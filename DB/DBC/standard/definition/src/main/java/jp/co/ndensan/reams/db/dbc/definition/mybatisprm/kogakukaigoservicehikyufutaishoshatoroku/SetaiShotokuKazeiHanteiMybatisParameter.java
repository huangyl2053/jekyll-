/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 世帯把握（バッチ）のバッチのパラメータです
 *
 * @reamsid_L DBC-2010-090 jiangzongyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SetaiShotokuKazeiHanteiMybatisParameter implements IMyBatisParameter {

    private final RString 管理識別区分;

    /**
     * コンストラクタです
     *
     * @param 管理識別区分 RString
     */
    public SetaiShotokuKazeiHanteiMybatisParameter(RString 管理識別区分) {
        this.管理識別区分 = 管理識別区分;
    }
}
