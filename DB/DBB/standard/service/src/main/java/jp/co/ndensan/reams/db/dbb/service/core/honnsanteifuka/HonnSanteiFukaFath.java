/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KeisangoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.ShikakuKikan;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.ShikakuKikanJoho;
import jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranProperty;
import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.HonsenteiKeisangojohoParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.HonsenteiKeisangojohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.KeisangojohoAtenaKozaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honnsanteifuka.IHonnSanteiFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 本算定賦課バッチのクラス
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
public class HonnSanteiFukaFath {

    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private static final RString 区分_管内 = new RString("1");
    private static final RString 区分_管外 = new RString("2");
    private static final RString SIGN = new RString(" ＞ ");
    private static final ReportId 帳票ID = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 年度 = new RString("年度");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString CSVファイル名_一覧表 = new RString("本算定結果一覧表");
    private static final RString 本算定_EUCファイル名 = new RString("HonsanteiKekkaIcihiranData.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200009");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ゆうちょ銀行 = new RString("9900");
    private static final RString HYPHEN = new RString("-");
    private final RString 特別徴収 = new RString("特別徴収");
    private final RString 普通徴収 = new RString("普通徴収");
    private final RString 併用徴収 = new RString("併用徴収");
    private final RString 本算定賦課なし = new RString("本算定賦課なし");
    private final RString 本算定前半普徴 = new RString("本算定前半普徴");
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル_氏名 = new RString("氏名");
    private static final RString タイトル_生年月日 = new RString("生年月日");
    private static final RString タイトル_性別 = new RString("性別");
    private static final RString タイトル_識別コード = new RString("識別コード");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_町域コード = new RString("町域コード");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域管内管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_口座情報 = new RString("口座情報");
    private static final RString タイトル_資格取得日 = new RString("資格取得日");
    private static final RString タイトル_資格喪失日 = new RString("資格喪失日");
    private static final RString タイトル_資格期間 = new RString("資格期間");
    private static final RString タイトル_確定保険料額 = new RString("確定保険料額");
    private static final RString タイトル_計算上保険料額 = new RString("計算上保険料額");
    private static final RString タイトル_減免額 = new RString("減免額");
    private static final RString タイトル_月別取得段階4月 = new RString("月別取得段階4月");
    private static final RString タイトル_月別取得段階5月 = new RString("月別取得段階5月");
    private static final RString タイトル_月別取得段階6月 = new RString("月別取得段階6月");
    private static final RString タイトル_月別取得段階7月 = new RString("月別取得段階7月");
    private static final RString タイトル_月別取得段階8月 = new RString("月別取得段階8月");
    private static final RString タイトル_月別取得段階9月 = new RString("月別取得段階9月");
    private static final RString タイトル_月別取得段階10月 = new RString("月別取得段階10月");
    private static final RString タイトル_月別取得段階11月 = new RString("月別取得段階11月");
    private static final RString タイトル_月別取得段階12月 = new RString("月別取得段階12月");
    private static final RString タイトル_月別取得段階1月 = new RString("月別取得段階1月");
    private static final RString タイトル_月別取得段階2月 = new RString("月別取得段階2月");
    private static final RString タイトル_月別取得段階3月 = new RString("月別取得段階3月");
    private static final RString タイトル_徴収方法 = new RString("徴収方法");
    private static final RString タイトル_特徴額１期 = new RString("特徴額１期");
    private static final RString タイトル_特徴額２期 = new RString("特徴額２期");
    private static final RString タイトル_特徴額３期 = new RString("特徴額３期");
    private static final RString タイトル_特徴額４期 = new RString("特徴額４期");
    private static final RString タイトル_特徴額５期 = new RString("特徴額５期");
    private static final RString タイトル_特徴額６期 = new RString("特徴額６期");
    private static final RString タイトル_普徴額1期 = new RString("普徴額1期");
    private static final RString タイトル_普徴額2期 = new RString("普徴額2期");
    private static final RString タイトル_普徴額3期 = new RString("普徴額3期");
    private static final RString タイトル_普徴額4期 = new RString("普徴額4期");
    private static final RString タイトル_普徴額5期 = new RString("普徴額5期");
    private static final RString タイトル_普徴額6期 = new RString("普徴額6期");
    private static final RString タイトル_普徴額7期 = new RString("普徴額7期");
    private static final RString タイトル_普徴額8期 = new RString("普徴額8期");
    private static final RString タイトル_普徴額9期 = new RString("普徴額9期");
    private static final RString タイトル_普徴額10期 = new RString("普徴額10期");
    private static final RString タイトル_普徴額11期 = new RString("普徴額11期");
    private static final RString タイトル_普徴額12期 = new RString("普徴額12期");
    private static final RString タイトル_備考 = new RString("備考");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_41 = 41;
    private static final int NUM_42 = 42;
    private static final int NUM_43 = 43;
    private static final int NUM_44 = 44;
    private static final int NUM_45 = 45;
    private static final int NUM_46 = 46;
    private static final int NUM_47 = 47;
    private static final int NUM_48 = 48;
    private static final int NUM_49 = 49;
    private static final int NUM_50 = 50;
    private static final int NUM_51 = 51;
    private static final int NUM_52 = 52;

