/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細一覧表作成Process処理パラメタークラスです
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShikyugakuJohoProcessParameter implements IBatchProcessParameter {

    private Long 出力順ID;
    private Furikomi_ShoriKubun 処理区分;
    private Furikomi_ShihraiHohoShitei 支払方法;

    /**
     * コンストラクタ
     *
     * @param 出力順ID 出力順ID
     * @param 処理区分 処理区分
     * @param 支払方法 支払方法
     */
    public ShikyugakuJohoProcessParameter(Long 出力順ID, Furikomi_ShoriKubun 処理区分, Furikomi_ShihraiHohoShitei 支払方法) {
        this.出力順ID = 出力順ID;
        this.処理区分 = 処理区分;
        this.支払方法 = 支払方法;
    }

}
