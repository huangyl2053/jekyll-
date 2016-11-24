package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ChoshuYuyoTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuYuyoTsuchiKobetsuDiv extends PanelPublish {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoshuYuyoHakkoYMD")
    private TextBoxFlexibleDate txtChoshuYuyoHakkoYMD;
    @JsonProperty("ccdChoshuYuyoTsuchiBunshoNo")
    private BunshoBangoInputDiv ccdChoshuYuyoTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoshuYuyoHakkoYMD
     * @return txtChoshuYuyoHakkoYMD
     */
    @JsonProperty("txtChoshuYuyoHakkoYMD")
    public TextBoxFlexibleDate getTxtChoshuYuyoHakkoYMD() {
        return txtChoshuYuyoHakkoYMD;
    }

    /*
     * settxtChoshuYuyoHakkoYMD
     * @param txtChoshuYuyoHakkoYMD txtChoshuYuyoHakkoYMD
     */
    @JsonProperty("txtChoshuYuyoHakkoYMD")
    public void setTxtChoshuYuyoHakkoYMD(TextBoxFlexibleDate txtChoshuYuyoHakkoYMD) {
        this.txtChoshuYuyoHakkoYMD = txtChoshuYuyoHakkoYMD;
    }

    /*
     * getccdChoshuYuyoTsuchiBunshoNo
     * @return ccdChoshuYuyoTsuchiBunshoNo
     */
    @JsonProperty("ccdChoshuYuyoTsuchiBunshoNo")
    public IBunshoBangoInputDiv getCcdChoshuYuyoTsuchiBunshoNo() {
        return ccdChoshuYuyoTsuchiBunshoNo;
    }

    // </editor-fold>
}
