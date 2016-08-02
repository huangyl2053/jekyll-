package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SasitomeKaijo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SasitomeKaijoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShokaiSashitomeKaijoYMD")
    private TextBoxFlexibleDate txtShokaiSashitomeKaijoYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShokaiSashitomeKaijoYMD
     * @return txtShokaiSashitomeKaijoYMD
     */
    @JsonProperty("txtShokaiSashitomeKaijoYMD")
    public TextBoxFlexibleDate getTxtShokaiSashitomeKaijoYMD() {
        return txtShokaiSashitomeKaijoYMD;
    }

    /*
     * settxtShokaiSashitomeKaijoYMD
     * @param txtShokaiSashitomeKaijoYMD txtShokaiSashitomeKaijoYMD
     */
    @JsonProperty("txtShokaiSashitomeKaijoYMD")
    public void setTxtShokaiSashitomeKaijoYMD(TextBoxFlexibleDate txtShokaiSashitomeKaijoYMD) {
        this.txtShokaiSashitomeKaijoYMD = txtShokaiSashitomeKaijoYMD;
    }

    // </editor-fold>
}
