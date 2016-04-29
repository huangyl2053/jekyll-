/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 適用除外者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0210-020 dingyi
 */
public interface ITekiyoJogaishaMapper {

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
    List<TekiyoJogaishaRelateEntity> get施設情報(TekiyoJogaishaMapperParameter 適用除外者検索条件);

    /**
     * 適用除外者更新用情報の取得します。
     *
     * @param parameter 適用除外者を特定するためのMyBatis用パラメータ
     * @return List<DbT1002TekiyoJogaishaEntity>
     */
    List<DbT1002TekiyoJogaishaEntity> get適用除外者更新用(TekiyoJogaishaMapperParameter parameter);

    /**
     * 施設入退所更新用情報の取得します。
     *
     * @param parameter 適用除外者を特定するためのMyBatis用パラメータ
     * @return List<DbT1004ShisetsuNyutaishoEntity>
     */
    List<DbT1004ShisetsuNyutaishoEntity> get施設情報更新用(TekiyoJogaishaMapperParameter parameter);

}
