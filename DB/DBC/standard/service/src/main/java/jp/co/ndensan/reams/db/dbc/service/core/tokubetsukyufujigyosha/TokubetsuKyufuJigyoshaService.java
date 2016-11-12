/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaSearchEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc2210011.ITokubetsuKyufuJigyoshaSearchMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 市町村特別給付・サービス事業者のDB管理クラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public class TokubetsuKyufuJigyoshaService {

    private final MapperProvider mapperProvider;
    private final DbT3065ShichosonTokubetsuKyufuJigyoshaDac 市町村特別給付サービス事業者Dac;

    TokubetsuKyufuJigyoshaService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.市町村特別給付サービス事業者Dac = InstanceProvider.create(DbT3065ShichosonTokubetsuKyufuJigyoshaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokubetsuKyufuJigyoshaService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokubetsuKyufuJigyoshaService}のインスタンス
     */
    public static TokubetsuKyufuJigyoshaService createTokubetsuKyufuJigyoshaService() {
        return InstanceProvider.create(TokubetsuKyufuJigyoshaService.class);
    }

    /**
     * 事業者情報を検索します。
     *
     * @param 事業者番号 RString
     * @param 事業者番号Length int
     * @param cD RString
     * @return List<TokubetsuKyufuJigyoshaSearchBusiness>
     */
    public List<TokubetsuKyufuJigyoshaSearchBusiness> select事業者情報(RString 事業者番号, int 事業者番号Length, RString cD) {
        ITokubetsuKyufuJigyoshaSearchMapper mapper = mapperProvider.create(ITokubetsuKyufuJigyoshaSearchMapper.class);
        List<TokubetsuKyufuJigyoshaSearchBusiness> businessList = new ArrayList<>();
        List<TokubetsuKyufuJigyoshaSearchEntity> 事業者情報 = mapper.select事業者情報(事業者番号, 事業者番号Length, cD);
        if (事業者情報 != null) {
            for (TokubetsuKyufuJigyoshaSearchEntity entity : 事業者情報) {
                TokubetsuKyufuJigyoshaSearchBusiness business = new TokubetsuKyufuJigyoshaSearchBusiness(entity);
                businessList.add(business);
            }
        }
        return businessList;
    }

    /**
     * サービス内容を検索します。
     *
     * @return List<ShichosonTokubetuKyufuService>
     */
    public List<ShichosonTokubetuKyufuService> selectサービス内容() {
        ITokubetsuKyufuJigyoshaSearchMapper mapper = mapperProvider.create(ITokubetsuKyufuJigyoshaSearchMapper.class);
        List<DbT3066ShichosonTokubetuKyufuServiceEntity> サービス内容 = mapper.selectサービス内容();
        List<ShichosonTokubetuKyufuService> businessList = new ArrayList<>();
        if (サービス内容 != null) {
            for (DbT3066ShichosonTokubetuKyufuServiceEntity entity : サービス内容) {
                ShichosonTokubetuKyufuService business = new ShichosonTokubetuKyufuService(entity);
                businessList.add(business);
            }
        }
        return businessList;
    }

    /**
     * 事業者情報件数取得メソッドです。
     *
     * @param 入力された事業者コード RString
     * @return int
     */
    public int count事業者情報(RString 入力された事業者コード) {
        ITokubetsuKyufuJigyoshaSearchMapper mapper = mapperProvider.create(ITokubetsuKyufuJigyoshaSearchMapper.class);
        return mapper.selectCount(入力された事業者コード);
    }

    /**
     * 事業者情報更新 メソッドです。
     *
     * @param entity TokubetsuKyufuJigyoshaSearchBusiness
     */
    @Transaction
    public void save事業者情報(TokubetsuKyufuJigyoshaSearchBusiness entity) {
        市町村特別給付サービス事業者Dac.save(entity.to事業者Entity());
    }
}
