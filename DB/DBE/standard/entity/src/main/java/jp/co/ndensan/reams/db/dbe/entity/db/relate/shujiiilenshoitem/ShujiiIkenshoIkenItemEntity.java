/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author n3509
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoIkenItemEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private int ikenshoIraiRirekiNo;
    private int remban;
    private Code koroshoIfShikibetsuCode;
    private RString ikenItem;
}
