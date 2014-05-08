package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyotakuServiceTodokedeJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceTodokedeJikoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo")
    private tblKyotakuServiceJikoSakuseiInfoDiv tblKyotakuServiceJikoSakuseiInfo;
    @JsonProperty("btnDlgTankiNyusho")
    private ButtonDialog btnDlgTankiNyusho;
    @JsonProperty("btnDlgHomonTsusho")
    private ButtonDialog btnDlgHomonTsusho;
    @JsonProperty("btnDlgKyotakuService")
    private ButtonDialog btnDlgKyotakuService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo")
    public tblKyotakuServiceJikoSakuseiInfoDiv getTblKyotakuServiceJikoSakuseiInfo() {
        return tblKyotakuServiceJikoSakuseiInfo;
    }

    @JsonProperty("tblKyotakuServiceJikoSakuseiInfo")
    public void setTblKyotakuServiceJikoSakuseiInfo(tblKyotakuServiceJikoSakuseiInfoDiv tblKyotakuServiceJikoSakuseiInfo) {
        this.tblKyotakuServiceJikoSakuseiInfo=tblKyotakuServiceJikoSakuseiInfo;
    }

    @JsonProperty("btnDlgTankiNyusho")
    public ButtonDialog getBtnDlgTankiNyusho() {
        return btnDlgTankiNyusho;
    }

    @JsonProperty("btnDlgTankiNyusho")
    public void setBtnDlgTankiNyusho(ButtonDialog btnDlgTankiNyusho) {
        this.btnDlgTankiNyusho=btnDlgTankiNyusho;
    }

    @JsonProperty("btnDlgHomonTsusho")
    public ButtonDialog getBtnDlgHomonTsusho() {
        return btnDlgHomonTsusho;
    }

    @JsonProperty("btnDlgHomonTsusho")
    public void setBtnDlgHomonTsusho(ButtonDialog btnDlgHomonTsusho) {
        this.btnDlgHomonTsusho=btnDlgHomonTsusho;
    }

    @JsonProperty("btnDlgKyotakuService")
    public ButtonDialog getBtnDlgKyotakuService() {
        return btnDlgKyotakuService;
    }

    @JsonProperty("btnDlgKyotakuService")
    public void setBtnDlgKyotakuService(ButtonDialog btnDlgKyotakuService) {
        this.btnDlgKyotakuService=btnDlgKyotakuService;
    }

}
