package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IIryohokenRirekiCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryohokenRirekiCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.IRoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai.RoreiFukushiNenkinShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.IShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuShutokuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShutokuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
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
    public void  setTplShikakuJoho(tplShikakuJohoDiv tplShikakuJoho) {
        this.getTabInputs().setTplShikakuJoho(tplShikakuJoho);
    }

    @JsonIgnore
    public ShikakuTokusoRirekiiDiv getShikakuTokusoRirekii() {
        return this.getTabInputs().getTplShikakuJoho().getShikakuTokusoRirekii();
    }

    @JsonIgnore
    public void  setShikakuTokusoRirekii(ShikakuTokusoRirekiiDiv ShikakuTokusoRirekii) {
        this.getTabInputs().getTplShikakuJoho().setShikakuTokusoRirekii(ShikakuTokusoRirekii);
    }

    @JsonIgnore
    public IShikakuTokusoRirekiDiv getCcdShikakuTokusoRireki() {
        return this.getTabInputs().getTplShikakuJoho().getShikakuTokusoRirekii().getCcdShikakuTokusoRireki();
    }

    @JsonIgnore
    public tplIryoHokenDiv getTplIryoHoken() {
        return this.getTabInputs().getTplIryoHoken();
    }

    @JsonIgnore
    public void  setTplIryoHoken(tplIryoHokenDiv tplIryoHoken) {
        this.getTabInputs().setTplIryoHoken(tplIryoHoken);
    }

    @JsonIgnore
    public IryoHokenRirekiiDiv getIryoHokenRirekii() {
        return this.getTabInputs().getTplIryoHoken().getIryoHokenRirekii();
    }

    @JsonIgnore
    public void  setIryoHokenRirekii(IryoHokenRirekiiDiv IryoHokenRirekii) {
        this.getTabInputs().getTplIryoHoken().setIryoHokenRirekii(IryoHokenRirekii);
    }

    @JsonIgnore
    public IIryohokenRirekiCommonChildDiv getCcdIryoHokenRireki() {
        return this.getTabInputs().getTplIryoHoken().getIryoHokenRirekii().getCcdIryoHokenRireki();
    }

    @JsonIgnore
    public tplRofukuNenkinDiv getTplRofukuNenkin() {
        return this.getTabInputs().getTplRofukuNenkin();
    }

    @JsonIgnore
    public void  setTplRofukuNenkin(tplRofukuNenkinDiv tplRofukuNenkin) {
        this.getTabInputs().setTplRofukuNenkin(tplRofukuNenkin);
    }

    @JsonIgnore
    public RohukuNenkinDiv getRohukuNenkin() {
        return this.getTabInputs().getTplRofukuNenkin().getRohukuNenkin();
    }

    @JsonIgnore
    public void  setRohukuNenkin(RohukuNenkinDiv RohukuNenkin) {
        this.getTabInputs().getTplRofukuNenkin().setRohukuNenkin(RohukuNenkin);
    }

    @JsonIgnore
    public IRoreiFukushiNenkinShokaiDiv getCcdRohukuNenkin() {
        return this.getTabInputs().getTplRofukuNenkin().getRohukuNenkin().getCcdRohukuNenkin();
    }

    // </editor-fold>
}