    /**
     * にて生成した{@link HonnSanteiFuka}のインスタンスを返します。
     *
     * @return FukaKeisan
     */
    public static HonnSanteiFukaFath createInstance() {
        return InstanceProvider.create(HonnSanteiFukaFath.class);
    }

    /**
     * コンストラクタです。
     */
    public HonnSanteiFukaFath() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param 帳票制御共通Dac DbT7065ChohyoSeigyoKyotsuDac
     */
    HonnSanteiFukaFath(MapperProvider mapperProvider,
            DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac) {
        this.mapperProvider = mapperProvider;
        this.帳票制御共通Dac = 帳票制御共通Dac;
    }

    /**
     * 本算定結果一覧表出力
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 出力順ID Long
     */
    public void spoolHonsanteiKekkaIchiran(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時,
            Long 出力順ID) {
        IHonnSanteiFukaMapper mapper = mapperProvider.create(IHonnSanteiFukaMapper.class);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID, 出力順ID);
        RString 出力順 = MyBatisOrderByClauseCreator.create(HonsanteiKekkaIcihiranProperty.DBB200009ShutsuryokujunEnum.class, outputOrder);
        KozaSearchKeyBuilder kozabuilder = new KozaSearchKeyBuilder();
        kozabuilder.set業務コード(GyomuCode.DB介護保険);
        kozabuilder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        kozabuilder.set基準日(new FlexibleDate(調定日時.getDate().toString()));
        IKozaSearchKey kozaSearchKey = kozabuilder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        HonsenteiKeisangojohoParameter param = HonsenteiKeisangojohoParameter
                .createSelectByKeyParam(調定年度, 賦課年度, 調定日時, 出力順, kozaSearchKey, list);
        List<HonsenteiKeisangojohoEntity> 本算定計算後賦課情報リスト = mapper.select本算定計算後賦課情報(param);
        List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座List = new ArrayList<>();
        for (HonsenteiKeisangojohoEntity entity : 本算定計算後賦課情報リスト) {
            KeisangoJoho keisangoJoho = new KeisangoJoho(entity.get計算後情報());
            KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity = setKeisangojohoAtenaKozaEntity(keisangoJoho, entity);
            計算後情報_宛名_口座List.add(計算後情報_宛名_口座Entity);
        }
        SourceDataCollection sourceDataCollection = new HonsanteiKekkaIcihiranPrintService().printHonsanteiKekkaIcihira(
                計算後情報_宛名_口座List, 賦課年度, 調定日時, 出力順ID);
        publish本算定結果一覧表(調定日時, 賦課年度, 計算後情報_宛名_口座List);
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(調定年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(賦課年度.wareki().eraType(EraType.KANJI).toDateString()).concat(年度));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    builder.append(iSetSortItem.get項目名());
                } else {
                    builder.append(iSetSortItem.get項目名()).append(SIGN);
                }
            }
        }
        出力条件リスト.add(builder.toRString());
        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(出力条件リスト, 出力ページ数, CSV出力有無_有り, CSVファイル名_一覧表);
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト, RString 出力ページ数,
            RString csv出力有無, RString 帳票名) {

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                csv出力有無,
                本算定_EUCファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * nullの判断するメソッドです。
     *
     * @param 項目 Object
     * @return boolean 項目がnullの場合、falseを返し
     */
    public boolean isNull(Object 項目) {
        return 項目 == null;
    }

    private void publish本算定結果一覧表(YMDHMS 調定日時, FlexibleYear 賦課年度,
            List<KeisangojohoAtenaKozaEntity> 計算後情報_宛名_口座List) {

        List<RString> 月別所得段階リスト = new ArrayList<>();
        RString 口座情報;
        RString 徴収方法;
        RString 備考;
        RString 住所編集;
        List<RString> headList = publish本算定結果一覧表_headList();
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 本算定_EUCファイル名);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath)
                .setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true)
                .setHeader(headList)
                .build()) {
            for (KeisangojohoAtenaKozaEntity 計算後情報_宛名_口座Entity : 計算後情報_宛名_口座List) {
                set月別取得段階(計算後情報_宛名_口座Entity, 月別所得段階リスト);
                口座情報 = kozaJoho(計算後情報_宛名_口座Entity);
                徴収方法 = set徴収方法(計算後情報_宛名_口座Entity);
                備考 = set備考(計算後情報_宛名_口座Entity);
                IKojin 宛名情報 = ShikibetsuTaishoFactory.createKojin(計算後情報_宛名_口座Entity.get宛名Entity());
                ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票ID);
                住所編集 = JushoHenshu.editJusho(帳票制御共通, 宛名情報,
                        AssociationFinderFactory.createInstance().getAssociation());

                List<RString> bodyList = new ArrayList<>();
                RString 作成年月日 = 調定日時.getRDateTime().getDate().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                RString 作成日時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
                bodyList.add(作成年月日);
                bodyList.add(作成日時);
                bodyList.add(賦課年度.toDateString());
                bodyList.add(計算後情報_宛名_口座Entity.get通知書番号().getColumnValue());
                bodyList.add(計算後情報_宛名_口座Entity.get被保険者番号().getColumnValue());
                AtenaMeisho meisho = 計算後情報_宛名_口座Entity.get宛名Entity().getMeisho();
                if (meisho != null) {
                    bodyList.add(meisho.getColumnValue());
                } else {
                    bodyList.add(RString.EMPTY);
                }
                FlexibleDate seinengappiYMD = 計算後情報_宛名_口座Entity.get宛名Entity().getSeinengappiYMD();
                if (seinengappiYMD != null) {
                    RString 生年月日 = seinengappiYMD.seireki()
                            .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
                    bodyList.add(生年月日);
                } else {
                    bodyList.add(RString.EMPTY);
                }
                bodyList.add(宛名情報.get性別().code());
                bodyList.add(計算後情報_宛名_口座Entity.get識別コード().getColumnValue());
                bodyList.add(計算後情報_宛名_口座Entity.get世帯コード().getColumnValue());
                ChoikiCode choikiCode = 計算後情報_宛名_口座Entity.get宛名Entity().getChoikiCode();
                if (choikiCode != null) {
                    bodyList.add(choikiCode.getColumnValue());
                } else {
                    bodyList.add(RString.EMPTY);
                }
                YubinNo yubinNo = 計算後情報_宛名_口座Entity.get宛名Entity().getYubinNo();
                if (yubinNo != null) {
                    bodyList.add(yubinNo.getColumnValue());
                } else {
                    bodyList.add(RString.EMPTY);
                }
                bodyList.add(住所編集);
                if (区分_管内.equals(計算後情報_宛名_口座Entity.get宛名Entity().getKannaiKangaiKubun())
                        && 宛名情報.get住所() != null) {
                    bodyList.add(宛名情報.get住所().get住所());
                } else if (区分_管外.equals(計算後情報_宛名_口座Entity.get宛名Entity().getKannaiKangaiKubun())) {
                    bodyList.add(住所編集);
                } else {
                    bodyList.add(RString.EMPTY);
                }
                AtenaBanchi banchi = 計算後情報_宛名_口座Entity.get宛名Entity().getBanchi();
                if (banchi != null) {
                    bodyList.add(banchi.getColumnValue());
                } else {
                    bodyList.add(RString.EMPTY);
                }
                bodyList.add(口座情報);
                bodyList.add(計算後情報_宛名_口座Entity.get資格取得日().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                bodyList.add(計算後情報_宛名_口座Entity.get資格喪失日().seireki()
                        .separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                ShikakuKikan shikakuKikan = new ShikakuKikan();
                ShikakuKikanJoho 資格期間 = shikakuKikan.get資格期間(賦課年度, 計算後情報_宛名_口座Entity.get資格取得日(),
                        計算後情報_宛名_口座Entity.get資格喪失日());
                bodyList.add(new RString(String.valueOf(資格期間.get月数())));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get確定介護保険料_年額()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get減免前介護保険料_年額()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get減免額()), 0));
                bodyList.add(月別所得段階リスト.get(NUM_3));
                bodyList.add(月別所得段階リスト.get(NUM_4));
                bodyList.add(月別所得段階リスト.get(NUM_5));
                bodyList.add(月別所得段階リスト.get(NUM_6));
                bodyList.add(月別所得段階リスト.get(NUM_7));
                bodyList.add(月別所得段階リスト.get(NUM_8));
                bodyList.add(月別所得段階リスト.get(NUM_9));
                bodyList.add(月別所得段階リスト.get(NUM_10));
                bodyList.add(月別所得段階リスト.get(NUM_11));
                bodyList.add(月別所得段階リスト.get(NUM_0));
                bodyList.add(月別所得段階リスト.get(NUM_1));
                bodyList.add(月別所得段階リスト.get(NUM_2));
                bodyList.add(徴収方法);
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額01()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額02()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額03()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額04()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額05()), 0));
                bodyList.add(DecimalFormatter.toコンマ区切りRString(nullTOZero(計算後情報_宛名_口座Entity.get特徴期別金額06()), 0));
                set普徴額_x期(計算後情報_宛名_口座Entity, bodyList);
                bodyList.add(備考);
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);

        }
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = NUM_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

    private Decimal nullTOZero(Decimal 期別金額) {
        if (期別金額 == null) {
            return Decimal.ZERO;
        }
        return 期別金額;
    }

    private List<RString> publish本算定結果一覧表_headList() {
        List<RString> headList = new ArrayList<>();
        headList.add(タイトル_作成年月日);
        headList.add(タイトル_作成時刻);
        headList.add(タイトル_賦課年度);
        headList.add(タイトル_通知書番号);
        headList.add(タイトル_被保険者番号);
        headList.add(タイトル_氏名);
        headList.add(タイトル_生年月日);
        headList.add(タイトル_性別);
        headList.add(タイトル_識別コード);
        headList.add(タイトル_世帯コード);
        headList.add(タイトル_町域コード);
        headList.add(タイトル_郵便番号);
        headList.add(タイトル_住所);
        headList.add(タイトル_町域管内管外住所);
        headList.add(タイトル_番地);
        headList.add(タイトル_口座情報);
        headList.add(タイトル_資格取得日);
        headList.add(タイトル_資格喪失日);
        headList.add(タイトル_資格期間);
        headList.add(タイトル_確定保険料額);
        headList.add(タイトル_計算上保険料額);
        headList.add(タイトル_減免額);
        headList.add(タイトル_月別取得段階4月);
        headList.add(タイトル_月別取得段階5月);
        headList.add(タイトル_月別取得段階6月);
        headList.add(タイトル_月別取得段階7月);
        headList.add(タイトル_月別取得段階8月);
        headList.add(タイトル_月別取得段階9月);
        headList.add(タイトル_月別取得段階10月);
        headList.add(タイトル_月別取得段階11月);
        headList.add(タイトル_月別取得段階12月);
        headList.add(タイトル_月別取得段階1月);
        headList.add(タイトル_月別取得段階2月);
        headList.add(タイトル_月別取得段階3月);
        headList.add(タイトル_徴収方法);
        headList.add(タイトル_特徴額１期);
        headList.add(タイトル_特徴額２期);
        headList.add(タイトル_特徴額３期);
        headList.add(タイトル_特徴額４期);
        headList.add(タイトル_特徴額５期);
        headList.add(タイトル_特徴額６期);
        headList.add(タイトル_普徴額1期);
        headList.add(タイトル_普徴額2期);
        headList.add(タイトル_普徴額3期);
        headList.add(タイトル_普徴額4期);
        headList.add(タイトル_普徴額5期);
        headList.add(タイトル_普徴額6期);
        headList.add(タイトル_普徴額7期);
        headList.add(タイトル_普徴額8期);
        headList.add(タイトル_普徴額9期);
        headList.add(タイトル_普徴額10期);
        headList.add(タイトル_普徴額11期);
        headList.add(タイトル_普徴額12期);
        headList.add(タイトル_備考);
        return headList;
    }

    private void set普徴額_x期(KeisangojohoAtenaKozaEntity entity,
            List<RString> bodyList) {
        for (int i = 0; i < NUM_12; i++) {
            bodyList.add(RString.EMPTY);
        }
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList kitsukiList = 月期対応取得_普徴.get期月リスト().filtered本算定期間();
        Kitsuki 最終法定納期 = kitsukiList.get最終法定納期();
        int 期 = 最終法定納期.get期AsInt();
        for (int i = 1; i <= 期; i++) {
            switch (i) {
                case NUM_1:
                    bodyList.set(NUM_41, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額01()), 0));
                    break;
                case NUM_2:
                    bodyList.set(NUM_42, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額02()), 0));
                    break;
                case NUM_3:
                    bodyList.set(NUM_43, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額03()), 0));
                    break;
                case NUM_4:
                    bodyList.set(NUM_44, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額04()), 0));
                    break;
                case NUM_5:
                    bodyList.set(NUM_45, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額05()), 0));
                    break;
                case NUM_6:
                    bodyList.set(NUM_46, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額06()), 0));
                    break;
                case NUM_7:
                    bodyList.set(NUM_47, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額07()), 0));
                    break;
                case NUM_8:
                    bodyList.set(NUM_48, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額08()), 0));
                    break;
                case NUM_9:
                    bodyList.set(NUM_49, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額09()), 0));
                    break;
                case NUM_10:
                    bodyList.set(NUM_50, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額10()), 0));
                    break;
                case NUM_11:
                    bodyList.set(NUM_51, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額11()), 0));
                    break;
                case NUM_12:
                    bodyList.set(NUM_52, DecimalFormatter.toコンマ区切りRString(nullTOZero(entity.get普徴期別金額12()), 0));
                    break;
                default:
                    break;
            }
        }
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類Id) throws NullPointerException {
        requireNonNull(帳票分類Id, UrSystemErrorMessages.値がnull.getReplacedMessage(帳票分類Id.toString()));

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類Id);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    private void set月別取得段階(KeisangojohoAtenaKozaEntity entity,
            List<RString> 月別所得段階リスト) {
        for (int i = 0; i < NUM_12; i++) {
            月別所得段階リスト.add(RString.EMPTY);
        }
        if (entity.get月割開始年月1() != null && !entity.get月割開始年月1().isEmpty()
                && entity.get月割終了年月1() != null && !entity.get月割終了年月1().isEmpty()
                && !entity.get保険料算定段階1().isNullOrEmpty()) {
            FlexibleYearMonth 月割開始年月1 = entity.get月割開始年月1();
            int 開始月1 = 月割開始年月1.getMonthValue();
            FlexibleYearMonth 月割終了年月1 = entity.get月割終了年月1();
            int 終了月1 = 月割終了年月1.getMonthValue();
            RString 保険料算定段階1 = entity.get保険料算定段階1();
            set月別取得段階(開始月1, 終了月1, 保険料算定段階1, 月別所得段階リスト);
        }
        if (entity.get月割開始年月2() != null && !entity.get月割開始年月2().isEmpty()
                && entity.get月割終了年月2() != null && !entity.get月割終了年月2().isEmpty()
                && !entity.get保険料算定段階2().isNullOrEmpty()) {
            FlexibleYearMonth 月割開始年月2 = entity.get月割開始年月2();
            int 開始月2 = 月割開始年月2.getMonthValue();
            FlexibleYearMonth 月割終了年月2 = entity.get月割終了年月2();
            int 終了月2 = 月割終了年月2.getMonthValue();
            RString 保険料算定段階2 = entity.get保険料算定段階2();
            set月別取得段階(開始月2, 終了月2, 保険料算定段階2, 月別所得段階リスト);
        }
    }

    private void set月別取得段階(int 開始月, int 終了月,
            RString 保険料算定段階, List<RString> 月別所得段階リスト) {
        for (int i = 開始月; i <= (開始月 > 終了月 ? (終了月 + NUM_12) : 終了月); i++) {
            int currentMonth = (i - 1) % NUM_12 + 1;
            set保険料算定段階(currentMonth, 保険料算定段階, 月別所得段階リスト);
        }
    }

    private void set保険料算定段階(int currentMonth, RString 保険料算定段階,
            List<RString> 月別所得段階リスト) {
        switch (currentMonth) {
            case NUM_1:
                月別所得段階リスト.set(NUM_0, 保険料算定段階);
                break;
            case NUM_2:
                月別所得段階リスト.set(NUM_1, 保険料算定段階);
                break;
            case NUM_3:
                月別所得段階リスト.set(NUM_2, 保険料算定段階);
                break;
            case NUM_4:
                月別所得段階リスト.set(NUM_3, 保険料算定段階);
                break;
            case NUM_5:
                月別所得段階リスト.set(NUM_4, 保険料算定段階);
                break;
            case NUM_6:
                月別所得段階リスト.set(NUM_5, 保険料算定段階);
                break;
            case NUM_7:
                月別所得段階リスト.set(NUM_6, 保険料算定段階);
                break;
            case NUM_8:
                月別所得段階リスト.set(NUM_7, 保険料算定段階);
                break;
            case NUM_9:
                月別所得段階リスト.set(NUM_8, 保険料算定段階);
                break;
            case NUM_10:
                月別所得段階リスト.set(NUM_9, 保険料算定段階);
                break;
            case NUM_11:
                月別所得段階リスト.set(NUM_10, 保険料算定段階);
                break;
            case NUM_12:
                月別所得段階リスト.set(NUM_11, 保険料算定段階);
                break;
            default:
                break;
        }
    }

    private KeisangojohoAtenaKozaEntity setKeisangojohoAtenaKozaEntity(
            KeisangoJoho keisangoJoho, HonsenteiKeisangojohoEntity entity) {
        KeisangojohoAtenaKozaEntity atenaKozaEntity = new KeisangojohoAtenaKozaEntity();
        atenaKozaEntity.set調定年度(keisangoJoho.get調定年度());
        atenaKozaEntity.set賦課年度(keisangoJoho.get賦課年度());
        atenaKozaEntity.set通知書番号(keisangoJoho.get通知書番号());
        atenaKozaEntity.set更正前後区分(keisangoJoho.get更正前後区分());
        atenaKozaEntity.set作成処理名(keisangoJoho.get作成処理名());
        atenaKozaEntity.set賦課履歴番号(keisangoJoho.get賦課履歴番号());
        atenaKozaEntity.set被保険者番号(keisangoJoho.get被保険者番号());
        atenaKozaEntity.set識別コード(keisangoJoho.get識別コード());
        atenaKozaEntity.set世帯コード(keisangoJoho.get世帯コード());
        atenaKozaEntity.set世帯員数(keisangoJoho.get世帯員数());
        atenaKozaEntity.set資格取得日(keisangoJoho.get資格取得日());
        atenaKozaEntity.set資格取得事由(keisangoJoho.get資格取得事由());
        atenaKozaEntity.set資格喪失日(keisangoJoho.get資格喪失日());
        atenaKozaEntity.set資格喪失事由(keisangoJoho.get資格喪失事由());
        atenaKozaEntity.set生活保護扶助種類(keisangoJoho.get生活保護扶助種類());
        atenaKozaEntity.set生保開始日(keisangoJoho.get生保開始日());
        atenaKozaEntity.set生保廃止日(keisangoJoho.get生保廃止日());
        atenaKozaEntity.set老齢開始日(keisangoJoho.get老齢開始日());
        atenaKozaEntity.set老齢廃止日(keisangoJoho.get老齢廃止日());
        atenaKozaEntity.set賦課期日(keisangoJoho.get賦課期日());
        atenaKozaEntity.set課税区分(keisangoJoho.get課税区分());
        atenaKozaEntity.set世帯課税区分(keisangoJoho.get世帯課税区分());
        atenaKozaEntity.set合計所得金額(keisangoJoho.get合計所得金額());
        atenaKozaEntity.set公的年金収入額(keisangoJoho.get公的年金収入額());
        atenaKozaEntity.set保険料段階(keisangoJoho.get保険料段階());
        atenaKozaEntity.set保険料算定段階1(keisangoJoho.get保険料算定段階1());
        atenaKozaEntity.set算定年額保険料1(keisangoJoho.get算定年額保険料1());
        atenaKozaEntity.set月割開始年月1(keisangoJoho.get月割開始年月1());
        atenaKozaEntity.set月割終了年月1(keisangoJoho.get月割終了年月1());
        atenaKozaEntity.set保険料算定段階2(keisangoJoho.get保険料算定段階2());
        atenaKozaEntity.set算定年額保険料2(keisangoJoho.get算定年額保険料2());
        atenaKozaEntity.set月割開始年月2(keisangoJoho.get月割開始年月2());
        atenaKozaEntity.set月割終了年月2(keisangoJoho.get月割終了年月2());
        atenaKozaEntity.set調定日時(keisangoJoho.get調定日時());
        atenaKozaEntity.set調定事由1(keisangoJoho.get調定事由1());
        atenaKozaEntity.set調定事由2(keisangoJoho.get調定事由2());
        atenaKozaEntity.set調定事由3(keisangoJoho.get調定事由3());
        atenaKozaEntity.set調定事由4(keisangoJoho.get調定事由4());
        atenaKozaEntity.set更正月(keisangoJoho.get更正月());
        atenaKozaEntity.set減免前介護保険料_年額(keisangoJoho.get減免前介護保険料_年額());
        atenaKozaEntity.set減免額(keisangoJoho.get減免額());
        atenaKozaEntity.set確定介護保険料_年額(keisangoJoho.get確定介護保険料_年額());
        atenaKozaEntity.set保険料段階_仮算定時(keisangoJoho.get保険料段階_仮算定時());
        atenaKozaEntity.set徴収方法履歴番号(keisangoJoho.get徴収方法履歴番号());
        atenaKozaEntity.set異動基準日時(keisangoJoho.get異動基準日時());
        atenaKozaEntity.set口座区分(keisangoJoho.get口座区分());
        atenaKozaEntity.set境界層区分(keisangoJoho.get境界層区分());
        atenaKozaEntity.set職権区分(keisangoJoho.get職権区分());
        atenaKozaEntity.set賦課市町村コード(keisangoJoho.get賦課市町村コード());
        atenaKozaEntity.set特徴歳出還付額(keisangoJoho.get特徴歳出還付額());
        atenaKozaEntity.set普徴歳出還付額(keisangoJoho.get普徴歳出還付額());
        atenaKozaEntity.set特徴期別金額01(keisangoJoho.get特徴期別金額01());
        atenaKozaEntity.set特徴期別金額02(keisangoJoho.get特徴期別金額02());
        atenaKozaEntity.set特徴期別金額03(keisangoJoho.get特徴期別金額03());
        atenaKozaEntity.set特徴期別金額04(keisangoJoho.get特徴期別金額04());
        atenaKozaEntity.set特徴期別金額05(keisangoJoho.get特徴期別金額05());
        atenaKozaEntity.set特徴期別金額06(keisangoJoho.get特徴期別金額06());
        atenaKozaEntity.set普徴期別金額01(keisangoJoho.get普徴期別金額01());
        atenaKozaEntity.set普徴期別金額02(keisangoJoho.get普徴期別金額02());
        atenaKozaEntity.set普徴期別金額03(keisangoJoho.get普徴期別金額03());
        atenaKozaEntity.set普徴期別金額04(keisangoJoho.get普徴期別金額04());
        atenaKozaEntity.set普徴期別金額05(keisangoJoho.get普徴期別金額05());
        atenaKozaEntity.set普徴期別金額06(keisangoJoho.get普徴期別金額06());
        atenaKozaEntity.set普徴期別金額07(keisangoJoho.get普徴期別金額07());
        atenaKozaEntity.set普徴期別金額08(keisangoJoho.get普徴期別金額08());
        atenaKozaEntity.set普徴期別金額09(keisangoJoho.get普徴期別金額09());
        atenaKozaEntity.set普徴期別金額10(keisangoJoho.get普徴期別金額10());
        atenaKozaEntity.set普徴期別金額11(keisangoJoho.get普徴期別金額11());
        atenaKozaEntity.set普徴期別金額12(keisangoJoho.get普徴期別金額12());
        atenaKozaEntity.set普徴期別金額13(keisangoJoho.get普徴期別金額13());
        atenaKozaEntity.set普徴期別金額14(keisangoJoho.get普徴期別金額14());
        atenaKozaEntity.set徴収方法4月(keisangoJoho.get徴収方法4月());
        atenaKozaEntity.set徴収方法5月(keisangoJoho.get徴収方法5月());
        atenaKozaEntity.set徴収方法6月(keisangoJoho.get徴収方法6月());
        atenaKozaEntity.set徴収方法7月(keisangoJoho.get徴収方法7月());
        atenaKozaEntity.set徴収方法8月(keisangoJoho.get徴収方法8月());
        atenaKozaEntity.set徴収方法9月(keisangoJoho.get徴収方法9月());
        atenaKozaEntity.set徴収方法10月(keisangoJoho.get徴収方法10月());
        atenaKozaEntity.set徴収方法11月(keisangoJoho.get徴収方法11月());
        atenaKozaEntity.set徴収方法12月(keisangoJoho.get徴収方法12月());
        atenaKozaEntity.set徴収方法1月(keisangoJoho.get徴収方法1月());
        atenaKozaEntity.set徴収方法2月(keisangoJoho.get徴収方法2月());
        atenaKozaEntity.set徴収方法3月(keisangoJoho.get徴収方法3月());
        atenaKozaEntity.set徴収方法翌4月(keisangoJoho.get徴収方法翌4月());
        atenaKozaEntity.set徴収方法翌5月(keisangoJoho.get徴収方法翌5月());
        atenaKozaEntity.set徴収方法翌6月(keisangoJoho.get徴収方法翌6月());
        atenaKozaEntity.set徴収方法翌7月(keisangoJoho.get徴収方法翌7月());
        atenaKozaEntity.set徴収方法翌8月(keisangoJoho.get徴収方法翌8月());
        atenaKozaEntity.set徴収方法翌9月(keisangoJoho.get徴収方法翌9月());
        atenaKozaEntity.set仮徴収基礎年金番号(keisangoJoho.get仮徴収_基礎年金番号());
        atenaKozaEntity.set仮徴収年金コード(keisangoJoho.get仮徴収_年金コード());
        atenaKozaEntity.set仮徴収捕捉月(keisangoJoho.get仮徴収_捕捉月());
        atenaKozaEntity.set本徴収基礎年金番号(keisangoJoho.get本徴収_基礎年金番号());
        atenaKozaEntity.set本徴収年金コード(keisangoJoho.get本徴収_年金コード());
        atenaKozaEntity.set本徴収捕捉月(keisangoJoho.get本徴収_捕捉月());
        atenaKozaEntity.set翌年度仮徴収基礎年金番号(keisangoJoho.get翌年度仮徴収_基礎年金番号());
        atenaKozaEntity.set翌年度仮徴収年金コード(keisangoJoho.get翌年度仮徴収_年金コード());
        atenaKozaEntity.set翌年度仮徴収捕捉月(keisangoJoho.get翌年度仮徴収_捕捉月());
        atenaKozaEntity.set依頼情報送付済みフラグ(keisangoJoho.is依頼情報送付済みフラグ());
        atenaKozaEntity.set追加依頼情報送付済みフラグ(keisangoJoho.is追加依頼情報送付済みフラグ());
        atenaKozaEntity.set特別徴収停止日時(keisangoJoho.get特別徴収停止日時());
        atenaKozaEntity.set特別徴収停止事由コード(keisangoJoho.get特別徴収停止事由コード());
        atenaKozaEntity.set特徴収入額01(keisangoJoho.get特徴収入額01());
        atenaKozaEntity.set特徴収入額02(keisangoJoho.get特徴収入額02());
        atenaKozaEntity.set特徴収入額03(keisangoJoho.get特徴収入額03());
        atenaKozaEntity.set特徴収入額04(keisangoJoho.get特徴収入額04());
        atenaKozaEntity.set特徴収入額05(keisangoJoho.get特徴収入額05());
        atenaKozaEntity.set特徴収入額06(keisangoJoho.get特徴収入額06());
        atenaKozaEntity.set普徴収入額01(keisangoJoho.get普徴収入額01());
        atenaKozaEntity.set普徴収入額02(keisangoJoho.get普徴収入額02());
        atenaKozaEntity.set普徴収入額03(keisangoJoho.get普徴収入額03());
        atenaKozaEntity.set普徴収入額04(keisangoJoho.get普徴収入額04());
        atenaKozaEntity.set普徴収入額05(keisangoJoho.get普徴収入額05());
        atenaKozaEntity.set普徴収入額06(keisangoJoho.get普徴収入額06());
        atenaKozaEntity.set普徴収入額07(keisangoJoho.get普徴収入額07());
        atenaKozaEntity.set普徴収入額08(keisangoJoho.get普徴収入額08());
        atenaKozaEntity.set普徴収入額09(keisangoJoho.get普徴収入額09());
        atenaKozaEntity.set普徴収入額10(keisangoJoho.get普徴収入額10());
        atenaKozaEntity.set普徴収入額11(keisangoJoho.get普徴収入額11());
        atenaKozaEntity.set普徴収入額12(keisangoJoho.get普徴収入額12());
        atenaKozaEntity.set普徴収入額13(keisangoJoho.get普徴収入額13());
        atenaKozaEntity.set普徴収入額14(keisangoJoho.get普徴収入額14());
        atenaKozaEntity.set宛名Entity(entity.get宛名());
        atenaKozaEntity.set口座Entity(entity.get口座());
        return atenaKozaEntity;
    }

    private RString kozaJoho(KeisangojohoAtenaKozaEntity entity) {
        KozaRelateEntity releteEntity = entity.get口座Entity();
        IKoza koza = new Koza(releteEntity);
        RString 口座情報 = RString.EMPTY;
        if (koza.get金融機関コード() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4 && ゆうちょ銀行
                    .equals(koza.get金融機関コード().value().substring(NUM_0, NUM_4))) {
                口座情報 = 金融機関コードHander1(koza);
            } else {
                口座情報 = 金融機関コードHander2(koza);
            }
        }
        return 口座情報;
    }

    private RString 金融機関コードHander1(IKoza koza) {
        RString 金融機関コード;
        RString 通帳記号;
        RString 通帳番号;
        RString 口座情報 = RString.EMPTY;
        if (koza.get通帳記号() != null && koza.get通帳番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.get通帳記号().length() >= NUM_5) {
                通帳記号 = koza.get通帳記号().substring(NUM_0, NUM_5);
            } else {
                通帳記号 = koza.get通帳記号();
            }
            if (koza.get通帳番号().length() >= NUM_8) {
                通帳番号 = koza.get通帳番号().substring(NUM_0, NUM_8);
            } else {
                通帳番号 = koza.get通帳番号();
            }
            口座情報 = 金融機関コード.concat(RString.FULL_SPACE).concat(通帳記号).concat(HYPHEN).concat(通帳番号)
                    .concat(RString.FULL_SPACE).concat(koza.get口座名義人漢字().toString());
        }
        return 口座情報;
    }

    private RString 金融機関コードHander2(IKoza koza) {
        RString 金融機関コード;
        RString 預金種別略称;
        RString 支店コード;
        RString 口座番号;
        RString 口座情報 = RString.EMPTY;
        if (koza.get支店コード() != null && koza.get口座番号() != null && koza.get口座名義人漢字() != null) {
            if (koza.get金融機関コード().value().length() >= NUM_4) {
                金融機関コード = koza.get金融機関コード().value().substring(NUM_0, NUM_4);
            } else {
                金融機関コード = koza.get金融機関コード().value();
            }
            if (koza.get支店コード().value().length() >= NUM_3) {
                支店コード = koza.get支店コード().value().substring(NUM_0, NUM_3);
            } else {
                支店コード = koza.get支店コード().value();
            }
            if (koza.get預金種別() != null && koza.get預金種別().get預金種別略称().length() >= NUM_2) {
                預金種別略称 = koza.get預金種別().get預金種別略称().substring(NUM_0, NUM_2);
            } else {
                預金種別略称 = koza.get預金種別().get預金種別略称();
            }
            if (koza.get口座番号().length() >= NUM_7) {
                口座番号 = koza.get口座番号().substring(NUM_0, NUM_7);
            } else {
                口座番号 = koza.get口座番号();
            }
            口座情報 = 金融機関コード.concat(HYPHEN).concat(支店コード).concat(RString.FULL_SPACE)
                    .concat(預金種別略称).concat(HYPHEN).concat(口座番号).concat(RString.FULL_SPACE)
                    .concat(koza.get口座名義人漢字().toString());
        }
        return 口座情報;
    }

    private RString set徴収方法(KeisangojohoAtenaKozaEntity entity) {
        RString 徴収方法 = RString.EMPTY;
        Decimal 特徴期の期別金額の合計 = nullTOZero(entity.get特徴期別金額04())
                .add(nullTOZero(entity.get特徴期別金額05()))
                .add(nullTOZero(entity.get特徴期別金額06()));
        Decimal 普徴期の期別金額の合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()).add(nullTOZero(entity.get普徴期別金額03())))
                .add(nullTOZero(entity.get普徴期別金額04())).add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06())).add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08())).add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10())).add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12())).add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0
                && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 徴収方法;
        } else if (Decimal.ONE.compareTo(特徴期の期別金額の合計) < NUM_0
                && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 特別徴収;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0
                && Decimal.ONE.compareTo(普徴期の期別金額の合計) < NUM_0) {
            return 普通徴収;
        } else if (Decimal.ONE.compareTo(特徴期の期別金額の合計) < NUM_0
                && Decimal.ONE.compareTo(普徴期の期別金額の合計) < NUM_0) {
            return 併用徴収;
        } else {
            return 徴収方法;
        }
    }

    private RString set備考(KeisangojohoAtenaKozaEntity entity) {
        RString 備考 = RString.EMPTY;
        Decimal 特徴期の期別金額の合計 = nullTOZero(entity.get特徴期別金額04())
                .add(nullTOZero(entity.get特徴期別金額05()))
                .add(nullTOZero(entity.get特徴期別金額06()));
        Decimal 普徴期の期別金額の合計 = nullTOZero(entity.get普徴期別金額01())
                .add(nullTOZero(entity.get普徴期別金額02()).add(nullTOZero(entity.get普徴期別金額03())))
                .add(nullTOZero(entity.get普徴期別金額04())).add(nullTOZero(entity.get普徴期別金額05()))
                .add(nullTOZero(entity.get普徴期別金額06())).add(nullTOZero(entity.get普徴期別金額07()))
                .add(nullTOZero(entity.get普徴期別金額08())).add(nullTOZero(entity.get普徴期別金額09()))
                .add(nullTOZero(entity.get普徴期別金額10())).add(nullTOZero(entity.get普徴期別金額11()))
                .add(nullTOZero(entity.get普徴期別金額12())).add(nullTOZero(entity.get普徴期別金額13()))
                .add(nullTOZero(entity.get普徴期別金額14()));
        if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0
                && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 本算定賦課なし;
        } else if (Decimal.ONE.compareTo(特徴期の期別金額の合計) < NUM_0
                && 普徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 本算定前半普徴;
        } else if (特徴期の期別金額の合計.compareTo(Decimal.ZERO) == NUM_0
                && Decimal.ONE.compareTo(普徴期の期別金額の合計) < NUM_0) {
            return 備考;
        } else if (Decimal.ONE.compareTo(特徴期の期別金額の合計) < NUM_0
                && Decimal.ONE.compareTo(普徴期の期別金額の合計) < NUM_0) {
            return 備考;
        } else {
            return 備考;
        }
    }

}
