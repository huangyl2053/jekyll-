/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd583001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力条件リストの出力service
 *
 * @reamsid_L DBD-1790-020 donghj
 */
public class OutputJokenhyo {

    private static final int SUBSTRING_9 = 9;

    /**
     * 帳票出力条件リストの出力
     *
     * @param parameter NenreiKaikyubetsuYokaigodoJokyoProcessParameter
     */
    public void outputJokenhyoFactory(NenreiKaikyubetsuYokaigodoJokyoProcessParameter parameter) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD300005.getReportId().getColumnValue().substring(0, SUBSTRING_9),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD300005.getReportName(),
                new RString("2"),
                new RString("なし"),
                new RString("なし"),
                contribute(parameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute(NenreiKaikyubetsuYokaigodoJokyoProcessParameter parameter) {
        List<RString> 出力条件 = new ArrayList<>();
        if (parameter.get基準日() != null) {
            出力条件.add(new RString("【基準日】　").concat(parameter.get基準日().wareki().toDateString()));
        }
        if (parameter.get基準年月() != null) {
            出力条件.add(new RString("【基準年月】　").concat(parameter.get基準年月().wareki().firstYear(FirstYear.ICHI_NEN).toDateString()));
        }
        if (parameter.get地区区分() != null) {
            出力条件.add(new RString("【地区区分】　").concat(parameter.get地区区分()));
        }
        if (parameter.get開始地区コード() != null) {
            出力条件.add(new RString("【開始地区コード】　").concat(parameter.get開始地区コード().value()));
        }
        if (parameter.get終了地区コード() != null) {
            出力条件.add(new RString("【終了地区コード】　").concat(parameter.get終了地区コード().value()));
        }
        if (parameter.get旧市町村コード() != null) {
            出力条件.add(new RString("【旧市町村コード】　").concat(parameter.get旧市町村コード()));
        }
        return 出力条件;
    }

}
