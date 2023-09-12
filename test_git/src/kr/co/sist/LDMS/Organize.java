package kr.co.sist.LDMS;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class Organize {
	private Map<String, Integer> browserCnt;
	private Map<String, Integer> typeCnt;
	private Map<String, Integer> timeCnt;
	private Map<String, Integer> keyCnt;
	private LDMS ldms;   

	public Organize(LDMS ldms, int startIndex, int maxIndex) {
		this.ldms = ldms;
		setCntMap(startIndex, maxIndex);
	}// constructor
	
	public Organize(LDMS ldms, int endIndex) {
		this.ldms = ldms;  
		setCntMap(1, endIndex);
	}// constructor

	public Organize(LDMS ldms) {
		this.ldms = ldms;
		setCntMap(1, ldms.getLogVOMap().size());
	}// constructor

	public void setCntMap(int startIndex, int endIndex) {
		browserCnt = new HashMap<String, Integer>();
		timeCnt = new HashMap<String, Integer>();
		typeCnt = new HashMap<String, Integer>();
		keyCnt = new HashMap<String, Integer>();
		LogVO logVO = null;
		String temp = null;

		for (int i = startIndex; i < endIndex + 1; i++) {
			logVO = ldms.getLogVOMap().get(i);
			temp = logVO.getKey();
			if (keyCnt.containsKey(temp)) {
				// keyCnt 설정
				keyCnt.put(temp, keyCnt.get(temp) + 1);
			} else {
				// keyCnt 설정
				keyCnt.put(temp, 1);
			} // else
			temp = logVO.getBrowser();
			if (browserCnt.containsKey(temp)) {
				// browserCnt 설정
				browserCnt.put(temp, browserCnt.get(temp) + 1);
			} else {
				// browserCnt 설정
				browserCnt.put(temp, 1);
			} // else
			temp = logVO.getType();
			if (typeCnt.containsKey(temp)) {
				// typeCnt 설정
				typeCnt.put(temp, typeCnt.get(temp) + 1);
			} else {
				// typeCnt 설정
				typeCnt.put(temp, 1);
			} // else
			temp = logVO.getTime().substring(11, 13);
			if (timeCnt.containsKey(temp)) {
				// timeCnt 설정
				timeCnt.put(temp, timeCnt.get(temp) + 1);
			} else {
				// timeCnt 설정
				timeCnt.put(temp, 1);
			} // else
		} // for
	}// viewInfo

	// 가장 많이 사용된 키 리턴
	public String topKey() {
		String topKey = "";
		String currentKey = null;
		if (keyCnt != null) {
			int tempCnt = 0;
			Iterator<String> keyIter = keyCnt.keySet().iterator();
			while (keyIter.hasNext()) {
				currentKey = keyIter.next();
				if (keyCnt.get(currentKey) > tempCnt) {
					tempCnt = keyCnt.get(currentKey);
					topKey = currentKey;
				} // if
			} // while
		} // if
		return topKey;
	}// tioKey

	// 브라우저별 방문 횟수
	public double browserRatio(String browser) {
		Iterator<Integer> browserIter = browserCnt.values().iterator();
		int sum = 0;
		while (browserIter.hasNext()) {
			sum += browserIter.next();
		} // while
		return (double) browserCnt.get(browser) / sum * 100;
	}// browserRatio

	// 타입별 수행 횟수
	public double typeRatio(String type) {
		Iterator<Integer> typeIter = typeCnt.values().iterator();
		int sum = 0;
		while (typeIter.hasNext()) {
			sum += typeIter.next();
		} // while
		return (double) typeCnt.get(type) / sum * 100;
	}// typeRatio

	// 최고 방문 시간
	public String topTime() {
		String topTime = "";
		String currentTime = null;
		if (!timeCnt.isEmpty()) {
			int tempCnt = 0;
			Iterator<String> timeIter = timeCnt.keySet().iterator();
			while (timeIter.hasNext()) {
				currentTime = timeIter.next();
				if (timeCnt.get(currentTime) > tempCnt) {
					tempCnt = timeCnt.get(currentTime);
					topTime = currentTime;
				} // if
			} // while
		} // if
		return topTime;
	}// topTime

	// getter / setter
	public Map<String, Integer> getBrowserCnt() {
		return browserCnt;
	}// getBrowserCnt
	public Map<String, Integer> getTypeCnt() {
		return typeCnt;
	}// getTypeCnt
	public Map<String, Integer> getTimeCnt() {
		return timeCnt;
	}// getTimeCnt
	public Map<String, Integer> getKeyCnt() {
		return keyCnt;
	}// getKeyCnt
}// class
