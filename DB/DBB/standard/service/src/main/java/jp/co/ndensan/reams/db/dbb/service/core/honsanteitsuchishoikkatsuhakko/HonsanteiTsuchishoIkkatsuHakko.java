/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.PrtTokuchoKaishiTsuchishoHonsanteiResult;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuProperty.OutputOrderEnum;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranProperty.NonyuOutputOrderEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiProperty.BreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoHoniOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.DecideKetteiHenkoTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.PrtNonyuTsuchishoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2014TsuchishoUchiwakeJokenDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.TokubetsuChoshuKaishi.TokubetsuChoshuKaishiPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kaigohokenryogaku.KaigoHokenryogakuPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定通知書一括発行（バッチ）クラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
public class HonsanteiTsuchishoIkkatsuHakko extends HonsanteiTsuchishoIkkatsuHakkoFath {

    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
    private static final RString キー_最新調定日時 = new RString("最新調定日時");
    private static final RString キー_調定年度 = new RString("調定年度");
    private static final RString キー_出力対象 = new RString("出力対象");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString キー_決定変更区分 = new RString("決定変更区分");
    private static final RString 定値_決定区分 = new RString("1");
    private static final RString 定値_変更区分 = new RString("2");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final int INT_15 = 15;
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSVファイル名_なし = new RString("なし");
    private static final RString CSVファイル名_一覧表 = new RString("特別徴収開始通知書発行一覧表");
    private static final RString CSVファイル名_決定一覧表 = new RString("介護保険料額決定通知書発行一覧表");
    private static final RString CSVファイル名_変更一覧表 = new RString("介護保険料額変更知書発行一覧表");
    private static final RString CSVファイル名_納入一覧表 = new RString("保険料納入通知書（本算定）発行一覧表");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_賦課年度 = new RString("賦課年度");
    private static final RString 定数_調定年度 = new RString("調定年度");
    private static final RString 定数_出力対象 = new RString("出力対象");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_文書番号 = new RString("文書番号");
    private static final RString 定数_出力期 = new RString("出力期");
    private static final RString 定数_対象者 = new RString("対象者");
    private static final RString 定数_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString 定数_ページごとに山分け = new RString("ページごとに山分け");
    private static final RString 定数_特徴期別金額 = new RString("get特徴期別金額");
    private static final RString 定数_普徴期別金額 = new RString("get普徴期別金額");
    private static final RString 定数_選択現金口座 = new RString("getSelectGenkinKoza");
    private static final RString 定数_選択通知書 = new RString("getSelectTsuchisho");
    private static final RString 定数_出力順グループ名 = new RString("getSortGroupName");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString SIGN = new RString(" ＞ ");
    private static final EucEntityId 決定_EUC_ENTITY_ID = new EucEntityId("DBB200012");
    private static final EucEntityId 変更_EUC_ENTITY_ID = new EucEntityId("DBB200028");
    private static final EucEntityId 納入_EUC_ENTITY_ID = new EucEntityId("DBB200010");
    private static final RString 決定_EUCファイル名 = new RString("KaigoHokenryogakuKetteiTsuchiHakkoIchiranData.csv");
    private static final RString 変更_EUCファイル名 = new RString("KaigoHokenryogakuHenkoTsuchiHakkoIchiranData.csv");
    private static final RString 納入_EUCファイル名 = new RString("NonyuTsuchishoHonsanteiHakkoIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定値_タイトル = new RString("介護保険料額変更通知書発行一覧表");
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString 対象者_全て = new RString("2");
    private static final RString 対象者_口座 = new RString("1");
    private static final RString 対象者_現金 = new RString("0");
    private static final RString 口座区分_現金納付 = new RString("0");
    private static final RString 口座区分_口座振替 = new RString("1");
    private static final RString 定値_特別徴収停止事由コード = new RString("T2");
    private static final RString 帳票タイプ_期毎 = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振型5 = new RString("銀振型5期タイプ");
    private static final RString 帳票タイプ_銀振型4 = new RString("銀振型4期タイプ");
    private static final RString 帳票タイプ_ブック = new RString("ブックタイプ");
    private static final RString 帳票タイプ_コンビニ = new RString("コンビニ収納タイプ");
    private static final RString 項目名出力期_中期 = new RString("当初出力_中期開始期");
    private static final RString 項目名出力期_後期 = new RString("当初出力_後期開始期");
    private static final RString 別々に出力 = new RString("0");
    private static final RString 全件出力 = new RString("1");
    private static final RString キー_処理対象 = new RString("処理対象");
    private static final RString キー_通知書プリント条件 = new RString("通知書プリント条件");
    private static final RString ソート = new RString("order by");
    private static final RString 定値_生活保護区分 = new RString("生活保護区分");
    private static final RString ソート順_降順 = new RString("DESC");
    private static final RString ソート順_昇順 = new RString("ASC");
    private static final RString 口座区分 = new RString("dbT2015KeisangoJoho_kozaKubun");
    private static final RString 定値_出力順グループ指定 = new RString("出力順グループ指定");
    private static final RString FORMAT = new RString("\"");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");
    private static final FlexibleYear 定値_管理年度 = new FlexibleYear("0000");
    private static final RString 定値_項目名 = new RString("宛名連番印字");
    private static final RString 定値_宛名連番 = new RString("*000001#");
    private static final RString 定値_印字する = new RString("1");
    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private final DbT2014TsuchishoUchiwakeJokenDac 通知書打ち分け条件Dac;

    /**
     * コンストラクタです。
     */
    public HonsanteiTsuchishoIkkatsuHakko() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        this.通知書打ち分け条件Dac = InstanceProvider.create(DbT2014TsuchishoUchiwakeJokenDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HonsanteiTsuchishoIkkatsuHakko}のインスタンスを返します。
     *
     * @return HonsanteiTsuchishoIkkatsuHakko
     */
    public static HonsanteiTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(HonsanteiTsuchishoIkkatsuHakko.class);
    }

