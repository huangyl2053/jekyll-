/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

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
        if (HokenshaKosei.単一市町村.getコード().equals(保険者構成.getコード())) {
            setPanelVisibilityAt単一(div);
        } else if (HokenshaKosei.広域市町村.getコード().equals(保険者構成.getコード())) {
            setPanelVisibilityAt広域(div);
        }
        set初期項目状態();
        set初期項目内容();
    }

    private static void setPanelVisibilityAt広域(HanyoListAtenaSelectDiv div) {
        div.getCcdHokenshaList().setVisible(true);
        div.getDvChiku().setDisplayNone(true);
    }

    private static void setPanelVisibilityAt単一(HanyoListAtenaSelectDiv div) {
        div.getCcdHokenshaList().setDisplayNone(true);
        div.getDvChiku().setVisible(true);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divを初期化します(パラメータがなし)。
     */
    public void initialize() {
        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村情報 != null && 市町村情報.get導入形態コード() != null
                && DonyuKeitaiCode.toValue(市町村情報.get導入形態コード().getColumnValue()).is広域()) {
            setPanelVisibilityAt広域(div);
        } else {
            setPanelVisibilityAt単一(div);
        }
        set初期項目状態();
        set初期項目内容();
    }

    /**
     * 「宛名検索条件」ラジオボタン連動処理をします。
     */
    public void onChange_SelectKijun() {
        RString 年齢層抽出方法 = div.getRadSelectKijun().getSelectedKey();
        if (NenreiSoChushutsuHoho.年齢範囲.getコード().equals(年齢層抽出方法)) {
            div.getRadSelectKijun().setDisabled(false);
            div.getTxtNenrei().setDisabled(false);
            div.getTxtNenrei().clearFromValue();
            div.getTxtNenrei().clearFromValue();
            div.getTxtSeinengappi().setDisabled(true);
            div.getTxtSeinengappi().clearFromValue();
            div.getTxtSeinengappi().clearToValue();
            div.getTxtNenreiKijunbi().setDisabled(false);
            div.getTxtNenreiKijunbi().clearValue();
        } else if (NenreiSoChushutsuHoho.生年月日範囲.getコード().equals(年齢層抽出方法)) {
            div.getRadSelectKijun().setDisabled(false);
            div.getTxtNenrei().setDisabled(true);
            div.getTxtNenrei().clearFromValue();
            div.getTxtNenrei().clearToValue();
            div.getTxtSeinengappi().setDisabled(false);
            div.getTxtSeinengappi().clearFromValue();
            div.getTxtSeinengappi().clearToValue();
            div.getTxtNenreiKijunbi().setDisabled(false);
            div.getTxtNenreiKijunbi().clearValue();
        }
    }

    /**
     * 「地区」DDL連動処理をします。
     */
    public void onChange_SelectChiku() {
        RString 地区 = div.getDdlChikuSelect().getSelectedKey();
        div.getDdlChikuSelect().setDisabled(false);
        if (Chiku.全て.getコード().equals(地区)) {
            div.getCcdJushoFrom().setDisabled(true);
            div.getCcdJushoFrom().setDisplayNone(false);
            div.getCcdJushoFrom().setVisible(true);
            div.getCcdJushoFrom().clear();
            div.getCcdJushoTo().setDisabled(true);
            div.getCcdJushoTo().setDisplayNone(false);
            div.getCcdJushoTo().setVisible(true);
            div.getCcdJushoTo().clear();
            set行政区CanBeInput(false);
            set地区sCanBeInput(false);
        } else if (Chiku.住所.getコード().equals(地区)) {
            set住所CanBeInput(true);
            set行政区CanBeInput(false);
            set地区sCanBeInput(false);
        } else if (Chiku.行政区.getコード().equals(地区)) {
            set住所CanBeInput(false);
            set行政区CanBeInput(true);
            set地区sCanBeInput(false);
        } else if (Chiku.地区.getコード().equals(地区)) {
            set住所CanBeInput(false);
            set行政区CanBeInput(false);
            set地区sCanBeInput(true);
        }
    }

    void set住所CanBeInput(boolean canBenInput) {
        div.getCcdJushoFrom().setDisplayNone(!canBenInput);
        div.getCcdJushoTo().setDisplayNone(!canBenInput);
        if (!canBenInput) {
            return;
        }
        div.getCcdJushoFrom().setDisabled(false);
        div.getCcdJushoFrom().setVisible(true);
        div.getCcdJushoFrom().clear();
        div.getCcdJushoTo().setDisabled(false);
        div.getCcdJushoTo().setVisible(true);
        div.getCcdJushoTo().clear();
    }

    void set行政区CanBeInput(boolean canBenInput) {
        div.getCcdGyoseikuFrom().setDisplayNone(!canBenInput);
        div.getCcdGyoseikuTo().setDisplayNone(!canBenInput);
        if (!canBenInput) {
            return;
        }
        div.getCcdGyoseikuFrom().setDisabled(false);
        div.getCcdGyoseikuFrom().setVisible(true);
        div.getCcdGyoseikuFrom().clear();
        div.getCcdGyoseikuTo().setDisabled(false);
        div.getCcdGyoseikuTo().setVisible(true);
        div.getCcdGyoseikuTo().clear();
    }

    void set地区sCanBeInput(boolean canBenInput) {
        div.getCcdChiku1From().setDisplayNone(!canBenInput);
        div.getCcdChiku2From().setDisplayNone(!canBenInput);
        div.getCcdChiku3From().setDisplayNone(!canBenInput);
        div.getCcdChiku1To().setDisplayNone(!canBenInput);
        div.getCcdChiku2To().setDisplayNone(!canBenInput);
        div.getCcdChiku3To().setDisplayNone(!canBenInput);
        if (!canBenInput) {
            return;
        }
        div.getCcdChiku1From().setDisabled(false);
        div.getCcdChiku1From().setVisible(true);
        div.getCcdChiku1From().clear();
        div.getCcdChiku2From().setDisabled(false);
        div.getCcdChiku2From().setVisible(true);
        div.getCcdChiku2From().clear();
        div.getCcdChiku3From().setDisabled(false);
        div.getCcdChiku3From().setVisible(true);
        div.getCcdChiku3From().clear();
        div.getCcdChiku1To().setDisabled(false);
        div.getCcdChiku1To().setVisible(true);
        div.getCcdChiku1To().clear();
        div.getCcdChiku2To().setDisabled(false);
        div.getCcdChiku2To().setVisible(true);
        div.getCcdChiku2To().clear();
        div.getCcdChiku3To().setDisabled(false);
        div.getCcdChiku3To().setVisible(true);
        div.getCcdChiku3To().clear();
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
        return div.getTxtNenrei().getFromValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢開始の値を設定します。
     *
     * @param 年齢開始
     */
    public void set年齢開始(Decimal 年齢開始) {
        div.getTxtNenrei().setFromValue(年齢開始);
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢終了の設定値を返却します。
     *
     * @return 年齢終了の設定値
     */
    public Decimal get年齢終了() {
        return div.getTxtNenrei().getToValue();
    }

    /**
     * 汎用リスト宛名抽出条件共有子Divの年齢終了の値を設定します。
     *
     * @param 年齢終了
     */
    public void set年齢終了(Decimal 年齢終了) {
        div.getTxtNenrei().setToValue(年齢終了);
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
     * 汎用リスト宛名抽出条件共有子Divの保険者の値（選択項）を設定します。
     *
     * @param 市町村コード
     */
    public void set保険者(LasdecCode 市町村コード) {
        div.getCcdHokenshaList().setSelectedShichosonIfExist(市町村コード);
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
     * 汎用リスト宛名抽出条件共有子Divの行政区終了の設定値を返却します。
     *
     * @return 行政区終了の設定値
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

    /**
     * 宛名の抽出条件を作成して返却します。
     *
     * @return 宛名の抽出条件
     */
    public AtenaSelectBatchParameter get宛名抽出条件() {
        AtenaSelectBatchParameter atenaSelect = new AtenaSelectBatchParameter();

        atenaSelect.setAgeSelectKijun(this.get年齢層抽出方法());
        Range<Decimal> 年齢範囲 = new Range<>(this.get年齢開始(), this.get年齢終了());
        atenaSelect.setNenreiRange(年齢範囲);
        atenaSelect.setNenreiKijunbi(this.get年齢基準日());
        Range<RDate> 生年月日範囲 = new Range<>(this.get生年月日開始(), this.get生年月日終了());
        atenaSelect.setSeinengappiRange(生年月日範囲);
        atenaSelect.setShichoson_Code(this.get保険者().get市町村コード());
        atenaSelect.setShichoson_Mesho(this.get保険者().get市町村名称());
        atenaSelect.setChiku_Kubun(this.get地区());
        atenaSelect.setJusho_From(this.get住所開始());
        atenaSelect.setJusho_FromMesho(div.getCcdJushoFrom().get町域名称());
        atenaSelect.setJusho_To(this.get住所終了());
        atenaSelect.setJusho_ToMesho(div.getCcdJushoTo().get町域名称());
        atenaSelect.setGyoseiku_From(this.get行政区開始());
        atenaSelect.setGyoseiku_FromMesho(div.getCcdGyoseikuFrom().get行政区名称());
        atenaSelect.setGyoseiku_To(this.get行政区終了());
        atenaSelect.setGyoseiku_ToMesho(div.getCcdGyoseikuTo().get行政区名称());
        atenaSelect.setChiku1_From(this.get地区１開始());
        atenaSelect.setChiku1_FromMesho(div.getCcdChiku1From().get地区1名称());
        atenaSelect.setChiku1_To(this.get地区１終了());
        atenaSelect.setChiku1_ToMesho(div.getCcdChiku1To().get地区1名称());
        atenaSelect.setChiku2_From(this.get地区２開始());
        atenaSelect.setChiku2_FromMesho(div.getCcdChiku2From().get地区2名称());
        atenaSelect.setChiku2_To(this.get地区２終了());
        atenaSelect.setChiku2_ToMesho(div.getCcdChiku2To().get地区2名称());
        atenaSelect.setChiku3_From(this.get地区３開始());
        atenaSelect.setChiku3_FromMesho(div.getCcdChiku3From().get地区3名称());
        atenaSelect.setChiku3_To(this.get地区３終了());
        atenaSelect.setChiku3_ToMesho(div.getCcdChiku3To().get地区3名称());

        return atenaSelect;
    }

    /**
     * 宛名抽出条件子Divを返却します。
     *
     * @return 宛名抽出条件子Div
     */
    public HanyoListAtenaSelectDiv get宛名抽出条件子Div() {
        return div;
    }

    private void set初期項目状態() {
        div.getCcdHokenshaList().loadHokenshaList();
        div.getCcdJushoFrom().initialize();
        div.getCcdGyoseikuFrom().initialize();
        div.getCcdChiku1From().initialize();
        div.getCcdChiku2From().initialize();
        div.getCcdChiku3From().initialize();
        div.getCcdJushoTo().initialize();
        div.getCcdGyoseikuTo().initialize();
        div.getCcdChiku1To().initialize();
        div.getCcdChiku2To().initialize();
        div.getCcdChiku3To().initialize();

        div.getRadSelectKijun().setDisabled(false);
        div.getTxtNenrei().setDisabled(false);
        div.getTxtSeinengappi().setDisabled(true);
        div.getTxtNenreiKijunbi().setDisabled(false);
        div.getDdlChikuSelect().setDisabled(false);
        div.getCcdJushoFrom().setDisabled(true);
        div.getCcdGyoseikuFrom().setDisplayNone(true);
        div.getCcdChiku1From().setDisplayNone(true);
        div.getCcdChiku2From().setDisplayNone(true);
        div.getCcdChiku3From().setDisplayNone(true);
        div.getCcdJushoTo().setDisabled(true);
        div.getCcdGyoseikuTo().setDisplayNone(true);
        div.getCcdChiku1To().setDisplayNone(true);
        div.getCcdChiku2To().setDisplayNone(true);
        div.getCcdChiku3To().setDisplayNone(true);
    }

    private void set初期項目内容() {
        set宛名抽出条件ラジオボタン();
        div.getRadSelectKijun().setSelectedKey(NenreiSoChushutsuHoho.年齢範囲.getコード());
        div.getTxtNenrei().clearFromValue();
        div.getTxtNenrei().clearToValue();
        div.getTxtSeinengappi().clearFromValue();
        div.getTxtSeinengappi().clearToValue();
        div.getTxtNenreiKijunbi().clearValue();
        set地区DDL();
        div.getDdlChikuSelect().setSelectedKey(Chiku.全て.getコード());
        div.getCcdJushoFrom().clear();
        div.getCcdJushoTo().clear();
    }

    private void set宛名抽出条件ラジオボタン() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (NenreiSoChushutsuHoho 宛名抽出条件 : NenreiSoChushutsuHoho.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(宛名抽出条件.getコード());
            keyValue.setValue(宛名抽出条件.get名称());
            dataSource.add(keyValue);
        }
        div.getRadSelectKijun().setDataSource(dataSource);
    }

    private void set地区DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (Chiku 地区 : Chiku.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(地区.getコード());
            keyValue.setValue(地区.get名称());
            dataSource.add(keyValue);
        }
        div.getDdlChikuSelect().setDataSource(dataSource);
    }

}
