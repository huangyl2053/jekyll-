/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.Collection;
import java.util.Set;

/**
 * 複数の{@link IProcessingResult}を扱うことを表します。
 */
public interface IProcessingResults extends Iterable<IProcessingResult> {

    /**
     * @return
     * 保持する要素に{@link IProcessingResult.Type#ERROR ERROR}を含む場合、{@code true}.
     */
    boolean hasError();

    /**
     * @return 空の場合、{@code true}.
     */
    boolean isEmpty();

    /**
     * @return エラーのない{@link IOcrData}すべて
     */
    Set<IOcrData> allOcrDataNotError();

    /**
     * @return エラーのある{@link IOcrData}すべて
     */
    Set<IOcrData> allOcrDataInError();

    /**
     * @return 保持するすべての{@link IProcessingResult}
     */
    Collection<IProcessingResult> values();
}
