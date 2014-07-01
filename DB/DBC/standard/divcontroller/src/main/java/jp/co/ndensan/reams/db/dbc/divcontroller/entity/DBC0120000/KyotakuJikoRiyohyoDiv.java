package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuJikoRiyohyo のクラスファイル
 *
 * @author 自動生成
 */
public class KyotakuJikoRiyohyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KyotakuJikoRiyohyoInfo")
    private ServiceRiyohyoInfoDiv KyotakuJikoRiyohyoInfo;
    @JsonProperty("txtBeppyoListSelectIndex")
    private TextBox txtBeppyoListSelectIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyotakuJikoRiyohyoInfo")
    public ServiceRiyohyoInfoDiv getKyotakuJikoRiyohyoInfo() {
        return KyotakuJikoRiyohyoInfo;
    }

    @JsonProperty("KyotakuJikoRiyohyoInfo")
    public void setKyotakuJikoRiyohyoInfo(ServiceRiyohyoInfoDiv KyotakuJikoRiyohyoInfo) {
        this.KyotakuJikoRiyohyoInfo = KyotakuJikoRiyohyoInfo;
    }

    @JsonProperty("txtBeppyoListSelectIndex")
    public TextBox getTxtBeppyoListSelectIndex() {
        return txtBeppyoListSelectIndex;
    }

    @JsonProperty("txtBeppyoListSelectIndex")
    public void setTxtBeppyoListSelectIndex(TextBox txtBeppyoListSelectIndex) {
        this.txtBeppyoListSelectIndex = txtBeppyoListSelectIndex;
    }

}
