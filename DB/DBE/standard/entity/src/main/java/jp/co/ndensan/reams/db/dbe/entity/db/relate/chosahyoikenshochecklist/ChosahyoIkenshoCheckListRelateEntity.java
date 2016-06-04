/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査結果と主治医意見書のチェックリストのRelateEntityクラスです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoIkenshoCheckListRelateEntity {

    private ShinseishoKanriNo dbT5101_shinseishoKanriNo;
    private Code dbT5101_koroshoIfShikibetsuCode;
    private RString dbT5101_shoKisaiHokenshaNo;
    private RString dbT5101_hihokenshaNo;
    private AtenaMeisho dbT5101_hihokenshaName;
    private Code dbT5101_ninteiShinseiShinseijiKubunCode;
    private FlexibleDate dbT5101_ninteiShinseiYMD;
    private RString dbT7051_shichosonMeisho;
    private Code dbT5101Zenkai_koroshoIfShikibetsuCode;
    private Code dbT5116_ichijiHanteiKekkaCode;
    private Code dbT5116Zenkai_ichijiHanteiKekkaCode;
    private Code dbT5102Zenkai_nijiHanteiYokaigoJotaiKubunCode;
    private FlexibleDate dbT5501_shinsakaiKaisaiYoteiYMD;
    private RString dbT5501_gogitaiNo;
    private Code dbT5203_ninchishoNichijoSeikatsuJiritsudoCode;
    private Code dbT5203_shogaiNichijoSeikatsuJiritsudoCode;
    private RString dbT5211_remban;
    private RString dbT5211_researchItem;
    private RString dbT5304_remban;
    private RString dbT5304_ikenItem;

}
