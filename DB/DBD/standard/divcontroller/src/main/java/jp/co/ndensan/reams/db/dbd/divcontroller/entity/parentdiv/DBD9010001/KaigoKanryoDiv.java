package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoKanryo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoKanryoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoKanryoMessageChildDiv")
    private KaigoKanryoMessageDiv KaigoKanryoMessageChildDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoKanryoMessageChildDiv
     * @return KaigoKanryoMessageChildDiv
     */
    @JsonProperty("KaigoKanryoMessageChildDiv")
    public IKaigoKanryoMessageDiv getKaigoKanryoMessageChildDiv() {
        return KaigoKanryoMessageChildDiv;
    }

    // </editor-fold>
}
