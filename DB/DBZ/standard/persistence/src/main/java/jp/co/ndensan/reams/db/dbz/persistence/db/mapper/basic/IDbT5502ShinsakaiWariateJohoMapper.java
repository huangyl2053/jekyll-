/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity}のマッパーIFです。
 *
 */
public interface IDbT5502ShinsakaiWariateJohoMapper {

    /**
     * {@link DbT5502ShinsakaiWariateJohoEntity}を取得します。
     *
     * @return {@link DbT5502ShinsakaiWariateJohoEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5502ShinsakaiWariateJohoEntity getEntity();

    /**
     *
     * @param shinsakaiKaisaiNo 審査会開催番号
     * @return 該当する情報すべて
     */
    List<DbT5502ShinsakaiWariateJohoEntity> findEffective(RString shinsakaiKaisaiNo);
}
