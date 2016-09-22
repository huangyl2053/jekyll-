/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200012;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.KyuhuJissekiMeisai;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.TokubetsuChiikiKasanKeigenJissekiKanri;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 特別地域加算軽減実績管理リストのReportです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public final class TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport extends
        Report<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> {

    private static final int LISTINDEX_3 = 3;

    private final TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 TokubetsuChiikiKasanKeigenJissekiKanri
     * @param association Association
     * @param iOutputOrder IOutputOrder
     */
    public TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport(
            TokubetsuChiikiKasanKeigenJissekiKanri 帳票情報, Association association,
            IOutputOrder iOutputOrder) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> writer) {

        if (帳票情報.get給付実績被保険者リスト() != null && !帳票情報.get給付実績被保険者リスト().isEmpty()) {
            int 給付実績明細リストCount = 0;

            for (int i = 0; i < 帳票情報.get給付実績被保険者リスト().size(); i++) {
                List<KyuhuJissekiMeisai> 給付実績明細Data = 帳票情報.get給付実績被保険者リスト().get(i).get給付実績明細リスト();
                if (給付実績明細Data != null && !給付実績明細Data.isEmpty()) {
                    給付実績明細リストCount = 給付実績明細Data.size();
                }
                if (i + 1 == 帳票情報.get給付実績被保険者リスト().size()) {
                    get明細(i, 給付実績明細リストCount, writer);
                } else {
                    非事業所計(給付実績明細リストCount, writer, i);
                }
            }
        } else {
            ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(
                    帳票情報, association, iOutputOrder, null, -1, -1);
            ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder builder = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(bodyEditor);
            writer.writeLine(builder);
        }
    }

    private void 非事業所計(int 給付実績明細リストCount, ReportSourceWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> writer, int i) {
        if (給付実績明細リストCount <= 1) {
            for (int j = 0; j < LISTINDEX_3; j++) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(帳票情報.get給付実績被保険者リスト().get(i).get宛名());
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(
                                帳票情報, association, iOutputOrder, 宛名, j, i);
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder builder
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(bodyEditor);
                writer.writeLine(builder);
            }
        } else {
            for (int j = 0; j < 給付実績明細リストCount + 1; j++) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(帳票情報.get給付実績被保険者リスト().get(i).get宛名());
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(
                                帳票情報, association, iOutputOrder, 宛名, j, i);
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder builder
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(bodyEditor);
                writer.writeLine(builder);
            }
        }
    }

    private void get明細(int i, int 給付実績明細リストCount,
            ReportSourceWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> writer) {
        if (1 == 給付実績明細リストCount) {
            for (int j = 0; j <= 給付実績明細リストCount + 2; j++) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(帳票情報.get給付実績被保険者リスト().get(i).get宛名());
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(
                                帳票情報, association, iOutputOrder, 宛名, j, i);
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder builder
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(bodyEditor);
                writer.writeLine(builder);
            }
        } else {
            for (int j = 0; j <= 給付実績明細リストCount + 1; j++) {
                IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(帳票情報.get給付実績被保険者リスト().get(i).get宛名());
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor bodyEditor
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranEditor(
                                帳票情報, association, iOutputOrder, 宛名, j, i);
                ITokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder builder
                        = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranBuilder(bodyEditor);
                writer.writeLine(builder);
            }
        }
    }
}
