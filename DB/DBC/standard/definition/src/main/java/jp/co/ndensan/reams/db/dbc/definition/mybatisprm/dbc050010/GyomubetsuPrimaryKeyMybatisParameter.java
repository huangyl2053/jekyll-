/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還口座払の口座情報取得の業務別主キー取得のMybatisパラメータ。
 *
 * @reamsid_L DBC-2180-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GyomubetsuPrimaryKeyMybatisParameter implements IMyBatisParameter {

    private KamokuCode 科目コード;
}
