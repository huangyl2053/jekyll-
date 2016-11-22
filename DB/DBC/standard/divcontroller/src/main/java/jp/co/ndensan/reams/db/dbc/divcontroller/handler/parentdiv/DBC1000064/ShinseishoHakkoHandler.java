/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000064;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000064.ShinseishoHakkoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku.TekiyoShinseishoManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 基準収入額適用申請書_年次分作成のクラスです。
 *
 * @reamsid_L DBC-4630-010 lihang
 */
public class ShinseishoHakkoHandler {

    private final ShinseishoHakkoDiv div;
    private static final int INDEX_4 = 4;
    private static final int INDEX_8 = 8;
    private static final int INDEX_101 = 101;
    private static final int INDEX_731 = 731;
    private static final int INDEX_801 = 801;
    private static final int INDEX_1231 = 1231;
    private static final RString 日 = new RString("0801");
    private static final RString 本年７月中 = new RString("本年７月中");

    /**
     * コンストラクタです。
     *
     *
     * @param div ShinseishoHakkoDiv
     */
    public ShinseishoHakkoHandler(ShinseishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * set初期化処理事件ことです。
     *
     */
    public void set初期化処理() {
        div.getRadChushutsuJoken().setDataSource(get申請書発行_抽出条件());
        set抽出条件表示制御処理();
        if (INDEX_101 <= Integer.valueOf((RDate.getNowDate().toString().substring(INDEX_4, INDEX_8)))
                && Integer.valueOf(RDate.getNowDate().toString().substring(INDEX_4, INDEX_8)) <= INDEX_731) {
            div.getTxtShoriNendo().setValue(FlexibleDate.getNowDate().minusYear(1));
        } else if (INDEX_801 <= Integer.valueOf(RDate.getNowDate().toString().substring(INDEX_4, INDEX_8))
                && Integer.valueOf(RDate.getNowDate().toString().substring(INDEX_4, INDEX_8)) <= INDEX_1231) {
            div.getTxtShoriNendo().setValue(FlexibleDate.getNowDate());
        }
        FlexibleDate 世帯員把握基準日基準日 = new FlexibleDate(YMDHMS.now().getYear()
                .toDateString().concat(日));
        div.getTxtSetaiinHaakuKijunYMD().setValue(世帯員把握基準日基準日);
        div.getTxtTeishutsuKigen().setValue(本年７月中);
        FlexibleDate 作成日 = new FlexibleDate(YMDHMS.now().getDate().toDateString());
        div.getTxtSakuseiYMD().setValue(作成日);
        div.getChkTsuchisho().setSelectedItems(div.getChkTsuchisho().getDataSource());
        div.getChkShinseisho().setSelectedItems(div.getChkShinseisho().getDataSource());
        div.getChkIchiranhyoCsv().setSelectedItems(div.getChkIchiranhyoCsv().getDataSource());
        div.getCcdBunshoBangoInput().initialize(ReportIdDBC.DBC100064.getReportId(), 作成日);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100075.getReportId());
    }

    private List<KeyValueDataSource> get申請書発行_抽出条件() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShinseishoHakkoChushutsuJoken 申請書発行_抽出条件 : ShinseishoHakkoChushutsuJoken.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請書発行_抽出条件.getコード(), 申請書発行_抽出条件.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 前排他のンメソッドです。
     *
     *
     */
    public void set前排他() {
        LockingKey 前排他キー = new LockingKey(ResponseHolder.getMenuID());
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
    }

    /**
     * 前排他のreleaseです。
     *
     *
     */
    public void release前排他() {
        LockingKey 排他キー = new LockingKey(ResponseHolder.getMenuID());
        RealInitialLocker.release(排他キー);
    }

    /**
     * 抽出条件表示制御処理。
     *
     *
     */
    public void set抽出条件表示制御処理() {

        if (ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(
                div.getRadChushutsuJoken().getSelectedKey())) {
            div.getTxtShoriNendo().setDisabled(false);
            div.getBtnSearchHihokensha().setDisabled(true);
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getTxtSetaiinHaakuKijunYMD().setDisabled(false);
        } else if (ShinseishoHakkoChushutsuJoken.被保険者番号.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())) {
            div.getTxtShoriNendo().setDisabled(true);
            div.getBtnSearchHihokensha().setDisabled(false);
            div.getTxtHihokenshaNo().setDisabled(false);
            div.getTxtSetaiinHaakuKijunYMD().setDisabled(false);
        } else {
            div.getTxtShoriNendo().setDisabled(true);
            div.getBtnSearchHihokensha().setDisabled(true);
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getTxtSetaiinHaakuKijunYMD().setDisabled(true);
        }
    }

    /**
     * 異動処理が実施済みか判定
     *
     * @return boolean
     */
    public boolean is異動処理が実施済みか判定() {
        if (ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(
                div.getRadChushutsuJoken().getSelectedKey())) {
            return TekiyoShinseishoManager.createInstance().isIdoExecute(
                    new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4)));
        }
        if (ShinseishoHakkoChushutsuJoken.被保険者番号.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())) {
            return TekiyoShinseishoManager.createInstance().isIdoExecute(
                    new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4)));
        } else {
            return false;
        }

    }
}
