/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigosakuseimeisaitouroku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KubunGendoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceRiyohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceTypeTotalEntity;

/**
 * ビジネス設計_DBC0120031_サービス利用票情報 Mapper
 *
 * @reamsid_L DBC-1930-060 xupeng
 */
public interface IJigoSakuseiMeisaiTourokuMapper {

    /**
     * サービス種類支給額取得
     *
     * @param param Map<String, Object>
     * @return List<ServiceTypeTotalEntity>
     */
    List<ServiceTypeTotalEntity> getサービス種類支給額(Map<String, Object> param);

    /**
     * サービス種類支給額取得
     *
     * @param param Map<String, Object>
     * @return List<ServiceRiyohyoEntity>
     */
    List<ServiceRiyohyoEntity> getサービス利用票データ(Map<String, Object> param);

    /**
     * 区分限度額統計処理
     *
     * @param param Map<String, Object>
     * @return KubunGendoEntity
     */
    KubunGendoEntity get区分限度額統計処理(Map<String, Object> param);
}
