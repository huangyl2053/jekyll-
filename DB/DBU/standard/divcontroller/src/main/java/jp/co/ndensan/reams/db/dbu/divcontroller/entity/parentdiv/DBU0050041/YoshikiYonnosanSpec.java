/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;

import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0050041.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険特別会計経理状況登録_様式４の３情報Divバリデーションクラスです。
 */
public enum YoshikiYonnosanSpec implements IPredicate<YoshikiYonnosanDiv> {

    報告年度必須チェック {
                /**
                 * 報告年度必須チェック
                 *
                 * @param div YoshikiYonnosanDiv
                 * @return true:報告年度があります、false:報告年度がありません。
                 */
                @Override
                public boolean apply(YoshikiYonnosanDiv div) {
                    return div.getYoshikiYonnosanMeisai().getTxtHokokuYM().getValue() != null;
                }
            },
    前年度以前_合計値チェック_合計１ {
                /**
                 * 前年度以前_合計値チェック_合計１
                 *
                 * @param div YoshikiYonnosanDiv
                 * @return true:歳入の決算額各項目の合計＝合計１項目、false:歳入の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(YoshikiYonnosanDiv div) {
                    KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(div);
                    Decimal 合計値1 = handler.get前年度以前_合計値1();
                    Decimal 合計1 = div.getYoshikiYonnosanMeisai().getTxtshiyohigokei().getValue();
                    if (null == 合計1) {
                        return Decimal.ZERO.equals(合計値1);
                    }
                    return 合計値1.equals(合計1);
                }
            },
    前年度以前_合計値チェック_合計２ {
                /**
                 * 前年度以前_合計値チェック_合計２
                 *
                 * @param div YoshikiYonnosanDiv
                 * @return true:歳出の決算額各項目の合計＝合計１項目、false:歳出の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(YoshikiYonnosanDiv div) {
                    KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(div);
                    Decimal 合計値2 = handler.get前年度以前_合計値2();
                    Decimal 合計2 = div.getYoshikiYonnosanMeisai().getTxtsaishutsugokei().getValue();
                    if (null == 合計2) {
                        return Decimal.ZERO.equals(合計値2);
                    }
                    return 合計値2.equals(合計2);
                }
            },
    今年度_合計値チェック_合計１ {
                /**
                 * 今年度_合計値チェック_合計１
                 *
                 * @param div YoshikiYonnosanDiv
                 * @return true:歳入の決算額各項目の合計＝合計１項目、false:歳入の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(YoshikiYonnosanDiv div) {
                    KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(div);
                    Decimal 合計値1 = handler.get今年度_合計値1();
                    Decimal 合計1 = div.getYoshikiYonnosanMeisai().getTxtkoshiyohigokei().getValue();
                    if (null == 合計1) {
                        return Decimal.ZERO.equals(合計値1);
                    }
                    return 合計値1.equals(合計1);
                }
            },
    今年度_合計値チェック_合計２ {
                /**
                 * 今年度_合計値チェック_合計２
                 *
                 * @param div YoshikiYonnosanDiv
                 * @return true:歳出の決算額各項目の合計＝合計１項目、false:歳出の決算額各項目の合計＝合計１項目でない。
                 */
                @Override
                public boolean apply(YoshikiYonnosanDiv div) {
                    KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler handler
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegist3Handler(div);
                    Decimal 合計値2 = handler.get今年度_合計値2();
                    Decimal 合計2 = div.getYoshikiYonnosanMeisai().getTxtkosaishutsugokei().getValue();
                    if (null == 合計2) {
                        return Decimal.ZERO.equals(合計値2);
                    }
                    return 合計値2.equals(合計2);
                }
            }

}
