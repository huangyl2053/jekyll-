package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.JogaiShisetsuHenkoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.JogaishaKaijoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.JogaishaTekiyoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TekiyoJogaiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiTorokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JogaishaTekiyoInput")
    private JogaishaTekiyoInputDiv JogaishaTekiyoInput;
    @JsonProperty("JogaishaKaijoInput")
    private JogaishaKaijoInputDiv JogaishaKaijoInput;
    @JsonProperty("JogaiShisetsuHenkoInput")
    private JogaiShisetsuHenkoInputDiv JogaiShisetsuHenkoInput;
    @JsonProperty("btnInsertTekiyoJogaiJoho")
    private Button btnInsertTekiyoJogaiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JogaishaTekiyoInput")
    public JogaishaTekiyoInputDiv getJogaishaTekiyoInput() {
        return JogaishaTekiyoInput;
    }

    @JsonProperty("JogaishaTekiyoInput")
    public void setJogaishaTekiyoInput(JogaishaTekiyoInputDiv JogaishaTekiyoInput) {
        this.JogaishaTekiyoInput=JogaishaTekiyoInput;
    }

    @JsonProperty("JogaishaKaijoInput")
    public JogaishaKaijoInputDiv getJogaishaKaijoInput() {
        return JogaishaKaijoInput;
    }

    @JsonProperty("JogaishaKaijoInput")
    public void setJogaishaKaijoInput(JogaishaKaijoInputDiv JogaishaKaijoInput) {
        this.JogaishaKaijoInput=JogaishaKaijoInput;
    }

    @JsonProperty("JogaiShisetsuHenkoInput")
    public JogaiShisetsuHenkoInputDiv getJogaiShisetsuHenkoInput() {
        return JogaiShisetsuHenkoInput;
    }

    @JsonProperty("JogaiShisetsuHenkoInput")
    public void setJogaiShisetsuHenkoInput(JogaiShisetsuHenkoInputDiv JogaiShisetsuHenkoInput) {
        this.JogaiShisetsuHenkoInput=JogaiShisetsuHenkoInput;
    }

    @JsonProperty("btnInsertTekiyoJogaiJoho")
    public Button getBtnInsertTekiyoJogaiJoho() {
        return btnInsertTekiyoJogaiJoho;
    }

    @JsonProperty("btnInsertTekiyoJogaiJoho")
    public void setBtnInsertTekiyoJogaiJoho(Button btnInsertTekiyoJogaiJoho) {
        this.btnInsertTekiyoJogaiJoho=btnInsertTekiyoJogaiJoho;
    }

}
