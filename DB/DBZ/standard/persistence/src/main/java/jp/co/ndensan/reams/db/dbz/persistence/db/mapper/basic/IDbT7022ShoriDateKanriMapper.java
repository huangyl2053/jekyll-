/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ParameterSetMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 *
 * @author LDNS chenty
 */
public interface IDbT7022ShoriDateKanriMapper {

    /**
     * {@link  DbT7022ShoriDateKanriEntity}を取得します。
     *
     * @return {@link  DbT7022ShoriDateKanriEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7022ShoriDateKanriEntity getEntity();

    /**
     * {@link  DbT7022ShoriDateKanriEntity}を取得します。
     *
     * @return {@link  DbT7022ShoriDateKanriEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7022ShoriDateKanriEntity getTaishoShuryoYMD();

    /**
     * 被保険者台帳管理（資格取得）情報を取得します。
     *
     * @param parameter 被保険者台帳管理（資格取得）検索条件
     * @return DbT7022ShoriDateKanriのエンティティ
     */
    DbT7022ShoriDateKanriEntity get処理日付管理マスタByKey(ParameterSetMybatisParameter parameter);

}
