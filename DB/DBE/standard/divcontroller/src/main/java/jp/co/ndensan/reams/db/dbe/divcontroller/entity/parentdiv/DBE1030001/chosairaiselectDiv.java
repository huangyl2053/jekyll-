package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * chosairaiselect のクラスファイル 
 * 
 * @author 自動生成
 */
public class chosairaiselectDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-10_12-10-23">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Dataoutput")
    private ButtonDownLoad Dataoutput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDataoutput
     * @return Dataoutput
     */
    @JsonProperty("Dataoutput")
    public ButtonDownLoad getDataoutput() {
        return Dataoutput;
    }

    /*
     * setDataoutput
     * @param Dataoutput Dataoutput
     */
    @JsonProperty("Dataoutput")
    public void setDataoutput(ButtonDownLoad Dataoutput) {
        this.Dataoutput = Dataoutput;
    }

    // </editor-fold>
}
