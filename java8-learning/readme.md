

# java8新特性学习

**```[author]```** 邱俊

1. 允许在接口中有默认方法实现
2. Lambda表达式
3. 函数式接口
4. 方法和构造函数引用
5. Lambda的范围
6. 内置函数式接口
7. Streams
8. Parallel Streams
9. Map
10. Annotations
11. 总结

# 概述

###### 通过简单明了的代码示例，你将会学习到如何使用默认接口方法，Lambda表达式，方法引用和重复注解。看完这篇教程后，你还将对最新推出的API有一定的了解，例如：流控制，函数式接口，map扩展等等。


# 新特性介绍

### 1. 搜索医院

**`GET``1.0.0~`** `/api/beinhospital/searchHospital?hospitalName=四川`

| 键            | 含义           | 类型     | 备注   |
| ------------ | ------------ | ------ | ---- |
| hospitalName | hospitalName | string | 医院名称 |

``返回数据`` 

```json
{
    "code": 0,
    "data": {
        "more": false,
        "content": [
            {
                "id": 1,
                "hospitalCode": "450751995",
                "hospitalName": "成都市第六人民医院",
                "hospitalAddress": "",
                "hospitalRule": null,
                "hospitalDesc": "",
                "hospitalPhone": "",
                "hospitalGrade": "",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": "510104000000",
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478589521000,
                "updateTime": 1478589521000
            },
            {
                "id": 2,
                "hospitalCode": "450755531",
                "hospitalName": "成都市第一人民医院",
                "hospitalAddress": "成都市高新南区繁雄大道万象北路18号",
                "hospitalRule": null,
                "hospitalDesc": "成都市中西医结合医院（又名成都市第一人民医院）是成都地区一所以中西医结合为特点的大型现代化综合医院，医院始建于1942年，1985年被上级命名为成都市中西医结合医院，1994年9月被评为爱婴医院，1995年4月被国家中医药管理局批准为“全国中药制剂和剂型改革基地”，1995年10月被评为中西医结合三级甲等医院，1999年被国家卫生部、国家中医药管理局共同授予“全国百佳医院”称号。",
                "hospitalPhone": "(028)85313628 028-85311726",
                "hospitalGrade": "三级甲等",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/589d85f6e72a4f978f4d7d7cc05df51b",
                "cityCode": "510104000000",
                "orderMode": null,
                "isOrderToday": "0",
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478589522000,
                "updateTime": 1478589522000
            },
            {
                "id": 3,
                "hospitalCode": "450754432",
                "hospitalName": "成都市第二人民医院",
                "hospitalAddress": "成都市锦江区庆云南街10号",
                "hospitalRule": null,
                "hospitalDesc": "成都市第二人民医院位于成都中心城区锦江区府河畔，拥有120余年历史，是集医疗、教学、科研、康复和预防保健为一体的三级甲等综合医院。\r\n 医院由本部和草市街分部组成。全院占地面积22613.58平方米，业务建筑面积约85000平方米。现有职工总数1516人，其中，临床医技人数1243人（含占职工总数比例81.99%）、正高36人、副高228人、博士11人、硕士143人，获国务院特殊津贴3人、市政府特殊津贴7人。\r\n 　　 医院编制床位700张，新建医疗综合大楼投入使用后床位可达到1500张。2011年门诊896659人次、住院28489人次、住院手术8773台次。对外协作的社区及医院共计35个。",
                "hospitalPhone": "028-65108801  028-65108888",
                "hospitalGrade": "三级甲等",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/8c7149ee10dc449c91bf7727317b1bc5",
                "cityCode": "510104000000",
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478589524000,
                "updateTime": 1478589524000
            },
            {
                "id": 4,
                "hospitalCode": "450754387",
                "hospitalName": "成都市第三人民医院",
                "hospitalAddress": "成都市青羊区青龙街82号",
                "hospitalRule": null,
                "hospitalDesc": "市三医院是一所建院70余年，集医疗、科学、教学、预防、保健和康复为一体的三级甲等综合性医院，市国家级“爱婴医院”，卫生部“国际紧急救援中心网络医院”，国家级执业医师实践技能考试基地，1993年被评为三级甲等医院。",
                "hospitalPhone": "028-61318569",
                "hospitalGrade": "3",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/7c617c5034214351ab554ac73a06fed6",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328188000
            },
            {
                "id": 5,
                "hospitalCode": "450753341",
                "hospitalName": "成都市第七人民医院",
                "hospitalAddress": "成都市十二中街1号  致民路51号",
                "hospitalRule": null,
                "hospitalDesc": "",
                "hospitalPhone": "028-85431030",
                "hospitalGrade": "三级医院",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/c6c941e1026e4f06bfb76d1a1a440b58",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328188000
            },
            {
                "id": 6,
                "hospitalCode": "580024374",
                "hospitalName": "成都市公共卫生临床医疗中心",
                "hospitalAddress": "成都市锦江区静明路377号",
                "hospitalRule": null,
                "hospitalDesc": "成都市公共卫生临床医疗中心（以下简称“中心”）是四川省首家三级甲等传染病专科医院，是全国结核界首家三级甲等医院，医院始建于1940年，承担法定传染病的诊疗工作，承担全省新突发传染病疫情应急医疗救治工作，承担全省各级医疗、疾控机构艾滋病治疗工作相关人员的培训，承担全市新突发传染病及重大传染病防治的培训工作。在肝病、结核病、艾滋病以及妊娠合并肝炎、艾滋病等专科有独特的学科优势，部份专科水平处国内先进水平，在四川地区享有较高知名度",
                "hospitalPhone": "028-84537477",
                "hospitalGrade": "三级甲等",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/4fca13b54ceb4cfb99a84479ba7de80f",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328189000
            },
            {
                "id": 7,
                "hospitalCode": "580027911",
                "hospitalName": "成都市妇女儿童中心医院",
                "hospitalAddress": "四川省成都市西三环外日月大道1617号",
                "hospitalRule": null,
                "hospitalDesc": "成都市妇女儿童中心医院是经成都市政府批准，在整合成都市第九人民医院、成都市妇产科医院、成都市妇幼保健院、成都市儿童医院医疗资源的基础上新建的一所集医疗、保健、科研、教学、培训为一体的、硬件设施居全国前列、医疗技术水平西部较高、专科设置西部最齐全的具有较强综合实力的三级甲等妇女儿童专科医疗与保健机构",
                "hospitalPhone": "",
                "hospitalGrade": "三级甲等",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/c709613ae35e40198a8bb670ad189a9a",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": "1",
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328190000
            },
            {
                "id": 8,
                "hospitalCode": "450751864",
                "hospitalName": "成都市第五人民医院",
                "hospitalAddress": "成都市温江区柳城镇麻市街33号",
                "hospitalRule": null,
                "hospitalDesc": "",
                "hospitalPhone": "028-82722252",
                "hospitalGrade": "",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/eb95c0dbd0a744479b516c4eb7f2ae1c",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328189000
            },
            {
                "id": 9,
                "hospitalCode": "12510100X2160118XM",
                "hospitalName": "成都市第十一人民医院",
                "hospitalAddress": "二环路北一段",
                "hospitalRule": null,
                "hospitalDesc": "二级甲等综合性医院",
                "hospitalPhone": "028-83382443",
                "hospitalGrade": "二级甲等",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/8c164675114f4699acaee1e2f6924fd3",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328189000
            },
            {
                "id": 10,
                "hospitalCode": "450751100",
                "hospitalName": "成都市第八人民医院",
                "hospitalAddress": "成都市金牛区蓉都大道1120号",
                "hospitalRule": null,
                "hospitalDesc": "二级乙等专科医院",
                "hospitalPhone": "028-83572191",
                "hospitalGrade": "二级乙等",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/5ecc21fa91f94c29864bc209c12b7fa8",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328190000
            },
            {
                "id": 11,
                "hospitalCode": "450752082",
                "hospitalName": "成都市第四人民医院",
                "hospitalAddress": "",
                "hospitalRule": null,
                "hospitalDesc": "",
                "hospitalPhone": "",
                "hospitalGrade": "",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328010000
            },
            {
                "id": 12,
                "hospitalCode": "450867859",
                "hospitalName": "蒲江县中医医院",
                "hospitalAddress": "飞虎路路159号",
                "hospitalRule": null,
                "hospitalDesc": "二级甲等专科性医院",
                "hospitalPhone": "028-84537477",
                "hospitalGrade": "II甲",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": "http://og3xulzx6.bkt.clouddn.com/44baf2f7dbb34aa69157ca7d918e9577",
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328190000
            },
            {
                "id": 13,
                "hospitalCode": "450867840",
                "hospitalName": "蒲江县妇幼保健院",
                "hospitalAddress": "飞虎路158号",
                "hospitalRule": null,
                "hospitalDesc": "二级甲等专科性医院",
                "hospitalPhone": "028-84537477",
                "hospitalGrade": "II甲",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328010000
            },
            {
                "id": 14,
                "hospitalCode": "450867867",
                "hospitalName": "蒲江县人民医院",
                "hospitalAddress": "XXX路XXX号",
                "hospitalRule": null,
                "hospitalDesc": "二级甲等综合性医院",
                "hospitalPhone": "028-84537477",
                "hospitalGrade": "II甲",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478328010000,
                "updateTime": 1478328010000
            },
            {
                "id": 15,
                "hospitalCode": "450752437",
                "hospitalName": "成都市传染病医院",
                "hospitalAddress": "成都市",
                "hospitalRule": null,
                "hospitalDesc": "临床公共卫生中心",
                "hospitalPhone": "",
                "hospitalGrade": "03",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            },
            {
                "id": 16,
                "hospitalCode": "124124-2",
                "hospitalName": "雅安市雨城区测试镇中心卫生院",
                "hospitalAddress": "测试小区",
                "hospitalRule": null,
                "hospitalDesc": "雅安市雨城区测试镇中心卫生院",
                "hospitalPhone": "02883356605",
                "hospitalGrade": "05",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            },
            {
                "id": 18,
                "hospitalCode": "0001",
                "hospitalName": "互慧测试的医院名称",
                "hospitalAddress": "绵阳",
                "hospitalRule": null,
                "hospitalDesc": "描述",
                "hospitalPhone": "130123456789",
                "hospitalGrade": "DegreeCode",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            },
            {
                "id": 19,
                "hospitalCode": "450717818",
                "hospitalName": "成都大学附属医院",
                "hospitalAddress": "",
                "hospitalRule": null,
                "hospitalDesc": "",
                "hospitalPhone": "",
                "hospitalGrade": "",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            },
            {
                "id": 20,
                "hospitalCode": "ZXYY",
                "hospitalName": "大连市中心医院",
                "hospitalAddress": "大连市中山区中山广场2号",
                "hospitalRule": null,
                "hospitalDesc": "这个医院非常好",
                "hospitalPhone": "041199988888",
                "hospitalGrade": "3",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            },
            {
                "id": 21,
                "hospitalCode": "0001_0001",
                "hospitalName": "New_互慧测试的医院名称",
                "hospitalAddress": "绵阳",
                "hospitalRule": null,
                "hospitalDesc": "描述",
                "hospitalPhone": "130123456789",
                "hospitalGrade": "DegreeCode",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            },
            {
                "id": 22,
                "hospitalCode": "450868851",
                "hospitalName": "蒲江县寿安公立中心卫生院",
                "hospitalAddress": "成都市蒲江县寿安镇利民路南段5号",
                "hospitalRule": null,
                "hospitalDesc": "蒲江县寿安公立中心卫生院",
                "hospitalPhone": "028-88670120",
                "hospitalGrade": "05",
                "hospitalLatitude": null,
                "hosptialLongitude": null,
                "hosptialPhoto": null,
                "cityCode": null,
                "orderMode": null,
                "isOrderToday": null,
                "status": "1",
                "receiveCount": 0,
                "delFlag": "0",
                "createTime": 1478506204000,
                "updateTime": 1478506204000
            }
        ]
    }
}
```

