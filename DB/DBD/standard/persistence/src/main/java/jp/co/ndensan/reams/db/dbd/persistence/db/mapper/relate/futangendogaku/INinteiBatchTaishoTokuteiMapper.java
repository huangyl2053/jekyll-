/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006.NinteiBatchTaishoTokuteiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;

/**
 * 負担限度額認定申請一括承認（バッチ）_処理対象の特定のMapperです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
public interface INinteiBatchTaishoTokuteiMapper {

    /**
     * 負担限度額認定一括テスト結果のデータを全件削除する。
     */
    void deleteAll();

    /**
     * 処理対象の特定データを取得する。
     *
     * @param parameter NinteiBatchTaishoTokuteiMybatisParameter
     * @return List<DbT4018KaigoHokenFutanGendogakuNinteiEntity>
     */
    List<DbT4018KaigoHokenFutanGendogakuNinteiEntity> selectAll(NinteiBatchTaishoTokuteiMybatisParameter parameter);
}
