package jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput.INinteiInputDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * NinteiInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiInputDiv extends Panel implements INinteiInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteiJoho")
    public NinteiJohoDiv getNinteiJoho() {
        return NinteiJoho;
    }

    @JsonProperty("NinteiJoho")
    public void setNinteiJoho(NinteiJohoDiv NinteiJoho) {
        this.NinteiJoho=NinteiJoho;
    }

    @JsonProperty("ServiceShitei")
    public ServiceShiteiDiv getServiceShitei() {
        return ServiceShitei;
    }

    @JsonProperty("ServiceShitei")
    public void setServiceShitei(ServiceShiteiDiv ServiceShitei) {
        this.ServiceShitei=ServiceShitei;
    }

    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken=txtShinsakaiIken;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode=hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo=hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    public RString getHdnKoroshoIfShikibetsuCode() {
        return hdnKoroshoIfShikibetsuCode;
    }

    @JsonProperty("hdnKoroshoIfShikibetsuCode")
    public void setHdnKoroshoIfShikibetsuCode(RString hdnKoroshoIfShikibetsuCode) {
        this.hdnKoroshoIfShikibetsuCode=hdnKoroshoIfShikibetsuCode;
    }

    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo=hdnHihokenshaNo;
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
        ShokaiMode("ShokaiMode"),
        NinteiMode("NinteiMode"),
        ShokkenTsuikaMode("ShokkenTsuikaMode"),
        ShokkenShuseiMode("ShokkenShuseiMode"),
        IchibuSoshitsuMode("IchibuSoshitsuMode");

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
        return (ShoriType) _CommonChildDivModeUtil.getMode( this.modes, ShoriType.class );
    }

    public void setMode_ShoriType( ShoriType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShoriType.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadNinteiKubun() {
        return this.getNinteiJoho().getRadNinteiKubun();
    }

    @JsonIgnore
    public void  setRadNinteiKubun(RadioButton radNinteiKubun) {
        this.getNinteiJoho().setRadNinteiKubun(radNinteiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiKoshinNintei() {
        return this.getNinteiJoho().getChkMinashiKoshinNintei();
    }

    @JsonIgnore
    public void  setChkMinashiKoshinNintei(CheckBoxList chkMinashiKoshinNintei) {
        this.getNinteiJoho().setChkMinashiKoshinNintei(chkMinashiKoshinNintei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return this.getNinteiJoho().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
        this.getNinteiJoho().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtYokaigodoCode() {
        return this.getNinteiJoho().getTxtYokaigodoCode();
    }

    @JsonIgnore
    public void  setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.getNinteiJoho().setTxtYokaigodoCode(txtYokaigodoCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnYokaigodoGuide() {
        return this.getNinteiJoho().getBtnYokaigodoGuide();
    }

    @JsonIgnore
    public void  setBtnYokaigodoGuide(ButtonDialog btnYokaigodoGuide) {
        this.getNinteiJoho().setBtnYokaigodoGuide(btnYokaigodoGuide);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoName() {
        return this.getNinteiJoho().getTxtYokaigodoName();
    }

    @JsonIgnore
    public void  setTxtYokaigodoName(TextBox txtYokaigodoName) {
        this.getNinteiJoho().setTxtYokaigodoName(txtYokaigodoName);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishiYMD() {
        return this.getNinteiJoho().getTxtYukoKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKaishiYMD(TextBoxFlexibleDate txtYukoKaishiYMD) {
        this.getNinteiJoho().setTxtYukoKaishiYMD(txtYukoKaishiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryoYMD() {
        return this.getNinteiJoho().getTxtYukoShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtYukoShuryoYMD(TextBoxFlexibleDate txtYukoShuryoYMD) {
        this.getNinteiJoho().setTxtYukoShuryoYMD(txtYukoShuryoYMD);
    }

    @JsonIgnore
    public Button getBtnAfter6Month() {
        return this.getNinteiJoho().getBtnAfter6Month();
    }

    @JsonIgnore
    public void  setBtnAfter6Month(Button btnAfter6Month) {
        this.getNinteiJoho().setBtnAfter6Month(btnAfter6Month);
    }

    @JsonIgnore
    public Button getBtnAfter12Month() {
        return this.getNinteiJoho().getBtnAfter12Month();
    }

    @JsonIgnore
    public void  setBtnAfter12Month(Button btnAfter12Month) {
        this.getNinteiJoho().setBtnAfter12Month(btnAfter12Month);
    }

    @JsonIgnore
    public Button getBtnAfter18Month() {
        return this.getNinteiJoho().getBtnAfter18Month();
    }

    @JsonIgnore
    public void  setBtnAfter18Month(Button btnAfter18Month) {
        this.getNinteiJoho().setBtnAfter18Month(btnAfter18Month);
    }

    @JsonIgnore
    public Button getBtnAfter24Month() {
        return this.getNinteiJoho().getBtnAfter24Month();
    }

    @JsonIgnore
    public void  setBtnAfter24Month(Button btnAfter24Month) {
        this.getNinteiJoho().setBtnAfter24Month(btnAfter24Month);
    }

    @JsonIgnore
    public Label getLblServiceIken() {
        return this.getServiceShitei().getLblServiceIken();
    }

    @JsonIgnore
    public void  setLblServiceIken(Label lblServiceIken) {
        this.getServiceShitei().setLblServiceIken(lblServiceIken);
    }

    @JsonIgnore
    public DataGrid<dgServiceIchiran_Row> getDgServiceIchiran() {
        return this.getServiceShitei().getDgServiceIchiran();
    }

    @JsonIgnore
    public void  setDgServiceIchiran(DataGrid<dgServiceIchiran_Row> dgServiceIchiran) {
        this.getServiceShitei().setDgServiceIchiran(dgServiceIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public RString get審査会意見() {
        return txtShinsakaiIken.getValue();
    }

    @JsonIgnore
    @Override
    public FlexibleDate get認定年月日() {
        return getTxtNinteiYMD().getValue();
    }

    @JsonIgnore
    @Override
    public RString get要介護度コード() {
        return getTxtYokaigodoCode().getValue();
    }

    @JsonIgnore
    @Override
    public FlexibleDate get有効開始年月日() {
        return getTxtYukoKaishiYMD().getValue();
    }

    @JsonIgnore
    @Override
    public FlexibleDate get有効終了年月日() {
        return getTxtYukoShuryoYMD().getValue();
    }

    @JsonIgnore
    @Override
    public RString get認定区分() {
        return getRadNinteiKubun().getSelectedValue();
    }

    @JsonIgnore
    @Override
    public List<dgServiceIchiran_Row> getサービス一覧() {
        return getDgServiceIchiran().getSelectedItems();
    }

    @JsonIgnore
    @Override
    public List<KeyValueDataSource> getみなし更新申請() {
        return getChkMinashiKoshinNintei().getSelectedItems();
    }

    @JsonIgnore
    @Override
    public void set審査会意見(RString 審査会意見) {
        txtShinsakaiIken.setValue(審査会意見);
    }

    @JsonIgnore
    @Override
    public void set認定年月日(FlexibleDate 認定年月日) {
        getTxtNinteiYMD().setValue(認定年月日);
    }

    @JsonIgnore
    @Override
    public void set要介護度コード(RString 要介護度) {
        getTxtYokaigodoCode().setValue(要介護度);
    }

    @JsonIgnore
    @Override
    public void set有効開始年月日(FlexibleDate 有効開始年月日) {
        getTxtYukoKaishiYMD().setValue(有効開始年月日);
    }

    @JsonIgnore
    @Override
    public void set有効終了年月日(FlexibleDate 有効終了年月日) {
        getTxtYukoShuryoYMD().setValue(有効終了年月日);
    }

    @JsonIgnore
    @Override
    public void set認定区分(RString 認定区分) {
        getRadNinteiKubun().setSelectedValue(認定区分);
    }

    @JsonIgnore
    @Override
    public void setサービス一覧(List<dgServiceIchiran_Row> サービス一覧) {
        getDgServiceIchiran().setSelectedItems(サービス一覧);
    }

    @JsonIgnore
    @Override
    public void setみなし更新申請(List<KeyValueDataSource> みなし更新申請) {
        getChkMinashiKoshinNintei().setSelectedItems(みなし更新申請);
    }

    public void clear() {
        createHandler().clear();
    }

    public void intialize() {
        createHandler().intialize();
    }

    private NinteiInputHandler createHandler() {
        return new NinteiInputHandler(this);
    }

}
