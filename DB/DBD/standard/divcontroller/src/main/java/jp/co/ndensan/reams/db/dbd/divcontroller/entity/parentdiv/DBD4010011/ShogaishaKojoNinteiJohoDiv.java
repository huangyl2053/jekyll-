package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoNinteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoNinteiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TaishoNendo")
    private TextBoxDate TaishoNendo;
    @JsonProperty("SinseiNengabi")
    private TextBoxDate SinseiNengabi;
    @JsonProperty("KeteiNengabi")
    private TextBoxDate KeteiNengabi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTaishoNendo
     * @return TaishoNendo
     */
    @JsonProperty("TaishoNendo")
    public TextBoxDate getTaishoNendo() {
        return TaishoNendo;
    }

    /*
     * setTaishoNendo
     * @param TaishoNendo TaishoNendo
     */
    @JsonProperty("TaishoNendo")
    public void setTaishoNendo(TextBoxDate TaishoNendo) {
        this.TaishoNendo = TaishoNendo;
    }

    /*
     * getSinseiNengabi
     * @return SinseiNengabi
     */
    @JsonProperty("SinseiNengabi")
    public TextBoxDate getSinseiNengabi() {
        return SinseiNengabi;
    }

    /*
     * setSinseiNengabi
     * @param SinseiNengabi SinseiNengabi
     */
    @JsonProperty("SinseiNengabi")
    public void setSinseiNengabi(TextBoxDate SinseiNengabi) {
        this.SinseiNengabi = SinseiNengabi;
    }

    /*
     * getKeteiNengabi
     * @return KeteiNengabi
     */
    @JsonProperty("KeteiNengabi")
    public TextBoxDate getKeteiNengabi() {
        return KeteiNengabi;
    }

    /*
     * setKeteiNengabi
     * @param KeteiNengabi KeteiNengabi
     */
    @JsonProperty("KeteiNengabi")
    public void setKeteiNengabi(TextBoxDate KeteiNengabi) {
        this.KeteiNengabi = KeteiNengabi;
    }

    // </editor-fold>
}
