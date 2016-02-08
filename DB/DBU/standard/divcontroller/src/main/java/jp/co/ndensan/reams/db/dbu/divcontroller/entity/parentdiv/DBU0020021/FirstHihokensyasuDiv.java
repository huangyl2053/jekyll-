package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FirstHihokensyasu のクラスファイル 
 * 
 * @author 自動生成
 */
public class FirstHihokensyasuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplFirstHihokensyasu")
    private tplFirstHihokensyasuDiv tplFirstHihokensyasu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplFirstHihokensyasu
     * @return tplFirstHihokensyasu
     */
    @JsonProperty("tplFirstHihokensyasu")
    public tplFirstHihokensyasuDiv getTplFirstHihokensyasu() {
        return tplFirstHihokensyasu;
    }

    /*
     * settplFirstHihokensyasu
     * @param tplFirstHihokensyasu tplFirstHihokensyasu
     */
    @JsonProperty("tplFirstHihokensyasu")
    public void setTplFirstHihokensyasu(tplFirstHihokensyasuDiv tplFirstHihokensyasu) {
        this.tplFirstHihokensyasu = tplFirstHihokensyasu;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtZenGetsumatsugenzailrokugoijonanagomiman() {
        return this.getTplFirstHihokensyasu().getTxtZenGetsumatsugenzailrokugoijonanagomiman();
    }

    @JsonIgnore
    public TextBoxNum getTxtToGetsumatsugenzailrokugoijonanagomiman() {
        return this.getTplFirstHihokensyasu().getTxtToGetsumatsugenzailrokugoijonanagomiman();
    }

    @JsonIgnore
    public TextBoxNum getTxtZennGetsumatsugenzaiKoki() {
        return this.getTplFirstHihokensyasu().getTxtZennGetsumatsugenzaiKoki();
    }

    @JsonIgnore
    public TextBoxNum getTxtToGetsumatsugenzaiKoki() {
        return this.getTplFirstHihokensyasu().getTxtToGetsumatsugenzaiKoki();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenGetsumatsugenzaiGai() {
        return this.getTplFirstHihokensyasu().getTxtZenGetsumatsugenzaiGai();
    }

    @JsonIgnore
    public TextBoxNum getTxtToGetsumatsugenzaiGai() {
        return this.getTplFirstHihokensyasu().getTxtToGetsumatsugenzaiGai();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenGetsumatsugenzaiJusho() {
        return this.getTplFirstHihokensyasu().getTxtZenGetsumatsugenzaiJusho();
    }

    @JsonIgnore
    public TextBoxNum getTxtToGetsumatsugenzaiJusho() {
        return this.getTplFirstHihokensyasu().getTxtToGetsumatsugenzaiJusho();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenGetsumatsugenzaiKei() {
        return this.getTplFirstHihokensyasu().getTxtZenGetsumatsugenzaiKei();
    }

    @JsonIgnore
    public Label getLblSanko1() {
        return this.getTplFirstHihokensyasu().getLblSanko1();
    }

    @JsonIgnore
    public TextBoxNum getTxtSanko1() {
        return this.getTplFirstHihokensyasu().getTxtSanko1();
    }

    @JsonIgnore
    public Label getLblSanko2() {
        return this.getTplFirstHihokensyasu().getLblSanko2();
    }

    @JsonIgnore
    public TextBoxNum getTxtSanko2() {
        return this.getTplFirstHihokensyasu().getTxtSanko2();
    }

    @JsonIgnore
    public TextBoxNum getTxtToGetsumatsugenzaiKei() {
        return this.getTplFirstHihokensyasu().getTxtToGetsumatsugenzaiKei();
    }

    // </editor-fold>
}
