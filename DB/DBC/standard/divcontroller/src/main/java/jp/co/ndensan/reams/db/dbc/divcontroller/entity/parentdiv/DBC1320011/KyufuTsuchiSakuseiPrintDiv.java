package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuTsuchiSakuseiPrint のクラスファイル
 *
 * @author 自動生成
 */
public class KyufuTsuchiSakuseiPrintDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdBunsyobango")
    private BunshoBangoInputDiv ccdBunsyobango;
    @JsonProperty("KyufuTsuchiSakuseiSetting")
    private PrintContentsSettingDiv KyufuTsuchiSakuseiSetting;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdBunsyobango
     * @return ccdBunsyobango
     */
    @JsonProperty("ccdBunsyobango")
    public IBunshoBangoInputDiv getCcdBunsyobango() {
        return ccdBunsyobango;
    }

    /*
     * getKyufuTsuchiSakuseiSetting
     * @return KyufuTsuchiSakuseiSetting
     */
    @JsonProperty("KyufuTsuchiSakuseiSetting")
    public IPrintContentsSettingDiv getKyufuTsuchiSakuseiSetting() {
        return KyufuTsuchiSakuseiSetting;
    }

    // </editor-fold>
}
