/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kanendoriyoshafutanwariaihantei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動分利用者負担割合判定（過年度）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-4940-030 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoRiyoshaFutanwariaiHanteiMybatisParameter implements IMyBatisParameter {

    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 処理名 処理名
     */
    public KanendoRiyoshaFutanwariaiHanteiMybatisParameter(RString 処理名) {
        this.処理名 = 処理名;
    }

}
