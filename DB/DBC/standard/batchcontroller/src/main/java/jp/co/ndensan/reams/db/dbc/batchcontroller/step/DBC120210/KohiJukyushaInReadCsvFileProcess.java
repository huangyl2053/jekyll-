/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120210;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120910.SogojigyohiKohiJukyushaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaContorlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaCsvFileHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaCsvFileMeisaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaCsvFileToreraEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha.DbWT6411KohiJukyushabetsuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha.DbWT6412KohiJukyushabetsuShukeiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費公費受給者別一覧表情報取込のファイル読込を実行する。
 *
 * @reamsid_L DBC-2800-010 duanzhanli
 */
public class KohiJukyushaInReadCsvFileProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private SogojigyohiKohiJukyushaReadCsvFileProcessParameter parameter;
    private SogojigyohiKohiJukyushaCsvFileHeadEntity headEntity;
    private SogojigyohiKohiJukyushaCsvFileMeisaEntity meisaEntity;
    private SogojigyohiKohiJukyushaCsvFileToreraEntity toreraEntity;
    private SogojigyohiKohiJukyushaContorlCsvEntity contorlEntity;
    private FlexibleYearMonth 処理対象年月;
    private int 連番;
    private int 履歴番号;

    @BatchWriter
    IBatchTableWriter 公費受給者別明細一時tbWriter;
    @BatchWriter
    IBatchTableWriter 公費受給者別集計一時tbWriter;
    @BatchWriter
    IBatchTableWriter 被保険者一時tbWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tbWriter;

    private static final RString 公費受給者別明細一時_TABLE_NAME = new RString("DbWT6411KohiJukyushabetsuMeisai");
    private static final RString 公費受給者別集計一時_TABLE_NAME = new RString("DbWT6412KohiJukyushabetsuShukei");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private final RString レコード種別_コントロール = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private final RString 帳票レコード種別_ヘッダー = new RString("\"H1\"");
    private final RString 帳票レコード種別_明細 = new RString("\"D1\"");
    private final RString 帳票レコード種別_トレーラ = new RString("\"T1\"");
    private static final RString カンマ = new RString(",");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private int 明細件数合計 = 0;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<SogojigyohiKohiJukyushaFlowEntity> flowEntity;
    private SogojigyohiKohiJukyushaFlowEntity returnEntity;

    @Override
    protected void initialize() {
        連番 = parameter.get連番();
        履歴番号 = parameter.get履歴番号();
        returnEntity = new SogojigyohiKohiJukyushaFlowEntity();
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void createWriter() {
        公費受給者別明細一時tbWriter
                = new BatchEntityCreatedTempTableWriter(公費受給者別明細一時_TABLE_NAME, DbWT6411KohiJukyushabetsuMeisaiTempEntity.class);
        公費受給者別集計一時tbWriter
                = new BatchEntityCreatedTempTableWriter(公費受給者別集計一時_TABLE_NAME,
                        DbWT6412KohiJukyushabetsuShukeiTempEntity.class);
        被保険者一時tbWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tbWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.getファイルパース());
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(カンマ.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別_コントロール.equals(data.get(INDEX_0))) {
                contorlEntity = ListToObjectMappingHelper.toObject(SogojigyohiKohiJukyushaContorlCsvEntity.class, data);
                処理対象年月 = contorlEntity.get処理対象年月();
            }
            if (帳票レコード種別_ヘッダー.equals(data.get(INDEX_3))) {
                headEntity = ListToObjectMappingHelper.toObject(SogojigyohiKohiJukyushaCsvFileHeadEntity.class, data);
            } else if (帳票レコード種別_明細.equals(data.get(INDEX_3))) {
                meisaEntity = ListToObjectMappingHelper.toObject(SogojigyohiKohiJukyushaCsvFileMeisaEntity.class, data);
                公費受給者別明細一時TBLに登録();
                被保険者一時TBLに登録();
                明細件数合計++;
            } else if (帳票レコード種別_トレーラ.equals(data.get(INDEX_3))) {
                toreraEntity = ListToObjectMappingHelper.toObject(SogojigyohiKohiJukyushaCsvFileToreraEntity.class, data);
                公費受給者別集計一時TBLに登録();
            }
        }
    }

    @Override
    protected void afterExecute() {
        int 明細データ登録件数合算 = parameter.get明細データ登録件数合算() + 明細件数合計;
        if (parameter.isさいごファイルフラグ() && 0 == 明細データ登録件数合算) {
            処理結果リスト一時に登録();
        }
        returnEntity.set明細データ登録件数(明細件数合計);
        returnEntity.setShoriYM(処理対象年月);
        returnEntity.set連番(連番);
        returnEntity.set履歴番号(履歴番号);
        flowEntity.setValue(returnEntity);
    }

    private void 公費受給者別明細一時TBLに登録() {
        DbWT6411KohiJukyushabetsuMeisaiTempEntity 明細一時TBL = new DbWT6411KohiJukyushabetsuMeisaiTempEntity();
        連番 = 連番 + 1;
        明細一時TBL.setMRenban(連番);
        明細一時TBL.setMRirekiNo(履歴番号);
        明細一時TBL.setKohiJukyushaNo(set字符(meisaEntity.get公費受給者番号()));
        明細一時TBL.setServiceTeikyoYM(set年月(meisaEntity.getサービス提供年月()));
        明細一時TBL.setJigyoshoNo(set字符(meisaEntity.get事業所番号()));
        明細一時TBL.setJigyoshoName(set字符(meisaEntity.get事業所名()));
        明細一時TBL.setServiceCode(set字符(meisaEntity.getサービスコード()));
        明細一時TBL.setServiceShuruiMei(set字符(meisaEntity.getサービス種類名()));
        明細一時TBL.setServiceKomokuMei(set字符(meisaEntity.getサービス項目名()));
        明細一時TBL.setNissuKaisu(meisaEntity.get日数回数());
        明細一時TBL.setKohiTaishoTanisu(meisaEntity.get公費対象単位数());
        明細一時TBL.setKohiFutanKingaku(meisaEntity.get公費負担金額());
        明細一時TBL.setKohibunHonninFutangaku(meisaEntity.get公費分本人負担額());
        公費受給者別明細一時tbWriter.insert(明細一時TBL);
    }

    private void 公費受給者別集計一時TBLに登録() {
        DbWT6412KohiJukyushabetsuShukeiTempEntity 集計Entity = new DbWT6412KohiJukyushabetsuShukeiTempEntity();
        集計Entity.setSRirekiNo(履歴番号);
        集計Entity.setKohiFutanshaNo(set字符(headEntity.get公費負担者番号()));
        集計Entity.setKohiFutanshaName(set字符(headEntity.get公費負担者名()));
        集計Entity.setShinsaYM(set年月(headEntity.get審査年月()));
        集計Entity.setKokuhorenName(set字符(headEntity.get国保連合会名()));
        集計Entity.setKohiTaishoTanisuShukei(toreraEntity.get公費対象単位数());
        集計Entity.setKohiFutanKingakuShukei(toreraEntity.get公費負担金額());
        集計Entity.setKohibunHonninFutangakuShukei(toreraEntity.get公費分本人負担額());
        公費受給者別集計一時tbWriter.insert(集計Entity);
        履歴番号++;
    }

    private void 被保険者一時TBLに登録() {
        DbWT0001HihokenshaIchijiEntity 被保険者一時entity = new DbWT0001HihokenshaIchijiEntity();
        被保険者一時entity.setMeisaiRenban(連番);
        被保険者一時entity.setShoHokenshaNo(new ShoKisaiHokenshaNo(set字符(meisaEntity.get証記載保険者番号())));
        被保険者一時entity.setOrgHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setServiceTeikyoYmd(get末日(meisaEntity.getサービス提供年月()));
        被保険者一時entity.setOrgHihokenshaKanaShimei(RString.EMPTY);
        被保険者一時entity.setOrgHihokenshaShimei(RString.EMPTY);
        被保険者一時entity.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setHenkanHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setKannaiKangaiKubun(RString.EMPTY);
        被保険者一時entity.setYubinNo(RString.EMPTY);
        被保険者一時entity.setChoikiCode(RString.EMPTY);
        被保険者一時entity.setGyoseikuCode(RString.EMPTY);
        被保険者一時entity.setGyoseikuMei(RString.EMPTY);
        被保険者一時entity.setJusho(RString.EMPTY);
        被保険者一時entity.setBanchi(RString.EMPTY);
        被保険者一時entity.setKatagaki(RString.EMPTY);
        被保険者一時entity.setKanaMeisho(RString.EMPTY);
        被保険者一時entity.setMeisho(RString.EMPTY);
        被保険者一時entity.setShimei50onKana(RString.EMPTY);
        被保険者一時entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        被保険者一時entity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        被保険者一時entity.setShikakuShutokuJiyuCode(RString.EMPTY);
        被保険者一時entity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        被保険者一時entity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        被保険者一時entity.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        被保険者一時tbWriter.insert(被保険者一時entity);
    }

    private void 処理結果リスト一時に登録() {
        DbWT0002KokuhorenTorikomiErrorEntity 処理結果リスト一時entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        処理結果リスト一時entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        処理結果リスト一時entity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        処理結果リスト一時entity.setHihokenshaNo(HihokenshaNo.EMPTY);
        処理結果リスト一時entity.setKey1(RString.EMPTY);
        処理結果リスト一時entity.setKey2(RString.EMPTY);
        処理結果リスト一時entity.setKey3(RString.EMPTY);
        処理結果リスト一時entity.setKey4(RString.EMPTY);
        処理結果リスト一時entity.setKey5(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果リスト一時entity.setHihokenshaShimei(RString.EMPTY);
        処理結果リスト一時entity.setBiko(RString.EMPTY);
        処理結果リスト一時tbWriter.insert(処理結果リスト一時entity);
    }

    private FlexibleDate get末日(FlexibleYearMonth yearMonth) {
        if (yearMonth == null || yearMonth.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        int lastDay = yearMonth.getLastDay();
        return new FlexibleDate(yearMonth.toDateString().concat(new RString(lastDay)));
    }

    private RString set字符(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        } else {
            return str;
        }
    }

    private FlexibleYearMonth set年月(FlexibleYearMonth yearMonth) {
        if (null == yearMonth || yearMonth.isEmpty()) {
            return FlexibleYearMonth.EMPTY;
        } else {
            return yearMonth;
        }
    }
}
