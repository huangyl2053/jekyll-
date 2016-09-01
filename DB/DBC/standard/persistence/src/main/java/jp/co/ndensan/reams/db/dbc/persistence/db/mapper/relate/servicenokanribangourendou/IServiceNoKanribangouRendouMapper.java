/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicenokanribangourendou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicenokanribangourendou.JigyouKetteiTutisyoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicenokanribangourendou.ServiceNoKanribangouRendouEntity;

/**
 * 新総合事業・事業高額決定通知書（単）用のマッパーインタフェースです。
 *
 * @reamsid_L DBC-4760-050 cuilin
 */
public interface IServiceNoKanribangouRendouMapper {

    /**
     * 事業高額介護サービス費支給情報を取得します。
     *
     * @param param JigyouKetteiTutisyoParameter
     * @return ServiceNoKanribangouRendouEntity
     */
    ServiceNoKanribangouRendouEntity get事業高額介護サービス費支給情報(JigyouKetteiTutisyoParameter param);

    /**
     * 事業高額介護サービス費給付対象者明細情報を取得します。
     *
     * @param param JigyouKetteiTutisyoParameter
     * @return List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity>
     */
    List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> get対象者明細情報(JigyouKetteiTutisyoParameter param);
}
