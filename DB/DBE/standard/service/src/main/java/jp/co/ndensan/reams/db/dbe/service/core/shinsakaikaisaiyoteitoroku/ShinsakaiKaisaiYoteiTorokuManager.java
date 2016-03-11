/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaiyoteitoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteitoroku.IShinsakaiKaisaiYoteiTorokuMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 介護認定審査会開催予定登録1のManagerです。
 */
public class ShinsakaiKaisaiYoteiTorokuManager {

    private final MapperProvider mapperProvider;
    private final DbT5501ShinsakaiKaisaiYoteiJohoDac dbt5501dac;

    ShinsakaiKaisaiYoteiTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5501dac = InstanceProvider.create(DbT5501ShinsakaiKaisaiYoteiJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaiKaisaiYoteiTorokuManager(
            MapperProvider mapperProvider, DbT5501ShinsakaiKaisaiYoteiJohoDac dbt5501dac
    ) {
        this.mapperProvider = mapperProvider;
        this.dbt5501dac = dbt5501dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiTorokuManager}のインスタンス
     */
    public static ShinsakaiKaisaiYoteiTorokuManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiYoteiTorokuManager.class);
    }

    /**
     * 割付可能チェッのcount数を返します。
     *
     * @param 開催番号 開催番号
     * @return 検索結果count
     */
    @Transaction
    public int get割付可能チェック(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        IShinsakaiKaisaiYoteiTorokuMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiTorokuMapper.class);
        return mapper.getDbT5511Count(開催番号);
    }

    /**
     * 開催予定登録チェックのcount数を返します。
     *
     * @param 開催番号 開催番号
     * @return 検索結果count
     */
    @Transaction
    public int get開催予定登録チェック(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        IShinsakaiKaisaiYoteiTorokuMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiTorokuMapper.class);
        return mapper.getDbT5501Count(開催番号);
    }

    /**
     * 地区認定調査員情報を取得します。
     *
     * @param 年月 年月
     * @return SearchResult<ChikuNinteiChosain>
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiYoteiJoho> get介護認定審査会開催予定情報(RString 年月) {

        List<ShinsakaiKaisaiYoteiJoho> resultList = new ArrayList<>();
        List<DbT5501ShinsakaiKaisaiYoteiJohoEntity> shinsaYoteiJohoList = dbt5501dac.selectNengetsu(年月);
        if (shinsaYoteiJohoList == null || shinsaYoteiJohoList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiKaisaiYoteiJoho>emptyList(), 0, false);
        }
        for (DbT5501ShinsakaiKaisaiYoteiJohoEntity entity : shinsaYoteiJohoList) {
            entity.initializeMd5();
            resultList.add(new ShinsakaiKaisaiYoteiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 介護認定審査会開催予定情報{@link ShinsakaiKaisaiYoteiJoho}を登録/更新します。
     *
     * @param 介護認定審査会開催予定情報 {@link ShinsakaiKaisaiYoteiJoho}
     * @return 登録/更新件数 登録/更新結果の件数を返します。
     */
    @Transaction
    public int insertOrUpdate(ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報) {
        if (!介護認定審査会開催予定情報.hasChanged()) {
            return 0;
        }
        return dbt5501dac.save(介護認定審査会開催予定情報.toEntity());
    }
}
