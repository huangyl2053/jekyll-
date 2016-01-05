/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.kaigochohyoshutsuryokujun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護帳票出力順のビジネスクラス
 */
public class KaigoChohyoShutsuryokujun {

    private static final RString ALL = new RString("ALL");
    private static final RString SHUKEI_NONE = new RString("SHUKEI_NONE");
    private static final RString 出力順 = new RString("出力順");
    private static final RString 改頁 = new RString("改頁");

    /**
     * 入力データチェックです。
     *
     * @param txtSort txtSort
     * @param displayNone displayNone
     * @param txtKaiPage txtKaiPage
     * @param txtShukeiNoneKaiPage txtShukeiNoneKaiPage
     */
    public void checkInput(RString txtSort, RString displayNone, RString txtKaiPage, RString txtShukeiNoneKaiPage) {
        if (txtSort == null
                || txtSort.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(出力順.toString()));
        }
        if ((displayNone.equals(ALL)
                || displayNone.equals(SHUKEI_NONE))
                && ((txtKaiPage == null
                || txtKaiPage.isEmpty())
                && (txtShukeiNoneKaiPage == null
                || txtShukeiNoneKaiPage.isEmpty()))) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(改頁.toString()));
        }
    }
}
