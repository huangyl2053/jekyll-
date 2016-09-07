/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モバイル入力用データRelateEntityクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ChosaKekkaNyuryokuMobileRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    private ChosainCode ninteiChosainCode;
    private RString hokenshaName;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private int ninteichosaIraiRirekiNo;
    private RString chosaItakusaki;
    private RString chosainShimei;
    private RString gaikyoChosaTextImageKubun;
    private Code ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private Code ninteiChosaKubunCode;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private Code serviceKubunCode;
    private RString riyoShisetsuShimei;
    private RString riyoShisetsuJusho;
    private RString riyoShisetsuTelNo;
    private YubinNo riyoShisetsuYubinNo;
    private RString tokki;
    private FlexibleDate tokkijikoUketsukeYMD;
    private FlexibleDate tokkijikoJuryoYMD;
    private ShinseishoKanriNo gaikyoTokkiShinseishoKanriNo;
    private int ninteichosaRirekiNo;
    private RString gaikyoTokkiTextImageKubun;
    private RString jutakuKaishu;
    private RString tokubetsuKyufuService;
    private RString zaitakuService;
    private RString shuso;
    private RString kazokuJokyo;
    private RString kyojuKankyo;
    private RString kikaiKiki;
    private RString ninteichosaTokkijikoNo;
    private int ninteichosaTokkijikoRemban;
    private RString tokkijikoTextImageKubun;
    private Code genponMaskKubun;
    private RString tokkiJiko;
    private int serviceJokyoRemban;
    private int serviceJokyo;
    private int serviceJokyoFlagRemban;
    private boolean serviceJokyoFlag;
    private int kinyuRemban;
    private RString serviceJokyoKinyu;
    private int shisetsuRiyoRemban;
    private boolean shisetsuRiyoFlag;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private int researchItemRemban;
    private RString researchItem;
    private int remban1;
    private int remban2;
    private int remban3;
    private int remban4;
    private int remban5;
    private int remban6;
    private int remban7;
    private int remban8;
    private int remban9;
    private int remban10;
    private int remban11;
    private int remban12;
    private int remban13;
    private int remban14;
    private int remban15;
    private int remban16;
    private int remban17;
    private int remban18;
    private int remban19;
    private int remban20;
    private int remban21;
    private int remban22;
    private int remban23;
    private int remban24;
    private int remban25;
    private int remban26;
    private int remban27;
    private int remban28;
    private int remban29;
    private int remban30;
    private int remban31;
    private int remban32;
    private int remban33;
    private int remban34;
    private int remban35;
    private int remban36;
    private int remban37;
    private int remban38;
    private int remban39;
    private int remban40;
    private int remban41;
    private int remban42;
    private int remban43;
    private int remban44;
    private int remban45;
    private int remban46;
    private int remban47;
    private int remban48;
    private int remban49;
    private int remban50;
    private int remban51;
    private int remban52;
    private int remban53;
    private int remban54;
    private int remban55;
    private int remban56;
    private int remban57;
    private int remban58;
    private int remban59;
    private int remban60;
    private int remban61;
    private int remban62;
    private int remban63;
    private int remban64;
    private int remban65;
    private int remban66;
    private int remban67;
    private int remban68;
    private int remban69;
    private int remban70;
    private int remban71;
    private int remban72;
    private int remban73;
    private int remban74;
    private int remban75;
    private int remban76;
    private int remban77;
    private int remban78;
    private int remban79;
    private int remban80;
    private int remban81;
    private int remban82;
    private int remban83;
    private int remban84;
    private int remban85;
    private Code zenkaiKoroshoIfShikibetsuCode;
    private Code zenkaiNinchishoNichijoSeikatsuJiritsudoCode;
    private Code zenkaiShogaiNichijoSeikatsuJiritsudoCode;

}
