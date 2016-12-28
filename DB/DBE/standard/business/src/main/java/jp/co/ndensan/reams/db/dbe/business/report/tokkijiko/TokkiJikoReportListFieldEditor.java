/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkijiko;

import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkijiko.TokkiJikoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項帳票のリストフィールド部分のEditorクラスです。
 */
public class TokkiJikoReportListFieldEditor implements ITokkiJikoReportListFieldEditor {

    private final RString 特記事項番号or項目名称;
    private final boolean isText;

    /**
     * コンストラクタです。
     *
     * @param 特記事項番号or項目名称 特記事項番号or項目名称
     * @param isText 短冊テキストに関するものならTrue、短冊イメージに関するものならFalse
     */
    public TokkiJikoReportListFieldEditor(RString 特記事項番号or項目名称, boolean isText) {
        this.特記事項番号or項目名称 = 特記事項番号or項目名称;
        this.isText = isText;
    }

    @Override
    public TokkiJikoReportSource edit(TokkiJikoReportSource source) {
        if (isText) {
            source.listChosa1_1 = 特記事項番号or項目名称;
        } else {
            source.listChosa_1 = 特記事項番号or項目名称;
        }
        return source;
    }

}
