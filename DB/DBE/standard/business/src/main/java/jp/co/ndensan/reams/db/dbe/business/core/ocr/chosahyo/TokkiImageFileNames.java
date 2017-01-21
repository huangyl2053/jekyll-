/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
//CHECKSTYLE IGNORE UnusedImports FOR NEXT 1 LINES
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;

/**
 * 複数の{@link TokkiImageFileName}を扱います。
 */
public class TokkiImageFileNames implements Iterable<TokkiImageFileName> {

    private final List<TokkiImageFileName> elements;

    TokkiImageFileNames(Collection<? extends TokkiImageFileName> collection) {
        this.elements = new ArrayList<>(collection);
    }

    /**
     * @return {@link KomokuNo}が空の要素を除外した新しいインスタンス
     */
    public TokkiImageFileNames removedEmptyKomokuNo() {
        List<TokkiImageFileName> list = new ArrayList<>();
        for (TokkiImageFileName a : this.elements) {
            if (!a.komokuNo().isEmpty()) {
                list.add(a);
            }
        }
        return new TokkiImageFileNames(list);
    }

    /**
     * @return {@link KomokuNo}が空の要素だけの新しいインスタンス
     */
    public TokkiImageFileNames onlyEmptyKomokuNo() {
        List<TokkiImageFileName> list = new ArrayList<>();
        for (TokkiImageFileName a : this.elements) {
            if (a.komokuNo().isEmpty()) {
                list.add(a);
            }
        }
        return new TokkiImageFileNames(list);
    }

    /**
     * @return ファイル名の文字列だけの{@link List}
     */
    public List<RString> fileNameValues() {
        List<RString> list = new ArrayList<>();
        for (TokkiImageFileName fileName : this.elements) {
            list.add(fileName.value());
        }
        return list;
    }

    /**
     * @return {@link List}に変換した結果
     */
    public List<TokkiImageFileName> toList() {
        return new ArrayList<>(this.elements);
    }

    @Override
    public Iterator<TokkiImageFileName> iterator() {
        return this.elements.iterator();
    }

    /**
     * @return ファイル数
     */
    public int size() {
        return this.elements.size();
    }
}
