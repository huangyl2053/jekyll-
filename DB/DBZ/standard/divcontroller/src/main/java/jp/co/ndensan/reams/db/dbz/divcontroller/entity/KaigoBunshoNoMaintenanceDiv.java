package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoBunshoNoMaintenanceDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.BunshoNoMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IBunshoNoMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.BunshoNoKanriRirekiHyojiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgBunshoNoRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoBunshoNoMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoBunshoNoMaintenanceDiv extends Panel implements IKaigoBunshoNoMaintenanceDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdBunshoMaintenance")
    private BunshoNoMaintenanceDiv ccdBunshoMaintenance;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdBunshoMaintenance")
    public IBunshoNoMaintenanceDiv getCcdBunshoMaintenance() {
        return ccdBunshoMaintenance;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
