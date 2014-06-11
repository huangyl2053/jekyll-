package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiResultIdoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiTorikeshiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiResultOther のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiResultOtherDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;
    @JsonProperty("NinteiResultIdo")
    private NinteiResultIdoDiv NinteiResultIdo;
    @JsonProperty("NinteiTorikeshi")
    private NinteiTorikeshiDiv NinteiTorikeshi;
    @JsonProperty("txtTokuteiShippei")
    private TextBox txtTokuteiShippei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken=txtShinsakaiIken;
    }

    @JsonProperty("NinteiResultIdo")
    public NinteiResultIdoDiv getNinteiResultIdo() {
        return NinteiResultIdo;
    }

    @JsonProperty("NinteiResultIdo")
    public void setNinteiResultIdo(NinteiResultIdoDiv NinteiResultIdo) {
        this.NinteiResultIdo=NinteiResultIdo;
    }

    @JsonProperty("NinteiTorikeshi")
    public NinteiTorikeshiDiv getNinteiTorikeshi() {
        return NinteiTorikeshi;
    }

    @JsonProperty("NinteiTorikeshi")
    public void setNinteiTorikeshi(NinteiTorikeshiDiv NinteiTorikeshi) {
        this.NinteiTorikeshi=NinteiTorikeshi;
    }

    @JsonProperty("txtTokuteiShippei")
    public TextBox getTxtTokuteiShippei() {
        return txtTokuteiShippei;
    }

    @JsonProperty("txtTokuteiShippei")
    public void setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.txtTokuteiShippei=txtTokuteiShippei;
    }

}
