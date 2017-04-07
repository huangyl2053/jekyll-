/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd130020;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 取込国保情報Tempに更新ProcessParameterです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdTorikomiKokuhoJyohoTempProcessParameter implements IBatchProcessParameter {

    private RString 保険者区分;
    private RString 表題;
    private List<RString> 処理対象市町村;
    private RString iF種類;
    private RString 取込形式;
    private RString 処理日時;

    /**
     *
     * @param 保険者区分 RString
     * @param 表題 RString
     * @param 処理対象市町村 List<RString>
     * @param iF種類 RString
     * @param 取込形式 RString
     * @param 処理日時 RString
     */
    public UpdTorikomiKokuhoJyohoTempProcessParameter(RString 保険者区分, RString 表題,
            List<RString> 処理対象市町村, RString iF種類, RString 取込形式, RString 処理日時) {

        this.保険者区分 = 保険者区分;
        this.表題 = 表題;
        this.処理対象市町村 = 処理対象市町村;
        this.iF種類 = iF種類;
        this.取込形式 = 取込形式;
        this.処理日時 = 処理日時;
    }
}
