package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.IOutputChohyoIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.OutputChohyoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HonsanteiChohyoHakko2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonsanteiChohyoHakko2Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChohyoIchiran")
    private OutputChohyoIchiranDiv ccdChohyoIchiran;
    @JsonProperty("HonTsuchiKobetsuJoho")
    private HonTsuchiKobetsuJohoDiv HonTsuchiKobetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdChohyoIchiran")
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return ccdChohyoIchiran;
    }

    @JsonProperty("HonTsuchiKobetsuJoho")
    public HonTsuchiKobetsuJohoDiv getHonTsuchiKobetsuJoho() {
        return HonTsuchiKobetsuJoho;
    }

    @JsonProperty("HonTsuchiKobetsuJoho")
    public void setHonTsuchiKobetsuJoho(HonTsuchiKobetsuJohoDiv HonTsuchiKobetsuJoho) {
        this.HonTsuchiKobetsuJoho=HonTsuchiKobetsuJoho;
    }

    // </editor-fold>
}
