/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jigosakuseimeisaitouroku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku.KubunGendoParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku.KyufuJikoSakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku.TankiNyushoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KubunGendoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.KyufuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.ServiceTypeTotalEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei.TankiNyushoEntity;

/**
 * サービス利用票情報 Mapperインタファースクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
public interface IJigoSakuseiMeisaiTourokuMapper {

    /**
     * サービス種類支給額を取得します。
     *
     * @param param Map<String, Object>
     * @return List<ServiceTypeTotalEntity>
     */
    List<ServiceTypeTotalEntity> getサービス種類支給額(Map<String, Object> param);

    /**
     * サービス種類支給額を取得します。
     *
     * @param param KyufuJikoSakuseiParameter
     * @return List<KyufuJikoSakuseiEntity>
     */
    List<KyufuJikoSakuseiEntity> getサービス利用票データ(KyufuJikoSakuseiParameter param);

    /**
     * 区分限度額統計データを取得します。
     *
     * @param param KubunGendoParameter
     * @return KubunGendoEntity
     */
    KubunGendoEntity get区分限度額統計処理(KubunGendoParameter param);

    /**
     * 短期入所情報を取得します。
     *
     * @param param TankiNyushoParameter
     * @return TankiNyushoEntity
     */
    TankiNyushoEntity get短期入所情報(TankiNyushoParameter param);
}
