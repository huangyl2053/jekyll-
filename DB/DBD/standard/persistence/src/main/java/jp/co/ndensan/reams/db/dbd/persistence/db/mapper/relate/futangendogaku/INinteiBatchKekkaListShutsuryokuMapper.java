/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006.NinteiBatchKekkaListShutsuryokuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei.FutanGengaokuNintteiKakuninListEntity;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力のMapperです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
public interface INinteiBatchKekkaListShutsuryokuMapper {

    /**
     * 結果一覧データを取得する。
     *
     * @param parameter NinteiBatchKekkaListShutsuryokuMybatisParameter
     * @return List<FutanGengaokuNintteiKakuninListEntity>
     */
    List<FutanGengaokuNintteiKakuninListEntity> get結果一覧データ(NinteiBatchKekkaListShutsuryokuMybatisParameter parameter);
}
