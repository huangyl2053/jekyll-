/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsakaijizenshinsakekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaijizenshinsakekkaichiran.IShinsakaiJIzenShinsakekkaIchiranMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事前審査結果一覧表の帳票のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranProcess extends BatchProcessBase<ShinsakaiJizenshinsakekkaIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID_TAISHOSHA = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaijizenshinsakekkaichiran."
            + "IShinsakaiJIzenShinsakekkaIchiranMapper.get審査会対象者情報");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE520001.getReportId();
    private static final RString なし = new RString("なし");
    private static final RString NULLNONE = new RString("※");
    private static final int ZERO = 0;
    private static final int ITI = 1;
    private static final int NI = 2;
    private static final int SAN = 3;
    private static final int YON = 4;
    private static final int LOKU = 6;
    private static final RString コード99A = new RString("99A");
    private static final RString コード02A = new RString("02A");
    private static final RString コード06A = new RString("06A");
    private static final RString コード09A = new RString("09A");
    private static final RString コード09B = new RString("09B");
    private ShinsakaiJizenshinsakekkaIchiranProcessParameter parameter;
    private IShinsakaiJIzenShinsakekkaIchiranMapper mapper;
    private List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会結果情報;
    private List<JizenShinsaKekkaRelateEntity> 審査員名;
    private List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会情報;
    private int データフラグ;

    @BatchWriter
    private BatchReportWriter<ShinsakaiJizenshinsakekkaIchiranReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaiJizenshinsakekkaIchiranReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IShinsakaiJIzenShinsakekkaIchiranMapper.class);
        審査会結果情報 = new ArrayList<>();
        審査員名 = new ArrayList<>();
        審査会情報 = new ArrayList<>();
        審査会結果情報 = mapper.get事前審査会結果情報(parameter.toMybitisParamter());
        審査員名 = mapper.get審査員名(parameter.toMybitisParamter());
        審査会情報 = mapper.get審査会情報(parameter.toMybitisParamter());
        データフラグ = mapper.get審査会対象者情報(parameter.toMybitisParamter()).size();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_TAISHOSHA, parameter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShinsakaiJizenshinsakekkaIchiranRelateEntity 審査会対象者情報) {
        ShinsakaiJizenshinsakekkaIchiranEntity entity = new ShinsakaiJizenshinsakekkaIchiranEntity(
                new RString(審査会情報.get(ZERO).getGogitaiNo()),
                審査会情報.get(ZERO).getShinsakaiKaisaiNo().substring(審査会情報.get(ZERO).getShinsakaiKaisaiNo().length() - YON),
                dateFormat(),
                get審査員(ZERO).getShinsakaiIinShimei(),
                get審査員(ITI).getShinsakaiIinShimei(),
                get審査員(NI).getShinsakaiIinShimei(),
                get審査員(SAN).getShinsakaiIinShimei(),
                get審査員(YON).getShinsakaiIinShimei(),
                new RString(審査会対象者情報.getShinsakaiOrder()),
                set特定疾病(審査会対象者情報.getNigoTokuteiShippeiCode()),
                審査会対象者情報.getHihokenshaNo(),
                set前回介護度(審査会対象者情報.getNijiHanteiYokaigoJotaiKubunCode(), 審査会対象者情報.getKoroshoIfShikibetsuCode()),
                RString.EMPTY,
                set対応結果(get審査員(ZERO).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                set有効期間(get審査員(ZERO).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                RString.EMPTY,
                set対応結果(get審査員(ITI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                set有効期間(get審査員(ITI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                RString.EMPTY,
                set対応結果(get審査員(NI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                set有効期間(get審査員(NI).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                RString.EMPTY,
                set対応結果(get審査員(SAN).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                set有効期間(get審査員(SAN).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                RString.EMPTY,
                set対応結果(get審査員(YON).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                set有効期間(get審査員(YON).getShinsakaiIinCode(), new RString(審査会対象者情報.getShinsakaiOrder())),
                set一次判定結果(審査会対象者情報.getIchijiHanteiKekkaCode(), 審査会対象者情報.getKoroshoIfShikibetsuCode()),
                RString.EMPTY,
                NinteiShinseiShinseijiKubunCode.toValue(審査会対象者情報.getNinteiShinseiShinseijiKubunCode()).get名称(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new RString(データフラグ)
        );
        ShinsakaiJizenshinsakekkaIchiranReport report = new ShinsakaiJizenshinsakekkaIchiranReport(entity);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        帳票バッチ出力条件リストの出力();
    }

    private void 帳票バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> 出力条件 = new ArrayList<>();
        RString 条件 = new RStringBuilder("【審査会開催年度】")
                .append(parameter.get介護認定審査会開催番号().substring(ZERO, YON))
                .append(new RString("【審査会開催番号】"))
                .append(parameter.get介護認定審査会開催番号().substring(parameter.get介護認定審査会開催番号().length() - YON))
                .toRString();
        出力条件.add(条件);
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE520001.getReportId().value(), 導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(), new RString(JobContextHolder.getJobId()),
                ReportIdDBE.DBE520001.getReportName(), new RString(reportSourceWriter.pageCount().value()),
                なし, なし, 出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString set特定疾病(RString 特定疾病) {
        if (!特定疾病.isNullOrEmpty()) {
            return NULLNONE;
        } else {
            return RString.EMPTY;
        }
    }

    private RString set有効期間(RString 審査員コード, RString 審査順) {
        for (ShinsakaiJizenshinsakekkaIchiranRelateEntity entity : 審査会結果情報) {
            if (審査員コード.equals(entity.getShinsakaiIinCode()) && 審査順.equals(new RString(entity.getShinsakaiOrder()))) {
                return entity.getYukokikan();
            }
        }
        return RString.EMPTY;
    }

    private RString set対応結果(RString 審査員コード, RString 審査順) {
        for (ShinsakaiJizenshinsakekkaIchiranRelateEntity entity : 審査会結果情報) {
            if (審査員コード.equals(entity.getShinsakaiIinCode()) && 審査順.equals(new RString(entity.getShinsakaiOrder()))) {
                return set前回介護度(entity.getNijiHanteiKekkaCode(), entity.getKoroshoIfShikibetsuCode());
            }
        }
        return RString.EMPTY;
    }

    private RString set前回介護度(RString 二次判定要介護状態区分コード, RString 厚労省IF識別コード) {
        if (RString.EMPTY.equals(二次判定要介護状態区分コード)) {
            return RString.EMPTY;
        }
        if (コード99A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード).get略称();
        }
        if (コード02A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(二次判定要介護状態区分コード).get略称();
        }
        if (コード06A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(二次判定要介護状態区分コード).get略称();
        }
        if (コード09A.equals(厚労省IF識別コード) || コード09B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(二次判定要介護状態区分コード).get略称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString set一次判定結果(RString 要介護認定一次判定結果コード, RString 厚労省IF識別コード) {
        if (要介護認定一次判定結果コード == null || RString.EMPTY.equals(要介護認定一次判定結果コード)) {
            return RString.EMPTY;
        }
        if (コード99A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(要介護認定一次判定結果コード).get名称();
        }
        if (コード02A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(要介護認定一次判定結果コード).get名称();
        }
        if (コード06A.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(要介護認定一次判定結果コード).get名称();
        }
        if (コード09A.equals(厚労省IF識別コード) || コード09B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(要介護認定一次判定結果コード).get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString dateFormat() {
        RString 年月日 = 審査会情報.get(ZERO).getShinsakaiKaisaiYoteiYMD();
        RString 時分 = 審査会情報.get(ZERO).getShinsakaiKaishiYoteiTime();
        return new RStringBuilder(年月日.substring(ZERO, YON)).append("年").append(年月日.substring(YON, LOKU))
                .append("月").append(年月日.substring(LOKU)).append("日")
                .append(" ").append(時分.substring(ZERO, NI)).append("時")
                .append(時分.substring(NI)).append("分").toRString();
    }

    private JizenShinsaKekkaRelateEntity get審査員(int 審査員フラグ) {
        try {
            return 審査員名.get(審査員フラグ);
        } catch (Exception e) {
            return new JizenShinsaKekkaRelateEntity();
        }

    }
}
