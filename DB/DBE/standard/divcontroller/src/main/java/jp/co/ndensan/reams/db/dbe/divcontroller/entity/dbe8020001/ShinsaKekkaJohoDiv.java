package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsaKekkaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsaKekkaJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisakaiKaisaibi")
    private TextBoxDate txtShisakaiKaisaibi;
    @JsonProperty("txtShinsakaiKaishiJikan")
    private TextBoxTime txtShinsakaiKaishiJikan;
    @JsonProperty("txtShinsakaiHanteibi")
    private TextBoxDate txtShinsakaiHanteibi;
    @JsonProperty("txtShinsakaiShuryoJikan")
    private TextBoxTime txtShinsakaiShuryoJikan;
    @JsonProperty("txtShinsaHanteiJikan")
    private TextBoxTime txtShinsaHanteiJikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShisakaiKaisaibi")
    public TextBoxDate getTxtShisakaiKaisaibi() {
        return txtShisakaiKaisaibi;
    }

    @JsonProperty("txtShisakaiKaisaibi")
    public void setTxtShisakaiKaisaibi(TextBoxDate txtShisakaiKaisaibi) {
        this.txtShisakaiKaisaibi=txtShisakaiKaisaibi;
    }

    @JsonProperty("txtShinsakaiKaishiJikan")
    public TextBoxTime getTxtShinsakaiKaishiJikan() {
        return txtShinsakaiKaishiJikan;
    }

    @JsonProperty("txtShinsakaiKaishiJikan")
    public void setTxtShinsakaiKaishiJikan(TextBoxTime txtShinsakaiKaishiJikan) {
        this.txtShinsakaiKaishiJikan=txtShinsakaiKaishiJikan;
    }

    @JsonProperty("txtShinsakaiHanteibi")
    public TextBoxDate getTxtShinsakaiHanteibi() {
        return txtShinsakaiHanteibi;
    }

    @JsonProperty("txtShinsakaiHanteibi")
    public void setTxtShinsakaiHanteibi(TextBoxDate txtShinsakaiHanteibi) {
        this.txtShinsakaiHanteibi=txtShinsakaiHanteibi;
    }

    @JsonProperty("txtShinsakaiShuryoJikan")
    public TextBoxTime getTxtShinsakaiShuryoJikan() {
        return txtShinsakaiShuryoJikan;
    }

    @JsonProperty("txtShinsakaiShuryoJikan")
    public void setTxtShinsakaiShuryoJikan(TextBoxTime txtShinsakaiShuryoJikan) {
        this.txtShinsakaiShuryoJikan=txtShinsakaiShuryoJikan;
    }

    @JsonProperty("txtShinsaHanteiJikan")
    public TextBoxTime getTxtShinsaHanteiJikan() {
        return txtShinsaHanteiJikan;
    }

    @JsonProperty("txtShinsaHanteiJikan")
    public void setTxtShinsaHanteiJikan(TextBoxTime txtShinsaHanteiJikan) {
        this.txtShinsaHanteiJikan=txtShinsaHanteiJikan;
    }

}
