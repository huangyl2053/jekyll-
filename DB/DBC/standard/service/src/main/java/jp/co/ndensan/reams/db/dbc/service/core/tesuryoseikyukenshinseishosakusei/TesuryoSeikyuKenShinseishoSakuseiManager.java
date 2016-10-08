/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.tesuryoseikyukenshinseishosakusei;

import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.tesuryoseikyukenshinseishosakusei.ITesuryoSeikyuKenShinseishoSakuseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * 審査会自動割付を検索します。
     *
     * @param 市町村コード 市町村コード
     * @return TesuryoSeikyuKenShinseishoSakuseiBusiness
     */
    @Transaction
    public TesuryoSeikyuKenShinseishoSakuseiBusiness getTemp_市町村コード(RString 市町村コード) {
        TesuryoSeikyuKenShinseishoSakuseiMybatisParameter mybitisParamter = new TesuryoSeikyuKenShinseishoSakuseiMybatisParameter(市町村コード);
        ITesuryoSeikyuKenShinseishoSakuseiMapper mapper = mapperProvider.create(ITesuryoSeikyuKenShinseishoSakuseiMapper.class);
        TesuryoSeikyuKenShinseishoSakuseiRelateEntity relateEntity = mapper.select日時(mybitisParamter);
        if (relateEntity == null) {
            return null;
        }
        return new TesuryoSeikyuKenShinseishoSakuseiBusiness(relateEntity);
    }
}
