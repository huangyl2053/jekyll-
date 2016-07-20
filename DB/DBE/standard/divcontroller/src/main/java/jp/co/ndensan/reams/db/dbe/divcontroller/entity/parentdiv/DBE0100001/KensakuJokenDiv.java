package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.INinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuOption")
    private KensakuOptionDiv KensakuOption;
    @JsonProperty("ccdNinteishinseishaFinder")
    private NinteiShinseishaFinderDiv ccdNinteishinseishaFinder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuOption
     * @return KensakuOption
     */
    @JsonProperty("KensakuOption")
    public KensakuOptionDiv getKensakuOption() {
        return KensakuOption;
    }

    /*
     * setKensakuOption
     * @param KensakuOption KensakuOption
     */
    @JsonProperty("KensakuOption")
    public void setKensakuOption(KensakuOptionDiv KensakuOption) {
        this.KensakuOption = KensakuOption;
    }

    /*
     * getccdNinteishinseishaFinder
     * @return ccdNinteishinseishaFinder
     */
    @JsonProperty("ccdNinteishinseishaFinder")
    public INinteiShinseishaFinderDiv getCcdNinteishinseishaFinder() {
        return ccdNinteishinseishaFinder;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuOption().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuOption().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuOption().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuOption().setBtnClear(btnClear);
    }

    @JsonIgnore
    public TextBox getTxtMaxDisp() {
        return this.getKensakuOption().getTxtMaxDisp();
    }

    @JsonIgnore
    public void  setTxtMaxDisp(TextBox txtMaxDisp) {
        this.getKensakuOption().setTxtMaxDisp(txtMaxDisp);
    }

    // </editor-fold>
}
