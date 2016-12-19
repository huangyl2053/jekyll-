/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseikensaku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請検索RelateEntityクラスです。
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiKensakuRelateEntity implements Serializable {

    private static final long serialVersionUID = 8593022720174114688L;

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubun;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private AtenaMeisho hihokenshaName;
    private AtenaKanaMeisho hihokenshaKana;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private Code koroshoIfShikibetsuCode;
    private FlexibleDate zenkaiYukoKikanStart;
    private FlexibleDate zenkaiYukoKikanEnd;
    private Code nijiHanteiYokaigoJotaiKubun;
    private int nijiHanteiNinteiYukoKikan;
    private RString shichosonMeisho;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private RString iryoKikanMeisho;
    private AtenaMeisho shujiiName;
    private int ikenshoIraiRirekiNo;
    private int ninteichosaIraiRirekiNo;
    private Code zenkaiKoroshoIfShikibetsuCode;
}
