/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.KyufuseigenBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.NyushoShisetsuBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuBusiness;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険資格者証の帳票出力用のビジネスです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShikakushashoDataBusiness {

    private RString yukoKigen;
    private RString hihokenshaNo;
    private RString jusho;
    private RString hihokenshaNameKana;
    private RString hihokenshaName;
    private RString birthGengoMeiji;
    private RString birthGengoTaisho;
    private RString birthGengoShowa;
    private RString birthYMD;
    private RString seibetsu;
    private RString kofuYMD;
    private RString yokaigoJotaiKubun;
    private RString ninteiYMD;
    private RString yukoKaishiYMD;
    private RString yukoShuryoYMD;
    private RString kubunShikyuYukoKaishiYMD;
    private RString kubunShikyuYukoShuryoYMD;
    private RString kizyunngaku;
    private RString taniShurui;
    private RString tani;
    private List<ShuruiShikyuGendoKizyunngakuBusiness> shikyuGendoKizyungakuList;
    private RString serviceShitei;
    private List<KyufuseigenBusiness> kyufuseigenDataList;
    private RString jigyoshaName1;
    private RString todokedeYMD1;
    private RString jigyoshaName2;
    private RString jigyoshaName2Asutarisuku;
    private RString jigyoshaName2Masshosen;
    private RString todokedeYMD2;
    private RString todokedeYMD2Asutarisuku;
    private RString todokedeYMD2Masshosen;
    private RString jigyoshaName3;
    private RString jigyoshaName3Asutarisuku;
    private RString jigyoshaName3Masshosen;
    private RString todokedeYMD3;
    private RString todokedeYMD3Asutarisuku;
    private RString todokedeYMD3Masshosen;
    private RString nyushoShisetsuShurui;
    private List<NyushoShisetsuBusiness> nyushoShisetsuDataList;
    private RString shisetsuNyusho;
    private RString shisetsuNyuin;
    private RString shisetsuTaisho;
    private RString shisetsuTaiin;
    private RString hokenshaNo;
    private RString hokenshaJusho;
    private RString hokenshaName;
    private RString hokenshaTelno;
    private RString denshiKoin;
    private RString remban;
    private RString subTitle;
}
