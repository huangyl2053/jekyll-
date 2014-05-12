package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010020Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DDBE2010040Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * DDBE2010010 のクラスファイル 
 * 
 * @author 自動生成
 */
public class DDBE2010010Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKikanWaritsukeJIdo")
    private Button btnKikanWaritsukeJIdo;
    @JsonProperty("btnKikanWaritsukeTedo")
    private Button btnKikanWaritsukeTedo;
    @JsonProperty("DDBE2010020")
    private DDBE2010020Div DDBE2010020;
    @JsonProperty("DDBE2010040")
    private DDBE2010040Div DDBE2010040;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnKikanWaritsukeJIdo")
    public Button getBtnKikanWaritsukeJIdo() {
        return btnKikanWaritsukeJIdo;
    }

    @JsonProperty("btnKikanWaritsukeJIdo")
    public void setBtnKikanWaritsukeJIdo(Button btnKikanWaritsukeJIdo) {
        this.btnKikanWaritsukeJIdo=btnKikanWaritsukeJIdo;
    }

    @JsonProperty("btnKikanWaritsukeTedo")
    public Button getBtnKikanWaritsukeTedo() {
        return btnKikanWaritsukeTedo;
    }

    @JsonProperty("btnKikanWaritsukeTedo")
    public void setBtnKikanWaritsukeTedo(Button btnKikanWaritsukeTedo) {
        this.btnKikanWaritsukeTedo=btnKikanWaritsukeTedo;
    }

    @JsonProperty("DDBE2010020")
    public DDBE2010020Div getDDBE2010020() {
        return DDBE2010020;
    }

    @JsonProperty("DDBE2010020")
    public void setDDBE2010020(DDBE2010020Div DDBE2010020) {
        this.DDBE2010020=DDBE2010020;
    }

    @JsonProperty("DDBE2010040")
    public DDBE2010040Div getDDBE2010040() {
        return DDBE2010040;
    }

    @JsonProperty("DDBE2010040")
    public void setDDBE2010040(DDBE2010040Div DDBE2010040) {
        this.DDBE2010040=DDBE2010040;
    }

}
