/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicenokanribangourendou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicenokanribangourendou.JigyouKetteiTutisyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.ServiceNoKanribangouRendouEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;

/**
 * 高額サービス費支給決定通知書（単）用のマッパーインタフェースです。
 *
 * @reamsid_L DBC-5160-030 chenxin
 */
public interface IServiceNoKanribangouRendou2Mapper {

    /**
     * 高額介護サービス費支給情報を取得します。
     *
     * @param param JigyouKetteiTutisyoParameter
     * @return ServiceNoKanribangouRendouEntity
     */
    ServiceNoKanribangouRendouEntity get高額介護サービス費支給情報(JigyouKetteiTutisyoParameter param);

    /**
     * 高額介護サービス費給付対象者明細情報を取得します。
     *
     * @param param JigyouKetteiTutisyoParameter
     * @return List<DbT3054KogakuKyufuTaishoshaMeisaiEntity>
     */
    List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> get対象者明細情報(JigyouKetteiTutisyoParameter param);
}
