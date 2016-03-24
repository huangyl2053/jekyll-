/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishoshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukyufutaishoshain.KogakuKyufuTaishoshaInParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;

/**
 * 高額介護サービス費給付対象者取込みDB操作です。
 */
public interface IKogakuKyufuTaishoshaInMapper {

    /**
     * 一時テーブル取得する。
     *
     * @return List<KogakuKyufuTaishoshaIchiranhyoEntity>
     */
    List<DbTKogakuKyufuTaishoshaDataTempTableEntity> select一時テーブル();

    /**
     * updateDbT3054サービス提供年月
     */
    void updateDbT3054サービス提供年月();

    /**
     * updateDbT3055サービス提供年月
     */
    void updateDbT3055サービス提供年月();

    /**
     * insert高額介護サービス費給付対象者合計
     */
    void insert高額介護サービス費給付対象者合計();

    /**
     * insert高額介護サービス費給付対象者明細
     */
    void insert高額介護サービス費給付対象者明細();

    /**
     * select被保険者番号From一時テーブル
     *
     * @return DbTKogakuKyufuTaishoshaDataTempTableEntity
     */
    List<DbTKogakuKyufuTaishoshaDataTempTableEntity> select被保険者番号From一時テーブル();

    /**
     * 被保険者台帳管理から市町村コードを取得する。
     *
     * @param parameter parameter
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity select市町村コードFrom被保険者台帳管理(KogakuKyufuTaishoshaInParameter parameter);

    /**
     * 新旧被保険者番号変換から新被保険者番号を取得する。
     *
     * @param parameter parameter
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity
     */
    DbT7026ShinKyuHihokenshaNoHenkanEntity select新被保険者番号From新旧被保険者番号変換(
            KogakuKyufuTaishoshaInParameter parameter);

    /**
     * 高額サービス費給付対象者一時TBLの被保険者番号の更新
     *
     * @param entity DbT7026ShinKyuHihokenshaNoHenkanEntity
     */
    void update一時TBL被保険者番号(DbT7026ShinKyuHihokenshaNoHenkanEntity entity);

    /**
     * 世帯集約番号の取得
     *
     * @return DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity
     */
    List<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> select世帯集約番号();

    /**
     * update世帯集約番号
     *
     * @param entity DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity
     */
    void update世帯集約番号(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity);

}
