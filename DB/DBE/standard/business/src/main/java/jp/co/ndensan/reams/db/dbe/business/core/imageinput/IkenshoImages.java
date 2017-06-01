/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 複数の{@link IkenshoImageJoho}を扱います。
 */
public class IkenshoImages implements Iterable<IkenshoImageJoho> {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final int rirekiNo;
    private final Map<RString, IkenshoImageJoho> gemponByChohyoID;
    private final Map<RString, IkenshoImageJoho> maskedByChohyoID;

    IkenshoImages(ShinseishoKanriNo shinseishoKanriNo, int rirekiNo, List<DbT5305IkenshoImageJohoEntity> entities) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.rirekiNo = rirekiNo;
        Map<RString, IkenshoImageJoho> map = new HashMap<>();
        Map<RString, IkenshoImageJoho> map2 = new HashMap<>();
        for (DbT5305IkenshoImageJohoEntity entity : entities) {
            if (GenponMaskKubun.原本.getコード().equals(entity.getGenponMaskKubun())) {
                map.put(entity.getChoyoID().value(), new IkenshoImageJoho(entity));
            } else {
                map2.put(entity.getChoyoID().value(), new IkenshoImageJoho(entity));
            }
        }
        this.gemponByChohyoID = map;
        this.maskedByChohyoID = map2;
    }

    private IkenshoImages(ShinseishoKanriNo shinseishoKanriNo, int rirekiNo,
            Map<RString, IkenshoImageJoho> gemponByChohyoID, Map<RString, IkenshoImageJoho> maskedByChohyoID) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.rirekiNo = rirekiNo;
        this.gemponByChohyoID = new HashMap<>(gemponByChohyoID);
        this.maskedByChohyoID = new HashMap<>(maskedByChohyoID);
    }

    /**
     * @param ocrIDs 追加するすべてのOCRID
     * @return 追加やそれに伴う削除などで編集された新たな{@link IkenshoImages}
     */
    public IkenshoImages added(Set<OCRID> ocrIDs) {
        Map<RString, IkenshoImageJoho> gemponAdded = new HashMap<>(this.gemponByChohyoID);
        Map<RString, IkenshoImageJoho> maskedAdded = new HashMap<>(this.maskedByChohyoID);
        Map<OCRID, List<RString>> deletionsTable = deletionsTableByOCRID();
        Set<RString> idsToDelete = new HashSet<>();
        for (OCRID addingID : ocrIDs) {
            if (deletionsTable.containsKey(addingID)) {
                idsToDelete.addAll(deletionsTable.get(addingID));
            }
            RString idValue = addingID.value();
            if (gemponAdded.containsKey(idValue)) {
                continue;
            }
            gemponAdded.put(idValue, newIkenshoImageJoho(this.shinseishoKanriNo, this.rirekiNo, addingID));
        }
        deleteUnnecessaryItems(gemponAdded, idsToDelete);
        deleteAll(maskedAdded);
        return new IkenshoImages(this.shinseishoKanriNo, this.rirekiNo, gemponAdded, maskedAdded);
    }

    /**
     * @param ocrID 追加するOCRID
     * @param anyOCRID 追加するOCRID(任意)
     * @return 追加やそれに伴う削除などで編集された新たな{@link IkenshoImages}
     */
    public IkenshoImages added(OCRID ocrID, OCRID... anyOCRID) {
        return added(toSet(ocrID, anyOCRID));
    }

    private static Set<OCRID> toSet(OCRID ocrID, OCRID... anyOCRID) {
        Set<OCRID> set = new HashSet<>();
        set.add(ocrID);
        if (anyOCRID != null) {
            set.addAll(Arrays.asList(anyOCRID));
        }
        return set;
    }

    private static Map<OCRID, List<RString>> deletionsTableByOCRID() {
        Map<OCRID, List<RString>> map = new HashMap<>();
        List<RString> teikei = Arrays.asList(OCRID._701.value(), OCRID._702.value());
        map.put(OCRID._777, teikei);
        map.put(OCRID._778, teikei);
        List<RString> teikeigai = Arrays.asList(OCRID._777.value(), OCRID._778.value());
        map.put(OCRID._701, teikeigai);
        map.put(OCRID._702, teikeigai);
        return Collections.unmodifiableMap(map);
    }

    private static IkenshoImageJoho newIkenshoImageJoho(ShinseishoKanriNo shinseishoKanriNo, int rirekiNo, OCRID ocrID) {
        return new IkenshoImageJoho(shinseishoKanriNo, rirekiNo, ocrID.asCode(), GenponMaskKubun.原本.getコード(), 1);
    }

    private static void deleteUnnecessaryItems(Map<RString, IkenshoImageJoho> added, Set<RString> idsToDelete) {
        for (RString id : idsToDelete) {
            IkenshoImageJoho o = added.get(id);
            if (o != null) {
                if (o.isAdded()) {
                    throw new SystemException("同時に追加することが不可能な2種類の意見書が追加されました。");
                }
                added.put(id, o.deleted());
            }
        }
    }

    private static void deleteAll(Map<RString, IkenshoImageJoho> added) {
        for (RString id : added.keySet()) {
            IkenshoImageJoho o = added.get(id);
            added.put(id, o.deleted());
        }
    }

    @Override
    public Iterator<IkenshoImageJoho> iterator() {
        List<IkenshoImageJoho> list = new ArrayList<>();
        list.addAll(this.gemponByChohyoID.values());
        list.addAll(this.maskedByChohyoID.values());
        return list.iterator();
    }

    Set<RString> gemponKeySet() {
        return this.gemponByChohyoID.keySet();
    }

    Map<RString, IkenshoImageJoho> gemponAsMap() {
        return Collections.unmodifiableMap(this.gemponByChohyoID);
    }

    Map<RString, IkenshoImageJoho> maskedAsMap() {
        return Collections.unmodifiableMap(this.maskedByChohyoID);
    }
}
