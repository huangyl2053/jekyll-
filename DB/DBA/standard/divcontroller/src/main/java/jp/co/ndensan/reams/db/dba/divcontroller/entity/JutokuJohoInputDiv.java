package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.KaijoJiyuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SochimotoJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutokuJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutokuJohoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TekiyoJiyuInput")
    private TekiyoJiyuInputDiv TekiyoJiyuInput;
    @JsonProperty("KaijoJiyuInput")
    private KaijoJiyuInputDiv KaijoJiyuInput;
    @JsonProperty("SochimotoJohoInput")
    private SochimotoJohoInputDiv SochimotoJohoInput;
    @JsonProperty("ShisetsuJohoInput")
    private ShisetsuJohoInputDiv ShisetsuJohoInput;
    @JsonProperty("btnTekiyoJohoToroku")
    private Button btnTekiyoJohoToroku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TekiyoJiyuInput")
    public TekiyoJiyuInputDiv getTekiyoJiyuInput() {
        return TekiyoJiyuInput;
    }

    @JsonProperty("TekiyoJiyuInput")
    public void setTekiyoJiyuInput(TekiyoJiyuInputDiv TekiyoJiyuInput) {
        this.TekiyoJiyuInput=TekiyoJiyuInput;
    }

    @JsonProperty("KaijoJiyuInput")
    public KaijoJiyuInputDiv getKaijoJiyuInput() {
        return KaijoJiyuInput;
    }

    @JsonProperty("KaijoJiyuInput")
    public void setKaijoJiyuInput(KaijoJiyuInputDiv KaijoJiyuInput) {
        this.KaijoJiyuInput=KaijoJiyuInput;
    }

    @JsonProperty("SochimotoJohoInput")
    public SochimotoJohoInputDiv getSochimotoJohoInput() {
        return SochimotoJohoInput;
    }

    @JsonProperty("SochimotoJohoInput")
    public void setSochimotoJohoInput(SochimotoJohoInputDiv SochimotoJohoInput) {
        this.SochimotoJohoInput=SochimotoJohoInput;
    }

    @JsonProperty("ShisetsuJohoInput")
    public ShisetsuJohoInputDiv getShisetsuJohoInput() {
        return ShisetsuJohoInput;
    }

    @JsonProperty("ShisetsuJohoInput")
    public void setShisetsuJohoInput(ShisetsuJohoInputDiv ShisetsuJohoInput) {
        this.ShisetsuJohoInput=ShisetsuJohoInput;
    }

    @JsonProperty("btnTekiyoJohoToroku")
    public Button getBtnTekiyoJohoToroku() {
        return btnTekiyoJohoToroku;
    }

    @JsonProperty("btnTekiyoJohoToroku")
    public void setBtnTekiyoJohoToroku(Button btnTekiyoJohoToroku) {
        this.btnTekiyoJohoToroku=btnTekiyoJohoToroku;
    }

}
