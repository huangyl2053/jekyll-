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
 * JukyushaIdoRenrakuhyoKokuho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKokuhoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    private TextBoxCode txtKokuhoHokenshaNo;
    @JsonProperty("txtKokuhoHihokenshashoNo")
    private TextBoxCode txtKokuhoHihokenshashoNo;
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
     * gettxtKokuhoHihokenshashoNo
     * @return txtKokuhoHihokenshashoNo
     */
    @JsonProperty("txtKokuhoHihokenshashoNo")
    public TextBoxCode getTxtKokuhoHihokenshashoNo() {
        return txtKokuhoHihokenshashoNo;
    }

    /*
     * settxtKokuhoHihokenshashoNo
     * @param txtKokuhoHihokenshashoNo txtKokuhoHihokenshashoNo
     */
    @JsonProperty("txtKokuhoHihokenshashoNo")
    public void setTxtKokuhoHihokenshashoNo(TextBoxCode txtKokuhoHihokenshashoNo) {
        this.txtKokuhoHihokenshashoNo = txtKokuhoHihokenshashoNo;
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
