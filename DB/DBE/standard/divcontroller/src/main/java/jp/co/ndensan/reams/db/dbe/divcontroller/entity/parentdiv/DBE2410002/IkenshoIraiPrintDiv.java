package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IkenshoIraiPrint のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoIraiPrintDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnPrint")
    private ButtonDialog btnPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnPrint
     * @return btnPrint
     */
    @JsonProperty("btnPrint")
    public ButtonDialog getBtnPrint() {
        return btnPrint;
    }

    /*
     * setbtnPrint
     * @param btnPrint btnPrint
     */
    @JsonProperty("btnPrint")
    public void setBtnPrint(ButtonDialog btnPrint) {
        this.btnPrint = btnPrint;
    }

    // </editor-fold>
}
