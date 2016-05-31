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
 * KokuhoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuhoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    private TextBoxCode txtKokuhoHokenshaNo;
    @JsonProperty("txtKokuhoHiHokenshaNo")
    private TextBoxCode txtKokuhoHiHokenshaNo;
    @JsonProperty("txtKokuhoKojinNo")
    private TextBoxCode txtKokuhoKojinNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKokuhoHokenshaNo
     * @return txtKokuhoHokenshaNo
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    public TextBoxCode getTxtKokuhoHokenshaNo() {
        return txtKokuhoHokenshaNo;
    }

    /*
     * settxtKokuhoHokenshaNo
     * @param txtKokuhoHokenshaNo txtKokuhoHokenshaNo
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    public void setTxtKokuhoHokenshaNo(TextBoxCode txtKokuhoHokenshaNo) {
        this.txtKokuhoHokenshaNo = txtKokuhoHokenshaNo;
    }

    /*
     * gettxtKokuhoHiHokenshaNo
     * @return txtKokuhoHiHokenshaNo
     */
    @JsonProperty("txtKokuhoHiHokenshaNo")
    public TextBoxCode getTxtKokuhoHiHokenshaNo() {
        return txtKokuhoHiHokenshaNo;
    }

    /*
     * settxtKokuhoHiHokenshaNo
     * @param txtKokuhoHiHokenshaNo txtKokuhoHiHokenshaNo
     */
    @JsonProperty("txtKokuhoHiHokenshaNo")
    public void setTxtKokuhoHiHokenshaNo(TextBoxCode txtKokuhoHiHokenshaNo) {
        this.txtKokuhoHiHokenshaNo = txtKokuhoHiHokenshaNo;
    }

    /*
     * gettxtKokuhoKojinNo
     * @return txtKokuhoKojinNo
     */
    @JsonProperty("txtKokuhoKojinNo")
    public TextBoxCode getTxtKokuhoKojinNo() {
        return txtKokuhoKojinNo;
    }

    /*
     * settxtKokuhoKojinNo
     * @param txtKokuhoKojinNo txtKokuhoKojinNo
     */
    @JsonProperty("txtKokuhoKojinNo")
    public void setTxtKokuhoKojinNo(TextBoxCode txtKokuhoKojinNo) {
        this.txtKokuhoKojinNo = txtKokuhoKojinNo;
    }

    // </editor-fold>
}
