package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaIdoRenrakuhyoRojinHoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoRojinHokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RokenShichosonNo")
    private TextBoxCode RokenShichosonNo;
    @JsonProperty("RokenJukyushaNo")
    private TextBoxCode RokenJukyushaNo;
    @JsonProperty("RokenKohiFutanshaNo")
    private TextBoxCode RokenKohiFutanshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRokenShichosonNo
     * @return RokenShichosonNo
     */
    @JsonProperty("RokenShichosonNo")
    public TextBoxCode getRokenShichosonNo() {
        return RokenShichosonNo;
    }

    /*
     * setRokenShichosonNo
     * @param RokenShichosonNo RokenShichosonNo
     */
    @JsonProperty("RokenShichosonNo")
    public void setRokenShichosonNo(TextBoxCode RokenShichosonNo) {
        this.RokenShichosonNo = RokenShichosonNo;
    }

    /*
     * getRokenJukyushaNo
     * @return RokenJukyushaNo
     */
    @JsonProperty("RokenJukyushaNo")
    public TextBoxCode getRokenJukyushaNo() {
        return RokenJukyushaNo;
    }

    /*
     * setRokenJukyushaNo
     * @param RokenJukyushaNo RokenJukyushaNo
     */
    @JsonProperty("RokenJukyushaNo")
    public void setRokenJukyushaNo(TextBoxCode RokenJukyushaNo) {
        this.RokenJukyushaNo = RokenJukyushaNo;
    }

    /*
     * getRokenKohiFutanshaNo
     * @return RokenKohiFutanshaNo
     */
    @JsonProperty("RokenKohiFutanshaNo")
    public TextBoxCode getRokenKohiFutanshaNo() {
        return RokenKohiFutanshaNo;
    }

    /*
     * setRokenKohiFutanshaNo
     * @param RokenKohiFutanshaNo RokenKohiFutanshaNo
     */
    @JsonProperty("RokenKohiFutanshaNo")
    public void setRokenKohiFutanshaNo(TextBoxCode RokenKohiFutanshaNo) {
        this.RokenKohiFutanshaNo = RokenKohiFutanshaNo;
    }

    // </editor-fold>
}
