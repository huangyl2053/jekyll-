package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList;

import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 共有子Div「保険者リスト」を操作するためのメソッドを提供します。
 * <p/>
 * このインタフェースは{@link HokenshaListDiv}のファサードとして機能します。
 */
public interface IHokenshaListDiv extends ICommonChildDivBaseProperties {

    /**
     * 保険者の情報を読み込み、DDLに設定します。業務分類は「介護事務」となります。
     * <p/>
     * このメソッドは、この共有子Divを使用する各画面の最初のロード処理で実行される必要があります。
     */
    void loadHokenshaList();

    /**
     * 保険者の情報を読み込み、DDLに設定します。 業務分類を指定しなければいけません。
     * <p/>
     * このメソッドは、この共有子Divを使用する各画面の最初のロード処理で実行される必要があります。
     *
     * @param 業務分類
     * @throws NullPointerException 引数が{@code null}の場合
     */
    void loadHokenshaList(GyomuBunrui 業務分類);

    /**
     * 画面で選択されている保険者の情報を返却します。
     * 画面で「全市町村」が選択されている場合は、{@link HokenshaSummary#EMPTY}を返却します。
     *
     * @return 画面で指定されている保険者名の保険者の情報を持った{@link HokenshaSummary}
     */
    HokenshaSummary getSelectedItem();

    /**
     * 指定の市町村コードの市町村を選択肢に持つ場合、選択値として設定します。
     *
     * @param 市町村コード 市町村コード
     */
    void setSelectedShichosonIfExist(LasdecCode 市町村コード);
}
