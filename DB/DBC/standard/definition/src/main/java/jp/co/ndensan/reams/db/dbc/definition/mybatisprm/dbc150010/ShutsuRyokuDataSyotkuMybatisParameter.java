/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 出力対象データ取得のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutsuRyokuDataSyotkuMybatisParameter implements IMyBatisParameter {

    private RString 出力順;
    private boolean isSort旧市町村コード;
    private final RString isTrue = new RString("1");
}
