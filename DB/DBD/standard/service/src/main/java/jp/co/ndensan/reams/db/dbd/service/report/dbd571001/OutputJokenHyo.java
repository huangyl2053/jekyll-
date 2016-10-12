/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd571001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票出力条件リストの出力service
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class OutputJokenHyo {

    private static final RString なし = new RString("なし");
    private static final RString 改行 = new RString("\r\n");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");

    /**
     * 帳票出力条件リストの出力
     *
     * @param processParamter IdoChushutsuDaichoProcessParameter
     * @param ページ数 ページ数
     */
    public void outputJokenhyoFactory(IdoChushutsuDaichoProcessParameter processParamter, RString ページ数) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD100026.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD100026.getReportName(),
                ページ数,
                なし,
                RString.EMPTY,
                contribute(processParamter));
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private List<RString> contribute(IdoChushutsuDaichoProcessParameter processParamter) {
        List<RString> 出力条件 = new ArrayList<>();
        if (processParamter.get抽出条件設定区分().equals(区分_0)) {
            set今回抽出あり(出力条件, processParamter);
        } else if (processParamter.get抽出条件設定区分().equals(区分_1)) {
            set今回抽出なし(出力条件, processParamter);
        }
        if (processParamter.get異動抽出対象リスト().isEmpty()) {
            出力条件.add(new RString("【異動抽出対象】　").concat(なし));
        } else {
            RString 異動抽出対象 = set異動抽出対象(processParamter);
            if (異動抽出対象 != null) {
                出力条件.add(異動抽出対象);
            }
        }
        if (processParamter.get出力オプション区分() != null && !processParamter.get出力オプション区分().isEmpty()) {
            if (processParamter.get出力オプション区分().equals(区分_0)) {
                出力条件.add(new RString("【出力オプション区分】　").concat(new RString("全てのページを印刷する")));
            } else if (processParamter.get出力オプション区分().equals(区分_1)) {
                出力条件.add(new RString("【出力オプション区分】　").concat(new RString("被保険者毎に最新1ページ分のみ印刷する")));
            }
        }
        return 出力条件;

    }

    private void set今回抽出あり(List<RString> 出力条件, IdoChushutsuDaichoProcessParameter parameter) {
        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(new RString("【今回抽出開始年月日】　").concat(parameter.get今回抽出開始年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(new RString("【今回抽出開始時分秒】　").concat(parameter.get今回抽出開始時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(new RString("【今回抽出終了年月日】　").concat(parameter.get今回抽出終了年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(new RString("【今回抽出終了時分秒】　").concat(parameter.get今回抽出終了時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
    }

    private void set今回抽出なし(List<RString> 出力条件, IdoChushutsuDaichoProcessParameter parameter) {
        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(new RString("【今回抽出開始年月日】　").concat(なし));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(new RString("【今回抽出開始時分秒】　").concat(なし));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(new RString("【今回抽出終了年月日】　").concat(なし));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(new RString("【今回抽出終了時分秒】　").concat(なし));
        }
    }

    private RString set異動抽出対象(IdoChushutsuDaichoProcessParameter parameter) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("【異動抽出対象】　"));
        for (RString 異動抽出対象 : parameter.get異動抽出対象リスト()) {
            if (異動抽出対象.equals(new RString("要介護認定"))) {
                builder.append(new RString("要介護認定"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("利用者負担額減免"))) {
                builder.append(new RString("利用者負担額減免"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("施設入退所"))) {
                builder.append(new RString("施設入退所"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("資格"))) {
                builder.append(new RString("資格"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("訪問介護（特別対策減免）"))) {
                builder.append(new RString("訪問介護（特別対策減免）"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("居宅サービス計画"))) {
                builder.append(new RString("居宅サービス計画"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("老齢福祉年金"))) {
                builder.append(new RString("老齢福祉年金"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("負担限度額(特定入所者)"))) {
                builder.append(new RString("負担限度額(特定入所者)"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("社会福祉法人軽減"))) {
                builder.append(new RString("社会福祉法人軽減"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("給付制限"))) {
                builder.append(new RString("給付制限"));
                builder.append(改行);
            } else if (異動抽出対象.equals(new RString("生活保護"))) {
                builder.append(new RString("生活保護"));
                builder.append(改行);
            }
        }
        return builder.toRString();
    }
}
