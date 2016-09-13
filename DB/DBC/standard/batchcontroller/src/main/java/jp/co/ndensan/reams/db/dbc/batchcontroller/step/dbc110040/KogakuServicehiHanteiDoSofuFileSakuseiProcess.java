/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakuservicehihanteikekkaout.KogakuServicehiHanteiSofuFairuControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakuservicehihanteikekkaout.KogakuServicehiHanteiSofuFairuEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakuservicehihanteikekkaout.KogakuServicehiHanteiSofuFairuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.DbWT3411KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiKanrenDataKoushinEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 高額サービス費給付判定結果情報作成・送付ファイル作成を実行する。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class KogakuServicehiHanteiDoSofuFileSakuseiProcess extends BatchProcessBase<KogakuServicehiHanteiKanrenDataKoushinEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakuservicehihanteikekkaout.IKogakuServicehiHanteikekkaOutJohoMapper.select送付対象データ関連リスト");
    private KogakuServicehiHanteiProcessParameter parameter;
    private KogakuServicehiHanteiMybatisParameter mybatisParameter;
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString ファイル名_前 = new RString("10_341");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final int INT_0 = 0;
    private static final int INT_80 = 80;
    private static final RString RSTRING_000 = new RString("000");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString RSTRING_0000000000 = new RString("0000000000");
    private static final RString RSTRING_000001 = new RString("000001");
    private static final RString 囲みの文字 = new RString("\"");

    /**
     * 総出力件数カウンターです。
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;
    /**
     * エントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTPUTENTRY;

    static {
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
        PARAMETER_OUT_OUTPUTENTRY = new RString("outputEntry");
    }

    private OutputParameter<Integer> outputCount;
    private OutputParameter<List> outputEntry;
    private List<SharedFileDescriptor> entryList;
    private int 総出力件数;
    private int レコード番号;
    private BatchDbReader reader;
    private Encode 文字コード;
    private RString eucFilePath;
    private RString 出力ファイル名;
    @BatchWriter
    private CsvWriter eucCsvWriter;

    @Override
    protected void initialize() {
        mybatisParameter = new KogakuServicehiHanteiMybatisParameter();
        mybatisParameter.set保険者番号(parameter.get保険者番号());
        outputCount = new OutputParameter<>();
        outputEntry = new OutputParameter<>();
        entryList = new ArrayList<>();
        総出力件数 = INT_0;
        レコード番号 = INT_0;
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (国保連送付外字_変換区分_1.equals(国保連送付外字_変換区分)) {
            // TODO QA90831 文字コードがありません。
            文字コード = Encode.UTF_8withBOM;
        } else {
            文字コード = Encode.SJIS;
        }
    }

    @Override
    protected IBatchReader createReader() {
        reader = new BatchDbReader(READ_DATA_ID, mybatisParameter);
        return reader;
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        出力ファイル名 = ファイル名_前
                .concat(parameter.get保険者番号()).concat(parameter.get処理年月().toDateString()).concat(ファイル名_後);
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(文字コード)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void process(KogakuServicehiHanteiKanrenDataKoushinEntity entity) {
        if (レコード番号 == INT_0) {
            レコード番号 = レコード番号 + 1;
            KogakuServicehiHanteiSofuFairuControlEntity controlEntity = getControlEntity();
            eucCsvWriter.writeLine(controlEntity);
        }
        レコード番号 = レコード番号 + 1;
        KogakuServicehiHanteiSofuFairuMeisaiEntity meisaiEntity = getMeisaiEntity(entity);
        eucCsvWriter.writeLine(meisaiEntity);
        総出力件数 = 総出力件数 + 1;
    }

    @Override
    protected void afterExecute() {
        レコード番号 = レコード番号 + 1;
        KogakuServicehiHanteiSofuFairuEndEntity endEntity = getEndEntity();
        eucCsvWriter.writeLine(endEntity);
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力ファイル名));
        sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(eucFilePath), opts);
        outputCount.setValue(総出力件数);
        entryList.add(sfd);
        outputEntry.setValue(entryList);
        eucCsvWriter.close();
    }

    private KogakuServicehiHanteiSofuFairuControlEntity getControlEntity() {
        KogakuServicehiHanteiSofuFairuControlEntity controlEntity = new KogakuServicehiHanteiSofuFairuControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_000);
        controlEntity.setレコード件数(new RString(reader.getCount()));
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.受給者情報更新結果情報.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_00);
        controlEntity.set保険者番号(parameter.get保険者番号());
        controlEntity.set事業所番号(RSTRING_0000000000);
        controlEntity.set都道府県番号(RSTRING_00);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_高額判定Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(parameter.get処理年月().seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
        controlEntity.setファイル管理番号(RSTRING_000001);
        return controlEntity;
    }

    private KogakuServicehiHanteiSofuFairuMeisaiEntity getMeisaiEntity(KogakuServicehiHanteiKanrenDataKoushinEntity entity) {
        DbWT3411KogakuShikyuShinseiEntity 高額介護 = entity.get高額介護();
        DbWT1001HihokenshaEntity 被保険者 = entity.get被保険者();
        KogakuServicehiHanteiSofuFairuMeisaiEntity meisaiEntity = new KogakuServicehiHanteiSofuFairuMeisaiEntity();
        meisaiEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        meisaiEntity.setレコード番号_連番(new RString(レコード番号));
        meisaiEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額介護サービス費給付判定結果情報.getコード());
        meisaiEntity.set証記載保険者番号(trimRString(getColumnValue(高額介護.getShoKisaiHokenshaNo())));
        meisaiEntity.set被保険者番号(trimRString(getColumnValue(被保険者.getSofuHihokenshaNo())));
        meisaiEntity.setサービス提供年月(formatDateYM(高額介護.getServiceTeikyoYM()));
        meisaiEntity.set受付年月日(formatDate(高額介護.getUketsukeYMD()));
        meisaiEntity.set決定年月日(formatDate(高額介護.getKetteiYMD()));
        meisaiEntity.set本人支払額(decimal_to_string(高額介護.getHonninShiharaiGaku()));
        meisaiEntity.set支給区分コード(trimRString(高額介護.getShikyuKubunCode()));
        if (ShikyuKubun.支給.getコード().equals(高額介護.getShikyuKubunCode())) {
            meisaiEntity.set支給金額(decimal_to_string(高額介護.getShikyuKingaku()));
        } else {
            meisaiEntity.set支給金額(RString.EMPTY);
        }
        if (ShikyuKubun.不支給.getコード().equals(高額介護.getShikyuKubunCode())) {
            meisaiEntity.set不支給理由(囲み文字(trimRString(高額介護.getFushikyuRiyu().substringReturnAsPossible(INT_0, INT_80))));
        }
        meisaiEntity.set支払方法区分コード(trimRString(高額介護.getShinsaHohoKubun()));
        meisaiEntity.set窓口払_支払場所(RString.EMPTY);
        meisaiEntity.set窓口払_支払期間_開始年月日(RString.EMPTY);
        meisaiEntity.set窓口払_支払期間_終了年月日(RString.EMPTY);
        meisaiEntity.set窓口払_支払期間_開始曜日(RString.EMPTY);
        meisaiEntity.set窓口払_支払期間_終了曜日(RString.EMPTY);
        meisaiEntity.set窓口払_支払期間_開始時間(RString.EMPTY);
        meisaiEntity.set窓口払_支払期間_終了時間(RString.EMPTY);
        meisaiEntity.set口座払_金融機関コード(RString.EMPTY);
        meisaiEntity.set口座払_金融機関支店コード(RString.EMPTY);
        meisaiEntity.set口座払_口座種目(RString.EMPTY);
        meisaiEntity.set口座払_口座番号(RString.EMPTY);
        meisaiEntity.set口座払_口座名義人_カナ(RString.EMPTY);
        meisaiEntity.set審査方法区分コード(trimRString(高額介護.getShinsaHohoKubun()));
        return meisaiEntity;
    }

    private KogakuServicehiHanteiSofuFairuEndEntity getEndEntity() {
        KogakuServicehiHanteiSofuFairuEndEntity endEntity = new KogakuServicehiHanteiSofuFairuEndEntity();
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

    private RString formatDateYM(FlexibleYearMonth date) {
        return date == null || date.isEmpty() ? RString.EMPTY : new RString(date.toString()).trim();
    }

    private RString 囲み文字(RString str) {
        return 囲みの文字.concat(str).concat(囲みの文字);
    }

    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return new RString(number.toString());
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
