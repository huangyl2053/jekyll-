package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ5100001;
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
 * KaigoNinteiShinseiKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNinteiShinseiKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnJokenClear")
    private Button btnJokenClear;
    @JsonProperty("txtMaxKensu")
    private TextBoxNum txtMaxKensu;
    @JsonProperty("KensakuKekka")
    private KensakuKekkaDiv KensakuKekka;
    @JsonProperty("ccdNinteiShinseishaFinder")
    private NinteiShinseishaFinderDiv ccdNinteiShinseishaFinder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnJokenClear
     * @return btnJokenClear
     */
    @JsonProperty("btnJokenClear")
    public Button getBtnJokenClear() {
        return btnJokenClear;
    }

    /*
     * setbtnJokenClear
     * @param btnJokenClear btnJokenClear
     */
    @JsonProperty("btnJokenClear")
    public void setBtnJokenClear(Button btnJokenClear) {
        this.btnJokenClear = btnJokenClear;
    }

    /*
     * gettxtMaxKensu
     * @return txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public TextBoxNum getTxtMaxKensu() {
        return txtMaxKensu;
    }

    /*
     * settxtMaxKensu
     * @param txtMaxKensu txtMaxKensu
     */
    @JsonProperty("txtMaxKensu")
    public void setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.txtMaxKensu = txtMaxKensu;
    }

    /*
     * getKensakuKekka
     * @return KensakuKekka
     */
    @JsonProperty("KensakuKekka")
    public KensakuKekkaDiv getKensakuKekka() {
        return KensakuKekka;
    }

    /*
     * setKensakuKekka
     * @param KensakuKekka KensakuKekka
     */
    @JsonProperty("KensakuKekka")
    public void setKensakuKekka(KensakuKekkaDiv KensakuKekka) {
        this.KensakuKekka = KensakuKekka;
    }

    /*
     * getccdNinteiShinseishaFinder
     * @return ccdNinteiShinseishaFinder
     */
    @JsonProperty("ccdNinteiShinseishaFinder")
    public INinteiShinseishaFinderDiv getCcdNinteiShinseishaFinder() {
        return ccdNinteiShinseishaFinder;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKensakuKekkaIchiran_Row> getDgKensakuKekkaIchiran() {
        return this.getKensakuKekka().getDgKensakuKekkaIchiran();
    }

    @JsonIgnore
    public void  setDgKensakuKekkaIchiran(DataGrid<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiran) {
        this.getKensakuKekka().setDgKensakuKekkaIchiran(dgKensakuKekkaIchiran);
    }

    // </editor-fold>
}
