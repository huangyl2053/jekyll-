/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.KubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.dgServiceShurui_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * {@link KubunShikyuGendogakuDiv}の仕様クラスです。 <br> {@link KubunShikyuGendogakuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public enum KubunShikyuGendogakuSpec implements IPredicate<KubunShikyuGendogakuDiv> {

    /**
     * 重複の入力チェック。
     */
    重複の入力チェック {
                @Override
                public boolean apply(KubunShikyuGendogakuDiv div) {
                    return SpecHelper.is重複の入力チェック(div);
                }
            },
    /**
     * 必須入力項目の必須入力チェック場合。
     */
    必須入力項目の必須入力チェック場合 {
                @Override
                public boolean apply(KubunShikyuGendogakuDiv div) {
                    return SpecHelper.isが各必須入力項目の必須入力チェック場合(div);
                }
            };

    private static class SpecHelper {

        /**
         * 重複の入力チェックです。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public static boolean is重複の入力チェック(KubunShikyuGendogakuDiv div) {
            List<dgServiceShurui_Row> dataSource = div.getDgServiceShurui().getDataSource();
            RDate startDate = div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().getValue();
            RDate endDate = div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().getValue();
            dgServiceShurui_Row selectRow = div.getDgServiceShurui().getClickedItem();
            for (dgServiceShurui_Row item : dataSource) {
                if (item.equals(selectRow)) {
                    continue;
                }
                if (!item.getDefaultDataName3().isNullOrEmpty()) {
                    if (!(isYMCompare(new RDate(item.getDefaultDataName2().toString()),
                            new RDate(item.getDefaultDataName3().toString()), startDate, endDate))) {
                        return Boolean.FALSE;
                    }
                } else {
                    if (!(isYMCompare(new RDate(item.getDefaultDataName2().toString()),
                            null, startDate, endDate))) {
                        return Boolean.FALSE;
                    }
                }
            }
            return Boolean.TRUE;
        }

        /**
         * *が各必須入力項目の必須入力チェック場合です。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public static boolean isが各必須入力項目の必須入力チェック場合(KubunShikyuGendogakuDiv div) {
            return (div.getServiceShuruiShousai().getTxtServiceCode().getValue() != null
                    && div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().getValue() != null
                    && div.getServiceShuruiShousai().getTxtServiceMeisho().getValue() != null
                    && div.getServiceShuruiShousai().getTxtServiceRyakusho() != null);
        }

        private static boolean isYMCompare(RDate startTimeRow, RDate endTimeRow, RDate startDate, RDate endDate) {
            if (endTimeRow != null) {
                if (endDate != null) {
                    isYMNotNullCompare(startTimeRow, endTimeRow, startDate, endDate);
                } else {
                    if (startTimeRow.isBeforeOrEquals(startDate) && startDate.isBeforeOrEquals(endTimeRow)) {
                        return false;
                    }
                }
            } else {
                if (endDate != null) {
                    if (startDate.isBeforeOrEquals(startTimeRow) && startTimeRow.isBeforeOrEquals(endDate)) {
                        return false;
                    }
                } else {
                    if (startTimeRow.equals(startDate)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private static boolean isYMNotNullCompare(RDate startTimeRow, RDate endTimeRow, RDate startDate, RDate endDate) {
            return (!startTimeRow.isBeforeOrEquals(startDate) || !startDate.isBeforeOrEquals(endTimeRow))
                    && (!startTimeRow.isBeforeOrEquals(endDate) || !endDate.isBeforeOrEquals(endTimeRow));
        }
    }
}
