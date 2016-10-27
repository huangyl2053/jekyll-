/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Source
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoSource implements IReportSource {

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "testShori", length = 5, order = 2)
    public RString testShori;
    @ReportItem(name = "nenkinHokenshaName", length = 3, order = 3)
    public RString nenkinHokenshaName;
    @ReportItem(name = "nengetsu", length = 11, order = 4)
    public RString nengetsu;
    @ReportItem(name = "shichosonCode", length = 6, order = 5)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 24, order = 6)
    public RString shichosonName;
    @ReportItem(name = "hokenshaNo", length = 6, order = 7)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 24, order = 8)
    public RString hokenshaName;
    @ReportItem(name = "tsukairaiTitleLeft", length = 6, order = 9)
    public RString tsukairaiTitleLeft;
    @ReportItem(name = "tsukairaiTitleRight", length = 6, order = 10)
    public RString tsukairaiTitleRight;
    @ReportItem(name = "list1_1", length = 7, order = 11)
    public RString list1_1;
    @ReportItem(name = "list1_2", length = 7, order = 12)
    public RString list1_2;
    @ReportItem(name = "list2_1", length = 3, order = 13)
    public RString list2_1;
    @ReportItem(name = "list2_2", length = 20, order = 14)
    public RString list2_2;
    @ReportItem(name = "list2_3", length = 7, order = 15)
    public RString list2_3;
    @ReportItem(name = "list2_4", length = 7, order = 16)
    public RString list2_4;
    @ReportItem(name = "list2_5", length = 3, order = 17)
    public RString list2_5;
    @ReportItem(name = "list2_6", length = 20, order = 18)
    public RString list2_6;
    @ReportItem(name = "list2_7", length = 7, order = 19)
    public RString list2_7;
    @ReportItem(name = "list2_8", length = 7, order = 20)
    public RString list2_8;
    @ReportItem(name = "list3_1", length = 7, order = 21)
    public RString list3_1;
    @ReportItem(name = "list3_2", length = 7, order = 22)
    public RString list3_2;
    @ReportItem(name = "list4_1", length = 7, order = 23)
    public RString list4_1;
    @ReportItem(name = "list4_2", length = 7, order = 24)
    public RString list4_2;
    @ReportItem(name = "gokeiSoshituKensu", length = 7, order = 25)
    public RString gokeiSoshituKensu;
    @ReportItem(name = "gokeiKensu", length = 7, order = 26)
    public RString gokeiKensu;
    @ReportItem(name = "gokeiKariSanShutsuGakuHenkoKensu", length = 7, order = 27)
    public RString gokeiKariSanShutsuGakuHenkoKensu;
    @ReportItem(name = "baitaiNo", length = 6, order = 28)
    public RString baitaiNo;
    @ReportItem(name = "shurokuKensu", length = 7, order = 29)
    public RString shurokuKensu;
    @ReportItem(name = "gokeijushochiTokureiKensu", length = 7, order = 30)
    public RString gokeijushochiTokureiKensu;
    @ReportItem(name = "gokeiTsukairaiKensu", length = 7, order = 31)
    public RString gokeiTsukairaiKensu;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * TokubetsuChoshuIdojohoKensuhyoSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        testShori,
        nenkinHokenshaName,
        nengetsu,
        shichosonCode,
        shichosonName,
        hokenshaNo,
        hokenshaName,
        tsukairaiTitleLeft,
        tsukairaiTitleRight,
        list1_1,
        list1_2,
        list2_1,
        list2_2,
        list2_3,
        list2_4,
        list2_5,
        list2_6,
        list2_7,
        list2_8,
        list3_1,
        list3_2,
        list4_1,
        list4_2,
        gokeiSoshituKensu,
        gokeiKensu,
        gokeiKariSanShutsuGakuHenkoKensu,
        baitaiNo,
        shurokuKensu,
        gokeijushochiTokureiKensu,
        gokeiTsukairaiKensu
    }
}
