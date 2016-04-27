/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "title", length = 20, order = 1)
    public RString title;
    @ReportItem(name = "gogitaiName", length = 20, order = 2)
    public RString gogitaiName;
    @ReportItem(name = "kaisaiKaishiYMD", length = 13, order = 3)
    public RString kaisaiKaishiYMD;
    @ReportItem(name = "kaisaiShuryoYMD", length = 13, order = 4)
    public RString kaisaiShuryoYMD;
    @ReportItem(name = "kaisaiCount", length = 4, order = 5)
    public RString kaisaiCount;
    @ReportItem(name = "hokenshaNo", length = 6, order = 6)
    public RString hokenshaNo;
    @ReportItem(name = "printTimeStamp", length = 34, order = 7)
    public RString printTimeStamp;
    @ReportItem(name = "hokenshaName", length = 20, order = 8)
    public RString hokenshaName;
    @ReportItem(name = "listHanteiHeader_1", length = 8, order = 9)
    public RString listHanteiHeader_1;
    @ReportItem(name = "listHanteiHeader_2", length = 8, order = 10)
    public RString listHanteiHeader_2;
    @ReportItem(name = "listHanteiHeader_3", length = 8, order = 11)
    public RString listHanteiHeader_3;
    @ReportItem(name = "listHanteiHeader_4", length = 8, order = 12)
    public RString listHanteiHeader_4;
    @ReportItem(name = "listHanteiHeader_5", length = 8, order = 13)
    public RString listHanteiHeader_5;
    @ReportItem(name = "listHanteiHeader_6", length = 8, order = 14)
    public RString listHanteiHeader_6;
    @ReportItem(name = "listHanteiHeader_7", length = 8, order = 15)
    public RString listHanteiHeader_7;
    @ReportItem(name = "listHanteiHeader_8", length = 8, order = 16)
    public RString listHanteiHeader_8;
    @ReportItem(name = "listHanteiHeader_9", length = 8, order = 17)
    public RString listHanteiHeader_9;
    @ReportItem(name = "listHantei_1", length = 12, order = 18)
    public RString listHantei_1;
    @ReportItem(name = "listHantei_2", length = 5, order = 19)
    public RString listHantei_2;
    @ReportItem(name = "listHantei_3", length = 5, order = 20)
    public RString listHantei_3;
    @ReportItem(name = "listHantei_4", length = 5, order = 21)
    public RString listHantei_4;
    @ReportItem(name = "listHantei_5", length = 5, order = 22)
    public RString listHantei_5;
    @ReportItem(name = "listHantei_6", length = 5, order = 23)
    public RString listHantei_6;
    @ReportItem(name = "listHantei_7", length = 5, order = 24)
    public RString listHantei_7;
    @ReportItem(name = "listHantei_8", length = 5, order = 25)
    public RString listHantei_8;
    @ReportItem(name = "listHantei_9", length = 5, order = 26)
    public RString listHantei_9;
    @ReportItem(name = "listHantei_10", length = 5, order = 27)
    public RString listHantei_10;
    @ReportItem(name = "listHantei_11", length = 5, order = 28)
    public RString listHantei_11;
    @ReportItem(name = "listHantei_12", length = 5, order = 29)
    public RString listHantei_12;
    @ReportItem(name = "listHantei_13", length = 5, order = 30)
    public RString listHantei_13;
    @ReportItem(name = "listHantei_14", length = 5, order = 31)
    public RString listHantei_14;
    @ReportItem(name = "listHantei_15", length = 5, order = 32)
    public RString listHantei_15;
    @ReportItem(name = "listHanteiKensu_1", length = 5, order = 33)
    public RString listHanteiKensu_1;
    @ReportItem(name = "listHanteiKensu_2", length = 5, order = 34)
    public RString listHanteiKensu_2;
    @ReportItem(name = "listHanteiKensu_3", length = 5, order = 35)
    public RString listHanteiKensu_3;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>

    /**
     * 介護認定審査会判定状況表改ページ条件クラスです。
     *
     */
    public enum ReportSourceFields {

        hokenshaNo,
        gogitaiName
    }
}
