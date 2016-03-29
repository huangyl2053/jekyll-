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
 * 要介護認定申請情報＆構成市町村マスタRelateEntityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoShiTaisyoRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private Code ninteiShinseiShinseijiKubunCode;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private FlexibleDate koshinTsuchiHakkoYMD;
    private FlexibleDate koshinTsuchiHakkoKanryoYMD;
    private RString shichosonMeisho;
}
