package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoUploadPanel.KaigoUploadPanel;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * アップロードダイアログのハンドラークラスです。
 *
 * @reamsid_L DBZ-4530-010 houtianpeng
 */
public class KaigoUploadPanelDiv extends Panel implements IKaigoUploadPanelDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplUploadFile1")
    private UploadPanel uplUploadFile1;
    @JsonProperty("uplUploadFile")
    private UploadPanel uplUploadFile;
    @JsonProperty("lblFileName")
    private Label lblFileName;
    @JsonProperty("lblUploadFileName")
    private Label lblUploadFileName;
    @JsonProperty("btnUpload1")
    private Button btnUpload1;
    @JsonProperty("btnUpload")
    private Button btnUpload;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("ファイル名称")
    private RString ファイル名称;
    @JsonProperty("出力先フォルダ")
    private RString 出力先フォルダ;
    @JsonProperty("処理モード")
    private RString 処理モード;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplUploadFile1
     * @return uplUploadFile1
     */
    @JsonProperty("uplUploadFile1")
    public UploadPanel getUplUploadFile1() {
        return uplUploadFile1;
    }

    /*
     * setuplUploadFile1
     * @param uplUploadFile1 uplUploadFile1
     */
    @JsonProperty("uplUploadFile1")
    public void setUplUploadFile1(UploadPanel uplUploadFile1) {
        this.uplUploadFile1 = uplUploadFile1;
    }

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
     * getbtnUpload1
     * @return btnUpload1
     */
    @JsonProperty("btnUpload1")
    public Button getBtnUpload1() {
        return btnUpload1;
    }

    /*
     * setbtnUpload1
     * @param btnUpload1 btnUpload1
     */
    @JsonProperty("btnUpload1")
    public void setBtnUpload1(Button btnUpload1) {
        this.btnUpload1 = btnUpload1;
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
     * getファイル名称
     * @return ファイル名称
     */
    @JsonProperty("ファイル名称")
    public RString getファイル名称() {
        return ファイル名称;
    }

    /*
     * setファイル名称
     * @param ファイル名称 ファイル名称
     */
    @JsonProperty("ファイル名称")
    public void setファイル名称(RString ファイル名称) {
        this.ファイル名称 = ファイル名称;
    }

    /*
     * get出力先フォルダ
     * @return 出力先フォルダ
     */
    @JsonProperty("出力先フォルダ")
    public RString get出力先フォルダ() {
        return 出力先フォルダ;
    }

    /*
     * set出力先フォルダ
     * @param 出力先フォルダ 出力先フォルダ
     */
    @JsonProperty("出力先フォルダ")
    public void set出力先フォルダ(RString 出力先フォルダ) {
        this.出力先フォルダ = 出力先フォルダ;
    }

    /*
     * get処理モード
     * @return 処理モード
     */
    @JsonProperty("処理モード")
    public RString get処理モード() {
        return 処理モード;
    }

    /*
     * set処理モード
     * @param 処理モード 処理モード
     */
    @JsonProperty("処理モード")
    public void set処理モード(RString 処理モード) {
        this.処理モード = 処理モード;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum IsSimpleMode implements ICommonChildDivMode {

        TRUE("TRUE"),
        FALSE("FALSE");

        private final String name;

        private IsSimpleMode(final String name) {
            this.name = name;
        }

        public static IsSimpleMode getEnum(String str) {
            IsSimpleMode[] enumArray = IsSimpleMode.values();

            for (IsSimpleMode enumStr : enumArray) {
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

    public IsSimpleMode getMode_IsSimpleMode() {
        return (IsSimpleMode) _CommonChildDivModeUtil.getMode(this.modes, IsSimpleMode.class);
    }

    public void setMode_IsSimpleMode(IsSimpleMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, IsSimpleMode.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private KaigoUploadHandler getHandler() {
        return new KaigoUploadHandler(this);
    }

    /**
     * 初期化。
     *
     * @param 処理モード 処理モード
     */
    @Override
    public void initialize(RString 処理モード) {

        getHandler().initialize(処理モード);
    }

    /**
     * ファイル名称を設定します。
     *
     * @param ファイル名称
     */
    @Override
    public void setFileName(RString ファイル名称) {

        getHandler().setファイル名称(ファイル名称);
    }

    /**
     * 出力先フォルダを設定します。
     *
     * @param 出力先フォルダ
     */
    @Override
    public void setフォルダ(RString 出力先フォルダ) {

        getHandler().set出力先フォルダ(出力先フォルダ);
    }

    /**
     * 「閉じる」ボタン。
     *
     */
    @Override
    public void setToJiRu() {
        getHandler().toJiRu();
    }
}
