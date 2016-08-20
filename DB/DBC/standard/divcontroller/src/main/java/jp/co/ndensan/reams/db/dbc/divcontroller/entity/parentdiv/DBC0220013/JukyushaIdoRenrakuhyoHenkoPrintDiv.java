package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoHenkoPrint のクラスファイル 
 * 
 * @reamsid_L DBC-2102-010 lihang
 */
public class JukyushaIdoRenrakuhyoHenkoPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkoDate")
    private TextBoxDate txtHakkoDate;
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    private CheckBoxList chkJukyushaIdoRenrakuhyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkoDate
     * @return txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public TextBoxDate getTxtHakkoDate() {
        return txtHakkoDate;
    }

    /*
     * settxtHakkoDate
     * @param txtHakkoDate txtHakkoDate
     */
    @JsonProperty("txtHakkoDate")
    public void setTxtHakkoDate(TextBoxDate txtHakkoDate) {
        this.txtHakkoDate = txtHakkoDate;
    }

    /*
     * getchkJukyushaIdoRenrakuhyo
     * @return chkJukyushaIdoRenrakuhyo
     */
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    public CheckBoxList getChkJukyushaIdoRenrakuhyo() {
        return chkJukyushaIdoRenrakuhyo;
    }

    /*
     * setchkJukyushaIdoRenrakuhyo
     * @param chkJukyushaIdoRenrakuhyo chkJukyushaIdoRenrakuhyo
     */
    @JsonProperty("chkJukyushaIdoRenrakuhyo")
    public void setChkJukyushaIdoRenrakuhyo(CheckBoxList chkJukyushaIdoRenrakuhyo) {
        this.chkJukyushaIdoRenrakuhyo = chkJukyushaIdoRenrakuhyo;
    }

    // </editor-fold>
}
