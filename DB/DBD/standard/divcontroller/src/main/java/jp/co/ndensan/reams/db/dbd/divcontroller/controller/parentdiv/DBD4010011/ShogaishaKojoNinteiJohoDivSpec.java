/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4010011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011.DBD4010011Div;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 障がい者控除対象者认定の障がい者控除認定情報バリデーションクラスです。
 *
 * @reamsid_L DBD-3850-010 liuwei2
 */
public enum ShogaishaKojoNinteiJohoDivSpec implements IPredicate<DBD4010011Div> {

    対象年度の未入力チェック {
                /**
                 * 対象年度の未入力チェックです。
                 *
                 * @param div 障がい者控除認定情報Div
                 * @return true:対象年度が非空です、false:対象年度が空です。
                 */
                @Override
                public boolean apply(DBD4010011Div div) {
                    return div.getShogaishaKojoNinteiJoho().getTaishoNendo().getValue() != null && !div.getShogaishaKojoNinteiJoho().getTaishoNendo().getValue().toString().isEmpty();
                }
            },
    申請年月日の未入力チェック {
                /**
                 * 申請年月日の未入力チェックです。
                 *
                 * @param div 障がい者控除認定情報Div
                 * @return true:申請年月日が非空です、false:申請年月日が空です。
                 */
                @Override
                public boolean apply(DBD4010011Div div) {
                    return div.getShogaishaKojoNinteiJoho().getSinseiNengabi().getValue() != null && !div.getShogaishaKojoNinteiJoho().getSinseiNengabi().toString().isEmpty();
                }
            },
    決定年月日の未入力チェック {
                /**
                 * 決定年月日の未入力チェック。
                 *
                 * @param div 障がい者控除認定情報Div
                 * @return true: 決定年月日が非空です、false: 決定年月日が空です。
                 */
                @Override
                public boolean apply(DBD4010011Div div) {

                    return div.getShogaishaKojoNinteiJoho().getKeteiNengabi().getValue() != null && !div.getShogaishaKojoNinteiJoho().getKeteiNengabi().getValue().toString().isEmpty();
                }
            },

}
