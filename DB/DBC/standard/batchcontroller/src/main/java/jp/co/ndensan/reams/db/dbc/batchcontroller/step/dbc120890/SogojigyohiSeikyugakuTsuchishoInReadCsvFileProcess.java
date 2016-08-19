/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120890;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileHeadRecordEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode1Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode2Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.SeikyugakuTsuchishoCsvFileToreraRecode3Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishofutanshain.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu.IKokuhorenKyoutsuuTempTableMapper;
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
 * 総合事業費等請求額通知書情報取込のCSVファイル読取
 *
 * @reamsid_L DBC-2480-013 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInReadCsvFileProcess extends BatchProcessBase<RString> {

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
    BatchEntityCreatedTempTableWriter 請求額通知書一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    private IKokuhorenKyoutsuuTempTableMapper 一時表Mapper;
    private static final RString 請求額通知書一時_TABLE_NAME = new RString("DbWT1511SeikyugakuTsuchisho");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    private final RString レコード種別 = new RString("1");
    private final RString レコード種別_エンド = new RString("3");
    private final RString 帳票レコード種別_H1 = new RString("H1");
    private final RString 帳票レコード種別_D1 = new RString("D1");
    private final RString 帳票レコード種別_T1 = new RString("T1");
    private final RString 帳票レコード種別_T2 = new RString("T2");
    private final RString 帳票レコード種別_T3 = new RString("T3");
    private static final RString 区切り文字 = new RString(",");
    private static final RString NUM = new RString("99");
    private static final Integer INDEX_0 = 0;
    private static final Integer INDEX_3 = 3;
    private KagoKetteiHokenshaInControlCsvEntity controlCsvEntity;
    private SeikyugakuTsuchishoCsvFileHeadRecordEntity headRecordEntity;
    private SeikyugakuTsuchishoCsvFileMeisaiEntity meisaiEntity;
    private SeikyugakuTsuchishoCsvFileToreraRecode1Entity toreraRecord1Entity;
    private SeikyugakuTsuchishoCsvFileToreraRecode2Entity toreraRecord2Entity;
    private SeikyugakuTsuchishoCsvFileToreraRecode3Entity toreraRecord3Entity;
    private DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity;
    private int 連番;
    boolean 合計;
    boolean 累計;

    @Override
    protected void initialize() {
        連番 = parameter.getレコード件数合算();
        returnEntity = new FlowEntity();
        controlCsvEntity = new KagoKetteiHokenshaInControlCsvEntity();
        shoTempentity = new DbWT1511SeikyugakuTsuchishoTempEntity();
    }

    @Override
    protected void beforeExecute() {
        一時表Mapper = getMapper(IKokuhorenKyoutsuuTempTableMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(parameter.get保存先パース());
    }

    @Override
    protected void createWriter() {
        請求額通知書一時tableWriter = new BatchEntityCreatedTempTableWriter(
                請求額通知書一時_TABLE_NAME, DbWT1511SeikyugakuTsuchishoTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(
                処理結果リスト一時_TABLE_NAME, DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(RString line) {
        List<RString> data = line.split(区切り文字.toString());
        if (data != null && !data.isEmpty()) {
            if (レコード種別_エンド.equals(data.get(INDEX_0))) {
                return;
            }
            if (レコード種別.equals(data.get(INDEX_0))) {
                controlCsvEntity = ListToObjectMappingHelper.toObject(KagoKetteiHokenshaInControlCsvEntity.class, data);
            } else if (帳票レコード種別_H1.equals(data.get(INDEX_3))) {
                ヘッダ判断();
                headRecordEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileHeadRecordEntity.class, data);
            } else if (帳票レコード種別_D1.equals(data.get(INDEX_3))) {
                明細判断();
                meisaiEntity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileMeisaiEntity.class, data);
            } else if (帳票レコード種別_T1.equals(data.get(INDEX_3))) {
                toreraRecord1Entity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode1Entity.class, data);
            } else if (帳票レコード種別_T2.equals(data.get(INDEX_3))) {
                toreraRecord2Entity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode2Entity.class, data);
            } else if (帳票レコード種別_T3.equals(data.get(INDEX_3))) {
                toreraRecord3Entity = ListToObjectMappingHelper.toObject(SeikyugakuTsuchishoCsvFileToreraRecode3Entity.class, data);
                累計判断();
            }
        }
    }

    private void ヘッダ判断() {
        if (meisaiEntity != null && toreraRecord1Entity == null) {
            合計 = false;
            累計 = false;
            set共通レコード(shoTempentity, controlCsvEntity, headRecordEntity);
            set明細レコード(shoTempentity, meisaiEntity);
            setトレーラレコード1_合計(shoTempentity, toreraRecord1Entity, 合計);
            setトレーラレコード2_累計(shoTempentity, toreraRecord2Entity, 累計);
            setトレーラレコード3_審査支払手数料(shoTempentity, toreraRecord3Entity, 累計);
            請求額通知書一時tableWriter.insert(shoTempentity);
            meisaiEntity = null;
        } else if (meisaiEntity != null && toreraRecord1Entity != null) {
            合計 = true;
            累計 = false;
            set共通レコード(shoTempentity, controlCsvEntity, headRecordEntity);
            set明細レコード(shoTempentity, meisaiEntity);
            setトレーラレコード1_合計(shoTempentity, toreraRecord1Entity, 合計);
            setトレーラレコード2_累計(shoTempentity, toreraRecord2Entity, 累計);
            setトレーラレコード3_審査支払手数料(shoTempentity, toreraRecord3Entity, 累計);
            請求額通知書一時tableWriter.insert(shoTempentity);
            toreraRecord1Entity = null;
            headRecordEntity = null;
            meisaiEntity = null;
        }
    }

    private void 明細判断() {
        if (meisaiEntity != null) {
            合計 = false;
            累計 = false;
            set共通レコード(shoTempentity, controlCsvEntity, headRecordEntity);
            set明細レコード(shoTempentity, meisaiEntity);
            setトレーラレコード1_合計(shoTempentity, toreraRecord1Entity, 合計);
            setトレーラレコード2_累計(shoTempentity, toreraRecord2Entity, 累計);
            setトレーラレコード3_審査支払手数料(shoTempentity, toreraRecord3Entity, 累計);
            請求額通知書一時tableWriter.insert(shoTempentity);
            meisaiEntity = null;
        }
    }

    private void 累計判断() {
        if (controlCsvEntity != null && headRecordEntity != null && meisaiEntity != null
                && toreraRecord1Entity != null && toreraRecord2Entity != null) {
            合計 = true;
            累計 = true;
            set共通レコード(shoTempentity, controlCsvEntity, headRecordEntity);
            set明細レコード(shoTempentity, meisaiEntity);
            setトレーラレコード1_合計(shoTempentity, toreraRecord1Entity, 合計);
            setトレーラレコード2_累計(shoTempentity, toreraRecord2Entity, 累計);
            setトレーラレコード3_審査支払手数料(shoTempentity, toreraRecord3Entity, 累計);
            請求額通知書一時tableWriter.insert(shoTempentity);
            headRecordEntity = null;
            meisaiEntity = null;
            toreraRecord1Entity = null;
            toreraRecord2Entity = null;
        }
    }

    private void set共通レコード(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity, KagoKetteiHokenshaInControlCsvEntity controlCsvEntity,
            SeikyugakuTsuchishoCsvFileHeadRecordEntity headRecordEntity) {
        連番 = 連番 + 1;
        shoTempentity.setRenban(連番);

        RString 保険者番号 = controlCsvEntity.getHokenshaNo();
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            shoTempentity.setHokenshaNo(new ShoKisaiHokenshaNo(保険者番号));
        }

        HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(保険者番号));
        if (hokensha != null) {
            shoTempentity.setHokenshaName(hokensha.get保険者名());
        }
        if (headRecordEntity.get証記載保険者番号() != null
                && !headRecordEntity.get証記載保険者番号().isEmpty()) {
            shoTempentity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(
                    headRecordEntity.get証記載保険者番号().substring(INDEX_3)));
        }

        shoTempentity.setShoKisaiHokenshaName(headRecordEntity.get保険者名());
        shoTempentity.setKohiFutanshaNo(RString.EMPTY);
        shoTempentity.setKohiFutanshaName(RString.EMPTY);
        shoTempentity.setKanCode(headRecordEntity.get款コード());
        shoTempentity.setKanName(headRecordEntity.get款名());
        shoTempentity.setKouCode(headRecordEntity.get項コード());
        shoTempentity.setKouName(headRecordEntity.get項名());
        shoTempentity.setShinsaYM(new FlexibleYearMonth(headRecordEntity.get審査年月()));
        shoTempentity.setKokuhorenName(headRecordEntity.get国保連合会名());
    }

    private void set明細レコード(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileMeisaiEntity meisaiEntity) {
        shoTempentity.setMokuCode(meisaiEntity.get目コード());
        shoTempentity.setMokuName(meisaiEntity.get目名());
        shoTempentity.setServiceShuruiCode(meisaiEntity.getサービス種類コード());
        shoTempentity.setServiceShuruiMei(meisaiEntity.getサービス種類名());
        shoTempentity.setT_Kensu(getDecimal(meisaiEntity.get通常分_件数()));
        shoTempentity.setT_JitsuNissu(getDecimal(meisaiEntity.get通常分_実日数()));
        shoTempentity.setT_Tanisu(getDecimal(meisaiEntity.get通常分_単位数()));
        shoTempentity.setT_Kingaku(getDecimal(meisaiEntity.get通常分_金額()));
        shoTempentity.setS_Kensu(getDecimal(meisaiEntity.get再審査_過誤_件数()));
        shoTempentity.setS_Tanisu(getDecimal(meisaiEntity.get再審査_過誤_単位数()));
        shoTempentity.setS_Choseigaku(getDecimal(meisaiEntity.get再審査_過誤_調整額()));
        shoTempentity.setKaigokyufuSogojigyohi(getDecimal(meisaiEntity.get介護給付費_総合事業費()));
        shoTempentity.setRiyoshaFutangaku(getDecimal(meisaiEntity.get利用者負担額()));
        shoTempentity.setKohiFutangaku(getDecimal(meisaiEntity.get公費負担額()));
    }

    @Override
    protected void afterExecute() {
        if (controlCsvEntity != null && headRecordEntity != null && meisaiEntity != null) {
            合計 = false;
            累計 = false;
            set共通レコード(shoTempentity, controlCsvEntity, headRecordEntity);
            set明細レコード(shoTempentity, meisaiEntity);
            setトレーラレコード1_合計(shoTempentity, toreraRecord1Entity, 合計);
            setトレーラレコード2_累計(shoTempentity, toreraRecord2Entity, 累計);
            setトレーラレコード3_審査支払手数料(shoTempentity, toreraRecord3Entity, 累計);
            請求額通知書一時tableWriter.insert(shoTempentity);
        } else if (controlCsvEntity != null && headRecordEntity != null && meisaiEntity != null
                && toreraRecord1Entity != null && toreraRecord2Entity != null) {
            合計 = true;
            累計 = true;
            set共通レコード(shoTempentity, controlCsvEntity, headRecordEntity);
            set明細レコード(shoTempentity, meisaiEntity);
            setトレーラレコード1_合計(shoTempentity, toreraRecord1Entity, 合計);
            setトレーラレコード2_累計(shoTempentity, toreraRecord2Entity, 累計);
            setトレーラレコード3_審査支払手数料(shoTempentity, toreraRecord3Entity, 累計);
            請求額通知書一時tableWriter.insert(shoTempentity);
        }

        if (null == returnEntity.getShoriYM()) {
            FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(controlCsvEntity.getShoriYM());
            returnEntity.setShoriYM(処理対象年月);
        }
        if (連番 == parameter.getレコード件数合算()) {
            DbWT0002KokuhorenTorikomiErrorTempEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorTempEntity();
            errorTempentity.setエラー区分(NUM);
            一時表Mapper.処理結果リスト一時TBLに登録(errorTempentity);
        }
        returnEntity.set明細データ登録件数(連番);
        flowEntity = new OutputParameter<>();
        flowEntity.setValue(returnEntity);
    }

    private void setトレーラレコード1_合計(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode1Entity toreraRecord1Entity, boolean flag) {
        if (flag) {
            shoTempentity.setGokeiChohyoRecordShubetsu(toreraRecord1Entity.get帳票レコード種別());
            shoTempentity.setT_GokeiKensu(getDecimal(toreraRecord1Entity.get通常分_件数()));
            shoTempentity.setT_GokeiTanisu(getDecimal(toreraRecord1Entity.get通常分_単位数()));
            shoTempentity.setT_GokeiKingaku(getDecimal(toreraRecord1Entity.get通常分_金額()));
            shoTempentity.setS_GokeiKensu(getDecimal(toreraRecord1Entity.get再審査_過誤_件数()));
            shoTempentity.setS_GokeiTanisu(getDecimal(toreraRecord1Entity.get再審査_過誤_単位数()));
            shoTempentity.setS_GokeiChoseigaku(getDecimal(toreraRecord1Entity.get再審査_過誤_調整額()));
            shoTempentity.setGokeiKaigokyufuSogojigyohi(getDecimal(toreraRecord1Entity.get介護給付費_総合事業費()));
            shoTempentity.setGokeiRiyoshaFutangaku(getDecimal(toreraRecord1Entity.get利用者負担額()));
            shoTempentity.setGokeiKohiFutangaku(getDecimal(toreraRecord1Entity.get公費負担額()));
        } else {
            shoTempentity.setGokeiChohyoRecordShubetsu(RString.EMPTY);
            shoTempentity.setT_GokeiKensu(Decimal.ZERO);
            shoTempentity.setT_GokeiTanisu(Decimal.ZERO);
            shoTempentity.setT_GokeiKingaku(Decimal.ZERO);
            shoTempentity.setS_GokeiKensu(Decimal.ZERO);
            shoTempentity.setS_GokeiTanisu(Decimal.ZERO);
            shoTempentity.setS_GokeiChoseigaku(Decimal.ZERO);
            shoTempentity.setGokeiKaigokyufuSogojigyohi(Decimal.ZERO);
            shoTempentity.setGokeiRiyoshaFutangaku(Decimal.ZERO);
            shoTempentity.setGokeiKohiFutangaku(Decimal.ZERO);
        }
    }

    private void setトレーラレコード2_累計(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode2Entity toreraRecord2Entity, boolean flag) {
        if (flag) {
            shoTempentity.setRuisekiChohyoRecordShubetsu(toreraRecord2Entity.get帳票レコード種別());
            shoTempentity.setT_RuisekiKensu(getDecimal(toreraRecord2Entity.get通常分_件数()));
            shoTempentity.setT_RuisekiTanisu(getDecimal(toreraRecord2Entity.get通常分_単位数()));
            shoTempentity.setT_RuisekiKingaku(getDecimal(toreraRecord2Entity.get通常分_金額()));
            shoTempentity.setS_RuisekiKensu(getDecimal(toreraRecord2Entity.get再審査_過誤_件数()));
            shoTempentity.setS_RuisekiTanisu(getDecimal(toreraRecord2Entity.get再審査_過誤_単位数()));
            shoTempentity.setS_RuisekiChoseigaku(getDecimal(toreraRecord2Entity.get再審査_過誤_調整額()));
            shoTempentity.setRuisekiKaigokyufuSogojigyohi(getDecimal(toreraRecord2Entity.get介護給付費_総合事業費()));
            shoTempentity.setRuisekiRiyoshaFutangaku(getDecimal(toreraRecord2Entity.get利用者負担額()));
            shoTempentity.setRuisekiKohiFutangaku(getDecimal(toreraRecord2Entity.get公費負担額()));
        } else {
            shoTempentity.setRuisekiChohyoRecordShubetsu(RString.EMPTY);
            shoTempentity.setT_RuisekiKensu(Decimal.ZERO);
            shoTempentity.setT_RuisekiTanisu(Decimal.ZERO);
            shoTempentity.setT_RuisekiKingaku(Decimal.ZERO);
            shoTempentity.setS_RuisekiKensu(Decimal.ZERO);
            shoTempentity.setS_RuisekiTanisu(Decimal.ZERO);
            shoTempentity.setS_RuisekiChoseigaku(Decimal.ZERO);
            shoTempentity.setRuisekiKaigokyufuSogojigyohi(Decimal.ZERO);
            shoTempentity.setRuisekiRiyoshaFutangaku(Decimal.ZERO);
            shoTempentity.setRuisekiKohiFutangaku(Decimal.ZERO);
        }
    }

    private void setトレーラレコード3_審査支払手数料(DbWT1511SeikyugakuTsuchishoTempEntity shoTempentity,
            SeikyugakuTsuchishoCsvFileToreraRecode3Entity toreraRecord3Entity, boolean flag) {
        if (flag) {
            shoTempentity.setTesuryoChohyoRecordShubetsu(toreraRecord3Entity.get帳票レコード種別());
            shoTempentity.setTesuryoSeikyugaku(getDecimal(toreraRecord3Entity.get請求額()));
            shoTempentity.setTesuiryoRuisekiSeikyugaku(getDecimal(toreraRecord3Entity.get累計請求額()));
        } else {
            shoTempentity.setTesuryoChohyoRecordShubetsu(RString.EMPTY);
            shoTempentity.setTesuryoSeikyugaku(Decimal.ZERO);
            shoTempentity.setTesuiryoRuisekiSeikyugaku(Decimal.ZERO);
        }
    }

    private Decimal getDecimal(RString decimal) {
        if (RString.isNullOrEmpty(decimal)) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }

}
