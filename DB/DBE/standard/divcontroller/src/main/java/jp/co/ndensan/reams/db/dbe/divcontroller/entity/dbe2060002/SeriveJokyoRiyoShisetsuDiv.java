package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002;
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
 * SeriveJokyoRiyoShisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeriveJokyoRiyoShisetsuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShisetsuType")
    private RadioButton radShisetsuType;
    @JsonProperty("linRiyoShisetsu")
    private HorizontalLine linRiyoShisetsu;
    @JsonProperty("txtShisetsuName")
    private TextBox txtShisetsuName;
    @JsonProperty("txtShisetsuYubinNo")
    private TextBoxYubinNo txtShisetsuYubinNo;
    @JsonProperty("txtShisetsuJusho")
    private TextBox txtShisetsuJusho;
    @JsonProperty("txtShisetsuTelNo")
    private TextBox txtShisetsuTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShisetsuType")
    public RadioButton getRadShisetsuType() {
        return radShisetsuType;
    }

    @JsonProperty("radShisetsuType")
    public void setRadShisetsuType(RadioButton radShisetsuType) {
        this.radShisetsuType=radShisetsuType;
    }

    @JsonProperty("linRiyoShisetsu")
    public HorizontalLine getLinRiyoShisetsu() {
        return linRiyoShisetsu;
    }

    @JsonProperty("linRiyoShisetsu")
    public void setLinRiyoShisetsu(HorizontalLine linRiyoShisetsu) {
        this.linRiyoShisetsu=linRiyoShisetsu;
    }

    @JsonProperty("txtShisetsuName")
    public TextBox getTxtShisetsuName() {
        return txtShisetsuName;
    }

    @JsonProperty("txtShisetsuName")
    public void setTxtShisetsuName(TextBox txtShisetsuName) {
        this.txtShisetsuName=txtShisetsuName;
    }

    @JsonProperty("txtShisetsuYubinNo")
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return txtShisetsuYubinNo;
    }

    @JsonProperty("txtShisetsuYubinNo")
    public void setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.txtShisetsuYubinNo=txtShisetsuYubinNo;
    }

    @JsonProperty("txtShisetsuJusho")
    public TextBox getTxtShisetsuJusho() {
        return txtShisetsuJusho;
    }

    @JsonProperty("txtShisetsuJusho")
    public void setTxtShisetsuJusho(TextBox txtShisetsuJusho) {
        this.txtShisetsuJusho=txtShisetsuJusho;
    }

    @JsonProperty("txtShisetsuTelNo")
    public TextBox getTxtShisetsuTelNo() {
        return txtShisetsuTelNo;
    }

    @JsonProperty("txtShisetsuTelNo")
    public void setTxtShisetsuTelNo(TextBox txtShisetsuTelNo) {
        this.txtShisetsuTelNo=txtShisetsuTelNo;
    }

}
