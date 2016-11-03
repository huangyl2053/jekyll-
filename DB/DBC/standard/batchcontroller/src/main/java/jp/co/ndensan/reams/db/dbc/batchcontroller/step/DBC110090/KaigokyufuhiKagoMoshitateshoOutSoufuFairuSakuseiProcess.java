/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110090;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090.KaigokyufuhiKagoMoshitateshoSoufuFairuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomoshitateshoout.SoufuFairuSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成の送付ファイル作成Processクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiProcess extends BatchProcessBase<KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomoshitateshoout."
            + "IKaigokyufuhiKagoMoshitateshoOutMapper.select送付ファイル");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString ファイル名_前 = new RString("10_");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_000 = new RString("000");
    private static final RString RSTRING_0000000000 = new RString("0000000000");
    private static final RString RSTRING_000001 = new RString("000001");
    private static final RString COPY = new RString("copy");

    /**
     * 総出力件数カウンターです。
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;
    /**
     * inputPathです。
     */
    public static final RString INPUT_PATH;
    /**
     * outputPathです。
     */
    public static final RString OUTPUT_PATH;

    static {
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
        INPUT_PATH = new RString("inputPath");
        OUTPUT_PATH = new RString("outputPath");
    }

    private OutputParameter<Integer> outputCount;
    private KaigokyufuhiKagoMoshitateshoSoufuFairuSakuseiProcessParameter processParameter;
    private SoufuFairuSakuseiMybatisParameter mybatisParameter;
    private int 総出力件数;
    private int レコード番号;
    private BatchDbReader reader;
    private RString eucFilePath;
    private RString 出力ファイル名;
    private RString データ種別;
    private RString 媒体区分;
    private RString 交換情報識別番号;

    private final RString コード_173 = new RString("173");
    private final RString コード_176 = new RString("176");
    private final RString コード_179 = new RString("179");

    private CsvWriter eucCsvWriter;
    private OutputParameter<RString> inputPath;
    private OutputParameter<RString> outputPath;
    private RString 入力ファイルパス;

    @Override
    protected void initialize() {
        outputCount = new OutputParameter<>();
        inputPath = new OutputParameter<>();
        outputPath = new OutputParameter<>();
        入力ファイルパス = RString.EMPTY;
        mybatisParameter = new SoufuFairuSakuseiMybatisParameter();
        mybatisParameter.set保険者番号(processParameter.get保険者番号());

        総出力件数 = INT_0;
        レコード番号 = INT_1;

        if (コード_173.equals(processParameter.getコード())) {
            出力ファイル名 = ファイル名_前.concat(コード_173).concat(processParameter.get保険者番号().getColumnValue())
                    .concat(processParameter.get処理年月().toDateString()).concat(ファイル名_後);
            this.データ種別 = ConfigKeysKokuhorenSofu.過誤申立書情報.getコード();
            this.媒体区分 = DbBusinessConfig
                    .get(ConfigNameDBC.国保連送付媒体_過誤申立Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            this.交換情報識別番号 = KokuhorenSofuKokanJohoShikibetsuBango.介護給付過誤申立書情報.getコード();
        } else if (コード_176.equals(processParameter.getコード())) {
            出力ファイル名 = ファイル名_前.concat(コード_176).concat(processParameter.get保険者番号().getColumnValue())
                    .concat(processParameter.get処理年月().toDateString()).concat(ファイル名_後);
            データ種別 = ConfigKeysKokuhorenSofu.総合事業費経過措置過誤申立書情報.getコード();
            this.媒体区分 = DbBusinessConfig
                    .get(ConfigNameDBC.国保連送付媒体_過誤申立総合経措Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            this.交換情報識別番号 = KokuhorenSofuKokanJohoShikibetsuBango.総合事業費経過措置過誤申立書情報.getコード();
        }
        if (コード_179.equals(processParameter.getコード())) {
            出力ファイル名 = ファイル名_前.concat(コード_179).concat(processParameter.get保険者番号().getColumnValue())
                    .concat(processParameter.get処理年月().toDateString()).concat(ファイル名_後);
            データ種別 = ConfigKeysKokuhorenSofu.総合事業費過誤申立書情報.getコード();
            this.媒体区分 = DbBusinessConfig
                    .get(ConfigNameDBC.国保連送付媒体_過誤申立総合Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            this.交換情報識別番号 = KokuhorenSofuKokanJohoShikibetsuBango.総合事業費過誤申立書情報.getコード();
        }
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        if (Encode.UTF_8.equals(processParameter.get文字コード())) {
            入力ファイルパス = Path.combinePath(spoolWorkPath, COPY.concat(出力ファイル名));
        } else {
            入力ファイルパス = eucFilePath;
        }

    }

    @Override
    protected IBatchReader createReader() {

        reader = new BatchDbReader(READ_DATA_ID, mybatisParameter);
        return reader;
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new CsvWriter.InstanceBuilder(入力ファイルパス)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(processParameter.get文字コード())
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void process(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity) {
        if (レコード番号 == INT_1) {
            KogakugassanSoufuFairuSakuseiControlEntity controlEntity = this.getControlEntity();
            eucCsvWriter.writeLine(controlEntity);
            レコード番号++;
        }
        KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiMeisaiEntity kaigoEntity = this.getKaigoEntity(entity);
        eucCsvWriter.writeLine(kaigoEntity);
        総出力件数++;
        レコード番号++;
    }

    @Override
    protected void afterExecute() {
        KogakugassanSoufuFairuSakuseiEndEntity endEntity = this.getEndEntity();
        eucCsvWriter.writeLine(endEntity);
        eucCsvWriter.close();

        outputCount.setValue(総出力件数);
        outputPath.setValue(eucFilePath);
        inputPath.setValue(入力ファイルパス);

    }

    private KogakugassanSoufuFairuSakuseiEndEntity getEndEntity() {
        KogakugassanSoufuFairuSakuseiEndEntity endEntity = new KogakugassanSoufuFairuSakuseiEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号));
        return endEntity;
    }

    private KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiMeisaiEntity getKaigoEntity(KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity entity) {
        DbWT1731KagoMoshitateTempEntity 過誤申立一時 = entity.getDbWT1731Entity();
        DbWT1001HihokenshaTempEntity 被保険者一時 = entity.getDbWT1001Entity();
        KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiMeisaiEntity kaigoEntity = new KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiMeisaiEntity();
        kaigoEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        kaigoEntity.setレコード番号_連番(new RString(レコード番号));
        kaigoEntity.set交換情報識別番号(this.交換情報識別番号);
        kaigoEntity.set申立年月日(trimDate(過誤申立一時.getMoshitateYMD()));
        kaigoEntity.set申立者区分コード(trimRString(過誤申立一時.getMoshitateshaKubunCode()));
        kaigoEntity.set事業所番号(trimRString(過誤申立一時.getJigyoshaNo().getColumnValue()));
        kaigoEntity.set証記載保険者番号(trimRString(過誤申立一時.getShoKisaiHokenshaNo().getColumnValue()));
        kaigoEntity.set被保険者番号(trimRString(被保険者一時.getExHihokenshaNo().getColumnValue()));
        kaigoEntity.setサービス提供年月日(trimYearMonth(過誤申立一時.getServiceTeikyoYM()));
        kaigoEntity.set申立事由コード(trimRString(過誤申立一時.getMoshitateJiyuCode()));
        return kaigoEntity;
    }

    private RString trimYearMonth(FlexibleYearMonth yearMoth) {
        return yearMoth == null || yearMoth.isEmpty() ? RString.EMPTY : new RString(yearMoth.toString()).trim();
    }

    private RString trimDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY : new RString(date.toString()).trim();
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private KogakugassanSoufuFairuSakuseiControlEntity getControlEntity() {
        KogakugassanSoufuFairuSakuseiControlEntity controlEntity = new KogakugassanSoufuFairuSakuseiControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_000);
        controlEntity.setレコード件数(new RString(processParameter.get件数()));
        controlEntity.setデータ種別(this.データ種別);
        controlEntity.set福祉事務所特定番号(RSTRING_00);
        controlEntity.set保険者番号(processParameter.get保険者番号().getColumnValue());
        controlEntity.set事業所番号(RSTRING_0000000000);
        controlEntity.set都道府県番号(RSTRING_00);
        controlEntity.set媒体区分(this.媒体区分);
        controlEntity.set処理対象年月(processParameter.get処理年月().toDateString());
        controlEntity.setファイル管理番号(RSTRING_000001);
        return controlEntity;
    }

}
