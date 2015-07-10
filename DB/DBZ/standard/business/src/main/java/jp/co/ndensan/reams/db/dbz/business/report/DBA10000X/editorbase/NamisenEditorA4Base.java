/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証A4版でのみ必要な、期間を表す波線を設定するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class NamisenEditorA4Base {

    private static final RString NAMISEN;

    static {
        NAMISEN = new RString("～");
    }

    /**
     * 帳票ソースに波線を設定します。
     *
     * @param source 被保険者証A4版帳票ソース
     */
    public void set波線(IHihokenshashoA4CommonEditData source) {
        source.setYukokikannamisen(NAMISEN);
        source.setHomonkikannamisen(NAMISEN);
    }

}
