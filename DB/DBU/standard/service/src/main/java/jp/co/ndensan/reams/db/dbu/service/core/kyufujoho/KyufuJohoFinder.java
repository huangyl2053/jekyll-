/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kyufujoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kyufujoho.KyufuJohoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KounyukingakuParamter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho.KyufuJohoParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyufujoho.KyufuJohoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kyufujoho.IKyufuJohoMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合照会_給付情報のFinderです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
public class KyufuJohoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dbt7063;

    /**
     * コンストラクタです。
     */
    KyufuJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt7063 = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JyuMiKoNyuJyoHoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JyuMiKoNyuJyoHoFinder}のインスタンス
     */
    public static KyufuJohoFinder createInstance() {
        return InstanceProvider.create(KyufuJohoFinder.class);
    }

    /**
     * 居宅サービス計画情報の取得です。
     *
     * @param paramter KyufuJohoParamter
     * @return 居宅サービス計画情報
     */
    @Transaction
    public KyufuJohoBusiness get居宅サービス計画情報(KyufuJohoParamter paramter) {

        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        KyufuJohoEntity kyufujohoentity = kyufujohomapper.get居宅サービス計画情報(paramter);
        if (kyufujohoentity == null) {
            return null;
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity kaigojigyoshashitei = get事業者名称(kyufujohoentity.get計画事業所番号(),
                kyufujohoentity.getサービス種類コード());
        if (kaigojigyoshashitei != null) {
            kyufujohoentity.set事業者名称(kaigojigyoshashitei);
        }
        return new KyufuJohoBusiness(kyufujohoentity);
    }

    /**
     * 事業者名称の取得です。
     *
     * @param 計画事業所番号 計画事業所番号
     * @param サービス種類コード サービス種類コード
     * @return KaigoJigyoshaShiteiService
     */
    @Transaction
    public DbT7063KaigoJigyoshaShiteiServiceEntity get事業者名称(RString 計画事業所番号, RString サービス種類コード) {

        return dbt7063.get事業者名称(計画事業所番号, サービス種類コード);
    }

    /**
     * 福祉用具販売情報の取得です。
     *
     * @param paramter KounyukingakuParamter
     * @return 福祉用具販売情報
     */
    @Transaction
    public KyufuJohoBusiness get購入金額(KounyukingakuParamter paramter) {

        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        KyufuJohoEntity kyufujoho購入金額 = kyufujohomapper.get購入金額(paramter);
        if (kyufujoho購入金額 == null) {
            return null;
        }
        return new KyufuJohoBusiness(kyufujoho購入金額);
    }

    /**
     * 請求負担額の取得です。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoBusiness
     */
    @Transaction
    public KyufuJohoBusiness get請求負担額(KounyukingakuParamter paramter) {
        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        KyufuJohoEntity kyufujoho請求負担額 = kyufujohomapper.get保険請求負担額(paramter);
        if (kyufujoho請求負担額 == null) {
            return null;
        }
        return new KyufuJohoBusiness(kyufujoho請求負担額);
    }

    /**
     * 住宅改修費用合計の取得です。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoBusiness
     */
    @Transaction
    public KyufuJohoBusiness get住宅改修費用合計(KounyukingakuParamter paramter) {
        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        KyufuJohoEntity kyufujoho = kyufujohomapper.get住宅改修費用合計(paramter);
        if (kyufujoho == null) {
            return null;
        }
        return new KyufuJohoBusiness(kyufujoho);
    }

    /**
     * 住宅改修求負担額の取得です。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoBusiness
     */
    @Transaction
    public KyufuJohoBusiness get住宅改修請求負担額(KounyukingakuParamter paramter) {
        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        KyufuJohoEntity kyufujoho = kyufujohomapper.get住宅改修請求負担額(paramter);
        if (kyufujoho == null) {
            return null;
        }
        return new KyufuJohoBusiness(kyufujoho);
    }

    /**
     * サービス利用状況情報の取得です。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoBusiness
     */
    @Transaction
    public SearchResult<KyufuJohoBusiness> getサービス利用状況情報(KyufuJohoParamter paramter) {
        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        List<KyufuJohoEntity> kyufujohoList = kyufujohomapper.getサービス利用状況情報(paramter);
        List<KyufuJohoBusiness> サービス利用状況情報 = new ArrayList();
        for (KyufuJohoEntity entity : kyufujohoList) {
            サービス利用状況情報.add(new KyufuJohoBusiness(entity));
        }
        return SearchResult.of(サービス利用状況情報, 0, false);
    }

    /**
     * ViewStateへ償還払い状況照会の取得です。
     *
     * @param paramter KounyukingakuParamter
     * @return KyufuJohoBusiness
     */
    @Transaction
    public KyufuJohoBusiness getViewState償還払い状況照会(KounyukingakuParamter paramter) {
        IKyufuJohoMapper kyufujohomapper = mapperProvider.create(IKyufuJohoMapper.class);
        KyufuJohoEntity kyufujoho = kyufujohomapper.getViewState償還払い状況照会(paramter);
        if (kyufujoho == null) {
            return null;
        }
        return new KyufuJohoBusiness(kyufujoho);
    }
}
