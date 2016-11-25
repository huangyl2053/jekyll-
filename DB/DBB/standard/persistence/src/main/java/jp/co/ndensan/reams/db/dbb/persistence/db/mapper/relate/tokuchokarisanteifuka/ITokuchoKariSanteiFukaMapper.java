/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoLokukatuRelateEntity;
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
    List<TokutyoukariSannteiTyuushutuResultEntity> select特徴継続者(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 特徴6月開始者を取得
     *
     * @param parameter Map<String, Object>
     * @return List
     */
    List<TokutyoukariSannteiTyuushutuResultEntity> select特徴6月開始者(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 前年度賦課を取得
     *
     * @param parameter Map
     * @return List
     */
    List<ZennNenndoFukaTempEntity> select前年度賦課(TokuchoKarisanteiFukaMyBatisParameter parameter);

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
     * 資格等最新化（４月開始）情報を取得
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     * @return List<SikakuSaisinnsikiRelateEntity>
     */
    List<SikakuSaisinnsikiRelateEntity> select資格等最新化_４月開始登録(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 資格等最新化（４月開始）情報を取得
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     * @return List<SikakuSaisinnsikiRelateEntity>
     */
    List<SikakuSaisinnsikiRelateEntity> select資格等最新化_４月開更新(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 賦課情報_継続を取得
     *
     * @return 賦課情報の計算登録（継続）entity
     */
    List<FukaJohokeizokuRelateEntity> select賦課情報_継続();

    /**
     * select賦課情報_6月開始
     *
     * @return 賦課情報の計算登録（6月開始）entity
     */
    List<FukaJohoLokukatuRelateEntity> select賦課情報_6月開始();

    /**
     * select計算後情報
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     * @return 計算後情報entity
     */
    List<DbT2015KeisangoJohoEntity> select計算後情報(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 特徴仮算定結果情報を取得
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     * @return 特徴仮算定結果情報
     */
    List<TokuchoKarisanteiKekkaIchiranEntity> select特徴仮算定結果情報(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 特徴仮算定計算後賦課情報Entity (特徴停止)を取得
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     * @return 特徴仮算定計算後賦課情報Entity (特徴停止)
     */
    List<TokuchoKarisanteiKekkaIchiranTeisiEntity> select特徴仮算定計算後賦課情報_特徴停止(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 処理日付管理テーブルの更新
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     */
    void update処理日付管理テーブル_特徴仮算定賦課(TokuchoKarisanteiFukaMyBatisParameter parameter);

    /**
     * 処理日付管理テーブルの更新
     *
     * @param parameter TokuchoKarisanteiFukaMyBatisParameter
     */
    void update処理日付管理テーブル_依頼金額計算(TokuchoKarisanteiFukaMyBatisParameter parameter);

}
