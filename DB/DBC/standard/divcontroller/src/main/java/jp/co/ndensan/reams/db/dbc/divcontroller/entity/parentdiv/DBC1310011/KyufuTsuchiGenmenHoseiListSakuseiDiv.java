package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1310011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiGenmenHoseiListSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuTsuchiGenmenHoseiListSakuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceYM")
    private TextBoxDateRange txtServiceYM;
    @JsonProperty("ddlShichoson")
    private DropDownList ddlShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceYM
     * @return txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public TextBoxDateRange getTxtServiceYM() {
        return txtServiceYM;
    }

    /*
     * settxtServiceYM
     * @param txtServiceYM txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public void setTxtServiceYM(TextBoxDateRange txtServiceYM) {
        this.txtServiceYM = txtServiceYM;
    }

    /*
     * getddlShichoson
     * @return ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public DropDownList getDdlShichoson() {
        return ddlShichoson;
    }

    /*
     * setddlShichoson
     * @param ddlShichoson ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.ddlShichoson = ddlShichoson;
    }

    // </editor-fold>
}
