/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.basic.GaibuRenkeiDataoutputJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7211GaibuRenkeiDataoutputJohoEntity;

/**
 *  *
 * {@link jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7211GaibuRenkeiDataoutputJohoEntity}のマッパーIFです。
 *
 * @author LDNS xuxf
 */
public interface IDbT7211GaibuRenkeiDataoutputJohoMapper {

    /**
     * {@link DbT7211GaibuRenkeiDataoutputJohoEntity}を取得します。
     *
     * @return {@link DbT7211GaibuRenkeiDataoutputJoholEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7211GaibuRenkeiDataoutputJohoEntity getEntity();

    /**
     * @param param 条件
     * @return 指定の条件に該当する要素すべて
     */
    List<DbT7211GaibuRenkeiDataoutputJohoEntity> searchByParam(GaibuRenkeiDataoutputJohoMapperParameter param);

}
