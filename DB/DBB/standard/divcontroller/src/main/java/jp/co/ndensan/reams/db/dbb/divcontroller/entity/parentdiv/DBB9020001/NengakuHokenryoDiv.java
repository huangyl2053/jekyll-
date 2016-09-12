package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NengakuHokenryo のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class NengakuHokenryoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHasu")
    private DropDownList ddlHasu;
    @JsonProperty("ddlMarumeKata")
    private DropDownList ddlMarumeKata;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHasu
     * @return ddlHasu
     */
    @JsonProperty("ddlHasu")
    public DropDownList getDdlHasu() {
        return ddlHasu;
    }

    /*
     * setddlHasu
     * @param ddlHasu ddlHasu
     */
    @JsonProperty("ddlHasu")
    public void setDdlHasu(DropDownList ddlHasu) {
        this.ddlHasu = ddlHasu;
    }

    /*
     * getddlMarumeKata
     * @return ddlMarumeKata
     */
    @JsonProperty("ddlMarumeKata")
    public DropDownList getDdlMarumeKata() {
        return ddlMarumeKata;
    }

    /*
     * setddlMarumeKata
     * @param ddlMarumeKata ddlMarumeKata
     */
    @JsonProperty("ddlMarumeKata")
    public void setDdlMarumeKata(DropDownList ddlMarumeKata) {
        this.ddlMarumeKata = ddlMarumeKata;
    }

    // </editor-fold>
}
