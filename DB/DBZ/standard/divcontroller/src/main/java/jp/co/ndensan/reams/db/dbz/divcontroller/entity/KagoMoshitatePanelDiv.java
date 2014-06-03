package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KagoMoshitateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.HihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KagoMoshitatePanel のクラスファイル
 *
 * @author 自動生成
 */
public class KagoMoshitatePanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("Hihokensha")
    private HihokenshaDiv Hihokensha;
    @JsonProperty("KagoMoshitateInfo")
    private KagoMoshitateDiv KagoMoshitateInfo;
    @JsonProperty("btnSettle")
    private Button btnSettle;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Hihokensha")
    public HihokenshaDiv getHihokensha() {
        return Hihokensha;
    }

    @JsonProperty("Hihokensha")
    public void setHihokensha(HihokenshaDiv Hihokensha) {
        this.Hihokensha = Hihokensha;
    }

    @JsonProperty("KagoMoshitateInfo")
    public KagoMoshitateDiv getKagoMoshitateInfo() {
        return KagoMoshitateInfo;
    }

    @JsonProperty("KagoMoshitateInfo")
    public void setKagoMoshitateInfo(KagoMoshitateDiv KagoMoshitateInfo) {
        this.KagoMoshitateInfo = KagoMoshitateInfo;
    }

    @JsonProperty("btnSettle")
    public Button getBtnSettle() {
        return btnSettle;
    }

    @JsonProperty("btnSettle")
    public void setBtnSettle(Button btnSettle) {
        this.btnSettle = btnSettle;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

}
