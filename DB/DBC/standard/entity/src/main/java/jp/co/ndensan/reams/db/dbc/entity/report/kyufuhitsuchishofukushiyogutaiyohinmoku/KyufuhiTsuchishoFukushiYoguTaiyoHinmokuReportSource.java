package jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のReportSourceクラスです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "hihokenshaName", length = 22, order = 1)
    public RString hihokenshaName;
    @ReportItem(name = "hokenshaNo", length = 10, order = 2)
    public RString hokenshaNo;
    @ReportItem(name = "shukeiserviceSTYM", length = 8, order = 3)
    public RString shukeiserviceSTYM;
    @ReportItem(name = "shukeiserviceEDYM", length = 8, order = 4)
    public RString shukeiserviceEDYM;
    @ReportItem(name = "tsuchibun1", length = 50, order = 5)
    public RString tsuchibun1;
    @ReportItem(name = "tsuchibun2", length = 50, order = 6)
    public RString tsuchibun2;
    @ReportItem(name = "listRiyoFukushiyogu_1", length = 8, order = 7)
    public RString listRiyoFukushiyogu_1;
    @ReportItem(name = "listRiyoFukushiyogu_2", length = 16, order = 8)
    public RString listRiyoFukushiyogu_2;
    @ReportItem(name = "listRiyoFukushiyogu_3", length = 12, order = 9)
    public RString listRiyoFukushiyogu_3;
    @ReportItem(name = "listRiyoFukushiyogu_4", length = 18, order = 10)
    public RString listRiyoFukushiyogu_4;
    @ReportItem(name = "listRiyoFukushiyogu_5", length = 11, order = 11)
    public RString listRiyoFukushiyogu_5;
    @ReportItem(name = "sankouShiryoTitle1", length = 50, order = 12)
    public RString sankouShiryoTitle1;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran1_1", length = 15, order = 13)
    public RString listSankouShiryoHiyoGakuIchiran1_1;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran1_2", length = 7, order = 14)
    public RString listSankouShiryoHiyoGakuIchiran1_2;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran1_3", length = 5, order = 15)
    public RString listSankouShiryoHiyoGakuIchiran1_3;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran1_4", length = 1, order = 16)
    public RString listSankouShiryoHiyoGakuIchiran1_4;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran1_1", length = 7, order = 17)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran1_1;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran1_2", length = 7, order = 18)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran1_2;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran1_3", length = 7, order = 19)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran1_3;
    @ReportItem(name = "sankouShiryoTitle2", length = 50, order = 20)
    public RString sankouShiryoTitle2;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran2_1", length = 15, order = 21)
    public RString listSankouShiryoHiyoGakuIchiran2_1;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran2_2", length = 7, order = 22)
    public RString listSankouShiryoHiyoGakuIchiran2_2;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran2_3", length = 5, order = 23)
    public RString listSankouShiryoHiyoGakuIchiran2_3;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran2_4", length = 1, order = 24)
    public RString listSankouShiryoHiyoGakuIchiran2_4;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran2_1", length = 7, order = 25)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran2_1;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran2_2", length = 7, order = 26)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran2_2;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran2_3", length = 7, order = 27)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran2_3;
    @ReportItem(name = "sankouShiryoTitle3", length = 50, order = 28)
    public RString sankouShiryoTitle3;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran3_1", length = 15, order = 29)
    public RString listSankouShiryoHiyoGakuIchiran3_1;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran3_2", length = 7, order = 30)
    public RString listSankouShiryoHiyoGakuIchiran3_2;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran3_3", length = 5, order = 31)
    public RString listSankouShiryoHiyoGakuIchiran3_3;
    @ReportItem(name = "listSankouShiryoHiyoGakuIchiran3_4", length = 1, order = 32)
    public RString listSankouShiryoHiyoGakuIchiran3_4;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran3_1", length = 7, order = 33)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran3_1;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran3_2", length = 7, order = 34)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran3_2;
    @ReportItem(name = "listSankouShiryoKokyoDantaiBetsuIchiran3_3", length = 7, order = 35)
    public RString listSankouShiryoKokyoDantaiBetsuIchiran3_3;
    @ReportItem(name = "tsuchibun3", length = 50, order = 36)
    public RString tsuchibun3;
    @ReportItem(name = "tsuchibun4", length = 50, order = 37)
    public RString tsuchibun4;
    @ReportItem(name = "tsuchibun5", length = 50, order = 38)
    public RString tsuchibun5;
    @ReportItem(name = "tsuchibun6", length = 50, order = 39)
    public RString tsuchibun6;
    @ReportItem(name = "tsuchibun7", length = 50, order = 40)
    public RString tsuchibun7;
    @ReportItem(name = "tsuchibun8", length = 50, order = 41)
    public RString tsuchibun8;
    @ReportItem(name = "tsuchibun9", length = 50, order = 42)
    public RString tsuchibun9;
    @ReportItem(name = "tsuchibun10", length = 50, order = 43)
    public RString tsuchibun10;
    @ReportItem(name = "tsuchibun11", length = 50, order = 44)
    public RString tsuchibun11;
    @ReportItem(name = "tsuchibun12", length = 50, order = 45)
    public RString tsuchibun12;
    @ReportItem(name = "tsuchibun13", length = 50, order = 46)
    public RString tsuchibun13;
    @ReportItem(name = "pageBunshi", length = 3, order = 47)
    public RString pageBunshi;
    @ReportItem(name = "pageBunbo", length = 3, order = 48)
    public RString pageBunbo;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
