/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.exclusivekey;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護資格で使用する排他キーを出力します。
 *
 * @author n8178
 */
public final class DbaExclusiveKey {

    private DbaExclusiveKey() {

    }

    /**
     * 被保険者番号を元に排他キーを作成します。
     *
     * @param 被保険者番号 被保険者番号
     * @return
     * 被保険者番号を元に作成した排他キー。被保険者番号に問題がある（nullやEMPTY）場合、{@code RString.EMPTY}を返します。
     */
    public static RString create被保険者番号排他キー(HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            return RString.EMPTY;
        }
        RStringBuilder builder = new RStringBuilder(new RString("DBAHihokenshaNo"));
        builder.append(被保険者番号.getColumnValue());
        return builder.toRString();
    }
    //
    //TODO 城間 被保険者番号以外にも排他キーに必要なものがあるので（識別コードや文書番号等）必要になり次第追加する。
}