    /**
     * 賦課情報の取得するメソッドです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 一括発行起動フラグ 一括発行起動フラグ
     */
    public void getFukaJoho(FlexibleYear 調定年度, FlexibleYear 賦課年度, boolean 一括発行起動フラグ) {

        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        mapper.clear本算定通知書一時();
        YMDHMS 最新調定日時 = get最新調定日時(調定年度);
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        IKozaSearchKey kozaSearchKey = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
                if (i != list.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        HonsanteiTsuchishoIkkatsuHakkoParameter parameter = HonsanteiTsuchishoIkkatsuHakkoParameter
                .createSelectByKeyParam(調定年度, 賦課年度, 処理日, kozaSearchKey, list, 科目コード, 最新調定日時);
        if (!一括発行起動フラグ) {
            mapper.insert本算定通知書一時(parameter);
            mapper.update本算定通知書一時_計算後情報更正前();
        } else {
            mapper.insert本算定通知書一時_一時(parameter);
            mapper.update本算定通知書一時_計算後情報更正前_一時();
        }
        Map<String, Object> para = new HashMap<>();
        para.put(キー_最新調定日時.toString(), 最新調定日時);
        para.put(キー_調定年度.toString(), 調定年度.minusYear(INT_1));
        mapper.update本算定通知書一時_対象者仮徴収更正前(para);
        para.put(キー_調定年度.toString(), 調定年度);
        mapper.update本算定通知書一時_対象者本徴収更正前(para);
        mapper.update本算定通知書一時_生活保護区分();
    }

    /**
     * 最新調定日時を取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @return YMDHMS 最新調定日時
     */
    public YMDHMS get最新調定日時(FlexibleYear 調定年度) {

        DbT7022ShoriDateKanriEntity dbt7022entity = 処理日付管理Dac.select最新調定日時(調定年度);
        if (dbt7022entity == null) {
            return null;
        }
        return dbt7022entity.getKijunTimestamp();
    }

    /**
     * 特徴開始通知書(本算定）の発行メソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 発行日 RDate
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 出力対象 RString
     * @return PrtTokuchoKaishiTsuchishoHonsanteiResult 特徴開始通知書(本算定）の発行用引数
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public PrtTokuchoKaishiTsuchishoHonsanteiResult prtTokuchoKaishiTsuchishoHonsantei(FlexibleYear 調定年度,
            RDate 発行日, RDateTime 帳票作成日時, RString 出力順ID, ReportId 帳票ID, RString 出力対象) throws InvocationTargetException {

        RString 出力順 = get出力順(特別徴収開始通知書本算定_帳票分類ID, 出力順ID);

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(調定年度.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_調定年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(調定年度.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力対象).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力対象) ? RString.EMPTY : TokuchoKaishiTsuhishoHoniOutputJoken.toValue(出力対象).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書本算定_帳票分類ID, Long.parseLong(出力順ID.toString()));
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
        getFukaJoho(調定年度, 調定年度, true);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力対象.toString(), 出力対象);
        parameter.put(キー_出力順.toString(), 出力順);
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select本算定通知書(parameter);
        RString 帳票名 = get帳票名_特徴(帳票ID.getColumnValue());
        if (entityList == null || entityList.isEmpty() || entityList.get(INT_0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_ゼロ, CSV出力有無_なし, CSVファイル名, 帳票名);
            return null;
        }
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(特別徴収開始通知書本算定_帳票分類ID);
        int 定型文文字サイズ = 0;
        if (帳票制御共通 != null && !RString.isNullOrEmpty(帳票制御共通.get定型文文字サイズ())) {
            定型文文字サイズ = Integer.parseInt(帳票制御共通.get定型文文字サイズ().toString());
        }
        RString 通知書定型文 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課,
                特別徴収開始通知書本算定_帳票分類ID, KamokuCode.EMPTY, 定型文文字サイズ, INT_1, FlexibleDate.getNowDate());
        RString 宛名連番 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御 = load帳票制御汎用ByKey(特別徴収開始通知書本算定_帳票分類ID, 定値_管理年度, 定値_項目名);
        if (帳票制御 != null && 定値_印字する.equals(帳票制御.get設定値())) {
            宛名連番 = 定値_宛名連番;
        }
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList);
        PrtTokuchoKaishiTsuchishoHonsanteiResult result = new PrtTokuchoKaishiTsuchishoHonsanteiResult();
        result.set特徴開始通知書ResultList(tmpResultList);
        result.set調定年度(調定年度);
        result.set発行日(発行日);
        result.set帳票作成日時(帳票作成日時);
        result.set出力順ID(出力順ID);
        result.set出力条件リスト(出力条件リスト);
        result.set帳票ID(帳票ID);
        result.set帳票名(帳票名);
        result.set宛名連番(宛名連番);
        result.set通知書定型文(通知書定型文);
        result.set帳票制御共通(帳票制御共通);
        return result;
    }

    /**
     * 特徴開始通知書(本算定）の発行メソッドです。
     *
     * @param result PrtTokuchoKaishiTsuchishoHonsanteiResult
     * @param 編集後本算定通知書共通情報List List<EditedHonSanteiTsuchiShoKyotsu>
     * @param 総ページ数 int
     */
    public void publishTokuchoKaishiTsuchishoHonsantei(PrtTokuchoKaishiTsuchishoHonsanteiResult result,
            List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List, int 総ページ数) {

        publish特別徴収開始通知書発行一覧表(result.get調定年度(), result.get帳票作成日時(), 編集後本算定通知書共通情報List);
        new TokubetsuChoshuKaishiPrintService().printSingle(編集後本算定通知書共通情報List,
                result.get調定年度(), result.get出力順ID(), result.get帳票作成日時());
        loadバッチ出力条件リスト(result.get出力条件リスト(), result.get帳票ID(), new RString(総ページ数),
                CSV出力有無_あり, CSVファイル名_一覧表, result.get帳票名());
    }

    /**
     * 特徴開始通知書発行後異動者登録するメソッドです。
     *
     * @param 出力対象区分 RString
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdoshaTokuchoKaishi(RString 出力対象区分, YMDHMS 帳票作成日時,
            RString 出力順ID, ReportId 帳票ID) {

        RString 出力順 = get出力順(特別徴収開始通知書本算定_帳票分類ID, 出力順ID);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力対象.toString(), 出力対象区分);
        parameter.put(キー_出力順.toString(), 出力順);
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select本算定通知書(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 決定変更通知書出力判定するメソッドです。
     *
     * @param 打分け条件 RString
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void decideKetteiHenkoTsuchisho(RString 打分け条件) throws InvocationTargetException {

        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select本算定通知書all();
        if (entityList == null || entityList.isEmpty() || entityList.get(INT_0).get計算後情報_更正後() == null) {
            return;
        }
        DbT2014TsuchishoUchiwakeJokenEntity 通知書打ち分け条件情報 = 通知書打ち分け条件Dac.select通知書打ち分け条件情報(打分け条件);
        if (通知書打ち分け条件情報 == null) {
            return;
        }
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 仮算定期間 = 期月リスト_普徴.filtered仮算定期間();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        int 仮算定最終期 = 仮算定期間.getLast().get期AsInt();
        List<Kitsuki> 仮算定期間List = 仮算定期間.toList();
        int 仮算定最初期 = 仮算定期間List.get(仮算定期間List.size() - INT_1).get期AsInt();
        int 本算定最終期 = 本算定期間.getLast().get期AsInt();
        List<Kitsuki> 本算定期間List = 本算定期間.toList();
        int 本算定最初期 = 本算定期間List.get(本算定期間List.size() - INT_1).get期AsInt();
        for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
            int 選択通知書No = get選択通知書No(仮算定最初期, 仮算定最終期, 本算定最初期, 本算定最終期, tmpResult);
            if (選択通知書No == 0) {
                continue;
            }
            FukaJoho 賦課の情報_更正後 = tmpResult.get賦課の情報_更正後().get賦課情報();
            DbT2015KeisangoJohoEntity 計算後情報_更正後 = tmpResult.get計算後情報_更正後();
            RString 選択現金口座 = get選択現金口座(通知書打ち分け条件情報, 選択通知書No);
            if (対象者_全て.equals(選択現金口座)
                    || (対象者_口座.equals(選択現金口座) && 口座区分_口座振替.equals(賦課の情報_更正後.get口座区分()))
                    || (対象者_現金.equals(選択現金口座) && 口座区分_現金納付.equals(賦課の情報_更正後.get口座区分()))) {
                RString 選択通知書 = get選択通知書(通知書打ち分け条件情報, 選択通知書No);
                RString 出力順グループ名 = get出力順グループ名(通知書打ち分け条件情報, 選択通知書No);
                DecideKetteiHenkoTsuchishoParameter parameter
                        = DecideKetteiHenkoTsuchishoParameter.createSelectByKeyParam(計算後情報_更正後.getChoteiNendo(),
                                計算後情報_更正後.getFukaNendo(), 計算後情報_更正後.getTsuchishoNo(),
                                計算後情報_更正後.getKoseiZengoKubun(), 計算後情報_更正後.getSakuseiShoriName(), 選択通知書, 出力順グループ名);
                mapper.update本算定通知書一時(parameter);
            }
        }
    }

    /**
     * 決定通知書の発行するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 一括発行起動フラグ boolean
     * @param 打分け条件 RString
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void prtKetteiTsuchisho(FlexibleYear 調定年度, RDate 発行日, RString 文書番号, RDateTime 帳票作成日時,
            RString 出力順ID, ReportId 帳票ID, boolean 一括発行起動フラグ, RString 打分け条件) throws InvocationTargetException {

        RString 出力順 = get出力順(決定変更通知書_帳票分類ID, 出力順ID);

        HonsanteiTsuchishoInfo 通知書共通情報entity = get通知書共通情報(調定年度, null);
        getFukaJoho(調定年度, 調定年度, 一括発行起動フラグ);
        decideKetteiHenkoTsuchisho(打分け条件);

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_文書番号).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(文書番号) ? RString.EMPTY : 文書番号));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 決定変更通知書_帳票分類ID, Long.parseLong(出力順ID.toString()));
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

        RStringBuilder orderByClause = new RStringBuilder(ソート);
        orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_出力順グループ指定).concat(FORMAT)
                .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_決定変更区分.toString(), 定値_決定区分);
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select決定変更通知書(parameter);
        RString 帳票名 = get帳票名_決定(帳票ID.getColumnValue());
        if (entityList == null || entityList.isEmpty() || entityList.get(INT_0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_ゼロ, CSV出力有無_なし, CSVファイル名, 帳票名);
            return;
        }
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(決定変更通知書_帳票分類ID);
        int 定型文文字サイズ = 0;
        if (帳票制御共通 != null && !RString.isNullOrEmpty(帳票制御共通.get定型文文字サイズ())) {
            定型文文字サイズ = Integer.parseInt(帳票制御共通.get定型文文字サイズ().toString());
        }
        RString 通知書定型文 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課,
                特別徴収開始通知書本算定_帳票分類ID, KamokuCode.EMPTY, 定型文文字サイズ, INT_1, FlexibleDate.getNowDate());
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList);
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List = new ArrayList<>();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        SourceDataCollection sourceDataCollection;
        try (ReportManager reportManager = new ReportManager()) {
            for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
                HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
                本算定通知書情報.set発行日(発行日);
                本算定通知書情報.set帳票分類ID(決定変更通知書_帳票分類ID);
                本算定通知書情報.set帳票ID(帳票ID);
                本算定通知書情報.set処理区分(ShoriKubun.バッチ);
                本算定通知書情報.set地方公共団体(地方公共団体);
                本算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
                本算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
                本算定通知書情報.set納組情報(tmpResult.get納組情報());
                本算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
                本算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
                本算定通知書情報.set宛先情報(tmpResult.get宛先情報());
                本算定通知書情報.set口座情報(tmpResult.get口座情報());
                本算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
                本算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
                本算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
                本算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
                本算定通知書情報.set収入情報(tmpResult.get収入情報());
                本算定通知書情報.set帳票制御共通(帳票制御共通);
                EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);
                HonSanteiKetteiTsuchiShoJoho 本算定決定通知書情報 = new HonSanteiKetteiTsuchiShoJoho();
                本算定決定通知書情報.set現年度_過年度区分(GennenKanen.現年度);
                本算定決定通知書情報.set発行日(発行日);
                本算定決定通知書情報.set帳票分類ID(決定変更通知書_帳票分類ID);
                本算定決定通知書情報.set帳票ID(帳票ID);
                本算定決定通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
                本算定決定通知書情報.set宛先情報(tmpResult.get宛先情報());
                本算定決定通知書情報.set処理区分(ShoriKubun.バッチ);
                本算定決定通知書情報.set地方公共団体(地方公共団体);

                List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities = new ArrayList<>();
                KaigoHokenHokenryogakuKetteiTsuchishoJoho 介護保険料額決定通知書 = new KaigoHokenHokenryogakuKetteiTsuchishoJoho();
                介護保険料額決定通知書.set文書番号(文書番号);
                介護保険料額決定通知書.set本算定決定通知書情報(本算定決定通知書情報);
                介護保険料額決定通知書.set通知書定型文(通知書定型文);
                entities.add(介護保険料額決定通知書);
                if (ReportIdDBB.DBB100039.getReportId().equals(帳票ID)) {
                    new KaigoHokenHokenryogakuKetteiTsuchishoPrintService().printB5Yoko(entities, reportManager);
                } else if (ReportIdDBB.DBB100040.getReportId().equals(帳票ID)) {
                    new KaigoHokenHokenryogakuKetteiTsuchishoPrintService().printA4Tate(entities, reportManager);
                }
                編集後本算定通知書共通情報List.add(編集後本算定通知書共通情報);
            }
            sourceDataCollection = reportManager.publish();
        }
        publish決定変更通知書発行一覧表(帳票作成日時, 編集後本算定通知書共通情報List, 決定_EUC_ENTITY_ID, 決定_EUCファイル名);
        new KaigoHokenryogakuPrintService().printSingle(編集後本算定通知書共通情報List, 帳票作成日時, 出力順ID, 定値_タイトル);
        RString 出力ページ数 = !sourceDataCollection.iterator().hasNext()
                ? 定値区分_0 : new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, CSVファイル名_決定一覧表, 帳票名);
    }

    /**
     * 決定通知書発行後異動者登録するメソッドです。
     *
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdoshaKettei(YMDHMS 帳票作成日時, RString 出力順ID, ReportId 帳票ID) {

        RString 出力順 = get出力順(決定変更通知書_帳票分類ID, 出力順ID);
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_出力順グループ指定).concat(FORMAT)
                .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_決定変更区分.toString(), 定値_決定区分);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select決定変更通知書(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 変更通知書の発行するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 一括発行起動フラグ boolean
     * @param 打分け条件 RString
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void prtHenkoTsuchisho(FlexibleYear 調定年度, RDate 発行日, RString 文書番号, RDateTime 帳票作成日時,
            RString 出力順ID, ReportId 帳票ID, boolean 一括発行起動フラグ, RString 打分け条件) throws InvocationTargetException {

        RString 出力順 = get出力順(決定変更通知書_帳票分類ID, 出力順ID);

        HonsanteiTsuchishoInfo 通知書共通情報entity = get通知書共通情報(調定年度, null);
        getFukaJoho(調定年度, 調定年度, 一括発行起動フラグ);
        decideKetteiHenkoTsuchisho(打分け条件);

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_文書番号).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(文書番号) ? RString.EMPTY : 文書番号));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 決定変更通知書_帳票分類ID, Long.parseLong(出力順ID.toString()));
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
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_出力順グループ指定).concat(FORMAT)
                .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_決定変更区分.toString(), 定値_変更区分);
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select決定変更通知書(parameter);
        RString 帳票名 = get帳票名_変更(帳票ID.getColumnValue());
        if (entityList == null || entityList.isEmpty() || entityList.get(INT_0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_ゼロ, CSV出力有無_なし, CSVファイル名, 帳票名);
            return;
        }
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(決定変更通知書_帳票分類ID);
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList);
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List = new ArrayList<>();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        SourceDataCollection sourceDataCollection;
        try (ReportManager reportManager = new ReportManager()) {
            for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
                HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
                本算定通知書情報.set発行日(発行日);
                本算定通知書情報.set帳票分類ID(決定変更通知書_帳票分類ID);
                本算定通知書情報.set帳票ID(帳票ID);
                本算定通知書情報.set処理区分(ShoriKubun.バッチ);
                本算定通知書情報.set地方公共団体(地方公共団体);
                本算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
                本算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
                本算定通知書情報.set納組情報(tmpResult.get納組情報());
                本算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
                本算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
                本算定通知書情報.set宛先情報(tmpResult.get宛先情報());
                本算定通知書情報.set口座情報(tmpResult.get口座情報());
                本算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
                本算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
                本算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
                本算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
                本算定通知書情報.set収入情報(tmpResult.get収入情報());
                本算定通知書情報.set帳票制御共通(帳票制御共通);
                EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定共通情報作成.create本算定通知書共通情報(本算定通知書情報);
                HonSanteiKetteiTsuchiShoJoho 本算定変更通知書情報 = new HonSanteiKetteiTsuchiShoJoho();
                本算定変更通知書情報.set現年度_過年度区分(GennenKanen.現年度);
                本算定変更通知書情報.set発行日(発行日);
                本算定変更通知書情報.set帳票分類ID(決定変更通知書_帳票分類ID);
                本算定変更通知書情報.set帳票ID(帳票ID);
                本算定変更通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
                本算定変更通知書情報.set宛先情報(tmpResult.get宛先情報());
                本算定変更通知書情報.set処理区分(ShoriKubun.バッチ);
                本算定変更通知書情報.set地方公共団体(地方公共団体);

                List<KaigoHokenryogakuHenkoKenChushiTsuchishoJoho> entities = new ArrayList<>();
                KaigoHokenryogakuHenkoKenChushiTsuchishoJoho 通知書情報 = new KaigoHokenryogakuHenkoKenChushiTsuchishoJoho();
                通知書情報.set文書番号(文書番号);
                通知書情報.set本算定決定通知書情報(本算定変更通知書情報);
                entities.add(通知書情報);
                if (ReportIdDBB.DBB100042.getReportId().equals(帳票ID)) {
                    new KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService().printB5Yoko(entities, reportManager);
                } else {
                    new KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService().printA4Tate(entities, reportManager);

                }
                編集後本算定通知書共通情報List.add(編集後本算定通知書共通情報);
            }
            sourceDataCollection = reportManager.publish();
        }
        publish決定変更通知書発行一覧表(帳票作成日時, 編集後本算定通知書共通情報List, 変更_EUC_ENTITY_ID, 変更_EUCファイル名);
        new KaigoHokenryogakuPrintService().printSingle(編集後本算定通知書共通情報List, 帳票作成日時, 出力順ID, 定値_タイトル);
        RString 出力ページ数 = !sourceDataCollection.iterator().hasNext()
                ? 定値区分_0 : new RString(sourceDataCollection.iterator().next().getPageCount());
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, CSVファイル名_変更一覧表, 帳票名);
    }

    /**
     * 変更通知書発行後異動者登録するメソッドです。
     *
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdoshaHenko(YMDHMS 帳票作成日時, RString 出力順ID, ReportId 帳票ID) {

        RString 出力順 = get出力順(決定変更通知書_帳票分類ID, 出力順ID);
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_出力順グループ指定).concat(FORMAT)
                .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_決定変更区分.toString(), 定値_変更区分);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select決定変更通知書(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 納入通知書の発行するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 帳票作成日時 RDateTime
     * @param 発行日 RDate
     * @param 別々に出力区分 RString
     * @param 出力期 RString
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 山分け区分 RString
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 一括発行起動フラグ boolean
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void prtNonyuTsuchisho(FlexibleYear 調定年度, FlexibleYear 賦課年度, RDateTime 帳票作成日時,
            RDate 発行日, RString 別々に出力区分, RString 出力期, RString 納入通知書対象者, RString 生活保護者先頭出力区分,
            RString 山分け区分, RString 出力順ID, ReportId 帳票ID, boolean 一括発行起動フラグ) throws InvocationTargetException {

        RString 帳票タイプ = get帳票タイプ(帳票ID);
        RString 出力順 = get出力順(納入通知書_帳票分類ID, 出力順ID);

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        int 出力期AsInt = Integer.parseInt(出力期.toString());
        List<NokiJoho> 期月List = get期月リスト(調定年度, 別々に出力区分, 帳票タイプ, 期月リスト_普徴, 本算定期間, 出力期AsInt);
        HonsanteiTsuchishoInfo 通知書共通情報entity = get通知書共通情報(調定年度, 出力期);
        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度);
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = finder.get本算定納入通知書制御情報();
        getFukaJoho(調定年度, 調定年度, 一括発行起動フラグ);
        RString 計算後情報_口座区分 = null;
        if (NotsuKozaShutsuryokuTaisho.全て.getコード().equals(納入通知書対象者)) {
            計算後情報_口座区分 = null;
        } else if (NotsuKozaShutsuryokuTaisho.現金納付者.getコード().equals(納入通知書対象者)) {
            計算後情報_口座区分 = KozaKubun.現金納付.getコード();
        } else if (NotsuKozaShutsuryokuTaisho.口座振替者.getコード().equals(納入通知書対象者)) {
            計算後情報_口座区分 = KozaKubun.口座振替.getコード();
        }
        Map<String, RString> 普徴期情報 = get普徴期情報(出力期);

        RStringBuilder orderByClause = new RStringBuilder(ソート);
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_生活保護区分).concat(FORMAT).concat(RString.HALF_SPACE)
                    .concat(ソート順_降順).concat(カンマ)
                    .concat(RString.HALF_SPACE).concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        }
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();

        List<RString> 出力条件リスト = get出力条件リスト(発行日, 出力期, 納入通知書対象者, 生活保護者先頭出力区分, 山分け区分);

        PrtNonyuTsuchishoParameter parameter = PrtNonyuTsuchishoParameter.createSelectByKeyParam(出力期AsInt, 計算後情報_口座区分,
                普徴期情報.get(キー_処理対象.toString()), 普徴期情報.get(キー_通知書プリント条件.toString()), 出力順);
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select納入通知書(parameter);
        RString 帳票名 = get帳票名_納入(帳票ID.getColumnValue());
        if (entityList == null || entityList.isEmpty() || entityList.get(INT_0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値_ゼロ, CSV出力有無_なし, CSVファイル名_なし, 帳票名);
            return;
        }

        //TO QA913
        int 山分け用スプール数 = get山分け用スプール数(帳票タイプ, 期月List, 本算定期間, 出力期AsInt, 山分け区分);
        checkStyle(山分け用スプール数);
        if (定値区分_1.equals(山分け区分)) {
            通知書共通情報entity.set普徴納期情報リスト(期月List);
        }

        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(納入通知書_帳票分類ID);
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList);
        NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List = new ArrayList<>();
        SourceDataCollection sourceDataCollection;
        try (ReportManager reportManager = new ReportManager()) {
            for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
                HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
                本算定通知書情報.set発行日(発行日);
                本算定通知書情報.set帳票分類ID(納入通知書_帳票分類ID);
                本算定通知書情報.set帳票ID(帳票ID);
                本算定通知書情報.set処理区分(ShoriKubun.バッチ);
                本算定通知書情報.set地方公共団体(地方公共団体);
                本算定通知書情報.set賦課の情報_更正前(tmpResult.get賦課の情報_更正前());
                本算定通知書情報.set賦課の情報_更正後(tmpResult.get賦課の情報_更正後());
                本算定通知書情報.set納組情報(tmpResult.get納組情報());
                本算定通知書情報.set普徴納期情報リスト(通知書共通情報entity.get普徴納期情報リスト());
                本算定通知書情報.set特徴納期情報リスト(通知書共通情報entity.get特徴納期情報リスト());
                本算定通知書情報.set宛先情報(tmpResult.get宛先情報());
                本算定通知書情報.set口座情報(tmpResult.get口座情報());
                本算定通知書情報.set徴収方法情報_更正前(tmpResult.get徴収方法情報_更正前());
                本算定通知書情報.set徴収方法情報_更正後(tmpResult.get徴収方法情報_更正後());
                本算定通知書情報.set対象者_追加含む_情報_更正前(tmpResult.get対象者_追加含む_情報_更正前());
                本算定通知書情報.set対象者_追加含む_情報_更正後(tmpResult.get対象者_追加含む_情報_更正後());
                本算定通知書情報.set収入情報(tmpResult.get収入情報());
                本算定通知書情報.set帳票制御共通(帳票制御共通);
                List<Kitsuki> 出力期リスト = get出力期リスト(出力期);
                IName 代納人氏名 = tmpResult.get宛先代納() != null ? tmpResult.get宛先代納().get宛先名称() : null;
                HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報
                        = nonyuTsuchiShoJohoFactory.create本算定納入通知書情報(本算定通知書情報, 本算定納入通知書制御情報, 出力期リスト, 代納人氏名);
                //TO QA913
                //publish納入通知書本算定(帳票ID, 編集後本算定通知書共通情報, reportManager);
                編集後本算定通知書共通情報List.add(編集後本算定通知書共通情報.get編集後本算定通知書共通情報());
            }
            sourceDataCollection = reportManager.publish();
        }
        publish納入通知書発行一覧表(帳票作成日時, 賦課年度, 出力期, 編集後本算定通知書共通情報List, 納入_EUC_ENTITY_ID, 納入_EUCファイル名);
        new NonyuTsuchIchiranPrintService().printSingle(編集後本算定通知書共通情報List, 帳票作成日時, 出力期AsInt, 出力順ID);
        RString 出力ページ数 = !sourceDataCollection.iterator().hasNext()
                ? 定値区分_0 : new RString(sourceDataCollection.iterator().next().getPageCount());
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 納入通知書_帳票分類ID, Long.parseLong(出力順ID.toString()));
        }
        load代行プリント送付票(調定年度, 賦課年度, 代行プリント送付票_帳票ID, 発行日, 出力期, 納入通知書対象者, 生活保護者先頭出力区分, 山分け区分,
                帳票制御共通 == null ? null : 帳票制御共通.toEntity(), 地方公共団体, outputOrder, new Decimal(出力ページ数.toString()));
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, CSVファイル名_納入一覧表, 帳票名);
    }

    /**
     * 納入通知書発行後異動者登録するメソッドです。
     *
     * @param 帳票作成日時 RDateTime
     * @param 出力期 RString
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdoshaNonyu(YMDHMS 帳票作成日時, RString 出力期, RString 納入通知書対象者,
            RString 生活保護者先頭出力区分, RString 出力順ID, ReportId 帳票ID) {

        RString 出力順 = get出力順(納入通知書_帳票分類ID, 出力順ID);
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_生活保護区分).concat(FORMAT).concat(RString.HALF_SPACE)
                    .concat(ソート順_降順).concat(カンマ)
                    .concat(RString.HALF_SPACE).concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        }
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();

        int 出力期AsInt = Integer.parseInt(出力期.toString());
        RString 計算後情報_口座区分 = null;
        if (NotsuKozaShutsuryokuTaisho.全て.getコード().equals(納入通知書対象者)) {
            計算後情報_口座区分 = null;
        } else if (NotsuKozaShutsuryokuTaisho.現金納付者.getコード().equals(納入通知書対象者)) {
            計算後情報_口座区分 = KozaKubun.現金納付.getコード();
        } else if (NotsuKozaShutsuryokuTaisho.口座振替者.getコード().equals(納入通知書対象者)) {
            計算後情報_口座区分 = KozaKubun.口座振替.getコード();
        }
        Map<String, RString> 普徴期情報 = get普徴期情報(出力期);
        IHonsanteiTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);
        PrtNonyuTsuchishoParameter parameter = PrtNonyuTsuchishoParameter.createSelectByKeyParam(出力期AsInt, 計算後情報_口座区分,
                普徴期情報.get(キー_処理対象.toString()), 普徴期情報.get(キー_通知書プリント条件.toString()), 出力順);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select納入通知書(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 出力期リストを取得メソッドです。
     *
     * @param 出力期 RString
     * @return 出力期リスト List<Kitsuki>
     */
    public List<Kitsuki> get出力期リスト(RString 出力期) {

        List<Kitsuki> 出力期リスト = new ArrayList<>();
        KitsukiList 期月リスト = new FuchoKiUtil().get期月リスト().filtered本算定期間();
        for (Kitsuki 期月 : 期月リスト.toList()) {
            if (出力期.equals(期月.get期())) {
                出力期リスト.add(期月);
                break;
            }
        }
        return 出力期リスト;
    }

    private RString get帳票タイプ(ReportId 帳票ID) {

        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100045.getReportId().equals(帳票ID) || ReportIdDBB.DBB100046.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100063.getReportId().equals(帳票ID) || ReportIdDBB.DBB100064.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎;
        } else if (ReportIdDBB.DBB100053.getReportId().equals(帳票ID) || ReportIdDBB.DBB100054.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型5;
        } else if (ReportIdDBB.DBB100051.getReportId().equals(帳票ID) || ReportIdDBB.DBB100052.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型4;
        } else if (ReportIdDBB.DBB100055.getReportId().equals(帳票ID) || ReportIdDBB.DBB100056.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100057.getReportId().equals(帳票ID) || ReportIdDBB.DBB100058.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブック;
        } else if (ReportIdDBB.DBB100059.getReportId().equals(帳票ID) || ReportIdDBB.DBB100060.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100061.getReportId().equals(帳票ID) || ReportIdDBB.DBB100062.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_コンビニ;
        }
        return 帳票タイプ;
    }

