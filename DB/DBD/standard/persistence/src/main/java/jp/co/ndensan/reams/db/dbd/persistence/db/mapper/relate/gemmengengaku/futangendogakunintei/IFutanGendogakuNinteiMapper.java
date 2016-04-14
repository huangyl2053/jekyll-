/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.futangendogakunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;

/**
 * 負担限度額認定のマッパーインタフェースです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public interface IFutanGendogakuNinteiMapper {

    /**
     * 負担限度額認定情報をキー検索で１件取得します。
     *
     * @param 負担限度額認定検索条件 負担限度額認定検索条件
     * @return FutanGendogakuNinteiEntity
     */
    FutanGendogakuNinteiEntity select負担限度額認定ByKey(FutanGendogakuNinteiMapperParameter 負担限度額認定検索条件);

    /**
     * 主キー1に合致する負担限度額認定のリストを取得します。
     *
     * @param 負担限度額認定検索条件 負担限度額認定検索条件
     * @return FutanGendogakuNinteiEntityの{@code list}
     */
    List<FutanGendogakuNinteiEntity> select負担限度額認定リストBy主キー1(FutanGendogakuNinteiMapperParameter 負担限度額認定検索条件);
}
