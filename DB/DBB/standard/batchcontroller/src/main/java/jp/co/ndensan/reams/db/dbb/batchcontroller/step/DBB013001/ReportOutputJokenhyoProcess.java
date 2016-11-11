/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001.PrtKaigoFukaTokuchoHeijunkaCore;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * バッチ出力条件表を出力する処理クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class ReportOutputJokenhyoProcess extends SimpleBatchProcessBase {

    private static final RString 定数_出力条件 = new RString("出力条件");
    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 出力条件_左括弧 = new RString("【");
    private static final RString 出力条件_右括弧 = new RString("】");
    private static final RString パラメータ名_調定年度 = new RString("調定年度");
    private static final RString パラメータ名_賦課年度 = new RString("賦課年度");
    private static final RString 年度 = new RString("年度");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString SIGN_GT = new RString("＞");
    private static final RString 英数字ファイル名 = new RString("TokubetsuChoshuHeijunkaKeisanAugustKekkaIchiran.csv");
    private TokuchoHeinjunka8GatsuProcessParameter parameter;
    private LasdecCode 市町村コード;
    private RString 市町村名;

    @Override
    protected void beforeExecute() {
        PrtKaigoFukaTokuchoHeijunkaCore core = new PrtKaigoFukaTokuchoHeijunkaCore();
        市町村コード = core.getAssociation().get地方公共団体コード();
        市町村名 = core.getAssociation().get市町村名();
    }

    @Override
    protected void process() {
        バッチ出力条件リストの出力(parameter.get調定年度(), parameter.get賦課年度(), 市町村コード, 市町村名,
                parameter.get出力ページ数(), parameter.get出力順ID());
    }

    private void バッチ出力条件リストの出力(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            LasdecCode 市町村コード, RString 市町村名, int ページ数, RString 出力順ID) {
        List<RString> 出力条件リスト = new ArrayList<>();
        出力条件リスト.add(定数_出力条件);
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_調定年度).concat(出力条件_右括弧).concat(
                調定年度.wareki().toDateString()).concat(年度));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_賦課年度).concat(出力条件_右括弧).concat(
                賦課年度.wareki().toDateString()).concat(年度));
        if (null != 出力順ID) {
            set出力順(出力順ID, 出力条件リスト);
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200005.getReportId().value(),
                市町村コード.value(),
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200005.getReportName(),
                new RString(ページ数),
                CSV出力有無_有り,
                英数字ファイル名,
                出力条件リスト
        );
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void set出力順(RString 出力順ID, List<RString> 出力条件リスト) {
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200005.getReportId(), Long.parseLong(出力順ID.toString()));
        RStringBuilder builder = new RStringBuilder(出力条件_左括弧.concat(定数_出力順).concat(出力条件_右括弧).concat(RString.FULL_SPACE));
        if (outputOrder != null) {
            List<ISetSortItem> iSetSortItemList = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : iSetSortItemList) {
                if (iSetSortItem == iSetSortItemList.get(iSetSortItemList.size() - 1)) {
                    builder.append(iSetSortItem.get項目名());
                } else {
                    builder.append(iSetSortItem.get項目名()).append(SIGN_GT);
                }
            }
        }
        出力条件リスト.add(builder.toRString());
    }
}
