package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.SegmentedControl;

/**
 * JisshiKubun のクラスファイル
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class JisshiKubunDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("segTaishoJigyoJishiKubun")
    private SegmentedControl segTaishoJigyoJishiKubun;
    @JsonProperty("segYoshien1")
    private SegmentedControl segYoshien1;
    @JsonProperty("segYoshien2")
    private SegmentedControl segYoshien2;
    @JsonProperty("segNijiYobosha")
    private SegmentedControl segNijiYobosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getsegTaishoJigyoJishiKubun
     * @return segTaishoJigyoJishiKubun
     */
    @JsonProperty("segTaishoJigyoJishiKubun")
    public SegmentedControl getSegTaishoJigyoJishiKubun() {
        return segTaishoJigyoJishiKubun;
    }

    /*
     * setsegTaishoJigyoJishiKubun
     * @param segTaishoJigyoJishiKubun segTaishoJigyoJishiKubun
     */
    @JsonProperty("segTaishoJigyoJishiKubun")
    public void setSegTaishoJigyoJishiKubun(SegmentedControl segTaishoJigyoJishiKubun) {
        this.segTaishoJigyoJishiKubun = segTaishoJigyoJishiKubun;
    }

    /*
     * getsegYoshien1
     * @return segYoshien1
     */
    @JsonProperty("segYoshien1")
    public SegmentedControl getSegYoshien1() {
        return segYoshien1;
    }

    /*
     * setsegYoshien1
     * @param segYoshien1 segYoshien1
     */
    @JsonProperty("segYoshien1")
    public void setSegYoshien1(SegmentedControl segYoshien1) {
        this.segYoshien1 = segYoshien1;
    }

    /*
     * getsegYoshien2
     * @return segYoshien2
     */
    @JsonProperty("segYoshien2")
    public SegmentedControl getSegYoshien2() {
        return segYoshien2;
    }

    /*
     * setsegYoshien2
     * @param segYoshien2 segYoshien2
     */
    @JsonProperty("segYoshien2")
    public void setSegYoshien2(SegmentedControl segYoshien2) {
        this.segYoshien2 = segYoshien2;
    }

    /*
     * getsegNijiYobosha
     * @return segNijiYobosha
     */
    @JsonProperty("segNijiYobosha")
    public SegmentedControl getSegNijiYobosha() {
        return segNijiYobosha;
    }

    /*
     * setsegNijiYobosha
     * @param segNijiYobosha segNijiYobosha
     */
    @JsonProperty("segNijiYobosha")
    public void setSegNijiYobosha(SegmentedControl segNijiYobosha) {
        this.segNijiYobosha = segNijiYobosha;
    }

    // </editor-fold>
}
