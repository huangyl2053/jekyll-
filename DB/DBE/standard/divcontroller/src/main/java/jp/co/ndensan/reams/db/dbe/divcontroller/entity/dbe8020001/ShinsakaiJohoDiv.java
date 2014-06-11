package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
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
 * ShinsakaiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsakaiKaisaiNo")
    private TextBoxCode txtShinsakaiKaisaiNo;
    @JsonProperty("txtShinsakaiKaisaiYoteibi")
    private TextBoxDate txtShinsakaiKaisaiYoteibi;
    @JsonProperty("txtGogitai")
    private TextBox txtGogitai;
    @JsonProperty("txtShinsakaiKaishiYoteiJikan")
    private TextBoxTime txtShinsakaiKaishiYoteiJikan;
    @JsonProperty("chkSeishinkaiSonzaiKbn")
    private CheckBoxList chkSeishinkaiSonzaiKbn;
    @JsonProperty("txtShinsakaiKaisaiBasho")
    private TextBox txtShinsakaiKaisaiBasho;
    @JsonProperty("txtShinsakaiShuryoYoteiJikan")
    private TextBoxTime txtShinsakaiShuryoYoteiJikan;
    @JsonProperty("chkGogitaiDummyKbn")
    private CheckBoxList chkGogitaiDummyKbn;
    @JsonProperty("txtShinsakaiShiryoSakuseibi")
    private TextBoxDate txtShinsakaiShiryoSakuseibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsakaiKaisaiNo")
    public TextBoxCode getTxtShinsakaiKaisaiNo() {
        return txtShinsakaiKaisaiNo;
    }

    @JsonProperty("txtShinsakaiKaisaiNo")
    public void setTxtShinsakaiKaisaiNo(TextBoxCode txtShinsakaiKaisaiNo) {
        this.txtShinsakaiKaisaiNo=txtShinsakaiKaisaiNo;
    }

    @JsonProperty("txtShinsakaiKaisaiYoteibi")
    public TextBoxDate getTxtShinsakaiKaisaiYoteibi() {
        return txtShinsakaiKaisaiYoteibi;
    }

    @JsonProperty("txtShinsakaiKaisaiYoteibi")
    public void setTxtShinsakaiKaisaiYoteibi(TextBoxDate txtShinsakaiKaisaiYoteibi) {
        this.txtShinsakaiKaisaiYoteibi=txtShinsakaiKaisaiYoteibi;
    }

    @JsonProperty("txtGogitai")
    public TextBox getTxtGogitai() {
        return txtGogitai;
    }

    @JsonProperty("txtGogitai")
    public void setTxtGogitai(TextBox txtGogitai) {
        this.txtGogitai=txtGogitai;
    }

    @JsonProperty("txtShinsakaiKaishiYoteiJikan")
    public TextBoxTime getTxtShinsakaiKaishiYoteiJikan() {
        return txtShinsakaiKaishiYoteiJikan;
    }

    @JsonProperty("txtShinsakaiKaishiYoteiJikan")
    public void setTxtShinsakaiKaishiYoteiJikan(TextBoxTime txtShinsakaiKaishiYoteiJikan) {
        this.txtShinsakaiKaishiYoteiJikan=txtShinsakaiKaishiYoteiJikan;
    }

    @JsonProperty("chkSeishinkaiSonzaiKbn")
    public CheckBoxList getChkSeishinkaiSonzaiKbn() {
        return chkSeishinkaiSonzaiKbn;
    }

    @JsonProperty("chkSeishinkaiSonzaiKbn")
    public void setChkSeishinkaiSonzaiKbn(CheckBoxList chkSeishinkaiSonzaiKbn) {
        this.chkSeishinkaiSonzaiKbn=chkSeishinkaiSonzaiKbn;
    }

    @JsonProperty("txtShinsakaiKaisaiBasho")
    public TextBox getTxtShinsakaiKaisaiBasho() {
        return txtShinsakaiKaisaiBasho;
    }

    @JsonProperty("txtShinsakaiKaisaiBasho")
    public void setTxtShinsakaiKaisaiBasho(TextBox txtShinsakaiKaisaiBasho) {
        this.txtShinsakaiKaisaiBasho=txtShinsakaiKaisaiBasho;
    }

    @JsonProperty("txtShinsakaiShuryoYoteiJikan")
    public TextBoxTime getTxtShinsakaiShuryoYoteiJikan() {
        return txtShinsakaiShuryoYoteiJikan;
    }

    @JsonProperty("txtShinsakaiShuryoYoteiJikan")
    public void setTxtShinsakaiShuryoYoteiJikan(TextBoxTime txtShinsakaiShuryoYoteiJikan) {
        this.txtShinsakaiShuryoYoteiJikan=txtShinsakaiShuryoYoteiJikan;
    }

    @JsonProperty("chkGogitaiDummyKbn")
    public CheckBoxList getChkGogitaiDummyKbn() {
        return chkGogitaiDummyKbn;
    }

    @JsonProperty("chkGogitaiDummyKbn")
    public void setChkGogitaiDummyKbn(CheckBoxList chkGogitaiDummyKbn) {
        this.chkGogitaiDummyKbn=chkGogitaiDummyKbn;
    }

    @JsonProperty("txtShinsakaiShiryoSakuseibi")
    public TextBoxDate getTxtShinsakaiShiryoSakuseibi() {
        return txtShinsakaiShiryoSakuseibi;
    }

    @JsonProperty("txtShinsakaiShiryoSakuseibi")
    public void setTxtShinsakaiShiryoSakuseibi(TextBoxDate txtShinsakaiShiryoSakuseibi) {
        this.txtShinsakaiShiryoSakuseibi=txtShinsakaiShiryoSakuseibi;
    }

}
