package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaIraiTaishoIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaIraiTaishoIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteiChosaIraiTaishoIchiran")
    private DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> dgNinteiChosaIraiTaishoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgNinteiChosaIraiTaishoIchiran
     * @return dgNinteiChosaIraiTaishoIchiran
     */
    @JsonProperty("dgNinteiChosaIraiTaishoIchiran")
    public DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> getDgNinteiChosaIraiTaishoIchiran() {
        return dgNinteiChosaIraiTaishoIchiran;
    }

    /*
     * setdgNinteiChosaIraiTaishoIchiran
     * @param dgNinteiChosaIraiTaishoIchiran dgNinteiChosaIraiTaishoIchiran
     */
    @JsonProperty("dgNinteiChosaIraiTaishoIchiran")
    public void setDgNinteiChosaIraiTaishoIchiran(DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> dgNinteiChosaIraiTaishoIchiran) {
        this.dgNinteiChosaIraiTaishoIchiran = dgNinteiChosaIraiTaishoIchiran;
    }

    // </editor-fold>
}
