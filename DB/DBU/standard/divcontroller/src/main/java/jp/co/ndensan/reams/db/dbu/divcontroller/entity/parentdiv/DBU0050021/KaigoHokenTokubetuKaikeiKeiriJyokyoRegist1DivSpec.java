/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021;

import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 介護保険特別会計経理状況登録_様式４情報Divバリデーションクラスです。
 */
public enum KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1DivSpec implements IPredicate<KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div> {

    報告年度必須チェック {
                /**
                 * 報告年度必須チェック
                 *
                 * @param div KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div
                 * @return true:報告年度があります、false:報告年度がありません。
                 */
                @Override
                public boolean apply(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
                    TextBoxFlexibleDate 報告年度 = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
                    return (報告年度 != null && !報告年度.getValue().isEmpty());
                }
            },
    合計値チェック_合計１ {
                /**
                 * 合計値チェック_合計１
                 *
                 * @param div KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div
                 * @return true:歳入の決算額各項目の合計＝合計１項目、false:歳入の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
                    KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler(div);
                    Decimal 合計値1 = handler.get合計値1();
                    Decimal 合計1 = div.getTxtsainyugokei().getValue();
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
                 * @param div KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div
                 * @return true:歳出の決算額各項目の合計＝合計２項目、false:歳出の決算額各項目の合計＝合計２項目でない。
                 */
                @Override
                public boolean apply(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
                    KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler handler
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler(div);
                    Decimal 合計値2 = handler.get合計値2();
                    Decimal 合計2 = div.getTxtsaishutsugoukei().getValue();
                    if (null == 合計2) {
                        return Decimal.ZERO.equals(合計値2);
                    }
                    return 合計値2.equals(合計2);
                }
            }
}
