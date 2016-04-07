/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 被保険者台帳のReportSourceです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 50, order = 2)
    public RString title;
    @ReportItem(name = "shichosonCode", length = 6, order = 3)
    public RString shichosonCode;
    @ReportItem(name = "shichosonName", length = 12, order = 4)
    public RString shichosonName;
    @ReportItem(name = "hihokenshaNoTitle", length = 12, order = 5)
    public RString hihokenshaNoTitle;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 6)
    public RString hihokenshaNo;
    @ReportItem(name = "shimeiKana", order = 7)
    public RString shimeiKana;
    @ReportItem(name = "birthYMD", length = 10, order = 8)
    public RString birthYMD;
    @ReportItem(name = "seibetsu", length = 2, order = 9)
    public RString seibetsu;
    @ReportItem(name = "setaiCode", length = 15, order = 10)
    public RString setaiCode;
    @ReportItem(name = "shikibetsuCode", length = 15, order = 11)
    public RString shikibetsuCode;
    @ReportItem(name = "shimei", order = 12)
    public RString shimei;
    @ReportItem(name = "chiku1CodeTitle", length = 10, order = 13)
    public RString chiku1CodeTitle;
    @ReportItem(name = "chiku1Code", length = 8, order = 14)
    public RString chiku1Code;
    @ReportItem(name = "jotai", length = 14, order = 15)
    public RString jotai;
    @ReportItem(name = "telNoTitle", length = 12, order = 16)
    public RString telNoTitle;
    @ReportItem(name = "jusho", order = 17)
    public RString jusho;
    @ReportItem(name = "chiku2CodeTitle", length = 10, order = 18)
    public RString chiku2CodeTitle;
    @ReportItem(name = "chiku2Code", length = 8, order = 19)
    public RString chiku2Code;
    @ReportItem(name = "telNo1", length = 14, order = 20)
    public RString telNo1;
    @ReportItem(name = "jushoTitle", length = 10, order = 21)
    public RString jushoTitle;
    @ReportItem(name = "telNo2", length = 14, order = 22)
    public RString telNo2;
    @ReportItem(name = "chiku3CodeTitle", length = 10, order = 23)
    public RString chiku3CodeTitle;
    @ReportItem(name = "chiku3Code", length = 8, order = 24)
    public RString chiku3Code;
    @ReportItem(name = "gyoseikuTitle", length = 10, order = 25)
    public RString gyoseikuTitle;
    @ReportItem(name = "jushoCode", length = 11, order = 26)
    public RString jushoCode;
    @ReportItem(name = "gyoseikuCode", length = 9, order = 27)
    public RString gyoseikuCode;
    @ReportItem(name = "jigyoshaNo", length = 10, order = 28)
    public RString jigyoshaNo;
    @ReportItem(name = "jigyoshaName", length = 48, order = 29)
    public RString jigyoshaName;
    @ReportItem(name = "kigoNo", length = 60, order = 30)
    public RString kigoNo;
    @ReportItem(name = "iryohokenShubetsu", length = 8, order = 31)
    public RString iryohokenShubetsu;
    @ReportItem(name = "iryohokenshaName", length = 40, order = 32)
    public RString iryohokenshaName;
    @ReportItem(name = "sochiHokensha", length = 13, order = 33)
    public RString sochiHokensha;
    @ReportItem(name = "kyuHokensha", length = 13, order = 34)
    public RString kyuHokensha;
    @ReportItem(name = "listShikakuIdo_1", length = 2, order = 35)
    public RString listShikakuIdo_1;
    @ReportItem(name = "listShikakuIdo_2", length = 10, order = 36)
    public RString listShikakuIdo_2;
    @ReportItem(name = "listShikakuIdo_3", length = 2, order = 37)
    public RString listShikakuIdo_3;
    @ReportItem(name = "listShikakuIdo_4", length = 12, order = 38)
    public RString listShikakuIdo_4;
    @ReportItem(name = "listShikakuIdo_5", length = 10, order = 39)
    public RString listShikakuIdo_5;
    @ReportItem(name = "listShikakuIdo_6", length = 10, order = 40)
    public RString listShikakuIdo_6;
    @ReportItem(name = "listShikakuIdo_7", length = 2, order = 41)
    public RString listShikakuIdo_7;
    @ReportItem(name = "listShikakuIdo_8", length = 12, order = 42)
    public RString listShikakuIdo_8;
    @ReportItem(name = "listShikakuIdo_9", length = 2, order = 43)
    public RString listShikakuIdo_9;
    @ReportItem(name = "listShikakuIdo_10", length = 10, order = 44)
    public RString listShikakuIdo_10;
    @ReportItem(name = "listShikakuIdo_11", length = 2, order = 45)
    public RString listShikakuIdo_11;
    @ReportItem(name = "listShikakuIdo_12", length = 12, order = 46)
    public RString listShikakuIdo_12;
    @ReportItem(name = "listShikakuIdo_13", length = 10, order = 47)
    public RString listShikakuIdo_13;
    @ReportItem(name = "listShikakuIdo_14", length = 10, order = 48)
    public RString listShikakuIdo_14;
    @ReportItem(name = "listShikakuIdo_15", length = 12, order = 49)
    public RString listShikakuIdo_15;
    @ReportItem(name = "listShikakuIdo_16", length = 12, order = 50)
    public RString listShikakuIdo_16;
    @ReportItem(name = "listSeikatsuhogo_1", length = 2, order = 51)
    public RString listSeikatsuhogo_1;
    @ReportItem(name = "listSeikatsuhogo_2", length = 10, order = 52)
    public RString listSeikatsuhogo_2;
    @ReportItem(name = "listSeikatsuhogo_3", length = 10, order = 53)
    public RString listSeikatsuhogo_3;
    @ReportItem(name = "listSeikatsuhogo_4", length = 10, order = 54)
    public RString listSeikatsuhogo_4;
    @ReportItem(name = "listSeikatsuhogo_5", length = 10, order = 55)
    public RString listSeikatsuhogo_5;
    @ReportItem(name = "listSeikatsuhogo_6", length = 40, order = 56)
    public RString listSeikatsuhogo_6;
    @ReportItem(name = "listRoreiFukushi_1", length = 2, order = 57)
    public RString listRoreiFukushi_1;
    @ReportItem(name = "listRoreiFukushi_2", length = 10, order = 58)
    public RString listRoreiFukushi_2;
    @ReportItem(name = "listRoreiFukushi_3", length = 10, order = 59)
    public RString listRoreiFukushi_3;
    @ReportItem(name = "listShoRireki1_1", length = 2, order = 60)
    public RString listShoRireki1_1;
    @ReportItem(name = "listShoRireki1_2", length = 10, order = 61)
    public RString listShoRireki1_2;
    @ReportItem(name = "listShoRireki1_3", length = 8, order = 62)
    public RString listShoRireki1_3;
    @ReportItem(name = "listShoRireki1_4", length = 10, order = 63)
    public RString listShoRireki1_4;
    @ReportItem(name = "listShoRireki2_1", length = 2, order = 64)
    public RString listShoRireki2_1;
    @ReportItem(name = "listShoRireki2_2", length = 10, order = 65)
    public RString listShoRireki2_2;
    @ReportItem(name = "listShoRireki2_3", length = 8, order = 66)
    public RString listShoRireki2_3;
    @ReportItem(name = "listShoRireki2_4", length = 10, order = 67)
    public RString listShoRireki2_4;
    @ReportItem(name = "listSetaiLeft_1", length = 2, order = 68)
    public RString listSetaiLeft_1;
    @ReportItem(name = "listSetaiLeft_2", length = 12, order = 69)
    public RString listSetaiLeft_2;
    @ReportItem(name = "setaiinShimei1", order = 70)
    public RString setaiinShimei1;
    @ReportItem(name = "listSetaiRight_1", length = 2, order = 71)
    public RString listSetaiRight_1;
    @ReportItem(name = "listSetaiRight_2", length = 10, order = 72)
    public RString listSetaiRight_2;
    @ReportItem(name = "listSetaiRight_3", length = 3, order = 73)
    public RString listSetaiRight_3;
    @ReportItem(name = "listSetaiRight_4", length = 10, order = 74)
    public RString listSetaiRight_4;
    @ReportItem(name = "setaiinShimei2", order = 75)
    public RString setaiinShimei2;
    @ReportItem(name = "setaiinShimei3", order = 76)
    public RString setaiinShimei3;
    @ReportItem(name = "setaiinShimei4", order = 77)
    public RString setaiinShimei4;
    @ReportItem(name = "setaiinShimei5", order = 78)
    public RString setaiinShimei5;
    @ReportItem(name = "junno", length = 6, order = 79)
    public RString junno;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
