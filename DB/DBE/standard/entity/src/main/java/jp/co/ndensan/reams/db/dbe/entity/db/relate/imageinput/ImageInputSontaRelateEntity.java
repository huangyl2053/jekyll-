/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込みでその他資料を取り込む際に、取り込んだ申請と関連するデータを保持します。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageInputSontaRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private HihokenshaNo hihokenshaNo;
    private RString koroshoIfShikibetsuCode;
    private RString hihokenshaKana;
    private RString hihokenshaName;
    private FlexibleDate ninteiShinseiYMD;
    private RString torisageKubunCode;
    private boolean logicalDeletedFlag;
    private boolean matchesShiteiShinseiYMD;
    private RDateTime imageSharedFileId;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private Boolean kariIchijiHanteiKubun;

}
