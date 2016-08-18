package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoikiHeddaJoho2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoikiHeddaJoho2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTaishoFuairu")
    private TextBox txtTaishoFuairu;
    @JsonProperty("txtShoriJotai")
    private TextBox txtShoriJotai;
    @JsonProperty("txtShoriNichiji")
    private TextBox txtShoriNichiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTaishoFuairu
     * @return txtTaishoFuairu
     */
    @JsonProperty("txtTaishoFuairu")
    public TextBox getTxtTaishoFuairu() {
        return txtTaishoFuairu;
    }

    /*
     * settxtTaishoFuairu
     * @param txtTaishoFuairu txtTaishoFuairu
     */
    @JsonProperty("txtTaishoFuairu")
    public void setTxtTaishoFuairu(TextBox txtTaishoFuairu) {
        this.txtTaishoFuairu = txtTaishoFuairu;
    }

    /*
     * gettxtShoriJotai
     * @return txtShoriJotai
     */
    @JsonProperty("txtShoriJotai")
    public TextBox getTxtShoriJotai() {
        return txtShoriJotai;
    }

    /*
     * settxtShoriJotai
     * @param txtShoriJotai txtShoriJotai
     */
    @JsonProperty("txtShoriJotai")
    public void setTxtShoriJotai(TextBox txtShoriJotai) {
        this.txtShoriJotai = txtShoriJotai;
    }

    /*
     * gettxtShoriNichiji
     * @return txtShoriNichiji
     */
    @JsonProperty("txtShoriNichiji")
    public TextBox getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    /*
     * settxtShoriNichiji
     * @param txtShoriNichiji txtShoriNichiji
     */
    @JsonProperty("txtShoriNichiji")
    public void setTxtShoriNichiji(TextBox txtShoriNichiji) {
        this.txtShoriNichiji = txtShoriNichiji;
    }

    // </editor-fold>
}
