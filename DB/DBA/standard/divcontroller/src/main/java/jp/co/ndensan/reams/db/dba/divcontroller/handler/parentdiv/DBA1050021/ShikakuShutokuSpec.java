/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 資格取得情報が入力されていることを保証するためのクラスです。
 *
 * @author n8178
 */
public enum ShikakuShutokuSpec implements IPredicate<HihokenshaShisakuPanalDiv> {

    /**
     * 資格取得日が入力されている事を保証します。
     */
    資格取得日が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getTxtShutokuDate().getValue().isEmpty();
                }
            },
    /**
     * 資格取得届出日が入力されている事を保証します。
     */
    資格取得届出日が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getTxtShutokuTodokedeDate().getValue().isEmpty();
                }
            },
    /**
     * 資格取得事由が入力されている事を保証します。
     */
    資格取得事由が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getDdlShutokuJiyu().getSelectedValue().isEmpty();
                }
            },
    /**
     * 被保険者区分が入力されている事を保証します。
     */
    被保険者区分が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getDdlHihoKubun().getSelectedValue().isEmpty();
                }
            },
    /**
     * 所在保険者が入力されている事を保証します。
     */
    所在保険者が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getDdlShutokuShozaiHokensha().getSelectedValue().isEmpty();
                }
            },
    /**
     * 措置元保険者が入力されている事を保証します。
     */
    措置元保険者が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getDdlShutokuSochimotoHokensha().getSelectedValue().isEmpty();
                }
            },
    /**
     * 資旧保険者が入力されている事を保証します。
     */
    旧保険者が入力されている() {
                @Override
                public boolean apply(HihokenshaShisakuPanalDiv t) {
                    return !t.getDdlShutokuKyuHokensha().getSelectedValue().isEmpty();
                }
            };

}
