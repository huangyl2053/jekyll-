/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.shinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteijoho.IShinsakaiKaisaiYoteiJohoMapper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 開催予定情報クラスです。
 */
public class ShinsakaiKaisaiYoteiJohoManager {

    private final MapperProvider mapperProvider;
    private static final RString 未開催 = new RString("1");
    private static final RString 審査会名称 = new RString("第○○審査会");

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiYoteiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンスを返します。
     *
     * @return ShinsakaiKaisaiYoteiJohoManager
     */
    public static ShinsakaiKaisaiYoteiJohoManager createInstance() {

        return InstanceProvider.create(ShinsakaiKaisaiYoteiJohoManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link mapperProvider}
     */
    ShinsakaiKaisaiYoteiJohoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 介護認定審査会開催予定情報の取得処理です。
     *
     * @param 表示年月 表示年月
     * @return 介護認定審査会開催予定情報
     */
    public SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> search審査会開催予定情報Of指定月(RString 表示年月) {
        List<ShinsakaiKaisaiYoteiJohoBusiness> 審査会開催予定情報 = new ArrayList<>();
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);
        List<ShinsakaiKaisaiYoteiJohoEntity> entityList = mapper.search審査会開催予定情報Of指定月(表示年月);
        for (ShinsakaiKaisaiYoteiJohoEntity entity : entityList) {
            審査会開催予定情報.add(new ShinsakaiKaisaiYoteiJohoBusiness(entity));
        }
        return SearchResult.of(審査会開催予定情報, 0, false);
    }

    /**
     * 開催予定入力欄内容の取得処理です。
     *
     * @param 設定日 設定日
     * @return 開催予定入力欄内容
     */
    public SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> search審査会開催予定情報Of指定日(RString 設定日) {
        List<ShinsakaiKaisaiYoteiJohoBusiness> 審査会開催予定情報 = new ArrayList<>();
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);
        List<ShinsakaiKaisaiYoteiJohoEntity> entityList = mapper.search審査会開催予定情報Of指定日(設定日);
        for (ShinsakaiKaisaiYoteiJohoEntity entity : entityList) {
            審査会開催予定情報.add(new ShinsakaiKaisaiYoteiJohoBusiness(entity));
        }
        return SearchResult.of(審査会開催予定情報, 0, false);
    }

    /**
     * 開催予定情報リストの更新処理です。
     *
     * @param 設定日 設定日
     * @param 開始時間 開始時間
     * @param 終了時間 終了時間
     * @param 合議体番号 合議体番号
     * @return 介護認定審査会開催予定情報Entity
     */
    public ShinsakaiKaisaiYoteiJohoBusiness get合議体情報(RString 設定日, RString 開始時間, RString 終了時間, int 合議体番号) {
        ShinsakaiKaisaiYoteiJohoEntity shinsakaiYotei = new ShinsakaiKaisaiYoteiJohoEntity();
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);
        GogitaiJohoShinsaRelateEntity entity = mapper.get合議体情報(合議体番号);
        shinsakaiYotei.set開催予定日(new FlexibleDate(設定日));
        shinsakaiYotei.set開催番号(RString.EMPTY);
        shinsakaiYotei.set予定開始時間(開始時間);
        shinsakaiYotei.set予定終了時間(終了時間);
        shinsakaiYotei.set合議体番号(合議体番号);
        shinsakaiYotei.set介護認定審査会進捗状況(未開催);
        shinsakaiYotei.set審査会名称(審査会名称);
        if (entity != null) {
            shinsakaiYotei.set催予定場所コード(entity.get介護認定審査会開催場所コード());
            shinsakaiYotei.set予定定員(entity.get介護認定審査会予定定員());
            shinsakaiYotei.set自動割当定員(entity.get介護認定審査会自動割当定員());
            shinsakaiYotei.set委員定員(entity.get介護認定審査会委員定員());
        }
        return new ShinsakaiKaisaiYoteiJohoBusiness(shinsakaiYotei);
    }
}
