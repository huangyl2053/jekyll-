package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuKaigoServiceHi のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuKaigoServiceHiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKogakuKaigoServiceHi")
    private RadioButton radKogakuKaigoServiceHi;
    @JsonProperty("txtKogakuKaigoServiceHiOther")
    private TextBox txtKogakuKaigoServiceHiOther;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKogakuKaigoServiceHi
     * @return radKogakuKaigoServiceHi
     */
    @JsonProperty("radKogakuKaigoServiceHi")
    public RadioButton getRadKogakuKaigoServiceHi() {
        return radKogakuKaigoServiceHi;
    }

    /*
     * setradKogakuKaigoServiceHi
     * @param radKogakuKaigoServiceHi radKogakuKaigoServiceHi
     */
    @JsonProperty("radKogakuKaigoServiceHi")
    public void setRadKogakuKaigoServiceHi(RadioButton radKogakuKaigoServiceHi) {
        this.radKogakuKaigoServiceHi = radKogakuKaigoServiceHi;
    }

    /*
     * gettxtKogakuKaigoServiceHiOther
     * @return txtKogakuKaigoServiceHiOther
     */
    @JsonProperty("txtKogakuKaigoServiceHiOther")
    public TextBox getTxtKogakuKaigoServiceHiOther() {
        return txtKogakuKaigoServiceHiOther;
    }

    /*
     * settxtKogakuKaigoServiceHiOther
     * @param txtKogakuKaigoServiceHiOther txtKogakuKaigoServiceHiOther
     */
    @JsonProperty("txtKogakuKaigoServiceHiOther")
    public void setTxtKogakuKaigoServiceHiOther(TextBox txtKogakuKaigoServiceHiOther) {
        this.txtKogakuKaigoServiceHiOther = txtKogakuKaigoServiceHiOther;
    }

    // </editor-fold>
}
