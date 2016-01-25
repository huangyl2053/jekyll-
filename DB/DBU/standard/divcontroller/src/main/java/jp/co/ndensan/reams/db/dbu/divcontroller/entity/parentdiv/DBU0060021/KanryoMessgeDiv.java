package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoMessge のクラスファイル 
 * 
 * @author 自動生成
 */
public class KanryoMessgeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CCKanryoMessge")
    private KanryoMessageDiv CCKanryoMessge;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCCKanryoMessge
     * @return CCKanryoMessge
     */
    @JsonProperty("CCKanryoMessge")
    public IKanryoMessageDiv getCCKanryoMessge() {
        return CCKanryoMessge;
    }

    // </editor-fold>
}
