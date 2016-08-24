/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 画面設計_DBC0150011_サービス提供票別表のSpecクラスです。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public enum ServiceTeikyohyoBeppyoPrintMainSpec implements IPredicate<ServiceTeikyohyoBeppyoPrintMainDiv> {

    /**
     * 作成年月日必須チェックの場合です。
     */
    作成年月日必須チェックの場合 {
                @Override
                public boolean apply(ServiceTeikyohyoBeppyoPrintMainDiv div) {
                    return SpecHelper.is作成年月日入力(div);
                }
            },
    /**
     * 自己作成計画年月必須チェックの場合です。
     */
    自己作成計画年月必須チェックの場合 {
                @Override
                public boolean apply(ServiceTeikyohyoBeppyoPrintMainDiv div) {
                    return SpecHelper.is自己作成計画年月入力(div);
                }
            };

    /**
     * {@link ServiceTeikyohyoBeppyoPrintMainSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        /**
         * 作成年月日の必須チェックです。
         *
         * @param div ServiceTeikyohyoBeppyoPrintMainDiv
         */
        public static boolean is作成年月日入力(ServiceTeikyohyoBeppyoPrintMainDiv div) {

            return div.getTxtSakuseiYmd().getValue() == null ? Boolean.FALSE : Boolean.TRUE;
        }

        /**
         * 自己作成計画年月の必須チェックです。
         *
         * @param div ServiceTeikyohyoBeppyoPrintMainDiv
         */
        public static boolean is自己作成計画年月入力(ServiceTeikyohyoBeppyoPrintMainDiv div) {

            return div.getTxtJikoSakuseiKeikakuYm().getValue() == null ? Boolean.FALSE : Boolean.TRUE;
        }

    }

}
