package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GokeiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class GokeiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSanteiKijunGaku")
    private TextBoxNum txtSanteiKijunGaku;
    @JsonProperty("txtSiharaiZumiGaku")
    private TextBoxNum txtSiharaiZumiGaku;
    @JsonProperty("txtKogakuShikyuGaku")
    private TextBoxNum txtKogakuShikyuGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSanteiKijunGaku
     * @return txtSanteiKijunGaku
     */
    @JsonProperty("txtSanteiKijunGaku")
    public TextBoxNum getTxtSanteiKijunGaku() {
        return txtSanteiKijunGaku;
    }

    /*
     * settxtSanteiKijunGaku
     * @param txtSanteiKijunGaku txtSanteiKijunGaku
     */
    @JsonProperty("txtSanteiKijunGaku")
    public void setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.txtSanteiKijunGaku = txtSanteiKijunGaku;
    }

    /*
     * gettxtSiharaiZumiGaku
     * @return txtSiharaiZumiGaku
     */
    @JsonProperty("txtSiharaiZumiGaku")
    public TextBoxNum getTxtSiharaiZumiGaku() {
        return txtSiharaiZumiGaku;
    }

    /*
     * settxtSiharaiZumiGaku
     * @param txtSiharaiZumiGaku txtSiharaiZumiGaku
     */
    @JsonProperty("txtSiharaiZumiGaku")
    public void setTxtSiharaiZumiGaku(TextBoxNum txtSiharaiZumiGaku) {
        this.txtSiharaiZumiGaku = txtSiharaiZumiGaku;
    }

    /*
     * gettxtKogakuShikyuGaku
     * @return txtKogakuShikyuGaku
     */
    @JsonProperty("txtKogakuShikyuGaku")
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return txtKogakuShikyuGaku;
    }

    /*
     * settxtKogakuShikyuGaku
     * @param txtKogakuShikyuGaku txtKogakuShikyuGaku
     */
    @JsonProperty("txtKogakuShikyuGaku")
    public void setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.txtKogakuShikyuGaku = txtKogakuShikyuGaku;
    }

    // </editor-fold>
}
