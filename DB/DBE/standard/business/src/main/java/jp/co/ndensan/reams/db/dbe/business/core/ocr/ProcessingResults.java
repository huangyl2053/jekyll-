/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    /**
     * 空のインスタンスです。
     */
    public static final IProcessingResults EMPTY;

    static {
        EMPTY = new IProcessingResults() {
            @Override
            public boolean hasError() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return true;
            }

            @Override
            public Set<IOcrData> allOcrDataNotError() {
                return Collections.emptySet();
            }

            @Override
            public Set<IOcrData> allOcrDataInError() {
                return Collections.emptySet();
            }

            @Override
            public Collection<IProcessingResult> values() {
                return Collections.emptyList();
            }

            @Override
            public Iterator<IProcessingResult> iterator() {
                return Collections.emptyIterator();
            }
        };
    }

    private final Map<Type, List<IProcessingResult>> elements;
    private final Set<IOcrData> keySet;

    /**
     * インスタンスを生成します。
     */
    public ProcessingResults() {
        this.elements = new HashMap<>();
        this.elements.put(Type.ERROR, new ArrayList<IProcessingResult>());
        this.elements.put(Type.WARNING, new ArrayList<IProcessingResult>());
        this.elements.put(Type.SUCCESS, new ArrayList<IProcessingResult>());
        this.keySet = new HashSet<>();
    }

    /**
     * 指定の{@link IProcessingResults}を保持するインスタンスを生成します。
     *
     * @param results 最初に保持する{@link IProcessingResults}
     */
    public ProcessingResults(IProcessingResults results) {
        this();
        this.addAll(results);
    }

    /**
     * 指定の{@link IProcessingResult}を保持するインスタンスを生成します。
     *
     * @param result 最初に保持する{@link IProcessingResults}
     */
    public ProcessingResults(IProcessingResult result) {
        this();
        this.add(result);
    }

    /**
     * @param ocrData
     */
    public void addSuccessIfNotContains(IOcrData ocrData) {
        if (!this.keySet.contains(ocrData)) {
            this.add(ProcessingResultFactory.success(ocrData));
        }
    }

    /**
     * @param pr 追加する{@link IProcessingResult}
     */
    public void add(IProcessingResult pr) {
        this.elements.get(pr.type()).add(pr);
        this.keySet.add(pr.ocrData());
    }

    /**
     * 指定の{@link IProcessingResults}が保持する{@link IProcessingResult}をすべて追加します。
     *
     * @param prs 追加する{@link IProcessingResults}
     */
    public void addAll(IProcessingResults prs) {
        for (IProcessingResult pr : prs) {
            this.add(pr);
        }
    }

    @Override
    public boolean hasError() {
        return !this.elements.get(Type.ERROR).isEmpty();
    }

    @Override
    public Collection<IProcessingResult> values() {
        List<IProcessingResult> list = new ArrayList<>();
        for (List<IProcessingResult> e : this.elements.values()) {
            list.addAll(e);
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
        Set<IOcrData> set = new HashSet<>(this.keySet);
        set.removeAll(allOcrDataInError());
        return set;
    }
}
