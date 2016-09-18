/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuidojohokensuhyo.TokuChoYidoKensu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Report
 *
 * @reamsid_L DBB-1840-090 lihang
 */
public class TokubetsuChoshuIdojohoKensuhyoReport extends Report<TokubetsuChoshuIdojohoKensuhyoSource> {

    private final TokuChoYidoKensu 特徴異動件数Entity;
    private final YMDHMS 作成日時;
    private final FlexibleYear 賦課年度;
    private final RString 処理対象月;

    /**
     * コンストラクタです。
     *
     * @param 特徴異動件数Entity TokubetsuChoshuIdojohoKensuhyoEntity
     * @param 作成日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param 処理対象月 RString
     */
    public TokubetsuChoshuIdojohoKensuhyoReport(
            TokuChoYidoKensu 特徴異動件数Entity,
            YMDHMS 作成日時,
            FlexibleYear 賦課年度,
            RString 処理対象月) {

        this.特徴異動件数Entity = 特徴異動件数Entity;
        this.作成日時 = 作成日時;
        this.賦課年度 = 賦課年度;
        this.処理対象月 = 処理対象月;
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuIdojohoKensuhyoSource> writer) {

        ITokubetsuChoshuIdojohoKensuhyoEditor editor
                = new TokubetsuChoshuIdojohoKensuhyoEditor(特徴異動件数Entity, 作成日時, 賦課年度, 処理対象月);
        ITokubetsuChoshuIdojohoKensuhyoBuilder builder
                = new TokubetsuChoshuIdojohoKensuhyoBuilder(editor);
        writer.writeLine(builder);

    }
}
