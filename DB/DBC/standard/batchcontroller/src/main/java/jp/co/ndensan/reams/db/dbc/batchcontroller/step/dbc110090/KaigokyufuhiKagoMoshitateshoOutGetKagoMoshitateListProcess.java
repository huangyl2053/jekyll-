/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090.KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomoshitateshoout.KagoMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成の送付対象データ取得Processクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutGetKagoMoshitateListProcess extends BatchProcessBase<DbT3059KagoMoshitateEntity> {

    /**
     * 送付対象データ取得の取得後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout."
                    + "IKaigokyufuhiKagoMoshitateshoOutMapper.select過誤申立データ");
    private static final RString 過誤申立一時TBL_NAME = new RString("DbWT1731KagoMoshitate");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWT1002KokuhorenSakuseiError");

    private KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter parameter;
    private KagoMoshitateMybatisParameter mybatisParameter;
    private int int_0 = 0;
    private int 連番 = 1;
    private static final RString 送付対象データなしのコード = new RString("01");
    private static final RString 同月審査区分_1 = new RString("1");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT1731TableWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT0001TableWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter dbWT1002TableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        mybatisParameter = new KagoMoshitateMybatisParameter();
        mybatisParameter.set再処理区分(parameter.get再処理区分());
        mybatisParameter.set処理年月(parameter.get処理年月());
        mybatisParameter.set申立書区分コード(parameter.get申立書区分コード());
        mybatisParameter.set送付対象情報(parameter.get送付対象情報());
        returnEntity = new FlowEntity();
    }

    @Override
    protected void createWriter() {
        this.dbWT1731TableWriter = new BatchEntityCreatedTempTableWriter(過誤申立一時TBL_NAME, DbWT1731KagoMoshitateTempEntity.class);
        this.dbWT0001TableWriter = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME, DbWT1001HihokenshaTempEntity.class);
        this.dbWT1002TableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        RString 同月審査区分 = DbBusinessConfig.get(ConfigNameDBC.過誤取下げ再請求指示_同月審査区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (同月審査区分_1.equals(同月審査区分)) {
            return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
        }
        return null;
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process(DbT3059KagoMoshitateEntity entity) {
        int_0++;
        dbWT1731TableWriter.insert(this.setDbWT1731KagoMoshitateTempEntity(entity));
        dbWT0001TableWriter.insert(this.setDbWT1001HihokenshaTempEntity(entity));
        連番++;

    }

    @Override
    protected void afterExecute() {
        if (0 == int_0) {
            DbWT1002KokuhorenSakuseiErrorTempEntity dbWT1002Entity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
            dbWT1002Entity.setErrorKubun(送付対象データなしのコード);
            dbWT1002TableWriter.insert(dbWT1002Entity);

        }
        returnEntity.setCodeNum(int_0);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);

    }

    private DbWT1731KagoMoshitateTempEntity setDbWT1731KagoMoshitateTempEntity(DbT3059KagoMoshitateEntity entity) {
        DbWT1731KagoMoshitateTempEntity dbWT1731Entity = new DbWT1731KagoMoshitateTempEntity();
        dbWT1731Entity.setRenban(連番);
        dbWT1731Entity.setJigyoshaNo(entity.getJigyoshoNo());
        dbWT1731Entity.setHiHokenshaNo(entity.getHiHokenshaNo());
        dbWT1731Entity.setServiceTeikyoYM(entity.getServiceTeikyoYM());
        dbWT1731Entity.setRirekiNo(entity.getRirekiNo());
        dbWT1731Entity.setMoshitateYMD(entity.getMoshitateYMD());
        dbWT1731Entity.setMoshitateJiyuCode(entity.getMoshitateJiyuCode());
        dbWT1731Entity.setShoKisaiHokenshaNo(entity.getShokisaiHokenshaNo());
        dbWT1731Entity.setMoshitateshaKubunCode(entity.getMoshitateshaKubunCode());
        dbWT1731Entity.setKokuhorenSofuYM(entity.getKokuhorenSofuYM());
        dbWT1731Entity.setKokuhirenSaiSofuAriFlag(entity.getKokuhirenSaiSofuAriFlag());
        dbWT1731Entity.setDogetsuShinsaAriFlag(entity.getDogetsuShinsaAriFlag());
        dbWT1731Entity.setMoshitateshoKubunCode(entity.getMoshitateshoKubunCode());
        dbWT1731Entity.setHokenshaNo(HokenshaNo.EMPTY);
        dbWT1731Entity.setHokenshaName(RString.EMPTY);
        dbWT1731Entity.setJigyoshaName(RString.EMPTY);
        if (DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)
                .equals(dbWT1731Entity.getShoKisaiHokenshaNo().getColumnValue())) {
            dbWT1731Entity.setShoKisaiHokenshaName(
                    DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        } else {
            dbWT1731Entity.setShoKisaiHokenshaName(RString.EMPTY);
        }
        dbWT1731Entity.setSofuJogaiFlag(false);
        return dbWT1731Entity;

    }

    private DbWT1001HihokenshaTempEntity setDbWT1001HihokenshaTempEntity(DbT3059KagoMoshitateEntity entity) {
        DbWT1001HihokenshaTempEntity dbWT1001Entity = new DbWT1001HihokenshaTempEntity();

        dbWT1001Entity.setExRenban(連番);
        dbWT1001Entity.setExHokenshaNo(HokenshaNo.EMPTY);
        dbWT1001Entity.setExHokenshaName(RString.EMPTY);
        dbWT1001Entity.setExShoHokenshaNo(entity.getShokisaiHokenshaNo());
        dbWT1001Entity.setExHihokenshaNo(entity.getHiHokenshaNo());
        dbWT1001Entity.setExServiceTeikyoYm(entity.getServiceTeikyoYM());
        dbWT1001Entity.setHenkanFlag(false);
        dbWT1001Entity.setOldShichosonCode(LasdecCode.EMPTY);
        dbWT1001Entity.setSofuHihokenshaNo(entity.getHiHokenshaNo());
        dbWT1001Entity.setShichosonCode(LasdecCode.EMPTY);
        dbWT1001Entity.setKannaiKangaiKubun(RString.EMPTY);
        dbWT1001Entity.setYubinNo(RString.EMPTY);
        dbWT1001Entity.setChoikiCode(RString.EMPTY);
        dbWT1001Entity.setGyoseikuCode(RString.EMPTY);
        dbWT1001Entity.setGyoseikuMei(RString.EMPTY);
        dbWT1001Entity.setJusho(RString.EMPTY);
        dbWT1001Entity.setBanchi(RString.EMPTY);
        dbWT1001Entity.setKatagaki(RString.EMPTY);
        dbWT1001Entity.setKanaMeisho(RString.EMPTY);
        dbWT1001Entity.setMeisho(RString.EMPTY);
        dbWT1001Entity.setShimei50onKana(RString.EMPTY);
        dbWT1001Entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        dbWT1001Entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        dbWT1001Entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        dbWT1001Entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        dbWT1001Entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        dbWT1001Entity.setSetaiShuyakuNo(RString.EMPTY);
        dbWT1001Entity.setSeinenYmd(FlexibleDate.EMPTY);
        dbWT1001Entity.setSeibetsuCode(RString.EMPTY);
        dbWT1001Entity.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        dbWT1001Entity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        return dbWT1001Entity;

    }

}
