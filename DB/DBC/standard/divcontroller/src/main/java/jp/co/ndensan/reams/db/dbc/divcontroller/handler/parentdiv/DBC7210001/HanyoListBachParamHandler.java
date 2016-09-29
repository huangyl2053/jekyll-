/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7210001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710210.DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7210001.ZigyoubunkougakugassanshikyuuketteJouhouDiv;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCGM23021_汎用リスト_事業分高額合算支給決定情報。
 *
 * @reamsid_L DBC-5060-010 wanghui
 */
public class HanyoListBachParamHandler {

    private final ZigyoubunkougakugassanshikyuuketteJouhouDiv div;
    private KaigoDonyuKeitaiManager manager;
    private static final RString 項目名付加 = new RString("6");
    private static final RString 連番付加 = new RString("7");
    private static final RString 日付_編集 = new RString("8");
    private static final int 固定 = 2014;
    private static final int 固定_月 = 8;
    private static final RString すべて = new RString("0");
    private static final RString 窓口払 = new RString("1");
    private static final RString 口座払 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div 事業分高額合算支給決定情報２
     */
    public HanyoListBachParamHandler(ZigyoubunkougakugassanshikyuuketteJouhouDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     */
    public void onLoad() {
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701021.getReportId());
        manager = KaigoDonyuKeitaiManager.createInstance();
        List<KaigoDonyuKeitai> list = manager.get介護導入形態By業務分類(GyomuBunrui.介護事務);
        if (list.get(0).get導入形態コード().is単一()) {
            div.getCcdHokenshaList().setDisplayNone(true);
        }
        if (list.get(0).get導入形態コード().is広域()) {
            div.getCcdHokenshaList().setDisplayNone(false);
            div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        RDate systemDate = RDate.getNowDate();
        RYear year;
        if (systemDate.getMonthValue() >= 固定_月) {
            year = systemDate.getYear().plusYear(1);
        } else {
            year = systemDate.getYear();
        }
        for (int i = 0; i < year.minusYear(固定).getYearValue(); i++) {
            KeyValueDataSource source = new KeyValueDataSource();
            source.setKey(new RString(固定 + i));
            source.setValue(new RDate(固定 + i).getYear().wareki().toDateString());
            dataSource.add(source);
        }
        if (!dataSource.isEmpty()) {
            Collections.sort(dataSource, new Comparator<KeyValueDataSource>() {
                @Override
                public int compare(KeyValueDataSource entity1, KeyValueDataSource entity2) {
                    return entity2.getKey().compareTo(entity1.getKey());
                }
            });
        }
        div.getDdlTaishoNendo().setDataSource(dataSource);
        List<RString> ckboxlist = new ArrayList<>();
        ckboxlist.add(項目名付加);
        ckboxlist.add(日付_編集);
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(ckboxlist);
    }

    /**
     * 「条件を保存する」ボタンを押下時、バッチパラメータを保存します。
     *
     * @return DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter
     */
    public DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter setBatchParameter() {
        DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter parameter = new DBC710210_HanyoListJigyoBunKogakuGassanShikyuKetteiParameter();
        parameter.set帳票ID(ReportIdDBC.DBC701021.getReportId().value());
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            parameter.set出力順ID(div.getCcdShutsuryokujun().get出力順ID());
        }
        parameter.set出力順項目ID(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        boolean 項目付加 = false;
        boolean 連番の付加 = false;
        boolean 日付スラッシュ編集 = false;
        for (RString keys : div.getChkCsvHenshuHoho().getSelectedKeys()) {
            if (keys.equals(項目名付加)) {
                項目付加 = true;
            }
            if (keys.equals(連番付加)) {
                連番の付加 = true;
            }
            if (keys.equals(日付_編集)) {
                日付スラッシュ編集 = true;
            }
        }
        parameter.set日付編集(日付スラッシュ編集);
        parameter.set連番付加(連番の付加);
        parameter.set項目名付加(項目付加);
        if (!div.getCcdHokenshaList().isDisplayNone()) {
            if (div.getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                parameter.set保険者コード(new RString("000000"));
            } else {
                parameter.set保険者コード(div.getCcdHokenshaList().getSelectedItem().get市町村コード().value());
            }
        }
        List<RString> 支給区分list = new ArrayList<>();
        if (すべて.equals(div.getRadShikyuKubun().getSelectedKey())) {
            支給区分list.add(すべて);
            支給区分list.add(窓口払);
            支給区分list.add(口座払);
        } else {
            支給区分list.add(div.getRadShikyuKubun().getSelectedKey());
        }
        parameter.set支給区分List(支給区分list);
        List<RString> 支払方法区分list = new ArrayList<>();
        if (すべて.equals(div.getRadSiharaiHohoKubun().getSelectedKey())) {
            支払方法区分list.add(すべて);
            支払方法区分list.add(窓口払);
            支払方法区分list.add(口座払);
        } else {
            支払方法区分list.add(div.getRadSiharaiHohoKubun().getSelectedKey());
        }
        parameter.set支払方法区分List(支払方法区分list);
        parameter.set金融機関コード(div.getCcdKinyuKikan().getKinyuKikanCode().value());
        parameter.set金融機関名(div.getCcdKinyuKikan().get金融機関名());
        parameter.set対象年度(div.getDdlTaishoNendo().getSelectedKey());
        return parameter;
    }
}
