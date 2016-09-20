package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeiGenzainojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaiShukeihyoGenzaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoReportSource;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（現在の状況別）の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaiShukeiGenzainojokyoProcess extends BatchKeyBreakBase<ShinsakaiShukeihyoGenzaiEntity> {

    private static final RString SELECT_GENZAINOJOKYO = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getShinsakaiShukeiGenzainojokyo");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsakaiShukeiGenzainojokyoReportSource.ReportSourceFields.shichosonName.name())));
    private static final RString タイトル = new RString("介護認定審査会集計表（現在の状況別）");
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
    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString パーセント = new RString("%");
    private static final RString 上段なし = new RString("0.00%");
    private static final RString 全て = new RString("100%");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final int 新規申請 = 0;
    private static final int 更新申請 = 1;
    private static final int 区分変更申請 = 2;
    private static final int 転入 = 3;
    private static final int 有効期間6ヶ月 = 0;
    private static final int 有効期間12ヶ月 = 1;
    private static final int 有効期間24ヶ月 = 2;
    private static final int 有効期間その他 = 3;
    private static final int ひゃく = 100;
    private ShinsakaiShukeiGenzainojokyoProcessParameter parameter;
    private ShinsakaiShukeiGenzainojokyoEntity genzainojokyo;
    private boolean isデータあり;
    @BatchWriter
    private BatchReportWriter<ShinsakaiShukeiGenzainojokyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaiShukeiGenzainojokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        genzainojokyo = new ShinsakaiShukeiGenzainojokyoEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_GENZAINOJOKYO, parameter.toShinsakaiShukeiGenzainojokyoMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE701009.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsakaiShukeiGenzainojokyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiShukeihyoGenzaiEntity current) {
        if (hasBrek(getBefore(), current)) {
            setヘッダー項目();
            ShinsakaiShukeiGenzainojokyoReport report = new ShinsakaiShukeiGenzainojokyoReport(genzainojokyo);
            report.writeBy(reportSourceWriter);
            genzainojokyo = new ShinsakaiShukeiGenzainojokyoEntity();
        }
    }

    @Override
    protected void usualProcess(ShinsakaiShukeihyoGenzaiEntity current) {
        isデータあり = true;
        set市町村(current);
        if (新規申請 == current.getShinseiKubun()) {
            set新規申請(current);
        } else if (更新申請 == current.getShinseiKubun()) {
            set更新申請(current);
        } else if (区分変更申請 == current.getShinseiKubun()) {
            set区分変更申請(current);
        } else if (転入 == current.getShinseiKubun()) {
            set転入(current);
        }
        set全体6ヶ月();
        set全体12ヶ月();
        set全体24ヶ月();
        set全体その他();
        set全体合計();
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            setヘッダー項目();
            ShinsakaiShukeiGenzainojokyoReport report = new ShinsakaiShukeiGenzainojokyoReport(genzainojokyo);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyo();
    }

    private boolean hasBrek(ShinsakaiShukeihyoGenzaiEntity before, ShinsakaiShukeihyoGenzaiEntity current) {
        return !(before.getShichosonCode().equals(current.getShichosonCode()));
    }

    private void setヘッダー項目() {
        genzainojokyo.setタイトル(タイトル);
        set有効基準年月日();
        genzainojokyo.set発行日時(get発行日時());
    }

    private void set新規申請(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set新規申請6ヶ月(entity);
        } else if (有効期間12ヶ月 == entity.getYukoKikan()) {
            set新規申請12ヶ月(entity);
        } else if (有効期間24ヶ月 == entity.getYukoKikan()) {
            set新規申請24ヶ月(entity);
        } else if (有効期間その他 == entity.getYukoKikan()) {
            set新規申請その他(entity);
        }
        set新規合計_上段();
        set新規合計_下段();
    }

    private void set更新申請(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set更新申請6ヶ月(entity);
        } else if (有効期間12ヶ月 == entity.getYukoKikan()) {
            set更新申請12ヶ月(entity);
        } else if (有効期間24ヶ月 == entity.getYukoKikan()) {
            set更新申請24ヶ月(entity);
        } else if (有効期間その他 == entity.getYukoKikan()) {
            set更新申請その他(entity);
        }
        set更新合計_上段();
        set更新合計_下段();
    }

    private void set区分変更申請(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set区分変更申請6ヶ月(entity);
        } else if (有効期間12ヶ月 == entity.getYukoKikan()) {
            set区分変更申請12ヶ月(entity);
        } else if (有効期間24ヶ月 == entity.getYukoKikan()) {
            set区分変更申請24ヶ月(entity);
        } else if (有効期間その他 == entity.getYukoKikan()) {
            set区分変更申請その他(entity);
        }
        set区分変更合計_上段();
        set区分変更合計_下段();
    }

    private void set転入(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set転入申請6ヶ月(entity);
        } else if (有効期間その他 == entity.getYukoKikan()) {
            set転入申請その他(entity);
        }
        set転入合計_上段();
        set転入合計_下段();
    }

    private void set新規申請6ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set新規6ヶ月_計_上段();
        genzainojokyo.set新規6ヶ月_要支援1_下段(format下段(genzainojokyo.get新規6ヶ月_要支援1_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要支援2_下段(format下段(genzainojokyo.get新規6ヶ月_要支援2_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護1_下段(format下段(genzainojokyo.get新規6ヶ月_要介護1_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護2_下段(format下段(genzainojokyo.get新規6ヶ月_要介護2_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護3_下段(format下段(genzainojokyo.get新規6ヶ月_要介護3_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護4_下段(format下段(genzainojokyo.get新規6ヶ月_要介護4_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護5_下段(format下段(genzainojokyo.get新規6ヶ月_要介護5_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_計_下段(全て);
    }

    private void set新規6ヶ月_計_上段() {
        genzainojokyo.set新規6ヶ月_計_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規6ヶ月_要介護5_上段())));
    }

    private void set新規申請12ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set新規12ヶ月_計_上段();
        genzainojokyo.set新規12ヶ月_要支援1_下段(format下段(genzainojokyo.get新規12ヶ月_要支援1_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要支援2_下段(format下段(genzainojokyo.get新規12ヶ月_要支援2_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護1_下段(format下段(genzainojokyo.get新規12ヶ月_要介護1_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護2_下段(format下段(genzainojokyo.get新規12ヶ月_要介護2_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護3_下段(format下段(genzainojokyo.get新規12ヶ月_要介護3_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護4_下段(format下段(genzainojokyo.get新規12ヶ月_要介護4_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護5_下段(format下段(genzainojokyo.get新規12ヶ月_要介護5_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_計_下段(全て);
    }

    private void set新規12ヶ月_計_上段() {
        genzainojokyo.set新規12ヶ月_計_上段(new RString(toInt(genzainojokyo.get新規12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規12ヶ月_要介護5_上段())));
    }

    private void set新規申請24ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set新規24ヶ月_計_上段();
        genzainojokyo.set新規24ヶ月_要支援1_下段(format下段(genzainojokyo.get新規24ヶ月_要支援1_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要支援2_下段(format下段(genzainojokyo.get新規24ヶ月_要支援2_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護1_下段(format下段(genzainojokyo.get新規24ヶ月_要介護1_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護2_下段(format下段(genzainojokyo.get新規24ヶ月_要介護2_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護3_下段(format下段(genzainojokyo.get新規24ヶ月_要介護3_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護4_下段(format下段(genzainojokyo.get新規24ヶ月_要介護4_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護5_下段(format下段(genzainojokyo.get新規24ヶ月_要介護5_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_計_下段(全て);
    }

    private void set新規24ヶ月_計_上段() {
        genzainojokyo.set新規24ヶ月_計_上段(new RString(toInt(genzainojokyo.get新規24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規24ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規24ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規24ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護5_上段())));
    }

    private void set新規申請その他(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set新規その他_計_上段();
        genzainojokyo.set新規その他_要支援1_下段(format下段(genzainojokyo.get新規その他_要支援1_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要支援2_下段(format下段(genzainojokyo.get新規その他_要支援2_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護1_下段(format下段(genzainojokyo.get新規その他_要介護1_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護2_下段(format下段(genzainojokyo.get新規その他_要介護2_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護3_下段(format下段(genzainojokyo.get新規その他_要介護3_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護4_下段(format下段(genzainojokyo.get新規その他_要介護4_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護5_下段(format下段(genzainojokyo.get新規その他_要介護5_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_計_下段(全て);
    }

    private void set新規その他_計_上段() {
        genzainojokyo.set新規その他_計_上段(new RString(toInt(genzainojokyo.get新規その他_要支援1_上段())
                + toInt(genzainojokyo.get新規その他_要支援2_上段()) + toInt(genzainojokyo.get新規その他_要介護1_上段())
                + toInt(genzainojokyo.get新規その他_要介護2_上段()) + toInt(genzainojokyo.get新規その他_要介護3_上段())
                + toInt(genzainojokyo.get新規その他_要介護4_上段()) + toInt(genzainojokyo.get新規その他_要介護5_上段())));
    }

    private void set新規合計_上段() {
        genzainojokyo.set新規合計_要支援1_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要支援1_上段()) + toInt(genzainojokyo.get新規24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規その他_要支援1_上段())));
        genzainojokyo.set新規合計_要支援2_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get新規その他_要支援2_上段())));
        genzainojokyo.set新規合計_要介護1_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護1_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規その他_要介護1_上段())));
        genzainojokyo.set新規合計_要介護2_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get新規その他_要介護2_上段())));
        genzainojokyo.set新規合計_要介護3_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護3_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規その他_要介護3_上段())));
        genzainojokyo.set新規合計_要介護4_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get新規その他_要介護4_上段())));
        genzainojokyo.set新規合計_要介護5_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護5_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get新規その他_要介護5_上段())));
        genzainojokyo.set新規合計_計_上段(new RString(toInt(genzainojokyo.get新規合計_要支援1_上段())
                + toInt(genzainojokyo.get新規合計_要支援2_上段()) + toInt(genzainojokyo.get新規合計_要介護1_上段())
                + toInt(genzainojokyo.get新規合計_要介護2_上段()) + toInt(genzainojokyo.get新規合計_要介護3_上段())
                + toInt(genzainojokyo.get新規合計_要介護4_上段()) + toInt(genzainojokyo.get新規合計_要介護5_上段())));
    }

    private void set新規合計_下段() {
        genzainojokyo.set新規合計_要支援1_下段(format下段(genzainojokyo.get新規合計_要支援1_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要支援2_下段(format下段(genzainojokyo.get新規合計_要支援2_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護1_下段(format下段(genzainojokyo.get新規合計_要介護1_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護2_下段(format下段(genzainojokyo.get新規合計_要介護2_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護3_下段(format下段(genzainojokyo.get新規合計_要介護3_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護4_下段(format下段(genzainojokyo.get新規合計_要介護4_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護5_下段(format下段(genzainojokyo.get新規合計_要介護5_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_計_下段(全て);
    }

    private void set更新申請6ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set更新6ヶ月_計_上段();
        genzainojokyo.set更新6ヶ月_要支援1_下段(format下段(genzainojokyo.get更新6ヶ月_要支援1_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要支援2_下段(format下段(genzainojokyo.get更新6ヶ月_要支援2_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護1_下段(format下段(genzainojokyo.get更新6ヶ月_要介護1_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護2_下段(format下段(genzainojokyo.get更新6ヶ月_要介護2_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護3_下段(format下段(genzainojokyo.get更新6ヶ月_要介護3_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護4_下段(format下段(genzainojokyo.get更新6ヶ月_要介護4_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護5_下段(format下段(genzainojokyo.get更新6ヶ月_要介護5_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_計_下段(全て);
    }

    private void set更新6ヶ月_計_上段() {
        genzainojokyo.set更新6ヶ月_計_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新6ヶ月_要介護5_上段())));
    }

    private void set更新申請12ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set更新12ヶ月_計_上段();
        genzainojokyo.set更新12ヶ月_要支援1_下段(format下段(genzainojokyo.get更新12ヶ月_要支援1_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要支援2_下段(format下段(genzainojokyo.get更新12ヶ月_要支援2_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護1_下段(format下段(genzainojokyo.get更新12ヶ月_要介護1_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護2_下段(format下段(genzainojokyo.get更新12ヶ月_要介護2_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護3_下段(format下段(genzainojokyo.get更新12ヶ月_要介護3_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護4_下段(format下段(genzainojokyo.get更新12ヶ月_要介護4_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護5_下段(format下段(genzainojokyo.get更新12ヶ月_要介護5_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_計_下段(全て);
    }

    private void set更新12ヶ月_計_上段() {
        genzainojokyo.set更新12ヶ月_計_上段(new RString(toInt(genzainojokyo.get更新12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新12ヶ月_要介護5_上段())));
    }

    private void set更新申請24ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set更新24ヶ月_計_上段();
        genzainojokyo.set更新24ヶ月_要支援1_下段(format下段(genzainojokyo.get更新24ヶ月_要支援1_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要支援2_下段(format下段(genzainojokyo.get更新24ヶ月_要支援2_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護1_下段(format下段(genzainojokyo.get更新24ヶ月_要介護1_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護2_下段(format下段(genzainojokyo.get更新24ヶ月_要介護2_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護3_下段(format下段(genzainojokyo.get更新24ヶ月_要介護3_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護4_下段(format下段(genzainojokyo.get更新24ヶ月_要介護4_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護5_下段(format下段(genzainojokyo.get更新24ヶ月_要介護5_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_計_下段(全て);
    }

    private void set更新24ヶ月_計_上段() {
        genzainojokyo.set更新24ヶ月_計_上段(new RString(toInt(genzainojokyo.get更新24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護5_上段())));
    }

    private void set更新申請その他(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set更新その他_計_上段();
        genzainojokyo.set更新その他_要支援1_下段(format下段(genzainojokyo.get更新その他_要支援1_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要支援2_下段(format下段(genzainojokyo.get更新その他_要支援2_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護1_下段(format下段(genzainojokyo.get更新その他_要介護1_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護2_下段(format下段(genzainojokyo.get更新その他_要介護2_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護3_下段(format下段(genzainojokyo.get更新その他_要介護3_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護4_下段(format下段(genzainojokyo.get更新その他_要介護4_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護5_下段(format下段(genzainojokyo.get更新その他_要介護5_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_計_下段(全て);
    }

    private void set更新その他_計_上段() {
        genzainojokyo.set更新その他_計_上段(new RString(toInt(genzainojokyo.get更新その他_要支援1_上段())
                + toInt(genzainojokyo.get更新その他_要支援2_上段()) + toInt(genzainojokyo.get更新その他_要介護1_上段())
                + toInt(genzainojokyo.get更新その他_要介護2_上段()) + toInt(genzainojokyo.get更新その他_要介護3_上段())
                + toInt(genzainojokyo.get更新その他_要介護4_上段()) + toInt(genzainojokyo.get更新その他_要介護5_上段())));
    }

    private void set更新合計_上段() {
        genzainojokyo.set更新合計_要支援1_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援1_上段()) + toInt(genzainojokyo.get更新24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新その他_要支援1_上段())));
        genzainojokyo.set更新合計_要支援2_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新その他_要支援2_上段())));
        genzainojokyo.set更新合計_要介護1_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護1_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新その他_要介護1_上段())));
        genzainojokyo.set更新合計_要介護2_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新その他_要介護2_上段())));
        genzainojokyo.set更新合計_要介護3_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護3_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新その他_要介護3_上段())));
        genzainojokyo.set更新合計_要介護4_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新その他_要介護4_上段())));
        genzainojokyo.set更新合計_要介護5_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護5_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新その他_要介護5_上段())));
        genzainojokyo.set更新合計_計_上段(new RString(toInt(genzainojokyo.get更新合計_要支援1_上段())
                + toInt(genzainojokyo.get更新合計_要支援2_上段()) + toInt(genzainojokyo.get更新合計_要介護1_上段())
                + toInt(genzainojokyo.get更新合計_要介護2_上段()) + toInt(genzainojokyo.get更新合計_要介護3_上段())
                + toInt(genzainojokyo.get更新合計_要介護4_上段()) + toInt(genzainojokyo.get更新合計_要介護5_上段())));
    }

    private void set更新合計_下段() {
        genzainojokyo.set更新合計_要支援1_下段(format下段(genzainojokyo.get更新合計_要支援1_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要支援2_下段(format下段(genzainojokyo.get更新合計_要支援2_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護1_下段(format下段(genzainojokyo.get更新合計_要介護1_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護2_下段(format下段(genzainojokyo.get更新合計_要介護2_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護3_下段(format下段(genzainojokyo.get更新合計_要介護3_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護4_下段(format下段(genzainojokyo.get更新合計_要介護4_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護5_下段(format下段(genzainojokyo.get更新合計_要介護5_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_計_下段(全て);
    }

    private void set区分変更申請6ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set区分変更6ヶ月_計_上段();
        genzainojokyo.set区分変更6ヶ月_要支援1_下段(format下段(genzainojokyo.get区分変更6ヶ月_要支援1_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要支援2_下段(format下段(genzainojokyo.get区分変更6ヶ月_要支援2_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護1_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護1_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護2_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護2_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護3_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護3_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護4_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護4_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護5_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護5_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_計_下段(全て);
    }

    private void set区分変更6ヶ月_計_上段() {
        genzainojokyo.set区分変更6ヶ月_計_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段())));
    }

    private void set区分変更申請12ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set区分変更12ヶ月_計_上段();
        genzainojokyo.set区分変更12ヶ月_要支援1_下段(format下段(genzainojokyo.get区分変更12ヶ月_要支援1_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要支援2_下段(format下段(genzainojokyo.get区分変更12ヶ月_要支援2_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護1_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護1_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護2_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護2_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護3_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護3_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護4_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護4_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護5_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護5_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_計_下段(全て);
    }

    private void set区分変更12ヶ月_計_上段() {
        genzainojokyo.set区分変更12ヶ月_計_上段(new RString(toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段())));
    }

    private void set区分変更申請24ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set区分変更24ヶ月_計_上段();
        genzainojokyo.set区分変更24ヶ月_要支援1_下段(format下段(genzainojokyo.get区分変更24ヶ月_要支援1_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要支援2_下段(format下段(genzainojokyo.get区分変更24ヶ月_要支援2_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護1_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護1_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護2_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護2_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護3_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護3_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護4_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護4_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護5_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護5_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_計_下段(全て);
    }

    private void set区分変更24ヶ月_計_上段() {
        genzainojokyo.set区分変更24ヶ月_計_上段(new RString(toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段())));
    }

    private void set区分変更申請その他(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set区分変更その他_計_上段();
        genzainojokyo.set区分変更その他_要支援1_下段(format下段(genzainojokyo.get区分変更その他_要支援1_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要支援2_下段(format下段(genzainojokyo.get区分変更その他_要支援2_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護1_下段(format下段(genzainojokyo.get区分変更その他_要介護1_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護2_下段(format下段(genzainojokyo.get区分変更その他_要介護2_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護3_下段(format下段(genzainojokyo.get区分変更その他_要介護3_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護4_下段(format下段(genzainojokyo.get区分変更その他_要介護4_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護5_下段(format下段(genzainojokyo.get区分変更その他_要介護5_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_計_下段(全て);
    }

    private void set区分変更その他_計_上段() {
        genzainojokyo.set区分変更その他_計_上段(new RString(toInt(genzainojokyo.get区分変更その他_要支援1_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援2_上段()) + toInt(genzainojokyo.get区分変更その他_要介護1_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護2_上段()) + toInt(genzainojokyo.get区分変更その他_要介護3_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護4_上段()) + toInt(genzainojokyo.get区分変更その他_要介護5_上段())));
    }

    private void set区分変更合計_上段() {
        genzainojokyo.set区分変更合計_要支援1_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援1_上段())));
        genzainojokyo.set区分変更合計_要支援2_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援2_上段())));
        genzainojokyo.set区分変更合計_要介護1_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護1_上段())));
        genzainojokyo.set区分変更合計_要介護2_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護2_上段())));
        genzainojokyo.set区分変更合計_要介護3_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護3_上段())));
        genzainojokyo.set区分変更合計_要介護4_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護4_上段())));
        genzainojokyo.set区分変更合計_要介護5_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護5_上段())));
        genzainojokyo.set区分変更合計_計_上段(new RString(toInt(genzainojokyo.get区分変更合計_要支援1_上段())
                + toInt(genzainojokyo.get区分変更合計_要支援2_上段()) + toInt(genzainojokyo.get区分変更合計_要介護1_上段())
                + toInt(genzainojokyo.get区分変更合計_要介護2_上段()) + toInt(genzainojokyo.get区分変更合計_要介護3_上段())
                + toInt(genzainojokyo.get区分変更合計_要介護4_上段()) + toInt(genzainojokyo.get区分変更合計_要介護5_上段())));
    }

    private void set区分変更合計_下段() {
        genzainojokyo.set区分変更合計_要支援1_下段(format下段(genzainojokyo.get区分変更合計_要支援1_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要支援2_下段(format下段(genzainojokyo.get区分変更合計_要支援2_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護1_下段(format下段(genzainojokyo.get区分変更合計_要介護1_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護2_下段(format下段(genzainojokyo.get区分変更合計_要介護2_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護3_下段(format下段(genzainojokyo.get区分変更合計_要介護3_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護4_下段(format下段(genzainojokyo.get区分変更合計_要介護4_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護5_下段(format下段(genzainojokyo.get区分変更合計_要介護5_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_計_下段(全て);
    }

    private void set転入申請6ヶ月(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set転入6ヶ月_計_上段();
        genzainojokyo.set転入6ヶ月_要支援1_下段(format下段(genzainojokyo.get転入6ヶ月_要支援1_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要支援2_下段(format下段(genzainojokyo.get転入6ヶ月_要支援2_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護1_下段(format下段(genzainojokyo.get転入6ヶ月_要介護1_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護2_下段(format下段(genzainojokyo.get転入6ヶ月_要介護2_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護3_下段(format下段(genzainojokyo.get転入6ヶ月_要介護3_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護4_下段(format下段(genzainojokyo.get転入6ヶ月_要介護4_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護5_下段(format下段(genzainojokyo.get転入6ヶ月_要介護5_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_計_下段(全て);
    }

    private void set転入6ヶ月_計_上段() {
        genzainojokyo.set転入6ヶ月_計_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get転入6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get転入6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get転入6ヶ月_要介護5_上段())));
    }

    private void set転入申請その他(ShinsakaiShukeihyoGenzaiEntity entity) {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要支援1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要支援2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護1_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護2_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護3_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護4_上段(toRString(entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護5_上段(toRString(entity.getCountHihokenshaNo()));
        }
        set転入その他_計_上段();
        genzainojokyo.set転入その他_要支援1_下段(format下段(genzainojokyo.get転入その他_要支援1_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要支援2_下段(format下段(genzainojokyo.get転入その他_要支援2_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護1_下段(format下段(genzainojokyo.get転入その他_要介護1_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護2_下段(format下段(genzainojokyo.get転入その他_要介護2_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護3_下段(format下段(genzainojokyo.get転入その他_要介護3_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護4_下段(format下段(genzainojokyo.get転入その他_要介護4_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護5_下段(format下段(genzainojokyo.get転入その他_要介護5_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_計_下段(全て);
    }

    private void set転入その他_計_上段() {
        genzainojokyo.set転入その他_計_上段(new RString(toInt(genzainojokyo.get転入その他_要支援1_上段())
                + toInt(genzainojokyo.get転入その他_要支援2_上段()) + toInt(genzainojokyo.get転入その他_要介護1_上段())
                + toInt(genzainojokyo.get転入その他_要介護2_上段()) + toInt(genzainojokyo.get転入その他_要介護3_上段())
                + toInt(genzainojokyo.get転入その他_要介護4_上段()) + toInt(genzainojokyo.get転入その他_要介護5_上段())));
    }

    private void set転入合計_上段() {
        genzainojokyo.set転入合計_要支援1_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get転入その他_要支援1_上段())));
        genzainojokyo.set転入合計_要支援2_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get転入その他_要支援2_上段())));
        genzainojokyo.set転入合計_要介護1_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get転入その他_要介護1_上段())));
        genzainojokyo.set転入合計_要介護2_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get転入その他_要介護2_上段())));
        genzainojokyo.set転入合計_要介護3_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get転入その他_要介護3_上段())));
        genzainojokyo.set転入合計_要介護4_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get転入その他_要介護4_上段())));
        genzainojokyo.set転入合計_要介護5_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get転入その他_要介護5_上段())));
        genzainojokyo.set転入合計_計_上段(new RString(toInt(genzainojokyo.get転入合計_要支援1_上段())
                + toInt(genzainojokyo.get転入合計_要支援2_上段()) + toInt(genzainojokyo.get転入合計_要介護1_上段())
                + toInt(genzainojokyo.get転入合計_要介護2_上段()) + toInt(genzainojokyo.get転入合計_要介護3_上段())
                + toInt(genzainojokyo.get転入合計_要介護4_上段()) + toInt(genzainojokyo.get転入合計_要介護5_上段())));
    }

    private void set転入合計_下段() {
        genzainojokyo.set転入合計_要支援1_下段(format下段(genzainojokyo.get転入合計_要支援1_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要支援2_下段(format下段(genzainojokyo.get転入合計_要支援2_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護1_下段(format下段(genzainojokyo.get転入合計_要介護1_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護2_下段(format下段(genzainojokyo.get転入合計_要介護2_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護3_下段(format下段(genzainojokyo.get転入合計_要介護3_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護4_下段(format下段(genzainojokyo.get転入合計_要介護4_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護5_下段(format下段(genzainojokyo.get転入合計_要介護5_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_計_下段(全て);
    }

    private void set全体6ヶ月() {
        genzainojokyo.set全体6ヶ月_要支援1_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要支援1_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要支援1_上段())));
        genzainojokyo.set全体6ヶ月_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要支援2_上段())));
        genzainojokyo.set全体6ヶ月_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護1_上段())));
        genzainojokyo.set全体6ヶ月_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護2_上段())));
        genzainojokyo.set全体6ヶ月_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護3_上段())));
        genzainojokyo.set全体6ヶ月_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護4_上段())));
        genzainojokyo.set全体6ヶ月_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護5_上段())));
        set全体6ヶ月_計_上段();
        genzainojokyo.set全体6ヶ月_要支援1_下段(format下段(genzainojokyo.get全体6ヶ月_要支援1_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要支援2_下段(format下段(genzainojokyo.get全体6ヶ月_要支援2_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護1_下段(format下段(genzainojokyo.get全体6ヶ月_要介護1_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護2_下段(format下段(genzainojokyo.get全体6ヶ月_要介護2_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護3_下段(format下段(genzainojokyo.get全体6ヶ月_要介護3_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護4_下段(format下段(genzainojokyo.get全体6ヶ月_要介護4_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護5_下段(format下段(genzainojokyo.get全体6ヶ月_要介護5_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_計_下段(全て);
    }

    private void set全体6ヶ月_計_上段() {
        genzainojokyo.set全体6ヶ月_計_上段(new RString(toInt(genzainojokyo.get全体6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護5_上段())));
    }

    private void set全体12ヶ月() {
        genzainojokyo.set全体12ヶ月_要支援1_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段())));
        genzainojokyo.set全体12ヶ月_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段())));
        genzainojokyo.set全体12ヶ月_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段())));
        genzainojokyo.set全体12ヶ月_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段())));
        genzainojokyo.set全体12ヶ月_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段())));
        genzainojokyo.set全体12ヶ月_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段())));
        genzainojokyo.set全体12ヶ月_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段())));
        set全体12ヶ月_計_上段();
        genzainojokyo.set全体12ヶ月_要支援1_下段(format下段(genzainojokyo.get全体12ヶ月_要支援1_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要支援2_下段(format下段(genzainojokyo.get全体12ヶ月_要支援2_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護1_下段(format下段(genzainojokyo.get全体12ヶ月_要介護1_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護2_下段(format下段(genzainojokyo.get全体12ヶ月_要介護2_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護3_下段(format下段(genzainojokyo.get全体12ヶ月_要介護3_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護4_下段(format下段(genzainojokyo.get全体12ヶ月_要介護4_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護5_下段(format下段(genzainojokyo.get全体12ヶ月_要介護5_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_計_下段(全て);
    }

    private void set全体12ヶ月_計_上段() {
        genzainojokyo.set全体12ヶ月_計_上段(new RString(toInt(genzainojokyo.get全体12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護5_上段())));
    }

    private void set全体24ヶ月() {
        genzainojokyo.set全体24ヶ月_要支援1_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段())));
        genzainojokyo.set全体24ヶ月_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段())));
        genzainojokyo.set全体24ヶ月_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段())));
        genzainojokyo.set全体24ヶ月_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段())));
        genzainojokyo.set全体24ヶ月_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段())));
        genzainojokyo.set全体24ヶ月_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段())));
        genzainojokyo.set全体24ヶ月_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段())));
        set全体24ヶ月_計_上段();
        genzainojokyo.set全体24ヶ月_要支援1_下段(format下段(genzainojokyo.get全体24ヶ月_要支援1_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要支援2_下段(format下段(genzainojokyo.get全体24ヶ月_要支援2_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護1_下段(format下段(genzainojokyo.get全体24ヶ月_要介護1_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護2_下段(format下段(genzainojokyo.get全体24ヶ月_要介護2_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護3_下段(format下段(genzainojokyo.get全体24ヶ月_要介護3_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護4_下段(format下段(genzainojokyo.get全体24ヶ月_要介護4_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護5_下段(format下段(genzainojokyo.get全体24ヶ月_要介護5_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_計_下段(全て);
    }

    private void set全体24ヶ月_計_上段() {
        genzainojokyo.set全体24ヶ月_計_上段(new RString(toInt(genzainojokyo.get全体24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護5_上段())));
    }

    private void set全体その他() {
        genzainojokyo.set全体その他_要支援1_上段(new RString(toInt(genzainojokyo.get新規その他_要支援1_上段())
                + toInt(genzainojokyo.get更新その他_要支援1_上段()) + toInt(genzainojokyo.get区分変更その他_要支援1_上段())
                + toInt(genzainojokyo.get転入その他_要支援1_上段())));
        genzainojokyo.set全体その他_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規その他_要支援2_上段())
                + toInt(genzainojokyo.get更新その他_要支援2_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援2_上段())
                + toInt(genzainojokyo.get転入その他_要支援2_上段())));
        genzainojokyo.set全体その他_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護1_上段())
                + toInt(genzainojokyo.get更新その他_要介護1_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護1_上段())
                + toInt(genzainojokyo.get転入その他_要介護1_上段())));
        genzainojokyo.set全体その他_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護2_上段())
                + toInt(genzainojokyo.get更新その他_要介護2_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護2_上段())
                + toInt(genzainojokyo.get転入その他_要介護2_上段())));
        genzainojokyo.set全体その他_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護3_上段())
                + toInt(genzainojokyo.get更新その他_要介護3_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護3_上段())
                + toInt(genzainojokyo.get転入その他_要介護3_上段())));
        genzainojokyo.set全体その他_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護4_上段())
                + toInt(genzainojokyo.get更新その他_要介護4_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護4_上段())
                + toInt(genzainojokyo.get転入その他_要介護4_上段())));
        genzainojokyo.set全体その他_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護5_上段())
                + toInt(genzainojokyo.get更新その他_要介護5_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護5_上段())
                + toInt(genzainojokyo.get転入その他_要介護5_上段())));
        set全体その他_計_上段();
        genzainojokyo.set全体その他_要支援1_下段(format下段(genzainojokyo.get全体その他_要支援1_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要支援2_下段(format下段(genzainojokyo.get全体その他_要支援2_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護1_下段(format下段(genzainojokyo.get全体その他_要介護1_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護2_下段(format下段(genzainojokyo.get全体その他_要介護2_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護3_下段(format下段(genzainojokyo.get全体その他_要介護3_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護4_下段(format下段(genzainojokyo.get全体その他_要介護4_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護5_下段(format下段(genzainojokyo.get全体その他_要介護5_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_計_下段(全て);
    }

    private void set全体その他_計_上段() {
        genzainojokyo.set全体その他_計_上段(new RString(toInt(genzainojokyo.get全体その他_要支援1_上段())
                + toInt(genzainojokyo.get全体その他_要支援2_上段())
                + toInt(genzainojokyo.get全体その他_要介護1_上段())
                + toInt(genzainojokyo.get全体その他_要介護2_上段())
                + toInt(genzainojokyo.get全体その他_要介護3_上段())
                + toInt(genzainojokyo.get全体その他_要介護4_上段())
                + toInt(genzainojokyo.get全体その他_要介護5_上段())));
    }

    private void set全体合計() {
        genzainojokyo.set全体合計_要支援1_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体その他_要支援1_上段())));
        genzainojokyo.set全体合計_要支援2_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体その他_要支援2_上段())));
        genzainojokyo.set全体合計_要介護1_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体その他_要介護1_上段())));
        genzainojokyo.set全体合計_要介護2_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体その他_要介護2_上段())));
        genzainojokyo.set全体合計_要介護3_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体その他_要介護3_上段())));
        genzainojokyo.set全体合計_要介護4_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体その他_要介護4_上段())));
        genzainojokyo.set全体合計_要介護5_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get全体その他_要介護5_上段())));
        set全体合計_計_上段();
        genzainojokyo.set全体合計_要支援1_下段(format下段(genzainojokyo.get全体合計_要支援1_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要支援2_下段(format下段(genzainojokyo.get全体合計_要支援2_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護1_下段(format下段(genzainojokyo.get全体合計_要介護1_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護2_下段(format下段(genzainojokyo.get全体合計_要介護2_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護3_下段(format下段(genzainojokyo.get全体合計_要介護3_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護4_下段(format下段(genzainojokyo.get全体合計_要介護4_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護5_下段(format下段(genzainojokyo.get全体合計_要介護5_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_計_下段(全て);
    }

    private void set全体合計_計_上段() {
        genzainojokyo.set全体合計_計_上段(new RString(
                toInt(genzainojokyo.get全体合計_要支援1_上段())
                + toInt(genzainojokyo.get全体合計_要支援2_上段())
                + toInt(genzainojokyo.get全体合計_要介護1_上段())
                + toInt(genzainojokyo.get全体合計_要介護2_上段())
                + toInt(genzainojokyo.get全体合計_要介護3_上段())
                + toInt(genzainojokyo.get全体合計_要介護4_上段())
                + toInt(genzainojokyo.get全体合計_要介護5_上段())));
    }

    private void set市町村(ShinsakaiShukeihyoGenzaiEntity entity) {
        genzainojokyo.set市町村コード(entity.getShichosonCode().value());
        genzainojokyo.set市町村名(entity.getShichosonMeisho());
    }

    private void set有効基準年月日() {
        if (parameter.isEmptyKijyunYMD()) {
            genzainojokyo.set有効基準年月日(RString.EMPTY);
        } else {
            genzainojokyo.set有効基準年月日(parameter.getKijyunYMD().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
    }

    private RString get発行日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }

    private void outputJokenhyo() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE701009.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                タイトル,
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

    private RString toRString(int 保険者数) {
        return 保険者数 == 0 ? RString.EMPTY : new RString(保険者数);
    }

    private int toInt(RString 保険者数) {
        return RString.isNullOrEmpty(保険者数) ? 0 : Integer.parseInt(保険者数.toString());
    }

    private RString format下段(RString 保険者数, RString 合計) {
        if (Integer.parseInt(合計.toString()) == 0 || RString.isNullOrEmpty(保険者数)
                || Integer.parseInt(保険者数.toString()) == 0) {
            return 上段なし;
        }
        if (保険者数.equals(合計)) {
            return 全て;
        }
        return new RString(FORMAT.format(new Decimal(Integer.parseInt(保険者数.toString()))
                .divide(Integer.parseInt(合計.toString())).multiply(ひゃく)) + パーセント);
    }

}
