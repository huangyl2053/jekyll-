package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuGaikyoChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuGaikyoChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJutakuKaishu")
    private RadioButton radJutakuKaishu;
    @JsonProperty("dgRiyoServiceJyokyo")
    private DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJutakuKaishu
     * @return radJutakuKaishu
     */
    @JsonProperty("radJutakuKaishu")
    public RadioButton getRadJutakuKaishu() {
        return radJutakuKaishu;
    }

    /*
     * setradJutakuKaishu
     * @param radJutakuKaishu radJutakuKaishu
     */
    @JsonProperty("radJutakuKaishu")
    public void setRadJutakuKaishu(RadioButton radJutakuKaishu) {
        this.radJutakuKaishu = radJutakuKaishu;
    }

    /*
     * getdgRiyoServiceJyokyo
     * @return dgRiyoServiceJyokyo
     */
    @JsonProperty("dgRiyoServiceJyokyo")
    public DataGrid<dgRiyoServiceJyokyo_Row> getDgRiyoServiceJyokyo() {
        return dgRiyoServiceJyokyo;
    }

    /*
     * setdgRiyoServiceJyokyo
     * @param dgRiyoServiceJyokyo dgRiyoServiceJyokyo
     */
    @JsonProperty("dgRiyoServiceJyokyo")
    public void setDgRiyoServiceJyokyo(DataGrid<dgRiyoServiceJyokyo_Row> dgRiyoServiceJyokyo) {
        this.dgRiyoServiceJyokyo = dgRiyoServiceJyokyo;
    }

    // </editor-fold>
}
