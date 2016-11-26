/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票「本算定賦課計算」の項目を定義するクラスです。
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "nendo", length = 4, order = 2)
    public RString nendo;
    @ReportItem(name = "hokenshaNo", length = 6, order = 3)
    public RString hokenshaNo;
    @ReportItem(name = "hokenshaName", length = 20, order = 4)
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
    @ReportItem(name = "kaipage1", length = 20, order = 10)
    public RString kaipage1;
    @ReportItem(name = "kaipage2", length = 20, order = 11)
    public RString kaipage2;
    @ReportItem(name = "kaipage3", length = 20, order = 12)
    public RString kaipage3;
    @ReportItem(name = "kaipage4", length = 20, order = 13)
    public RString kaipage4;
    @ReportItem(name = "kaipage5", length = 20, order = 14)
    public RString kaipage5;
    @ReportItem(name = "fuchoKi1", length = 3, order = 15)
    public RString fuchoKi1;
    @ReportItem(name = "fuchoKi2", length = 3, order = 16)
    public RString fuchoKi2;
    @ReportItem(name = "fuchoKi3", length = 3, order = 17)
    public RString fuchoKi3;
    @ReportItem(name = "fuchoKi4", length = 3, order = 18)
    public RString fuchoKi4;
    @ReportItem(name = "fuchoKi5", length = 3, order = 19)
    public RString fuchoKi5;
    @ReportItem(name = "fuchoKi6", length = 3, order = 20)
    public RString fuchoKi6;
    @ReportItem(name = "fuchoKi7", length = 3, order = 21)
    public RString fuchoKi7;
    @ReportItem(name = "fuchoKi8", length = 3, order = 22)
    public RString fuchoKi8;
    @ReportItem(name = "fuchoKi9", length = 3, order = 23)
    public RString fuchoKi9;
    @ReportItem(name = "fuchoKi10", length = 3, order = 24)
    public RString fuchoKi10;
    @ReportItem(name = "fuchoKi11", length = 3, order = 25)
    public RString fuchoKi11;
    @ReportItem(name = "fuchoKi12", length = 3, order = 26)
    public RString fuchoKi12;
    @ReportItem(name = "listUpper_1", length = 20, order = 27)
    public RString listUpper_1;
    @ReportItem(name = "listUpper_2", length = 16, order = 28)
    public RString listUpper_2;
    @ReportItem(name = "listUpper_3", length = 10, order = 29)
    public RString listUpper_3;
    @ReportItem(name = "listUpper_4", length = 1, order = 30)
    public RString listUpper_4;
    @ReportItem(name = "listUpper_5", length = 15, order = 31)
    public RString listUpper_5;
    @ReportPerson(id = "A")
    @ReportItem(name = "listUpper_6", length = 15, order = 32)
    public RString listUpper_6;
    @ReportItem(name = "listUpper_7", length = 11, order = 33)
    public RString listUpper_7;
    @ReportItem(name = "listUpper_8", length = 8, order = 34)
    public RString listUpper_8;
    @ReportItem(name = "listUpper_9", length = 19, order = 35)
    public RString listUpper_9;
    @ReportItem(name = "listUpper_10", length = 38, order = 36)
    public RString listUpper_10;
    @ReportItem(name = "listCenter_1", length = 10, order = 37)
    public RString listCenter_1;
    @ReportItem(name = "listCenter_2", length = 9, order = 38)
    public RString listCenter_2;
    @ReportItem(name = "listCenter_3", length = 9, order = 39)
    public RString listCenter_3;
    @ReportItem(name = "listCenter_4", length = 5, order = 40)
    public RString listCenter_4;
    @ReportItem(name = "listCenter_5", length = 15, order = 41)
    public RString listCenter_5;
    @ReportItem(name = "listCenter_6", length = 15, order = 42)
    public RString listCenter_6;
    @ReportItem(name = "listCenter_7", length = 15, order = 43)
    public RString listCenter_7;
    @ReportItem(name = "listCenter_8", length = 5, order = 44)
    public RString listCenter_8;
    @ReportItem(name = "listCenter_9", length = 2, order = 45)
    public RString listCenter_9;
    @ReportItem(name = "listCenter_10", length = 2, order = 46)
    public RString listCenter_10;
    @ReportItem(name = "listCenter_11", length = 2, order = 47)
    public RString listCenter_11;
    @ReportItem(name = "listCenter_12", length = 2, order = 48)
    public RString listCenter_12;
    @ReportItem(name = "listCenter_13", length = 2, order = 49)
    public RString listCenter_13;
    @ReportItem(name = "listCenter_14", length = 2, order = 50)
    public RString listCenter_14;
    @ReportItem(name = "listCenter_15", length = 2, order = 51)
    public RString listCenter_15;
    @ReportItem(name = "listCenter_16", length = 2, order = 52)
    public RString listCenter_16;
    @ReportItem(name = "listCenter_17", length = 2, order = 53)
    public RString listCenter_17;
    @ReportItem(name = "listCenter_18", length = 2, order = 54)
    public RString listCenter_18;
    @ReportItem(name = "listCenter_19", length = 2, order = 55)
    public RString listCenter_19;
    @ReportItem(name = "listCenter_20", length = 2, order = 56)
    public RString listCenter_20;
    @ReportItem(name = "listCenter_21", length = 18, order = 57)
    public RString listCenter_21;
    @ReportItem(name = "listLower_1", length = 7, order = 58)
    public RString listLower_1;
    @ReportItem(name = "listLower_2", length = 7, order = 59)
    public RString listLower_2;
    @ReportItem(name = "listLower_3", length = 7, order = 60)
    public RString listLower_3;
    @ReportItem(name = "listLower_4", length = 7, order = 61)
    public RString listLower_4;
    @ReportItem(name = "listLower_5", length = 7, order = 62)
    public RString listLower_5;
    @ReportItem(name = "listLower_6", length = 7, order = 63)
    public RString listLower_6;
    @ReportItem(name = "listLower_7", length = 7, order = 64)
    public RString listLower_7;
    @ReportItem(name = "listLower_8", length = 7, order = 65)
    public RString listLower_8;
    @ReportItem(name = "listLower_9", length = 7, order = 66)
    public RString listLower_9;
    @ReportItem(name = "listLower_10", length = 7, order = 67)
    public RString listLower_10;
    @ReportItem(name = "listLower_11", length = 7, order = 68)
    public RString listLower_11;
    @ReportItem(name = "listLower_12", length = 7, order = 69)
    public RString listLower_12;
    @ReportItem(name = "listLower_13", length = 7, order = 70)
    public RString listLower_13;
    @ReportItem(name = "listLower_14", length = 7, order = 71)
    public RString listLower_14;
    @ReportItem(name = "listLower_15", length = 7, order = 72)
    public RString listLower_15;
    @ReportItem(name = "listLower_16", length = 7, order = 73)
    public RString listLower_16;
    @ReportItem(name = "listLower_17", length = 7, order = 74)
    public RString listLower_17;
    @ReportItem(name = "listLower_18", length = 7, order = 75)
    public RString listLower_18;
    @ReportItem(name = "listLower_19", length = 18, order = 76)
    public RString listLower_19;
    @ReportExpandedInfo(id = "A")
    public ExpandedInformation expandedInformation;

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
    /**
     * ReportSourceFields
     */
    @ReportItem(name = "fukaShichosonCode", length = 18, order = 77)
    public RString fukaShichosonCode;
    @ReportItem(name = "kanaMeisho", length = 100, order = 78)
    public RString kanaMeisho;
    @ReportItem(name = "choshuHoho", length = 100, order = 79)
    public RString choshuHoho;

    public enum ReportSourceFields {

        printTimeStamp,
        nendo,
        hokenshaNohokenshaName,
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
        fuchoKi1,
        fuchoKi2,
        fuchoKi3,
        fuchoKi4,
        fuchoKi5,
        fuchoKi6,
        fuchoKi7,
        fuchoKi8,
        fuchoKi9,
        fuchoKi10,
        fuchoKi11,
        fuchoKi12,
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
        listCenter_1,
        listCenter_2,
        listCenter_3,
        listCenter_4,
        listCenter_5,
        listCenter_6,
        listCenter_7,
        listCenter_8,
        listCenter_9,
        listCenter_10,
        listCenter_11,
        listCenter_12,
        listCenter_13,
        listCenter_14,
        listCenter_15,
        listCenter_16,
        listCenter_17,
        listCenter_18,
        listCenter_19,
        listCenter_20,
        listCenter_21,
        listLower_1,
        listLower_2,
        listLower_3,
        listLower_4,
        listLower_5,
        listLower_6,
        listLower_7,
        listLower_8,
        listLower_9,
        listLower_10,
        listLower_11,
        listLower_12,
        listLower_13,
        listLower_14,
        listLower_15,
        listLower_16,
        listLower_17,
        listLower_18,
        listLower_19,
        fukaShichosonCode,
        kanaMeisho,
        choshuHoho
    }
}
