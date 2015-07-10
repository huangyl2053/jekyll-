package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 共有子Div「施設入退所履歴管理Div」において、外部に公開する処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 * @author n8223 朴義一
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
     * 引数から渡されたキーを元に施設入退所履歴管理テーブルから情報を取得し、その情報を共有子Divに設定します。
     *
     * @param 識別コード 識別コード
     */
    void load(ShikibetsuCode 識別コード);

    /**
     * 入力明細エリアのコントロールをクリアします。
     */
    void clearInputData();

    /**
     * 共有子Divに設定されている、施設入退所履歴の情報を取得します。
     *
     * @return 施設入退所履歴List
     */
    IItemList<ShisetsuNyutaishoRelateModel> get施設入退所履歴();

    /**
     * 共有子Divに対して、引数から施設入退所履歴の情報を設定します。
     *
     * @param 施設入退所履歴 施設入退所履歴List
     */
    void set施設入退所履歴(IItemList<ShisetsuNyutaishoRelateModel> 施設入退所履歴);

    /**
     * 共有子Divの初期化を行います。<br />
     * 引数を元に処理対象者の情報を設定し、利用機能モードの設定を元に初期化を行います。
     *
     * @param shichosonCode 処理対象者の市町村コード
     * @param shikibetsuCode 処理対象者の識別コード
     */
    void initialize(LasdecCode shichosonCode, ShikibetsuCode shikibetsuCode);

    /**
     * 自身が持つ施設入退所情報に対して変更が存在した場合に、trueを返します。
     *
     * @return 施設入退所情報に変更が有った場合、true
     */
    boolean hasChanged();

    /**
     * 明細パネルが変更されたかどうかを判定します。
     *
     * @return 明細パネルの内容が変更されていたらtrue
     */
    boolean hasChangedInMeisai();
}
