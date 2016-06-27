/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事務局用予備判定記入表のBuilderクラスです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoBuilder implements IJimukyokuyoYobihanteiKinyuhyoBuilder {

    private final IJimukyokuyoYobihanteiKinyuhyoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJimukyokuyoYobihanteiKinyuhyoEditor}
     */
    public JimukyokuyoYobihanteiKinyuhyoBuilder(IJimukyokuyoYobihanteiKinyuhyoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JimukyokuyoYobihanteiKinyuhyoReportSource}
     */
    @Override
    public JimukyokuyoYobihanteiKinyuhyoReportSource build() {
        return ReportEditorJoiner.from(new JimukyokuyoYobihanteiKinyuhyoReportSource()).join(editor).buildSource();
    }
}
