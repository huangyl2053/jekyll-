/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.sokujikosei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;

/**
 * 即時賦課更正処理のマッピングクラスです。
 *
 * @reamsid_L DBB-0660-020 cuilin
 */
public interface ISokujiFukaKoseiMapper {

    /**
     * 賦課の情報を取得します。
     *
     * @param map Map<String, Object> map
     * @return FukaJohoRelateEntity
     */
    FukaJohoRelateEntity get賦課の情報By通知書番号(Map<String, Object> map);

    /**
     * 賦課の情報を取得します。
     *
     * @param map Map<String, Object> map
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoRelateEntity> get賦課の情報By被保険者番号(Map<String, Object> map);

    /**
     * 生保の情報を取得します。
     *
     * @param map Map<String, Object> map
     * @return List<SeikatsuHogoJukyushaRelateEntity>
     */
    List<SeikatsuHogoJukyushaRelateEntity> get生保の情報(Map<String, Object> map);

    /**
     * 境界層の情報の取得します。
     *
     * @param map Map<String, Object>
     * @return List<KyokaisoGaitoshaEntity>
     */
    List<KyokaisoGaitoshaEntity> get境界層の情報(Map<String, Object> map);

    /**
     * 賦課の情報を取得します。
     *
     * @param map Map<String, Object>
     * @return FukaJohoRelateEntity
     */
    FukaJohoRelateEntity get賦課の情報(Map<String, Object> map);
}
