/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * アクセスログの拡張情報を生成します。
 */
public final class ExpandedInformations {

    private static final RString SHINSEISHO_KANRI_NO = new RString("申請書管理番号");

    private ExpandedInformations() {
    }

    /**
     * @param shinseishoKanriNo 申請書管理番号の値
     * @return {@link ExpandedInformation}
     */
    public static ExpandedInformation[] fromValue(RString shinseishoKanriNo) {
        return fromValues(Collections.singleton(shinseishoKanriNo));
    }

    /**
     * @param shinseishoKanriNos 申請書管理番号の値（複数）
     * @return {@link ExpandedInformation}
     */
    public static ExpandedInformation[] fromValues(Iterable<? extends RString> shinseishoKanriNos) {
        return fromValues(Lists.newArrayList(shinseishoKanriNos));
    }

    /**
     * @param shinseishoKanriNos 申請書管理番号の値（複数）
     * @return {@link ExpandedInformation}
     */
    public static ExpandedInformation[] fromValues(Collection<? extends RString> shinseishoKanriNos) {
        List<ExpandedInformation> list = new ArrayList<>();
        int i = 1;
        for (RString value : shinseishoKanriNos) {
            list.add(new ExpandedInformation(new Code(String.format("%04d", i)), SHINSEISHO_KANRI_NO, value));
            i++;
        }
        return list.toArray(new ExpandedInformation[list.size()]);
    }

    /**
     * @param shinseishoKanriNo 申請書管理番号
     * @return {@link ExpandedInformation}
     */
    public static ExpandedInformation[] fromShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        return fromValue(shinseishoKanriNo.value());
    }

    /**
     * @param shinseishoKanriNos 申請書管理番号（複数）
     * @return {@link ExpandedInformation}
     */
    public static ExpandedInformation[] fromShinseishoKanriNos(Iterable<? extends ShinseishoKanriNo> shinseishoKanriNos) {
        return fromShinseishoKanriNos(Lists.newArrayList(shinseishoKanriNos));
    }

    /**
     * @param shinseishoKanriNos 申請書管理番号（複数）
     * @return {@link ExpandedInformation}
     */
    public static ExpandedInformation[] fromShinseishoKanriNos(Collection<? extends ShinseishoKanriNo> shinseishoKanriNos) {
        List<RString> list = new ArrayList<>();
        for (ShinseishoKanriNo no : shinseishoKanriNos) {
            list.add(no.value());
        }
        return fromValues(list);
    }
}
