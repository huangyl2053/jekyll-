/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaikekka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaikaisaikekka.ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.shinsakaikaisaikekka.IShinsakaiKaisaiKekkaMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 介護認定審査会開催結果登録です。
 */
public class ShinsakaiKaisaiKekkaFinder {

    private static final RString REPLACEDMESSAGE = new RString("開催番号");
    private final MapperProvider mapperProvider;
    private final DbT5592ShinsakaiKaisaiBashoJohoDac dac;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiKekkaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT5592ShinsakaiKaisaiBashoJohoDac.class);
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dac DbT5592ShinsakaiKaisaiBashoJohoDac
     */
    ShinsakaiKaisaiKekkaFinder(
            MapperProvider mapperProvider,
            DbT5592ShinsakaiKaisaiBashoJohoDac dac
    ) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiKekkaFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiKekkaFinder}のインスタンス
     */
    public static ShinsakaiKaisaiKekkaFinder createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiKekkaFinder.class);
    }

    /**
     *
     * ヘッドエリア内容を取得です。
     *
     * @param 開催番号 開催番号
     * @return ヘッドエリア内容
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> getヘッドエリア内容検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACEDMESSAGE.toString()));
        IShinsakaiKaisaiKekkaMapper mapper = mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class);
        ShinsakaiKaisaiYoteiJohoEntity yoteiJohoEntity = mapper.getヘッドエリア内容検索(開催番号);
        List<ShinsakaiKaisaiYoteiJohoBusiness> kaisaiYoteiJohoBusiness = new ArrayList();
        if (yoteiJohoEntity != null) {
            kaisaiYoteiJohoBusiness.add(new ShinsakaiKaisaiYoteiJohoBusiness(yoteiJohoEntity));
        }

        return SearchResult.of(kaisaiYoteiJohoBusiness, 0, false);
    }

    /**
     * 開催会場リストを取得です。
     *
     * @return 開催会場
     */
    @Transaction
    public List<KeyValueDataSource> get開催会場() {
        List<KeyValueDataSource> 開催会場 = new ArrayList<>();
        List<DbT5592ShinsakaiKaisaiBashoJohoEntity> 開催会場リスト = dac.selectAll();
        if (開催会場リスト != null) {
            for (int i = 0; i < 開催会場リスト.size(); i++) {
                開催会場.add(new KeyValueDataSource(
                        開催会場リスト.get(i).getShinsakaiKaisaiBashoCode(),
                        開催会場リスト.get(i).getShinsakaiKaisaiBashoName()));
            }
        }
        return 開催会場;
    }

    /**
     * 審査会委員一覧検索を取得です。
     *
     * @param 開催番号 開催番号
     * @return 審査会委員一覧
     */
    @Transaction
    public SearchResult<ShinsakaiWariateIinJohoBusiness> get審査会委員一覧検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACEDMESSAGE.toString()));
        IShinsakaiKaisaiKekkaMapper mapper = mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class);
        List<ShinsakaiWariateIinJohoEntity> entityList = mapper.get審査会委員一覧検索(開催番号);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiWariateIinJohoBusiness>emptyList(), 0, false);
        }
        List<ShinsakaiWariateIinJohoBusiness> wariateIinJohoBusiness = new ArrayList();
        for (ShinsakaiWariateIinJohoEntity entity : entityList) {
            wariateIinJohoBusiness.add(new ShinsakaiWariateIinJohoBusiness(entity));
        }
        return SearchResult.of(wariateIinJohoBusiness, 0, false);
    }

    /**
     * 審査会委員一覧検索を取得です。
     *
     * @param 開催番号 開催番号
     * @return 審査会委員一覧
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiYoteiJoho> get審査会委員(RString 開催番号) {
        List<ShinsakaiKaisaiYoteiJoho> resultList = new ArrayList<>();
        List<ShinsakaiKaisaiYoteiJohoRelateEntity> entityList
                = mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class).get開催予定情報更新(開催番号);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (ShinsakaiKaisaiYoteiJohoRelateEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            resultList.add(new ShinsakaiKaisaiYoteiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * MAX(連番)を取得です。
     *
     * @param 開催番号 開催番号
     * @return MAX連番
     */
    @Transaction
    public int get連番(RString 開催番号) {
        return mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class).get連番(開催番号);
    }
}
