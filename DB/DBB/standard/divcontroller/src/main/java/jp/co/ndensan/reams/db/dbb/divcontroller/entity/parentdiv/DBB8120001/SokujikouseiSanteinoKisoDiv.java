package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujikouseiSanteinoKiso のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujikouseiSanteinoKisoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblSanteinokisoMae")
    private tblSanteinokisoMaeDiv tblSanteinokisoMae;
    @JsonProperty("tblSanteinokisoAto")
    private tblSanteinokisoAtoDiv tblSanteinokisoAto;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblSanteinokisoMae
     * @return tblSanteinokisoMae
     */
    @JsonProperty("tblSanteinokisoMae")
    public tblSanteinokisoMaeDiv getTblSanteinokisoMae() {
        return tblSanteinokisoMae;
    }

    /*
     * settblSanteinokisoMae
     * @param tblSanteinokisoMae tblSanteinokisoMae
     */
    @JsonProperty("tblSanteinokisoMae")
    public void setTblSanteinokisoMae(tblSanteinokisoMaeDiv tblSanteinokisoMae) {
        this.tblSanteinokisoMae = tblSanteinokisoMae;
    }

    /*
     * gettblSanteinokisoAto
     * @return tblSanteinokisoAto
     */
    @JsonProperty("tblSanteinokisoAto")
    public tblSanteinokisoAtoDiv getTblSanteinokisoAto() {
        return tblSanteinokisoAto;
    }

    /*
     * settblSanteinokisoAto
     * @param tblSanteinokisoAto tblSanteinokisoAto
     */
    @JsonProperty("tblSanteinokisoAto")
    public void setTblSanteinokisoAto(tblSanteinokisoAtoDiv tblSanteinokisoAto) {
        this.tblSanteinokisoAto = tblSanteinokisoAto;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblSanteinoKisoMae1() {
        return this.getTblSanteinokisoMae().getLblSanteinoKisoMae1();
    }

    @JsonIgnore
    public Label getLblKikanMae() {
        return this.getTblSanteinokisoMae().getLblKikanMae();
    }

    @JsonIgnore
    public Label getLblTsukisuMae() {
        return this.getTblSanteinokisoMae().getLblTsukisuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiMae() {
        return this.getTblSanteinokisoMae().getLblHokenryoDankaiMae();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuMae() {
        return this.getTblSanteinokisoMae().getLblHokenryoritsuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuMae() {
        return this.getTblSanteinokisoMae().getLblHokenryoSanshutsuGakuMae();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuMae() {
        return this.getTblSanteinokisoMae().getLblHokenryoGakuMae();
    }

    @JsonIgnore
    public Label getLblKikanMae1() {
        return this.getTblSanteinokisoMae().getLblKikanMae1();
    }

    @JsonIgnore
    public Label getLblTsukisuMae1() {
        return this.getTblSanteinokisoMae().getLblTsukisuMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiMae1() {
        return this.getTblSanteinokisoMae().getLblHokenryoDankaiMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuMae1() {
        return this.getTblSanteinokisoMae().getLblHokenryoritsuMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuMae1() {
        return this.getTblSanteinokisoMae().getLblHokenryoSanshutsuGakuMae1();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuMae1() {
        return this.getTblSanteinokisoMae().getLblHokenryoGakuMae1();
    }

    @JsonIgnore
    public Label getLblKikanMae2() {
        return this.getTblSanteinokisoMae().getLblKikanMae2();
    }

    @JsonIgnore
    public Label getLblTsukisuMae2() {
        return this.getTblSanteinokisoMae().getLblTsukisuMae2();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiMae2() {
        return this.getTblSanteinokisoMae().getLblHokenryoDankaiMae2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuMae2() {
        return this.getTblSanteinokisoMae().getLblHokenryoritsuMae2();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuMae2() {
        return this.getTblSanteinokisoMae().getLblHokenryoSanshutsuGakuMae2();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuMae2() {
        return this.getTblSanteinokisoMae().getLblHokenryoGakuMae2();
    }

    @JsonIgnore
    public Label getLblSanteinoKisoAto() {
        return this.getTblSanteinokisoAto().getLblSanteinoKisoAto();
    }

    @JsonIgnore
    public Label getLblKikanAto() {
        return this.getTblSanteinokisoAto().getLblKikanAto();
    }

    @JsonIgnore
    public Label getLblTsukisuAto() {
        return this.getTblSanteinokisoAto().getLblTsukisuAto();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiAto() {
        return this.getTblSanteinokisoAto().getLblHokenryoDankaiAto();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuAto() {
        return this.getTblSanteinokisoAto().getLblHokenryoritsuAto();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuAto() {
        return this.getTblSanteinokisoAto().getLblHokenryoSanshutsuGakuAto();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuAto() {
        return this.getTblSanteinokisoAto().getLblHokenryoGakuAto();
    }

    @JsonIgnore
    public Label getLblKikanAto1() {
        return this.getTblSanteinokisoAto().getLblKikanAto1();
    }

    @JsonIgnore
    public Label getLblTsukisuAto1() {
        return this.getTblSanteinokisoAto().getLblTsukisuAto1();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiAto1() {
        return this.getTblSanteinokisoAto().getLblHokenryoDankaiAto1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuAto1() {
        return this.getTblSanteinokisoAto().getLblHokenryoritsuAto1();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuAto1() {
        return this.getTblSanteinokisoAto().getLblHokenryoSanshutsuGakuAto1();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuAto1() {
        return this.getTblSanteinokisoAto().getLblHokenryoGakuAto1();
    }

    @JsonIgnore
    public Label getLblKikanAto2() {
        return this.getTblSanteinokisoAto().getLblKikanAto2();
    }

    @JsonIgnore
    public Label getLblTsukisuAto2() {
        return this.getTblSanteinokisoAto().getLblTsukisuAto2();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiAto2() {
        return this.getTblSanteinokisoAto().getLblHokenryoDankaiAto2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsuAto2() {
        return this.getTblSanteinokisoAto().getLblHokenryoritsuAto2();
    }

    @JsonIgnore
    public Label getLblHokenryoSanshutsuGakuAto2() {
        return this.getTblSanteinokisoAto().getLblHokenryoSanshutsuGakuAto2();
    }

    @JsonIgnore
    public Label getLblHokenryoGakuAto2() {
        return this.getTblSanteinokisoAto().getLblHokenryoGakuAto2();
    }

    // </editor-fold>
}
