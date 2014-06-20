package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiKogakuFurikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKogakuFurikomiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKogakuFurikomiMeisaiSakuseiYMD")
    private TextBoxDate txtKogakuFurikomiMeisaiSakuseiYMD;
    @JsonProperty("txtKogakuFurikomiShiharaiYoteiYMD")
    private TextBoxDate txtKogakuFurikomiShiharaiYoteiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKogakuFurikomiMeisaiSakuseiYMD")
    public TextBoxDate getTxtKogakuFurikomiMeisaiSakuseiYMD() {
        return txtKogakuFurikomiMeisaiSakuseiYMD;
    }

    @JsonProperty("txtKogakuFurikomiMeisaiSakuseiYMD")
    public void setTxtKogakuFurikomiMeisaiSakuseiYMD(TextBoxDate txtKogakuFurikomiMeisaiSakuseiYMD) {
        this.txtKogakuFurikomiMeisaiSakuseiYMD=txtKogakuFurikomiMeisaiSakuseiYMD;
    }

    @JsonProperty("txtKogakuFurikomiShiharaiYoteiYMD")
    public TextBoxDate getTxtKogakuFurikomiShiharaiYoteiYMD() {
        return txtKogakuFurikomiShiharaiYoteiYMD;
    }

    @JsonProperty("txtKogakuFurikomiShiharaiYoteiYMD")
    public void setTxtKogakuFurikomiShiharaiYoteiYMD(TextBoxDate txtKogakuFurikomiShiharaiYoteiYMD) {
        this.txtKogakuFurikomiShiharaiYoteiYMD=txtKogakuFurikomiShiharaiYoteiYMD;
    }

}
