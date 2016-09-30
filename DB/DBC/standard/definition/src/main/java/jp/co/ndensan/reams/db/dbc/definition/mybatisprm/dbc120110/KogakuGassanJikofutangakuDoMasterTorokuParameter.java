/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120110;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 37J_高額合算自己負担額確認情報取込(マスタ登録)パラメータです。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuDoMasterTorokuParameter implements IMyBatisParameter {

    private RString 処理区分;
    private FlexibleYearMonth 処理年月;
}
