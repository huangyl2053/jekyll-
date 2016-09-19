/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheinjunka6gatsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001.TokuchoHeinjunka6GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFukaJohoResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;

/**
 * バッチ設計_DBBBT35001_特徴平準化（特徴6月分）Mapperクラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public interface ITokuchoHeinjunka6GatsuBatchMapper {

    /**
     * 平準化前賦課Temp情報を取得するメソッドです。
     *
     * @param parameter TokuchoHeinjunka6GatsuMyBatisParameter
     * @return List<FukaJohoTmpEntity>
     */
    List<FukaJohoTmpEntity> get平準化前賦課Temp(TokuchoHeinjunka6GatsuMyBatisParameter parameter);

    /**
     * 平準化前賦課Temp情報を取得するメソッドです。
     *
     * @return List<FukaJohoTmpEntity>
     */
    List<FukaJohoTmpEntity> getTmpHeijunkaMae();

    /**
     * 対象者データTemp情報を取得するメソッドです。
     *
     * @return List<TokuchoHeijunkaRokuBatchTaishogaiTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishogaiTempEntity> get対象者データTemp();

    /**
     * 賦課の情報を取得するメソッドです。
     *
     * @return List<TaishoshaTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchFukaJohoResult> get賦課の情報();

    /**
     * 対象者データの情報を取得するメソッドです。
     *
     * @param parameter TokuchoHeinjunka6GatsuProcessParameter
     * @return List<TokuchoHeijunkaRokuBatchTaishoshaEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishoshaEntity> get対象者データ(TokuchoHeinjunka6GatsuMyBatisParameter parameter);

    /**
     * get対象外データの情報を取得するメソッドです。
     *
     * @param parameter TokuchoHeinjunka6GatsuProcessParameter
     * @return List<TokuchoHeijunkaRokuBatchTaishogaiEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishogaiEntity> get対象外データ(TokuchoHeinjunka6GatsuMyBatisParameter parameter);

    /**
     * 処理日付管理テーブルを更新するメソッドです。
     *
     * @param parameter TokuchoHeinjunka6GatsuProcessParameter
     */
    void updateShoriDateKanri(TokuchoHeinjunka6GatsuMyBatisParameter parameter);
}
