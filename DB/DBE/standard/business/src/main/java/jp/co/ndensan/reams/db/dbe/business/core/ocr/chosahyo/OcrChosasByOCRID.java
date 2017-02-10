/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;

/**
 * {@link OCRID}をキーに{@link OcrChosas}を管理します。
 */
public class OcrChosasByOCRID {

    private final Map<OCRID, OcrChosas> map;

    OcrChosasByOCRID(Map<OCRID, OcrChosas> map) {
        this.map = map;
    }

    /**
     * @param ocrID {@link OCRID}
     * @return {@link OcrChosas}
     */
    public OcrChosas get(OCRID ocrID) {
        OcrChosas o = this.map.get(ocrID);
        return o == null ? new OcrChosas(new ArrayList<OcrChosa>()) : o;
    }

    /**
     * @param ocrIDs {@link OCRID}複数
     * @return 指定のOCRIDのみの要素を保持した{@link OcrChosasByOCRID}
     */
    public OcrChosasByOCRID getAll(Iterable<? extends OCRID> ocrIDs) {
        Map<OCRID, OcrChosas> passed = new HashMap<>();
        for (OCRID ocrID : ocrIDs) {
            if (this.map.containsKey(ocrID)) {
                passed.put(ocrID, this.map.get(ocrID));
            }
        }
        return new OcrChosasByOCRID(passed);
    }

    /**
     * @param size 閾値となる要素数
     * @return 指定のsizeと要素の数が一致する{@link OcrChosasByOCRID}
     */
    public OcrChosasByOCRID filterdSizeIs(int size) {
        Map<OCRID, OcrChosas> passed = new HashMap<>();
        for (Entry entry : entrySet()) {
            if (entry.getOcrChosas().size() == size) {
                passed.put(entry.getOCRID(), entry.getOcrChosas());
            }
        }
        return new OcrChosasByOCRID(passed);
    }

    /**
     * @param keys 取り除くキーの値
     * @return 指定のキーと対応する{@link OcrChosas}を取り除いたビュー
     */
    public OcrChosasByOCRID removed(Iterable<? extends OCRID> keys) {
        Map<OCRID, OcrChosas> newMap = new HashMap<>(map);
        for (OCRID ocrID : keys) {
            newMap.remove(ocrID);
        }
        return new OcrChosasByOCRID(newMap);
    }

    /**
     * @return 保持するすべての{@link OcrChosas}
     */
    public OcrChosas values() {
        List<OcrChosa> list = new ArrayList<>();
        for (OcrChosas ocrChosas : map.values()) {
            list.addAll(ocrChosas.toList());
        }
        return new OcrChosas(list);
    }

    /**
     * @return すべてのキー
     */
    public Set<OCRID> keySet() {
        return this.map.keySet();
    }

    /**
     * @return 保持する全要素を{@link OcrChosasByOCRID.Entry}のペアに変換した結果
     */
    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet<>();
        for (Map.Entry<OCRID, OcrChosas> entry : this.map.entrySet()) {
            set.add(new Entry(entry.getKey(), entry.getValue()));
        }
        return set;
    }

    /**
     * {@link OCRID}と対応する{@link OcrChosas}を保持します。
     */
    public static final class Entry {

        private final OCRID ocrID;
        private final OcrChosas ocrChosas;

        private Entry(OCRID ocrID, OcrChosas ocrChosas) {
            this.ocrID = ocrID;
            this.ocrChosas = ocrChosas;
        }

        /**
         * @return キーの{@link OCRID}
         */
        public OCRID getOCRID() {
            return this.ocrID;
        }

        /**
         * @return キーと対応する{@link OcrChosas}
         */
        public OcrChosas getOcrChosas() {
            return this.ocrChosas;
        }
    }
}
