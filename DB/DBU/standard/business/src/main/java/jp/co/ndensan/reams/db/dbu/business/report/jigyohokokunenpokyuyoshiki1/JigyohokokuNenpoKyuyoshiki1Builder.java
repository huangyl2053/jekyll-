/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpokyuyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業状況報告年報（様式１・２　所得段階）のクラスです。
 *
 * @reamsid_L DBU-5610-060 kanghongsong
 */
class JigyohokokuNenpoKyuyoshiki1Builder implements IJigyohokokuNenpoKyuyoshiki1Builder {

    private final IJigyohokokuNenpoKyuyoshiki1Editor headerEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor {@link IJigyohokokuNenpoKyuyoshiki1Editor}
     */
    public JigyohokokuNenpoKyuyoshiki1Builder(IJigyohokokuNenpoKyuyoshiki1Editor headerEditor) {
        this.headerEditor = headerEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JigyohokokuNenpoKyuyoshiki1ReportSource}
     */
    @Override
    public JigyohokokuNenpoKyuyoshiki1ReportSource build() {
        return ReportEditorJoiner.from(new JigyohokokuNenpoKyuyoshiki1ReportSource()).join(headerEditor).buildSource();
    }

}
