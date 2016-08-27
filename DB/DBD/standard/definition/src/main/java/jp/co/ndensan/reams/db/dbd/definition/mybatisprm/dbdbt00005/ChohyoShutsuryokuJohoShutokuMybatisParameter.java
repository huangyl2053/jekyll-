/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00005;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力情報の取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3880-050 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoShutsuryokuJohoShutokuMybatisParameter implements IMyBatisParameter {
    // TODO SQL使用のパラメター
    //

    private RString パラメター;

    /**
     * コンストラクタです。
     *
     * @param パラメター パラメター(TODO)
     */
    public ChohyoShutsuryokuJohoShutokuMybatisParameter(RString パラメター) {
        //TODO
        this.パラメター = パラメター;
    }
}
