package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaishorireki.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 共有子Div「施設入退所履歴管理Div」において、外部に公開する処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShisetsuNyutaishoRirekiKanriDiv {

    /**
     * 引数から渡されたキーを元に施設入退所履歴管理テーブルから情報を取得し、その情報を共有子Divに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード);

    /**
     * 入力明細エリアのコントロールをクリアします。
     */
    void clearInputData();

    /**
     * 共有子Divに設定されている、施設入退所履歴の情報を取得します。
     *
     * @return 施設入退所履歴List
     */
    IItemList<ShisetsuNyutaishoModel> get施設入退所履歴();

    /**
     * 共有子Divに対して、引数から施設入退所履歴の情報を設定します。
     *
     * @param 施設入退所履歴 施設入退所履歴List
     */
    void set施設入退所履歴(IItemList<ShisetsuNyutaishoModel> 施設入退所履歴);
}
