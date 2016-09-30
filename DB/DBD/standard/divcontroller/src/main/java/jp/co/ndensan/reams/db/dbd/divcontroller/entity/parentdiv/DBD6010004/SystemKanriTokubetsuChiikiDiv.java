package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SystemKanriTokubetsuChiiki のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriTokubetsuChiikiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKakuninNo")
    private RadioButton radKakuninNo;
    @JsonProperty("radSaiban")
    private RadioButton radSaiban;
    @JsonProperty("radNoHikitsugi")
    private RadioButton radNoHikitsugi;
    @JsonProperty("txtYukoKetasu")
    private TextBoxNum txtYukoKetasu;
    @JsonProperty("txtGengakuRitsu1")
    private TextBoxNum txtGengakuRitsu1;
    @JsonProperty("txtGengakuRitsu2")
    private TextBoxNum txtGengakuRitsu2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKakuninNo
     * @return radKakuninNo
     */
    @JsonProperty("radKakuninNo")
    public RadioButton getRadKakuninNo() {
        return radKakuninNo;
    }

    /*
     * setradKakuninNo
     * @param radKakuninNo radKakuninNo
     */
    @JsonProperty("radKakuninNo")
    public void setRadKakuninNo(RadioButton radKakuninNo) {
        this.radKakuninNo = radKakuninNo;
    }

    /*
     * getradSaiban
     * @return radSaiban
     */
    @JsonProperty("radSaiban")
    public RadioButton getRadSaiban() {
        return radSaiban;
    }

    /*
     * setradSaiban
     * @param radSaiban radSaiban
     */
    @JsonProperty("radSaiban")
    public void setRadSaiban(RadioButton radSaiban) {
        this.radSaiban = radSaiban;
    }

    /*
     * getradNoHikitsugi
     * @return radNoHikitsugi
     */
    @JsonProperty("radNoHikitsugi")
    public RadioButton getRadNoHikitsugi() {
        return radNoHikitsugi;
    }

    /*
     * setradNoHikitsugi
     * @param radNoHikitsugi radNoHikitsugi
     */
    @JsonProperty("radNoHikitsugi")
    public void setRadNoHikitsugi(RadioButton radNoHikitsugi) {
        this.radNoHikitsugi = radNoHikitsugi;
    }

    /*
     * gettxtYukoKetasu
     * @return txtYukoKetasu
     */
    @JsonProperty("txtYukoKetasu")
    public TextBoxNum getTxtYukoKetasu() {
        return txtYukoKetasu;
    }

    /*
     * settxtYukoKetasu
     * @param txtYukoKetasu txtYukoKetasu
     */
    @JsonProperty("txtYukoKetasu")
    public void setTxtYukoKetasu(TextBoxNum txtYukoKetasu) {
        this.txtYukoKetasu = txtYukoKetasu;
    }

    /*
     * gettxtGengakuRitsu1
     * @return txtGengakuRitsu1
     */
    @JsonProperty("txtGengakuRitsu1")
    public TextBoxNum getTxtGengakuRitsu1() {
        return txtGengakuRitsu1;
    }

    /*
     * settxtGengakuRitsu1
     * @param txtGengakuRitsu1 txtGengakuRitsu1
     */
    @JsonProperty("txtGengakuRitsu1")
    public void setTxtGengakuRitsu1(TextBoxNum txtGengakuRitsu1) {
        this.txtGengakuRitsu1 = txtGengakuRitsu1;
    }

    /*
     * gettxtGengakuRitsu2
     * @return txtGengakuRitsu2
     */
    @JsonProperty("txtGengakuRitsu2")
    public TextBoxNum getTxtGengakuRitsu2() {
        return txtGengakuRitsu2;
    }

    /*
     * settxtGengakuRitsu2
     * @param txtGengakuRitsu2 txtGengakuRitsu2
     */
    @JsonProperty("txtGengakuRitsu2")
    public void setTxtGengakuRitsu2(TextBoxNum txtGengakuRitsu2) {
        this.txtGengakuRitsu2 = txtGengakuRitsu2;
    }

    // </editor-fold>
}
