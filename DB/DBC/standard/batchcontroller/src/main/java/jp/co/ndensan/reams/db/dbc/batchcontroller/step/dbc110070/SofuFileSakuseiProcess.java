/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.DataRecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110070.KogakugassanKeisankekkaRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoToreraEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanKeisanKekkaRenrakuJohoTmpEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070.IKogakugassanKeisankekkaRenrakuhyoOutMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算計算結果連絡票情報作成のバッチ送付除外区分設定Processです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public class SofuFileSakuseiProcess extends BatchKeyBreakBase<KogakuGassanKeisanKekkaRenrakuJohoTmpEntity> {

    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110070."
            + "IKogakugassanKeisankekkaRenrakuhyoOutMapper.get送付ファイル作成データ");
    private static final RString 処理結果リスト一時 = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString コンマ = new RString(",");
    private static final RString ファイル名_前 = new RString("10_381");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString RSTONE = new RString("1");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_20 = 20;
    private static final int INT_25 = 25;
    private static final int INT_50 = 50;
    private static final int INT_64 = 64;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString 囲み文字 = new RString("\"");
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
    private int flag;
    private RString 出力用レコード件数;
    private Encode 文字コード;
    private RString eucFilePath;
    private RString 出力ファイル名;
    private RString 保険者番号;
    private OutputParameter<Integer> outputCount;
    private OutputParameter<List> outputEntry;
    private List<SharedFileDescriptor> entryList;
    private KogakugassanKeisankekkaRenrakuhyoOutProcessParameter processParameter;
    private SofuFileSakuseiProcessCore processCore;
    private KogakuGassanKeisanKekkaRenrakuJohoRelateEntity 高額合算支給額計算結果;
    private CsvWriter eucCsvWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter dbWT1002TableWriter;

    @Override
    protected void initialize() {
        flag = 0;
        outputCount = new OutputParameter<>();
        outputEntry = new OutputParameter<>();
        entryList = new ArrayList<>();
        総出力件数 = INT_0;
        レコード番号 = INT_0;
        RString 国保連送付外字_変換区分
                = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (RSTONE.equals(国保連送付外字_変換区分)) {
            文字コード = Encode.SJIS;
        } else {
            // TODO QA1489
            文字コード = Encode.SJIS;
        }
        保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        出力用レコード件数 = getレコード件数();
        出力ファイル名 = ファイル名_前.concat(保険者番号)
                .concat(processParameter.get処理年月().toDateString()).concat(ファイル名_後);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        dbWT1002TableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void beforeExecute() {
        processCore = new SofuFileSakuseiProcessCore();
    }

    @Override
    protected void usualProcess(KogakuGassanKeisanKekkaRenrakuJohoTmpEntity entity) {
        if (flag == 0) {
            flag = INT_1;
            RString spoolWorkPath = Path.getTmpDirectoryPath();

            eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
            eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                    .setDelimiter(コンマ)
                    .setEnclosure(RString.EMPTY)
                    .setEncode(文字コード)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(false)
                    .build();
        }
    }

    @Override
    protected void keyBreakProcess(KogakuGassanKeisanKekkaRenrakuJohoTmpEntity entity) {
        flag = INT_2;
        高額合算支給額計算結果 = processCore.keyBreakProcess(getBefore(), entity);
        if (高額合算支給額計算結果 != null) {
            送付ファイル作成();
        }
    }

    @Override
    protected void afterExecute() {
        if (flag == 0) {
            処理結果リスト一時TBL出力();
        }
        if (flag == INT_1) {
            高額合算支給額計算結果 = new KogakuGassanKeisanKekkaRenrakuJohoRelateEntity();
            高額合算支給額計算結果.set高額合算支給額計算結果一時(getBefore().get高額合算支給額計算結果一時());
            高額合算支給額計算結果.set被保険者一時(getBefore().get被保険者一時());
            高額合算支給額計算結果.get高額合算支給額計算結果明細リスト().add(getBefore().get高額合算支給額計算結果明細());
            送付ファイル作成();
        }
        if (flag == INT_2) {
            高額合算支給額計算結果 = processCore.getFinal連絡票情報();
            送付ファイル作成();
        }
        if (flag != 0) {
            エンドレコード出力();
        }
        outputCount.setValue(総出力件数);
        if (null != eucCsvWriter) {
            SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力ファイル名));
            sfd = SharedFile.defineSharedFile(sfd, INT_1, SharedFile.GROUP_ALL, null, true, null);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
            SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(eucFilePath), opts);
            entryList.add(sfd);
            outputEntry.setValue(entryList);
            eucCsvWriter.close();
        }
    }

    private void 処理結果リスト一時TBL出力() {
        DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果リスト一時Entity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        処理結果リスト一時Entity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        処理結果リスト一時Entity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        処理結果リスト一時Entity.setHihokenshaNo(HihokenshaNo.EMPTY);
        処理結果リスト一時Entity.setKey1(RString.EMPTY);
        処理結果リスト一時Entity.setKey2(RString.EMPTY);
        処理結果リスト一時Entity.setKey3(RString.EMPTY);
        処理結果リスト一時Entity.setKey4(RString.EMPTY);
        処理結果リスト一時Entity.setKey5(RString.EMPTY);
        処理結果リスト一時Entity.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果リスト一時Entity.setHihokenshaShimei(RString.EMPTY);
        処理結果リスト一時Entity.setBiko(RString.EMPTY);
        dbWT1002TableWriter.insert(処理結果リスト一時Entity);
    }

    private void 送付ファイル作成() {
        if (INT_0 == レコード番号) {
            コントロールレコード出力();
        }
        ヘッダーレコード出力(高額合算支給額計算結果);
        データレコード出力(高額合算支給額計算結果);
        トレーラレコード出力(高額合算支給額計算結果);
    }

    private void コントロールレコード出力() {
        レコード番号 = レコード番号 + INT_1;
        KogakuGassanKeisanKekkaRenrakuJohoControlEntity controlEntity = new KogakuGassanKeisanKekkaRenrakuJohoControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_0);
        controlEntity.setレコード件数(出力用レコード件数);
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.高額合算計算結果連絡票情報.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_0);
        controlEntity.set保険者番号(保険者番号);
        controlEntity.set事業所番号(RSTRING_0);
        controlEntity.set都道府県番号(RSTRING_0);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_計算結果連絡Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(processParameter.get処理年月().toDateString());
        controlEntity.setファイル管理番号(RSTRING_0);
        eucCsvWriter.writeLine(controlEntity);
    }

    private void ヘッダーレコード出力(KogakuGassanKeisanKekkaRenrakuJohoRelateEntity entity) {
        レコード番号 = レコード番号 + INT_1;
        総出力件数 = 総出力件数 + INT_1;
        KogakuGassanKeisanKekkaRenrakuJohoHeadEntity headEntity = new KogakuGassanKeisanKekkaRenrakuJohoHeadEntity();
        headEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        headEntity.setレコード番号_連番(new RString(レコード番号));
        headEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額合算計算結果連絡票情報.getコード());
        headEntity.setレコード種別２(DataRecordShubetsu.ヘッダーレコード.getコード());
        headEntity.set連絡票整理番号(trimRString(entity.get高額合算支給額計算結果一時().getShikyuShinseishoSeiriNo()));
        headEntity.set保険制度コード(trimRString(entity.get高額合算支給額計算結果一時().getHokenSeidoCode()));
        headEntity.set対象年度(trimYear((entity.get高額合算支給額計算結果一時().getTaishoNendo())));
        headEntity.set自己負担額証明書整理番号(trimRString(entity.get高額合算支給額計算結果一時().getJikoFutanSeiriNo()));
        RString 支給対象者氏名 = entity.get被保険者一時().getKanaMeisho();
        headEntity.set支給対象者氏名_カナ(
                囲み文字(INT_25 < 支給対象者氏名.length() ? 支給対象者氏名.substring(0, INT_25).trim() : 支給対象者氏名.trim()));
        RString 名称 = entity.get被保険者一時().getMeisho();
        if (名称 != null) {
            headEntity.set支給対象者氏名_漢字(
                    囲み文字(INT_20 < 名称.length() ? 名称.substring(0, INT_20).trim() : 名称.trim()));
        }
        headEntity.set生年月日(trimDate(entity.get被保険者一時().getSeinenYmd()));
        headEntity.set性別(trimRString(entity.get被保険者一時().getSeibetsuCode()));
        HokenshaNo 保険者番号一時 = entity.get高額合算支給額計算結果一時().getShoKisaiHokenshaNo();
        RString 保険者番号R = 保険者番号一時 == null || 保険者番号一時.isEmpty()
                ? RString.EMPTY : 保険者番号一時.getColumnValue().trim();
        headEntity.set保険者番号(保険者番号R);
        headEntity.set被保険者証記号(RString.EMPTY);
        HihokenshaNo 保険者番号一時２ = entity.get高額合算支給額計算結果一時().getHihokenshaNo();
        RString 保険者番号R２ = 保険者番号一時２ == null || 保険者番号一時２.isEmpty()
                ? RString.EMPTY : 保険者番号一時２.getColumnValue().trim();
        headEntity.set被保険者_証_番号(保険者番号R２);
        headEntity.set計算対象期間開始年月日(trimDate(entity.get高額合算支給額計算結果一時().getTaishoKeisanKaishiYMD()));
        headEntity.set計算対象期間終了年月日(trimDate(entity.get高額合算支給額計算結果一時().getTaishoKeisanShuryoYMD()));
        headEntity.set世帯負担総額(trimDecimal(entity.get高額合算支給額計算結果一時().getSetaiFutanSogaku()));
        headEntity.set介護等合算一部負担金等世帯合算額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getSetaiGassanGaku()));
        headEntity.setななじゅう歳以上介護等合算一部負担金等世帯合算額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getOver70_SetaiGassanGaku()));
        headEntity.set所得区分(trimRString(entity.get高額合算支給額計算結果一時().getShotokuKubun()));
        headEntity.setななじゅう歳以上の者に係る所得区分(
                trimRString(entity.get高額合算支給額計算結果一時().getOver70_ShotokuKubun()));
        headEntity.set介護等合算算定基準額(trimDecimal(entity.get高額合算支給額計算結果一時().getSanteiKijunGaku()));
        headEntity.setななじゅう歳以上介護等合算算定基準額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getOver70_SanteiKijyunGaku()));
        headEntity.set世帯支給総額(trimDecimal(entity.get高額合算支給額計算結果一時().getSetaiShikyuSogaku()));
        headEntity.setうち70歳以上分世帯支給総額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getOver70_SetaiShikyuSogaku()));
        headEntity.set按分後支給額(trimDecimal(entity.get高額合算支給額計算結果一時().getHonninShikyugaku()));
        headEntity.setうち70歳以上分按分後支給額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getOver70_honninShikyugaku()));
        headEntity.set介護低所得者Ⅰ再計算実施の有無(
                trimRString(entity.get高額合算支給額計算結果一時().getTeiShotoku_1_SaiKeisanUmu()));
        headEntity.set備考(囲み文字(trimRString(entity.get高額合算支給額計算結果一時().getBiko())));
        YubinNo 宛先郵便番号 = entity.get高額合算支給額計算結果一時().getKekkaRenrakusakiYubinNo();
        RString 宛先郵便番号R
                = 宛先郵便番号 == null || 宛先郵便番号.isEmpty() ? RString.EMPTY : 宛先郵便番号.getColumnValue().trim();
        headEntity.set支給額計算結果連絡先郵便番号(宛先郵便番号R);
        RString 支給額計算結果連絡先住所 = entity.get高額合算支給額計算結果一時().getKekkaRenrakusakiJusho();
        if (支給額計算結果連絡先住所 != null) {
            headEntity.set支給額計算結果連絡先住所(囲み文字(
                    trimRString(INT_64 < 支給額計算結果連絡先住所.length()
                            ? 支給額計算結果連絡先住所.substring(0, INT_64) : 支給額計算結果連絡先住所)));
        }
        RString 支給額計算結果連絡先名称1 = entity.get高額合算支給額計算結果一時().getKetteRenrakusakiMeisho1();
        if (支給額計算結果連絡先名称1 != null) {
            headEntity.set支給額計算結果連絡先名称1(囲み文字(
                    trimRString(INT_20 < 支給額計算結果連絡先名称1.length()
                            ? 支給額計算結果連絡先名称1.substring(0, INT_20) : 支給額計算結果連絡先名称1)));
        }
        RString 支給額計算結果連絡先名称2 = entity.get高額合算支給額計算結果一時().getKekkaRenrakusakiMeisho2();
        if (支給額計算結果連絡先名称2 != null) {
            headEntity.set支給額計算結果連絡先名称2(囲み文字(
                    trimRString(INT_20 < 支給額計算結果連絡先名称2.length()
                            ? 支給額計算結果連絡先名称2.substring(0, INT_20) : 支給額計算結果連絡先名称2)));
        }
        headEntity.set通知年月日(trimDate(entity.get高額合算支給額計算結果一時().getTsuchiYMD()));
        setヘッダーレコード(headEntity, entity);
        eucCsvWriter.writeLine(headEntity);
    }

    private void setヘッダーレコード(KogakuGassanKeisanKekkaRenrakuJohoHeadEntity headEntity,
            KogakuGassanKeisanKekkaRenrakuJohoRelateEntity entity) {
        AtenaMeisho 連絡票発行者名 = entity.get高額合算支給額計算結果一時().getRenrakuhyoHakkoshaMei();
        if (連絡票発行者名 != null && !連絡票発行者名.isEmpty()) {
            headEntity.set連絡票発行者名(囲み文字(
                    INT_50 < 連絡票発行者名.getColumnValue().length()
                    ? 連絡票発行者名.getColumnValue().substring(0, INT_50).trim() : 連絡票発行者名.getColumnValue()));
        }
        YubinNo 連絡票発行者郵便番号 = entity.get高額合算支給額計算結果一時().getRenrakuhyoHakkoshaYubinNo();
        RString 連絡票発行者郵便番号R
                = 連絡票発行者郵便番号 == null || 連絡票発行者郵便番号.isEmpty()
                ? RString.EMPTY : 連絡票発行者郵便番号.getColumnValue().trim();
        headEntity.set連絡票発行者郵便番号(連絡票発行者郵便番号R);
        RString 連絡票発行者住所 = entity.get高額合算支給額計算結果一時().getRenrakuhyoHakkoshaJusho();
        if (連絡票発行者住所 != null) {
            headEntity.set連絡票発行者住所(囲み文字(trimRString(INT_64 < 連絡票発行者住所.length()
                    ? 連絡票発行者住所.substring(0, INT_64) : 連絡票発行者住所)));
        }
        YubinNo 問い合わせ先郵便番号 = entity.get高額合算支給額計算結果一時().getToiawasesakiYobinNo();
        RString 問い合わせ先郵便番号R
                = 問い合わせ先郵便番号 == null || 問い合わせ先郵便番号.isEmpty()
                ? RString.EMPTY : 問い合わせ先郵便番号.getColumnValue().trim();
        headEntity.set問い合わせ先郵便番号(問い合わせ先郵便番号R);
        RString 問い合わせ先住所 = entity.get高額合算支給額計算結果一時().getToiawasesakiJusho();
        if (問い合わせ先住所 != null) {
            headEntity.set問い合わせ先住所(囲み文字(trimRString(INT_64 < 問い合わせ先住所.length()
                    ? 問い合わせ先住所.substring(0, INT_64) : 問い合わせ先住所)));
        }
        RString 問い合わせ先名称1 = entity.get高額合算支給額計算結果一時().getToiawasesakiMeisho1();
        if (問い合わせ先名称1 != null) {
            headEntity.set問い合わせ先名称1(囲み文字(trimRString(INT_20 < 問い合わせ先名称1.length()
                    ? 問い合わせ先名称1.substring(0, INT_20) : 問い合わせ先名称1)));
        }
        RString 問い合わせ先名称2 = entity.get高額合算支給額計算結果一時().getToiawasesakiMeisho2();
        if (問い合わせ先名称2 != null) {
            headEntity.set問い合わせ先名称2(囲み文字(trimRString(INT_20 < 問い合わせ先名称2.length()
                    ? 問い合わせ先名称2.substring(0, INT_20) : 問い合わせ先名称2)));
        }
        TelNo 問い合わせ先電話番号 = entity.get高額合算支給額計算結果一時().getToiawasesakiTelNo();
        RString 問い合わせ先電話番号R
                = 問い合わせ先電話番号 == null || 問い合わせ先電話番号.isEmpty()
                ? RString.EMPTY : 問い合わせ先電話番号.getColumnValue().trim();
        headEntity.set問い合わせ先電話番号(囲み文字(問い合わせ先電話番号R));
    }

    private void データレコード出力(KogakuGassanKeisanKekkaRenrakuJohoRelateEntity entity) {
        for (DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity 明細 : entity.get高額合算支給額計算結果明細リスト()) {
            レコード番号 = レコード番号 + INT_1;
            総出力件数 = 総出力件数 + INT_1;
            KogakuGassanKeisanKekkaRenrakuJohoDataEntity dataEntity = new KogakuGassanKeisanKekkaRenrakuJohoDataEntity();
            dataEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
            dataEntity.setレコード番号_連番(new RString(レコード番号));
            dataEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額合算計算結果連絡票情報.getコード());
            dataEntity.setレコード種別２(DataRecordShubetsu.データレコード.getコード());
            dataEntity.set保険制度コード(trimRString(明細.getHokenSeidoCode()));
            dataEntity.set保険者番号(trimRString(明細.getUchiwakeHokenshaNo()));
            dataEntity.set被保険者証記号(trimRString(明細.getKokuho_HihokenshaShoKigo()));
            dataEntity.set被保険者_証_番号(trimRString(明細.getHiHokenshaShoNo()));
            dataEntity.set保険者名(囲み文字(trimRString(明細.getUchiwakeHokenshaMei())));
            dataEntity.set自己負担額証明書整理番号(trimRString(明細.getJikoFutanSeiriNo()));
            dataEntity.set対象者氏名_漢字(囲み文字(trimRString(明細.getTaishoshaShimei())));
            dataEntity.setななじゅう歳以上負担額(trimRString(明細.getOver70_Futangaku()));
            dataEntity.setななじゅう歳以上按分率(trimRString(明細.getOver70_AmbunRitsu()));
            dataEntity.setななじゅう歳以上支給額(trimRString(明細.getOver70_Shikyugaku()));
            dataEntity.setななじゅう歳未満負担額(trimRString(明細.getUnder70_Futangaku()));
            dataEntity.set負担額(trimRString(明細.getFutangaku()));
            dataEntity.set按分率(trimRString(明細.getAmbunRitsu()));
            dataEntity.setななじゅう歳未満支給額(trimRString(明細.getUnder70_Shikyugaku()));
            dataEntity.set支給額(trimRString(明細.getShikyugaku()));
            dataEntity.set備考欄記載70歳以上負担額(trimRString(明細.getOver70_Biko()));
            dataEntity.set備考欄記載70歳未満負担額(trimRString(明細.getUnder70_Biko()));
            eucCsvWriter.writeLine(dataEntity);
        }
    }

    private void トレーラレコード出力(KogakuGassanKeisanKekkaRenrakuJohoRelateEntity entity) {
        レコード番号 = レコード番号 + INT_1;
        総出力件数 = 総出力件数 + INT_1;
        KogakuGassanKeisanKekkaRenrakuJohoToreraEntity トレーラEntity
                = new KogakuGassanKeisanKekkaRenrakuJohoToreraEntity();
        トレーラEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        トレーラEntity.setレコード番号_連番(new RString(レコード番号));
        トレーラEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額合算計算結果連絡票情報.getコード());
        トレーラEntity.setレコード種別２(DataRecordShubetsu.トレーラレコード.getコード());
        トレーラEntity.setななじゅう歳以上負担額合計(
                trimDecimal(entity.get高額合算支給額計算結果一時().getOver70_FutangakuGokei()));

        トレーラEntity.setななじゅう歳以上支給額合計(
                trimDecimal(entity.get高額合算支給額計算結果一時().getOver70_ShikyugakuGokei()));
        トレーラEntity.setななじゅう歳未満負担額合計(
                trimDecimal(entity.get高額合算支給額計算結果一時().getUnder70_FutangakuGokei()));
        トレーラEntity.set負担額の合計額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getFutangakuGokei()));
        トレーラEntity.setななじゅう歳未満支給額合計(
                trimDecimal(entity.get高額合算支給額計算結果一時().getUnder70_ShikyugakuGokei()));
        トレーラEntity.set支給額合計額(
                trimDecimal(entity.get高額合算支給額計算結果一時().getShikyugakuGokei()));
        eucCsvWriter.writeLine(トレーラEntity);
    }

    private void エンドレコード出力() {
        レコード番号 = レコード番号 + INT_1;
        KogakuGassanKeisanKekkaRenrakuJohoEndEntity endEntity = new KogakuGassanKeisanKekkaRenrakuJohoEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号));
        eucCsvWriter.writeLine(endEntity);
    }

    private RString getレコード件数() {
        int 計算結果レコード件数 = 0;
        int 明細レコード件数 = 0;
        IKogakugassanKeisankekkaRenrakuhyoOutMapper mapper = getMapper(IKogakugassanKeisankekkaRenrakuhyoOutMapper.class);
        List<KogakuGassanKeisanKekkaRenrakuJohoTmpEntity> tmpEntityList
                = mapper.get送付ファイル作成データ();
        if (tmpEntityList != null && !tmpEntityList.isEmpty()) {
            明細レコード件数 = tmpEntityList.size();
            List<Integer> 連番List = new ArrayList<>();
            for (KogakuGassanKeisanKekkaRenrakuJohoTmpEntity tmpEntity : tmpEntityList) {
                if (!連番List.contains(tmpEntity.get高額合算支給額計算結果一時().getRenban())) {
                    連番List.add(tmpEntity.get高額合算支給額計算結果一時().getRenban());
                }
            }
            計算結果レコード件数 = 連番List.size();
        }

        return new RString(計算結果レコード件数 * INT_2 + 明細レコード件数);
    }

    private RString trimDecimal(Decimal dec) {
        return dec == null ? RString.EMPTY : new RString(dec.toString());
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString trimDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY
                : date.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE).toDateString();
    }

    private RString 囲み文字(RString str) {
        return 囲み文字.concat(str).concat(囲み文字);
    }

    private RString trimYear(FlexibleYear year) {
        return year == null || year.isEmpty() ? RString.EMPTY
                : year.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).toDateString();
    }
}
