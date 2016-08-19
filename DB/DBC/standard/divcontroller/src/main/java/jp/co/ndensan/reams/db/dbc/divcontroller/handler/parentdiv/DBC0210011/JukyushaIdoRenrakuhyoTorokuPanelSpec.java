/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link JukyushaIdoRenrakuhyoTorokuPanelDiv}の仕様クラスです。 <br>
 * {@link JukyushaIdoRenrakuhyoTorokuPanelDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-2100-010 jiangzongyue
 */
public enum JukyushaIdoRenrakuhyoTorokuPanelSpec implements IPredicate<JukyushaIdoRenrakuhyoTorokuPanelDiv> {

    /**
     * 発行日の必須チェック。
     */
    発行日の必須チェック {
                @Override
                public boolean apply(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
                    return SpecHelper.is発行日の必須チェック場合(div);
                }
            };

    private static class SpecHelper {

        /**
         * 発行日の必須チェック場合です。
         *
         * @param div JukyushaIdoRenrakuhyoTorokuPanelDiv
         */
        public static boolean is発行日の必須チェック場合(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
            return (div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getOutputJukyushaIdoRenrakuhyo().getBtnHakkou() != null);
        }

    }
}
