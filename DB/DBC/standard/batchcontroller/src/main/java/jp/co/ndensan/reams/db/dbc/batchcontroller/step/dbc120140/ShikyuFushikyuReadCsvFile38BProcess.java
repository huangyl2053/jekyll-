/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120140;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoin.KyufukanrihyoInCsvReadReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120140.ShikyuFushikyuKetteiTsuchishoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenkyotsu.KokuhorenkyoutsuControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 支給不支給決定通知書情報ファイル(38B)・ファイル読込を実行する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuReadCsvFile38BProcess extends BatchProcessBase<RString> {

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
    private static final Integer INDEX_2 = 2;
    private static final RString NUM = new RString("99");
    private static final RString 交換情報識別番号 = new RString("38B1");

    private KyufukanrihyoInCsvReadReturnEntity returnEntity;
    private KokuhorenkyoutsuControlCsvEntity controlCsvEntity;
    private ShikyuFushikyuKetteiTsuchishoCsvEntity meisaiEntity;
    private int 連番;
    private FlexibleYearMonth 処理対象年月;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給不支給決定一時tableWriter;
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 高額合算支給不支給決定一時_TABLE_NAME
            = new RString("DbWT38B1KogakuGassanShikyuFushikyuKettei");

    @Override
    protected void initialize() {
        controlCsvEntity = new KokuhorenkyoutsuControlCsvEntity();
        meisaiEntity = new ShikyuFushikyuKetteiTsuchishoCsvEntity();
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
        高額合算支給不支給決定一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給不支給決定一時_TABLE_NAME,
                        DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity.class);
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
            } else if (交換情報識別番号.equals(data.get(INDEX_2))) {
                meisaiEntity = ListToObjectMappingHelper.
                        toObject(ShikyuFushikyuKetteiTsuchishoCsvEntity.class, data);
                連番 = 連番 + 1;
                データを一時TBLに登録する(meisaiEntity, 連番);
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (parameter.isLast() && 連番 == INDEX_0) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(NUM);
            処理結果リスト一時tableWriter.insert(errorTempentity.toEntity());
        }
        returnEntity.set明細件数合算(連番);
        returnEntity.setレコード件数合算(parameter.getレコード件数合算()
                + Integer.valueOf(controlCsvEntity.getCodeNum().toString()));
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void データを一時TBLに登録する(ShikyuFushikyuKetteiTsuchishoCsvEntity csvEntity, int 連番) {
        DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity tempEntity
                = new DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity();
        tempEntity.set連番(連番);
        if (null != csvEntity.get被保険者証番号()) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(csvEntity.get被保険者証番号());
            tempEntity.set被保険者番号(被保険者番号);
        }
        tempEntity.set対象年度(RString.EMPTY);
        if (null != csvEntity.get保険者番号()) {
            HokenshaNo 保険者番号 = new HokenshaNo(csvEntity.get保険者番号());
            tempEntity.set保険者番号(保険者番号);
        }
        tempEntity.set支給申請書整理番号(csvEntity.get支給申請書整理番号());
        tempEntity.set履歴番号(1);
        tempEntity.set自己負担額証明書整理番号(csvEntity.get自己負担額証明書整理番号());
        tempEntity.set保険制度コード(csvEntity.get保険制度コード());
        tempEntity.set被保険者証記号(csvEntity.get被保険者証記号());
        tempEntity.set対象計算期間開始年月日(toパターン34(csvEntity.get計算対象期間開始年月日()));
        tempEntity.set対象計算期間終了年月日(toパターン34(csvEntity.get計算対象期間終了年月日()));
        tempEntity.set申請年月日(toパターン34(csvEntity.get申請年月日()));
        tempEntity.set決定年月日(toパターン34(csvEntity.get決定年月日()));
        tempEntity.set自己負担総額(csvEntity.get自己負担総額());
        tempEntity.set支給区分コード(csvEntity.get支給区分コード());
        tempEntity.set支給額(csvEntity.get支給額());
        tempEntity.set給付の種類(csvEntity.get給付の種類());
        tempEntity.set不支給理由(csvEntity.get不支給の理由());
        tempEntity.set備考(csvEntity.get備考());
        tempEntity.set支払方法区分(csvEntity.get支払方法区分コード());
        tempEntity.set支払場所(csvEntity.get自己負担額証明書整理番号());
        tempEntity.set支払期間開始年月日(toパターン34(csvEntity.get窓口払情報_支払期間開始年月日()));
        tempEntity.set支払期間終了年月日(toパターン34(csvEntity.get窓口払情報_支払期間終了年月日()));
        tempEntity.set支払期間開始時間(csvEntity.get窓口払情報_支払期間開始年月日_開始時間());
        tempEntity.set支払期間終了時間(csvEntity.get窓口払情報_支払期間終了年月日_終了時間());
        tempEntity.set金融機関コード(RString.EMPTY);
        tempEntity.set金融機関名(csvEntity.get口座払情報_金融機関名());
        tempEntity.set金融機関支店コード(RString.EMPTY);
        tempEntity.set金融機関支店名(csvEntity.get口座払情報_金融機関支店名());
        tempEntity.set口座種目(RString.EMPTY);
        tempEntity.set口座種目名(csvEntity.get口座払情報_口座種目名());
        tempEntity.set口座番号(csvEntity.get口座払情報_口座番号());
        tempEntity.set口座名義人_カナ(csvEntity.get口座払情報_口座名義人_カナ());
        tempEntity.set口座ID(null);
        tempEntity.set帳票関連付け番号(csvEntity.get帳票関連付け番号());
        高額合算支給不支給決定一時tableWriter.insert(tempEntity.toEntity());

        DbWT0001HihokenshaTempEntity 被保険者一時 = new DbWT0001HihokenshaTempEntity();
        被保険者一時.set連番(連番);
        if (null != csvEntity.get保険者番号()) {
            ShoKisaiHokenshaNo 保険者番号 = new ShoKisaiHokenshaNo(csvEntity.get保険者番号());
            被保険者一時.set証記載保険者番号(保険者番号);
        }
        if (null != csvEntity.get被保険者証番号()) {
            HihokenshaNo 被保険者番号 = new HihokenshaNo(csvEntity.get被保険者証番号());
            被保険者一時.set被保険者番号(被保険者番号);
            被保険者一時.set登録被保険者番号(被保険者番号);
        }
        被保険者一時.setサービス提供年月末日(FlexibleDate.getNowDate());
        被保険者一時.set被保険者氏名(csvEntity.get被保険者氏名());
        被保険者一時tableWriter.insert(被保険者一時.toEntity());
    }

    private void set処理対象年月() {
        if (null == returnEntity.get処理対象年月()) {
            処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            returnEntity.set処理対象年月(処理対象年月);
        }
    }

    private RString toパターン34(RString 年月日) {
        if (RString.isNullOrEmpty(年月日)) {
            return RString.EMPTY;
        }
        return new RDate(年月日.toString()).seireki().separator(Separator.NONE)
                .fillType(FillType.ZERO).toDateString();
    }

}
