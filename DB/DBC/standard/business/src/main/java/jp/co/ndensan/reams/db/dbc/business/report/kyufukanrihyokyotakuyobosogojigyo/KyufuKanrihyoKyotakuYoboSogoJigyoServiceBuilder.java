/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyokyotakuyobosogojigyo;

import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyokyotakuyobosogojigyo.KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 給付管理票のBuilderクラスです。
 *
 * @reamsid_L DBC-2840-040 sunhaidi
 */
public class KyufuKanrihyoKyotakuYoboSogoJigyoServiceBuilder implements IKyufuKanrihyoKyotakuYoboSogoJigyoServiceBuilder {

    private final IKyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor
     */
    public KyufuKanrihyoKyotakuYoboSogoJigyoServiceBuilder(
            IKyufuKanrihyoKyotakuYoboSogoJigyoServiceEditor editor) {
        this.editor = editor;
    }

    @Override
    public KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource build() {
        return ReportEditorJoiner.from(new KyufuKanrihyoKyotakuYoboSogoJigyoServiceReportSource()).join(editor).buildSource();
    }
}
