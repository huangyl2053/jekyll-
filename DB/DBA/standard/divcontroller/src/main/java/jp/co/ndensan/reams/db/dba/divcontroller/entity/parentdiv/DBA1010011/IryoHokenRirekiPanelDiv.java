package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.iryohokenrireki.IIryoHokenRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IryoHokenRirekiPanel のクラスファイル
 *
 * @author 自動生成
 */
public class IryoHokenRirekiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IryoHokenInput")
    private IryoHokenInputDiv IryoHokenInput;
    @JsonProperty("ccdIryoHokenRireki")
    private IryoHokenRirekiDiv ccdIryoHokenRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("IryoHokenInput")
    public IryoHokenInputDiv getIryoHokenInput() {
        return IryoHokenInput;
    }

    @JsonProperty("IryoHokenInput")
    public void setIryoHokenInput(IryoHokenInputDiv IryoHokenInput) {
        this.IryoHokenInput = IryoHokenInput;
    }

    @JsonProperty("ccdIryoHokenRireki")
    public IIryoHokenRirekiDiv getCcdIryoHokenRireki() {
        return ccdIryoHokenRireki;
    }

    // </editor-fold>
}
