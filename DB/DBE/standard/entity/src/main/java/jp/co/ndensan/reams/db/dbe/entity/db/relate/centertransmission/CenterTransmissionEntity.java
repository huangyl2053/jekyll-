/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * センター送信データのentityクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private FlexibleDate ninteiShinseiYMD;
    private EdabanCode ninteiShinseiEdabanCode;
    private Code ninteiShinseiHoreiKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code torisageKubunCode;
    private RString hihokenshaKubunCode;
    private Code shinseiTodokedeDaikoKubunCode;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private AtenaMeisho jigyoshaName;
    private AtenaJusho jigyoshaAddress;
    private Code zenYokaigoKubunCode;
    private FlexibleDate zenkaiYukoKikanStart;
    private FlexibleDate zenkaiYukoKikanEnd;
    private ShujiiIryokikanCode shujiiIryokikanCode;
    private ShujiiCode shujiiCode;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoJuryoYMD;
    private RString ikenItemKoban14;
    private RString ikenItemKoban15;
    private RString ikenItemKoban16;
    private RString ikenItemKoban17;
    private RString ikenItemKoban18;
    private RString ikenItemKoban19;
    private RString ikenItemKoban69;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaJisshiYMD;
    private JigyoshaNo jigyoshaNo;
    private RString chosaItakuKubun;
    private RString ninteiChosainCode;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private int kijunJikan;
    private int kijunJikanShokuji;
    private int kijunJikanHaisetsu;
    private int kijunJikanIdo;
    private int kijunJikanSeiketsuHoji;
    private int kijunJikanKansetsuCare;
    private int kijunJikanBPSDKanren;
    private int kijunJikanKinoKunren;
    private int kijunJikanIryoKanren;
    private int kijunJikanNinchishoKasan;
    private int chukanHyokaKomoku1gun;
    private int chukanHyokaKomoku2gun;
    private int chukanHyokaKomoku3gun;
    private int chukanHyokaKomoku4gun;
    private int chukanHyokaKomoku5gun;
    private RString ichijiHnateiKeikokuCode;
    private Code jotaiAnteiseiCode;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code suiteiKyufuKubunCode;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private int gogitaiNo;
    private FlexibleDate nijiHanteiYMD;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private Code nigoTokuteiShippeiCode;
    private Code yokaigoJotaizoReiCode;
    private Code serviceKubunCode;
    private int remban;
    private int serviceJokyoKoban1;
    private int serviceJokyoKoban2;
    private int serviceJokyoKoban3;
    private int serviceJokyoKoban4;
    private int serviceJokyoKoban5;
    private int serviceJokyoKoban6;
    private int serviceJokyoKoban7;
    private int serviceJokyoKoban8;
    private int serviceJokyoKoban9;
    private int serviceJokyoKoban10;
    private int serviceJokyoKoban11;
    private int serviceJokyoKoban12;
    private int serviceJokyoKoban13;
    private int serviceJokyoKoban14;
    private int serviceJokyoKoban15;
    private int serviceJokyoKoban16;
    private int serviceJokyoKoban17;
    private int serviceJokyoKoban18;
    private int serviceJokyoKoban19;
    private int serviceJokyoKoban20;
    private boolean serviceJokyoFlag;
    private RString chosaItemKoban1;
    private RString chosaItemKoban2;
    private RString chosaItemKoban3;
    private RString chosaItemKoban4;
    private RString chosaItemKoban5;
    private RString chosaItemKoban6;
    private RString chosaItemKoban7;
    private RString chosaItemKoban8;
    private RString chosaItemKoban9;
    private RString chosaItemKoban10;
    private RString chosaItemKoban11;
    private RString chosaItemKoban12;
    private RString chosaItemKoban13;
    private RString chosaItemKoban14;
    private RString chosaItemKoban15;
    private RString chosaItemKoban16;
    private RString chosaItemKoban17;
    private RString chosaItemKoban18;
    private RString chosaItemKoban19;
    private RString chosaItemKoban20;
    private RString chosaItemKoban21;
    private RString chosaItemKoban22;
    private RString chosaItemKoban23;
    private RString chosaItemKoban24;
    private RString chosaItemKoban25;
    private RString chosaItemKoban26;
    private RString chosaItemKoban27;
    private RString chosaItemKoban28;
    private RString chosaItemKoban29;
    private RString chosaItemKoban30;
    private RString chosaItemKoban31;
    private RString chosaItemKoban32;
    private RString chosaItemKoban33;
    private RString chosaItemKoban34;
    private RString chosaItemKoban35;
    private RString chosaItemKoban36;
    private RString chosaItemKoban37;
    private RString chosaItemKoban38;
    private RString chosaItemKoban39;
    private RString chosaItemKoban40;
    private RString chosaItemKoban41;
    private RString chosaItemKoban42;
    private RString chosaItemKoban43;
    private RString chosaItemKoban44;
    private RString chosaItemKoban45;
    private RString chosaItemKoban46;
    private RString chosaItemKoban47;
    private RString chosaItemKoban48;
    private RString chosaItemKoban49;
    private RString chosaItemKoban50;
    private RString chosaItemKoban51;
    private RString chosaItemKoban52;
    private RString chosaItemKoban53;
    private RString chosaItemKoban54;
    private RString chosaItemKoban55;
    private RString chosaItemKoban56;
    private RString chosaItemKoban57;
    private RString chosaItemKoban58;
    private RString chosaItemKoban59;
    private RString chosaItemKoban60;
    private RString chosaItemKoban61;
    private RString chosaItemKoban62;
    private RString chosaItemKoban63;
    private RString chosaItemKoban64;
    private RString chosaItemKoban65;
    private RString chosaItemKoban66;
    private RString chosaItemKoban67;
    private RString chosaItemKoban68;
    private RString chosaItemKoban69;
    private RString chosaItemKoban70;
    private RString chosaItemKoban71;
    private RString chosaItemKoban72;
    private RString chosaItemKoban73;
    private RString chosaItemKoban74;
    private RString chosaItemKoban75;
    private RString chosaItemKoban76;
    private RString chosaItemKoban77;
    private RString chosaItemKoban78;
    private RString chosaItemKoban79;
    private RString chosaItemKoban80;
    private RString chosaItemKoban81;
    private RString chosaItemKoban82;
    private RString chosaItemKoban83;
    private RString chosaItemKoban84;
    private RString chosaItemKoban85;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private RString zenkaiChosaItemKoban1;
    private RString zenkaiChosaItemKoban2;
    private RString zenkaiChosaItemKoban3;
    private RString zenkaiChosaItemKoban4;
    private RString zenkaiChosaItemKoban5;
    private RString zenkaiChosaItemKoban6;
    private RString zenkaiChosaItemKoban7;
    private RString zenkaiChosaItemKoban8;
    private RString zenkaiChosaItemKoban9;
    private RString zenkaiChosaItemKoban10;
    private RString zenkaiChosaItemKoban11;
    private RString zenkaiChosaItemKoban12;
    private RString zenkaiChosaItemKoban13;
    private RString zenkaiChosaItemKoban14;
    private RString zenkaiChosaItemKoban15;
    private RString zenkaiChosaItemKoban16;
    private RString zenkaiChosaItemKoban17;
    private RString zenkaiChosaItemKoban18;
    private RString zenkaiChosaItemKoban19;
    private RString zenkaiChosaItemKoban20;
    private RString zenkaiChosaItemKoban21;
    private RString zenkaiChosaItemKoban22;
    private RString zenkaiChosaItemKoban23;
    private RString zenkaiChosaItemKoban24;
    private RString zenkaiChosaItemKoban25;
    private RString zenkaiChosaItemKoban26;
    private RString zenkaiChosaItemKoban27;
    private RString zenkaiChosaItemKoban28;
    private RString zenkaiChosaItemKoban29;
    private RString zenkaiChosaItemKoban30;
    private RString zenkaiChosaItemKoban31;
    private RString zenkaiChosaItemKoban32;
    private RString zenkaiChosaItemKoban33;
    private RString zenkaiChosaItemKoban34;
    private RString zenkaiChosaItemKoban35;
    private RString zenkaiChosaItemKoban36;
    private RString zenkaiChosaItemKoban37;
    private RString zenkaiChosaItemKoban38;
    private RString zenkaiChosaItemKoban39;
    private RString zenkaiChosaItemKoban40;
    private RString zenkaiChosaItemKoban41;
    private RString zenkaiChosaItemKoban42;
    private RString zenkaiChosaItemKoban43;
    private RString zenkaiChosaItemKoban44;
    private RString zenkaiChosaItemKoban45;
    private RString zenkaiChosaItemKoban46;
    private RString zenkaiChosaItemKoban47;
    private RString zenkaiChosaItemKoban48;
    private RString zenkaiChosaItemKoban49;
    private RString zenkaiChosaItemKoban50;
    private RString zenkaiChosaItemKoban51;
    private RString zenkaiChosaItemKoban52;
    private RString zenkaiChosaItemKoban53;
    private RString zenkaiChosaItemKoban54;
    private RString zenkaiChosaItemKoban55;
    private RString zenkaiChosaItemKoban56;
    private RString zenkaiChosaItemKoban57;
    private RString zenkaiChosaItemKoban58;
    private RString zenkaiChosaItemKoban59;
    private RString zenkaiChosaItemKoban60;
    private RString zenkaiChosaItemKoban61;
    private RString zenkaiChosaItemKoban62;
    private RString zenkaiChosaItemKoban63;
    private RString zenkaiChosaItemKoban64;
    private RString zenkaiChosaItemKoban65;
    private RString zenkaiChosaItemKoban66;
    private RString zenkaiChosaItemKoban67;
    private RString zenkaiChosaItemKoban68;
    private RString zenkaiChosaItemKoban69;
    private RString zenkaiChosaItemKoban70;
    private RString zenkaiChosaItemKoban71;
    private RString zenkaiChosaItemKoban72;
    private RString zenkaiChosaItemKoban73;
    private RString zenkaiChosaItemKoban74;
    private RString zenkaiChosaItemKoban75;
    private RString zenkaiChosaItemKoban76;
    private RString zenkaiChosaItemKoban77;
    private RString zenkaiChosaItemKoban78;
    private RString zenkaiChosaItemKoban79;
    private RString zenkaiChosaItemKoban80;
    private RString zenkaiChosaItemKoban81;
    private RString zenkaiChosaItemKoban82;
    private RString zenkaiChosaItemKoban83;
    private RString zenkaiChosaItemKoban84;
    private RString zenkaiChosaItemKoban85;
    private Code zenkaiNinchishoNichijoSeikatsuJiritsudoCode;
    private Code zenkaiShogaiNichijoSeikatsuJiritsudoCode;
    private Code zenkaiIchijiHanteiKekkaCode;
    private Code zenkaiIchijiHanteiKekkaNinchishoKasanCode;
    private int zenkaiKijunJikan;
    private int zenkaiKijunJikanShokuji;
    private int zenkaiKijunJikanHaisetsu;
    private int zenkaiKijunJikanIdo;
    private int zenkaiKijunJikanSeiketsuHoji;
    private int zenkaiKijunJikanKansetsuCare;
    private int zenkaiKijunJikanBPSDKanren;
    private int zenkaiKijunJikanKinoKunren;
    private int zenkaiKijunJikanIryoKanren;
    private int zenkaiKijunJikanNinchishoKasan;
    private int zenkaiChukanHyokaKomoku1gun;
    private int zenkaiChukanHyokaKomoku2gun;
    private int zenkaiChukanHyokaKomoku3gun;
    private int zenkaiChukanHyokaKomoku4gun;
    private int zenkaiChukanHyokaKomoku5gun;
    private RString zenkaIchijiHnateiKeikokuCode;
    private Code zenkaiJotaiAnteiseiCode;
    private Decimal zenkaiNinchishoJiritsudoIIijoNoGaizensei;
    private Code zenkaiSuiteiKyufuKubunCode;
    private FlexibleDate zenkaiNinteiShinseiYMD;
    private FlexibleDate zenkaiNijiHanteiYMD;
    private Code zenkaiServiceKubunCode;
    private int zenkaiRemban;
    private int zenkaiServiceJokyoKoban1;
    private int zenkaiServiceJokyoKoban2;
    private int zenkaiServiceJokyoKoban3;
    private int zenkaiServiceJokyoKoban4;
    private int zenkaiServiceJokyoKoban5;
    private int zenkaiServiceJokyoKoban6;
    private int zenkaiServiceJokyoKoban7;
    private int zenkaiServiceJokyoKoban8;
    private int zenkaiServiceJokyoKoban9;
    private int zenkaiServiceJokyoKoban10;
    private int zenkaiServiceJokyoKoban11;
    private int zenkaiServiceJokyoKoban12;
    private int zenkaiServiceJokyoKoban13;
    private int zenkaiServiceJokyoKoban14;
    private int zenkaiServiceJokyoKoban15;
    private int zenkaiServiceJokyoKoban16;
    private int zenkaiServiceJokyoKoban17;
    private int zenkaiServiceJokyoKoban18;
    private int zenkaiServiceJokyoKoban19;
    private int zenkaiServiceJokyoKoban20;
    private boolean zenkaiServiceJokyoFlag;
    private Code zenkaiKoroshoIfShikibetsuCode;
    private RString ninteishinsakaiIkenShurui;
    private RString shinsakaiMemo;
}
