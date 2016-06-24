/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunkakakutei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiItirannParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.FukaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiItirannEntity;

/**
 * ビジネス設計_DBBBZ35004_1_特徴平準化確定（バッチ） DB操作です。
 *
 * @reamsid_L DBB-0830-050 xuhao
 */
public interface ITokuchoHeinjunkaKakuteiMapper {

    /**
     * create特徴平準化賦課Tempをクリアを作成する。
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
     * @return TokuchoHeinjunkaKakuteiEntity
     */
    List<TokuchoHeinjunkaKakuteiEntity> select特徴平準化賦課Temp();

    /**
     * 賦課Tempを作成する。
     */
    void create賦課Temp();

    /**
     * 賦課Tempをinset
     *
     * @param entity 賦課Temp
     */
    void inset賦課Temp(FukaTempEntity entity);

    /**
     * 調定共通_介護継承をupdate
     */
    void update調定共通_介護継承();

    /**
     * 調定額内訳_介護継承をupdate
     *
     * @param parameter Map<String, Object>
     */
    void delete調定額内訳_介護継承(Map<String, Object> parameter);

    /**
     * 調定状況_介護継承をupdate
     *
     * @param parameter Map<String, Object>
     */
    void delete調定状況_介護継承(Map<String, Object> parameter);

    /**
     * 収納管理マスタ_介護継承をupdate
     *
     * @param parameter Map<String, Object>
     */
    void delete収納管理マスタ_介護継承(Map<String, Object> parameter);

    /**
     * 調定共通_介護継承をupdate
     *
     * @param parameter Map<String, Object>
     */
    void delete調定共通_介護継承(Map<String, Object> parameter);

    /**
     * 賦課Tempを取得
     *
     * @return FukaTempEntity
     */
    List<FukaTempEntity> select賦課Temp();

    /**
     * 特徴平準化確定一覧entityを作成
     *
     * @param paramter TokuchoHeinjunkaKakuteiItirannParameter
     * @return List<TokuchoHeinjunkaKakuteiItirannEntity>
     */
    List<TokuchoHeinjunkaKakuteiItirannEntity> selest特徴平準化確定一覧(TokuchoHeinjunkaKakuteiItirannParameter paramter);

    /**
     * update処理日付管理
     *
     * @param parameter Map<String, Object>
     */
    void update処理日付管理(Map<String, Object> parameter);
}
