/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshikyuketteiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin.DbWT0002InsertParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin.ShokanShikyuMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiInResultEntity;

/**
 *
 * @reamsid_L DBC-0980-331 chenaoqi
 */
public interface IShokanShikyuKetteiInMapper {

    /**
     * get判定結果被保険一時
     *
     * @return List<ShokanShikyuKetteiInResultEntity>
     */
    List<ShokanShikyuKetteiInResultEntity> get判定結果被保険一時();

    /**
     * update償還払支給判定結果一時_更新DB有無
     *
     * @param entity ShokanShikyuKetteiInResultEntity
     */
    void update償還払支給判定結果一時_更新DB有無(ShokanShikyuKetteiInResultEntity entity);

    /**
     * update償還払支給判定結果一時_福祉用具事業者番号
     *
     * @param entity DbT3048ShokanFukushiYoguHanbaihiEntity
     */
    void update償還払支給判定結果一時_福祉用具事業者番号(DbT3048ShokanFukushiYoguHanbaihiEntity entity);

    /**
     * update償還払支給判定結果一時_住宅改修事業者番号
     *
     * @param entity DbT3049ShokanJutakuKaishuEntity
     */
    void update償還払支給判定結果一時_住宅改修事業者番号(DbT3049ShokanJutakuKaishuEntity entity);

    /**
     * insert処理結果リスト一時TBL_申請
     *
     * @param dbParameter DbWT0002InsertParameter
     */
    void insert処理結果リスト一時TBL_申請(DbWT0002InsertParameter dbParameter);

    /**
     * insert処理結果リスト一時TBL_再処理
     *
     * @param dbParameter DbWT0002InsertParameter
     */
    void insert処理結果リスト一時TBL_再処理(DbWT0002InsertParameter dbParameter);

    /**
     * 警告エラーデータの取得
     *
     * @return List<ShokanShikyuKetteiInResultEntity>
     */
    List<ShokanShikyuKetteiInResultEntity> get警告エラーデータ();

    /**
     * update重複データ
     *
     * @param entity ShokanShikyuKetteiInResultEntity
     */
    void update重複データ(ShokanShikyuKetteiInResultEntity entity);

    /**
     * 福祉用具事業所番号の取得
     *
     * @return List<ShokanShikyuKetteiInResultEntity>
     */
    List<ShokanShikyuKetteiInResultEntity> get福祉用具事業所番号();

    /**
     * 住宅改修事業所番号の取得
     *
     * @return List<ShokanShikyuKetteiInResultEntity>
     */
    List<ShokanShikyuKetteiInResultEntity> get住宅改修事業所番号();

    /**
     * 償還払請求集計データの取得
     *
     * @return List<ShokanShikyuEntity>
     */
    List<ShokanShikyuEntity> select償還払請求集計データ();

    /**
     * select償還払請求食事費用データの取得
     *
     * @return List<ShokanShikyuEntity>
     */
    List<ShokanShikyuEntity> select償還払請求食事費用データ();

    /**
     * select償還払請求サービス計画200004データの取得
     *
     * @return List<ShokanShikyuEntity>
     */
    List<ShokanShikyuEntity> select償還払請求サービス計画200004データ();

    /**
     * select償還払請求サービス計画200604データの取得
     *
     * @return List<ShokanShikyuEntity>
     */
    List<ShokanShikyuEntity> select償還払請求サービス計画200604データ();

    /**
     * select償還払請求サービス計画200904データの取得
     *
     * @return List<ShokanShikyuEntity>
     */
    List<ShokanShikyuEntity> select償還払請求サービス計画200904データ();

    /**
     * select介護サービス費用データの取得
     *
     * @return List<ShokanShikyuEntity>
     */
    List<ShokanShikyuEntity> select介護サービス費用データ();

    /**
     * update償還払支給判定結果一時_更新DBあり
     *
     * @param 判定結果一時Entity DbWT3036ShokanHanteiKekkaEntity
     */
    void update償還払支給判定結果一時_更新DBあり(DbWT3036ShokanHanteiKekkaEntity 判定結果一時Entity);

    /**
     * update償還払支給判定結果一時
     */
    void update償還払支給判定結果一時();

    /**
     * select償還払支給判定結果データ
     *
     * @param parameter ShokanShikyuMyBatisParameter
     * @return List<DbT3036ShokanHanteiKekkaEntity>
     */
    List<DbT3036ShokanHanteiKekkaEntity> select償還払支給判定結果データ(ShokanShikyuMyBatisParameter parameter);

    /**
     * get償還払支給判定結果集計データの取得
     *
     * @return List<ShokanShikyuKetteiInResultEntity>
     */
    List<ShokanShikyuKetteiInResultEntity> get償還払支給判定結果集計();

}
