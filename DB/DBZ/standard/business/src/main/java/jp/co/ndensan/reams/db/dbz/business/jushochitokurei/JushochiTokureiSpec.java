/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokurei;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * @author LDNS chenty
 */
public enum JushochiTokureiSpec implements IPredicate<HihokenshaDaicho> {

    /**
     * 住特適用日が資格取得日より前
     */
    住特適用日が資格取得日より前 {
                @Override
                public boolean apply(HihokenshaDaicho jushochiTokureiData) {
                    boolean res = true;
                    if (jushochiTokureiData.get適用年月日().isBefore(jushochiTokureiData.get資格取得年月日())) {
                        res = false;
                    }
                    return res;
                }
            },
    /**
     * 住特適用日が資格喪失日以降
     */
    住特適用日が資格喪失日以降 {
                @Override
                public boolean apply(HihokenshaDaicho jushochiTokureiData) {
                    boolean res = true;
                    if (jushochiTokureiData.get資格喪失年月日().isBeforeOrEquals(jushochiTokureiData.get適用年月日())) {
                        res = false;
                    }
                    if (jushochiTokureiData.get資格喪失年月日() == null || jushochiTokureiData.get資格喪失年月日().isEmpty()) {
                        return res;
                    }
                    return res;
                }
            },
    /**
     * 住特解除日が資格取得日より前
     */
    住特解除日が資格取得日より前 {
                @Override
                public boolean apply(HihokenshaDaicho jushochiTokureiData) {
                    boolean res = true;
                    if (jushochiTokureiData.get解除年月日().isBefore(jushochiTokureiData.get資格取得年月日())) {
                        res = false;
                    }
                    if (jushochiTokureiData.get解除年月日() == null || jushochiTokureiData.get解除年月日().isEmpty()) {
                        return res;
                    }
                    return res;
                }
            },
    /**
     * 住特解除日が資格喪失日以降
     */
    住特解除日が資格喪失日以降 {
                @Override
                public boolean apply(HihokenshaDaicho jushochiTokureiData) {
                    boolean res = true;
                    if (jushochiTokureiData.get資格喪失年月日().isBefore(jushochiTokureiData.get解除年月日())) {
                        res = false;
                    }
                    if (jushochiTokureiData.get解除年月日() == null || jushochiTokureiData.get解除年月日().isEmpty()) {
                        return res;
                    } else if (jushochiTokureiData.get資格喪失年月日() == null || jushochiTokureiData.get資格喪失年月日().isEmpty()) {
                        return res;
                    }
                    return res;
                }
            },
    /**
     * 住所地特例期間が不正_適用日が解除日の後
     */
    住所地特例期間が不正_適用日が解除日の後 {
                @Override
                public boolean apply(HihokenshaDaicho jushochiTokureiData) {
                    boolean res = true;
                    if (jushochiTokureiData.get解除年月日().isBeforeOrEquals(jushochiTokureiData.get適用年月日())) {
                        res = false;
                    }
                    if (jushochiTokureiData.get解除年月日() == null || jushochiTokureiData.get解除年月日().isEmpty()) {
                        return res;
                    }
                    return res;
                }
            },

}
