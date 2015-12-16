/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokureikaijo;

//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuIdoBaseItem;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者の住所地自特例解除を扱います。
 *
 *
 */
public class JushochitokureiKaijo extends ShikakuIdoBaseItem<JushochitokureiKaijoJiyu> {

    /**
     * 住所地自特例解除がないことを表すオブジェクトです。
     */
    public static final JushochitokureiKaijo NOTHING;

    static {
        NOTHING = new JushochitokureiKaijo(JushochitokureiKaijoJiyu.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
    }
    private final FlexibleDate kaijoDate = FlexibleDate.EMPTY;
    private final HihokenshaDaicho newestHihokenshaDaicho = null;

    /**
     * 新しい住所地自特例解除の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 資格変更事由
     * @param noticeDate 資格変更届出年月日
     * @param actionDate 資格変更年月日
     */
    public JushochitokureiKaijo(JushochitokureiKaijoJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }

    @Override
    public boolean isNothing() {
        return this == NOTHING;
    }
/**
 * getKaijoDateを取得します。
 * @return kaijoDate
 */
    public FlexibleDate getKaijoDate() {
        return kaijoDate;
    }
/**
 * getNewestHihokenshaDaichoを取得します。
 * @return newestHihokenshaDaicho
 */
    public HihokenshaDaicho getNewestHihokenshaDaicho() {
        return newestHihokenshaDaicho;
    }

}
