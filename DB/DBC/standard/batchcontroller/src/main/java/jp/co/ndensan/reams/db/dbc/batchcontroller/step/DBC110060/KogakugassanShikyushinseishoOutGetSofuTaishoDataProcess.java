/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110060;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.KogakugassanShikyushinseishoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110060.KogakugassanShikyushinseishoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成の送付対象データ取得Process
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class KogakugassanShikyushinseishoOutGetSofuTaishoDataProcess extends BatchProcessBase<KogakuGassanShinseishoDataEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.get高額合算申請書データ");
    private static final RString 高額合算申請書一時TABLE_NAME = new RString("DbWT3711KogakuGassanShinseisho");
    private static final RString 被保険者一時TABLE_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_5 = 5;
    private static final int INDEX_11 = 11;

    private KogakugassanShikyushinseishoOutProcessParameter processParameter;
    private KogakugassanShikyushinseishoOutMybatisParameter mybatisParameter;
    private OutputParameter<Integer> outCount;
    private int 合計;
    private RString 業務保険者番号;
    private RString 業務保険者名称;
    private RDateTime システム日付;
    /**
     * 送付対象データ取得件数合計です。
     */
    public static final RString PARAMETER_OUT_OUTCOUNT;

    static {
        PARAMETER_OUT_OUTCOUNT = new RString("outCount");
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算申請書一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    @Override
    protected void initialize() {
        合計 = INDEX_0;
        outCount = new OutputParameter<>();
        システム日付 = RDateTime.now();
        業務保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                システム日付.getDate(), SubGyomuCode.DBU介護統計報告);
        業務保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                システム日付.getDate(), SubGyomuCode.DBU介護統計報告);

    }

    @Override
    protected IBatchReader createReader() {
        mybatisParameter = new KogakugassanShikyushinseishoOutMybatisParameter(processParameter.get再処理区分(),
                processParameter.get処理年月());
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        高額合算申請書一時tableWriter = new BatchEntityCreatedTempTableWriter(高額合算申請書一時TABLE_NAME,
                DbWT3711KogakuGassanShinseishoTempEntity.class);
        被保険者一時tableWriter = new BatchEntityCreatedTempTableWriter(被保険者一時TABLE_NAME,
                DbWT1001HihokenshaTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TABLE_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanShinseishoDataEntity entity) {
        合計 = 合計 + INDEX_1;
        高額合算申請書一時tableWriter.insert(set高額合算申請書一時(entity));
        被保険者一時tableWriter.insert(set被保険者一時(entity));

    }

    @Override
    protected void afterExecute() {
        if (INDEX_0 == 合計) {
            DbWT1002KokuhorenSakuseiErrorTempEntity tempEntity = get処理結果リスト一時Entity();
            処理結果リスト一時tableWriter.insert(tempEntity);
        }
        outCount.setValue(合計);
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時Entity() {
        DbWT1002KokuhorenSakuseiErrorTempEntity dbwt1002Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        dbwt1002Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        dbwt1002Enttiy.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        dbwt1002Enttiy.setHihokenshaNo(HihokenshaNo.EMPTY);
        dbwt1002Enttiy.setKey1(RString.EMPTY);
        dbwt1002Enttiy.setKey2(RString.EMPTY);
        dbwt1002Enttiy.setKey3(RString.EMPTY);
        dbwt1002Enttiy.setKey4(RString.EMPTY);
        dbwt1002Enttiy.setKey5(RString.EMPTY);
        dbwt1002Enttiy.setHihokenshaKanaShimei(RString.EMPTY);
        dbwt1002Enttiy.setHihokenshaShimei(RString.EMPTY);
        dbwt1002Enttiy.setBiko(RString.EMPTY);
        return dbwt1002Enttiy;
    }

    private DbWT3711KogakuGassanShinseishoTempEntity set高額合算申請書一時(KogakuGassanShinseishoDataEntity entity) {
        DbWT3711KogakuGassanShinseishoTempEntity dbwt3711Entity = new DbWT3711KogakuGassanShinseishoTempEntity();
        dbwt3711Entity.setRenban(合計);
        if (null != entity.get高額合算申請書Entity()) {
            dbwt3711Entity.setHihokenshaNo(entity.get高額合算申請書Entity().getHihokenshaNo());
            dbwt3711Entity.setTaishoNendo(entity.get高額合算申請書Entity().getTaishoNendo());
            dbwt3711Entity.setHokenshaNo(entity.get高額合算申請書Entity().getHokenshaNo());
            dbwt3711Entity.setSeiriNo(entity.get高額合算申請書Entity().getSeiriNo());
            dbwt3711Entity.setRirekiNo(entity.get高額合算申請書Entity().getRirekiNo());
            dbwt3711Entity.setShinseiJokyoKubun(entity.get高額合算申請書Entity().getShinseiJokyoKubun());
            dbwt3711Entity.setShinseiYMD(entity.get高額合算申請書Entity().getShinseiYMD());
            dbwt3711Entity.setShikyuShinseishoSeiriNo(entity.get高額合算申請書Entity().getShikyuShinseishoSeiriNo());
            dbwt3711Entity.setKokuhoShikyuShinseishoSeiriNo(entity.get高額合算申請書Entity().getKokuhoShikyuShinseishoSeiriNo());
            dbwt3711Entity.setShikyuShinseiKubun(entity.get高額合算申請書Entity().getShikyuShinseiKubun());
            dbwt3711Entity.setTaishoKeisanKaishiYMD(entity.get高額合算申請書Entity().getTaishoKeisanKaishiYMD());
            dbwt3711Entity.setTaishoKeisanShuryoYMD(entity.get高額合算申請書Entity().getTaishoKeisanShuryoYMD());
            dbwt3711Entity.setShikyuShinseiKeitai(entity.get高額合算申請書Entity().getShikyuShinseiKeitai());
            dbwt3711Entity.setJikoFutanKofuUmu(entity.get高額合算申請書Entity().getJikoFutanKofuUmu());
            dbwt3711Entity.setShinseiDaihyoshaShimei(entity.get高額合算申請書Entity().getShinseiDaihyoshaShimei());
            dbwt3711Entity.setShinseiDaihyoshaYubinNo(entity.get高額合算申請書Entity().getShinseiDaihyoshaYubinNo());
            dbwt3711Entity.setShinseiDaihyoshaJusho(entity.get高額合算申請書Entity().getShinseiDaihyoshaJusho());
            dbwt3711Entity.setShinseiDaihyoshaTelNo(entity.get高額合算申請書Entity().getShinseiDaihyoshaTelNo());
            dbwt3711Entity.setShotokuKubun(entity.get高額合算申請書Entity().getShotokuKubun());
            dbwt3711Entity.setOver70_ShotokuKubun(entity.get高額合算申請書Entity().getOver70_ShotokuKubun());
            dbwt3711Entity.setShikakuSoshitsuYMD(entity.get高額合算申請書Entity().getShikakuSoshitsuYMD());
            dbwt3711Entity.setShikakuSoshitsuJiyu(entity.get高額合算申請書Entity().getShikakuSoshitsuJiyu());
            dbwt3711Entity.setKanyuKaishiYMD(entity.get高額合算申請書Entity().getKanyuKaishiYMD());
            dbwt3711Entity.setKanyuShuryoYMD(entity.get高額合算申請書Entity().getKanyuShuryoYMD());
            dbwt3711Entity.setKokuho_HokenshaNo(entity.get高額合算申請書Entity().getKoki_HokenshaNo());
            dbwt3711Entity.setKokuho_HokenshaMeisho(entity.get高額合算申請書Entity().getKokuho_HokenshaMeisho());
            dbwt3711Entity.setKokuho_HihokenshaShoKigo(entity.get高額合算申請書Entity().getKokuho_HihokenshaShoKigo());
            dbwt3711Entity.setKokuho_HihokenshaShoNo(entity.get高額合算申請書Entity().getKokuho_HihokenshaShoNo());
            dbwt3711Entity.setKokuho_SetaiNo(entity.get高額合算申請書Entity().getKokuho_SetaiNo());
            dbwt3711Entity.setKokuho_Zokugara(entity.get高額合算申請書Entity().getKokuho_Zokugara());
            dbwt3711Entity.setKokuho_KanyuKaishiYMD(entity.get高額合算申請書Entity().getKokuho_KanyuKaishiYMD());
            dbwt3711Entity.setKokuho_KanyuShuryoYMD(entity.get高額合算申請書Entity().getKokuho_KanyuShuryoYMD());
            dbwt3711Entity.setKoki_HokenshaNo(entity.get高額合算申請書Entity().getKoki_HokenshaNo());
            dbwt3711Entity.setKoki_KoikiRengoMeisho(entity.get高額合算申請書Entity().getKoki_KoikiRengoMeisho());
            dbwt3711Entity.setKoki_HihokenshaNo(entity.get高額合算申請書Entity().getKoki_HihokenshaNo());
            dbwt3711Entity.setKoki_KanyuKaishiYMD(entity.get高額合算申請書Entity().getKoki_KanyuKaishiYMD());
            dbwt3711Entity.setKoki_KanyuShuryoYMD(entity.get高額合算申請書Entity().getKoki_KanyuShuryoYMD());
            dbwt3711Entity.setShiharaiHohoKubun(entity.get高額合算申請書Entity().getShiharaiHohoKubun());
            dbwt3711Entity.setShiharaiBasho(entity.get高額合算申請書Entity().getShiharaiBasho());
            dbwt3711Entity.setShiharaiKaishiYMD(entity.get高額合算申請書Entity().getShiharaiKaishiYMD());
            dbwt3711Entity.setShiharaiShuryoYMD(entity.get高額合算申請書Entity().getShiharaiShuryoYMD());
            dbwt3711Entity.setHeichoNaiyo(entity.get高額合算申請書Entity().getHeichoNaiyo());
            dbwt3711Entity.setShiharaiKaishiTime(entity.get高額合算申請書Entity().getShiharaiKaishiTime());
            dbwt3711Entity.setShiharaiShuryoTime(entity.get高額合算申請書Entity().getShiharaiShuryoTime());
            dbwt3711Entity.setKozaID(entity.get高額合算申請書Entity().getKozaID());
            dbwt3711Entity.setBiko(entity.get高額合算申請書Entity().getBiko());
            dbwt3711Entity.setShikyuShinseisho_SofuYM(entity.get高額合算申請書Entity().getShikyuShinseisho_SofuYM());
            dbwt3711Entity.setSaiSofuFlag(entity.get高額合算申請書Entity().getSaiSofuFlag());
            dbwt3711Entity.setJikoFutan_KeisanYM(entity.get高額合算申請書Entity().getJikoFutan_KeisanYM());
            dbwt3711Entity.setSaiKeisanKubun(entity.get高額合算申請書Entity().getSaiKeisanKubun());
            if (entity.getRowNum() == INDEX_1) {
                dbwt3711Entity.setJufukuKubun(false);
            } else {
                dbwt3711Entity.setJufukuKubun(true);
            }
            RString strNo = entity.get高額合算申請書Entity().getShikyuShinseishoSeiriNo();
            RString 証記載保険者番号 = RString.EMPTY;
            if (null != strNo && !strNo.isEmpty()) {
                証記載保険者番号 = strNo.substring(INDEX_5, INDEX_11);
                dbwt3711Entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(証記載保険者番号));
            }
            if (証記載保険者番号.equals(業務保険者番号)) {
                dbwt3711Entity.setShoKisaiHokenshaName(業務保険者名称);
            } else {
                dbwt3711Entity.setShoKisaiHokenshaName(RString.EMPTY);
            }
        }
        return dbwt3711Entity;
    }

    private DbWT1001HihokenshaTempEntity set被保険者一時(KogakuGassanShinseishoDataEntity entity) {
        DbWT1001HihokenshaTempEntity dbwt1001Entity = new DbWT1001HihokenshaTempEntity();
        dbwt1001Entity.setExRenban(合計);
        dbwt1001Entity.setExHokenshaNo(null);
        dbwt1001Entity.setExHokenshaName(RString.EMPTY);
        if (null != entity.get高額合算申請書Entity()) {
            RString strNo = entity.get高額合算申請書Entity().getShikyuShinseishoSeiriNo();
            if (null != strNo && !strNo.isEmpty()) {
                RString 証記載保険者番号 = strNo.substring(INDEX_5, INDEX_11);
                dbwt1001Entity.setExShoHokenshaNo(new ShoKisaiHokenshaNo(証記載保険者番号));
            }
            dbwt1001Entity.setExHihokenshaNo(entity.get高額合算申請書Entity().getHihokenshaNo());
            dbwt1001Entity.setSofuHihokenshaNo(entity.get高額合算申請書Entity().getHihokenshaNo());
        }
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(システム日付.getDate().getYearMonth().toDateString());
        dbwt1001Entity.setExServiceTeikyoYm(サービス提供年月);
        dbwt1001Entity.setHenkanFlag(false);
        dbwt1001Entity.setOldShichosonCode(null);
        dbwt1001Entity.setShichosonCode(null);
        dbwt1001Entity.setKannaiKangaiKubun(RString.EMPTY);
        dbwt1001Entity.setYubinNo(RString.EMPTY);
        dbwt1001Entity.setChoikiCode(RString.EMPTY);
        dbwt1001Entity.setGyoseikuCode(RString.EMPTY);
        dbwt1001Entity.setGyoseikuMei(RString.EMPTY);
        dbwt1001Entity.setJusho(RString.EMPTY);
        dbwt1001Entity.setBanchi(RString.EMPTY);
        dbwt1001Entity.setKatagaki(RString.EMPTY);
        dbwt1001Entity.setKanaMeisho(RString.EMPTY);
        dbwt1001Entity.setMeisho(RString.EMPTY);
        dbwt1001Entity.setShimei50onKana(RString.EMPTY);
        dbwt1001Entity.setShikibetsuCode(null);
        dbwt1001Entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        dbwt1001Entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        dbwt1001Entity.setSetaiShuyakuNo(RString.EMPTY);
        dbwt1001Entity.setSeinenYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setSeibetsuCode(RString.EMPTY);
        dbwt1001Entity.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        dbwt1001Entity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        return dbwt1001Entity;
    }

}
