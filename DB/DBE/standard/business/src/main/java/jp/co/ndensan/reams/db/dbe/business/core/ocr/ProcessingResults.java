/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult.Type;

/**
 * 複数の{@link IProcessingResult}を保持します。
 */
public final class ProcessingResults implements IProcessingResults {

    private final Map<Type, List<IProcessingResult>> elements;

    /**
     * インスタンスを生成します。
     */
    public ProcessingResults() {
        elements = new HashMap<>();
        elements.put(Type.ERROR, new ArrayList<IProcessingResult>());
        elements.put(Type.WARNING, new ArrayList<IProcessingResult>());
        elements.put(Type.SUCCESS, new ArrayList<IProcessingResult>());
    }

    /**
     * @param pr 追加する{@link IProcessingResult}
     */
    @Override
    public void add(IProcessingResult pr) {
        this.elements.get(pr.type()).add(pr);
    }

    @Override
    public void addAll(IProcessingResults prs) {
        for (IProcessingResult pr : prs) {
            this.add(pr);
        }
    }

    @Override
    public boolean hasError() {
        return !this.elements.get(Type.ERROR).isEmpty();
    }

    /**
     * @return 保持する全要素
     */
    public List<IProcessingResult> values() {
        List<IProcessingResult> list = new ArrayList<>();
        for (List<IProcessingResult> e : this.elements.values()) {
            list.addAll(list);
        }
        return list;
    }

    @Override
    public Iterator<IProcessingResult> iterator() {
        return this.values().iterator();
    }

    @Override
    public boolean isEmpty() {
        for (List<IProcessingResult> list : elements.values()) {
            if (list.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<IOcrData> allOcrDataInError() {
        Set<IOcrData> set = new HashSet<>();
        for (IProcessingResult pr : this.elements.get(Type.ERROR)) {
            set.add(pr.ocrData());
        }
        return set;
    }

    @Override
    public Set<IOcrData> allOcrDataNotError() {
        Set<IOcrData> set = new HashSet<>();
        for (IProcessingResult pr : values()) {
            set.add(pr.ocrData());
        }
        set.removeAll(allOcrDataInError());
        return set;
    }
}
