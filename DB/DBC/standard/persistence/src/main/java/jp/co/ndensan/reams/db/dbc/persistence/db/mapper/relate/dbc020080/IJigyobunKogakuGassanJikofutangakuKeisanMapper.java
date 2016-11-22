/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020080;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020080.DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * バッチ設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のマッパインタフェースクラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
public interface IJigyobunKogakuGassanJikofutangakuKeisanMapper {

    /**
     * get処理日付管理のメソッドです。
     *
     * @param parameter DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter
     * @return <@link DbT7022ShoriDateKanriEntity>
     */
    DbT7022ShoriDateKanriEntity select処理日付管理(DBC020080JigyobunKogakuGassanJikofutangakuKeisanMybatisParameter parameter);

}
