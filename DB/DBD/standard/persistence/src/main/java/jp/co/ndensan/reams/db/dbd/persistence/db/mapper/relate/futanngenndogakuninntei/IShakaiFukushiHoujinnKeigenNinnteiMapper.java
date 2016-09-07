/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiEntity;

/**
 * 社会福祉法人等軽減の認定証発行のMapperクラスです。
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
public interface IShakaiFukushiHoujinnKeigenNinnteiMapper {

    /**
     * 社会福祉法人等軽減の認定証発行情報を取得します．
     *
     * @param parameter パラメター
     * @return 社会福祉法人等軽減の認定証発行情報
     */
    List<ShakaiFukushiHoujinnKeigenNinnteiEntity> get社会福祉法人等軽減の認定証発行情報(ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter parameter);
}
