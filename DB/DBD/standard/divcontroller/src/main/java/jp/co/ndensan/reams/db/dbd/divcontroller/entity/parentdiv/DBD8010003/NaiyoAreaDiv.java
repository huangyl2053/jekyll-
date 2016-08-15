package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NaiyoArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class NaiyoAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tbNenKinHokenshaName")
    private TextBoxMultiLine tbNenKinHokenshaName;
    @JsonProperty("tbGenkisoNenkinNo")
    private TextBox tbGenkisoNenkinNo;
    @JsonProperty("tbTaishoNenKin")
    private TextBoxMultiLine tbTaishoNenKin;
    @JsonProperty("ddlTsuki")
    private DropDownList ddlTsuki;
    @JsonProperty("tbKingaku")
    private TextBoxNum tbKingaku;
    @JsonProperty("tbCreateDate")
    private TextBoxDate tbCreateDate;
    @JsonProperty("tbTaishoNen")
    private TextBox tbTaishoNen;
    @JsonProperty("tbLoadCata")
    private TextBox tbLoadCata;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettbNenKinHokenshaName
     * @return tbNenKinHokenshaName
     */
    @JsonProperty("tbNenKinHokenshaName")
    public TextBoxMultiLine getTbNenKinHokenshaName() {
        return tbNenKinHokenshaName;
    }

    /*
     * settbNenKinHokenshaName
     * @param tbNenKinHokenshaName tbNenKinHokenshaName
     */
    @JsonProperty("tbNenKinHokenshaName")
    public void setTbNenKinHokenshaName(TextBoxMultiLine tbNenKinHokenshaName) {
        this.tbNenKinHokenshaName = tbNenKinHokenshaName;
    }

    /*
     * gettbGenkisoNenkinNo
     * @return tbGenkisoNenkinNo
     */
    @JsonProperty("tbGenkisoNenkinNo")
    public TextBox getTbGenkisoNenkinNo() {
        return tbGenkisoNenkinNo;
    }

    /*
     * settbGenkisoNenkinNo
     * @param tbGenkisoNenkinNo tbGenkisoNenkinNo
     */
    @JsonProperty("tbGenkisoNenkinNo")
    public void setTbGenkisoNenkinNo(TextBox tbGenkisoNenkinNo) {
        this.tbGenkisoNenkinNo = tbGenkisoNenkinNo;
    }

    /*
     * gettbTaishoNenKin
     * @return tbTaishoNenKin
     */
    @JsonProperty("tbTaishoNenKin")
    public TextBoxMultiLine getTbTaishoNenKin() {
        return tbTaishoNenKin;
    }

    /*
     * settbTaishoNenKin
     * @param tbTaishoNenKin tbTaishoNenKin
     */
    @JsonProperty("tbTaishoNenKin")
    public void setTbTaishoNenKin(TextBoxMultiLine tbTaishoNenKin) {
        this.tbTaishoNenKin = tbTaishoNenKin;
    }

    /*
     * getddlTsuki
     * @return ddlTsuki
     */
    @JsonProperty("ddlTsuki")
    public DropDownList getDdlTsuki() {
        return ddlTsuki;
    }

    /*
     * setddlTsuki
     * @param ddlTsuki ddlTsuki
     */
    @JsonProperty("ddlTsuki")
    public void setDdlTsuki(DropDownList ddlTsuki) {
        this.ddlTsuki = ddlTsuki;
    }

    /*
     * gettbKingaku
     * @return tbKingaku
     */
    @JsonProperty("tbKingaku")
    public TextBoxNum getTbKingaku() {
        return tbKingaku;
    }

    /*
     * settbKingaku
     * @param tbKingaku tbKingaku
     */
    @JsonProperty("tbKingaku")
    public void setTbKingaku(TextBoxNum tbKingaku) {
        this.tbKingaku = tbKingaku;
    }

    /*
     * gettbCreateDate
     * @return tbCreateDate
     */
    @JsonProperty("tbCreateDate")
    public TextBoxDate getTbCreateDate() {
        return tbCreateDate;
    }

    /*
     * settbCreateDate
     * @param tbCreateDate tbCreateDate
     */
    @JsonProperty("tbCreateDate")
    public void setTbCreateDate(TextBoxDate tbCreateDate) {
        this.tbCreateDate = tbCreateDate;
    }

    /*
     * gettbTaishoNen
     * @return tbTaishoNen
     */
    @JsonProperty("tbTaishoNen")
    public TextBox getTbTaishoNen() {
        return tbTaishoNen;
    }

    /*
     * settbTaishoNen
     * @param tbTaishoNen tbTaishoNen
     */
    @JsonProperty("tbTaishoNen")
    public void setTbTaishoNen(TextBox tbTaishoNen) {
        this.tbTaishoNen = tbTaishoNen;
    }

    /*
     * gettbLoadCata
     * @return tbLoadCata
     */
    @JsonProperty("tbLoadCata")
    public TextBox getTbLoadCata() {
        return tbLoadCata;
    }

    /*
     * settbLoadCata
     * @param tbLoadCata tbLoadCata
     */
    @JsonProperty("tbLoadCata")
    public void setTbLoadCata(TextBox tbLoadCata) {
        this.tbLoadCata = tbLoadCata;
    }

    // </editor-fold>
}
