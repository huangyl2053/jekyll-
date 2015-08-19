package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;

import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshaShikakuHakko;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 被保険者証・資格者証 共有子Divと使用者とのインタフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IHihokenshaShikakuHakkoDiv {

    /**
     * 引数を元に被保険者証・資格者証の情報を取得して共有子Divに表示します。<br/>
     * このメソッドを動作させるには、画面上で共有子Divに対して 発行証タイプ モードを設定する必要があります。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param is直前履歴 boolean
     */
    void load(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, boolean is直前履歴);

    /**
     * この共有子Divに設定されているデータをクリアします。
     */
    void clear();

    /**
     * 共有子Divのバリデーションチェックを行います。
     *
     * @return ValidationMessageControlPairs
     */
    ValidationMessageControlPairs validate();

    /**
     * 画面に表示している情報を被保険者証資格者証Modelにセットして返します。
     *
     * @return 被保険者証資格者証発行モデル
     */
    HihokenshaShikakuHakko create証発行情報();
}
