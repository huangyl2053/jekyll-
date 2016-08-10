/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.service.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranPrintService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険所得情報一覧表出力です。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class PrtKaigoHokenShotokuJohoIchiranProcess extends BatchProcessBase<KaigoHokenShotokuTempEntity> {

    private static final int INDEX_1 = 1;
    private static final RString INDEX_111 = new RString("111");
    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString 出力_出力条件 = new RString("出力条件");
    private static final RString 出力_導入形態コード = new RString("導入形態コード");
    private static final RString 出力_市町村コード = new RString("市町村コード");
    private static final RString 出力_市町村名称 = new RString("市町村名称");
    private static final RString 出力_処理年度 = new RString("処理年度");
    private static final RString 出力_抽出対象チェックボックス = new RString("抽出対象チェックボックス");
    private static final RString 出力_抽出対象ラジオボタン = new RString("抽出対象ラジオボタン");
    private static final RString 出力_抽出期間開始日時 = new RString("抽出期間開始日時");
    private static final RString 出力_抽出期間終了日時 = new RString("抽出期間終了日時");
    private static final RString 出力_市町村情報リスト = new RString("市町村情報リスト");
    private static final RString 出力_出力順ＩＤ = new RString("出力順ＩＤ");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 出力_コンマ = new RString(",");
    private static final RString CSV出力有無_無し = new RString("無し");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db."
            + "mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper");
    private static final RString SELECTALL = new RString(MAPPER_PATH + ".selectTempAll");
    private SourceDataCollection sourceDataCollection;
    private LasdecCode 市町村コード;
    private RString 導入形態コード;
    private RString 市町村名称;
    private Long 出力順ID;
    private RString チェックボックス;
    private RString ラジオボタン;
    private YMDHMS 開始日時;
    private YMDHMS 終了日時;
    private FlexibleYear 処理年度;
    private int 連番;

    @BatchParameter
    ShotokujohoIchiranhyoSakuseiProcessParameter parameter;

    @Override
    public void initialize() {
        導入形態コード = parameter.get導入形態コード();
        if (INDEX_111.equals(導入形態コード)) {
            市町村コード = parameter.get市町村コード();
            市町村名称 = parameter.get市町村名称();
        }
        出力順ID = parameter.get出力順ID();
        チェックボックス = parameter.getチェックボックス();
        ラジオボタン = parameter.getラジオボタン();
        開始日時 = parameter.get開始日時();
        終了日時 = parameter.get終了日時();
        処理年度 = parameter.get処理年度();
        連番 = INDEX_1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTALL);
    }

    @Override
    protected void process(KaigoHokenShotokuTempEntity item) {
        sourceDataCollection = new KaigoHokenShotokuJohoIchiranPrintService()
                .print介護保険所得情報(item, 導入形態コード, 市町村コード, 市町村名称, 出力順ID, 連番);
        連番++;
    }

    @Override
    protected void afterExecute() {
        List<RString> 出力条件リスト = set出力条件リスト(導入形態コード, 処理年度,
                チェックボックス, ラジオボタン, 開始日時, 終了日時, parameter.get市町村情報リスト(), 出力順ID);
        RString 出力ページ数 = new RString(sourceDataCollection.iterator().next().getPageCount());
        RString 帳票名 = ReportIdDBB.DBB200008.getReportName();
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_無し, CSVファイル名, 帳票名);
    }

    private List<RString> set出力条件リスト(RString 導入形態コード,
            FlexibleYear 処理年度, RString チェックボックス, RString ラジオボタン,
            YMDHMS 開始日時, YMDHMS 終了日時, List<ShichosonJouhouResult> 市町村情報リスト, Long 出力順ID) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(出力_出力条件);
        出力条件リスト.add(builder.toRString());
        builder.append((FORMAT_LEFT).concat(出力_導入形態コード).concat(FORMAT_RIGHT).concat(導入形態コード));
        出力条件リスト.add(builder.toRString());
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        builder.append((FORMAT_LEFT).concat(出力_市町村コード).concat(FORMAT_RIGHT).concat(市町村コード.getColumnValue()));
        出力条件リスト.add(builder.toRString());
        市町村名称 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
        builder.append((FORMAT_LEFT).concat(出力_市町村名称).concat(FORMAT_RIGHT).concat(市町村名称));
        出力条件リスト.add(builder.toRString());
        builder.append((FORMAT_LEFT).concat(出力_処理年度).concat(FORMAT_RIGHT).concat(処理年度.wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder.append((FORMAT_LEFT).concat(出力_抽出対象チェックボックス).concat(FORMAT_RIGHT).concat(チェックボックス));
        出力条件リスト.add(builder.toRString());
        builder.append((FORMAT_LEFT).concat(出力_抽出対象ラジオボタン).concat(FORMAT_RIGHT).concat(ラジオボタン));
        出力条件リスト.add(builder.toRString());
        builder.append((FORMAT_LEFT).concat(出力_抽出期間開始日時).concat(FORMAT_RIGHT).concat(開始日時.toDateString()));
        出力条件リスト.add(builder.toRString());
        builder.append((FORMAT_LEFT).concat(出力_抽出期間終了日時).concat(FORMAT_RIGHT).concat(終了日時.toDateString()));
        出力条件リスト.add(builder.toRString());
        for (ShichosonJouhouResult result : 市町村情報リスト) {
            builder.append((FORMAT_LEFT).concat(出力_市町村情報リスト).concat(FORMAT_RIGHT).concat(result.get市町村コード().value())
                    .concat(出力_コンマ).concat(result.get市町村識別ID()).concat(出力_コンマ).concat(new RString(result.get開始年月日().toString()))
                    .concat(出力_コンマ).concat(result.get開始時刻()).concat(出力_コンマ).concat(new RString(result.get終了年月日().toString()))
                    .concat(出力_コンマ).concat(result.get終了時刻()));
            出力条件リスト.add(builder.toRString());
        }
        builder.append((FORMAT_LEFT).concat(出力_出力順ＩＤ).concat(FORMAT_RIGHT).concat(String.valueOf(出力順ID)));
        出力条件リスト.add(builder.toRString());
        return 出力条件リスト;
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト,
            ReportId 帳票ID, RString 出力ページ数, RString csv出力有無, RString csvファイル名, RString 帳票名) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

}
