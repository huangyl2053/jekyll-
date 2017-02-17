/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.LayoutBreaker;

/**
 * 主治医意見書のレイアウトブレイククラスです。
 *
 * @author N3212 竹内 和紀
 */
public class ShujiiikenshoLaypoutBreaker extends LayoutBreaker<ShujiiikenshoReportSource> {

    @Override
    public List<RString> breakKeys() {
        return NinteiChosaTokkiImageReportSource.LAYOUT_BREAK_KEYS;
    }
}
