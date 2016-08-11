package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TekiyoJogaiRireki のクラスファイル
 *
 * @reamsid_L DBA-0210-010 dingyi
 */
public class TekiyoJogaiRirekiDiv extends Panel implements ITekiyoJogaiRirekiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelTekiyoRireki")
    private panelTekiyoRirekiDiv panelTekiyoRireki;
    @JsonProperty("panelTekiyoInput")
    private panelTekiyoInputDiv panelTekiyoInput;
    @JsonProperty("panelTekiyoJokaiTekiInput")
    private panelTekiyoJokaiTekiInputDiv panelTekiyoJokaiTekiInput;
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    private panelTekiyoJokaiKaiJyoInputDiv panelTekiyoJokaiKaiJyoInput;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnInputClear")
    private Button btnInputClear;
    @JsonProperty("stauts")
    private RString stauts;
    @JsonProperty("hiddenInputShikibetsuCode")
    private RString hiddenInputShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelTekiyoRireki
     * @return panelTekiyoRireki
     */
    @JsonProperty("panelTekiyoRireki")
    public panelTekiyoRirekiDiv getPanelTekiyoRireki() {
        return panelTekiyoRireki;
    }

    /*
     * setpanelTekiyoRireki
     * @param panelTekiyoRireki panelTekiyoRireki
     */
    @JsonProperty("panelTekiyoRireki")
    public void setPanelTekiyoRireki(panelTekiyoRirekiDiv panelTekiyoRireki) {
        this.panelTekiyoRireki = panelTekiyoRireki;
    }

    /*
     * getpanelTekiyoInput
     * @return panelTekiyoInput
     */
    @JsonProperty("panelTekiyoInput")
    public panelTekiyoInputDiv getPanelTekiyoInput() {
        return panelTekiyoInput;
    }

    /*
     * setpanelTekiyoInput
     * @param panelTekiyoInput panelTekiyoInput
     */
    @JsonProperty("panelTekiyoInput")
    public void setPanelTekiyoInput(panelTekiyoInputDiv panelTekiyoInput) {
        this.panelTekiyoInput = panelTekiyoInput;
    }

    /*
     * getpanelTekiyoJokaiTekiInput
     * @return panelTekiyoJokaiTekiInput
     */
    @JsonProperty("panelTekiyoJokaiTekiInput")
    public panelTekiyoJokaiTekiInputDiv getPanelTekiyoJokaiTekiInput() {
        return panelTekiyoJokaiTekiInput;
    }

    /*
     * setpanelTekiyoJokaiTekiInput
     * @param panelTekiyoJokaiTekiInput panelTekiyoJokaiTekiInput
     */
    @JsonProperty("panelTekiyoJokaiTekiInput")
    public void setPanelTekiyoJokaiTekiInput(panelTekiyoJokaiTekiInputDiv panelTekiyoJokaiTekiInput) {
        this.panelTekiyoJokaiTekiInput = panelTekiyoJokaiTekiInput;
    }

    /*
     * getpanelTekiyoJokaiKaiJyoInput
     * @return panelTekiyoJokaiKaiJyoInput
     */
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    public panelTekiyoJokaiKaiJyoInputDiv getPanelTekiyoJokaiKaiJyoInput() {
        return panelTekiyoJokaiKaiJyoInput;
    }

    /*
     * setpanelTekiyoJokaiKaiJyoInput
     * @param panelTekiyoJokaiKaiJyoInput panelTekiyoJokaiKaiJyoInput
     */
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    public void setPanelTekiyoJokaiKaiJyoInput(panelTekiyoJokaiKaiJyoInputDiv panelTekiyoJokaiKaiJyoInput) {
        this.panelTekiyoJokaiKaiJyoInput = panelTekiyoJokaiKaiJyoInput;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnInputClear
     * @return btnInputClear
     */
    @JsonProperty("btnInputClear")
    public Button getBtnInputClear() {
        return btnInputClear;
    }

    /*
     * setbtnInputClear
     * @param btnInputClear btnInputClear
     */
    @JsonProperty("btnInputClear")
    public void setBtnInputClear(Button btnInputClear) {
        this.btnInputClear = btnInputClear;
    }

    /*
     * getstauts
     * @return stauts
     */
    @JsonProperty("stauts")
    public RString getStauts() {
        return stauts;
    }

    /*
     * setstauts
     * @param stauts stauts
     */
    @JsonProperty("stauts")
    public void setStauts(RString stauts) {
        this.stauts = stauts;
    }

    /*
     * gethiddenInputShikibetsuCode
     * @return hiddenInputShikibetsuCode
     */
    @JsonProperty("hiddenInputShikibetsuCode")
    public RString getHiddenInputShikibetsuCode() {
        return hiddenInputShikibetsuCode;
    }

    /*
     * sethiddenInputShikibetsuCode
     * @param hiddenInputShikibetsuCode hiddenInputShikibetsuCode
     */
    @JsonProperty("hiddenInputShikibetsuCode")
    public void setHiddenInputShikibetsuCode(RString hiddenInputShikibetsuCode) {
        this.hiddenInputShikibetsuCode = hiddenInputShikibetsuCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        適用登録モード("適用登録モード"),
        解除モード("解除モード"),
        施設変更モード("施設変更モード"),
        訂正履歴モード("訂正履歴モード"),
        照会モード("照会モード");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelTekiyoRireki().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelTekiyoRireki().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<datagridTekiyoJogai_Row> getDatagridTekiyoJogai() {
        return this.getPanelTekiyoRireki().getDatagridTekiyoJogai();
    }

    @JsonIgnore
    public void  setDatagridTekiyoJogai(DataGrid<datagridTekiyoJogai_Row> datagridTekiyoJogai) {
        this.getPanelTekiyoRireki().setDatagridTekiyoJogai(datagridTekiyoJogai);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyusyoDateInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtNyusyoDateInput();
    }

    @JsonIgnore
    public void  setTxtNyusyoDateInput(TextBoxDate txtNyusyoDateInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtNyusyoDateInput(txtNyusyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoDateInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtTekiyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTekiyoDateInput(TextBoxDate txtTekiyoDateInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtTekiyoDateInput(txtTekiyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTkyoTododkDateIn() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtTkyoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtTkyoTododkDateIn(TextBoxDate txtTkyoTododkDateIn) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtTkyoTododkDateIn(txtTkyoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyuInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getDdlTekiyoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyuInput(DropDownList ddlTekiyoJiyuInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setDdlTekiyoJiyuInput(ddlTekiyoJiyuInput);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtTaisyoDateInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtTaisyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTaisyoDateInput(TextBoxDate txtTaisyoDateInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtTaisyoDateInput(txtTaisyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoDateInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtKaijoDateInput();
    }

    @JsonIgnore
    public void  setTxtKaijoDateInput(TextBoxDate txtKaijoDateInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtKaijoDateInput(txtKaijoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoTododkDateIn() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtKaijoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtKaijoTododkDateIn(TextBoxDate txtKaijoTododkDateIn) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtKaijoTododkDateIn(txtKaijoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJiyuInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getDdlKaijoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyuInput(DropDownList ddlKaijoJiyuInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setDdlKaijoJiyuInput(ddlKaijoJiyuInput);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private TekiyoJogaiRirekiHandler getHandler() {
        return new TekiyoJogaiRirekiHandler(this);
    }

    @Override
    public void set状態(RString mode) {
        setMode_DisplayMode(TekiyoJogaiRirekiDiv.DisplayMode.getEnum(mode.toString()));
    }

    @Override
    public void setDiplayMode(DisplayMode mode) {
        setMode_DisplayMode(mode);
    }

    @Override
    public void initialize(ShikibetsuCode 識別コード) {
        getHandler().initialize(識別コード);
    }

    @Override
    public void saveTekiyoJogaisha(ShikibetsuCode 識別コード) {
        getHandler().saveTekiyoJogaisha(識別コード);
    }

    @Override
    public List<datagridTekiyoJogai_Row> get適用情報一覧() {
        return getHandler().get適用情報一覧();
    }
}
