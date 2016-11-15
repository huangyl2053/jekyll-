/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.henreihoryuin.HenreiHoryuInResult;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120910.SogojigyohiKohiJukyushaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvFileHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin.HenreiHoryuInCsvFileMeisaEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaContorlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin.DbWT7411SeikyuuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.henreihoryuin.DbWT7411SeikyuuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
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
        履歴番号 = parameter.get履歴番号();
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
                履歴番号 = 履歴番号 + 1;
                請求一時tbWriter.insert(new HenreiHoryuInResult().請求一時TBLに登録(履歴番号, headEntity));
            } else if (帳票レコード種別_明細.equals(data.get(INDEX_3))) {
                meisaEntity = ListToObjectMappingHelper.toObject(HenreiHoryuInCsvFileMeisaEntity.class, data);
                連番 = 連番 + 1;
                請求明細一時tbWriter.insert(new HenreiHoryuInResult().請求明細一時TBLに登録(連番, 履歴番号, meisaEntity));
                被保険者一時tbWriter.insert(new HenreiHoryuInResult().被保険者一時TBLに登録(連番, meisaEntity));
                明細件数合計++;
            }
        }
    }

    @Override
    protected void afterExecute() {
        int 明細データ登録件数合算 = parameter.get明細データ登録件数合算() + 明細件数合計;
        if (parameter.isさいごファイルフラグ() && 0 == 明細データ登録件数合算) {
            処理結果リスト一時tbWriter.insert(new HenreiHoryuInResult().処理結果リスト一時に登録());
        }
        returnEntity.set明細データ登録件数(明細件数合計);
        returnEntity.setShoriYM(処理対象年月);
        returnEntity.set連番(連番);
        returnEntity.set履歴番号(履歴番号);
        flowEntity.setValue(returnEntity);
    }
}
