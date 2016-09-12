/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitaishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会個人別状況照会のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiTaishoshaRelateEntity {

    private RString shinsakaiKaisaiNo;
    private RString gogitaiMei;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiWariateZumiNinzu;
    private Code shinsakaiShinchokuJokyo;
    private RString shinsakaiKaisaiBashoName;
    private RString shinsakaiKaisaiBashoCode;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiShuryoYoteiTime;
    private boolean gogitaiSeishinkaSonzaiFlag;
    private FlexibleDate shinsakaiKaisaiYMD;
    private RString shinsakaiKaishiTime;
    private RString shinsakaiShuryoTime;
    private int shoyoJikanGokei;
    private int shinsakaiJisshiNinzu;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private RString hihokenshaKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString shichosonMeisho;
    private int shinsakaiOrder;
    private ShinseishoKanriNo shinseishoKanriNo;
    private int saiChosaIraiKaisu;
    private int saiSakuseiIraiKaisu;
    private Code ichijiHanteiKekkaCode;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private Code shinsakaiKaisaiChikuCode;
}
