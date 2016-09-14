/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120140;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoin.KyufukanrihyoInCsvReadReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140.ShikyuFushikyuKetteishaIchiranCsvHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140.ShikyuFushikyuKetteishaIchiranCsvMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38G1KetteishaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38G1KetteishaIchiranTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給不支給決定通知書情報ファイル(38G)・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuReadCsvFile38GProcess extends BatchProcessBase<RString> {

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KokuhorenkyotsuCsvFileReadProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    private OutputParameter<KyufukanrihyoInCsvReadReturnEntity> flowEntity;

    private final RString 区切り文字 = new RString(",");

    private final RString レコード種別 = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_H1 = new RString("H1");

    private KyufukanrihyoInCsvReadReturnEntity returnEntity;
    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private ShikyuFushikyuKetteishaIchiranCsvHeadEntity headEntity;
    private ShikyuFushikyuKetteishaIchiranCsvMeisaiEntity meisaiEntity;
    private int 連番;
    private FlexibleYearMonth 処理対象年月;
    private RString 申請対象年度;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 決定者一覧一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 決定者一覧一時_TABLE_NAME
            = new RString("DbWT38G1KetteishaIchiran");

    @Override
    protected void initialize() {
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        headEntity = new ShikyuFushikyuKetteishaIchiranCsvHeadEntity();
        meisaiEntity = new ShikyuFushikyuKetteishaIchiranCsvMeisaiEntity();
        returnEntity = new KyufukanrihyoInCsvReadReturnEntity();
        連番 = parameter.get明細件数合算();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先パース());
    }

    @Override
    protected void createWriter() {
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaIchijiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
        決定者一覧一時tableWriter
                = new BatchEntityCreatedTempTableWriter(決定者一覧一時_TABLE_NAME,
                        DbWT38G1KetteishaIchiranEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.
                        toObject(KokuhorenkyoutsuControlCsvEntity.class, data);
                set処理対象年月();
            } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                headEntity = ListToObjectMappingHelper.
                        toObject(ShikyuFushikyuKetteishaIchiranCsvHeadEntity.class, data);
                申請対象年度 = new RDate(headEntity.get申請対象年度().toString()).getYear().toDateString();
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                meisaiEntity = ListToObjectMappingHelper.
                        toObject(ShikyuFushikyuKetteishaIchiranCsvMeisaiEntity.class, data);
                連番 = 連番 + 1;
                データを一時TBLに登録する(meisaiEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        returnEntity.set明細件数合算(連番);
        returnEntity.setレコード件数合算(parameter.getレコード件数合算()
                + Integer.valueOf(controlCsvEntity.getCodeNum().toString()));
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void データを一時TBLに登録する(ShikyuFushikyuKetteishaIchiranCsvMeisaiEntity csvEntity) {
        DbWT38G1KetteishaIchiranTempEntity 決定者 = new DbWT38G1KetteishaIchiranTempEntity();
        決定者.set申請対象年度(申請対象年度);
        決定者.setNo(csvEntity.getNo());
        決定者.set金融機関コード(csvEntity.get口座払情報_金融機関コード());
        決定者.set金融機関支店コード(csvEntity.get口座払情報_金融機関支店コード());
        決定者.set口座種目(csvEntity.get口座払情報_口座種目());
        if (null != csvEntity.get被保険者証番号()) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(csvEntity.get被保険者証番号());
            決定者.set被保険者番号(被保険者番号);
        }
        決定者一覧一時tableWriter.insert(決定者.toEntity());
    }

    private void set処理対象年月() {
        if (null == returnEntity.get処理対象年月()) {
            処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            returnEntity.set処理対象年月(処理対象年月);
        }
    }

}
