/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link OcrChosa}内の基本調査項目の値を取得します。
 */
public interface INinteiChosahyoChosaItemAccessor {

    /**
     * @param 連番 連番
     * @return 指定の連番に対応する値. 存在しない場合、{@link RString#EMPTY}.
     */
    RString valueOf(int 連番);
}
