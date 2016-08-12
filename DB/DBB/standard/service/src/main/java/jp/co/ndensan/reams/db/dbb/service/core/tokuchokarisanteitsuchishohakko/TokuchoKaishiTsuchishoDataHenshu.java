/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko.PrtTokuchoKaishiTsuchishoKarisanteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchokarisanteitsuchishohakko.TsuchishoDataTempResult;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KaishiTsuchishoKariHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoKariOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.kibetsu.KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2017TsuchishoHakkogoIdoshaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteitsuchishohakko.ITokuchoKarisanteiTsuchishoHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.report.tokuchokarisanteitsuchishohakko.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * ビジネス設計_DBBBZ33002_1_特徴仮算定通知書一括発行（バッチ）
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public class TokuchoKaishiTsuchishoDataHenshu {

    private final MapperProvider provider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private final DbT2017TsuchishoHakkogoIdoshaDac 通知書発行後異動者Dac;
    private static final RString 定数_特徴方法 = new RString("getTkKibetsuGaku");
    private static final RString 定数_普徴方法 = new RString("getFuKibetsuGaku");
    private static final RString 項目名 = new RString("宛名連番印字");
    private static final RString 設定値_1 = new RString("1");
    private static final RString 宛名連番値 = new RString("*000001#");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_発行日 = new RString("【発行日】");
    private static final RString 定数_出力対象 = new RString("【出力対象】");
    private static final RString 定数_出力順 = new RString("【出力順】");
    private static final RString 定数_抽出条件 = new RString("抽出条件");
    private static final RString 定数_帳票名 = new RString("特別徴収開始通知書（仮算定）");
    private static final RString 定数_処理名 = new RString("「特徴仮算定通知書一括発行」");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSVファイル名_一覧表 = new RString("特徴仮算定通知書一括発行一覧");
    private static final RString 定値_0 = new RString("0");
    private static final RString 定値_1 = new RString("1");
    private static final RString 定値_2 = new RString("2");
    private static final RString 定値_3 = new RString("3");
    private static final RString 定値_4 = new RString("4");
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域_管内_管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_行政区コード = new RString("行政区コード");
    private static final RString タイトル_行政区 = new RString("行政区");
    private static final RString タイトル_生年月日 = new RString("生年月日");
    private static final RString タイトル_性別 = new RString("性別");
    private static final RString タイトル_世帯主名 = new RString("世帯主名");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_被保険者氏名 = new RString("被保険者氏名");
    private static final RString タイトル_特別徴収業務者コード = new RString("特別徴収業務者コード");
    private static final RString タイトル_特別徴収業務者 = new RString("特別徴収業務者");
    private static final RString タイトル_特別徴収対象年金コード = new RString("特別徴収対象年金コード");
    private static final RString タイトル_特別徴収対象年金 = new RString("特別徴収対象年金");
    private static final RString タイトル_本徴収額_4月 = new RString("仮徴収額（4月）");
    private static final RString タイトル_本徴収額_6月 = new RString("仮徴収額（6月）");
    private static final RString タイトル_本徴収額_8月 = new RString("仮徴収額（8月）");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200001");
    private static final RString 特別徴収_EUCファイル名 = new RString("TokubetsuChoshuKaishiTsuchishoKairiHakkoIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final ReportId 帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_14 = 14;

    /**
     * テスト用コンストラクタです。
     */
    public TokuchoKaishiTsuchishoDataHenshu() {
        this.provider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        this.通知書発行後異動者Dac = InstanceProvider.create(DbT2017TsuchishoHakkogoIdoshaDac.class);
    }

    /**
     * 該当クラスの対象を返す。
     *
     * @return TokuchoKaishiTsuchishoDataHenshu 該当クラスの対象
     */
    public static TokuchoKaishiTsuchishoDataHenshu createInstance() {
        return InstanceProvider.create(TokuchoKaishiTsuchishoDataHenshu.class);
    }

    /**
     * 賦課情報取得
     *
     */
    public void getFukaJoho() {
        ITokuchoKarisanteiTsuchishoHakkoMapper mapper = provider.create(ITokuchoKarisanteiTsuchishoHakkoMapper.class);
        mapper.update仮算定一括発行一時_前年度賦課情報();
        mapper.update仮算定一括発行一時_特徴調定額();
        mapper.update仮算定一括発行一時_被保険者区分0();
        mapper.update仮算定一括発行一時_被保険者区分1();
        mapper.update仮算定一括発行一時_被保険者区分2();
    }

    /**
     * 通知書の発行
     *
     * @param result PrtTokuchoKaishiTsuchishoKarisanteiResult
     * @param 総ページ数 int
     * @param 編集後仮算定通知書共通情報List List<EditedKariSanteiTsuchiShoKyotsu>
     */
    public void printTsuchisho(PrtTokuchoKaishiTsuchishoKarisanteiResult result,
            int 総ページ数, List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報List) {
        loadバッチ出力条件リスト(result.get出力条件リスト(), result.get帳票ID(), new RString(総ページ数),
                CSV出力有無_あり, CSVファイル名_一覧表, result.get帳票名());
        load代行プリント送付票(result.get発行日(), result.get出力対象区分(), result.get帳票制御共通(),
                result.get地方公共団体(), result.get出力順ID(), new Decimal(総ページ数));
        new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranPrintService().printSingle(編集後仮算定通知書共通情報List,
                result.get出力順ID(), result.get調定年度(), result.get帳票作成日時());
        publish特別徴収開始通知書仮算定発行一覧表(result.get調定年度(), result.get帳票作成日時(), 編集後仮算定通知書共通情報List);
    }

    /**
     * 通知書発行後異動者登録
     *
     * @param 出力対象区分 RString
     * @param 帳票作成日時 YMDHMS
     * @param 出力順ID Long
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdosha(RString 出力対象区分, YMDHMS 帳票作成日時,
            RString 出力順ID, ReportId 帳票ID) {
        List<TsuchishoDataTempEntity> 出力対象List = get出力対象データ(出力対象区分, 出力順ID);
        if (出力対象List == null || 出力対象List.isEmpty()) {
            return;
        }
        int 連番 = 1;
        for (TsuchishoDataTempEntity 出力対象 : 出力対象List) {
            if (出力対象.get計算後情報() == null || 出力対象.get計算後情報().getTsuchishoNo() == null) {
                continue;
            }
            DbT2017TsuchishoHakkogoIdoshaEntity 通知書発行後異動者 = new DbT2017TsuchishoHakkogoIdoshaEntity();
            通知書発行後異動者.setReportID(帳票ID);
            通知書発行後異動者.setChohyosakuseiTimestamp(帳票作成日時);
            通知書発行後異動者.setTsuchishoNo(出力対象.get計算後情報().getTsuchishoNo());
            通知書発行後異動者.setFukaNendo(出力対象.get計算後情報().getFukaNendo());
            通知書発行後異動者.setShikibetsuCode(出力対象.get計算後情報().getShikibetsuCode());
            通知書発行後異動者.setHihokenshaNo(出力対象.get計算後情報().getHihokenshaNo());
            通知書発行後異動者.setKeisanTimestamp(出力対象.get計算後情報().getChoteiNichiji());
            通知書発行後異動者.setGaitoRemban(連番);
            通知書発行後異動者.setIdoAriFlag(false);
            通知書発行後異動者.setState(EntityDataState.Added);
            通知書発行後異動者Dac.save(通知書発行後異動者);
            連番 = 連番 + INT_1;
        }
    }

    /**
     * 特徴開始通知書(仮算定）の発行メソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 発行日 FlexibleDate
     * @param 帳票作成日時 YMDHMS
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 出力対象 RString
     * @return PrtTokuchoKaishiTsuchishoKarisanteiResult 特徴開始通知書(仮算定）の発行用引数
     */
    public PrtTokuchoKaishiTsuchishoKarisanteiResult prtTokuchoKaishiTsuchishoKarisantei(
            FlexibleYear 調定年度,
            FlexibleDate 発行日, YMDHMS 帳票作成日時, RString 出力順ID, ReportId 帳票ID, RString 出力対象) {
        PrtTokuchoKaishiTsuchishoKarisanteiResult prtResult = new PrtTokuchoKaishiTsuchishoKarisanteiResult();
        List<TsuchishoDataTempEntity> 出力対象List = get出力対象データ(出力対象, 出力順ID);
        List<RString> 出力条件リスト = get出力条件リスト(発行日, 出力対象, 出力順ID);
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(帳票分類ID);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 帳票名 = get帳票名_特徴(帳票ID.getColumnValue());
        if (出力対象List == null || 出力対象List.isEmpty() || 出力対象List.get(INT_0).get計算後情報() == null) {
            load代行プリント送付票(発行日, 出力対象, 帳票制御共通, 地方公共団体, 出力順ID, Decimal.ZERO);
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_0,
                    CSV出力有無_なし, CSVファイル名, 帳票名);
            return null;
        }
        ChohyoSeigyoHanyo 帳票制御汎用 = load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名);
        RString 宛名連番 = RString.EMPTY;
        if (設定値_1.equals(帳票制御汎用.get設定値())) {
            宛名連番 = 宛名連番値;
        }
        RString 通知書定型文1 = null;
        RString 通知書定型文2 = null;
        if (帳票制御共通 != null && !nullTOEmpty(帳票制御共通.get定型文文字サイズ()).isEmpty()) {
            int パターン番号 = Integer.parseInt(nullTOEmpty(帳票制御共通.get定型文文字サイズ()).toString());
            FlexibleDate システム日付 = FlexibleDate.getNowDate();
            通知書定型文1 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課, 帳票分類ID, KamokuCode.EMPTY,
                    パターン番号, INT_1, システム日付);
            通知書定型文2 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課, 帳票分類ID, KamokuCode.EMPTY,
                    パターン番号, INT_2, システム日付);
        }
        List<TsuchishoDataTempResult> tempResultList = get仮算定情報(出力対象List);
        prtResult.set出力条件リスト(出力条件リスト);
        prtResult.set出力順ID(出力順ID);
        prtResult.set宛名連番(宛名連番);
        prtResult.set帳票ID(帳票ID);
        prtResult.set特徴開始通知書ResultList(tempResultList);
        prtResult.set通知書定型文1(通知書定型文1);
        prtResult.set通知書定型文2(通知書定型文2);
        prtResult.set帳票制御共通(帳票制御共通);
        prtResult.set帳票名(帳票名);
        prtResult.set調定年度(調定年度);
        prtResult.set帳票作成日時(帳票作成日時);
        prtResult.set発行日(発行日);
        prtResult.set出力対象区分(出力対象);
        prtResult.set地方公共団体(地方公共団体);
        return prtResult;
    }

    private void publish特別徴収開始通知書仮算定発行一覧表(FlexibleYear 調定年度, YMDHMS 帳票作成日時,
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報List) {

        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_作成年月日);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_賦課年度);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_行政区コード);
        headerList.add(タイトル_行政区);
        headerList.add(タイトル_生年月日);
        headerList.add(タイトル_性別);
        headerList.add(タイトル_世帯主名);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_被保険者氏名);
        headerList.add(タイトル_特別徴収業務者コード);
        headerList.add(タイトル_特別徴収業務者);
        headerList.add(タイトル_特別徴収対象年金コード);
        headerList.add(タイトル_特別徴収対象年金);
        headerList.add(タイトル_本徴収額_4月);
        headerList.add(タイトル_本徴収額_6月);
        headerList.add(タイトル_本徴収額_8月);

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 特別徴収_EUCファイル名);
        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build()) {
            for (EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 : 編集後仮算定通知書共通情報List) {
                List<RString> bodyList = new ArrayList<>();
                bodyList.add(帳票作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                bodyList.add(帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                bodyList.add(調定年度.toDateString());
                if (isNull(編集後仮算定通知書共通情報.get編集後宛先())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get郵便番号());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get編集後住所());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get町域());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get番地());
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後宛先().get行政区コード())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後宛先().get行政区コード().getColumnValue());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get行政区名());
                }
                if (isNull(編集後仮算定通知書共通情報.get編集後個人())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後仮算定通知書共通情報.get編集後個人().get生年月日Csv());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後個人().get性別());
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get世帯主名())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue());

                }
                bodyList.add(isNull(編集後仮算定通知書共通情報.get通知書番号())
                        ? RString.EMPTY : 編集後仮算定通知書共通情報.get通知書番号().getColumnValue());
                if (isNull(編集後仮算定通知書共通情報.get編集後個人())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get世帯コード())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get名称())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue());
                }
                if (isNull(編集後仮算定通知書共通情報.get更正後())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収義務者コード());
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収義務者());
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収対象年金コード());
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収対象年金());
                    if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額01() != null) {
                        bodyList.add(DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額01(), 0));
                    } else {
                        bodyList.add(RString.EMPTY);
                    }
                    if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額02() != null) {
                        bodyList.add(DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額02(), 0));
                    } else {
                        bodyList.add(RString.EMPTY);
                    }
                    if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額03() != null) {
                        bodyList.add(DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額03(), 0));
                    } else {
                        bodyList.add(RString.EMPTY);
                    }
                }
                toBodyList(bodyList);
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, 特別徴収_EUCファイル名);
        }
    }

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

    private void load代行プリント送付票(FlexibleDate 発行日, RString 出力対象区分,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            Association 地方公共団体, RString 出力順ID, Decimal ページ数) {

        if (!帳票制御共通情報.is代行プリント有無()) {
            return;
        }

        List<RString> 出力順項目List = new ArrayList<>();
        List<RString> 改ページ項目List = new ArrayList<>();
        set出力順_改頁(出力順ID, 出力順項目List, 改ページ項目List);

        List<RString> 抽出条件List = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_抽出条件);
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力対象
                .concat(TokuchoKaishiTsuhishoKariOutputJoken.valueOf(出力対象区分.toString()).get名称()));
        抽出条件List.add(builder.toRString());
        List<RString> 帳票名List = new ArrayList<>();
        帳票名List.add(定数_帳票名);
        List<Decimal> ページ数List = new ArrayList<>();
        ページ数List.add(ページ数);

        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名(),
                ジョブ番号.concat(RString.FULL_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                定数_処理名, 代行プリント送付票_帳票ID.getColumnValue(), 帳票名List, ページ数List, 抽出条件List,
                出力順項目List, 改ページ項目List, null);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        daikoPrint.print();
    }

    private List<TsuchishoDataTempEntity> get出力対象データ(RString 出力対象区分, RString 出力順ID) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        TokuchoKaishiTsuchishoMybatisParameter parameter = new TokuchoKaishiTsuchishoMybatisParameter();
        if (出力順ID != null && !出力順ID.isEmpty()) {
            IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
            if (outputOrder != null) {
                RString 出力順 = MyBatisOrderByClauseCreator.create(KaishiTsuchishoKariHakkoIchiranProperty.BreakerFieldsEnum.class,
                        outputOrder);
                parameter.set出力順(出力順);
            }
        }
        parameter.set出力対象(get出力対象(出力対象区分));
        ITokuchoKarisanteiTsuchishoHakkoMapper mapper = provider.create(ITokuchoKarisanteiTsuchishoHakkoMapper.class);
        return mapper.select出力対象データ(parameter);
    }

    private RString get出力対象(RString 出力対象) {
        RString 出力対象code = RString.EMPTY;
        if (TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含む.get名称().equals(出力対象)) {
            出力対象code = 定値_0;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含まない.get名称().equals(出力対象)) {
            出力対象code = 定値_1;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken.追加候補者のみ全て.get名称().equals(出力対象)) {
            出力対象code = 定値_2;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken._4月特別徴収開始の追加候補者のみ.get名称().equals(出力対象)) {
            出力対象code = 定値_3;
        } else if (TokuchoKaishiTsuhishoKariOutputJoken._6月特別徴収開始の追加候補者のみ.get名称().equals(出力対象)) {
            出力対象code = 定値_4;
        }
        return 出力対象code;
    }

    /**
     * 帳票制御共通情報取得メソッドです。
     *
     * @param 帳票分類ID ReportId
     * @return ChohyoSeigyoKyotsu 帳票制御共通情報
     */
    public ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) {

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    /**
     * 帳票制御汎用取得メソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    public ChohyoSeigyoHanyo load帳票制御汎用ByKey(ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(SubGyomuCode.DBB介護賦課, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

    private List<TsuchishoDataTempResult> get仮算定情報(List<TsuchishoDataTempEntity> 出力対象List) {
        List<TsuchishoDataTempResult> tmpResultList = new ArrayList<>();
        if (出力対象List == null || 出力対象List.isEmpty()) {
            return tmpResultList;
        }
        for (TsuchishoDataTempEntity tempEntity : 出力対象List) {
            TsuchishoDataTempResult result = new TsuchishoDataTempResult();
            result.set計算後情報Entity(tempEntity.get計算後情報());
            result.set賦課の情報(get賦課の情報(tempEntity));
            IAtesaki 宛先 = AtesakiFactory.createInstance(tempEntity.get宛先());
            result.set宛先情報(宛先);
            if (tempEntity.get対象者_追加含む情報() != null) {
                result.set対象者_追加含む_情報(new NenkinTokuchoKaifuJoho(tempEntity.get対象者_追加含む情報()));
            }
            result.set徴収方法情報(get徴収方法情報(tempEntity));
            result.set納組情報(tempEntity.get納組());
            List<Decimal> 期別金額リスト = new ArrayList<>();
            期別金額リスト.add(tempEntity.get前年度特徴期別金額01());
            期別金額リスト.add(tempEntity.get前年度特徴期別金額02());
            期別金額リスト.add(tempEntity.get前年度特徴期別金額03());
            期別金額リスト.add(tempEntity.get前年度特徴期別金額04());
            期別金額リスト.add(tempEntity.get前年度特徴期別金額05());
            期別金額リスト.add(tempEntity.get前年度特徴期別金額06());
            FukaJoho 賦課情報 = get賦課情報(tempEntity.get前年度賦課情報(), 期別金額リスト);
            if (賦課情報.get調定年度() == null || 賦課情報.get賦課年度() == null || 賦課情報.get通知書番号() == null) {
                賦課情報 = null;
            }
            result.set前年度賦課情報(賦課情報);
            tmpResultList.add(result);
        }
        return tmpResultList;
    }

    private FukaAtena get賦課の情報(TsuchishoDataTempEntity tempEntity) {

        FukaAtena fukaAtena = new FukaAtena();
        DbTKeisangoJohoTempTableEntity 計算後情報 = tempEntity.get計算後情報();

        if (計算後情報 == null || 計算後情報.getChoteiNendo() == null || 計算後情報.getChoteiNendo().isEmpty()
                || 計算後情報.getFukaNendo() == null || 計算後情報.getFukaNendo().isEmpty()
                || 計算後情報.getTsuchishoNo() == null || 計算後情報.getTsuchishoNo().isEmpty()) {
            return null;
        }
        Fuka fuka = new Fuka(計算後情報.getChoteiNendo(), 計算後情報.getFukaNendo(),
                計算後情報.getTsuchishoNo(), 計算後情報.getFukaRirekiNo());
        fuka = fuka.createBuilderForEdit().set被保険者番号(計算後情報.getHihokenshaNo())
                .set識別コード(計算後情報.getShikibetsuCode())
                .set世帯コード(計算後情報.getSetaiCode()).set世帯員数(計算後情報.getSetaiInsu())
                .set資格取得日(計算後情報.getShikakuShutokuYMD()).set資格取得事由(計算後情報.getShikakuShutokuJiyu())
                .set資格喪失日(計算後情報.getShikakuSoshitsuYMD()).set資格喪失事由(計算後情報.getShikakuSoshitsuJiyu())
                .set生活保護扶助種類(計算後情報.getSeihofujoShurui()).set生保開始日(計算後情報.getSeihoKaishiYMD())
                .set生保廃止日(計算後情報.getSeihoHaishiYMD()).set老年開始日(計算後情報.getRonenKaishiYMD())
                .set老年廃止日(計算後情報.getRonenHaishiYMD()).set賦課期日(計算後情報.getFukaYMD())
                .set課税区分(計算後情報.getKazeiKubun()).set世帯課税区分(計算後情報.getSetaikazeiKubun())
                .set合計所得金額(計算後情報.getGokeiShotokuGaku()).set公的年金収入額(計算後情報.getNenkinShunyuGaku())
                .set保険料段階(計算後情報.getHokenryoDankai()).set保険料算定段階1(計算後情報.getHokenryoDankai1())
                .set算定年額保険料1(計算後情報.getNengakuHokenryo1()).set保険料算定段階2(計算後情報.getHokenryoDankai2())
                .set算定年額保険料2(計算後情報.getNengakuHokenryo2()).set調定日時(計算後情報.getChoteiNichiji())
                .set調定事由1(計算後情報.getChoteiJiyu1()).set調定事由2(計算後情報.getChoteiJiyu2())
                .set調定事由3(計算後情報.getChoteiJiyu3()).set調定事由4(計算後情報.getChoteiJiyu4())
                .set更正月(計算後情報.getKoseiM()).set減免前介護保険料_年額(計算後情報.getGemmenMaeHokenryo())
                .set減免額(計算後情報.getGemmenGaku()).set確定介護保険料_年額(計算後情報.getKakuteiHokenryo())
                .set保険料段階_仮算定時(計算後情報.getHokenryoDankaiKarisanntei())
                .set徴収方法履歴番号(計算後情報.getChoshuHohoRirekiNo())
                .set異動基準日時(計算後情報.getIdoKijunNichiji()).set口座区分(計算後情報.getKozaKubun())
                .set境界層区分(計算後情報.getKyokaisoKubun()).set職権区分(計算後情報.getShokkenKubun())
                .set賦課市町村コード(計算後情報.getFukaShichosonCode()).set特徴歳出還付額(計算後情報.getTkSaishutsuKampuGaku())
                .set普徴歳出還付額(計算後情報.getFuSaishutsuKampuGaku()).set月割開始年月1(計算後情報.getTsukiwariStartYM1())
                .set月割終了年月1(計算後情報.getTsukiwariEndYM1()).set月割開始年月2(計算後情報.getTsukiwariStartYM2())
                .set月割終了年月2(計算後情報.getTsukiwariEndYM2()).build();

        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        fukaJohoRelateEntity.set介護賦課Entity(fuka.toEntity());
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        for (int index = INT_1; index < INT_7; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(get特徴調定額(計算後情報, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        for (int index = INT_1; index <= INT_14; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(計算後情報.getChoteiNendo());
            介護期別Entity.setFukaNendo(計算後情報.getFukaNendo());
            介護期別Entity.setTsuchishoNo(計算後情報.getTsuchishoNo());
            介護期別Entity.setRirekiNo(計算後情報.getFukaRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index).add(Decimal.TEN));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.普通徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).add(Decimal.TEN).longValue());
            調定共通Entity.setChoteigaku(get普通調定額(計算後情報, index));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        FukaJoho 賦課情報 = new FukaJoho(fukaJohoRelateEntity);
        fukaAtena.set賦課情報(賦課情報);
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(tempEntity.get宛名());
        fukaAtena.set宛名(宛名);
        return fukaAtena;
    }

    private FukaJoho get賦課情報(FukaJohoRelateEntity fukaJohoRelateEntity, List<Decimal> 期別金額リスト) {
        if (fukaJohoRelateEntity == null) {
            return null;
        }
        DbT2002FukaEntity 介護賦課Entity = fukaJohoRelateEntity.get介護賦課Entity();
        List<KibetsuEntity> 介護期別RelateEntity = new ArrayList<>();
        int i = 0;
        for (int index = INT_1; index < INT_7; index++) {
            KibetsuEntity 介護期別Relate = new KibetsuEntity();
            DbT2003KibetsuEntity 介護期別Entity = new DbT2003KibetsuEntity();
            介護期別Entity.setChoteiNendo(介護賦課Entity.getChoteiNendo());
            介護期別Entity.setFukaNendo(介護賦課Entity.getFukaNendo());
            介護期別Entity.setTsuchishoNo(介護賦課Entity.getTsuchishoNo());
            介護期別Entity.setRirekiNo(介護賦課Entity.getRirekiNo());
            介護期別Entity.setChoteiId(new Decimal(index));
            介護期別Entity.setChoshuHouhou(ChoshuHohoKibetsu.特別徴収.getコード());
            介護期別Entity.setKi(index);
            List<UrT0705ChoteiKyotsuEntity> 調定共通EntityList = new ArrayList<>();
            UrT0705ChoteiKyotsuEntity 調定共通Entity = new UrT0705ChoteiKyotsuEntity();
            調定共通Entity.setChoteiId(new Decimal(index).longValue());
            調定共通Entity.setChoteigaku(期別金額リスト.get(i));
            調定共通EntityList.add(調定共通Entity);
            介護期別Relate.set介護期別Entity(介護期別Entity);
            介護期別Relate.set調定共通Entity(調定共通EntityList);
            介護期別RelateEntity.add(介護期別Relate);
            i = i + INT_1;
        }
        fukaJohoRelateEntity.set介護期別RelateEntity(介護期別RelateEntity);
        return new FukaJoho(fukaJohoRelateEntity);

    }

    private ChoshuHoho get徴収方法情報(TsuchishoDataTempEntity tempEntity) {

        DbTKeisangoJohoTempTableEntity 計算後情報 = tempEntity.get計算後情報();

        if (計算後情報 == null || 計算後情報.getFukaNendo() == null || 計算後情報.getFukaNendo().isEmpty()
                || 計算後情報.getHihokenshaNo() == null || 計算後情報.getHihokenshaNo().isEmpty()) {
            return null;
        }
        ChoshuHoho 徴収方法情報 = new ChoshuHoho(計算後情報.getFukaNendo(),
                計算後情報.getHihokenshaNo(), 計算後情報.getChoshuHohoRirekiNo());
        徴収方法情報 = 徴収方法情報.createBuilderForEdit().set徴収方法4月(計算後情報.getChoshuHoho4gatsu())
                .set徴収方法5月(計算後情報.getChoshuHoho5gatsu()).set徴収方法6月(計算後情報.getChoshuHoho6gatsu())
                .set徴収方法7月(計算後情報.getChoshuHoho7gatsu()).set徴収方法8月(計算後情報.getChoshuHoho8gatsu())
                .set徴収方法9月(計算後情報.getChoshuHoho9gatsu()).set徴収方法10月(計算後情報.getChoshuHoho10gatsu())
                .set徴収方法11月(計算後情報.getChoshuHoho11gatsu()).set徴収方法12月(計算後情報.getChoshuHoho12gatsu())
                .set徴収方法1月(計算後情報.getChoshuHoho1gatsu()).set徴収方法2月(計算後情報.getChoshuHoho2gatsu())
                .set徴収方法3月(計算後情報.getChoshuHoho3gatsu()).set徴収方法翌4月(計算後情報.getChoshuHohoYoku4gatsu())
                .set徴収方法翌5月(計算後情報.getChoshuHohoYoku5gatsu()).set徴収方法翌6月(計算後情報.getChoshuHohoYoku6gatsu())
                .set徴収方法翌7月(計算後情報.getChoshuHohoYoku7gatsu()).set徴収方法翌8月(計算後情報.getChoshuHohoYoku8gatsu())
                .set徴収方法翌9月(計算後情報.getChoshuHohoYoku9gatsu()).set仮徴収_基礎年金番号(計算後情報.getKariNenkinNo())
                .set仮徴収_年金コード(計算後情報.getKariNenkinCode()).set仮徴収_捕捉月(計算後情報.getKariHosokuM())
                .set本徴収_基礎年金番号(計算後情報.getHonNenkinNo()).set本徴収_年金コード(計算後情報.getHonNenkinCode())
                .set本徴収_捕捉月(計算後情報.getHonHosokuM()).set翌年度仮徴収_基礎年金番号(計算後情報.getYokunendoKariNenkinNo())
                .set翌年度仮徴収_年金コード(計算後情報.getYokunendoKariNenkinCode())
                .set翌年度仮徴収_捕捉月(計算後情報.getYokunendoKariHosokuM())
                .set依頼情報送付済みフラグ(計算後情報.isIraiSohuzumiFlag())
                .set追加依頼情報送付済みフラグ(計算後情報.isTsuikaIraiSohuzumiFlag())
                .set特別徴収停止日時(計算後情報.getTokuchoTeishiNichiji())
                .set特別徴収停止事由コード(計算後情報.getTokuchoTeishiJiyuCode()).build();
        return 徴収方法情報;
    }

    private Decimal get特徴調定額(DbTKeisangoJohoTempTableEntity entity, int index) {
        Decimal 特徴調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_特徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            特徴調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(TokuchoKaishiTsuchishoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 特徴調定額;
    }

    private Decimal get普通調定額(DbTKeisangoJohoTempTableEntity entity, int index) {
        Decimal 普通調定額 = Decimal.ZERO;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_普徴方法.toString());
        sb.append(new RString(index).padZeroToLeft(2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            普通調定額 = (Decimal) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(TokuchoKaishiTsuchishoDataHenshu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 普通調定額;
    }

    private RString get帳票名_特徴(RString 帳票ID) {

        if (ReportIdDBB.DBB100003.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100003.getReportName();
        } else if (ReportIdDBB.DBB100004.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100004.getReportName();
        } else if (ReportIdDBB.DBB100005.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100005.getReportName();
        } else if (ReportIdDBB.DBB100006.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100006.getReportName();
        } else if (ReportIdDBB.DBB100008.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100008.getReportName();
        } else if (ReportIdDBB.DBB100009.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100009.getReportName();
        }
        return RString.EMPTY;
    }

    private List<RString> get出力条件リスト(FlexibleDate 発行日, RString 出力対象区分,
            RString 出力順ID) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力対象.concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力対象区分) ? RString.EMPTY : TokuchoKaishiTsuhishoKariOutputJoken.valueOf(出力対象区分.toString()).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力順.concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (出力順ID != null && !出力順ID.isEmpty()) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        }
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
        return 出力条件リスト;
    }

    private RString nullTOEmpty(RString 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return RString.EMPTY;
        }
        return 項目;
    }

    private void set出力順_改頁(RString 出力順ID, List<RString> 出力順項目List, List<RString> 改ページ項目List) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.valueOf(出力順ID.toString()));
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        int i = INT_1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力順項目List.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改ページ項目List.add(setSortItem.get項目名());
                }
            }
            i = i + INT_1;
        }
    }

    private void toBodyList(List<RString> bodyList) {
        for (int i = INT_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
    }

    /**
     * nullの判断するメソッドです。
     *
     * @param 項目 Object
     * @return boolean 項目がnullの場合、falseを返し
     */
    private boolean isNull(Object 項目) {
        return 項目 == null;
    }

}
