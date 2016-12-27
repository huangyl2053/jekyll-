/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.OutputJokenhyoFactoryProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 審査会資料一括作成の出力条件表出力のバッチ処理クラスです。
 */
public class OutputJokenhyoFactoryProcess extends SimpleBatchProcessBase {

    private OutputJokenhyoFactoryProcessParameter paramter;
    private static final int 帳票名_１レコード最大表示数 = 5;

    @Override
    protected void process() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                RString.EMPTY,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> get帳票名文字列リスト(Map<RString, RString> 帳票一覧Map) {
        RStringBuilder rsb = new RStringBuilder();
        int count = 0;
        List<RString> list = new ArrayList();
        for (Map.Entry<RString, RString> entry : 帳票一覧Map.entrySet()) {
            if (rsb.length() > 0) {
                rsb.append(",");
            }
            if (count == 帳票名_１レコード最大表示数) {
                list.add(rsb.toRString());
                count = 0;
                rsb = new RStringBuilder();
            } else {
                rsb.append(entry.getValue());
                count++;
            }
        }
        if (rsb.length() > 0) {
            list.add(rsb.toRString());
        }
        return list;
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("合議体番号"), new RString(paramter.getGogitaiNo())));
        出力条件.add(条件(new RString("介護認定審査会開催予定年月日"), paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString()));
        出力条件.add(条件(new RString("介護認定審査会開催番号"), paramter.getShinsakaiKaisaiNo()));
        出力条件.add(条件(new RString("出力スタイル"), 出力スタイル(paramter.getShuturyokuSutairu())));
        出力条件.add(条件(new RString("印刷方法"), 印刷方法(paramter.getPrintHou())));
        出力条件.add(条件(new RString("作成条件"), 作成条件(paramter.getSakuseiJoken(), paramter.getBangoStart(), paramter.getBangoEnd())));
        List<RString> 帳票一覧リスト = get帳票名文字列リスト(paramter.get帳票一覧Map());
        boolean isFirst = true;
        for (RString 帳票名 : 帳票一覧リスト) {
            if (isFirst) {
                出力条件.add(条件_帳票名(new RString("出力帳票名称"), 帳票名, isFirst));
                isFirst = false;
            } else {
                出力条件.add(条件_帳票名(new RString("　　　　　　"), 帳票名, isFirst));
            }
        }
        return 出力条件;
    }

    private RString 出力スタイル(RString key) {
        if (key.equals(new RString("1"))) {
            return new RString("A4縦");
        } else if (key.equals(new RString("2"))) {
            return new RString("A3横");
        }
        return RString.EMPTY;
    }

    private RString 印刷方法(RString key) {
        if (key.equals(new RString("1"))) {
            return new RString("両面");
        } else if (key.equals(new RString("2"))) {
            return new RString("片面");
        }
        return RString.EMPTY;
    }

    private RString 作成条件(RString key, int 資料番号開始, int 資料番号終了) {
        if (key.equals(new RString("全件"))) {
            return new RString("全件");
        } else if (key.equals(new RString("範囲指定"))) {
            RString 資料番号範囲 = new RString(資料番号開始).concat("～").concat(new RString(資料番号終了));
            return new RString("範囲指定").concat(" ").concat(資料番号範囲);
        } else if (key.equals(new RString("追加分"))) {
            return new RString("追加分");
        }
        return RString.EMPTY;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("【"));
        条件.append(バッチパラメータ名);
        条件.append(new RString("】"));
        条件.append(値);
        return 条件.toRString();
    }

    private RString 条件_帳票名(RString バッチパラメータ名, RString 値, boolean is先頭) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(is先頭 ? new RString("【") : RString.FULL_SPACE);
        条件.append(バッチパラメータ名);
        条件.append(is先頭 ? new RString("】") : RString.FULL_SPACE);
        条件.append(値);
        return 条件.toRString();
    }
}
