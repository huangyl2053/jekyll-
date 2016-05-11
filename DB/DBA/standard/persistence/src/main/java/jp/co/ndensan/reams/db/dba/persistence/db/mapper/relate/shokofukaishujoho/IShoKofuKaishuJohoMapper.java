/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.shokofukaishujoho;

import jp.co.ndensan.reams.db.dba.entity.db.relate.shokofukaishujoho.ShoKofuKaishuJohoEntity;

/**
 * 証交付回収情報のMapperクラスです。
 */
public interface IShoKofuKaishuJohoMapper {

    /**
     * 証交付回収の更新処理します。
     *
     * @param kaishuJohoEntity 証交付回収情報のエンティティ
     * @return 更新件数
     */
    int updShoKofuKaishuJoho(ShoKofuKaishuJohoEntity kaishuJohoEntity);

    /**
     * 証交付回収の削除処理します。
     *
     * @param kaishuJohoEntity 証交付回収情報のエンティティ
     * @return 削除件数
     */
    int delShoKofuKaishuJoho(ShoKofuKaishuJohoEntity kaishuJohoEntity);
}
