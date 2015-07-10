package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.ButtonsShosaiShijiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaShokai のクラスファイル
 *
 * @author 自動生成
 */
public class JukyushaShokaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("kaigoAtena")
    private KaigoAtenaInfoDiv kaigoAtena;
    @JsonProperty("kaigoShikaku")
    private KaigoShikakuKihonDiv kaigoShikaku;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("btnHiddenStart")
    private Button btnHiddenStart;
    @JsonProperty("ButtonsShosaiShiji")
    private ButtonsShosaiShijiDiv ButtonsShosaiShiji;
    @JsonProperty("NinteiRireki")
    private NinteiRirekiDiv NinteiRireki;
    @JsonProperty("NinteiDetail")
    private NinteiDetailDiv NinteiDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("kaigoAtena")
    public KaigoAtenaInfoDiv getKaigoAtena() {
        return kaigoAtena;
    }

    @JsonProperty("kaigoAtena")
    public void setKaigoAtena(KaigoAtenaInfoDiv kaigoAtena) {
        this.kaigoAtena = kaigoAtena;
    }

    @JsonProperty("kaigoShikaku")
    public KaigoShikakuKihonDiv getKaigoShikaku() {
        return kaigoShikaku;
    }

    @JsonProperty("kaigoShikaku")
    public void setKaigoShikaku(KaigoShikakuKihonDiv kaigoShikaku) {
        this.kaigoShikaku = kaigoShikaku;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    @JsonProperty("btnHiddenStart")
    public Button getBtnHiddenStart() {
        return btnHiddenStart;
    }

    @JsonProperty("btnHiddenStart")
    public void setBtnHiddenStart(Button btnHiddenStart) {
        this.btnHiddenStart = btnHiddenStart;
    }

    @JsonProperty("ButtonsShosaiShiji")
    public ButtonsShosaiShijiDiv getButtonsShosaiShiji() {
        return ButtonsShosaiShiji;
    }

    @JsonProperty("ButtonsShosaiShiji")
    public void setButtonsShosaiShiji(ButtonsShosaiShijiDiv ButtonsShosaiShiji) {
        this.ButtonsShosaiShiji = ButtonsShosaiShiji;
    }

    @JsonProperty("NinteiRireki")
    public NinteiRirekiDiv getNinteiRireki() {
        return NinteiRireki;
    }

    @JsonProperty("NinteiRireki")
    public void setNinteiRireki(NinteiRirekiDiv NinteiRireki) {
        this.NinteiRireki = NinteiRireki;
    }

    @JsonProperty("NinteiDetail")
    public NinteiDetailDiv getNinteiDetail() {
        return NinteiDetail;
    }

    @JsonProperty("NinteiDetail")
    public void setNinteiDetail(NinteiDetailDiv NinteiDetail) {
        this.NinteiDetail = NinteiDetail;
    }

}
