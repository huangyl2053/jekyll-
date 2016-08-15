package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabChosainhoshuTanka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabChosainhoshuTankaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnChoTsuika")
    private Button btnChoTsuika;
    @JsonProperty("dgChosainhoshuTankaIchiran")
    private DataGrid<dgChosainhoshuTankaIchiran_Row> dgChosainhoshuTankaIchiran;
    @JsonProperty("ChosainhoshuTankaNyuryoku")
    private ChosainhoshuTankaNyuryokuDiv ChosainhoshuTankaNyuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnChoTsuika
     * @return btnChoTsuika
     */
    @JsonProperty("btnChoTsuika")
    public Button getBtnChoTsuika() {
        return btnChoTsuika;
    }

    /*
     * setbtnChoTsuika
     * @param btnChoTsuika btnChoTsuika
     */
    @JsonProperty("btnChoTsuika")
    public void setBtnChoTsuika(Button btnChoTsuika) {
        this.btnChoTsuika = btnChoTsuika;
    }

    /*
     * getdgChosainhoshuTankaIchiran
     * @return dgChosainhoshuTankaIchiran
     */
    @JsonProperty("dgChosainhoshuTankaIchiran")
    public DataGrid<dgChosainhoshuTankaIchiran_Row> getDgChosainhoshuTankaIchiran() {
        return dgChosainhoshuTankaIchiran;
    }

    /*
     * setdgChosainhoshuTankaIchiran
     * @param dgChosainhoshuTankaIchiran dgChosainhoshuTankaIchiran
     */
    @JsonProperty("dgChosainhoshuTankaIchiran")
    public void setDgChosainhoshuTankaIchiran(DataGrid<dgChosainhoshuTankaIchiran_Row> dgChosainhoshuTankaIchiran) {
        this.dgChosainhoshuTankaIchiran = dgChosainhoshuTankaIchiran;
    }

    /*
     * getChosainhoshuTankaNyuryoku
     * @return ChosainhoshuTankaNyuryoku
     */
    @JsonProperty("ChosainhoshuTankaNyuryoku")
    public ChosainhoshuTankaNyuryokuDiv getChosainhoshuTankaNyuryoku() {
        return ChosainhoshuTankaNyuryoku;
    }

    /*
     * setChosainhoshuTankaNyuryoku
     * @param ChosainhoshuTankaNyuryoku ChosainhoshuTankaNyuryoku
     */
    @JsonProperty("ChosainhoshuTankaNyuryoku")
    public void setChosainhoshuTankaNyuryoku(ChosainhoshuTankaNyuryokuDiv ChosainhoshuTankaNyuryoku) {
        this.ChosainhoshuTankaNyuryoku = ChosainhoshuTankaNyuryoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtChoKaishiYM() {
        return this.getChosainhoshuTankaNyuryoku().getTxtChoKaishiYM();
    }

    @JsonIgnore
    public void  setTxtChoKaishiYM(TextBoxFlexibleYearMonth txtChoKaishiYM) {
        this.getChosainhoshuTankaNyuryoku().setTxtChoKaishiYM(txtChoKaishiYM);
    }

    @JsonIgnore
    public TextBoxFlexibleYearMonth getTxtChoShuryoYM() {
        return this.getChosainhoshuTankaNyuryoku().getTxtChoShuryoYM();
    }

    @JsonIgnore
    public void  setTxtChoShuryoYM(TextBoxFlexibleYearMonth txtChoShuryoYM) {
        this.getChosainhoshuTankaNyuryoku().setTxtChoShuryoYM(txtChoShuryoYM);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoNinteiShinsaIinShubetsu() {
        return this.getChosainhoshuTankaNyuryoku().getDdlKaigoNinteiShinsaIinShubetsu();
    }

    @JsonIgnore
    public void  setDdlKaigoNinteiShinsaIinShubetsu(DropDownList ddlKaigoNinteiShinsaIinShubetsu) {
        this.getChosainhoshuTankaNyuryoku().setDdlKaigoNinteiShinsaIinShubetsu(ddlKaigoNinteiShinsaIinShubetsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoTanka() {
        return this.getChosainhoshuTankaNyuryoku().getTxtChoTanka();
    }

    @JsonIgnore
    public void  setTxtChoTanka(TextBoxNum txtChoTanka) {
        this.getChosainhoshuTankaNyuryoku().setTxtChoTanka(txtChoTanka);
    }

    @JsonIgnore
    public Button getBtnChoKousin() {
        return this.getChosainhoshuTankaNyuryoku().getBtnChoKousin();
    }

    @JsonIgnore
    public void  setBtnChoKousin(Button btnChoKousin) {
        this.getChosainhoshuTankaNyuryoku().setBtnChoKousin(btnChoKousin);
    }

    @JsonIgnore
    public Button getBtnChoTorikesu() {
        return this.getChosainhoshuTankaNyuryoku().getBtnChoTorikesu();
    }

    @JsonIgnore
    public void  setBtnChoTorikesu(Button btnChoTorikesu) {
        this.getChosainhoshuTankaNyuryoku().setBtnChoTorikesu(btnChoTorikesu);
    }

    // </editor-fold>
}
