/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼先変更者のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaIraiHenkoRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private FlexibleDate seinengappiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString shichosonMeisho;
    private int ninteichosaIraiRirekiNo;
    private FlexibleDate ninteichosaIraiYMD;
    private RString jigyoshaMeisho;
    private RString chosainShimei;

}
