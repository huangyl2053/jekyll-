/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.Collection;
import java.util.Set;

/**
 *
 */
public interface IProcessingResults extends Iterable<IProcessingResult> {

    /**
     * 指定の{@link IProcessingResult}を追加します。
     *
     * @param pr 追加する{@link IProcessingResult}
     */
    void add(IProcessingResult pr);

    /**
     * 指定の{@link IProcessingResults}が保持する{@link IProcessingResult}をすべて追加します。
     *
     * @param prs 追加する{@link IProcessingResults}
     */
    void addAll(IProcessingResults prs);

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
     * @return
     */
    Set<IOcrData> allOcrDataNotError();

    /**
     * @return
     */
    Set<IOcrData> allOcrDataInError();

    /**
     * @return
     */
    Collection<IProcessingResult> values();
}
