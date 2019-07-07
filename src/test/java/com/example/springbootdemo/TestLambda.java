package com.example.springbootdemo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author frankwin608
 * @date 2018-09-20 8:03
 * @desc 测试lambda表达式
 **/
public class TestLambda {
    private static final String CN_DRUG_TYPE = "5";
    private static final String WEST_DRUG_TYPE = "4";
    private static final String SINGLE_COMPOUND_FLAG = "singleCompoundFlag";
    private static final String NOT_CN_DRUG = "0";
    private static final String SINGLE_FLAG = "1";
    private static final String COMPOUND_FLAG = "2";
    private static final String PRESCRIPTION_ID = "prescriptionId";
    private static final String ITEM_ID = "itemId";
    private static final String ITEM_TYPE = "itemType";
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void init() {

    }

    @Test
    public void test1() {
        Map<String, Object> hashMap = getMap(CN_DRUG_TYPE, "test1", "123");
        Map<String, Object> hashMap2 = getMap(CN_DRUG_TYPE, "test1", "1234");
        Map<String, Object> hashMap3 = getMap(WEST_DRUG_TYPE, "test1", "1235");
        Map<String, Object> hashMap4 = getMap(WEST_DRUG_TYPE, "test1", "1236");

        List<Map<String, Object>> mapList = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4);
        buildSingleCompoundFlagWithLambda(mapList);
        assertEquals(COMPOUND_FLAG, mapList.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(3).get(SINGLE_COMPOUND_FLAG).toString());

