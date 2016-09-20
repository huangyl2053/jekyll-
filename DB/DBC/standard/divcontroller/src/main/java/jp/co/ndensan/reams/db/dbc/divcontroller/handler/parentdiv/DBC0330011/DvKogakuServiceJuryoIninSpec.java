/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DvKogakuServiceJuryoIninDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author Administrator
 */
public enum DvKogakuServiceJuryoIninSpec implements IPredicate<DvKogakuServiceJuryoIninDiv> {

    /**
     * 文書番号のチェックです。
     */
    文書番号必須 {
                @Override
                public boolean apply(DvKogakuServiceJuryoIninDiv div) {
                    return !SpecHelper.is文書番号必須(div);
                }
            },
    /**
     * 承認しない理由のチェックです。
     */
    承認しない理由必須 {
                @Override
                public boolean apply(DvKogakuServiceJuryoIninDiv div) {
                    return !SpecHelper.is承認しない理由必須(div);
                }
            },
    /**
     * 利用者負担上限額のチェックです
     */
    利用者負担上限額必須 {
                @Override
                public boolean apply(DvKogakuServiceJuryoIninDiv div) {
                    return !SpecHelper.is利用者負担上限額必須(div);
                }
            },
    /**
     * 承認終了日の入力値のチェックです
     */
    承認終了日の入力値が不正 {
                @Override
                public boolean apply(DvKogakuServiceJuryoIninDiv div) {
                    return !SpecHelper.is承認終了日の入力値が不正(div);
                }
            };

    /**
     * {@link DvKogakuServiceJuryoIninSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final RString KEY_決定区分_承認する = new RString("key0");
        private static final RString KEY_決定区分_承認しない = new RString("key1");

        public static boolean is文書番号必須(DvKogakuServiceJuryoIninDiv div) {
            return RString.isNullOrEmpty(div.getDvKakuninsho().getCcdBunshoBango().get文書番号());
        }

        public static boolean is承認しない理由必須(DvKogakuServiceJuryoIninDiv div) {
            return KEY_決定区分_承認しない.equals(div.getRadKetteiKubun().getSelectedKey())
                    && RString.isNullOrEmpty(div.getTxtShoninShinaiRiyu().getValue());
        }

        public static boolean is利用者負担上限額必須(DvKogakuServiceJuryoIninDiv div) {
            return KEY_決定区分_承認する.equals(div.getRadKetteiKubun().getSelectedKey())
                    && RString.isNullOrEmpty(div.getDdlRiyoshafutanJogenGaku().getSelectedKey());
        }

        public static boolean is承認終了日の入力値が不正(DvKogakuServiceJuryoIninDiv div) {
            return null != div.getDvHaraiKetteiShusei().getBtnShoninDate().getToValue()
                    && div.getDvHaraiKetteiShusei().getBtnShoninDate().getToValue()
                    .isBefore(div.getDvHaraiKetteiShusei().getBtnShoninDate().getFromValue());
        }
    }
}
