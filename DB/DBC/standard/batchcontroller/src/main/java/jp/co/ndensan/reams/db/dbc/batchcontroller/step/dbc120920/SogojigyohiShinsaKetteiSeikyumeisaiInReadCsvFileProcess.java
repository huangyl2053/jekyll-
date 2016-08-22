/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120920;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1611SinsaKetteiSeikyuMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1612SinsaKetteiSeikyuKogakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.DbWT1613SinsaKetteiSeikyuGokeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiCsvFileHeadRecordEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiCsvFileMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiCsvFileToreraRecode1AEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiCsvFileToreraRecode1BEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiCsvFileToreraRecode2Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.io.csv.ListToObjectMappingHelper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 審査決定請求明細表情報取込共通処理（CSVファイル取込）クラスです
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInReadCsvFileProcess extends BatchProcessBase<RString> {

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
    @BatchWriter
    BatchEntityCreatedTempTableWriter 審査決定請求明細一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 審査決定請求高額一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 審査決定請求合計一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    private IKokuhorenKyoutsuuTempTableMapper 一時表Mapper;
    private static final RString 審査決定請求明細一時_TABLE_NAME = new RString("DbWT1611SinsaKetteiSeikyuMeisai");
    private static final RString 審査決定請求高額一時_TABLE_NAME = new RString("DbWT1612SinsaKetteiSeikyuKogaku");
    private static final RString 審査決定請求合計一時_TABLE_NAME = new RString("DbWT1613SinsaKetteiSeikyuGokei");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");
    private final RString レコード種別 = new RString("1");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private final RString 帳票レコード種別_T2 = new RString("T2");
    private final RString 交換情報識別番号_1611 = new RString("1611");
    private final RString 交換情報識別番号_1621 = new RString("1621");
    private final RString 交換情報識別番号_1631 = new RString("1631");
    private static final RString 区切り文字 = new RString(",");
    private static final RString NUM = new RString("99");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_2 = 2;
    private static final Integer INDEX_3 = 3;
    private static final int 定値_1 = 1;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private SogojigyohiShinsaKetteiCsvFileHeadRecordEntity headRecordEntity;
    private SogojigyohiShinsaKetteiCsvFileMeisaiEntity meisaiEntity;
    private SogojigyohiShinsaKetteiCsvFileToreraRecode1AEntity toreraRecord1AEntity;
    private SogojigyohiShinsaKetteiCsvFileToreraRecode1BEntity toreraRecord1BEntity;
    private SogojigyohiShinsaKetteiCsvFileToreraRecode2Entity toreraRecord2Entity;
    private int 明細_連番;
    private int 高額_連番;
    private int 合計_連番;
    private int 連番;

    @Override
    protected void initialize() {
        連番 = parameter.getレコード件数合算();
        returnEntity = new FlowEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先パース());
    }

    @Override
    protected void createWriter() {
        審査決定請求明細一時tableWriter = new BatchEntityCreatedTempTableWriter(
                審査決定請求明細一時_TABLE_NAME, DbWT1611SinsaKetteiSeikyuMeisaiTempEntity.class);
        審査決定請求高額一時tableWriter = new BatchEntityCreatedTempTableWriter(
                審査決定請求高額一時_TABLE_NAME, DbWT1612SinsaKetteiSeikyuKogakuTempEntity.class);
        審査決定請求合計一時tableWriter = new BatchEntityCreatedTempTableWriter(
                審査決定請求合計一時_TABLE_NAME, DbWT1613SinsaKetteiSeikyuGokeiTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(
                処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void beforeExecute() {
        一時表Mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
                controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                headRecordEntity = new SogojigyohiShinsaKetteiCsvFileHeadRecordEntity();
                連番 = 連番 + 定値_1;
                headRecordEntity = ListToObjectMappingHelper.toObject(SogojigyohiShinsaKetteiCsvFileHeadRecordEntity.class, data);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                meisaiEntity = new SogojigyohiShinsaKetteiCsvFileMeisaiEntity();
                meisaiEntity = ListToObjectMappingHelper.toObject(SogojigyohiShinsaKetteiCsvFileMeisaiEntity.class, data);
                insert審査決定請求明細一時TBL(meisaiEntity);
                明細_連番 = 明細_連番 + 定値_1;
            } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                交換情報識別番号(data);
            } else if (帳票レコード種別_T2.equals(data.get(INDEX_3))) {
                toreraRecord2Entity = new SogojigyohiShinsaKetteiCsvFileToreraRecode2Entity();
                toreraRecord2Entity = ListToObjectMappingHelper.toObject(SogojigyohiShinsaKetteiCsvFileToreraRecode2Entity.class, data);
                insert審査決定請求合計一時TBL(null, toreraRecord2Entity);
                合計_連番 = 合計_連番 + 定値_1;
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (null == returnEntity.getShoriYM()) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            returnEntity.setShoriYM(処理対象年月);
        }
        if (連番 == parameter.getレコード件数合算()) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(NUM);
            一時表Mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        returnEntity.set明細データ登録件数(明細_連番);
        returnEntity.set高額データ登録件数(高額_連番);
        returnEntity.set合計データ登録件数(合計_連番);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);

    }

    private void insert審査決定請求明細一時TBL(SogojigyohiShinsaKetteiCsvFileMeisaiEntity meisaiEntity) {
        DbWT1611SinsaKetteiSeikyuMeisaiTempEntity seikyuMeisaiTempEntity = new DbWT1611SinsaKetteiSeikyuMeisaiTempEntity();
        seikyuMeisaiTempEntity.setMeisaiRirekiNo(連番);
        seikyuMeisaiTempEntity.setJigyoshoNo(new JigyoshaNo(meisaiEntity.get事業所番号()));
        seikyuMeisaiTempEntity.setJigyoshoName(meisaiEntity.get事業所名());
        seikyuMeisaiTempEntity.setServiceTeikyouYM(new FlexibleYearMonth(meisaiEntity.getサービス提供年月()));
        seikyuMeisaiTempEntity.setServiceShuruiCode(new ServiceShuruiCode(meisaiEntity.getサービス種類コード()));
        seikyuMeisaiTempEntity.setServiceShuruiMei(meisaiEntity.getサービス種類名());
        seikyuMeisaiTempEntity.setKensu(getDecimal(meisaiEntity.get件数()));
        seikyuMeisaiTempEntity.setNissuKaisu(getDecimal(meisaiEntity.get日数_回数()));
        seikyuMeisaiTempEntity.setTanisu(getDecimal(meisaiEntity.get単位数()));
        seikyuMeisaiTempEntity.setKingaku(getDecimal(meisaiEntity.get金額()));
        seikyuMeisaiTempEntity.setKaigoKyufuhiSogoJigyohi(getDecimal(meisaiEntity.get介護給付費_総合事業費()));
        seikyuMeisaiTempEntity.setRiyoshaFutangaku(getDecimal(meisaiEntity.get利用者負担額()));
        seikyuMeisaiTempEntity.setKohiFutangaku(getDecimal(meisaiEntity.get公費負担額()));
        審査決定請求明細一時tableWriter.insert(seikyuMeisaiTempEntity);
    }

    private void insert審査決定請求高額一時TBL(SogojigyohiShinsaKetteiCsvFileToreraRecode1AEntity toreraRecord1AEntity) {
        DbWT1612SinsaKetteiSeikyuKogakuTempEntity kyuKogakuTempEntity = new DbWT1612SinsaKetteiSeikyuKogakuTempEntity();
        kyuKogakuTempEntity.setKogakuRirekiNo(連番);
        kyuKogakuTempEntity.setKogakuGaitoKensu(getDecimal(toreraRecord1AEntity.get高額該当件数()));
        kyuKogakuTempEntity.setKogakuKaigoServicehi(getDecimal(toreraRecord1AEntity.get高額介護サービス費()));
        kyuKogakuTempEntity.setKogakuKohiFutangaku(getDecimal(toreraRecord1AEntity.get公費負担額()));
        審査決定請求高額一時tableWriter.insert(kyuKogakuTempEntity);
    }

    private void insert審査決定請求合計一時TBL(SogojigyohiShinsaKetteiCsvFileToreraRecode1BEntity toreraRecord1BEntity,
            SogojigyohiShinsaKetteiCsvFileToreraRecode2Entity toreraRecord2Entity) {
        DbWT1613SinsaKetteiSeikyuGokeiTempEntity kyuGokeiTempEntity = new DbWT1613SinsaKetteiSeikyuGokeiTempEntity();
        kyuGokeiTempEntity.setGokeiRirekiNo(連番);
        kyuGokeiTempEntity.setHokenshaNo(new HokenshaNo(controlCsvEntity.getHokenshaNo()));
        HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(controlCsvEntity.getHokenshaNo()));
        if (hokensha != null) {
            kyuGokeiTempEntity.setHokenshaName(hokensha.get保険者名());
        }
        kyuGokeiTempEntity.setShinsaYM(new FlexibleYearMonth(headRecordEntity.get審査年月()));
        kyuGokeiTempEntity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(headRecordEntity.get証記載保険者番号()));
        kyuGokeiTempEntity.setKokuhorenName(headRecordEntity.get国保連合会名());
        if (toreraRecord1BEntity != null) {
            kyuGokeiTempEntity.setGokeiKensu(getDecimal(toreraRecord1BEntity.get件数()));
            kyuGokeiTempEntity.setGokeiTanisu(getDecimal(toreraRecord1BEntity.get単位数()));
            kyuGokeiTempEntity.setGokeiKingaku(getDecimal(toreraRecord1BEntity.get金額()));
            kyuGokeiTempEntity.setGokeiKaigoKyufuhiSogoJigyohi(getDecimal(toreraRecord1BEntity.get総合事業費()));
            kyuGokeiTempEntity.setGokeiRiyoshaFutangaku(getDecimal(toreraRecord1BEntity.get利用者負担額()));
            kyuGokeiTempEntity.setGokeiKohiFutangaku(getDecimal(null));
        } else if (toreraRecord2Entity != null) {
            kyuGokeiTempEntity.setGokeiKensu(getDecimal(toreraRecord2Entity.get件数()));
            kyuGokeiTempEntity.setGokeiTanisu(getDecimal(toreraRecord2Entity.get単位数()));
            kyuGokeiTempEntity.setGokeiKingaku(getDecimal(toreraRecord2Entity.get金額()));
            kyuGokeiTempEntity.setGokeiKaigoKyufuhiSogoJigyohi(getDecimal(toreraRecord2Entity.get介護給付費_総合事業費()));
            kyuGokeiTempEntity.setGokeiRiyoshaFutangaku(getDecimal(toreraRecord2Entity.get利用者負担額()));
            kyuGokeiTempEntity.setGokeiKohiFutangaku(getDecimal(toreraRecord2Entity.get公費負担額()));
        }
        審査決定請求合計一時tableWriter.insert(kyuGokeiTempEntity);
    }

    private Decimal getDecimal(RString decimal) {
        if (RString.isNullOrEmpty(decimal)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }

    private void 交換情報識別番号(List<RString> data) {
        if (交換情報識別番号_1611.equals(data.get(INDEX_2))
                || 交換情報識別番号_1631.equals(data.get(INDEX_2))) {
            toreraRecord1AEntity = new SogojigyohiShinsaKetteiCsvFileToreraRecode1AEntity();
            toreraRecord1AEntity = ListToObjectMappingHelper.toObject(SogojigyohiShinsaKetteiCsvFileToreraRecode1AEntity.class, data);
            insert審査決定請求高額一時TBL(toreraRecord1AEntity);
            高額_連番 = 高額_連番 + 定値_1;
        } else if (交換情報識別番号_1621.equals(data.get(INDEX_2))) {
            toreraRecord1BEntity = new SogojigyohiShinsaKetteiCsvFileToreraRecode1BEntity();
            toreraRecord1BEntity = ListToObjectMappingHelper.toObject(SogojigyohiShinsaKetteiCsvFileToreraRecode1BEntity.class, data);
            insert審査決定請求合計一時TBL(toreraRecord1BEntity, null);
            合計_連番 = 合計_連番 + 定値_1;
        }
    }
}
