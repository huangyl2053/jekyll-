/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shutokujohochushutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshotokutemp.DbtKaigoShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichilan.ShotokuJohoIchilan;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp.DbTShotokuJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携のマッパーインタフェースです。
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
public interface IShutokuJohoChushutsuRenkeiMapper {

    /**
     * 所得情報一時テーブルを作成する。
     */
    void create所得情報一時テーブル();

    /**
     * 所得情報一時テーブルの全件を取ります
     *
     * @return List<DbTShotokuJohoTempTableEntity>
     */
    List<DbTShotokuJohoTempTableEntity> get所得情報一時テーブルの全件();

    /**
     * 介護所得一時テーブルの情報を取ります
     *
     * @return List<DbtKaigoShotokuTempEntity>
     */
    List<DbtKaigoShotokuTempEntity> get介護所得一時テーブルの情報();

    /**
     * 介護所得一時テーブルの市町村以外情報を取ります
     *
     * @return List<DbtKaigoShotokuTempEntity>
     */
    List<DbtKaigoShotokuTempEntity> get介護所得一時テーブルの市町村以外情報();

    /**
     * 介護所得一時テーブルの市町村情報を取ります
     *
     * @return List<DbtKaigoShotokuTempEntity>
     */
    List<DbtKaigoShotokuTempEntity> get介護所得一時テーブルの市町村情報();

    /**
     * 所得情報一覧を取ります
     *
     * @param 出力順 RString
     * @return List<ShotokuJohoIchilan>
     */
    List<ShotokuJohoIchilan> get所得情報一覧(RString 出力順);

    /**
     * 介護所得管理に登録する
     *
     * @param entity DbtKaigoShotokuTempEntity
     *
     */
    void insert介護所得管理(DbtKaigoShotokuTempEntity entity);

    /**
     * 所得情報一時テーブルに登録する
     *
     * @param entity DbTShotokuJohoTempTableEntity
     *
     */
    void insert所得情報一時テーブル(DbTShotokuJohoTempTableEntity entity);

    /**
     * 介護所得一時テーブルに登録する
     *
     * @param entity DbtKaigoShotokuTempEntity
     *
     */
    void insert介護所得一時テーブル(DbtKaigoShotokuTempEntity entity);

}
