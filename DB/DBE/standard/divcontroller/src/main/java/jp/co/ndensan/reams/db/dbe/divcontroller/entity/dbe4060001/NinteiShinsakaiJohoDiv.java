package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiShinsakaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinsakaiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiYoteibi")
    private TextBoxDate txtShinsakaiYoteibi;
    @JsonProperty("txtGogitaiNo")
    private TextBoxCode txtGogitaiNo;
    @JsonProperty("txtGogitaiMeisho")
    private TextBox txtGogitaiMeisho;
    @JsonProperty("txtKaishiYoteiJikan")
    private TextBoxTime txtKaishiYoteiJikan;
    @JsonProperty("txtSaidaiTeiin")
    private TextBoxNum txtSaidaiTeiin;
    @JsonProperty("chkDummyKbn")
    private CheckBoxList chkDummyKbn;
    @JsonProperty("txtKaisaiBasho")
    private TextBox txtKaisaiBasho;
    @JsonProperty("txtShuryoYoteiJikan")
    private TextBoxTime txtShuryoYoteiJikan;
    @JsonProperty("txtYoteiTeiin")
    private TextBoxNum txtYoteiTeiin;
    @JsonProperty("chkKyukaiKbn")
    private CheckBoxList chkKyukaiKbn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiYoteibi")
    public TextBoxDate getTxtShinsakaiYoteibi() {
        return txtShinsakaiYoteibi;
    }

    @JsonProperty("txtShinsakaiYoteibi")
    public void setTxtShinsakaiYoteibi(TextBoxDate txtShinsakaiYoteibi) {
        this.txtShinsakaiYoteibi=txtShinsakaiYoteibi;
    }

    @JsonProperty("txtGogitaiNo")
    public TextBoxCode getTxtGogitaiNo() {
        return txtGogitaiNo;
    }

    @JsonProperty("txtGogitaiNo")
    public void setTxtGogitaiNo(TextBoxCode txtGogitaiNo) {
        this.txtGogitaiNo=txtGogitaiNo;
    }

    @JsonProperty("txtGogitaiMeisho")
    public TextBox getTxtGogitaiMeisho() {
        return txtGogitaiMeisho;
    }

    @JsonProperty("txtGogitaiMeisho")
    public void setTxtGogitaiMeisho(TextBox txtGogitaiMeisho) {
        this.txtGogitaiMeisho=txtGogitaiMeisho;
    }

    @JsonProperty("txtKaishiYoteiJikan")
    public TextBoxTime getTxtKaishiYoteiJikan() {
        return txtKaishiYoteiJikan;
    }

    @JsonProperty("txtKaishiYoteiJikan")
    public void setTxtKaishiYoteiJikan(TextBoxTime txtKaishiYoteiJikan) {
        this.txtKaishiYoteiJikan=txtKaishiYoteiJikan;
    }

    @JsonProperty("txtSaidaiTeiin")
    public TextBoxNum getTxtSaidaiTeiin() {
        return txtSaidaiTeiin;
    }

    @JsonProperty("txtSaidaiTeiin")
    public void setTxtSaidaiTeiin(TextBoxNum txtSaidaiTeiin) {
        this.txtSaidaiTeiin=txtSaidaiTeiin;
    }

    @JsonProperty("chkDummyKbn")
    public CheckBoxList getChkDummyKbn() {
        return chkDummyKbn;
    }

    @JsonProperty("chkDummyKbn")
    public void setChkDummyKbn(CheckBoxList chkDummyKbn) {
        this.chkDummyKbn=chkDummyKbn;
    }

    @JsonProperty("txtKaisaiBasho")
    public TextBox getTxtKaisaiBasho() {
        return txtKaisaiBasho;
    }

    @JsonProperty("txtKaisaiBasho")
    public void setTxtKaisaiBasho(TextBox txtKaisaiBasho) {
        this.txtKaisaiBasho=txtKaisaiBasho;
    }

    @JsonProperty("txtShuryoYoteiJikan")
    public TextBoxTime getTxtShuryoYoteiJikan() {
        return txtShuryoYoteiJikan;
    }

    @JsonProperty("txtShuryoYoteiJikan")
    public void setTxtShuryoYoteiJikan(TextBoxTime txtShuryoYoteiJikan) {
        this.txtShuryoYoteiJikan=txtShuryoYoteiJikan;
    }

    @JsonProperty("txtYoteiTeiin")
    public TextBoxNum getTxtYoteiTeiin() {
        return txtYoteiTeiin;
    }

    @JsonProperty("txtYoteiTeiin")
    public void setTxtYoteiTeiin(TextBoxNum txtYoteiTeiin) {
        this.txtYoteiTeiin=txtYoteiTeiin;
    }

    @JsonProperty("chkKyukaiKbn")
    public CheckBoxList getChkKyukaiKbn() {
        return chkKyukaiKbn;
    }

    @JsonProperty("chkKyukaiKbn")
    public void setChkKyukaiKbn(CheckBoxList chkKyukaiKbn) {
        this.chkKyukaiKbn=chkKyukaiKbn;
    }

}
