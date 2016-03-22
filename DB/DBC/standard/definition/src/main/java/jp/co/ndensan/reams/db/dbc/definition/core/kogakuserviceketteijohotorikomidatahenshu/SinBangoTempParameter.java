/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新番号の取得に対するMapperパラメータ
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinBangoTempParameter {

    private final RString 新番号;
    private final RString 旧番号;

    private SinBangoTempParameter(RString 新番号,
            RString 旧番号) {
        this.新番号 = 新番号;
        this.旧番号 = 旧番号;
    }

    /**
     * 新番号を取得するパラメータ作成
     *
     * @param 新番号 RString
     * @param 旧番号 RString
     * @return SinBangoTempParameter
     */
    public static SinBangoTempParameter createParameter(
            RString 新番号,
            RString 旧番号) {
        return new SinBangoTempParameter(新番号, 旧番号);
    }

}
