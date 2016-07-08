package jp.co.ndensan.reams.db.dbe.entity.report.source.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書のReportSourceクラスです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
public class HiyobenshotoShiharaimeisaishoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "shinsainName1", length = 20, order = 1)
    public RString shinsainName1;
    @ReportItem(name = "shinsainName2", length = 20, order = 2)
    public RString shinsainName2;
    @ReportItem(name = "hoshuhi1", length = 10, order = 3)
    public RString hoshuhi1;
    @ReportItem(name = "hoshuhi2", length = 10, order = 4)
    public RString hoshuhi2;
    @ReportItem(name = "hiyobensho1", length = 10, order = 5)
    public RString hiyobensho1;
    @ReportItem(name = "hiyobensho2", length = 10, order = 6)
    public RString hiyobensho2;
    @ReportItem(name = "shokeiKingaku1", length = 10, order = 7)
    public RString shokeiKingaku1;
    @ReportItem(name = "shokeiKingaku2", length = 10, order = 8)
    public RString shokeiKingaku2;
    @ReportItem(name = "gensenShotokuzei1", length = 10, order = 9)
    public RString gensenShotokuzei1;
    @ReportItem(name = "gensenShotokuzei2", length = 10, order = 10)
    public RString gensenShotokuzei2;
    @ReportItem(name = "sashihikishikyugaku1", length = 10, order = 11)
    public RString sashihikishikyugaku1;
    @ReportItem(name = "sashihikishikyugaku2", length = 10, order = 12)
    public RString sashihikishikyugaku2;
    @ReportItem(name = "kinyukikanName1", length = 20, order = 13)
    public RString kinyukikanName1;
    @ReportItem(name = "shitenName1", length = 20, order = 14)
    public RString shitenName1;
    @ReportItem(name = "kinyukikanName2", length = 20, order = 15)
    public RString kinyukikanName2;
    @ReportItem(name = "shitenName2", length = 20, order = 16)
    public RString shitenName2;
    @ReportItem(name = "kozaShubetsu1", length = 6, order = 17)
    public RString kozaShubetsu1;
    @ReportItem(name = "kozaBango1", length = 10, order = 18)
    public RString kozaBango1;
    @ReportItem(name = "kozaShubetsu2", length = 6, order = 19)
    public RString kozaShubetsu2;
    @ReportItem(name = "kozaBango2", length = 10, order = 20)
    public RString kozaBango2;
    @ReportItem(name = "furikomiyoteiYMD1", length = 11, order = 21)
    public RString furikomiyoteiYMD1;
    @ReportItem(name = "furikomiyoteiYMD2", length = 11, order = 22)
    public RString furikomiyoteiYMD2;
    @ReportItem(name = "shinsaKikan1", length = 18, order = 23)
    public RString shinsaKikan1;
    @ReportItem(name = "shinsaKikan2", length = 18, order = 24)
    public RString shinsaKikan2;
    @ReportItem(name = "shussekiKaisu1", length = 15, order = 25)
    public RString shussekiKaisu1;
    @ReportItem(name = "shussekiKaisu2", length = 15, order = 26)
    public RString shussekiKaisu2;
    @ReportItem(name = "shichosonName2", length = 15, order = 27)
    public RString shichosonName2;
    @ReportItem(name = "shichosonName1", length = 15, order = 28)
    public RString shichosonName1;
    @ReportItem(name = "shinsainName3", length = 20, order = 29)
    public RString shinsainName3;
    @ReportItem(name = "shinsainName4", length = 20, order = 30)
    public RString shinsainName4;
    @ReportItem(name = "hoshuhi3", length = 10, order = 31)
    public RString hoshuhi3;
    @ReportItem(name = "hoshuhi4", length = 10, order = 32)
    public RString hoshuhi4;
    @ReportItem(name = "hiyobensho3", length = 10, order = 33)
    public RString hiyobensho3;
    @ReportItem(name = "hiyobensho4", length = 10, order = 34)
    public RString hiyobensho4;
    @ReportItem(name = "shokeiKingaku3", length = 10, order = 35)
    public RString shokeiKingaku3;
    @ReportItem(name = "shokeiKingaku4", length = 10, order = 36)
    public RString shokeiKingaku4;
    @ReportItem(name = "gensenShotokuzei3", length = 10, order = 37)
    public RString gensenShotokuzei3;
    @ReportItem(name = "gensenShotokuzei4", length = 10, order = 38)
    public RString gensenShotokuzei4;
    @ReportItem(name = "sashihikishikyugaku3", length = 10, order = 39)
    public RString sashihikishikyugaku3;
    @ReportItem(name = "sashihikishikyugaku4", length = 10, order = 40)
    public RString sashihikishikyugaku4;
    @ReportItem(name = "kinyukikanName3", length = 20, order = 41)
    public RString kinyukikanName3;
    @ReportItem(name = "shitenName3", length = 20, order = 42)
    public RString shitenName3;
    @ReportItem(name = "kinyukikanName4", length = 20, order = 43)
    public RString kinyukikanName4;
    @ReportItem(name = "shitenName4", length = 20, order = 44)
    public RString shitenName4;
    @ReportItem(name = "kozaShubetsu3", length = 6, order = 45)
    public RString kozaShubetsu3;
    @ReportItem(name = "kozaBango3", length = 10, order = 46)
    public RString kozaBango3;
    @ReportItem(name = "kozaShubetsu4", length = 6, order = 47)
    public RString kozaShubetsu4;
    @ReportItem(name = "kozaBango4", length = 10, order = 48)
    public RString kozaBango4;
    @ReportItem(name = "furikomiyoteiYMD3", length = 11, order = 49)
    public RString furikomiyoteiYMD3;
    @ReportItem(name = "furikomiyoteiYMD4", length = 11, order = 50)
    public RString furikomiyoteiYMD4;
    @ReportItem(name = "shinsaKikan3", length = 18, order = 51)
    public RString shinsaKikan3;
    @ReportItem(name = "shinsaKikan4", length = 18, order = 52)
    public RString shinsaKikan4;
    @ReportItem(name = "shussekiKaisu3", length = 15, order = 53)
    public RString shussekiKaisu3;
    @ReportItem(name = "shussekiKaisu4", length = 15, order = 54)
    public RString shussekiKaisu4;
    @ReportItem(name = "shichosonName3", length = 15, order = 55)
    public RString shichosonName3;
    @ReportItem(name = "shichosonName4", length = 15, order = 56)
    public RString shichosonName4;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
