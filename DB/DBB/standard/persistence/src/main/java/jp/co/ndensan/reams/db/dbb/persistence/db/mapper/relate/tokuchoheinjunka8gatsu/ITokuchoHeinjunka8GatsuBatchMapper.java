/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheinjunka8gatsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb013001.TokuchoHeinjunka8GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001.TokuchoHeinjunka6GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFukaJohoResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.setaiinhaakuinputtable.TmpSetaiHaaku;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.LogBetsuSeigyoJouhouEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * バッチ設計_DBBBT35002_特徴平準化（特徴8月分）Mapperクラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public interface ITokuchoHeinjunka8GatsuBatchMapper {

    /**
     * 資格情報Temp情報を取得するメソッドです。
     *
     * @param parameter TokuchoHeinjunka8GatsuMyBatisParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> get資格情報Temp(TokuchoHeinjunka8GatsuMyBatisParameter parameter);

    /**
     * 平準化前賦課Temp情報を取得するメソッドです。
     *
     * @param parameter TokuchoHeinjunka8GatsuMyBatisParameter
     * @return List<FukaJohoTmpEntity>
     */
    List<FukaJohoTmpEntity> get平準化前賦課Temp(TokuchoHeinjunka8GatsuMyBatisParameter parameter);

    /**
     * 特徴停止_賦課エラー一覧へ登録です。
     *
     * @param parameter TokuchoHeinjunka8GatsuMyBatisParameter
     * @return List<FukaJohoTmpEntity>
     */
    List<FukaJohoTmpEntity> do特徴停止_賦課エラー一覧へ登録(TokuchoHeinjunka8GatsuMyBatisParameter parameter);

    /**
     * ランク別制御情報です。
     *
     * @param parameter TokuchoHeinjunka8GatsuMyBatisParameter
     * @return List<LogBetsuSeigyoJouhouEntity>
     */
    List<LogBetsuSeigyoJouhouEntity> getランク別制御情報(TokuchoHeinjunka8GatsuMyBatisParameter parameter);

    /**
     * 賦課情報あり_賦課エラー一覧へ登録です。
     *
     *
     * @return List<FukaJohoTmpEntity>
     */
    List<FukaJohoTmpEntity> do賦課情報あり_賦課エラー一覧へ登録();

    /**
     * 月別ランクTemp一時テーブルに登録です。
     *
     *
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> do月別ランクTemp一時テーブルに登録();

    /**
     * 世帯員把握入力テーブルに登録です。
     *
     *
     * @return List<TmpSetaiHaaku>
     */
    List<TmpSetaiHaaku> do世帯員把握入力テーブルに登録();

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

    /**
     * 平準化前賦課Tempテーブルに削除
     */
    void do賦課情報あり_平準化前賦課Tempテーブルに削除();

    /**
     * 特徴停止_平準化前賦課Tempテーブルに削除
     *
     * @param parameter TokuchoHeinjunka6GatsuMyBatisParameter
     */
    void do特徴停止_平準化前賦課Tempからデータを削除(TokuchoHeinjunka6GatsuMyBatisParameter parameter);
}
