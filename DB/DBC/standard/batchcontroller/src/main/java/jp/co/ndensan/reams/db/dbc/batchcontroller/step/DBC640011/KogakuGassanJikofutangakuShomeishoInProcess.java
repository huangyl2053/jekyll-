/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC640011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikofutangakuShomeishoRealHakkoFlag;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenDataSaisoFlag;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInProcessParamerter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoFlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0001HihokenshaEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算自己負担額証明書情報または高額合算自己負担額確認情報取込processクラスです
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
public class KogakuGassanJikofutangakuShomeishoInProcess extends BatchProcessBase<List<RString>> {

    private static final RString 高額合算自己負担額一時_TABLE_NAME
            = new RString("DbWT37H1KogakuGassanaJikofutangaku");
    private static final RString 高額合算自己負担額明細一時_TABLE_NAME
            = new RString("DbWT37H2KogakuGassanaJikofutangakuMeisai");
    private static final RString 被保険者一時_TABLE_NAME = new RString("DbWT0001Hihokensha");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private static final RString 交換情報識別番号_37H1 = new RString("37H1");
    private static final RString 交換情報識別番号_37J1 = new RString("37J1");
    private static final RString 対象年度420 = new RString("420");
    private static final Integer INDEX_0 = 0;
    private static final RString 四月分 = new RString("004");
    private static final RString 五月分 = new RString("005");
    private static final RString 六月分 = new RString("006");
    private static final RString 七月分 = new RString("007");
    private static final RString 八月分 = new RString("008");
    private static final RString 九月分 = new RString("009");
    private static final RString 十月分 = new RString("010");
    private static final RString 十一月分 = new RString("011");
    private static final RString 十二月分 = new RString("012");
    private static final RString 翌年一月分 = new RString("101");
    private static final RString 翌年二月分 = new RString("102");
    private static final RString 翌年三月分 = new RString("103");
    private static final RString 翌年四月分 = new RString("104");
    private static final RString 翌年五月分 = new RString("105");
    private static final RString 翌年六月分 = new RString("106");
    private static final RString 翌年七月分 = new RString("107");
    private static final Integer INDEX_1 = 1;
    private static final Integer INDEX_2 = 2;
    private static final RString レコード種別 = new RString("1");
    private final RString エンドレコード種別 = new RString("3");
    private final RString 区切り文字 = new RString(",");
    private int renban;
    /**
     * returnEnyity
     */
    public static final RString PARAMETER_OUT_FLOWENTITY;

    private RString csvReaderPath;

    private KogakuGassanJikofutangakuShomeishoInProcessParamerter parameter;

    private DbWT37H1KogakuGassanaJikofutangakuTempEntity dbWT37H1TempEntity;
    private DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity dbWT37H2TempEntity;
    private DbWT0001HihokenshaEntity dbWT0001TempEntity;
    private KogakuGassanJikofutangakuShomeishoInCsvEntity csvEntity;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private KogakuGassanJikofutangakuShomeishoFlowEntity returnEntity;
    private OutputParameter<KogakuGassanJikofutangakuShomeishoFlowEntity> flowEntity;

