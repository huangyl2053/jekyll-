/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shinseikensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shinseikensaku.ShinseiKensakuBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinseikensaku.ShinseiKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinseikensaku.IShinseiKensakuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定申請検索クラスです。
 *
 */
public class ShinseiKensakuFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinseiKensakuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinseiKensakuFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinseiKensakuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinseiKensakuFinder}のインスタンス
     */
    public static ShinseiKensakuFinder createInstance() {
        return InstanceProvider.create(ShinseiKensakuFinder.class);
    }

    /**
     * 要介護認定申請検索処理です。
     *
     * @param parameter 検索条件
     * @return 要介護認定申請情報
     */
    public SearchResult<ShinseiKensakuBusiness> search認定(ShinseiKensakuMapperParameter parameter) {
        List<ShinseiKensakuBusiness> shinseiKensakuList = new ArrayList<>();
        IShinseiKensakuMapper shinseiKensakuMapper = mapperProvider.create(IShinseiKensakuMapper.class);
        List<ShinseiKensakuRelateEntity> list = shinseiKensakuMapper.selectShinseiJoho認定(parameter);
        for (ShinseiKensakuRelateEntity entity : list) {
            ShinseiKensakuBusiness business = new ShinseiKensakuBusiness(entity);
            shinseiKensakuList.add(business);
        }
        int totalcount = shinseiKensakuMapper.countShinseiJoho認定(parameter);
        return SearchResult.of(shinseiKensakuList, totalcount, parameter.getLimitCount() < totalcount);
    }

    /**
     * 要介護認定申請検索処理です。
     *
     * @param parameter 検索条件
     * @return 要介護認定申請情報
     */
    public SearchResult<ShinseiKensakuBusiness> search受給(ShinseiKensakuMapperParameter parameter) {
        List<ShinseiKensakuBusiness> shinseiKensakuList = new ArrayList<>();
        IShinseiKensakuMapper shinseiKensakuMapper = mapperProvider.create(IShinseiKensakuMapper.class);
        List<ShinseiKensakuRelateEntity> list = shinseiKensakuMapper.selectShinseiJoho受給(parameter);
        for (ShinseiKensakuRelateEntity entity : list) {
            ShinseiKensakuBusiness business = new ShinseiKensakuBusiness(entity);
            shinseiKensakuList.add(business);
        }
        int totalcount = shinseiKensakuMapper.countShinseiJoho受給(parameter);
        return SearchResult.of(shinseiKensakuList, totalcount, parameter.getLimitCount() < totalcount);
    }
}
