package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoTaishoshaDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("txtNinnchishouJiritsudo")
    private TextBox txtNinnchishouJiritsudo;
    @JsonProperty("txtShougaishaJiritsudo")
    private TextBox txtShougaishaJiritsudo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNinteiKubun
     * @return txtNinteiKubun
     */
    @JsonProperty("txtNinteiKubun")
    public TextBox getTxtNinteiKubun() {
        return txtNinteiKubun;
    }

    /*
     * settxtNinteiKubun
     * @param txtNinteiKubun txtNinteiKubun
     */
    @JsonProperty("txtNinteiKubun")
    public void setTxtNinteiKubun(TextBox txtNinteiKubun) {
        this.txtNinteiKubun = txtNinteiKubun;
    }

    /*
     * gettxtNinteiNaiyo
     * @return txtNinteiNaiyo
     */
    @JsonProperty("txtNinteiNaiyo")
    public TextBox getTxtNinteiNaiyo() {
        return txtNinteiNaiyo;
    }

    /*
     * settxtNinteiNaiyo
     * @param txtNinteiNaiyo txtNinteiNaiyo
     */
    @JsonProperty("txtNinteiNaiyo")
    public void setTxtNinteiNaiyo(TextBox txtNinteiNaiyo) {
        this.txtNinteiNaiyo = txtNinteiNaiyo;
    }

    /*
     * gettxtNinnchishouJiritsudo
     * @return txtNinnchishouJiritsudo
     */
    @JsonProperty("txtNinnchishouJiritsudo")
    public TextBox getTxtNinnchishouJiritsudo() {
        return txtNinnchishouJiritsudo;
    }

    /*
     * settxtNinnchishouJiritsudo
     * @param txtNinnchishouJiritsudo txtNinnchishouJiritsudo
     */
    @JsonProperty("txtNinnchishouJiritsudo")
    public void setTxtNinnchishouJiritsudo(TextBox txtNinnchishouJiritsudo) {
        this.txtNinnchishouJiritsudo = txtNinnchishouJiritsudo;
    }

    /*
     * gettxtShougaishaJiritsudo
     * @return txtShougaishaJiritsudo
     */
    @JsonProperty("txtShougaishaJiritsudo")
    public TextBox getTxtShougaishaJiritsudo() {
        return txtShougaishaJiritsudo;
    }

    /*
     * settxtShougaishaJiritsudo
     * @param txtShougaishaJiritsudo txtShougaishaJiritsudo
     */
    @JsonProperty("txtShougaishaJiritsudo")
    public void setTxtShougaishaJiritsudo(TextBox txtShougaishaJiritsudo) {
        this.txtShougaishaJiritsudo = txtShougaishaJiritsudo;
    }

    // </editor-fold>
}
