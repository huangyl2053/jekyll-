/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.LayoutBreaker;

/**
 *
 * @author n3502
 */
public class NinteiChosaTokkiImageLaypoutBreaker extends LayoutBreaker<NinteiChosaTokkiImageReportSource> {

    @Override
    public List<RString> breakKeys() {
        return NinteiChosaTokkiImageReportSource.LAYOUT_BREAK_KEYS;
    }

}
