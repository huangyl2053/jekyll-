/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohochushutsurenkeibatch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranProperty.DBB200008ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei.ShichosonJohoShutoku;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigohokenichilan.KaigoHokenShotokuJohoIchilanEucCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshotokukanri.KaigoShotokukanri;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshotokutemp.DbtKaigoShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shorikega.ShoriKegaKakunin;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichilan.ShotokuJohoIchilan;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp.DbTShotokuJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotorokueuccsventity.ShotokuJohoTorokuEucCsvEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shutokujohochushutsurenkei.IShutokuJohoChushutsuRenkeiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2008ShotokuKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * ビジネス設計_DBBBZ51005_3_所得情報抽出・連携（バッチ）
 *
 * @reamsid_L DBB-1690-070 sunhui
 */
public class ShotokuJohoChushutsuRenkeiBatch {

    private final DbT2008ShotokuKanriDac 介護所得管理dac;
    private final DbT7022ShoriDateKanriDac 処理日付管理dac;
    private final MapperProvider mapperProvider;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private EucCsvWriter<ShotokuJohoTorokuEucCsvEntity> eucCsvWriter;
    private static final RString 当初_広域 = new RString("1");
    private static final RString 異動_広域 = new RString("2");
    private static final RString 当初_単一 = new RString("3");
    private static final RString 異動_単一 = new RString("4");
    private static final RString 別年度の所得情報です = new RString("別年度の所得情報です");
    private static final RString 当年度の所得情報が既に存在します = new RString("当年度の所得情報が既に存在します");
    private static final RString 課税_0非課税_1課税取消_2未申告_3 = new RString("0:課税 、1:非課税、2:課税取消、3:未申告");
    private static final RString 非課税区分が誤ってます = new RString("非課税区分が誤ってます");
    private static final RString 値_0 = new RString("0");
    private static final RString 非課税区分_0 = new RString("0");
    private static final RString 非課税区分_1 = new RString("1");
    private static final RString 非課税区分_2 = new RString("2");
    private static final RString 非課税区分_3 = new RString("3");
    private static final RString 課税_1 = new RString("1");
    private static final RString 非課税_2 = new RString("2");
    private static final RString 未申告_3 = new RString("3");
    private static final RString 調査中_4 = new RString("4");
    private static final RString 調査中として登録されています = new RString("調査中として登録されています");
    private static final RString 介護優先_1 = new RString("介護優先");
    private static final RString 介護優先として登録されています = new RString("介護優先として登録されています");
    private static final RString FORMAT_補00 = new RString("00");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString FORMAT_最大年度内連番 = new RString("0001");
    private static final RString カンマ = new RString(",");
    private static final RString ファイル名 = new RString("BBKAIGO.CSV");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定値_バッチパラメータ名 = new RString("バッチパラメータ名");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSVファイル名_介護保険所得情報一覧表 = new RString("介護保険所得情報一覧表");
    private static final EucEntityId EUC_ENTITY_ID_介護保険所得情報一覧表帳票 = new EucEntityId(new RString("DBB200008"));
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB900001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString SJIS類字 = new RString("SJIS類字");

    /**
     * コンストラクタです。
     */
    public ShotokuJohoChushutsuRenkeiBatch() {
        介護所得管理dac = InstanceProvider.create(DbT2008ShotokuKanriDac.class);
        処理日付管理dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです
     *
     * @param mapperProvider MapperProvider
     * @param 介護所得管理dac DbT2008ShotokuKanriDac
     * @param association Association
     */
    ShotokuJohoChushutsuRenkeiBatch(MapperProvider mapperProvider, DbT2008ShotokuKanriDac 介護所得管理dac,
            DbT7022ShoriDateKanriDac 処理日付管理dac, Association association) {
        this.mapperProvider = mapperProvider;
        this.介護所得管理dac = 介護所得管理dac;
        this.処理日付管理dac = 処理日付管理dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInCsvFileRead}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoKetteiHokenshaInCsvFileRead}のインスタンス
     */
    public static ShotokuJohoChushutsuRenkeiBatch createInstance() {
        return InstanceProvider.create(ShotokuJohoChushutsuRenkeiBatch.class);
    }

    /**
     * ファイルの登録メソッドです 所得情報ファイルのデータを抽出し、一時テーブルを作成する
     *
     * @param 処理区分 RString
     * @param 市町村情報List List<ShichosonJohoEntity>
     */
    public void selectShotokuJoho(RString 処理区分, List<ShichosonJohoShutoku> 市町村情報List) {
        if (処理区分.equals(当初_広域) || 処理区分.equals(異動_広域)) {
            for (ShichosonJohoShutoku entity : 市町村情報List) {
                List<DbTShotokuJohoTempTableEntity> csvList = csvファイル読込();
                for (int i = 0; i < csvList.size(); i++) {
                    if (csvList.get(i).get市町村コード().equals(entity.get市町村コード())) {
                        IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
                        mapper.insert所得情報一時テーブル(csvList.get(i));
                    }
                }
            }
        } else if (処理区分.equals(当初_単一) || 処理区分.equals(異動_単一)) {
            List<DbTShotokuJohoTempTableEntity> csvList = csvファイル読込();
            for (int i = 0; i < csvList.size(); i++) {
                IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
                mapper.insert所得情報一時テーブル(csvList.get(i));
            }
        }

    }

