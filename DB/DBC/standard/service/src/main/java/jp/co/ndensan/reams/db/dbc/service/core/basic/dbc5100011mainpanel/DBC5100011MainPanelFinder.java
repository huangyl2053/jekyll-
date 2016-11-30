/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic.dbc5100011mainpanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakukaigotaishoumainpanel.KougakuKaigotaiShouMainPanelMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakukaigotaishoushachuushutsumainpanel.IKougakuKaigotaiShouMainPanelMapper;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBCMN41003_高額介護対象者抽出（遡及分）管理するクラスです。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
public class DBC5100011MainPanelFinder {

    private final DbT3104KokuhorenInterfaceKanriDac dbT3104;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public DBC5100011MainPanelFinder() {
        this.dbT3104 = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    DBC5100011MainPanelFinder(DbT3104KokuhorenInterfaceKanriDac dbT3104,
            MapperProvider mapperProvider) {
        this.dbT3104 = dbT3104;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinHoshuNyuryokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinHoshuNyuryokuFinder}のインスタンス
     */
    public static DBC5100011MainPanelFinder createInstance() {
        return InstanceProvider.create(DBC5100011MainPanelFinder.class);
    }

    /**
     * 処理番号有無 取得返します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 処理状態区分 処理状態区分
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    public SearchResult<KokuhorenInterfaceKanri> get処理番号(RString 交換情報識別番号, RString 処理状態区分) {
        List<KokuhorenInterfaceKanri> businessList = new ArrayList<>();
        List<DbT3104KokuhorenInterfaceKanriEntity> kokuhorenInterfaceKanriList = dbT3104.get処理番号(交換情報識別番号, 処理状態区分);
        if (kokuhorenInterfaceKanriList.isEmpty()) {
            return SearchResult.of(Collections.<KokuhorenInterfaceKanri>emptyList(), 0, false);
        }
        for (DbT3104KokuhorenInterfaceKanriEntity entity : kokuhorenInterfaceKanriList) {
            businessList.add(new KokuhorenInterfaceKanri(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 処理日付管理マスタ 取得返します。
     *
     * @param param param
     * @return SearchResult<ShoriDateKanri>
     */
    public SearchResult<ShoriDateKanri> get処理日付管理(KougakuKaigotaiShouMainPanelMapperParameter param) {
        List<ShoriDateKanri> businessList = new ArrayList<>();
        IKougakuKaigotaiShouMainPanelMapper mapper = mapperProvider.create(IKougakuKaigotaiShouMainPanelMapper.class);
        List<DbT7022ShoriDateKanriEntity> dbT7022ShoriDateKanriList = mapper.get処理日付管理(param);
        if (dbT7022ShoriDateKanriList.isEmpty()) {
            return SearchResult.of(Collections.<ShoriDateKanri>emptyList(), 0, false);
        }
        for (DbT7022ShoriDateKanriEntity entity : dbT7022ShoriDateKanriList) {
            businessList.add(new ShoriDateKanri(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 国保連インターフェース管理 取得返します。
     *
     * @param param param
     * @return SearchResult<KokuhorenInterfaceKanri>
     */
    public SearchResult<KokuhorenInterfaceKanri> get国保連インターフェース管理(KougakuKaigotaiShouMainPanelMapperParameter param) {
        List<KokuhorenInterfaceKanri> businessList = new ArrayList<>();
        IKougakuKaigotaiShouMainPanelMapper mapper = mapperProvider.create(IKougakuKaigotaiShouMainPanelMapper.class);
        List<DbT3104KokuhorenInterfaceKanriEntity> dbT3104EntityList = mapper.get国保連インターフェース管理(param);
        if (dbT3104EntityList.isEmpty()) {
            return SearchResult.of(Collections.<KokuhorenInterfaceKanri>emptyList(), 0, false);
        }
        for (DbT3104KokuhorenInterfaceKanriEntity entity : dbT3104EntityList) {
            businessList.add(new KokuhorenInterfaceKanri(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
