package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shisetsujoho.IShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShisetsuNyutaishoInput のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuNyutaishoInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("btnShisetsuNyutaishoKakutei")
    private Button btnShisetsuNyutaishoKakutei;
    @JsonProperty("btnShisetsuNyutaishoTorikeshi")
    private Button btnShisetsuNyutaishoTorikeshi;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoDiv ccdShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNyushoDate")
    public TextBoxFlexibleDate getTxtNyushoDate() {
        return txtNyushoDate;
    }

    @JsonProperty("txtNyushoDate")
    public void setTxtNyushoDate(TextBoxFlexibleDate txtNyushoDate) {
        this.txtNyushoDate = txtNyushoDate;
    }

    @JsonProperty("txtTaishoDate")
    public TextBoxFlexibleDate getTxtTaishoDate() {
        return txtTaishoDate;
    }

    @JsonProperty("txtTaishoDate")
    public void setTxtTaishoDate(TextBoxFlexibleDate txtTaishoDate) {
        this.txtTaishoDate = txtTaishoDate;
    }

    @JsonProperty("btnShisetsuNyutaishoKakutei")
    public Button getBtnShisetsuNyutaishoKakutei() {
        return btnShisetsuNyutaishoKakutei;
    }

    @JsonProperty("btnShisetsuNyutaishoKakutei")
    public void setBtnShisetsuNyutaishoKakutei(Button btnShisetsuNyutaishoKakutei) {
        this.btnShisetsuNyutaishoKakutei = btnShisetsuNyutaishoKakutei;
    }

    @JsonProperty("btnShisetsuNyutaishoTorikeshi")
    public Button getBtnShisetsuNyutaishoTorikeshi() {
        return btnShisetsuNyutaishoTorikeshi;
    }

    @JsonProperty("btnShisetsuNyutaishoTorikeshi")
    public void setBtnShisetsuNyutaishoTorikeshi(Button btnShisetsuNyutaishoTorikeshi) {
        this.btnShisetsuNyutaishoTorikeshi = btnShisetsuNyutaishoTorikeshi;
    }

    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

    // </editor-fold>
}
