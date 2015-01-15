/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoB4CommonEditData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証B4版でのみ印字が必要な、居宅サービス関連の文言を設定するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class ServiceTaniEditorB4Base {

    private static final RString ONE_MONTH_ATARI;

    static {
        ONE_MONTH_ATARI = new RString("1月当たり");
    }

    /**
     * 帳票ソースに文言を設定します。
     *
     * @param source 被保険者証B4版帳票ソース
     */
    public void set1月当たり(IHihokenshashoB4CommonEditData source) {
        source.setServicetani1(ONE_MONTH_ATARI);
    }

}
