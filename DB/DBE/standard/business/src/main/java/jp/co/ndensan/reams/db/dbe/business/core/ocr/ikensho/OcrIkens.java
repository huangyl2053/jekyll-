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
 *
 */
public class OcrIkens implements Iterable<OcrIken> {

    private final List<OcrIken> elements;

    /**
     * @param elements
     */
    public OcrIkens(Collection<? extends OcrIken> elements) {
        this.elements = new ArrayList<>(elements);
    }

    /**
     *
     * @return
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

    public int size() {
        return this.elements.size();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public Optional<OcrIken> findByOCRID(OCRID ocrID) {
        for (OcrIken o : this) {
            if (o.getOCRID() == ocrID) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }

    public List<OcrIken> asList() {
        return new ArrayList<>(this.elements);
    }

    public Optional<OcrIken> findByOCRIDPrioritizing(OCRID... 優先順) {
        for (OCRID ocrID : 優先順) {
            Optional<OcrIken> o = findByOCRID(ocrID);
            if (o.isPresent()) {
                return o;
            }
        }
        return Optional.empty();
    }

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
