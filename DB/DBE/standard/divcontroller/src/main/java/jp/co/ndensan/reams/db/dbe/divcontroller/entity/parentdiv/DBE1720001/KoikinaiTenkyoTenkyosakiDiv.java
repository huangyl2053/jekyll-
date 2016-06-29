package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikinaiTenkyoTenkyosaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikinaiTenkyoTenkyosakiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShokisaiHokenshaNoSaki")
    private DropDownList ddlShokisaiHokenshaNoSaki;
    @JsonProperty("txtShokisaiHokenshaSaki")
    private TextBox txtShokisaiHokenshaSaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShokisaiHokenshaNoSaki
     * @return ddlShokisaiHokenshaNoSaki
     */
    @JsonProperty("ddlShokisaiHokenshaNoSaki")
    public DropDownList getDdlShokisaiHokenshaNoSaki() {
        return ddlShokisaiHokenshaNoSaki;
    }

    /*
     * setddlShokisaiHokenshaNoSaki
     * @param ddlShokisaiHokenshaNoSaki ddlShokisaiHokenshaNoSaki
     */
    @JsonProperty("ddlShokisaiHokenshaNoSaki")
    public void setDdlShokisaiHokenshaNoSaki(DropDownList ddlShokisaiHokenshaNoSaki) {
        this.ddlShokisaiHokenshaNoSaki = ddlShokisaiHokenshaNoSaki;
    }

    /*
     * gettxtShokisaiHokenshaSaki
     * @return txtShokisaiHokenshaSaki
     */
    @JsonProperty("txtShokisaiHokenshaSaki")
    public TextBox getTxtShokisaiHokenshaSaki() {
        return txtShokisaiHokenshaSaki;
    }

    /*
     * settxtShokisaiHokenshaSaki
     * @param txtShokisaiHokenshaSaki txtShokisaiHokenshaSaki
     */
    @JsonProperty("txtShokisaiHokenshaSaki")
    public void setTxtShokisaiHokenshaSaki(TextBox txtShokisaiHokenshaSaki) {
        this.txtShokisaiHokenshaSaki = txtShokisaiHokenshaSaki;
    }

    // </editor-fold>
}
