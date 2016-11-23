/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoItems;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 被保険者証発行管理リストを発行するうえで、共通的に利用される処理を定義します。
 *
 * @author n8178
 */
final class HihokenshashoHakkoKanriboCommonProcess {

    private static final RString 抽出条件 = new RString("【抽出条件】");
    private static final RString 出力対象 = new RString("出力対象：");
    private static final RString 交付年月日 = new RString("交付年月日：");
    private static final RString 回収年月日 = new RString("回収年月日：");
    private static final RString 交付事由 = new RString("交付事由：");
    private static final RString 回収事由 = new RString("回収事由：");
    private static final RString カラ = new RString("　～　");
    private static final RString 区切り文字 = new RString("、");

    private static final RString 証発行モード_被保険者 = new RString("001");
    private static final RString 証発行モード_資格者 = new RString("002");
    private static final RString 発行対象_発行管理リスト = new RString("1");
    private static final RString 発行対象_未回収者リスト = new RString("2");

    private enum EucEntityIds {

        被保険者証発行管理リストCSV("DBA200004"),
        被保険者証未回収者リストCSV("DBA201004"),
        資格者証発行管理リストCSV("DBA202004"),
        資格者証未回収者リストCSV("DBA203004"),
        被保険者証発行管理リスト_連番_CSV("DBA210004"),
        被保険者証未回収者リスト_連番_CSV("DBA211004"),
        資格者証発行管理リスト_連番_CSV("DBA212004"),
        資格者証未回収者リスト_連番_CSV("DBA213004");

        private final EucEntityId id;

        EucEntityIds(String id) {
            this.id = new EucEntityId(id);
        }

        EucEntityId getEucEntityId() {
            return id;
        }
    }

    private HihokenshashoHakkoKanriboCommonProcess() {
    }

    /**
     * MapperXmlに付与する、帳票出力順を反映したOrderBy句を生成します。
     *
     * @param shutsuryokujun 出力順クラス
     * @return 出力順を反映したOrderBy句
     */
    static RString createOrderBy(IOutputOrder shutsuryokujun) {
        return MyBatisOrderByClauseCreator.create(HihokenshashoHakkoKanriIchiranhyoItems.class, shutsuryokujun);
    }

    /**
     * MapperXmlのSelect句に付与する、帳票出力順項目の項目名を生成します。
     *
     * @param shutsuryokujun 出力順クラス
     * @return 帳票出力順項目を示す文字列
     */
    static RString createPageBreakItem(IOutputOrder shutsuryokujun) {
        if (shutsuryokujun == null || shutsuryokujun.get設定項目リスト().isEmpty()) {
            return RString.EMPTY;
        }

        RStringBuilder builder = new RStringBuilder();
        int i = 1;
        for (ISetSortItem item : shutsuryokujun.get設定項目リスト()) {
            builder.append(",");
            builder.append(get項目名(item));
            builder.append(" AS ");
            builder.append("\"pageBreakItem" + i + "\"");
            i++;
        }
        return builder.toRString();
    }

