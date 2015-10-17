package jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv.IJigyoshaSearchConditionOptionDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JigyoshaSearchConditionOption のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */
public class JigyoshaSearchConditionOptionDiv extends Panel implements IJigyoshaSearchConditionOptionDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkOutputKyushiHaishi")
    private CheckBoxList chkOutputKyushiHaishi;
    @JsonProperty("chkOutputShisetsuRireki")
    private CheckBoxList chkOutputShisetsuRireki;
    @JsonProperty("txtMaxNum")
    private TextBoxNum txtMaxNum;
    @JsonProperty("btnSearchShisetsu")
    private Button btnSearchShisetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkOutputKyushiHaishi")
    public CheckBoxList getChkOutputKyushiHaishi() {
        return chkOutputKyushiHaishi;
    }

    @JsonProperty("chkOutputKyushiHaishi")
    public void setChkOutputKyushiHaishi(CheckBoxList chkOutputKyushiHaishi) {
        this.chkOutputKyushiHaishi=chkOutputKyushiHaishi;
    }

    @JsonProperty("chkOutputShisetsuRireki")
    public CheckBoxList getChkOutputShisetsuRireki() {
        return chkOutputShisetsuRireki;
    }

    @JsonProperty("chkOutputShisetsuRireki")
    public void setChkOutputShisetsuRireki(CheckBoxList chkOutputShisetsuRireki) {
        this.chkOutputShisetsuRireki=chkOutputShisetsuRireki;
    }

    @JsonProperty("txtMaxNum")
    public TextBoxNum getTxtMaxNum() {
        return txtMaxNum;
    }

    @JsonProperty("txtMaxNum")
    public void setTxtMaxNum(TextBoxNum txtMaxNum) {
        this.txtMaxNum=txtMaxNum;
    }

    @JsonProperty("btnSearchShisetsu")
    public Button getBtnSearchShisetsu() {
        return btnSearchShisetsu;
    }

    @JsonProperty("btnSearchShisetsu")
    public void setBtnSearchShisetsu(Button btnSearchShisetsu) {
        this.btnSearchShisetsu=btnSearchShisetsu;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
