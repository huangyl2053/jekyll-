/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choteibo;

import jp.co.ndensan.reams.db.dbb.entity.report.choteibo.ChoteiboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票の編集Editorです。
 *
 * @reamsid_L DBB-0770-050 zhangrui
 */
class ChoteiboBuilder implements IChoteiboBuilder {

    private final IChoteiboEditor headerEditor;
    private final IChoteiboEditor kitsukiEditor;
    private final IChoteiboEditor dankaiEditor;
    private final IChoteiboEditor dankaiGokeiEditor;

    /**
     * コンストラクタです。
     *
     * @param headerEditor ヘッダ編集
     * @param kitsukiEditor 期別編集
     * @param dankaiEditor 段階編集
     * @param dankaiGokeiEditor 段階合計編集
     */
    public ChoteiboBuilder(
            IChoteiboEditor headerEditor,
            IChoteiboEditor kitsukiEditor,
            IChoteiboEditor dankaiEditor,
            IChoteiboEditor dankaiGokeiEditor) {
        this.headerEditor = headerEditor;
        this.kitsukiEditor = kitsukiEditor;
        this.dankaiEditor = dankaiEditor;
        this.dankaiGokeiEditor = dankaiGokeiEditor;
    }

    @Override
    public ChoteiboSource build() {
        return ReportEditorJoiner.from(new ChoteiboSource())
                .join(headerEditor)
                .join(kitsukiEditor)
                .join(dankaiEditor)
                .join(dankaiGokeiEditor)
                .buildSource();
    }

}
