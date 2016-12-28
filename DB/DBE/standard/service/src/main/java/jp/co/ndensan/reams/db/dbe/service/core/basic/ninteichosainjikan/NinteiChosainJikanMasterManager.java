/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosainjikan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainjikan.NinteiChosainBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosainjikan.NinteiChosainJikanMasterParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainjikan.NinteiChosainEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosainjikan.INinteiChosainJikanMasterMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5224ChikuShichosonDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュール登録6を管理するクラスです。
 *
 * @reamsid_L DBE-0022-010 linghuhang
 */
public class NinteiChosainJikanMasterManager {

    private final MapperProvider mapperProvider;
    private final DbT5224ChikuShichosonDac dbt5224dac;
    private final ShichosonSecurityJohoFinder finder;
    private final DbT5221NinteichosaScheduleDac dac;

    /**
     * コンストラクタです。
     */
    NinteiChosainJikanMasterManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5224dac = InstanceProvider.create(DbT5224ChikuShichosonDac.class);
        this.finder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        this.dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param mapper Mapper
     * @param dbt5224dac dbt5224dac
     * @param finder finder
     */
    NinteiChosainJikanMasterManager(MapperProvider mapper,
            DbT5224ChikuShichosonDac dbt5224dac,
            ShichosonSecurityJohoFinder finder,
            DbT5221NinteichosaScheduleDac dac) {
        this.mapperProvider = mapper;
        this.dbt5224dac = dbt5224dac;
        this.finder = finder;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosainJikanMasterManager}のインスタンスを返します。
     *
     * @return NinteiChosainJikanMasterManager NinteiChosainJikanMasterManager
     */
    public static NinteiChosainJikanMasterManager createInstance() {
        return InstanceProvider.create(NinteiChosainJikanMasterManager.class);
    }

    /**
     * 調査地区コードを取得します。
     *
     * @return SearchResult<DbT5224ChikuShichosonEntity>
     */
    @Transaction
    public SearchResult<ChikuShichoson> getChikuShichosonList() {
        List<ChikuShichoson> chikuShichoson = new ArrayList<>();
        List<DbT5224ChikuShichosonEntity> dbT5224EntityList = new ArrayList();
        ShichosonSecurityJoho 自市町村情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (自市町村情報 != null && 自市町村情報.get市町村情報().get市町村コード() != null) {
            if (null != 自市町村情報.get市町村情報().get市町村識別ID() && 自市町村情報.get市町村情報().get市町村識別ID().is広域s()) {
                dbT5224EntityList = dbt5224dac.selectAll();
            } else {
                dbT5224EntityList = dbt5224dac.selectByShichosonCode(自市町村情報.get市町村情報().get市町村コード());
            }
        }
        if (dbT5224EntityList == null || dbT5224EntityList.isEmpty()) {
            return SearchResult.of(Collections.<ChikuShichoson>emptyList(), 0, false);
        }
        for (DbT5224ChikuShichosonEntity entity : dbT5224EntityList) {
            chikuShichoson.add(new ChikuShichoson(entity));
        }
        return SearchResult.of(chikuShichoson, 0, false);
    }

