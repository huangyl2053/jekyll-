package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KanryoDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class KanryoDialogDiv extends Panel implements IKanryoDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SuccessInfo")
    private SuccessInfoDiv SuccessInfo;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hdnKanryoMsg")
    private RString hdnKanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSuccessInfo
     * @return SuccessInfo
     */
    @JsonProperty("SuccessInfo")
    public SuccessInfoDiv getSuccessInfo() {
        return SuccessInfo;
    }

    /*
     * setSuccessInfo
     * @param SuccessInfo SuccessInfo
     */
    @JsonProperty("SuccessInfo")
    public void setSuccessInfo(SuccessInfoDiv SuccessInfo) {
        this.SuccessInfo = SuccessInfo;
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
     * gethdnKanryoMsg
     * @return hdnKanryoMsg
     */
    @JsonProperty("hdnKanryoMsg")
    public RString getHdnKanryoMsg() {
        return hdnKanryoMsg;
    }

    /*
     * sethdnKanryoMsg
     * @param hdnKanryoMsg hdnKanryoMsg
     */
    @JsonProperty("hdnKanryoMsg")
    public void setHdnKanryoMsg(RString hdnKanryoMsg) {
        this.hdnKanryoMsg = hdnKanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public StaticImage getImgSuccess() {
        return this.getSuccessInfo().getImgSuccess();
    }

    @JsonIgnore
    public void  setImgSuccess(StaticImage imgSuccess) {
        this.getSuccessInfo().setImgSuccess(imgSuccess);
    }

    @JsonIgnore
    public WrapMessageMainDiv getWrapMessageMain() {
        return this.getSuccessInfo().getWrapMessageMain();
    }

    @JsonIgnore
    public void  setWrapMessageMain(WrapMessageMainDiv WrapMessageMain) {
        this.getSuccessInfo().setWrapMessageMain(WrapMessageMain);
    }

    @JsonIgnore
    public Label getLblMessageMain() {
        return this.getSuccessInfo().getWrapMessageMain().getLblMessageMain();
    }

    @JsonIgnore
    public void  setLblMessageMain(Label lblMessageMain) {
        this.getSuccessInfo().getWrapMessageMain().setLblMessageMain(lblMessageMain);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