| code   | 含义   |
| ------ | ---- |
| `1000` | 内部错误 |

### 2. 获取用户住院记录

**`GET``1.0.0~`** `/api/beinhospital/records`

| 键            | 含义   | 类型     | 备注                 |
| ------------ | ---- | ------ | ------------------ |
| idCard       | 身份证号 | string | 410527199302029897 |
| hospitalCode | 医院编码 | string | 450751995          |
| flag         | 当前位置 | string | 0                  |

```json
{
    "code": 0,
    "data": {
        "more": false,
        "content": [
            {
                "id": "2c908a0f5843707c01584370ad370000",
                "idCard": "410527199302029897",
                "hospitalCode": "450751995",
                "beInHospitalCode": "0672201606155768",//住院号
                "inHospitalDate": "2016-06-15 10:23:37",
                "outHospitalDate": "2016-07-13 8:50:00",
                "bedNum": "0032",
                "departmentCode": "0001",
                "departmentName": "神经内科",
                "doctorCode": "0622",
                "doctorName": "祝常金",
                "nurseCode": "-",
                "nurseName": "-",
                "prepaidPaymentAmt": 15000,
                "updateTime": 1478600202000,
                "delFlag": "0",
                "outHospitalFlag": "0"
            }
        ],
        "more_params": {
            "order": "",
            "flag": "1"
        }
    }
}
```

