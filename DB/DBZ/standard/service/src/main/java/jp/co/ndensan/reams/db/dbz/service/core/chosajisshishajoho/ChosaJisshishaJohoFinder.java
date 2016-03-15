/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.chosajisshishajoho.IChosaJisshishaJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 調査実施者情報の検索処理クラスです。
 */
public class ChosaJisshishaJohoFinder {
    
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ChosaJisshishaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    
    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link MapperProvider}
     */
    ChosaJisshishaJohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaJisshishaJohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaJisshishaJohoFinder}のインスタンス
     */
    public static ChosaJisshishaJohoFinder createInstance() {
        return InstanceProvider.create(ChosaJisshishaJohoFinder.class);
    }
    
    /**
     * 所属機関のデータソースを取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<NinteichosaItakusakiJoho> getSyozokuKikan(RString shinseishoKanriNo) {
        List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        List<DbT5910NinteichosaItakusakiJohoEntity> syozokuKikanList = mapper.getSyozokuKikan(shinseishoKanriNo);
        for (DbT5910NinteichosaItakusakiJohoEntity syozokuKikan : syozokuKikanList) {
            ninteichosaItakusakiJohoList.add(new NinteichosaItakusakiJoho(syozokuKikan));
        }
        return SearchResult.of(ninteichosaItakusakiJohoList, 0, false);
    }
    
    /**
     * 記入者の初期値を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<ChosainJoho> getKinyusha(RString shinseishoKanriNo) {
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        List<DbT5913ChosainJohoEntity> kinyushaList = mapper.getKinyusha(shinseishoKanriNo);
        for (DbT5913ChosainJohoEntity kinyusha : kinyushaList) {
            chosainJohoList.add(new ChosainJoho(kinyusha));
        }
        return SearchResult.of(chosainJohoList, 0, false);
    }
    
    /**
     * 所属機関のデータソースを取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<ChosainJoho> getKinyushaEmpty(RString shinseishoKanriNo) {
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        List<DbT5913ChosainJohoEntity> kinyushaEmptyList = mapper.getKinyushaEmpty(shinseishoKanriNo);
        for (DbT5913ChosainJohoEntity kinyushaEmpty : kinyushaEmptyList) {
            chosainJohoList.add(new ChosainJoho(kinyushaEmpty));
        }
        return SearchResult.of(chosainJohoList, 0, false);
    }
}
