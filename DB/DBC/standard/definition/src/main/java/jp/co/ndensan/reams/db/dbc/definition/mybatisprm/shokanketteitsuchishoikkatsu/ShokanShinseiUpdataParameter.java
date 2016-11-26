/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成_償還払支給申請のデータを更新するMyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanShinseiUpdataParameter implements IMyBatisParameter {

    private static final RString 発行しない = new RString("0");

    private boolean isHako;

    private ShokanShinseiUpdataParameter(boolean isHako) {

        this.isHako = isHako;
    }

    /**
     * 償還払支給申請更新のMyBatisパラメータを作成します。
     *
     * @param 発行有無 RString
     * @return 償還払い支給（不支給）決定通知書一括作成のMyBatisパラメータ
     */
    public static ShokanShinseiUpdataParameter createParam(RString 発行有無) {
        boolean isHako2 = false;
        if (発行しない.endsWith(発行有無)) {
            isHako2 = true;
        }
        return new ShokanShinseiUpdataParameter(isHako2);

    }

}
