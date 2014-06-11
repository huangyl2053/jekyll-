package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ButtonsShosaiShijiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.HihokenshaAtenaDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.HihokenshaDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

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
    @JsonProperty("HihokenshaAtena")
    private HihokenshaAtenaDiv HihokenshaAtena;
    @JsonProperty("Hihokensha")
    private HihokenshaDiv Hihokensha;
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
    @JsonProperty("HihokenshaAtena")
    public HihokenshaAtenaDiv getHihokenshaAtena() {
        return HihokenshaAtena;
    }

    @JsonProperty("HihokenshaAtena")
    public void setHihokenshaAtena(HihokenshaAtenaDiv HihokenshaAtena) {
        this.HihokenshaAtena=HihokenshaAtena;
    }

    @JsonProperty("Hihokensha")
    public HihokenshaDiv getHihokensha() {
        return Hihokensha;
    }

    @JsonProperty("Hihokensha")
    public void setHihokensha(HihokenshaDiv Hihokensha) {
        this.Hihokensha=Hihokensha;
    }

    @JsonProperty("ButtonsShosaiShiji")
    public ButtonsShosaiShijiDiv getButtonsShosaiShiji() {
        return ButtonsShosaiShiji;
    }

    @JsonProperty("ButtonsShosaiShiji")
    public void setButtonsShosaiShiji(ButtonsShosaiShijiDiv ButtonsShosaiShiji) {
        this.ButtonsShosaiShiji=ButtonsShosaiShiji;
    }

    @JsonProperty("NinteiRireki")
    public NinteiRirekiDiv getNinteiRireki() {
        return NinteiRireki;
    }

    @JsonProperty("NinteiRireki")
    public void setNinteiRireki(NinteiRirekiDiv NinteiRireki) {
        this.NinteiRireki=NinteiRireki;
    }

    @JsonProperty("NinteiDetail")
    public NinteiDetailDiv getNinteiDetail() {
        return NinteiDetail;
    }

    @JsonProperty("NinteiDetail")
    public void setNinteiDetail(NinteiDetailDiv NinteiDetail) {
        this.NinteiDetail=NinteiDetail;
    }

}
