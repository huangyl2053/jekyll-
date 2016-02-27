package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaKeisanShoriNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaKeisanShoriNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKakuteiFukaNendo")
    private TextBoxFlexibleYear txtKakuteiFukaNendo;
    @JsonProperty("txtFukaKeisanShoriNichiji")
    private TextBox txtFukaKeisanShoriNichiji;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKakuteiFukaNendo
     * @return txtKakuteiFukaNendo
     */
    @JsonProperty("txtKakuteiFukaNendo")
    public TextBoxFlexibleYear getTxtKakuteiFukaNendo() {
        return txtKakuteiFukaNendo;
    }

    /*
     * settxtKakuteiFukaNendo
     * @param txtKakuteiFukaNendo txtKakuteiFukaNendo
     */
    @JsonProperty("txtKakuteiFukaNendo")
    public void setTxtKakuteiFukaNendo(TextBoxFlexibleYear txtKakuteiFukaNendo) {
        this.txtKakuteiFukaNendo = txtKakuteiFukaNendo;
    }

    /*
     * gettxtFukaKeisanShoriNichiji
     * @return txtFukaKeisanShoriNichiji
     */
    @JsonProperty("txtFukaKeisanShoriNichiji")
    public TextBox getTxtFukaKeisanShoriNichiji() {
        return txtFukaKeisanShoriNichiji;
    }

    /*
     * settxtFukaKeisanShoriNichiji
     * @param txtFukaKeisanShoriNichiji txtFukaKeisanShoriNichiji
     */
    @JsonProperty("txtFukaKeisanShoriNichiji")
    public void setTxtFukaKeisanShoriNichiji(TextBox txtFukaKeisanShoriNichiji) {
        this.txtFukaKeisanShoriNichiji = txtFukaKeisanShoriNichiji;
    }

    // </editor-fold>
}
