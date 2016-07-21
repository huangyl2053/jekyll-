package jp.co.ndensan.reams.db.dbz.divcontroller.entity.testdriver.testshujiiiryokikanandshujiiinput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TestShujiiryoKikanAndShujiiInput のクラスファイル
 *
 * @author 自動生成
 */
public class TestShujiiryoKikanAndShujiiInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSubGyomuCode")
    private TextBox txtSubGyomuCode;
    @JsonProperty("txtShichosonCode")
    private TextBox txtShichosonCode;
    @JsonProperty("txtShinseishoKanriNo")
    private TextBox txtShinseishoKanriNo;
    @JsonProperty("btnTestDataSet")
    private Button btnTestDataSet;
    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiIryokikanAndShujiiInput;
    @JsonProperty("hdnTestShinseishoKanriNo")
    private RString hdnTestShinseishoKanriNo;
    @JsonProperty("hdnTestDatabaseSubGyomuCode")
    private RString hdnTestDatabaseSubGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSubGyomuCode")
    public TextBox getTxtSubGyomuCode() {
        return txtSubGyomuCode;
    }

    @JsonProperty("txtSubGyomuCode")
    public void setTxtSubGyomuCode(TextBox txtSubGyomuCode) {
        this.txtSubGyomuCode = txtSubGyomuCode;
    }

    @JsonProperty("txtShichosonCode")
    public TextBox getTxtShichosonCode() {
        return txtShichosonCode;
    }

    @JsonProperty("txtShichosonCode")
    public void setTxtShichosonCode(TextBox txtShichosonCode) {
        this.txtShichosonCode = txtShichosonCode;
    }

    @JsonProperty("txtShinseishoKanriNo")
    public TextBox getTxtShinseishoKanriNo() {
        return txtShinseishoKanriNo;
    }

    @JsonProperty("txtShinseishoKanriNo")
    public void setTxtShinseishoKanriNo(TextBox txtShinseishoKanriNo) {
        this.txtShinseishoKanriNo = txtShinseishoKanriNo;
    }

    @JsonProperty("btnTestDataSet")
    public Button getBtnTestDataSet() {
        return btnTestDataSet;
    }

    @JsonProperty("btnTestDataSet")
    public void setBtnTestDataSet(Button btnTestDataSet) {
        this.btnTestDataSet = btnTestDataSet;
    }

    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return ccdShujiiIryokikanAndShujiiInput;
    }

    @JsonProperty("hdnTestShinseishoKanriNo")
    public RString getHdnTestShinseishoKanriNo() {
        return hdnTestShinseishoKanriNo;
    }

    @JsonProperty("hdnTestShinseishoKanriNo")
    public void setHdnTestShinseishoKanriNo(RString hdnTestShinseishoKanriNo) {
        this.hdnTestShinseishoKanriNo = hdnTestShinseishoKanriNo;
    }

    @JsonProperty("hdnTestDatabaseSubGyomuCode")
    public RString getHdnTestDatabaseSubGyomuCode() {
        return hdnTestDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnTestDatabaseSubGyomuCode")
    public void setHdnTestDatabaseSubGyomuCode(RString hdnTestDatabaseSubGyomuCode) {
        this.hdnTestDatabaseSubGyomuCode = hdnTestDatabaseSubGyomuCode;
    }

    // </editor-fold>
}
