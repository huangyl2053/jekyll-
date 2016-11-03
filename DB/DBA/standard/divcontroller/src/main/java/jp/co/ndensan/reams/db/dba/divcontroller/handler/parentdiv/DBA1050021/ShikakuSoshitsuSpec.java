/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 資格喪失情報が入力されていることを保証するためのクラスです。
 *
 * @author n8178
 */
public enum ShikakuSoshitsuSpec implements IPredicate<HihokenshaShisakuPanalDiv> {

    /**
     * 資格喪失日が入力されていることを保証します。
     */
    資格喪失日が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getTxtSoshitsuDate().getValue().isEmpty();
                }
            },
    /**
     * 入力された取得日と喪失日の関係性が正しいことを保証します。
     */
    入力された取得日と喪失日の関係性が正しい() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    boolean isCorrect = t.getTxtShutokuDate().getValue().isEmpty()
                    || t.getTxtSoshitsuDate().getValue().isEmpty();
                    if (isCorrect) {
                        return false;
                    }

                    return t.getTxtShutokuDate().getValue().isBefore(t.getTxtSoshitsuDate().getValue());
                }
            },
    /**
     * 資格喪失届出日が入力されていることを保証します。
     */
    資格喪失届出日が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getTxtSoshitsuTodokedeDate().getValue().isEmpty();
                }
            },
    /**
     * 資格喪失事由が入力されていることを保証します。
     */
    資格喪失事由が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getDdlSoshitsuJiyu().getSelectedValue().isEmpty();
                }
            },
    /**
     * 喪失情報が全て入力されていないことを保証します。
     */
    喪失情報が全て入力されていない() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return t.getTxtSoshitsuDate().getValue().isEmpty()
                    && t.getTxtSoshitsuTodokedeDate().getValue().isEmpty()
                    && t.getDdlSoshitsuJiyu().getSelectedValue().isEmpty();
                }
            },
    /**
     * 喪失情報のいずれかが入力されていないことを保証します。
     */
    喪失情報のいずれかが入力されていない() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return t.getTxtSoshitsuDate().getValue().isEmpty()
                    || t.getTxtSoshitsuTodokedeDate().getValue().isEmpty()
                    || t.getDdlSoshitsuJiyu().getSelectedValue().isEmpty();
                }
            };

}
