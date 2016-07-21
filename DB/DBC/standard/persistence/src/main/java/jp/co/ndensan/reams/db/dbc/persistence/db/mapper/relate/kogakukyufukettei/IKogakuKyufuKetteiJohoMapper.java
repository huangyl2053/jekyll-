/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufukettei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3058KogakuShikyuShinsaKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiChohyoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiTorokuEntity;

/**
 * 高額サービス費決定情報取込みのMapper
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public interface IKogakuKyufuKetteiJohoMapper {

    /**
     * 高額介護サービス費支給審査決定一時TBLを作成する。
     */
    void create高額介護サービス費支給審査決定一時TBL();

    /**
     * 高額介護サービス費支給審査決定一時TBLに登録する。
     *
     * @param entity DbWT3058KogakuShikyuShinsaKetteiTempEntity
     */
    void do高額介護サービス費支給審査決定一時TBLに登録(DbWT3058KogakuShikyuShinsaKetteiTempEntity entity);

    /**
     * 審査決定一時データを更新済にする。更新済フラグFALSE->TRUE
     *
     * @param parameter Map<String, Object>
     */
    void do審査決定一時データを更新済にする(Map<String, Object> parameter);

    /**
     * 前回処理時に登録したデータを取得する。
     *
     * @param parameter java.util.Map
     * @return List<KogakuKyufuKetteiTorokuEntity>
     */
    List<KogakuKyufuKetteiTorokuEntity> get前回登録データ(Map<String, Object> parameter);

    /**
     * 未更新の審査決定一時データ　と　審査決定一時データと同じ被保険者番号、サービス提供年月をもつ判定結果データ<br>
     * （判定結果送付済＆審査結果未反映のみ）を取得する。
     *
     * @return List<KogakuKyufuKetteiHanteiEntity>
     */
    List<KogakuKyufuKetteiHanteiEntity> get登録対象データ();

    /**
     * 帳票出力対象データ取得
     *
     * @param parameter Map<String, Object>
     * @return List<KogakuKyufuKetteiChohyoDataEntity>
     */
    List<KogakuKyufuKetteiChohyoDataEntity> get帳票出力対象データ(Map<String, Object> parameter);

}
