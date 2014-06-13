package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * KaigoShikakuKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoShikakuKihonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShutokuYmd")
    private TextBoxDate txtShutokuYmd;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtJutokuTekiyo")
    private TextBoxDate txtJutokuTekiyo;
    @JsonProperty("txtYokaigoJotaiKubun")
    private TextBox txtYokaigoJotaiKubun;
    @JsonProperty("txtKyuSochiNyusho")
    private TextBox txtKyuSochiNyusho;
    @JsonProperty("btnHihoRireki")
    private ButtonDialog btnHihoRireki;
    @JsonProperty("txtShikakuJotai")
    private TextBox txtShikakuJotai;
    @JsonProperty("txtSoshitsuYmd")
    private TextBoxDate txtSoshitsuYmd;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("txtJutokuKaijo")
    private TextBoxDate txtJutokuKaijo;
    @JsonProperty("btnNinteiRireki")
    private ButtonDialog btnNinteiRireki;
    @JsonProperty("txtNinteiKikan")
    private TextBoxDateRange txtNinteiKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtShutokuYmd")
    public TextBoxDate getTxtShutokuYmd() {
        return txtShutokuYmd;
    }

    @JsonProperty("txtShutokuYmd")
    public void setTxtShutokuYmd(TextBoxDate txtShutokuYmd) {
        this.txtShutokuYmd=txtShutokuYmd;
    }

    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu=txtShutokuJiyu;
    }

    @JsonProperty("txtJutokuTekiyo")
    public TextBoxDate getTxtJutokuTekiyo() {
        return txtJutokuTekiyo;
    }

    @JsonProperty("txtJutokuTekiyo")
    public void setTxtJutokuTekiyo(TextBoxDate txtJutokuTekiyo) {
        this.txtJutokuTekiyo=txtJutokuTekiyo;
    }

    @JsonProperty("txtYokaigoJotaiKubun")
    public TextBox getTxtYokaigoJotaiKubun() {
        return txtYokaigoJotaiKubun;
    }

    @JsonProperty("txtYokaigoJotaiKubun")
    public void setTxtYokaigoJotaiKubun(TextBox txtYokaigoJotaiKubun) {
        this.txtYokaigoJotaiKubun=txtYokaigoJotaiKubun;
    }

    @JsonProperty("txtKyuSochiNyusho")
    public TextBox getTxtKyuSochiNyusho() {
        return txtKyuSochiNyusho;
    }

    @JsonProperty("txtKyuSochiNyusho")
    public void setTxtKyuSochiNyusho(TextBox txtKyuSochiNyusho) {
        this.txtKyuSochiNyusho=txtKyuSochiNyusho;
    }

    @JsonProperty("btnHihoRireki")
    public ButtonDialog getBtnHihoRireki() {
        return btnHihoRireki;
    }

    @JsonProperty("btnHihoRireki")
    public void setBtnHihoRireki(ButtonDialog btnHihoRireki) {
        this.btnHihoRireki=btnHihoRireki;
    }

    @JsonProperty("txtShikakuJotai")
    public TextBox getTxtShikakuJotai() {
        return txtShikakuJotai;
    }

    @JsonProperty("txtShikakuJotai")
    public void setTxtShikakuJotai(TextBox txtShikakuJotai) {
        this.txtShikakuJotai=txtShikakuJotai;
    }

    @JsonProperty("txtSoshitsuYmd")
    public TextBoxDate getTxtSoshitsuYmd() {
        return txtSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuYmd")
    public void setTxtSoshitsuYmd(TextBoxDate txtSoshitsuYmd) {
        this.txtSoshitsuYmd=txtSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu=txtSoshitsuJiyu;
    }

    @JsonProperty("txtJutokuKaijo")
    public TextBoxDate getTxtJutokuKaijo() {
        return txtJutokuKaijo;
    }

    @JsonProperty("txtJutokuKaijo")
    public void setTxtJutokuKaijo(TextBoxDate txtJutokuKaijo) {
        this.txtJutokuKaijo=txtJutokuKaijo;
    }

    @JsonProperty("btnNinteiRireki")
    public ButtonDialog getBtnNinteiRireki() {
        return btnNinteiRireki;
    }

    @JsonProperty("btnNinteiRireki")
    public void setBtnNinteiRireki(ButtonDialog btnNinteiRireki) {
        this.btnNinteiRireki=btnNinteiRireki;
    }

    @JsonProperty("txtNinteiKikan")
    public TextBoxDateRange getTxtNinteiKikan() {
        return txtNinteiKikan;
    }

    @JsonProperty("txtNinteiKikan")
    public void setTxtNinteiKikan(TextBoxDateRange txtNinteiKikan) {
        this.txtNinteiKikan=txtNinteiKikan;
    }

}
