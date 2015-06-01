package jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestKaigoNinteiKihonJohoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TestKaigoNinteiKihonJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class TestKaigoNinteiKihonJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnLoad")
    private Button btnLoad;
    @JsonProperty("ccdKaigoNinteiKihonJokyoInput")
    private KaigoNinteiShinseiKihonJohoInputDiv ccdKaigoNinteiKihonJokyoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("btnLoad")
    public Button getBtnLoad() {
        return btnLoad;
    }

    @JsonProperty("btnLoad")
    public void setBtnLoad(Button btnLoad) {
        this.btnLoad=btnLoad;
    }

    @JsonProperty("ccdKaigoNinteiKihonJokyoInput")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiKihonJokyoInput() {
        return ccdKaigoNinteiKihonJokyoInput;
    }

    // </editor-fold>
}
