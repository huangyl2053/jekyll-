/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.tesuryoseikyukenshinseishosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.tesuryoseikyukenshinseishosakusei.ITesuryoSeikyuKenShinseishoSakuseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 クラスです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
public class TesuryoSeikyuKenShinseishoSakuseiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TesuryoSeikyuKenShinseishoSakuseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    public TesuryoSeikyuKenShinseishoSakuseiManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TesuryoSeikyuKenShinseishoSakuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TesuryoSeikyuKenShinseishoSakuseiManager}のインスタンス
     */
    public static TesuryoSeikyuKenShinseishoSakuseiManager creatInstance() {
        return InstanceProvider.create(TesuryoSeikyuKenShinseishoSakuseiManager.class);
    }

    /**
     * 住宅改修理由書作成手数料請求書兼申請書を検索します。
     *
     * @param mybitisParamter 住宅改修理由書作成手数料請求書兼申請書作成のパラメータ
     * @return TesuryoSeikyuKenShinseishoSakuseiBusiness
     */
    @Transaction
    public SearchResult<TesuryoSeikyuKenShinseishoSakuseiBusiness> getTemp_市町村コード(TesuryoSeikyuKenShinseishoSakuseiMybatisParameter mybitisParamter) {
        ITesuryoSeikyuKenShinseishoSakuseiMapper mapper = mapperProvider.create(ITesuryoSeikyuKenShinseishoSakuseiMapper.class);
        TesuryoSeikyuKenShinseishoSakuseiRelateEntity relateEntity = mapper.select日時(mybitisParamter);
        List<TesuryoSeikyuKenShinseishoSakuseiBusiness> businessList = new ArrayList<>();
        if (relateEntity != null) {
            businessList.add(new TesuryoSeikyuKenShinseishoSakuseiBusiness(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
