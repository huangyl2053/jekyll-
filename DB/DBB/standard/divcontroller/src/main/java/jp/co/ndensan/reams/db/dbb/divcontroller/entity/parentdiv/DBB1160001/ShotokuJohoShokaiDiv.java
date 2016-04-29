package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1160001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuJohoShokai のクラスファイル
 *
 * @reamsid_L DBB-1740-010 xuhao
 */
public class ShotokuJohoShokaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaKihonInfo")
    private AtenaKihonInfoDiv AtenaKihonInfo;
    @JsonProperty("SetaiShotokuInfo")
    private SetaiShotokuInfoDiv SetaiShotokuInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaKihonInfo
     * @return AtenaKihonInfo
     */
    @JsonProperty("AtenaKihonInfo")
    public AtenaKihonInfoDiv getAtenaKihonInfo() {
        return AtenaKihonInfo;
    }

    /*
     * setAtenaKihonInfo
     * @param AtenaKihonInfo AtenaKihonInfo
     */
    @JsonProperty("AtenaKihonInfo")
    public void setAtenaKihonInfo(AtenaKihonInfoDiv AtenaKihonInfo) {
        this.AtenaKihonInfo = AtenaKihonInfo;
    }

    /*
     * getSetaiShotokuInfo
     * @return SetaiShotokuInfo
     */
    @JsonProperty("SetaiShotokuInfo")
    public SetaiShotokuInfoDiv getSetaiShotokuInfo() {
        return SetaiShotokuInfo;
    }

    /*
     * setSetaiShotokuInfo
     * @param SetaiShotokuInfo SetaiShotokuInfo
     */
    @JsonProperty("SetaiShotokuInfo")
    public void setSetaiShotokuInfo(SetaiShotokuInfoDiv SetaiShotokuInfo) {
        this.SetaiShotokuInfo = SetaiShotokuInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoFukaKihonDiv getKaigoFukaKihon() {
        return this.getAtenaKihonInfo().getKaigoFukaKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getKaigoAtenaInfo() {
        return this.getAtenaKihonInfo().getKaigoAtenaInfo();
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getSetaiShotokuIchiran() {
        return this.getSetaiShotokuInfo().getSetaiShotokuIchiran();
    }

    // </editor-fold>
}
