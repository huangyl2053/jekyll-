/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0490011;

import jp.co.ndensan.reams.db.dbc.business.core.ketteitsuchishosakusei.param.KogakuJigyoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020060.DBC020060_KogakuJigyoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun.ShiharaiHohoKinoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011.ShikyuketteituchishoSakuseiJyokenDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishikyuuketteitsuchishosakusei.KougakuSabisuhiShikyuuKetteiTsuchishoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBCMN43002_高額サービス費支給決定通知書作成のクラスです。
 *
 * @reamsid_L DBC-2000-010 chenhui
 */
public class ShikyuketteituchishoSakuseiJyokenHandler {

    private final ShikyuketteituchishoSakuseiJyokenDiv div;
    private static final RString 高額サービス費支給決定通知書作成メニューID = new RString("DBCMN43002");
    private static final RString 高額総合事業サービス費支給決定通知書メニューID = new RString("DBCMNL3002");
    private static final RString 高額サービス費支給決定通知書作成帳票ID = new RString("DBC100007_KogakuKetteiTsuchiSho");
    private static final RString 高額総合事業サービス費支給決定通知書帳票ID = new RString("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_3 = new RString("3");
    private static final RString フラグ_FALSE = new RString("false");
    private static final RString フラグ_TRUE = new RString("true");
    private static final RString 利用者向け決定通知書 = new RString("ForRiyosha");
    private static final RString 受領委任者向け決定通知書 = new RString("ForJuryoininsha");
    private static final RString 実行するボタン1 = new RString("Execute1");
    private static final RString 実行するボタン2 = new RString("Execute2");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final ReportId 高額サービス帳票ID = new ReportId("DBC100007_KogakuKetteiTsuchiSho");
    private static final ReportId 高額総合事業サービス帳票ID = new ReportId("DBC100061_JigyoKogakuKetteiTsuchisho");

    /**
     * コンストラクタです。
     *
     * @param div ShikyuketteituchishoSakuseiJyokenDiv
     */
    public ShikyuketteituchishoSakuseiJyokenHandler(ShikyuketteituchishoSakuseiJyokenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     */
    public void initialize() {
        div.getShikyuKetteiTsuchisho().getTxtHakkobi().setValue(RDate.getNowDate());
        onClick_radKetteibiIkkatsuKoshinKubun();
        onClick_radHizukeSentaku(KEY0);
        if (高額サービス費支給決定通知書作成メニューID.equals(ResponseHolder.getMenuID())) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 高額サービス帳票ID);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(実行するボタン2, false);
            div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().initialize(new ReportId(高額サービス費支給決定通知書作成帳票ID));
        } else if (高額総合事業サービス費支給決定通知書メニューID.equals(ResponseHolder.getMenuID())) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 高額総合事業サービス帳票ID);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(実行するボタン1, false);

