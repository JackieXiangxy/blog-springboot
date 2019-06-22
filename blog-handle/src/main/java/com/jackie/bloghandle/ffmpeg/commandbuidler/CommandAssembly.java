package com.jackie.bloghandle.ffmpeg.commandbuidler;

import java.util.Map;
/**
 * 命令组装器接口
 * @author jackie
 * @since jdk1.8
 * @version 1.0
 */
public interface CommandAssembly {
	/**
	 * 将参数转为ffmpeg命令
	 * @param paramMap
	 * @return
	 */
	public String assembly(Map<String, String> paramMap);
	
	public String assembly();
}
