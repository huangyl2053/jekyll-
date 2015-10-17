package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShutokuJoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuShutokuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabInputs")
    private tabInputsDiv tabInputs;
    @JsonProperty("shikakuInputMode")
    private RString shikakuInputMode;
    @JsonProperty("iryoHokenInputMode")
    private RString iryoHokenInputMode;
    @JsonProperty("shikakuSelectRow")
    private RString shikakuSelectRow;
    @JsonProperty("iryoHokenSelectRow")
    private RString iryoHokenSelectRow;
    @JsonProperty("dateOfBirth")
    private RString dateOfBirth;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabInputs")
    public tabInputsDiv getTabInputs() {
        return tabInputs;
    }

    @JsonProperty("tabInputs")
    public void setTabInputs(tabInputsDiv tabInputs) {
        this.tabInputs = tabInputs;
    }

    @JsonProperty("shikakuInputMode")
    public RString getShikakuInputMode() {
        return shikakuInputMode;
    }

    @JsonProperty("shikakuInputMode")
    public void setShikakuInputMode(RString shikakuInputMode) {
        this.shikakuInputMode = shikakuInputMode;
    }

    @JsonProperty("iryoHokenInputMode")
    public RString getIryoHokenInputMode() {
        return iryoHokenInputMode;
    }

    @JsonProperty("iryoHokenInputMode")
    public void setIryoHokenInputMode(RString iryoHokenInputMode) {
        this.iryoHokenInputMode = iryoHokenInputMode;
    }

    @JsonProperty("shikakuSelectRow")
    public RString getShikakuSelectRow() {
        return shikakuSelectRow;
    }

    @JsonProperty("shikakuSelectRow")
    public void setShikakuSelectRow(RString shikakuSelectRow) {
        this.shikakuSelectRow = shikakuSelectRow;
    }

    @JsonProperty("iryoHokenSelectRow")
    public RString getIryoHokenSelectRow() {
        return iryoHokenSelectRow;
    }

    @JsonProperty("iryoHokenSelectRow")
    public void setIryoHokenSelectRow(RString iryoHokenSelectRow) {
        this.iryoHokenSelectRow = iryoHokenSelectRow;
    }

    @JsonProperty("dateOfBirth")
    public RString getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(RString dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplShikakuJohoDiv getTplShikakuJoho() {
        return this.getTabInputs().getTplShikakuJoho();
    }

    @JsonIgnore
    public void setTplShikakuJoho(tplShikakuJohoDiv tplShikakuJoho) {
        this.getTabInputs().setTplShikakuJoho(tplShikakuJoho);
    }

    @JsonIgnore
    public ShikakuTokusoRirekiPanelDiv getShikakuTokusoRirekiPanel() {
        return this.getTabInputs().getTplShikakuJoho().getShikakuTokusoRirekiPanel();
    }

    @JsonIgnore
    public void setShikakuTokusoRirekiPanel(ShikakuTokusoRirekiPanelDiv ShikakuTokusoRirekiPanel) {
        this.getTabInputs().getTplShikakuJoho().setShikakuTokusoRirekiPanel(ShikakuTokusoRirekiPanel);
    }

    @JsonIgnore
    public tplIryoHokenDiv getTplIryoHoken() {
        return this.getTabInputs().getTplIryoHoken();
    }

    @JsonIgnore
    public void setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.getTabInputs().setTplIryoHoken(tplIryoHoken);
    }

    @JsonIgnore
    public IryoHokenRirekiPanelDiv getIryoHokenRirekiPanel() {
        return this.getTabInputs().getTplIryoHoken().getIryoHokenRirekiPanel();
    }

    @JsonIgnore
    public void setIryoHokenRirekiPanel(IryoHokenRirekiPanelDiv IryoHokenRirekiPanel) {
        this.getTabInputs().getTplIryoHoken().setIryoHokenRirekiPanel(IryoHokenRirekiPanel);
    }

    @JsonIgnore
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return this.getTabInputs().getTplRofukuNenkin();
    }

    @JsonIgnore
    public void setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.getTabInputs().setTplRofukuNenkin(tplRofukuNenkin);
    }

    @JsonIgnore
    public RohukuNenkinDiv getRohukuNenkin() {
        return this.getTabInputs().getTplRofukuNenkin().getRohukuNenkin();
    }

    @JsonIgnore
    public void setRohukuNenkin(RohukuNenkinDiv RohukuNenkin) {
        this.getTabInputs().getTplRofukuNenkin().setRohukuNenkin(RohukuNenkin);
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabInputs().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabInputs().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public ShisetsuNyutaishoRirekiDiv getShisetsuNyutaishoRireki() {
        return this.getTabInputs().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public void setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiDiv ShisetsuNyutaishoRireki) {
        this.getTabInputs().getTplShisetsuNyutaisho().setShisetsuNyutaishoRireki(ShisetsuNyutaishoRireki);
    }

    @JsonIgnore
    public ShisetsuNyutaishoInputDiv getShisetsuNyutaishoInput() {
        return this.getTabInputs().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().getShisetsuNyutaishoInput();
    }

    @JsonIgnore
    public void setShisetsuNyutaishoInput(ShisetsuNyutaishoInputDiv ShisetsuNyutaishoInput) {
        this.getTabInputs().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().setShisetsuNyutaishoInput(ShisetsuNyutaishoInput);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRirekiKanri() {
        return this.getTabInputs().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri();
    }

    @JsonIgnore
    public tplSeikatsuHogoDiv getTplSeikatsuHogo() {
        return this.getTabInputs().getTplSeikatsuHogo();
    }

    @JsonIgnore
    public void setTplSeikatsuHogo(tplSeikatsuHogoDiv tplSeikatsuHogo) {
        this.getTabInputs().setTplSeikatsuHogo(tplSeikatsuHogo);
    }

    @JsonIgnore
    public SeikatsuHogoDiv getSeikatsuHogo() {
        return this.getTabInputs().getTplSeikatsuHogo().getSeikatsuHogo();
    }

    @JsonIgnore
    public void setSeikatsuHogo(SeikatsuHogoDiv SeikatsuHogo) {
        this.getTabInputs().getTplSeikatsuHogo().setSeikatsuHogo(SeikatsuHogo);
    }

    // </editor-fold>
}
