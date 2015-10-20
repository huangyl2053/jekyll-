/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.Shikaku;

import jp.co.ndensan.reams.db.dbz.business.ShikakuIdoBaseItem;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者の資格変更を扱います。
 *
 * @author N3327 三浦 凌
 */
public class ShikakuHenko extends ShikakuIdoBaseItem<ShikakuHenkoJiyu> {

    /**
     * 資格変更がないことを表すオブジェクトです。
     */
    public static final ShikakuHenko NOTHING;

    static {
        NOTHING = new ShikakuHenko(ShikakuHenkoJiyu.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
    }
    private FlexibleDate 変更日;
    private FlexibleDate 取得日;
    private FlexibleDate 喪失日;
    private RString 変更事由;
    private FlexibleDate 最新資格取得日;
    private FlexibleDate 最新資格喪失日;
    private FlexibleDate 一号資格取得日;
    private FlexibleDate 最新資格変更日;

    /**
     * 新しい資格変更の事由、届出年月日、処理年月日を持ったインスタンスを生成します。
     *
     * @param reason 資格変更事由
     * @param noticeDate 資格変更届出年月日
     * @param actionDate 資格変更年月日
     */
    public ShikakuHenko(ShikakuHenkoJiyu reason, FlexibleDate noticeDate, FlexibleDate actionDate) {
        super(reason, noticeDate, actionDate);
    }

    @Override
    public boolean isNothing() {
        return this == NOTHING;
    }

    public FlexibleDate 変更日() {
        return 変更日;
    }

    public FlexibleDate 取得日() {
        return 取得日;
    }

    public FlexibleDate 喪失日() {
        return 喪失日;
    }

    public FlexibleDate 最新資格取得日() {
        return 最新資格取得日;
    }

    public FlexibleDate 最新資格喪失日() {
        return 最新資格喪失日;
    }

    public FlexibleDate 一号資格取得日() {
        return 一号資格取得日;
    }

    public FlexibleDate 最新資格変更日() {
        return 最新資格変更日;
    }

    public RString 変更事由() {
        return 変更事由;
    }

    public Optional< DbT1001HihokenshaDaichoEntity> get次履歴() {

        return get次履歴();
    }

    public Optional< DbT1001HihokenshaDaichoEntity> get前履歴() {
        return get前履歴();
    }

    public IItemList<DbT1001HihokenshaDaichoEntity> get全履歴() {
        return get全履歴();
    }

    public IValidationMessages validate() {
        return new ShikakuHenkoValidator(this).validate();
    }

}
