/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.DataRecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.KozaKyomuBetsuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060.SofuFileSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110060.KogakugassanShikyushinseishoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110060.KogakuGassanShinseishoSofuFileHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110060.KogakuGassanShinseishoSofuFileMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiControlEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan.KogakugassanSoufuFairuSakuseiEndEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.DbWT3711KogakuGassanShinseishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoSofuFileEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060.IKogakugassanShikyushinseishoOutMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 高額合算支給申請書情報作成の送付ファイル作成Process
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class KogakugassanShikyushinseishoOutSofuFileSakuseiProcess extends BatchProcessBase<KogakuGassanShinseishoSofuFileEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.get送付ファイル作成データ");
    private static final RString 支払方法区分_2 = new RString("2");
    private static final RString カンマ = new RString(",");
    private static final RString ファイル名_前 = new RString("10_371");
    private static final RString ファイル_TYPE = new RString(".csv");
    private static final RString 囲みの文字 = new RString("\"");
    private static final RString 加入歴番号_01 = new RString("01");
    private static final RString 加入歴番号_02 = new RString("02");
    private static final RString 加入歴番号_03 = new RString("03");
    private static final RString 加入歴番号_04 = new RString("04");
    private static final RString 加入歴番号_05 = new RString("05");
    private static final RString 加入歴番号_06 = new RString("06");
    private static final RString 加入歴番号_07 = new RString("07");
    private static final RString 加入歴番号_08 = new RString("08");
    private static final RString 加入歴番号_09 = new RString("09");
    private static final RString 加入歴番号_10 = new RString("10");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString COPY = new RString("copy");

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;

    private KogakugassanShikyushinseishoOutProcessParameter parameter;
    private SofuFileSakuseiMybatisParameter mybatisParameter;
    private int 総出力件数;
    private int レコード番号;
    private int 口座管理番号の件数;
    private RString csvFilePath;
    private RString csvFileName;
    private KogakuGassanShinseishoSofuFileEntity beforeEntity;
    private KogakuGassanShinseishoSofuFileMeisaiEntity meisaiCsvEntity;
    private OutputParameter<Integer> outputCount;
    private OutputParameter<RString> inputPath;
    private OutputParameter<RString> outputPath;
    private RString 入力ファイルパス;
    /**
     * 総出力件数カウンターとエントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTCOUNT;
    /**
     * inputPathです。
     */
    public static final RString INPUT_PATH;
    /**
     * outputPathです。
     */
    public static final RString OUTPUT_PATH;

    static {
        PARAMETER_OUT_OUTCOUNT = new RString("outputCount");
        INPUT_PATH = new RString("inputPath");
        OUTPUT_PATH = new RString("outputPath");
    }

    @BatchWriter
    private CsvWriter csvWriter;

    @Override
    protected void initialize() {
        総出力件数 = INDEX_0;
        レコード番号 = INDEX_0;
        口座管理番号の件数 = INDEX_0;
        outputCount = new OutputParameter<>();
        inputPath = new OutputParameter<>();
        outputPath = new OutputParameter<>();
        入力ファイルパス = RString.EMPTY;
        IKogakugassanShikyushinseishoOutMapper mapper = getMapper(IKogakugassanShikyushinseishoOutMapper.class);
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_高額合算 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_高額合算);
        KozaKyomuBetsuMybatisParameter mybatis = new KozaKyomuBetsuMybatisParameter();
        mybatis.set科目コード(介護給付_高額合算.getコード());
        RString 主キー = mapper.get業務別主キー(mybatis);
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(介護給付_高額合算.getコード())
                .set業務別主キー(主キー)
                .set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()))
                .set基準日(new FlexibleDate(RDate.getNowDate().toDateString())).build();
        List<KamokuCode> kamokuList = new ArrayList<>();
        kamokuList.add(介護給付_高額合算.getコード());
        mybatisParameter = new SofuFileSakuseiMybatisParameter(parameter.get保険者番号(), searchKey, kamokuList);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        csvFileName = ファイル名_前.concat(parameter.get保険者番号().getColumnValue()).
                concat(parameter.get処理年月().toDateString()).concat(ファイル_TYPE);
        csvFilePath = Path.combinePath(spoolWorkPath, csvFileName);
        if (Encode.UTF_8.equals(parameter.get文字コード())) {
            入力ファイルパス = Path.combinePath(spoolWorkPath, COPY.concat(csvFileName));
        } else {
            入力ファイルパス = csvFilePath;
        }
        csvWriter = new CsvWriter.InstanceBuilder(入力ファイルパス).
                setDelimiter(カンマ).
                setEnclosure(RString.EMPTY).
                setEncode(parameter.get文字コード()).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(KogakuGassanShinseishoSofuFileEntity entity) {

        if (beforeEntity == null) {
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getControlEntity());
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getHeadEntity(entity.get高額合算申請書一時()));
            総出力件数 = 総出力件数 + INDEX_1;
            レコード番号 = レコード番号 + INDEX_1;
            set口座管理番号の件数(entity);
            meisaiCsvEntity = getMeisaiEntity(entity);
        } else {
            RString 支給申請書整理番号 = beforeEntity.get高額合算申請書一時().getShikyuShinseishoSeiriNo();
            Decimal 履歴番号 = beforeEntity.get高額合算申請書一時().getRirekiNo();
            FlexibleYear 対象年度 = beforeEntity.get高額合算申請書一時().getTaishoNendo();
            RString 整理番号 = beforeEntity.get高額合算申請書一時().getSeiriNo();
            if (!支給申請書整理番号.equals(entity.get高額合算申請書一時().getShikyuShinseishoSeiriNo())
                    || !履歴番号.equals(entity.get高額合算申請書一時().getRirekiNo())) {
                csvWriter.writeLine(meisaiCsvEntity);
                総出力件数 = 総出力件数 + INDEX_1;
                レコード番号 = レコード番号 + INDEX_1;
                csvWriter.writeLine(getHeadEntity(entity.get高額合算申請書一時()));
                口座管理番号の件数 = INDEX_0;
                レコード番号 = レコード番号 + INDEX_1;
                set口座管理番号の件数(entity);
                meisaiCsvEntity = getMeisaiEntity(entity);
            } else if (!対象年度.equals(entity.get高額合算申請書一時().getTaishoNendo())
                    || !整理番号.equals(entity.get高額合算申請書一時().getSeiriNo())) {
                csvWriter.writeLine(meisaiCsvEntity);
                総出力件数 = 総出力件数 + INDEX_1;
                レコード番号 = レコード番号 + INDEX_1;
                set口座管理番号の件数(entity);
                meisaiCsvEntity = getMeisaiEntity(entity);
            } else {
                set高額合算申請書加入歴(meisaiCsvEntity, entity.get高額合算申請書加入歴());
            }
        }
        beforeEntity = entity;
    }

    @Override
    protected void afterExecute() {
        if (null != meisaiCsvEntity) {
            csvWriter.writeLine(meisaiCsvEntity);
            総出力件数 = 総出力件数 + INDEX_1;
            レコード番号 = レコード番号 + INDEX_1;
            csvWriter.writeLine(getEndEntity());
        }
        csvWriter.close();
        outputCount.setValue(総出力件数);
        inputPath.setValue(入力ファイルパス);
        outputPath.setValue(csvFilePath);
    }

    private void set口座管理番号の件数(KogakuGassanShinseishoSofuFileEntity entity) {
        if (支払方法区分_2.equals(entity.get高額合算申請書一時().getShiharaiHohoKubun())) {
            口座管理番号の件数 = 口座管理番号の件数 + INDEX_1;
        }
    }

    private KogakugassanSoufuFairuSakuseiControlEntity getControlEntity() {
        KogakugassanSoufuFairuSakuseiControlEntity controlEntity = new KogakugassanSoufuFairuSakuseiControlEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号));
        controlEntity.setボリュ_ム通番(RSTRING_0);
        controlEntity.setレコード件数(new RString(parameter.getレコード件数() + parameter.get件数()));
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.高額合算支給申請書情報.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_0);
        controlEntity.set保険者番号(parameter.get保険者番号().getColumnValue());
        controlEntity.set事業所番号(RSTRING_0);
        controlEntity.set都道府県番号(RSTRING_0);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(parameter.get処理年月().toDateString());
        controlEntity.setファイル管理番号(RSTRING_0);
        return controlEntity;
    }

    private KogakugassanSoufuFairuSakuseiEndEntity getEndEntity() {
        KogakugassanSoufuFairuSakuseiEndEntity endEntity = new KogakugassanSoufuFairuSakuseiEndEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号));
        return endEntity;
    }

    private KogakuGassanShinseishoSofuFileHeadEntity getHeadEntity(DbWT3711KogakuGassanShinseishoTempEntity entity) {
        KogakuGassanShinseishoSofuFileHeadEntity headEntity = new KogakuGassanShinseishoSofuFileHeadEntity();
        headEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        headEntity.setレコード番号(new RString(レコード番号));
        headEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額合算支給申請書情報.getコード());
        headEntity.setデータレコード種別(DataRecordShubetsu.ヘッダーレコード.getコード());
        if (entity.getHokenshaNo() != null) {
            headEntity.set提出保険者番号(entity.getHokenshaNo().getColumnValue());
        }
        headEntity.set支給申請書整理番号(trimRString(entity.getShikyuShinseishoSeiriNo()));
        headEntity.set支給申請区分(trimRString(entity.getShikyuShinseiKubun()));
        headEntity.set支給申請形態(trimRString(entity.getShikyuShinseiKeitai()));
        if (null != entity.getShinseiDaihyoshaShimei()) {
            headEntity.set申請代表者氏名(囲み文字(trimRString(entity.getShinseiDaihyoshaShimei().getColumnValue())));
        }
        if (null != entity.getShinseiDaihyoshaYubinNo()) {
            headEntity.set郵便番号(trimRString(entity.getShinseiDaihyoshaYubinNo().getColumnValue()));
        }
        headEntity.set住所(囲み文字(trimRString(entity.getShinseiDaihyoshaJusho())));
        if (null != entity.getShinseiDaihyoshaTelNo()) {
            headEntity.set電話番号(囲み文字(trimRString(entity.getShinseiDaihyoshaTelNo().getColumnValue())));
        }
        headEntity.set申請年月日(formatDate(entity.getShinseiYMD()));
        headEntity.set自己負担額証明書交付申請の有無(trimRString(entity.getJikoFutanKofuUmu()));
        return headEntity;
    }

    private KogakuGassanShinseishoSofuFileMeisaiEntity getMeisaiEntity(KogakuGassanShinseishoSofuFileEntity entity) {
        DbWT3711KogakuGassanShinseishoTempEntity dbwt3711entity = entity.get高額合算申請書一時();
        KogakuGassanShinseishoSofuFileMeisaiEntity meisaiEntity = new KogakuGassanShinseishoSofuFileMeisaiEntity();
        meisaiEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        meisaiEntity.setレコード番号(new RString(レコード番号));
        meisaiEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.高額合算支給申請書情報.getコード());
        meisaiEntity.setデータレコード種別(DataRecordShubetsu.データレコード.getコード());
        meisaiEntity.set被保険者氏名_カナ(囲み文字(trimRString(entity.get被保険者一時().getKanaMeisho())));
        meisaiEntity.set被保険者氏名_漢字(囲み文字(trimRString(entity.get被保険者一時().getMeisho())));
        meisaiEntity.set生年月日(formatDate(entity.get被保険者一時().getSeinenYmd()));
        meisaiEntity.set性別(trimRString(entity.get被保険者一時().getSeibetsuCode()));
        meisaiEntity.set所得区分(trimRString(dbwt3711entity.getShotokuKubun()));
        meisaiEntity.setOver70_所得区分(trimRString(dbwt3711entity.getOver70_ShotokuKubun()));
        meisaiEntity.set被保険者資格喪失年月日(formatDate(dbwt3711entity.getShikakuSoshitsuYMD()));
        meisaiEntity.set被保険者資格喪失事由(trimRString(dbwt3711entity.getShikakuSoshitsuJiyu()));
        meisaiEntity.set計算期間の始期(formatDate(dbwt3711entity.getTaishoKeisanKaishiYMD()));
        meisaiEntity.set計算期間の終期(formatDate(dbwt3711entity.getTaishoKeisanShuryoYMD()));
        meisaiEntity.set国保資格_保険者番号(trimRString(dbwt3711entity.getKokuho_HokenshaNo()));
        meisaiEntity.set国保資格_被保険者証記号(trimRString(dbwt3711entity.getKokuho_HihokenshaShoKigo()));
        meisaiEntity.set国保資格_被保険者証番号(trimRString(dbwt3711entity.getKokuho_HihokenshaShoNo()));
        meisaiEntity.set国保資格_世帯番号(trimRString(dbwt3711entity.getKokuho_SetaiNo()));
        meisaiEntity.set国保資格_続柄(trimRString(dbwt3711entity.getKokuho_Zokugara()));
        meisaiEntity.set国保資格_保険者名称(囲み文字(trimRString(dbwt3711entity.getKokuho_HokenshaMeisho())));
        meisaiEntity.set国保資格_加入開始年月日(formatDate(dbwt3711entity.getKokuho_KanyuKaishiYMD()));
        meisaiEntity.set国保資格_加入終了年月日(formatDate(dbwt3711entity.getKokuho_KanyuShuryoYMD()));
        meisaiEntity.set後期資格_保険者番号(trimRString(dbwt3711entity.getKoki_HokenshaNo()));
        meisaiEntity.set後期資格_被保険者番号(trimRString(dbwt3711entity.getKoki_HihokenshaNo()));
        meisaiEntity.set後期資格_広域連合名称(囲み文字(trimRString(dbwt3711entity.getKoki_KoikiRengoMeisho())));
        meisaiEntity.set後期資格_加入開始年月日(formatDate(dbwt3711entity.getKoki_KanyuKaishiYMD()));
        meisaiEntity.set後期資格_加入終了年月日(formatDate(dbwt3711entity.getKoki_KanyuShuryoYMD()));
        if (null != dbwt3711entity.getShoKisaiHokenshaNo()) {
            meisaiEntity.set介護資格_証記載保険者番号(trimRString(dbwt3711entity.getShoKisaiHokenshaNo().getColumnValue()));
        }
        if (null != dbwt3711entity.getHihokenshaNo()) {
            meisaiEntity.set介護資格_被保険者番号(trimRString(dbwt3711entity.getHihokenshaNo().getColumnValue()));
        }
        meisaiEntity.set介護資格_保険者名称(囲み文字(trimRString(dbwt3711entity.getShoKisaiHokenshaName())));
        meisaiEntity.set介護資格_加入開始年月日(formatDate(dbwt3711entity.getKanyuKaishiYMD()));
        meisaiEntity.set介護資格_加入終了年月日(formatDate(dbwt3711entity.getKanyuShuryoYMD()));
        meisaiEntity.set支給方法(trimRString(dbwt3711entity.getShiharaiHohoKubun()));
        if (支払方法区分_2.equals(dbwt3711entity.getShiharaiHohoKubun())) {
            meisaiEntity.set口座管理番号(new RString(口座管理番号の件数));
            set口座(meisaiEntity, entity.get口座());
        }
        meisaiEntity.set振込先口座管理番号(RString.EMPTY);
        set高額合算申請書加入歴(meisaiEntity, entity.get高額合算申請書加入歴());
        meisaiEntity.set備考(囲み文字(trimRString(dbwt3711entity.getBiko())));
        return meisaiEntity;
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private RString formatDate(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.NUMBER).firstYear(FirstYear.GAN_NEN).separator(Separator.NONE).toDateString();
    }

    private RString 囲み文字(RString str) {
        if (str.isEmpty()) {
            return str;
        }
        return 囲みの文字.concat(str).concat(囲みの文字);
    }

    private void set口座(KogakuGassanShinseishoSofuFileMeisaiEntity meisaiEntity, TokuteiKozaRelateEntity 口座) {
        IKoza koza = new Koza(口座, true);
        if (null != koza.get金融機関コード()) {
            meisaiEntity.set金融機関コード(koza.get金融機関コード().getColumnValue());
        }
        if (null != koza.get預金種別()) {
            meisaiEntity.set種目(koza.get預金種別().get預金種別コード());
        }
        meisaiEntity.set口座番号(koza.get口座番号());
        if (null != koza.get口座名義人()) {
            meisaiEntity.set口座名義人_カナ(囲み文字(trimRString(koza.get口座名義人().getColumnValue())));
        }
        EditedKoza editorKoza = new EditedKoza(koza);
        meisaiEntity.set店舗コード(editorKoza.get振込支店コード());

    }

    private void set高額合算申請書加入歴(KogakuGassanShinseishoSofuFileMeisaiEntity meisaiEntity,
            DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        if (加入歴番号_01.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名1(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日1(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日1(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号1(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_02.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名2(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日2(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日2(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号2(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_03.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名3(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日3(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日3(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号3(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_04.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名4(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日4(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日4(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号4(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_05.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名5(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日5(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日5(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号5(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_06.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名6(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日6(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日6(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号6(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_07.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名7(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日7(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日7(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号7(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_08.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名8(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日8(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日8(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号8(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_09.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名9(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日9(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日9(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号9(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        } else if (加入歴番号_10.equals(entity.getKanyurekiNo())) {
            meisaiEntity.set保険者名10(囲み文字(trimRString(entity.getHokenshaMei())));
            meisaiEntity.set加入期間_開始年月日10(formatDate(entity.getKanyuKaishiYMD()));
            meisaiEntity.set加入期間_終了年月日10(formatDate(entity.getKanyuShuryoYMD()));
            meisaiEntity.set自己負担額証明書整理番号10(trimRString(entity.getJikoFutanShomeisho_SeiriNo()));
        }
    }
}
