/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassankyufujissekiin.KogakuGassanKyufuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.DbWT38P1KogakuGassanKyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算給付実績取込のSVファイル取込処理のクラスです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class KogakuGassanKyufuJissekiInGetFileProcess extends BatchProcessBase<List<RString>> {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;
    private static final RString 高額合算給付実績一時_TABLE_NAME = new RString("DbWT38P1KogakuGassanKyufuJisseki");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 区切り文字 = new RString(",");
    private final RString コントロールレコード種別 = new RString("1");
    private static final RString 明細レコード種別 = new RString("2");
    private final RString エンドレコード種別 = new RString("3");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private int 集計件数;
    private int レコード件数合計;
    private int 明細番号;
    private int 明細件数;
    private KogakuGassanKyufuCsvEntity csvEntity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private KokuhorenkyotsuCsvFileReadProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算給付実績一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tbWriter;

    @Override
    protected void initialize() {
        returnEntity = new FlowEntity();
        集計件数 = parameter.get集計件数合算();
        明細件数 = parameter.get明細件数合算();
        レコード件数合計 = parameter.getレコード件数合算();
        flowEntity = new OutputParameter<>();
    }

    @Override
    protected void createWriter() {

        高額合算給付実績一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算給付実績一時_TABLE_NAME, DbWT38P1KogakuGassanKyufuJissekiTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaEntity.class);
        処理結果リスト一時tbWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.get保存先パース())
                .setDelimiter(区切り文字).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void process(List<RString> data) {
        csvEntity = null;
        if (エンドレコード種別.equals(data.get(INT_0))) {
            return;
        }
        if (コントロールレコード種別.equals(data.get(INT_0))) {
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            returnEntity.setShoriYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
            レコード件数合計 = レコード件数合計 + Integer.parseInt(controlCsvEntity.getCodeNum().toString());
            returnEntity.setCodeNum(レコード件数合計);
        } else if (明細レコード種別.equals(data.get(INT_0))) {
            csvEntity = new KogakuGassanKyufuCsvEntity();
            csvEntity = ListToObjectMappingHelper.toObject(KogakuGassanKyufuCsvEntity.class, data);
            集計件数 = 集計件数 + INT_1;
            明細件数 = 明細件数 + INT_1;
            明細番号 = 明細番号 + INT_1;
            set高額合算給付実績一時TBL(csvEntity);
            set被保険者一時TBL(csvEntity);
        }

    }

    @Override
    protected void afterExecute() {
        if (集計件数 == INT_0 && parameter.isLast()) {
            処理結果リスト一時に登録();
        }
        returnEntity.set集計データ登録件数(集計件数);
        returnEntity.set明細データ登録件数(明細件数);
        flowEntity.setValue(returnEntity);
    }

    private void set高額合算給付実績一時TBL(KogakuGassanKyufuCsvEntity csvEntity) {
        DbWT38P1KogakuGassanKyufuJissekiTempEntity dbWT38P1TempEntity = new DbWT38P1KogakuGassanKyufuJissekiTempEntity();
        if (csvEntity != null) {

            dbWT38P1TempEntity.setRenban(集計件数);

            if (csvEntity.get交換情報識別番号() != null && !csvEntity.get交換情報識別番号().isEmpty()) {
                dbWT38P1TempEntity.setKokanJohoShikibetsuNo(new KokanShikibetsuNo(csvEntity.get交換情報識別番号()));
            }

            RString 被保険者番号 = csvEntity.get被保険者番号();
            if (被保険者番号 != null && !被保険者番号.isEmpty()) {
                dbWT38P1TempEntity.setHihokenshaNoIn(new HihokenshaNo(被保険者番号));
            }
            dbWT38P1TempEntity.setShikyuShinseiSeiriNo(csvEntity.get支給申請書整理番号());
            dbWT38P1TempEntity.setSeiriNo(RString.EMPTY);
            dbWT38P1TempEntity.setJikoFutanSeiriNo(csvEntity.get自己負担額証明書整理番号());
            dbWT38P1TempEntity.setHokenSeidoCode(csvEntity.get保険制度コード());
            dbWT38P1TempEntity.setKyufuJissekiSakuseiKubunCode(csvEntity.get給付実績作成区分コード());
            dbWT38P1TempEntity.setShoKisaiHokenshaNo(new HokenshaNo(csvEntity.get保険者番号()));
            dbWT38P1TempEntity.setKokuho_HihokenshaShoKigo(csvEntity.get被保険者証記号());
            if (csvEntity.get申請年月日() != null) {
                dbWT38P1TempEntity.setShinseiYMD(new FlexibleDate(csvEntity.get申請年月日()));
            }
            if (csvEntity.get決定年月日() != null) {
                dbWT38P1TempEntity.setKetteiYMD(new FlexibleDate(csvEntity.get決定年月日()));
            }
            if (csvEntity.get自己負担総額() != null) {
                dbWT38P1TempEntity.setJikoFutanSogaku(getDecimal(csvEntity.get自己負担総額()));
            }
            if (csvEntity.get支給額() != null) {
                dbWT38P1TempEntity.setShikyuGaku(getDecimal(csvEntity.get支給額()));
            }
            if (csvEntity.get処理年月() != null) {
                dbWT38P1TempEntity.setShoriYM(new FlexibleYearMonth(csvEntity.get処理年月()));
            }
            dbWT38P1TempEntity.setUketoriYM(FlexibleYearMonth.EMPTY);
            dbWT38P1TempEntity.setSofuYM(FlexibleYearMonth.EMPTY);
            dbWT38P1TempEntity.setDataKubun(RString.EMPTY);
        }
        高額合算給付実績一時tableWriter.insert(dbWT38P1TempEntity);

    }

    private void set被保険者一時TBL(KogakuGassanKyufuCsvEntity csvEntity) {
        DbWT0001HihokenshaEntity dbWT0001TempEntity = new DbWT0001HihokenshaEntity();
        dbWT0001TempEntity.setMeisaiRenban((new Decimal(集計件数)));
        RString 被保険者番号 = csvEntity.get被保険者番号();
        RString 保険者番号 = csvEntity.get保険者番号();
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            dbWT0001TempEntity.setShoHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            dbWT0001TempEntity.setOrgHihokenshaNo(new HihokenshaNo(被保険者番号));
        }
        dbWT0001TempEntity.setServiceTeikyoYmd(FlexibleDate.getNowDate());
        dbWT0001TempEntity.setOrgHihokenshaKanaShimei(RString.EMPTY);
        dbWT0001TempEntity.setOrgHihokenshaShimei(RString.EMPTY);
        dbWT0001TempEntity.setOldShichosonCode(LasdecCode.EMPTY);
        dbWT0001TempEntity.setHenkanHihokenshaNo(HihokenshaNo.EMPTY);
        dbWT0001TempEntity.setHihokenshaNo(new HihokenshaNo(被保険者番号));
        dbWT0001TempEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        dbWT0001TempEntity.setKannaiKangaiKubun(RString.EMPTY);
        dbWT0001TempEntity.setYubinNo(RString.EMPTY);
        dbWT0001TempEntity.setChoikiCode(RString.EMPTY);
        dbWT0001TempEntity.setGyoseikuCode(RString.EMPTY);
        dbWT0001TempEntity.setGyoseikuMei(RString.EMPTY);
        dbWT0001TempEntity.setJusho(RString.EMPTY);
        dbWT0001TempEntity.setBanchi(RString.EMPTY);
        dbWT0001TempEntity.setKatagaki(RString.EMPTY);
        dbWT0001TempEntity.setKanaMeisho(RString.EMPTY);
        dbWT0001TempEntity.setMeisho(RString.EMPTY);
        dbWT0001TempEntity.setShimei50onKana(RString.EMPTY);
        dbWT0001TempEntity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        dbWT0001TempEntity.setShikakuShutokuJiyuCode(RString.EMPTY);
        dbWT0001TempEntity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        dbWT0001TempEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        dbWT0001TempEntity.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        被保険者一時tableWriter.insert(dbWT0001TempEntity);
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

    private Decimal getDecimal(RString decimal) {
        if (RString.isNullOrEmpty(decimal)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }

}
