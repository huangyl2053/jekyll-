package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaErrorShoriButton のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaErrorShoriButtonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnMishori")
    private Button btnMishori;
    @JsonProperty("btnFukaKosei")
    private Button btnFukaKosei;
    @JsonProperty("btnShikakuFuseigo")
    private Button btnShikakuFuseigo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnMishori
     * @return btnMishori
     */
    @JsonProperty("btnMishori")
    public Button getBtnMishori() {
        return btnMishori;
    }

    /*
     * setbtnMishori
     * @param btnMishori btnMishori
     */
    @JsonProperty("btnMishori")
    public void setBtnMishori(Button btnMishori) {
        this.btnMishori = btnMishori;
    }

    /*
     * getbtnFukaKosei
     * @return btnFukaKosei
     */
    @JsonProperty("btnFukaKosei")
    public Button getBtnFukaKosei() {
        return btnFukaKosei;
    }

    /*
     * setbtnFukaKosei
     * @param btnFukaKosei btnFukaKosei
     */
    @JsonProperty("btnFukaKosei")
    public void setBtnFukaKosei(Button btnFukaKosei) {
        this.btnFukaKosei = btnFukaKosei;
    }

    /*
     * getbtnShikakuFuseigo
     * @return btnShikakuFuseigo
     */
    @JsonProperty("btnShikakuFuseigo")
    public Button getBtnShikakuFuseigo() {
        return btnShikakuFuseigo;
    }

    /*
     * setbtnShikakuFuseigo
     * @param btnShikakuFuseigo btnShikakuFuseigo
     */
    @JsonProperty("btnShikakuFuseigo")
    public void setBtnShikakuFuseigo(Button btnShikakuFuseigo) {
        this.btnShikakuFuseigo = btnShikakuFuseigo;
    }

    // </editor-fold>
}
