package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiJuminKyokaiKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiJuminSogoJigyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiJumin のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiJuminDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnJuminSeiho")
    private Button btnJuminSeiho;
    @JsonProperty("btnJuminRofuku")
    private Button btnJuminRofuku;
    @JsonProperty("btnJuminKorei")
    private Button btnJuminKorei;
    @JsonProperty("btnJuminKokuho")
    private Button btnJuminKokuho;
    @JsonProperty("SogoShokaiJuminKyokaiKanri")
    private SogoShokaiJuminKyokaiKanriDiv SogoShokaiJuminKyokaiKanri;
    @JsonProperty("SogoShokaiJuminSogoJigyo")
    private SogoShokaiJuminSogoJigyoDiv SogoShokaiJuminSogoJigyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnJuminSeiho")
    public Button getBtnJuminSeiho() {
        return btnJuminSeiho;
    }

    @JsonProperty("btnJuminSeiho")
    public void setBtnJuminSeiho(Button btnJuminSeiho) {
        this.btnJuminSeiho=btnJuminSeiho;
    }

    @JsonProperty("btnJuminRofuku")
    public Button getBtnJuminRofuku() {
        return btnJuminRofuku;
    }

    @JsonProperty("btnJuminRofuku")
    public void setBtnJuminRofuku(Button btnJuminRofuku) {
        this.btnJuminRofuku=btnJuminRofuku;
    }

    @JsonProperty("btnJuminKorei")
    public Button getBtnJuminKorei() {
        return btnJuminKorei;
    }

    @JsonProperty("btnJuminKorei")
    public void setBtnJuminKorei(Button btnJuminKorei) {
        this.btnJuminKorei=btnJuminKorei;
    }

    @JsonProperty("btnJuminKokuho")
    public Button getBtnJuminKokuho() {
        return btnJuminKokuho;
    }

    @JsonProperty("btnJuminKokuho")
    public void setBtnJuminKokuho(Button btnJuminKokuho) {
        this.btnJuminKokuho=btnJuminKokuho;
    }

    @JsonProperty("SogoShokaiJuminKyokaiKanri")
    public SogoShokaiJuminKyokaiKanriDiv getSogoShokaiJuminKyokaiKanri() {
        return SogoShokaiJuminKyokaiKanri;
    }

    @JsonProperty("SogoShokaiJuminKyokaiKanri")
    public void setSogoShokaiJuminKyokaiKanri(SogoShokaiJuminKyokaiKanriDiv SogoShokaiJuminKyokaiKanri) {
        this.SogoShokaiJuminKyokaiKanri=SogoShokaiJuminKyokaiKanri;
    }

    @JsonProperty("SogoShokaiJuminSogoJigyo")
    public SogoShokaiJuminSogoJigyoDiv getSogoShokaiJuminSogoJigyo() {
        return SogoShokaiJuminSogoJigyo;
    }

    @JsonProperty("SogoShokaiJuminSogoJigyo")
    public void setSogoShokaiJuminSogoJigyo(SogoShokaiJuminSogoJigyoDiv SogoShokaiJuminSogoJigyo) {
        this.SogoShokaiJuminSogoJigyo=SogoShokaiJuminSogoJigyo;
    }

}
