/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tokubetsutiikikasannkeigennjiqsekikannri;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00005.KyufuJisekiSanshoKeyCreateMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00005.temptable.KyufuJisekiSanshoKeyTempTableEntity;

/**
 * 給付実績参照キー作成のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3880-030 x_lilh
 */
public interface IKyufuJisekiSanshoKeyCreateMapper {

    //TODO 対応のxml該当は実装する、現行ソースに存在しませんが
    /**
     * 給付実績参照キー作成情報を取得します．
     *
     * @param parameter 給付実績参照キー作成情報パラメター
     * @return 給付実績参照キー作成情報
     */
    List<KyufuJisekiSanshoKeyTempTableEntity> get給付実績参照キー作成情報(KyufuJisekiSanshoKeyCreateMybatisParameter parameter);
}
