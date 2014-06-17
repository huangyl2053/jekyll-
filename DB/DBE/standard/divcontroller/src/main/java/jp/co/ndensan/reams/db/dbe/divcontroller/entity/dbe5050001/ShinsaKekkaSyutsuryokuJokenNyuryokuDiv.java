package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001;
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
 * ShinsaKekkaSyutsuryokuJokenNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaKekkaSyutsuryokuJokenNyuryokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("radShutsuryokuKubun")
    private RadioButton radShutsuryokuKubun;
    @JsonProperty("txtNinteiKekkaKakuninKikan")
    private TextBoxDateRange txtNinteiKekkaKakuninKikan;
    @JsonProperty("btnHyoji")
    private Button btnHyoji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("radShutsuryokuKubun")
    public RadioButton getRadShutsuryokuKubun() {
        return radShutsuryokuKubun;
    }

    @JsonProperty("radShutsuryokuKubun")
    public void setRadShutsuryokuKubun(RadioButton radShutsuryokuKubun) {
        this.radShutsuryokuKubun=radShutsuryokuKubun;
    }

    @JsonProperty("txtNinteiKekkaKakuninKikan")
    public TextBoxDateRange getTxtNinteiKekkaKakuninKikan() {
        return txtNinteiKekkaKakuninKikan;
    }

    @JsonProperty("txtNinteiKekkaKakuninKikan")
    public void setTxtNinteiKekkaKakuninKikan(TextBoxDateRange txtNinteiKekkaKakuninKikan) {
        this.txtNinteiKekkaKakuninKikan=txtNinteiKekkaKakuninKikan;
    }

    @JsonProperty("btnHyoji")
    public Button getBtnHyoji() {
        return btnHyoji;
    }

    @JsonProperty("btnHyoji")
    public void setBtnHyoji(Button btnHyoji) {
        this.btnHyoji=btnHyoji;
    }

}
