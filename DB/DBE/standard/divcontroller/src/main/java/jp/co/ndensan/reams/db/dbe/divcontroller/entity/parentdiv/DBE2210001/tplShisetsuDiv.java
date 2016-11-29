package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
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
 * tplShisetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShisetsuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("GaikyoTokkiShisetsu")
    private GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu;
    @JsonProperty("GaigyoShisetsuRenrakusaki")
    private GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getGaikyoTokkiShisetsu
     * @return GaikyoTokkiShisetsu
     */
    @JsonProperty("GaikyoTokkiShisetsu")
    public GaikyoTokkiShisetsuDiv getGaikyoTokkiShisetsu() {
        return GaikyoTokkiShisetsu;
    }

    /*
     * setGaikyoTokkiShisetsu
     * @param GaikyoTokkiShisetsu GaikyoTokkiShisetsu
     */
    @JsonProperty("GaikyoTokkiShisetsu")
    public void setGaikyoTokkiShisetsu(GaikyoTokkiShisetsuDiv GaikyoTokkiShisetsu) {
        this.GaikyoTokkiShisetsu = GaikyoTokkiShisetsu;
    }

    /*
     * getGaigyoShisetsuRenrakusaki
     * @return GaigyoShisetsuRenrakusaki
     */
    @JsonProperty("GaigyoShisetsuRenrakusaki")
    public GaigyoShisetsuRenrakusakiDiv getGaigyoShisetsuRenrakusaki() {
        return GaigyoShisetsuRenrakusaki;
    }

    /*
     * setGaigyoShisetsuRenrakusaki
     * @param GaigyoShisetsuRenrakusaki GaigyoShisetsuRenrakusaki
     */
    @JsonProperty("GaigyoShisetsuRenrakusaki")
    public void setGaigyoShisetsuRenrakusaki(GaigyoShisetsuRenrakusakiDiv GaigyoShisetsuRenrakusaki) {
        this.GaigyoShisetsuRenrakusaki = GaigyoShisetsuRenrakusaki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgRiyoShisetsu_Row> getDgRiyoShisetsu() {
        return this.getGaikyoTokkiShisetsu().getDgRiyoShisetsu();
    }

    @JsonIgnore
    public void  setDgRiyoShisetsu(DataGrid<dgRiyoShisetsu_Row> dgRiyoShisetsu) {
        this.getGaikyoTokkiShisetsu().setDgRiyoShisetsu(dgRiyoShisetsu);
    }

    @JsonIgnore
    public TextBox getTxtShisetsuMeisdho() {
        return this.getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho();
    }

    @JsonIgnore
    public void  setTxtShisetsuMeisdho(TextBox txtShisetsuMeisdho) {
        this.getGaigyoShisetsuRenrakusaki().setTxtShisetsuMeisdho(txtShisetsuMeisdho);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShisetsuYubinNo() {
        return this.getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo();
    }

    @JsonIgnore
    public void  setTxtShisetsuYubinNo(TextBoxYubinNo txtShisetsuYubinNo) {
        this.getGaigyoShisetsuRenrakusaki().setTxtShisetsuYubinNo(txtShisetsuYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShisetsuJusho() {
        return this.getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho();
    }

    @JsonIgnore
    public void  setTxtShisetsuJusho(TextBoxJusho txtShisetsuJusho) {
        this.getGaigyoShisetsuRenrakusaki().setTxtShisetsuJusho(txtShisetsuJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getGaigyoShisetsuRenrakusaki().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getGaigyoShisetsuRenrakusaki().setTxtTelNo(txtTelNo);
    }

    // </editor-fold>
}
