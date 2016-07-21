/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoLokukatuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohokeizokuRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.SikakuSaisinnsikiRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokuchoKarisanteiKekkaIchiranTeisiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.TokutyoukariSannteiTyuushutuResultEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.ZennNenndoFukaTempEntity;

/**
 * ビジネス設計_DBBBZ33001_1_特徴仮算定賦課（バッチ）DB操作です。
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
public interface ITokuchoKariSanteiFukaMapper {

    /**
     * 特徴継続者を取得
     *
     * @param parameter Map
     * @return List
     */
    List<TokutyoukariSannteiTyuushutuResultEntity> select特徴継続者(Map<String, Object> parameter);

    /**
     * 特徴仮算定抽出Tempを作成する。
     */
    void creat特徴仮算定抽出Temp();

    /**
     * 特徴仮算定抽出Tempをinset
     *
     * @param entity TokutyoukariSannteiTyuushutuEntity
     */
    void inset特徴仮算定抽出Temp(TokutyoukariSannteiTyuushutuEntity entity);

    /**
     * 前年度賦課Tempを作成する。
     */
    void create前年度賦課Temp();

    /**
     * inset前年度賦課Temp
     *
     * @param entity ZennNenndoFukaTempEntity
     */
    void inset前年度賦課Temp(ZennNenndoFukaTempEntity entity);

    /**
     * 特徴6月開始者を取得
     *
     * @param parameter Map<String, Object>
     * @return List
     */
    List<TokutyoukariSannteiTyuushutuResultEntity> select特徴6月開始者(Map<String, Object> parameter);

    /**
     * 前年度賦課を取得
     *
     * @param parameter Map
     * @return List
     */
    List<ZennNenndoFukaTempEntity> select前年度賦課(Map<String, Object> parameter);

    /**
     * 最新履歴以外のデータを削除する。
     */
    void delete最新履歴以外のデータ();

    /**
     * 特徴仮算定抽出Tempの前年度特徴期別金額06を更新する。
     */
    void update特徴仮算定抽出Temp();

    /**
     * 不整合データ抽出する。
     *
     * @return List
     */
    List<TokutyoukariSannteiTyuushutuEntity> select不整合データ();

    /**
     * delete特徴仮算定抽出Temp
     *
     * @param entity TokutyoukariSannteiTyuushutuEntity
     */
    void delete特徴仮算定抽出Temp(TokutyoukariSannteiTyuushutuEntity entity);

    /**
     * 資格等最新化（４月開始）情報を取得
     *
     * @param parameter Map<String, Object>
     * @return List<SikakuSaisinnsiki>
     */
    List<SikakuSaisinnsikiRelateEntity> select資格等最新化_４月開始(Map<String, Object> parameter);

    /**
     * create賦課の情報一時テーブル
     */
    void create賦課の情報一時テーブル();

    /**
     * inset賦課の情報一時テーブル
     *
     * @param entity 賦課の情報一時Entity
     */
    void inset賦課の情報一時テーブル(FukaJohoTempEntity entity);

    /**
     * 賦課情報_継続を取得
     *
     * @return 賦課情報の計算登録（継続）entity
     */
    List<FukaJohokeizokuRelateEntity> select賦課情報_継続();

    /**
     * clear賦課の情報一時テーブル
     */
    void clear賦課の情報一時テーブル();

    /**
     * select賦課情報_6月開始
     *
     * @return 賦課情報の計算登録（6月開始）entity
     */
    List<FukaJohoLokukatuRelateEntity> select賦課情報_6月開始();

    /**
     * 特徴仮算定結果情報を取得
     *
     * @param parameter Map<String, Object>
     * @return 特徴仮算定結果情報
     */
    List<TokuchoKarisanteiKekkaIchiranEntity> select特徴仮算定結果情報(Map<String, Object> parameter);

    /**
     * 特徴仮算定計算後賦課情報Entity (特徴停止)を取得
     *
     * @param parameter Map<String, Object>
     * @return 特徴仮算定計算後賦課情報Entity (特徴停止)
     */
    List<TokuchoKarisanteiKekkaIchiranTeisiEntity> select特徴仮算定計算後賦課情報_特徴停止(Map<String, Object> parameter);
}
