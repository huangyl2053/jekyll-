/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1300001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710020.DBD710020_HanyoListJukyushaDaicho2Parameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001.JukyushaDaichoPanelDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト受給者台帳２。
 *
 * @reamsid_L DBD-1810-010 wanghui
 */
public class JukyushaDaichoPanelHandler {

    private final JukyushaDaichoPanelDiv div;
    private static final RString 申請取消データ抽出 = new RString("4");
    private static final RString 削除データ抽出 = new RString("5");
    private static final RString 抽出年月日 = new RString("1");
    private static final RString 項目名付加 = new RString("6");
    private static final RString 連番付加 = new RString("7");
    private static final RString 日付_編集 = new RString("8");
    private static final RString 帳票ID = new RString("DBD701002_HanyoListJukyushaDaicho2");
    private static final RString 全履歴 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト受給者台帳２
     */
    public JukyushaDaichoPanelHandler(JukyushaDaichoPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     */
    public void initialize() {
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD130001.getReportId());
        List<RString> selectKeys = new ArrayList<>();
        selectKeys.add(削除データ抽出);
        div.getChkTorikeshiSakujo().setDisabledItemsByKey(selectKeys);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource date = new KeyValueDataSource();
        date.setKey(抽出年月日);
        dataSource.add(date);
        div.getRadChushutsuTaisho().setDisabledItem(dataSource);
        div.getDdlChushutsuYmd().setDisabled(false);
        div.getTxtChushutsuYMD().setDisabled(false);
        div.getTxtIryokikan().setDisabled(true);
        div.getTxtChosaItakusaki().setDisabled(true);
        List<RString> listCSV = new ArrayList<>();
        listCSV.add(項目名付加);
        listCSV.add(連番付加);
        listCSV.add(日付_編集);
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(listCSV);
        div.getCcdAtenaJoken().initialize();
        div.getCcdAtenaJoken().set保険者();
        div.getCcdAtenaJoken().set地区(Chiku.全て.getコード());
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdGyoseikuFrom().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdJushoFrom().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdJushoTo().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdHokenshaList().setDisplayNone(false);
    }

    /**
     * 「抽出年月日」を選択した時、コントロールの制御。
     *
     */
    public void set抽出年月日() {
        div.getDdlChushutsuYmd().setDisabled(false);
        div.getTxtChushutsuYMD().setDisabled(false);
        div.getTxtIryokikan().setDisabled(true);
        div.getTxtIryokikan().clearFromValue();
        div.getTxtIryokikan().clearToValue();
        div.getTxtChosaItakusaki().setDisabled(true);
        div.getTxtChosaItakusaki().clearFromValue();
        div.getTxtChosaItakusaki().clearToValue();

    }

    /**
     * 「抽出年月日」を選択した時、コントロールの制御。
     *
     */
    public void set抽出区分() {
        if (全履歴.equals(div.getDdlChushutsuData().getSelectedKey())) {
            List<RString> selectKeys = new ArrayList<>();
            div.getChkTorikeshiSakujo().setDisabledItemsByKey(selectKeys);
        } else {
            List<RString> selectKeys = new ArrayList<>();
            selectKeys.add(削除データ抽出);
            div.getChkTorikeshiSakujo().setDisabledItemsByKey(selectKeys);
        }
    }

    /**
     * 「医療機関」を選択した時、コントロールの制御。
     *
     */
    public void set医療機関() {
        div.getDdlChushutsuYmd().setDisabled(true);
        div.getTxtChushutsuYMD().clearFromValue();
        div.getTxtChushutsuYMD().clearToValue();
        div.getTxtChushutsuYMD().setDisabled(true);
        div.getTxtChosaItakusaki().clearFromValue();
        div.getTxtChosaItakusaki().clearToValue();
        div.getTxtIryokikan().setDisabled(false);
        div.getTxtChosaItakusaki().setDisabled(true);

    }

