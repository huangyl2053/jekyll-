/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;

/**
 * {@link OcrChosa}内のサービスの状況フラグ関連の値を取得します。
 */
public interface INinteiChosahyoServiceJokyoFlagAccessor {

    /**
     * @param 連番 連番
     * @return 指定の連番に対応する値.
     */
    Optional<Boolean> valueOf(int 連番);
}
