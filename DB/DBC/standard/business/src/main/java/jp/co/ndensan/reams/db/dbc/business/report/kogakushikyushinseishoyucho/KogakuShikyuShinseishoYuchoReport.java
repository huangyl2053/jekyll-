/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseishoyucho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護（予防）サービス費支給申請書（ゆうちょ）の出力クラスです。
 *
 * @reamsid_L DBC-4770-070 jianglaisheng
 */
public class KogakuShikyuShinseishoYuchoReport extends Report<KogakuShikyuShinseishoYuchoSource> {

    private final KogakuShikyuShinseishoYuchoEntity target;

    /**
     * コンストラクタです。
     *
     * @param target target
     */
    public KogakuShikyuShinseishoYuchoReport(KogakuShikyuShinseishoYuchoEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuShinseishoYuchoSource> writer) {
        IKogakuShikyuShinseishoYuchoEditor editor = new KogakuShikyuShinseishoYuchoEditor(target);
        IKogakuShikyuShinseishoYuchoBuilder builder = new KogakuShikyuShinseishoYuchoBuilder(editor);
        writer.writeLine(builder);
    }

}