    static {
        PARAMETER_OUT_FLOWENTITY = new RString("flowEntity");
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算自己負担額明細一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時tableWriter;
    @BatchWriter
    IBatchTableWriter 処理結果リスト一時tbWriter;

    @Override
    protected void initialize() {
        renban = parameter.get連番();
        csvReaderPath = parameter.getPath().concat(File.separator).concat(parameter.getFileName());
        returnEntity = new KogakuGassanJikofutangakuShomeishoFlowEntity();
        flowEntity = new OutputParameter<>();
        dbWT37H1TempEntity = new DbWT37H1KogakuGassanaJikofutangakuTempEntity();
        dbWT37H2TempEntity = new DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity();
        dbWT0001TempEntity = new DbWT0001HihokenshaEntity();
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額一時_TABLE_NAME,
                        DbWT37H1KogakuGassanaJikofutangakuTempEntity.class);
        高額合算自己負担額明細一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算自己負担額明細一時_TABLE_NAME,
                        DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity.class);
        被保険者一時tableWriter
                = new BatchEntityCreatedTempTableWriter(被保険者一時_TABLE_NAME, DbWT0001HihokenshaEntity.class);
        処理結果リスト一時tbWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchCsvListReader(new CsvListReader.InstanceBuilder(csvReaderPath)
                .setDelimiter(区切り文字).setEncode(Encode.SJIS).hasHeader(false).setNewLine(NewLine.CRLF).build());
    }

    @Override
    protected void process(List<RString> data) {
        csvEntity = null;
        if (data != null && !data.isEmpty()) {
            if (エンドレコード種別.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            } else if (交換情報識別番号_37H1.equals(data.get(INDEX_2))) {
                csvEntity = ListToObjectMappingHelper.toObject(KogakuGassanJikofutangakuShomeishoInCsvEntity.class, data);
                renban = renban + 1;
                set高額合算自己負担額一時TBL(dbWT37H1TempEntity, renban, csvEntity);
                set高額合算自己負担額明細一時TBL(dbWT37H2TempEntity, renban, csvEntity);
                set被保険者一時TBL(dbWT0001TempEntity, renban, csvEntity);
            } else if (交換情報識別番号_37J1.equals(data.get(INDEX_2))) {
                csvEntity = ListToObjectMappingHelper.toObject(KogakuGassanJikofutangakuShomeishoInCsvEntity.class, data);
                renban = renban + 1;
                set高額合算自己負担額明細一時TBL(dbWT37H2TempEntity, renban, csvEntity);
                set高額合算自己負担額一時TBL(dbWT37H1TempEntity, renban, csvEntity);
                set被保険者一時TBL(dbWT0001TempEntity, renban, csvEntity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        int レコード件数合算 = INDEX_0;
        if (controlCsvEntity != null && controlCsvEntity.getCodeNum() != null) {
            レコード件数合算 = Integer.parseInt(controlCsvEntity.getCodeNum().toString());
        }
        if (controlCsvEntity != null && controlCsvEntity.getShoriYM() != null) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            returnEntity.setShoriYM(処理対象年月);
        }
        if (parameter.isさいごファイルフラグ() && 0 == renban) {
            処理結果リスト一時に登録();
        }
        returnEntity.set連番(renban);
        returnEntity.setCodeNum(レコード件数合算);
        returnEntity.set高額合算自己負担額一時TBL登録件数(renban);
        flowEntity.setValue(returnEntity);
    }

    private void set高額合算自己負担額一時TBL(DbWT37H1KogakuGassanaJikofutangakuTempEntity dbWT37H1TempEntity,
            int renban, KogakuGassanJikofutangakuShomeishoInCsvEntity csvEntity) {

        dbWT37H1TempEntity.setRenban(renban);
        RString 被保険者番号 = csvEntity.get被保険者_証_番号();
        RString 保険者番号 = csvEntity.get保険者番号();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            dbWT37H1TempEntity.setHokenshaNoIn(new HihokenshaNo(被保険者番号));
        }
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            dbWT37H1TempEntity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
        }
        RDate 対象年度 = new RDate(csvEntity.get対象年度().toString());
        dbWT37H1TempEntity.setTaishoNendo(new FlexibleYear(対象年度.getNendo().toDateString()));
        dbWT37H1TempEntity.setShikyuShinseishoSeiriNo(csvEntity.get支給申請書整理番号());
        dbWT37H1TempEntity.setRirekiNo(INDEX_1);
        dbWT37H1TempEntity.setHokenSeidoCode(csvEntity.get保険制度コード());
        dbWT37H1TempEntity.setHokenshaMei(csvEntity.get保険者名称());
        dbWT37H1TempEntity.setKokuho_HihokenshaShoKigo(csvEntity.get被保険者証記号());
        dbWT37H1TempEntity.setHihokenshaShimeiKana(new AtenaKanaMeisho(csvEntity.get被保険者氏名_カナ()));
        dbWT37H1TempEntity.setHihokenshaShimei(new AtenaMeisho(csvEntity.get被保険者氏名_漢字()));
        RDate 生年月日 = new RDate(csvEntity.get生年月日().toString());
        dbWT37H1TempEntity.setUmareYMD(new FlexibleDate(生年月日.toDateString()));
        dbWT37H1TempEntity.setSeibetsuCode(new Code(csvEntity.get性別()));
        dbWT37H1TempEntity.setShotokuKubun(csvEntity.get所得区分());
        dbWT37H1TempEntity.setOver70_ShotokuKubun(csvEntity.get七十歳以上の者に係る所得区分());
        dbWT37H1TempEntity.setJikoFutanSeiriNo(csvEntity.get自己負担額証明書整理番号());
        dbWT37H1TempEntity.setKoki_HokenshaNo(csvEntity.get突合用後期高齢者医療保険者番号());
        dbWT37H1TempEntity.setKoki_HihokenshaNo(csvEntity.get突合用後期高齢者医療被保険者番号());
        dbWT37H1TempEntity.setKokuho_HokenshaNo(csvEntity.get突合用国民健康保険保険者番号());
        dbWT37H1TempEntity.setKokuho_HihokenshaShoNo(csvEntity.get突合用国民健康保険被保険者証番号());
        dbWT37H1TempEntity.setKokuho_KojinNo(csvEntity.get突合用国保被保険者個人番号());
        dbWT37H1TempEntity.setIdoKubun(csvEntity.get異動区分());
        dbWT37H1TempEntity.setHoseiZumiSofuKubun(csvEntity.get補正済自己負担額送付区分());
        RDate 対象計算期間_開始 = new RDate(csvEntity.get対象計算期間_開始().toString());
        dbWT37H1TempEntity.setTaishoKeisanKaishiYMD(new FlexibleDate(対象計算期間_開始.toDateString()));
        RDate 対象計算期間_終了 = new RDate(csvEntity.get対象計算期間_終了().toString());
        dbWT37H1TempEntity.setTaishoKeisanShuryoYMD(new FlexibleDate(対象計算期間_終了.toDateString()));
        RDate 被保険者期間_開始 = new RDate(csvEntity.get被保険者期間_開始().toString());
        dbWT37H1TempEntity.setHihokenshaKaishiYMD(new FlexibleDate(被保険者期間_開始.toDateString()));
        RDate 被保険者期間_終了 = new RDate(csvEntity.get被保険者期間_終了().toString());
        dbWT37H1TempEntity.setHihokenshaShuryoYMD(new FlexibleDate(被保険者期間_終了.toDateString()));
        RDate 申請年月日 = new RDate(csvEntity.get申請年月日().toString());
        dbWT37H1TempEntity.setShinseiYMD(new FlexibleDate(申請年月日.toDateString()));
        dbWT37H1TempEntity.setGokei_JikoFutanGaku(getDecimal(csvEntity.get対象年度合計欄_自己負担額()));
        dbWT37H1TempEntity.setGokei_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度合計欄_うち70_74歳の者に係る負担額()));
        dbWT37H1TempEntity.setGokei_Under70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度合計欄_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37H1TempEntity.setGokei_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度合計欄_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37H1TempEntity.setSumi_Gokei_JikoFutanGaku(Decimal.ZERO);
        dbWT37H1TempEntity.setSumi_Gokei_70_74JikoFutanGaku(Decimal.ZERO);
        dbWT37H1TempEntity.setSumi_Gokei_Under70KogakuShikyuGaku(Decimal.ZERO);
        dbWT37H1TempEntity.setSumi_Gokei_70_74KogakuShikyuGaku(Decimal.ZERO);
        dbWT37H1TempEntity.setAtesakiShimei(new AtenaMeisho(csvEntity.get宛先情報_宛先氏名_漢字()));
        dbWT37H1TempEntity.setAtesakiYubinNo(new YubinNo(csvEntity.get宛先情報_宛先郵便番号()));
        dbWT37H1TempEntity.setAtesakiJusho(csvEntity.get宛先情報_宛先住所_漢字());
        dbWT37H1TempEntity.setMadoguchi_TaishoshaHanteiCode(csvEntity.get窓口払対象者判定コード());
        dbWT37H1TempEntity.setShiharaiBasho(RString.EMPTY);
        dbWT37H1TempEntity.setShikaraiKaishiYMD(FlexibleDate.EMPTY);
        dbWT37H1TempEntity.setShiharaiShuryoYMD(FlexibleDate.EMPTY);
        dbWT37H1TempEntity.setHeichoNaiyo(RString.EMPTY);
        dbWT37H1TempEntity.setShiharaiKaishiTime(RString.EMPTY);
        dbWT37H1TempEntity.setShiharaiShuryoTime(RString.EMPTY);
        dbWT37H1TempEntity.setBiko(csvEntity.get備考欄());
        dbWT37H1TempEntity.setDataSakuseiKubun(Kaigogassan_DataSakuseiKubun.国保連取込情報.getコード());
        dbWT37H1TempEntity.setKakunin_UketoriYM(FlexibleYearMonth.EMPTY);
        dbWT37H1TempEntity.setHoseiZumi_SofuYM(FlexibleYearMonth.EMPTY);
        dbWT37H1TempEntity.setShomeisho_UketoriYM(FlexibleYearMonth.EMPTY);
        dbWT37H1TempEntity.setSaisoFlag(KokuhorenDataSaisoFlag.再送不要.getコード());
        dbWT37H1TempEntity.setSofuTaishoGaiFlag(RString.EMPTY);
        dbWT37H1TempEntity.setJikoFutanKeisanYMD(FlexibleDate.EMPTY);
        dbWT37H1TempEntity.setShomeiShoSakuseiYMD(FlexibleDate.EMPTY);
        dbWT37H1TempEntity.setKoki_KokuhoShoriKubun(RString.EMPTY);
        dbWT37H1TempEntity.setJikoFutangakuShomeishoRealHakkoFlag(
                KaigoGassan_JikofutangakuShomeishoRealHakkoFlag.未発行.getコード());
        dbWT37H1TempEntity.setBatchHoseiJissiYMD(FlexibleDate.EMPTY);
        dbWT37H1TempEntity.setRealHoseiJissiYMD(FlexibleDate.EMPTY);
        dbWT37H1TempEntity.setKoshinFlag(false);
        dbWT37H1TempEntity.setJikoFutangakuSaiFlag(false);
        高額合算自己負担額一時tableWriter.insert(dbWT37H1TempEntity);
    }

    private void set高額合算自己負担額明細一時TBL(
            DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity dbWT37J1TempEntity,
            int renban, KogakuGassanJikofutangakuShomeishoInCsvEntity csvEntity) {
        dbWT37J1TempEntity.setRenban(renban);
        RString 被保険者番号 = csvEntity.get被保険者_証_番号();
        RString 保険者番号 = csvEntity.get保険者番号();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            dbWT37J1TempEntity.setHokenshaNoIn(new HihokenshaNo(被保険者番号));
        }
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            dbWT37J1TempEntity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
        }
        RDate 対象年度 = new RDate(csvEntity.get対象年度().toString());
        dbWT37J1TempEntity.setTaishoNendo(new FlexibleYear(対象年度.getNendo().toDateString()));
        dbWT37J1TempEntity.setShikyuShinseishoSeiriNo(csvEntity.get支給申請書整理番号());
        dbWT37J1TempEntity.setRirekiNo(INDEX_1);
        dbWT37J1TempEntity.setSumi_JikoFutanGaku(Decimal.ZERO);
        dbWT37J1TempEntity.setSumi_70_74JikoFutanGaku(Decimal.ZERO);
        dbWT37J1TempEntity.setSumi_under_70KogakuShikyuGaku(Decimal.ZERO);
        dbWT37J1TempEntity.setSumi_70_74KogakuShikyuGaku(Decimal.ZERO);
        dbWT37J1TempEntity.setSumi_Tekiyo(RString.EMPTY);
        dbWT37J1TempEntity.setJikoFutangakuSaiFlag(false);
        set対象年度月分の情報(dbWT37J1TempEntity, csvEntity);
    }

    private void set被保険者一時TBL(DbWT0001HihokenshaEntity dbWT0001TempEntity,
            int renban, KogakuGassanJikofutangakuShomeishoInCsvEntity csvEntity) {
        dbWT0001TempEntity.setMeisaiRenban((new Decimal(renban)));
        RString 被保険者番号 = csvEntity.get被保険者_証_番号();
        RString 保険者番号 = csvEntity.get保険者番号();
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            dbWT0001TempEntity.setShoHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            dbWT0001TempEntity.setOrgHihokenshaNo(new HihokenshaNo(被保険者番号));
        }
        dbWT0001TempEntity.setServiceTeikyoYmd(FlexibleDate.getNowDate());
        dbWT0001TempEntity.setOrgHihokenshaKanaShimei(csvEntity.get被保険者氏名_カナ());
        dbWT0001TempEntity.setOrgHihokenshaShimei(csvEntity.get被保険者氏名_漢字());
        dbWT0001TempEntity.setOldShichosonCode(LasdecCode.EMPTY);
        dbWT0001TempEntity.setHenkanHihokenshaNo(HihokenshaNo.EMPTY);
        dbWT0001TempEntity.setHihokenshaNo(new HihokenshaNo(被保険者番号));
        dbWT0001TempEntity.setShichosonCode(LasdecCode.EMPTY);
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
        dbWT0001TempEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        dbWT0001TempEntity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        dbWT0001TempEntity.setShikakuShutokuJiyuCode(RString.EMPTY);
        dbWT0001TempEntity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        dbWT0001TempEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        dbWT0001TempEntity.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
        被保険者一時tableWriter.insert(dbWT0001TempEntity);
    }

    private void set対象年度月分の情報(DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity dbWT37J1TempEntity,
            KogakuGassanJikofutangakuShomeishoInCsvEntity csvEntity) {
        dbWT37J1TempEntity.setTaishoM(八月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度8月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度8月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度8月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度8月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度8月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(九月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度9月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度9月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度9月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度9月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度9月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(十月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度10月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度10月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度10月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度10月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度10月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(十一月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度11月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度11月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度11月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度11月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度11月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(十二月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度12月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度12月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度12月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度12月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度12月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年一月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年1月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度翌年1月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年1月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年1月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年1月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年二月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年2月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度翌年2月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年2月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年2月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年2月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年三月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年3月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度翌年3月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年3月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年3月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年3月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年四月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年4月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度翌年4月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年4月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年4月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年4月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年五月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年5月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                .get対象年度翌年5月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年5月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                .get対象年度翌年5月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年5月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年六月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年6月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity.get対象年度翌年6月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity.get対象年度翌年6月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity.get対象年度翌年6月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年6月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        dbWT37J1TempEntity.setTaishoM(翌年七月分);
        dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度翌年7月分_自己負担額()));
        dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity.get対象年度翌年7月分_うち70_74歳の者に係る負担額()));
        dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity.get対象年度翌年7月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
        dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity.get対象年度翌年7月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
        dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度翌年7月分_摘要());
        高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        if (対象年度420.equals(csvEntity.get対象年度())) {
            dbWT37J1TempEntity.setTaishoM(四月分);
            dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度4月分_自己負担額()));
            dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity
                    .get対象年度4月分_うち70_74歳の者に係る負担額()));
            dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity
                    .get対象年度4月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
            dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity
                    .get対象年度4月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
            dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度4月分_摘要());
            高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
            dbWT37J1TempEntity.setTaishoM(五月分);
            dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度5月分_自己負担額()));
            dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity.get対象年度5月分_うち70_74歳の者に係る負担額()));
            dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity.get対象年度5月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
            dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity.get対象年度5月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
            dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度5月分_摘要());
            高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
            dbWT37J1TempEntity.setTaishoM(六月分);
            dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度6月分_自己負担額()));
            dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity.get対象年度6月分_うち70_74歳の者に係る負担額()));
            dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity.get対象年度6月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
            dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity.get対象年度6月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
            dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度6月分_摘要());
            高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
            dbWT37J1TempEntity.setTaishoM(七月分);
            dbWT37J1TempEntity.setJikoFutanGaku(getDecimal(csvEntity.get対象年度7月分_自己負担額()));
            dbWT37J1TempEntity.setUchisu_70_74JikoFutanGaku(getDecimal(csvEntity.get対象年度7月分_うち70_74歳の者に係る負担額()));
            dbWT37J1TempEntity.setUnder_70KogakuShikyuGaku(getDecimal(csvEntity.get対象年度7月分_高額療養費_高額介護_予防_サービス費_支給額_70歳未満()));
            dbWT37J1TempEntity.setOver_70_74KogakuShikyuGaku(getDecimal(csvEntity.get対象年度7月分_高額療養費_高額介護_予防_サービス費_支給額_70_74歳()));
            dbWT37J1TempEntity.setTekiyo(csvEntity.get対象年度7月分_摘要());
            高額合算自己負担額明細一時tableWriter.insert(dbWT37J1TempEntity);
        }
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
