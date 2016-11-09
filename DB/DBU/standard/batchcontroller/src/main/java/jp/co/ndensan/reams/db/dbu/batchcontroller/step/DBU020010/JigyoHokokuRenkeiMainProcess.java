/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU020010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokurenkei.JigyoHokokuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 様式別連携情報作成のバッチ処理プロセスクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
public class JigyoHokokuRenkeiMainProcess extends BatchProcessBase<DbT7021JigyoHokokuTokeiDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokurenkei.IJigyoHokokuRenkeiMapper.get事業報告統計情報の取得");
    private static final RString 番号 = new RString("保険者番号");
    private static final RString 名称 = new RString("保険者名称");
    private final RDate 基準日 = RDate.getNowDate();
    private JigyoHokokuRenkeiProcessParameter processParameter;
    private static MapperProvider mapperProvider;
    private IJigyoHokokuRenkeiMapper mapper;
    private Map<RString, List<RString>> 保険者番号data;
    private Map<RString, List<RString>> 保険者名称data;
    /**
     * 保険者番号の取得です。
     */
    public static final RString 保険者番号;
    /**
     * 保険者名称の取得です。
     */
    public static final RString 保険者名称;

    static {
        保険者番号 = new RString("hiHokenshaNo");
        保険者名称 = new RString("hiHokenshaName");
    }
    private OutputParameter<Map<RString, List<RString>>> hiHokenshaNo;
    private OutputParameter<Map<RString, List<RString>>> hiHokenshaName;

    @Override
    protected void initialize() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        mapper = mapperProvider.create(IJigyoHokokuRenkeiMapper.class);
        保険者番号data = new HashMap<>();
        保険者名称data = new HashMap<>();
        List<RString> 保険者番号List = new ArrayList<>();
        List<RString> 保険者名称List = new ArrayList<>();
        if (processParameter.is旧保険者分()) {
            List<DbT7056GappeiShichosonEntity> 合併市町村data = mapper.get合併市町村の取得(processParameter.toMybatisParamter());
            for (DbT7056GappeiShichosonEntity dbT7056entity : 合併市町村data) {
                保険者番号List.add(get旧保険者番号(dbT7056entity.getKyuHokenshaNo()));
                保険者名称List.add(dbT7056entity.getKyuShichosonMeisho());
            }
        } else if (processParameter.is構成市町村分()) {
            List<DbT7051KoseiShichosonMasterEntity> 構成市町村data = mapper.get構成市町村マスタの取得(processParameter.toMybatisParamter());
            for (DbT7051KoseiShichosonMasterEntity dbT7051entity : 構成市町村data) {
                保険者番号List.add(get証記載保険者番号(dbT7051entity.getShoKisaiHokenshaNo()));
                保険者名称List.add(dbT7051entity.getShichosonMeisho());
            }
        } else {
            保険者番号List.add(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告));
            保険者名称List.add(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, 基準日, SubGyomuCode.DBU介護統計報告));
        }
        保険者番号data.put(番号, 保険者番号List);
        保険者名称data.put(名称, 保険者名称List);
        hiHokenshaNo = new OutputParameter<>();
        hiHokenshaName = new OutputParameter<>();
        hiHokenshaNo.setValue(保険者番号data);
        hiHokenshaName.setValue(保険者名称data);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisParamter());
    }

    @Override
    protected void process(DbT7021JigyoHokokuTokeiDataEntity entity) {
    }

    private RString get旧保険者番号(HokenshaNo date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.value();
    }

    private RString get証記載保険者番号(ShoKisaiHokenshaNo date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.value();
    }
}
