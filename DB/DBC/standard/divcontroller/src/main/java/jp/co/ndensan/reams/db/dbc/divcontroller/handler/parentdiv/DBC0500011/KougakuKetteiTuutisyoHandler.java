/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0500011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.servicenokanribangourendou.JigyouKetteiTutisyoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0500011.KougakuKetteiTuutisyoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kogakuservicehiketteitsuchishotan.KogakuServicehiKetteiTsuchishoTan;
import jp.co.ndensan.reams.db.dbc.service.core.kougakuketteituutisyo.KougakuKetteiTuutisyoManager;
import jp.co.ndensan.reams.db.dbc.service.report.dbc100107.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiPrintService;
import jp.co.ndensan.reams.db.dbc.service.report.dbc100108.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMN43005_高額サービス費支給決定通知書（単）のHandlerクラスです。
 *
 * @reamsid_L DBC-5160-010 chenxin
 */
public class KougakuKetteiTuutisyoHandler {

    private static final RString 定数_初回申請用 = new RString("key0");
    private static final RString 画面_初回申請用様式 = new RString("0");
    private static final RString 画面_自動償還用様式 = new RString("1");
    private static final RString 決定通知リアル発行区分_発行済 = new RString("1");

    /**
     * サービス提供年月ドロップダウンリストを設定する。
     *
     * @param サービス提供年月リスト List<FlexibleYearMonth>
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> onLoad_ddlServiceYearMonth(List<FlexibleYearMonth> サービス提供年月リスト) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (FlexibleYearMonth yearMonth : サービス提供年月リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(yearMonth.toDateString());
            dataSource.setValue(yearMonth.wareki().toDateString());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * サービス提供年月ドロップダウンリストの選択値より、管理番号リストの内容を変更する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @param 被保険者番号 HihokenshaNo
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> onLoad_ddlKanliBanngou(KougakuKetteiTuutisyoDiv div, HihokenshaNo 被保険者番号) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        int index = 1;
        KougakuKetteiTuutisyoManager manager = KougakuKetteiTuutisyoManager.createInstance();
        List<RString> 管理番号リスト = manager.get管理番号(
                被保険者番号,
                new FlexibleYearMonth(div.getDdlServiceYearMonth().getSelectedKey()));
        for (RString 管理番号 : 管理番号リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString("key").concat(new RString(index++)));
            dataSource.setValue(管理番号);
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 管理番号ドロップダウンリストの表示データによって前回作成日も変更する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @param 被保険者番号 HihokenshaNo
     */
    public void onLoad_txtZennkaiHakkoubi(KougakuKetteiTuutisyoDiv div, HihokenshaNo 被保険者番号) {
        KougakuKetteiTuutisyoManager manager = KougakuKetteiTuutisyoManager.createInstance();
        FlexibleDate dateValue = manager.get前回発行日(
                被保険者番号,
                new FlexibleYearMonth(div.getDdlServiceYearMonth().getSelectedKey()),
                Integer.valueOf(div.getDdlKanliBanngou().getSelectedValue().toString()));
        if (!dateValue.isEmpty()) {
            div.getTxtZennkaiHakkoubi().setValue(new RDate(dateValue.toString()));
        }
    }

    /**
     * DBを更新する。
     *
     * @param div KougakuKetteiTuutisyoDiv
     * @param 被保険者番号 HihokenshaNo
     */
    public void ＤＢ更新(KougakuKetteiTuutisyoDiv div, HihokenshaNo 被保険者番号) {
        KougakuKetteiTuutisyoManager manager = KougakuKetteiTuutisyoManager.createInstance();
        KogakuShikyuHanteiKekka kogakuShikyuHanteiKekka = manager.更新データ読み込み(
                被保険者番号,
                new FlexibleYearMonth(div.getDdlServiceYearMonth().getSelectedKey()),
                Integer.valueOf(div.getDdlKanliBanngou().getSelectedValue().toString()));
        kogakuShikyuHanteiKekka = kogakuShikyuHanteiKekka.createBuilderForEdit()
                .set決定通知書作成年月日(new FlexibleDate(div.getTxtHakkoubi().getValue().toDateString()))
                .set決定通知リアル発行区分(決定通知リアル発行区分_発行済)
                .build()
                .modified();
        manager.save(kogakuShikyuHanteiKekka);
    }

    /**
     * ビジネスを呼び出す、帳票発行判定を行う、帳票を発行する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param div KougakuKetteiTuutisyoDiv
     * @return SourceDataCollection
     */
    public SourceDataCollection 帳票印刷(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, KougakuKetteiTuutisyoDiv div) {
        RString 様式 = 画面_初回申請用様式;
        if (!定数_初回申請用.equals(div.getRadSyoukaiSinnsei().getSelectedKey())) {
            様式 = 画面_自動償還用様式;
        }
        FlexibleDate 支払予定日 = FlexibleDate.EMPTY;
        if (div.getTxtSiharaiYoteibi().isVisible() && div.getTxtSiharaiYoteibi().getValue() != null) {
            支払予定日 = new FlexibleDate(div.getTxtSiharaiYoteibi().getValue().toDateString());
        }
        HokenshaNo 証記載保険者番号 = new HokenshaNo(div.getKyoTuuKaigoNinnteiSikaku().getHookenshaCode());
        KogakuServicehiKetteiTsuchishoTan 帳票情報Mgr = KogakuServicehiKetteiTsuchishoTan.createInstance();
        JigyouKetteiTutisyoResult 帳票情報Result = 帳票情報Mgr.editTsuchisho(
                div.getKougakuKetteiTuutisyoBunsho().get文書番号(),
                new FlexibleDate(div.getTxtHakkoubi().getValue().toDateString()),
                被保険者番号,
                new FlexibleYearMonth(div.getDdlServiceYearMonth().getSelectedKey()),
                様式,
                Integer.valueOf(div.getDdlKanliBanngou().getSelectedValue().toString()),
                識別コード,
                支払予定日,
                証記載保険者番号,
                div.getKyoTuuKaigoAtena().get氏名漢字()
        );
        if (div.getTxtSiharaiYoteibi().isVisible()) {
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriPrintService printAri = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriPrintService();
            return printAri.printSingle(帳票情報Result, 被保険者番号, 識別コード, new FlexibleDate(div.getTxtHakkoubi().getValue().toDateString()));
        } else {
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiPrintService printNashi = new KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiPrintService();
            return printNashi.printSingle(帳票情報Result, 被保険者番号, 識別コード, new FlexibleDate(div.getTxtHakkoubi().getValue().toDateString()));
        }
    }
}
