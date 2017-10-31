# SpringBootJasper
SpringBoot Jasper Report

## Setup Program
1. Install maven
2. Install Font from directory "directprinter\tools\07-TH-Sarabun-PSK.zip"
3. Start Project with command "mvn spring-boot:run"
4. You can change port in file "directprinter\src\main\resources\application.properties"
5. You can modify jasper file from directory "directprinter\src\main\resources\jrxml\slip.jrxml"

## How To Test Programe
1. run program with command "mvn spring-boot:run" in directory "directprinter"
2. Call API from Rest API tool
3. url http://localhost:9999/printslip
4. Method `POST`
5. Header `Content-Type: application/json`

### Data Mockup
`[{
	"title": "รายการ",
	"item":"สมุด   40 บาท"
},
{
	"title": "รายการ",
	"item":"ดินสอ   10 บาท"
},
{
	"title": "รายการ",
	"item":"ปากกา   15 บาท"
},
{
	"title": "รายการ",
	"item":"กระดาษ A4   260 บาท"
},
{
	"title": "รายการ",
	"item":"ยางลบ 20 บาท"
}]`

### Response Data
`{
    "desc": "กำลังพิมพ์ Slip ออกทางเครื่องพิมพ์..."
}`

