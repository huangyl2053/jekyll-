package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoShikakuKihonDiv extends ICommonChildDivBaseProperties {

    /**
     * 介護資格基本の初期化
     *
     * @param 識別コード 識別コード
     */
    void onLoad(ShikibetsuCode 識別コード);

    /**
     * 介護資格基本の初期化
     *
     * @param 被保険者番号 被保険者番号
     */
    void onLoad(HihokenshaNo 被保険者番号);

    /**
     * set認定履歴ボタンDisable
     *
     * @param isdisabled boolean
     */
    void set認定履歴ボタンDisable(boolean isdisabled);

    /**
     * set被保履歴ボタンDisable
     *
     * @param isdisabled boolean
     */
    void set被保履歴ボタンDisable(boolean isdisabled);
}
