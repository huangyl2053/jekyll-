/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportExpandedInfo;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;
import jp.co.ndensan.reams.uz.uza.report.source.ReportPerson;

/**
 * 帳票設計_DBCMNN1004_事業分支給額計算 のソースクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
public class GassanJigyobunKekkaIchiranSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shori_ymd_hms", length = 34, order = 1)
    public RString shori_ymd_hms;
    @ReportItem(name = "Data1", length = 25, order = 2)
    public RString Data1;
    @ReportItem(name = "Data2", length = 25, order = 3)
    public RString Data2;
    @ReportItem(name = "city_cd", length = 6, order = 4)
    public RString city_cd;
    @ReportItem(name = "city_mei", length = 12, order = 5)
    public RString city_mei;
    @ReportItem(name = "sort_jun_area1", length = 10, order = 6)
    public RString sort_jun_area1;
    @ReportItem(name = "sort_jun_area2", length = 10, order = 7)
    public RString sort_jun_area2;
    @ReportItem(name = "sort_jun_area3", length = 10, order = 8)
    public RString sort_jun_area3;
    @ReportItem(name = "sort_jun_area4", length = 10, order = 9)
    public RString sort_jun_area4;
    @ReportItem(name = "sort_jun_area5", length = 10, order = 10)
    public RString sort_jun_area5;
    @ReportItem(name = "kai_page_area1", length = 20, order = 11)
    public RString kai_page_area1;
    @ReportItem(name = "kai_page_area2", length = 20, order = 12)
    public RString kai_page_area2;
    @ReportItem(name = "kai_page_area3", length = 20, order = 13)
    public RString kai_page_area3;
    @ReportItem(name = "kai_page_area4", length = 20, order = 14)
    public RString kai_page_area4;
    @ReportItem(name = "kai_page_area5", length = 20, order = 15)
    public RString kai_page_area5;
    @ReportExpandedInfo(id = "A")
    @ReportItem(name = "List1_1", length = 10, order = 16)
    public RString List1_1;
    @ReportItem(name = "List1_2", length = 10, order = 17)
    public RString List1_2;
    @ReportItem(name = "List1_3", length = 17, order = 18)
    public RString List1_3;
    @ReportItem(name = "List1_4", length = 3, order = 19)
    public RString List1_4;
    @ReportItem(name = "List1_5", length = 13, order = 20)
    public RString List1_5;
    @ReportItem(name = "List1_6", length = 13, order = 21)
    public RString List1_6;
    @ReportItem(name = "List1_7", length = 13, order = 22)
    public RString List1_7;
    @ReportItem(name = "List1_8", length = 9, order = 23)
    public RString List1_8;
    @ReportItem(name = "List1_9", length = 7, order = 24)
    public RString List1_9;
    @ReportItem(name = "List1_10", length = 13, order = 25)
    public RString List1_10;
    @ReportItem(name = "List1_11", length = 13, order = 26)
    public RString List1_11;
    @ReportItem(name = "List1_12", length = 13, order = 27)
    public RString List1_12;
    @ReportItem(name = "List1_13", length = 13, order = 28)
    public RString List1_13;
    @ReportItem(name = "List1_14", length = 20, order = 29)
    public RString List1_14;
    @ReportItem(name = "List1_15", length = 2, order = 30)
    public RString List1_15;
    @ReportPerson(id = "A")
    @ReportItem(name = "shikibetsuCode", length = 15)
    public RString shikibetsuCode;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。

    @ReportItem(name = "yubinNo", length = 16)
    public RString yubinNo;
    @ReportItem(name = "taishoNendo", length = 17)
    public RString taishoNendo;
    @ReportItem(name = "gyoseiCode", length = 18)
    public RString gyoseiCode;
    @ReportItem(name = "jushoCode", length = 19)
    public RString jushoCode;
    @ReportItem(name = "shichosonCode", length = 20)
    public RString shichosonCode;
    @ReportItem(name = "shoKisaiHokenshaNo", length = 21)
    public RString shoKisaiHokenshaNo;

// </editor-fold>
}
