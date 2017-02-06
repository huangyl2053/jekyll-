/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendotsuchishoikkatsuhakko;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempResult;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteitsuchishoikkatsuhakko.TokuchoKaishiTsuchishoInfo;
import jp.co.ndensan.reams.db.dbb.business.core.karisanteiidotsuchisho.TsuchishoKyotsuEntity;
import jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuProperty.OutputOrderEnum;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranProperty.NonyuOutputOrderEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiKetteiTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.FuchoSyoriTaisho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KozaFurikaeOutputType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendotsuchishoikkatsuhakko.IdoFukaJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendotsuchishoikkatsuhakko.IKanendoTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NonyuTsuchiShoSeigyoJohoLoaderFinder;
import jp.co.ndensan.reams.db.dbb.service.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kaigohokenryogaku.KaigoHokenryogakuPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.kanendoidohakkoichiran.HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbb.service.report.tsuchisho.notsu.NonyuTsuchiShoJohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AtesakiShubetsu;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
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
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定異動（過年度）通知書一括発行（バッチ）のクラスです。
 *
 * @reamsid_L DBB-0920-040 huzongcheng
 */
public class HonsanteiIdoKanendoTsuchishoIkkatsuHakko extends HonsanteiIdoKanendoTsuchishoIkkatsuHakkoHojo {

    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");
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
    private static final RString 定値区分_0 = new RString("0");
    private static final RString 定値区分_1 = new RString("1");
    private static final RString 定値区分_2 = new RString("2");
    private static final ReportId 介護保険料額決定通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書本算定_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString キー_賦課年度リスト = new RString("賦課年度リスト");
    private static final RString キー_調定年度 = new RString("調定年度");
    private static final RString キー_納入通知書対象者 = new RString("納入通知書対象者");
    private static final RString キー_変更通知書出力対象区分 = new RString("変更通知書出力対象区分");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 定数_対象賦課年度 = new RString("対象賦課年度");
    private static final RString 定数_文書番号 = new RString("文書番号");
    private static final RString 定数_出力期 = new RString("出力期");
    private static final RString 定数_対象者 = new RString("対象者");
    private static final RString 定数_出力対象 = new RString("出力対象");
    private static final RString 定数_口座振替者 = new RString("口座振替者　今回出力様式");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString CSVファイル名_なし = new RString("なし");
    private static final RString 年度 = new RString("年度");
    private static final RString CSVファイル名_決定一覧表 = new RString("介護保険料額決定通知書発行一覧表");
    private static final RString CSVファイル名_変更一覧表 = new RString("介護保険料額変更通知書発行一覧表");
    private static final EucEntityId 決定_EUC_ENTITY_ID = new EucEntityId("DBB200012");
    private static final RString 決定_EUCファイル名 = new RString("KaigoHokenryogakuKetteiTsuchiHakkoIchiranData.csv");
    private static final EucEntityId 変更_EUC_ENTITY_ID = new EucEntityId("DBB200030");
    private static final RString 変更_EUCファイル名 = new RString("KaigoHokenryogakuHenkoTsuchiHakkoIchiranData.csv");
    private static final EucEntityId 納入_EUC_ENTITY_ID = new EucEntityId("DBB200010");
    private static final RString 納入_EUCファイル名 = new RString("NonyuTsuchishoHonsanteiHakkoIchiranData.csv");
    private static final RString 定値_タイトル = new RString("介護保険料額変更通知書発行一覧表");
    private static final RString ソート = new RString("order by");
    private static final RString 定値_生活保護区分 = new RString("生活保護区分");
    private static final RString ソート順_降順 = new RString("DESC");
    private static final RString ソート順_昇順 = new RString("ASC");
    private static final RString 口座区分 = new RString("dbT2015KeisangoJoho_kozaKubun");
    private static final RString FORMAT = new RString("\"");
    private static final RString キー_処理対象 = new RString("処理対象");
    private static final RString キー_通知書プリント条件 = new RString("通知書プリント条件");
    private static final RString カンマ = new RString(",");
    private static final RString 定数_生活保護対象者をまとめて先頭に出力 = new RString("生活保護対象者をまとめて先頭に出力");
    private static final RString 定数_ページごとに山分け = new RString("ページごとに山分け");
    private static final RString 定値_する = new RString("する");
    private static final RString 定値_しない = new RString("しない");

    private final MapperProvider mapperProvider;
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;

