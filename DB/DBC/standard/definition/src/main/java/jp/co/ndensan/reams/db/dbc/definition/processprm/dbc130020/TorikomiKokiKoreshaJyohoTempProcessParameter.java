/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取込後期高齢者情報Tempに更新ProcessParameterです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiKokiKoreshaJyohoTempProcessParameter implements IBatchProcessParameter {

    private RString 保険者区分;
    private RString 表題;
    private RString 市町村識別ID;
    private RString IF種類;
    private RString 取込形式;
    private RString 処理日時;

    public TorikomiKokiKoreshaJyohoTempProcessParameter(RString 保険者区分, RString 表題,
            RString 市町村識別ID, RString IF種類, RString 取込形式, RString 処理日時) {

        this.保険者区分 = 保険者区分;
        this.表題 = 表題;
        this.市町村識別ID = 市町村識別ID;
        this.IF種類 = IF種類;
        this.取込形式 = 取込形式;
        this.処理日時 = 処理日時;
    }
}
