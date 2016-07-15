/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kaigofukatokuchoheijunka6batch;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFuchJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFukaJohoResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaEntity;

/**
 * 特徴平準化（特徴6月分）（バッチ） のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
public interface IKaigoFukaTokuchoHeijunka6BatchMapper {

    /**
     * 賦課情報を取得するメソッドです。
     *
     * @param parameter TokuchoHeijunkaRokuBatchFuchJohoParameter
     */
    void insert平準化前賦課Temp(TokuchoHeijunkaRokuBatchFuchJohoParameter parameter);

    /**
     * 対象外データTempテーブルに記録を追加するメソッドです。
     *
     * @param parameter TokuchoHeijunkaRokuBatchTaishogaiTempEntity
     */
    void insert対象外データTemp(TokuchoHeijunkaRokuBatchTaishogaiTempEntity parameter);

    /**
     * Temp対象外データテーブルを作成するメソッドです。
     */
    void create対象外データTemp();

    /**
     * Temp対象外データテーブルに備考コードを追加するメソッドです。
     */
    void alter対象外データTemp備考コード();

    /**
     * 対象者データTempテーブルに記録を追加するメソッドです。
     *
     * @param parameter TokuchoHeijunkaRokuBatchTaishogaiTempEntity
     */
    void insert対象者データTemp(TokuchoHeijunkaRokuBatchTaishogaiTempEntity parameter);

    /**
     * Temp対象者データテーブルを作成するメソッドです。
     */
    void create対象者データTemp();

    /**
     * Temp対象外データテーブルに備考コードを追加するメソッドです。
     */
    void alter対象者データTemp備考コード();

    /**
     * 平準化前賦課Temp情報を取得するメソッドです。
     *
     * @return List<FukaJohoRelateEntity>
     */
    List<FukaJohoRelateEntity> get平準化前賦課Temp();

    /**
     * 平準化前賦課Temp情報を取得するメソッドです。
     *
     * @return List<TaishogaiTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishogaiTempEntity> get対象外データTemp();

    /**
     * 平準化前賦課Temp情報を取得するメソッドです。
     *
     * @return List<TaishoshaTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishogaiTempEntity> get対象者データTemp();

    /**
     * 平準化計算結果Tempテーブルを作成するメソッドです。
     */
    void create平準化計算結果Temp();

    /**
     * 準化計算結果Tempテーブルに記録を追加するメソッドです。
     *
     * @param parameter TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity
     */
    void insert平準化計算結果Temp(TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity parameter);

    /**
     * 賦課の情報を取得するメソッドです。
     *
     * @return List<TaishoshaTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchFukaJohoResult> get賦課の情報();

    /**
     * 賦課の情報を取得するメソッドです。
     *
     * @return List<TaishoshaTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity> get平準化計算結果Temp();

    /**
     * 対象者データを取得するメソッドです。
     *
     * @param parameter TokuchoHeijunkaRokuBatchTaishoParameter
     * @return List<TaishoshaTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishoshaEntity> get対象者データ(TokuchoHeijunkaRokuBatchTaishoParameter parameter);

    /**
     * 対象外データを取得するメソッドです。
     *
     * @param parameter TokuchoHeijunkaRokuBatchTaishoParameter
     * @return List<TaishoshaTempEntity>
     */
    List<TokuchoHeijunkaRokuBatchTaishogaiEntity> get対象外データ(TokuchoHeijunkaRokuBatchTaishoParameter parameter);
}
