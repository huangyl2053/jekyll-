/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuiraikin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のPrintServiceです。
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranPrintService {

    private static final ReportId 特別徴収開始通知書仮算定_帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param 賦課の情報一時Entity DbT2002FukaJohoTempTableEntity
     * @param 宛名 IKojin
     * @param 年金特徴回付情報 NenkinTokuchoKaifuJoho
     * @param 徴収方法 ChoshuHoho
     * @param 出力順ID RString
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 RDateTime
     * @param 保険料段階 HokenryoDankai
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 本算定Flag boolean
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaitsu(DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity,
            IKojin 宛名, NenkinTokuchoKaifuJoho 年金特徴回付情報, ChoshuHoho 徴収方法,
            RString 出力順ID, FlexibleYear 賦課年度, RDateTime 調定日時,
            HokenryoDankai 保険料段階, ChohyoSeigyoKyotsu 帳票制御共通, boolean 本算定Flag) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printFukusu(賦課の情報一時Entity, 宛名, 年金特徴回付情報, 徴収方法,
                    出力順ID, 賦課年度, 調定日時, 保険料段階, 帳票制御共通, 本算定Flag, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 本算定異動（過年度）結果一覧表 printメソッド(複数帳票出力用)
     *
     * @param 賦課の情報一時Entity DbT2002FukaJohoTempTableEntity
     * @param 宛名 IKojin
     * @param 年金特徴回付情報 NenkinTokuchoKaifuJoho
     * @param 徴収方法 ChoshuHoho
     * @param 出力順ID RString
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 RDateTime
     * @param 保険料段階 HokenryoDankai
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 本算定Flag boolean
     * @param reportManager ReportManager
     */
    public void printFukusu(DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity,
            IKojin 宛名, NenkinTokuchoKaifuJoho 年金特徴回付情報, ChoshuHoho 徴収方法,
            RString 出力順ID, FlexibleYear 賦課年度, RDateTime 調定日時,
            HokenryoDankai 保険料段階, ChohyoSeigyoKyotsu 帳票制御共通, boolean 本算定Flag, ReportManager reportManager) {
        IOutputOrder 並び順 = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定_帳票分類ID, Long.parseLong(出力順ID.toString()));
        }
        TokubetsuChoshuIraikingakuMeisaiIchiranProperty property = new TokubetsuChoshuIraikingakuMeisaiIchiranProperty(並び順);
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体 = associationFinder.getAssociation();
        try (ReportAssembler<TokubetsuChoshuIraikingakuMeisaiIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuIraikingakuMeisaiIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            int i = 0;
            List<RString> 改頁項目リスト = new ArrayList<>();
            List<RString> 出力項目リスト = new ArrayList<>();
            if (並び順 != null) {
                for (ISetSortItem item : 並び順.get設定項目リスト()) {
                    if (item.is改頁項目()) {
                        改頁項目リスト.add(item.get項目名());
                    }
                    出力項目リスト.add(item.get項目名());
                    i = i + 1;
                }
            }
            new TokubetsuChoshuIraikingakuMeisaiIchiranReport(賦課の情報一時Entity,
                    宛名, 年金特徴回付情報, 徴収方法, 出力項目リスト, 改頁項目リスト,
                    賦課年度, 調定日時, 地方公共団体, 保険料段階, 帳票制御共通, 本算定Flag)
                    .writeBy(reportSourceWriter);
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}
