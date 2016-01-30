package jp.co.ndensan.reams.db.dba.entity.report.hihokenshashob4;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 
 * 介護保険被保険者証（B4版）のReportSourceクラスです。
 */
public class HihokenshashoB4ReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "kaigokbn1", length = 6, order = 1)
    public RString kaigokbn1;
    @ReportItem(name = "seigen11", length = 4, order = 2)
    public RString seigen11;
    @ReportItem(name = "seigenSt11", length = 11, order = 3)
    public RString seigenSt11;
    @ReportItem(name = "seigenLong11", length = 6, order = 4)
    public RString seigenLong11;
    @ReportItem(name = "seigen21", length = 4, order = 5)
    public RString seigen21;
    @ReportItem(name = "seigenEd11", length = 11, order = 6)
    public RString seigenEd11;
    @ReportItem(name = "seigenLong21", length = 6, order = 7)
    public RString seigenLong21;
    @ReportItem(name = "ninteiymd1", length = 11, order = 8)
    public RString ninteiymd1;
    @ReportItem(name = "yukokigen21", length = 11, order = 9)
    public RString yukokigen21;
    @ReportItem(name = "yukokigen1", length = 25, order = 10)
    public RString yukokigen1;
    @ReportItem(name = "seigen31", length = 4, order = 11)
    public RString seigen31;
    @ReportItem(name = "seigenSt21", length = 11, order = 12)
    public RString seigenSt21;
    @ReportItem(name = "seigenLong31", length = 6, order = 13)
    public RString seigenLong31;
    @ReportItem(name = "yukokikaned1", length = 11, order = 14)
    public RString yukokikaned1;
    @ReportItem(name = "yukokikanst1", length = 11, order = 15)
    public RString yukokikanst1;
    @ReportItem(name = "seigen41", length = 4, order = 16)
    public RString seigen41;
    @ReportItem(name = "hihokenshanno1", length = 10, order = 17)
    public RString hihokenshanno1;
    @ReportItem(name = "seigenEd21", length = 11, order = 18)
    public RString seigenEd21;
    @ReportItem(name = "seigenLong41", length = 6, order = 19)
    public RString seigenLong41;
    @ReportItem(name = "seigen51", length = 4, order = 20)
    public RString seigen51;
    @ReportItem(name = "seigenSt31", length = 11, order = 21)
    public RString seigenSt31;
    @ReportItem(name = "seigenLong51", length = 6, order = 22)
    public RString seigenLong51;
    @ReportItem(name = "yubinno1", length = 8, order = 23)
    public RString yubinno1;
    @ReportItem(name = "homonkikanst1", length = 11, order = 24)
    public RString homonkikanst1;
    @ReportItem(name = "homonkikaned1", length = 11, order = 25)
    public RString homonkikaned1;
    @ReportItem(name = "seigen61", length = 4, order = 26)
    public RString seigen61;
    @ReportItem(name = "gyoseiku1", length = 13, order = 27)
    public RString gyoseiku1;
    @ReportItem(name = "seigenEd31", length = 11, order = 28)
    public RString seigenEd31;
    @ReportItem(name = "gyoseikuS1", length = 17, order = 29)
    public RString gyoseikuS1;
    @ReportItem(name = "seigenLong61", length = 6, order = 30)
    public RString seigenLong61;
    @ReportItem(name = "hihojusho1", order = 31)
    public RString hihojusho1;
    @ReportItem(name = "service11", length = 7, order = 32)
    public RString service11;
    @ReportItem(name = "ten01", length = 2, order = 33)
    public RString ten01;
    @ReportItem(name = "gyosha1", order = 34)
    public RString gyosha1;
    @ReportItem(name = "servicetani1", length = 5, order = 35)
    public RString servicetani1;
    @ReportItem(name = "todokeYmd11", length = 11, order = 36)
    public RString todokeYmd11;
    @ReportItem(name = "shuruigendo11", length = 7, order = 37)
    public RString shuruigendo11;
    @ReportItem(name = "shurui11", length = 14, order = 38)
    public RString shurui11;
    @ReportItem(name = "ten11", length = 2, order = 39)
    public RString ten11;
    @ReportItem(name = "gyosha2", order = 40)
    public RString gyosha2;
    @ReportItem(name = "gyosha2Asa", order = 41)
    public RString gyosha2Asa;
    @ReportItem(name = "gyosha2Massho", order = 42)
    public RString gyosha2Massho;
    @ReportItem(name = "shuruigendo21", length = 7, order = 43)
    public RString shuruigendo21;
    @ReportItem(name = "ten21", length = 2, order = 44)
    public RString ten21;
    @ReportItem(name = "shurui21", length = 14, order = 45)
    public RString shurui21;
    @ReportItem(name = "shuruigendo31", length = 7, order = 46)
    public RString shuruigendo31;
    @ReportItem(name = "ten31", length = 2, order = 47)
    public RString ten31;
    @ReportItem(name = "shurui31", length = 14, order = 48)
    public RString shurui31;
    @ReportItem(name = "hihokana1", order = 49)
    public RString hihokana1;
    @ReportItem(name = "todokeYmd21", length = 11, order = 50)
    public RString todokeYmd21;
    @ReportItem(name = "todokeYmd2Massho1", length = 16, order = 51)
    public RString todokeYmd2Massho1;
    @ReportItem(name = "todokeYmd2Asa1", length = 16, order = 52)
    public RString todokeYmd2Asa1;
    @ReportItem(name = "shuruigendo41", length = 7, order = 53)
    public RString shuruigendo41;
    @ReportItem(name = "ten41", length = 2, order = 54)
    public RString ten41;
    @ReportItem(name = "shurui41", length = 14, order = 55)
    public RString shurui41;
    @ReportItem(name = "hihoname1", order = 56)
    public RString hihoname1;
    @ReportItem(name = "gyosha3", order = 57)
    public RString gyosha3;
    @ReportItem(name = "gyosha3Asa", order = 58)
    public RString gyosha3Asa;
    @ReportItem(name = "gyosha3Massho", order = 59)
    public RString gyosha3Massho;
    @ReportItem(name = "shuruigendo51", length = 7, order = 60)
    public RString shuruigendo51;
    @ReportItem(name = "ten51", length = 2, order = 61)
    public RString ten51;
    @ReportItem(name = "shurui51", length = 14, order = 62)
    public RString shurui51;
    @ReportItem(name = "shurui61", length = 14, order = 63)
    public RString shurui61;
    @ReportItem(name = "ten61", length = 2, order = 64)
    public RString ten61;
    @ReportItem(name = "shuruigendo61", length = 7, order = 65)
    public RString shuruigendo61;
    @ReportItem(name = "todokeYmd31", length = 11, order = 66)
    public RString todokeYmd31;
    @ReportItem(name = "todokeYmd3Asa1", length = 16, order = 67)
    public RString todokeYmd3Asa1;
    @ReportItem(name = "todokeYmd3Massho1", length = 16, order = 68)
    public RString todokeYmd3Massho1;
    @ReportItem(name = "ryui1", order = 69)
    public RString ryui1;
    @ReportItem(name = "shisetsuSyu11", length = 13, order = 70)
    public RString shisetsuSyu11;
    @ReportItem(name = "seibetsuMan1", length = 1, order = 71)
    public RString seibetsuMan1;
    @ReportItem(name = "seibetsuWoman1", length = 1, order = 72)
    public RString seibetsuWoman1;
    @ReportItem(name = "umareMeiji1", length = 2, order = 73)
    public RString umareMeiji1;
    @ReportItem(name = "umareTaisho1", length = 2, order = 74)
    public RString umareTaisho1;
    @ReportItem(name = "umareShowa1", length = 2, order = 75)
    public RString umareShowa1;
    @ReportItem(name = "umareMm1", length = 2, order = 76)
    public RString umareMm1;
    @ReportItem(name = "umareDd1", length = 2, order = 77)
    public RString umareDd1;
    @ReportItem(name = "umareYy1", length = 2, order = 78)
    public RString umareYy1;
    @ReportItem(name = "umareYyyy1", length = 4, order = 79)
    public RString umareYyyy1;
    @ReportItem(name = "umareMmS1", length = 2, order = 80)
    public RString umareMmS1;
    @ReportItem(name = "umareDdS1", length = 2, order = 81)
    public RString umareDdS1;
    @ReportItem(name = "saikofu11", length = 3, order = 82)
    public RString saikofu11;
    @ReportItem(name = "saikofu21", length = 3, order = 83)
    public RString saikofu21;
    @ReportItem(name = "shisetsuname11", order = 84)
    public RString shisetsuname11;
    @ReportItem(name = "kofuymdGengo1", length = 2, order = 85)
    public RString kofuymdGengo1;
    @ReportItem(name = "kofuymdYy1", length = 2, order = 86)
    public RString kofuymdYy1;
    @ReportItem(name = "kofuymdMm1", length = 2, order = 87)
    public RString kofuymdMm1;
    @ReportItem(name = "kofuymdDd1", length = 2, order = 88)
    public RString kofuymdDd1;
    @ReportItem(name = "nyushochk11", length = 2, order = 89)
    public RString nyushochk11;
    @ReportItem(name = "nyuinchk11", length = 2, order = 90)
    public RString nyuinchk11;
    @ReportItem(name = "nyushoymd11", length = 11, order = 91)
    public RString nyushoymd11;
    @ReportItem(name = "taishochk11", length = 2, order = 92)
    public RString taishochk11;
    @ReportItem(name = "taiinchk11", length = 2, order = 93)
    public RString taiinchk11;
    @ReportItem(name = "taiinymd11", length = 11, order = 94)
    public RString taiinymd11;
    @ReportItem(name = "hokenshano41", length = 1, order = 95)
    public RString hokenshano41;
    @ReportItem(name = "hokenshano11", length = 1, order = 96)
    public RString hokenshano11;
    @ReportItem(name = "hokenshano21", length = 1, order = 97)
    public RString hokenshano21;
    @ReportItem(name = "hokenshano31", length = 1, order = 98)
    public RString hokenshano31;
    @ReportItem(name = "hokenshano51", length = 1, order = 99)
    public RString hokenshano51;
    @ReportItem(name = "hokenshano61", length = 1, order = 100)
    public RString hokenshano61;
    @ReportItem(name = "shisetsuSyu21", length = 13, order = 101)
    public RString shisetsuSyu21;
    @ReportItem(name = "shisetsuname21", order = 102)
    public RString shisetsuname21;
    @ReportItem(name = "nyushochk21", length = 2, order = 103)
    public RString nyushochk21;
    @ReportItem(name = "nyuinchk21", length = 2, order = 104)
    public RString nyuinchk21;
    @ReportItem(name = "nyushoymd21", length = 11, order = 105)
    public RString nyushoymd21;
    @ReportItem(name = "taishochk21", length = 2, order = 106)
    public RString taishochk21;
    @ReportItem(name = "taiinchk21", length = 2, order = 107)
    public RString taiinchk21;
    @ReportItem(name = "taiinymd21", length = 11, order = 108)
    public RString taiinymd21;
    @ReportItem(name = "renban1", length = 6, order = 109)
    public RString renban1;
    @ReportItem(name = "kaigokbn2", length = 6, order = 110)
    public RString kaigokbn2;
    @ReportItem(name = "seigen12", length = 4, order = 111)
    public RString seigen12;
    @ReportItem(name = "seigenLong12", length = 6, order = 112)
    public RString seigenLong12;
    @ReportItem(name = "seigenSt12", length = 11, order = 113)
    public RString seigenSt12;
    @ReportItem(name = "seigen22", length = 4, order = 114)
    public RString seigen22;
    @ReportItem(name = "seigenLong22", length = 6, order = 115)
    public RString seigenLong22;
    @ReportItem(name = "seigenEd12", length = 11, order = 116)
    public RString seigenEd12;
    @ReportItem(name = "ninteiymd2", length = 11, order = 117)
    public RString ninteiymd2;
    @ReportItem(name = "yukokigen22", length = 11, order = 118)
    public RString yukokigen22;
    @ReportItem(name = "yukokigen2", length = 25, order = 119)
    public RString yukokigen2;
    @ReportItem(name = "seigen32", length = 4, order = 120)
    public RString seigen32;
    @ReportItem(name = "seigenLong32", length = 6, order = 121)
    public RString seigenLong32;
    @ReportItem(name = "seigenSt22", length = 11, order = 122)
    public RString seigenSt22;
    @ReportItem(name = "yukokikanst2", length = 11, order = 123)
    public RString yukokikanst2;
    @ReportItem(name = "yukokikaned2", length = 11, order = 124)
    public RString yukokikaned2;
    @ReportItem(name = "seigen42", length = 4, order = 125)
    public RString seigen42;
    @ReportItem(name = "seigenLong42", length = 6, order = 126)
    public RString seigenLong42;
    @ReportItem(name = "seigenEd22", length = 11, order = 127)
    public RString seigenEd22;
    @ReportItem(name = "hihokenshanno2", length = 10, order = 128)
    public RString hihokenshanno2;
    @ReportItem(name = "seigen52", length = 4, order = 129)
    public RString seigen52;
    @ReportItem(name = "seigenLong52", length = 6, order = 130)
    public RString seigenLong52;
    @ReportItem(name = "seigenSt32", length = 11, order = 131)
    public RString seigenSt32;
    @ReportItem(name = "yubinno2", length = 8, order = 132)
    public RString yubinno2;
    @ReportItem(name = "homonkikanst2", length = 11, order = 133)
    public RString homonkikanst2;
    @ReportItem(name = "homonkikaned2", length = 11, order = 134)
    public RString homonkikaned2;
    @ReportItem(name = "gyoseikuS2", length = 17, order = 135)
    public RString gyoseikuS2;
    @ReportItem(name = "seigen62", length = 4, order = 136)
    public RString seigen62;
    @ReportItem(name = "gyoseiku2", length = 13, order = 137)
    public RString gyoseiku2;
    @ReportItem(name = "seigenEd32", length = 11, order = 138)
    public RString seigenEd32;
    @ReportItem(name = "seigenLong62", length = 6, order = 139)
    public RString seigenLong62;
    @ReportItem(name = "hihojusho2", order = 140)
    public RString hihojusho2;
    @ReportItem(name = "service12", length = 7, order = 141)
    public RString service12;
    @ReportItem(name = "ten02", length = 2, order = 142)
    public RString ten02;
    @ReportItem(name = "servicetani2", length = 5, order = 143)
    public RString servicetani2;
    @ReportItem(name = "gyosha4", order = 144)
    public RString gyosha4;
    @ReportItem(name = "todokeYmd12", length = 11, order = 145)
    public RString todokeYmd12;
    @ReportItem(name = "shuruigendo12", length = 7, order = 146)
    public RString shuruigendo12;
    @ReportItem(name = "ten12", length = 2, order = 147)
    public RString ten12;
    @ReportItem(name = "shurui12", length = 14, order = 148)
    public RString shurui12;
    @ReportItem(name = "gyosha5", order = 149)
    public RString gyosha5;
    @ReportItem(name = "gyosha5Asa", order = 150)
    public RString gyosha5Asa;
    @ReportItem(name = "gyosha5Massho", order = 151)
    public RString gyosha5Massho;
    @ReportItem(name = "shuruigendo22", length = 7, order = 152)
    public RString shuruigendo22;
    @ReportItem(name = "ten22", length = 2, order = 153)
    public RString ten22;
    @ReportItem(name = "shurui22", length = 14, order = 154)
    public RString shurui22;
    @ReportItem(name = "shuruigendo32", length = 7, order = 155)
    public RString shuruigendo32;
    @ReportItem(name = "ten32", length = 2, order = 156)
    public RString ten32;
    @ReportItem(name = "shurui32", length = 14, order = 157)
    public RString shurui32;
    @ReportItem(name = "hihokana2", order = 158)
    public RString hihokana2;
    @ReportItem(name = "todokeYmd22", length = 11, order = 159)
    public RString todokeYmd22;
    @ReportItem(name = "todokeYmd2Asa2", length = 16, order = 160)
    public RString todokeYmd2Asa2;
    @ReportItem(name = "todokeYmd2Massho2", length = 16, order = 161)
    public RString todokeYmd2Massho2;
    @ReportItem(name = "shuruigendo42", length = 7, order = 162)
    public RString shuruigendo42;
    @ReportItem(name = "ten42", length = 2, order = 163)
    public RString ten42;
    @ReportItem(name = "shurui42", length = 14, order = 164)
    public RString shurui42;
    @ReportItem(name = "hihoname2", order = 165)
    public RString hihoname2;
    @ReportItem(name = "gyosha6", order = 166)
    public RString gyosha6;
    @ReportItem(name = "gyosha6Asa", order = 167)
    public RString gyosha6Asa;
    @ReportItem(name = "gyosha6Massho", order = 168)
    public RString gyosha6Massho;
    @ReportItem(name = "shuruigendo52", length = 7, order = 169)
    public RString shuruigendo52;
    @ReportItem(name = "ten52", length = 2, order = 170)
    public RString ten52;
    @ReportItem(name = "shurui52", length = 14, order = 171)
    public RString shurui52;
    @ReportItem(name = "shuruigendo62", length = 7, order = 172)
    public RString shuruigendo62;
    @ReportItem(name = "ten62", length = 2, order = 173)
    public RString ten62;
    @ReportItem(name = "shurui62", length = 14, order = 174)
    public RString shurui62;
    @ReportItem(name = "ryui2", order = 175)
    public RString ryui2;
    @ReportItem(name = "todokeYmd32", length = 11, order = 176)
    public RString todokeYmd32;
    @ReportItem(name = "todokeYmd3Asa2", length = 16, order = 177)
    public RString todokeYmd3Asa2;
    @ReportItem(name = "todokeYmd3Massho2", length = 16, order = 178)
    public RString todokeYmd3Massho2;
    @ReportItem(name = "shisetsuSyu12", length = 13, order = 179)
    public RString shisetsuSyu12;
    @ReportItem(name = "seibetsuWoman2", length = 1, order = 180)
    public RString seibetsuWoman2;
    @ReportItem(name = "seibetsuMan2", length = 1, order = 181)
    public RString seibetsuMan2;
    @ReportItem(name = "umareMeiji2", length = 2, order = 182)
    public RString umareMeiji2;
    @ReportItem(name = "umareTaisho2", length = 2, order = 183)
    public RString umareTaisho2;
    @ReportItem(name = "umareShowa2", length = 2, order = 184)
    public RString umareShowa2;
    @ReportItem(name = "umareMm2", length = 2, order = 185)
    public RString umareMm2;
    @ReportItem(name = "umareDd2", length = 2, order = 186)
    public RString umareDd2;
    @ReportItem(name = "umareMmS2", length = 2, order = 187)
    public RString umareMmS2;
    @ReportItem(name = "umareDdS2", length = 2, order = 188)
    public RString umareDdS2;
    @ReportItem(name = "umareYy2", length = 2, order = 189)
    public RString umareYy2;
    @ReportItem(name = "umareYyyy2", length = 4, order = 190)
    public RString umareYyyy2;
    @ReportItem(name = "saikofu12", length = 3, order = 191)
    public RString saikofu12;
    @ReportItem(name = "saikofu22", length = 3, order = 192)
    public RString saikofu22;
    @ReportItem(name = "shisetsuname12", order = 193)
    public RString shisetsuname12;
    @ReportItem(name = "kofuymdYy2", length = 2, order = 194)
    public RString kofuymdYy2;
    @ReportItem(name = "kofuymdMm2", length = 2, order = 195)
    public RString kofuymdMm2;
    @ReportItem(name = "kofuymdDd2", length = 2, order = 196)
    public RString kofuymdDd2;
    @ReportItem(name = "kofuymdGengo2", length = 2, order = 197)
    public RString kofuymdGengo2;
    @ReportItem(name = "nyushochk12", length = 2, order = 198)
    public RString nyushochk12;
    @ReportItem(name = "nyuinchk12", length = 2, order = 199)
    public RString nyuinchk12;
    @ReportItem(name = "nyushoymd12", length = 11, order = 200)
    public RString nyushoymd12;
    @ReportItem(name = "taiinchk12", length = 2, order = 201)
    public RString taiinchk12;
    @ReportItem(name = "taishochk12", length = 2, order = 202)
    public RString taishochk12;
    @ReportItem(name = "taiinymd12", length = 11, order = 203)
    public RString taiinymd12;
    @ReportItem(name = "hokenshano12", length = 1, order = 204)
    public RString hokenshano12;
    @ReportItem(name = "hokenshano22", length = 1, order = 205)
    public RString hokenshano22;
    @ReportItem(name = "hokenshano32", length = 1, order = 206)
    public RString hokenshano32;
    @ReportItem(name = "hokenshano42", length = 1, order = 207)
    public RString hokenshano42;
    @ReportItem(name = "hokenshano52", length = 1, order = 208)
    public RString hokenshano52;
    @ReportItem(name = "hokenshano62", length = 1, order = 209)
    public RString hokenshano62;
    @ReportItem(name = "shisetsuSyu22", length = 13, order = 210)
    public RString shisetsuSyu22;
    @ReportItem(name = "shisetsuname22", order = 211)
    public RString shisetsuname22;
    @ReportItem(name = "nyushoymd22", length = 11, order = 212)
    public RString nyushoymd22;
    @ReportItem(name = "nyushochk22", length = 2, order = 213)
    public RString nyushochk22;
    @ReportItem(name = "nyuinchk22", length = 2, order = 214)
    public RString nyuinchk22;
    @ReportItem(name = "taiinymd22", length = 11, order = 215)
    public RString taiinymd22;
    @ReportItem(name = "renban2", length = 6, order = 216)
    public RString renban2;
    @ReportItem(name = "taishochk22", length = 2, order = 217)
    public RString taishochk22;
    @ReportItem(name = "taiinchk22", length = 2, order = 218)
    public RString taiinchk22;
    @ReportItem(name = "itakuGyosha1", order = 219)
    public RString itakuGyosha1;
    @ReportItem(name = "itakuGyosha2", order = 220)
    public RString itakuGyosha2;
    @ReportItem(name = "itakuGyosha2Asa", order = 221)
    public RString itakuGyosha2Asa;
    @ReportItem(name = "itakuGyosha2Massho", order = 222)
    public RString itakuGyosha2Massho;
    @ReportItem(name = "itakuGyosha3", order = 223)
    public RString itakuGyosha3;
    @ReportItem(name = "itakuGyosha3Asa", order = 224)
    public RString itakuGyosha3Asa;
    @ReportItem(name = "itakuGyosha3Massho", order = 225)
    public RString itakuGyosha3Massho;
    @ReportItem(name = "seiShogai11", length = 4, order = 226)
    public RString seiShogai11;
    @ReportItem(name = "seiShogai21", length = 4, order = 227)
    public RString seiShogai21;
    @ReportItem(name = "kosekiSeibetsu11", length = 4, order = 228)
    public RString kosekiSeibetsu11;
    @ReportItem(name = "kosekiSeibetsu21", length = 4, order = 229)
    public RString kosekiSeibetsu21;
    @ReportItem(name = "itakuGyosha4", order = 230)
    public RString itakuGyosha4;
    @ReportItem(name = "itakuGyosha5", order = 231)
    public RString itakuGyosha5;
    @ReportItem(name = "itakuGyosha5Asa", order = 232)
    public RString itakuGyosha5Asa;
    @ReportItem(name = "itakuGyosha5Massho", order = 233)
    public RString itakuGyosha5Massho;
    @ReportItem(name = "itakuGyosha6", order = 234)
    public RString itakuGyosha6;
    @ReportItem(name = "itakuGyosha6Asa", order = 235)
    public RString itakuGyosha6Asa;
    @ReportItem(name = "itakuGyosha6Massho", order = 236)
    public RString itakuGyosha6Massho;
    @ReportItem(name = "seiShogai12", length = 4, order = 237)
    public RString seiShogai12;
    @ReportItem(name = "seiShogai22", length = 4, order = 238)
    public RString seiShogai22;
    @ReportItem(name = "kosekiSeibetsu12", length = 4, order = 239)
    public RString kosekiSeibetsu12;
    @ReportItem(name = "kosekiSeibetsu22", length = 4, order = 240)
    public RString kosekiSeibetsu22;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
