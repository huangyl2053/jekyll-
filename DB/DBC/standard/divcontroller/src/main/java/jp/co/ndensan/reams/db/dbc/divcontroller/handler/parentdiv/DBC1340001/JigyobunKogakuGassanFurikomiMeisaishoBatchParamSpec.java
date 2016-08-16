/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1340001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001.JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * DBCMNN2004_事業合算・事業分振込明細書作成（一括）のクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public enum JigyobunKogakuGassanFurikomiMeisaishoBatchParamSpec implements IPredicate<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> {

    /**
     * 依頼日範囲のチック
     */
    依頼日範囲のチック {
                @Override
                public boolean apply(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
                    return SpecHelper.check依頼日範囲(div);
                }
            },
    /**
     * 日付関係チェック
     */
    日付関係 {
                @Override
                public boolean apply(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
                    return SpecHelper.check日付関係(div);
                }
            };

    private static class SpecHelper {

        /**
         * 今回対象年月日 From　＞　今回対象年月日 Toのの場合、エラー
         *
         * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check日付関係(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
            RDate 今回対象年月日_FROM = div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().getFromValue();
            RDate 今回対象年月日_TO = div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().getToValue();
            if (null == 今回対象年月日_FROM || null == 今回対象年月日_TO) {
                return true;
            }
            return 今回対象年月日_FROM.isBeforeOrEquals(今回対象年月日_TO);
        }

        /**
         * 作成日≦依頼日≦振込指定日 以外のの場合、エラー
         *
         * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean check依頼日範囲(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
            RDate 作成日 = div.getShuturyokuTyouhyou().getTxtSakuseibi().getValue();
            RDate 依頼日 = div.getShuturyokuTyouhyou().getTxtIraibi().getValue();
            RDate 振込指定日 = div.getShuturyokuTyouhyou().getTxtFurikomiSiteibi().getValue();
            return 作成日.isBeforeOrEquals(依頼日) && 依頼日.isBeforeOrEquals(振込指定日);
        }
    }
}