| code   | 含义   |
| ------ | ---- |
| `1000` | 内部错误 |

### 3. 获取单条住院记录的缴费记录

#### 接口地址

**`GET` `1.0.0~`** `~/api/beinhospital/payRecords`

#### 请求参数

| 键                | 含义   | 类型     | 是否必须 | 说明                 |
| ---------------- | ---- | ------ | ---- | ------------------ |
| hospitalCode     | 医院编码 | String | 是    | 450751995          |
| idCard           | 身份证号 | String | 是    | 410527199302029897 |
| beInHospitalCode | 住院号  | String | 是    | 0672201606155768   |

#### 返回结果

```json
{
    "code": 0,
    "data": {
        "more": false,
        "content": [
            {
                "hospitalCode": "450751995",
                "paymentDate": "2016-06-15 10:24:32",
                "paymentAmt": 5000,
                "paymentMethod": "院内支付"// 01 微信 02 支付宝 返回其他值的话就直接显示 比如显示院内支付
            },
            {
                "hospitalCode": "450751995",
                "paymentDate": "2016-06-21 15:51:16",
                "paymentAmt": 10000,
                "paymentMethod": "院内支付"
            }
        ]
    }
}
```

### 4. 诊间支付获取待缴费记录

#### 接口地址

**`GET` `1.0.0~`** `~/api/interDiaPayment/unPayRecord`

