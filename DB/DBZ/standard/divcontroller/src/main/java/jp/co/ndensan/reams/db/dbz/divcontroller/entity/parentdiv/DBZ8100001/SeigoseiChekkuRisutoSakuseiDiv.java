package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ8100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SeigoseiChekkuRisutoSakusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeigoseiChekkuRisutoSakuseiDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriKijyunbi")
    private TextBoxDate txtShoriKijyunbi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriKijyunbi
     * @return txtShoriKijyunbi
     */
    @JsonProperty("txtShoriKijyunbi")
    public TextBoxDate getTxtShoriKijyunbi() {
        return txtShoriKijyunbi;
    }

    /*
     * settxtShoriKijyunbi
     * @param txtShoriKijyunbi txtShoriKijyunbi
     */
    @JsonProperty("txtShoriKijyunbi")
    public void setTxtShoriKijyunbi(TextBoxDate txtShoriKijyunbi) {
        this.txtShoriKijyunbi = txtShoriKijyunbi;
    }

    // </editor-fold>
}
