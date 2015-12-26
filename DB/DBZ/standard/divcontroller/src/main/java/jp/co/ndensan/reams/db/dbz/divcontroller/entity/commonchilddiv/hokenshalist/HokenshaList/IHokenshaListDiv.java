package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;

import jp.co.ndensan.reams.db.dbx.business.core.shichosonlist.ShichosonCodeNameResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 共有子Div「保険者リスト」を操作するためのメソッドを提供します。
 * <p/>
 * このインタフェースは{@link HokenshaListDiv}のファサードとして機能します。
 */
public interface IHokenshaListDiv extends ICommonChildDivBaseProperties {

    /**
     * 保険者の情報を読み込み、DDLに設定します。
     * <p/>
     * このメソッドは、この共有子Divを使用する各画面の最初のロード処理で実行される必要があります。
     */
    void loadHokenshaList();

    /**
     * 画面で選択されている保険者の情報を返却します。
     * 画面で空白が選択されている場合は{@link ShichosonCodeNameResult#EMPTY}を返却します。
     *
     * @return 画面で指定されている保険者名の保険者の情報を持った{@link ShichosonCodeNameResult}
     */
    ShichosonCodeNameResult getSelectedItem();
}
