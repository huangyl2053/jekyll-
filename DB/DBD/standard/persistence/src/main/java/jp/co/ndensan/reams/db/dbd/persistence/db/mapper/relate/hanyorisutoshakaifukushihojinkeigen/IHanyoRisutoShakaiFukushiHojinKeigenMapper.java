/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutoshakaifukushihojinkeigen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEntity;

/**
 * 汎用リスト出力(社会福祉法人軽減)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3900-030 mawy
 */
public interface IHanyoRisutoShakaiFukushiHojinKeigenMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<HanyoRisutoShakaiFukushiHoujinKeigenEntity>
     */
    List<ShakaiFukushiHojinKeigenEntity> get汎用リスト(ShakaiFukushiHojinKeigenMybatisParameter parameter);
}
