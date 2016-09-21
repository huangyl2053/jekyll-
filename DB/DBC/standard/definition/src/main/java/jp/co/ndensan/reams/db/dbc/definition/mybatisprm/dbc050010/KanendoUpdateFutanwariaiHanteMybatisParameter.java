/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-5010-030 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoUpdateFutanwariaiHanteMybatisParameter implements IMyBatisParameter {

    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 処理名 処理名
     */
    public KanendoUpdateFutanwariaiHanteMybatisParameter(RString 処理名) {
        this.処理名 = 処理名;
    }

}
