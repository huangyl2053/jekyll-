/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosascheduleinput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ninteichosascheduleinput.NinteiChosaSchedule;
import jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosascheduleinput.NinteiChosaScheduleInputParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosascheduleinput.NinteiChosaScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosascheduleinput.INinteiChosaScheduleInputMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 認定調査スケジュール登録10Managerクラです。
 */
public class NinteiChosaScheduleInputManager {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5221NinteichosaScheduleDac dbT5221Dac;
    private final DbT5121ShinseiRirekiJohoDac dbT5121Dac;

    /**
     * コンストラクタです。
     */
    NinteiChosaScheduleInputManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5221Dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
        this.dbT5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     * @param dbT5101Dac DbT5101NinteiShinseiJohoDac
     * @param dbT5221Dac DbT5221NinteichosaScheduleDac
     * @param dbT5121Dac DbT5121ShinseiRirekiJohoDac
     */
    NinteiChosaScheduleInputManager(
            MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac dbT5101Dac,
            DbT5221NinteichosaScheduleDac dbT5221Dac,
            DbT5121ShinseiRirekiJohoDac dbT5121Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5101Dac = dbT5101Dac;
        this.dbT5221Dac = dbT5221Dac;
        this.dbT5121Dac = dbT5121Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaScheduleInputManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaScheduleInputManager}のインスタンス
     */
    public static NinteiChosaScheduleInputManager createInstance() {
        return InstanceProvider.create(NinteiChosaScheduleInputManager.class);
    }

    /**
     * 調査員情報取得する。
     *
     * @param 申請者管理番号2 申請者管理番号2
     * @param 設定日 設定日
     * @param 時間枠 時間枠
     * @param 地区コード 地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @param 調査員状況02 調査員状況02
     * @return NinteiChosaSchedule 調査員情報 nullの場合存在する
     */
    @Transaction
    public NinteiChosaSchedule get調査員情報取得(
            RString 申請者管理番号2,
            RString 設定日,
            RString 時間枠,
            RString 地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 市町村コード,
            RString 調査員状況02) {
        INinteiChosaScheduleInputMapper mapper = mapperProvider.create(INinteiChosaScheduleInputMapper.class);
        NinteiChosaScheduleInputParameter parameter = NinteiChosaScheduleInputParameter.createParam(
                申請者管理番号2, 設定日, 時間枠, 地区コード, 認定調査委託先コード,
                認定調査員コード, 市町村コード, 調査員状況02);
        NinteiChosaScheduleRelateEntity entity = mapper.get調査員情報取得(parameter);
        if (entity == null) {
            return null;
        }
        return new NinteiChosaSchedule(entity);
    }

    /**
     * 調査員情報取得する。
     *
     * @param 申請者管理番号2 申請者管理番号2
     * @param 設定日 設定日
     * @param 時間枠 時間枠
     * @param 地区コード 地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @param 調査員状況02 調査員状況02
     * @return NinteiChosaSchedule 調査員情報 nullの場合存在する
     */
    @Transaction
    public NinteichosaSchedule get調査員情報(
            RString 申請者管理番号2,
            RString 設定日,
            RString 時間枠,
            RString 地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 市町村コード,
            RString 調査員状況02) {
        INinteiChosaScheduleInputMapper mapper = mapperProvider.create(INinteiChosaScheduleInputMapper.class);
        NinteiChosaScheduleInputParameter parameter = NinteiChosaScheduleInputParameter.createParam(申請者管理番号2, 設定日, 時間枠, 地区コード, 認定調査委託先コード,
                認定調査員コード, 市町村コード, 調査員状況02);
        DbT5221NinteichosaScheduleEntity entity = mapper.get調査員情報(parameter);
        if (entity == null) {
            return null;
        }
        return new NinteichosaSchedule(entity);
    }

    /**
     * 対象個人基本情報取得する。
     *
     * @param 申請者管理番号3 申請者管理番号3
     * @return 対象個人基本情報 nullの場合存在する
     */
    @Transaction
    public NinteiShinseiJoho get対象個人基本情報取得(ShinseishoKanriNo 申請者管理番号3) {
        DbT5101NinteiShinseiJohoEntity entity = dbT5101Dac.selectByKey(申請者管理番号3);
        if (entity == null) {
            return null;
        }
        return new NinteiShinseiJoho(entity);
    }

    /**
     * 対象調査基本情報取得する。
     *
     * @param 申請者管理番号3 申請者管理番号3
     * @return SearchResult<NinteiChosaSchedule> 対象調査基本情報
     */
    @Transaction
    public SearchResult<NinteichosaSchedule> get対象調査基本情報取得(ShinseishoKanriNo 申請者管理番号3) {
        List<NinteichosaSchedule> list = new ArrayList<>();
        List<DbT5221NinteichosaScheduleEntity> entityList = dbT5221Dac.selectBy申請書管理番号(申請者管理番号3);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedule>emptyList(), 0, false);
        }
        for (DbT5221NinteichosaScheduleEntity entity : entityList) {
            list.add(new NinteichosaSchedule(entity));
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 前回情報の取得する。
     *
     * @param 申請管理番号 申請管理番号
     * @return 前回情報 nullの場合存在する
     */
    @Transaction
    public ShinseiRirekiJoho get前回情報(ShinseishoKanriNo 申請管理番号) {
        DbT5121ShinseiRirekiJohoEntity entity = dbT5121Dac.selectByKey(申請管理番号);
        if (entity == null) {
            return null;
        }
        return new ShinseiRirekiJoho(entity);
    }

    /**
     * スケジュール情報のsaveです。
     *
     * @param ninteichosaSchedule 認定調査スケジュール情報
     * @return int
     */
    @Transaction
    public int saveスケジュール情報(NinteichosaSchedule ninteichosaSchedule) {
        if (ninteichosaSchedule != null) {
            DbT5221NinteichosaScheduleEntity entity = ninteichosaSchedule.toEntity();
            entity.setState(EntityDataState.Modified);
            return dbT5221Dac.save(entity);
        }
        return 0;
    }
}
