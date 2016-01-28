/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;

/**
 * {@link jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity}のマッパーIFです。
 *
 */
public interface IDbT5592ShinsakaiKaisaiBashoJohoMapper {

    /**
     * {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}を取得します。
     *
     * @return {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5592ShinsakaiKaisaiBashoJohoEntity getEntity();
    
    /**
     * {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}を取得します。
     *
     * @param param
     * @return {@link List<DbT5592ShinsakaiKaisaiBashoJohoEntity>}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    List<DbT5592ShinsakaiKaisaiBashoJohoEntity> getYiChiRanEntity(GogitaiJohoMapperParameter param);
}
