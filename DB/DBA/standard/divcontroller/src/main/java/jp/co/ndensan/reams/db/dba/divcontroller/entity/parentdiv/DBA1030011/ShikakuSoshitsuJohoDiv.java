package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuSoshitsuJoho のクラスファイル
 *
 */
public class ShikakuSoshitsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    /*
     * gettabInputs
     * @return tabInputs
     */
    @JsonProperty("tabInputs")
    public tabInputsDiv getTabInputs() {
        return tabInputs;
    }

    /*
     * settabInputs
     * @param tabInputs tabInputs
     */
    @JsonProperty("tabInputs")
    public void setTabInputs(tabInputsDiv tabInputs) {
        this.tabInputs = tabInputs;
    }

    /*
     * getshikakuInputMode
     * @return shikakuInputMode
     */
    @JsonProperty("shikakuInputMode")
    public RString getShikakuInputMode() {
        return shikakuInputMode;
    }

    /*
     * setshikakuInputMode
     * @param shikakuInputMode shikakuInputMode
     */
    @JsonProperty("shikakuInputMode")
    public void setShikakuInputMode(RString shikakuInputMode) {
        this.shikakuInputMode = shikakuInputMode;
    }

    /*
     * getiryoHokenInputMode
     * @return iryoHokenInputMode
     */
    @JsonProperty("iryoHokenInputMode")
    public RString getIryoHokenInputMode() {
        return iryoHokenInputMode;
    }

    /*
     * setiryoHokenInputMode
     * @param iryoHokenInputMode iryoHokenInputMode
     */
    @JsonProperty("iryoHokenInputMode")
    public void setIryoHokenInputMode(RString iryoHokenInputMode) {
        this.iryoHokenInputMode = iryoHokenInputMode;
    }

    /*
     * getshikakuSelectRow
     * @return shikakuSelectRow
     */
    @JsonProperty("shikakuSelectRow")
    public RString getShikakuSelectRow() {
        return shikakuSelectRow;
    }

    /*
     * setshikakuSelectRow
     * @param shikakuSelectRow shikakuSelectRow
     */
    @JsonProperty("shikakuSelectRow")
    public void setShikakuSelectRow(RString shikakuSelectRow) {
        this.shikakuSelectRow = shikakuSelectRow;
    }

    /*
     * getiryoHokenSelectRow
     * @return iryoHokenSelectRow
     */
    @JsonProperty("iryoHokenSelectRow")
    public RString getIryoHokenSelectRow() {
        return iryoHokenSelectRow;
    }

    /*
     * setiryoHokenSelectRow
     * @param iryoHokenSelectRow iryoHokenSelectRow
     */
    @JsonProperty("iryoHokenSelectRow")
    public void setIryoHokenSelectRow(RString iryoHokenSelectRow) {
        this.iryoHokenSelectRow = iryoHokenSelectRow;
    }

    /*
     * getdateOfBirth
     * @return dateOfBirth
     */
    @JsonProperty("dateOfBirth")
    public RString getDateOfBirth() {
        return dateOfBirth;
    }

    /*
     * setdateOfBirth
     * @param dateOfBirth dateOfBirth
     */
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
    public ShikakuTokusoRirekiMainDiv getShikakuTokusoRirekiMain() {
        return this.getTabInputs().getTplShikakuJoho().getShikakuTokusoRirekiMain();
    }

    @JsonIgnore
    public void setShikakuTokusoRirekiMain(ShikakuTokusoRirekiMainDiv ShikakuTokusoRirekiMain) {
        this.getTabInputs().getTplShikakuJoho().setShikakuTokusoRirekiMain(ShikakuTokusoRirekiMain);
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
    public IryoHokenRirekiMainDiv getIryoHokenRirekiMain() {
        return this.getTabInputs().getTplIryoHoken().getIryoHokenRirekiMain();
    }

    @JsonIgnore
    public void setIryoHokenRirekiMain(IryoHokenRirekiMainDiv IryoHokenRirekiMain) {
        this.getTabInputs().getTplIryoHoken().setIryoHokenRirekiMain(IryoHokenRirekiMain);
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
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRirekiKanri() {
        return this.getTabInputs().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri();
    }

    @JsonIgnore
    public tplShoruiJokyoDiv getTplShoruiJokyo() {
        return this.getTabInputs().getTplShoruiJokyo();
    }

    @JsonIgnore
    public void setTplShoruiJokyo(tplShoruiJokyoDiv tplShoruiJokyo) {
        this.getTabInputs().setTplShoruiJokyo(tplShoruiJokyo);
    }

    @JsonIgnore
    public ShoruiJokyoDiv getShoruiJokyo() {
        return this.getTabInputs().getTplShoruiJokyo().getShoruiJokyo();
    }

    @JsonIgnore
    public void setShoruiJokyo(ShoruiJokyoDiv ShoruiJokyo) {
        this.getTabInputs().getTplShoruiJokyo().setShoruiJokyo(ShoruiJokyo);
    }

    // </editor-fold>
}
