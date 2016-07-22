package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * NinteichosaIraiByHand のクラスファイル
 *
 * @author 自動生成
 */
public class NinteichosaIraiByHandDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIraiKubun")
    private DropDownList ddlIraiKubun;
    @JsonProperty("txtChosaIraiD")
    private TextBoxDate txtChosaIraiD;
    @JsonProperty("ccdItakusakiAndChosainInput")
    private ChosaItakusakiAndChosainInputDiv ccdItakusakiAndChosainInput;

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
     * gettxtChosaIraiD
     * @return txtChosaIraiD
     */
    @JsonProperty("txtChosaIraiD")
    public TextBoxDate getTxtChosaIraiD() {
        return txtChosaIraiD;
    }

    /*
     * settxtChosaIraiD
     * @param txtChosaIraiD txtChosaIraiD
     */
    @JsonProperty("txtChosaIraiD")
    public void setTxtChosaIraiD(TextBoxDate txtChosaIraiD) {
        this.txtChosaIraiD = txtChosaIraiD;
    }

    /*
     * getccdItakusakiAndChosainInput
     * @return ccdItakusakiAndChosainInput
     */
    @JsonProperty("ccdItakusakiAndChosainInput")
    public IChosaItakusakiAndChosainInputDiv getCcdItakusakiAndChosainInput() {
        return ccdItakusakiAndChosainInput;
    }

    // </editor-fold>
}
