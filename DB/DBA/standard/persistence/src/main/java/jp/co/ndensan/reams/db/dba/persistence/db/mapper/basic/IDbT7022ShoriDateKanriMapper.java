/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.dbamn71001.ParameterSetMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 被保険者台帳管理（資格取得）のMapperクラスです。
 */
public interface IDbT7022ShoriDateKanriMapper {

    /**
     * 被保険者台帳管理（資格取得）情報を取得します。
     *
     * @param parameter 被保険者台帳管理（資格取得）検索条件
     * @return DbT7022ShoriDateKanriのエンティティ
     */
    DbT7022ShoriDateKanriEntity get処理日付管理マスタByKey(ParameterSetMybatisParameter parameter);


}
