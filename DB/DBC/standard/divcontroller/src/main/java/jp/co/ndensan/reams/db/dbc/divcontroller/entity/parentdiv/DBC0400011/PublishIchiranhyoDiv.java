package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0400011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;

/**
 * PublishIchiranhyo のクラスファイル
 *
 * @reamsid_L DBC-2010-030 huzongcheng
 */
public class PublishIchiranhyoDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("blank1")
    private Space blank1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getblank1
     * @return blank1
     */
    @JsonProperty("blank1")
    public Space getBlank1() {
        return blank1;
    }

    /*
     * setblank1
     * @param blank1 blank1
     */
    @JsonProperty("blank1")
    public void setBlank1(Space blank1) {
        this.blank1 = blank1;
    }

    // </editor-fold>
}
