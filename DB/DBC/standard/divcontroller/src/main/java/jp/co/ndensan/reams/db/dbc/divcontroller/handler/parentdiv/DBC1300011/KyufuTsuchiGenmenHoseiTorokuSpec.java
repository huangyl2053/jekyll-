/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *画面設計_DBCMN71001_給付費通知減免情報補正登録のSpecです。
 * 
 * @reamsid_L DBC-2260-010 guyan
 */
public enum KyufuTsuchiGenmenHoseiTorokuSpec implements IPredicate<KyufuTsuchiGenmenHoseiTorokuDiv> {
    
    /**
     * 最大取得件数不正
     */
    最大取得件数不正 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            Decimal 最大取得件数 = div.getKyufuTsuchiGenmenHoseiTorokuSearch().getTextBoxNumKensuu().getValue();
            if ((最大取得件数.compareTo(Decimal.ONE) > 0 || 最大取得件数.compareTo(Decimal.ONE) == 0)
                && (最大取得件数.compareTo(new Decimal(SpecHelper.INT_999)) < 0 || 最大取得件数.compareTo(new Decimal(SpecHelper.INT_999)) == 0)) {
                flag = true;
            }
            return flag;
        }
    },
    /**
     * サービス年月入力
     */
    サービス年月入力 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            if (div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu().getValue() != null) {
                flag = true;
            }
            return flag;
        }
    },
    /**
     * 証記載保険者番号入力
     */
    証記載保険者番号入力 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            if (div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdHokenshaList().getSelectedItem() != null) {
                flag = true;
            }
            return flag;
        }
    },
    /**
     * 事業者入力
     */
    事業者入力 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            if (!div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().getNyuryokuShisetsuKodo().isNull()
                    && !div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().getNyuryokuShisetsuKodo().isEmpty()) {
                flag = true;
            }
            return flag;
        }
    },
    /**
     * サービス種類入力
     */
    サービス種類入力 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            if (!div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput().getサービス種類コード().isNull()
                    && !div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput().getサービス種類コード().isEmpty()) {
                flag = true;
            }
            return flag;
        }
    },
    /**
     * 利用者負担額合計入力
     */
    利用者負担額合計入力 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            if (div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxFudangoukei().getValue() != null) {
                flag = true;
            }
            return flag;
        }
    },
    /**
     * サービス費用合計入力
     */
    サービス費用合計入力 {
        @Override
        public boolean apply(KyufuTsuchiGenmenHoseiTorokuDiv div) {
            boolean flag = false;
            if (div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxNumHiyouGoukei().getValue() != null) {
                flag = true;
            }
            return flag;
        }
    };
    
    private static class SpecHelper {
        private static final int INT_999 = 999;
    }
}
