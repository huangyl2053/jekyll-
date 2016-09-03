package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.util.Models;

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
     * 画面を初期化します。グリッド上に表示するデータを引数から受け取って初期化します。
     *
     * @param roreiFukushiNenkinJukyusha グリッド上に表示するデータ
     */
    void initialize(Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha);

    /**
     * 画面データをデータベースに格納します。
     */
    public void click_Save();

    /**
     * グリッド上に設定されているデータを、保存可能な状態で取得します。
     *
     * @return 老福年金グリッド上に設定されているデータ
     */
    Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> getSaveData();

    /**
     * 老福年金情報を取得します。
     *
     * @return List<datagridRireki_Row>
     * @deprecated オブジェクト指向を知らない人が実装したメソッドです。
     */
    public List<datagridRireki_Row> getDataGridList();

    /**
     * 保存可能な状態かチェックします。
     *
     * @return 保存可能ならtrue
     */
    public boolean isSavable();

    /**
     * 変更がある場合は{@code true}、無い場合は{@code false}を返却します。
     *
     * @return 変更がある場合は{@code true}、無い場合は{@code false}.
     */
    public boolean hasChanged();

    /**
     * 老齢福祉年金の状態を照会モードに設定します。
     *
     * TODO 城間
     * 現状の仕様だと1度照会モードに設定すると、モードの変更だけでは登録できる状態に戻せない。切り替えられるようにするならモードの修正が必要。
     */
    void setShokaiMode();

    /**
     * 老齢福祉年金の状態を照会モードに設定します。
     *
     * TODO 城間
     * 現状の仕様だと1度照会モードに設定すると、モードの変更だけでは登録できる状態に戻せない。切り替えられるようにするならモードの修正が必要。
     */
    void setTorokuMode();
}