#### 请求参数

| 键            | 含义   | 类型     | 是否必须 | 说明    |
| ------------ | ---- | ------ | ---- | ----- |
| hospitalCode | 医院编码 | String | 是    | 51000 |
| uid          | 用户id | String | 是    | 用户id  |

#### 返回结果

```json
{
    "code": 0,
    "data": {
        "more": false,
        "content": [
            {
                "orderType": "CLINIC",
                "price": 26,
                "business": {
                    "prescriptionNum": "w15133691",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:53"
            },
            {
                "orderType": "CLINIC",
                "price": 69,
                "business": {
                    "prescriptionNum": "w15134108",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 310,
                "business": {
                    "prescriptionNum": "w15133689",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 57,
                "business": {
                    "prescriptionNum": "w15134109",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 68.09,
                "business": {
                    "prescriptionNum": "w15133685",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 60.9,
                "business": {
                    "prescriptionNum": "w15133686",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 7,
                "business": {
                    "prescriptionNum": "w15133687",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 20,
                "business": {
                    "prescriptionNum": "w15133688",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 20,
                "business": {
                    "prescriptionNum": "w15133690",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 116,
                "business": {
                    "prescriptionNum": "w15133692",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 7.14,
                "business": {
                    "prescriptionNum": "w15133693",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 18,
                "business": {
                    "prescriptionNum": "w15133694",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 4.4,
                "business": {
                    "prescriptionNum": "w15133695",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 72.45,
                "business": {
                    "prescriptionNum": "w15133696",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 14.18,
                "business": {
                    "prescriptionNum": "w15133697",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            },
            {
                "orderType": "CLINIC",
                "price": 3,
                "business": {
                    "prescriptionNum": "w15132242",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-24 10:22:22",
                    "deptName": "产 科(住院)",
                    "hospitalCode": "51000",
                    "jzlsh": "null"
                },
                "payStatus": "NOTPAY",
                "orderTime": "2016-11-24 10:49:58"
            }
        ]
    }
}
```

