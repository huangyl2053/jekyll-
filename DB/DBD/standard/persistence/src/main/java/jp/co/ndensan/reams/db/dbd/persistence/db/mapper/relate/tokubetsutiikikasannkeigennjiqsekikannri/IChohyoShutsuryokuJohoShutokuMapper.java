/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tokubetsutiikikasannkeigennjiqsekikannri;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00005.ChohyoShutsuryokuJohoShutokuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00005.ChohyoShutsuryokuJohoShutokuResultEntity;

/**
 * 帳票出力情報の取得のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3880-030 x_lilh
 */
public interface IChohyoShutsuryokuJohoShutokuMapper {

    // TODO 対応のxml該当は実装する、現行ソースに存在しませんが
    /**
     * 帳票出力情報を取得します．
     *
     * @param parameter 帳票出力情報使用パラメター
     * @return 帳票出力情報
     */
    List<ChohyoShutsuryokuJohoShutokuResultEntity> get帳票出力情報(ChohyoShutsuryokuJohoShutokuMybatisParameter parameter);

}
