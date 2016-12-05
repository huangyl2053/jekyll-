package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
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
 * ShinsakaiKaisaiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiKaisaiKekkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiYoteiInfo")
    private ShinsakaiYoteiInfoDiv ShinsakaiYoteiInfo;
    @JsonProperty("ShinsakaiKaisaiInfo")
    private ShinsakaiKaisaiInfoDiv ShinsakaiKaisaiInfo;
    @JsonProperty("ShinsakaiIinToroku")
    private ShinsakaiIinTorokuDiv ShinsakaiIinToroku;
    @JsonProperty("onseiFile")
    private onseiFileDiv onseiFile;
    @JsonProperty("Model")
    private RString Model;
    @JsonProperty("gogitaiNo")
    private RString gogitaiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiYoteiInfo
     * @return ShinsakaiYoteiInfo
     */
    @JsonProperty("ShinsakaiYoteiInfo")
    public ShinsakaiYoteiInfoDiv getShinsakaiYoteiInfo() {
        return ShinsakaiYoteiInfo;
    }

    /*
     * setShinsakaiYoteiInfo
     * @param ShinsakaiYoteiInfo ShinsakaiYoteiInfo
     */
    @JsonProperty("ShinsakaiYoteiInfo")
    public void setShinsakaiYoteiInfo(ShinsakaiYoteiInfoDiv ShinsakaiYoteiInfo) {
        this.ShinsakaiYoteiInfo = ShinsakaiYoteiInfo;
    }

    /*
     * getShinsakaiKaisaiInfo
     * @return ShinsakaiKaisaiInfo
     */
    @JsonProperty("ShinsakaiKaisaiInfo")
    public ShinsakaiKaisaiInfoDiv getShinsakaiKaisaiInfo() {
        return ShinsakaiKaisaiInfo;
    }

    /*
     * setShinsakaiKaisaiInfo
     * @param ShinsakaiKaisaiInfo ShinsakaiKaisaiInfo
     */
    @JsonProperty("ShinsakaiKaisaiInfo")
    public void setShinsakaiKaisaiInfo(ShinsakaiKaisaiInfoDiv ShinsakaiKaisaiInfo) {
        this.ShinsakaiKaisaiInfo = ShinsakaiKaisaiInfo;
    }

    /*
     * getShinsakaiIinToroku
     * @return ShinsakaiIinToroku
     */
    @JsonProperty("ShinsakaiIinToroku")
    public ShinsakaiIinTorokuDiv getShinsakaiIinToroku() {
        return ShinsakaiIinToroku;
    }

    /*
     * setShinsakaiIinToroku
     * @param ShinsakaiIinToroku ShinsakaiIinToroku
     */
    @JsonProperty("ShinsakaiIinToroku")
    public void setShinsakaiIinToroku(ShinsakaiIinTorokuDiv ShinsakaiIinToroku) {
        this.ShinsakaiIinToroku = ShinsakaiIinToroku;
    }

    /*
     * getonseiFile
     * @return onseiFile
     */
    @JsonProperty("onseiFile")
    public onseiFileDiv getOnseiFile() {
        return onseiFile;
    }

    /*
     * setonseiFile
     * @param onseiFile onseiFile
     */
    @JsonProperty("onseiFile")
    public void setOnseiFile(onseiFileDiv onseiFile) {
        this.onseiFile = onseiFile;
    }

    /*
     * getModel
     * @return Model
     */
    @JsonProperty("Model")
    public RString getModel() {
        return Model;
    }

    /*
     * setModel
     * @param Model Model
     */
    @JsonProperty("Model")
    public void setModel(RString Model) {
        this.Model = Model;
    }

    /*
     * getgogitaiNo
     * @return gogitaiNo
     */
    @JsonProperty("gogitaiNo")
    public RString getGogitaiNo() {
        return gogitaiNo;
    }

    /*
     * setgogitaiNo
     * @param gogitaiNo gogitaiNo
     */
    @JsonProperty("gogitaiNo")
    public void setGogitaiNo(RString gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinsakaiMeisho() {
        return this.getShinsakaiYoteiInfo().getTxtShinsakaiMeisho();
    }

    @JsonIgnore
    public void  setTxtShinsakaiMeisho(TextBox txtShinsakaiMeisho) {
        this.getShinsakaiYoteiInfo().setTxtShinsakaiMeisho(txtShinsakaiMeisho);
    }

    @JsonIgnore
    public TextBox getTxtGogitai() {
        return this.getShinsakaiYoteiInfo().getTxtGogitai();
    }

    @JsonIgnore
    public void  setTxtGogitai(TextBox txtGogitai) {
        this.getShinsakaiYoteiInfo().setTxtGogitai(txtGogitai);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaisaiYoteibi() {
        return this.getShinsakaiYoteiInfo().getTxtKaisaiYoteibi();
    }

    @JsonIgnore
    public void  setTxtKaisaiYoteibi(TextBoxFlexibleDate txtKaisaiYoteibi) {
        this.getShinsakaiYoteiInfo().setTxtKaisaiYoteibi(txtKaisaiYoteibi);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiStartTime() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiStartTime();
    }

    @JsonIgnore
    public void  setTxtYoteiStartTime(TextBoxTime txtYoteiStartTime) {
        this.getShinsakaiYoteiInfo().setTxtYoteiStartTime(txtYoteiStartTime);
    }

    @JsonIgnore
    public TextBoxTime getTxtYoteiEndTime() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiEndTime();
    }

    @JsonIgnore
    public void  setTxtYoteiEndTime(TextBoxTime txtYoteiEndTime) {
        this.getShinsakaiYoteiInfo().setTxtYoteiEndTime(txtYoteiEndTime);
    }

    @JsonIgnore
    public TextBoxNum getTxtYoteiTeiin() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiTeiin();
    }

    @JsonIgnore
    public void  setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.getShinsakaiYoteiInfo().setTxtYoteiTeiin(txtYoteiTeiin);
    }

    @JsonIgnore
    public TextBox getTxtYoteiKaijo() {
        return this.getShinsakaiYoteiInfo().getTxtYoteiKaijo();
    }

    @JsonIgnore
    public void  setTxtYoteiKaijo(TextBox txtYoteiKaijo) {
        this.getShinsakaiYoteiInfo().setTxtYoteiKaijo(txtYoteiKaijo);
    }

    @JsonIgnore
    public DataGrid<dgShinsakaiIinIchiran_Row> getDgShinsakaiIinIchiran() {
        return this.getShinsakaiIinToroku().getDgShinsakaiIinIchiran();
    }

    @JsonIgnore
    public void  setDgShinsakaiIinIchiran(DataGrid<dgShinsakaiIinIchiran_Row> dgShinsakaiIinIchiran) {
        this.getShinsakaiIinToroku().setDgShinsakaiIinIchiran(dgShinsakaiIinIchiran);
    }

    @JsonIgnore
    public UploadPanel getUplUploadPanel() {
        return this.getOnseiFile().getUplUploadPanel();
    }

    @JsonIgnore
    public void  setUplUploadPanel(UploadPanel uplUploadPanel) {
        this.getOnseiFile().setUplUploadPanel(uplUploadPanel);
    }

    @JsonIgnore
    public Button getBtnAddOnseiFile() {
        return this.getOnseiFile().getBtnAddOnseiFile();
    }

    @JsonIgnore
    public void  setBtnAddOnseiFile(Button btnAddOnseiFile) {
        this.getOnseiFile().setBtnAddOnseiFile(btnAddOnseiFile);
    }

    // </editor-fold>
}
