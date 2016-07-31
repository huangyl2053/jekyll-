package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikatuhogoJukyushaHizukeChushutsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatuhogoJukyushaHizukeChushutsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeikatuhogoJukyushaYohaku")
    private Space SeikatuhogoJukyushaYohaku;
    @JsonProperty("texSeikatuhogoKijunDate")
    private TextBoxDate texSeikatuhogoKijunDate;
    @JsonProperty("radSeikatuhogoHani")
    private RadioButton radSeikatuhogoHani;
    @JsonProperty("texSeikatuhogoDateHani")
    private TextBoxDateRange texSeikatuhogoDateHani;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSeikatuhogoJukyushaYohaku
     * @return SeikatuhogoJukyushaYohaku
     */
    @JsonProperty("SeikatuhogoJukyushaYohaku")
    public Space getSeikatuhogoJukyushaYohaku() {
        return SeikatuhogoJukyushaYohaku;
    }

    /*
     * setSeikatuhogoJukyushaYohaku
     * @param SeikatuhogoJukyushaYohaku SeikatuhogoJukyushaYohaku
     */
    @JsonProperty("SeikatuhogoJukyushaYohaku")
    public void setSeikatuhogoJukyushaYohaku(Space SeikatuhogoJukyushaYohaku) {
        this.SeikatuhogoJukyushaYohaku = SeikatuhogoJukyushaYohaku;
    }

    /*
     * gettexSeikatuhogoKijunDate
     * @return texSeikatuhogoKijunDate
     */
    @JsonProperty("texSeikatuhogoKijunDate")
    public TextBoxDate getTexSeikatuhogoKijunDate() {
        return texSeikatuhogoKijunDate;
    }

    /*
     * settexSeikatuhogoKijunDate
     * @param texSeikatuhogoKijunDate texSeikatuhogoKijunDate
     */
    @JsonProperty("texSeikatuhogoKijunDate")
    public void setTexSeikatuhogoKijunDate(TextBoxDate texSeikatuhogoKijunDate) {
        this.texSeikatuhogoKijunDate = texSeikatuhogoKijunDate;
    }

    /*
     * getradSeikatuhogoHani
     * @return radSeikatuhogoHani
     */
    @JsonProperty("radSeikatuhogoHani")
    public RadioButton getRadSeikatuhogoHani() {
        return radSeikatuhogoHani;
    }

    /*
     * setradSeikatuhogoHani
     * @param radSeikatuhogoHani radSeikatuhogoHani
     */
    @JsonProperty("radSeikatuhogoHani")
    public void setRadSeikatuhogoHani(RadioButton radSeikatuhogoHani) {
        this.radSeikatuhogoHani = radSeikatuhogoHani;
    }

    /*
     * gettexSeikatuhogoDateHani
     * @return texSeikatuhogoDateHani
     */
    @JsonProperty("texSeikatuhogoDateHani")
    public TextBoxDateRange getTexSeikatuhogoDateHani() {
        return texSeikatuhogoDateHani;
    }

    /*
     * settexSeikatuhogoDateHani
     * @param texSeikatuhogoDateHani texSeikatuhogoDateHani
     */
    @JsonProperty("texSeikatuhogoDateHani")
    public void setTexSeikatuhogoDateHani(TextBoxDateRange texSeikatuhogoDateHani) {
        this.texSeikatuhogoDateHani = texSeikatuhogoDateHani;
    }

    // </editor-fold>
}
