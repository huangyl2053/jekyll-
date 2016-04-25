/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;

import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト宛名抽出条件のHandlerクラスです。
 *
 * @reamsid_L DBA-1610-040 dingyi
 */
public class HanyoListAtenaSelectHandler {

    private final HanyoListAtenaSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト宛名抽出条件パネル
     */
    public HanyoListAtenaSelectHandler(HanyoListAtenaSelectDiv div) {
        this.div = div;
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divを初期化します(パラメータがある)。
     *
     * @param 保険者構成 保険者構成
     */
    public void initialize(HokenshaKosei 保険者構成) {

    }

    /**
     * 汎用リスト宛名抽出条件共有子Divを初期化します(パラメータがなし)。
     */
    public void initialize() {

    }

    /**
     * 「宛名検索条件」ラジオボタン連動処理をします。
     */
    public void onChange_SelectKijun() {

    }

    /**
     * 「地区」DDL連動処理をします。
     */
    public void onChange_ChikuSelect() {

    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの抽出条件ラジオボタンの設定値を返却します。
     *
     * @return 年齢層抽出方法抽出条件ラジオボタンの設定値
     */
    public NenreiSoChushutsuHoho get年齢層抽出方法() {
        return NenreiSoChushutsuHoho.toValue(div.getRadSelectKijun().getSelectedKey());
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの抽出条件ラジオボタンの値を設定します。
     *
     * @param 年齢層抽出方法
     */
    public void set年齢層抽出方法(RString 年齢層抽出方法) {
        div.getRadSelectKijun().setSelectedKey(年齢層抽出方法);

    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢開始の設定値を返却します。
     *
     * @return 年齢開始の設定値
     */
    public Decimal get年齢開始() {
        return Decimal.valueOf(Integer.valueOf(div.getTxtNenrei().getFromPlaceHolder().toString()).longValue());
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢開始の値を設定します。
     *
     * @param 年齢開始
     */
    public void set年齢開始(Decimal 年齢開始) {
        div.getTxtNenrei().setFromPlaceHolder(new RString(年齢開始.toString()));
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢終了の設定値を返却します。
     *
     * @return 年齢終了の設定値
     */
    public Decimal get年齢終了() {
        return Decimal.valueOf(Integer.valueOf(div.getTxtNenrei().getToPlaceHolder().toString()).longValue());
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢終了の値を設定します。
     *
     * @param 年齢終了
     */
    public void set年齢終了(Decimal 年齢終了) {
        div.getTxtNenrei().setToPlaceHolder(new RString(年齢終了.toString()));
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢基準日の設定値を返却します。
     *
     * @return 年齢基準日の設定値
     */
    public RDate get年齢基準日() {
        return div.getTxtNenreiKijunbi().getValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢基準日の値を設定します。
     *
     * @param 年齢基準日
     */
    public void set年齢基準日(RDate 年齢基準日) {
        div.getTxtNenreiKijunbi().setValue(年齢基準日);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日開始の設定値を返却します。
     *
     * @return 生年月日開始の設定値
     */
    public RDate get生年月日開始() {
        return div.getTxtSeinengappi().getFromValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日開始の値を設定します。
     *
     * @param 生年月日開始
     */
    public void set生年月日開始(RDate 生年月日開始) {
        div.getTxtSeinengappi().setFromValue(生年月日開始);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日終了の設定値を返却します。
     *
     * @return 生年月日終了の設定値
     */
    public RDate get生年月日終了() {
        return div.getTxtSeinengappi().getToValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの生年月日終了の値を設定します。
     *
     * @param 生年月日終了
     */
    public void set生年月日終了(RDate 生年月日終了) {
        div.getTxtSeinengappi().setToValue(生年月日終了);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの保険者の設定値を返却します。
     *
     * @return 保険者の設定値
     */
    public HokenshaSummary get保険者() {
        return div.getCcdHokenshaList().getSelectedItem();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの保険者の値を設定します。
     */
    public void set保険者() {
        div.getCcdHokenshaList().loadHokenshaList();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区ラジオボタンの設定値を返却します。
     *
     * @return 地区ラジオボタンの設定値
     */
    public Chiku get地区() {
        return Chiku.toValue(div.getDdlChikuSelect().getSelectedKey());
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区の値を設定します。
     *
     * @param 地区
     */
    public void set地区(RString 地区) {
        div.getDdlChikuSelect().setSelectedKey(地区);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所開始の設定値を返却します。
     *
     * @return 住所開始の設定値
     */
    public RString get住所開始() {
        return div.getCcdJushoFrom().get町域コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所開始の値を設定します。
     *
     * @param 町域コード
     */
    public void set住所開始(ChoikiCode 町域コード) {
        div.getCcdJushoFrom().load(町域コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区開始の設定値を返却します。
     *
     * @return 行政区開始の設定値
     */
    public RString get行政区開始() {
        return div.getCcdGyoseikuFrom().get行政区コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区開始の値を設定します。
     *
     * @param 行政区コード
     */
    public void set行政区開始(GyoseikuCode 行政区コード) {
        div.getCcdGyoseikuFrom().load(行政区コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１開始の設定値を返却します。
     *
     * @return 地区１開始の設定値
     */
    public RString get地区１開始() {
        return div.getCcdChiku1From().get地区1コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１開始の値を設定します。
     *
     * @param 地区1コード
     */
    public void set地区１開始(ChikuCode 地区1コード) {
        div.getCcdChiku1From().load(地区1コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２開始の設定値を返却します。
     *
     * @return 地区２開始の設定値
     */
    public RString get地区２開始() {
        return div.getCcdChiku2From().get地区2コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２開始の値を設定します。
     *
     * @param 地区2コード
     */
    public void set地区２開始(ChikuCode 地区2コード) {
        div.getCcdChiku2From().load(地区2コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３開始の設定値を返却します。
     *
     * @return 地区３開始の設定値
     */
    public RString get地区３開始() {
        return div.getCcdChiku3From().get地区3コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３開始の値を設定します。
     *
     * @param 地区3コード
     */
    public void set地区３開始(ChikuCode 地区3コード) {
        div.getCcdChiku3From().load(地区3コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所終了の設定値を返却します。
     *
     * @return 住所終了の設定値
     */
    public RString get住所終了() {
        return div.getCcdJushoTo().get町域コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所終了の値を設定します。
     *
     * @param 町域コード
     */
    public void set住所終了(ChoikiCode 町域コード) {
        div.getCcdJushoTo().load(町域コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの住所終了の設定値を返却します。
     *
     * @return 住所終了の設定値
     */
    public RString get行政区終了() {
        return div.getCcdGyoseikuTo().get行政区コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの行政区終了の値を設定します。
     *
     * @param 行政区コード
     */
    public void set行政区終了(GyoseikuCode 行政区コード) {
        div.getCcdGyoseikuTo().load(行政区コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１終了の設定値を返却します。
     *
     * @return 地区１終了の設定値
     */
    public RString get地区１終了() {
        return div.getCcdChiku1To().get地区1コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区１終了の値を設定します。
     *
     * @param 地区1コード
     */
    public void set地区１終了(ChikuCode 地区1コード) {
        div.getCcdChiku1To().load(地区1コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２終了の設定値を返却します。
     *
     * @return 地区２終了の設定値
     */
    public RString get地区２終了() {
        return div.getCcdChiku2To().get地区2コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区２終了の値を設定します。
     *
     * @param 地区2コード
     */
    public void set地区２終了(ChikuCode 地区2コード) {
        div.getCcdChiku2To().load(地区2コード);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３終了の設定値を返却します。
     *
     * @return 地区３終了の設定値
     */
    public RString get地区３終了() {
        return div.getCcdChiku3To().get地区3コード().getColumnValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの地区３終了の値を設定します。
     *
     * @param 地区3コード
     */
    public void set地区３終了(ChikuCode 地区3コード) {
        div.getCcdChiku3To().load(地区3コード);
    }

}
