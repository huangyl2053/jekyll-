/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuShikyuShinseisho;

import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho.IKogakuShikyuShinseishoBuilder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho.IKogakuShikyuShinseishoEditor;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho.KogakuShikyuShinseishoBuilder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho.KogakuShikyuShinseishoEditor;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護（予防）サービス費支給申請書帳票Reportラクタです。
 *
 * @author @reamsid_L DBC-4770-060 jiangxiaolong
 */
public class KogakuShikyuShinseishoReport extends
        Report<KogakuShikyuShinseishoSource> {

    private final KogakuShikyuShinseishoEntity target;

    /**
     * コンストラクタです。
     *
     * @param target target
     */
    public KogakuShikyuShinseishoReport(KogakuShikyuShinseishoEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuShinseishoSource> writer) {
        IKogakuShikyuShinseishoEditor editor = new KogakuShikyuShinseishoEditor(target);
        IKogakuShikyuShinseishoBuilder builder = new KogakuShikyuShinseishoBuilder(editor);
        writer.writeLine(builder);
    }

}
