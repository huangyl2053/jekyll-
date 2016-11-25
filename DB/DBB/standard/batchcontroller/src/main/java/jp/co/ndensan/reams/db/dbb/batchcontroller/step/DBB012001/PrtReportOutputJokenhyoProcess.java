/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * バッチ出力条件表を出力する処理クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class PrtReportOutputJokenhyoProcess extends SimpleBatchProcessBase {

    private static final RString 定数_出力順 = new RString("出力順");
    private static final RString 出力条件_左括弧 = new RString("【");
    private static final RString 出力条件_右括弧 = new RString("】");
    private static final RString パラメータ名_調定年度 = new RString("調定年度");
    private static final RString パラメータ名_賦課年度 = new RString("賦課年度");
    private static final RString 年度 = new RString("年度");
    private static final RString CSV出力有無_有り = new RString("有り");
    private static final RString SIGN_GT = new RString("＞");
    private static final RString 英数字ファイル名 = new RString("TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranData.csv");
    private static final RString 平準化しない = new RString("0");
    private static final RString 平準化するを判定し = new RString("1");
    private static final RString SPACE = new RString("　　　　　　　");
    private TokuchoHeinjunka6GatsuProcessParameter parameter;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private IOutputOrder outputOrder;

    @Override
    protected void beforeExecute() {
        PrtKaigoFukaTokuchoHeijunkaCore core = new PrtKaigoFukaTokuchoHeijunkaCore();
        outputOrder = core.beforeExecuteCore(parameter.get出力帳票一覧().get出力順ID());
        市町村コード = core.getAssociation().get地方公共団体コード();
        市町村名 = core.getAssociation().get市町村名();
    }

    @Override
    protected void process() {
        バッチ出力条件リストの出力(parameter.get調定年度(), parameter.get賦課年度(), 市町村コード, 市町村名,
                parameter.get出力ページ数());
    }

    private void バッチ出力条件リストの出力(FlexibleYear 調定年度, FlexibleYear 賦課年度,
            LasdecCode 市町村コード, RString 市町村名, int ページ数) {
        List<RString> 出力条件リスト = new ArrayList<>();

        RString 減額 = RString.EMPTY;
        RString 減額コンフィグ = DbBusinessConfig.
                get(ConfigNameDBB.特別徴収_平準化計算方法_6月分減額, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString());
        if (平準化しない.equals(減額コンフィグ)) {
            減額 = TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称();
        } else if (平準化するを判定し.equals(減額コンフィグ)) {
            減額 = TokuchoHeijunkaKeisanHoho6Gatsu.toValue(DbBusinessConfig.
                    get(ConfigNameDBB.特別徴収_平準化計算方法_6月分, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString())).get名称();
        }
        RString 増額 = RString.EMPTY;
        RString 増額コンフィグ = DbBusinessConfig.
                get(ConfigNameDBB.特別徴収_平準化計算方法_6月分増額, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString());
        if (平準化しない.equals(増額コンフィグ)) {
            増額 = TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称();
        } else if (平準化するを判定し.equals(増額コンフィグ)) {
            増額 = TokuchoHeijunkaKeisanHoho6Gatsu.toValue(DbBusinessConfig.
                    get(ConfigNameDBB.特別徴収_平準化計算方法_6月分, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString())).get名称();
        }
        if (!増額.isEmpty()) {
            増額 = SPACE.concat(増額);
        }

        出力条件リスト.add(減額);
        出力条件リスト.add(増額);
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_調定年度).concat(出力条件_右括弧).concat(
                調定年度.wareki().toDateString()).concat(年度));
        出力条件リスト.add(出力条件_左括弧.concat(パラメータ名_賦課年度).concat(出力条件_右括弧).concat(
                賦課年度.wareki().toDateString()).concat(年度));
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
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200003.getReportId().value(),
                市町村コード.value(),
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200003.getReportName(),
                new RString(ページ数),
                CSV出力有無_有り,
                英数字ファイル名,
                出力条件リスト
        );
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
