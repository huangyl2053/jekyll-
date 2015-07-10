package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IGyoseikuInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GyoseikuSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class GyoseikuSelectDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdGyoseikuInputSt")
    private GyoseikuInputDiv ccdGyoseikuInputSt;
    @JsonProperty("lblKaraGyoseiku")
    private Label lblKaraGyoseiku;
    @JsonProperty("ccdGyoseikuInputEd")
    private GyoseikuInputDiv ccdGyoseikuInputEd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdGyoseikuInputSt")
    public IGyoseikuInputDiv getCcdGyoseikuInputSt() {
        return ccdGyoseikuInputSt;
    }

    @JsonProperty("lblKaraGyoseiku")
    public Label getLblKaraGyoseiku() {
        return lblKaraGyoseiku;
    }

    @JsonProperty("lblKaraGyoseiku")
    public void setLblKaraGyoseiku(Label lblKaraGyoseiku) {
        this.lblKaraGyoseiku=lblKaraGyoseiku;
    }

    @JsonProperty("ccdGyoseikuInputEd")
    public IGyoseikuInputDiv getCcdGyoseikuInputEd() {
        return ccdGyoseikuInputEd;
    }

}