        List<Map<String, Object>> mapList2 = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4);
        buildSingleCompoundFlagWithLambda(mapList2);
        assertEquals(COMPOUND_FLAG, mapList2.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList2.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(3).get(SINGLE_COMPOUND_FLAG).toString());
    }

    @Test
    public void testCollect2() {
        Map<String, Object> hashMap = getMap(CN_DRUG_TYPE, "test1", "123");
        Map<String, Object> hashMap2 = getMap(CN_DRUG_TYPE, "test1", "1234");
        Map<String, Object> hashMap3 = getMap(CN_DRUG_TYPE, null, "1235");
        Map<String, Object> hashMap4 = getMap(CN_DRUG_TYPE, null, "1236");
        Map<String, Object> hashMap5 = getMap(WEST_DRUG_TYPE, null, "1237");

        List<Map<String, Object>> mapList = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5);
        buildSingleCompoundFlagWithLambda(mapList);
        assertEquals(COMPOUND_FLAG, mapList.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(4).get(SINGLE_COMPOUND_FLAG).toString());

        List<Map<String, Object>> mapList2 = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5);
        buildSingleCompoundFlagWithLambda(mapList2);
        assertEquals(COMPOUND_FLAG, mapList2.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList2.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList2.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList2.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(4).get(SINGLE_COMPOUND_FLAG).toString());
    }

    @Test
    public void testCollect3() {
        Map<String, Object> hashMap = getMap(CN_DRUG_TYPE, "test1", "123");
        Map<String, Object> hashMap2 = getMap(CN_DRUG_TYPE, "test2", "1234");
        Map<String, Object> hashMap3 = getMap(CN_DRUG_TYPE, null, "1235");
        Map<String, Object> hashMap4 = getMap(CN_DRUG_TYPE, null, "1235");
        Map<String, Object> hashMap5 = getMap(WEST_DRUG_TYPE, null, "1237");
        Map<String, Object> hashMap6 = getMap(WEST_DRUG_TYPE, null, "1237");

        List<Map<String, Object>> mapList = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6);
        buildSingleCompoundFlagWithLambda(mapList);
        assertEquals(SINGLE_FLAG, mapList.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(4).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(5).get(SINGLE_COMPOUND_FLAG).toString());

        List<Map<String, Object>> mapList2 = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6);
        buildSingleCompoundFlagWithLambda(mapList2);
        assertEquals(SINGLE_FLAG, mapList2.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(4).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(5).get(SINGLE_COMPOUND_FLAG).toString());
    }
    @Test
    public void testCollect4() {
        Map<String, Object> hashMap = getMap(CN_DRUG_TYPE, "test1", "1234");
        Map<String, Object> hashMap2 = getMap(CN_DRUG_TYPE, "test1", "1234");
        Map<String, Object> hashMap3 = getMap(CN_DRUG_TYPE, null, "1234");
        Map<String, Object> hashMap4 = getMap(CN_DRUG_TYPE, null, "1234");
        Map<String, Object> hashMap5 = getMap(WEST_DRUG_TYPE, null, "1237");
        Map<String, Object> hashMap6 = getMap(WEST_DRUG_TYPE, null, "1237");

        List<Map<String, Object>> mapList = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6);
        buildSingleCompoundFlagWithLambda(mapList);
        assertEquals(SINGLE_FLAG, mapList.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(4).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(5).get(SINGLE_COMPOUND_FLAG).toString());

        List<Map<String, Object>> mapList2 = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6);
        buildSingleCompoundFlagWithLambda(mapList2);
        assertEquals(SINGLE_FLAG, mapList2.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(4).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(5).get(SINGLE_COMPOUND_FLAG).toString());
    }
    @Test
    public void testCollect5() {
        Map<String, Object> hashMap = getMap(CN_DRUG_TYPE, "test1", "1234");
        Map<String, Object> hashMap2 = getMap(CN_DRUG_TYPE, "test1", "1234");
        Map<String, Object> hashMap7 = getMap(CN_DRUG_TYPE, "test1", "12345");
        Map<String, Object> hashMap3 = getMap(CN_DRUG_TYPE, null, "1234");
        Map<String, Object> hashMap4 = getMap(CN_DRUG_TYPE, null, "1234");
        Map<String, Object> hashMap5 = getMap(WEST_DRUG_TYPE, null, "1237");
        Map<String, Object> hashMap6 = getMap(WEST_DRUG_TYPE, null, "1237");

        List<Map<String, Object>> mapList = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6, hashMap7);
        buildSingleCompoundFlagWithLambda(mapList);
        assertEquals(COMPOUND_FLAG, mapList.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(4).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList.get(5).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList.get(6).get(SINGLE_COMPOUND_FLAG).toString());

        List<Map<String, Object>> mapList2 = Arrays.asList(hashMap, hashMap2, hashMap3, hashMap4, hashMap5, hashMap6, hashMap7);
        buildSingleCompoundFlagWithLambda(mapList2);
        assertEquals(COMPOUND_FLAG, mapList2.get(0).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList2.get(1).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(2).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(SINGLE_FLAG, mapList2.get(3).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(4).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(NOT_CN_DRUG, mapList2.get(5).get(SINGLE_COMPOUND_FLAG).toString());
        assertEquals(COMPOUND_FLAG, mapList2.get(6).get(SINGLE_COMPOUND_FLAG).toString());
    }
    private void buildSingleCompoundFlagWithLambda(List<Map<String, Object>> mappingList) {
        if (!CollectionUtils.isEmpty(mappingList)) {
            Map<String, Set<String>> mapSet = mappingList.stream()
                    .filter(x -> {
                        boolean cnDrugFlag = CN_DRUG_TYPE.equals(String.valueOf(x.get(ITEM_TYPE)));
                        if (!cnDrugFlag) {
                            x.put(SINGLE_COMPOUND_FLAG, NOT_CN_DRUG);
                        }
                        return cnDrugFlag;
                    })
                    .collect(Collectors.groupingBy(
                            y -> y.get(PRESCRIPTION_ID) == null ? "" : (String) y.get(PRESCRIPTION_ID)
                            , Collectors.mapping(
                                    k -> k.get(ITEM_ID) == null ? "" : (String) k.get(ITEM_ID)
                                    , Collectors.toSet()
                            )
                    ));

            mappingList.stream().forEach(item -> {
                String pid1 = item.get(PRESCRIPTION_ID) == null ? "" : (String) item.get(PRESCRIPTION_ID);
                Set<Map.Entry<String, Set<String>>> entries = mapSet.entrySet();
                Iterator<Map.Entry<String, Set<String>>> iterator = entries.iterator();
                Map.Entry<String, Set<String>> entry;
                while (iterator.hasNext()) {
                    entry = iterator.next();
                    String pid2 = entry.getKey() == null ? "" : entry.getKey();
                    Set<String> itemIdSets = entry.getValue();
                    if (pid1.equals(pid2)) {
                        if (!CollectionUtils.isEmpty(itemIdSets)) {
                            String singleCompoundFlag = (String) item.get(SINGLE_COMPOUND_FLAG);
                            if (singleCompoundFlag == null) {
                                if (itemIdSets.size() > 1) {
                                    item.put(SINGLE_COMPOUND_FLAG, COMPOUND_FLAG);
                                } else {
                                    item.put(SINGLE_COMPOUND_FLAG, SINGLE_FLAG);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    private void buildSingleCompoundFlagWithTraditional(List<Map> mappingList) {
        Map<String, Set<String>> cnDrugSetMap = new HashMap<>();
        for (int i = 0; i < mappingList.size(); i++) {
            Map map = mappingList.get(i);
            boolean cnDrugFlag = CN_DRUG_TYPE.equals(String.valueOf(map.get(ITEM_TYPE)));
            if (!cnDrugFlag) {
                map.put(SINGLE_COMPOUND_FLAG, NOT_CN_DRUG);
            } else {
                String pid1 = map.get(PRESCRIPTION_ID) == null ? "" : (String) map.get(PRESCRIPTION_ID);
                String itemId1 = map.get(ITEM_ID) == null ? "" : (String) map.get(ITEM_ID);
                Set<String> stringSet = cnDrugSetMap.get(pid1);
                if (CollectionUtils.isEmpty(stringSet)) {
                    HashSet<String> hashSet = new HashSet<>();
                    hashSet.add(itemId1);
                    cnDrugSetMap.put(pid1, hashSet);
                } else {
                    stringSet.add(itemId1);
                }
            }
        }
        Set<Map.Entry<String, Set<String>>> entries = cnDrugSetMap.entrySet();
        Iterator<Map.Entry<String, Set<String>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Set<String>> entry = iterator.next();
            String prescriptionId = entry.getKey() == null ? "" : entry.getKey();
            Set<String> sets = entry.getValue();
            for (int i = 0; i < mappingList.size(); i++) {
                Map map = mappingList.get(i);
                String pid1 = map.get(PRESCRIPTION_ID) == null ? "" : (String) map.get(PRESCRIPTION_ID);
                String itemId1 = map.get(ITEM_ID) == null ? "" : (String) map.get(ITEM_ID);
                if (prescriptionId.equals(pid1)) {
                    String singleCompoundFlag = (String) map.get(SINGLE_COMPOUND_FLAG);
                    if (singleCompoundFlag == null) {
                        if (sets.size() > 1) {
                            map.put(SINGLE_COMPOUND_FLAG, COMPOUND_FLAG);
                        } else {
                            map.put(SINGLE_COMPOUND_FLAG, SINGLE_FLAG);
                        }
                    }
                }
            }
        }
    }

    private Map getMap(String itemType, String prescriptionId, String itemId) {
        Map<String, Object> map = new HashMap();
        map.put(ITEM_TYPE, itemType);
        map.put(PRESCRIPTION_ID, prescriptionId);
        map.put(ITEM_ID, itemId);
        return map;
    }
}
