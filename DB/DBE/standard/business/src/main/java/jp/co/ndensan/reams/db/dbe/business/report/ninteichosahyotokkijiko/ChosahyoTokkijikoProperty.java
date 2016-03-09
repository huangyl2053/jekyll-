/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（特記事項）のプロパティです。
 */
public class ChosahyoTokkijikoProperty extends ReportPropertyBase<ChosahyoTokkijikoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoTokkijikoProperty() {
        // TODO 内部QA:667 Redmine#:75887 (四つ帳票formファイルがあるので、処置に惑います。)
        // TODO 内部QA:842 Redmine#:78381 (改ページ設定は必要がないと思います。)
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE221022_1.getReportId());
    }
}
