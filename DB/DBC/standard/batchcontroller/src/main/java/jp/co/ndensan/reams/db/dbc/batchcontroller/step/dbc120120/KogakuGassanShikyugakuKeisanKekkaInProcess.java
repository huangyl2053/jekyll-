/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120120;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInHeaderEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.TempDbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.TempDbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込のCSVファイル取込処理のクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class KogakuGassanShikyugakuKeisanKekkaInProcess extends BatchProcessBase<List<RString>> {

    /**
     * CSVファイル取込後の返したエンティティ
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private KokuhorenkyotsuCsvFileReadProcessParameter parameter;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }
    private OutputParameter<FlowEntity> flowEntity;
    FlowEntity returnEntity;
    private static final RString 高額合算支給額計算結果_TABLE_NAME = new RString("DbWT3861KogakuGassanShikyugakuKeisanKekka");
    private static final RString 高額合算支給額計算結果明細_TABLE_NAME = new RString("DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisai");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private final RString コントロールレコード種別 = new RString("1");
    private final RString エンドレコード種別 = new RString("3");
    private final RString ヘッダーレコード種別 = new RString("H1");
    private final RString 明細レコード種別 = new RString("D1");
    private final RString トレーラレコード種別 = new RString("T1");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final RString 区切り = new RString("-");
    private static final RString 按分率 = new RString("99999999/99999999");
    private static final RString 区切り文字 = new RString(",");
    private final RString 介護合算_データ区分 = new RString("1");
    private final RString 再送フラグ_再送不要 = new RString("0");
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private KogakuGassanShikyugakuKeisanKekkaInHeaderEntity headRecordEntity;
    private KogakuGassanShikyugakuKeisanKekkaInMeisaiEntity meisaiEntity;
    private KogakuGassanShikyugakuKeisanKekkaInShukeiEntity shukeiEntity;
    private int 集計件数;
    private int レコード件数合計;
    private int 明細番号;
    private int 明細件数;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給額計算結果一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給額計算結果明細一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

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
        高額合算支給額計算結果一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給額計算結果_TABLE_NAME, DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity.class);
        高額合算支給額計算結果明細一時tableWriter = new BatchEntityCreatedTempTableWriter(
                高額合算支給額計算結果明細_TABLE_NAME, DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisaiEntity.class);
        被保険者一時tableWriter = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, TempDbWT0001HihokenshaEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME, TempDbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(parameter.get保存先パース())
                .setDelimiter(区切り文字).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void process(List<RString> data) {

        if (エンドレコード種別.equals(data.get(INT_0))) {
            return;
        }
        if (コントロールレコード種別.equals(data.get(INT_0))) {
            controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
            controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            returnEntity.setShoriYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
            レコード件数合計 = レコード件数合計 + Integer.parseInt(controlCsvEntity.getCodeNum().toString());
            returnEntity.setCodeNum(レコード件数合計);
        } else if (ヘッダーレコード種別.equals(data.get(INT_3))) {
            headRecordEntity = new KogakuGassanShikyugakuKeisanKekkaInHeaderEntity();
            headRecordEntity = ListToObjectMappingHelper.toObject(KogakuGassanShikyugakuKeisanKekkaInHeaderEntity.class, data);
            集計件数 = 集計件数 + INT_1;
            明細番号 = INT_0;
            insert被保険者一時(headRecordEntity);
        } else if (明細レコード種別.equals(data.get(INT_3))) {
            meisaiEntity = new KogakuGassanShikyugakuKeisanKekkaInMeisaiEntity();
            meisaiEntity = ListToObjectMappingHelper.toObject(KogakuGassanShikyugakuKeisanKekkaInMeisaiEntity.class, data);
            明細件数 = 明細件数 + INT_1;
            明細番号 = 明細番号 + INT_1;
            insert高額合算支給額計算結果明細(headRecordEntity, meisaiEntity);
        } else if (トレーラレコード種別.equals(data.get(INT_3))) {
            shukeiEntity = new KogakuGassanShikyugakuKeisanKekkaInShukeiEntity();
            shukeiEntity = ListToObjectMappingHelper.toObject(KogakuGassanShikyugakuKeisanKekkaInShukeiEntity.class, data);
            insert高額合算支給額計算結果(headRecordEntity, shukeiEntity);
        }
    }

    @Override
    protected void afterExecute() {

        if (集計件数 == INT_0 && parameter.isLast()) {
            TempDbWT0002KokuhorenTorikomiErrorEntity errorEntity = new TempDbWT0002KokuhorenTorikomiErrorEntity();
            errorEntity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
            errorEntity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
            errorEntity.setHihokenshaNo(HihokenshaNo.EMPTY);
            errorEntity.setKey1(RString.EMPTY);
            errorEntity.setKey2(RString.EMPTY);
            errorEntity.setKey3(RString.EMPTY);
            errorEntity.setKey4(RString.EMPTY);
            errorEntity.setKey5(RString.EMPTY);
            errorEntity.setHihokenshaKanaShimei(RString.EMPTY);
            errorEntity.setHihokenshaShimei(RString.EMPTY);
            errorEntity.setBiko(RString.EMPTY);
            処理結果リスト一時tableWriter.insert(errorEntity);
        }
        returnEntity.set集計データ登録件数(集計件数);
        returnEntity.set明細データ登録件数(明細件数);
        flowEntity.setValue(returnEntity);
    }

    private void insert被保険者一時(KogakuGassanShikyugakuKeisanKekkaInHeaderEntity headRecordEntity) {

        TempDbWT0001HihokenshaEntity entity = new TempDbWT0001HihokenshaEntity();
        entity.setMeisaiRenban(new Decimal(集計件数));
        entity.setShoHokenshaNo(new ShoKisaiHokenshaNo(headRecordEntity.get保険者番号()));
        entity.setOrgHihokenshaNo(new HihokenshaNo(headRecordEntity.get被保険者証番号()));
        entity.setServiceTeikyoYmd(FlexibleDate.getNowDate());
        entity.setOrgHihokenshaKanaShimei(headRecordEntity.get支給対象氏名カナ());
        entity.setOrgHihokenshaShimei(headRecordEntity.get支給対象氏名漢字());
        entity.setHihokenshaNo(new HihokenshaNo(headRecordEntity.get被保険者証番号()));
        entity.setState(EntityDataState.Added);
        被保険者一時tableWriter.insert(entity);
    }

    private void insert高額合算支給額計算結果明細(KogakuGassanShikyugakuKeisanKekkaInHeaderEntity headRecordEntity,
            KogakuGassanShikyugakuKeisanKekkaInMeisaiEntity meisaiEntity) {

        DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = new DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
        entity.setHihokenshaNo(new HihokenshaNo(headRecordEntity.get被保険者証番号()));
        entity.setTaishoNendo(new FlexibleYear(toRDate(headRecordEntity.get対象年度()).getYear().toDateString()));
        entity.setShoKisaiHokenshaNo(new HokenshaNo(headRecordEntity.get保険者番号()));
        entity.setShikyuShinseishoSeiriNo(headRecordEntity.get連絡票整理番号());
        entity.setMeisanNo(new RString(明細番号).padZeroToLeft(INT_2));
        entity.setRirekiNo(new Decimal(INT_1));
        entity.setHokenSeidoCode(meisaiEntity.get保険制度コード());
        entity.setUchiwakeHokenshaNo(meisaiEntity.get保険者番号());
        entity.setKokuho_HihokenshaShoKigo(meisaiEntity.get被保険者証記号());
        entity.setHiHokenshaShoNo(meisaiEntity.get被保険者証番号());
        entity.setUchiwakeHokenshaMei(meisaiEntity.get保険者名());
        entity.setJikoFutanSeiriNo(meisaiEntity.get自己負担額証明書整理番号());
        entity.setTaishoshaShimei(meisaiEntity.get対象者氏名漢字());
        entity.setOver70_Futangaku(meisaiEntity.get七十歳以上負担額());
        entity.setOver70_AmbunRitsu(to按分率(meisaiEntity.get七十歳以上按分率()));
        entity.setOver70_Shikyugaku(meisaiEntity.get七十歳以上支給額());
        entity.setUnder70_Futangaku(meisaiEntity.get七十歳未満負担額());
        entity.setFutangaku(meisaiEntity.get負担額());
        entity.setAmbunRitsu(to按分率(meisaiEntity.get按分率()));
        entity.setUnder70_Shikyugaku(meisaiEntity.get七十歳未満支給額());
        entity.setShikyugaku(meisaiEntity.get支給額());
        entity.setOver70_Biko(meisaiEntity.get備考欄記載70歳以上負担額());
        entity.setUnder70_Biko(meisaiEntity.get備考欄記載70歳未満負担額());
        entity.setDataKubun(RString.EMPTY);
        entity.setUketoriYM(parameter.get処理年月());
        entity.setSofuYM(FlexibleYearMonth.EMPTY);
        entity.setState(EntityDataState.Added);
        高額合算支給額計算結果明細一時tableWriter.insert(entity);
    }

    private void insert高額合算支給額計算結果(KogakuGassanShikyugakuKeisanKekkaInHeaderEntity headRecordEntity,
            KogakuGassanShikyugakuKeisanKekkaInShukeiEntity shukeiEntity) {

        DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity entity = new DbWT3861KogakuGassanShikyugakuKeisanKekkaEntity();
        entity.setRenban(集計件数);
        entity.setHihokenshaNoIn(new HihokenshaNo(headRecordEntity.get被保険者証番号()));
        entity.setTaishoNendo(new FlexibleYear(toRDate(headRecordEntity.get対象年度()).getYear().toDateString()));
        entity.setShoKisaiHokenshaNo(new HokenshaNo(headRecordEntity.get保険者番号()));
        entity.setShikyuShinseishoSeiriNo(headRecordEntity.get連絡票整理番号());
        entity.setRirekiNo(INT_1);
        entity.setHokenSeidoCode(headRecordEntity.get保険制度コード());
        entity.setJikoFutanSeiriNo(headRecordEntity.get自己負担額証明書整理番号());
        entity.setTaishoKeisanKaishiYMD(get年月日(headRecordEntity.get対象計算期間開始年月日()));
        entity.setTaishoKeisanShuryoYMD(get年月日(headRecordEntity.get対象計算期間終了年月日()));
        entity.setSetaiFutanSogaku(get金額(headRecordEntity.get世帯負担総額()));
        entity.setSetaiGassanGaku(get金額(headRecordEntity.get介護等合算一部負担金等世帯合算額()));
        entity.setOver70_SetaiGassanGaku(get金額(headRecordEntity.get七十歳以上介護等合算一部負担金等世帯合算額()));
        entity.setShotokuKubun(headRecordEntity.get所得区分());
        entity.setOver70_ShotokuKubun(headRecordEntity.get七十歳以上の者に係る所得区分());
        entity.setSanteiKijunGaku(get金額(headRecordEntity.get介護等合算算定基準額()));
        entity.setOver70_SanteiKijyunGaku(get金額(headRecordEntity.get七十歳以上介護等合算算定基準額()));
        entity.setSetaiShikyuSogaku(get金額(headRecordEntity.get世帯支給総額()));
        entity.setOver70_SetaiShikyuSogaku(get金額(headRecordEntity.getうち70歳以上分世帯支給総額()));
        entity.setHonninShikyugaku(get金額(headRecordEntity.get按分後支給額()));
        entity.setOver70_honninShikyugaku(get金額(headRecordEntity.getうち70歳以上分按分後支給額()));
        entity.setTeiShotoku_1_SaiKeisanUmu(headRecordEntity.get介護低所得者Ⅰ再計算実施の有無());
        entity.setBiko(headRecordEntity.get備考());
        if (!RString.isNullOrEmpty(headRecordEntity.get計算結果連絡先郵便番号())) {
            entity.setKekkaRenrakusakiYubinNo(new YubinNo(headRecordEntity.get計算結果連絡先郵便番号()));
        }
        entity.setKekkaRenrakusakiJusho(headRecordEntity.get計算結果連絡先住所());
        entity.setKetteRenrakusakiMeisho1(headRecordEntity.get支給額計算結果連絡先名称1());
        entity.setKekkaRenrakusakiMeisho2(headRecordEntity.get支給額計算結果連絡先名称2());
        entity.setTsuchiYMD(get年月日(headRecordEntity.get通知年月日()));
        if (!RString.isNullOrEmpty(headRecordEntity.get連絡票発行者名())) {
            entity.setRenrakuhyoHakkoshaMei(new AtenaMeisho(headRecordEntity.get連絡票発行者名()));
        }
        if (!RString.isNullOrEmpty(headRecordEntity.get連絡票発行者郵便番号())) {
            entity.setRenrakuhyoHakkoshaYubinNo(new YubinNo(headRecordEntity.get連絡票発行者郵便番号()));
        }
        entity.setRenrakuhyoHakkoshaJusho(headRecordEntity.get連絡票発行者住所());
        if (!RString.isNullOrEmpty(headRecordEntity.get問い合わせ先郵便番号())) {
            entity.setToiawasesakiYobinNo(new YubinNo(headRecordEntity.get問い合わせ先郵便番号()));
        }
        entity.setToiawasesakiJusho(headRecordEntity.get問い合わせ先住所());
        entity.setToiawasesakiMeisho1(headRecordEntity.get問い合わせ先名称1());
        entity.setToiawasesakiMeisho2(headRecordEntity.get問い合わせ先名称2());
        if (!RString.isNullOrEmpty(headRecordEntity.get問い合わせ先電話番号())) {
            entity.setToiawasesakiTelNo(new TelNo(headRecordEntity.get問い合わせ先電話番号()));
        }
        entity.setOver70_FutangakuGokei(get金額(shukeiEntity.get七十歳以上負担額合計()));
        entity.setOver70_ShikyugakuGokei(get金額(shukeiEntity.get七十歳以上支給額合計()));
        entity.setUnder70_FutangakuGokei(get金額(shukeiEntity.get七十歳未満負担額合計()));
        entity.setFutangakuGokei(get金額(shukeiEntity.get負担額合計()));
        entity.setUnder70_ShikyugakuGokei(get金額(shukeiEntity.get七十歳未満支給額合計()));
        entity.setShikyugakuGokei(get金額(shukeiEntity.get支給額合計()));
        entity.setDataKubun(介護合算_データ区分);
        entity.setUketoriYM(parameter.get処理年月());
        entity.setSofuYM(FlexibleYearMonth.EMPTY);
        entity.setSaisoFG(再送フラグ_再送不要);
        entity.setSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(FlexibleDate.EMPTY);
        entity.setKakuninListFlag(false);
        entity.setState(EntityDataState.Added);
        高額合算支給額計算結果一時tableWriter.insert(entity);
    }

    private RString to按分率(RString 項目) {
        if (区切り.equals(項目)) {
            return 按分率;
        }
        return 項目;
    }

    private RDate toRDate(RString 日付) {
        if (!RString.isNullOrEmpty(日付)) {
            return new RDate(日付.toString());
        }
        return RDate.MIN;
    }

    private Decimal get金額(RString 金額) {
        if (RString.isNullOrEmpty(金額) || !Decimal.canConvert(金額)) {
            return Decimal.ZERO;
        }
        return new Decimal(金額.toString());
    }

    private FlexibleDate get年月日(RString 年月日) {
        if (RString.isNullOrEmpty(年月日)) {
            return null;
        }
        return new FlexibleDate(toRDate(年月日).toDateString());
    }
}