    private static RString get項目名(ISetSortItem item) {
        for (HihokenshashoHakkoKanriIchiranhyoItems shutsuryokujunItem : HihokenshashoHakkoKanriIchiranhyoItems.values()) {
            if (item.get項目ID().equals(shutsuryokujunItem.get項目ID())) {
                return shutsuryokujunItem.getMyBatis項目名();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 証発行モードと対象区分から、対応する帳票ＩＤを取得します。
     *
     * @param 証発行モード 証発行モード
     * @param 出力対象 出力対象
     * @return 対応する帳票ID
     */
    static ReportId getReportId(RString 証発行モード, RString 出力対象) {
        ReportIdDBA reportId = ReportIdDBA.DBA200004;

        if (証発行モード_被保険者.equals(証発行モード)) {
            if (発行対象_発行管理リスト.equals(出力対象)) {
                reportId = ReportIdDBA.DBA200004;
            } else if (発行対象_未回収者リスト.equals(出力対象)) {
                reportId = ReportIdDBA.DBA201004;
            }
        } else if (証発行モード_資格者.equals(証発行モード)) {
            if (発行対象_発行管理リスト.equals(出力対象)) {
                reportId = ReportIdDBA.DBA202004;
            } else if (発行対象_未回収者リスト.equals(出力対象)) {
                reportId = ReportIdDBA.DBA203004;
            }
        }
        return reportId.getReportId();
    }

    /**
     * 証発行モードと対象区分から、対応するEUCエンティティID（連番）を取得します。
     *
     * @param 証発行モード 証発行モード
     * @param 出力対象 出力対象
     * @return 対応する帳票ID（連番）
     */
    static EucEntityId getEucEntityId連番(RString 証発行モード, RString 出力対象) {
        EucEntityIds eucEntityId = EucEntityIds.被保険者証発行管理リスト_連番_CSV;

        if (証発行モード_被保険者.equals(証発行モード)) {
            if (発行対象_発行管理リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.被保険者証発行管理リスト_連番_CSV;
            } else if (発行対象_未回収者リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.被保険者証未回収者リスト_連番_CSV;
            }
        } else if (証発行モード_資格者.equals(証発行モード)) {
            if (発行対象_発行管理リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.資格者証発行管理リスト_連番_CSV;
            } else if (発行対象_未回収者リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.資格者証未回収者リスト_連番_CSV;
            }
        }
        return eucEntityId.getEucEntityId();
    }

    /**
     * 証発行モードと対象区分から、対応するEUCエンティティIDを取得します。
     *
     * @param 証発行モード 証発行モード
     * @param 出力対象 出力対象
     * @return EUCエンティティID
     */
    static EucEntityId getEucEntityId(RString 証発行モード, RString 出力対象) {
        EucEntityIds eucEntityId = EucEntityIds.被保険者証発行管理リストCSV;

        if (証発行モード_被保険者.equals(証発行モード)) {
            if (発行対象_発行管理リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.被保険者証発行管理リストCSV;
            } else if (発行対象_未回収者リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.被保険者証未回収者リストCSV;
            }
        } else if (証発行モード_資格者.equals(証発行モード)) {
            if (発行対象_発行管理リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.資格者証発行管理リストCSV;
            } else if (発行対象_未回収者リスト.equals(出力対象)) {
                eucEntityId = EucEntityIds.資格者証未回収者リストCSV;
            }
        }
        return eucEntityId.getEucEntityId();
    }

    /**
     * EUCファイル出力条件表を出力します。
     *
     * @param processParameter バッチパラメータ
     * @return 出力条件情報
     */
    static void outputJokenhyoFactory(EucEntityId id, AkasiHakouKanriRelateEntity shoHakkoKanri, Association association,
            RString csvName, HihokenshashoHakkoKanriboProcessParameter processParameter, EucCsvWriter eucCsvWriter) {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                id.toRString(),
                association.get地方公共団体コード().value(),
                association.get市町村名(),
                new RString(String.valueOf(processParameter.getJobId())),
                shoHakkoKanri.getChouhouTitle(),
                csvName,
                new RString(String.valueOf(eucCsvWriter.getCount())),
                HihokenshashoHakkoKanriboCommonProcess.contribute(processParameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private static List<RString> contribute(HihokenshashoHakkoKanriboProcessParameter processParameter) {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(抽出条件);
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(出力対象);
        jokenBuilder.append(processParameter.getSiyuturiyokudaysyou());
        出力条件List.add(jokenBuilder.toRString());

        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(交付年月日);
        jokenBuilder.append(processParameter.getKoufukayisihi());
        jokenBuilder.append(カラ);
        jokenBuilder.append(processParameter.getKoufusiuryouhi());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(回収年月日);
        if (processParameter.getKasyuukayisihi().isEmpty()) {
            jokenBuilder.append("");
        } else {
            jokenBuilder.append(processParameter.getKasyuukayisihi());
            jokenBuilder.append(カラ);
            jokenBuilder.append(processParameter.getKasyuusiuryouhi());
        }

        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(交付事由);
        if (processParameter.getKofuJiyulist().size() > 0) {
            for (RString jiyu : processParameter.getKofuJiyulist()) {
                jokenBuilder.append(jiyu).append(区切り文字);
            }
            jokenBuilder.deleteCharAt(jokenBuilder.lastIndexOf(区切り文字));
        } else {
            jokenBuilder.append("交付事由なし");
        }
        出力条件List.add(jokenBuilder.toRString());

        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(回収事由);
        if (processParameter.getKaishuJiyulist().size() > 0) {
            for (RString jiyu : processParameter.getKaishuJiyulist()) {
                jokenBuilder.append(jiyu).append(区切り文字);
            }
            jokenBuilder.deleteCharAt(jokenBuilder.lastIndexOf(区切り文字));
        } else {
            jokenBuilder.append("回収事由なし");
        }
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }
}
