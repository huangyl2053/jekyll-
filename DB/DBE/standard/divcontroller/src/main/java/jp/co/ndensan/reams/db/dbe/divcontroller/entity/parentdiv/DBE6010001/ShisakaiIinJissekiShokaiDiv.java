package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisakaiIinJissekiShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisakaiIinJissekiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiKaisaibi")
    private ShinsakaiKaisaibiDiv ShinsakaiKaisaibi;
    @JsonProperty("ShisakaiIinJisseki")
    private ShisakaiIinJissekiDiv ShisakaiIinJisseki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsakaiKaisaibi
     * @return ShinsakaiKaisaibi
     */
    @JsonProperty("ShinsakaiKaisaibi")
    public ShinsakaiKaisaibiDiv getShinsakaiKaisaibi() {
        return ShinsakaiKaisaibi;
    }

    /*
     * setShinsakaiKaisaibi
     * @param ShinsakaiKaisaibi ShinsakaiKaisaibi
     */
    @JsonProperty("ShinsakaiKaisaibi")
    public void setShinsakaiKaisaibi(ShinsakaiKaisaibiDiv ShinsakaiKaisaibi) {
        this.ShinsakaiKaisaibi = ShinsakaiKaisaibi;
    }

    /*
     * getShisakaiIinJisseki
     * @return ShisakaiIinJisseki
     */
    @JsonProperty("ShisakaiIinJisseki")
    public ShisakaiIinJissekiDiv getShisakaiIinJisseki() {
        return ShisakaiIinJisseki;
    }

    /*
     * setShisakaiIinJisseki
     * @param ShisakaiIinJisseki ShisakaiIinJisseki
     */
    @JsonProperty("ShisakaiIinJisseki")
    public void setShisakaiIinJisseki(ShisakaiIinJissekiDiv ShisakaiIinJisseki) {
        this.ShisakaiIinJisseki = ShisakaiIinJisseki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtShinsakaiKaisaibi() {
        return this.getShinsakaiKaisaibi().getTxtShinsakaiKaisaibi();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaibi(TextBoxDateRange txtShinsakaiKaisaibi) {
        this.getShinsakaiKaisaibi().setTxtShinsakaiKaisaibi(txtShinsakaiKaisaibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getShinsakaiKaisaibi().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getShinsakaiKaisaibi().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getShinsakaiKaisaibi().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getShinsakaiKaisaibi().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getShinsakaiKaisaibi().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getShinsakaiKaisaibi().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public DataGrid<dgShisakaiIinJisseki_Row> getDgShisakaiIinJisseki() {
        return this.getShisakaiIinJisseki().getDgShisakaiIinJisseki();
    }

    @JsonIgnore
    public void  setDgShisakaiIinJisseki(DataGrid<dgShisakaiIinJisseki_Row> dgShisakaiIinJisseki) {
        this.getShisakaiIinJisseki().setDgShisakaiIinJisseki(dgShisakaiIinJisseki);
    }

    // </editor-fold>
}