    /**
     * コンストラクタです。
     */
    public HonsanteiIdoKanendoTsuchishoIkkatsuHakko() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HonsanteiIdoKanendoTsuchishoIkkatsuHakko}のインスタンスを返します。
     *
     * @return HonsanteiIdoKanendoTsuchishoIkkatsuHakko
     */
    public static HonsanteiIdoKanendoTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(HonsanteiIdoKanendoTsuchishoIkkatsuHakko.class);
    }

    /**
     * 異動分賦課情報取得メソッド。
     *
     * @param 調定年度 FlexibleYear
     * @param 一括発行起動フラグ boolean
     */
    public void getIdoFukaJoho(FlexibleYear 調定年度, boolean 一括発行起動フラグ) {
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        YMDHMS 最新の基準日 = get最新調定日時(調定年度);
        IKozaSearchKey kozaSearchKey = get口座Param();
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護保険料_普通徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        List<KamokuCode> list = new ArrayList<>();
        list.add(介護保険料_普通徴収.getコード());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        for (int i = 0; i < list.size(); i++) {
            rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
            if (i != list.size() - 1) {
                rStringBuilder.append(MIDDLE_FORMAT);
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        IdoFukaJohoParameter parameter1 = IdoFukaJohoParameter.createParameter(
                調定年度, 調定年度.minusYear(1), 調定年度.minusYear(2), 最新の基準日, 処理日, kozaSearchKey, list, 科目コード, 定値区分_1);
        IdoFukaJohoParameter parameter2 = IdoFukaJohoParameter.createParameter(
                調定年度, 調定年度.minusYear(1), 調定年度.minusYear(2), 最新の基準日, 処理日, kozaSearchKey, list, 科目コード, 定値区分_2);
        if (一括発行起動フラグ) {
            mapper.insert賦課情報一時FROM計算後情報(parameter1);
            mapper.insert賦課情報一時FROM計算後情報(parameter2);
            mapper.update異動賦課情報一時テーブルFROM計算後情報();
        }
        mapper.update異動賦課情報一時テーブル更正前対象者情報(parameter1);
        mapper.update異動賦課情報一時テーブル更正前対象者情報(parameter2);
        mapper.update異動賦課情報一時テーブル生活保護区分();
        mapper.update異動賦課情報一時テーブル特徴8月開始者区分();
        mapper.update異動賦課情報一時テーブル特徴10月開始者区分();
    }

    /**
     * 異動分賦課情報取得メソッド。
     *
     * @param 調定年度 FlexibleYear
     * @param 回目 RString
     */
    public void getIdoFukaJohoFlgTrue(FlexibleYear 調定年度, RString 回目) {
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        YMDHMS 最新の基準日 = get最新調定日時(調定年度);
        IKozaSearchKey kozaSearchKey = get口座Param();
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護保険料_普通徴収 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        List<KamokuCode> list = new ArrayList<>();
        list.add(介護保険料_普通徴収.getコード());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        for (int i = 0; i < list.size(); i++) {
            rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
            if (i != list.size() - 1) {
                rStringBuilder.append(MIDDLE_FORMAT);
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        IdoFukaJohoParameter parameter = IdoFukaJohoParameter.createParameter(
                調定年度, 調定年度.minusYear(1), 調定年度.minusYear(2), 最新の基準日, 処理日, kozaSearchKey, list, 科目コード, 回目);
        mapper.insert賦課情報一時FROM計算後情報FLAGTRUE(parameter);
        mapper.update異動賦課情報一時テーブルFROM計算後情報一時FLAGTRUE();
    }

    /**
     * 決定通知書の発行のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度リスト List<FlexibleYear>
     * @param 帳票作成日時 YMDHMS
     * @param 発行日 RDate
     * @param 文書番号 RString
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 一括発行起動フラグ boolean
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void pntKetteiTsuchisho(FlexibleYear 調定年度, List<FlexibleYear> 賦課年度リスト, YMDHMS 帳票作成日時,
            RDate 発行日, RString 文書番号, RString 出力順ID, ReportId 帳票ID, boolean 一括発行起動フラグ) throws InvocationTargetException {
        RString 出力順 = get出力順(介護保険料額決定通知書_帳票分類ID, 出力順ID);
        TsuchishoKyotsuEntity 通知書共通情報entity = getTuutishoKyoutuJoho(調定年度, null);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_賦課年度リスト.toString(), 賦課年度リスト);
        parameter.put(キー_調定年度.toString(), 調定年度);
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select異動賦課情報一時(parameter);
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(介護保険料額決定通知書_帳票分類ID);
        int 定型文文字サイズ = 0;
        if (帳票制御共通 != null && !RString.isNullOrEmpty(帳票制御共通.get定型文文字サイズ())) {
            定型文文字サイズ = Integer.parseInt(帳票制御共通.get定型文文字サイズ().toString());
        }
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        RString 通知書定型文 = ReportUtil.get通知文(SubGyomuCode.DBB介護賦課,
                介護保険料額決定通知書_帳票分類ID, KamokuCode.EMPTY, 定型文文字サイズ, INT_1, システム日付);
        List<RString> 出力条件リスト = 決定出力条件リスト取得(発行日, 文書番号, 出力順ID, 賦課年度リスト);
        RString 帳票名 = get帳票名_介護保険料額決定通知書(帳票ID.getColumnValue());
        if (entityList == null || entityList.isEmpty() || entityList.get(0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値区分_0, CSV出力有無_なし, CSVファイル名, 帳票名);
            return;
        }
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList, null);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<TokuchoKaishiTsuchishoInfo> 編集後本算定通知書共通情報List = new ArrayList<>();
        List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities = new ArrayList<>();
        SourceDataCollection sourceDataCollection;
        for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
            TokuchoKaishiTsuchishoInfo tokuchoKaishiTsuchishoInfo = new TokuchoKaishiTsuchishoInfo();
            tokuchoKaishiTsuchishoInfo.set生活保護区分(tmpResult.get生活保護区分());
            tokuchoKaishiTsuchishoInfo.set特徴8月開始者区分(tmpResult.get特徴8月開始者区分());
            tokuchoKaishiTsuchishoInfo.set特徴10月開始者区分(tmpResult.get特徴10月開始者区分());
            HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
            本算定通知書情報.set現年度_過年度区分(GennenKanen.過年度);
            本算定通知書情報.set発行日(発行日);
            本算定通知書情報.set帳票分類ID(介護保険料額決定通知書_帳票分類ID);
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
            本算定決定通知書情報.set現年度_過年度区分(GennenKanen.過年度);
            本算定決定通知書情報.set発行日(発行日);
            本算定決定通知書情報.set帳票分類ID(介護保険料額決定通知書_帳票分類ID);
            本算定決定通知書情報.set帳票ID(帳票ID);
            本算定決定通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
            本算定決定通知書情報.set宛先情報(tmpResult.get宛先情報());
            本算定決定通知書情報.set処理区分(ShoriKubun.バッチ);
            本算定決定通知書情報.set地方公共団体(地方公共団体);

            KaigoHokenHokenryogakuKetteiTsuchishoJoho 介護保険料額決定通知書 = new KaigoHokenHokenryogakuKetteiTsuchishoJoho();
            介護保険料額決定通知書.set文書番号(文書番号);
            介護保険料額決定通知書.set本算定決定通知書情報(本算定決定通知書情報);
            介護保険料額決定通知書.set通知書定型文(通知書定型文);
            entities.add(介護保険料額決定通知書);

            tokuchoKaishiTsuchishoInfo.set本算定通知書情報(本算定通知書情報);
            tokuchoKaishiTsuchishoInfo.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
            編集後本算定通知書共通情報List.add(tokuchoKaishiTsuchishoInfo);
        }
        try (ReportManager reportManager = new ReportManager()) {
            if (ReportIdDBB.DBB100039.getReportId().equals(帳票ID)) {
                new KaigoHokenHokenryogakuKetteiTsuchishoPrintService().printB5Yoko(entities, reportManager);
            } else if (ReportIdDBB.DBB100040.getReportId().equals(帳票ID)) {
                new KaigoHokenHokenryogakuKetteiTsuchishoPrintService().printA4Tate(entities, reportManager);
            }
            sourceDataCollection = reportManager.publish();
        }
        new KaigoHokenryogakuPrintService().printSingle(編集後本算定通知書共通情報List,
                帳票作成日時.getRDateTime(), 出力順ID, 定値_タイトル);
        publish決定変更通知書発行一覧表(帳票作成日時.getRDateTime(), 編集後本算定通知書共通情報List, 決定_EUC_ENTITY_ID, 決定_EUCファイル名);
        RString 出力ページ数 = get出力ページ数(sourceDataCollection);
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, CSVファイル名_決定一覧表, 帳票名);
    }

    /**
     * 決定通知書発行後異動者登録するメソッドです。
     *
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 賦課年度リスト List<FlexibleYear>
     */
    public void insTsuchishoHakkogoIdoshaKettei(YMDHMS 帳票作成日時, RString 出力順ID, ReportId 帳票ID, List<FlexibleYear> 賦課年度リスト) {

        RString 出力順 = get出力順(介護保険料額決定通知書_帳票分類ID, 出力順ID);
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_賦課年度リスト.toString(), 賦課年度リスト);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select通知書発行後異動者(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 変更通知書の発行のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度リスト List<FlexibleYear>
     * @param 帳票作成日時 YMDHMS
     * @param 発行日 RDate
     * @param 変更通知書出力対象区分 RString
     * @param 文書番号 RString
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 一括発行起動フラグ boolean
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void pntHenkoTsuchisho(FlexibleYear 調定年度, List<FlexibleYear> 賦課年度リスト, YMDHMS 帳票作成日時,
            RDate 発行日, RString 変更通知書出力対象区分, RString 文書番号, RString 出力順ID, ReportId 帳票ID, boolean 一括発行起動フラグ) throws InvocationTargetException {
        RString 出力順 = get出力順(介護保険料額決定通知書_帳票分類ID, 出力順ID);
        TsuchishoKyotsuEntity 通知書共通情報entity = getTuutishoKyoutuJoho(調定年度, null);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_賦課年度リスト.toString(), 賦課年度リスト);
        parameter.put(キー_調定年度.toString(), 調定年度);
        parameter.put(キー_変更通知書出力対象区分.toString(), 変更通知書出力対象区分);
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select異動賦課情報一時変更(parameter);
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(介護保険料額決定通知書_帳票分類ID);
        List<RString> 出力条件リスト = 変更出力条件リスト取得(発行日, 文書番号, 出力順ID, 賦課年度リスト, 変更通知書出力対象区分);
        RString 帳票名 = get帳票名_介護保険料額決定通知書(帳票ID.getColumnValue());
        if (entityList == null || entityList.isEmpty() || entityList.get(0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値区分_0, CSV出力有無_なし, CSVファイル名, 帳票名);
            return;
        }
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList, null);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        HonSanteiTsuchiShoKyotsuKomokuHenshu 本算定共通情報作成 = InstanceProvider.create(HonSanteiTsuchiShoKyotsuKomokuHenshu.class);
        List<TokuchoKaishiTsuchishoInfo> 編集後本算定通知書共通情報List = new ArrayList<>();
        List<KaigoHokenryogakuHenkoKenChushiTsuchishoJoho> entities = new ArrayList<>();
        SourceDataCollection sourceDataCollection;
        for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
            TokuchoKaishiTsuchishoInfo tokuchoKaishiTsuchishoInfo = new TokuchoKaishiTsuchishoInfo();
            tokuchoKaishiTsuchishoInfo.set生活保護区分(tmpResult.get生活保護区分());
            tokuchoKaishiTsuchishoInfo.set特徴8月開始者区分(tmpResult.get特徴8月開始者区分());
            tokuchoKaishiTsuchishoInfo.set特徴10月開始者区分(tmpResult.get特徴10月開始者区分());
            HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
            本算定通知書情報.set現年度_過年度区分(GennenKanen.過年度);
            本算定通知書情報.set発行日(発行日);
            本算定通知書情報.set帳票分類ID(介護保険料額決定通知書_帳票分類ID);
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
            本算定変更通知書情報.set現年度_過年度区分(GennenKanen.過年度);
            本算定変更通知書情報.set発行日(発行日);
            本算定変更通知書情報.set帳票分類ID(介護保険料額決定通知書_帳票分類ID);
            本算定変更通知書情報.set帳票ID(帳票ID);
            本算定変更通知書情報.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
            本算定変更通知書情報.set宛先情報(tmpResult.get宛先情報());
            本算定変更通知書情報.set処理区分(ShoriKubun.バッチ);
            本算定変更通知書情報.set地方公共団体(地方公共団体);

            KaigoHokenryogakuHenkoKenChushiTsuchishoJoho 通知書情報 = new KaigoHokenryogakuHenkoKenChushiTsuchishoJoho();
            通知書情報.set文書番号(文書番号);
            通知書情報.set本算定決定通知書情報(本算定変更通知書情報);
            entities.add(通知書情報);
            tokuchoKaishiTsuchishoInfo.set本算定通知書情報(本算定通知書情報);
            tokuchoKaishiTsuchishoInfo.set編集後本算定通知書共通情報(編集後本算定通知書共通情報);
            編集後本算定通知書共通情報List.add(tokuchoKaishiTsuchishoInfo);
        }
        try (ReportManager reportManager = new ReportManager()) {
            if (ReportIdDBB.DBB100042.getReportId().equals(帳票ID)) {
                new KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService().printB5Yoko(entities, reportManager);
            } else {
                new KaigoHokenryogakuHenkoKenChushiTsuchishoPrintService().printA4Tate(entities, reportManager);
            }
            sourceDataCollection = reportManager.publish();
        }
        publish決定変更通知書発行一覧表(帳票作成日時.getRDateTime(), 編集後本算定通知書共通情報List, 変更_EUC_ENTITY_ID, 変更_EUCファイル名);
        new KaigoHokenryogakuPrintService().printSingle(編集後本算定通知書共通情報List,
                帳票作成日時.getRDateTime(), 出力順ID, 定値_タイトル);
        RString 出力ページ数 = get出力ページ数(sourceDataCollection);
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, CSVファイル名_変更一覧表, 帳票名);
    }

    /**
     * 変更通知書発行後異動者登録するメソッドです。
     *
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString RString
     * @param 変更通知書出力対象区分 RString
     * @param 帳票ID ReportId
     * @param 賦課年度リスト List<FlexibleYear>
     */
    public void insTsuchishoHakkogoIdoshaHenko(YMDHMS 帳票作成日時, RString 出力順ID,
            RString 変更通知書出力対象区分, ReportId 帳票ID, List<FlexibleYear> 賦課年度リスト) {
        RString 出力順 = get出力順(介護保険料額決定通知書_帳票分類ID, 出力順ID);
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_賦課年度リスト.toString(), 賦課年度リスト);
        parameter.put(キー_変更通知書出力対象区分.toString(), 変更通知書出力対象区分);
        parameter.put(キー_出力順.toString(), 出力順);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select変更通知書発行後異動者(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 通知書共通情報取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 出力期 RString
     * @return TsuchishoKyotsuEntity 通知書共通情報
     */
    public TsuchishoKyotsuEntity getTuutishoKyoutuJoho(FlexibleYear 調定年度, RString 出力期) {
        TsuchishoKyotsuEntity 通知書共通情報entity = new TsuchishoKyotsuEntity();
        if (!RString.isNullOrEmpty(出力期)) {
            KanendoKiUtil 月期対応取得_過年度 = new KanendoKiUtil();
            Kitsuki 期月_過年度 = 月期対応取得_過年度.get期月リスト().get期の月(Integer.parseInt(出力期.toString())).get(0);
            FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
            Noki 納期_過年度 = fukaNokiResearcher.get過年度納期(Integer.parseInt(出力期.toString()));

            List<NokiJoho> 過年度納期情報リスト = new ArrayList<>();
            NokiJoho nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月_過年度);
            nokiJoho.set納期(納期_過年度);
            過年度納期情報リスト.add(nokiJoho);
            通知書共通情報entity.set普徴納期情報リスト(過年度納期情報リスト);
        }
        return 通知書共通情報entity;
    }

    /**
     * 納入通知書の発行のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度リスト List<FlexibleYear>
     * @param 出力期 RString
     * @param 発行日 RDate
     * @param 帳票作成日時 YMDHMS
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 口座振替分出力様式 RString
     * @param ページごとに山分け RString
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     * @param 一括発行起動フラグ boolean
     * @throws java.lang.reflect.InvocationTargetException 賦課情報が取得できない場合、Exception
     */
    public void pntNonyuTsuchisho(FlexibleYear 調定年度, List<FlexibleYear> 賦課年度リスト, YMDHMS 帳票作成日時,
            RDate 発行日, RString 出力期, RString 納入通知書対象者, RString 口座振替分出力様式, RString 生活保護者先頭出力区分,
            RString ページごとに山分け, RString 出力順ID, ReportId 帳票ID, boolean 一括発行起動フラグ) throws InvocationTargetException {
        RString 出力順 = get出力順(納入通知書本算定_帳票分類ID, 出力順ID);
        Map<String, RString> 普徴期情報 = get普徴期情報(出力期);
        RString 普徴期情報_処理対象 = 普徴期情報.get(キー_処理対象.toString());
        if (!FuchoSyoriTaisho.異動分のみ対象.getコード().equals(普徴期情報_処理対象)) {
            return;
        }
        int 出力期AsInt = Integer.parseInt(出力期.toString());
        List<NokiJoho> 期月List = get期月リスト(調定年度, 出力期AsInt);
        TsuchishoKyotsuEntity 通知書共通情報entity = getTuutishoKyoutuJoho(調定年度, 出力期);
        NonyuTsuchiShoSeigyoJohoLoaderFinder finder = NonyuTsuchiShoSeigyoJohoLoaderFinder.createInstance(調定年度);
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = finder.get本算定納入通知書制御情報();
        List<RString> 出力条件リスト = 納入出力条件リスト取得(発行日, 出力期, 納入通知書対象者, 口座振替分出力様式, 生活保護者先頭出力区分, ページごとに山分け);
        RString 帳票名 = get帳票名_本算定保険料納入通知書(帳票ID.getColumnValue());
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        if (定値区分_1.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_生活保護区分).concat(FORMAT).concat(RString.HALF_SPACE)
                    .concat(ソート順_降順).concat(カンマ)
                    .concat(RString.HALF_SPACE).concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else if (定値区分_0.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        }
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_賦課年度リスト.toString(), 賦課年度リスト);
        parameter.put(キー_調定年度.toString(), 調定年度);
        parameter.put(キー_納入通知書対象者.toString(), 納入通知書対象者);
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select異動賦課情報一時納入(parameter);
        if (entityList == null || entityList.isEmpty() || entityList.get(0).get計算後情報_更正後() == null) {
            loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 定値区分_0, CSV出力有無_なし, CSVファイル名_なし, 帳票名);
            return;
        }
        if (定値区分_1.equals(ページごとに山分け)) {
            通知書共通情報entity.set普徴納期情報リスト(期月List);
        }
        int 山分け用スプール数 = get山分け用スプール数(帳票ID, 期月List, 出力期AsInt, ページごとに山分け);
        ChohyoSeigyoKyotsu 帳票制御共通 = load帳票制御共通(納入通知書本算定_帳票分類ID);
        List<HonsanteiTsuchishoTempResult> tmpResultList = get賦課情報(entityList, 口座振替分出力様式);
        NonyuTsuchiShoJohoFactory nonyuTsuchiShoJohoFactory = InstanceProvider.create(NonyuTsuchiShoJohoFactory.class);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        List<HonSanteiTsuchiShoKyotsu> 本算定通知書情報List = new ArrayList<>();
        List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List = new ArrayList<>();
        SourceDataCollection sourceDataCollection;
        try (ReportManager reportManager = new ReportManager()) {
            List<HonSanteiNonyuTsuchiShoJoho> 編集後本算定共通情報List = new ArrayList<>();
            for (HonsanteiTsuchishoTempResult tmpResult : tmpResultList) {
                HonSanteiTsuchiShoKyotsu 本算定通知書情報 = new HonSanteiTsuchiShoKyotsu();
                本算定通知書情報.set現年度_過年度区分(GennenKanen.過年度);
                本算定通知書情報.set発行日(発行日);
                本算定通知書情報.set帳票分類ID(納入通知書本算定_帳票分類ID);
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
                List<Kitsuki> 出力期リスト = get出力期リスト(出力期AsInt);
                IName 代納人氏名 = tmpResult.get宛先情報() != null && AtesakiShubetsu.代納人.equals(tmpResult.get宛先情報().get宛先種別())
                        ? tmpResult.get宛先情報().get宛先名称() : null;
                HonSanteiNonyuTsuchiShoJoho 編集後本算定通知書共通情報
                        = nonyuTsuchiShoJohoFactory.create本算定納入通知書情報(本算定通知書情報, 本算定納入通知書制御情報, 出力期リスト, 代納人氏名, false);
                本算定通知書情報List.add(本算定通知書情報);
                編集後本算定共通情報List.add(編集後本算定通知書共通情報);
                編集後本算定通知書共通情報List.add(編集後本算定通知書共通情報.get編集後本算定通知書共通情報());
            }
            if (山分け用スプール数 == INT_1) {
                publish納入通知書本算定(帳票ID, 編集後本算定共通情報List, reportManager);
            } else if (山分け用スプール数 == INT_2) {
                publish納入通知書本算定_山分けする(帳票ID, 編集後本算定共通情報List, reportManager);
            }
            sourceDataCollection = reportManager.publish();
        }
        List<RString> 賦課年度List = new ArrayList();
        for (FlexibleYear item : 賦課年度リスト) {
            賦課年度List.add(item.toDateString());
        }
        publish納入通知書発行一覧表(帳票作成日時.getRDateTime(), 調定年度, 賦課年度リスト, 出力期, 編集後本算定通知書共通情報List, 納入_EUC_ENTITY_ID, 納入_EUCファイル名);
        new HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService().print(本算定通知書情報List, 編集後本算定通知書共通情報List,
                調定年度.toDateString(), 出力期, 帳票作成日時, 出力順ID, 賦課年度List);
        RString 出力ページ数 = get出力ページ数(sourceDataCollection);
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_あり, 納入_EUCファイル名, 帳票名);
    }

    private int get山分け用スプール数(ReportId 帳票ID, List<NokiJoho> 期月List,
            int 出力期AsInt, RString 山分け区分) {
        int 山分け用スプール数 = INT_1;
        if (定値区分_0.equals(山分け区分)
                && (ReportIdDBB.DBB100071.getReportId().getColumnValue().equals(帳票ID.getColumnValue())
                || ReportIdDBB.DBB100072.getReportId().getColumnValue().equals(帳票ID.getColumnValue()))) {
            山分け用スプール数 = get山分け用スプール数_ブック(出力期AsInt, 期月List);
        } else if (定値区分_0.equals(山分け区分)
                && (ReportIdDBB.DBB100073.getReportId().getColumnValue().equals(帳票ID.getColumnValue())
                || ReportIdDBB.DBB100075.getReportId().getColumnValue().equals(帳票ID.getColumnValue()))) {
            山分け用スプール数 = get山分け用スプール数_コンビニ(出力期AsInt, 期月List);
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
        if (ブック開始位置 == INT_1) {
            return INT_1;
        }
        return INT_2;
    }

    private int get山分け用スプール数_コンビニ(int 出力期AsInt, List<NokiJoho> 期月List) {
        int コンビニカット印字位置 = 0;
        for (NokiJoho 期月 : 期月List) {
            if (出力期AsInt == 期月.get期月().get期AsInt()) {
                コンビニカット印字位置 = Integer.parseInt(getコンビニカット印字位置(期月.get期月().get月AsInt()).toString());
            }
        }
        if (コンビニカット印字位置 == INT_1) {
            return INT_1;
        }
        return INT_2;
    }

    private RString getブック開始位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_ブック開始位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    private RString getコンビニカット印字位置(int 月) {

        RString 設定値 = RString.EMPTY;
        RDate 運用日 = RDate.getNowDate();
        switch (月) {
            case INT_4:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_1:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                設定値 = DbBusinessConfig.get(ConfigNameDBB.過年度期情報_コンビニカット印字位置12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                break;
        }
        return 設定値;
    }

    /**
     * 納入通知書発行後異動者登録するメソッドです。
     *
     * @param 賦課年度リスト List<FlexibleYear>
     * @param 帳票作成日時 RDateTime
     * @param 出力期 RString
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力区分 RString
     * @param 出力順ID RString
     * @param 帳票ID ReportId
     */
    public void insTsuchishoHakkogoIdoshaNonyu(List<FlexibleYear> 賦課年度リスト, YMDHMS 帳票作成日時, RString 出力期,
            RString 納入通知書対象者, RString 生活保護者先頭出力区分, RString 出力順ID, ReportId 帳票ID) {
        RString 出力順 = get出力順(納入通知書本算定_帳票分類ID, 出力順ID);
        RStringBuilder orderByClause = new RStringBuilder(ソート);
        if (定値区分_1.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(定値_生活保護区分).concat(FORMAT).concat(RString.HALF_SPACE)
                    .concat(ソート順_降順).concat(カンマ)
                    .concat(RString.HALF_SPACE).concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        } else if (定値区分_0.equals(生活保護者先頭出力区分)) {
            orderByClause.append(RString.HALF_SPACE.concat(FORMAT).concat(口座区分).concat(FORMAT)
                    .concat(RString.HALF_SPACE).concat(ソート順_昇順));
        }
        if (!RString.isNullOrEmpty(出力順)) {
            orderByClause.append(カンマ).append(RString.HALF_SPACE).append(出力順.replace(ソート, RString.EMPTY));
        }
        出力順 = orderByClause.toRString();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー_出力順.toString(), 出力順);
        parameter.put(キー_賦課年度リスト.toString(), 賦課年度リスト);
        parameter.put(キー_納入通知書対象者.toString(), 納入通知書対象者);
        IKanendoTsuchishoIkkatsuHakkoMapper mapper = mapperProvider.create(IKanendoTsuchishoIkkatsuHakkoMapper.class);
        List<HonsanteiTsuchishoTempEntity> entityList = mapper.select納入通知書発行後異動者(parameter);
        insert通知書発行後異動者(帳票作成日時, 帳票ID, entityList);
    }

    /**
     * 最新調定日時を取得するメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @return YMDHMS 最新調定日時
     */
    public YMDHMS get最新調定日時(FlexibleYear 調定年度) {

        List<RString> 処理名リスト = new ArrayList<>();
        処理名リスト.add(ShoriName.過年度賦課.get名称());
        DbT7022ShoriDateKanriEntity dbt7022entity = 処理日付管理Dac.select最新の基準日(調定年度, 処理名リスト);
        if (dbt7022entity == null) {
            return null;
        }
        return dbt7022entity.getKijunTimestamp();
    }

    /**
     * 出力期リストを取得メソッドです。
     *
     * @param 出力期AsInt int
     * @return 出力期リスト List<Kitsuki>
     */
    public List<Kitsuki> get出力期リスト(int 出力期AsInt) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 期月リスト = 期月リスト_普徴.filtered本算定期間().subListBy期(出力期AsInt, 出力期AsInt);
        return 期月リスト.toList();
    }

    private IKozaSearchKey get口座Param() {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set基準日(FlexibleDate.EMPTY);
        return builder.build();
    }

    private RString get出力順(ReportId 帳票分類ID, RString 出力順ID) {

        if (RString.isNullOrEmpty(出力順ID)) {
            return RString.EMPTY;
        }
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, Long.parseLong(出力順ID.toString()));
        }
        if (outputOrder == null) {
            return RString.EMPTY;
        }
        RString 出力順 = RString.EMPTY;
        if (介護保険料額決定通知書_帳票分類ID.equals(帳票分類ID)) {
            出力順 = MyBatisOrderByClauseCreator.create(OutputOrderEnum.class, outputOrder);
        } else if (納入通知書本算定_帳票分類ID.equals(帳票分類ID)) {
            出力順 = MyBatisOrderByClauseCreator.create(NonyuOutputOrderEnum.class, outputOrder);
        }
        return 出力順;
    }

    private ChohyoSeigyoKyotsu load帳票制御共通(ReportId 帳票分類ID) {

        DbT7065ChohyoSeigyoKyotsuEntity entity = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoKyotsu(entity);
    }

    private List<RString> 決定出力条件リスト取得(RDate 発行日, RString 文書番号, RString 出力順ID, List<FlexibleYear> 賦課年度リスト) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_対象賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        for (int i = 0; i < 賦課年度リスト.size(); i++) {
            if (!isFlexibleYearNullOrEmpty(賦課年度リスト.get(i))) {
                if (i == 賦課年度リスト.size() - 1) {
                    builder.append(getWarekiYear(賦課年度リスト.get(i)));
                } else {
                    builder.append(getWarekiYear(賦課年度リスト.get(i))).append(RString.FULL_SPACE);
                }
            }
        }
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_文書番号).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(文書番号));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 介護保険料額決定通知書_帳票分類ID, Long.parseLong(出力順ID.toString()));
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

    private List<RString> 変更出力条件リスト取得(RDate 発行日, RString 文書番号,
            RString 出力順ID, List<FlexibleYear> 賦課年度リスト, RString 変更通知書出力対象区分) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_対象賦課年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        for (int i = 0; i < 賦課年度リスト.size(); i++) {
            if (!isFlexibleYearNullOrEmpty(賦課年度リスト.get(i))) {
                if (i == 賦課年度リスト.size() - 1) {
                    builder.append(getWarekiYear(賦課年度リスト.get(i)));
                } else {
                    builder.append(getWarekiYear(賦課年度リスト.get(i))).append(RString.FULL_SPACE);
                }
            }
        }
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_発行日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_文書番号).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE).concat(文書番号));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力対象).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(NotsuKozaShutsuryokuTaisho.toValue(変更通知書出力対象区分).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(FORMAT_LEFT.concat(定数_出力順).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE));
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 介護保険料額決定通知書_帳票分類ID, Long.parseLong(出力順ID.toString()));
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

    private RString get帳票名_介護保険料額決定通知書(RString 帳票ID) {

        if (ReportIdDBB.DBB100039.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100039.getReportName();
        } else if (ReportIdDBB.DBB100040.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100040.getReportName();
        } else if (ReportIdDBB.DBB100041.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100041.getReportName();
        } else if (ReportIdDBB.DBB100042.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100042.getReportName();
        } else if (ReportIdDBB.DBB100043.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100043.getReportName();
        } else if (ReportIdDBB.DBB100044.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100044.getReportName();
        }

        return RString.EMPTY;
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト, ReportId 帳票ID, RString 出力ページ数,
            RString csv出力有無, RString csvファイル名, RString 帳票名) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
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

    private RString getWarekiYear(FlexibleYear date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(年度);
        }
        return wareki;
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

    private List<NokiJoho> get期月リスト(FlexibleYear 調定年度, int 出力期AsInt) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        FukaNokiResearcher fukaNokiResearcher = new FukaNokiResearcher(new RYear(調定年度.toDateString()));
        List<Noki> 普徴納期List = fukaNokiResearcher.get普徴納期ALL();
        KitsukiList 期月リスト = 期月リスト_普徴.filtered本算定期間().subListBy期(出力期AsInt, 出力期AsInt);
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

    private List<RString> 納入出力条件リスト取得(RDate 発行日, RString 出力期, RString 納入通知書対象者,
            RString 口座振替分出力様式, RString 生活保護者先頭出力区分, RString 山分け区分) {

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
        builder.append(FORMAT_LEFT.concat(定数_口座振替者).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(KozaFurikaeOutputType.toValue(口座振替分出力様式).get名称()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        if (定値区分_0.equals(生活保護者先頭出力区分)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_しない));
        } else if (定値区分_1.equals(生活保護者先頭出力区分)) {
            builder.append(FORMAT_LEFT.concat(定数_生活保護対象者をまとめて先頭に出力).concat(FORMAT_RIGHT)
                    .concat(RString.FULL_SPACE).concat(定値_する));
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

    private RString get帳票名_本算定保険料納入通知書(RString 帳票ID) {
        if (ReportIdDBB.DBB100066.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100066.getReportName();
        } else if (ReportIdDBB.DBB100069.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100069.getReportName();
        } else if (ReportIdDBB.DBB100070.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100070.getReportName();
        } else if (ReportIdDBB.DBB100071.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100071.getReportName();
        } else if (ReportIdDBB.DBB100072.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100072.getReportName();
        } else if (ReportIdDBB.DBB100073.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100073.getReportName();
        } else if (ReportIdDBB.DBB100075.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100075.getReportName();
        } else if (ReportIdDBB.DBB100076.getReportId().getColumnValue().equals(帳票ID)) {
            return ReportIdDBB.DBB100076.getReportName();
        }
        return RString.EMPTY;
    }

    private RString get出力ページ数(SourceDataCollection sourceDataCollection) {
        if (!sourceDataCollection.iterator().hasNext()) {
            return 定値区分_0;
        }
        int pageCount = 0;
        Iterator<SourceData> sourceDataList = sourceDataCollection.iterator();
        while (sourceDataList.hasNext()) {
            SourceData sourceData = sourceDataList.next();
            pageCount = pageCount + sourceData.getPageCount();
        }
        return new RString(pageCount);
    }

    private boolean isFlexibleYearNullOrEmpty(FlexibleYear data) {
        return data == null || RString.EMPTY.equals(new RString(data.toString()));
    }

}
