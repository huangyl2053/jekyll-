package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShisetsuNyutaishoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuNyutaishoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNyushoDate")
    private TextBoxFlexibleDate txtNyushoDate;
    @JsonProperty("txtTaishoDate")
    private TextBoxFlexibleDate txtTaishoDate;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoDiv ccdShisetsuJoho;
    @JsonProperty("btnShisetsuNyutaishoKakutei")
    private Button btnShisetsuNyutaishoKakutei;
    @JsonProperty("btnShisetsuNyutaishoTorikeshi")
    private Button btnShisetsuNyutaishoTorikeshi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNyushoDate
     * @return txtNyushoDate
     */
    @JsonProperty("txtNyushoDate")
    public TextBoxFlexibleDate getTxtNyushoDate() {
        return txtNyushoDate;
    }

    /*
     * settxtNyushoDate
     * @param txtNyushoDate txtNyushoDate
     */
    @JsonProperty("txtNyushoDate")
    public void setTxtNyushoDate(TextBoxFlexibleDate txtNyushoDate) {
        this.txtNyushoDate = txtNyushoDate;
    }

    /*
     * gettxtTaishoDate
     * @return txtTaishoDate
     */
    @JsonProperty("txtTaishoDate")
    public TextBoxFlexibleDate getTxtTaishoDate() {
        return txtTaishoDate;
    }

    /*
     * settxtTaishoDate
     * @param txtTaishoDate txtTaishoDate
     */
    @JsonProperty("txtTaishoDate")
    public void setTxtTaishoDate(TextBoxFlexibleDate txtTaishoDate) {
        this.txtTaishoDate = txtTaishoDate;
    }

    /*
     * getccdShisetsuJoho
     * @return ccdShisetsuJoho
     */
    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

    /*
     * getbtnShisetsuNyutaishoKakutei
     * @return btnShisetsuNyutaishoKakutei
     */
    @JsonProperty("btnShisetsuNyutaishoKakutei")
    public Button getBtnShisetsuNyutaishoKakutei() {
        return btnShisetsuNyutaishoKakutei;
    }

    /*
     * setbtnShisetsuNyutaishoKakutei
     * @param btnShisetsuNyutaishoKakutei btnShisetsuNyutaishoKakutei
     */
    @JsonProperty("btnShisetsuNyutaishoKakutei")
    public void setBtnShisetsuNyutaishoKakutei(Button btnShisetsuNyutaishoKakutei) {
        this.btnShisetsuNyutaishoKakutei = btnShisetsuNyutaishoKakutei;
    }

    /*
     * getbtnShisetsuNyutaishoTorikeshi
     * @return btnShisetsuNyutaishoTorikeshi
     */
    @JsonProperty("btnShisetsuNyutaishoTorikeshi")
    public Button getBtnShisetsuNyutaishoTorikeshi() {
        return btnShisetsuNyutaishoTorikeshi;
    }

    /*
     * setbtnShisetsuNyutaishoTorikeshi
     * @param btnShisetsuNyutaishoTorikeshi btnShisetsuNyutaishoTorikeshi
     */
    @JsonProperty("btnShisetsuNyutaishoTorikeshi")
    public void setBtnShisetsuNyutaishoTorikeshi(Button btnShisetsuNyutaishoTorikeshi) {
        this.btnShisetsuNyutaishoTorikeshi = btnShisetsuNyutaishoTorikeshi;
    }

    // </editor-fold>
}
