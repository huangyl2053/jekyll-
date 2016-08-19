/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4010011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011.DBD4010011Div;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 障がい者控除対象者认定の対象者条件バリデーションクラスです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
public enum ShogaishaKojoTaishoshaHaakuJokenDivSpec implements IPredicate<DBD4010011Div> {

    基準日の未入力チェック {
                /**
                 * 基準日の未入力チェック。
                 *
                 * @param div 対象者条件Div
                 * @return true: 基準日が非空です、false: 基準日が空です。
                 */
                @Override
                public boolean apply(DBD4010011Div div) {
                    return div.getShogaishaKojoTaishoshaHaakuJoken().getTxtKijunYMD().getValue() != null && !div.getShogaishaKojoTaishoshaHaakuJoken().getTxtKijunYMD().getValue().toString().isEmpty();
                }
            },

}
