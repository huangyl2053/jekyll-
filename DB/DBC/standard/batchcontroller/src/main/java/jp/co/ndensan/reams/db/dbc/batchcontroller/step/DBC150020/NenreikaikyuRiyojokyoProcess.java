/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenreikaikyuriyojokyo.NenreikaikyuRiyojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo.TmpSyuturyokuYoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.nenreikeikyubetsuriyojyokyo.NenreiKeikyuBetsuRiyoJyokyoReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.nenreikaikyuriyojokyo.NenreiKaikyuRiyoJokyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString 值000000 = new RString("000000");
    private static final RString 市町村名 = new RString("市町村名:");
    private static final RString 旧市町村名 = new RString("旧市町村名:");
    private static final RString 住所 = new RString("住所:");
    private static final RString 行政区 = new RString("行政区:");
    private static final RString 地区1 = new RString("地区1:");
    private static final RString 地区2 = new RString("地区2:");
    private static final RString 地区3 = new RString("地区3:");
    private static final RString 町域 = new RString("1");
    private static final RString 值2 = new RString("2");
    private static final RString 值3 = new RString("3");
    private static final RString 值4 = new RString("4");
    private static final RString 值5 = new RString("5");
    NenreiKeikyuBetsuRiyoJyokyoEntity reportEntity = new NenreiKeikyuBetsuRiyoJyokyoEntity();
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
        editReportEntity(reportEntity);
        reportEntity.setページ数(entity.getPageNo());
        reportEntity.set印刷日時(RDate.getNowDateTime());
        if (entity.getNo().equals(new RString("1"))) {
            reportEntity.setサービス種類名称1(entity.getServiceSyuruiCodeMei());
            set明細1(entity);
        }
        if (entity.getNo().equals(new RString("2"))) {
            reportEntity.setサービス種類名称2(entity.getServiceSyuruiCodeMei());
            set明細2(entity);
        }

        NenreiKeikyuBetsuRiyoJyokyoReport report = new NenreiKeikyuBetsuRiyoJyokyoReport(reportEntity);
        report.writeBy(reportSourceWriter);
    }

    private void set明細1(TmpSyuturyokuYoRelateEntity entity) {
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

    private void set明細2(TmpSyuturyokuYoRelateEntity entity) {
        if (entity.getServiceSyuruiCodeMei().isEmpty()) {
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
            reportEntity.set合計_1(getRString(entity.getGoikei()));
            reportEntity.set備考_1(entity.getBikou());
        }
    }

    private void editReportEntity(NenreiKeikyuBetsuRiyoJyokyoEntity entity) {
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        entity.set保険者番号(保険者番号);
        RString 保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        entity.set保険者名(保険者名称);
        if (!processParameter.getServiceTeikyoYM().isEmpty()) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(提供月);
            rb.append((setDateFormat(processParameter.getServiceTeikyoYM())));
            RString 条件１ = rb.toRString();
            entity.set条件1(条件１);
        } else if (!processParameter.getSinsaYM().isEmpty()) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(審査月);
            rb.append((setDateFormat(processParameter.getServiceTeikyoYM())));
            RString 条件１ = rb.toRString();
            entity.set条件1(条件１);
        }
        if ((!processParameter.getShichosonCode().value().isEmpty() && !(processParameter.getShichosonCode().value().equals(值000000)))
                && (processParameter.getKyoShichosonCode().value().isEmpty() || processParameter.getKyoShichosonCode().value().equals(值000000))) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(市町村名);
            rb.append(processParameter.getShichosonMeisho());
            RString 条件2 = rb.toRString();
            entity.set条件2(条件2);
        } else if (!processParameter.getShichosonCode().value().isEmpty() && !(processParameter.getShichosonCode().value().equals(值000000))) {
            RStringBuilder rb = new RStringBuilder();
            rb.append(旧市町村名);
            rb.append(processParameter.getKyoShichosonMeisho());
            RString 条件2 = rb.toRString();
            entity.set条件2(条件2);
        } else if (processParameter.getShichosonCode().value().isEmpty() && processParameter.getKyoShichosonCode().value().isEmpty()) {
            if (processParameter.getSentakuTaisyoKubun().equals(町域)) {
                entity.set条件2(setBuilder(住所));
            } else if (processParameter.getSentakuTaisyoKubun().equals(值2)) {
                entity.set条件2(setBuilder(行政区));
            } else if (processParameter.getSentakuTaisyoKubun().equals(值3)) {
                entity.set条件2(setBuilder(地区1));
            } else if (processParameter.getSentakuTaisyoKubun().equals(值4)) {
                entity.set条件2(setBuilder(地区2));
            } else if (processParameter.getSentakuTaisyoKubun().equals(值5)) {
                entity.set条件2(setBuilder(地区3));
            } else {
                entity.set条件2(RString.EMPTY);
            }
        }

    }

    private RString setBuilder(RString 対象区分) {
        Map<RString, RString> map = processParameter.getSentakuTaisyoList();
        RString firstCode = RString.EMPTY;
        RString lastCode = RString.EMPTY;
        boolean firstFlag = true;
        int count = 0;
        for (RString key : map.keySet()) {
            ++count;
            if (firstFlag) {
                firstCode = key;
                firstFlag = false;
            }
            if (count == map.keySet().size()) {
                lastCode = key;
            }
        }
        RStringBuilder rb = new RStringBuilder();
        rb.append(対象区分);
        rb.append(firstCode);
        rb.append("～");
        rb.append(lastCode);
        return rb.toRString();
    }

    private RString setDateFormat(FlexibleDate date) {
        RString formatDate = RString.EMPTY;
        if (!date.isEmpty()) {
            formatDate = date.wareki().toDateString();
        }
        return formatDate;
    }

    private RString getRString(Decimal decimal) {
        return new RString(String.valueOf(decimal));
    }

}
