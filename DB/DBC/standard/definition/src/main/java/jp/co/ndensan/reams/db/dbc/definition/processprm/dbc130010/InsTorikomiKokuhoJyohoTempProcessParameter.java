/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取込国保情報Tempに登録
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTorikomiKokuhoJyohoTempProcessParameter implements IBatchProcessParameter {

    private RString 保険者区分;
    private RString 表題;
    private RString 市町村識別ID;
    private RString if種類;
    private RString 取込形式;
    private RString 処理日時;

    /**
     *
     * @param 保険者区分 RString
     * @param 表題 RString
     * @param 処理対象市町村 List<RString>
     * @param if種類 RString
     * @param 取込形式 RString
     * @param 処理日時 RString
     */
    public InsTorikomiKokuhoJyohoTempProcessParameter(RString 保険者区分, RString 表題,
            RString 市町村識別ID, RString if種類, RString 取込形式, RString 処理日時) {

        this.保険者区分 = 保険者区分;
        this.表題 = 表題;
        this.市町村識別ID = 市町村識別ID;
        this.if種類 = if種類;
        this.取込形式 = 取込形式;
        this.処理日時 = 処理日時;
    }
}
