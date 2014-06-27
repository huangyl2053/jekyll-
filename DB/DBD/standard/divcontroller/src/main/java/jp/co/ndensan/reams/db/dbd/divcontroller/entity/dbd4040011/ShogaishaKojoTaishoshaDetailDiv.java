package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011;
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
 * ShogaishaKojoTaishoshaDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiKubun")
    private TextBox txtNinteiKubun;
    @JsonProperty("txtNinteiNaiyo")
    private TextBox txtNinteiNaiyo;
    @JsonProperty("txtJiritsudo")
    private TextBox txtJiritsudo;
    @JsonProperty("txtSoshitsuYMD")
    private TextBoxDate txtSoshitsuYMD;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("chkTechoAri")
    private CheckBoxList chkTechoAri;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiKubun")
    public TextBox getTxtNinteiKubun() {
        return txtNinteiKubun;
    }

    @JsonProperty("txtNinteiKubun")
    public void setTxtNinteiKubun(TextBox txtNinteiKubun) {
        this.txtNinteiKubun=txtNinteiKubun;
    }

    @JsonProperty("txtNinteiNaiyo")
    public TextBox getTxtNinteiNaiyo() {
        return txtNinteiNaiyo;
    }

    @JsonProperty("txtNinteiNaiyo")
    public void setTxtNinteiNaiyo(TextBox txtNinteiNaiyo) {
        this.txtNinteiNaiyo=txtNinteiNaiyo;
    }

    @JsonProperty("txtJiritsudo")
    public TextBox getTxtJiritsudo() {
        return txtJiritsudo;
    }

    @JsonProperty("txtJiritsudo")
    public void setTxtJiritsudo(TextBox txtJiritsudo) {
        this.txtJiritsudo=txtJiritsudo;
    }

    @JsonProperty("txtSoshitsuYMD")
    public TextBoxDate getTxtSoshitsuYMD() {
        return txtSoshitsuYMD;
    }

    @JsonProperty("txtSoshitsuYMD")
    public void setTxtSoshitsuYMD(TextBoxDate txtSoshitsuYMD) {
        this.txtSoshitsuYMD=txtSoshitsuYMD;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu=txtSoshitsuJiyu;
    }

    @JsonProperty("chkTechoAri")
    public CheckBoxList getChkTechoAri() {
        return chkTechoAri;
    }

    @JsonProperty("chkTechoAri")
    public void setChkTechoAri(CheckBoxList chkTechoAri) {
        this.chkTechoAri=chkTechoAri;
    }

}
