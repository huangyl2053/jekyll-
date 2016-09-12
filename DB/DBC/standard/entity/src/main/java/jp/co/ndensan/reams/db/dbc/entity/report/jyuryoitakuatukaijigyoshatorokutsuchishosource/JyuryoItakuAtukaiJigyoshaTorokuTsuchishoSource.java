/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC100032_介護保険受領委任払い取扱事業者登録通知書のReportSourceクラスです。
 *
 * @reamsid_L DBC-2120-050 sunhui
 */
public class JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "bunshoNo", length = 36, order = 1)
    public RString bunshoNo;
    @ReportItem(name = "sofusakiYubinNo", length = 8, order = 2)
    public RString sofusakiYubinNo;
    @ReportItem(name = "sofusakiJusho", order = 3)
    public RString sofusakiJusho;
    @ReportItem(name = "sofusakiMeisho", order = 4)
    public RString sofusakiMeisho;
    @ReportItem(name = "sofusakiBusho", order = 5)
    public RString sofusakiBusho;
    @ReportItem(name = "barcodeSofusaki", order = 6)
    public RString barcodeSofusaki;
    @ReportItem(name = "tsuchiBun1", order = 7)
    public RString tsuchiBun1;
    @ReportItem(name = "jigyoshoName", order = 8)
    public RString jigyoshoName;
    @ReportItem(name = "jigyoshoYubinNo", length = 8, order = 9)
    public RString jigyoshoYubinNo;
    @ReportItem(name = "jigyoshoJusho", order = 10)
    public RString jigyoshoJusho;
    @ReportItem(name = "jigyoshoTelNo", length = 20, order = 11)
    public RString jigyoshoTelNo;
    @ReportItem(name = "jigyoshoTorokuNo", length = 10, order = 12)
    public RString jigyoshoTorokuNo;
    @ReportItem(name = "serviceShurui", length = 20, order = 13)
    public RString serviceShurui;
    @ReportItem(name = "keiyakuKikanKaishiYmd", length = 11, order = 14)
    public RString keiyakuKikanKaishiYmd;
    @ReportItem(name = "keiyakuKikanKara", length = 1, order = 15)
    public RString keiyakuKikanKara;
    @ReportItem(name = "keiyakuKikanShuryoYmd", length = 11, order = 16)
    public RString keiyakuKikanShuryoYmd;
    @ReportItem(name = "tsuchiBun2", order = 17)
    public RString tsuchiBun2;
    @ReportItem(name = "hakkoYMD", length = 12, order = 18)
    public RString hakkoYMD;
    @ReportItem(name = "ninshoshaYakushokuMei", length = 15, order = 19)
    public RString ninshoshaYakushokuMei;
    @ReportItem(name = "denshiKoin", order = 20)
    public RString denshiKoin;
    @ReportItem(name = "koinMojiretsu", length = 4, order = 21)
    public RString koinMojiretsu;
    @ReportItem(name = "ninshoshaShimeiKakenai", order = 22)
    public RString ninshoshaShimeiKakenai;
    @ReportItem(name = "ninshoshaShimeiKakeru", order = 23)
    public RString ninshoshaShimeiKakeru;
    @ReportItem(name = "koinShoryaku", length = 15, order = 24)
    public RString koinShoryaku;
    @ReportItem(name = "yubinBango", length = 8, order = 25)
    public RString yubinBango;
    @ReportItem(name = "shozaichi", order = 26)
    public RString shozaichi;
    @ReportItem(name = "choshaBushoName", order = 27)
    public RString choshaBushoName;
    @ReportItem(name = "tantoName", order = 28)
    public RString tantoName;
    @ReportItem(name = "telNo", length = 20, order = 29)
    public RString telNo;
    @ReportItem(name = "naisenLabel", length = 4, order = 30)
    public RString naisenLabel;
    @ReportItem(name = "naisenNo", length = 20, order = 31)
    public RString naisenNo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