            div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().initialize(new ReportId(高額総合事業サービス費支給決定通知書帳票ID));
        }
        div.getCcdShiharaiHoho().initialize(ShiharaiHohoKinoKubun.高額介護.getコード());
        決定者受付年月TXT制御();
    }

    /**
     * 「受付日」「決定日」「決定者受付年月」を選択のメソッドです。
     *
     * @param 選択Key RString
     */
    public void onClick_radHizukeSentaku(RString 選択Key) {
        RString 処理名;
        if (KEY0.equals(選択Key)) {
            処理名 = ShoriName.事業高額サービス等支給不支給決定通知書一括作成_受付日.get名称();
        } else if (KEY1.equals(選択Key)) {
            処理名 = ShoriName.事業高額サービス等支給不支給決定通知書一括作成_決定日.get名称();
        } else {
            処理名 = ShoriName.事業高額サービス等支給不支給決定通知書一括作成_決定者受付年月.get名称();
        }

        RDate システム日付 = RDate.getNowDate();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ShoriDateKanri 前回対象日 = KougakuSabisuhiShikyuuKetteiTsuchishoSakusei.createInstance().
                getZenkaiTaisyobiData(処理名, 導入団体クラス.get地方公共団体コード());

        div.getChushutsuJoken().getTxtZenkaiTaishobi().clearFromValue();
        div.getChushutsuJoken().getTxtZenkaiTaishobi().clearToValue();
        if (前回対象日 != null) {
            div.getChushutsuJoken().getTxtZenkaiTaishobi().setFromValue(new RDate(前回対象日.get対象開始年月日().toString()));
            div.getChushutsuJoken().getTxtZenkaiTaishobi().setToValue(new RDate(前回対象日.get対象終了年月日().toString()));

            RDate 前回対象日Toの次日 = new RDate(前回対象日.get対象開始年月日().toString()).plusDay(INT_1);

            if (KEY0.equals(選択Key)) {
                div.getChushutsuJoken().getChushutsubiNyuryokuEria().
                        getTxtUketukebi().setFromValue(前回対象日Toの次日);
            } else if (KEY1.equals(選択Key)) {
                div.getChushutsuJoken().getChushutsubiNyuryokuEria().
                        getTxtKetteibi().setFromValue(前回対象日Toの次日);
            }
        }
        if (KEY0.equals(選択Key)) {
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setReadOnly(false);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setToValue(システム日付);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().clearFromValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().clearToValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().clearValue();
        } else if (KEY1.equals(選択Key)) {
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setReadOnly(false);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setToValue(システム日付);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().clearFromValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().clearToValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().clearValue();
        } else if (KEY2.equals(選択Key)) {
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setReadOnly(false);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setValue(システム日付);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().clearFromValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().clearToValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().clearFromValue();
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().clearToValue();
        }
    }

    /**
     * 決定日一括更新区分を選択のメソッドです。
     *
     */
    public void onClick_radKetteibiIkkatsuKoshinKubun() {
        RString 選択Key = div.getShutsuryokukoshinSentaku().getRadKetteibiIkkatsuKoshinKubun().getSelectedKey();
        if (KEY0.equals(選択Key)) {
            div.getShikyuKetteiTsuchisho().getTxtketteibi2().setVisible(false);
        } else if (KEY1.equals(選択Key)) {
            div.getShikyuKetteiTsuchisho().getTxtketteibi2().setVisible(true);
        }
    }

    /**
     * 高額サービス費支給決定通知書作成画面入力するデータより、バッチ用パラメータクラスを作成する。
     *
     * @return ShoukanBaraiSuuchiShoIkatsuBatchParamter
     */
    public DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter creatBatchParameter1() {
        return KougakuSabisuhiShikyuuKetteiTsuchishoSakusei.createInstance().
                getDBC020030_KougakuSabisuhiShikyuuKetteiTsuchishoBatchParameter(creatCommonParameter());
    }

    /**
     * 高額総合事業サービス費支給決定通知書作成画面入力するデータより、バッチ用パラメータクラスを作成する。
     *
     * @return ShoukanBaraiSuuchiShoIkatsuBatchParamter
     */
    public DBC020060_KogakuJigyoServicehiShikyuKetteiTsuchishoParameter creatBatchParameter2() {
        return KougakuSabisuhiShikyuuKetteiTsuchishoSakusei.createInstance().
                getDBC020060_KougakuSabisuhiShikyuuKetteiTsuchishoBatchParameter(creatCommonParameter());
    }

    private void 決定者受付年月TXT制御() {
        RString configValue = DbBusinessConfig.get(ConfigNameDBC.高額決定通知書_初期選択抽出条件, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (!STR_3.equals(configValue)) {
            div.getTxtKetteishaUketukeNengetsu().setDisplayNone(true);
            div.getChushutsuJoken().getRadHizukeSentaku().getDataSource().remove(INT_2);
        }
    }

    /**
     * テスト出力制御
     */
    public void テスト出力制御() {
        boolean isチェック = div.getChkTesutoShuturyoku().isAllSelected();
        div.getRadKetteibiIkkatsuKoshinKubun().setDisabled(isチェック);
        div.getCcdShiharaiHoho().get窓口払い一括更新区分RB().setDisabled(isチェック);
        if (isチェック) {
            div.getRadKetteibiIkkatsuKoshinKubun().setSelectedKey(KEY0);
            div.getCcdShiharaiHoho().get窓口払い一括更新区分RB().setSelectedKey(STR_1);
        }
    }

    private KogakuJigyoServicehiShikyuKetteiTsuchishoParameter creatCommonParameter() {
        KogakuJigyoServicehiShikyuKetteiTsuchishoParameter parameter = new KogakuJigyoServicehiShikyuKetteiTsuchishoParameter();
        RString 抽出モード = null;
        RDate 抽出条件日付From = null;
        RDate 抽出条件日付To = null;
        if (KEY0.equals(div.getChushutsuJoken().getRadHizukeSentaku().getSelectedKey())) {
            抽出モード = STR_1;
            抽出条件日付From = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().getFromValue();
            抽出条件日付To = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().getToValue();
        } else if (KEY1.equals(div.getChushutsuJoken().getRadHizukeSentaku().getSelectedKey())) {
            抽出モード = STR_2;
            抽出条件日付From = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().getFromValue();
            抽出条件日付To = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().getToValue();
        } else if (KEY2.equals(div.getChushutsuJoken().getRadHizukeSentaku().getSelectedKey())) {
            抽出モード = STR_3;
        }
        parameter.set抽出モード(抽出モード);
        parameter.set抽出条件日付From(抽出条件日付From);
        parameter.set抽出条件日付To(抽出条件日付To);
        parameter.set決定者受付年月(div.getChushutsuJoken().getTxtKetteishaUketukeNengetsu().getValue());
        if (KEY0.equals(div.getChushutsuJoken().getRadKogakuJidoShokanSentaku().getSelectedKey())) {
            parameter.set高額自動償還(STR_1);
        } else if (KEY1.equals(div.getChushutsuJoken().getRadKogakuJidoShokanSentaku().getSelectedKey())) {
            parameter.set高額自動償還(STR_2);
        } else if (KEY2.equals(div.getChushutsuJoken().getRadKogakuJidoShokanSentaku().getSelectedKey())) {
            parameter.set高額自動償還(STR_3);
        }
        set印書(parameter);
        parameter.set発行日(div.getShikyuKetteiTsuchisho().getTxtHakkobi().getValue());
        RString 文書番号 = div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().get文書番号();
        if (文書番号 != null && !文書番号.isEmpty()) {
            parameter.set文書番号(div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().get文書番号());
        }
        if (new RString("第号").equals(文書番号)) {
            parameter.set文書番号(new RString("第　　　　　　　号"));
        }
        if (div.getShikyuKetteiTsuchisho().getChkTesutoShuturyoku().getSelectedKeys().isEmpty()) {
            parameter.setテスト出力フラグ(フラグ_FALSE);
        } else {
            parameter.setテスト出力フラグ(フラグ_TRUE);
        }
        if (KEY0.equals(div.getShikyuKetteiTsuchisho().getRadKetteibiIkkatsuKoshinKubun().getSelectedKey())) {
            parameter.set決定日一括更新区分(STR_1);
        } else if (KEY1.equals(div.getShikyuKetteiTsuchisho().getRadKetteibiIkkatsuKoshinKubun().getSelectedKey())) {
            parameter.set決定日一括更新区分(STR_2);
        }
        parameter.set決定日(div.getShikyuKetteiTsuchisho().getTxtketteibi2().getValue());
        if (div.getShikyuKetteiTsuchisho().getChkShutsuryokuTaishoKubun().getSelectedKeys().contains(利用者向け決定通知書)) {
            parameter.set利用者向け決定通知書フラグ(フラグ_TRUE);
        } else {
            parameter.set利用者向け決定通知書フラグ(フラグ_FALSE);
        }
        if (div.getShikyuKetteiTsuchisho().getChkShutsuryokuTaishoKubun().getSelectedKeys().contains(受領委任者向け決定通知書)) {
            parameter.set受領委任者向け決定通知書フラグ(フラグ_TRUE);
        } else {
            parameter.set受領委任者向け決定通知書フラグ(フラグ_FALSE);
        }
        parameter.set振込予定日(div.getCcdShiharaiHoho().get振込予定日());
        if (div.getCcdShiharaiHoho().get支払場所() != null && !div.getCcdShiharaiHoho().get支払場所().isEmpty()) {
            parameter.set支払場所(div.getCcdShiharaiHoho().get支払場所());
        }
        parameter.set支払期間From(div.getCcdShiharaiHoho().get支払期間FROM());
        parameter.set支払期間To(div.getCcdShiharaiHoho().get支払期間TO());
        parameter.set開始時間(div.getCcdShiharaiHoho().get開始時間());
        parameter.set終了時間(div.getCcdShiharaiHoho().get終了時間());
        if (div.getCcdShutsuryokujun() != null && div.getCcdShutsuryokujun().get出力順ID() != null) {
            long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
            parameter.set出力順ID(出力順ID);
        }
        parameter.set窓口払い一括更新区分(div.getCcdShiharaiHoho().get窓口払い一括更新区分());
        return parameter;
    }

    private void set印書(KogakuJigyoServicehiShikyuKetteiTsuchishoParameter parameter) {
        if (KEY0.equals(div.getChushutsuJoken().getRadInshoSentaku().getSelectedKey())) {
            parameter.set印書(STR_1);
        } else if (KEY1.equals(div.getChushutsuJoken().getRadInshoSentaku().getSelectedKey())) {
            parameter.set印書(STR_2);
        } else if (KEY2.equals(div.getChushutsuJoken().getRadInshoSentaku().getSelectedKey())) {
            parameter.set印書(STR_3);
        }
    }
}
