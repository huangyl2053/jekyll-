package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkShogaiKoreishaNichijoSeikatsuJiritsudo")
    private CheckBoxList chkShogaiKoreishaNichijoSeikatsuJiritsudo;
    @JsonProperty("chkNinchishoKoreishaJiritsu")
    private CheckBoxList chkNinchishoKoreishaJiritsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkShogaiKoreishaNichijoSeikatsuJiritsudo")
    public CheckBoxList getChkShogaiKoreishaNichijoSeikatsuJiritsudo() {
        return chkShogaiKoreishaNichijoSeikatsuJiritsudo;
    }

    @JsonProperty("chkShogaiKoreishaNichijoSeikatsuJiritsudo")
    public void setChkShogaiKoreishaNichijoSeikatsuJiritsudo(CheckBoxList chkShogaiKoreishaNichijoSeikatsuJiritsudo) {
        this.chkShogaiKoreishaNichijoSeikatsuJiritsudo=chkShogaiKoreishaNichijoSeikatsuJiritsudo;
    }

    @JsonProperty("chkNinchishoKoreishaJiritsu")
    public CheckBoxList getChkNinchishoKoreishaJiritsu() {
        return chkNinchishoKoreishaJiritsu;
    }

    @JsonProperty("chkNinchishoKoreishaJiritsu")
    public void setChkNinchishoKoreishaJiritsu(CheckBoxList chkNinchishoKoreishaJiritsu) {
        this.chkNinchishoKoreishaJiritsu=chkNinchishoKoreishaJiritsu;
    }

    // </editor-fold>
}
