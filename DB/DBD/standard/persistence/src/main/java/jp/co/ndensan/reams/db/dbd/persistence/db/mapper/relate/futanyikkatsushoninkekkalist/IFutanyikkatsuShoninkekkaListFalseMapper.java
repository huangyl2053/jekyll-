/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanyikkatsushoninkekkalist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futanyikkatsulist.FutanyikkatsuShoninListMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei.FutanGendogakuNinteiBatchResultEntity;

/**
 * 一括承認結果一覧（画面）のMapperです。
 *
 * @reamsid_L DBD-3710-080 xuejm
 */
public interface IFutanyikkatsuShoninkekkaListFalseMapper {

    /**
     * 負担限度額認定バッチ結果情報を取得する。
     *
     * @param parameter FutanyikkatsuShoninListMapperParameter
     * @return List<FutanGendogakuNinteiBatchResultEntity>
     */
    List<FutanGendogakuNinteiBatchResultEntity> get一括承認結果情報を取得_承認済みフラグFALSE(FutanyikkatsuShoninListMapperParameter parameter);

}
