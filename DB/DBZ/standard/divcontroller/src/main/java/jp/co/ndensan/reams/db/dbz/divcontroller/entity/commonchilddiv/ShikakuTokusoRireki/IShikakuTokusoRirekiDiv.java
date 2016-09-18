package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokuso.ShikakuTokuso;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0130-011 huangh
 */
public interface IShikakuTokusoRirekiDiv extends ICommonChildDivBaseProperties {

    /**
     * 引数から渡されたキーを元に被保険者台帳テーブルから情報を取得し、その情報をグリッドに表示します。 内部で{@code initializeKoseiShichosonJoho()}、
     * {@code getShikakuShutokuRireki(SearchResult<ShikakuTokuso>)}を呼び出しています。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード);

    /**
     * 市町村セキュリティ情報を参照し、共有子Divの初期状態を設定します。
     */
    void initializeShichosonSecurity();

    /**
     * 被保険者番号と識別コードを元に、
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     */
    void getShikakuShutokuRireki(HihokenshaNo hihokenshaNo, ShikibetsuCode shikibetsuCode);

    /**
     * 資格得喪履歴Gridの設定します。
     *
     * @param dgShikakuShutokuRireki_Row dgShikakuShutokuRireki_Row
     */
    public abstract void setDataGridSelectItem(dgShikakuShutokuRireki_Row dgShikakuShutokuRireki_Row);

    /**
     * 資格得喪履歴Gridの取得します。
     *
     * @return dgShikakuShutokuRireki_Row dgShikakuShutokuRireki_Row
     */
    public abstract dgShikakuShutokuRireki_Row getDataGridSelectItem();

    /**
     * 資格得喪履歴Gridの設定します。
     *
     * @param dgShikakuShutokuRireki_RowList List<dgShikakuShutokuRireki_Row>
     */
    public abstract void setDataGridDataSource(List<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki_RowList);

    /**
     * 資格得喪履歴Gridの取得します。
     *
     * @return dgShikakuShutokuRireki_Row dgShikakuShutokuRireki_Row
     */
    public abstract List<dgShikakuShutokuRireki_Row> getDataGridDataSource();

    /**
     * 「追加するボタン」の状態を設定します、 パラメーターは true : 非活性 、false : 活性
     *
     * @param jyotai jyotai
     */
    public abstract void set追加するボタン(boolean jyotai);

    /**
     * 「追加するボタン」の表示状態を設定します、 パラメーターは true : 非表示 、false : 表示
     *
     * @param 表示モード 表示モード
     */
    public abstract void set追加するボタンの表示状態(boolean 表示モード);

    /**
     * ダイアログとして共有子Divを開いた場合のコントロール表示非表示を設定します。
     *
     */
    void setDialogDisplay();
}
