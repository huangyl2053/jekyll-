/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.ShoninShoriEntity;

/**
 * 負担限度額認定申請一括承認（バッチ）_承認処理のMapperです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
public interface INinteiBatchMainMapper {

    /**
     * 承認処理データを取得する。
     *
     * @return List<ShoninShoriEntity>
     */
    List<ShoninShoriEntity> get承認処理データ();
}
