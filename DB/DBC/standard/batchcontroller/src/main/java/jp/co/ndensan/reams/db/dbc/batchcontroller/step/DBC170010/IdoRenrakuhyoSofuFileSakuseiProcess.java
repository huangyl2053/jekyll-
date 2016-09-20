/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170010;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceCode_IdoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.GendogakuTaisyogaiFlg;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.JigyoTaisyosyaJisiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.SikyuGendogakuTaisyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.YoSienJykyusyaJisiKubun1;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.YoSienJykyusyaJisiKubun2;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc170010.ServicecodeIdoRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc170010.ServicecodeIdoRenrakuhyoOutCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc170010.ServicecodeIdoRenrakuhyoOutDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010.SogoJigyoServiceCodeTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170010.IServicecodeIdoRenrakuhyoOutMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
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
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 総合事業分サービスコード異動連絡票作成バッチの送付ファイル作成Processです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
public class IdoRenrakuhyoSofuFileSakuseiProcess extends BatchProcessBase<SogoJigyoServiceCodeTempEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170010."
            + "IServicecodeIdoRenrakuhyoOutMapper.get送付ファイル作成データ");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 囲み文字 = new RString("\"");
    private static final RString ファイル名_前 = new RString("10_5H1");
    private static final RString FORMATTER = new RString("###,###,###,##0");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString RSTONE = new RString("1");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_00 = new RString("00");
    private static final RString 異動事由 = new RString("01");
    private static final RString ファイル管理番号 = new RString("000001");

    private static final RString A2 = new RString("A2");
    private static final RString A3 = new RString("A3");
    private static final RString A4 = new RString("A4");
    private static final RString A6 = new RString("A6");
    private static final RString A7 = new RString("A7");
    private static final RString A8 = new RString("A8");
    private static final RString A9 = new RString("A9");
    private static final RString AA = new RString("AA");
    private static final RString AB = new RString("AB");
    private static final RString AC = new RString("AC");
    private static final RString AD = new RString("AD");
    private static final RString AE = new RString("AE");
    private static final RString AF = new RString("AF");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    private static final RString CSVファイル名
            = new RString("DBC100019_SogojigyoServiceCodeIdoRenrakuhyo.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC100019");
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

    private int 総出力件数;
    private int レコード番号;
    private RString 出力件数;
    private Encode 文字コード;
    private RString eucFilePath;
    private RString eucCsvFilePath;
    private RString 出力ファイル名;
    private RString 保険者番号;
    private FileSpoolManager manager;
    private OutputParameter<Integer> outputCount;
    private OutputParameter<List> outputEntry;
    private List<SharedFileDescriptor> entryList;
    private ServicecodeIdoRenrakuhyoOutProcessParameter processParameter;
    @BatchWriter
    private CsvWriter eucCsvWriter;
    @BatchWriter
    private CsvWriter eucCsvWriter２;

    @Override
    protected void initialize() {
        outputCount = new OutputParameter<>();
        outputEntry = new OutputParameter<>();
        entryList = new ArrayList<>();
        総出力件数 = INT_0;
        レコード番号 = INT_0;
        出力件数 = getレコード件数();
        RString 国保連送付外字_変換区分
                = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (RSTONE.equals(国保連送付外字_変換区分)) {
            文字コード = Encode.SJIS;
        } else {
            // TODO QA1489
            文字コード = Encode.UTF_8withBOM;
        }
        保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        出力ファイル名 = ファイル名_前.concat(保険者番号)
                .concat(processParameter.get処理年月().toDateString()).concat(ファイル名_後);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(RString.EMPTY)
                .setEncode(文字コード)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath2 = manager.getEucOutputDirectry();
        eucCsvFilePath = Path.combinePath(spoolWorkPath2, CSVファイル名);
        eucCsvWriter２ = new CsvWriter.InstanceBuilder(eucCsvFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(SogoJigyoServiceCodeTempEntity entity) {
        if (INT_0 == レコード番号) {
            コントロールレコード出力();
        }
        データレコード出力(entity);
        csvファイル出力(entity);
    }

    @Override
    protected void afterExecute() {
        if (INT_0 == レコード番号) {
            コントロールレコード出力();
        }
        エンドレコード出力();
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力ファイル名));
        sfd = SharedFile.defineSharedFile(sfd, INT_1, SharedFile.GROUP_ALL, null, true, null);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(eucFilePath), opts);
        outputCount.setValue(総出力件数);
        entryList.add(sfd);
        outputEntry.setValue(entryList);
        eucCsvWriter.close();
        eucCsvWriter２.close();
    }

    private void コントロールレコード出力() {
        レコード番号 = レコード番号 + INT_1;
        KogakuGassanKeisanKekkaRenrakuJohoControlEntity controlEntity = new KogakuGassanKeisanKekkaRenrakuJohoControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_0);
        controlEntity.setレコード件数(出力件数);
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.総合事業分サービスコード異動連絡票情報.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_00);
        controlEntity.set保険者番号(保険者番号);
        controlEntity.set事業所番号(RString.EMPTY);
        controlEntity.set都道府県番号(RSTRING_00);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_サービスコード異動連絡票Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(processParameter.get処理年月().toDateString());
        controlEntity.setファイル管理番号(ファイル管理番号);
        eucCsvWriter.writeLine(controlEntity);
    }

    private void データレコード出力(SogoJigyoServiceCodeTempEntity entity) {
        レコード番号 = レコード番号 + INT_1;
        総出力件数 = 総出力件数 + INT_1;
        ServicecodeIdoRenrakuhyoOutDataEntity dataEntity = new ServicecodeIdoRenrakuhyoOutDataEntity();
        dataEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        dataEntity.setレコード番号_連番(new RString(レコード番号));
        dataEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.総合事業分サービスコード異動連絡票情報.getコード());
        dataEntity.set異動年月日(trimRString(new RString(entity.getIdoYMD().toString())));
        dataEntity.set異動区分コード(trimRString(entity.getIdoKubunCode()));
        dataEntity.set異動事由(異動事由);
        dataEntity.set証記載保険者番号(trimRString(保険者番号));
        dataEntity.setサービス種類コード(trimRString(entity.getServiceShuruiCode().getColumnValue()));
        dataEntity.setサービス項目コード(trimRString(entity.getServiceKomokuCode().getColumnValue()));
        if (ServiceCode_IdoKubun.新規.getコード().equals(entity.getIdoKubunCode())) {
            if (A2.equals(entity.getServiceShuruiCode().getColumnValue())
                    || A6.equals(entity.getServiceShuruiCode().getColumnValue())
                    || AF.equals(entity.getServiceShuruiCode().getColumnValue())) {
                dataEntity.set適用開始年月(trimRString(entity.getTekiyoKaishiYM().toDateString()));
                dataEntity.set適用終了年月(RString.EMPTY);
                dataEntity.setサービス名称(RString.EMPTY);
                dataEntity.set単位数(trimDecimal(entity.getTaniSu()));
                dataEntity.set算定単位(RString.EMPTY);
                dataEntity.set制限日数回数(RString.EMPTY);
                dataEntity.set算定回数制限期間(RString.EMPTY);
                dataEntity.set支給限度額対象区分(RString.EMPTY);
                dataEntity.set給付率(RString.EMPTY);
                dataEntity.set利用者負担額(RString.EMPTY);
                dataEntity.set事業対象者実施区分(RString.EMPTY);
                dataEntity.set要支援１受給者実施区分(RString.EMPTY);
                dataEntity.set要支援２受給者実施区分(RString.EMPTY);
            }
            if (A3.equals(entity.getServiceShuruiCode().getColumnValue())
                    || A7.equals(entity.getServiceShuruiCode().getColumnValue())
                    || A9.equals(entity.getServiceShuruiCode().getColumnValue())
                    || AB.equals(entity.getServiceShuruiCode().getColumnValue())
                    || AD.equals(entity.getServiceShuruiCode().getColumnValue())) {
                dataEntity.set適用開始年月(trimRString(entity.getTekiyoKaishiYM().toDateString()));
                dataEntity.set適用終了年月(RString.EMPTY);
                dataEntity.setサービス名称(囲み文字(
                        null == entity.getServiceMeisho() ? RString.EMPTY : entity.getServiceMeisho()));
                dataEntity.set単位数(trimDecimal(entity.getTaniSu()));
                dataEntity.set算定単位(entity.getSanteiTaniKubun());
                dataEntity.set制限日数回数(RString.EMPTY);
                dataEntity.set算定回数制限期間(RString.EMPTY);
                dataEntity.set支給限度額対象区分(RString.EMPTY);
                dataEntity.set給付率(
                        null == entity.getKyufuRitsu()
                        ? RString.EMPTY : new RString(entity.getKyufuRitsu().getColumnValue().toString()));
                dataEntity.set利用者負担額(RString.EMPTY);
                dataEntity.set事業対象者実施区分(entity.getNijiYoboTaishosha_JissiKubun());
                dataEntity.set要支援１受給者実施区分(entity.getYoShien1_JisshiKubun());
                dataEntity.set要支援２受給者実施区分(entity.getYoShien2_JisshiKubun());
            }
            if (A4.equals(entity.getServiceShuruiCode().getColumnValue())
                    || A8.equals(entity.getServiceShuruiCode().getColumnValue())
                    || AA.equals(entity.getServiceShuruiCode().getColumnValue())
                    || AC.equals(entity.getServiceShuruiCode().getColumnValue())
                    || AE.equals(entity.getServiceShuruiCode().getColumnValue())) {
                dataEntity.set適用開始年月(trimRString(entity.getTekiyoKaishiYM().toDateString()));
                dataEntity.set適用終了年月(RString.EMPTY);
                dataEntity.setサービス名称(囲み文字(
                        null == entity.getServiceMeisho() ? RString.EMPTY : entity.getServiceMeisho()));
                dataEntity.set単位数(trimDecimal(entity.getTaniSu()));
                dataEntity.set算定単位(entity.getSanteiTaniKubun());
                dataEntity.set制限日数回数(RString.EMPTY);
                dataEntity.set算定回数制限期間(RString.EMPTY);
                dataEntity.set支給限度額対象区分(RString.EMPTY);
                dataEntity.set給付率(RString.EMPTY);
                dataEntity.set利用者負担額(trimDecimal(entity.getRiyoshaFutanGaku()));
                dataEntity.set事業対象者実施区分(entity.getNijiYoboTaishosha_JissiKubun());
                dataEntity.set要支援１受給者実施区分(entity.getYoShien1_JisshiKubun());
                dataEntity.set要支援２受給者実施区分(entity.getYoShien2_JisshiKubun());
            }
        }
        if (ServiceCode_IdoKubun.終了.getコード().equals(entity.getIdoKubunCode())) {
            dataEntity.set適用開始年月(RString.EMPTY);
            dataEntity.set適用終了年月(trimRString(entity.getTekiyoShuryoYM().toDateString()));
            dataEntity.setサービス名称(RString.EMPTY);
            dataEntity.set単位数(RString.EMPTY);
            dataEntity.set算定単位(RString.EMPTY);
            dataEntity.set制限日数回数(RString.EMPTY);
            dataEntity.set算定回数制限期間(RString.EMPTY);
            dataEntity.set支給限度額対象区分(RString.EMPTY);
            dataEntity.set給付率(RString.EMPTY);
            dataEntity.set利用者負担額(RString.EMPTY);
            dataEntity.set事業対象者実施区分(RString.EMPTY);
            dataEntity.set要支援１受給者実施区分(RString.EMPTY);
            dataEntity.set要支援２受給者実施区分(RString.EMPTY);
        }
        eucCsvWriter.writeLine(dataEntity);
    }

    private void エンドレコード出力() {
        レコード番号 = レコード番号 + INT_1;
        KogakuGassanKeisanKekkaRenrakuJohoEndEntity endEntity = new KogakuGassanKeisanKekkaRenrakuJohoEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号));
        eucCsvWriter.writeLine(endEntity);
    }

    private void csvファイル出力(SogoJigyoServiceCodeTempEntity entity) {
        ServicecodeIdoRenrakuhyoOutCsvEntity csvEntity = new ServicecodeIdoRenrakuhyoOutCsvEntity();
        csvEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.総合事業分サービスコード異動連絡票情報.getコード());
        csvEntity.set異動年月日(new RString(entity.getIdoYMD().toString()));
        csvEntity.set異動区分コード(entity.getIdoKubunCode());
        csvEntity.set異動区分名称(ServiceCode_IdoKubun.toValue(entity.getIdoKubunCode()).get名称());
        csvEntity.set異動事由(異動事由);
        csvEntity.set証記載保険者番号(保険者番号);
        csvEntity.setサービス種類コード(entity.getServiceShuruiCode().getColumnValue());
        csvEntity.setサービス項目コード(entity.getServiceKomokuCode().getColumnValue());
        csvEntity.set適用開始年月(entity.getTekiyoKaishiYM().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        if (entity.getTekiyoShuryoYM() != null && !entity.getTekiyoShuryoYM().isEmpty()) {
            csvEntity.set適用終了年月(entity.getTekiyoShuryoYM().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        csvEntity.setサービス名称(entity.getServiceMeisho());
        csvEntity.set単位数(decimalFormat(entity.getTaniSu()));
        csvEntity.set算定単位(entity.getSanteiTaniKubun());
        csvEntity.set制限日数_回数(new RString(entity.getSeigenNissuKaisu()));
        csvEntity.set算定回数制限期間(entity.getSanteiKaisuSeigenKikanKubun());
        if (GendogakuTaisyogaiFlg.新規.getコード().equals(entity.getGendoGakuTaishogaiFlag())) {
            csvEntity.set支給限度額対象区分(SikyuGendogakuTaisyoKubun.区分支給限度額管理対照.getコード());
            csvEntity.set支給限度額対象区分名称(SikyuGendogakuTaisyoKubun.区分支給限度額管理対照.get名称());
        }
        if (entity.getKyufuRitsu() != null) {
            csvEntity.set給付率(new RString(entity.getKyufuRitsu().getColumnValue().toString()));
        }
        csvEntity.set利用者負担額(decimalFormat(entity.getRiyoshaFutanGaku()));
        csvEntity.set事業対象者実施区分(entity.getTaishoJigyosha_JisshiKubun());
        if (entity.getTaishoJigyosha_JisshiKubun() != null && !entity.getTaishoJigyosha_JisshiKubun().isEmpty()) {
            csvEntity.set事業対象者実施区分名称(JigyoTaisyosyaJisiKubun.toValue(entity.getTaishoJigyosha_JisshiKubun()).get名称());
        }
        csvEntity.set要支援１受給者実施区分(entity.getYoShien1_JisshiKubun());
        if (entity.getYoShien1_JisshiKubun() != null && !entity.getYoShien1_JisshiKubun().isEmpty()) {
            csvEntity.set要支援１受給者実施区分名称(YoSienJykyusyaJisiKubun1.toValue(entity.getYoShien1_JisshiKubun()).get名称());
        }
        csvEntity.set要支援２受給者実施区分(entity.getYoShien2_JisshiKubun());
        if (entity.getYoShien2_JisshiKubun() != null && !entity.getYoShien2_JisshiKubun().isEmpty()) {
            csvEntity.set要支援２受給者実施区分名称(YoSienJykyusyaJisiKubun2.toValue(entity.getYoShien2_JisshiKubun()).get名称());
        }
        eucCsvWriter２.writeLine(csvEntity);
    }

    private RString getレコード件数() {
        IServicecodeIdoRenrakuhyoOutMapper mapper = getMapper(IServicecodeIdoRenrakuhyoOutMapper.class);
        List<SogoJigyoServiceCodeTempEntity> list = mapper.get送付ファイル作成データ();
        return new RString(list.size());
    }

    private RString trimDecimal(Decimal dec) {
        return dec == null ? RString.EMPTY : new RString(dec.toString());
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString 囲み文字(RString str) {
        return 囲み文字.concat(str).concat(囲み文字);
    }

    private RString decimalFormat(Decimal decimal) {
        if (decimal == null) {
            return RString.EMPTY;
        }
        NumberFormat format = new DecimalFormat(FORMATTER.toString());
        return new RString(format.format(decimal));
    }
}
