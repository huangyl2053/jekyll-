/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfokihon;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.ChosaKekkaInfoKihonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.TokiJikouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfokihon.ChosaKekkaInfoKihonParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon.ChosaKekkaInfoKihonRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon.TokiJikouRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosakekkainfokihon.IChosaKekkaInfoKihonMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査結果情報照会_基本調査を管理するクラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public class ChosaKekkaInfoKihonFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ChosaKekkaInfoKihonFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     */
    ChosaKekkaInfoKihonFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaKekkaInfoKihonFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaKekkaInfoKihonFinder}のインスタンス
     */
    public static ChosaKekkaInfoKihonFinder createInstance() {
        return InstanceProvider.create(ChosaKekkaInfoKihonFinder.class);
    }

    /**
     * 認定調査票情報を取得します。
     *
     * @param 認定調査票情報検索条件 ChosaKekkaInfoGaikyoParameter
     * @return SearchResult<ChosaKekkaInfoKihonBusiness> 認定調査票情報検索条件
     */
    @Transaction
    public SearchResult<ChosaKekkaInfoKihonBusiness> getChosaKekkaInfoKihon(ChosaKekkaInfoKihonParameter 認定調査票情報検索条件) {
        List<ChosaKekkaInfoKihonBusiness> businessList = new ArrayList<>();
        IChosaKekkaInfoKihonMapper mapper = mapperProvider.create(IChosaKekkaInfoKihonMapper.class);
        List<ChosaKekkaInfoKihonRelateEntity> kihonRelateEntity = mapper.getChosaKekkaInfoKihonList1(認定調査票情報検索条件);
        for (ChosaKekkaInfoKihonRelateEntity relateEntity : kihonRelateEntity) {
            businessList.add(new ChosaKekkaInfoKihonBusiness(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 基本調査_調査項目の情報を取得します。
     *
     * @param 基本調査_調査項目情報検索条件 ChosaKekkaInfoGaikyoParameter
     * @return SearchResult<TokiJikouBusiness> 基本調査_調査項目情報検索条件
     */
    @Transaction
    public SearchResult<TokiJikouBusiness> getTokiJikou(ChosaKekkaInfoKihonParameter 基本調査_調査項目情報検索条件) {
        List<TokiJikouBusiness> businessList = new ArrayList<>();
        IChosaKekkaInfoKihonMapper mapper = mapperProvider.create(IChosaKekkaInfoKihonMapper.class);
        List<TokiJikouRelateEntity> rsjresEntity = mapper.getChosaKekkaInfoKihonList2(基本調査_調査項目情報検索条件);
        for (TokiJikouRelateEntity itemEntity : rsjresEntity) {
            businessList.add(new TokiJikouBusiness(itemEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
