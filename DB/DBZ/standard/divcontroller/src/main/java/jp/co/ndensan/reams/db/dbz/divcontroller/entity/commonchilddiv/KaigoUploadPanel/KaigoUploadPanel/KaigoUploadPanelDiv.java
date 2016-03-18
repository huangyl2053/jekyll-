package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoUploadPanel.KaigoUploadPanel;
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

/**
 * KaigoUploadPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoUploadPanelDiv extends Panel implements IKaigoUploadPanelDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplUploadFile")
    private UploadPanel uplUploadFile;
    @JsonProperty("lblFileName")
    private Label lblFileName;
    @JsonProperty("lblUploadFileName")
    private Label lblUploadFileName;
    @JsonProperty("btnUpload")
    private Button btnUpload;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hdnIsSimpleMode")
    private RString hdnIsSimpleMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplUploadFile
     * @return uplUploadFile
     */
    @JsonProperty("uplUploadFile")
    public UploadPanel getUplUploadFile() {
        return uplUploadFile;
    }

    /*
     * setuplUploadFile
     * @param uplUploadFile uplUploadFile
     */
    @JsonProperty("uplUploadFile")
    public void setUplUploadFile(UploadPanel uplUploadFile) {
        this.uplUploadFile = uplUploadFile;
    }

    /*
     * getlblFileName
     * @return lblFileName
     */
    @JsonProperty("lblFileName")
    public Label getLblFileName() {
        return lblFileName;
    }

    /*
     * setlblFileName
     * @param lblFileName lblFileName
     */
    @JsonProperty("lblFileName")
    public void setLblFileName(Label lblFileName) {
        this.lblFileName = lblFileName;
    }

    /*
     * getlblUploadFileName
     * @return lblUploadFileName
     */
    @JsonProperty("lblUploadFileName")
    public Label getLblUploadFileName() {
        return lblUploadFileName;
    }

    /*
     * setlblUploadFileName
     * @param lblUploadFileName lblUploadFileName
     */
    @JsonProperty("lblUploadFileName")
    public void setLblUploadFileName(Label lblUploadFileName) {
        this.lblUploadFileName = lblUploadFileName;
    }

    /*
     * getbtnUpload
     * @return btnUpload
     */
    @JsonProperty("btnUpload")
    public Button getBtnUpload() {
        return btnUpload;
    }

    /*
     * setbtnUpload
     * @param btnUpload btnUpload
     */
    @JsonProperty("btnUpload")
    public void setBtnUpload(Button btnUpload) {
        this.btnUpload = btnUpload;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gethdnIsSimpleMode
     * @return hdnIsSimpleMode
     */
    @JsonProperty("hdnIsSimpleMode")
    public RString getHdnIsSimpleMode() {
        return hdnIsSimpleMode;
    }

    /*
     * sethdnIsSimpleMode
     * @param hdnIsSimpleMode hdnIsSimpleMode
     */
    @JsonProperty("hdnIsSimpleMode")
    public void setHdnIsSimpleMode(RString hdnIsSimpleMode) {
        this.hdnIsSimpleMode = hdnIsSimpleMode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum isSimpleMode implements ICommonChildDivMode {

        TRUE("TRUE"),
        FALSE("FALSE");

        private final String name;

        private isSimpleMode(final String name) {
            this.name = name;
        }

        public static isSimpleMode getEnum(String str) {
            isSimpleMode[] enumArray = isSimpleMode.values();

            for (isSimpleMode enumStr : enumArray) {
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

    public isSimpleMode getMode_isSimpleMode() {
        return (isSimpleMode) _CommonChildDivModeUtil.getMode( this.modes, isSimpleMode.class );
    }

    public void setMode_isSimpleMode( isSimpleMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, isSimpleMode.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
