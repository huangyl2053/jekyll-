/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000014.FutanWariaiShoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBCMNK3001_負担割合証発行（一括）のHandlerクラスです。
 *
 * @reamsid_L DBC-4990-010 pengxingyi
 */
public class FutanWariaiShoHakkoHandler {

    private final FutanWariaiShoHakkoPanelDiv div;
    private final ShoriDateKanriManager manager;
    private final RDateTime dateTime;

    private static final int NUM_ONE = 1;
    private static final int NUM_SEVEN = 7;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 全件 = new RString("全件");
    private static final RString 異動分 = new RString("異動分");
    private static final RString 新規認定分 = new RString("新規認定分");
    private static final RString 未発行 = new RString("未発行");
    private static final RString 発行済み = new RString("発行済み");
    private static final RString 全て = new RString("全て");
    private static final RString 処理枝番_0000 = new RString("0000");
    private static final RString 処理枝番_0001 = new RString("0001");
    private static final RString 処理枝番_0002 = new RString("0002");
    private static final RString 実行 = new RString("btnBatchRegister");

    /**
     * コンストラクタです。
     *
     * @param div PanelAllDiv
     */
    public FutanWariaiShoHakkoHandler(FutanWariaiShoHakkoPanelDiv div) {
        manager = new ShoriDateKanriManager();
        dateTime = RDate.getNowDateTime();
        this.div = div;
    }

