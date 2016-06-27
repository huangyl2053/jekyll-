package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KekkaShosaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KekkaShosaiJohoDiv extends Panel implements IKekkaShosaiJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdNinteiInput")
    private NinteiInputDiv ccdNinteiInput;
    @JsonProperty("ccdShinseiSonotaJohoInput")
    private ShinseiSonotaJohoInputDiv ccdShinseiSonotaJohoInput;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("txtShinseiKubunShinsei")
    private TextBox txtShinseiKubunShinsei;
    @JsonProperty("txtShinseiKubunLaw")
    private TextBox txtShinseiKubunLaw;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("hdnKekkaShosaiJohoModel")
    private RString hdnKekkaShosaiJohoModel;
    @JsonProperty("hdnKekkaShosaiJohoOutModel")
    private RString hdnKekkaShosaiJohoOutModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdNinteiInput
     * @return ccdNinteiInput
     */
    @JsonProperty("ccdNinteiInput")
    public INinteiInputDiv getCcdNinteiInput() {
        return ccdNinteiInput;
    }

    /*
     * getccdShinseiSonotaJohoInput
     * @return ccdShinseiSonotaJohoInput
     */
    @JsonProperty("ccdShinseiSonotaJohoInput")
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return ccdShinseiSonotaJohoInput;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * gettxtShinseiKubunShinsei
     * @return txtShinseiKubunShinsei
     */
    @JsonProperty("txtShinseiKubunShinsei")
    public TextBox getTxtShinseiKubunShinsei() {
        return txtShinseiKubunShinsei;
    }

    /*
     * settxtShinseiKubunShinsei
     * @param txtShinseiKubunShinsei txtShinseiKubunShinsei
     */
    @JsonProperty("txtShinseiKubunShinsei")
    public void setTxtShinseiKubunShinsei(TextBox txtShinseiKubunShinsei) {
        this.txtShinseiKubunShinsei = txtShinseiKubunShinsei;
    }

    /*
     * gettxtShinseiKubunLaw
     * @return txtShinseiKubunLaw
     */
    @JsonProperty("txtShinseiKubunLaw")
    public TextBox getTxtShinseiKubunLaw() {
        return txtShinseiKubunLaw;
    }

    /*
     * settxtShinseiKubunLaw
     * @param txtShinseiKubunLaw txtShinseiKubunLaw
     */
    @JsonProperty("txtShinseiKubunLaw")
    public void setTxtShinseiKubunLaw(TextBox txtShinseiKubunLaw) {
        this.txtShinseiKubunLaw = txtShinseiKubunLaw;
    }

    /*
     * getbtnToroku
     * @return btnToroku
     */
    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    /*
     * setbtnToroku
     * @param btnToroku btnToroku
     */
    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku = btnToroku;
    }

    /*
     * gethdnKekkaShosaiJohoModel
     * @return hdnKekkaShosaiJohoModel
     */
    @JsonProperty("hdnKekkaShosaiJohoModel")
    public RString getHdnKekkaShosaiJohoModel() {
        return hdnKekkaShosaiJohoModel;
    }

    /*
     * sethdnKekkaShosaiJohoModel
     * @param hdnKekkaShosaiJohoModel hdnKekkaShosaiJohoModel
     */
    @JsonProperty("hdnKekkaShosaiJohoModel")
    public void setHdnKekkaShosaiJohoModel(RString hdnKekkaShosaiJohoModel) {
        this.hdnKekkaShosaiJohoModel = hdnKekkaShosaiJohoModel;
    }

    /*
     * gethdnKekkaShosaiJohoOutModel
     * @return hdnKekkaShosaiJohoOutModel
     */
    @JsonProperty("hdnKekkaShosaiJohoOutModel")
    public RString getHdnKekkaShosaiJohoOutModel() {
        return hdnKekkaShosaiJohoOutModel;
    }

    /*
     * sethdnKekkaShosaiJohoOutModel
     * @param hdnKekkaShosaiJohoOutModel hdnKekkaShosaiJohoOutModel
     */
    @JsonProperty("hdnKekkaShosaiJohoOutModel")
    public void setHdnKekkaShosaiJohoOutModel(RString hdnKekkaShosaiJohoOutModel) {
        this.hdnKekkaShosaiJohoOutModel = hdnKekkaShosaiJohoOutModel;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        SoshitsuMode("SoshitsuMode"),
        ShokkenTorikeshiInputMode("ShokkenTorikeshiInputMode"),
        ShokaiMode("ShokaiMode"),
        InputMode("InputMode");

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
