/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpSyuturyokuYoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.nenreikaikyuriyojokyo.NenreiKaikyuRiyoJokyoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 年齢階級別利用状況帳票作成
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public class NenreikaikyuRiyojokyoProcess extends BatchProcessBase<TmpSyuturyokuYoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenreikaikyuriyojokyo.INenreikaikyuRiyojokyoMapper."
            + "get出力用一時TBL");
    private static final RString 帳票ID = ReportIdDBC.DBC300003.getReportId().value();
    private static final RString 提供月 = new RString("提供月:");
    private static final RString 審査月 = new RString("審査月:");
    private static final RString 値000000 = new RString("000000");
    private static final RString 市町村名 = new RString("市町村名:");
    private static final RString 旧市町村名 = new RString("旧市町村名:");
    private static final RString 住所 = new RString("住所");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 地区1 = new RString("地区1");
    private static final RString 地区2 = new RString("地区2");
    private static final RString 地区3 = new RString("地区3");
    private static final RString 町域 = new RString("町域");
    private static final RString RSTRING_07 = new RString("07");
    private int count = 0;
    List<NenreiKeikyuBetsuRiyoJyokyoEntity> resultList = new ArrayList<>();
    private NenreikaikyuRiyojokyoProcessParameter processParameter;

    @BatchWriter
    private BatchReportWriter<NenreiKeikyuBetsuRiyoJyokyoReportSource> batchReportWriter;
    private ReportSourceWriter<NenreiKeikyuBetsuRiyoJyokyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        NenreiKaikyuRiyoJokyoFinder finder = NenreiKaikyuRiyoJokyoFinder.createInstance();
        finder.updateForOut();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(TmpSyuturyokuYoRelateEntity entity) {
        NenreiKeikyuBetsuRiyoJyokyoEntity reportEntity = new NenreiKeikyuBetsuRiyoJyokyoEntity();
        editReportEntity(reportEntity);
        reportEntity.set印刷日時(RDate.getNowDateTime());
        if (!entity.getShuukeiBangouCd().equals(RSTRING_07)) {
            int 番号_NUM = Integer.valueOf(entity.getShuukeiBangouCd().toString());
            if (番号_NUM % 2 != 0) {
                reportEntity.setサービス種類名称1(entity.getServiceSyuruiCodeMei());
                set明細1(reportEntity, entity);
                resultList.add(reportEntity);
            } else {
                resultList.get(count).setサービス種類名称2(entity.getServiceSyuruiCodeMei());
                set明細2(resultList.get(count), entity);
                count++;
            }
        } else {
            reportEntity.setサービス種類名称1(entity.getServiceSyuruiCodeMei());
            set明細1(reportEntity, entity);
            reportEntity.setサービス種類名称2(RString.EMPTY);
            set明細2(reportEntity, null);
            resultList.add(reportEntity);
            count++;
        }
    }

    @Override
    protected void afterExecute() {
        for (NenreiKeikyuBetsuRiyoJyokyoEntity result : resultList) {
            NenreiKeikyuBetsuRiyoJyokyoReport report = new NenreiKeikyuBetsuRiyoJyokyoReport(result);
            report.writeBy(reportSourceWriter);
        }
    }

    private void set明細1(NenreiKeikyuBetsuRiyoJyokyoEntity reportEntity, TmpSyuturyokuYoRelateEntity entity) {
        if (entity.getServiceSyuruiCodeMei().isEmpty()) {
            reportEntity.set区分_1(RString.EMPTY);
            reportEntity.set非該当_1(RString.EMPTY);
            reportEntity.set要支援１_1(RString.EMPTY);
            reportEntity.set要支援２_1(RString.EMPTY);
            reportEntity.set経過的要支援_1(RString.EMPTY);
            reportEntity.set要介護１_1(RString.EMPTY);
            reportEntity.set要介護２_1(RString.EMPTY);
            reportEntity.set要介護３_1(RString.EMPTY);
            reportEntity.set要介護４_1(RString.EMPTY);
            reportEntity.set要介護５_1(RString.EMPTY);
            reportEntity.set合計_1(RString.EMPTY);
            reportEntity.set備考_1(RString.EMPTY);
        } else {
            reportEntity.set区分_1(entity.getKubun());
            reportEntity.set非該当_1(getRString(entity.getHiGaitou()));
            reportEntity.set要支援１_1(getRString(entity.getYoSien1()));
            reportEntity.set要支援２_1(getRString(entity.getYoSien2()));
            reportEntity.set経過的要支援_1(getRString(entity.getKeikatekiYoSien()));
            reportEntity.set要介護１_1(getRString(entity.getYouKaigo1()));
            reportEntity.set要介護２_1(getRString(entity.getYouKaigo2()));
            reportEntity.set要介護３_1(getRString(entity.getYouKaigo3()));
            reportEntity.set要介護４_1(getRString(entity.getYouKaigo4()));
            reportEntity.set要介護５_1(getRString(entity.getYouKaigo5()));
            reportEntity.set合計_1(getRString(entity.getGoikei()));
            reportEntity.set備考_1(entity.getBikou());
        }
    }

    private void set明細2(NenreiKeikyuBetsuRiyoJyokyoEntity reportEntity, TmpSyuturyokuYoRelateEntity entity) {
        if (entity == null || entity.getServiceSyuruiCodeMei().isEmpty()) {
            reportEntity.set区分_2(RString.EMPTY);
            reportEntity.set非該当_2(RString.EMPTY);
            reportEntity.set要支援１_2(RString.EMPTY);
            reportEntity.set要支援２_2(RString.EMPTY);
            reportEntity.set経過的要支援_2(RString.EMPTY);
            reportEntity.set要介護１_2(RString.EMPTY);
            reportEntity.set要介護２_2(RString.EMPTY);
            reportEntity.set要介護３_2(RString.EMPTY);
            reportEntity.set要介護４_2(RString.EMPTY);
            reportEntity.set要介護５_2(RString.EMPTY);
            reportEntity.set合計_2(RString.EMPTY);
            reportEntity.set備考_2(RString.EMPTY);
        } else {
            reportEntity.set区分_2(entity.getKubun());
            reportEntity.set非該当_2(getRString(entity.getHiGaitou()));
            reportEntity.set要支援１_2(getRString(entity.getYoSien1()));
            reportEntity.set要支援２_2(getRString(entity.getYoSien2()));
            reportEntity.set経過的要支援_2(getRString(entity.getKeikatekiYoSien()));
            reportEntity.set要介護１_2(getRString(entity.getYouKaigo1()));
            reportEntity.set要介護２_2(getRString(entity.getYouKaigo2()));
            reportEntity.set要介護３_2(getRString(entity.getYouKaigo3()));
            reportEntity.set要介護４_2(getRString(entity.getYouKaigo4()));
            reportEntity.set要介護５_2(getRString(entity.getYouKaigo5()));
            reportEntity.set合計_2(getRString(entity.getGoikei()));
            reportEntity.set備考_2(entity.getBikou());
        }
    }

    private void editReportEntity(NenreiKeikyuBetsuRiyoJyokyoEntity entity) {
        if (!processParameter.getServiceTeikyoYM().isEmpty()) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(提供月);
            rb.append((setDateFormat(processParameter.getServiceTeikyoYM())));
            RString 条件１ = rb.toRString();
            entity.set条件1(条件１);
        } else if (!processParameter.getSinsaYM().isEmpty()) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(審査月);
            rb.append((setDateFormat(processParameter.getSinsaYM())));
            RString 条件１ = rb.toRString();
            entity.set条件1(条件１);
        }
        if ((!processParameter.getShichosonCode().value().isEmpty() && !(processParameter.getShichosonCode().value().equals(値000000)))
                && (processParameter.getKyoShichosonCode().value().isEmpty() || processParameter.getKyoShichosonCode().value().equals(値000000))) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(市町村名);
            rb.append(processParameter.getShichosonMeisho());
            RString 条件2 = rb.toRString();
            entity.set条件2(条件2);
        } else if (!processParameter.getShichosonCode().value().isEmpty() && !(processParameter.getShichosonCode().value().equals(値000000))) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(旧市町村名);
            rb.append(processParameter.getKyoShichosonMeisho());
            RString 条件2 = rb.toRString();
            entity.set条件2(条件2);
        } else if (processParameter.getShichosonCode().value().isEmpty() && processParameter.getKyoShichosonCode().value().isEmpty()) {
            if (processParameter.getSentakuTaisyoKubun().equals(町域)) {
                entity.set条件2(setBuilder(住所));
            } else if (processParameter.getSentakuTaisyoKubun().equals(行政区)) {
                entity.set条件2(setBuilder(行政区));
            } else if (processParameter.getSentakuTaisyoKubun().equals(地区1)) {
                entity.set条件2(setBuilder(地区1));
            } else if (processParameter.getSentakuTaisyoKubun().equals(地区2)) {
                entity.set条件2(setBuilder(地区2));
            } else if (processParameter.getSentakuTaisyoKubun().equals(地区3)) {
                entity.set条件2(setBuilder(地区3));
            } else {
                entity.set条件2(RString.EMPTY);
            }
        }
    }

    private RString setBuilder(RString 対象区分) {
        RStringBuilder rb = new RStringBuilder();
        rb.append(対象区分);
        rb.append(":");
        if (processParameter.getSentakuTaisyoList() != null && !processParameter.getSentakuTaisyoList().isEmpty()) {
            rb.append(processParameter.getSentakuTaisyoList().get(0));
            rb.append("～");
            rb.append(processParameter.getSentakuTaisyoList().get(processParameter.getSentakuTaisyoList().size() - 1));
        }
        return rb.toRString();
    }

    private RString setDateFormat(FlexibleDate date) {
        RString formatDate = RString.EMPTY;
        if (!date.isEmpty()) {
            formatDate = date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        formatDate = formatDate.substring(0, formatDate.indexOf(new RString("月")) + 1);
        return formatDate;
    }

    private RString getRString(Decimal decimal) {
        return new RString(String.valueOf(decimal));
    }

}
