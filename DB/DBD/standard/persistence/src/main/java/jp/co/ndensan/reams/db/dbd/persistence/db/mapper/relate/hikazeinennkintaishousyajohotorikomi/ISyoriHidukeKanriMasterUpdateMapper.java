/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hikazeinennkintaishousyajohotorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 処理日付管理マスタのマッパーインタフェースです。
 *
 * @reamsid_L DBD-4910-030 x_xuliang
 */
public interface ISyoriHidukeKanriMasterUpdateMapper {

    /**
     * 処理日付管理マスタを更新する．
     *
     * @return 処理日付管理マスタを更新する
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタを更新する();

}
