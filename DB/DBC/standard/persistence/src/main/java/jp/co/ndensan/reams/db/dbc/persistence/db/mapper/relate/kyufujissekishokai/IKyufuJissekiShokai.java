/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekishokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiHeaderJohoMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績照会のインタフェースクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
public interface IKyufuJissekiShokai {

    /**
     * 受給者情報を取得します（直近データ）。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return DbV4001JukyushaDaichoEntity 検索結果の{@link DbV4001JukyushaDaichoEntity}
     */
    DbV4001JukyushaDaichoEntity get受給者情報(KyufuJissekiHeaderJohoMapperParameter parameter);

    /**
     * 宛名情報を取得します。
     *
     * @param 識別コード 識別コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity get宛名情報(RString 識別コード, RString psmShikibetsuTaisho);

    /**
     * 給付実績情報を取得します。
     *
     * @param parameter 給付実績ヘッダ情報取得用のMyBatisパラメータ
     * @return List<KyufuJissekiJyohoRelateEntity>
     */
    List<KyufuJissekiJyohoRelateEntity> get給付実績情報(KyufuJissekiHeaderJohoMapperParameter parameter);

}
