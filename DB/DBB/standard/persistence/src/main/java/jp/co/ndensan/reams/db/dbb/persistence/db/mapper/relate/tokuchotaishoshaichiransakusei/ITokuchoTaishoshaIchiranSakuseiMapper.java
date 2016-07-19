/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshaichiransakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiEntity;

/**
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
public interface ITokuchoTaishoshaIchiranSakuseiMapper {

    /**
     * 処理日付管理マスタからデータを取得する。
     *
     * @param param TokuchoTaishoshaIchiranSakuseiMybatisParameter
     * @return List<TokuchoTaishoshaIchiranSakuseiEntity>
     */
    List<TokuchoTaishoshaIchiranSakuseiEntity> select特別徴収同定一覧(TokuchoTaishoshaIchiranSakuseiMybatisParameter param);

    /**
     * 特別徴収未同定一覧を取得する。
     *
     * @param param TokuchoTaishoshaIchiranSakuseiMybatisParameter
     * @return List<TokuchoTeishiTaisyosyaDouteiEntity>
     */
    List<TokuchoTaishoshaIchiranSakuseiEntity> select特別徴収未同定一覧(TokuchoTaishoshaIchiranSakuseiMybatisParameter param);

    /**
     * 特別徴収同定候補者一覧情報を取得する。
     *
     * @param param TokuchoTaishoshaIchiranSakuseiMybatisParameter
     * @return KonkaiShoriNaiyoJohoEntity
     */
    List<TokuchoTaishoshaIchiranSakuseiEntity> select特別徴収同定候補者一覧(TokuchoTaishoshaIchiranSakuseiMybatisParameter param);

    /**
     * 特別徴収同定候補者詳細情報取得を取得する。
     *
     * @param param TokuchoTaishoshaIchiranSakuseiMybatisParameter
     * @return KonkaiShoriNaiyoJohoEntity
     */
    List<TokuchoTaishoshaIchiranSakuseiEntity> select特別徴収同定候補者詳細(TokuchoTaishoshaIchiranSakuseiMybatisParameter param);

    /**
     * 登録済年金情報のデータを取得する。
     *
     * @param param TokuchoTaishoshaIchiranSakuseiMybatisParameter
     * @return KonkaiShoriNaiyoJohoEntity
     */
    List<TokuchoTaishoshaIchiranSakuseiEntity> select被保険者情報取得(TokuchoTaishoshaIchiranSakuseiMybatisParameter param);

    /**
     * 登録済年金情報のデータを取得する。
     *
     * @param param TokuchoTaishoshaIchiranSakuseiMybatisParameter
     * @return List<DbT2001ChoshuHohoEntity>
     */
    List<DbT2001ChoshuHohoEntity> select最新介護徴収方法情報取得(TokuchoTaishoshaIchiranSakuseiMybatisParameter param);
}
