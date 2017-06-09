/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity}のマッパーIFです。
 *
 * @author n3423 樋木
 */
public interface IDbT5504ShinsakaiWariateJohoKenshuMapper {

    /**
     * {@link DbT5504ShinsakaiWariateJohoKenshuEntity}を取得します。
     *
     * @return {@link DbT5504ShinsakaiWariateJohoKenshuEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT5504ShinsakaiWariateJohoKenshuEntity getEntity();

    /**
     * @param shinsakaiKaisaiNo 審査会開催番号
     * @return 条件い該当する要素全て
     */
    List<DbT5504ShinsakaiWariateJohoKenshuEntity> findEffective(RString shinsakaiKaisaiNo);

}
