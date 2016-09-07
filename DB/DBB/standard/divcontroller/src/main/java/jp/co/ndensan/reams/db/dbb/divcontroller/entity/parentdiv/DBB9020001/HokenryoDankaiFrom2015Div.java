package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * HokenryoDankaiFrom2015 のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class HokenryoDankaiFrom2015Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDankaihyokiNinisettei")
    private RadioButton radDankaihyokiNinisettei;
    @JsonProperty("dgHokenryoDankai")
    private DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradDankaihyokiNinisettei
     * @return radDankaihyokiNinisettei
     */
    @JsonProperty("radDankaihyokiNinisettei")
    public RadioButton getRadDankaihyokiNinisettei() {
        return radDankaihyokiNinisettei;
    }

    /*
     * setradDankaihyokiNinisettei
     * @param radDankaihyokiNinisettei radDankaihyokiNinisettei
     */
    @JsonProperty("radDankaihyokiNinisettei")
    public void setRadDankaihyokiNinisettei(RadioButton radDankaihyokiNinisettei) {
        this.radDankaihyokiNinisettei = radDankaihyokiNinisettei;
    }

    /*
     * getdgHokenryoDankai
     * @return dgHokenryoDankai
     */
    @JsonProperty("dgHokenryoDankai")
    public DataGrid<dgHokenryoDankai_Row> getDgHokenryoDankai() {
        return dgHokenryoDankai;
    }

    /*
     * setdgHokenryoDankai
     * @param dgHokenryoDankai dgHokenryoDankai
     */
    @JsonProperty("dgHokenryoDankai")
    public void setDgHokenryoDankai(DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai) {
        this.dgHokenryoDankai = dgHokenryoDankai;
    }

    // </editor-fold>
}
