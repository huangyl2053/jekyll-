/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigojigyosha.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;

/**
 *
 * @author LDNS 燕京
 */
public interface IDbT7060KaigoJigyoshaMapper {

    /**
     * {@link DbT7060KaigoJigyoshaEntity}を取得します。
     *
     * @return {@link DbT7060KaigoJigyoshaEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7060KaigoJigyoshaEntity getEntity();

    /**
     * 事業者番号と申請日より、{@link DbT7060KaigoJigyoshaEntity}を取得します。
     *
     * @param 介護事業者検索条件 介護事業者検索条件
     * @return {@link DbT7060KaigoJigyoshaEntity}
     */
    DbT7060KaigoJigyoshaEntity select介護事業者By申請日(KaigoJigyoshaMapperParameter 介護事業者検索条件);

    /**
     * 事業者番号と申請日より、{@link DbT7060KaigoJigyoshaEntity}を取得します。
     *
     * @param 介護事業者検索条件 介護事業者検索条件
     * @return {@link DbT7060KaigoJigyoshaEntity}
     */
    List<DbT7060KaigoJigyoshaEntity> select介護事業者ListBy申請日(KaigoJigyoshaMapperParameter 介護事業者検索条件);

}
