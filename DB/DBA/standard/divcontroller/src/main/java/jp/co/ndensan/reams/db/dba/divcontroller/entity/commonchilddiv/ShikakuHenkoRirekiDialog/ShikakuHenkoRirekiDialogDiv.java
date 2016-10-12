package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.IShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikakuHenkoRirekiDialog のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuHenkoRirekiDialogDiv extends Panel implements IShikakuHenkoRirekiDialogDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdShikakuHenkoRireki")
    private ShikakuHenkoRirekiDiv ccdShikakuHenkoRireki;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("gridData")
    private RString gridData;
    @JsonProperty("hihoData")
    private RString hihoData;
    @JsonProperty("shutokuDate")
    private RString shutokuDate;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdShikakuHenkoRireki
     * @return ccdShikakuHenkoRireki
     */
    @JsonProperty("ccdShikakuHenkoRireki")
    public IShikakuHenkoRirekiDiv getCcdShikakuHenkoRireki() {
        return ccdShikakuHenkoRireki;
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
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * getgridData
     * @return gridData
     */
    @JsonProperty("gridData")
    public RString getGridData() {
        return gridData;
    }

    /*
     * setgridData
     * @param gridData gridData
     */
    @JsonProperty("gridData")
    public void setGridData(RString gridData) {
        this.gridData = gridData;
    }

    /*
     * gethihoData
     * @return hihoData
     */
    @JsonProperty("hihoData")
    public RString getHihoData() {
        return hihoData;
    }

    /*
     * sethihoData
     * @param hihoData hihoData
     */
    @JsonProperty("hihoData")
    public void setHihoData(RString hihoData) {
        this.hihoData = hihoData;
    }

    /*
     * getshutokuDate
     * @return shutokuDate
     */
    @JsonProperty("shutokuDate")
    public RString getShutokuDate() {
        return shutokuDate;
    }

    /*
     * setshutokuDate
     * @param shutokuDate shutokuDate
     */
    @JsonProperty("shutokuDate")
    public void setShutokuDate(RString shutokuDate) {
        this.shutokuDate = shutokuDate;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
