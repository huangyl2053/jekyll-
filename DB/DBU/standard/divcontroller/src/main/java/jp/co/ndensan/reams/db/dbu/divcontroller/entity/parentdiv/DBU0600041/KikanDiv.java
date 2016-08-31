package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041;
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
 * Kikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class KikanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKikan1")
    private tblKikan1Div tblKikan1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblKikan1
     * @return tblKikan1
     */
    @JsonProperty("tblKikan1")
    public tblKikan1Div getTblKikan1() {
        return tblKikan1;
    }

    /*
     * settblKikan1
     * @param tblKikan1 tblKikan1
     */
    @JsonProperty("tblKikan1")
    public void setTblKikan1(tblKikan1Div tblKikan1) {
        this.tblKikan1 = tblKikan1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKikan() {
        return this.getTblKikan1().getLblKikan();
    }

    @JsonIgnore
    public Label getLblTsukiSu() {
        return this.getTblKikan1().getLblTsukiSu();
    }

    @JsonIgnore
    public Label getLblShotokuDankai() {
        return this.getTblKikan1().getLblShotokuDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu() {
        return this.getTblKikan1().getLblHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu() {
        return this.getTblKikan1().getLblHokenryoSansyutsu();
    }

    @JsonIgnore
    public Label getLblKikan1() {
        return this.getTblKikan1().getLblKikan1();
    }

    @JsonIgnore
    public Label getLblTsukiSu1() {
        return this.getTblKikan1().getLblTsukiSu1();
    }

    @JsonIgnore
    public Label getLblShotokuDankai1() {
        return this.getTblKikan1().getLblShotokuDankai1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu1() {
        return this.getTblKikan1().getLblHokenryoritsu1();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu1() {
        return this.getTblKikan1().getLblHokenryoSansyutsu1();
    }

    @JsonIgnore
    public Label getLblKikan2() {
        return this.getTblKikan1().getLblKikan2();
    }

    @JsonIgnore
    public Label getLblTsukiSu2() {
        return this.getTblKikan1().getLblTsukiSu2();
    }

    @JsonIgnore
    public Label getLblShotokuDankai2() {
        return this.getTblKikan1().getLblShotokuDankai2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu2() {
        return this.getTblKikan1().getLblHokenryoritsu2();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu2() {
        return this.getTblKikan1().getLblHokenryoSansyutsu2();
    }

    // </editor-fold>
}
