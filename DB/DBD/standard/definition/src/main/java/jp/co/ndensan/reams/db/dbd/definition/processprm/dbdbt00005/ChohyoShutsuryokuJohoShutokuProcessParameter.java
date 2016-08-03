/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00005;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00005.ChohyoShutsuryokuJohoShutokuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力情報の取得_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3880-050 x_lilh
 */
public class ChohyoShutsuryokuJohoShutokuProcessParameter implements IBatchProcessParameter {

    //TODO 帳票出力情報の取得_process処理のパラメター
    //    対象年月
    //年月範囲の開始
    //年月範囲の終了
    //事業者番号
    /**
     * コンストラクタです。
     *
     * @param パラメター パラメター(TODO)
     * @return 帳票出力情報の取得のMyBatis用パラメー
     */
    public ChohyoShutsuryokuJohoShutokuMybatisParameter toChohyoShutsuryokuJohoShutokuMybatisParameter(RString パラメター) {
        //TODO
        return new ChohyoShutsuryokuJohoShutokuMybatisParameter(パラメター);
    }
}
