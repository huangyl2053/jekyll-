/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosadataoutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaDataOutputMybitisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査一覧情報を取得するクラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
public class NinteiChosaDataOutputFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiChosaDataOutputFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    NinteiChosaDataOutputFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaDataOutputFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiChosaDataOutputFinder}のインスタンス
     */
    public static NinteiChosaDataOutputFinder createInstance() {
        return InstanceProvider.create(NinteiChosaDataOutputFinder.class);
    }

    /**
     * 認定調査一覧情報を取得します。
     *
     * @param param NinteiChosaDataOutputMybitisParameter
     * @return SearchResult<NinteiChosaDataOutputBusiness>
     */
    @Transaction
    public SearchResult<NinteiChosaDataOutputBusiness> getChosaChikuList(NinteiChosaDataOutputMybitisParameter param) {
        List<NinteiChosaDataOutputBusiness> resultList = new ArrayList<>();
        List<NinteiChosaDataOutputRelateEntity> 認定調査一覧List = mapperProvider.create(INinteiChosaDataOutputMapper.class).get認定調査一覧(param);
        if (認定調査一覧List == null || 認定調査一覧List.isEmpty()) {
            return SearchResult.of(Collections.<NinteiChosaDataOutputBusiness>emptyList(), 0, false);
        }
        for (NinteiChosaDataOutputRelateEntity entity : 認定調査一覧List) {
            resultList.add(new NinteiChosaDataOutputBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

}
