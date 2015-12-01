package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;
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
 * ConfigInfo4 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ConfigInfo4Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("BarCode")
    private BarCodeDiv BarCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getBarCode
     * @return BarCode
     */
    @JsonProperty("BarCode")
    public BarCodeDiv getBarCode() {
        return BarCode;
    }

    /*
     * setBarCode
     * @param BarCode BarCode
     */
    @JsonProperty("BarCode")
    public void setBarCode(BarCodeDiv BarCode) {
        this.BarCode = BarCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlBarCodeUmu() {
        return this.getBarCode().getDdlBarCodeUmu();
    }

    @JsonIgnore
    public void  setDdlBarCodeUmu(DropDownList ddlBarCodeUmu) {
        this.getBarCode().setDdlBarCodeUmu(ddlBarCodeUmu);
    }

    @JsonIgnore
    public DropDownList getDdlBarCodeHenshuHoho() {
        return this.getBarCode().getDdlBarCodeHenshuHoho();
    }

    @JsonIgnore
    public void  setDdlBarCodeHenshuHoho(DropDownList ddlBarCodeHenshuHoho) {
        this.getBarCode().setDdlBarCodeHenshuHoho(ddlBarCodeHenshuHoho);
    }

    // </editor-fold>
}
