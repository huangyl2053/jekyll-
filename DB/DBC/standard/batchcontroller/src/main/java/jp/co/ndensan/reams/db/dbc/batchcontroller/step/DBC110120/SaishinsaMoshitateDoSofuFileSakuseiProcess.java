/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateGetSoufuDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsamoshitateshoout.SaishinsaMoshitateSofuFairuControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsamoshitateshoout.SaishinsaMoshitateSofuFairuEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.saishinsamoshitateshoout.SaishinsaMoshitateSofuFairuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateAndHihokenshaKanrenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護給付費再審査申立書情報作成・送付ファイル作成を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateDoSofuFileSakuseiProcess extends BatchProcessBase<SaishinsaMoshitateAndHihokenshaKanrenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select送付対象データ関連リスト");
    private SaishinsaMoshitateGetSoufuDataProcessParameter parameter;
    private SaishinsaMoshitateMybatisParameter mybatisParameter;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString ファイル名_前 = new RString("10_174");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString COPY = new RString("copy");
    private static final int INT_0 = 0;
    private static final int INT_6 = 6;
    private static final RString RSTRING_000 = new RString("000");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_0000000000 = new RString("0000000000");
    private static final RString RSTRING_000001 = new RString("000001");

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
    private OutputParameter<RString> inputPath;
    private OutputParameter<RString> outputPath;
    private int 総出力件数;
    private int レコード番号;
    private RString eucFilePath;
    private RString 出力ファイル名;
    private RString 入力ファイルパス;
    @BatchWriter
    private CsvWriter eucCsvWriter;

    @Override
    protected void initialize() {
        mybatisParameter = new SaishinsaMoshitateMybatisParameter();
        mybatisParameter.set保険者番号(parameter.get保険者番号());
        outputCount = new OutputParameter<>();
        inputPath = new OutputParameter<>();
        outputPath = new OutputParameter<>();
        入力ファイルパス = RString.EMPTY;
        総出力件数 = INT_0;
        レコード番号 = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        出力ファイル名 = ファイル名_前
                .concat(parameter.get保険者番号()).concat(parameter.get処理年月().toDateString()).concat(ファイル名_後);
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        if (Encode.UTF_8.equals(parameter.get文字コード())) {
            入力ファイルパス = Path.combinePath(spoolWorkPath, COPY.concat(出力ファイル名));
        } else {
            入力ファイルパス = eucFilePath;
        }
        eucCsvWriter = new CsvWriter.InstanceBuilder(入力ファイルパス)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(parameter.get文字コード())
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void process(SaishinsaMoshitateAndHihokenshaKanrenEntity entity) {
        if (レコード番号 == INT_0) {
            レコード番号 = レコード番号 + 1;
            SaishinsaMoshitateSofuFairuControlEntity controlEntity = getControlEntity();
            eucCsvWriter.writeLine(controlEntity);
        }
        レコード番号 = レコード番号 + 1;
        SaishinsaMoshitateSofuFairuMeisaiEntity meisaiEntity = getMeisaiEntity(entity);
        eucCsvWriter.writeLine(meisaiEntity);
        総出力件数 = 総出力件数 + 1;
    }

    @Override
    protected void afterExecute() {
        レコード番号 = レコード番号 + 1;
        SaishinsaMoshitateSofuFairuEndEntity endEntity = getEndEntity();
        eucCsvWriter.writeLine(endEntity);
        outputCount.setValue(総出力件数);
        outputPath.setValue(eucFilePath);
        inputPath.setValue(入力ファイルパス);
        eucCsvWriter.close();
    }

    private SaishinsaMoshitateSofuFairuControlEntity getControlEntity() {
        SaishinsaMoshitateSofuFairuControlEntity controlEntity = new SaishinsaMoshitateSofuFairuControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_000);
        controlEntity.setレコード件数(new RString(parameter.getレコード件数()));
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.再審査申立書情報.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_00);
        controlEntity.set保険者番号(trimRString(parameter.get保険者番号()));
        controlEntity.set事業所番号(RSTRING_0000000000);
        controlEntity.set都道府県番号(RSTRING_00);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_再審申立Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(parameter.get処理年月().toDateString());
        controlEntity.setファイル管理番号(RSTRING_000001);
        return controlEntity;
    }

    private SaishinsaMoshitateSofuFairuMeisaiEntity getMeisaiEntity(SaishinsaMoshitateAndHihokenshaKanrenEntity entity) {
        DbWT1741SaishinsaMoshitateEntity 再審査申立 = entity.get再審査申立();
        DbWT1001HihokenshaEntity 被保険者 = entity.get被保険者();
        SaishinsaMoshitateSofuFairuMeisaiEntity meisaiEntity = new SaishinsaMoshitateSofuFairuMeisaiEntity();
        meisaiEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        meisaiEntity.setレコード番号_連番(new RString(レコード番号));
        RString 年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_介護給付費見直し,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substringEmptyOnError(INT_0, INT_6);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(年月);
        if (サービス提供年月.equals(再審査申立.getServiceTeikyoYM())) {
            meisaiEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.介護給付費再審査申立書情報.getコード());
        } else {
            meisaiEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.介護給付費再審査申立書情報_平成15年4月以降.getコード());
        }
        meisaiEntity.set申立年月日(formatDate(再審査申立.getMoshitateYMD()));
        meisaiEntity.set申立者区分コード(trimRString(再審査申立.getMoshitateshaKubunCode()));
        meisaiEntity.set事業所番号(trimRString(getColumnValue(再審査申立.getJigyoshoNo())));
        meisaiEntity.set証記載保険者番号(trimRString(getColumnValue(再審査申立.getShokisaiHokenshaNo())));
        meisaiEntity.set被保険者番号(trimRString(getColumnValue(被保険者.getSofuHihokenshaNo())));
        meisaiEntity.setサービス提供年月(再審査申立.getServiceTeikyoYM().toDateString());
        meisaiEntity.setサービス種類コード(trimRString(getColumnValue(再審査申立.getServiceTeikyoShuruiCode())));
        meisaiEntity.setサービス項目コード(trimRString(getColumnValue(再審査申立.getServiceKomokuCode())));
        meisaiEntity.set申立単位数(new RString(再審査申立.getMoshitateTanisu()));
        meisaiEntity.set申立事由コード(trimRString(再審査申立.getMoshitateJiyuCode()));
        return meisaiEntity;
    }

    private SaishinsaMoshitateSofuFairuEndEntity getEndEntity() {
        SaishinsaMoshitateSofuFairuEndEntity endEntity = new SaishinsaMoshitateSofuFairuEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号));
        return endEntity;
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString formatDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY : new RString(date.toString()).trim();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
