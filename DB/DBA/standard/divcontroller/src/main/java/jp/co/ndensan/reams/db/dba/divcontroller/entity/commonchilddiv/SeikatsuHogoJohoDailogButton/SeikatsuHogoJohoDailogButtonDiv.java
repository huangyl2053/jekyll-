package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoDailogButton;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatsuHogoJohoDailogButton のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuHogoJohoDailogButtonDiv extends Panel implements ISeikatsuHogoJohoDailogButtonDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-16_09-04-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSeikatsuHogoJoho")
    private ButtonDialog btnSeikatsuHogoJoho;
    @JsonProperty("gyomuCode")
    private RString gyomuCode;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSeikatsuHogoJoho
     * @return btnSeikatsuHogoJoho
     */
    @JsonProperty("btnSeikatsuHogoJoho")
    public ButtonDialog getBtnSeikatsuHogoJoho() {
        return btnSeikatsuHogoJoho;
    }

    /*
     * setbtnSeikatsuHogoJoho
     * @param btnSeikatsuHogoJoho btnSeikatsuHogoJoho
     */
    @JsonProperty("btnSeikatsuHogoJoho")
    public void setBtnSeikatsuHogoJoho(ButtonDialog btnSeikatsuHogoJoho) {
        this.btnSeikatsuHogoJoho = btnSeikatsuHogoJoho;
    }

    /*
     * getgyomuCode
     * @return gyomuCode
     */
    @JsonProperty("gyomuCode")
    public RString getGyomuCode() {
        return gyomuCode;
    }

    /*
     * setgyomuCode
     * @param gyomuCode gyomuCode
     */
    @JsonProperty("gyomuCode")
    public void setGyomuCode(RString gyomuCode) {
        this.gyomuCode = gyomuCode;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

    @Override
    public void initialize(RString shikibetsuCode, RString gyomuCode) {
        this.shikibetsuCode = shikibetsuCode;
        this.gyomuCode = gyomuCode;
    }

}
