/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosayoteimitei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査予定未定者一覧表のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1390-110 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaYoteiMiteiRelateEntity {

    private ShinseishoKanriNo dbT5101_shinseishoKanriNo;
    private RString dbT5101_shoKisaiHokenshaNo;
    private RString dbT5101_hihokenshaNo;
    private AtenaKanaMeisho dbT5101_hihokenshaKana;
    private AtenaMeisho dbT5101_hihokenshaName;
    private Code dbT5101_seibetsu;
    private FlexibleDate dbT5101_seinengappiYMD;
    private Code dbT5101_ninteiShinseiShinseijiKubunCode;
    private FlexibleDate dbT5101_ninteiShinseiYMD;
    private RString dbT7051_shichosonMeisho;
    private ShinseishoKanriNo dbT5121_zenkaiShinseishoKanriNo;
    private RString dbT5910_jigyoshaMeisho;
    private RString dbT5913_chosainShimei;
    private RString dbT5910_Zenkai_jigyoshaMeisho;
    private RString dbT5913_Zenkai_chosainShimei;
    private RString dbT5910_ZenZenkai_jigyoshaMeisho;
    private RString dbT5913_ZenZenkai_chosainShimei;

}