    /**
     * 所得情報チェックメソッドです 所得情報Tempからデータを抽出し、所得情報チェックを行う
     *
     * @param 処理年度 FlexibleYear
     * @param 処理区分 RString
     * @return List<ShoriKegaKakunin>
     */
    public List<ShoriKegaKakunin> checkShotokuJoho(FlexibleYear 処理年度, RString 処理区分) {
        IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
        List<DbTShotokuJohoTempTableEntity> shotokuJohoList = mapper.get所得情報一時テーブルの全件();
        List<ShoriKegaKakunin> shoriKegaKakuninList = new ArrayList<>();
        ShoriKegaKakunin shoriKegaKakunin = new ShoriKegaKakunin();
        if (処理区分.equals(当初_広域) || 処理区分.equals(当初_単一)) {
            for (DbTShotokuJohoTempTableEntity entity : shotokuJohoList) {
                if (!entity.get賦課年度().equals(処理年度)) {
                    shoriKegaKakuninList = new ArrayList<>();
                    shoriKegaKakunin = new ShoriKegaKakunin();
                    shoriKegaKakunin.set賦課年度(entity.get賦課年度());
                    shoriKegaKakunin.set住民コード(entity.get住民ｺｰﾄﾞ());
                    shoriKegaKakunin.set市町村コード(entity.get市町村コード());
                    shoriKegaKakunin.set非課税区分(entity.get非課税区分());
                    shoriKegaKakunin.setエラー内容(別年度の所得情報です);
                    shoriKegaKakuninList.add(shoriKegaKakunin);
                } else {
                    当初場合介護所得管理を検索Method(shoriKegaKakunin, entity);
                    shoriKegaKakuninList.add(shoriKegaKakunin);
                }
            }

        }
        if (処理区分.equals(異動_広域) || 処理区分.equals(異動_単一)) {
            for (DbTShotokuJohoTempTableEntity entity : shotokuJohoList) {
                if (!課税_0非課税_1課税取消_2未申告_3.equals(entity.get非課税区分())) {
                    shoriKegaKakunin = new ShoriKegaKakunin();
                    shoriKegaKakunin.set賦課年度(entity.get賦課年度());
                    shoriKegaKakunin.set住民コード(entity.get住民ｺｰﾄﾞ());
                    shoriKegaKakunin.set市町村コード(entity.get市町村コード());
                    shoriKegaKakunin.set非課税区分(entity.get非課税区分());
                    shoriKegaKakunin.setエラー内容(非課税区分が誤ってます);
                    shoriKegaKakuninList.add(shoriKegaKakunin);
                } else {
                    異動場合介護所得管理を検索Handle(shoriKegaKakunin, entity);
                    shoriKegaKakuninList.add(shoriKegaKakunin);
                }
            }
        }
        return shoriKegaKakuninList;
    }

    /**
     * 介護所得管理の登録メソッドです 介護所得Tempから、追加するデータを抽出し、介護所得管理テーブルに登録する
     */
    public void insKaigoShotokuKanri() {
        IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
        List<DbtKaigoShotokuTempEntity> kaigoTempList = mapper.get介護所得一時テーブルの市町村以外情報();
        for (DbtKaigoShotokuTempEntity kaigoTempEntity : kaigoTempList) {
            mapper.insert介護所得管理(kaigoTempEntity);
        }
    }

