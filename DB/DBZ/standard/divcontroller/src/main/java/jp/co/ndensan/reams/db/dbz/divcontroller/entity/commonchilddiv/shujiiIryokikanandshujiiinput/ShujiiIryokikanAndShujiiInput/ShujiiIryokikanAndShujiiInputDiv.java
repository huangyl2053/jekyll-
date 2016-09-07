package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShujiiIryokikanAndShujiiInput のクラスファイル
 *
 * @reamsid_L DBZ-1300-140 chengsanyuan
 */
public class ShujiiIryokikanAndShujiiInputDiv extends Panel implements IShujiiIryokikanAndShujiiInputDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIryoKikanCode")
    private TextBoxCode txtIryoKikanCode;
    @JsonProperty("btnIryokikanGuide")
    private ButtonDialog btnIryokikanGuide;
    @JsonProperty("txtIryoKikanName")
    private TextBox txtIryoKikanName;
    @JsonProperty("btnShujiiRenrakuJiko")
    private ButtonDialog btnShujiiRenrakuJiko;
    @JsonProperty("btnZenkaiIrokikanJoho")
    private Button btnZenkaiIrokikanJoho;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("btnShujiiGuide")
    private ButtonDialog btnShujiiGuide;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("chkShiteii")
    private CheckBoxList chkShiteii;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("hdnRenrakujikoKey")
    private RString hdnRenrakujikoKey;
    @JsonProperty("hdnShujiiRenrakuJiko")
    private RString hdnShujiiRenrakuJiko;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;
    @JsonProperty("hdnSubGyomuModel")
    private RString hdnSubGyomuModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIryoKikanCode
     * @return txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public TextBoxCode getTxtIryoKikanCode() {
        return txtIryoKikanCode;
    }

    /*
     * settxtIryoKikanCode
     * @param txtIryoKikanCode txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    @Override
    public void setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.txtIryoKikanCode = txtIryoKikanCode;
    }

    /*
     * getbtnIryokikanGuide
     * @return btnIryokikanGuide
     */
    @JsonProperty("btnIryokikanGuide")
    public ButtonDialog getBtnIryokikanGuide() {
        return btnIryokikanGuide;
    }

    /*
     * setbtnIryokikanGuide
     * @param btnIryokikanGuide btnIryokikanGuide
     */
    @JsonProperty("btnIryokikanGuide")
    public void setBtnIryokikanGuide(ButtonDialog btnIryokikanGuide) {
        this.btnIryokikanGuide = btnIryokikanGuide;
    }

    /*
     * gettxtIryoKikanName
     * @return txtIryoKikanName
     */
    @JsonProperty("txtIryoKikanName")
    public TextBox getTxtIryoKikanName() {
        return txtIryoKikanName;
    }

    /*
     * settxtIryoKikanName
     * @param txtIryoKikanName txtIryoKikanName
     */
    @JsonProperty("txtIryoKikanName")
    @Override
    public void setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.txtIryoKikanName = txtIryoKikanName;
    }

    /*
     * getbtnShujiiRenrakuJiko
     * @return btnShujiiRenrakuJiko
     */
    @JsonProperty("btnShujiiRenrakuJiko")
    public ButtonDialog getBtnShujiiRenrakuJiko() {
        return btnShujiiRenrakuJiko;
    }

    /*
     * setbtnShujiiRenrakuJiko
     * @param btnShujiiRenrakuJiko btnShujiiRenrakuJiko
     */
    @JsonProperty("btnShujiiRenrakuJiko")
    public void setBtnShujiiRenrakuJiko(ButtonDialog btnShujiiRenrakuJiko) {
        this.btnShujiiRenrakuJiko = btnShujiiRenrakuJiko;
    }

    /*
     * getbtnZenkaiIrokikanJoho
     * @return btnZenkaiIrokikanJoho
     */
    @JsonProperty("btnZenkaiIrokikanJoho")
    public Button getBtnZenkaiIrokikanJoho() {
        return btnZenkaiIrokikanJoho;
    }

    /*
     * setbtnZenkaiIrokikanJoho
     * @param btnZenkaiIrokikanJoho btnZenkaiIrokikanJoho
     */
    @JsonProperty("btnZenkaiIrokikanJoho")
    public void setBtnZenkaiIrokikanJoho(Button btnZenkaiIrokikanJoho) {
        this.btnZenkaiIrokikanJoho = btnZenkaiIrokikanJoho;
    }

    /*
     * gettxtShujiiCode
     * @return txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    /*
     * settxtShujiiCode
     * @param txtShujiiCode txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    @Override
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode = txtShujiiCode;
    }

    /*
     * getbtnShujiiGuide
     * @return btnShujiiGuide
     */
    @JsonProperty("btnShujiiGuide")
    public ButtonDialog getBtnShujiiGuide() {
        return btnShujiiGuide;
    }

    /*
     * setbtnShujiiGuide
     * @param btnShujiiGuide btnShujiiGuide
     */
    @JsonProperty("btnShujiiGuide")
    public void setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.btnShujiiGuide = btnShujiiGuide;
    }

    /*
     * gettxtShujiiName
     * @return txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    /*
     * settxtShujiiName
     * @param txtShujiiName txtShujiiName
     */
    @JsonProperty("txtShujiiName")
    @Override
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName = txtShujiiName;
    }

    /*
     * getchkShiteii
     * @return chkShiteii
     */
    @JsonProperty("chkShiteii")
    public CheckBoxList getChkShiteii() {
        return chkShiteii;
    }

    /*
     * setchkShiteii
     * @param chkShiteii chkShiteii
     */
    @JsonProperty("chkShiteii")
    public void setChkShiteii(CheckBoxList chkShiteii) {
        this.chkShiteii = chkShiteii;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * gethdnRenrakujikoKey
     * @return hdnRenrakujikoKey
     */
    @JsonProperty("hdnRenrakujikoKey")
    public RString getHdnRenrakujikoKey() {
        return hdnRenrakujikoKey;
    }

    /*
     * sethdnRenrakujikoKey
     * @param hdnRenrakujikoKey hdnRenrakujikoKey
     */
    @JsonProperty("hdnRenrakujikoKey")
    public void setHdnRenrakujikoKey(RString hdnRenrakujikoKey) {
        this.hdnRenrakujikoKey = hdnRenrakujikoKey;
    }

    /*
     * gethdnShujiiRenrakuJiko
     * @return hdnShujiiRenrakuJiko
     */
    @JsonProperty("hdnShujiiRenrakuJiko")
    public RString getHdnShujiiRenrakuJiko() {
        return hdnShujiiRenrakuJiko;
    }

    /*
     * sethdnShujiiRenrakuJiko
     * @param hdnShujiiRenrakuJiko hdnShujiiRenrakuJiko
     */
    @JsonProperty("hdnShujiiRenrakuJiko")
    public void setHdnShujiiRenrakuJiko(RString hdnShujiiRenrakuJiko) {
        this.hdnShujiiRenrakuJiko = hdnShujiiRenrakuJiko;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnShichosonCode
     * @return hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    /*
     * sethdnShichosonCode
     * @param hdnShichosonCode hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * gethdnSubGyomuModel
     * @return hdnSubGyomuModel
     */
    @JsonProperty("hdnSubGyomuModel")
    public RString getHdnSubGyomuModel() {
        return hdnSubGyomuModel;
    }

    /*
     * sethdnSubGyomuModel
     * @param hdnSubGyomuModel hdnSubGyomuModel
     */
    @JsonProperty("hdnSubGyomuModel")
    public void setHdnSubGyomuModel(RString hdnSubGyomuModel) {
        this.hdnSubGyomuModel = hdnSubGyomuModel;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
        NinteiMode("NinteiMode"),
        ShokaiMode("ShokaiMode"),
        SimpleInputMode("SimpleInputMode"),
        SimpleShokaiMode("SimpleShokaiMode");

        private final String name;

        private ShoriType(final String name) {
            this.name = name;
        }

        public static ShoriType getEnum(String str) {
            ShoriType[] enumArray = ShoriType.values();

            for (ShoriType enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public ShoriType getMode_ShoriType() {
        return (ShoriType) _CommonChildDivModeUtil.getMode(this.modes, ShoriType.class);
    }

    @Override
    public void setMode_ShoriType(ShoriType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriType.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    @JsonIgnore
    public void initialize(LasdecCode shichosonCode, ShinseishoKanriNo shinseishoKanriNo, SubGyomuCode gyomuCode) {
        createHandler().initialize(shichosonCode, shinseishoKanriNo, gyomuCode);
    }

    @Override
    @JsonIgnore
    public void initialize(LasdecCode shichosonCode, ShinseishoKanriNo shinseishoKanriNo, SubGyomuCode gyomuCode, RString shujiiIryokikanCode,
            RString iryoKikanMeisho, RString shujiiCode, RString shujiiName) {
        createHandler().initialize(shichosonCode, shinseishoKanriNo, gyomuCode, shujiiIryokikanCode, iryoKikanMeisho, shujiiCode, shujiiName);
    }

    @JsonIgnore
    private ShujiiIryokikanAndShujiiInputHandler createHandler() {
        return new ShujiiIryokikanAndShujiiInputHandler(this);
    }

    @Override
    public RString getShujiiCode() {
        return this.getTxtShujiiCode().getValue();
    }

    @Override
    public RString getIryoKikanCode() {
        return this.getTxtIryoKikanCode().getValue();
    }

    @Override
    public RString getIryoKikanName() {
        return this.getTxtIryoKikanName().getValue();
    }

    @Override
    public RString getShujiiName() {
        return this.getTxtShujiiName().getValue();
    }

    @Override
    public RString getRenrakuJiko() {
        return this.hdnShujiiRenrakuJiko;
    }

    @Override
    public void setRenrakuJiko(RString renrakuJiko) {
        this.hdnShujiiRenrakuJiko = renrakuJiko;
    }

    @Override
    public boolean hasShiteii() {
        return this.getChkShiteii().getSelectedKeys().contains(new RString("key0"));
    }

    @Override
    public void setShiteii(boolean isChecked) {
        List<RString> keys = new ArrayList<>();
        if (isChecked) {
            keys.add(new RString("key0"));
        }
        this.getChkShiteii().setSelectedItemsByKey(keys);
    }

    @Override
    public void clear() {
        createHandler().clear();
    }
}
