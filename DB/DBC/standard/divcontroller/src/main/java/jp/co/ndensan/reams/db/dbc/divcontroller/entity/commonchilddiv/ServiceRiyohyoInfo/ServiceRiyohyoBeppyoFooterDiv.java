package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceRiyohyoBeppyoFooter のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoBeppyoFooterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnBackRiyoNengetsuIchiran")
    private Button btnBackRiyoNengetsuIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnUpdate
     * @return btnUpdate
     */
    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    /*
     * setbtnUpdate
     * @param btnUpdate btnUpdate
     */
    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    /*
     * getbtnBackRiyoNengetsuIchiran
     * @return btnBackRiyoNengetsuIchiran
     */
    @JsonProperty("btnBackRiyoNengetsuIchiran")
    public Button getBtnBackRiyoNengetsuIchiran() {
        return btnBackRiyoNengetsuIchiran;
    }

    /*
     * setbtnBackRiyoNengetsuIchiran
     * @param btnBackRiyoNengetsuIchiran btnBackRiyoNengetsuIchiran
     */
    @JsonProperty("btnBackRiyoNengetsuIchiran")
    public void setBtnBackRiyoNengetsuIchiran(Button btnBackRiyoNengetsuIchiran) {
        this.btnBackRiyoNengetsuIchiran = btnBackRiyoNengetsuIchiran;
    }

    // </editor-fold>
}
