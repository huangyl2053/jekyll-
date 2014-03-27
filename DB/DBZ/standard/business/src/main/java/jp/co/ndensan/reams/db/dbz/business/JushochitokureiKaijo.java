/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者の住所地特例解除を扱います。
 *
 * @author N3327 三浦 凌
 */
public class JushochitokureiKaijo extends ShikakuIdoBaseItem<JushochitokureiKaijoJiyu> {

    /**
     * 新しい住所地特例解除の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 資格変更事由
     * @param noticeDate 資格変更届出年月日
     * @param actionDate 資格変更年月日
     */
    public JushochitokureiKaijo(JushochitokureiKaijoJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }
}
