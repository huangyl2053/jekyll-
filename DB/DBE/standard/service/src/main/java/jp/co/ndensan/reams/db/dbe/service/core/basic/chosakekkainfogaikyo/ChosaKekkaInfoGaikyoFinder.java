/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo.RembanServiceJokyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosakekkainfogaikyo.IChosaKekkaInfoGaikyoMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査結果情報照会_概況調査を管理するクラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ChosaKekkaInfoGaikyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider
     */
    ChosaKekkaInfoGaikyoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaKekkaInfoGaikyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaKekkaInfoGaikyoFinder}のインスタンス
     */
    public static ChosaKekkaInfoGaikyoFinder createInstance() {
        return InstanceProvider.create(ChosaKekkaInfoGaikyoFinder.class);
    }

    /**
     * 認定調査結果情報照会を取得します。
     *
     * @param 認定調査結果情報照会検索条件 認定調査結果情報照会検索条件
     * @return 認定調査結果情報照会情報
     */
    @Transaction
    public SearchResult<ChosaKekkaInfoGaikyoBusiness> getChosaKekkaInfoGaikyo(ChosaKekkaInfoGaikyoParameter 認定調査結果情報照会検索条件) {
        List<ChosaKekkaInfoGaikyoBusiness> businessList = new ArrayList<>();
        IChosaKekkaInfoGaikyoMapper mapper = mapperProvider.create(IChosaKekkaInfoGaikyoMapper.class);
        List<ChosaKekkaInfoGaikyoRelateEntity> ninteiEntity = mapper.getChosaKekkaInfoGaikyoList1(認定調査結果情報照会検索条件);
        for (ChosaKekkaInfoGaikyoRelateEntity relateEntity : ninteiEntity) {
            businessList.add(new ChosaKekkaInfoGaikyoBusiness(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 認定調査結果情報照会を取得します。
     *
     * @param 認定調査結果情報照会検索条件 認定調査結果情報照会検索条件
     * @return 認定調査結果情報照会情報
     */
    @Transaction
    public SearchResult<RembanServiceJokyoBusiness> getRembanServiceJokyo(ChosaKekkaInfoGaikyoParameter 認定調査結果情報照会検索条件) {
        List<RembanServiceJokyoBusiness> businessList = new ArrayList<>();
        IChosaKekkaInfoGaikyoMapper mapper = mapperProvider.create(IChosaKekkaInfoGaikyoMapper.class);
        List<RembanServiceJokyoRelateEntity> rsjresEntity = mapper.getChosaKekkaInfoGaikyoList2(認定調査結果情報照会検索条件);
        for (RembanServiceJokyoRelateEntity relateEntity : rsjresEntity) {
            businessList.add(new RembanServiceJokyoBusiness(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 認定調査結果情報照会を取得します。
     *
     * @param 認定調査結果情報照会検索条件 認定調査結果情報照会検索条件
     * @return 認定調査結果情報照会情報
     */
    @Transaction
    public SearchResult<NinteichosahyoShisetsuRiyo> get5210NinteichosahyoShisetsu(ChosaKekkaInfoGaikyoParameter 認定調査結果情報照会検索条件) {
        List<NinteichosahyoShisetsuRiyo> businessList = new ArrayList<>();
        IChosaKekkaInfoGaikyoMapper mapper = mapperProvider.create(IChosaKekkaInfoGaikyoMapper.class);
        List<DbT5210NinteichosahyoShisetsuRiyoEntity> ninteiEntity = mapper.getChosaKekkaInfoGaikyoList3(認定調査結果情報照会検索条件);
        for (DbT5210NinteichosahyoShisetsuRiyoEntity relateEntity : ninteiEntity) {
            businessList.add(new NinteichosahyoShisetsuRiyo(relateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * イメージ共有ファイルIDを取得します。
     *
     * @param イメージ共有ファイルID検索条件 イメージ共有ファイルID検索条件
     * @return イメージ共有ファイルID検索条件
     */
    @Transaction
    public Image DbT5115Image(ChosaKekkaInfoGaikyoParameter イメージ共有ファイルID検索条件) {
        IChosaKekkaInfoGaikyoMapper mapper = mapperProvider.create(IChosaKekkaInfoGaikyoMapper.class);
        DbT5115ImageEntity ninteiEntity = mapper.getChosaKekkaInfoGaikyoList4(イメージ共有ファイルID検索条件);
        return new Image(ninteiEntity);
    }
}
