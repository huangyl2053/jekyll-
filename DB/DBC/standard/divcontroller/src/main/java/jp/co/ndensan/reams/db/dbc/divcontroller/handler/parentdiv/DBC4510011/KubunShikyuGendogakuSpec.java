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
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
                    if (!div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().isDisabled()) {
                        return SpecHelper.is重複の入力チェック(div);
                    } else {
                        return true;
                    }
                }
            },
    /**
     * 必須入力項目の必須入力チェック場合。
     */
    サービス種類コードの必須入力チェック場合 {
                @Override
                public boolean apply(KubunShikyuGendogakuDiv div) {
                    return SpecHelper.isがサービス種類コードが未入力の場合の必須入力チェック場合(div);
                }
            },
    /**
     * 必須入力項目の必須入力チェック場合。
     */
    提供開始年月の必須入力チェック場合 {
                @Override
                public boolean apply(KubunShikyuGendogakuDiv div) {
                    return SpecHelper.isが提供開始年月が未入力の場合の必須入力チェック場合(div);
                }
            },
    /**
     * 必須入力項目の必須入力チェック場合。
     */
    名称の必須入力チェック場合 {
                @Override
                public boolean apply(KubunShikyuGendogakuDiv div) {
                    return SpecHelper.isが名称が未入力の場合の必須入力チェック場合(div);
                }
            },
    /**
     * 必須入力項目の必須入力チェック場合。
     */
    略称の必須入力チェック場合 {
                @Override
                public boolean apply(KubunShikyuGendogakuDiv div) {
                    return SpecHelper.isが略称が未入力の場合の必須入力チェック場合(div);
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
            RString serviceCode = div.getServiceShuruiShousai().getTxtServiceCode().getValue();
            for (dgServiceShurui_Row item : dataSource) {
                if ((item.getDefaultDataName1().equals(serviceCode)
                        && (item.getDefaultDataName3() == null || item.getDefaultDataName3().isEmpty()))
                        && startDate.isBeforeOrEquals(new RDate(item.getDefaultDataName2().toString()))) {
                    return false;
                }
            }
            return Boolean.TRUE;
        }

        /**
         * *が各必須入力項目の必須入力チェック場合です。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public static boolean isがサービス種類コードが未入力の場合の必須入力チェック場合(KubunShikyuGendogakuDiv div) {
            return !RString.isNullOrEmpty(div.getServiceShuruiShousai().getTxtServiceCode().getValue());
        }

        /**
         * *が各必須入力項目の必須入力チェック場合です。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public static boolean isが提供開始年月が未入力の場合の必須入力チェック場合(KubunShikyuGendogakuDiv div) {
            return div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().getValue() != null;
        }

        /**
         * *が各必須入力項目の必須入力チェック場合です。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public static boolean isが名称が未入力の場合の必須入力チェック場合(KubunShikyuGendogakuDiv div) {
            return !RString.isNullOrEmpty(div.getServiceShuruiShousai().getTxtServiceMeisho().getValue());
        }

        /**
         * *が各必須入力項目の必須入力チェック場合です。
         *
         * @param div DvShikyuNinteiParamDiv
         */
        public static boolean isが略称が未入力の場合の必須入力チェック場合(KubunShikyuGendogakuDiv div) {
            return !RString.isNullOrEmpty(div.getServiceShuruiShousai().getTxtServiceRyakusho().getValue());
        }

    }
}
