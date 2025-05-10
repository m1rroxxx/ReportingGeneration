# ReportingGeneration

---
# Сборка и запуск проекта

## Требования
- JDK 17+
- Maven 3.6+

## 🛠 Сборка проекта

### Используя Maven
```bash
  mvn clean install
```

### в папке reportingGeneration/target появится .jar файл

запустить

```bash
  java -jar target/your-project-name.jar 
```

---
### три скрипта curl
```bash
    curl -X POST http://localhost:8080/api/reports \
      -H "Content-Type: application/json" \
      -d '{
        "reportName": "xls_report",
        "payloadData": {"year": 2023, "region": "Europe"},
        "outputFormat": "xls"
      }' \
      --output report.xls
```

```bash
    curl -X POST http://localhost:8080/api/reports \
      -H "Content-Type: application/json" \
      -d '{
        "reportName": "txt_report",
        "payloadData": {"year": 2025, "region": "Europe"},
        "outputFormat": "txt"
      }' \
      --output report.txt
```

```bash
    curl -X POST http://localhost:8080/api/reports \
      -H "Content-Type: application/json" \
      -d '{
        "reportName": "csv_report",
        "payloadData": {"year": 2023, "region": "rus"},
        "outputFormat": "csv"
      }' \
      --output report.csv
```

---

### для тестирования через postman выбрать post запрос, ввести http:://localhost:8080/api/v1/reports и в тело запросп вставить любой ниже json
```text
справа от кнопки "send" есть стрелочка и появится "send and download"
так будет скачен файл
```
```json
{
    "reportName": "report",
    "payloadData": {
        "id": 1,
        "name": "Large Report",
        "count": 100,
        "active": true,
        "timestamp": "2023-11-15T12:00:00Z",
        "values": [10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
        "metadata": {
            "author": "John Doe",
            "version": "1.0.0",
            "tags": ["report", "data", "analytics"]
        },
        "details": {
            "field1": 123,
            "field2": "value",
            "field3": false,
            "field4": [1, 2, 3],
            "field5": {
                "nested1": "nested value",
                "nested2": 456
            }
        },
        "item1": 1,
        "item2": 2,
        "item3": 3,
        "item4": 4,
        "item5": 5,
        "item6": 6,
        "item7": 7,
        "item8": 8,
        "item9": 9,
        "item10": 10,
        "text1": "text 1",
        "text2": "text 2",
        "text3": "text 3",
        "text4": "text 4",
        "text5": "text 5",
        "text6": "text 6",
        "text7": "text 7",
        "text8": "text 8",
        "text9": "text 9",
        "text10": "text 10",
        "flag1": true,
        "flag2": false,
        "flag3": true,
        "flag4": false,
        "flag5": true,
        "nestedObject1": {
            "prop1": "value1",
            "prop2": 100,
            "prop3": [1, "a", true]
        },
        "nestedObject2": {
            "prop1": "value2",
            "prop2": 200,
            "prop3": [2, "b", false]
        },
        "nestedObject3": {
            "prop1": "value3",
            "prop2": 300,
            "prop3": [3, "c", true]
        },
        "array1": ["a", "b", "c"],
        "array2": [1, 2, 3, 4, 5],
        "array3": [true, false, true],
        "mixedArray": [1, "a", true, null],
        "settings": {
            "setting1": "enabled",
            "setting2": "disabled",
            "setting3": 42,
            "advanced": {
                "opt1": true,
                "opt2": "high",
                "opt3": 3.14
            }
        },
        "additional1": "extra data 1",
        "additional2": "extra data 2",
        "additional3": "extra data 3",
        "additional4": "extra data 4",
        "additional5": "extra data 5",
        "numericValues": {
            "val1": 0,
            "val2": 1,
            "val3": 2,
            "val4": 3,
            "val5": 4,
            "val6": 5,
            "val7": 6,
            "val8": 7,
            "val9": 8,
            "val10": 9
        },
        "booleanValues": {
            "b1": true,
            "b2": false,
            "b3": true,
            "b4": false,
            "b5": true
        },
        "nullValue": null,
        "coordinates": {
            "x": 12.34,
            "y": 56.78,
            "z": 90.12
        },
        "description": "This is a large payload with approximately 100 values of different types including numbers, strings, booleans, arrays, and nested objects.",
        "endMarker": "END OF PAYLOAD"
    },
    "outputFormat": "txt"
}
```
```json
{
    "reportName": "daily/456/789",
    "payloadData": {
        "id": 2,
        "name": "Medium Report",
        "count": 75,
        "active": false,
        "timestamp": "2023-11-16T09:30:00Z",
        "values": [5, 15, 25, 35, 45, 55, 65, 75, 85, 95],
        "metadata": {
            "author": "Jane Smith",
            "version": "1.1.0",
            "tags": ["daily", "stats", "summary"]
        },
        "details": {
            "field1": 456,
            "field2": "another value",
            "field3": true,
            "field4": [4, 5, 6],
            "field5": {
                "nested1": "different nested value",
                "nested2": 789
            }
        },
        "item1": 11,
        "item2": 12,
        "item3": 13,
        "item4": 14,
        "item5": 15,
        "item6": 16,
        "item7": 17,
        "item8": 18,
        "item9": 19,
        "item10": 20,
        "text1": "sample 1",
        "text2": "sample 2",
        "text3": "sample 3",
        "text4": "sample 4",
        "text5": "sample 5",
        "text6": "sample 6",
        "text7": "sample 7",
        "text8": "sample 8",
        "text9": "sample 9",
        "text10": "sample 10",
        "flag1": false,
        "flag2": true,
        "flag3": false,
        "flag4": true,
        "flag5": false,
        "nestedObject1": {
            "prop1": "alt value1",
            "prop2": 150,
            "prop3": [10, "x", false]
        },
        "nestedObject2": {
            "prop1": "alt value2",
            "prop2": 250,
            "prop3": [20, "y", true]
        },
        "nestedObject3": {
            "prop1": "alt value3",
            "prop2": 350,
            "prop3": [30, "z", false]
        },
        "array1": ["x", "y", "z"],
        "array2": [10, 20, 30, 40, 50],
        "array3": [false, true, false],
        "mixedArray": [10, "b", false, null],
        "settings": {
            "setting1": "disabled",
            "setting2": "enabled",
            "setting3": 24,
            "advanced": {
                "opt1": false,
                "opt2": "low",
                "opt3": 6.28
            }
        },
        "additional1": "more data 1",
        "additional2": "more data 2",
        "additional3": "more data 3",
        "additional4": "more data 4",
        "additional5": "more data 5",
        "numericValues": {
            "val1": 10,
            "val2": 11,
            "val3": 12,
            "val4": 13,
            "val5": 14,
            "val6": 15,
            "val7": 16,
            "val8": 17,
            "val9": 18,
            "val10": 19
        },
        "booleanValues": {
            "b1": false,
            "b2": true,
            "b3": false,
            "b4": true,
            "b5": false
        },
        "nullValue": null,
        "coordinates": {
            "x": 23.45,
            "y": 67.89,
            "z": 12.34
        },
        "description": "This is a medium-sized payload with about 75 values of various types including integers, text, flags, arrays and nested structures.",
        "endMarker": "END OF DATA"
    },
    "outputFormat": "csv"
}
```

