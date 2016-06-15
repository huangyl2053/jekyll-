/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunkakakutei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiEntity;

/**
 * ビジネス設計_DBBBZ35004_特徴平準化確定のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0830-020 wangkanglei
 */
public interface ITokuchoHeijunkaKakuteiMapper {

    /**
     * 賦課処理状況の更新。
     *
     * @param parameter 平準化更新条件
     */
    void update賦課処理状況(Map<String, Object> parameter);

    /**
     * 特徴平準化賦課Tempを作成する。
     */
    void create特徴平準化賦課Temp();

    /**
     * 特徴平準化賦課Tempをinset
     *
     * @param entity TokuchoHeinjunkaKakuteiEntity
     */
    void inset特徴平準化賦課Temp(TokuchoHeinjunkaKakuteiEntity entity);

    /**
     * 平準化後の賦課の情報を取得
     *
     * @return 平準化後の賦課の情報
     */
    List<FukaJohoRelateEntity> select平準化前の賦課の情報();

    /**
     * 特徴平準化賦課Tempをupdate
     *
     * @param entity TokuchoHeinjunkaKakuteiEntity
     */
    void update特徴平準化賦課Temp(TokuchoHeinjunkaKakuteiEntity entity);

    /**
     * 特徴平準化賦課Tempを取得
     *
     * @return List<TokuchoHeinjunkaKakuteiEntity>
     */
    List<TokuchoHeinjunkaKakuteiEntity> select特徴平準化賦課Temp();

    /**
     * 特徴平準化賦課一時テーブルをクリア
     */
    void clear特徴平準化賦課Temp();
}
