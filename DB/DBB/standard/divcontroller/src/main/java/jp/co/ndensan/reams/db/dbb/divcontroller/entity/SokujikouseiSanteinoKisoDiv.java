package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tblSanteinokisoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.tblSanteinokisoMaeDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujikouseiSanteinoKiso のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujikouseiSanteinoKisoDiv extends Panel {
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
    @JsonProperty("tblSanteinokisoMae")
    public tblSanteinokisoMaeDiv getTblSanteinokisoMae() {
        return tblSanteinokisoMae;
    }

    @JsonProperty("tblSanteinokisoMae")
    public void setTblSanteinokisoMae(tblSanteinokisoMaeDiv tblSanteinokisoMae) {
        this.tblSanteinokisoMae=tblSanteinokisoMae;
    }

    @JsonProperty("tblSanteinokisoAto")
    public tblSanteinokisoAtoDiv getTblSanteinokisoAto() {
        return tblSanteinokisoAto;
    }

    @JsonProperty("tblSanteinokisoAto")
    public void setTblSanteinokisoAto(tblSanteinokisoAtoDiv tblSanteinokisoAto) {
        this.tblSanteinokisoAto=tblSanteinokisoAto;
    }

}
