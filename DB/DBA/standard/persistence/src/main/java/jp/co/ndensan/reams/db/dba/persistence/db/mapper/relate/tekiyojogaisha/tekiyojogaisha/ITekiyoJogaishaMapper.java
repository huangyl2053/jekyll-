/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
     * @return Max履歴番号
     */
    Decimal getMax履歴番号(TekiyoJogaishaMapperParameter 適用除外者検索条件);

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

    /**
     * 適用除外者の取得します。
     *
     * @param 適用除外者検索条件 適用除外者を特定するためのMyBatis用パラメータ
     * @return List<TekiyoJogaishaRelateEntity>
     */
    List<TekiyoJogaishaRelateEntity> get適用除外者(TekiyoJogaishaMapperParameter 適用除外者検索条件);

    /**
     * 施設情報の取得します。
     *
     * @param 適用除外者検索条件 適用除外者を特定するためのMyBatis用パラメータ
     * @return List<TekiyoJogaishaRelateEntity>
     */
    List<TekiyoJogaishaRelateEntity> get施設情(TekiyoJogaishaMapperParameter 適用除外者検索条件);

    /**
     * 施設情報の取得します。
     *
     * @param parameter 適用除外者を特定するためのMyBatis用パラメータ
     * @return List<DbT1002TekiyoJogaishaEntity>
     */
    List<DbT1002TekiyoJogaishaEntity> getTekiyoJogaisha(TekiyoJogaishaMapperParameter parameter);

    /**
     * 介護保険施設入退所情報の取得します。
     *
     * @param parameter 適用除外者を特定するためのMyBatis用パラメータ
     * @return List<DbT1004ShisetsuNyutaishoEntity>
     */
    List<DbT1004ShisetsuNyutaishoEntity> getShisetsuNyutaisho(TekiyoJogaishaMapperParameter parameter);
}
