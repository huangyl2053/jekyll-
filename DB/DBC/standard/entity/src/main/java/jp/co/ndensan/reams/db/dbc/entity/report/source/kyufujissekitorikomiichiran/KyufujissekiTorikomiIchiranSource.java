/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kyufujissekitorikomiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBC200007_給付実績情報取込結果一覧表 のソースクラスです。
 *
 * @reamsid_L DBC-2440-030 qinzhen
 */
public class KyufujissekiTorikomiIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "torikomiYM", length = 8, order = 2)
    public RString torikomiYM;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 12, order = 4)
    public RString hokenshaName;
    @ReportItem(name = "shutsuryokujun1", length = 10, order = 5)
    public RString shutsuryokujun1;
    @ReportItem(name = "shutsuryokujun2", length = 10, order = 6)
    public RString shutsuryokujun2;
    @ReportItem(name = "shutsuryokujun3", length = 10, order = 7)
    public RString shutsuryokujun3;
    @ReportItem(name = "shutsuryokujun4", length = 10, order = 8)
    public RString shutsuryokujun4;
    @ReportItem(name = "shutsuryokujun5", length = 10, order = 9)
    public RString shutsuryokujun5;
    @ReportItem(name = "kaiPege1", length = 20, order = 10)
    public RString kaiPege1;
    @ReportItem(name = "kaiPege2", length = 20, order = 11)
    public RString kaiPege2;
    @ReportItem(name = "kaiPege3", length = 20, order = 12)
    public RString kaiPege3;
    @ReportItem(name = "kaiPege4", length = 20, order = 13)
    public RString kaiPege4;
    @ReportItem(name = "kaiPege5", length = 20, order = 14)
    public RString kaiPege5;
    @ReportItem(name = "listUpper_1", length = 5, order = 15)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 4, order = 16)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 8, order = 17)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 2, order = 18)
    public RString listUpper_4;
    @ReportExpandedInfo(id = "A", code = "0003", name = "被保険者番号")
    @ReportItem(name = "listUpper_5", length = 10, order = 19)
    public RString listUpper_5;
    @ReportItem(name = "listUpper_6", length = 30, order = 20)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 6, order = 21)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 4, order = 22)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 10, order = 23)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 10, order = 24)
    public RString listUpper_10;
    @ReportItem(name = "listUpper_11", length = 1, order = 25)
    public RString listUpper_11;
    @ReportItem(name = "listUpper_12", length = 1, order = 26)
    public RString listUpper_12;
    @ReportItem(name = "listUpper_13", length = 1, order = 27)
    public RString listUpper_13;
    @ReportItem(name = "listUpper_14", length = 1, order = 28)
    public RString listUpper_14;
    @ReportItem(name = "listUpper_15", length = 1, order = 29)
    public RString listUpper_15;
    @ReportItem(name = "listUpper_16", length = 1, order = 30)
    public RString listUpper_16;
    @ReportItem(name = "listUpper_17", length = 1, order = 31)
    public RString listUpper_17;
    @ReportItem(name = "listUpper_18", length = 1, order = 32)
    public RString listUpper_18;
    @ReportItem(name = "listUpper_19", length = 1, order = 33)
    public RString listUpper_19;
    @ReportItem(name = "listUpper_20", length = 1, order = 34)
    public RString listUpper_20;
    @ReportItem(name = "listUpper_21", length = 1, order = 35)
    public RString listUpper_21;
    @ReportItem(name = "listUpper_22", length = 1, order = 36)
    public RString listUpper_22;
    @ReportItem(name = "listUpper_23", length = 1, order = 37)
    public RString listUpper_23;
    @ReportItem(name = "listUpper_24", length = 1, order = 38)
    public RString listUpper_24;
    @ReportItem(name = "listUpper_25", length = 2, order = 39)
    public RString listUpper_25;
    @ReportItem(name = "listLower_1", length = 8, order = 40)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 15, order = 41)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 20, order = 42)
    public RString listLower_3;
    @ReportItem(name = "gokeiKensuTitle", length = 4, order = 43)
    public RString gokeiKensuTitle;
    @ReportItem(name = "gokeiKensu", length = 8, order = 44)
    public RString gokeiKensu;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
    @ReportItem(name = "yubinNo", length = 10, order = 68)
    public RString yubinNo;
    @ReportItem(name = "choikiCode", length = 10, order = 69)
    public RString choikiCode;
    @ReportItem(name = "gyoseikuCode", length = 10, order = 70)
    public RString gyoseikuCode;
    @ReportItem(name = "shimei50onKana", length = 10, order = 71)
    public RString shimei50onKana;
    @ReportItem(name = "shichosonCode", length = 10, order = 72)
    public RString shichosonCode;
    @ReportItem(name = "kyufuJissekiKubun", length = 10, order = 73)
    public RString kyufuJissekiKubun;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSourceのenum
     */
    public enum ReportSourceFields {

        printTimeStamp,
        torikomiYM,
        hokenshaNo,
        hokenshaName,
        shutsuryokujun1,
        shutsuryokujun2,
        shutsuryokujun3,
        shutsuryokujun4,
        shutsuryokujun5,
        kaipage1,
        kaipage2,
        kaipage3,
        kaipage4,
        kaipage5,
        listUpper_1,
        listUpper_2,
        listUpper_3,
        listUpper_4,
        listUpper_5,
        listUpper_6,
        listUpper_7,
        listUpper_8,
        listUpper_9,
        listUpper_10,
        listUpper_11,
        listUpper_12,
        listUpper_13,
        listUpper_14,
        listUpper_15,
        listUpper_16,
        listUpper_17,
        listUpper_18,
        listUpper_19,
        listUpper_20,
        listUpper_21,
        listUpper_22,
        listUpper_23,
        listUpper_24,
        listUpper_25,
        listLower_1,
        listLower_2,
        listLower_3,
        gokeiKensuTitle,
        gokeiKensu,
        kyufuJissekiKubun,
        yubinNo,
        choikiCode,
        gyoseikuCode,
        shimei50onKana,
        shichosonCode
    }
}
