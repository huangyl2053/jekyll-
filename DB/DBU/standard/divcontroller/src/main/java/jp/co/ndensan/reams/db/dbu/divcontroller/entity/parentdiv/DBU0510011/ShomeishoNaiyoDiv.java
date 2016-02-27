package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShomeishoNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShomeishoNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiseiHaishibi")
    private TextBoxDate txtShiseiHaishibi;
    @JsonProperty("txtHogoFuyoKonshoGengakuKingaku")
    private TextBoxNum txtHogoFuyoKonshoGengakuKingaku;
    @JsonProperty("txtShomeishoKoufuDate")
    private TextBoxDate txtShomeishoKoufuDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShiseiHaishibi
     * @return txtShiseiHaishibi
     */
    @JsonProperty("txtShiseiHaishibi")
    public TextBoxDate getTxtShiseiHaishibi() {
        return txtShiseiHaishibi;
    }

    /*
     * settxtShiseiHaishibi
     * @param txtShiseiHaishibi txtShiseiHaishibi
     */
    @JsonProperty("txtShiseiHaishibi")
    public void setTxtShiseiHaishibi(TextBoxDate txtShiseiHaishibi) {
        this.txtShiseiHaishibi = txtShiseiHaishibi;
    }

    /*
     * gettxtHogoFuyoKonshoGengakuKingaku
     * @return txtHogoFuyoKonshoGengakuKingaku
     */
    @JsonProperty("txtHogoFuyoKonshoGengakuKingaku")
    public TextBoxNum getTxtHogoFuyoKonshoGengakuKingaku() {
        return txtHogoFuyoKonshoGengakuKingaku;
    }

    /*
     * settxtHogoFuyoKonshoGengakuKingaku
     * @param txtHogoFuyoKonshoGengakuKingaku txtHogoFuyoKonshoGengakuKingaku
     */
    @JsonProperty("txtHogoFuyoKonshoGengakuKingaku")
    public void setTxtHogoFuyoKonshoGengakuKingaku(TextBoxNum txtHogoFuyoKonshoGengakuKingaku) {
        this.txtHogoFuyoKonshoGengakuKingaku = txtHogoFuyoKonshoGengakuKingaku;
    }

    /*
     * gettxtShomeishoKoufuDate
     * @return txtShomeishoKoufuDate
     */
    @JsonProperty("txtShomeishoKoufuDate")
    public TextBoxDate getTxtShomeishoKoufuDate() {
        return txtShomeishoKoufuDate;
    }

    /*
     * settxtShomeishoKoufuDate
     * @param txtShomeishoKoufuDate txtShomeishoKoufuDate
     */
    @JsonProperty("txtShomeishoKoufuDate")
    public void setTxtShomeishoKoufuDate(TextBoxDate txtShomeishoKoufuDate) {
        this.txtShomeishoKoufuDate = txtShomeishoKoufuDate;
    }

    // </editor-fold>
}
