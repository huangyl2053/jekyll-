/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120910.SogojigyohiKohiJukyushaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvFileHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvFileMeisaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaContorlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin.DbWT7411SeikyuuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin.DbWT7411SeikyuuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求明細・給付管理票返戻（保留）一覧表取込のファイル読込を実行する。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
public class HenreiHoryuInReadCsvFileProcess extends BatchProcessBase<List<RString>> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;
    private SogojigyohiKohiJukyushaReadCsvFileProcessParameter parameter;
    private HenreiHoryuInCsvFileHeadEntity headEntity;
    private HenreiHoryuInCsvFileMeisaEntity meisaEntity;
    private SogojigyohiKohiJukyushaContorlCsvEntity contorlEntity;
    private FlexibleYearMonth 処理対象年月;
    private int 連番;
    private int 履歴番号;
    @BatchWriter
    IBatchTableWriter 請求一時tbWriter;
    @BatchWriter
    IBatchTableWriter 請求明細一時tbWriter;
    @BatchWriter
    IBatchTableWriter 被保険者一時tbWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tbWriter;

    private static final RString 請求一時_TABLE_NAME = new RString("DbWT7411Seikyuu");
    private static final RString 請求明細一時_TABLE_NAME = new RString("DbWT7411SeikyuuMeisai");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private final RString レコード種別_コントロール = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private final RString 帳票レコード種別_ヘッダー = new RString("H1");
    private final RString 帳票レコード種別_明細 = new RString("D1");
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
        履歴番号 = parameter.get履歴番号() + 1;
        returnEntity = new SogojigyohiKohiJukyushaFlowEntity();
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected void createWriter() {
        請求一時tbWriter
                = new BatchEntityCreatedTempTableWriter(請求一時_TABLE_NAME, DbWT7411SeikyuuTempEntity.class);
        請求明細一時tbWriter
                = new BatchEntityCreatedTempTableWriter(請求明細一時_TABLE_NAME,
                        DbWT7411SeikyuuMeisaiTempEntity.class);
        被保険者一時tbWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tbWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.getファイルパース())
                .setDelimiter(カンマ).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void process(List<RString> data) {
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別_コントロール.equals(data.get(INDEX_0))) {
                contorlEntity = ListToObjectMappingHelper.toObject(SogojigyohiKohiJukyushaContorlCsvEntity.class, data);
                処理対象年月 = contorlEntity.get処理対象年月();
            }
            if (帳票レコード種別_ヘッダー.equals(data.get(INDEX_3))) {
                headEntity = ListToObjectMappingHelper.toObject(HenreiHoryuInCsvFileHeadEntity.class, data);
                請求一時TBLに登録();
            } else if (帳票レコード種別_明細.equals(data.get(INDEX_3))) {
                meisaEntity = ListToObjectMappingHelper.toObject(HenreiHoryuInCsvFileMeisaEntity.class, data);
                請求明細一時TBLに登録();
                被保険者一時TBLに登録();
                明細件数合計++;
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

    private void 請求一時TBLに登録() {
        DbWT7411SeikyuuTempEntity 請求一時TBL = new DbWT7411SeikyuuTempEntity();
        履歴番号 = 履歴番号 + 1;
        請求一時TBL.setRirekiNo(履歴番号);
        請求一時TBL.setHokenshaNo(headEntity.get事業所保険者番号());
        請求一時TBL.setHokenshaName(headEntity.get事業所保険者名());
        請求一時TBL.setShinsaYM(set年月(headEntity.get審査年月()));
        請求一時TBL.setKokuhorenName(headEntity.get国保連合会名());
        請求一時tbWriter.insert(請求一時TBL);
    }

    private void 請求明細一時TBLに登録() {
        DbWT7411SeikyuuMeisaiTempEntity 請求明細一時Entity = new DbWT7411SeikyuuMeisaiTempEntity();
        連番 = 連番 + 1;
        請求明細一時Entity.setRenban(連番);
        請求明細一時Entity.setMeisaiRirekiNo(履歴番号);
        請求明細一時Entity.setJigyoshaNo(meisaEntity.get保険者事業所番号());
        請求明細一時Entity.setJigyoshaName(meisaEntity.get保険者事業所名());
        請求明細一時Entity.setShubetsu(meisaEntity.get種別());
        請求明細一時Entity.setServiceTeikyoYM(meisaEntity.getサービス提供年月());
        請求明細一時Entity.setServiceShuruiCode(meisaEntity.getサービス種類コード());
        請求明細一時Entity.setServiceKoumokuCode(meisaEntity.getサービス項目コード等());
        請求明細一時Entity.setTanisu(meisaEntity.get単位数());
        請求明細一時Entity.setJiyu(meisaEntity.get事由());
        請求明細一時Entity.setNaiyo(meisaEntity.get内容());
        請求明細一時Entity.setBiko(meisaEntity.get備考());
        請求明細一時tbWriter.insert(請求明細一時Entity);
    }

    private void 被保険者一時TBLに登録() {
        DbWT0001HihokenshaIchijiEntity 被保険者一時entity = new DbWT0001HihokenshaIchijiEntity();
        被保険者一時entity.setMeisaiRenban(連番);
        被保険者一時entity.setShoHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        被保険者一時entity.setOrgHihokenshaNo(new HihokenshaNo(set字符(meisaEntity.get被保険者番号())));
        被保険者一時entity.setServiceTeikyoYmd(get末日(meisaEntity.getサービス提供年月()));
        被保険者一時entity.setOrgHihokenshaKanaShimei(meisaEntity.get被保険者カナ氏名());
        被保険者一時entity.setOrgHihokenshaShimei(RString.EMPTY);
        被保険者一時entity.setOldShichosonCode(LasdecCode.EMPTY);
        被保険者一時entity.setHenkanHihokenshaNo(HihokenshaNo.EMPTY);
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
        if (str.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return str;
        }
    }

    private FlexibleYearMonth set年月(RString yearMonth) {
        if (RString.isNullOrEmpty(yearMonth)) {
            return FlexibleYearMonth.EMPTY;
        }
        return new FlexibleYearMonth(yearMonth);
    }
}
