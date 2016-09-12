package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HikazeiNenkinKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HikazeiNenkinKensakuDiv extends Panel implements IHikazeiNenkinKensakuDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshano")
    private TextBox txtHihokenshano;
    @JsonProperty("txtTaishom")
    private TextBox txtTaishom;
    @JsonProperty("dgHikazeNenkinKensaku")
    private DataGrid<dgHikazeNenkinKensaku_Row> dgHikazeNenkinKensaku;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("key_HousholdBusiness")
    private RString key_HousholdBusiness;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("nendo")
    private RString nendo;
    @JsonProperty("lastInputHousehold")
    private RString lastInputHousehold;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshano
     * @return txtHihokenshano
     */
    @JsonProperty("txtHihokenshano")
    public TextBox getTxtHihokenshano() {
        return txtHihokenshano;
    }

    /*
     * settxtHihokenshano
     * @param txtHihokenshano txtHihokenshano
     */
    @JsonProperty("txtHihokenshano")
    public void setTxtHihokenshano(TextBox txtHihokenshano) {
        this.txtHihokenshano = txtHihokenshano;
    }

    /*
     * gettxtTaishom
     * @return txtTaishom
     */
    @JsonProperty("txtTaishom")
    public TextBox getTxtTaishom() {
        return txtTaishom;
    }

    /*
     * settxtTaishom
     * @param txtTaishom txtTaishom
     */
    @JsonProperty("txtTaishom")
    public void setTxtTaishom(TextBox txtTaishom) {
        this.txtTaishom = txtTaishom;
    }

    /*
     * getdgHikazeNenkinKensaku
     * @return dgHikazeNenkinKensaku
     */
    @JsonProperty("dgHikazeNenkinKensaku")
    public DataGrid<dgHikazeNenkinKensaku_Row> getDgHikazeNenkinKensaku() {
        return dgHikazeNenkinKensaku;
    }

    /*
     * setdgHikazeNenkinKensaku
     * @param dgHikazeNenkinKensaku dgHikazeNenkinKensaku
     */
    @JsonProperty("dgHikazeNenkinKensaku")
    public void setDgHikazeNenkinKensaku(DataGrid<dgHikazeNenkinKensaku_Row> dgHikazeNenkinKensaku) {
        this.dgHikazeNenkinKensaku = dgHikazeNenkinKensaku;
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
     * getkey_HousholdBusiness
     * @return key_HousholdBusiness
     */
    @JsonProperty("key_HousholdBusiness")
    public RString getKey_HousholdBusiness() {
        return key_HousholdBusiness;
    }

    /*
     * setkey_HousholdBusiness
     * @param key_HousholdBusiness key_HousholdBusiness
     */
    @JsonProperty("key_HousholdBusiness")
    public void setKey_HousholdBusiness(RString key_HousholdBusiness) {
        this.key_HousholdBusiness = key_HousholdBusiness;
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

    /*
     * getnendo
     * @return nendo
     */
    @JsonProperty("nendo")
    public RString getNendo() {
        return nendo;
    }

    /*
     * setnendo
     * @param nendo nendo
     */
    @JsonProperty("nendo")
    public void setNendo(RString nendo) {
        this.nendo = nendo;
    }

    /*
     * getlastInputHousehold
     * @return lastInputHousehold
     */
    @JsonProperty("lastInputHousehold")
    public RString getLastInputHousehold() {
        return lastInputHousehold;
    }

    /*
     * setlastInputHousehold
     * @param lastInputHousehold lastInputHousehold
     */
    @JsonProperty("lastInputHousehold")
    public void setLastInputHousehold(RString lastInputHousehold) {
        this.lastInputHousehold = lastInputHousehold;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
