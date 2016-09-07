/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokujyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo.AtenaKikan;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosatokusokujyo.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査督促状のReportです。
 *
 * @reamsid_L DBE-0030-020 xuyue
 */
public class NinteiChosaTokusokujoReport extends Report<NinteiChosaTokusokujoReportSource> {

    private final DbT5101NinteiShinseiJohoEntity entity;
    private final NinshoshaSource ninshoshaSource;
    private final RString 文書番号;
    private final Map<Integer, RString> 通知文;
    private final AtenaKikan atenaKikan;
    private final RString customerBarCode;

    /**
     * コンストラクタです。
     *
     * @param entity {@link DbT5101NinteiShinseiJohoEntity}
     * @param ninshoshaSource 認証者ソース
     * @param atenaKikan 宛名機関
     * @param 文書番号 文書番号
     * @param 通知文 通知文
     * @param customerBarCode customerBarCode
     */
    public NinteiChosaTokusokujoReport(DbT5101NinteiShinseiJohoEntity entity, NinshoshaSource ninshoshaSource,
            AtenaKikan atenaKikan,
            RString 文書番号,
            Map<Integer, RString> 通知文, RString customerBarCode) {

        this.entity = entity;
        this.ninshoshaSource = ninshoshaSource;
        this.atenaKikan = atenaKikan;
        this.文書番号 = 文書番号;
        this.通知文 = 通知文;
        this.customerBarCode = customerBarCode;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter) {

        INinteiChosaTokusokujoEditor bodyEditor
                = new NinteiChosaTokusokujoBodyEditor(entity, ninshoshaSource, atenaKikan, 文書番号, 通知文, customerBarCode);
        INinteiChosaTokusokujoBuilder builder = new NinteiChosaTokusokujoBuilderImpl(bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
