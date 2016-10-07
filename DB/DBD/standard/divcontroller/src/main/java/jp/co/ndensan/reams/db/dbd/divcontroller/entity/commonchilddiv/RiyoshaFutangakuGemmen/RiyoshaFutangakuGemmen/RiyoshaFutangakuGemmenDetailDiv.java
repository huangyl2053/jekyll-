package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutangakuGemmenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutangakuGemmenDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("RiyoshaFutangakuGemmenRiyoshaFutan")
    private RiyoshaFutangakuGemmenRiyoshaFutanDiv RiyoshaFutangakuGemmenRiyoshaFutan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * getRiyoshaFutangakuGemmenRiyoshaFutan
     * @return RiyoshaFutangakuGemmenRiyoshaFutan
     */
    @JsonProperty("RiyoshaFutangakuGemmenRiyoshaFutan")
    public RiyoshaFutangakuGemmenRiyoshaFutanDiv getRiyoshaFutangakuGemmenRiyoshaFutan() {
        return RiyoshaFutangakuGemmenRiyoshaFutan;
    }

    /*
     * setRiyoshaFutangakuGemmenRiyoshaFutan
     * @param RiyoshaFutangakuGemmenRiyoshaFutan RiyoshaFutangakuGemmenRiyoshaFutan
     */
    @JsonProperty("RiyoshaFutangakuGemmenRiyoshaFutan")
    public void setRiyoshaFutangakuGemmenRiyoshaFutan(RiyoshaFutangakuGemmenRiyoshaFutanDiv RiyoshaFutangakuGemmenRiyoshaFutan) {
        this.RiyoshaFutangakuGemmenRiyoshaFutan = RiyoshaFutangakuGemmenRiyoshaFutan;
    }

    // </editor-fold>
}
