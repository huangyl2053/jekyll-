package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaigoHihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaigoNinteiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NyuryokuSeigyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiShinsaKekkaNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinsaKekkaNyuryokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaJoho")
    private KaigoHihokenshaJohoDiv HihokenshaJoho;
    @JsonProperty("NinteiKekkaNyuryoku")
    private KaigoNinteiKekkaDiv NinteiKekkaNyuryoku;
    @JsonProperty("NyuryokuSeigyo")
    private NyuryokuSeigyoDiv NyuryokuSeigyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaJoho")
    public KaigoHihokenshaJohoDiv getHihokenshaJoho() {
        return HihokenshaJoho;
    }

    @JsonProperty("HihokenshaJoho")
    public void setHihokenshaJoho(KaigoHihokenshaJohoDiv HihokenshaJoho) {
        this.HihokenshaJoho=HihokenshaJoho;
    }

    @JsonProperty("NinteiKekkaNyuryoku")
    public KaigoNinteiKekkaDiv getNinteiKekkaNyuryoku() {
        return NinteiKekkaNyuryoku;
    }

    @JsonProperty("NinteiKekkaNyuryoku")
    public void setNinteiKekkaNyuryoku(KaigoNinteiKekkaDiv NinteiKekkaNyuryoku) {
        this.NinteiKekkaNyuryoku=NinteiKekkaNyuryoku;
    }

    @JsonProperty("NyuryokuSeigyo")
    public NyuryokuSeigyoDiv getNyuryokuSeigyo() {
        return NyuryokuSeigyo;
    }

    @JsonProperty("NyuryokuSeigyo")
    public void setNyuryokuSeigyo(NyuryokuSeigyoDiv NyuryokuSeigyo) {
        this.NyuryokuSeigyo=NyuryokuSeigyo;
    }

}
