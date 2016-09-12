/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IChiJiHanTeiRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code shinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private RString shichosonMeisho;
    private FlexibleDate johoTorokuKanryoYMD;
    private FlexibleDate ichijiHanteiYMD;
    private FlexibleDate ichijiHanteiKanryoYMD;
    private Code ichijiHanteiKekkaCode;
    private RString ichijiHnateiKeikokuCode;
    private boolean kariIchijiHanteiKubun;
}
