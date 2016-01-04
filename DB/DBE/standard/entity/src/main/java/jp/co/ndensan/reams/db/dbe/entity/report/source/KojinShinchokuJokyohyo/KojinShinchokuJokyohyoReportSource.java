/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.KojinShinchokuJokyohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 要介護認定個人進捗状況票Sourceクラスです。
 */
public class KojinShinchokuJokyohyoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "printTimeStamp", length = 34, order = 1)
    public RString printTimeStamp;
    @ReportItem(name = "title", length = 50, order = 2)
    public RString title;
    @ReportItem(name = "hihokenshaNo1", length = 1, order = 3)
    public RString hihokenshaNo1;
    @ReportItem(name = "hihokenshaNo2", length = 1, order = 4)
    public RString hihokenshaNo2;
    @ReportItem(name = "hihokenshaNo3", length = 1, order = 5)
    public RString hihokenshaNo3;
    @ReportItem(name = "hihokenshaNo4", length = 1, order = 6)
    public RString hihokenshaNo4;
    @ReportItem(name = "hihokenshaNo5", length = 1, order = 7)
    public RString hihokenshaNo5;
    @ReportItem(name = "hihokenshaNo6", length = 1, order = 8)
    public RString hihokenshaNo6;
    @ReportItem(name = "hihokenshaNo7", length = 1, order = 9)
    public RString hihokenshaNo7;
    @ReportItem(name = "hihokenshaNo8", length = 1, order = 10)
    public RString hihokenshaNo8;
    @ReportItem(name = "hihokenshaNo9", length = 1, order = 11)
    public RString hihokenshaNo9;
    @ReportItem(name = "hihokenshaNo10", length = 1, order = 12)
    public RString hihokenshaNo10;
    @ReportItem(name = "shinseiKubun", length = 34, order = 13)
    public RString shinseiKubun;
    @ReportItem(name = "hihokenshaNameKana", order = 14)
    public RString hihokenshaNameKana;
    @ReportItem(name = "shinseiYMD", length = 16, order = 15)
    public RString shinseiYMD;
    @ReportItem(name = "seibetsu", length = 2, order = 16)
    public RString seibetsu;
    @ReportItem(name = "hihokenshaName", order = 17)
    public RString hihokenshaName;
    @ReportItem(name = "birthYMD", length = 16, order = 18)
    public RString birthYMD;
    @ReportItem(name = "age", length = 3, order = 19)
    public RString age;
    @ReportItem(name = "yubinNo1", length = 10, order = 20)
    public RString yubinNo1;
    @ReportItem(name = "hihokenshaJusho", order = 21)
    public RString hihokenshaJusho;
    @ReportItem(name = "telNo1", length = 13, order = 22)
    public RString telNo1;
    @ReportItem(name = "shinseiRiyu", length = 78, order = 23)
    public RString shinseiRiyu;
    @ReportItem(name = "shinseishaName", length = 22, order = 24)
    public RString shinseishaName;
    @ReportItem(name = "shinseiDaikoJigyoshaName", length = 38, order = 25)
    public RString shinseiDaikoJigyoshaName;
    @ReportItem(name = "shinseishaKankei", length = 30, order = 26)
    public RString shinseishaKankei;
    @ReportItem(name = "honninKankei", length = 32, order = 27)
    public RString honninKankei;
    @ReportItem(name = "yubinNo2", length = 10, order = 28)
    public RString yubinNo2;
    @ReportItem(name = "shinseishaJusho", order = 29)
    public RString shinseishaJusho;
    @ReportItem(name = "telNo2", length = 13, order = 30)
    public RString telNo2;
    @ReportItem(name = "shisetsuName", length = 68, order = 31)
    public RString shisetsuName;
    @ReportItem(name = "shisetsujusho", order = 32)
    public RString shisetsujusho;
    @ReportItem(name = "telNo3", length = 13, order = 33)
    public RString telNo3;
    @ReportItem(name = "listChosain_1", length = 20, order = 34)
    public RString listChosain_1;
    @ReportItem(name = "listChosain_2", length = 20, order = 35)
    public RString listChosain_2;
    @ReportItem(name = "listChosain_3", length = 20, order = 36)
    public RString listChosain_3;
    @ReportItem(name = "listShujii_1", length = 20, order = 37)
    public RString listShujii_1;
    @ReportItem(name = "listShujii_2", length = 20, order = 38)
    public RString listShujii_2;
    @ReportItem(name = "listShujii_3", length = 20, order = 39)
    public RString listShujii_3;
    @ReportItem(name = "listJokyo_1", length = 2, order = 40)
    public RString listJokyo_1;
    @ReportItem(name = "listJokyo_2", length = 20, order = 41)
    public RString listJokyo_2;
    @ReportItem(name = "listJokyo_3", length = 16, order = 42)
    public RString listJokyo_3;
    @ReportItem(name = "listJokyo_4", length = 16, order = 43)
    public RString listJokyo_4;
    @ReportItem(name = "listJokyo_5", length = 16, order = 44)
    public RString listJokyo_5;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
