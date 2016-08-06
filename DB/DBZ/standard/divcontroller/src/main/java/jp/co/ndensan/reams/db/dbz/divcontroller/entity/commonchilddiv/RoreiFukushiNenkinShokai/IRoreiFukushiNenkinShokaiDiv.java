package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBA-0220-010 dongyabin
 */
public interface IRoreiFukushiNenkinShokaiDiv extends ICommonChildDivBaseProperties {

    /**
     * 画面を初期化します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     */
    public void initialize(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo);

    /**
     * 画面データをデータベースに格納します。
     */
    public void click_Save();

    /**
     * 老福年金情報を取得します。
     *
     * @return List<datagridRireki_Row>
     * @deprecated オブジェクト指向を知らない人が実装したメソッドです。
     */
    public List<datagridRireki_Row> getDataGridList();

    /**
     * 変更がある場合は{@code true}、無い場合は{@code false}を返却します。
     *
     * @return 変更がある場合は{@code true}、無い場合は{@code false}.
     */
    public boolean hasChanged();
}
