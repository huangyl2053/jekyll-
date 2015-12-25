/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokureitekiyo;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuIdoBaseItem;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者の住所地特例適用を扱います。
 *
 *
 */
public class JushochitokureiTekiyo extends ShikakuIdoBaseItem<JushochitokureiTekiyoJiyu> {

    /**
     * 住所地特例適用がないことを表すオブジェクトです。
     */
    public static final JushochitokureiTekiyo NOTHING;

    static {
        NOTHING = new JushochitokureiTekiyo(JushochitokureiTekiyoJiyu.EMPTY, FlexibleDate.MIN, FlexibleDate.MIN);
    }

    private final FlexibleDate tekiyoDate = FlexibleDate.EMPTY;
    private final HihokenshaDaicho newestHihokenshaDaicho = null;

    /**
     * 新しい住所地特例適用の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 住所地特例適用事由
     * @param noticeDate 住所地特例適用届出年月日
     * @param actionDate 住所地特例適用年月日
     */
    public JushochitokureiTekiyo(JushochitokureiTekiyoJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }

    @Override
    public boolean isNothing() {
        return this == NOTHING;
    }

    /**
     * getTekiyoDateを取得します。
     *
     * @return tekiyoDate
     */
    public FlexibleDate getTekiyoDate() {
        return tekiyoDate;
    }

    /**
     * getNewestHihokenshaDaichoを取得します。
     *
     * @return newestHihokenshaDaicho
     */
    public HihokenshaDaicho getNewestHihokenshaDaicho() {
        return newestHihokenshaDaicho;
    }

}
