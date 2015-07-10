package jp.co.ndensan.reams.db.dba.divcontroller.entity.TaishoshaKeyCreator;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TaishoshaKeySetting のクラスファイル
 *
 * @author 自動生成
 */
public class TaishoshaKeySettingDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtSetai")
    private TextBox txtSetai;
    @JsonProperty("txtShikibetsu")
    private TextBox txtShikibetsu;
    @JsonProperty("txtHihoNo")
    private TextBox txtHihoNo;
    @JsonProperty("btnNext")
    private Button btnNext;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSetai")
    public TextBox getTxtSetai() {
        return txtSetai;
    }

    @JsonProperty("txtSetai")
    public void setTxtSetai(TextBox txtSetai) {
        this.txtSetai = txtSetai;
    }

    @JsonProperty("txtShikibetsu")
    public TextBox getTxtShikibetsu() {
        return txtShikibetsu;
    }

    @JsonProperty("txtShikibetsu")
    public void setTxtShikibetsu(TextBox txtShikibetsu) {
        this.txtShikibetsu = txtShikibetsu;
    }

    @JsonProperty("txtHihoNo")
    public TextBox getTxtHihoNo() {
        return txtHihoNo;
    }

    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBox txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    @JsonProperty("btnNext")
    public Button getBtnNext() {
        return btnNext;
    }

    @JsonProperty("btnNext")
    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

}
