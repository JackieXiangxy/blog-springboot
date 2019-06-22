package com.jackie.bloghandle.ffmpeg.data;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 任务信息持久层实现
 *
 * @author jackie
 * @since jdk1.8
 * @version 1.0
 */
public class TaskDaoImpl implements TaskDao {
	// 存放任务信息
	private ConcurrentMap<String, CommandTasker> map = null;

	public TaskDaoImpl(int size) {
		map = new ConcurrentHashMap<>(size);
	}

	@Override
	public CommandTasker get(String id) {
		return map.get(id);
	}

	@Override
	public Collection<CommandTasker> getAll() {
		return map.values();
	}

	@Override
	public int add(CommandTasker CommandTasker) {
		String id = CommandTasker.getId();
		if (id != null && !map.containsKey(id)) {
			map.put(CommandTasker.getId(), CommandTasker);
			if(map.get(id)!=null)
			{
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int remove(String id) {
		if(map.remove(id) != null){
			return 1;
		};
		return 0;
	}

	@Override
	public int removeAll() {
		int size = map.size();
		try {
			map.clear();
		} catch (Exception e) {
			return 0;
		}
		return size;
	}

	@Override
	public boolean isHave(String id) {
		return map.containsKey(id);
	}

}
