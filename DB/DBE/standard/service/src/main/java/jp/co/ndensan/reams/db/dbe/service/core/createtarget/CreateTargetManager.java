/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.createtarget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.ExaminationsPartialResult;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.ApplicationsResultMain;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CenterTransmissionRecords;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CenterTransmissionRecords.CenterTransmissionRecordsBuilder;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.createtarget.CreateTargetMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetCsvRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.createtarget.ICreateTargetMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7211GaibuRenkeiDataoutputJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7211GaibuRenkeiDataoutputJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * センター送信データ出力クラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateTargetManager {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac dbt5101Dac;
    private final DbT7211GaibuRenkeiDataoutputJohoDac db7211Dac;

    /**
     * コンストラクタです。
     */
    CreateTargetManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.db7211Dac = InstanceProvider.create(DbT7211GaibuRenkeiDataoutputJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     * @param DbT5101NinteiShinseiJohoDac {@link dbt5101Dac}
     * @param DbT7211GaibuRenkeiDataoutputJohoDac {@link db7211Dac}
     */
    CreateTargetManager(MapperProvider mapperProvider, DbT5101NinteiShinseiJohoDac dbt5101Dac, DbT7211GaibuRenkeiDataoutputJohoDac db7211Dac) {
        this.mapperProvider = mapperProvider;
        this.dbt5101Dac = dbt5101Dac;
        this.db7211Dac = db7211Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link CreateTargetManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link CreateTargetManager}のインスタンス
     */
    public static CreateTargetManager createInstance() {
        return InstanceProvider.create(CreateTargetManager.class);
    }

    /**
     * 検索条件に従い、センター送信データ情報を検索します。
     *
     * @param param センター送信データ
     * @return SearchResult<CreateTargetBusiness> 対象者一覧情報
     */
    @Transaction
    public SearchResult<ExaminationsPartialResult> get対象者一覧情報(CreateTargetMapperParameter param) {
        List<ExaminationsPartialResult> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetRelateEntity> entityList = mapper.getTaishouJouhou(param);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ExaminationsPartialResult>emptyList(), 0, false);
        }
        int totalcount = entityList.get(0).getTotalCount();
        for (CreateTargetRelateEntity entity : entityList) {
            resultList.add(new ExaminationsPartialResult(entity));
        }
        return SearchResult.of(resultList, totalcount, param.get件数() < totalcount);
    }

    /**
     * @param param {@link CreateTargetMapperParameter}
     * @return センター送信用データ出力対象
     */
    public CenterTransmissionRecords getCsv出力用データ(CreateTargetMapperParameter param) {
        return new CenterTransmissionRecordsBuilder()
                .setMain(getMain(param))
                .setIkensho(get主治医意見書意見項目(param))
                .setServiceJokyo(getサービスの状況(param))
                .setKihonChosa(get調査票調査項目(param))
                .setLastServiceJokyo(get前回サービスの状況(param))
                .setLastKihonChosa(get前回調査票調査項目(param))
                .build();
    }

    /**
     * CSVファイル出力用データの抽出情報を検索します。
     *
     * @param param センター送信データ
     * @return CSVファイル出力用データ
     */
    private List<ApplicationsResultMain> getMain(CreateTargetMapperParameter param) {
        List<ApplicationsResultMain> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetCsvRelateEntity> entityList = mapper.getCsvData(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.<ApplicationsResultMain>emptyList();
        }
        for (CreateTargetCsvRelateEntity entity : entityList) {
            resultList.add(ApplicationsResultMain.creatCreateTargetCsvBusiness(entity));
        }
        return resultList;
    }

    /**
     * 検索条件に従い、主治医意見書意見項目を検索します。
     *
     * @param param センター送信データ
     * @return 主治医意見書情報
     */
    private List<ExaminationsPartialResult> get主治医意見書意見項目(CreateTargetMapperParameter param) {
        List<ExaminationsPartialResult> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetRelateEntity> entityList = mapper.get主治医意見書意見項目(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.<ExaminationsPartialResult>emptyList();
        }
        for (CreateTargetRelateEntity entity : entityList) {
            resultList.add(new ExaminationsPartialResult(entity));
        }
        return resultList;
    }

    /**
     * 検索条件に従い、サービスの状況を検索します。
     *
     * @param param センター送信データ
     * @return サービスの状況情報
     */
    private List<ExaminationsPartialResult> getサービスの状況(CreateTargetMapperParameter param) {
        List<ExaminationsPartialResult> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetRelateEntity> entityList = mapper.getサービスの状況(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.<ExaminationsPartialResult>emptyList();
        }
        for (CreateTargetRelateEntity entity : entityList) {
            resultList.add(new ExaminationsPartialResult(entity));
        }
        return resultList;
    }

    /**
     * 検索条件に従い、調査票調査項目を検索します。
     *
     * @param param センター送信データ
     * @return 調査票調査項目情報
     */
    private List<ExaminationsPartialResult> get調査票調査項目(CreateTargetMapperParameter param) {
        List<ExaminationsPartialResult> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetRelateEntity> entityList = mapper.get調査票調査項目(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.<ExaminationsPartialResult>emptyList();
        }
        for (CreateTargetRelateEntity entity : entityList) {
            resultList.add(new ExaminationsPartialResult(entity));
        }
        return resultList;
    }

    /**
     * 検索条件に従い、前回サービスの状況を検索します。
     *
     * @param param センター送信データ
     * @return 前回サービスの状況情報
     */
    private List<ExaminationsPartialResult> get前回サービスの状況(CreateTargetMapperParameter param) {
        List<ExaminationsPartialResult> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetRelateEntity> entityList = mapper.get前回サービスの状況(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.<ExaminationsPartialResult>emptyList();
        }
        for (CreateTargetRelateEntity entity : entityList) {
            resultList.add(new ExaminationsPartialResult(entity));
        }
        return resultList;
    }

    /**
     * 検索条件に従い、前回調査票調査項目を検索します。
     *
     * @param param センター送信データ
     * @return 前回調査票調査項目情報
     */
    @Transaction
    public List<ExaminationsPartialResult> get前回調査票調査項目(CreateTargetMapperParameter param) {
        List<ExaminationsPartialResult> resultList = new ArrayList<>();
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        List<CreateTargetRelateEntity> entityList = mapper.get前回調査票調査項目(param);
        if (entityList == null || entityList.isEmpty()) {
            return Collections.<ExaminationsPartialResult>emptyList();
        }
        for (CreateTargetRelateEntity entity : entityList) {
            resultList.add(new ExaminationsPartialResult(entity));
        }
        return resultList;
    }

    /**
     * 要介護認定申請情報テーブル更新します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return updateCount 更新件数
     */
    @Transaction
    public int update(RString 申請書管理番号) {
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        DbT5101NinteiShinseiJohoEntity entity = mapper.get申請情報(申請書管理番号);
        entity.setIfSofuYMD(FlexibleDate.getNowDate());
        entity.setState(EntityDataState.Modified);
        return dbt5101Dac.save(entity);
    }

    /**
     * 外部連携データ抽出情報テーブル更新します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return updateCount 更新件数
     */
    @Transaction
    public int insertUpdate(RString 申請書管理番号) {
        ICreateTargetMapper mapper = mapperProvider.create(ICreateTargetMapper.class);
        DbT7211GaibuRenkeiDataoutputJohoEntity entity = mapper.get外部連携データ(申請書管理番号);
        if (entity == null) {
            DbT7211GaibuRenkeiDataoutputJohoEntity dbt7211Entity = new DbT7211GaibuRenkeiDataoutputJohoEntity();
            dbt7211Entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
            dbt7211Entity.setCenterSoshinChushutsuYMD(FlexibleDate.getNowDate());
            return db7211Dac.save(dbt7211Entity);
        }
        entity.setCenterSoshinChushutsuYMD(FlexibleDate.getNowDate());
        entity.setState(EntityDataState.Modified);
        return db7211Dac.save(entity);
    }
}
