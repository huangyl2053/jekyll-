/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekishokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiHeaderJohoMapperParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiKensakuDataMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiCareManagementHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiKihonKyotakuServiceRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiKihonShukeiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiShukeiKekkaData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusinessRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiJutakuKaishuhiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiKyotakuServiceRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiMeisaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity;
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

    /**
     * 給付実績基本集計データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufuJissekiKihonShukeiRelateEntity>
     */
    List<KyufuJissekiKihonShukeiRelateEntity> get給付実績基本集計データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績基本居宅サービス計画費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufuJissekiKihonKyotakuServiceRelateEntity>
     */
    List<KyufuJissekiKihonKyotakuServiceRelateEntity> get給付実績基本居宅サービス計画費データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績高額介護サービス費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3028KyufujissekiKogakuKaigoServicehiEntity>
     */
    List<DbT3028KyufujissekiKogakuKaigoServicehiEntity> get給付実績基本高額介護サービス費データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績集計データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3033KyufujissekiShukeiEntity>
     */
    List<DbT3033KyufujissekiShukeiEntity> get給付実績集計データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績集計データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufujissekiMeisaiRelateEntity>
     */
    List<KyufujissekiMeisaiRelateEntity> get給付実績明細データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績緊急時施設療養データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity>
     */
    List<DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity> get給付実績緊急時施設療養データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績所定疾患施設療養費等データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity>
     */
    List<DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity> get給付実績所定疾患施設療養費等データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績特定診療費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3020KyufujissekiTokuteiSinryohiEntity>
     */
    List<DbT3020KyufujissekiTokuteiSinryohiEntity> get給付実績特定診療費データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績特定診療費_特別療養費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity>
     */
    List<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> get給付実績特定診療費_特別療養費データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績食事費用データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3022KyufujissekiShokujiHiyoEntity>
     */
    List<DbT3022KyufujissekiShokujiHiyoEntity> get給付実績食事費用データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績居宅サービス計画費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufujissekiKyotakuServiceRelateEntity>
     */
    List<KyufujissekiKyotakuServiceRelateEntity> get給付実績居宅サービス計画費データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績福祉用具販売費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufujissekiFukushiYoguHanbaihiBusinessRelateEntity>
     */
    List<KyufujissekiFukushiYoguHanbaihiBusinessRelateEntity> get給付実績福祉用具販売費データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績住宅改修費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufujissekiJutakuKaishuhiRelateEntity>
     */
    List<KyufujissekiJutakuKaishuhiRelateEntity> get給付実績住宅改修費データ(KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績高額介護サービス費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<DbT3028KyufujissekiKogakuKaigoServicehiEntity>
     */
    List<DbT3028KyufujissekiKogakuKaigoServicehiEntity> get給付実績高額介護サービス費データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績特定入所者介護サービス費用データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity>
     */
    List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity> get給付実績特定入所者介護サービス費用データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績社会福祉法人軽減額データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity>
     */
    List<KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity> get給付実績社会福祉法人軽減額データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績ケアマネジメント費データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufuJissekiCareManagementHiRelateEntity>
     */
    List<KyufuJissekiCareManagementHiRelateEntity> get給付実績ケアマネジメント費データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績明細・住所地特例データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufujissekiMeisaiJushochiTokureiRelateEntity>
     */
    List<KyufujissekiMeisaiJushochiTokureiRelateEntity> get給付実績明細住所地特例データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績集計データを取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufuJissekiShukeiKekkaData>
     */
    List<KyufuJissekiShukeiKekkaData> get集計データ(
            KyufuJissekiKensakuDataMapperParameter parameter);

    /**
     * 給付実績集計データ_経過措置を取得します。
     *
     * @param parameter 給付実績情報照会検索データ取得用MyBatisパラメータ
     * @return List<KyufuJissekiShukeiKekkaData>
     */
    List<KyufuJissekiShukeiKekkaData> get集計データ_経過措置(
            KyufuJissekiKensakuDataMapperParameter parameter);

}
