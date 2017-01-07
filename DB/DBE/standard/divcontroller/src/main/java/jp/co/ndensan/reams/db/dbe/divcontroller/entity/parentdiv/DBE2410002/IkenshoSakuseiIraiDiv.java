package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoSakuseiIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoSakuseiIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    private IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;
    @JsonProperty("ikenshoIraiRirekiNo")
    private RString ikenshoIraiRirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkenshoIraiTorokuPanel
     * @return IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public IkenshoIraiTorokuPanelDiv getIkenshoIraiTorokuPanel() {
        return IkenshoIraiTorokuPanel;
    }

    /*
     * setIkenshoIraiTorokuPanel
     * @param IkenshoIraiTorokuPanel IkenshoIraiTorokuPanel
     */
    @JsonProperty("IkenshoIraiTorokuPanel")
    public void setIkenshoIraiTorokuPanel(IkenshoIraiTorokuPanelDiv IkenshoIraiTorokuPanel) {
        this.IkenshoIraiTorokuPanel = IkenshoIraiTorokuPanel;
    }

    /*
     * getccdNinteiShinseishaKihonInfo
     * @return ccdNinteiShinseishaKihonInfo
     */
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return ccdNinteiShinseishaKihonInfo;
    }

    /*
     * getikenshoIraiRirekiNo
     * @return ikenshoIraiRirekiNo
     */
    @JsonProperty("ikenshoIraiRirekiNo")
    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /*
     * setikenshoIraiRirekiNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    @JsonProperty("ikenshoIraiRirekiNo")
    public void setIkenshoIraiRirekiNo(RString ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlIraiKubun() {
        return this.getIkenshoIraiTorokuPanel().getDdlIraiKubun();
    }

    @JsonIgnore
    public void  setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.getIkenshoIraiTorokuPanel().setDdlIraiKubun(ddlIraiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtSakuseiIraiD() {
        return this.getIkenshoIraiTorokuPanel().getTxtSakuseiIraiD();
    }

    @JsonIgnore
    public void  setTxtSakuseiIraiD(TextBoxDate txtSakuseiIraiD) {
        this.getIkenshoIraiTorokuPanel().setTxtSakuseiIraiD(txtSakuseiIraiD);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiInput() {
        return this.getIkenshoIraiTorokuPanel().getCcdShujiiInput();
    }

    // </editor-fold>
}
