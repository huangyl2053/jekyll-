package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tblhokenkyufushiharai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblhokenkyufushiharaiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblhokenkyufushiharaijokyo")
    private tblhokenkyufushiharaijokyoDiv tblhokenkyufushiharaijokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblhokenkyufushiharaijokyo
     * @return tblhokenkyufushiharaijokyo
     */
    @JsonProperty("tblhokenkyufushiharaijokyo")
    public tblhokenkyufushiharaijokyoDiv getTblhokenkyufushiharaijokyo() {
        return tblhokenkyufushiharaijokyo;
    }

    /*
     * settblhokenkyufushiharaijokyo
     * @param tblhokenkyufushiharaijokyo tblhokenkyufushiharaijokyo
     */
    @JsonProperty("tblhokenkyufushiharaijokyo")
    public void setTblhokenkyufushiharaijokyo(tblhokenkyufushiharaijokyoDiv tblhokenkyufushiharaijokyo) {
        this.tblhokenkyufushiharaijokyo = tblhokenkyufushiharaijokyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblgubun() {
        return this.getTblhokenkyufushiharaijokyo().getLblgubun();
    }

    @JsonIgnore
    public Label getLblShiharaigi() {
        return this.getTblhokenkyufushiharaijokyo().getLblShiharaigi();
    }

    @JsonIgnore
    public Label getLblShiharaizu() {
        return this.getTblhokenkyufushiharaijokyo().getLblShiharaizu();
    }

    @JsonIgnore
    public Label getLblchoshu() {
        return this.getTblhokenkyufushiharaijokyo().getLblchoshu();
    }

    @JsonIgnore
    public Label getLblreinyu() {
        return this.getTblhokenkyufushiharaijokyo().getLblreinyu();
    }

    @JsonIgnore
    public Label getLblmishiharaigaku() {
        return this.getTblhokenkyufushiharaijokyo().getLblmishiharaigaku();
    }

    @JsonIgnore
    public Label getLblkaigoSer() {
        return this.getTblhokenkyufushiharaijokyo().getLblkaigoSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi1() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi1();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu1() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu1() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu1() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu1();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku1() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku1();
    }

    @JsonIgnore
    public Label getLblkaigoyoboSer() {
        return this.getTblhokenkyufushiharaijokyo().getLblkaigoyoboSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi2() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi2();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu2() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu2() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu2() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu2();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku2() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku2();
    }

    @JsonIgnore
    public Label getLblkogakukaigoSer() {
        return this.getTblhokenkyufushiharaijokyo().getLblkogakukaigoSer();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi3() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi3();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu3() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu3() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu3() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu3();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku3() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku3();
    }

    @JsonIgnore
    public Label getLblkogakuiryo() {
        return this.getTblhokenkyufushiharaijokyo().getLblkogakuiryo();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi4() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi4();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu4() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu4() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu4() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu4();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku4() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku4();
    }

    @JsonIgnore
    public Label getLbltokuteinyusho() {
        return this.getTblhokenkyufushiharaijokyo().getLbltokuteinyusho();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi5() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi5();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu5() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu5() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu5() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu5();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku5() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku5();
    }

    @JsonIgnore
    public Label getLblsonota() {
        return this.getTblhokenkyufushiharaijokyo().getLblsonota();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi6() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi6();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu6() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu6() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu6() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu6();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku6() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku6();
    }

    @JsonIgnore
    public Label getLblkeii() {
        return this.getTblhokenkyufushiharaijokyo().getLblkeii();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaigi7() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaigi7();
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaizu7() {
        return this.getTblhokenkyufushiharaijokyo().getTxtShiharaizu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtChoshu7() {
        return this.getTblhokenkyufushiharaijokyo().getTxtChoshu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtReinyu7() {
        return this.getTblhokenkyufushiharaijokyo().getTxtReinyu7();
    }

    @JsonIgnore
    public TextBoxNum getTxtlmishiharaigaku7() {
        return this.getTblhokenkyufushiharaijokyo().getTxtlmishiharaigaku7();
    }

    // </editor-fold>
}