```json
{
    "reportName": "weekly/789/012",
    "payloadData": {
        "id": 3,
        "name": "Small Report",
        "count": 50,
        "active": true,
        "timestamp": "2023-11-17T15:45:00Z",
        "values": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
        "metadata": {
            "author": "Alex Johnson",
            "version": "2.0.0",
            "tags": ["weekly", "compact", "metrics"]
        },
        "details": {
            "field1": 789,
            "field2": "final value",
            "field3": null,
            "field4": [7, 8, 9],
            "field5": {
                "nested1": "last nested value",
                "nested2": 101
            }
        },
        "item1": 21,
        "item2": 22,
        "item3": 23,
        "item4": 24,
        "item5": 25,
        "item6": 26,
        "item7": 27,
        "item8": 28,
        "item9": 29,
        "item10": 30,
        "text1": "final 1",
        "text2": "final 2",
        "text3": "final 3",
        "text4": "final 4",
        "text5": "final 5",
        "text6": "final 6",
        "text7": "final 7",
        "text8": "final 8",
        "text9": "final 9",
        "text10": "final 10",
        "flag1": true,
        "flag2": true,
        "flag3": false,
        "flag4": false,
        "flag5": true,
        "nestedObject1": {
            "prop1": "last value1",
            "prop2": 500,
            "prop3": [100, "last1", true]
        },
        "nestedObject2": {
            "prop1": "last value2",
            "prop2": 600,
            "prop3": [200, "last2", false]
        },
        "nestedObject3": {
            "prop1": "last value3",
            "prop2": 700,
            "prop3": [300, "last3", true]
        },
        "array1": ["final", "array", "items"],
        "array2": [100, 200, 300, 400, 500],
        "array3": [true, true, false],
        "mixedArray": [100, "final", true, null],
        "settings": {
            "setting1": "auto",
            "setting2": "auto",
            "setting3": 100,
            "advanced": {
                "opt1": true,
                "opt2": "medium",
                "opt3": 1.618
            }
        },
        "additional1": "last data 1",
        "additional2": "last data 2",
        "additional3": "last data 3",
        "additional4": "last data 4",
        "additional5": "last data 5",
        "numericValues": {
            "val1": 100,
            "val2": 101,
            "val3": 102,
            "val4": 103,
            "val5": 104,
            "val6": 105,
            "val7": 106,
            "val8": 107,
            "val9": 108,
            "val10": 109
        },
        "booleanValues": {
            "b1": true,
            "b2": true,
            "b3": false,
            "b4": false,
            "b5": true
        },
        "nullValue": null,
        "coordinates": {
            "x": 34.56,
            "y": 78.90,
            "z": 12.34
        },
        "description": "Compact payload containing 50 values with mixed types, suitable for weekly reporting with essential metrics only.",
        "endMarker": "END OF REPORT"
    },
    "outputFormat": "xls"
}
```