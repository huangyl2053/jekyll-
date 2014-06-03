package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaItakuJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaKekkaShosaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ChosaKekkaShuseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KihonJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaKekkaShosaiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaKekkaShosaiMainDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("ChosaItakuJoho")
    private ChosaItakuJohoDiv ChosaItakuJoho;
    @JsonProperty("ChosaKekkaShusei")
    private ChosaKekkaShuseiDiv ChosaKekkaShusei;
    @JsonProperty("ChosaKekkaShosai")
    private ChosaKekkaShosaiDiv ChosaKekkaShosai;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnReturn")
    private Button btnReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho=KihonJoho;
    }

    @JsonProperty("ChosaItakuJoho")
    public ChosaItakuJohoDiv getChosaItakuJoho() {
        return ChosaItakuJoho;
    }

    @JsonProperty("ChosaItakuJoho")
    public void setChosaItakuJoho(ChosaItakuJohoDiv ChosaItakuJoho) {
        this.ChosaItakuJoho=ChosaItakuJoho;
    }

    @JsonProperty("ChosaKekkaShusei")
    public ChosaKekkaShuseiDiv getChosaKekkaShusei() {
        return ChosaKekkaShusei;
    }

    @JsonProperty("ChosaKekkaShusei")
    public void setChosaKekkaShusei(ChosaKekkaShuseiDiv ChosaKekkaShusei) {
        this.ChosaKekkaShusei=ChosaKekkaShusei;
    }

    @JsonProperty("ChosaKekkaShosai")
    public ChosaKekkaShosaiDiv getChosaKekkaShosai() {
        return ChosaKekkaShosai;
    }

    @JsonProperty("ChosaKekkaShosai")
    public void setChosaKekkaShosai(ChosaKekkaShosaiDiv ChosaKekkaShosai) {
        this.ChosaKekkaShosai=ChosaKekkaShosai;
    }

    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku=btnToroku;
    }

    @JsonProperty("btnReturn")
    public Button getBtnReturn() {
        return btnReturn;
    }

    @JsonProperty("btnReturn")
    public void setBtnReturn(Button btnReturn) {
        this.btnReturn=btnReturn;
    }

}
