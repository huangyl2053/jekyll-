/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ShokanRenrakuhyoRecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanrenrakuhyoout.ShokanRenrakuhyoOutManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還連絡票情報作成の送付ファイル作成Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutSofuFileSakuseiProcess extends BatchProcessBase<DbWT2112ShokanMeisaiTempEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get送付ファイルデータ");
    private static final RString ファイル名_前 = new RString("10_211");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString コンマ = new RString(",");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString ファイル管理番号 = new RString("000001");
    private static final RString 囲みの文字 = new RString("\"");
    private static final RString レコード順次番号_99 = new RString("99");
    private static final RString データ区分_01 = new RString("01");
    private static final RString データ区分_02 = new RString("02");
    private static final RString データ区分_03 = new RString("03");
    private static final RString データ区分_04 = new RString("04");
    private static final RString データ区分_05 = new RString("05");
    private static final RString データ区分_06 = new RString("06");
    private static final RString データ区分_07 = new RString("07");
    private static final RString データ区分_08 = new RString("08");
    private static final RString データ区分_09 = new RString("09");
    private static final RString データ区分_10 = new RString("10");
    private static final RString データ区分_11 = new RString("11");
    private static final RString データ区分_12 = new RString("12");
    private static final RString データ区分_13 = new RString("13");
    private static final RString データ区分_14 = new RString("14");
    private static final RString STR_200604 = new RString("200604");
    private static final RString STR_200904 = new RString("200904");
    private static final RString RSTRING_0000 = new RString("0000");
    private static final RString COPY = new RString("copy");
    private static final int INT_100 = 100;
    private static final int INT_10 = 10;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    private ShokanRenrakuhyoOutProcessParameter parameter;
    private ShokanRenrakuhyoOutManager manager;

    private OutputParameter<Integer> outputCount;
    private OutputParameter<RString> outputPath;
    private OutputParameter<RString> inputPath;

    /**
     * 送付ファイルのレコード件数です
     */
    public static final RString PARAMETER_OUT_OUTCOUNT;
    /**
     * inputPathです
     */
    public static final RString INPUT_PATH;
    /**
     * outputPathです
     */
    public static final RString OUTPUT_PATH;

    static {
        PARAMETER_OUT_OUTCOUNT = new RString("outputCount");
        INPUT_PATH = new RString("inputPath");
        OUTPUT_PATH = new RString("outputPath");
    }

    private DbWT2112ShokanMeisaiTempEntity beforeEntity;
    private RString csvFileName;
    private RString csvFilePath;
    private int 総出力件数;
    private int レコード番号;
    private int レコード件数;
    private int レコード順次番号;
    private int 往診日数;
    private int 通院日数;
    private int 緊急時治療管理単位数;
    private int 緊急時治療管理日数;
    private int 緊急時治療管理小計;
    private int リハビリテーション単位数;
    private int 処置単位数;
    private int 手術単位数;
    private int 麻酔単位数;
    private int 放射線治療単位数;
    private int 緊急時施設療養費合計単位数;
    private int 所定疾患施設療養費単位数;
    private int 所定疾患施設療養費日数;
    private int 所定疾患施設療養費小計;
    private int 指導管理料等単位数;
    private int 単純エックス線単位数;
    private int 精神科専門療法単位数;
    private int 合計単位数;
    private int 費用額合計;
    private int 保険分請求額合計;
    private int 利用者負担額合計;
    private int サービス単位数合計;
    private int 請求金額;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private JigyoshaNo 事業者番号;
    private RString 様式番号;
    private RString 明細番号;
    private RString 入力ファイルパス;

    @BatchWriter
    private CsvListWriter csvWriter;

    @Override
    protected void initialize() {
        総出力件数 = INDEX_0;
        レコード番号 = INDEX_0;
        レコード順次番号 = INDEX_1;
        outputCount = new OutputParameter<>();
        inputPath = new OutputParameter<>();
        outputPath = new OutputParameter<>();
        manager = ShokanRenrakuhyoOutManager.createInstance();
        レコード件数 = manager.getレコード件数(parameter.toSofuMeisaiParameter());
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        csvFileName = ファイル名_前.concat(parameter.get保険者番号().getColumnValue()).
                concat(parameter.get処理年月().toDateString()).concat(ファイル名_後);
        csvFilePath = Path.combinePath(spoolWorkPath, csvFileName);
        if (Encode.UTF_8.equals(parameter.get文字コード())) {
            入力ファイルパス = Path.combinePath(spoolWorkPath, COPY.concat(csvFileName));
        } else {
            入力ファイルパス = csvFilePath;
        }
        csvWriter = new CsvListWriter.InstanceBuilder(入力ファイルパス).
                setDelimiter(コンマ).
                setEnclosure(RString.EMPTY).
                setEncode(parameter.get文字コード()).
                hasHeader(false).
                setNewLine(NewLine.CRLF).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH, parameter.toSofuMeisaiParameter());
    }

    @Override
    protected void process(DbWT2112ShokanMeisaiTempEntity entity) {
        if (レコード番号 == INDEX_0) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getControlEntity());
        }
        boolean lastFlag = true;
        if (データ区分_01.equals(entity.getDataKubun())) {
            if (beforeEntity == null) {
                レコード番号 = レコード番号 + INDEX_1;
                csvWriter.writeLine(getHeadEntity(entity));
                総出力件数 = 総出力件数 + INDEX_1;
            } else if (!beforeEntity.getHiHokenshaNo().equals(entity.getHiHokenshaNo())
                    || !beforeEntity.getServiceTeikyoYM().equals(entity.getServiceTeikyoYM())
                    || !beforeEntity.getSeiriNo().equals(entity.getSeiriNo())) {
                addEntityWriter(beforeEntity, lastFlag);
                レコード番号 = レコード番号 + INDEX_1;
                csvWriter.writeLine(getHeadEntity(entity));
                総出力件数 = 総出力件数 + INDEX_1;
            } else {
                addEntityWriter(beforeEntity, lastFlag);
            }
            beforeEntity = entity;
            被保険者番号 = entity.getHiHokenshaNo();
            サービス提供年月 = entity.getServiceTeikyoYM();
            整理番号 = entity.getSeiriNo();
            事業者番号 = entity.getJigyoshaNo();
            様式番号 = entity.getYoshikiNo();
            明細番号 = entity.getMeisaiNo();
        } else {
            if (beforeEntity != null && entity.getDataKubun() != null) {
                lastFlag = !entity.getDataKubun().equals(beforeEntity.getDataKubun());
                addEntityWriter(beforeEntity, lastFlag);
                beforeEntity = entity;
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (総出力件数 != INDEX_0) {
            addEntityWriter(beforeEntity, true);
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getEndEntity());
        }
        if (csvWriter != null) {
            csvWriter.close();
        }
        outputCount.setValue(総出力件数);
        inputPath.setValue(入力ファイルパス);
        outputPath.setValue(csvFilePath);
    }

    private void addEntityWriter(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        if (is償還明細キー(entity)) {
            addMeisaiEntityWriter(entity, lastFlag);
        }
    }

    private boolean is償還明細キー(DbWT2112ShokanMeisaiTempEntity entity) {
        if (被保険者番号 == null || サービス提供年月 == null || 整理番号 == null || 事業者番号 == null
                || 様式番号 == null || 明細番号 == null) {
            return false;
        } else if (被保険者番号.equals(entity.getHiHokenshaNo()) && サービス提供年月.equals(entity.getServiceTeikyoYM())
                && 整理番号.equals(entity.getSeiriNo()) && 事業者番号.equals(entity.getJigyoshaNo())
                && 様式番号.equals(entity.getYoshikiNo()) && 明細番号.equals(entity.getMeisaiNo())) {
            return true;
        }
        return false;
    }

    private void addMeisaiEntityWriter(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        if (データ区分_01.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getKihonTempEntity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_02.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getMeisaiEntity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_03.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getJutokuEntity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_04.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getShisetsuEntity(entity, lastFlag));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_05.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getShoteiEntity(entity, lastFlag));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_06.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get特定診療Entity(entity, lastFlag));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_07.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get特別療養Entity(entity, lastFlag));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_08.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getShokujiEntity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_09.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            if (entity.getServiceTeikyoYM().toDateString().compareTo(STR_200604) < 0) {
                csvWriter.writeLine(get計画200004(entity));
            } else if (entity.getServiceTeikyoYM().toDateString().compareTo(STR_200904) < 0) {
                csvWriter.writeLine(get計画200604(entity));
            } else {
                csvWriter.writeLine(get計画200904(entity, lastFlag));
            }
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_10.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get福祉Entity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_11.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get住宅Entity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_12.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get集計Entity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_13.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get入所Entity(entity, lastFlag));
            総出力件数 = 総出力件数 + INDEX_1;
        } else if (データ区分_14.equals(entity.getDataKubun())) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(get社福Entity(entity));
            総出力件数 = 総出力件数 + INDEX_1;
        }

    }

    private List<RString> getControlEntity() {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.コントロールレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(RSTRING_0);
        tempList.add(new RString(レコード件数));
        tempList.add(ConfigKeysKokuhorenSofu.償還連絡票情報.getコード());
        tempList.add(RSTRING_00);
        tempList.add(parameter.get保険者番号().getColumnValue());
        tempList.add(RString.EMPTY);
        tempList.add(RSTRING_00);
        tempList.add(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_償還Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        tempList.add(parameter.get処理年月().toDateString());
        tempList.add(ファイル管理番号);
        return tempList;
    }

    private List<RString> getEndEntity() {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.エンドレコード.getコード());
        tempList.add(new RString(レコード番号));
        return tempList;
    }

    private List<RString> getHeadEntity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(KokuhorenSofuKokanJohoShikibetsuBango.償還連絡票情報.getコード());
        tempList.add(ShokanRenrakuhyoRecordShubetsu.基本情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getDbwt2111_serviceTeikyoYM()));
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getDbwt2111_seiriNo()));
        tempList.add(trimDate(entity.getShinseiYMD()));
        tempList.add(trimDate(entity.getSeinenYmd()));
        tempList.add(trimRString(entity.getSeibetsuCode()));
        tempList.add(trimRString(entity.getYokaigoJotaiKubunCode()));
        tempList.add(trimDate(entity.getNinteiYukoKikanKaishiYMD()));
        tempList.add(trimDate(entity.getNinteiYukoKikanShuryoYMD()));
        tempList.add(ShiharaiHohoKubun.口座払.getコード());
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(trimDecimal(entity.getHokenKyufugaku()));
        tempList.add(trimDecimal(entity.getDbwt2111_riyoshaFutangaku()));
        return tempList;
    }

    private List<RString> getKihonTempEntity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.基本情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(trimRString(entity.getKyuSochiNyushoshaTokureiCode()));
        tempList.add(trimRString(entity.getKyotakuServiceSakuseiKubunCode()));
        tempList.add(entity.getKyotakuserviceJigyoshaNo() == null || entity.getKyotakuserviceJigyoshaNo().isEmpty()
                ? RString.EMPTY : entity.getKyotakuserviceJigyoshaNo().getColumnValue().trim());
        tempList.add(trimDate(entity.getKaishiYMD()));
        tempList.add(trimDate(entity.getChushiYMD()));
        tempList.add(trimRString(entity.getChushiRiyuNyushomaeJyokyoCode()));
        tempList.add(trimDate(entity.getNyushoYMD()));
        tempList.add(trimDate(entity.getTaishoYMD()));
        tempList.add(new RString(entity.getNyushoJitsuNissu()));
        tempList.add(new RString(entity.getGaihakuNissu()));
        tempList.add(trimRString(entity.getTaishogoJotaiCode()));
        tempList.add(trimKyufuritsu(entity.getHokenKyufuritsu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getServiceTanisu()));
        tempList.add(trimDecimal(entity.getHokenSeikyugaku()));
        tempList.add(new RString(entity.getRiyoshaFutangaku()));
        tempList.add(trimDecimal(entity.getKinkyuShisetsuRyoyoSeikyugaku()));
        tempList.add(trimDecimal(entity.getTokuteiShinryoSeikyugaku()));
        tempList.add(new RString(entity.getTokuteiNyushoshaKaigoServiceSeikyugaku()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        return tempList;
    }

    private List<RString> getMeisaiEntity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.明細情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(entity.getServiceShuruiCode() == null || entity.getServiceShuruiCode().isEmpty()
                ? RString.EMPTY : entity.getServiceShuruiCode().getColumnValue().trim());
        tempList.add(entity.getServiceKomokuCode() == null || entity.getServiceKomokuCode().isEmpty()
                ? RString.EMPTY : entity.getServiceKomokuCode().getColumnValue().trim());
        tempList.add(new RString(entity.getTanisu()));
        tempList.add(new RString(entity.getNissuKaisu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getServiceTanisu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(囲み文字(trimRString(entity.getTekiyo())));
        return tempList;
    }

    private List<RString> getJutokuEntity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.明細情報_住所地特例レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(entity.getServiceShuruiCode() == null || entity.getServiceShuruiCode().isEmpty()
                ? RString.EMPTY : entity.getServiceShuruiCode().getColumnValue().trim());
        tempList.add(entity.getServiceKomokuCode() == null || entity.getServiceKomokuCode().isEmpty()
                ? RString.EMPTY : entity.getServiceKomokuCode().getColumnValue().trim());
        tempList.add(new RString(entity.getTanisu()));
        tempList.add(new RString(entity.getNissuKaisu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getServiceTanisu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(entity.getShisetsuShozaiHokenshaNo() == null || entity.getShisetsuShozaiHokenshaNo().isEmpty()
                ? RString.EMPTY : entity.getShisetsuShozaiHokenshaNo().getColumnValue().trim());
        tempList.add(囲み文字(trimRString(entity.getTekiyo())));
        return tempList;
    }

    private List<RString> getShisetsuEntity(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.緊急時施設療養情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        if (lastFlag) {
            tempList.add(レコード順次番号_99);
        } else {
            tempList.add(new RString(レコード順次番号).padZeroToLeft(INT_2));
        }
        tempList.add(囲み文字(trimRString(entity.getKinkyuShobyoName1())));
        tempList.add(囲み文字(trimRString(entity.getKinkyuShobyoName2())));
        tempList.add(囲み文字(trimRString(entity.getKinkyuShobyoName3())));
        tempList.add(trimDate(entity.getKinkyuChiryoKaishiYMD1()));
        tempList.add(trimDate(entity.getKinkyuChiryoKaishiYMD2()));
        tempList.add(trimDate(entity.getKinkyuChiryoKaishiYMD3()));
        if (lastFlag) {
            tempList.add(new RString(entity.getOshinNissu() + 往診日数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getOshinIryoKikanName())));
        if (lastFlag) {
            tempList.add(new RString(entity.getTsuinNissu() + 通院日数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getTsuinKikanName())));
        if (lastFlag) {
            tempList.add(new RString(entity.getKinkyuChiryoKanriTanisu() + 緊急時治療管理単位数));
            tempList.add(new RString(entity.getKinkyuChiryoKanriNissu() + 緊急時治療管理日数));
            tempList.add(new RString(entity.getKinkyuChiryoKanriSubTotal() + 緊急時治療管理小計));
            tempList.add(new RString(entity.getRehabilitationTanisu() + リハビリテーション単位数));
            tempList.add(new RString(entity.getShochiTanisu() + 処置単位数));
            tempList.add(new RString(entity.getShujutsuTanisu() + 手術単位数));
            tempList.add(new RString(entity.getMasuiTanisu() + 麻酔単位数));
            tempList.add(new RString(entity.getHoshasenChiryoTanisu() + 放射線治療単位数));
        } else {
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getTekiyo1())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo2())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo3())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo4())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo5())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo6())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo7())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo8())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo9())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo10())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo11())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo12())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo13())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo14())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo15())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo16())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo17())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo18())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo19())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo20())));
        tempList.add(new RString(entity.getKinkyuShisetsuRyoyohiTotalTanisu()));
        if (lastFlag) {
            clearShukeiKomoku();
            レコード順次番号 = INDEX_1;
        } else {
            往診日数 = 往診日数 + entity.getOshinNissu();
            通院日数 = 通院日数 + entity.getTsuinNissu();
            緊急時治療管理単位数 = 緊急時治療管理単位数 + entity.getKinkyuChiryoKanriTanisu();
            緊急時治療管理日数 = 緊急時治療管理日数 + entity.getKinkyuChiryoKanriNissu();
            緊急時治療管理小計 = 緊急時治療管理小計 + entity.getKinkyuChiryoKanriSubTotal();
            リハビリテーション単位数 = リハビリテーション単位数 + entity.getRehabilitationTanisu();
            処置単位数 = 処置単位数 + entity.getShochiTanisu();
            手術単位数 = 手術単位数 + entity.getShujutsuTanisu();
            麻酔単位数 = 麻酔単位数 + entity.getMasuiTanisu();
            放射線治療単位数 = 放射線治療単位数 + entity.getHoshasenChiryoTanisu();
            レコード順次番号 = レコード順次番号 + INDEX_1;
        }
        return tempList;
    }

    private List<RString> getShoteiEntity(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.所定疾患施設療養費等情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getDbwt2111_seiriNo()));
        if (lastFlag) {
            tempList.add(レコード順次番号_99);
        } else {
            tempList.add(new RString(レコード順次番号).padZeroToLeft(INT_2));
        }
        tempList.add(囲み文字(trimRString(entity.getKinkyuShobyoName1())));
        tempList.add(囲み文字(trimRString(entity.getKinkyuShobyoName2())));
        tempList.add(囲み文字(trimRString(entity.getKinkyuShobyoName3())));
        tempList.add(trimDate(entity.getKinkyuChiryoKaishiYMD1()));
        tempList.add(trimDate(entity.getKinkyuChiryoKaishiYMD2()));
        tempList.add(trimDate(entity.getKinkyuChiryoKaishiYMD3()));
        if (lastFlag) {
            tempList.add(new RString(entity.getOshinNissu() + 往診日数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getOshinIryoKikanName())));
        if (lastFlag) {
            tempList.add(new RString(entity.getTsuinNissu() + 通院日数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getTsuinKikanName())));
        if (lastFlag) {
            tempList.add(new RString(entity.getKinkyuChiryoKanriTanisu() + 緊急時治療管理単位数));
            tempList.add(new RString(entity.getKinkyuChiryoKanriNissu() + 緊急時治療管理日数));
            tempList.add(new RString(entity.getKinkyuChiryoKanriSubTotal() + 緊急時治療管理小計));
            tempList.add(new RString(entity.getRehabilitationTanisu() + リハビリテーション単位数));
            tempList.add(new RString(entity.getShochiTanisu() + 処置単位数));
            tempList.add(new RString(entity.getShujutsuTanisu() + 手術単位数));
            tempList.add(new RString(entity.getMasuiTanisu() + 麻酔単位数));
            tempList.add(new RString(entity.getHoshasenChiryoTanisu() + 放射線治療単位数));
        } else {
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getTekiyo1())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo2())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo3())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo4())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo5())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo6())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo7())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo8())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo9())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo10())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo11())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo12())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo13())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo14())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo15())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo16())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo17())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo18())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo19())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo20())));
        if (lastFlag) {
            tempList.add(new RString(entity.getKinkyuShisetsuRyoyohiTotalTanisu() + 緊急時施設療養費合計単位数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(囲み文字(trimRString(entity.getShoteiShikkanShobyoName1())));
        tempList.add(囲み文字(trimRString(entity.getShoteiShikkanShobyoName2())));
        tempList.add(囲み文字(trimRString(entity.getShoteiShikkanShobyoName3())));
        tempList.add(trimDate(entity.getShoteiShikkanShobyoKaishiYMD1()));
        tempList.add(trimDate(entity.getShoteiShikkanShobyoKaishiYMD2()));
        tempList.add(trimDate(entity.getShoteiShikkanShobyoKaishiYMD3()));
        if (lastFlag) {
            tempList.add(new RString(entity.getShoteiShikkanTanisu() + 所定疾患施設療養費単位数));
            tempList.add(new RString(entity.getShoteiShikkanNissu() + 所定疾患施設療養費日数));
            tempList.add(new RString(entity.getShoteiShikkanSubTotal() + 所定疾患施設療養費小計));
            レコード順次番号 = INDEX_1;
            clearShukeiKomoku();
        } else {
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            往診日数 = 往診日数 + entity.getOshinNissu();
            通院日数 = 通院日数 + entity.getTsuinNissu();
            緊急時施設療養費合計単位数 = 緊急時施設療養費合計単位数 + entity.getKinkyuShisetsuRyoyohiTotalTanisu();
            緊急時治療管理単位数 = 緊急時治療管理単位数 + entity.getKinkyuChiryoKanriTanisu();
            緊急時治療管理日数 = 緊急時治療管理日数 + entity.getKinkyuChiryoKanriNissu();
            緊急時治療管理小計 = 緊急時治療管理小計 + entity.getKinkyuChiryoKanriSubTotal();
            リハビリテーション単位数 = リハビリテーション単位数 + entity.getRehabilitationTanisu();
            処置単位数 = 処置単位数 + entity.getShochiTanisu();
            手術単位数 = 手術単位数 + entity.getShujutsuTanisu();
            麻酔単位数 = 麻酔単位数 + entity.getMasuiTanisu();
            放射線治療単位数 = 放射線治療単位数 + entity.getHoshasenChiryoTanisu();
            所定疾患施設療養費単位数 = 所定疾患施設療養費単位数 + entity.getShoteiShikkanTanisu();
            所定疾患施設療養費日数 = 所定疾患施設療養費日数 + entity.getShoteiShikkanNissu();
            所定疾患施設療養費小計 = 所定疾患施設療養費小計 + entity.getShoteiShikkanSubTotal();
            レコード順次番号 = レコード順次番号 + INDEX_1;
        }
        return tempList;
    }

    private List<RString> get特定診療Entity(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.特定診療費_特別療養費情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        if (lastFlag) {
            tempList.add(レコード順次番号_99);
        } else {
            tempList.add(new RString(レコード順次番号).padZeroToLeft(INT_2));
        }
        tempList.add(囲み文字(trimRString(entity.getShobyoName())));
        if (lastFlag) {
            tempList.add(new RString(entity.getShidoKanriryoTanisu() + 指導管理料等単位数));
            tempList.add(new RString(entity.getTanjunXsenTanisu() + 単純エックス線単位数));
            tempList.add(new RString(entity.getRehabilitationTanisu() + リハビリテーション単位数));
            tempList.add(new RString(entity.getSeishinkaSemmonRyoyohouTanisu() + 精神科専門療法単位数));
        } else {
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
        }
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        if (lastFlag) {
            tempList.add(new RString(entity.getTotalTanisu() + 合計単位数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(囲み文字(trimRString(entity.getTekiyo1())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo2())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo3())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo4())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo5())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo6())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo7())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo8())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo9())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo10())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo11())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo12())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo13())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo14())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo15())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo16())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo17())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo18())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo19())));
        tempList.add(囲み文字(trimRString(entity.getTekiyo20())));
        if (lastFlag) {
            clearShukeiKomoku();
            レコード順次番号 = INDEX_1;
        } else {
            指導管理料等単位数 = 指導管理料等単位数 + entity.getShidoKanriryoTanisu();
            単純エックス線単位数 = 単純エックス線単位数 + entity.getTanjunXsenTanisu();
            リハビリテーション単位数 = リハビリテーション単位数 + entity.getRehabilitationTanisu();
            精神科専門療法単位数 = 精神科専門療法単位数 + entity.getSeishinkaSemmonRyoyohouTanisu();
            合計単位数 = 合計単位数 + entity.getTotalTanisu();
            レコード順次番号 = レコード順次番号 + INDEX_1;
        }
        return tempList;
    }

    private List<RString> get特別療養Entity(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.特定診療費_特別療養費情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        if (lastFlag) {
            tempList.add(レコード順次番号_99);
        } else {
            tempList.add(new RString(レコード順次番号).padZeroToLeft(INT_2));
        }
        tempList.add(囲み文字(trimRString(entity.getShobyoName())));
        tempList.add(trimRString(entity.getShikibetsuNo()));
        tempList.add(new RString(entity.getTanisu()));
        tempList.add(new RString(entity.getKaisu()));
        tempList.add(new RString(entity.getServiceTanisu()));
        if (lastFlag) {
            tempList.add(new RString(entity.getTotalTanisu() + 合計単位数));
        } else {
            tempList.add(RSTRING_0);
        }
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(囲み文字(trimRString(entity.getTekiyo())));
        if (lastFlag) {
            clearShukeiKomoku();
            レコード順次番号 = INDEX_1;
        } else {
            合計単位数 = 合計単位数 + entity.getTotalTanisu();
            レコード順次番号 = レコード順次番号 + INDEX_1;
        }
        return tempList;
    }

    private List<RString> getShokujiEntity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.食事費用情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(new RString(entity.getKihonTeikyoNissu()));
        tempList.add(new RString(entity.getKihonTeikyoTanka()));
        tempList.add(new RString(entity.getKihonTeikyoKingaku()));
        tempList.add(new RString(entity.getTokubetsuTeikyoNissu()));
        tempList.add(new RString(entity.getTokubetsuTeikyoTanka()));
        tempList.add(new RString(entity.getTokubetsuTeikyoKingaku()));
        tempList.add(new RString(entity.getShokujiTeikyoTotalNissu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getShokujiTeikyohiTotal()));
        tempList.add(new RString(entity.getGetsugakuHyojunFutangaku()));
        tempList.add(new RString(entity.getShokujiTeikyohiSeikyugaku()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getNichigakuHyojunFutangaku()));
        return tempList;
    }

    private List<RString> get計画200004(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.サービス計画情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(trimRString(entity.getShiteiKijunGaitoJigyoshaKubunCode()));
        tempList.add(trimDate(entity.getKyotakuServiceSakuseiIraiYMD()));
        tempList.add(entity.getServiceCode() == null || entity.getServiceCode().isEmpty()
                ? RString.EMPTY : entity.getServiceCode().getColumnValue().trim());
        tempList.add(new RString(entity.getTanisu()));
        RString 単位数単価;
        if (entity.getTanisuTanka() == null) {
            単位数単価 = RString.EMPTY;
        } else {
            単位数単価 = entity.getTanisuTanka().compareTo(Decimal.ZERO) == 0 ? RSTRING_0000
                    : DecimalFormatter.toRString(entity.getTanisuTanka().multiply(INT_100), 0).padZeroToLeft(INT_4);
        }
        tempList.add(単位数単価);
        tempList.add(new RString(entity.getSeikyuKingaku()));
        tempList.add(trimRString(entity.getShinsaHohoKubunCode()));
        return tempList;
    }

    private List<RString> get計画200604(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.サービス計画情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(trimRString(entity.getShiteiKijunGaitoJigyoshaKubunCode()));
        tempList.add(trimDate(entity.getKyotakuServiceSakuseiIraiYMD()));
        tempList.add(entity.getServiceCode() == null || entity.getServiceCode().isEmpty()
                ? RString.EMPTY : entity.getServiceCode().getColumnValue().trim());
        tempList.add(new RString(entity.getTanisu()));
        RString 単位数単価;
        if (entity.getTanisuTanka() == null) {
            単位数単価 = RString.EMPTY;
        } else {
            単位数単価 = entity.getTanisuTanka().compareTo(Decimal.ZERO) == 0 ? RSTRING_0000
                    : DecimalFormatter.toRString(entity.getTanisuTanka().multiply(INT_100), 0).padZeroToLeft(INT_4);
        }
        tempList.add(単位数単価);
        tempList.add(new RString(entity.getSeikyuKingaku()));
        tempList.add(trimRString(entity.getTantokangoshienSemmoninNo()));
        tempList.add(囲み文字(trimRString(entity.getTekiyo())));
        tempList.add(trimRString(entity.getShinsaHohoKubunCode()));
        return tempList;
    }

    private List<RString> get計画200904(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.サービス計画情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(trimRString(entity.getShiteiKijunGaitoJigyoshaKubunCode()));
        tempList.add(trimDate(entity.getKyotakuServiceSakuseiIraiYMD()));
        if (lastFlag) {
            tempList.add(レコード順次番号_99);
        } else {
            tempList.add(new RString(レコード順次番号).padZeroToLeft(INT_2));
        }
        tempList.add(entity.getServiceCode() == null || entity.getServiceCode().isEmpty()
                ? RString.EMPTY : entity.getServiceCode().getColumnValue().trim());
        tempList.add(new RString(entity.getTanisu()));
        tempList.add(new RString(entity.getKaisu()));
        tempList.add(new RString(entity.getServiceTanisu()));
        RString 単位数単価;
        if (entity.getTanisuTanka() == null) {
            単位数単価 = RString.EMPTY;
        } else {
            単位数単価 = entity.getTanisuTanka().compareTo(Decimal.ZERO) == 0 ? RSTRING_0000
                    : DecimalFormatter.toRString(entity.getTanisuTanka().multiply(INT_100), 0).padZeroToLeft(INT_4);
        }
        tempList.add(単位数単価);
        if (lastFlag) {
            tempList.add(new RString(entity.getServiceTanisuTotal() + サービス単位数合計));
            tempList.add(new RString(entity.getSeikyuKingaku() + 請求金額));
        } else {
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
        }
        tempList.add(trimRString(entity.getTantokangoshienSemmoninNo()));
        tempList.add(囲み文字(trimRString(entity.getTekiyo())));
        tempList.add(trimRString(entity.getShinsaHohoKubunCode()));
        if (lastFlag) {
            clearShukeiKomoku();
            レコード順次番号 = INDEX_1;
        } else {
            サービス単位数合計 = サービス単位数合計 + entity.getServiceTanisuTotal();
            請求金額 = 請求金額 + entity.getSeikyuKingaku();
            レコード順次番号 = レコード順次番号 + INDEX_1;
        }
        return tempList;
    }

    private List<RString> get福祉Entity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.福祉用具販売費情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(entity.getServiceCode() == null || entity.getServiceCode().isEmpty()
                ? RString.EMPTY : entity.getServiceCode().getColumnValue().trim());
        tempList.add(trimDate(entity.getFukushiYoguHanbaiYMD()));
        tempList.add(囲み文字(trimRString(entity.getFukushiYoguShohinName())));
        tempList.add(trimRString(entity.getFukushiYoguShumokuCode()));
        tempList.add(囲み文字(trimRString(entity.getFukushiYoguSeizoJigyoshaName())));
        tempList.add(囲み文字(trimRString(entity.getFukushiYoguHanbaiJigyoshaName())));
        tempList.add(new RString(entity.getKounyuKingaku()));
        tempList.add(囲み文字(trimRString(entity.getHinmokuCode())));
        tempList.add(trimRString(entity.getShinsaHohoKubunCode()));

        return tempList;
    }

    private List<RString> get住宅Entity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.住宅改修費情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(entity.getServiceCode() == null || entity.getServiceCode().isEmpty()
                ? RString.EMPTY : entity.getServiceCode().getColumnValue().trim());
        tempList.add(trimDate(entity.getJutakuKaishuChakkoYMD()));
        tempList.add(囲み文字(trimRString(entity.getJutakuKaishuJigyoshaName())));
        tempList.add(囲み文字(trimRString(entity.getJutakuKaishuJutakuAddress())));
        tempList.add(new RString(entity.getKaishuKingaku()));
        tempList.add(trimRString(entity.getShinsaHohoKubunCode()));
        return tempList;
    }

    private List<RString> get集計Entity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.集計情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        tempList.add(entity.getServiceShuruiCode() == null || entity.getServiceShuruiCode().isEmpty()
                ? RString.EMPTY : entity.getServiceShuruiCode().getColumnValue().trim());
        tempList.add(new RString(entity.getServiceJitsunissu()));
        tempList.add(new RString(entity.getPlanTanisu()));
        tempList.add(new RString(entity.getGendogakuKanriTaishoTanisu()));
        tempList.add(new RString(entity.getGendogakuKanriTaishogaiTanisu()));
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getTankiNyushoJitsunissu()));
        tempList.add(new RString(entity.getTanisuTotal()));
        RString 単位数単価;
        if (entity.getTanisuTanka() == null) {
            単位数単価 = RString.EMPTY;
        } else {
            単位数単価 = entity.getTanisuTanka().compareTo(Decimal.ZERO) == 0 ? RSTRING_0000
                    : DecimalFormatter.toRString(entity.getTanisuTanka().multiply(INT_100), 0).padZeroToLeft(INT_4);
        }
        tempList.add(単位数単価);
        tempList.add(trimDecimal(entity.getSeikyugaku()));
        tempList.add(new RString(entity.getRiyoshaFutangaku()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getDekidakaIryohiTanisuTotal()));
        tempList.add(trimDecimal(entity.getDekidakaIryohiSeikyugaku()));
        tempList.add(trimDecimal(entity.getDekidakaIryohiRiyoshaFutangaku()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(trimRString(entity.getShinsaHohoKubunCode()));
        return tempList;
    }

    private List<RString> get入所Entity(DbWT2112ShokanMeisaiTempEntity entity, boolean lastFlag) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.特定入所者介護サービス費用情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        if (lastFlag) {
            tempList.add(レコード順次番号_99);
        } else {
            tempList.add(new RString(レコード順次番号).padZeroToLeft(INT_2));
        }
        tempList.add(entity.getServiceShuruiCode() == null || entity.getServiceShuruiCode().isEmpty()
                ? RString.EMPTY : entity.getServiceShuruiCode().getColumnValue().trim());
        tempList.add(entity.getServiceKomokuCode() == null || entity.getServiceKomokuCode().isEmpty()
                ? RString.EMPTY : entity.getServiceKomokuCode().getColumnValue().trim());
        tempList.add(new RString(entity.getHiyoTanka()));
        tempList.add(new RString(entity.getFutanGendogaku()));
        tempList.add(new RString(entity.getNissu()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getHiyogaku()));
        tempList.add(new RString(entity.getHokenbunSeikyugaku()));
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(new RString(entity.getRiyoshaFutangaku()));
        if (lastFlag) {
            tempList.add(new RString(entity.getHiyogakuTotal() + 費用額合計));
            tempList.add(new RString(entity.getHokenbunSeikyugakuTotal() + 保険分請求額合計));
            tempList.add(new RString(entity.getRiyoshaFutangakuTotal() + 利用者負担額合計));
        } else {
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
            tempList.add(RSTRING_0);
        }
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        tempList.add(RString.EMPTY);
        if (lastFlag) {
            clearShukeiKomoku();
            レコード順次番号 = INDEX_1;
        } else {
            費用額合計 = 費用額合計 + entity.getHiyogakuTotal();
            保険分請求額合計 = 保険分請求額合計 + entity.getHokenbunSeikyugakuTotal();
            利用者負担額合計 = 利用者負担額合計 + entity.getRiyoshaFutangakuTotal();
            レコード順次番号 = レコード順次番号 + INDEX_1;
        }
        return tempList;
    }

    private List<RString> get社福Entity(DbWT2112ShokanMeisaiTempEntity entity) {
        List<RString> tempList = new ArrayList<>();
        tempList.add(RecordShubetsu.データレコード.getコード());
        tempList.add(new RString(レコード番号));
        tempList.add(trimRString(entity.getYoshikiNo()));
        tempList.add(ShokanRenrakuhyoRecordShubetsu.社会福祉法人軽減額情報レコード.getコード());
        tempList.add(trimYearMonth(entity.getServiceTeikyoYM()));
        tempList.add(entity.getJigyoshaNo().getColumnValue().trim());
        tempList.add(entity.getShoKisaiHokenshaNo().getColumnValue().trim());
        tempList.add(entity.getSofuHihokenshaNo().getColumnValue().trim());
        tempList.add(trimRString(entity.getSeiriNo()));
        RString 軽減率;
        if (entity.getKeigenritsu() == null) {
            軽減率 = RString.EMPTY;
        } else {
            軽減率 = entity.getKeigenritsu().compareTo(Decimal.ZERO) == 0 ? RSTRING_0000
                    : DecimalFormatter.toRString(entity.getKeigenritsu().multiply(INT_10), 0).padZeroToLeft(INT_4);
        }
        tempList.add(軽減率);
        tempList.add(entity.getServiceShuruiCode() == null || entity.getServiceShuruiCode().isEmpty()
                ? RString.EMPTY : entity.getServiceShuruiCode().getColumnValue().trim());
        tempList.add(new RString(entity.getRiyoshaFutangakuTotal()));
        tempList.add(new RString(entity.getKeigengaku()));
        tempList.add(new RString(entity.getKeigengoRiyoshaFutangaku()));
        tempList.add(囲み文字(trimRString(entity.getBiko())));
        return tempList;
    }

    private void clearShukeiKomoku() {
        往診日数 = INDEX_0;
        通院日数 = INDEX_0;
        緊急時治療管理単位数 = INDEX_0;
        緊急時治療管理日数 = INDEX_0;
        緊急時治療管理小計 = INDEX_0;
        リハビリテーション単位数 = INDEX_0;
        処置単位数 = INDEX_0;
        手術単位数 = INDEX_0;
        麻酔単位数 = INDEX_0;
        放射線治療単位数 = INDEX_0;
        緊急時施設療養費合計単位数 = INDEX_0;
        所定疾患施設療養費単位数 = INDEX_0;
        所定疾患施設療養費日数 = INDEX_0;
        所定疾患施設療養費小計 = INDEX_0;
        指導管理料等単位数 = INDEX_0;
        単純エックス線単位数 = INDEX_0;
        精神科専門療法単位数 = INDEX_0;
        合計単位数 = INDEX_0;
        費用額合計 = INDEX_0;
        保険分請求額合計 = INDEX_0;
        利用者負担額合計 = INDEX_0;
        サービス単位数合計 = INDEX_0;
        請求金額 = INDEX_0;
    }

    private RString trimYearMonth(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.toDateString();
    }

    private RString trimDate(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.seireki().separator(Separator.NONE).toDateString();
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString trimDecimal(Decimal dec) {
        return dec == null ? RString.EMPTY : new RString(dec.toString());
    }

    private RString trimKyufuritsu(HokenKyufuRitsu ritsu) {
        return ritsu == null ? RString.EMPTY : trimDecimal(ritsu.getColumnValue());
    }

    private RString 囲み文字(RString str) {
        return 囲みの文字.concat(str).concat(囲みの文字);
    }

}
