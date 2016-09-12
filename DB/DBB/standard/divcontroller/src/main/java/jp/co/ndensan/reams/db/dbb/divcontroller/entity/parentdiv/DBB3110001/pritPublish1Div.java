package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.IPrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * pritPublish1 のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class pritPublish1Div extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BunshoBango1")
    private BunshoBangoInputDiv BunshoBango1;
    @JsonProperty("comdiv1")
    private PrintContentsSettingDiv comdiv1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBunshoBango1
     * @return BunshoBango1
     */
    @JsonProperty("BunshoBango1")
    public IBunshoBangoInputDiv getBunshoBango1() {
        return BunshoBango1;
    }

    /*
     * getcomdiv1
     * @return comdiv1
     */
    @JsonProperty("comdiv1")
    public IPrintContentsSettingDiv getComdiv1() {
        return comdiv1;
    }

    // </editor-fold>
}
