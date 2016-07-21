package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SonotaJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class SonotaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdGeninShikkan")
    private CodeInputDiv ccdGeninShikkan;
    @JsonProperty("txtShinseiKeikaNissu")
    private TextBoxNumRange txtShinseiKeikaNissu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdGeninShikkan
     * @return ccdGeninShikkan
     */
    @JsonProperty("ccdGeninShikkan")
    public ICodeInputDiv getCcdGeninShikkan() {
        return ccdGeninShikkan;
    }

    /*
     * gettxtShinseiKeikaNissu
     * @return txtShinseiKeikaNissu
     */
    @JsonProperty("txtShinseiKeikaNissu")
    public TextBoxNumRange getTxtShinseiKeikaNissu() {
        return txtShinseiKeikaNissu;
    }

    /*
     * settxtShinseiKeikaNissu
     * @param txtShinseiKeikaNissu txtShinseiKeikaNissu
     */
    @JsonProperty("txtShinseiKeikaNissu")
    public void setTxtShinseiKeikaNissu(TextBoxNumRange txtShinseiKeikaNissu) {
        this.txtShinseiKeikaNissu = txtShinseiKeikaNissu;
    }

    // </editor-fold>
}
