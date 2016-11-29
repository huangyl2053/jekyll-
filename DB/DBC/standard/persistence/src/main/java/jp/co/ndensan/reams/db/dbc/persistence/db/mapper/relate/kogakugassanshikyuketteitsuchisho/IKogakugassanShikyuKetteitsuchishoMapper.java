/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyuketteitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshikyuketteitsuchisho.KogakuGassanShikyuFushikyuKetteiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 高額合算支給決定通知書（一括）のハンドラクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public interface IKogakugassanShikyuKetteitsuchishoMapper {

    /**
     * 高額合算支給不支給決定データを取得します。
     *
     * @param parameter KogakugassanShikyuKetteitsuchishoMybatisParameter
     * @return 高額合算支給不支給決定データ
     */
    List<KogakuGassanShikyuFushikyuKetteiResultEntity> select高額合算支給不支給決定データ(
            KogakugassanShikyuKetteitsuchishoMybatisParameter parameter);

    /**
     * 高額合算支給決定通知書データを取得します。
     *
     * @return 高額合算支給決定通知書データ
     */
    List<KogakugassanShikyuKetteitsuchishoEntity> select高額合算支給決定通知書データ();

    /**
     * 高額合算支給決定通知書データを取得します。
     *
     * @return List<KogakugassanShikyuKetteitsuchishoTempEntity>
     */
    List<KogakugassanShikyuKetteitsuchishoTempEntity> get高額合算支給決定通知書データ();

    /**
     * DbT3074KogakuGassanShikyuFushikyuKetteiEntityを取得します。
     *
     * @param parameter KogakugassanShikyuKetteitsuchishoMybatisParameter
     * @return DbT3074KogakuGassanShikyuFushikyuKetteiEntity
     */
    DbT3074KogakuGassanShikyuFushikyuKetteiEntity selectDbT3074KogakuGassanShikyuFushikyuKettei(
            KogakugassanShikyuKetteitsuchishoMybatisParameter parameter);

    /**
     * 処理日付管理マスタを更新する。
     *
     * @param parameter KogakugassanShikyuKetteitsuchishoMybatisParameter
     * @return DbT7022ShoriDateKanriEntity
     */
    DbT7022ShoriDateKanriEntity update処理日付管理マスタ(KogakugassanShikyuKetteitsuchishoMybatisParameter parameter);

    /**
     * 高額合算支給決定通知書データをクリアする。
     */
    void delete高額合算支給決定通知書データ();
}
