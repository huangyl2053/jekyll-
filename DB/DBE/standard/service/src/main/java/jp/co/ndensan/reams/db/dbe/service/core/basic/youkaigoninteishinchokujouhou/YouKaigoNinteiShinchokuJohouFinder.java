/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.youkaigoninteishinchokujouhou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness.NinteichosaSchedulBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.youkaigoninteishinchokujouhou.IYouKaigoNinteiShinchokuJohouMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定進捗情報データ出力の処理です。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
public class YouKaigoNinteiShinchokuJohouFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    YouKaigoNinteiShinchokuJohouFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    YouKaigoNinteiShinchokuJohouFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YouKaigoNinteiShinchokuJohouFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YouKaigoNinteiShinchokuJohouFinder}のインスタンス
     */
    public static YouKaigoNinteiShinchokuJohouFinder createInstance() {
        return InstanceProvider.create(YouKaigoNinteiShinchokuJohouFinder.class);
    }

    /**
     * 対象者一覧結果情報を検索する。
     *
     * @param parametere YouKaigoNinteiShinchokuJohouParameter
     * @return 結果情報list
     */
    @Transaction
    public SearchResult<YouKaigoNinteiShinchokuJohouBusiness> get結果情報検索(YouKaigoNinteiShinchokuJohouParameter parametere) {
        List<YouKaigoNinteiShinchokuJohouBusiness> kojinJokyoShokaiList = new ArrayList();
        IYouKaigoNinteiShinchokuJohouMapper mapper = mapperProvider.create(IYouKaigoNinteiShinchokuJohouMapper.class);
        List<YouKaigoNinteiShinchokuJohouRelateEntity> 結果情報list = mapper.get結果情報(parametere);
        if (結果情報list == null || 結果情報list.isEmpty()) {
            return SearchResult.of(Collections.<YouKaigoNinteiShinchokuJohouBusiness>emptyList(), 0, false);
        }
        for (YouKaigoNinteiShinchokuJohouRelateEntity entity : 結果情報list) {
            kojinJokyoShokaiList.add(new YouKaigoNinteiShinchokuJohouBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 対象者一覧進捗情報を検索する。
     *
     * @param parametere YouKaigoNinteiShinchokuJohouParameter
     * @return 進捗情報list
     */
    @Transaction
    public SearchResult<YouKaigoNinteiShinchokuJohouBusiness> get進捗情報検索(YouKaigoNinteiShinchokuJohouParameter parametere) {
        List<YouKaigoNinteiShinchokuJohouBusiness> kojinJokyoShokaiList = new ArrayList();
        IYouKaigoNinteiShinchokuJohouMapper mapper = mapperProvider.create(IYouKaigoNinteiShinchokuJohouMapper.class);
        List<YouKaigoNinteiShinchokuJohouRelateEntity> 進捗情報list = mapper.get進捗情報(parametere);
        if (進捗情報list == null || 進捗情報list.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (YouKaigoNinteiShinchokuJohouRelateEntity entity : 進捗情報list) {
            kojinJokyoShokaiList.add(new YouKaigoNinteiShinchokuJohouBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }
}
