package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RojinHokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class RojinHokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRojinHokenShichosonNo")
    private TextBoxCode txtRojinHokenShichosonNo;
    @JsonProperty("txtRojinHokenJukyushaNo")
    private TextBoxCode txtRojinHokenJukyushaNo;
    @JsonProperty("txtKohiFutanshaNo")
    private TextBoxCode txtKohiFutanshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRojinHokenShichosonNo
     * @return txtRojinHokenShichosonNo
     */
    @JsonProperty("txtRojinHokenShichosonNo")
    public TextBoxCode getTxtRojinHokenShichosonNo() {
        return txtRojinHokenShichosonNo;
    }

    /*
     * settxtRojinHokenShichosonNo
     * @param txtRojinHokenShichosonNo txtRojinHokenShichosonNo
     */
    @JsonProperty("txtRojinHokenShichosonNo")
    public void setTxtRojinHokenShichosonNo(TextBoxCode txtRojinHokenShichosonNo) {
        this.txtRojinHokenShichosonNo = txtRojinHokenShichosonNo;
    }

    /*
     * gettxtRojinHokenJukyushaNo
     * @return txtRojinHokenJukyushaNo
     */
    @JsonProperty("txtRojinHokenJukyushaNo")
    public TextBoxCode getTxtRojinHokenJukyushaNo() {
        return txtRojinHokenJukyushaNo;
    }

    /*
     * settxtRojinHokenJukyushaNo
     * @param txtRojinHokenJukyushaNo txtRojinHokenJukyushaNo
     */
    @JsonProperty("txtRojinHokenJukyushaNo")
    public void setTxtRojinHokenJukyushaNo(TextBoxCode txtRojinHokenJukyushaNo) {
        this.txtRojinHokenJukyushaNo = txtRojinHokenJukyushaNo;
    }

    /*
     * gettxtKohiFutanshaNo
     * @return txtKohiFutanshaNo
     */
    @JsonProperty("txtKohiFutanshaNo")
    public TextBoxCode getTxtKohiFutanshaNo() {
        return txtKohiFutanshaNo;
    }

    /*
     * settxtKohiFutanshaNo
     * @param txtKohiFutanshaNo txtKohiFutanshaNo
     */
    @JsonProperty("txtKohiFutanshaNo")
    public void setTxtKohiFutanshaNo(TextBoxCode txtKohiFutanshaNo) {
        this.txtKohiFutanshaNo = txtKohiFutanshaNo;
    }

    // </editor-fold>
}
