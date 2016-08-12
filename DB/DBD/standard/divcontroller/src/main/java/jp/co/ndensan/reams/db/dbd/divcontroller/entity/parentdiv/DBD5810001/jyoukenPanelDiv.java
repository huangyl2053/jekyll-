package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * jyoukenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class jyoukenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtnendo")
    private TextBoxFlexibleDate txtnendo;
    @JsonProperty("rdoKijyun")
    private RadioButton rdoKijyun;
    @JsonProperty("ddlKijyunhi")
    private DropDownList ddlKijyunhi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtnendo
     * @return txtnendo
     */
    @JsonProperty("txtnendo")
    public TextBoxFlexibleDate getTxtnendo() {
        return txtnendo;
    }

    /*
     * settxtnendo
     * @param txtnendo txtnendo
     */
    @JsonProperty("txtnendo")
    public void setTxtnendo(TextBoxFlexibleDate txtnendo) {
        this.txtnendo = txtnendo;
    }

    /*
     * getrdoKijyun
     * @return rdoKijyun
     */
    @JsonProperty("rdoKijyun")
    public RadioButton getRdoKijyun() {
        return rdoKijyun;
    }

    /*
     * setrdoKijyun
     * @param rdoKijyun rdoKijyun
     */
    @JsonProperty("rdoKijyun")
    public void setRdoKijyun(RadioButton rdoKijyun) {
        this.rdoKijyun = rdoKijyun;
    }

    /*
     * getddlKijyunhi
     * @return ddlKijyunhi
     */
    @JsonProperty("ddlKijyunhi")
    public DropDownList getDdlKijyunhi() {
        return ddlKijyunhi;
    }

    /*
     * setddlKijyunhi
     * @param ddlKijyunhi ddlKijyunhi
     */
    @JsonProperty("ddlKijyunhi")
    public void setDdlKijyunhi(DropDownList ddlKijyunhi) {
        this.ddlKijyunhi = ddlKijyunhi;
    }

    // </editor-fold>
}
