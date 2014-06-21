package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaigoNinteiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaigoNinteiKekkaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabShinsaKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShinsaKekkaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiKekkaNyuryoku")
    private KaigoNinteiKekkaDiv NinteiKekkaNyuryoku;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("ZenkaiNinteiKekka")
    private KaigoNinteiKekkaDiv ZenkaiNinteiKekka;
    @JsonProperty("ZenZenkaiNinteiKekka")
    private KaigoNinteiKekkaDiv ZenZenkaiNinteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteiKekkaNyuryoku")
    public KaigoNinteiKekkaDiv getNinteiKekkaNyuryoku() {
        return NinteiKekkaNyuryoku;
    }

    @JsonProperty("NinteiKekkaNyuryoku")
    public void setNinteiKekkaNyuryoku(KaigoNinteiKekkaDiv NinteiKekkaNyuryoku) {
        this.NinteiKekkaNyuryoku=NinteiKekkaNyuryoku;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
    }

    @JsonProperty("ZenkaiNinteiKekka")
    public KaigoNinteiKekkaDiv getZenkaiNinteiKekka() {
        return ZenkaiNinteiKekka;
    }

    @JsonProperty("ZenkaiNinteiKekka")
    public void setZenkaiNinteiKekka(KaigoNinteiKekkaDiv ZenkaiNinteiKekka) {
        this.ZenkaiNinteiKekka=ZenkaiNinteiKekka;
    }

    @JsonProperty("ZenZenkaiNinteiKekka")
    public KaigoNinteiKekkaDiv getZenZenkaiNinteiKekka() {
        return ZenZenkaiNinteiKekka;
    }

    @JsonProperty("ZenZenkaiNinteiKekka")
    public void setZenZenkaiNinteiKekka(KaigoNinteiKekkaDiv ZenZenkaiNinteiKekka) {
        this.ZenZenkaiNinteiKekka=ZenZenkaiNinteiKekka;
    }

}
