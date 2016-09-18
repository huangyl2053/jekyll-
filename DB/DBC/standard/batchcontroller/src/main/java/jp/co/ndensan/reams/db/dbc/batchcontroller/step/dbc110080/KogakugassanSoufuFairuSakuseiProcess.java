/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110080;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikofutangakuMeisaiTaishoTsuki;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassan.KogakugassanProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan.SyuturyokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassanhoseisumijikofutangaku.KogakugassanFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 高額合算補正済自己負担額情報作成のバッチ送付ファイル作成Processです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public class KogakugassanSoufuFairuSakuseiProcess extends BatchProcessBase<SyuturyokuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassan."
            + "IKogakugassanHoseisumiJikofutangakuOutMapper.get出力対象データ");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString ファイル名_前 = new RString("10_37K");
    private static final RString ファイル名_後 = new RString(".csv");
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final int INT_0 = 0;
    private static final RString RSTRING_0 = new RString("0");
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
    private KogakugassanProcessParameter processParameter;
    private int 総出力件数;
    private int レコード番号;
    private Encode 文字コード;
    private RString eucFilePath;
    private RString 出力ファイル名;
    private int レコード件数;
    private int renben;
    private KogakugassanSoufuFairuSakuseiMeisaiEntity meisEntity;
    @BatchWriter
    private CsvWriter eucCsvWriter;

    @Override
    protected void initialize() {
        レコード件数 = KogakugassanFinder.createInstance().get出力対象データ().size();
        outputCount = new OutputParameter<>();
        outputEntry = new OutputParameter<>();
        entryList = new ArrayList<>();
        meisEntity = new KogakugassanSoufuFairuSakuseiMeisaiEntity();
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
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        出力ファイル名 = ファイル名_前.concat(processParameter.getShoriKunbun())
                .concat(processParameter.get保険者情報_保険者番号()).concat(processParameter.getShoriYM().toDateString()).concat(ファイル名_後);
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
    protected void process(SyuturyokuEntity entity) {
        if (レコード番号 == INT_0) {
            renben = entity.get高額合算自己負担額一時Entity().getRenban();
            レコード番号 = レコード番号 + 1;
            KogakugassanSoufuFairuSakuseiControlEntity controlEntity = getControlEntity();
            eucCsvWriter.writeLine(controlEntity);
            レコード番号 = レコード番号 + 1;
        }
        総出力件数 = 総出力件数 + 1;
        if (renben != entity.get高額合算自己負担額一時Entity().getRenban()) {
            レコード番号 = レコード番号 + 1;
            eucCsvWriter.writeLine(meisEntity);
            renben = entity.get高額合算自己負担額一時Entity().getRenban();
            meisEntity = getMeisaiEntity(entity);
        } else {
            meisEntity = getMeisaiEntity(entity);
        }
    }

    @Override
    protected void afterExecute() {
        if (レコード番号 != INT_0) {
            eucCsvWriter.writeLine(meisEntity);
            レコード番号 = レコード番号 + 1;
            KogakugassanSoufuFairuSakuseiEndEntity endEntity = getEndEntity();
            eucCsvWriter.writeLine(endEntity);
            SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力ファイル名));
            sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
            SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(eucFilePath), opts);
            entryList.add(sfd);
        }
        outputCount.setValue(総出力件数);
        outputEntry.setValue(entryList);
        eucCsvWriter.close();
    }

    private KogakugassanSoufuFairuSakuseiEndEntity getEndEntity() {
        KogakugassanSoufuFairuSakuseiEndEntity endEntity = new KogakugassanSoufuFairuSakuseiEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号));
        return endEntity;
    }

    private KogakugassanSoufuFairuSakuseiMeisaiEntity getMeisaiEntity(SyuturyokuEntity entity) {
        DbWT37K1KogakuGassanJikoFutanGakuTempEntity 高額合算自己負担額一時Entity = entity.get高額合算自己負担額一時Entity();
        KogakugassanSoufuFairuSakuseiMeisaiEntity meisaiEntity = new KogakugassanSoufuFairuSakuseiMeisaiEntity();
        meisaiEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        meisaiEntity.setレコード番号_連番(new RString(レコード番号));
        meisaiEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額合算補正済自己負担額情報.getコード());
        meisaiEntity.set支給申請書整理番号(trimRString(高額合算自己負担額一時Entity.getShikyuShinseishoSeiriNo()));
        meisaiEntity.set保険制度コード(trimRString(高額合算自己負担額一時Entity.getHokenSeidoCode()));
        HokenshaNo 保険者番号 = 高額合算自己負担額一時Entity.getHokenshaNo();
        RString 保険者番号R = 保険者番号 == null || 保険者番号.isEmpty() ? RString.EMPTY : 保険者番号.getColumnValue().trim();
        meisaiEntity.set保険者番号(保険者番号R);
        meisaiEntity.set保険者名称(囲み文字(trimRString(高額合算自己負担額一時Entity.getHokenshaMei())));
        meisaiEntity.set被保険者証記号(trimRString(高額合算自己負担額一時Entity.getKokuho_HihokenshaShoKigo()));
        HihokenshaNo 被保険者番号 = 高額合算自己負担額一時Entity.getHihokenshaNo();
        RString 被保険者番号R = 被保険者番号 == null || 被保険者番号.isEmpty() ? RString.EMPTY : 被保険者番号.getColumnValue().trim();
        meisaiEntity.set被保険者証番号(被保険者番号R);
        AtenaKanaMeisho 被保険者氏名カナ = 高額合算自己負担額一時Entity.getHihokenshaShimeiKana();
        RString 被保険者氏名カナR
                = 被保険者氏名カナ == null || 被保険者氏名カナ.isEmpty() ? RString.EMPTY : 被保険者氏名カナ.getColumnValue().trim();
        // TODO 25バイト QA1430
        meisaiEntity.set被保険者氏名_カナ(囲み文字(被保険者氏名カナR));
        AtenaMeisho 被保険者氏名_漢字 = 高額合算自己負担額一時Entity.getHihokenshaShimei();
        RString 被保険者氏名_漢字R
                = 被保険者氏名_漢字 == null || 被保険者氏名_漢字.isEmpty() ? RString.EMPTY : 被保険者氏名_漢字.getColumnValue().trim();
        // TODO 40バイト QA1430
        meisaiEntity.set被保険者氏名_漢字(囲み文字(被保険者氏名_漢字R));
        meisaiEntity.set生年月日(trimDate(高額合算自己負担額一時Entity.getUmareYMD()));
        Code 性別 = 高額合算自己負担額一時Entity.getSeibetsuCode();
        RString 性別R = 性別 == null || 性別.isEmpty() ? RString.EMPTY : 性別.getColumnValue().trim();
        meisaiEntity.set性別(性別R);
        meisaiEntity.set所得区分(trimRString(高額合算自己負担額一時Entity.getShotokuKubun()));
        meisaiEntity.set所得区分_70歳以上の者係る(trimRString(高額合算自己負担額一時Entity.getOver70_ShotokuKubun()));
        meisaiEntity.set自己負担額証明書整理番号(trimRString(高額合算自己負担額一時Entity.getJikoFutanSeiriNo()));
        meisaiEntity.set突合用後期高齢者医療保険者番号(trimRString(高額合算自己負担額一時Entity.getKoki_HokenshaNo()));
        meisaiEntity.set突合用後期高齢者医療被保険者番号(trimRString(高額合算自己負担額一時Entity.getKoki_HihokenshaNo()));
        meisaiEntity.set突合用国民健康保険保険者番号(trimRString(高額合算自己負担額一時Entity.getKokuho_HokenshaNo()));
        meisaiEntity.set突合用国民健康保険被保険者証番号(trimRString(高額合算自己負担額一時Entity.getKokuho_HihokenshaShoNo()));
        meisaiEntity.set突合用国保被保険者個人番号(trimRString(高額合算自己負担額一時Entity.getKokuho_KojinNo()));
        meisaiEntity.set異動区分(trimRString(高額合算自己負担額一時Entity.getIdoKubun()));
        meisaiEntity.set補正済自己負担額送付区分(trimRString(高額合算自己負担額一時Entity.getHoseiZumiSofuKubun()));
        meisaiEntity.set対象年度(trimYear(高額合算自己負担額一時Entity.getTaishoNendo()));
        meisaiEntity.set対象計算期間_開始(trimDate(高額合算自己負担額一時Entity.getTaishoKeisanKaishiYMD()));
        meisaiEntity.set対象計算期間_終了(trimDate(高額合算自己負担額一時Entity.getTaishoKeisanShuryoYMD()));
        meisaiEntity.set被保険者期間_開始(trimDate(高額合算自己負担額一時Entity.getHihokenshaKaishiYMD()));
        meisaiEntity.set被保険者期間_終了(trimDate(高額合算自己負担額一時Entity.getHihokenshaShuryoYMD()));
        meisaiEntity.set申請年月日(trimDate(高額合算自己負担額一時Entity.getShinseiYMD()));
        meisaiEntity = getMeisaiEntity2(meisaiEntity, entity);
        meisaiEntity = getMeisaiEntity3(meisaiEntity, entity);
        meisaiEntity.set合計_自己負担額(trimDecimal(高額合算自己負担額一時Entity.getSumi_Gokei_JikoFutanGaku()));
        meisaiEntity.set合計_うち70_74歳の者に係る負担額(trimDecimal(高額合算自己負担額一時Entity.getSumi_Gokei_70_74JikoFutanGaku()));
        meisaiEntity.set合計_70歳未満高額療養費支給額(trimDecimal(高額合算自己負担額一時Entity.getSumi_Gokei_Under70KogakuShikyuGaku()));
        meisaiEntity.set合計_70_74歳高額療養費支給額(trimDecimal(高額合算自己負担額一時Entity.getSumi_Gokei_70_74KogakuShikyuGaku()));

        AtenaMeisho 宛先氏名 = 高額合算自己負担額一時Entity.getAtesakiShimei();
        RString 宛先氏名R = 宛先氏名 == null || 宛先氏名.isEmpty() ? RString.EMPTY : 宛先氏名.getColumnValue().trim();
        // TODO 40バイト QA1430
        meisaiEntity.set宛先氏名(囲み文字(宛先氏名R));
        YubinNo 宛先郵便番号 = 高額合算自己負担額一時Entity.getAtesakiYubinNo();
        RString 宛先郵便番号R = 宛先郵便番号 == null || 宛先郵便番号.isEmpty() ? RString.EMPTY : 宛先郵便番号.getColumnValue().trim();
        meisaiEntity.set宛先郵便番号(宛先郵便番号R);
        // TODO 128バイト QA1430
        meisaiEntity.set宛先住所(囲み文字(trimRString(高額合算自己負担額一時Entity.getAtesakiJusho())));
        meisaiEntity.set証明書発行年月日(RString.EMPTY);
        meisaiEntity.set証明書発行者名(RString.EMPTY);
        meisaiEntity.set証明書発行者郵便番号(RString.EMPTY);
        meisaiEntity.set証明書発行者住所(RString.EMPTY);
        meisaiEntity.set問い合わせ先郵便番号(RString.EMPTY);
        meisaiEntity.set問い合わせ先住所(RString.EMPTY);
        meisaiEntity.set問い合わせ先名称1(RString.EMPTY);
        meisaiEntity.set問い合わせ先名称2(RString.EMPTY);
        meisaiEntity.set問い合わせ先電話番号(RString.EMPTY);
        meisaiEntity.set計算結果送付先郵便番号(RString.EMPTY);
        meisaiEntity.set計算結果送付先住所(RString.EMPTY);
        meisaiEntity.set計算結果送付先名称1(RString.EMPTY);
        meisaiEntity.set計算結果送付先名称2(RString.EMPTY);
        meisaiEntity.set計算結果送付先電話番号(RString.EMPTY);
        meisaiEntity.set窓口払対象者判定コード(trimRString(高額合算自己負担額一時Entity.getMadoguchi_TaishoshaHanteiCode()));
        meisaiEntity.set支払場所(囲み文字(trimRString(高額合算自己負担額一時Entity.getShiharaiBasho())));
        meisaiEntity.set支払期間開始年月日(trimDate(高額合算自己負担額一時Entity.getShikaraiKaishiYMD()));
        meisaiEntity.set支払期間終了年月日(trimDate(高額合算自己負担額一時Entity.getShiharaiShuryoYMD()));
        meisaiEntity.set支払期間開始年月日_曜日(get曜日略称(高額合算自己負担額一時Entity.getShikaraiKaishiYMD()));
        meisaiEntity.set支払期間終了年月日_曜日(get曜日略称(高額合算自己負担額一時Entity.getShiharaiShuryoYMD()));
        meisaiEntity.set支払期間開始年月日_開始時間(trimRString(高額合算自己負担額一時Entity.getShiharaiKaishiTime()));
        meisaiEntity.set支払期間終了年月日_終了時間(trimRString(高額合算自己負担額一時Entity.getShiharaiShuryoTime()));
        meisaiEntity.set備考欄(囲み文字(trimRString(高額合算自己負担額一時Entity.getBiko())));
        return meisaiEntity;
    }

    private KogakugassanSoufuFairuSakuseiMeisaiEntity getMeisaiEntity2(
            KogakugassanSoufuFairuSakuseiMeisaiEntity meisaiEntity, SyuturyokuEntity entity) {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity meisai = entity.get高額合算自己負担額明細();
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_4月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度4月.getコード(), meisai);
        if (明細_4月分 != null) {
            meisaiEntity.set月分4_自己負担額(trimDecimal(明細_4月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分4_うち70_74歳の者に係る負担額(trimDecimal(明細_4月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分4_70歳未満高額療養費支給額(trimDecimal(明細_4月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分4_70_74歳高額療養費支給額(trimDecimal(明細_4月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分4_摘要(囲み文字(trimRString(明細_4月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分4_自己負担額(RString.EMPTY);
            meisaiEntity.set月分4_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分4_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分4_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分4_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_5月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度5月.getコード(), meisai);
        if (明細_5月分 != null) {
            meisaiEntity.set月分5_自己負担額(trimDecimal(明細_5月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分5_うち70_74歳の者に係る負担額(trimDecimal(明細_5月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分5_70歳未満高額療養費支給額(trimDecimal(明細_5月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分5_70_74歳高額療養費支給額(trimDecimal(明細_5月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分5_摘要(囲み文字(trimRString(明細_5月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分5_自己負担額(RString.EMPTY);
            meisaiEntity.set月分5_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分5_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分5_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分5_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_6月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度6月.getコード(), meisai);
        if (明細_6月分 != null) {
            meisaiEntity.set月分6_自己負担額(trimDecimal(明細_6月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分6_うち70_74歳の者に係る負担額(trimDecimal(明細_6月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分6_70歳未満高額療養費支給額(trimDecimal(明細_6月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分6_70_74歳高額療養費支給額(trimDecimal(明細_6月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分6_摘要(囲み文字(trimRString(明細_6月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分6_自己負担額(RString.EMPTY);
            meisaiEntity.set月分6_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分6_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分6_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分6_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_7月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度7月.getコード(), meisai);
        if (明細_7月分 != null) {
            meisaiEntity.set月分7_自己負担額(trimDecimal(明細_7月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分7_うち70_74歳の者に係る負担額(trimDecimal(明細_7月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分7_70歳未満高額療養費支給額(trimDecimal(明細_7月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分7_70_74歳高額療養費支給額(trimDecimal(明細_7月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分7_摘要(囲み文字(trimRString(明細_7月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分7_自己負担額(RString.EMPTY);
            meisaiEntity.set月分7_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分7_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分7_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分7_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_8月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度8月.getコード(), meisai);
        if (明細_8月分 != null) {
            meisaiEntity.set月分8_自己負担額(trimDecimal(明細_8月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分8_うち70_74歳の者に係る負担額(trimDecimal(明細_8月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分8_70歳未満高額療養費支給額(trimDecimal(明細_8月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分8_70_74歳高額療養費支給額(trimDecimal(明細_8月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分8_摘要(囲み文字(trimRString(明細_8月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分8_自己負担額(RString.EMPTY);
            meisaiEntity.set月分8_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分8_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分8_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分8_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_9月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度9月.getコード(), meisai);
        if (明細_9月分 != null) {
            meisaiEntity.set月分9_自己負担額(trimDecimal(明細_9月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分9_うち70_74歳の者に係る負担額(trimDecimal(明細_9月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分9_70歳未満高額療養費支給額(trimDecimal(明細_9月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分9_70_74歳高額療養費支給額(trimDecimal(明細_9月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分9_摘要(囲み文字(trimRString(明細_9月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分9_自己負担額(RString.EMPTY);
            meisaiEntity.set月分9_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分9_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分9_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分9_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_10月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度10月.getコード(), meisai);
        if (明細_10月分 != null) {
            meisaiEntity.set月分10_自己負担額(trimDecimal(明細_10月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分10_うち70_74歳の者に係る負担額(trimDecimal(明細_10月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分10_70歳未満高額療養費支給額(trimDecimal(明細_10月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分10_70_74歳高額療養費支給額(trimDecimal(明細_10月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分10_摘要(囲み文字(trimRString(明細_10月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分10_自己負担額(RString.EMPTY);
            meisaiEntity.set月分10_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分10_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分10_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分10_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_11月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度11月.getコード(), meisai);
        if (明細_11月分 != null) {
            meisaiEntity.set月分11_自己負担額(trimDecimal(明細_11月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分11_うち70_74歳の者に係る負担額(trimDecimal(明細_11月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分11_70歳未満高額療養費支給額(trimDecimal(明細_11月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分11_70_74歳高額療養費支給額(trimDecimal(明細_11月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分11_摘要(囲み文字(trimRString(明細_11月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分11_自己負担額(RString.EMPTY);
            meisaiEntity.set月分11_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分11_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分11_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分11_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_12月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度12月.getコード(), meisai);
        if (明細_12月分 != null) {
            meisaiEntity.set月分12_自己負担額(trimDecimal(明細_12月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分12_うち70_74歳の者に係る負担額(trimDecimal(明細_12月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分12_70歳未満高額療養費支給額(trimDecimal(明細_12月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分12_70_74歳高額療養費支給額(trimDecimal(明細_12月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分12_摘要(囲み文字(trimRString(明細_12月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分12_自己負担額(RString.EMPTY);
            meisaiEntity.set月分12_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分12_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分12_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分12_摘要(RString.EMPTY);
        }
        return meisaiEntity;
    }

    private KogakugassanSoufuFairuSakuseiMeisaiEntity getMeisaiEntity3(
            KogakugassanSoufuFairuSakuseiMeisaiEntity meisaiEntity, SyuturyokuEntity entity) {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity meisai = entity.get高額合算自己負担額明細();
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年1月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年1月.getコード(), meisai);
        if (明細_翌年1月分 != null) {
            meisaiEntity.set月分翌年1_自己負担額(trimDecimal(明細_翌年1月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年1_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年1月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年1_70歳未満高額療養費支給額(trimDecimal(明細_翌年1月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年1_70_74歳高額療養費支給額(trimDecimal(明細_翌年1月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年1_摘要(囲み文字(trimRString(明細_翌年1月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年1_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年1_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年1_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年1_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年1_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年2月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年2月.getコード(), meisai);
        if (明細_翌年2月分 != null) {
            meisaiEntity.set月分翌年2_自己負担額(trimDecimal(明細_翌年2月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年2_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年2月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年2_70歳未満高額療養費支給額(trimDecimal(明細_翌年2月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年2_70_74歳高額療養費支給額(trimDecimal(明細_翌年2月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年2_摘要(囲み文字(trimRString(明細_翌年2月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年2_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年2_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年2_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年2_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年2_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年3月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年3月.getコード(), meisai);
        if (明細_翌年3月分 != null) {
            meisaiEntity.set月分翌年3_自己負担額(trimDecimal(明細_翌年3月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年3_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年3月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年3_70歳未満高額療養費支給額(trimDecimal(明細_翌年3月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年3_70_74歳高額療養費支給額(trimDecimal(明細_翌年3月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年3_摘要(囲み文字(trimRString(明細_翌年3月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年3_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年3_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年3_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年3_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年3_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年4月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年4月.getコード(), meisai);
        if (明細_翌年4月分 != null) {
            meisaiEntity.set月分翌年4_自己負担額(trimDecimal(明細_翌年4月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年4_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年4月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年4_70歳未満高額療養費支給額(trimDecimal(明細_翌年4月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年4_70_74歳高額療養費支給額(trimDecimal(明細_翌年4月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年4_摘要(囲み文字(trimRString(明細_翌年4月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年4_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年4_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年4_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年4_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年4_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年5月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年5月.getコード(), meisai);
        if (明細_翌年5月分 != null) {
            meisaiEntity.set月分翌年5_自己負担額(trimDecimal(明細_翌年5月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年5_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年5月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年5_70歳未満高額療養費支給額(trimDecimal(明細_翌年5月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年5_70_74歳高額療養費支給額(trimDecimal(明細_翌年5月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年5_摘要(囲み文字(trimRString(明細_翌年5月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年5_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年5_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年5_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年5_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年5_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年6月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年6月.getコード(), meisai);
        if (明細_翌年6月分 != null) {
            meisaiEntity.set月分翌年6_自己負担額(trimDecimal(明細_翌年6月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年6_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年6月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年6_70歳未満高額療養費支給額(trimDecimal(明細_翌年6月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年6_70_74歳高額療養費支給額(trimDecimal(明細_翌年6月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年6_摘要(囲み文字(trimRString(明細_翌年6月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年6_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年6_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年6_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年6_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年6_摘要(RString.EMPTY);
        }

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 明細_翌年7月分
                = get高額合算自己負担額明細(KaigoGassan_JikofutangakuMeisaiTaishoTsuki.対象年度翌年7月.getコード(), meisai);
        if (明細_翌年7月分 != null) {
            meisaiEntity.set月分翌年7_自己負担額(trimDecimal(明細_翌年7月分.getSumi_JikoFutanGaku()));
            meisaiEntity.set月分翌年7_うち70_74歳の者に係る負担額(trimDecimal(明細_翌年7月分.getSumi_70_74JikoFutanGaku()));
            meisaiEntity.set月分翌年7_70歳未満高額療養費支給額(trimDecimal(明細_翌年7月分.getSumi_under_70KogakuShikyuGaku()));
            meisaiEntity.set月分翌年7_70_74歳高額療養費支給額(trimDecimal(明細_翌年7月分.getSumi_70_74KogakuShikyuGaku()));
            meisaiEntity.set月分翌年7_摘要(囲み文字(trimRString(明細_翌年7月分.getSumi_Tekiyo())));
        } else {
            meisaiEntity.set月分翌年7_自己負担額(RString.EMPTY);
            meisaiEntity.set月分翌年7_うち70_74歳の者に係る負担額(RString.EMPTY);
            meisaiEntity.set月分翌年7_70歳未満高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年7_70_74歳高額療養費支給額(RString.EMPTY);
            meisaiEntity.set月分翌年7_摘要(RString.EMPTY);
        }
        return meisaiEntity;
    }

    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntity get高額合算自己負担額明細(RString 対象月, DbT3071KogakuGassanJikoFutanGakuMeisaiEntity meisaiEntity) {
        if (meisaiEntity == null) {
            return null;
        }
        if (対象月.equals(meisaiEntity.getTaishoM())) {
            return meisaiEntity;
        }
        return null;
    }

    private RString get曜日略称(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY : new RString(date.getDayOfWeek().getShortTerm());
    }

    private RString trimYear(FlexibleYear year) {
        return year == null || year.isEmpty() ? RString.EMPTY
                : year.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).toDateString();
    }

    private RString trimDate(FlexibleDate date) {
        return date == null || date.isEmpty() ? RString.EMPTY
                : date.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE).toDateString();
    }

    private RString trimDecimal(Decimal dec) {
        return dec == null ? RString.EMPTY : new RString(dec.toString());
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString 囲み文字(RString str) {
        return 囲みの文字.concat(str).concat(囲みの文字);
    }

    private KogakugassanSoufuFairuSakuseiControlEntity getControlEntity() {
        KogakugassanSoufuFairuSakuseiControlEntity controlEntity = new KogakugassanSoufuFairuSakuseiControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_0);
        controlEntity.setレコード件数(new RString(レコード件数));
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.高額合算補正済自己負担額情報.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_0);
        controlEntity.set保険者番号(processParameter.get保険者情報_保険者番号());
        controlEntity.set事業所番号(RSTRING_0);
        controlEntity.set都道府県番号(RSTRING_0);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(processParameter.getShoriYM().toDateString());
        controlEntity.setファイル管理番号(RSTRING_0);
        return controlEntity;
    }
}
