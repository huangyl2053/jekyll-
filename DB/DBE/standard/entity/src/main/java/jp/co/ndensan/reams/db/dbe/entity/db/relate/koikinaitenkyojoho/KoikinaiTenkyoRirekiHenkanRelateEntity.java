/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.koikinaitenkyojoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内転居使用ことEntityクラスです
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoRirekiHenkanRelateEntity implements Serializable {

    private static final long serialVersionUID = 9073666287263687709L;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private FlexibleDate seinengappiYMD;
    private int age;
    private AtenaJusho jusho;
    private YubinNo yubinNo;
    private TelNo telNo;
    private FlexibleDate ninteiShinseiYMD;
    private RString shichosonMeisho;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private FlexibleDate nijiHanteiYMD;
    private int nijiHanteiNinteiYukoKikan;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaJisshiYMD;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoJuryoYMD;
    private RString shinsakaiKaisaiNo;
    private FlexibleDate shinsakaiKaisaiYMD;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
}
