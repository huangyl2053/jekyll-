/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 主治医医療機関＆主治医入力共有子Divの仕様クラスです。
 */
public enum ShujiiIryokikanAndShujiiInputSpec implements IPredicate<ShujiiIryokikanAndShujiiInputDiv> {

    /**
     * 医療機関コードに該当するデータが存在すること
     */
    医療機関コードに該当するデータが存在すること {
                @Override
                public boolean apply(ShujiiIryokikanAndShujiiInputDiv div) {
                    return div.getTxtIryoKikanCode().getValue().isEmpty()
                    || !div.getTxtIryoKikanName().getValue().isEmpty();
                }
            },
    /**
     * 主治医コードに該当するデータが存在すること
     */
    主治医コードに該当するデータが存在すること {
                @Override
                public boolean apply(ShujiiIryokikanAndShujiiInputDiv div) {
                    return div.getTxtShujiiCode().getValue().isEmpty()
                    || !div.getTxtShujiiName().getValue().isEmpty();
                }
            }
}