### 5. 我的订单

#### 接口地址

**`GET` `1.0.0~`** `~/api/interDiaPayment/orders`

#### 请求参数

| 键      | 含义   | 类型     | 是否必须 | 说明                                       |
| ------ | ---- | ------ | ---- | ---------------------------------------- |
| status | 支付状态 | String | 是    | NOTPAY, EXPIRED,SUCCESS,REFUND,REFUNDSUCCESS,ALL |
| uid    | 用户id | String | 是    | 用户id                                     |
| flag   | 当前位置 | String | 否    |                                          |

```说明：```

```
返回的对象当中有一个business字段因为在列表当中包含诊间支付和预约挂号支付的订单, 显示的内容也不一致, 所以把不一样的显示内容都放在body中, 诊间支付的body格式如下:

  				{
                    "prescriptionNum": "w6672000", //处方号
                    "hospitalName": "绵阳市第一人民医院",//医院名称
                    "time": "2016-11-04 11:22:11",//开方时间
                    "deptName":"妇科",
                    "hospitalCode": "51000"
                    //"receiptNo":"xx12311414414"//这个收据编号只有支付成功之后才有
                }
   
预约挂号body格式如下:

  				{
                    "doctorName": "王医生", //医生名字
                    "hospitalName": "绵阳市第一人民医院",//医院名称
                    "deptName": "内科"//科室
                    "outDoctorLevel":"专家门诊"//出诊级别
                    "patientName":"王强",
                    "appointPeriod":"2016-11-04 周一 上午"//预约时间段
                }
```

#### 返回结果

```json
{
    "code": 0,
    "data": {
        "more": true,
        "content": [
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609088532",
                "price": 20,
                "business": {
                    "prescriptionNum": "w15133688",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000",
                    "receiptNo": "110687786"
                },
                "payStatus": "SUCCESS",
                "pay_order": {
                    "id": "0743c4be422e470db1df144a2a6b14d4",
                    "amount": 2000,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "SUCCESS"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609151885",
                "price": 3,
                "business": {
                    "prescriptionNum": "w15132242",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "产 科(住院)",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "b6d7f3fa1b244e358ae4f9c76617f07c",
                    "amount": 300,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609144994",
                "price": 14.18,
                "business": {
                    "prescriptionNum": "w15133697",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "9e6dc6df409b4768bc95ae8899c13449",
                    "amount": 1418,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609134086",
                "price": 72.45,
                "business": {
                    "prescriptionNum": "w15133696",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "bb3b34eb78d04835b5ad2628b2048554",
                    "amount": 7245,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609128646",
                "price": 4.4,
                "business": {
                    "prescriptionNum": "w15133695",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "edba5f8e9b264f8bb5818403a90f2bfe",
                    "amount": 440,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609123434",
                "price": 18,
                "business": {
                    "prescriptionNum": "w15133694",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "2126d84e460e4db9b7c16564451a235f",
                    "amount": 1800,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609118002",
                "price": 7.14,
                "business": {
                    "prescriptionNum": "w15133693",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "f8974670e28e407e9affa2e3bfcfafa3",
                    "amount": 714,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609097701",
                "price": 20,
                "business": {
                    "prescriptionNum": "w15133690",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "0d174ec850a54209a7a780f1fd8b4345",
                    "amount": 2000,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609108471",
                "price": 116,
                "business": {
                    "prescriptionNum": "w15133692",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "a4ff42c9a0e249c88c3d08ed09fba84a",
                    "amount": 11600,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "CLINIC",
                "orderId": "yy201611141609073973",
                "price": 7,
                "business": {
                    "prescriptionNum": "w15133687",
                    "hospitalName": "安县第二人民医院",
                    "time": "2016-11-14 13:46:42",
                    "deptName": "门诊妇产科",
                    "hospitalCode": "51000"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "4e382e0a2b62442d8e953ca21d362a78",
                    "amount": 700,
                    "subject": "诊间支付",
                    "body": "",
                    "description": "",
                    "status": "NOTPAY"
                }
            }
        ],
        "more_params": {
            "order": "",
            "flag": "10"
        }
    }
}
```

