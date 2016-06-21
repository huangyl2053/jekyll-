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

}
