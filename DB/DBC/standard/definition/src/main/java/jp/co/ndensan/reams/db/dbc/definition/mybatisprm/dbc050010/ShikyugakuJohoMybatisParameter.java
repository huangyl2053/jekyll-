/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式番号別支給金額情報取得SQL用
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyugakuJohoMybatisParameter implements IMyBatisParameter {

    private RString 出力順;

    /**
     * 送付対象データ取得用DBデータ取得MybatisParameter
     *
     * @param 出力順 RString
     */
    public ShikyugakuJohoMybatisParameter(RString 出力順) {
        this.出力順 = 出力順;
    }
}
