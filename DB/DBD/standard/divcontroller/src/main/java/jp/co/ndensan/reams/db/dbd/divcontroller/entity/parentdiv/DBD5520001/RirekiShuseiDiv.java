package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RirekiShusei のクラスファイル
 *
 * @author 自動生成
 */
public class RirekiShuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnBeforeRirekiTsuika")
    private ButtonDialog btnBeforeRirekiTsuika;
    @JsonProperty("btnAfterRirekiTsuika")
    private ButtonDialog btnAfterRirekiTsuika;
    @JsonProperty("dgRirekiIchiran")
    private DataGrid<dgRirekiIchiran_Row> dgRirekiIchiran;
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoNinteiShikakuInfo;
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;
    @JsonProperty("hdnReceiveSerializeBusiness")
    private RString hdnReceiveSerializeBusiness;
    @JsonProperty("hdnDeleteKey")
    private RString hdnDeleteKey;
    @JsonProperty("hdnZenkaiSerializeBusiness")
    private RString hdnZenkaiSerializeBusiness;
    @JsonProperty("hdnJikaiSerializeBusiness")
    private RString hdnJikaiSerializeBusiness;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnBeforeRirekiTsuika
     * @return btnBeforeRirekiTsuika
     */
    @JsonProperty("btnBeforeRirekiTsuika")
    public ButtonDialog getBtnBeforeRirekiTsuika() {
        return btnBeforeRirekiTsuika;
    }

    /*
     * setbtnBeforeRirekiTsuika
     * @param btnBeforeRirekiTsuika btnBeforeRirekiTsuika
     */
    @JsonProperty("btnBeforeRirekiTsuika")
    public void setBtnBeforeRirekiTsuika(ButtonDialog btnBeforeRirekiTsuika) {
        this.btnBeforeRirekiTsuika = btnBeforeRirekiTsuika;
    }

    /*
     * getbtnAfterRirekiTsuika
     * @return btnAfterRirekiTsuika
     */
    @JsonProperty("btnAfterRirekiTsuika")
    public ButtonDialog getBtnAfterRirekiTsuika() {
        return btnAfterRirekiTsuika;
    }

    /*
     * setbtnAfterRirekiTsuika
     * @param btnAfterRirekiTsuika btnAfterRirekiTsuika
     */
    @JsonProperty("btnAfterRirekiTsuika")
    public void setBtnAfterRirekiTsuika(ButtonDialog btnAfterRirekiTsuika) {
        this.btnAfterRirekiTsuika = btnAfterRirekiTsuika;
    }

    /*
     * getdgRirekiIchiran
     * @return dgRirekiIchiran
     */
    @JsonProperty("dgRirekiIchiran")
    public DataGrid<dgRirekiIchiran_Row> getDgRirekiIchiran() {
        return dgRirekiIchiran;
    }

    /*
     * setdgRirekiIchiran
     * @param dgRirekiIchiran dgRirekiIchiran
     */
    @JsonProperty("dgRirekiIchiran")
    public void setDgRirekiIchiran(DataGrid<dgRirekiIchiran_Row> dgRirekiIchiran) {
        this.dgRirekiIchiran = dgRirekiIchiran;
    }

    /*
     * getccdKaigoNinteiShikakuInfo
     * @return ccdKaigoNinteiShikakuInfo
     */
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdKaigoNinteiShikakuInfo() {
        return ccdKaigoNinteiShikakuInfo;
    }

    /*
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    /*
     * gethdnSubGyomuCode
     * @return hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    /*
     * sethdnSubGyomuCode
     * @param hdnSubGyomuCode hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode = hdnSubGyomuCode;
    }

    /*
     * gethdnReceiveSerializeBusiness
     * @return hdnReceiveSerializeBusiness
     */
    @JsonProperty("hdnReceiveSerializeBusiness")
    public RString getHdnReceiveSerializeBusiness() {
        return hdnReceiveSerializeBusiness;
    }

    /*
     * sethdnReceiveSerializeBusiness
     * @param hdnReceiveSerializeBusiness hdnReceiveSerializeBusiness
     */
    @JsonProperty("hdnReceiveSerializeBusiness")
    public void setHdnReceiveSerializeBusiness(RString hdnReceiveSerializeBusiness) {
        this.hdnReceiveSerializeBusiness = hdnReceiveSerializeBusiness;
    }

    /*
     * gethdnDeleteKey
     * @return hdnDeleteKey
     */
    @JsonProperty("hdnDeleteKey")
    public RString getHdnDeleteKey() {
        return hdnDeleteKey;
    }

    /*
     * sethdnDeleteKey
     * @param hdnDeleteKey hdnDeleteKey
     */
    @JsonProperty("hdnDeleteKey")
    public void setHdnDeleteKey(RString hdnDeleteKey) {
        this.hdnDeleteKey = hdnDeleteKey;
    }

    /*
     * gethdnZenkaiSerializeBusiness
     * @return hdnZenkaiSerializeBusiness
     */
    @JsonProperty("hdnZenkaiSerializeBusiness")
    public RString getHdnZenkaiSerializeBusiness() {
        return hdnZenkaiSerializeBusiness;
    }

    /*
     * sethdnZenkaiSerializeBusiness
     * @param hdnZenkaiSerializeBusiness hdnZenkaiSerializeBusiness
     */
    @JsonProperty("hdnZenkaiSerializeBusiness")
    public void setHdnZenkaiSerializeBusiness(RString hdnZenkaiSerializeBusiness) {
        this.hdnZenkaiSerializeBusiness = hdnZenkaiSerializeBusiness;
    }

    /*
     * gethdnJikaiSerializeBusiness
     * @return hdnJikaiSerializeBusiness
     */
    @JsonProperty("hdnJikaiSerializeBusiness")
    public RString getHdnJikaiSerializeBusiness() {
        return hdnJikaiSerializeBusiness;
    }

    /*
     * sethdnJikaiSerializeBusiness
     * @param hdnJikaiSerializeBusiness hdnJikaiSerializeBusiness
     */
    @JsonProperty("hdnJikaiSerializeBusiness")
    public void setHdnJikaiSerializeBusiness(RString hdnJikaiSerializeBusiness) {
        this.hdnJikaiSerializeBusiness = hdnJikaiSerializeBusiness;
    }

    // </editor-fold>
}
