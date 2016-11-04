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

/**
 * tplZaitaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplZaitakuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuGaikyoChosa")
    private JutakuGaikyoChosaDiv JutakuGaikyoChosa;
    @JsonProperty("txtShichosonTokubetsuKyufu")
    private TextBoxMultiLine txtShichosonTokubetsuKyufu;
    @JsonProperty("txtKyufuIgaiJutakuService")
    private TextBoxMultiLine txtKyufuIgaiJutakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutakuGaikyoChosa
     * @return JutakuGaikyoChosa
     */
    @JsonProperty("JutakuGaikyoChosa")
    public JutakuGaikyoChosaDiv getJutakuGaikyoChosa() {
        return JutakuGaikyoChosa;
    }

    /*
     * setJutakuGaikyoChosa
     * @param JutakuGaikyoChosa JutakuGaikyoChosa
     */
    @JsonProperty("JutakuGaikyoChosa")
    public void setJutakuGaikyoChosa(JutakuGaikyoChosaDiv JutakuGaikyoChosa) {
        this.JutakuGaikyoChosa = JutakuGaikyoChosa;
    }

    /*
     * gettxtShichosonTokubetsuKyufu
     * @return txtShichosonTokubetsuKyufu
     */
    @JsonProperty("txtShichosonTokubetsuKyufu")
    public TextBoxMultiLine getTxtShichosonTokubetsuKyufu() {
        return txtShichosonTokubetsuKyufu;
    }

    /*
     * settxtShichosonTokubetsuKyufu
     * @param txtShichosonTokubetsuKyufu txtShichosonTokubetsuKyufu
     */
    @JsonProperty("txtShichosonTokubetsuKyufu")
    public void setTxtShichosonTokubetsuKyufu(TextBoxMultiLine txtShichosonTokubetsuKyufu) {
        this.txtShichosonTokubetsuKyufu = txtShichosonTokubetsuKyufu;
    }

    /*
     * gettxtKyufuIgaiJutakuService
     * @return txtKyufuIgaiJutakuService
     */
    @JsonProperty("txtKyufuIgaiJutakuService")
    public TextBoxMultiLine getTxtKyufuIgaiJutakuService() {
        return txtKyufuIgaiJutakuService;
    }

    /*
     * settxtKyufuIgaiJutakuService
     * @param txtKyufuIgaiJutakuService txtKyufuIgaiJutakuService
     */
    @JsonProperty("txtKyufuIgaiJutakuService")
    public void setTxtKyufuIgaiJutakuService(TextBoxMultiLine txtKyufuIgaiJutakuService) {
        this.txtKyufuIgaiJutakuService = txtKyufuIgaiJutakuService;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJutakuKaishu() {
        return this.getJutakuGaikyoChosa().getRadJutakuKaishu();
    }

    @JsonIgnore
    public void  setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.getJutakuGaikyoChosa().setRadJutakuKaishu(radJutakuKaishu);
    }

    @JsonIgnore
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return this.getJutakuGaikyoChosa().getDgRiyoServiceJyokyo();
    }

    @JsonIgnore
    public void  setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.getJutakuGaikyoChosa().setDgRiyoServiceJyokyo(dgRiyoServiceJyokyo);
    }

    // </editor-fold>
}
