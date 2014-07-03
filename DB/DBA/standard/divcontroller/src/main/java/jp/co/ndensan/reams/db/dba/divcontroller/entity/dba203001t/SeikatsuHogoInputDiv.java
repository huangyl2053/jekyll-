package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba203001t;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SeikatsuHogoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuHogoInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeikatsuHogoKaishiDate")
    private TextBoxFlexibleDate txtSeikatsuHogoKaishiDate;
    @JsonProperty("txtSeikatsuHogoHaishiDate")
    private TextBoxFlexibleDate txtSeikatsuHogoHaishiDate;
    @JsonProperty("txtSeikatsuHogoJukyushaNo")
    private TextBoxCode txtSeikatsuHogoJukyushaNo;
    @JsonProperty("ddlSeikatuHogoShubetsu")
    private DropDownList ddlSeikatuHogoShubetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSeikatsuHogoKaishiDate")
    public TextBoxFlexibleDate getTxtSeikatsuHogoKaishiDate() {
        return txtSeikatsuHogoKaishiDate;
    }

    @JsonProperty("txtSeikatsuHogoKaishiDate")
    public void setTxtSeikatsuHogoKaishiDate(TextBoxFlexibleDate txtSeikatsuHogoKaishiDate) {
        this.txtSeikatsuHogoKaishiDate=txtSeikatsuHogoKaishiDate;
    }

    @JsonProperty("txtSeikatsuHogoHaishiDate")
    public TextBoxFlexibleDate getTxtSeikatsuHogoHaishiDate() {
        return txtSeikatsuHogoHaishiDate;
    }

    @JsonProperty("txtSeikatsuHogoHaishiDate")
    public void setTxtSeikatsuHogoHaishiDate(TextBoxFlexibleDate txtSeikatsuHogoHaishiDate) {
        this.txtSeikatsuHogoHaishiDate=txtSeikatsuHogoHaishiDate;
    }

    @JsonProperty("txtSeikatsuHogoJukyushaNo")
    public TextBoxCode getTxtSeikatsuHogoJukyushaNo() {
        return txtSeikatsuHogoJukyushaNo;
    }

    @JsonProperty("txtSeikatsuHogoJukyushaNo")
    public void setTxtSeikatsuHogoJukyushaNo(TextBoxCode txtSeikatsuHogoJukyushaNo) {
        this.txtSeikatsuHogoJukyushaNo=txtSeikatsuHogoJukyushaNo;
    }

    @JsonProperty("ddlSeikatuHogoShubetsu")
    public DropDownList getDdlSeikatuHogoShubetsu() {
        return ddlSeikatuHogoShubetsu;
    }

    @JsonProperty("ddlSeikatuHogoShubetsu")
    public void setDdlSeikatuHogoShubetsu(DropDownList ddlSeikatuHogoShubetsu) {
        this.ddlSeikatuHogoShubetsu=ddlSeikatuHogoShubetsu;
    }

}
