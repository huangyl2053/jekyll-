/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4010011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011.DBD4010011Div;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 障がい者控除対象者認定の障がい者控除認定情報バリデーションクラスです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
public enum ShogaishaKojoNinteiJohoDivSpec implements IPredicate<DBD4010011Div> {

    /**
     * 対象年度の未入力チェックです。
     *
     */
    対象年度の未入力チェック {
                @Override
                public boolean apply(DBD4010011Div div) {
                    return div.getShogaishaKojoNinteiJoho().getTaishoNendo().getValue() != null && !div.getShogaishaKojoNinteiJoho().getTaishoNendo().getValue().toString().isEmpty();
                }
            },
    /**
     * 申請年月日の未入力チェックです。
     *
     */
    申請年月日の未入力チェック {
                @Override
                public boolean apply(DBD4010011Div div) {
                    return div.getShogaishaKojoNinteiJoho().getSinseiNengabi().getValue() != null && !div.getShogaishaKojoNinteiJoho().getSinseiNengabi().toString().isEmpty();
                }
            },
    /**
     * 決定年月日の未入力チェック。
     *
     */
    決定年月日の未入力チェック {
                @Override
                public boolean apply(DBD4010011Div div) {
                    return div.getShogaishaKojoNinteiJoho().getKeteiNengabi().getValue() != null && !div.getShogaishaKojoNinteiJoho().getKeteiNengabi().getValue().toString().isEmpty();
                }
            },

}