    /**
     * 「医療機関」を選択した時、コントロールの制御。
     *
     */
    public void set調査委託先() {

        div.getDdlChushutsuYmd().setDisabled(true);
        div.getTxtChushutsuYMD().setDisabled(true);
        div.getTxtChushutsuYMD().clearFromValue();
        div.getTxtChushutsuYMD().clearToValue();
        div.getTxtIryokikan().setDisabled(true);
        div.getTxtIryokikan().clearFromValue();
        div.getTxtIryokikan().clearToValue();
        div.getTxtChosaItakusaki().setDisabled(false);
    }

    /**
     * 「条件を保存する」ボタンを押下時、バッチパラメータを保存します。
     *
     * @return HanyoRisutoJyukyusyaDaichoBatchParameter
     */
    public DBD710020_HanyoListJukyushaDaicho2Parameter setBatchParameter() {
        DBD710020_HanyoListJukyushaDaicho2Parameter parameter = new DBD710020_HanyoListJukyushaDaicho2Parameter();
        parameter.setCyusyutsudatakubun(div.getDdlChushutsuData().getSelectedKey());
        boolean 申請取消データ抽出Flag = false;
        boolean 削除データ抽出Flag = false;
        for (RString keys : div.getChkTorikeshiSakujo().getSelectedKeys()) {
            if (keys.equals(申請取消データ抽出)) {
                申請取消データ抽出Flag = true;
            }
            if (keys.equals(削除データ抽出)) {
                削除データ抽出Flag = true;
            }
        }
        parameter.setShinseikeshidetacyusyutsu(申請取消データ抽出Flag);
        parameter.setSakujyodatacyusyutsu(削除データ抽出Flag);
        parameter.setSoshitsukubun(div.getDdlSoushitsuKubun().getSelectedKey());
        parameter.setCyusyutsutaisyo(div.getRadChushutsuTaisho().getSelectedKey());
        parameter.setCyusyutsunichisyurai(div.getDdlChushutsuYmd().getSelectedKey());
        if (div.getTxtChushutsuYMD().getFromValue() != null) {
            parameter.setCyusyutsunichifrom(new FlexibleDate(div.getTxtChushutsuYMD().getFromValue().toDateString()));
        } else {
            parameter.setCyusyutsunichifrom(null);
        }
        if (div.getTxtChushutsuYMD().getToValue() != null) {
            parameter.setCyusyutsunichito(new FlexibleDate(div.getTxtChushutsuYMD().getToValue().toDateString()));
        } else {
            parameter.setCyusyutsunichito(null);
        }
        if (div.getTxtIryokikan().getFromValue() != null) {
            parameter.setIryokikancodefrom(new RString(div.getTxtIryokikan().getFromValue().toString()));
        } else {
            parameter.setIryokikancodefrom(null);
        }
        if (div.getTxtIryokikan().getToValue() != null) {
            parameter.setIryokikancodefto(new RString(div.getTxtIryokikan().getToValue().toString()));
        } else {
            parameter.setIryokikancodefto(null);
        }
        if (div.getTxtChosaItakusaki().getFromValue() != null) {
            parameter.setCyosaitakusakicodefrom(new RString(div.getTxtChosaItakusaki().getFromValue().toString()));
        } else {
            parameter.setCyosaitakusakicodefrom(null);
        }
        if (div.getTxtChosaItakusaki().getToValue() != null) {
            parameter.setCyosaitakusakicodefto(new RString(div.getTxtChosaItakusaki().getToValue().toString()));
        } else {
            parameter.setCyosaitakusakicodefto(null);
        }
        parameter.setAtenacyusyutsujyoken(RString.EMPTY);
        parameter.setKaipejisyutsuryokujunid(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setSyutsuryokukomokuid(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setCyohyoid(帳票ID);
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
        parameter.setCsvkomokumeifuka(項目付加);
        parameter.setCsvrenbanfuka(連番の付加);
        parameter.setCsvhitsukesurasyuhensyu(日付スラッシュ編集);
        return parameter;
    }
}
