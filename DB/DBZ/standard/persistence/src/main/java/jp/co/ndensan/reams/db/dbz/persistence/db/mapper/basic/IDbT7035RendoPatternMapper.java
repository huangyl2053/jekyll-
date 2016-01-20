/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author LDNS chenty
 */
public interface IDbT7035RendoPatternMapper {

    /**
     * {@link  DbT7035RendoPatternEntity}を取得します。
     *
     * @return {@link  DbT7035RendoPatternEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7035RendoPatternEntity getEntity();

    /**
     * {@link  DbT7035RendoPatternEntity}を取得します。
     *
     * @param systemdate FlexibleDate
     * @return {@link  DbT7035RendoPatternEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7035RendoPatternEntity getRendoPatternEntity(FlexibleDate systemdate);
}