    /**
     * 認定調査スケジュール情報を取得します。
     *
     * @param ninteiChosaYoteiYMD 認定調査予定年月日
     * @param chosaChikuCode 調査地区コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param shichosonCode 市町村コード
     * @return SearchResult<NinteiChosainBusiness> 認定調査スケジュール情報
     */
    @Transaction
    public SearchResult<NinteiChosainBusiness> get時間枠設定一覧情報(
            FlexibleDate ninteiChosaYoteiYMD,
            Code chosaChikuCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            LasdecCode shichosonCode) {
        NinteiChosainJikanMasterParameter parameter = NinteiChosainJikanMasterParameter.createParam時間枠設定一覧情報(
                new FlexibleDate(ninteiChosaYoteiYMD.getYearMonth().toDateString()),
                chosaChikuCode,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                shichosonCode);
        INinteiChosainJikanMasterMapper mapper = mapperProvider.create(INinteiChosainJikanMasterMapper.class);
        List<NinteiChosainEntity> entityList = mapper.selectNinteichosa(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteiChosainBusiness>emptyList(), 0, false);
        }
        List<NinteiChosainBusiness> 認定調査 = new ArrayList<>();
        for (NinteiChosainEntity entity : entityList) {
            認定調査.add(new NinteiChosainBusiness(entity));
        }
        return SearchResult.of(認定調査, 0, false);
    }

    /**
     * 認定調査スケジュール情報を取得します。
     *
     * @param ninteiChosaYoteiYMD 認定調査予定年月日
     * @param chosaChikuCode 調査地区コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param shichosonCode 市町村コード
     * @return SearchResult<NinteiChosainBusiness> 認定調査スケジュール情報
     */
    @Transaction
    public SearchResult<NinteichosaSchedule> select時間枠設定一覧情報(
            FlexibleDate ninteiChosaYoteiYMD,
            Code chosaChikuCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            LasdecCode shichosonCode) {
        NinteiChosainJikanMasterParameter parameter = NinteiChosainJikanMasterParameter.createParam時間枠設定一覧情報(
                new FlexibleDate(ninteiChosaYoteiYMD.getYearMonth().toDateString()),
                chosaChikuCode,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                shichosonCode);
        INinteiChosainJikanMasterMapper mapper = mapperProvider.create(INinteiChosainJikanMasterMapper.class);
        List<DbT5221NinteichosaScheduleEntity> entityList = mapper.selectNintei(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedule>emptyList(), 0, false);
        }
        List<NinteichosaSchedule> 認定調査 = new ArrayList<>();
        for (DbT5221NinteichosaScheduleEntity entity : entityList) {
            entity.initializeMd5();
            認定調査.add(new NinteichosaSchedule(entity));
        }
        return SearchResult.of(認定調査, 0, false);
    }

    /**
     * 時間枠設定の編集元を取得します。
     *
     * @param ninteiChosaYoteiYMD 認定調査予定年月日
     * @param chosaChikuCode 調査地区コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param shichosonCode 市町村コード
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     * @param ninteiChosaJikanWaku 認定調査時間枠
     * @return SearchResult<NinteiChosainBusiness> 時間枠設定の編集元取得
     */
    @Transaction
    public NinteiChosainBusiness 時間枠設定の編集元取得(
            FlexibleDate ninteiChosaYoteiYMD,
            Code chosaChikuCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            LasdecCode shichosonCode,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        NinteiChosainJikanMasterParameter parameter = NinteiChosainJikanMasterParameter.createParam時間枠設定(
                ninteiChosaYoteiYMD,
                chosaChikuCode,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                shichosonCode,
                ninteiChosaYoteiKaishiTime,
                ninteiChosaYoteiShuryoTime,
                ninteiChosaJikanWaku);
        INinteiChosainJikanMasterMapper mapper = mapperProvider.create(INinteiChosainJikanMasterMapper.class);
        return new NinteiChosainBusiness(mapper.selectByKy(parameter));
    }

    /**
     * 認定調査スケジュール情報を更新します。
     *
     * @param 変更前データ 変更前データ
     * @param 変更後データ 変更後データ
     */
    @Transaction
    public void 更新(DbT5221NinteichosaScheduleEntity 変更前データ, DbT5221NinteichosaScheduleEntity 変更後データ) {
        変更後データ.setState(EntityDataState.Added);
        変更前データ.setState(EntityDataState.Deleted);
        dac.saveOrDelete(変更前データ);
        dac.save(変更後データ);
    }

    /**
     * DbT5221NinteichosaScheduleEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     */
    @Transaction
    public void saveOrDelete(DbT5221NinteichosaScheduleEntity entity) {
        dac.saveOrDelete(entity);
    }

    /**
     * DbT5221NinteichosaScheduleEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     */
    @Transaction
    public void save(DbT5221NinteichosaScheduleEntity entity) {
        dac.save(entity);
    }
}
