/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.chosachiku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachiku.ChosaChikuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosachiku.ChosaChikuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachiku.ChosaChikuEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachiku.IChosaChikuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosainIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5223ChikuNinteiChosainDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地区認定調査員情報を管理するクラスです。
 *
 * @reamsid_L DBE-0021-010 zhangzhiming
 */
public class ChosaChikuManager {

    private final MapperProvider mapperProvider;
    private final DbT5910NinteichosaItakusakiJohoDac dbt5910dac;
    private final DbT5913ChosainJohoDac dbt5913dac;
    private final DbT5223ChikuNinteiChosainDac dbt5223dac;
    private final DbT5221NinteichosaScheduleDac dbt5221dac;

    /**
     * コンストラクタです。
     */
    ChosaChikuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5910dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.dbt5913dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
        this.dbt5223dac = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
        this.dbt5221dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ChosaChikuManager(MapperProvider mapperProvider, DbT5910NinteichosaItakusakiJohoDac dbt5910dac,
            DbT5913ChosainJohoDac dbt5913dac, DbT5223ChikuNinteiChosainDac dbt5223dac, DbT5221NinteichosaScheduleDac dbt5221dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5910dac = dbt5910dac;
        this.dbt5913dac = dbt5913dac;
        this.dbt5223dac = dbt5223dac;
        this.dbt5221dac = dbt5221dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaChikuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaChikuManager}のインスタンス
     */
    public static ChosaChikuManager createInstance() {
        return InstanceProvider.create(ChosaChikuManager.class);
    }

    /**
     * 調査地区/市町村情報を取得します。
     *
     * @return SearchResult<ChosaChikuBusiness>
     */
    @Transaction
    public SearchResult<ChosaChikuBusiness> getChosaChikuList() {

        List<ChosaChikuBusiness> resultList = new ArrayList<>();
        List<ChosaChikuEntity> chosaChiList = mapperProvider.create(IChosaChikuMapper.class).select調査地区情報();
        if (chosaChiList == null || chosaChiList.isEmpty()) {
            return SearchResult.of(Collections.<ChosaChikuBusiness>emptyList(), 0, false);
        }
        for (ChosaChikuEntity entity : chosaChiList) {
            resultList.add(new ChosaChikuBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 認定調査員一覧情報を取得します。
     *
     * @param paramer ChosaChikuMapperParameter
     * @return SearchResult<ChosaChikuBusiness>
     */
    @Transaction
    public SearchResult<ChosaChikuBusiness> getChikuNinnteiList(ChosaChikuMapperParameter paramer) {

        List<ChosaChikuBusiness> resultList = new ArrayList<>();
        List<ChosaChikuEntity> chikuNinnteiList = mapperProvider.create(IChosaChikuMapper.class).select認定調査員一覧(paramer);
        if (chikuNinnteiList == null || chikuNinnteiList.isEmpty()) {
            return SearchResult.of(Collections.<ChosaChikuBusiness>emptyList(), 0, false);
        }
        for (ChosaChikuEntity entity : chikuNinnteiList) {
            resultList.add(new ChosaChikuBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 地区認定調査員情報を取得します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return SearchResult<ChikuNinteiChosain>
     */
    @Transaction
    public SearchResult<ChikuNinteiChosain> get地区認定調査員情報(Code 調査地区コード, LasdecCode 市町村コード) {

        List<ChikuNinteiChosain> resultList = new ArrayList<>();
        List<DbT5223ChikuNinteiChosainEntity> chikuNinnteiList = dbt5223dac.selec地区認定調査員(調査地区コード, 市町村コード);
        if (chikuNinnteiList == null || chikuNinnteiList.isEmpty()) {
            return SearchResult.of(Collections.<ChikuNinteiChosain>emptyList(), 0, false);
        }
        for (DbT5223ChikuNinteiChosainEntity entity : chikuNinnteiList) {
            entity.initializeMd5();
            resultList.add(new ChikuNinteiChosain(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 地区認定調査員情報{@link ChikuNinteiChosain}を登録/更新します。
     *
     * @param 認定調査員情報 {@link ChikuNinteiChosain}
     * @return 登録/更新件数 登録/更新結果の件数を返します。
     */
    @Transaction
    public int insertOrUpdate(ChikuNinteiChosain 認定調査員情報) {
        if (!認定調査員情報.hasChanged()) {
            return 0;
        }
        return dbt5223dac.save(認定調査員情報.toEntity());
    }

    /**
     * 削除を行うデータの整合性チェックする。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @param 認定調査員コード 認定調査員コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return boolean
     */
    @Transaction
    public boolean getCheck(Code 調査地区コード, RString 認定調査委託先コード, RString 認定調査員コード, LasdecCode 市町村コード) {
        List<DbT5221NinteichosaScheduleEntity> entity = dbt5221dac.selectCount(調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
        return entity == null || entity.isEmpty();
    }

    /**
     * 地区認定調査員情報の削除処理する。
     *
     * @param models 地区認定調査員情報
     * @param key 地区認定調査員情報の識別子
     * @return 物理削除件数 物理削除結果の件数を返します。
     */
    @Transaction
    public boolean delete(Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> models,
            ChikuNinteiChosainIdentifier key) {
        ChikuNinteiChosain 地区認定調査員情報 = models.get(key);
        if (地区認定調査員情報 != null) {
            return 1 == dbt5223dac.delete(地区認定調査員情報.toEntity());
        }
        return false;
    }

    /**
     * 認定調査委託先名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 認定調査委託先名称
     */
    @Transaction
    public RString getChosaItakusaki(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        DbT5910NinteichosaItakusakiJohoEntity entity = dbt5910dac.selectByKey(市町村コード, 認定調査委託先コード);
        if (entity != null) {
            return entity.getJigyoshaMeisho();
        }
        return RString.EMPTY;
    }

    /**
     * 認定調査員名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return 認定調査員名称
     */
    @Transaction
    public RString getChosain(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        DbT5913ChosainJohoEntity entity = dbt5913dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード);
        if (entity != null && !entity.getChosainShimei().isNullOrEmpty()) {
            return entity.getChosainShimei();
        }
        return RString.EMPTY;
    }

    /**
     * 認定調査委託先コード、認定調査員コードの存在チェックする。
     *
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @return boolean
     */
    @Transaction
    public boolean chosainCheck(Code 調査地区コード, RString 認定調査委託先コード, RString 認定調査員コード, LasdecCode 市町村コード) {
        DbT5223ChikuNinteiChosainEntity entity = dbt5223dac.selectByKey(調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
        return entity != null;
    }
}
