package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KetteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiYMD")
    private TextBoxFlexibleDate txtKetteiYMD;
    @JsonProperty("txtKetteiRiyu")
    private TextBoxMultiLine txtKetteiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * gettxtKetteiRiyu
     * @return txtKetteiRiyu
     */
    @JsonProperty("txtKetteiRiyu")
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return txtKetteiRiyu;
    }

    /*
     * settxtKetteiRiyu
     * @param txtKetteiRiyu txtKetteiRiyu
     */
    @JsonProperty("txtKetteiRiyu")
    public void setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.txtKetteiRiyu = txtKetteiRiyu;
    }

    // </editor-fold>
}
