package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.IKihonChosaInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.KihonChosaInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplKihonChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKihonChosaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnKiteichiSettei")
    private Button btnKiteichiSettei;
    @JsonProperty("btnZenkaiCopy")
    private Button btnZenkaiCopy;
    @JsonProperty("txtIchijiHanteiKekka")
    private TextBox txtIchijiHanteiKekka;
    @JsonProperty("btnIchiHanteiJisshi")
    private Button btnIchiHanteiJisshi;
    @JsonProperty("tabKihonChosaShurui")
    private tabKihonChosaShuruiDiv tabKihonChosaShurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnKiteichiSettei
     * @return btnKiteichiSettei
     */
    @JsonProperty("btnKiteichiSettei")
    public Button getBtnKiteichiSettei() {
        return btnKiteichiSettei;
    }

    /*
     * setbtnKiteichiSettei
     * @param btnKiteichiSettei btnKiteichiSettei
     */
    @JsonProperty("btnKiteichiSettei")
    public void setBtnKiteichiSettei(Button btnKiteichiSettei) {
        this.btnKiteichiSettei = btnKiteichiSettei;
    }

    /*
     * getbtnZenkaiCopy
     * @return btnZenkaiCopy
     */
    @JsonProperty("btnZenkaiCopy")
    public Button getBtnZenkaiCopy() {
        return btnZenkaiCopy;
    }

    /*
     * setbtnZenkaiCopy
     * @param btnZenkaiCopy btnZenkaiCopy
     */
    @JsonProperty("btnZenkaiCopy")
    public void setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.btnZenkaiCopy = btnZenkaiCopy;
    }

    /*
     * gettxtIchijiHanteiKekka
     * @return txtIchijiHanteiKekka
     */
    @JsonProperty("txtIchijiHanteiKekka")
    public TextBox getTxtIchijiHanteiKekka() {
        return txtIchijiHanteiKekka;
    }

    /*
     * settxtIchijiHanteiKekka
     * @param txtIchijiHanteiKekka txtIchijiHanteiKekka
     */
    @JsonProperty("txtIchijiHanteiKekka")
    public void setTxtIchijiHanteiKekka(TextBox txtIchijiHanteiKekka) {
        this.txtIchijiHanteiKekka = txtIchijiHanteiKekka;
    }

    /*
     * getbtnIchiHanteiJisshi
     * @return btnIchiHanteiJisshi
     */
    @JsonProperty("btnIchiHanteiJisshi")
    public Button getBtnIchiHanteiJisshi() {
        return btnIchiHanteiJisshi;
    }

    /*
     * setbtnIchiHanteiJisshi
     * @param btnIchiHanteiJisshi btnIchiHanteiJisshi
     */
    @JsonProperty("btnIchiHanteiJisshi")
    public void setBtnIchiHanteiJisshi(Button btnIchiHanteiJisshi) {
        this.btnIchiHanteiJisshi = btnIchiHanteiJisshi;
    }

    /*
     * gettabKihonChosaShurui
     * @return tabKihonChosaShurui
     */
    @JsonProperty("tabKihonChosaShurui")
    public tabKihonChosaShuruiDiv getTabKihonChosaShurui() {
        return tabKihonChosaShurui;
    }

    /*
     * settabKihonChosaShurui
     * @param tabKihonChosaShurui tabKihonChosaShurui
     */
    @JsonProperty("tabKihonChosaShurui")
    public void setTabKihonChosaShurui(tabKihonChosaShuruiDiv tabKihonChosaShurui) {
        this.tabKihonChosaShurui = tabKihonChosaShurui;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplIchigunDiv getTplIchigun() {
        return this.getTabKihonChosaShurui().getTplIchigun();
    }

    @JsonIgnore
    public void  setTplIchigun(tplIchigunDiv tplIchigun) {
        this.getTabKihonChosaShurui().setTplIchigun(tplIchigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdIchigunKihonChosa() {
        return this.getTabKihonChosaShurui().getTplIchigun().getCcdIchigunKihonChosa();
    }

    @JsonIgnore
    public tplNigunDiv getTplNigun() {
        return this.getTabKihonChosaShurui().getTplNigun();
    }

    @JsonIgnore
    public void  setTplNigun(tplNigunDiv tplNigun) {
        this.getTabKihonChosaShurui().setTplNigun(tplNigun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdNigunKihonChosa() {
        return this.getTabKihonChosaShurui().getTplNigun().getCcdNigunKihonChosa();
    }

    @JsonIgnore
    public tplSangunDiv getTplSangun() {
        return this.getTabKihonChosaShurui().getTplSangun();
    }

    @JsonIgnore
    public void  setTplSangun(tplSangunDiv tplSangun) {
        this.getTabKihonChosaShurui().setTplSangun(tplSangun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSangunKihonChosa() {
        return this.getTabKihonChosaShurui().getTplSangun().getCcdSangunKihonChosa();
    }

    @JsonIgnore
    public tplYongunDiv getTplYongun() {
        return this.getTabKihonChosaShurui().getTplYongun();
    }

    @JsonIgnore
    public void  setTplYongun(tplYongunDiv tplYongun) {
        this.getTabKihonChosaShurui().setTplYongun(tplYongun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdYongunKihonChosa() {
        return this.getTabKihonChosaShurui().getTplYongun().getCcdYongunKihonChosa();
    }

    @JsonIgnore
    public tplGogunDiv getTplGogun() {
        return this.getTabKihonChosaShurui().getTplGogun();
    }

    @JsonIgnore
    public void  setTplGogun(tplGogunDiv tplGogun) {
        this.getTabKihonChosaShurui().setTplGogun(tplGogun);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdGogun() {
        return this.getTabKihonChosaShurui().getTplGogun().getCcdGogun();
    }

    @JsonIgnore
    public tplTokubetsuIryoDiv getTplTokubetsuIryo() {
        return this.getTabKihonChosaShurui().getTplTokubetsuIryo();
    }

    @JsonIgnore
    public void  setTplTokubetsuIryo(tplTokubetsuIryoDiv tplTokubetsuIryo) {
        this.getTabKihonChosaShurui().setTplTokubetsuIryo(tplTokubetsuIryo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdTokubetsuIryoKihonChosa() {
        return this.getTabKihonChosaShurui().getTplTokubetsuIryo().getCcdTokubetsuIryoKihonChosa();
    }

    @JsonIgnore
    public tplSeikatsuJiritsudoDiv getTplSeikatsuJiritsudo() {
        return this.getTabKihonChosaShurui().getTplSeikatsuJiritsudo();
    }

    @JsonIgnore
    public void  setTplSeikatsuJiritsudo(tplSeikatsuJiritsudoDiv tplSeikatsuJiritsudo) {
        this.getTabKihonChosaShurui().setTplSeikatsuJiritsudo(tplSeikatsuJiritsudo);
    }

    @JsonIgnore
    public IKihonChosaInputDiv getCcdSeikatsuJiritsudoKihonchosa() {
        return this.getTabKihonChosaShurui().getTplSeikatsuJiritsudo().getCcdSeikatsuJiritsudoKihonchosa();
    }

    // </editor-fold>
}
