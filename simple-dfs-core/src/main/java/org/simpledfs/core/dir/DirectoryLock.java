package org.simpledfs.core.dir;

import org.simpledfs.core.exception.NonDirectoryException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DirectoryLock {

    private Map<String, Lock> lockMap;

    private DirectoryLock(){
        lockMap = new ConcurrentHashMap<>();
    }

    public static DirectoryLock getInstance(){
        return DirectoryLockHolder.directoryLock;
    }

    public void lock(String directory){
        Lock lock = lockMap.get(directory);
        if (lock == null){
            throw new NonDirectoryException();
        }
        lock.lock();
    }

    public void unlock(String directory){
        Lock lock = lockMap.get(directory);
        if (lock == null){
            throw new NonDirectoryException();
        }
        lock.unlock();
    }

    public void addLock(String directory){
        if (lockMap.containsKey(directory)){
            throw new NonDirectoryException();
        }
        lockMap.put(directory, new ReentrantLock());
    }

    public void removeLock(String directory){
        if (lockMap.containsKey(directory)){
            throw new NonDirectoryException();
        }
        lockMap.remove(directory);
    }

    private static class DirectoryLockHolder {
        private static DirectoryLock directoryLock = new DirectoryLock();
    }
}
