/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;

/**
 * {@link OCRID}をキーに{@link ProcessingResults}を管理します。
 */
public class ProcessingResultsByOCRID {

    private final Map<OCRID, ProcessingResults> elements;

    /**
     * 空のインスタンスを生成します。
     */
    public ProcessingResultsByOCRID() {
        this.elements = new HashMap<>();
    }

    private ProcessingResultsByOCRID(Map<OCRID, ProcessingResults> map) {
        this.elements = new HashMap<>(map);
    }

    /**
     * @return エラーの要素
     */
    public ProcessingResultsByOCRID errors() {
        Map<OCRID, ProcessingResults> map = new HashMap<>();
        for (Map.Entry<OCRID, ProcessingResults> entry : this.elements.entrySet()) {
            IProcessingResult pr = entry.getValue().get();
            if (pr.type().isError()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return new ProcessingResultsByOCRID(map);
    }

    /**
     * @param ocrID キーとなる{@link OCRID}
     * @param defaultValue 指定のキーと対応する値が存在しない場合に返却する値
     * @return 指定のキーと対応する{@link IProcessingResult}.
     * 存在しない場合、{@code defaultValue}.
     */
    public IProcessingResult getResultOrDefault(OCRID ocrID, IProcessingResult defaultValue) {
        if (this.elements.containsKey(ocrID)) {
            return this.elements.get(ocrID).get();
        }
        return defaultValue;
    }

    /**
     * @param key キーとなる{@link OCRID}
     * @param pr キーに紐付ける{@link IProcessingResult}
     */
    public void add(OCRID key, IProcessingResult pr) {
        if (this.elements.containsKey(key)) {
            ProcessingResults prs = new ProcessingResults();
            this.elements.put(key, prs);
        }
        this.elements.get(key).add(pr);
    }

    /**
     * @param key キーとなる{@link OCRID}
     * @param prs キーに紐付ける{@link ProcessingResults}
     */
    public void add(OCRID key, ProcessingResults prs) {
        for (IProcessingResult pr : prs.values()) {
            add(key, pr);
        }
    }

    /**
     * @param pr すべてのキーに紐付ける{@link IProcessingResult}
     */
    public void addToAll(IProcessingResult pr) {
        for (Map.Entry<OCRID, ProcessingResults> entry : this.elements.entrySet()) {
            entry.getValue().add(pr);
        }
    }

    /**
     * 指定の{@link ProcessingResultsByOCRID}のすべての値を追加します。
     *
     * @param other 追加する{@link ProcessingResultsByOCRID}
     */
    public void addAll(ProcessingResultsByOCRID other) {
        for (Map.Entry<OCRID, ProcessingResults> entry : other.elements.entrySet()) {
            this.add(entry.getKey(), entry.getValue());
        }
    }

    /**
     * @return すべてのキーのビュー
     */
    public Set<OCRID> keySet() {
        return this.elements.keySet();
    }

    /**
     * @return 保持する全要素を{@link ProcessingResultsByOCRID.Entry}のペアに変換した結果
     */
    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet<>();
        for (Map.Entry<OCRID, ProcessingResults> prs : this.elements.entrySet()) {
            set.add(new Entry(prs.getKey(), prs.getValue()));
        }
        return set;
    }

    /**
     * {@link OCRID}と対応する{@link ProcessingResultsByOCRID}を保持します。
     */
    public static final class Entry {

        private final OCRID ocrID;
        private final IProcessingResult pr;

        private Entry(OCRID ocrID, ProcessingResults prs) {
            this.ocrID = ocrID;
            this.pr = prs.get();
        }

        /**
         * @return キーの{@link OCRID}
         */
        public OCRID getOCRID() {
            return this.ocrID;
        }

        /**
         * @return キーと対応する{@link IProcessingResult}
         */
        public IProcessingResult getResult() {
            return this.pr;
        }
    }
}
