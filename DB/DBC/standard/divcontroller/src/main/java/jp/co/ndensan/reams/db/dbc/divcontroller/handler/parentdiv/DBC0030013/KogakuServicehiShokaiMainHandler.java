/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaihanteikekka.ShikyuMeisaiResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.JidoShokanTaishoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.HanteiKekkaLDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.HanteiKekkaRDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.KogakuServicehiShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.ShowResultTwoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.dgJudgementResultL_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.dgJudgementResultR_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbc.service.core.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 世帯合算並列表示のHandlerです。
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class KogakuServicehiShokaiMainHandler {

    private final KogakuServicehiShokaiMainDiv div;
    private static final int INDEX_ゼロ = 0;
    private static final int INDEX_イチ = 1;
    private static final RString 世帯基準の日 = new RString("01");

    /**
     * 世帯合算並列表示のHandlerです。
     *
     * @param div SetaiPanelDiv
     */
    public KogakuServicehiShokaiMainHandler(KogakuServicehiShokaiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KogakuServiceData
     */
    public void load共有子Div(KogakuServiceData 引き継ぎ情報) {
        // TODO 上の画面の識別コードの取得は問題があります。Redmine#89690
        ShikibetsuCode 識別コード = 引き継ぎ情報.get識別コード();
//        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");

        HihokenshaNo 被保険者番号 = 引き継ぎ情報.get被保険者番号();
        FlexibleYearMonth サービス提供年月 = 引き継ぎ情報.getサービス提供年月();
        div.getSetaiInfo().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getSetaiInfo().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            FlexibleDate 世帯基準年月日 = new FlexibleDate(サービス提供年月.toString().concat(世帯基準の日.toString()));
            FlexibleYear 所得年度 = サービス提供年月.getYear();
            // TODO QA902 初期化時に、共有子Div内部で表示する世帯員のアクセスログ出力を行う
            // TODO QA902 YMDHMS.now()?EMPTY?
            // TODO QA899 「並べて表示する」ボタンの問題
            div.getSetaiInfoPanel().getCcdSetaiShotokuIchiran().initialize(識別コード, 世帯基準年月日, 所得年度, YMDHMS.now());
        }
    }

    /**
     * 審査方法、支給区分と高額自動償還RadioButtonを初期化メソッドです。
     */
    public void loadRadioButton() {
        HanteiKekkaLDiv 並べて表示エリア_左側 = div.getShowResultTwo().getSetaiinL().getHanteiKekkaL();
        HanteiKekkaRDiv 並べて表示エリア_右側 = div.getShowResultTwo().getSetaiinR().getHanteiKekkaR();
        並べて表示エリア_左側.getRadShinsaMethodL().setDataSource(get審査方法());
        並べて表示エリア_左側.getRadShikyuKubunL().setDataSource(get支給区分());
        並べて表示エリア_左側.getRadKogakuAutoShokanL().setDataSource(get高額自動償還());
        並べて表示エリア_右側.getRadShinsaMethodR().setDataSource(get審査方法());
        並べて表示エリア_右側.getRadShikyuKubunR().setDataSource(get支給区分());
        並べて表示エリア_右側.getRadKogakuAutoShokanR().setDataSource(get高額自動償還());
    }

    /**
     * 「並べて表示する」ボタンを押下、世帯所得一覧Divから、世帯一覧Gridのマルチ選択された行の情報（list）を取得する。
     *
     * @param 引き継ぎ情報 KogakuServiceData
     */
    public void onClick_並べて表示する(KogakuServiceData 引き継ぎ情報) {
        List<SetaiinShotoku> 世帯員所得Selected = div.getSetaiInfoPanel().getCcdSetaiShotokuIchiran().get世帯員所得Selected();
        操作可否確認(世帯員所得Selected);
        RString メニューID = ResponseHolder.getMenuID();
        clear並べて表示エリア();
        ShowResultTwoDiv 並べて表示エリア = div.getShowResultTwo();
        FlexibleYearMonth サービス提供年月 = 引き継ぎ情報.getサービス提供年月();
        並べて表示エリア.getTxtTeikyoYMShowTwo().setValue(サービス提供年月 == null ? null : new RDate(サービス提供年月.toString()));

        KogakuShokaiHanteiKekkaParam parameter = new KogakuShokaiHanteiKekkaParam();
        parameter.setメニューID(メニューID);
        parameter.set提供年月(サービス提供年月);
        parameter.set被保険者番号(世帯員所得Selected.get(0).get被保険者番号());
        KogakuShokaiHanteiKekkaFinder finder = KogakuShokaiHanteiKekkaFinder.createInstance();
        KogakuShokaiHanteiKekkaResult 高額判定結果_左側 = finder.get支給判定結果(parameter);

        HanteiKekkaLDiv 並べて表示エリア_左側 = 並べて表示エリア.getSetaiinL().getHanteiKekkaL();
        並べて表示エリア_左側.getHanteiKekkaDetailL().getTxtHihoNoL().setValue(世帯員所得Selected.get(0).get被保険者番号().getColumnValue());
        // TODO QA911 氏名はEMPTYです。
        並べて表示エリア_左側.getHanteiKekkaDetailL().getTxtHihoNameR().setValue(世帯員所得Selected.get(0).get氏名());
        if (高額判定結果_左側 != null) {
            並べて表示エリア.getTxtSetaiShuyakuNo().setValue(高額判定結果_左側.get世帯集約番号());
            set並べて表示エリア_左側(高額判定結果_左側, 並べて表示エリア_左側);
        }

        HanteiKekkaRDiv 並べて表示エリア_右側 = 並べて表示エリア.getSetaiinR().getHanteiKekkaR();
        if (INDEX_イチ < 世帯員所得Selected.size()) {
            parameter.set被保険者番号(世帯員所得Selected.get(1).get被保険者番号());
            KogakuShokaiHanteiKekkaResult 高額判定結果_右側 = finder.get支給判定結果(parameter);
            並べて表示エリア_右側.getHanteiKekkaDetailR().getTxtHihoNoR().setValue(世帯員所得Selected.get(1).get被保険者番号().getColumnValue());
            // TODO QA911 氏名はEMPTYです。
            並べて表示エリア_右側.getHanteiKekkaDetailR().getTxtHihoNameL().setValue(世帯員所得Selected.get(1).get氏名());
            if (高額判定結果_右側 != null) {
                set並べて表示エリア_右側(高額判定結果_右側, 並べて表示エリア_右側);
            }
        }
    }

    private void set並べて表示エリア_左側(KogakuShokaiHanteiKekkaResult 高額判定結果_左側, HanteiKekkaLDiv 並べて表示エリア_左側) {
        List<dgJudgementResultL_Row> dataSources = new ArrayList<>();
        List<ShikyuMeisaiResult> 支給明細list = 高額判定結果_左側.get支給明細list();
        for (ShikyuMeisaiResult 支給明細entity : 支給明細list) {
            dgJudgementResultL_Row row = new dgJudgementResultL_Row();
            row.setTxtJigyosha(支給明細entity.get事業者名称().getColumnValue());
            ServiceShuruiCode サービス種類コード = 支給明細entity.getサービス種類コード();
            if (サービス種類コード != null && !サービス種類コード.isEmpty()) {
                row.setTxtServiceShurui(ServiceCategoryShurui.toValue(サービス種類コード.getColumnValue()).get略称());
            }
            row.getTxtServiceHiyoGokeigaku().setValue(支給明細entity.getサービス費用合計());
            row.getTxtRiyoshaFutangaku().setValue(支給明細entity.get利用者負担額());
            row.getTxtSanteiKijungaku().setValue(支給明細entity.get算定基準額());
            row.getTxtShiharaizumiKingaku().setValue(支給明細entity.get支払済金額());
            row.getTxtKogakuShikyugaku().setValue(支給明細entity.get高額支給額());
            dataSources.add(row);
        }
        並べて表示エリア_左側.getDgJudgementResultL().setDataSource(dataSources);
        並べて表示エリア_左側.getTxtBikoL().setValue(高額判定結果_左側.get高額給付根拠());
        FlexibleDate 受付年月日 = 高額判定結果_左側.get受付年月日();
        if (受付年月日 != null && !受付年月日.isEmpty()) {
            並べて表示エリア_左側.getTxtUketsukeDateL().setValue(new RDate(受付年月日.toString()));
        }
        FlexibleDate 決定年月日 = 高額判定結果_左側.get決定年月日();
        if (決定年月日 != null && !決定年月日.isEmpty()) {
            並べて表示エリア_左側.getTxtKetteiDateL().setValue(new RDate(決定年月日.toString()));
        }
        RString 審査方法区分 = 高額判定結果_左側.get審査方法区分();
        if (審査方法区分.isEmpty()) {
            並べて表示エリア_左側.getRadShinsaMethodL().setSelectedIndex(INDEX_ゼロ);
        } else {
            並べて表示エリア_左側.getRadShinsaMethodL().setSelectedKey(高額判定結果_左側.get審査方法区分());
        }
        並べて表示エリア_左側.getTxtShiharaiAmountL().setValue(高額判定結果_左側.get本人支払額());
        RString 支給区分 = 高額判定結果_左側.get支給区分コード();
        if (支給区分.isEmpty()) {
            並べて表示エリア_左側.getRadShikyuKubunL().setSelectedIndex(INDEX_ゼロ);
        } else {
            並べて表示エリア_左側.getRadShikyuKubunL().setSelectedKey(高額判定結果_左側.get支給区分コード());
        }
        並べて表示エリア_左側.getTxtShikyuAmountL().setValue(高額判定結果_左側.get支給金額());
        並べて表示エリア_左側.getTxtFushikyuRiyuL().setValue(高額判定結果_左側.get不支給理由());
        boolean 自動償還対象フラグ = 高額判定結果_左側.is自動償還対象フラグ();
        if (自動償還対象フラグ) {
            並べて表示エリア_左側.getRadKogakuAutoShokanL().setSelectedKey(JidoShokanTaishoKubun.あり.getコード());
        } else {
            並べて表示エリア_左側.getRadKogakuAutoShokanL().setSelectedKey(JidoShokanTaishoKubun.なし.getコード());
        }
    }

    private void clear並べて表示エリア() {
        ShowResultTwoDiv 並べて表示エリア = div.getShowResultTwo();
        並べて表示エリア.getTxtTeikyoYMShowTwo().clearValue();
        並べて表示エリア.getTxtSetaiShuyakuNo().clearValue();
        HanteiKekkaLDiv 並べて表示エリア_左側 = 並べて表示エリア.getSetaiinL().getHanteiKekkaL();
        HanteiKekkaRDiv 並べて表示エリア_右側 = 並べて表示エリア.getSetaiinR().getHanteiKekkaR();
        List<dgJudgementResultL_Row> dataSourcesL = new ArrayList<>();
        並べて表示エリア_左側.getDgJudgementResultL().setDataSource(dataSourcesL);
        並べて表示エリア_左側.getRadShinsaMethodL().setSelectedIndex(INDEX_ゼロ);
        並べて表示エリア_左側.getRadShikyuKubunL().setSelectedIndex(INDEX_ゼロ);
        並べて表示エリア_左側.getRadKogakuAutoShokanL().setSelectedKey(JidoShokanTaishoKubun.あり.getコード());
        並べて表示エリア_左側.getHanteiKekkaDetailL().getTxtHihoNoL().clearValue();
        並べて表示エリア_左側.getHanteiKekkaDetailL().getTxtHihoNameR().clearValue();
        並べて表示エリア_左側.getTxtBikoL().clearValue();
        並べて表示エリア_左側.getTxtUketsukeDateL().clearValue();
        並べて表示エリア_左側.getTxtKetteiDateL().clearValue();
        並べて表示エリア_左側.getTxtShiharaiAmountL().clearValue();
        並べて表示エリア_左側.getTxtShikyuAmountL().clearValue();
        並べて表示エリア_左側.getTxtFushikyuRiyuL().clearValue();
        List<dgJudgementResultR_Row> dataSources = new ArrayList<>();
        並べて表示エリア_右側.getDgJudgementResultR().setDataSource(dataSources);
        並べて表示エリア_右側.getRadShinsaMethodR().setSelectedIndex(INDEX_ゼロ);
        並べて表示エリア_右側.getRadShikyuKubunR().setSelectedIndex(INDEX_ゼロ);
        並べて表示エリア_右側.getRadKogakuAutoShokanR().setSelectedKey(JidoShokanTaishoKubun.あり.getコード());
        並べて表示エリア_右側.getHanteiKekkaDetailR().getTxtHihoNoR().clearValue();
        並べて表示エリア_右側.getHanteiKekkaDetailR().getTxtHihoNameL().clearValue();
        並べて表示エリア_右側.getTxtBikoR().clearValue();
        並べて表示エリア_右側.getTxtUketsukeDateR().clearValue();
        並べて表示エリア_右側.getTxtKetteiDateR().clearValue();
        並べて表示エリア_右側.getTxtShiharaiAmountR().clearValue();
        並べて表示エリア_右側.getTxtShikyuAmountR().clearValue();
        並べて表示エリア_右側.getTxtFushikyuRiyuR().clearValue();
    }

    private void set並べて表示エリア_右側(KogakuShokaiHanteiKekkaResult 高額判定結果_右側, HanteiKekkaRDiv 並べて表示エリア_右側) {
        List<dgJudgementResultR_Row> dataSources = new ArrayList<>();
        List<ShikyuMeisaiResult> 支給明細list = 高額判定結果_右側.get支給明細list();
        for (ShikyuMeisaiResult 支給明細entity : 支給明細list) {
            dgJudgementResultR_Row row = new dgJudgementResultR_Row();
            row.setTxtJigyosha(支給明細entity.get事業者名称().getColumnValue());
            ServiceShuruiCode サービス種類コード = 支給明細entity.getサービス種類コード();
            if (サービス種類コード != null && !サービス種類コード.isEmpty()) {
                row.setTxtServiceShurui(ServiceCategoryShurui.toValue(サービス種類コード.getColumnValue()).get略称());
            }
            row.getTxtServiceHiyoGokeigaku().setValue(支給明細entity.getサービス費用合計());
            row.getTxtRiyoshaFutangaku().setValue(支給明細entity.get利用者負担額());
            row.getTxtSanteiKijungaku().setValue(支給明細entity.get算定基準額());
            row.getTxtShiharaizumigaku().setValue(支給明細entity.get支払済金額());
            row.getTxtKogakuShikyugaku().setValue(支給明細entity.get高額支給額());
            dataSources.add(row);
        }
        並べて表示エリア_右側.getDgJudgementResultR().setDataSource(dataSources);
        並べて表示エリア_右側.getTxtBikoR().setValue(高額判定結果_右側.get高額給付根拠());
        FlexibleDate 受付年月日 = 高額判定結果_右側.get受付年月日();
        if (受付年月日 != null && !受付年月日.isEmpty()) {
            並べて表示エリア_右側.getTxtUketsukeDateR().setValue(new RDate(受付年月日.toString()));
        }
        FlexibleDate 決定年月日 = 高額判定結果_右側.get決定年月日();
        if (決定年月日 != null && !決定年月日.isEmpty()) {
            並べて表示エリア_右側.getTxtKetteiDateR().setValue(new RDate(決定年月日.toString()));
        }
        RString 審査方法区分 = 高額判定結果_右側.get審査方法区分();
        if (審査方法区分.isEmpty()) {
            並べて表示エリア_右側.getRadShinsaMethodR().setSelectedIndex(INDEX_ゼロ);
        } else {
            並べて表示エリア_右側.getRadShinsaMethodR().setSelectedKey(高額判定結果_右側.get審査方法区分());
        }
        並べて表示エリア_右側.getTxtShiharaiAmountR().setValue(高額判定結果_右側.get本人支払額());
        RString 支給区分 = 高額判定結果_右側.get支給区分コード();
        if (支給区分.isEmpty()) {
            並べて表示エリア_右側.getRadShikyuKubunR().setSelectedIndex(INDEX_ゼロ);
        } else {
            並べて表示エリア_右側.getRadShikyuKubunR().setSelectedKey(高額判定結果_右側.get支給区分コード());
        }
        並べて表示エリア_右側.getTxtShikyuAmountR().setValue(高額判定結果_右側.get支給金額());
        並べて表示エリア_右側.getTxtFushikyuRiyuR().setValue(高額判定結果_右側.get不支給理由());
        boolean 自動償還対象フラグ = 高額判定結果_右側.is自動償還対象フラグ();
        if (自動償還対象フラグ) {
            並べて表示エリア_右側.getRadKogakuAutoShokanR().setSelectedKey(JidoShokanTaishoKubun.あり.getコード());
        } else {
            並べて表示エリア_右側.getRadKogakuAutoShokanR().setSelectedKey(JidoShokanTaishoKubun.なし.getコード());
        }
    }

    private void 操作可否確認(List<SetaiinShotoku> 世帯員所得Selected) {
        if (世帯員所得Selected == null || 世帯員所得Selected.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者を選択.getMessage().evaluate());
        }
        // TODO QA902 給付実績より同月サービス情報を取得部分は未実装  SetaiinShotokuJohoFinder
//        for (SetaiinShotoku 世帯員所得 : 世帯員所得Selected) {
//            if (!世帯員所得.is同月サービス有無()) {
//                世帯員所得.
//                throw new ApplicationException(DbcErrorMessages.同月サービスなし世帯員.getMessage().evaluate());
//            }
//        }
    }

    private List<KeyValueDataSource> get審査方法() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource keyValue_依頼 = new KeyValueDataSource(ShinsaHohoKubun.審査依頼.getコード(), ShinsaHohoKubun.審査依頼.get名称());
        KeyValueDataSource keyValue_済み = new KeyValueDataSource(ShinsaHohoKubun.審査済み.getコード(), ShinsaHohoKubun.審査済み.get名称());
        dataSource.add(keyValue_依頼);
        dataSource.add(keyValue_済み);
        return dataSource;
    }

    private List<KeyValueDataSource> get支給区分() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource keyValue_支給 = new KeyValueDataSource(ShikyuKubun.支給.getコード(), ShikyuKubun.支給.get名称());
        KeyValueDataSource keyValue_不支給 = new KeyValueDataSource(ShikyuKubun.不支給.getコード(), ShikyuKubun.不支給.get名称());
        dataSource.add(keyValue_支給);
        dataSource.add(keyValue_不支給);
        return dataSource;
    }

    private List<KeyValueDataSource> get高額自動償還() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource keyValue_あり = new KeyValueDataSource(JidoShokanTaishoKubun.あり.getコード(), JidoShokanTaishoKubun.あり.get名称());
        KeyValueDataSource keyValue_なし = new KeyValueDataSource(JidoShokanTaishoKubun.なし.getコード(), JidoShokanTaishoKubun.なし.get名称());
        dataSource.add(keyValue_あり);
        dataSource.add(keyValue_なし);
        return dataSource;
    }

}
