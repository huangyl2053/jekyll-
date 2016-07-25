/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokurenkei.JigyoHokokuRenkeiParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;

/**
 * 様式別連携情報作成のMapperクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 *
 */
public interface IJigyoHokokuRenkeiMapper {

    /**
     * 事業報告統計データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get事業報告統計情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計・一般状況・現物分データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get事業報告統計現物分情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計一般状況・償還分・審査年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get事業報告統計償還分審査年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計一般状況・償還分・決定年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get事業報告統計償還分決定年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計一般状況・合算分・審査年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get事業報告統計合算分審査年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計一般状況・合算分・決定年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get事業報告統計合算分決定年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計・保険給付決定状況・現物分データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get保険給付決定状況現物分情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計保険給付決定状況・償還分・審査年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get保険給付決定状況償還分審査年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計保険給付決定状況・償還分・決定年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get保険給付決定状況償還分決定年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計保険給付決定状況・合算分・審査年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get保険給付決定状況合算分審査年月情報の取得(JigyoHokokuRenkeiParameter parameter);

    /**
     * 事業報告統計保険給付決定状況・合算分・決定年月データを取得します。
     *
     * @param parameter 事業報告集計一覧用パラメータ
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>　事業報告統計データ
     */
    List<DbT7021JigyoHokokuTokeiDataEntity> get保険給付決定状況合算分決定年月情報の取得(JigyoHokokuRenkeiParameter parameter);
}
