package jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinshinIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NichijoJiritsudo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NichijoJiritsudoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShogaiKoreishaNichijoSeikatsuJiritsudo")
    private RadioButton radShogaiKoreishaNichijoSeikatsuJiritsudo;
    @JsonProperty("radNinchishoKoreishaJiritsu")
    private RadioButton radNinchishoKoreishaJiritsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShogaiKoreishaNichijoSeikatsuJiritsudo")
    public RadioButton getRadShogaiKoreishaNichijoSeikatsuJiritsudo() {
        return radShogaiKoreishaNichijoSeikatsuJiritsudo;
    }

    @JsonProperty("radShogaiKoreishaNichijoSeikatsuJiritsudo")
    public void setRadShogaiKoreishaNichijoSeikatsuJiritsudo(RadioButton radShogaiKoreishaNichijoSeikatsuJiritsudo) {
        this.radShogaiKoreishaNichijoSeikatsuJiritsudo=radShogaiKoreishaNichijoSeikatsuJiritsudo;
    }

    @JsonProperty("radNinchishoKoreishaJiritsu")
    public RadioButton getRadNinchishoKoreishaJiritsu() {
        return radNinchishoKoreishaJiritsu;
    }

    @JsonProperty("radNinchishoKoreishaJiritsu")
    public void setRadNinchishoKoreishaJiritsu(RadioButton radNinchishoKoreishaJiritsu) {
        this.radNinchishoKoreishaJiritsu=radNinchishoKoreishaJiritsu;
    }

    // </editor-fold>
}
