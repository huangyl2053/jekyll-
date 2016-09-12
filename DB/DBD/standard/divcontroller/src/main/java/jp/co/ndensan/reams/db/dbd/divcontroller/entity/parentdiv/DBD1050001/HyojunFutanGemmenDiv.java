package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HyojunFutanGemmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class HyojunFutanGemmenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linTaishoshaInfo")
    private HorizontalLine linTaishoshaInfo;
    @JsonProperty("txtSetaiKazeiJokyo")
    private TextBox txtSetaiKazeiJokyo;
    @JsonProperty("btnOutputSetaiInfo")
    private ButtonDialog btnOutputSetaiInfo;
    @JsonProperty("btnOutputGenmenInfo")
    private ButtonDialog btnOutputGenmenInfo;
    @JsonProperty("ShinseiList")
    private ShinseiListDiv ShinseiList;
    @JsonProperty("ShinseiDetail")
    private ShinseiDetailDiv ShinseiDetail;
    @JsonProperty("ccdKaigoKihon")
    private KaigoShikakuKihonDiv ccdKaigoKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinTaishoshaInfo
     * @return linTaishoshaInfo
     */
    @JsonProperty("linTaishoshaInfo")
    public HorizontalLine getLinTaishoshaInfo() {
        return linTaishoshaInfo;
    }

    /*
     * setlinTaishoshaInfo
     * @param linTaishoshaInfo linTaishoshaInfo
     */
    @JsonProperty("linTaishoshaInfo")
    public void setLinTaishoshaInfo(HorizontalLine linTaishoshaInfo) {
        this.linTaishoshaInfo = linTaishoshaInfo;
    }

    /*
     * gettxtSetaiKazeiJokyo
     * @return txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public TextBox getTxtSetaiKazeiJokyo() {
        return txtSetaiKazeiJokyo;
    }

    /*
     * settxtSetaiKazeiJokyo
     * @param txtSetaiKazeiJokyo txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public void setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.txtSetaiKazeiJokyo = txtSetaiKazeiJokyo;
    }

    /*
     * getbtnOutputSetaiInfo
     * @return btnOutputSetaiInfo
     */
    @JsonProperty("btnOutputSetaiInfo")
    public ButtonDialog getBtnOutputSetaiInfo() {
        return btnOutputSetaiInfo;
    }

    /*
     * setbtnOutputSetaiInfo
     * @param btnOutputSetaiInfo btnOutputSetaiInfo
     */
    @JsonProperty("btnOutputSetaiInfo")
    public void setBtnOutputSetaiInfo(ButtonDialog btnOutputSetaiInfo) {
        this.btnOutputSetaiInfo = btnOutputSetaiInfo;
    }

    /*
     * getbtnOutputGenmenInfo
     * @return btnOutputGenmenInfo
     */
    @JsonProperty("btnOutputGenmenInfo")
    public ButtonDialog getBtnOutputGenmenInfo() {
        return btnOutputGenmenInfo;
    }

    /*
     * setbtnOutputGenmenInfo
     * @param btnOutputGenmenInfo btnOutputGenmenInfo
     */
    @JsonProperty("btnOutputGenmenInfo")
    public void setBtnOutputGenmenInfo(ButtonDialog btnOutputGenmenInfo) {
        this.btnOutputGenmenInfo = btnOutputGenmenInfo;
    }

    /*
     * getShinseiList
     * @return ShinseiList
     */
    @JsonProperty("ShinseiList")
    public ShinseiListDiv getShinseiList() {
        return ShinseiList;
    }

    /*
     * setShinseiList
     * @param ShinseiList ShinseiList
     */
    @JsonProperty("ShinseiList")
    public void setShinseiList(ShinseiListDiv ShinseiList) {
        this.ShinseiList = ShinseiList;
    }

    /*
     * getShinseiDetail
     * @return ShinseiDetail
     */
    @JsonProperty("ShinseiDetail")
    public ShinseiDetailDiv getShinseiDetail() {
        return ShinseiDetail;
    }

    /*
     * setShinseiDetail
     * @param ShinseiDetail ShinseiDetail
     */
    @JsonProperty("ShinseiDetail")
    public void setShinseiDetail(ShinseiDetailDiv ShinseiDetail) {
        this.ShinseiDetail = ShinseiDetail;
    }

    /*
     * getccdKaigoKihon
     * @return ccdKaigoKihon
     */
    @JsonProperty("ccdKaigoKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return ccdKaigoKihon;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
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
}
