/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekishokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiHeaderJohoMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 給付実績照会のインタフェースクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
public interface IKyufuJissekiShokaiMapper {

    /**
     * 宛名情報を取得します。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity get宛名情報(KyufuJissekiHeaderJohoMapperParameter parameter);

    /**
     * 給付実績情報を取得します。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return List<KyufuJissekiJyohoRelateEntity>
     */
    List<KyufuJissekiJyohoRelateEntity> get給付実績情報(KyufuJissekiHeaderJohoMapperParameter parameter);

    /**
     * 介護事業者情報を取得します。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return DbT7060KaigoJigyoshaEntity 検索結果の{@link DbT7060KaigoJigyoshaEntity}
     */
    DbT7060KaigoJigyoshaEntity get介護事業者情報(KyufuJissekiHeaderJohoMapperParameter parameter);

    /**
     * 介護事業者指定サービス情報を取得します。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return DbT7063KaigoJigyoshaShiteiServiceEntity 検索結果の{@link DbT7063KaigoJigyoshaShiteiServiceEntity}
     */
    DbT7063KaigoJigyoshaShiteiServiceEntity get介護事業者指定サービス情報(KyufuJissekiHeaderJohoMapperParameter parameter);

    /**
     * 識別番号管理データを取得します。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return List<DbT3118ShikibetsuNoKanriEntity>
     */
    List<DbT3118ShikibetsuNoKanriEntity> get識別番号管理データ(KyufuJissekiHeaderJohoMapperParameter parameter);

}
