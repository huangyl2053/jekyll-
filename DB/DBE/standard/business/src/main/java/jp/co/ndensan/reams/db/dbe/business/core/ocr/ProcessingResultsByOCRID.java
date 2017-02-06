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

    private final Map<OCRID, IProcessingResults> elements;

    /**
     * 空のインスタンスを生成します。
     */
    public ProcessingResultsByOCRID() {
        this.elements = new HashMap<>();
    }

    private ProcessingResultsByOCRID(Map<OCRID, IProcessingResults> map) {
        this.elements = new HashMap<>(map);
    }

    /**
     * @param ocrID OCRID
     * @return 指定のOCRIDに該当する{@link IProcessingResults}
     */
    public IProcessingResults get(OCRID ocrID) {
        if (this.elements.containsKey(ocrID)) {
            return this.elements.get(ocrID);
        }
        return new ProcessingResults();
    }

    /**
     * @return エラーの要素
     */
    public ProcessingResultsByOCRID errors() {
        Map<OCRID, IProcessingResults> map = new HashMap<>();
        for (Map.Entry<OCRID, IProcessingResults> entry : this.elements.entrySet()) {
            IProcessingResults prs = entry.getValue();
            if (prs.hasError()) {
                map.put(entry.getKey(), prs);
            }
        }
        return new ProcessingResultsByOCRID(map);
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
    public void add(OCRID key, IProcessingResults prs) {
        for (IProcessingResult pr : prs) {
            add(key, pr);
        }
    }

    /**
     * @param pr すべてのキーに紐付ける{@link IProcessingResult}
     */
    public void addToAll(IProcessingResult pr) {
        for (Map.Entry<OCRID, IProcessingResults> entry : this.elements.entrySet()) {
            entry.getValue().add(pr);
        }
    }

    /**
     * 指定の{@link ProcessingResultsByOCRID}のすべての値を追加します。
     *
     * @param other 追加する{@link ProcessingResultsByOCRID}
     */
    public void addAll(ProcessingResultsByOCRID other) {
        for (Map.Entry<OCRID, IProcessingResults> entry : other.elements.entrySet()) {
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
        for (Map.Entry<OCRID, IProcessingResults> prs : this.elements.entrySet()) {
            set.add(new Entry(prs.getKey(), prs.getValue()));
        }
        return set;
    }

    /**
     * {@link OCRID}と対応する{@link ProcessingResultsByOCRID}を保持します。
     */
    public static final class Entry {

        private final OCRID ocrID;
        private final IProcessingResults prs;

        private Entry(OCRID ocrID, IProcessingResults prs) {
            this.ocrID = ocrID;
            this.prs = prs;
        }

        /**
         * @return キーの{@link OCRID}
         */
        public OCRID getOCRID() {
            return this.ocrID;
        }

        /**
         * @return キーと対応する{@link IProcessingResults}
         */
        public IProcessingResults getResults() {
            return this.prs;
        }
    }
}
