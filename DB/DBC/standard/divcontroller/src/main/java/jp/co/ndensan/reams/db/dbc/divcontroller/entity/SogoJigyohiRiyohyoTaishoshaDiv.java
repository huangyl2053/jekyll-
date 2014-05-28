package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoJigyohiRiyohyoTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoJigyohiRiyohyoTaishoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNijiYoboYukoKikan")
    private TextBoxDateRange txtNijiYoboYukoKikan;
    @JsonProperty("txtNijiYoboHanteiYMD")
    private TextBoxDate txtNijiYoboHanteiYMD;
    @JsonProperty("btnKaito")
    private Button btnKaito;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNijiYoboYukoKikan")
    public TextBoxDateRange getTxtNijiYoboYukoKikan() {
        return txtNijiYoboYukoKikan;
    }

    @JsonProperty("txtNijiYoboYukoKikan")
    public void setTxtNijiYoboYukoKikan(TextBoxDateRange txtNijiYoboYukoKikan) {
        this.txtNijiYoboYukoKikan=txtNijiYoboYukoKikan;
    }

    @JsonProperty("txtNijiYoboHanteiYMD")
    public TextBoxDate getTxtNijiYoboHanteiYMD() {
        return txtNijiYoboHanteiYMD;
    }

    @JsonProperty("txtNijiYoboHanteiYMD")
    public void setTxtNijiYoboHanteiYMD(TextBoxDate txtNijiYoboHanteiYMD) {
        this.txtNijiYoboHanteiYMD=txtNijiYoboHanteiYMD;
    }

    @JsonProperty("btnKaito")
    public Button getBtnKaito() {
        return btnKaito;
    }

    @JsonProperty("btnKaito")
    public void setBtnKaito(Button btnKaito) {
        this.btnKaito=btnKaito;
    }

}
