package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinsei;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyoshinsei.ShinsakaishukeihyoShinseiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyoshinsei.ShinsakaiShukeihyoShinseiReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（申請区分別）の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaiShukeihyoShinseiBetsuProcess extends BatchKeyBreakBase<ShinsakaiShukeihyoShinseiBetsuEntity> {

    private static final RString SELECT_SHUKEIHYO = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsakaiShukeihyoShinseiBetsu");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsakaiShukeihyoShinseiReportSource.ReportSourceFields.shichosonName.name())));
    private static final RString 帳票タイトル = new RString("介護認定審査会集計表（申請区分別）");
    private static final RString JIGYOJYOKYOHOKOKU = new RString("【事業状況報告出力区分】");
    private static final RString JISSIJYOKYOTOKEI = new RString("【実施状況統計出力区分】");
    private static final RString SINSAHANTEIJYOKYO = new RString("【審査判定状況出力区分】");
    private static final RString SINSAKAIKANRENTOKEI = new RString("【審査会関連統計資料作成出力区分】");
    private static final RString CSVSHUTSURYOKU = new RString("【CSV出力区分】");
    private static final RString SHUTSURYOKUFAIRU = new RString("【出力ファイル名】");
    private static final RString HOKENSYANO = new RString("【保険者番号】");
    private static final RString HIHOKENSYAKUBUN = new RString("【被保険者区分】");
    private static final RString GOGITAINO = new RString("【合議体番号】");
    private static final RString TAISHOTSUKIKUBUN = new RString("【対象月編集区分】");
    private static final RString TAISHOYM = new RString("【対象年月】");
    private static final RString KIJYUNYMD = new RString("【基準年月日】");
    private static final RString TAISHOGEPPIKUBUN = new RString("【対象月日編集区分】");
    private static final RString TAISHOGEPPIFROM = new RString("【対象月日開始】");
    private static final RString TAISHOGEPPITO = new RString("【対象月日終了】");
    private static final RString SINSEIKUBUNSINSEITOKI = new RString("【申請区分(申請時)】");
    private static final RString SINSEIKUBUNHOREI = new RString("【申請区分(法令)】");
    private static final RString から = new RString("～");
    private static final RString 開始期間 = new RString("最初から");
    private static final RString 終了期間 = new RString("最終まで");
    private static final int 申請区分申請時 = 1;
    private static final int 申請区分法令 = 2;
    private static final int 申請区分申請時法令 = 3;
    private static final int 認定受付 = 0;
    private static final int 認定調査 = 1;
    private static final int 認定意見書 = 2;
    private static final int 認定審査会 = 3;
    private static final int 認定二次判定 = 4;
    private ShinsakaiShukeihyoShinseiBetsuProcessParameter parameter;
    private ShinsakaiShukeihyoShinsei shukeihyoShinseiBetsu;
    private boolean isデータあり;

    @BatchWriter
    private BatchReportWriter<ShinsakaiShukeihyoShinseiReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaiShukeihyoShinseiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        shukeihyoShinseiBetsu = new ShinsakaiShukeihyoShinsei();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHUKEIHYO, parameter.toShinsakaiShukeihyoShinseiBetsuMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701008.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsakaiShukeihyoShinseiReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiShukeihyoShinseiBetsuEntity headerJoho) {
        if (hasBrek(getBefore(), headerJoho)) {
            shukeihyoShinseiBetsu.setタイトル(帳票タイトル);
            shukeihyoShinseiBetsu.set抽出期間(get抽出期間());
            shukeihyoShinseiBetsu.set発行日時(RDateTime.now());
            set申請区分申請時合計();
            set申請区分法令合計();
            ShinsakaishukeihyoShinseiReport report = new ShinsakaishukeihyoShinseiReport(shukeihyoShinseiBetsu);
            report.writeBy(reportSourceWriter);
            shukeihyoShinseiBetsu = new ShinsakaiShukeihyoShinsei();
        }
    }

    @Override
    protected void usualProcess(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        isデータあり = true;
        if (申請区分申請時 == current.getNiTeiShinseiKubun()) {
            set申請区分申請時新規申請(current);
            set申請区分申請時更新申請(current);
            set申請区分申請時区分変更申請(current);
            set申請区分申請時転入申請(current);
        }
        if (申請区分法令 == current.getNiTeiShinseiKubun()) {
            set申請区分法令新規申請(current);
            set申請区分法令更新申請(current);
            set申請区分法令区分変更申請(current);
            set申請区分法令転入申請();
        }
        if (申請区分申請時法令 == current.getNiTeiShinseiKubun()) {
            set法令新規申請申請時(current);
            set法令更新申請申請時(current);
            set法令区分変更申請申請時(current);
            set法令区変却下申請時(current);
        }
        shukeihyoShinseiBetsu.set市町村名称(current.getShichosonMeisho());
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            shukeihyoShinseiBetsu.setタイトル(帳票タイトル);
            shukeihyoShinseiBetsu.set抽出期間(get抽出期間());
            shukeihyoShinseiBetsu.set発行日時(RDateTime.now());
            set申請区分申請時合計();
            set申請区分法令合計();
            ShinsakaishukeihyoShinseiReport report = new ShinsakaishukeihyoShinseiReport(shukeihyoShinseiBetsu);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyo();
    }

    private boolean hasBrek(ShinsakaiShukeihyoShinseiBetsuEntity before, ShinsakaiShukeihyoShinseiBetsuEntity current) {
        return !before.getShichosonCode().equals(current.getShichosonCode());
    }

    private RString get抽出期間() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.isTaishoTsukiKubun()) {
            RYearMonth 対象年月 = new RYearMonth(parameter.getTaishoNendoYM());
            builder.append(dateForMat(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 1)));
            builder.append(から);
            builder.append(dateForMat(new RDate(対象年月.getYearValue(), 対象年月.getMonthValue(), 対象年月.getLastDay())));
        } else {
            if (!parameter.isEmptyTaishoGeppiFrom() && !parameter.isEmptyTaishoGeppiTo()) {
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiFrom().toString())));
                builder.append(から);
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiTo().toString())));
            } else if (parameter.isEmptyTaishoGeppiFrom()) {
                builder.append(開始期間);
                builder.append(から);
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiTo().toString())));
            } else {
                builder.append(dateForMat(new RDate(parameter.getTaishoGeppiFrom().toString())));
                builder.append(から);
                builder.append(終了期間);
            }
        }
        return builder.toRString();
    }

    private void set申請区分申請時新規申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_新規申請_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時更新申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_更新申請_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時区分変更申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_区分変更申請_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時転入申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set申_転入_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分申請時合計() {
        shukeihyoShinseiBetsu.set申_合計_受付数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_受付数())));
        shukeihyoShinseiBetsu.set申_合計_調査数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_調査数())));
        shukeihyoShinseiBetsu.set申_合計_意見書数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_意見書数())));
        shukeihyoShinseiBetsu.set申_合計_審査会数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_審査会数())));
        shukeihyoShinseiBetsu.set申_合計_二次判定数(new RString(
                toInt(shukeihyoShinseiBetsu.get申_新規申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get申_更新申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get申_区分変更申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get申_転入_二次判定数())));
    }

    private void set申請区分法令新規申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_新規申請_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分法令更新申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_更新申請_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分法令区分変更申請(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定受付 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_受付数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定調査 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_調査数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定意見書 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_意見書数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定審査会 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_審査会数(new RString(current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && 認定二次判定 == current.getNiTeiJokyo()) {
            shukeihyoShinseiBetsu.set法_区分変更申請_二次判定数(new RString(current.getCountHihokenshaNo()));
        }
    }

    private void set申請区分法令転入申請() {
        shukeihyoShinseiBetsu.set法_転入_受付数(RString.EMPTY);
        shukeihyoShinseiBetsu.set法_転入_調査数(RString.EMPTY);
        shukeihyoShinseiBetsu.set法_転入_意見書数(RString.EMPTY);
        shukeihyoShinseiBetsu.set法_転入_審査会数(RString.EMPTY);
        shukeihyoShinseiBetsu.set法_転入_二次判定数(RString.EMPTY);
    }

    private void set申請区分法令合計() {
        shukeihyoShinseiBetsu.set法_合計_受付数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_受付数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_受付数())));
        shukeihyoShinseiBetsu.set法_合計_調査数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_調査数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_調査数())));
        shukeihyoShinseiBetsu.set法_合計_意見書数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_意見書数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_意見書数())));
        shukeihyoShinseiBetsu.set法_合計_審査会数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_審査会数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_審査会数())));
        shukeihyoShinseiBetsu.set法_合計_二次判定数(new RString(
                toInt(shukeihyoShinseiBetsu.get法_新規申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get法_更新申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get法_区分変更申請_二次判定数())
                + toInt(shukeihyoShinseiBetsu.get法_転入_二次判定数())));
    }

    private void set法令新規申請申請時(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_新規申請_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_新規申請_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_新規申請_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_新規申請_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.新規申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_新規申請_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_新規申請_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void set法令更新申請申請時(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_更新申請_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_更新申請_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_更新申請_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_更新申請_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.更新申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_更新申請_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_更新申請_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void set法令区分変更申請申請時(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区分変更申請_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区分変更申請_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区分変更申請_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区分変更申請_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区分変更申請_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区分変更申請_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void set法令区変却下申請時(ShinsakaiShukeihyoShinseiBetsuEntity current) {
        if (NinteiShinseiHoreiCode.職権.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区変却下_申_新規申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区変却下_申_新規申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.職権.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区変却下_申_更新申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区変却下_申_更新申請()) + current.getCountHihokenshaNo()));
        }
        if (NinteiShinseiHoreiCode.職権.getコード().equals(current.getNinteiShinseiHoreiKubunCode().value())
                && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(current.getNinteiShinseiShinseijiKubunCode().value())) {
            shukeihyoShinseiBetsu.set法_区変却下_申_区分変更申請(new RString(
                    toInt(shukeihyoShinseiBetsu.get法_区変却下_申_区分変更申請()) + current.getCountHihokenshaNo()));
        }
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE701008.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票タイトル,
                new RString(reportSourceWriter.pageCount().value()),
                new RString("無し"),
                new RString("ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(JIGYOJYOKYOHOKOKU);
        条件.append(parameter.isJigyoJyokyoHokoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(JISSIJYOKYOTOKEI);
        条件.append(parameter.isJissiJyokyoTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAHANTEIJYOKYO);
        条件.append(parameter.isSinsaHanteiJyokyo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAKAIKANRENTOKEI);
        条件.append(parameter.isSinsakaiKanrenTokei());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(CSVSHUTSURYOKU);
        条件.append(parameter.isCsvShutsuryoku());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SHUTSURYOKUFAIRU);
        条件.append(parameter.getShutsuryokuFairuName());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HOKENSYANO);
        条件.append(parameter.getHokensyaNo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HIHOKENSYAKUBUN);
        条件.append(HihokenshaKubun.toValue(parameter.getHihokenshaKubun()).get名称());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(GOGITAINO);
        条件.append(parameter.isEmptyGogitaiNo() ? RString.EMPTY : new RString(parameter.getGogitaiNo()));
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOTSUKIKUBUN);
        条件.append(parameter.isTaishoTsukiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOYM);
        条件.append(!parameter.isTaishoTsukiKubun() ? RString.EMPTY
                : new RYearMonth(parameter.getTaishoNendoYM()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(KIJYUNYMD);
        条件.append(parameter.getKijyunYMD() == null ? RString.EMPTY : parameter.getKijyunYMD().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIKUBUN);
        条件.append(parameter.isTaishoGeppiKubun());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIFROM);
        条件.append(parameter.isEmptyTaishoGeppiFrom() ? RString.EMPTY
                : new RDate(parameter.getTaishoGeppiFrom().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPITO);
        条件.append(parameter.isEmptyTaishoGeppiTo() ? RString.EMPTY
                : new RDate(parameter.getTaishoGeppiTo().toString()).toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNSINSEITOKI);
        条件.append(parameter.isShinseiji());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNHOREI);
        条件.append(parameter.isHorei());
        出力条件.add(条件.toRString());
        return 出力条件;
    }

    private RString dateForMat(RDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private int toInt(RString 保険者数) {
        return RString.isNullOrEmpty(保険者数) ? 0 : Integer.parseInt(保険者数.toString());
    }

}
