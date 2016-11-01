/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050031;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険特別会計経理状況登録_様式４の２情報Divバリデーションクラスです。
 */
public enum YoshikiYonnoniSpec implements IPredicate<YoshikiYonnoniDiv> {

    報告年度必須チェック {
                /**
                 * 報告年度必須チェック
                 *
                 * @param div YoshikiYonnoniDiv
                 * @return true:報告年度があります、false:報告年度がありません。
                 */
                @Override
                public boolean apply(YoshikiYonnoniDiv div) {
                    return div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getValue() != null
                    && !div.getYoshikiYonnoniMeisai().getTxtHokokuYM().getValue().isEmpty();
                }
            },
    合計値チェック_合計１ {
                /**
                 * 合計値チェック_合計１
                 *
                 * @param div YoshikiYonnoniDiv
                 * @return true:歳入の決算額各項目の合計＝合計１項目、false:歳入の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(YoshikiYonnoniDiv div) {
                    ValidationHandler validationHandler = new ValidationHandler(div);
                    Decimal 合計値1 = validationHandler.get合計値1();
                    Decimal 合計1 = div.getYoshikiYonnoniMeisai().getTxtsainyugokei().getValue();
                    if (null == 合計1) {
                        return Decimal.ZERO.equals(合計値1);
                    }
                    return 合計値1.equals(合計1);
                }
            },
    合計値チェック_合計２ {
                /**
                 * 合計値チェック_合計２
                 *
                 * @param div YoshikiYonnoniDiv
                 * @return true:歳出の決算額各項目の合計＝合計１項目、false:歳出の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(YoshikiYonnoniDiv div) {
                    ValidationHandler validationHandler = new ValidationHandler(div);
                    Decimal 合計値2 = validationHandler.get合計値2();
                    Decimal 合計2 = div.getYoshikiYonnoniMeisai().getTxtsaishutsugokei().getValue();
                    if (null == 合計2) {
                        return Decimal.ZERO.equals(合計値2);
                    }
                    return 合計値2.equals(合計2);
                }
            }

}
