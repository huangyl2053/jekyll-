package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoFutangakuHoseiSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuHoseiSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKakuninJouhouUketoriYM")
    private TextBoxDate txtKakuninJouhouUketoriYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKakuninJouhouUketoriYM
     * @return txtKakuninJouhouUketoriYM
     */
    @JsonProperty("txtKakuninJouhouUketoriYM")
    public TextBoxDate getTxtKakuninJouhouUketoriYM() {
        return txtKakuninJouhouUketoriYM;
    }

    /*
     * settxtKakuninJouhouUketoriYM
     * @param txtKakuninJouhouUketoriYM txtKakuninJouhouUketoriYM
     */
    @JsonProperty("txtKakuninJouhouUketoriYM")
    public void setTxtKakuninJouhouUketoriYM(TextBoxDate txtKakuninJouhouUketoriYM) {
        this.txtKakuninJouhouUketoriYM = txtKakuninJouhouUketoriYM;
    }

    // </editor-fold>
}
