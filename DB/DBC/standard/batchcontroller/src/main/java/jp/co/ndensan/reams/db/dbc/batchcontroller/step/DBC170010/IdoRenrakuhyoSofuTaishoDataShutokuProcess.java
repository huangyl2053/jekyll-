/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceCode_IdoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceCode_SofuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc170010.ServicecodeIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc170010.DbWT5H11SogoJigyoServiceCodeTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010.ServicecodeIdoRenrakuhyoOutEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業分サービスコード異動連絡票作成バッチの送付対象データ取得Processです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
public class IdoRenrakuhyoSofuTaishoDataShutokuProcess extends BatchProcessBase<ServicecodeIdoRenrakuhyoOutEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170010."
            + "IServicecodeIdoRenrakuhyoOutMapper.get送付対象データ");

    private static final RString 総合事業サービスコード一時 = new RString("DbWT5H11SogoJigyoServiceCode");
    private static final RString 処理結果リスト一時 = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString データがない = new RString("0");
    private static final RString データがある = new RString("1");
    private static final RString 開始日 = new RString("01");
    private static final int サービスコード1件目 = 1;
    /**
     * 送付対象データ取得フラグです。
     */
    public static final RString PARAMETER_OUT_FLOWFLAG;

    static {
        PARAMETER_OUT_FLOWFLAG = new RString("dataFlag");
    }

    private int renban;
    private boolean 取得データフラグ = true;
    private boolean 未送付データありflag;
    private ServicecodeIdoRenrakuhyoOutProcessParameter processParameter;
    private OutputParameter<RString> dataFlag;
    private DbWT5H11SogoJigyoServiceCodeTempEntity tmpEntity;

    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT5H11TableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT1002TableWriter;

    @Override
    protected void initialize() {
        dataFlag = new OutputParameter<>();
        renban = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbWT5H11TableWriter = new BatchEntityCreatedTempTableWriter(総合事業サービスコード一時,
                DbWT5H11SogoJigyoServiceCodeTempEntity.class);
        dbWT1002TableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(ServicecodeIdoRenrakuhyoOutEntity entity) {
        取得データフラグ = false;
        get総合事業サービスコード一時(entity);
        dbWT5H11TableWriter.insert(tmpEntity);
    }

    @Override
    protected void afterExecute() {
        if (取得データフラグ) {
            dbWT1002TableWriter.insert(get処理結果リスト一時Entity());
            dataFlag.setValue(データがない);
        } else {
            dataFlag.setValue(データがある);
        }
    }

    private void get総合事業サービスコード一時(ServicecodeIdoRenrakuhyoOutEntity entity) {
        renban = renban + 1;
        tmpEntity = new DbWT5H11SogoJigyoServiceCodeTempEntity();
        tmpEntity.setRenban(renban);
        tmpEntity.setServiceShuruiCode(entity.getServiceShuruiCode());
        tmpEntity.setServiceKomokuCode(entity.getServiceKomokuCode());
        tmpEntity.setTekiyoKaishiYM(entity.getTekiyoKaishiYM());
        tmpEntity.setRirekiNo(entity.getRirekiNo());
        tmpEntity.setServiceMeisho(entity.getServiceMeisho());
        tmpEntity.setTaniSu(entity.getTaniSu());
        tmpEntity.setGendoGakuTaishogaiFlag(entity.getGendoGakuTaishogaiFlag());
        tmpEntity.setTaniSuShikibetsuCode(entity.getTaniSuShikibetsuCode());
        tmpEntity.setGaibuServiceRiyoKubun(entity.getGaibuServiceRiyoKubun());
        tmpEntity.setTokubetsuChiikiKasanFlag(entity.getTokubetsuChiikiKasanFlag());
        tmpEntity.setTeiRitsu_TeiGakuKubun(entity.getTeiRitsu_TeiGakuKubun());
        tmpEntity.setRiyoshaFutanGaku(entity.getRiyoshaFutanGaku());
        tmpEntity.setKyufuRitsu(entity.getKyufuRitsu());
        tmpEntity.setNijiYoboTaishosha_JissiKubun(entity.getNijiYoboTaishosha_JissiKubun());
        tmpEntity.setYoShien1_JisshiKubun(entity.getYoShien1_JisshiKubun());
        tmpEntity.setYoShien2_JisshiKubun(entity.getYoShien2_JisshiKubun());
        tmpEntity.setTaishoJigyosha_JisshiKubun(entity.getTaishoJigyosha_JisshiKubun());
        tmpEntity.setSanteiTaniKubun(entity.getSanteiTaniKubun());
        tmpEntity.setSeigenNissuKaisu(entity.getSeigenNissuKaisu());
        tmpEntity.setSanteiKaisuSeigenKikanKubun(entity.getSanteiKaisuSeigenKikanKubun());
        tmpEntity.setSofuKubun(entity.getSofuKubun());
        tmpEntity.setSofuYM(entity.getSofuYM());

        RString 異動区分コード = RString.EMPTY;
        FlexibleDate 異動年月日 = FlexibleDate.EMPTY;
        FlexibleDate 新規変更異動年月日 = FlexibleDate.EMPTY;
        FlexibleDate 終了異動年月日 = FlexibleDate.EMPTY;
        if (entity.getTekiyoShuryoYM() == null || entity.getTekiyoShuryoYM().isEmpty()) {
            if (サービスコード1件目 == entity.getサービスコード件数()) {
                異動区分コード = get異動区分コード(entity);
            }
            if (サービスコード1件目 < entity.getサービスコード件数()) {
                異動区分コード = ServiceCode_IdoKubun.修正.getコード();
            }
        } else {
            異動区分コード = 未送付データあり(entity);
            if (未送付データありflag) {
                return;
            }
        }
        if (ServiceCode_IdoKubun.新規.getコード().equals(異動区分コード)
                || ServiceCode_IdoKubun.修正.getコード().equals(異動区分コード)) {
            if (entity.getShinkiHenkoIdoYMD() != null && !entity.getShinkiHenkoIdoYMD().isEmpty()) {
                異動年月日 = entity.getShinkiHenkoIdoYMD().plusDay(1);
            } else {
                異動年月日 = new FlexibleDate(entity.getTekiyoKaishiYM().toDateString().concat(開始日));
            }
            新規変更異動年月日 = 異動年月日;
            終了異動年月日 = entity.getShuryoIdoYMD();
        }
        if (ServiceCode_IdoKubun.終了.getコード().equals(異動区分コード)) {
            if (entity.getShuryoIdoYMD() != null && !entity.getShuryoIdoYMD().isEmpty()) {
                異動年月日 = entity.getShuryoIdoYMD().plusDay(1);
            } else {
                異動年月日 = new FlexibleDate(entity.getTekiyoShuryoYM().toDateString().concat(開始日));
            }
            新規変更異動年月日 = entity.getShinkiHenkoIdoYMD();
            終了異動年月日 = 異動年月日;
        }
        tmpEntity.setTekiyoShuryoYM(entity.getTekiyoShuryoYM());
        tmpEntity.setShinkiHenkoIdoYMD(新規変更異動年月日);
        tmpEntity.setShuryoIdoYMD(終了異動年月日);
        tmpEntity.setIdoYMD(異動年月日);
        tmpEntity.setIdoKubunCode(異動区分コード);
        tmpEntity.setDummyDataFlag(false);
    }

    private RString 未送付データあり(ServicecodeIdoRenrakuhyoOutEntity entity) {
        未送付データありflag = false;
        RString 異動区分コード = RString.EMPTY;
        if (ServiceCode_SofuKubun.送付対象.getコード().equals(entity.getSofuKubun())) {
            異動区分コード = ServiceCode_IdoKubun.終了.getコード();
            if (entity.getSofuYM() == null || entity.getSofuYM().isEmpty()) {
                未送付データありflag = true;
                tmpEntity.setTekiyoShuryoYM(FlexibleYearMonth.EMPTY);
                tmpEntity.setShinkiHenkoIdoYMD(
                        new FlexibleDate(entity.getTekiyoKaishiYM().toDateString().concat(開始日)));
                tmpEntity.setShuryoIdoYMD(entity.getShuryoIdoYMD());
                tmpEntity.setIdoYMD(
                        new FlexibleDate(entity.getTekiyoKaishiYM().toDateString().concat(開始日)));
                tmpEntity.setIdoKubunCode(ServiceCode_IdoKubun.新規.getコード());
                tmpEntity.setDummyDataFlag(true);
                return 異動区分コード;
            }
        }
        if (ServiceCode_SofuKubun.送付済み.getコード().equals(entity.getSofuKubun())) {
            if (0 == entity.getSofuYM().compareTo(
                    new FlexibleYearMonth(processParameter.get処理年月().toDateString()))) {
                異動区分コード = ServiceCode_IdoKubun.終了.getコード();
            } else {
                異動区分コード = ServiceCode_IdoKubun.修正.getコード();
            }
        }
        return 異動区分コード;
    }

    private RString get異動区分コード(ServicecodeIdoRenrakuhyoOutEntity entity) {
        RString 異動区分コード = RString.EMPTY;
        if (ServiceCode_SofuKubun.送付対象.getコード().equals(entity.getSofuKubun())) {
            異動区分コード = ServiceCode_IdoKubun.新規.getコード();
        }
        if (ServiceCode_SofuKubun.送付済み.getコード().equals(entity.getSofuKubun())) {
            if (entity.getSofuYM().compareTo(
                    new FlexibleYearMonth(processParameter.get処理年月().toDateString())) == 0) {
                異動区分コード = ServiceCode_IdoKubun.新規.getコード();
            } else {
                異動区分コード = ServiceCode_IdoKubun.修正.getコード();
            }
        }
        return 異動区分コード;
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト一時Entity() {
        DbWT1002KokuhorenSakuseiErrorTempEntity 一時Enttiy = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        一時Enttiy.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        一時Enttiy.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        一時Enttiy.setHihokenshaNo(HihokenshaNo.EMPTY);
        一時Enttiy.setKey1(RString.EMPTY);
        一時Enttiy.setKey2(RString.EMPTY);
        一時Enttiy.setKey3(RString.EMPTY);
        一時Enttiy.setKey4(RString.EMPTY);
        一時Enttiy.setKey5(RString.EMPTY);
        一時Enttiy.setHihokenshaKanaShimei(RString.EMPTY);
        一時Enttiy.setHihokenshaShimei(RString.EMPTY);
        一時Enttiy.setBiko(RString.EMPTY);
        return 一時Enttiy;
    }
}
