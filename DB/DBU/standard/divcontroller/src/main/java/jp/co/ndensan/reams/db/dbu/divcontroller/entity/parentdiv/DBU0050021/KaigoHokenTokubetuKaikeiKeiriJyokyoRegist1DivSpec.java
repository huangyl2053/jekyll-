/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
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
            }
}
