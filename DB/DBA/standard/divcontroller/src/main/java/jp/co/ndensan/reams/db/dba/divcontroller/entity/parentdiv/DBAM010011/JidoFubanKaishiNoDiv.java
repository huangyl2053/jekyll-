package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBAM010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JidoFubanKaishiNo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JidoFubanKaishiNoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("spaceJidoFuban")
    private Space spaceJidoFuban;
    @JsonProperty("txtJidoFubanKaishiNo")
    private TextBoxCode txtJidoFubanKaishiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getspaceJidoFuban
     * @return spaceJidoFuban
     */
    @JsonProperty("spaceJidoFuban")
    public Space getSpaceJidoFuban() {
        return spaceJidoFuban;
    }

    /*
     * setspaceJidoFuban
     * @param spaceJidoFuban spaceJidoFuban
     */
    @JsonProperty("spaceJidoFuban")
    public void setSpaceJidoFuban(Space spaceJidoFuban) {
        this.spaceJidoFuban = spaceJidoFuban;
    }

    /*
     * gettxtJidoFubanKaishiNo
     * @return txtJidoFubanKaishiNo
     */
    @JsonProperty("txtJidoFubanKaishiNo")
    public TextBoxCode getTxtJidoFubanKaishiNo() {
        return txtJidoFubanKaishiNo;
    }

    /*
     * settxtJidoFubanKaishiNo
     * @param txtJidoFubanKaishiNo txtJidoFubanKaishiNo
     */
    @JsonProperty("txtJidoFubanKaishiNo")
    public void setTxtJidoFubanKaishiNo(TextBoxCode txtJidoFubanKaishiNo) {
        this.txtJidoFubanKaishiNo = txtJidoFubanKaishiNo;
    }

    // </editor-fold>
}
