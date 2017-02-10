/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.Filterd;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;

/**
 * 複数の{@link OcrIken}を扱います。
 */
public class OcrIkens implements Iterable<OcrIken> {

    private final List<OcrIken> elements;

    /**
     * @param elements 保持する要素
     */
    public OcrIkens(Collection<? extends OcrIken> elements) {
        this.elements = new ArrayList<>(elements);
    }

    /**
     * @return 正常なレコードのみ
     */
    public Filterd<OcrIkens> filterdNormal() {
        List<OcrIken> normals = new ArrayList<>();
        List<OcrIken> brokens = new ArrayList<>();
        for (OcrIken o : this) {
            if (o.isBroken()) {
                brokens.add(o);
            } else {
                normals.add(o);
            }
        }
        return new Filterd<>(new OcrIkens(normals), new OcrIkens(brokens));
    }

    /**
     * @param ocrID OCRID
     * @param anyOCRIDs OCRID
     * @return 指定のOCRIDに合致する要素すべて
     */
    public OcrIkens filterdByOCRIDs(OCRID ocrID, OCRID... anyOCRIDs) {
        Set<OCRID> ocrIDs = new HashSet<>();
        ocrIDs.addAll(Collections.singleton(ocrID));
        ocrIDs.addAll(Arrays.asList(anyOCRIDs));

        List<OcrIken> list = new ArrayList<>();
        for (OcrIken o : this) {
            if (ocrIDs.contains(o.getOCRID())) {
                list.add(o);
            }
        }
        return new OcrIkens(list);
    }

    @Override
    public Iterator<OcrIken> iterator() {
        return this.elements.iterator();
    }

    /**
     * @return 要素数
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * @return 一件の要素も保持しない場合、{@code true}.
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    /**
     * @param ocrID OCRID
     * @return 指定のOCRIDに該当する要素
     */
    public Optional<OcrIken> findByOCRID(OCRID ocrID) {
        for (OcrIken o : this) {
            if (o.getOCRID() == ocrID) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }

    /**
     * @return {@link List}形式のビュー
     */
    public List<OcrIken> asList() {
        return new ArrayList<>(this.elements);
    }

    /**
     * @param 優先順 優先順に列挙したOCRID
     * @return 優先順に従い検索し、該当する物があれば、その要素
     */
    public Optional<OcrIken> findByOCRIDPrioritizing(OCRID... 優先順) {
        for (OCRID ocrID : 優先順) {
            Optional<OcrIken> o = findByOCRID(ocrID);
            if (o.isPresent()) {
                return o;
            }
        }
        return Optional.empty();
    }

    /**
     * @param ocrData 取り除きたい要素
     * @return 指定の要素を取り除いた新しいインスタンス
     */
    public OcrIkens removed(Collection<? extends IOcrData> ocrData) {
        List<OcrIken> list = new ArrayList<>();
        for (OcrIken o : this) {
            if (!ocrData.contains(o)) {
                list.add(o);
            }
        }
        return new OcrIkens(list);
    }
}
