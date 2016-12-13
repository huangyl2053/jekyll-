/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定個人状況照会用Entityクラスです。
 *
 * @reamsid_L DBE-0200-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KojinJokyoShokaiRelateEntity {

    private FlexibleDate ninteichosaIraiYoteiYMD;
    private FlexibleDate ninteichosaYoteiYMD;
    private FlexibleDate ikenshoSakuseiIraiYoteiYMD;
    private FlexibleDate ikenshoTorokuYoteiYMD;
    private FlexibleDate ichijiHanteiYoteiYMD;
    private FlexibleDate ninteiShinsakaiWariateYoteiYMD;
    private FlexibleDate ninteiShinsakaiYoteiYMD;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private FlexibleDate ichijiHanteiKanryoYMD;
    private FlexibleDate maskingKanryoYMD;
    private FlexibleDate ninteiShinsakaiWariateKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private FlexibleDate nijiHanteiYMD;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private int nijiHanteiNinteiYukoKikan;
    private RString shienShinseiKubun;
    private Code nigoTokuteiShippeiCode;
    private boolean johoteikyoDoiFlag;
    private Code koroshoIfShikibetsuCode;
    private Code ichijiHanteiKekkaCode;
    private FlexibleDate ichijiHanteiYMD;
    private Code shoriJotaiKubun;
    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private RString shujiiCode;
    private RString shujiiName;
    private boolean shiteiiFlag;
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString ninteiChosainCode;
    private RString chosainShimei;
    private RString shichosonRenrakuJiko;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private Code ishiKubunCode;
    private Code shinseiKubun;
    private RString hihokenshaNameKana;
    private FlexibleDate shinseiYMD;
    private RString seibetsu;
    private RString hihokenshaName;
    private FlexibleDate birthYMD;
    private int age;
    private YubinNo yubinNo1;
    private AtenaJusho hihokenshaJusho;
    private TelNo telNo1;
    private RString shinseiRiyu;
    private RString shinseishaName;
    private RString shinseiDaikoJigyoshaName;
    private Code shinseishaKankei;
    private Code honninKankei;
    private YubinNo yubinNo2;
    private AtenaJusho shinseishaJusho;
    private TelNo telNo2;
    private RString shisetsuName;
    private AtenaJusho shisetsujusho;
    private TelNo telNo3;
    private RString chosain_1;
    private RString chosain_2;
    private TelNo chosain_3;
    private RString chosain_4;
    private RString chosain_5;
    private TelNo chosain_6;
    private RString chosain_7;
    private RString chosain_8;
    private TelNo chosain_9;
    private RString shui_1;
    private RString shui_2;
    private TelNo shui_3;
    private RString shui_4;
    private RString shui_5;
    private TelNo shui_6;
    private RString shui_7;
    private RString shui_8;
    private TelNo shui_9;
    private FlexibleDate konnkai_1;
    private FlexibleDate zennkai_1;
    private FlexibleDate zennnoma_1;
    private FlexibleDate konnkai_2;
    private FlexibleDate zennkai_2;
    private FlexibleDate zennnoma_2;
    private FlexibleDate konnkai_3;
    private FlexibleDate zennkai_3;
    private FlexibleDate zennnoma_3;
    private FlexibleDate konnkai_4;
    private FlexibleDate zennkai_4;
    private FlexibleDate zennnoma_4;
    private FlexibleDate konnkai_5;
    private FlexibleDate zennkai_5;
    private FlexibleDate zennnoma_5;
    private FlexibleDate konnkai_6;
    private FlexibleDate zennkai_6;
    private FlexibleDate zennnoma_6;
    private FlexibleDate konnkai_7;
    private FlexibleDate zennkai_7;
    private FlexibleDate zennnoma_7;
    private FlexibleDate konnkai_8;
    private FlexibleDate zennkai_8;
    private FlexibleDate zennnoma_8;
    private FlexibleDate konnkai_9;
    private FlexibleDate zennkai_9;
    private FlexibleDate zennnoma_9;
    private FlexibleDate konnkai_10;
    private FlexibleDate zennkai_10;
    private FlexibleDate zennnoma_10;
    private FlexibleDate konnkai_11;
    private FlexibleDate zennkai_11;
    private FlexibleDate zennnoma_11;
    private FlexibleDate konnkai_12;
    private FlexibleDate zennkai_12;
    private FlexibleDate zennnoma_12;
    private FlexibleDate konnkai_13;
    private FlexibleDate zennkai_13;
    private FlexibleDate zennnoma_13;
    private FlexibleDate konnkai_14;
    private FlexibleDate zennkai_14;
    private FlexibleDate zennnoma_14;
    private FlexibleDate konnkai_15;
    private FlexibleDate zennkai_15;
    private FlexibleDate zennnoma_15;
    private FlexibleDate konnkai_16;
    private FlexibleDate zennkai_16;
    private FlexibleDate zennnoma_16;
    private FlexibleDate konnkai_17;
    private FlexibleDate zennkai_17;
    private FlexibleDate zennnoma_17;
    private FlexibleDate konnkai_18;
    private FlexibleDate zennkai_18;
    private FlexibleDate zennnoma_18;
    private FlexibleDate konnkai_19;
    private FlexibleDate zennkai_19;
    private FlexibleDate zennnoma_19;
    private FlexibleDate konnkai_20;
    private FlexibleDate zennkai_20;
    private FlexibleDate zennnoma_20;
    private FlexibleDate konnkai_21;
    private FlexibleDate zennkai_21;
    private FlexibleDate zennnoma_21;
    private FlexibleDate konnkai_22;
    private FlexibleDate zennkai_22;
    private FlexibleDate zennnoma_22;
    private RString ikenshoIraiRirekiNo;
    private int ninteichosaIraiRirekiNo;

}
