package jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki;

import jp.co.ndensan.reams.db.dbz.model.iryohokenkanyujokyo.IryoHokenKanyuJokyoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 共有子Div「医療保険履歴Div」において、外部に公開する処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IIryoHokenRirekiDiv {

    /**
     * 引数から与えられるキーを用いて医療保険加入状況を検索し、その結果をグリッドに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード);

    /**
     * 明細エリアに入力されている情報を初期化します。
     */
    void clearInputData();

    /**
     * 医療保険履歴Divに設定されている、医療保険加入状況を取得します。
     *
     * @return 医療保険加入状況List
     */
    IItemList<IryoHokenKanyuJokyoModel> get医療保険加入状況List();

    /**
     * 医療保険履歴Divに対して、引数から医療保険加入状況の情報を設定します。
     *
     * @param 医療保険加入状況List 医療保険加入状況List
     */
    void set医療保険加入状況List(IItemList<IryoHokenKanyuJokyoModel> 医療保険加入状況List);
}
