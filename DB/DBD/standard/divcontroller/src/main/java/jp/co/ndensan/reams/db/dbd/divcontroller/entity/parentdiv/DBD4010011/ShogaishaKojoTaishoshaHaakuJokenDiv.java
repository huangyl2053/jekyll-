package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoTaishoshaHaakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaHaakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("chkJogaiJoken")
    private CheckBoxList chkJogaiJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * getchkJogaiJoken
     * @return chkJogaiJoken
     */
    @JsonProperty("chkJogaiJoken")
    public CheckBoxList getChkJogaiJoken() {
        return chkJogaiJoken;
    }

    /*
     * setchkJogaiJoken
     * @param chkJogaiJoken chkJogaiJoken
     */
    @JsonProperty("chkJogaiJoken")
    public void setChkJogaiJoken(CheckBoxList chkJogaiJoken) {
        this.chkJogaiJoken = chkJogaiJoken;
    }

    // </editor-fold>
}
