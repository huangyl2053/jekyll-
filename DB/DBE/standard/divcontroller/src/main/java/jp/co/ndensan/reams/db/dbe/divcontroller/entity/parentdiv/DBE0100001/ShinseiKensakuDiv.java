package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.INinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-10_12-10-23">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("ShinseiJohoIchiran")
    private ShinseiJohoIchiranDiv ShinseiJohoIchiran;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hdnShinseiKensaku")
    private RString hdnShinseiKensaku;
    @JsonProperty("wfParameter")
    private RString wfParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getShinseiJohoIchiran
     * @return ShinseiJohoIchiran
     */
    @JsonProperty("ShinseiJohoIchiran")
    public ShinseiJohoIchiranDiv getShinseiJohoIchiran() {
        return ShinseiJohoIchiran;
    }

    /*
     * setShinseiJohoIchiran
     * @param ShinseiJohoIchiran ShinseiJohoIchiran
     */
    @JsonProperty("ShinseiJohoIchiran")
    public void setShinseiJohoIchiran(ShinseiJohoIchiranDiv ShinseiJohoIchiran) {
        this.ShinseiJohoIchiran = ShinseiJohoIchiran;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * gethdnShinseiKensaku
     * @return hdnShinseiKensaku
     */
    @JsonProperty("hdnShinseiKensaku")
    public RString getHdnShinseiKensaku() {
        return hdnShinseiKensaku;
    }

    /*
     * sethdnShinseiKensaku
     * @param hdnShinseiKensaku hdnShinseiKensaku
     */
    @JsonProperty("hdnShinseiKensaku")
    public void setHdnShinseiKensaku(RString hdnShinseiKensaku) {
        this.hdnShinseiKensaku = hdnShinseiKensaku;
    }

    /*
     * getwfParameter
     * @return wfParameter
     */
    @JsonProperty("wfParameter")
    public RString getWfParameter() {
        return wfParameter;
    }

    /*
     * setwfParameter
     * @param wfParameter wfParameter
     */
    @JsonProperty("wfParameter")
    public void setWfParameter(RString wfParameter) {
        this.wfParameter = wfParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KensakuOptionDiv getKensakuOption() {
        return this.getKensakuJoken().getKensakuOption();
    }

    @JsonIgnore
    public void  setKensakuOption(KensakuOptionDiv KensakuOption) {
        this.getKensakuJoken().setKensakuOption(KensakuOption);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getKensakuOption().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().getKensakuOption().setBtnClear(btnClear);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxDisp() {
        return this.getKensakuJoken().getKensakuOption().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBoxNum txtMaxDisp) {
        this.getKensakuJoken().getKensakuOption().setTxtMaxDisp(txtMaxDisp);
    }

    @JsonIgnore
    public INinteiShinseishaFinderDiv getCcdNinteishinseishaFinder() {
        return this.getKensakuJoken().getCcdNinteishinseishaFinder();
    }

    @JsonIgnore
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return this.getShinseiJohoIchiran().getDgShinseiJoho();
    }

    @JsonIgnore
    public void  setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.getShinseiJohoIchiran().setDgShinseiJoho(dgShinseiJoho);
    }

    @JsonIgnore
    public Button getBtnModoru() {
        return this.getShinseiJohoIchiran().getBtnModoru();
    }

    @JsonIgnore
    public void  setBtnModoru(Button btnModoru) {
        this.getShinseiJohoIchiran().setBtnModoru(btnModoru);
    }

    // </editor-fold>
}
