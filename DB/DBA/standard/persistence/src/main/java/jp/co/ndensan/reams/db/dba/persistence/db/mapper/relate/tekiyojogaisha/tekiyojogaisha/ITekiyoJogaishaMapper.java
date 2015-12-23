/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 適用除外者のマッパーインタフェースです。
 */
public interface ITekiyoJogaishaMapper {

    /**
     * 適用除外者情報をキー検索で１件取得します。
     *
     * @param 適用除外者検索条件 適用除外者検索条件
     * @return TekiyoJogaishaEntity
     */
    TekiyoJogaishaEntity select適用除外者ByKey(TekiyoJogaishaMapperParameter 適用除外者検索条件);

    /**
     * Max履歴番号取得します。
     *
     * @param 適用除外者検索条件 適用除外者を特定するためのMyBatis用パラメータ
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    DbT1004ShisetsuNyutaishoEntity getMax履歴番号(TekiyoJogaishaMapperParameter 適用除外者検索条件);

    /**
     * 宛名情報取得します。
     *
     * @param 適用除外者検索条件 適用除外者を特定するためのMyBatis用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity select宛名情報(TekiyoJogaishaMapperParameter 適用除外者検索条件);

    /**
     * 最大の枝番取得します。
     *
     * @param 適用除外者検索条件 適用除外者を特定するためのMyBatis用パラメータ
     * @return DbT1002TekiyoJogaishaEntity
     */
    DbT1002TekiyoJogaishaEntity get最大の枝番(TekiyoJogaishaMapperParameter 適用除外者検索条件);
}
