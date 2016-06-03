package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlChushutsuYmd")
    private DropDownList ddlChushutsuYmd;
    @JsonProperty("txtChushutsuYMD")
    private TextBoxDateRange txtChushutsuYMD;
    @JsonProperty("txtIryokikan")
    private TextBoxNumRange txtIryokikan;
    @JsonProperty("txtChosaItakusaki")
    private TextBoxNumRange txtChosaItakusaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlChushutsuYmd
     * @return ddlChushutsuYmd
     */
    @JsonProperty("ddlChushutsuYmd")
    public DropDownList getDdlChushutsuYmd() {
        return ddlChushutsuYmd;
    }

    /*
     * setddlChushutsuYmd
     * @param ddlChushutsuYmd ddlChushutsuYmd
     */
    @JsonProperty("ddlChushutsuYmd")
    public void setDdlChushutsuYmd(DropDownList ddlChushutsuYmd) {
        this.ddlChushutsuYmd = ddlChushutsuYmd;
    }

    /*
     * gettxtChushutsuYMD
     * @return txtChushutsuYMD
     */
    @JsonProperty("txtChushutsuYMD")
    public TextBoxDateRange getTxtChushutsuYMD() {
        return txtChushutsuYMD;
    }

    /*
     * settxtChushutsuYMD
     * @param txtChushutsuYMD txtChushutsuYMD
     */
    @JsonProperty("txtChushutsuYMD")
    public void setTxtChushutsuYMD(TextBoxDateRange txtChushutsuYMD) {
        this.txtChushutsuYMD = txtChushutsuYMD;
    }

    /*
     * gettxtIryokikan
     * @return txtIryokikan
     */
    @JsonProperty("txtIryokikan")
    public TextBoxNumRange getTxtIryokikan() {
        return txtIryokikan;
    }

    /*
     * settxtIryokikan
     * @param txtIryokikan txtIryokikan
     */
    @JsonProperty("txtIryokikan")
    public void setTxtIryokikan(TextBoxNumRange txtIryokikan) {
        this.txtIryokikan = txtIryokikan;
    }

    /*
     * gettxtChosaItakusaki
     * @return txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public TextBoxNumRange getTxtChosaItakusaki() {
        return txtChosaItakusaki;
    }

    /*
     * settxtChosaItakusaki
     * @param txtChosaItakusaki txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public void setTxtChosaItakusaki(TextBoxNumRange txtChosaItakusaki) {
        this.txtChosaItakusaki = txtChosaItakusaki;
    }

    // </editor-fold>
}
