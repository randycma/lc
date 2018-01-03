/*
 * lru_cache.cpp
 *
 *  Created on: Dec 10, 2017
 *      Author: Randy Ma
 */

#include <list>
#include <unordered_map>
#include <iostream>
#include <iterator>
#include <algorithm>

class LRUCache {
public:
    LRUCache(int capacity)
        : m_size(0)
        , m_capacity(capacity)
        , m_list()
        , m_map()
    {
    }

    int get(int key) {
        auto it = m_map.find(key);
        if(it != m_map.end()) // key found
        {
            m_list.erase(it->second.ptr);
            m_list.push_back(key);
            // it->second.ptr = m_list.rbegin(); // update pointer
            it->second.ptr = (std::next(m_list.rbegin())).base(); // get iterator to last element in list

            // std::copy(m_list.begin(), m_list.end(), std::ostream_iterator<int>(std::cout, "->")); std::cout << std::endl;
            return it->second.value;
        }

        return -1; // not found
    }

    void put(int key, int value) {
        remove(key);

        if(m_size >= m_capacity)
        {
            // remove least recently used (front)
            auto it = m_list.begin();
            // std::cout << "removing least recently used : " << *it << std::endl;
            remove(*it);
        }

        m_list.push_back(key);
        std::list<int>::iterator it = std::next(m_list.rbegin()).base(); // get iterator to last element in list
        m_map.insert(std::make_pair(key, MapValue(value,it)));
        ++m_size;

        // std::copy(m_list.begin(), m_list.end(), std::ostream_iterator<int>(std::cout, "->")); std::cout << std::endl;
    }

private:

    void remove(int key)
    {
        auto it = m_map.find(key);
        if(it != m_map.end()) // key found
        {
            // remove found element from list and from map
            m_list.erase(it->second.ptr);
            m_map.erase(it);
            --m_size;
        }
    }


    struct MapValue {
        MapValue(int v, std::list<int>::iterator p)
            : value(v), ptr(p)
        {}
        int value;
        std::list<int>::iterator ptr;
    };

    int m_size;
    int m_capacity;
    std::list<int> m_list; // front is oldest, back is newest
    std::unordered_map<int,MapValue> m_map;

};


int main()
{
	LRUCache cache(2);
	cache.put(1,1);
	cache.put(2,2);
	std::cout << cache.get(1) << std::endl;;
	cache.put(3,3);
	std::cout << cache.get(2) << std::endl;
	cache.put(4,4);
	std::cout << cache.get(1) << std::endl;
	std::cout << cache.get(3) << std::endl;
	std::cout << cache.get(4) << std::endl;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
