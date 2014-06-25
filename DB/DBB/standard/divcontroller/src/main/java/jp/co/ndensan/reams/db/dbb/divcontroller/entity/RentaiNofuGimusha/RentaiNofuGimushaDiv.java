package jp.co.ndensan.reams.db.dbb.divcontroller.entity.RentaiNofuGimusha;
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
 * RentaiNofuGimusha のクラスファイル 
 * 
 * @author 自動生成
 */
public class RentaiNofuGimushaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtKaishiYMD")
    private TextBoxDate txtKaishiYMD;
    @JsonProperty("txtSyuryoYMD")
    private TextBoxDate txtSyuryoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtKaishiYMD")
    public TextBoxDate getTxtKaishiYMD() {
        return txtKaishiYMD;
    }

    @JsonProperty("txtKaishiYMD")
    public void setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.txtKaishiYMD=txtKaishiYMD;
    }

    @JsonProperty("txtSyuryoYMD")
    public TextBoxDate getTxtSyuryoYMD() {
        return txtSyuryoYMD;
    }

    @JsonProperty("txtSyuryoYMD")
    public void setTxtSyuryoYMD(TextBoxDate txtSyuryoYMD) {
        this.txtSyuryoYMD=txtSyuryoYMD;
    }

}
