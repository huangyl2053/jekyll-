/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.shinsakaigijiroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class ShinsakaiGijirokuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "nendo", length = 10, order = 1)
    public RString nendo;
    @ReportItem(name = "title", length = 20, order = 2)
    public RString title;
    @ReportItem(name = "printTimeStamp", length = 34, order = 3)
    public RString printTimeStamp;
    @ReportItem(name = "kaisaiCount", length = 20, order = 4)
    public RString kaisaiCount;
    @ReportItem(name = "kaisaiDate", length = 16, order = 5)
    public RString kaisaiDate;
    @ReportItem(name = "kaisaiTime", length = 22, order = 6)
    public RString kaisaiTime;
    @ReportItem(name = "count", length = 4, order = 7)
    public RString count;
    @ReportItem(name = "kaisaiKaijo", length = 30, order = 8)
    public RString kaisaiKaijo;
    @ReportItem(name = "listShinsakaishussekiIchiran_1", length = 14, order = 9)
    public RString listShinsakaishussekiIchiran_1;
    @ReportItem(name = "listShinsakaishussekiIchiran_2", length = 14, order = 10)
    public RString listShinsakaishussekiIchiran_2;
    @ReportItem(name = "listShinsakaishussekiIchiran_3", length = 14, order = 11)
    public RString listShinsakaishussekiIchiran_3;
    @ReportItem(name = "listShinsakaishussekiIchiran_4", length = 14, order = 12)
    public RString listShinsakaishussekiIchiran_4;
    @ReportItem(name = "listShinsakaishussekiIchiran_5", length = 14, order = 13)
    public RString listShinsakaishussekiIchiran_5;
    @ReportItem(name = "ListCount_1", length = 1, order = 14)
    public RString ListCount_1;
    @ReportItem(name = "cnt", length = 2, order = 15)
    public RString cnt;
    @ReportItem(name = "shinsakaiKaisaiTime", length = 10, order = 16)
    public RString shinsakaiKaisaiTime;
    @ReportItem(name = "hanteitime", length = 10, order = 17)
    public RString hanteitime;
    @ReportItem(name = "yoteiCount", length = 5, order = 18)
    public RString yoteiCount;
    @ReportItem(name = "listShinseishubetsuCount_1", length = 5, order = 19)
    public RString listShinseishubetsuCount_1;
    @ReportItem(name = "listShinseishubetsuCount_2", length = 5, order = 20)
    public RString listShinseishubetsuCount_2;
    @ReportItem(name = "listShinseishubetsuCount_3", length = 5, order = 21)
    public RString listShinseishubetsuCount_3;
    @ReportItem(name = "listShinseishubetsuCount_4", length = 5, order = 22)
    public RString listShinseishubetsuCount_4;
    @ReportItem(name = "ichijiGaiCnt1", length = 5, order = 23)
    public RString ichijiGaiCnt1;
    @ReportItem(name = "listIchijihanteibetsuCount_1", length = 5, order = 24)
    public RString listIchijihanteibetsuCount_1;
    @ReportItem(name = "listIchijihanteibetsuCount_2", length = 5, order = 25)
    public RString listIchijihanteibetsuCount_2;
    @ReportItem(name = "listIchijihanteibetsuCount_3", length = 5, order = 26)
    public RString listIchijihanteibetsuCount_3;
    @ReportItem(name = "listIchijihanteibetsuCount_4", length = 5, order = 27)
    public RString listIchijihanteibetsuCount_4;
    @ReportItem(name = "listIchijihanteibetsuCount_5", length = 5, order = 28)
    public RString listIchijihanteibetsuCount_5;
    @ReportItem(name = "listIchijihanteibetsuCount_6", length = 5, order = 29)
    public RString listIchijihanteibetsuCount_6;
    @ReportItem(name = "listIchijihanteibetsuCount_7", length = 5, order = 30)
    public RString listIchijihanteibetsuCount_7;
    @ReportItem(name = "listIchijihanteibetsuCount_8", length = 5, order = 31)
    public RString listIchijihanteibetsuCount_8;
    @ReportItem(name = "listIchijihanteibetsuCount_9", length = 5, order = 32)
    public RString listIchijihanteibetsuCount_9;
    @ReportItem(name = "listIchijihantei2betsuCount_1", length = 5, order = 33)
    public RString listIchijihantei2betsuCount_1;
    @ReportItem(name = "listIchijihantei2betsuCount_2", length = 5, order = 34)
    public RString listIchijihantei2betsuCount_2;
    @ReportItem(name = "listIchijihantei2betsuCount_3", length = 5, order = 35)
    public RString listIchijihantei2betsuCount_3;
    @ReportItem(name = "listIchijihantei2betsuCount_4", length = 5, order = 36)
    public RString listIchijihantei2betsuCount_4;
    @ReportItem(name = "listIchijihantei2betsuCount_5", length = 5, order = 37)
    public RString listIchijihantei2betsuCount_5;
    @ReportItem(name = "listIchijihantei2betsuCount_6", length = 5, order = 38)
    public RString listIchijihantei2betsuCount_6;
    @ReportItem(name = "listIchijihantei2betsuCount_7", length = 5, order = 39)
    public RString listIchijihantei2betsuCount_7;
    @ReportItem(name = "listIchijihantei2betsuCount_8", length = 5, order = 40)
    public RString listIchijihantei2betsuCount_8;
    @ReportItem(name = "listIchijihantei2betsuCount_9", length = 5, order = 41)
    public RString listIchijihantei2betsuCount_9;
    @ReportItem(name = "ichijiGaiCnt2", length = 5, order = 42)
    public RString ichijiGaiCnt2;
    @ReportItem(name = "ichijiGaiCnt3", length = 5, order = 43)
    public RString ichijiGaiCnt3;
    @ReportItem(name = "sabisuShurui1", length = 60, order = 44)
    public RString sabisuShurui1;
    @ReportItem(name = "kensu", length = 5, order = 45)
    public RString kensu;
    @ReportItem(name = "hokengaiShisetsuKensu", length = 5, order = 46)
    public RString hokengaiShisetsuKensu;
    @ReportItem(name = "nigoKensu", length = 5, order = 47)
    public RString nigoKensu;
    @ReportItem(name = "zaitakuKensu", length = 5, order = 48)
    public RString zaitakuKensu;
    @ReportItem(name = "shisetsuKensu", length = 5, order = 49)
    public RString shisetsuKensu;
    @ReportItem(name = "koshinKensu", length = 5, order = 50)
    public RString koshinKensu;
    @ReportItem(name = "shinkiKensu", length = 5, order = 51)
    public RString shinkiKensu;
    @ReportItem(name = "kubunHenkoKensu", length = 5, order = 52)
    public RString kubunHenkoKensu;
    @ReportItem(name = "listNijihanteibetsuCount_1", length = 5, order = 53)
    public RString listNijihanteibetsuCount_1;
    @ReportItem(name = "listNijihanteibetsuCount_2", length = 5, order = 54)
    public RString listNijihanteibetsuCount_2;
    @ReportItem(name = "listNijihanteibetsuCount_3", length = 5, order = 55)
    public RString listNijihanteibetsuCount_3;
    @ReportItem(name = "listNijihanteibetsuCount_4", length = 5, order = 56)
    public RString listNijihanteibetsuCount_4;
    @ReportItem(name = "listNijihanteibetsuCount_5", length = 5, order = 57)
    public RString listNijihanteibetsuCount_5;
    @ReportItem(name = "listNijihanteibetsuCount_6", length = 5, order = 58)
    public RString listNijihanteibetsuCount_6;
    @ReportItem(name = "listNijihanteibetsuCount_7", length = 5, order = 59)
    public RString listNijihanteibetsuCount_7;
    @ReportItem(name = "listNijihanteibetsuCount_8", length = 5, order = 60)
    public RString listNijihanteibetsuCount_8;
    @ReportItem(name = "mihanteiCount", length = 5, order = 61)
    public RString mihanteiCount;
    @ReportItem(name = "mishinsaCount", length = 5, order = 62)
    public RString mishinsaCount;
    @ReportItem(name = "ichijihanteiHenkoCount", length = 5, order = 63)
    public RString ichijihanteiHenkoCount;
    @ReportItem(name = "shinsakaiikenHenkoCount", length = 5, order = 64)
    public RString shinsakaiikenHenkoCount;
    @ReportItem(name = "sabisuShurui2", length = 60, order = 65)
    public RString sabisuShurui2;
    @ReportItem(name = "biko", order = 66)
    public RString biko;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