### 6. 在线支付挂号费支付

#### 接口地址

**`GET` `1.0.0~`** `~/api/interDiaPayment/appoint`

#### 请求参数

| 键    | 含义   | 类型     | 是否必须 | 说明   |
| ---- | ---- | ------ | ---- | ---- |
| flag | 当前位置 | String | 否    |      |
| uid  | 用户id | String | 是    | 用户id |

#### 返回结果

```json
{
    "code": 0,
    "data": {
        "more": true,
        "content": [
            {
                "orderType": "APPOINTMENT",
                "orderId": "32",
                "price": 7,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "444dd6990db04ae59556b7b03507d83c",
                    "amount": 700,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "31",
                "price": 5,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "b9d39fb708c24be1aa9443178eea4735",
                    "amount": 500,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "30",
                "price": 5,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "4d851c6cb0d6452fb4f8eab9498637ba",
                    "amount": 500,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "28",
                "price": 5,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "e1a56273df63451b940ce85b89eb021d",
                    "amount": 500,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "26",
                "price": 5,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "255ed87e90a64f2189526a924bb8112c",
                    "amount": 500,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "25",
                "price": 7,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "610e09ffaab648408395ec53bc60e4bd",
                    "amount": 700,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "24",
                "price": 5,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "9531838a02ff4942b244776bfa3b6287",
                    "amount": 500,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "23",
                "price": 14,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "5daefad778dd413aaaac20a5077717a3",
                    "amount": 1400,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "22",
                "price": 5,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "71ad01cf3f4545ceac8f2eba361c98e0",
                    "amount": 500,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            },
            {
                "orderType": "APPOINTMENT",
                "orderId": "21",
                "price": 3,
                "business": {
                    "doctorName": "王医生",
                    "hospitalName": "绵阳市第一人民医院",
                    "deptName": "内科",
                    "outDoctorLevel": "专家门诊",
                    "patientName": "王强",
                    "appointPeriod": "2016-11-04 周一 上午"
                },
                "payStatus": "NOTPAY",
                "pay_order": {
                    "id": "6128b4226c514bddbba355a3ee3a450c",
                    "amount": 300,
                    "subject": "微健康预约挂号订单-名称",
                    "body": "微健康预约挂号订单-详情",
                    "description": "微健康预约挂号订单-描述",
                    "status": "NOTPAY"
                }
            }
        ],
        "more_params": {
            "order": "",
            "flag": "10"
        }
    }
}
```

### 7. 生成诊间支付订单

#### 接口地址

**`POST` `1.0.0~`** `~/api/interDiaPayment/generateOrder`

#### 请求参数

```json
{
    "prescriptionNum": "w15133691",
    "hospitalName": "安县第二人民医院",
    "time": "2016-11-24 10:22:22",
    "deptName": "门诊妇产科",
    "hospitalCode": "51000",
    "jzlsh": "-",
    "price": "26",
    "uid": "050f96947aa2429a91c306cb8b10840b"
}
```

#### 返回结果

```json
{
  "code": 0,
  "data": {
    "orderType": "CLINIC",
    "orderId": "yp201611241735125350",
    "price": 26,
    "business": {
      "prescriptionNum": "w15133691",
      "hospitalName": "安县第二人民医院",
      "time": "2016-11-24 10:22:22",
      "deptName": "门诊妇产科",
      "hospitalCode": "51000",
      "jzlsh": "-"
    },
    "payStatus": "NOTPAY",
    "pay_order": {
      "id": "80468d411d264b44ae396afb46b9a587",
      "amount": 2600,
      "subject": "诊间支付",
      "description": "诊间支付",
      "status": "NOTPAY",
      "time_left": 21643
    },
    "orderTime": "2016-11-24 17:35:12"
  }
}
```

