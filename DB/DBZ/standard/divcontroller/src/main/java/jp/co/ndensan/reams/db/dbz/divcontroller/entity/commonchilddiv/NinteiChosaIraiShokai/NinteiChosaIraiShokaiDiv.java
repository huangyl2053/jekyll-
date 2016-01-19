package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIraiShokai.INinteiChosaIraiShokaiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaIraiShokai のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaIraiShokaiDiv extends Panel implements INinteiChosaIraiShokaiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoNinteiShinseisha")
    private KaigoNinteiShinseishaInfoDiv ccdKaigoNinteiShinseisha;
    @JsonProperty("dgNinteiChosaIrai")
    private DataGrid<dgNinteiChosaIrai_Row> dgNinteiChosaIrai;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKaigoNinteiShinseisha")
    public IKaigoNinteiShinseishaInfoDiv getCcdKaigoNinteiShinseisha() {
        return ccdKaigoNinteiShinseisha;
    }

    @JsonProperty("dgNinteiChosaIrai")
    public DataGrid<dgNinteiChosaIrai_Row> getDgNinteiChosaIrai() {
        return dgNinteiChosaIrai;
    }

    @JsonProperty("dgNinteiChosaIrai")
    public void setDgNinteiChosaIrai(DataGrid<dgNinteiChosaIrai_Row> dgNinteiChosaIrai) {
        this.dgNinteiChosaIrai = dgNinteiChosaIrai;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
