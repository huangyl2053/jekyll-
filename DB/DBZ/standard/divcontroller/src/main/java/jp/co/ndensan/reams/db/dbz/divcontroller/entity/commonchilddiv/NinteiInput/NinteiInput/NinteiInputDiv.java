package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputNaiyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput.NinteiInputHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteiinput.NinteiInputValidationHandler;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * NinteiInput のクラスファイル。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class NinteiInputDiv extends Panel implements INinteiInputDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiJoho")
    private NinteiJohoDiv NinteiJoho;
    @JsonProperty("ServiceShitei")
    private ServiceShiteiDiv ServiceShitei;
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    private RString hdnKoroshoIfShikibetsuCode;
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;
    @JsonProperty("hdnNinteiYmd")
    private RString hdnNinteiYmd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getNinteiJoho
     * @return NinteiJoho
     */
    @JsonProperty("NinteiJoho")
    @Override
    public NinteiJohoDiv getNinteiJoho() {
        return NinteiJoho;
    }

    /*
     * setNinteiJoho
     * @param NinteiJoho NinteiJoho
     */
    @JsonProperty("NinteiJoho")
    public void setNinteiJoho(NinteiJohoDiv NinteiJoho) {
        this.NinteiJoho = NinteiJoho;
    }

    /*
     * getServiceShitei
     * @return ServiceShitei
     */
    @JsonProperty("ServiceShitei")
    public ServiceShiteiDiv getServiceShitei() {
        return ServiceShitei;
    }

    /*
     * setServiceShitei
     * @param ServiceShitei ServiceShitei
     */
    @JsonProperty("ServiceShitei")
    public void setServiceShitei(ServiceShiteiDiv ServiceShitei) {
        this.ServiceShitei = ServiceShitei;
    }

    /*
     * gettxtShinsakaiIken
     * @return txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    @Override
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    /*
     * settxtShinsakaiIken
     * @param txtShinsakaiIken txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken = txtShinsakaiIken;
    }

    /*
     * gethdnDatabaseSubGyomuCode
     * @return hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    /*
     * sethdnDatabaseSubGyomuCode
     * @param hdnDatabaseSubGyomuCode hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
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
     * gethdnKoroshoIfShikibetsuCode
     * @return hdnKoroshoIfShikibetsuCode
     */
    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    public RString getHdnKoroshoIfShikibetsuCode() {
        return hdnKoroshoIfShikibetsuCode;
    }

    /*
     * sethdnKoroshoIfShikibetsuCode
     * @param hdnKoroshoIfShikibetsuCode hdnKoroshoIfShikibetsuCode
     */
    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    public void setHdnKoroshoIfShikibetsuCode(RString hdnKoroshoIfShikibetsuCode) {
        this.hdnKoroshoIfShikibetsuCode = hdnKoroshoIfShikibetsuCode;
    }

    /*
     * gethdnHihokenshaNo
     * @return hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    /*
     * sethdnHihokenshaNo
     * @param hdnHihokenshaNo hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo = hdnHihokenshaNo;
    }

    /*
     * gethdnNinteiYmd
     * @return hdnNinteiYmd
     */
    @JsonProperty("hdnNinteiYmd")
    public RString getHdnNinteiYmd() {
        return hdnNinteiYmd;
    }

    /*
     * sethdnNinteiYmd
     * @param hdnNinteiYmd hdnNinteiYmd
     */
    @JsonProperty("hdnNinteiYmd")
    public void setHdnNinteiYmd(RString hdnNinteiYmd) {
        this.hdnNinteiYmd = hdnNinteiYmd;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        TemnyuMode("TemnyuMode"),
        InputMode("InputMode"),
        TokushuTsuikaMode("TokushuTsuikaMode"),
        TokushuShuseiMode("TokushuShuseiMode"),
        TokushuShinseiTorikeshiMode("TokushuShinseiTorikeshiMode"),
        ShokaiMode("ShokaiMode"),
        NinteiMode("NinteiMode"),
        ShokkenTsuikaMode("ShokkenTsuikaMode"),
        ShokkenShuseiMode("ShokkenShuseiMode"),
        IchibuSoshitsuMode("IchibuSoshitsuMode"),
        KyakkaRirekiTsuikaMode("KyakkaRirekiTsuikaMode"),
        ShinseiTorikeshiRirekiMode("ShinseiTorikeshiRirekiMode"),
        KyakkaTorikeshiRirekiShusei("KyakkaTorikeshiRirekiShusei");

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

    public void setMode_ShoriType(ShoriType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriType.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadNinteiKubun() {
        return this.getNinteiJoho().getRadNinteiKubun();
    }

    @JsonIgnore
    public void setRadNinteiKubun(RadioButton radNinteiKubun) {
        this.getNinteiJoho().setRadNinteiKubun(radNinteiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiKoshinNintei() {
        return this.getNinteiJoho().getChkMinashiKoshinNintei();
    }

    @JsonIgnore
    public void setChkMinashiKoshinNintei(CheckBoxList chkMinashiKoshinNintei) {
        this.getNinteiJoho().setChkMinashiKoshinNintei(chkMinashiKoshinNintei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return this.getNinteiJoho().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
        this.getNinteiJoho().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtYokaigodoCode() {
        return this.getNinteiJoho().getTxtYokaigodoCode();
    }

    @JsonIgnore
    public void setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.getNinteiJoho().setTxtYokaigodoCode(txtYokaigodoCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnYokaigodoGuide() {
        return this.getNinteiJoho().getBtnYokaigodoGuide();
    }

    @JsonIgnore
    public void setBtnYokaigodoGuide(ButtonDialog btnYokaigodoGuide) {
        this.getNinteiJoho().setBtnYokaigodoGuide(btnYokaigodoGuide);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoName() {
        return this.getNinteiJoho().getTxtYokaigodoName();
    }

    @JsonIgnore
    public void setTxtYokaigodoName(TextBox txtYokaigodoName) {
        this.getNinteiJoho().setTxtYokaigodoName(txtYokaigodoName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishiYMD() {
        return this.getNinteiJoho().getTxtYukoKaishiYMD();
    }

    @JsonIgnore
    public void setTxtYukoKaishiYMD(TextBoxFlexibleDate txtYukoKaishiYMD) {
        this.getNinteiJoho().setTxtYukoKaishiYMD(txtYukoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryoYMD() {
        return this.getNinteiJoho().getTxtYukoShuryoYMD();
    }

    @JsonIgnore
    public void setTxtYukoShuryoYMD(TextBoxFlexibleDate txtYukoShuryoYMD) {
        this.getNinteiJoho().setTxtYukoShuryoYMD(txtYukoShuryoYMD);
    }

    @JsonIgnore
    public Button getBtnAfter6Month() {
        return this.getNinteiJoho().getBtnAfter6Month();
    }

    @JsonIgnore
    public void setBtnAfter6Month(Button btnAfter6Month) {
        this.getNinteiJoho().setBtnAfter6Month(btnAfter6Month);
    }

    @JsonIgnore
    public Button getBtnAfter12Month() {
        return this.getNinteiJoho().getBtnAfter12Month();
    }

    @JsonIgnore
    public void setBtnAfter12Month(Button btnAfter12Month) {
        this.getNinteiJoho().setBtnAfter12Month(btnAfter12Month);
    }

    @JsonIgnore
    public Button getBtnAfter18Month() {
        return this.getNinteiJoho().getBtnAfter18Month();
    }

    @JsonIgnore
    public void setBtnAfter18Month(Button btnAfter18Month) {
        this.getNinteiJoho().setBtnAfter18Month(btnAfter18Month);
    }

    @JsonIgnore
    public Button getBtnAfter24Month() {
        return this.getNinteiJoho().getBtnAfter24Month();
    }

    @JsonIgnore
    public void setBtnAfter24Month(Button btnAfter24Month) {
        this.getNinteiJoho().setBtnAfter24Month(btnAfter24Month);
    }

    @JsonIgnore
    public DataGrid<dgServiceIchiran_Row> getDgServiceIchiran() {
        return this.getServiceShitei().getDgServiceIchiran();
    }

    @JsonIgnore
    public void setDgServiceIchiran(DataGrid<dgServiceIchiran_Row> dgServiceIchiran) {
        this.getServiceShitei().setDgServiceIchiran(dgServiceIchiran);
    }

    @JsonIgnore
    public Label getLblServiceIken() {
        return this.getServiceShitei().getLblServiceIken();
    }

    @JsonIgnore
    public void setLblServiceIken(Label lblServiceIken) {
        this.getServiceShitei().setLblServiceIken(lblServiceIken);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 共通子DIVの初期化処理です。
     *
     * @param model NinteiInputDataPassModel
     */
    @Override
    public void initialize(NinteiInputDataPassModel model) {
        new NinteiInputHandler(this).initialize(model);
    }

    /**
     * 状態の設定すます。
     *
     * @param mode mode
     */
    @Override
    public void set状態(RString mode) {
        setMode_ShoriType(ShoriType.getEnum(mode.toString()));
    }

    /**
     * 開始終了日前後順checkです。
     *
     * @return ValidationMessageControlPairs
     */
    @Override
    public ValidationMessageControlPairs 開始終了日前後順check() {
        return new NinteiInputValidationHandler(this).開始終了日前後順check();
    }

    /**
     * 画面一覧内容を取得。
     *
     * @return NinteiInputNaiyo
     */
    @Override
    public NinteiInputNaiyo getNaiyo() {
        return new NinteiInputHandler(this).getNaiyo();
    }

    /**
     * Service一覧内容を取得。
     *
     * @return dgServiceIchiran_Row
     */
    @Override
    public List<dgServiceIchiran_Row> getServiceRow() {
        return new NinteiInputHandler(this).getServiceRow();
    }
}
