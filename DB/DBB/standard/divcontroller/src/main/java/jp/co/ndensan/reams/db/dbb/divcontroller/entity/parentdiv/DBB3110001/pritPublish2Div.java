package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * pritPublish2 のクラスファイル
 *
 * @reamsid_L DBB-1660-050 gongliang
 */
public class pritPublish2Div extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BunshoBango2")
    private BunshoBangoInputDiv BunshoBango2;
    @JsonProperty("comdiv2")
    private PrintContentsSettingDiv comdiv2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBunshoBango2
     * @return BunshoBango2
     */
    @JsonProperty("BunshoBango2")
    public IBunshoBangoInputDiv getBunshoBango2() {
        return BunshoBango2;
    }

    /*
     * getcomdiv2
     * @return comdiv2
     */
    @JsonProperty("comdiv2")
    public IPrintContentsSettingDiv getComdiv2() {
        return comdiv2;
    }

    // </editor-fold>
}
