/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 調査実施者情報共有子Divの仕様クラスです。
 */
public enum ChosaJisshishaJohoSpec implements IPredicate<ChosaJisshishaJohoDiv> {

    /**
     * 所属機関コードに該当するデータが存在すること
     */
    所属機関コードに該当するデータが存在すること {
                @Override
                public boolean apply(ChosaJisshishaJohoDiv div) {
                    return div.getTxtShozokuKikanCode().getValue().isEmpty()
                    || !div.getTxtShozokuKikanName().getValue().isEmpty();
                }
            },
    /**
     * 記入者コードに該当するデータが存在すること
     */
    記入者コードに該当するデータが存在すること {
                @Override
                public boolean apply(ChosaJisshishaJohoDiv div) {
                    return div.getTxtKinyushaCode().getValue().isEmpty()
                    || !div.getTxtKinyushaName().getValue().isEmpty();
                }
            }

}
