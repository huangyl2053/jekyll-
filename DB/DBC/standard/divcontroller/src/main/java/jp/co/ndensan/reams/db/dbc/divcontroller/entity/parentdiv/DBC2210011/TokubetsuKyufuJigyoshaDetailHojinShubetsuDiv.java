package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuJigyoshaDetailHojinShubetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaDetailHojinShubetsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("spc02")
    private Space spc02;
    @JsonProperty("ddlHojinShubetsu")
    private DropDownList ddlHojinShubetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getspc02
     * @return spc02
     */
    @JsonProperty("spc02")
    public Space getSpc02() {
        return spc02;
    }

    /*
     * setspc02
     * @param spc02 spc02
     */
    @JsonProperty("spc02")
    public void setSpc02(Space spc02) {
        this.spc02 = spc02;
    }

    /*
     * getddlHojinShubetsu
     * @return ddlHojinShubetsu
     */
    @JsonProperty("ddlHojinShubetsu")
    public DropDownList getDdlHojinShubetsu() {
        return ddlHojinShubetsu;
    }

    /*
     * setddlHojinShubetsu
     * @param ddlHojinShubetsu ddlHojinShubetsu
     */
    @JsonProperty("ddlHojinShubetsu")
    public void setDdlHojinShubetsu(DropDownList ddlHojinShubetsu) {
        this.ddlHojinShubetsu = ddlHojinShubetsu;
    }

    // </editor-fold>
}
