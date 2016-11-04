/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogakuninteishinseisho;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseishoParamter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseishoEntity;

/**
 * 介護保険負担限度額認定申請書の施設情報のMapperクラスです。
 *
 * @reamsid_L DBA-0540-690 dongyabin
 */
public interface IFutanGendogakuNinteiShinseishoMapper {

    /**
     * 最新の施設入退所情報を取得します。
     *
     * @param param パラメータ
     * @return 最新の施設入退所情報
     */
    FutanGendogakuNinteiShinseishoEntity get施設入退所(FutanGendogakuNinteiShinseishoParamter param);

    /**
     * 介護事業者情報を取得します。
     *
     * @param param パラメータ
     * @return 最新の施設入退所情報
     */
    FutanGendogakuNinteiShinseishoEntity get介護事業者(FutanGendogakuNinteiShinseishoParamter param);

    /**
     * 介護除外住所地特例対象施設情報を取得します。
     *
     * @param param パラメータ
     * @return 最新の施設入退所情報
     */
    FutanGendogakuNinteiShinseishoEntity get介護除外住所地特例対象施設(FutanGendogakuNinteiShinseishoParamter param);

}
