package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * IkenshoIraiTorokuPanel のクラスファイル
 *
 * @author 自動生成
 */
public class IkenshoIraiTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIraiKubun")
    private DropDownList ddlIraiKubun;
    @JsonProperty("txtSakuseiIraiD")
    private TextBoxDate txtSakuseiIraiD;
    @JsonProperty("ccdShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlIraiKubun
     * @return ddlIraiKubun
     */
    @JsonProperty("ddlIraiKubun")
    public DropDownList getDdlIraiKubun() {
        return ddlIraiKubun;
    }

    /*
     * setddlIraiKubun
     * @param ddlIraiKubun ddlIraiKubun
     */
    @JsonProperty("ddlIraiKubun")
    public void setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.ddlIraiKubun = ddlIraiKubun;
    }

    /*
     * gettxtSakuseiIraiD
     * @return txtSakuseiIraiD
     */
    @JsonProperty("txtSakuseiIraiD")
    public TextBoxDate getTxtSakuseiIraiD() {
        return txtSakuseiIraiD;
    }

    /*
     * settxtSakuseiIraiD
     * @param txtSakuseiIraiD txtSakuseiIraiD
     */
    @JsonProperty("txtSakuseiIraiD")
    public void setTxtSakuseiIraiD(TextBoxDate txtSakuseiIraiD) {
        this.txtSakuseiIraiD = txtSakuseiIraiD;
    }

    /*
     * getccdShujiiInput
     * @return ccdShujiiInput
     */
    @JsonProperty("ccdShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return ccdShujiiInput;
    }

    // </editor-fold>
}
