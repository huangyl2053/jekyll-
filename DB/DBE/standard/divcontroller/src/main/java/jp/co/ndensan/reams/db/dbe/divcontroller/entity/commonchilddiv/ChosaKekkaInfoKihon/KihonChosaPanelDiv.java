package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KihonChosaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonChosaPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgKihonChosa")
    private DataGrid<dgKihonChosa_Row> dgKihonChosa;
    @JsonProperty("txtNinchishoNichijoSeikatsuJiritsudoCode")
    private TextBoxCode txtNinchishoNichijoSeikatsuJiritsudoCode;
    @JsonProperty("txtShogaiNichijoSeikatsuJiritsudoCode")
    private TextBoxCode txtShogaiNichijoSeikatsuJiritsudoCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgKihonChosa
     * @return dgKihonChosa
     */
    @JsonProperty("dgKihonChosa")
    public DataGrid<dgKihonChosa_Row> getDgKihonChosa() {
        return dgKihonChosa;
    }

    /*
     * setdgKihonChosa
     * @param dgKihonChosa dgKihonChosa
     */
    @JsonProperty("dgKihonChosa")
    public void setDgKihonChosa(DataGrid<dgKihonChosa_Row> dgKihonChosa) {
        this.dgKihonChosa = dgKihonChosa;
    }

    /*
     * gettxtNinchishoNichijoSeikatsuJiritsudoCode
     * @return txtNinchishoNichijoSeikatsuJiritsudoCode
     */
    @JsonProperty("txtNinchishoNichijoSeikatsuJiritsudoCode")
    public TextBoxCode getTxtNinchishoNichijoSeikatsuJiritsudoCode() {
        return txtNinchishoNichijoSeikatsuJiritsudoCode;
    }

    /*
     * settxtNinchishoNichijoSeikatsuJiritsudoCode
     * @param txtNinchishoNichijoSeikatsuJiritsudoCode txtNinchishoNichijoSeikatsuJiritsudoCode
     */
    @JsonProperty("txtNinchishoNichijoSeikatsuJiritsudoCode")
    public void setTxtNinchishoNichijoSeikatsuJiritsudoCode(TextBoxCode txtNinchishoNichijoSeikatsuJiritsudoCode) {
        this.txtNinchishoNichijoSeikatsuJiritsudoCode = txtNinchishoNichijoSeikatsuJiritsudoCode;
    }

    /*
     * gettxtShogaiNichijoSeikatsuJiritsudoCode
     * @return txtShogaiNichijoSeikatsuJiritsudoCode
     */
    @JsonProperty("txtShogaiNichijoSeikatsuJiritsudoCode")
    public TextBoxCode getTxtShogaiNichijoSeikatsuJiritsudoCode() {
        return txtShogaiNichijoSeikatsuJiritsudoCode;
    }

    /*
     * settxtShogaiNichijoSeikatsuJiritsudoCode
     * @param txtShogaiNichijoSeikatsuJiritsudoCode txtShogaiNichijoSeikatsuJiritsudoCode
     */
    @JsonProperty("txtShogaiNichijoSeikatsuJiritsudoCode")
    public void setTxtShogaiNichijoSeikatsuJiritsudoCode(TextBoxCode txtShogaiNichijoSeikatsuJiritsudoCode) {
        this.txtShogaiNichijoSeikatsuJiritsudoCode = txtShogaiNichijoSeikatsuJiritsudoCode;
    }

    // </editor-fold>
}
