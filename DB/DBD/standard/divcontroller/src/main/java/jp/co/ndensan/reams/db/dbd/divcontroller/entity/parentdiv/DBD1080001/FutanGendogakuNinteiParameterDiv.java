package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutanGendogakuNinteiParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiParameterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKyushochishaKubun1")
    private DropDownList ddlKyushochishaKubun1;
    @JsonProperty("radShisetsuNyushoKubun1")
    private RadioButton radShisetsuNyushoKubun1;
    @JsonProperty("ddlRiyoshaFutanDankai")
    private DropDownList ddlRiyoshaFutanDankai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKyushochishaKubun1
     * @return ddlKyushochishaKubun1
     */
    @JsonProperty("ddlKyushochishaKubun1")
    public DropDownList getDdlKyushochishaKubun1() {
        return ddlKyushochishaKubun1;
    }

    /*
     * setddlKyushochishaKubun1
     * @param ddlKyushochishaKubun1 ddlKyushochishaKubun1
     */
    @JsonProperty("ddlKyushochishaKubun1")
    public void setDdlKyushochishaKubun1(DropDownList ddlKyushochishaKubun1) {
        this.ddlKyushochishaKubun1 = ddlKyushochishaKubun1;
    }

    /*
     * getradShisetsuNyushoKubun1
     * @return radShisetsuNyushoKubun1
     */
    @JsonProperty("radShisetsuNyushoKubun1")
    public RadioButton getRadShisetsuNyushoKubun1() {
        return radShisetsuNyushoKubun1;
    }

    /*
     * setradShisetsuNyushoKubun1
     * @param radShisetsuNyushoKubun1 radShisetsuNyushoKubun1
     */
    @JsonProperty("radShisetsuNyushoKubun1")
    public void setRadShisetsuNyushoKubun1(RadioButton radShisetsuNyushoKubun1) {
        this.radShisetsuNyushoKubun1 = radShisetsuNyushoKubun1;
    }

    /*
     * getddlRiyoshaFutanDankai
     * @return ddlRiyoshaFutanDankai
     */
    @JsonProperty("ddlRiyoshaFutanDankai")
    public DropDownList getDdlRiyoshaFutanDankai() {
        return ddlRiyoshaFutanDankai;
    }

    /*
     * setddlRiyoshaFutanDankai
     * @param ddlRiyoshaFutanDankai ddlRiyoshaFutanDankai
     */
    @JsonProperty("ddlRiyoshaFutanDankai")
    public void setDdlRiyoshaFutanDankai(DropDownList ddlRiyoshaFutanDankai) {
        this.ddlRiyoshaFutanDankai = ddlRiyoshaFutanDankai;
    }

    // </editor-fold>
}
