package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FubanMotoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class FubanMotoJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlFubanmotoJoho")
    private DropDownList ddlFubanmotoJoho;
    @JsonProperty("txtKaishiKetaIchi")
    private TextBoxNum txtKaishiKetaIchi;
    @JsonProperty("txtYukoKetasu")
    private TextBoxNum txtYukoKetasu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlFubanmotoJoho
     * @return ddlFubanmotoJoho
     */
    @JsonProperty("ddlFubanmotoJoho")
    public DropDownList getDdlFubanmotoJoho() {
        return ddlFubanmotoJoho;
    }

    /*
     * setddlFubanmotoJoho
     * @param ddlFubanmotoJoho ddlFubanmotoJoho
     */
    @JsonProperty("ddlFubanmotoJoho")
    public void setDdlFubanmotoJoho(DropDownList ddlFubanmotoJoho) {
        this.ddlFubanmotoJoho = ddlFubanmotoJoho;
    }

    /*
     * gettxtKaishiKetaIchi
     * @return txtKaishiKetaIchi
     */
    @JsonProperty("txtKaishiKetaIchi")
    public TextBoxNum getTxtKaishiKetaIchi() {
        return txtKaishiKetaIchi;
    }

    /*
     * settxtKaishiKetaIchi
     * @param txtKaishiKetaIchi txtKaishiKetaIchi
     */
    @JsonProperty("txtKaishiKetaIchi")
    public void setTxtKaishiKetaIchi(TextBoxNum txtKaishiKetaIchi) {
        this.txtKaishiKetaIchi = txtKaishiKetaIchi;
    }

    /*
     * gettxtYukoKetasu
     * @return txtYukoKetasu
     */
    @JsonProperty("txtYukoKetasu")
    public TextBoxNum getTxtYukoKetasu() {
        return txtYukoKetasu;
    }

    /*
     * settxtYukoKetasu
     * @param txtYukoKetasu txtYukoKetasu
     */
    @JsonProperty("txtYukoKetasu")
    public void setTxtYukoKetasu(TextBoxNum txtYukoKetasu) {
        this.txtYukoKetasu = txtYukoKetasu;
    }

    // </editor-fold>
}
