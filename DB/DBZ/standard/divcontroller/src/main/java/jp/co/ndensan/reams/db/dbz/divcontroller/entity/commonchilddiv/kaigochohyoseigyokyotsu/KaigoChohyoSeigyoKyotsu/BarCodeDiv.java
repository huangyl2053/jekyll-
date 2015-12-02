package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * BarCode のクラスファイル 
 * 
 * @author 自動生成
 */
public class BarCodeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlBarCodeUmu")
    private DropDownList ddlBarCodeUmu;
    @JsonProperty("ddlBarCodeHenshuHoho")
    private DropDownList ddlBarCodeHenshuHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlBarCodeUmu
     * @return ddlBarCodeUmu
     */
    @JsonProperty("ddlBarCodeUmu")
    public DropDownList getDdlBarCodeUmu() {
        return ddlBarCodeUmu;
    }

    /*
     * setddlBarCodeUmu
     * @param ddlBarCodeUmu ddlBarCodeUmu
     */
    @JsonProperty("ddlBarCodeUmu")
    public void setDdlBarCodeUmu(DropDownList ddlBarCodeUmu) {
        this.ddlBarCodeUmu = ddlBarCodeUmu;
    }

    /*
     * getddlBarCodeHenshuHoho
     * @return ddlBarCodeHenshuHoho
     */
    @JsonProperty("ddlBarCodeHenshuHoho")
    public DropDownList getDdlBarCodeHenshuHoho() {
        return ddlBarCodeHenshuHoho;
    }

    /*
     * setddlBarCodeHenshuHoho
     * @param ddlBarCodeHenshuHoho ddlBarCodeHenshuHoho
     */
    @JsonProperty("ddlBarCodeHenshuHoho")
    public void setDdlBarCodeHenshuHoho(DropDownList ddlBarCodeHenshuHoho) {
        this.ddlBarCodeHenshuHoho = ddlBarCodeHenshuHoho;
    }

    // </editor-fold>
}
