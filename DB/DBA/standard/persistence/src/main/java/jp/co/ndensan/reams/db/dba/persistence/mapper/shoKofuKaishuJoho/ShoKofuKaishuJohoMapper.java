/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.persistence.mapper.shoKofuKaishuJoho;
import jp.co.ndensan.reams.db.dba.entity.ShoKofuKaishuJohoEntity;

/**
 * 証交付回収情報のMapperクラスです。
 */
public interface ShoKofuKaishuJohoMapper {
    
    /**
     * 証交付回収の更新処理します。
     *
     * @param kaishuJohoEntity
     * @return ShoKofuKaishuJohoEntity
     */
    int updShoKofuKaishuJoho(ShoKofuKaishuJohoEntity kaishuJohoEntity);

    /**
     * 証交付回収の削除処理します。
     *
     * @param kaishuJohoEntity
     * @return ShoKofuKaishuJohoEntity
     */
    int delShoKofuKaishuJoho(ShoKofuKaishuJohoEntity kaishuJohoEntity);
}
