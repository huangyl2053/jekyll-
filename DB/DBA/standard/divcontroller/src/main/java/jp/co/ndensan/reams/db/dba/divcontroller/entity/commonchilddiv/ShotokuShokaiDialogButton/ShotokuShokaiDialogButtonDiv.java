package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShotokuShokaiDialogButton;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuShokaiDialogButton のクラスファイル
 *
 * @author 自動生成
 */
public class ShotokuShokaiDialogButtonDiv extends Panel implements IShotokuShokaiDialogButtonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSetaiShotoku")
    private ButtonDialog btnSetaiShotoku;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnSetaiShotoku
     * @return btnSetaiShotoku
     */
    @JsonProperty("btnSetaiShotoku")
    public ButtonDialog getBtnSetaiShotoku() {
        return btnSetaiShotoku;
    }

    /*
     * setbtnSetaiShotoku
     * @param btnSetaiShotoku btnSetaiShotoku
     */
    @JsonProperty("btnSetaiShotoku")
    public void setBtnSetaiShotoku(ButtonDialog btnSetaiShotoku) {
        this.btnSetaiShotoku = btnSetaiShotoku;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    public void initialize(ShikibetsuCode shikibetsuCode) {
        this.setShikibetsuCode(shikibetsuCode.getColumnValue());
    }

}
