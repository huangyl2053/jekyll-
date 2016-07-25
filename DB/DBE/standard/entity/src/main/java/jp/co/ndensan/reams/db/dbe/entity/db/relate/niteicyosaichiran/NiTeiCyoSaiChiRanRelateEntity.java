/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査一覧RelateEntityクラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
@lombok.Getter
@lombok.Setter
public class NiTeiCyoSaiChiRanRelateEntity implements Serializable {

    private int ninteichosaIraiRirekiNo;
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    private ChosainCode ninteiChosainCode;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private RString hokensya;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
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
    private RString jutakuKaishu;
    private RString tokubetsuKyufuService;
    private RString zaitakuService;
    private RString shuso;
    private RString kazokuJokyo;
    private RString kyojuKankyo;
    private RString kikaiKiki;
    private RString ninteichosaTokkijikoNo;
    private int ninteichosaTokkijikoRemban;
    private Code genponMaskKubun;
    private RString tokkiJiko;
    private int sabisuremban;
    private int serviceJokyo;
    private RString serviceJokyoKinyu;
    private boolean shisetsuRiyoFlag;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private int cyusakomokuremban;
    private RString researchItem;
    private Code koroshoIfShikibetsuCode;
    private RString gaikyoTokkiTextImageKubun;
    private boolean serviceJokyoFlag;
}