    private List<RString> get出力条件リスト(RDate 発行日, RString 出力期, RString 納入通知書対象者, RString 生活保護者先頭出力区分,
            RString 山分け区分) {

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力期).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(RString.isNullOrEmpty(出力期) ? RString.EMPTY : 出力期));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_対象者).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(NotsuKozaShutsuryokuTaisho.toValue(納入通知書対象者).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(山分け区分)) {
            builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
        } else if (定値区分_1.equals(山分け区分)) {
            builder.append(FORMAT_LEFT.concat(定数_ページごとに山分け).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        }
        出力条件リスト.add(builder.toRString());

        return 出力条件リスト;
    }

    private List<NokiJoho> get期月リスト(FlexibleYear 調定年度, RString 別々に出力区分, RString 帳票タイプ,
            KitsukiList 期月リスト_普徴, KitsukiList 本算定期間, int 出力期AsInt) {

        ChohyoSeigyoHanyo 当初出力_中期開始期 = load帳票制御汎用ByKey(納入通知書_帳票分類ID, 調定年度, 項目名出力期_中期);
        ChohyoSeigyoHanyo 当初出力_後期開始期 = load帳票制御汎用ByKey(納入通知書_帳票分類ID, 調定年度, 項目名出力期_後期);
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        int 最終期 = INT_0;
        if (帳票タイプ_期毎.equals(帳票タイプ)) {
            if (別々に出力.equals(別々に出力区分)) {
                最終期 = 出力期AsInt;
            } else if (全件出力.equals(別々に出力区分)) {
                最終期 = 本算定期間.getLast().get期AsInt();
            }
        } else {
            if (別々に出力.equals(別々に出力区分) && 当初出力_中期開始期 != null && !RString.isNullOrEmpty(当初出力_中期開始期.get設定値())
                    && 当初出力_後期開始期 != null && !RString.isNullOrEmpty(当初出力_後期開始期.get設定値())) {
                if (出力期AsInt < Integer.parseInt(当初出力_中期開始期.get設定値().toString())) {
                    最終期 = Integer.parseInt(当初出力_中期開始期.get設定値().toString()) - INT_1;
                } else if (Integer.parseInt(当初出力_後期開始期.get設定値().toString()) <= 出力期AsInt) {
                    最終期 = 本算定期間.getLast().get期AsInt();
                } else {
                    最終期 = Integer.parseInt(当初出力_後期開始期.get設定値().toString()) - INT_1;
                }
            } else {
                最終期 = 本算定期間.getLast().get期AsInt();
            }
        }
        KitsukiList 期月リスト = 期月リスト_普徴.subListBy期(出力期AsInt, 最終期);
        List<Kitsuki> 期月List = 期月リスト.toList();
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月List) {
            NokiJoho 普徴納期情報 = new NokiJoho();
            普徴納期情報.set期月(期月);
            普徴納期情報.set納期(get納期By期月(期月, 普徴納期List));
            普徴納期情報リスト.add(普徴納期情報);
        }
        return 普徴納期情報リスト;
    }

    private Noki get納期By期月(Kitsuki 期月, List<Noki> 賦課納期) {
        if (null == 賦課納期 || null == 期月) {
            return null;
        }
        for (Noki 納期 : 賦課納期) {
            if (期月.get期AsInt() == 納期.get期別()) {
                return 納期;
            }
        }
        return null;
    }

    private int get山分け用スプール数(RString 帳票タイプ, List<NokiJoho> 期月List, KitsukiList 本算定期間,
            int 出力期AsInt, RString 山分け区分) {

        int 山分け用スプール数 = 0;
        if (定値区分_0.equals(山分け区分)) {
            if (帳票タイプ_期毎.equals(帳票タイプ)) {
                山分け用スプール数 = 期月List.isEmpty() ? 0 : 期月List.size();
            } else if (帳票タイプ_銀振型5.equals(帳票タイプ) || 帳票タイプ_銀振型4.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_銀振型(期月List, 本算定期間);
            } else if (帳票タイプ_ブック.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_ブック(出力期AsInt, 期月List);
            } else if (帳票タイプ_コンビニ.equals(帳票タイプ)) {
                山分け用スプール数 = get山分け用スプール数_コンビニ(出力期AsInt, 期月List);
            }
        } else if (定値区分_1.equals(山分け区分)) {
            山分け用スプール数 = INT_1;
        }
        return 山分け用スプール数;
    }

    private int get山分け用スプール数_銀振型(List<NokiJoho> 期月List, KitsukiList 本算定期間) {
        int 山分け用スプール数 = 0;
        List<Kitsuki> 銀振計算期月リスト = 本算定期間.toList();
        int 最初の月 = 銀振計算期月リスト.get(銀振計算期月リスト.size() - INT_1).get月AsInt();
        RString 印字位置 = get印字位置(最初の月);
        boolean is昇順 = false;
        if (定値区分_1.equals(印字位置)) {
            is昇順 = true;
        } else if (INT_1 < Integer.parseInt(印字位置.toString())) {
            is昇順 = false;
        }
        for (NokiJoho 期月 : 期月List) {
            if (定値区分_0.equals(get印字位置(期月.get期月().get月AsInt()))) {
                期月List.remove(期月);
            }
        }
        if (is昇順) {
            for (int i = 0; i < 期月List.size() - 1; i++) {
                if (Integer.parseInt(get印字位置(期月List.get(i).get期月().get月AsInt()).toString())
                        < Integer.parseInt(get印字位置(期月List.get(i + INT_1).get期月().get月AsInt()).toString())) {
                    山分け用スプール数 = 山分け用スプール数 + 1;
                }
            }
        } else {
            for (int i = 期月List.size() - 1; 0 < i; i--) {
                if (Integer.parseInt(get印字位置(期月List.get(i).get期月().get月AsInt()).toString())
                        < Integer.parseInt(get印字位置(期月List.get(i - INT_1).get期月().get月AsInt()).toString())) {
                    山分け用スプール数 = 山分け用スプール数 + 1;
                }
            }
        }
        return 山分け用スプール数;
    }

    private int get山分け用スプール数_ブック(int 出力期AsInt, List<NokiJoho> 期月List) {

        int ブック開始位置 = 0;
        for (NokiJoho 期月 : 期月List) {
            if (出力期AsInt == 期月.get期月().get期AsInt()) {
                ブック開始位置 = Integer.parseInt(getブック開始位置(期月.get期月().get月AsInt()).toString());
            }
        }
        int 出力期リスト_サイズ = 期月List.size();
        if (出力期リスト_サイズ == INT_0) {
            return INT_0;
        }
        switch (ブック開始位置) {
            case INT_1:
                return set山分け用スプール数_ブック開始位置1(出力期リスト_サイズ);
            case INT_2:
                return set山分け用スプール数_ブック開始位置2(出力期リスト_サイズ);
            case INT_3:
                if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_3) {
                    return INT_2;
                } else if (INT_4 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_7) {
                    return INT_3;
                } else {
                    return INT_4;
                }
            case INT_4:
                if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_2) {
                    return INT_2;
                } else if (INT_3 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_6) {
                    return INT_3;
                } else {
                    return INT_4;
                }
            case INT_5:
                return set山分け用スプール数_ブック開始位置5(出力期リスト_サイズ);
            default:
                return INT_0;
        }
    }

    private int get山分け用スプール数_コンビニ(int 出力期AsInt, List<NokiJoho> 期月List) {
        int 山分け用スプール数 = 0;
        int コンビニカット印字位置 = 0;
        for (NokiJoho 期月 : 期月List) {
            if (出力期AsInt == 期月.get期月().get期AsInt()) {
                コンビニカット印字位置 = Integer.parseInt(getコンビニカット印字位置(期月.get期月().get月AsInt()).toString());
            }
        }
        if (コンビニカット印字位置 == 1) {
            山分け用スプール数 = INT_1;
        } else if (INT_2 <= コンビニカット印字位置 && コンビニカット印字位置 <= INT_4) {
            山分け用スプール数 = INT_2;
        } else if (INT_5 <= コンビニカット印字位置 && コンビニカット印字位置 <= INT_7) {
            山分け用スプール数 = INT_3;
        } else if (INT_8 <= コンビニカット印字位置) {
            山分け用スプール数 = INT_4;
        }
        return 山分け用スプール数;
    }

    private int set山分け用スプール数_ブック開始位置1(int 出力期リスト_サイズ) {
        if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_5) {
            return INT_2;
        } else if (INT_6 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_9) {
            return INT_3;
        } else {
            return INT_4;
        }
    }

    private int set山分け用スプール数_ブック開始位置2(int 出力期リスト_サイズ) {
        if (INT_1 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_4) {
            return INT_2;
        } else if (INT_5 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_8) {
            return INT_3;
        } else {
            return INT_4;
        }
    }

    private int set山分け用スプール数_ブック開始位置5(int 出力期リスト_サイズ) {
        if (出力期リスト_サイズ == 1) {
            return INT_2;
        } else if (INT_2 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_5) {
            return INT_3;
        } else if (INT_6 <= 出力期リスト_サイズ && 出力期リスト_サイズ <= INT_9) {
            return INT_4;
        } else {
            return INT_5;
        }
    }

    private RString getコンビニカット印字位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_15:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_コンビニカット印字位置14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    private RString getブック開始位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_15:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_ブック開始位置14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    private Map<String, RString> get普徴期情報(RString 出力期) {

        RString 普徴期情報_通知書プリント条件;
        RString 普徴期情報_処理対象;
        RDate 運用日 = RDate.getNowDate();
        switch (Integer.parseInt(出力期.toString())) {
            case INT_1:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件1, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件2, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件3, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_4:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件4, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件5, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件6, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件7, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件8, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件9, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件10, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件11, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件12, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_13:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件13, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                普徴期情報_通知書プリント条件
                        = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_通知書プリント条件14, 運用日, SubGyomuCode.DBB介護賦課);
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                普徴期情報_通知書プリント条件 = RString.EMPTY;
                普徴期情報_処理対象 = RString.EMPTY;
                break;
        }
        Map<String, RString> map = new HashMap<>();
        map.put(キー_処理対象.toString(), 普徴期情報_処理対象);
        map.put(キー_通知書プリント条件.toString(), 普徴期情報_通知書プリント条件);
        return map;
    }

    private int get選択通知書No(int 仮算定最初期, int 仮算定最終期, int 本算定最初期, int 本算定最終期,
            HonsanteiTsuchishoTempResult tmpResult) {

        FukaAtena 賦課の情報_更正前 = tmpResult.get賦課の情報_更正前();
        FukaJoho 賦課の情報_更正後 = tmpResult.get賦課の情報_更正後().get賦課情報();
        Decimal 更正後_普徴本算定額 = get普徴期別金額合計(賦課の情報_更正後, 本算定最初期, 本算定最終期);
        if (賦課の情報_更正前 == null) {
            if (定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_9;
            } else {
                return INT_0;
            }
        }
        ChoshuHoho 徴収方法情報_更正前 = tmpResult.get徴収方法情報_更正前();
        Decimal 更正前_普徴特徴仮算定額合計 = null;
        RString 徴収方法更正前_特別徴収停止事由コード = RString.EMPTY;
        if (徴収方法情報_更正前 != null) {
            徴収方法更正前_特別徴収停止事由コード = 徴収方法情報_更正前.get特別徴収停止事由コード();
        }

        Decimal 更正前_特徴仮算定額 = get特徴期別金額合計(賦課の情報_更正前.get賦課情報(), INT_1, INT_3);
        Decimal 更正前_普徴仮算定額 = get普徴期別金額合計(賦課の情報_更正前.get賦課情報(), 仮算定最初期, 仮算定最終期);
        if (更正前_特徴仮算定額 == null && 更正前_普徴仮算定額 == null) {
            更正前_普徴特徴仮算定額合計 = null;
        } else if (更正前_特徴仮算定額 != null && 更正前_普徴仮算定額 == null) {
            更正前_普徴特徴仮算定額合計 = 更正前_特徴仮算定額;
        } else if (更正前_特徴仮算定額 == null && 更正前_普徴仮算定額 != null) {
            更正前_普徴特徴仮算定額合計 = 更正前_普徴仮算定額;
        } else if (更正前_特徴仮算定額 != null && 更正前_普徴仮算定額 != null) {
            更正前_普徴特徴仮算定額合計 = 更正前_特徴仮算定額.add(更正前_普徴仮算定額);
        }
        Decimal 更正後_特徴本算定額 = get特徴期別金額合計(賦課の情報_更正後, INT_4, INT_6);

        int 選択通知書No = get選択通知書No_部分(賦課の情報_更正後, 更正前_普徴特徴仮算定額合計,
                更正前_特徴仮算定額, 更正後_特徴本算定額, 徴収方法更正前_特別徴収停止事由コード);
        if (選択通知書No != 0) {
            return 選択通知書No;
        }

        if (定値区分_0.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正前_普徴仮算定額))
                && 定値区分_1.equals(get判定結果(更正後_特徴本算定額))) {
            return INT_8;
        }
        選択通知書No = get選択通知書No_部分(賦課の情報_更正後, 更正前_特徴仮算定額, 更正前_普徴仮算定額, 更正後_特徴本算定額, 更正後_普徴本算定額);
        if (選択通知書No != 0) {
            return 選択通知書No;
        }

        return 0;
    }

    private int get選択通知書No_部分(FukaJoho 賦課の情報_更正後, Decimal 更正前_普徴特徴仮算定額合計, Decimal 更正前_特徴仮算定額,
            Decimal 更正後_特徴本算定額, RString 徴収方法更正前_特別徴収停止事由コード) {

        if (賦課の情報_更正後.get資格喪失日() == null || 賦課の情報_更正後.get資格喪失日().isEmpty()) {
            if ((更正前_普徴特徴仮算定額合計 == null && 賦課の情報_更正後.get減免前介護保険料_年額() == null)
                    || (更正前_普徴特徴仮算定額合計 != null
                    && 更正前_普徴特徴仮算定額合計.equals(賦課の情報_更正後.get減免前介護保険料_年額()))) {
                return INT_1;
            }
            if (更正前_普徴特徴仮算定額合計 != null && 賦課の情報_更正後.get減免前介護保険料_年額() != null
                    && (更正前_普徴特徴仮算定額合計.compareTo(賦課の情報_更正後.get減免前介護保険料_年額()) == INT_1)
                    && 定値区分_1.equals(get判定結果(賦課の情報_更正後.get減免前介護保険料_年額()))) {
                return INT_2;
            }
        }

        return get選択通知書No_部分1(賦課の情報_更正後, 更正前_普徴特徴仮算定額合計, 更正前_特徴仮算定額,
                更正後_特徴本算定額, 徴収方法更正前_特別徴収停止事由コード);
    }

    private int get選択通知書No_部分1(FukaJoho 賦課の情報_更正後, Decimal 更正前_普徴特徴仮算定額合計, Decimal 更正前_特徴仮算定額,
            Decimal 更正後_特徴本算定額, RString 徴収方法更正前_特別徴収停止事由コード) {

        if ((更正前_普徴特徴仮算定額合計 == null && 賦課の情報_更正後.get減免前介護保険料_年額() == null)
                || (更正前_普徴特徴仮算定額合計 != null
                && 更正前_普徴特徴仮算定額合計.equals(賦課の情報_更正後.get減免前介護保険料_年額()))) {
            return INT_3;
        }
        if (更正前_普徴特徴仮算定額合計 != null && 賦課の情報_更正後.get減免前介護保険料_年額() != null
                && (更正前_普徴特徴仮算定額合計.compareTo(賦課の情報_更正後.get減免前介護保険料_年額()) == INT_1)
                && 定値区分_1.equals(get判定結果(賦課の情報_更正後.get減免前介護保険料_年額()))) {
            return INT_4;
        }
        if (Decimal.ZERO.equals(賦課の情報_更正後.get減免前介護保険料_年額())) {
            return INT_5;
        }
        if (定値区分_1.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正後_特徴本算定額))) {
            if (!定値_特別徴収停止事由コード.equals(徴収方法更正前_特別徴収停止事由コード)) {
                return INT_6;
            } else {
                return INT_7;
            }
        }
        return INT_0;
    }

    private int get選択通知書No_部分(FukaJoho 賦課の情報_更正後, Decimal 更正前_特徴仮算定額, Decimal 更正前_普徴仮算定額,
            Decimal 更正後_特徴本算定額, Decimal 更正後_普徴本算定額) {

        if (賦課の情報_更正後.get資格喪失日() == null || 賦課の情報_更正後.get資格喪失日().isEmpty()) {
            if (定値区分_1.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_0.equals(get判定結果(更正後_特徴本算定額))
                    && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_10;
            }
            if (定値区分_0.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正前_普徴仮算定額))
                    && 定値区分_0.equals(get判定結果(更正後_特徴本算定額)) && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_11;
            }
        } else {
            if (定値区分_1.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_0.equals(get判定結果(更正後_特徴本算定額))
                    && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_12;
            }
            if (定値区分_0.equals(get判定結果(更正前_特徴仮算定額)) && 定値区分_1.equals(get判定結果(更正前_普徴仮算定額))
                    && 定値区分_0.equals(get判定結果(更正後_特徴本算定額)) && 定値区分_1.equals(get判定結果(更正後_普徴本算定額))) {
                return INT_13;
            }
        }
        return 0;
    }

    private RString get判定結果(Decimal 金額) {
        if (金額 == null) {
            return RString.EMPTY;
        }
        if (金額.compareTo(Decimal.ZERO) == INT_1) {
            return 定値区分_1;
        } else if (金額.compareTo(Decimal.ZERO) == 0) {
            return 定値区分_0;
        }
        return RString.EMPTY;
    }

    /**
     * 通知書共通情報取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 出力期 RString
     * @return HonsanteiTsuchishoInfo 通知書共通情報
     */
    private HonsanteiTsuchishoInfo get通知書共通情報(FlexibleYear 調定年度, RString 出力期) {

        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 本算定期間 = 期月リスト_普徴.filtered本算定期間();
        int 最終期 = 本算定期間.getLast().get期AsInt();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        List<Kitsuki> 本算定期間List = 本算定期間.toList();
        int 最初期;
        if (RString.isNullOrEmpty(出力期)) {
            最初期 = 本算定期間List.get(本算定期間List.size() - INT_1).get期AsInt();
        } else {
            最初期 = Integer.parseInt(出力期.toString());
        }
        KitsukiList 期月リスト = 期月リスト_普徴.subListBy期(最初期, 最終期);
        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : 期月リスト.toList()) {
            for (Noki 普徴納期 : 普徴納期List) {
                if (期月.get期AsInt() == 普徴納期.get期別() && !定値_ゼロ.equals(get印字位置(期月.get月AsInt()))) {
                    NokiJoho nokiJoho = new NokiJoho();
                    nokiJoho.set期月(期月);
                    nokiJoho.set納期(普徴納期);
                    普徴納期情報リスト.add(nokiJoho);
                }
            }
        }

        List<NokiJoho> 特徴納期情報リスト = new ArrayList<>();
        TokuchoKiUtil 月期対応取得_特徴 = new TokuchoKiUtil();
        KitsukiList 期月リスト_特徴 = 月期対応取得_特徴.get期月リスト();
        for (int index = INT_1; index <= INT_6; index++) {
            Kitsuki 期月情報 = 期月リスト_特徴.get期の最初月(index);
            Noki 特徴納期 = fukaNokiResearcher.get特徴納期(index);
            NokiJoho nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月情報);
            nokiJoho.set納期(特徴納期);
            特徴納期情報リスト.add(nokiJoho);
        }

        HonsanteiTsuchishoInfo 通知書共通情報entity = new HonsanteiTsuchishoInfo();
        通知書共通情報entity.set普徴納期情報リスト(普徴納期情報リスト);
        通知書共通情報entity.set特徴納期情報リスト(特徴納期情報リスト);
        return 通知書共通情報entity;
    }

    private RString get印字位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_15:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の印字位置14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    /**
     * 入力の改頁出力順IDによって、出力順を取得するメソッドです。
     *
     * @param 帳票ID ReportId
     * @param 出力順ID RString
     * @return RString 出力順
     */
    private RString get出力順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return RString.EMPTY;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        if (outputOrder == null) {
            return RString.EMPTY;
        }
        RString 出力順 = RString.EMPTY;
        if (特別徴収開始通知書本算定_帳票分類ID.equals(帳票分類ID)) {
            出力順 = MyBatisOrderByClauseCreator.create(BreakerFieldsEnum.class, outputOrder);
        } else if (決定変更通知書_帳票分類ID.equals(帳票分類ID)) {
            出力順 = MyBatisOrderByClauseCreator.create(OutputOrderEnum.class, outputOrder);
        } else if (納入通知書_帳票分類ID.equals(帳票分類ID)) {
            出力順 = MyBatisOrderByClauseCreator.create(NonyuOutputOrderEnum.class, outputOrder);
        }
        return 出力順;
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
    public void loadバッチ出力条件リスト(List<RString> 出力条件リスト, ReportId 帳票ID, RString 出力ページ数,
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

    private RString get帳票名_特徴(RString 帳票ID) {

        if (ReportIdDBB.DBB100032.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100032.getReportName();
        } else if (ReportIdDBB.DBB100033.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100033.getReportName();
        } else if (ReportIdDBB.DBB100034.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100034.getReportName();
        } else if (ReportIdDBB.DBB100035.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100035.getReportName();
        } else if (ReportIdDBB.DBB100036.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100036.getReportName();
        } else if (ReportIdDBB.DBB100037.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100037.getReportName();
        } else if (ReportIdDBB.DBB100038.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100038.getReportName();
        }
        return RString.EMPTY;
    }

    private RString get帳票名_決定(RString 帳票ID) {

        if (ReportIdDBB.DBB100039.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100039.getReportName();
        } else if (ReportIdDBB.DBB100040.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100040.getReportName();
        }
        return RString.EMPTY;
    }

    private RString get帳票名_変更(RString 帳票ID) {

        if (ReportIdDBB.DBB100042.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100042.getReportName();
        } else if (ReportIdDBB.DBB100043.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100043.getReportName();
        }
        return RString.EMPTY;
    }

    private RString get帳票名_納入(RString 帳票ID) {

        if (ReportIdDBB.DBB100045.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100045.getReportName();
        } else if (ReportIdDBB.DBB100046.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100046.getReportName();
        } else if (ReportIdDBB.DBB100053.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100053.getReportName();
        } else if (ReportIdDBB.DBB100054.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100054.getReportName();
        } else if (ReportIdDBB.DBB100051.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100051.getReportName();
        } else if (ReportIdDBB.DBB100052.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100052.getReportName();
        } else if (ReportIdDBB.DBB100056.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100056.getReportName();
        } else if (ReportIdDBB.DBB100058.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100058.getReportName();
        } else if (ReportIdDBB.DBB100055.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100055.getReportName();
        } else if (ReportIdDBB.DBB100057.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100057.getReportName();
        } else if (ReportIdDBB.DBB100061.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100061.getReportName();
        } else if (ReportIdDBB.DBB100062.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100062.getReportName();
        } else if (ReportIdDBB.DBB100059.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100059.getReportName();
        } else if (ReportIdDBB.DBB100060.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100060.getReportName();
        } else if (ReportIdDBB.DBB100063.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100063.getReportName();
        } else if (ReportIdDBB.DBB100064.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100064.getReportName();
        }
        return RString.EMPTY;
    }

    private Decimal get特徴期別金額合計(FukaJoho fukaJoho, int start, int end) {
        Decimal 特徴仮算定保険料 = Decimal.ZERO;
        if (fukaJoho == null) {
            return null;
        }
        boolean 区分 = false;
        for (int i = start; i <= end; i++) {
            if (i == INT_0 || INT_6 < i) {
                continue;
            }
            RStringBuilder sb = new RStringBuilder(定数_特徴期別金額.toString());
            sb.append(new RString(i).padZeroToLeft(INT_2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                if ((Decimal) getMethod.invoke(fukaJoho) != null) {
                    区分 = true;
                    特徴仮算定保険料 = 特徴仮算定保険料.add((Decimal) getMethod.invoke(fukaJoho));
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!区分) {
            return null;
        }
        return 特徴仮算定保険料;
    }

    private Decimal get普徴期別金額合計(FukaJoho fukaJoho, int start, int end) {
        Decimal 普徴納付済額 = Decimal.ZERO;
        if (fukaJoho == null) {
            return null;
        }
        boolean 区分 = false;
        for (int i = start; i <= end; i++) {
            if (i == INT_0 || INT_14 < i) {
                continue;
            }
            RStringBuilder sb = new RStringBuilder(定数_普徴期別金額.toString());
            sb.append(new RString(i).padZeroToLeft(INT_2));
            Class clazz = fukaJoho.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(sb.toString());
                if ((Decimal) getMethod.invoke(fukaJoho) != null) {
                    区分 = true;
                    普徴納付済額 = 普徴納付済額.add((Decimal) getMethod.invoke(fukaJoho));
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!区分) {
            return null;
        }
        return 普徴納付済額;
    }

    private RString get選択現金口座(DbT2014TsuchishoUchiwakeJokenEntity entity, int index) {

        RString 選択現金口座 = RString.EMPTY;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_選択現金口座.toString());
        sb.append(new RString(index).padZeroToLeft(INT_2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            選択現金口座 = (RString) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 選択現金口座;
    }

    private RString get選択通知書(DbT2014TsuchishoUchiwakeJokenEntity entity, int index) {

        RString 選択通知書 = RString.EMPTY;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_選択通知書.toString());
        sb.append(new RString(index).padZeroToLeft(INT_2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            選択通知書 = (RString) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 選択通知書;
    }

    private RString get出力順グループ名(DbT2014TsuchishoUchiwakeJokenEntity entity, int index) {

        RString 出力順グループ名 = RString.EMPTY;
        if (entity == null) {
            return null;
        }
        RStringBuilder sb = new RStringBuilder(定数_出力順グループ名.toString());
        sb.append(new RString(index).padZeroToLeft(INT_2));
        Class clazz = entity.getClass();
        try {
            Method getMethod = clazz.getDeclaredMethod(sb.toString());
            出力順グループ名 = (RString) getMethod.invoke(entity);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HonsanteiTsuchishoIkkatsuHakko.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 出力順グループ名;
    }

    private int checkStyle(int 山分け用スプール数) {
        if (山分け用スプール数 == 0) {
            return INT_1;
        }
        return 山分け用スプール数;
    }
}
