package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiImageShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiShiryoShokai.ChosaTokkiShiryoShokai.IChosaTokkiShiryoShokaiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaTokkiImageShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaTokkiImageShokaiDiv extends Panel implements IChosaTokkiImageShokaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChosaTokkiShiryoShokai")
    private ChosaTokkiShiryoShokaiDiv ccdChosaTokkiShiryoShokai;
    @JsonProperty("btnReturn")
    private Button btnReturn;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnNinteiChosaIraiRirekiNo")
    private RString hdnNinteiChosaIraiRirekiNo;
    @JsonProperty("hdnTokkiJikoNoList")
    private RString hdnTokkiJikoNoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdChosaTokkiShiryoShokai
     * @return ccdChosaTokkiShiryoShokai
     */
    @JsonProperty("ccdChosaTokkiShiryoShokai")
    public IChosaTokkiShiryoShokaiDiv getCcdChosaTokkiShiryoShokai() {
        return ccdChosaTokkiShiryoShokai;
    }

    /*
     * getbtnReturn
     * @return btnReturn
     */
    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    /*
     * setbtnReturn
     * @param btnReturn btnReturn
     */
    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
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
     * gethdnNinteiChosaIraiRirekiNo
     * @return hdnNinteiChosaIraiRirekiNo
     */
    @JsonProperty("hdnNinteiChosaIraiRirekiNo")
    public RString getHdnNinteiChosaIraiRirekiNo() {
        return hdnNinteiChosaIraiRirekiNo;
    }

    /*
     * sethdnNinteiChosaIraiRirekiNo
     * @param hdnNinteiChosaIraiRirekiNo hdnNinteiChosaIraiRirekiNo
     */
    @JsonProperty("hdnNinteiChosaIraiRirekiNo")
    public void setHdnNinteiChosaIraiRirekiNo(RString hdnNinteiChosaIraiRirekiNo) {
        this.hdnNinteiChosaIraiRirekiNo = hdnNinteiChosaIraiRirekiNo;
    }

    /*
     * gethdnTokkiJikoNoList
     * @return hdnTokkiJikoNoList
     */
    @JsonProperty("hdnTokkiJikoNoList")
    public RString getHdnTokkiJikoNoList() {
        return hdnTokkiJikoNoList;
    }

    /*
     * sethdnTokkiJikoNoList
     * @param hdnTokkiJikoNoList hdnTokkiJikoNoList
     */
    @JsonProperty("hdnTokkiJikoNoList")
    public void setHdnTokkiJikoNoList(RString hdnTokkiJikoNoList) {
        this.hdnTokkiJikoNoList = hdnTokkiJikoNoList;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
