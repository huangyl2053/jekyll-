package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.IJyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabJutakuKaisyuJyoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabJutakuKaisyuJyohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    private JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo;
    @JsonProperty("ccdJutakugaisyunaiyoList")
    private JyutakugaisyunaiyoListDiv ccdJutakugaisyunaiyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutakuKaishuShinseiResetInfo
     * @return JutakuKaishuShinseiResetInfo
     */
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public JutakuKaishuShinseiResetInfoDiv getJutakuKaishuShinseiResetInfo() {
        return JutakuKaishuShinseiResetInfo;
    }

    /*
     * setJutakuKaishuShinseiResetInfo
     * @param JutakuKaishuShinseiResetInfo JutakuKaishuShinseiResetInfo
     */
    @JsonProperty("JutakuKaishuShinseiResetInfo")
    public void setJutakuKaishuShinseiResetInfo(JutakuKaishuShinseiResetInfoDiv JutakuKaishuShinseiResetInfo) {
        this.JutakuKaishuShinseiResetInfo = JutakuKaishuShinseiResetInfo;
    }

    /*
     * getccdJutakugaisyunaiyoList
     * @return ccdJutakugaisyunaiyoList
     */
    @JsonProperty("ccdJutakugaisyunaiyoList")
    public IJyutakugaisyunaiyoListDiv getCcdJutakugaisyunaiyoList() {
        return ccdJutakugaisyunaiyoList;
    }

    // </editor-fold>
}
