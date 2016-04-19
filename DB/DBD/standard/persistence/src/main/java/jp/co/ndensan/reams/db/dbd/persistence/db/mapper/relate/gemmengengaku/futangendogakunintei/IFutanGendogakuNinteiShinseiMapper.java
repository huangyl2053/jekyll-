/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.futangendogakunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;

/**
 * 負担限度額認定申請のマッパーインタフェースです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public interface IFutanGendogakuNinteiShinseiMapper {

    /**
     * 境界層該当者の情報を取得する。
     *
     * @param param FutanGendogakuNinteiShinseiMapperParameter
     * @return DbT1006KyokaisoGaitoshaEntity{@code list}
     */
    List<DbT1006KyokaisoGaitoshaEntity> select境界層該当者(FutanGendogakuNinteiShinseiMapperParameter param);

    /**
     * 負担限度額認定申請の情報を取得する。
     *
     * @param param FutanGendogakuNinteiShinseiMapperParameter
     * @return FutanGendogakuNinteiEntity{@code list}
     */
    List<FutanGendogakuNinteiEntity> get負担限度額認定申請の情報List(FutanGendogakuNinteiShinseiMapperParameter param);
}
