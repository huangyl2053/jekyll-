package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IgakutekiKanriHitsuyosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IgakutekiKanriHitsuyoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkHasseiShojo")
    private CheckBoxList chkHasseiShojo;
    @JsonProperty("chkIgakutekiKanri")
    private CheckBoxList chkIgakutekiKanri;
    @JsonProperty("chkSonotaIryoService")
    private CheckBoxList chkSonotaIryoService;
    @JsonProperty("txtShonotaIryoServiceShosai")
    private TextBox txtShonotaIryoServiceShosai;
    @JsonProperty("chkSonotaIryoServiceHitsuyoSei")
    private CheckBoxList chkSonotaIryoServiceHitsuyoSei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkHasseiShojo
     * @return chkHasseiShojo
     */
    @JsonProperty("chkHasseiShojo")
    public CheckBoxList getChkHasseiShojo() {
        return chkHasseiShojo;
    }

    /*
     * setchkHasseiShojo
     * @param chkHasseiShojo chkHasseiShojo
     */
    @JsonProperty("chkHasseiShojo")
    public void setChkHasseiShojo(CheckBoxList chkHasseiShojo) {
        this.chkHasseiShojo = chkHasseiShojo;
    }

    /*
     * getchkIgakutekiKanri
     * @return chkIgakutekiKanri
     */
    @JsonProperty("chkIgakutekiKanri")
    public CheckBoxList getChkIgakutekiKanri() {
        return chkIgakutekiKanri;
    }

    /*
     * setchkIgakutekiKanri
     * @param chkIgakutekiKanri chkIgakutekiKanri
     */
    @JsonProperty("chkIgakutekiKanri")
    public void setChkIgakutekiKanri(CheckBoxList chkIgakutekiKanri) {
        this.chkIgakutekiKanri = chkIgakutekiKanri;
    }

    /*
     * getchkSonotaIryoService
     * @return chkSonotaIryoService
     */
    @JsonProperty("chkSonotaIryoService")
    public CheckBoxList getChkSonotaIryoService() {
        return chkSonotaIryoService;
    }

    /*
     * setchkSonotaIryoService
     * @param chkSonotaIryoService chkSonotaIryoService
     */
    @JsonProperty("chkSonotaIryoService")
    public void setChkSonotaIryoService(CheckBoxList chkSonotaIryoService) {
        this.chkSonotaIryoService = chkSonotaIryoService;
    }

    /*
     * gettxtShonotaIryoServiceShosai
     * @return txtShonotaIryoServiceShosai
     */
    @JsonProperty("txtShonotaIryoServiceShosai")
    public TextBox getTxtShonotaIryoServiceShosai() {
        return txtShonotaIryoServiceShosai;
    }

    /*
     * settxtShonotaIryoServiceShosai
     * @param txtShonotaIryoServiceShosai txtShonotaIryoServiceShosai
     */
    @JsonProperty("txtShonotaIryoServiceShosai")
    public void setTxtShonotaIryoServiceShosai(TextBox txtShonotaIryoServiceShosai) {
        this.txtShonotaIryoServiceShosai = txtShonotaIryoServiceShosai;
    }

    /*
     * getchkSonotaIryoServiceHitsuyoSei
     * @return chkSonotaIryoServiceHitsuyoSei
     */
    @JsonProperty("chkSonotaIryoServiceHitsuyoSei")
    public CheckBoxList getChkSonotaIryoServiceHitsuyoSei() {
        return chkSonotaIryoServiceHitsuyoSei;
    }

    /*
     * setchkSonotaIryoServiceHitsuyoSei
     * @param chkSonotaIryoServiceHitsuyoSei chkSonotaIryoServiceHitsuyoSei
     */
    @JsonProperty("chkSonotaIryoServiceHitsuyoSei")
    public void setChkSonotaIryoServiceHitsuyoSei(CheckBoxList chkSonotaIryoServiceHitsuyoSei) {
        this.chkSonotaIryoServiceHitsuyoSei = chkSonotaIryoServiceHitsuyoSei;
    }

    // </editor-fold>
}
