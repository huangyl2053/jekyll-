package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvHakko のクラスファイル
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DvKakuninsho")
    private DvKakuninshoDiv DvKakuninsho;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getDvKakuninsho
     * @return DvKakuninsho
     */
    @JsonProperty("DvKakuninsho")
    public DvKakuninshoDiv getDvKakuninsho() {
        return DvKakuninsho;
    }

    /*
     * setDvKakuninsho
     * @param DvKakuninsho DvKakuninsho
     */
    @JsonProperty("DvKakuninsho")
    public void setDvKakuninsho(DvKakuninshoDiv DvKakuninsho) {
        this.DvKakuninsho = DvKakuninsho;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTsuchiDate() {
        return this.getDvKakuninsho().getTxtTsuchiDate();
    }

    @JsonIgnore
    public void setTxtTsuchiDate(TextBoxDate txtTsuchiDate) {
        this.getDvKakuninsho().setTxtTsuchiDate(txtTsuchiDate);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return this.getDvKakuninsho().getCcdBunshoBango();
    }

    // </editor-fold>
}
