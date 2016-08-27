package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600051;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelRoureiHukuNenkinJukyuushaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelRoureiHukuNenkinJukyuushaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRoureiJyukyuKaishibi")
    private TextBox txtRoureiJyukyuKaishibi;
    @JsonProperty("txtRoureiJukyuuHaishibi")
    private TextBox txtRoureiJukyuuHaishibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtRoureiJyukyuKaishibi
     * @return txtRoureiJyukyuKaishibi
     */
    @JsonProperty("txtRoureiJyukyuKaishibi")
    public TextBox getTxtRoureiJyukyuKaishibi() {
        return txtRoureiJyukyuKaishibi;
    }

    /*
     * settxtRoureiJyukyuKaishibi
     * @param txtRoureiJyukyuKaishibi txtRoureiJyukyuKaishibi
     */
    @JsonProperty("txtRoureiJyukyuKaishibi")
    public void setTxtRoureiJyukyuKaishibi(TextBox txtRoureiJyukyuKaishibi) {
        this.txtRoureiJyukyuKaishibi = txtRoureiJyukyuKaishibi;
    }

    /*
     * gettxtRoureiJukyuuHaishibi
     * @return txtRoureiJukyuuHaishibi
     */
    @JsonProperty("txtRoureiJukyuuHaishibi")
    public TextBox getTxtRoureiJukyuuHaishibi() {
        return txtRoureiJukyuuHaishibi;
    }

    /*
     * settxtRoureiJukyuuHaishibi
     * @param txtRoureiJukyuuHaishibi txtRoureiJukyuuHaishibi
     */
    @JsonProperty("txtRoureiJukyuuHaishibi")
    public void setTxtRoureiJukyuuHaishibi(TextBox txtRoureiJukyuuHaishibi) {
        this.txtRoureiJukyuuHaishibi = txtRoureiJukyuuHaishibi;
    }

    // </editor-fold>
}