    /**
     * 画面コントロールの初期化処理を行います。
     */
    public void initControl() {
        setDdlNendo();
        FlexibleYear 年度 = new FlexibleYear(div.getPanelJoken().getDdlNendo().getSelectedKey());
        RString 今回処理区分 = get当初発行チェック(年度, ONE);
        if (ZERO.equals(今回処理区分) || TWO.equals(今回処理区分)) {
            setRadKubun();
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            div.getPanelJoken().getRadKubun().setDisabledItem(dataSource);
            div.getPanelJoken().getRadKubun().setSelectedKey(ONE);
            setRadHakkoKubun();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(ZERO);
        } else if (ONE.equals(今回処理区分)) {
            setRadKubun();
            setDisableRadKubun();
            div.getPanelJoken().getRadKubun().setSelectedKey(ZERO);
            setRadHakkoKubun();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(TWO);
        }
        div.getPanelJoken().getTxtKofubi().setValue(RDate.getNowDate());
        抽出期間の設定(年度, ONE, 今回処理区分);
        div.getCcdShutsuryokuJun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100065.getReportId());
    }

    /**
     * 年度変更の処理を行います。
     */
    public void onChangeNendo() {
        FlexibleYear 年度 = new FlexibleYear(div.getPanelJoken().getDdlNendo().getSelectedKey());
        RString 今回処理区分 = get当初発行チェック(年度, ONE);
        if (ZERO.equals(今回処理区分) || TWO.equals(今回処理区分)) {
            setRadKubun();
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            div.getPanelJoken().getRadKubun().setDisabledItem(dataSource);
            div.getPanelJoken().getRadKubun().setSelectedKey(ONE);
            setRadHakkoKubun();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(ZERO);
        } else if (ONE.equals(今回処理区分)) {
            setRadKubun();
            setDisableRadKubun();
            div.getPanelJoken().getRadKubun().setSelectedKey(ZERO);
            setRadHakkoKubun();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(TWO);
        }
        抽出期間の設定(年度, ONE, 今回処理区分);
    }

    /**
     * 出力対象の処理を行います。
     */
    public void onChangeKubun() {
        FlexibleYear 年度 = new FlexibleYear(div.getPanelJoken().getDdlNendo().getSelectedKey());
        RString 出力対象 = div.getPanelJoken().getRadKubun().getSelectedKey();
        if (ZERO.equals(出力対象)) {
            clearIdoTaishoKikan();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(TWO);
            return;
        }
        RString 今回処理区分 = get当初発行チェック(年度, 出力対象);
        if (ZERO.equals(今回処理区分) || TWO.equals(今回処理区分)) {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            div.getPanelJoken().getRadKubun().setDisabledItem(dataSource);
            setRadKubun();
            div.getPanelJoken().getRadKubun().setSelectedKey(ONE);
            setRadHakkoKubun();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(ZERO);
        } else if (ONE.equals(今回処理区分)) {
            setRadKubun();
            setDisableRadKubun();
            div.getPanelJoken().getRadKubun().setSelectedKey(ZERO);
            setRadHakkoKubun();
            div.getPanelJoken().getRadHakkoKubun().setSelectedKey(TWO);
        }
        抽出期間の設定(年度, ONE, 今回処理区分);

    }

    private void setDisableRadKubun() {
        KeyValueDataSource 出力対象_1 = new KeyValueDataSource();
        出力対象_1.setKey(ONE);
        出力対象_1.setValue(異動分);
        KeyValueDataSource 出力対象_2 = new KeyValueDataSource();
        出力対象_2.setKey(TWO);
        出力対象_2.setValue(新規認定分);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(出力対象_1);
        dataSource.add(出力対象_2);
        div.getPanelJoken().getRadKubun().setDisabledItem(dataSource);
    }

    private void setRadKubun() {
        KeyValueDataSource 出力対象_0 = new KeyValueDataSource();
        出力対象_0.setKey(ZERO);
        出力対象_0.setValue(全件);
        KeyValueDataSource 出力対象_1 = new KeyValueDataSource();
        出力対象_1.setKey(ONE);
        出力対象_1.setValue(異動分);
        KeyValueDataSource 出力対象_2 = new KeyValueDataSource();
        出力対象_2.setKey(TWO);
        出力対象_2.setValue(新規認定分);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(出力対象_0);
        dataSource.add(出力対象_1);
        dataSource.add(出力対象_2);
        div.getPanelJoken().getRadKubun().setDataSource(dataSource);
    }

    private void setRadHakkoKubun() {
        KeyValueDataSource 発行区分_0 = new KeyValueDataSource();
        発行区分_0.setKey(ZERO);
        発行区分_0.setValue(未発行);
        KeyValueDataSource 発行区分_1 = new KeyValueDataSource();
        発行区分_1.setKey(ONE);
        発行区分_1.setValue(発行済み);
        KeyValueDataSource 発行区分_2 = new KeyValueDataSource();
        発行区分_2.setKey(TWO);
        発行区分_2.setValue(全て);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(発行区分_0);
        dataSource.add(発行区分_1);
        dataSource.add(発行区分_2);
        div.getPanelJoken().getRadHakkoKubun().setDataSource(dataSource);
    }

    private ShoriDateKanri get直近の年次負担割合判定処理() {
        return manager.select直近の年次負担割合判定();
    }

    private void setDdlNendo() {
        List<KeyValueDataSource> list = new ArrayList<>();
        ShoriDateKanri entity = get直近の年次負担割合判定処理();
        FlexibleDate date = new FlexibleDate(dateTime.getDate().toDateString());
        FlexibleYear 処理年度 = date.getMonthValue() > NUM_SEVEN ? date.getYear() : date.getYear().minusYear(NUM_ONE);
        if (entity == null || entity.get年度().isBefore(処理年度)) {
            throw new ApplicationException(DbcErrorMessages.年次判定未処理.getMessage());
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, false);
        div.setDisabled(false);
        FlexibleYear 年次判定年度 = entity.get年度();
        if (処理年度.equals(年次判定年度)) {
            KeyValueDataSource keyValueData = new KeyValueDataSource(処理年度.toDateString(), 処理年度.wareki().toDateString());
            list.add(keyValueData);
        }
        if (処理年度.isBefore(年次判定年度)) {
            KeyValueDataSource keyValueData1 = new KeyValueDataSource(処理年度.toDateString(), 処理年度.wareki().toDateString());
            list.add(keyValueData1);
            KeyValueDataSource keyValueData2 = new KeyValueDataSource(年次判定年度.toDateString(), 年次判定年度.wareki().toDateString());
            list.add(keyValueData2);
        }
        div.getPanelJoken().getDdlNendo().setDataSource(list);
        div.getPanelJoken().getDdlNendo().setSelectedIndex(0);
    }

    private RString get当初発行チェック(FlexibleYear 年度, RString 出力対象) {
        if (manager.select当初発行チェック(年度, 処理枝番_0000) == null) {
            return ONE;
        } else if (ONE.equals(出力対象)) {
            if (manager.select当初発行チェック(年度, 処理枝番_0001) != null) {
                return ZERO;
            }
            return TWO;
        } else {
            if (manager.select当初発行チェック(年度, 処理枝番_0002) != null) {
                return ZERO;
            }
            return TWO;
        }
    }

    private void 抽出期間の設定(FlexibleYear 年度, RString 出力対象, RString 今回処理区分) {
        if (ZERO.equals(今回処理区分)) {
            ShoriDateKanri shoriDateKanri;
            if (ONE.equals(出力対象)) {
                shoriDateKanri = manager.select当初発行チェック(年度, 処理枝番_0001);
            } else {
                shoriDateKanri = manager.select当初発行チェック(年度, 処理枝番_0002);
            }
            if (shoriDateKanri == null) {
                div.getPanelKikan().getTxtZenkaiKaishiDate().clearValue();
                div.getPanelKikan().getTxtZenkaiKaishiTime().clearValue();
                div.getPanelKikan().getTxtZenkaiShuryoDate().clearValue();
                div.getPanelKikan().getTxtZenkaiShuryoTime().clearValue();
                div.getPanelKikan().getTxtKonkaiKaishiDate().clearValue();
                div.getPanelKikan().getTxtKonkaiKaishiTime().clearValue();
            } else {
                div.getPanelKikan().getTxtZenkaiKaishiDate().setValue(shoriDateKanri.get対象開始日時().getRDateTime().getDate());
                div.getPanelKikan().getTxtZenkaiKaishiTime().setValue(shoriDateKanri.get対象開始日時().getRDateTime().getTime());
                div.getPanelKikan().getTxtZenkaiShuryoDate().setValue(shoriDateKanri.get対象終了日時().getRDateTime().getDate());
                div.getPanelKikan().getTxtZenkaiShuryoTime().setValue(shoriDateKanri.get対象終了日時().getRDateTime().getTime());
                div.getPanelKikan().getTxtKonkaiKaishiDate().setValue(shoriDateKanri.get対象終了日時().getRDateTime().getDate());
                div.getPanelKikan().getTxtKonkaiKaishiTime().setValue(shoriDateKanri.get対象終了日時().getRDateTime().getTime());
            }
            div.getPanelKikan().getTxtKonkaiShuryoDate().setValue(dateTime.getDate());
            div.getPanelKikan().getTxtKonkaiShuryoTime().setValue(dateTime.getTime());
            div.getPanelKikan().getTxtZenkaiKaishiDate().setReadOnly(true);
            div.getPanelKikan().getTxtZenkaiKaishiTime().setReadOnly(true);
            div.getPanelKikan().getTxtZenkaiShuryoDate().setReadOnly(true);
            div.getPanelKikan().getTxtZenkaiShuryoTime().setReadOnly(true);
            div.getPanelKikan().getTxtKonkaiKaishiDate().setReadOnly(false);
            div.getPanelKikan().getTxtKonkaiKaishiTime().setReadOnly(false);
            div.getPanelKikan().getTxtKonkaiShuryoDate().setReadOnly(true);
            div.getPanelKikan().getTxtKonkaiShuryoTime().setReadOnly(true);
        } else if (ONE.equals(今回処理区分)) {
            clearIdoTaishoKikan();
        } else {
            ShoriDateKanri shoriDateKanri = manager.select当初発行チェック(年度, 処理枝番_0000);
            div.getPanelKikan().getTxtZenkaiKaishiDate().clearValue();
            div.getPanelKikan().getTxtZenkaiKaishiTime().clearValue();
            if (shoriDateKanri == null) {
                div.getPanelKikan().getTxtZenkaiShuryoDate().clearValue();
                div.getPanelKikan().getTxtZenkaiShuryoTime().clearValue();
                div.getPanelKikan().getTxtKonkaiKaishiDate().clearValue();
                div.getPanelKikan().getTxtKonkaiKaishiTime().clearValue();
            } else {
                div.getPanelKikan().getTxtZenkaiShuryoDate().setValue(shoriDateKanri.get基準日時().getRDateTime().getDate());
                div.getPanelKikan().getTxtZenkaiShuryoTime().setValue(shoriDateKanri.get基準日時().getRDateTime().getTime());
                div.getPanelKikan().getTxtKonkaiKaishiDate().setValue(shoriDateKanri.get基準日時().getRDateTime().getDate());
                div.getPanelKikan().getTxtKonkaiKaishiTime().setValue(shoriDateKanri.get基準日時().getRDateTime().getTime());
            }
            div.getPanelKikan().getTxtKonkaiShuryoDate().setValue(dateTime.getDate());
            div.getPanelKikan().getTxtKonkaiShuryoTime().setValue(dateTime.getTime());
            div.getPanelKikan().getTxtZenkaiKaishiDate().setReadOnly(true);
            div.getPanelKikan().getTxtZenkaiKaishiTime().setReadOnly(true);
            div.getPanelKikan().getTxtZenkaiShuryoDate().setReadOnly(true);
            div.getPanelKikan().getTxtZenkaiShuryoTime().setReadOnly(true);
            div.getPanelKikan().getTxtKonkaiKaishiDate().setReadOnly(false);
            div.getPanelKikan().getTxtKonkaiKaishiTime().setReadOnly(false);
            div.getPanelKikan().getTxtKonkaiShuryoDate().setReadOnly(true);
            div.getPanelKikan().getTxtKonkaiShuryoTime().setReadOnly(true);
        }
    }

    private void clearIdoTaishoKikan() {
        div.getPanelKikan().getTxtZenkaiKaishiDate().clearValue();
        div.getPanelKikan().getTxtZenkaiKaishiDate().setReadOnly(true);
        div.getPanelKikan().getTxtZenkaiKaishiTime().clearValue();
        div.getPanelKikan().getTxtZenkaiKaishiTime().setReadOnly(true);
        div.getPanelKikan().getTxtZenkaiShuryoDate().clearValue();
        div.getPanelKikan().getTxtZenkaiShuryoDate().setReadOnly(true);
        div.getPanelKikan().getTxtZenkaiShuryoTime().clearValue();
        div.getPanelKikan().getTxtZenkaiShuryoTime().setReadOnly(true);
        div.getPanelKikan().getTxtKonkaiKaishiDate().clearValue();
        div.getPanelKikan().getTxtKonkaiKaishiDate().setReadOnly(true);
        div.getPanelKikan().getTxtKonkaiKaishiTime().clearValue();
        div.getPanelKikan().getTxtKonkaiKaishiTime().setReadOnly(true);
        div.getPanelKikan().getTxtKonkaiShuryoDate().clearValue();
        div.getPanelKikan().getTxtKonkaiShuryoDate().setReadOnly(true);
        div.getPanelKikan().getTxtKonkaiShuryoTime().clearValue();
        div.getPanelKikan().getTxtKonkaiShuryoTime().setReadOnly(true);
    }
}
