// TODO: 業務に合わせてパスを変更してください
package jp.co.ndensan.reams.db.dba.entity.report.shikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

public class ShikakushashoReportSource implements IReportSource {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @ReportItem(name = "subTitle", length = 15, order = 1)
    public RString subTitle;
    @ReportItem(name = "yukoKigen", length = 18, order = 2)
    public RString yukoKigen;
    @ReportItem(name = "hihokenshaNo", length = 10, order = 3)
    public RString hihokenshaNo;
    @ReportItem(name = "jusho", order = 4)
    public RString jusho;
    @ReportItem(name = "hihokenshaNameKana", order = 5)
    public RString hihokenshaNameKana;
    @ReportItem(name = "hihokenshaName", order = 6)
    public RString hihokenshaName;
    @ReportItem(name = "birthGengoMeiji", length = 2, order = 7)
    public RString birthGengoMeiji;
    @ReportItem(name = "birthGengoTaisho", length = 2, order = 8)
    public RString birthGengoTaisho;
    @ReportItem(name = "birthGengoShowa", length = 2, order = 9)
    public RString birthGengoShowa;
    @ReportItem(name = "seibetsuMan", length = 1, order = 10)
    public RString seibetsuMan;
    @ReportItem(name = "seibetsuWoman", length = 1, order = 11)
    public RString seibetsuWoman;
    @ReportItem(name = "birthYMD", length = 11, order = 12)
    public RString birthYMD;
    @ReportItem(name = "kofuYMD", length = 11, order = 13)
    public RString kofuYMD;
    @ReportItem(name = "yokaigoJotaiKubun", length = 6, order = 14)
    public RString yokaigoJotaiKubun;
    @ReportItem(name = "ninteiYMD", length = 11, order = 15)
    public RString ninteiYMD;
    @ReportItem(name = "yukoKaishiYMD", length = 11, order = 16)
    public RString yukoKaishiYMD;
    @ReportItem(name = "yukoShuryoYMD", length = 11, order = 17)
    public RString yukoShuryoYMD;
    @ReportItem(name = "kubunShikyuTanisu", length = 7, order = 18)
    public RString kubunShikyuTanisu;
    @ReportItem(name = "kubunShikyuYukoKaishiYMD", length = 11, order = 19)
    public RString kubunShikyuYukoKaishiYMD;
    @ReportItem(name = "kubunShikyuYukoShuryoYMD", length = 11, order = 20)
    public RString kubunShikyuYukoShuryoYMD;
    @ReportItem(name = "kubunShikyuTaniShurui", length = 5, order = 21)
    public RString kubunShikyuTaniShurui;
    @ReportItem(name = "kubunShikyuTani", length = 2, order = 22)
    public RString kubunShikyuTani;
    @ReportItem(name = "shuruiShikyuServiceName1", length = 12, order = 23)
    public RString shuruiShikyuServiceName1;
    @ReportItem(name = "shuruiShikyuTnisu1", length = 7, order = 24)
    public RString shuruiShikyuTnisu1;
    @ReportItem(name = "shuruiShikyuTani1", length = 2, order = 25)
    public RString shuruiShikyuTani1;
    @ReportItem(name = "shuruiShikyuServiceName2", length = 12, order = 26)
    public RString shuruiShikyuServiceName2;
    @ReportItem(name = "shuruiShikyuTnisu2", length = 7, order = 27)
    public RString shuruiShikyuTnisu2;
    @ReportItem(name = "shuruiShikyuTani2", length = 2, order = 28)
    public RString shuruiShikyuTani2;
    @ReportItem(name = "shuruiShikyuServiceName3", length = 12, order = 29)
    public RString shuruiShikyuServiceName3;
    @ReportItem(name = "shuruiShikyuTnisu3", length = 7, order = 30)
    public RString shuruiShikyuTnisu3;
    @ReportItem(name = "shuruiShikyuTani3", length = 2, order = 31)
    public RString shuruiShikyuTani3;
    @ReportItem(name = "shuruiShikyuServiceName4", length = 12, order = 32)
    public RString shuruiShikyuServiceName4;
    @ReportItem(name = "shuruiShikyuTnisu4", length = 7, order = 33)
    public RString shuruiShikyuTnisu4;
    @ReportItem(name = "shuruiShikyuTani4", length = 2, order = 34)
    public RString shuruiShikyuTani4;
    @ReportItem(name = "shuruiShikyuServiceName5", length = 12, order = 35)
    public RString shuruiShikyuServiceName5;
    @ReportItem(name = "shuruiShikyuTnisu5", length = 7, order = 36)
    public RString shuruiShikyuTnisu5;
    @ReportItem(name = "shuruiShikyuTani5", length = 2, order = 37)
    public RString shuruiShikyuTani5;
    @ReportItem(name = "shuruiShikyuServiceName6", length = 12, order = 38)
    public RString shuruiShikyuServiceName6;
    @ReportItem(name = "shuruiShikyuTnisu6", length = 7, order = 39)
    public RString shuruiShikyuTnisu6;
    @ReportItem(name = "shuruiShikyuTani6", length = 2, order = 40)
    public RString shuruiShikyuTani6;
    @ReportItem(name = "serviceRyui", order = 41)
    public RString serviceRyui;
    @ReportItem(name = "kyufuseigenNaiyo1", order = 42)
    public RString kyufuseigenNaiyo1;
    @ReportItem(name = "kyufuseigenKaishiYMD1", length = 11, order = 43)
    public RString kyufuseigenKaishiYMD1;
    @ReportItem(name = "kyufuseigenShuryoYMD1", length = 11, order = 44)
    public RString kyufuseigenShuryoYMD1;
    @ReportItem(name = "kyufuseigenNaiyo2", order = 45)
    public RString kyufuseigenNaiyo2;
    @ReportItem(name = "kyufuseigenKaishiYMD2", length = 11, order = 46)
    public RString kyufuseigenKaishiYMD2;
    @ReportItem(name = "kyufuseigenShuryoYMD2", length = 11, order = 47)
    public RString kyufuseigenShuryoYMD2;
    @ReportItem(name = "kyufuseigenNaiyo3", order = 48)
    public RString kyufuseigenNaiyo3;
    @ReportItem(name = "kyufuseigenKaishiYMD3", length = 11, order = 49)
    public RString kyufuseigenKaishiYMD3;
    @ReportItem(name = "kyufuseigenShuryoYMD3", length = 11, order = 50)
    public RString kyufuseigenShuryoYMD3;
    @ReportItem(name = "keikakuJigyoshaName1", order = 51)
    public RString keikakuJigyoshaName1;
    @ReportItem(name = "keikakuTodokedeYMD1", length = 11, order = 52)
    public RString keikakuTodokedeYMD1;
    @ReportItem(name = "keikakuJigyoshaName2", order = 53)
    public RString keikakuJigyoshaName2;
    @ReportItem(name = "keikakuJigyoshaName2Asutarisuku", order = 54)
    public RString keikakuJigyoshaName2Asutarisuku;
    @ReportItem(name = "keikakuJigyoshaName2Masshosen", order = 55)
    public RString keikakuJigyoshaName2Masshosen;
    @ReportItem(name = "keikakuTodokedeYMD2", length = 11, order = 56)
    public RString keikakuTodokedeYMD2;
    @ReportItem(name = "keikakuTodokedeYMD2Asutarisuku", length = 16, order = 57)
    public RString keikakuTodokedeYMD2Asutarisuku;
    @ReportItem(name = "keikakuTodokedeYMD2Masshosen", length = 16, order = 58)
    public RString keikakuTodokedeYMD2Masshosen;
    @ReportItem(name = "keikakuJigyoshaName3", order = 59)
    public RString keikakuJigyoshaName3;
    @ReportItem(name = "keikakuJigyoshaName3Asutarisuku", order = 60)
    public RString keikakuJigyoshaName3Asutarisuku;
    @ReportItem(name = "keikakuJigyoshaName3Masshosen", order = 61)
    public RString keikakuJigyoshaName3Masshosen;
    @ReportItem(name = "keikakuTodokedeYMD3", length = 11, order = 62)
    public RString keikakuTodokedeYMD3;
    @ReportItem(name = "keikakuTodokedeYMD3Asutarisuku", length = 16, order = 63)
    public RString keikakuTodokedeYMD3Asutarisuku;
    @ReportItem(name = "keikakuTodokedeYMD3Masshosen", length = 16, order = 64)
    public RString keikakuTodokedeYMD3Masshosen;
    @ReportItem(name = "nyushoShisetsuShurui1", order = 65)
    public RString nyushoShisetsuShurui1;
    @ReportItem(name = "nyushoShisetsuName1", order = 66)
    public RString nyushoShisetsuName1;
    @ReportItem(name = "shisetsuNyusho1", length = 2, order = 67)
    public RString shisetsuNyusho1;
    @ReportItem(name = "shisetsuNyuin1", length = 2, order = 68)
    public RString shisetsuNyuin1;
    @ReportItem(name = "shisetsuNyushoYMD1", length = 11, order = 69)
    public RString shisetsuNyushoYMD1;
    @ReportItem(name = "shisetsuTaisho1", length = 2, order = 70)
    public RString shisetsuTaisho1;
    @ReportItem(name = "shisetsuTaiin1", length = 2, order = 71)
    public RString shisetsuTaiin1;
    @ReportItem(name = "shisetsuTaishoYMD1", length = 11, order = 72)
    public RString shisetsuTaishoYMD1;
    @ReportItem(name = "nyushoShisetsuShurui2", order = 73)
    public RString nyushoShisetsuShurui2;
    @ReportItem(name = "nyushoShisetsuName2", order = 74)
    public RString nyushoShisetsuName2;
    @ReportItem(name = "shisetsuNyusho2", length = 2, order = 75)
    public RString shisetsuNyusho2;
    @ReportItem(name = "shisetsuNyuin2", length = 2, order = 76)
    public RString shisetsuNyuin2;
    @ReportItem(name = "shisetsuNyushoYMD2", length = 11, order = 77)
    public RString shisetsuNyushoYMD2;
    @ReportItem(name = "shisetsuTaisho2", length = 2, order = 78)
    public RString shisetsuTaisho2;
    @ReportItem(name = "shisetsuTaiin2", length = 2, order = 79)
    public RString shisetsuTaiin2;
    @ReportItem(name = "shisetsuTaishoYMD2", length = 11, order = 80)
    public RString shisetsuTaishoYMD2;
    @ReportItem(name = "hokenshaNo1", length = 1, order = 81)
    public RString hokenshaNo1;
    @ReportItem(name = "hokenshaNo2", length = 1, order = 82)
    public RString hokenshaNo2;
    @ReportItem(name = "hokenshaNo3", length = 1, order = 83)
    public RString hokenshaNo3;
    @ReportItem(name = "hokenshaNo4", length = 1, order = 84)
    public RString hokenshaNo4;
    @ReportItem(name = "hokenshaNo5", length = 1, order = 85)
    public RString hokenshaNo5;
    @ReportItem(name = "hokenshaNo6", length = 1, order = 86)
    public RString hokenshaNo6;
    @ReportItem(name = "hokenshaJusho", length = 30, order = 87)
    public RString hokenshaJusho;
    @ReportItem(name = "hokenshaName", order = 88)
    public RString hokenshaName;
    @ReportItem(name = "hokenshaTelno", length = 30, order = 89)
    public RString hokenshaTelno;
    @ReportItem(name = "remban", length = 4, order = 90)
    public RString remban;
    @ReportItem(name = "denshiKoin", order = 91)
    public RString denshiKoin;
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User Customize Area">
    //追加コードは以下（「User Customize Area」内）に記述してください。
    //帳票ソースデータクラスを再作成する場合は、「User Customize Area」内のソースコードは記述されません。
    //再作成した後、当箇所に記述したコードを再作成された帳票ソースデータクラスの「User Customize Area」内にコピー＆ペーストする必要があります。
// </editor-fold>
}