    /**
     * 帳票の発行メソッドです 介護所得Tempから、介護保険所得情報一覧表を帳票で作成する
     *
     * @param 処理区分 RString
     * @param 市町村情報リスト List<ShichosonJohoShutoku>
     * @param 帳票ID ReportId
     * @param 作成日時 YMDHMS
     * @param 出力順ID long
     */
    public void spoolShotokuJohoIchiran(RString 処理区分, List<ShichosonJohoShutoku> 市町村情報リスト,
            ReportId 帳票ID, YMDHMS 作成日時, long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 帳票ID, 出力順ID);
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBB200008ShutsuryokujunEnum.class, 並び順);
        IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
        List<ShotokuJohoIchilan> ichilanList = mapper.get所得情報一覧(出力順);
        List<KaigoHokenShotokuJohoIchilanEucCsvEntity> csvList = new ArrayList<>();
        for (ShotokuJohoIchilan ichilanEntity : ichilanList) {
            KaigoHokenShotokuJohoIchilanEucCsvEntity csvEntity = new KaigoHokenShotokuJohoIchilanEucCsvEntity();
            if (当初_広域.equals(処理区分) || 異動_広域.equals(処理区分)) {
                for (ShichosonJohoShutoku entity : 市町村情報リスト) {
                    if (entity.get市町村コード().equals(ichilanEntity.get市町村コード())) {
                        csvEntity.set市町村名(ichilanEntity.get市町村名());
                    }
                }
                csvEntity.set市町村コード(ichilanEntity.get市町村コード().value());
            }
            if (当初_単一.equals(処理区分) || 異動_単一.equals(処理区分)) {
                IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
                Association association = associationFinder.getAssociation();
                csvEntity.set市町村コード(association.get地方公共団体コード().getColumnValue());
                csvEntity.set市町村名(association.get市町村名());
            }
            項目編集(csvEntity, 作成日時, ichilanEntity);
            csvEntity.set年金収入額(DecimalFormatter.toコンマ区切りRString(ichilanEntity.get公的年金収入額(), 0));
            csvList.add(csvEntity);
        }
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association association = associationFinder.getAssociation();
        // TODO　QA
        new KaigoHokenShotokuJohoIchiranPrintService().print介護保険所得情報(null, null,
                new LasdecCode(association.get地方公共団体コード().getColumnValue()), association.get市町村名(), 出力順ID);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID_介護保険所得情報一覧表帳票, UzUDE0831EucAccesslogFileType.Csv);
        RString 文字コード = DbBusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("KaigoHokenShotokuJohoIchiranData.csv"));
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID_介護保険所得情報一覧表帳票)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(getEncode(文字コード))
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
        eucCsvWriter.close();
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder;
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定値_バッチパラメータ名).concat(FORMAT_RIGHT));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(出力順);
        RString 帳票名 = get帳票名_変更(帳票ID.getColumnValue());
        SourceDataCollection sourceDataCollection;
        try (ReportManager reportManager = new ReportManager()) {
            sourceDataCollection = reportManager.publish();
        }
        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        if (ichilanList != null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_ゼロ, CSV出力有無_なし, CSVファイル名, 帳票名);
        } else {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, CSVファイル名_介護保険所得情報一覧表, 帳票名);
        }
    }

    /**
     * 所得情報登録エラーリストの作成メソッドです 所得情報登録エラーリストをCSVファイルで作成する
     *
     * @param shoriKakuninlist List<ShoriKegaKakunin>
     * @param 作成日時 YMDHMS
     */
    public void spoolShotokuJohoTorokuErrList(List<ShoriKegaKakunin> shoriKakuninlist, YMDHMS 作成日時) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("ShotokuJohoTorokuErrList.csv"));
        RString 文字コード = DbBusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(getEncode(文字コード))
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
        eucCsvWriter.close();
        List<ShotokuJohoTorokuEucCsvEntity> errList = new ArrayList<>();
        ShotokuJohoTorokuEucCsvEntity errEntity = new ShotokuJohoTorokuEucCsvEntity();
        errEntity.set作成年月日(作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        errEntity.set作成日時(作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        errEntity.set賦課年度(shoriKakuninlist.get(0).get賦課年度().toDateString());
        errEntity.set住民コード(shoriKakuninlist.get(0).get住民コード());
        errEntity.set市町村コード(new RString(shoriKakuninlist.get(0).get市町村コード().toString()));
        errEntity.set非課税区分(shoriKakuninlist.get(0).get非課税区分());
        errEntity.setエラー内容(shoriKakuninlist.get(0).getエラー内容());
        errList.add(errEntity);
    }

    /**
     * 処理日付管理マスタの更新メソッドです 介護保険所得一覧帳票を正常に出力した後で、処理日付管理マスタを更新する
     *
     * @param 処理区分 RString
     * @param 処理年度 FlexibleYear
     * @param バッチ起動処理日時 YMDHMS
     */
    public void updShoriHidukeKanri(RString 処理区分, FlexibleYear 処理年度, YMDHMS バッチ起動処理日時) {
        IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
        List<DbtKaigoShotokuTempEntity> shichosonList = mapper.get介護所得一時テーブルの市町村情報();
        for (DbtKaigoShotokuTempEntity entity : shichosonList) {
            entity.get市町村識別ID();
            if (当初_広域.equals(処理区分)) {
                DbT7022ShoriDateKanriEntity 当初_広域処理日付管理Entity = 処理日付管理dac.selectBySomeKeysLimits(
                        SubGyomuCode.DBB介護賦課, ShoriName.当初所得引出.get名称(), new RString(
                                String.format(FORMAT_補00.toString(), entity.get市町村識別ID())), 処理年度, 年度内連番);
                当初_広域処理日付管理Entity.setKijunTimestamp(バッチ起動処理日時);
                当初_広域処理日付管理Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
                当初_広域処理日付管理Entity.setState(EntityDataState.Modified);
                処理日付管理dac.save(当初_広域処理日付管理Entity);
            }
            if (当初_単一.equals(処理区分)) {
                DbT7022ShoriDateKanriEntity 当初_単一処理日付管理Entity = 処理日付管理dac
                        .selectBySomeKeysLimits(SubGyomuCode.DBB介護賦課, ShoriName.当初所得引出.get名称(),
                                処理枝番, 処理年度, 年度内連番);
                当初_単一処理日付管理Entity.setKijunTimestamp(バッチ起動処理日時);
                当初_単一処理日付管理Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
                当初_単一処理日付管理Entity.setState(EntityDataState.Modified);
                処理日付管理dac.save(当初_単一処理日付管理Entity);
            }
            if (異動_広域.equals(処理区分)) {
                異動_広域場合Handle(entity, 処理区分, 処理年度, バッチ起動処理日時);
            }
            if (異動_単一.equals(処理区分)) {
                異動_単一場合Handle(処理年度, バッチ起動処理日時);
            }
        }
    }

    private List<DbTShotokuJohoTempTableEntity> csvファイル読込() {
        List<DbTShotokuJohoTempTableEntity> csvファイルLsit = new ArrayList<>();
        DbTShotokuJohoTempTableEntity csvファイルEntity = new DbTShotokuJohoTempTableEntity();
        List<RString> csvFullPathList = new ArrayList<>();
        File path = new File(SharedFile.getBasePath() + File.separator + ファイル名);
        RString csvFullPath = new RString(path.getPath());
        csvFullPathList.add(csvFullPath);
        try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(csvFullPathList.get(0))
                .setDelimiter(カンマ).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
            while (true) {
                List<RString> data = csvReader.readLine();
                if (data != null && !data.isEmpty()) {
                    for (int i = 0; i < data.size(); i++) {
                        csvファイルEntity.set市町村コード(new LasdecCode(data.get(i)));
                        csvファイルEntity.set識別ＩＤ(data.get(i));
                        csvファイルEntity.setその他所得１(data.get(i));
                        csvファイルEntity.setその他所得２(data.get(i));
                        csvファイルEntity.setタイムスタンプ(new YMDHMS(data.get(i)));
                        csvファイルEntity.setデータ種類(data.get(i));
                        csvファイルEntity.set予備(data.get(i));
                        csvファイルEntity.set住民税均等割(data.get(i));
                        csvファイルEntity.set住民税所得割(data.get(i));
                        csvファイルEntity.set住民ｺｰﾄﾞ(data.get(i));
                        csvファイルEntity.set公的年金等収入額(new Decimal(data.get(i).toString()));
                        csvファイルEntity.set公的年金等所得額(new Decimal(data.get(i).toString()));
                        csvファイルEntity.set合計所得金額(new Decimal(data.get(i).toString()));
                        csvファイルEntity.set所得把握区分_申告区分(data.get(i));
                        csvファイルEntity.set所得税(new Decimal(data.get(i).toString()));
                        csvファイルEntity.set最終レコード区分(data.get(i));
                        csvファイルEntity.set更新日時(new YMDHMS(data.get(i)));
                        csvファイルEntity.set激変緩和区分(data.get(i));
                        csvファイルEntity.set給与収入額(new Decimal(data.get(i).toString()));
                        csvファイルEntity.set識別ＩＤ(data.get(i));
                        csvファイルEntity.set賦課年度(new FlexibleYear(data.get(i)));
                        csvファイルEntity.set連番(data.get(i));
                        csvファイルEntity.set非課税区分(data.get(i));
                        csvファイルEntity.setＦＩＬＬＥＲ(data.get(i));
                    }
                } else {
                    break;
                }
            }
        }
        return csvファイルLsit;
    }

    private void 項目編集(KaigoHokenShotokuJohoIchilanEucCsvEntity csvEntity, YMDHMS 作成日時, ShotokuJohoIchilan ichilanEntity) {
        csvEntity.set作成年月日(作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        csvEntity.set作成日時(作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        csvEntity.set識別コード(ichilanEntity.get識別コード());
        csvEntity.set氏名_カナ(ichilanEntity.getカナ名称());
        csvEntity.set所得年度(ichilanEntity.get所得年度());
        csvEntity.set生年月日(ichilanEntity.get生年月日().seireki().toDateString());
        RString 性別 = Seibetsu.男.get名称();
        if (Seibetsu.女.getコード().equals(ichilanEntity.get性別コード())) {
            性別 = Seibetsu.女.get名称();
        }
        csvEntity.set性別(性別);
        RString 課税区分 = KazeiKubun.所得調査中.get名称();
        if (KazeiKubun.未申告.getコード().equals(ichilanEntity.get課税区分_住民税減免前())) {
            課税区分 = KazeiKubun.未申告.get名称();
        } else if (KazeiKubun.課税.getコード().equals(ichilanEntity.get課税区分_住民税減免前())) {
            課税区分 = KazeiKubun.課税.get名称();
        } else if (KazeiKubun.非課税.getコード().equals(ichilanEntity.get課税区分_住民税減免前())) {
            課税区分 = KazeiKubun.非課税.get名称();
        } else if (KazeiKubun.課税取消.getコード().equals(ichilanEntity.get課税区分_住民税減免前())) {
            課税区分 = KazeiKubun.課税取消.get名称();
        }
        csvEntity.set住民税課税区分_減免前(課税区分);
        RString 課税区分後 = KazeiKubun.所得調査中.get名称();
        if (KazeiKubun.未申告.getコード().equals(ichilanEntity.get課税区分_住民税減免後())) {
            課税区分後 = KazeiKubun.未申告.get名称();
        } else if (KazeiKubun.課税.getコード().equals(ichilanEntity.get課税区分_住民税減免後())) {
            課税区分後 = KazeiKubun.課税.get名称();
        } else if (KazeiKubun.非課税.getコード().equals(ichilanEntity.get課税区分_住民税減免後())) {
            課税区分後 = KazeiKubun.非課税.get名称();
        } else if (KazeiKubun.課税取消.getコード().equals(ichilanEntity.get課税区分_住民税減免後())) {
            課税区分後 = KazeiKubun.課税取消.get名称();
        }
        csvEntity.set住民税課税区分_減免後(課税区分後);
        csvEntity.set合計所得金額(DecimalFormatter.toコンマ区切りRString(ichilanEntity.get合計所得金額(), 0));
        csvEntity.set課税標準額(DecimalFormatter.toコンマ区切りRString(ichilanEntity.get課税所得額(), 0));
        csvEntity.set登録業務(RString.EMPTY);
        csvEntity.set被保険者番号(ichilanEntity.get被保険者番号());
        csvEntity.set氏名(ichilanEntity.get名称());
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(new UaFt200FindShikibetsuTaishoEntity());
        csvEntity.set年齢(宛名.get年齢算出().get年齢());
        RString 住民種別 = JuminShubetsu.住登外個人_外国人.toRString();
        if (JuminShubetsu.住登外個人_日本人.getCode().equals(ichilanEntity.get住民種別コード())) {
            住民種別 = JuminShubetsu.住登外個人_日本人.toRString();
        } else if (JuminShubetsu.共有者.getCode().equals(ichilanEntity.get住民種別コード())) {
            住民種別 = JuminShubetsu.共有者.toRString();
        } else if (JuminShubetsu.外国人.getCode().equals(ichilanEntity.get住民種別コード())) {
            住民種別 = JuminShubetsu.外国人.toRString();
        } else if (JuminShubetsu.日本人.getCode().equals(ichilanEntity.get住民種別コード())) {
            住民種別 = JuminShubetsu.日本人.toRString();
        } else if (JuminShubetsu.法人.getCode().equals(ichilanEntity.get住民種別コード())) {
            住民種別 = JuminShubetsu.法人.toRString();
        }
        csvEntity.set種別(住民種別);
    }

    private void 当初場合介護所得管理を検索Method(ShoriKegaKakunin shoriKegaKakunin, DbTShotokuJohoTempTableEntity entity) {
        DbT2008ShotokuKanriEntity 介護所得管理Entity = 介護所得管理dac.select介護所得管理(entity.get賦課年度(),
                new ShikibetsuCode(entity.get住民ｺｰﾄﾞ()));
        if (介護所得管理Entity != null) {
            shoriKegaKakunin = new ShoriKegaKakunin();
            shoriKegaKakunin.set賦課年度(entity.get賦課年度());
            shoriKegaKakunin.set住民コード(entity.get住民ｺｰﾄﾞ());
            shoriKegaKakunin.set市町村コード(entity.get市町村コード());
            shoriKegaKakunin.set非課税区分(entity.get非課税区分());
            shoriKegaKakunin.setエラー内容(当年度の所得情報が既に存在します);
        } else {
            if (!課税_0非課税_1課税取消_2未申告_3.equals(entity.get非課税区分())) {
                shoriKegaKakunin = new ShoriKegaKakunin();
                shoriKegaKakunin.set賦課年度(entity.get賦課年度());
                shoriKegaKakunin.set住民コード(entity.get住民ｺｰﾄﾞ());
                shoriKegaKakunin.set市町村コード(entity.get市町村コード());
                shoriKegaKakunin.set非課税区分(entity.get非課税区分());
                shoriKegaKakunin.setエラー内容(非課税区分が誤ってます);
            } else {
                List<DbtKaigoShotokuTempEntity> kaigoList = new ArrayList<>();
                DbtKaigoShotokuTempEntity kaigoEntity = new DbtKaigoShotokuTempEntity();
                kaigoEntity.set市町村コード(entity.get市町村コード());
                kaigoEntity.set市町村識別ID(entity.get識別ＩＤ());
                kaigoEntity.set所得年度(entity.get賦課年度());
                kaigoEntity.set識別コード(entity.get住民ｺｰﾄﾞ());
                kaigoEntity.set履歴番号(値_0);
                if (非課税区分_0.equals(entity.get非課税区分())) {
                    kaigoEntity.set課税区分_住民税減免前(課税_1);
                } else if (非課税区分_1.equals(entity.get非課税区分()) || 非課税区分_2.equals(entity.get非課税区分())) {
                    kaigoEntity.set課税区分_住民税減免前(非課税_2);
                } else if (非課税区分_3.equals(entity.get非課税区分())) {
                    kaigoEntity.set課税区分_住民税減免前(未申告_3);
                }
                if (非課税区分_0.equals(entity.get非課税区分())) {
                    kaigoEntity.set課税区分_住民税減免後(課税_1);
                } else if (非課税区分_1.equals(entity.get非課税区分()) || 非課税区分_2.equals(entity.get非課税区分())) {
                    kaigoEntity.set課税区分_住民税減免後(非課税_2);
                } else if (非課税区分_3.equals(entity.get非課税区分())) {
                    kaigoEntity.set課税区分_住民税減免後(未申告_3);
                }
                kaigoEntity.set合計所得金額(entity.get合計所得金額());
                kaigoEntity.set公的年金収入額(entity.get公的年金等収入額());
                kaigoEntity.set公的年金所得額(entity.get公的年金等所得額());
                kaigoEntity.set課税所得額(new Decimal(値_0.toString()));
                kaigoEntity.set激変緩和措置区分(entity.get激変緩和区分());
                kaigoEntity.set優先区分(値_0);
                kaigoEntity.set処理日時(YMDHMS.now());
                kaigoList.add(kaigoEntity);
                for (int i = 0; i < kaigoList.size(); i++) {
                    IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
                    mapper.insert介護所得一時テーブル(kaigoList.get(i));
                }
            }
        }
    }

    private void 異動場合介護所得管理を検索Handle(ShoriKegaKakunin shoriKegaKakunin, DbTShotokuJohoTempTableEntity entity) {
        DbT2008ShotokuKanriEntity 介護所得管理制限Entity = 介護所得管理dac.select介護所得管理制限(entity.get賦課年度(),
                new ShikibetsuCode(entity.get住民ｺｰﾄﾞ()));
        if (介護所得管理制限Entity != null) {
            if (調査中_4.equals(介護所得管理制限Entity.getKazeiKubun())) {
                shoriKegaKakunin = new ShoriKegaKakunin();
                shoriKegaKakunin.set賦課年度(entity.get賦課年度());
                shoriKegaKakunin.set住民コード(entity.get住民ｺｰﾄﾞ());
                shoriKegaKakunin.set市町村コード(entity.get市町村コード());
                shoriKegaKakunin.set非課税区分(entity.get非課税区分());
                shoriKegaKakunin.setエラー内容(調査中として登録されています);
            } else {
                if (介護優先_1.equals(介護所得管理制限Entity.getYusenKubun())) {
                    shoriKegaKakunin = new ShoriKegaKakunin();
                    shoriKegaKakunin.set賦課年度(entity.get賦課年度());
                    shoriKegaKakunin.set住民コード(entity.get住民ｺｰﾄﾞ());
                    shoriKegaKakunin.set市町村コード(entity.get市町村コード());
                    shoriKegaKakunin.set非課税区分(entity.get非課税区分());
                    shoriKegaKakunin.setエラー内容(介護優先として登録されています);
                } else {
                    List<KaigoShotokukanri> kaigoList = new ArrayList<>();
                    KaigoShotokukanri kaigoEntity = new KaigoShotokukanri();
                    kaigoEntity.set市町村コード(entity.get市町村コード());
                    kaigoEntity.set市町村識別ID(entity.get識別ＩＤ());
                    kaigoEntity.set所得年度(entity.get賦課年度());
                    kaigoEntity.set識別コード(new ShikibetsuCode(entity.get住民ｺｰﾄﾞ()));
                    kaigoEntity.set履歴番号(new RString(介護所得管理制限Entity.getRirekiNo() + 1));
                    課税区分Handle(entity, kaigoEntity);
                    kaigoEntity.set合計所得金額(entity.get合計所得金額());
                    kaigoEntity.set公的年金収入額(entity.get公的年金等収入額());
                    kaigoEntity.set公的年金所得額(entity.get公的年金等所得額());
                    kaigoEntity.set課税所得額(new Decimal(値_0.toString()));
                    kaigoEntity.set激変緩和措置区分(entity.get激変緩和区分());
                    kaigoEntity.set優先区分(値_0);
                    kaigoEntity.set処理日時(YMDHMS.now());
                    kaigoList.add(kaigoEntity);
                }
            }
        } else {
            List<DbtKaigoShotokuTempEntity> kaigoList = new ArrayList<>();
            DbtKaigoShotokuTempEntity kaigoEntity = new DbtKaigoShotokuTempEntity();
            kaigoEntity.set市町村コード(entity.get市町村コード());
            kaigoEntity.set市町村識別ID(entity.get識別ＩＤ());
            kaigoEntity.set所得年度(entity.get賦課年度());
            kaigoEntity.set識別コード(entity.get住民ｺｰﾄﾞ());
            kaigoEntity.set履歴番号(値_0);
            if (非課税区分_0.equals(entity.get非課税区分())) {
                kaigoEntity.set課税区分_住民税減免前(課税_1);
            } else if (非課税区分_1.equals(entity.get非課税区分()) || 非課税区分_2.equals(entity.get非課税区分())) {
                kaigoEntity.set課税区分_住民税減免前(非課税_2);
            } else if (非課税区分_3.equals(entity.get非課税区分())) {
                kaigoEntity.set課税区分_住民税減免前(未申告_3);
            }
            if (非課税区分_0.equals(entity.get非課税区分())) {
                kaigoEntity.set課税区分_住民税減免後(課税_1);
            } else if (非課税区分_1.equals(entity.get非課税区分()) || 非課税区分_2.equals(entity.get非課税区分())) {
                kaigoEntity.set課税区分_住民税減免後(非課税_2);
            } else if (非課税区分_3.equals(entity.get非課税区分())) {
                kaigoEntity.set課税区分_住民税減免後(未申告_3);
            }
            kaigoEntity.set合計所得金額(entity.get合計所得金額());
            kaigoEntity.set公的年金収入額(entity.get公的年金等収入額());
            kaigoEntity.set公的年金所得額(entity.get公的年金等所得額());
            kaigoEntity.set課税所得額(new Decimal(値_0.toString()));
            kaigoEntity.set激変緩和措置区分(entity.get激変緩和区分());
            kaigoEntity.set優先区分(値_0);
            kaigoEntity.set処理日時(YMDHMS.now());
            kaigoList.add(kaigoEntity);
            for (int i = 0; i < kaigoList.size(); i++) {
                IShutokuJohoChushutsuRenkeiMapper mapper = this.mapperProvider.create(IShutokuJohoChushutsuRenkeiMapper.class);
                mapper.insert介護所得一時テーブル(kaigoList.get(i));
            }

        }
    }

    private void 課税区分Handle(DbTShotokuJohoTempTableEntity entity, KaigoShotokukanri kaigoEntity) {
        if (非課税区分_0.equals(entity.get非課税区分())) {
            kaigoEntity.set課税区分_住民税減免前(課税_1);
        } else if (非課税区分_1.equals(entity.get非課税区分()) || 非課税区分_2.equals(entity.get非課税区分())) {
            kaigoEntity.set課税区分_住民税減免前(非課税_2);
        } else if (非課税区分_3.equals(entity.get非課税区分())) {
            kaigoEntity.set課税区分_住民税減免前(未申告_3);
        }
        if (非課税区分_0.equals(entity.get非課税区分())) {
            kaigoEntity.set課税区分_住民税減免後(課税_1);
        } else if (非課税区分_1.equals(entity.get非課税区分()) || 非課税区分_2.equals(entity.get非課税区分())) {
            kaigoEntity.set課税区分_住民税減免後(非課税_2);
        } else if (非課税区分_3.equals(entity.get非課税区分())) {
            kaigoEntity.set課税区分_住民税減免後(未申告_3);
        }
    }

    private void 異動_広域場合Handle(DbtKaigoShotokuTempEntity entity, RString 処理区分, FlexibleYear 処理年度, YMDHMS バッチ起動処理日時) {
        DbT7022ShoriDateKanriEntity 異動_広域処理日付管理Entity = 処理日付管理dac.select異動広域最大年度内連番(処理区分, 処理年度);
        if (異動_広域処理日付管理Entity != null) {
            Decimal 最大年度内連番 = new Decimal(異動_広域処理日付管理Entity.getNendoNaiRenban().toString()).add(Decimal.ONE);
            YMDHMS 対象開始日時 = 異動_広域処理日付管理Entity.getTaishoShuryoTimestamp();
            異動_広域処理日付管理Entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
            異動_広域処理日付管理Entity.setShichosonCode(entity.get市町村コード());
            異動_広域処理日付管理Entity.setShoriName(ShoriName.所得引出.get名称());
            異動_広域処理日付管理Entity.setShoriEdaban(entity.get市町村識別ID());
            異動_広域処理日付管理Entity.setNendo(処理年度);
            異動_広域処理日付管理Entity.setNendoNaiRenban(new RString(最大年度内連番.toString()));
            異動_広域処理日付管理Entity.setKijunTimestamp(バッチ起動処理日時);
            異動_広域処理日付管理Entity.setTaishoKaishiTimestamp(対象開始日時);
            異動_広域処理日付管理Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
            異動_広域処理日付管理Entity.setState(EntityDataState.Modified);
            処理日付管理dac.save(異動_広域処理日付管理Entity);
        } else {
            RString 最大年度内連番 = FORMAT_最大年度内連番;
            FlexibleYear 前年度処理年度 = 処理年度.minusYear(1);
            DbT7022ShoriDateKanriEntity 前年度異動_広域処理日付管理Entity = 処理日付管理dac
                    .select異動広域最大年度内連番(処理区分, 前年度処理年度);
            if (前年度異動_広域処理日付管理Entity != null) {
                YMDHMS 対象開始日時 = 前年度異動_広域処理日付管理Entity.getTaishoShuryoTimestamp();
                前年度異動_広域処理日付管理Entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                前年度異動_広域処理日付管理Entity.setShichosonCode(entity.get市町村コード());
                前年度異動_広域処理日付管理Entity.setShoriName(ShoriName.所得引出.get名称());
                前年度異動_広域処理日付管理Entity.setShoriEdaban(entity.get市町村識別ID());
                前年度異動_広域処理日付管理Entity.setNendo(処理年度);
                前年度異動_広域処理日付管理Entity.setNendoNaiRenban(最大年度内連番);
                前年度異動_広域処理日付管理Entity.setKijunTimestamp(バッチ起動処理日時);
                前年度異動_広域処理日付管理Entity.setTaishoKaishiTimestamp(対象開始日時);
                前年度異動_広域処理日付管理Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
                前年度異動_広域処理日付管理Entity.setState(EntityDataState.Modified);
                処理日付管理dac.save(前年度異動_広域処理日付管理Entity);
            }
        }
    }

    private void 異動_単一場合Handle(FlexibleYear 処理年度, YMDHMS バッチ起動処理日時) {
        DbT7022ShoriDateKanriEntity 異動_単一処理日付管理Entity = 処理日付管理dac.select異動単一最大年度内連番(処理年度);
        if (異動_単一処理日付管理Entity != null) {
            Decimal 最大年度内連番 = new Decimal(異動_単一処理日付管理Entity.getNendoNaiRenban().toString()).add(Decimal.ONE);
            YMDHMS 対象開始日時 = 異動_単一処理日付管理Entity.getTaishoShuryoTimestamp();
            異動_単一処理日付管理Entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
            異動_単一処理日付管理Entity.setShichosonCode(AssociationFinderFactory.createInstance()
                    .getAssociation().getLasdecCode_());
            異動_単一処理日付管理Entity.setShoriName(ShoriName.所得引出.get名称());
            異動_単一処理日付管理Entity.setShoriEdaban(処理枝番);
            異動_単一処理日付管理Entity.setNendo(処理年度);
            異動_単一処理日付管理Entity.setNendoNaiRenban(new RString(最大年度内連番.toString()));
            異動_単一処理日付管理Entity.setKijunTimestamp(バッチ起動処理日時);
            異動_単一処理日付管理Entity.setTaishoKaishiTimestamp(対象開始日時);
            異動_単一処理日付管理Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
            異動_単一処理日付管理Entity.setState(EntityDataState.Modified);
            処理日付管理dac.save(異動_単一処理日付管理Entity);
        } else {
            RString 最大年度内連番 = FORMAT_最大年度内連番;
            FlexibleYear 前年度処理年度 = 処理年度.minusYear(1);
            DbT7022ShoriDateKanriEntity 前年度異動_単一処理日付管理Entity = 処理日付管理dac.select異動単一最大年度内連番(前年度処理年度);
            if (前年度異動_単一処理日付管理Entity != null) {
                YMDHMS 対象開始日時 = 前年度異動_単一処理日付管理Entity.getTaishoShuryoTimestamp();
                前年度異動_単一処理日付管理Entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
                前年度異動_単一処理日付管理Entity.setShichosonCode(AssociationFinderFactory.createInstance()
                        .getAssociation().getLasdecCode_());
                前年度異動_単一処理日付管理Entity.setShoriName(ShoriName.所得引出.get名称());
                前年度異動_単一処理日付管理Entity.setShoriEdaban(処理枝番);
                前年度異動_単一処理日付管理Entity.setNendo(処理年度);
                前年度異動_単一処理日付管理Entity.setNendoNaiRenban(最大年度内連番);
                前年度異動_単一処理日付管理Entity.setKijunTimestamp(バッチ起動処理日時);
                前年度異動_単一処理日付管理Entity.setTaishoKaishiTimestamp(対象開始日時);
                前年度異動_単一処理日付管理Entity.setTaishoShuryoTimestamp(バッチ起動処理日時);
                前年度異動_単一処理日付管理Entity.setState(EntityDataState.Modified);
                処理日付管理dac.save(前年度異動_単一処理日付管理Entity);
            }
        }
    }

    /**
     * バッチ出力条件リストの出力メソッドです。
     *
     * @param 出力条件リスト List<RString>
     * @param 帳票ID ReportId
     * @param 出力ページ数 RString
     * @param csv出力有無 RString
     * @param csvファイル名 RString
     * @param 帳票名 RString
     */
    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト, ReportId 帳票ID, RString 出力ページ数,
            RString csv出力有無, RString csvファイル名, RString 帳票名) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private Encode getEncode(RString sakiEncodeKeitai) {
        Encode encode = Encode.UTF_8withBOM;
        if (new RString("1").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("2").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (new RString("3").equals(sakiEncodeKeitai)) {
            encode = Encode.valueOf(SJIS類字.toString());
        }
        return encode;
    }

    private RString get帳票名_変更(RString 帳票ID) {

        if (ReportIdDBB.DBB200008.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB200008.getReportName();
        }
        return RString.EMPTY;
    }

}
