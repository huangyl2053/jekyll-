/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.persistence.mapper.shoKofuKaishuJoho;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.shokofukaishujoho.ShoKofuKaishuJohoParameter;
import jp.co.ndensan.reams.db.dba.entity.ShoKofuKaishuJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;

/**
 * 証交付回収情報のMapperクラスです。
 */
public interface ShoKofuKaishuJohoMapper {
    
    /**
     * 証交付回収の更新処理します。
     *
     * @param entity
     * @return DbT7037ShoKofuKaishuEntity
     */
    int updShoKofuKaishuJoho(ShoKofuKaishuJohoEntity entity);

    /**
     * 証交付回収の削除処理します。
     *
     * @param parameter 証交付回収情報のパラメータ
     * @return DbT7037ShoKofuKaishuEntity
     */
    DbT7037ShoKofuKaishuEntity delShoKofuKaishuJoho(ShoKofuKaishuJohoParameter parameter);

    /**
     * 証交付回収の保存処理します。
     *
     * @param parameter 証交付回収情報のパラメータ
     * @return DbT7037ShoKofuKaishuEntity
     */
    DbT7037ShoKofuKaishuEntity saveShoKofuKaishuJoho(ShoKofuKaishuJohoParameter parameter);
    
}
