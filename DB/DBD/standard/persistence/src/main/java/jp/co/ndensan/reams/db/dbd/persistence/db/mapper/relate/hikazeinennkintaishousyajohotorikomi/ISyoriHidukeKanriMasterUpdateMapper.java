/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazeinennkintaishousyajohotorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd8100201.SyoriHidukeKanriMasterUpdateMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.SyoriHidukeKanriMasterUpdateJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 処理日付管理マスタ更新のマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public interface ISyoriHidukeKanriMasterUpdateMapper {

    /**
     * 処理日付管理マスタ更新情報を取得します．
     *
     * @param parameter パラメター
     * @return 処理日付管理マスタ更新情報
     */
    List<SyoriHidukeKanriMasterUpdateJohoEntity> get処理日付管理マスタ更新情報(SyoriHidukeKanriMasterUpdateMybatisParameter parameter);

    /**
     * 処理日付管理マスタ情報を追加します．
     *
     * @param entity 処理日付管理マスタEntity
     * @return 追加アカウント
     */
    int insert処理日付管理マスタ更新情報(DbT7022ShoriDateKanriEntity entity);

    /**
     * 処理日付管理マスタ情報を更新します．
     *
     * @param entity 処理日付管理マスタEntity
     * @return 更新アカウント
     */
    int update処理日付管理マスタ更新情報(DbT7022ShoriDateKanriEntity entity);

}
