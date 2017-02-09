/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 *
 */
@lombok.Getter
@lombok.Setter
public class IkenshoContextEntity {

    private ShinseishoKanriNo 申請書管理番号;
    private Boolean exists主治医区分;

    /**
     * MyBatis用引数なしのコンストラクタです。
     */
    public IkenshoContextEntity() {
    }
}
