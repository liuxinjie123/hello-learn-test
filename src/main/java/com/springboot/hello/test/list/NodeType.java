package com.springboot.hello.test.list;

import java.util.HashMap;
import java.util.Map;

public enum NodeType {
        CONTRACT("合同/进场确认函"),
        FULL_CYCLE("全周期预算"),
        SEAL("盖章"),
        BACK("法务上传回缴"),
        KEEP("归档"),
        UPLOAD("双方盖章件上传"),
        SEAL_APPROVE("双方盖章件审核"),
        BROKERAGE_APPROVE("佣金标准审核"),
        DISABLE("禁用"),
        NO_FILE("无归档"),
        IN_ACCESS("调档中"),
        BACK2("回缴");
        private final String nodeTypeName;

        NodeType(String nodeTypeName) {
        this.nodeTypeName = nodeTypeName;
    }

        public String getNodeTypeName() {
        return nodeTypeName;
    }

        private static final Map<String, NodeType> MAP;

        static {
        MAP = new HashMap<>();
        for (NodeType nodeType : NodeType.values()) {
            MAP.put(nodeType.name(), nodeType);
        }
    }


        /**
         * 根据节点code获取节点名称
         * @param code
         * @return
         */
        public static String getNameByCode(String code) {
        NodeType result;
        return (result = MAP.get(code)) == null ? "" : result.getNodeTypeName();
    }
}
