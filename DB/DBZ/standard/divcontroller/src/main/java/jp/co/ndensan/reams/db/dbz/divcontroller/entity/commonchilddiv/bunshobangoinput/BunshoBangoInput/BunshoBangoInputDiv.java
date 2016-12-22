package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.bunshobangoinput.BunshoBangoInputHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * BunshoBangoInput のクラスファイル
 *
 * @author 自動生成
 */
public class BunshoBangoInputDiv extends Panel implements IBunshoBangoInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBunshoKigo")
    private TextBox txtBunshoKigo;
    @JsonProperty("txtBunshoHeader")
    private TextBox txtBunshoHeader;
    @JsonProperty("txtBunshoNo")
    private TextBoxCode txtBunshoNo;
    @JsonProperty("txtBunshoFooter")
    private TextBox txtBunshoFooter;
    @JsonProperty("btnGetBunshoNo")
    private Button btnGetBunshoNo;
    @JsonProperty("hdnPadSpaceFlag")
    private RString hdnPadSpaceFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtBunshoKigo
     * @return txtBunshoKigo
     */
    @JsonProperty("txtBunshoKigo")
    public TextBox getTxtBunshoKigo() {
        return txtBunshoKigo;
    }

    /*
     * settxtBunshoKigo
     * @param txtBunshoKigo txtBunshoKigo
     */
    @JsonProperty("txtBunshoKigo")
    public void setTxtBunshoKigo(TextBox txtBunshoKigo) {
        this.txtBunshoKigo = txtBunshoKigo;
    }

    /*
     * gettxtBunshoHeader
     * @return txtBunshoHeader
     */
    @JsonProperty("txtBunshoHeader")
    public TextBox getTxtBunshoHeader() {
        return txtBunshoHeader;
    }

    /*
     * settxtBunshoHeader
     * @param txtBunshoHeader txtBunshoHeader
     */
    @JsonProperty("txtBunshoHeader")
    public void setTxtBunshoHeader(TextBox txtBunshoHeader) {
        this.txtBunshoHeader = txtBunshoHeader;
    }

    /*
     * gettxtBunshoNo
     * @return txtBunshoNo
     */
    @JsonProperty("txtBunshoNo")
    public TextBoxCode getTxtBunshoNo() {
        return txtBunshoNo;
    }

    /*
     * settxtBunshoNo
     * @param txtBunshoNo txtBunshoNo
     */
    @JsonProperty("txtBunshoNo")
    public void setTxtBunshoNo(TextBoxCode txtBunshoNo) {
        this.txtBunshoNo = txtBunshoNo;
    }

    /*
     * gettxtBunshoFooter
     * @return txtBunshoFooter
     */
    @JsonProperty("txtBunshoFooter")
    public TextBox getTxtBunshoFooter() {
        return txtBunshoFooter;
    }

    /*
     * settxtBunshoFooter
     * @param txtBunshoFooter txtBunshoFooter
     */
    @JsonProperty("txtBunshoFooter")
    public void setTxtBunshoFooter(TextBox txtBunshoFooter) {
        this.txtBunshoFooter = txtBunshoFooter;
    }

    /*
     * getbtnGetBunshoNo
     * @return btnGetBunshoNo
     */
    @JsonProperty("btnGetBunshoNo")
    public Button getBtnGetBunshoNo() {
        return btnGetBunshoNo;
    }

    /*
     * setbtnGetBunshoNo
     * @param btnGetBunshoNo btnGetBunshoNo
     */
    @JsonProperty("btnGetBunshoNo")
    public void setBtnGetBunshoNo(Button btnGetBunshoNo) {
        this.btnGetBunshoNo = btnGetBunshoNo;
    }

    /*
     * gethdnPadSpaceFlag
     * @return hdnPadSpaceFlag
     */
    @JsonProperty("hdnPadSpaceFlag")
    public RString getHdnPadSpaceFlag() {
        return hdnPadSpaceFlag;
    }

    /*
     * sethdnPadSpaceFlag
     * @param hdnPadSpaceFlag hdnPadSpaceFlag
     */
    @JsonProperty("hdnPadSpaceFlag")
    public void setHdnPadSpaceFlag(RString hdnPadSpaceFlag) {
        this.hdnPadSpaceFlag = hdnPadSpaceFlag;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayType implements ICommonChildDivMode {

        ShudoNyuryoku("ShudoNyuryoku"),
        JidoSaiban("JidoSaiban"),
        Kotei("Kotei");

        private final String name;

        private DisplayType(final String name) {
            this.name = name;
        }

        public static DisplayType getEnum(String str) {
            DisplayType[] enumArray = DisplayType.values();

            for (DisplayType enumStr : enumArray) {
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

    public DisplayType getMode_DisplayType() {
        return (DisplayType) _CommonChildDivModeUtil.getMode( this.modes, DisplayType.class );
    }

    public void setMode_DisplayType( DisplayType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(ReportId 帳票ID) {
        initialize(帳票ID, FlexibleDate.getNowDate());
    }

    @Override
    public void initialize(ReportId 帳票ID, FlexibleDate 基準日) {
        getHandler().initialize(帳票ID, 基準日);
    }

    @Override
    public RString get文書番号() {
        return getHandler().getEdit文書番号();
    }

    @JsonIgnore
    private BunshoBangoInputHandler getHandler() {
        return new BunshoBangoInputHandler(this);
    }

}
