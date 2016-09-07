package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NofuZumiKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class NofuZumiKikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNofuZumiKikan")
    private Label lblNofuZumiKikan;
    @JsonProperty("txtNofuZumiKikan")
    private TextBoxNum txtNofuZumiKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNofuZumiKikan
     * @return lblNofuZumiKikan
     */
    @JsonProperty("lblNofuZumiKikan")
    public Label getLblNofuZumiKikan() {
        return lblNofuZumiKikan;
    }

    /*
     * setlblNofuZumiKikan
     * @param lblNofuZumiKikan lblNofuZumiKikan
     */
    @JsonProperty("lblNofuZumiKikan")
    public void setLblNofuZumiKikan(Label lblNofuZumiKikan) {
        this.lblNofuZumiKikan = lblNofuZumiKikan;
    }

    /*
     * gettxtNofuZumiKikan
     * @return txtNofuZumiKikan
     */
    @JsonProperty("txtNofuZumiKikan")
    public TextBoxNum getTxtNofuZumiKikan() {
        return txtNofuZumiKikan;
    }

    /*
     * settxtNofuZumiKikan
     * @param txtNofuZumiKikan txtNofuZumiKikan
     */
    @JsonProperty("txtNofuZumiKikan")
    public void setTxtNofuZumiKikan(TextBoxNum txtNofuZumiKikan) {
        this.txtNofuZumiKikan = txtNofuZumiKikan;
    }

    // </editor-fold>
}
