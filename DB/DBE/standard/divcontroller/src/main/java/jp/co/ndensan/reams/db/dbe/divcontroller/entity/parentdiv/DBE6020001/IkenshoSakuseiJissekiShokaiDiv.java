package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoSakuseiJissekiShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoSakuseiJissekiShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IkenshoKinyubi")
    private IkenshoKinyubiDiv IkenshoKinyubi;
    @JsonProperty("IkenshoSakuseiJisseki")
    private IkenshoSakuseiJissekiDiv IkenshoSakuseiJisseki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIkenshoKinyubi
     * @return IkenshoKinyubi
     */
    @JsonProperty("IkenshoKinyubi")
    public IkenshoKinyubiDiv getIkenshoKinyubi() {
        return IkenshoKinyubi;
    }

    /*
     * setIkenshoKinyubi
     * @param IkenshoKinyubi IkenshoKinyubi
     */
    @JsonProperty("IkenshoKinyubi")
    public void setIkenshoKinyubi(IkenshoKinyubiDiv IkenshoKinyubi) {
        this.IkenshoKinyubi = IkenshoKinyubi;
    }

    /*
     * getIkenshoSakuseiJisseki
     * @return IkenshoSakuseiJisseki
     */
    @JsonProperty("IkenshoSakuseiJisseki")
    public IkenshoSakuseiJissekiDiv getIkenshoSakuseiJisseki() {
        return IkenshoSakuseiJisseki;
    }

    /*
     * setIkenshoSakuseiJisseki
     * @param IkenshoSakuseiJisseki IkenshoSakuseiJisseki
     */
    @JsonProperty("IkenshoSakuseiJisseki")
    public void setIkenshoSakuseiJisseki(IkenshoSakuseiJissekiDiv IkenshoSakuseiJisseki) {
        this.IkenshoSakuseiJisseki = IkenshoSakuseiJisseki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtIkenshoKinyubi() {
        return this.getIkenshoKinyubi().getTxtIkenshoKinyubi();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubi(TextBoxDateRange txtIkenshoKinyubi) {
        this.getIkenshoKinyubi().setTxtIkenshoKinyubi(txtIkenshoKinyubi);
    }

    @JsonIgnore
    public Button getBtnKensakuClear() {
        return this.getIkenshoKinyubi().getBtnKensakuClear();
    }

    @JsonIgnore
    public void  setBtnKensakuClear(Button btnKensakuClear) {
        this.getIkenshoKinyubi().setBtnKensakuClear(btnKensakuClear);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getIkenshoKinyubi().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getIkenshoKinyubi().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getIkenshoKinyubi().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getIkenshoKinyubi().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensya() {
        return this.getIkenshoKinyubi().getCcdHokensya();
    }

    @JsonIgnore
    public DataGrid<dgIkenshoSakuseiJisseki_Row> getDgIkenshoSakuseiJisseki() {
        return this.getIkenshoSakuseiJisseki().getDgIkenshoSakuseiJisseki();
    }

    @JsonIgnore
    public void  setDgIkenshoSakuseiJisseki(DataGrid<dgIkenshoSakuseiJisseki_Row> dgIkenshoSakuseiJisseki) {
        this.getIkenshoSakuseiJisseki().setDgIkenshoSakuseiJisseki(dgIkenshoSakuseiJisseki);
    }

    // </editor-fold>
}
