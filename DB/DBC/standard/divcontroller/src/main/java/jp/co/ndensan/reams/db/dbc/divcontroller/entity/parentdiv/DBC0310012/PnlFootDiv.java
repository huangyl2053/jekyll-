package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PnlFoot のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlFootDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikyuumukubun")
    private TextBox txtShikyuumukubun;
    @JsonProperty("txtServiceYM")
    private TextBoxYearMonth txtServiceYM;
    @JsonProperty("txtSyokanseriNo")
    private TextBoxCode txtSyokanseriNo;
    @JsonProperty("txtBikou")
    private TextBox txtBikou;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikyuumukubun
     * @return txtShikyuumukubun
     */
    @JsonProperty("txtShikyuumukubun")
    public TextBox getTxtShikyuumukubun() {
        return txtShikyuumukubun;
    }

    /*
     * settxtShikyuumukubun
     * @param txtShikyuumukubun txtShikyuumukubun
     */
    @JsonProperty("txtShikyuumukubun")
    public void setTxtShikyuumukubun(TextBox txtShikyuumukubun) {
        this.txtShikyuumukubun = txtShikyuumukubun;
    }

    /*
     * gettxtServiceYM
     * @return txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public TextBoxYearMonth getTxtServiceYM() {
        return txtServiceYM;
    }

    /*
     * settxtServiceYM
     * @param txtServiceYM txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public void setTxtServiceYM(TextBoxYearMonth txtServiceYM) {
        this.txtServiceYM = txtServiceYM;
    }

    /*
     * gettxtSyokanseriNo
     * @return txtSyokanseriNo
     */
    @JsonProperty("txtSyokanseriNo")
    public TextBoxCode getTxtSyokanseriNo() {
        return txtSyokanseriNo;
    }

    /*
     * settxtSyokanseriNo
     * @param txtSyokanseriNo txtSyokanseriNo
     */
    @JsonProperty("txtSyokanseriNo")
    public void setTxtSyokanseriNo(TextBoxCode txtSyokanseriNo) {
        this.txtSyokanseriNo = txtSyokanseriNo;
    }

    /*
     * gettxtBikou
     * @return txtBikou
     */
    @JsonProperty("txtBikou")
    public TextBox getTxtBikou() {
        return txtBikou;
    }

    /*
     * settxtBikou
     * @param txtBikou txtBikou
     */
    @JsonProperty("txtBikou")
    public void setTxtBikou(TextBox txtBikou) {
        this.txtBikou = txtBikou;
    }

    // </editor-fold>
}
