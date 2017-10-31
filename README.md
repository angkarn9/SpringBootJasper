# SpringBootJasper
SpringBoot Jasper Report

## Setup Program
1. Install Font from directory "directprinter\tools\07-TH-Sarabun-PSK.zip"
2. Start Project with command "mvn spring-boot:run"
3. You can change port in file "directprinter\src\main\resources\application.properties"
4. You can modify jasper file from directory "directprinter\src\main\resources\jrxml\slip.jrxml"

## How To Test Programe
Call API from Rest API tool
1. http://localhost:9999/printslip/
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

