/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0490011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.ketteitsuchishosakusei.param.KogakuJigyoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020060.DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihohokinokubun.ShiharaiHohoKinoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011.ShikyuketteituchishoSakuseiJyokenDiv;
import jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishikyuuketteitsuchishosakusei.KougakuSabisuhiShikyuuKetteiTsuchishoSakusei;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoBunruiKanriManager;
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
    private static final RString 高額総合事業サービス費支給決定通知書メニューID = new RString("DBCMN43005");
    private static final RString 高額サービス費支給決定通知書作成帳票ID = new RString("DBC100007_KogakuKetteiTsuchiSho");
    private static final RString 高額総合事業サービス費支給決定通知書帳票ID = new RString("DBC100061_JigyoKogakuKetteiTsuchisho");
    private static final RString 処理枝番_01 = new RString("01");
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
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        List<ShoriDateKanri> 前回対象日List
                = KougakuSabisuhiShikyuuKetteiTsuchishoSakusei.createInstance().getZenkaiTaisyobiData(導入団体クラス.get地方公共団体コード());
        RDate 前回対象日From = null;
        RDate 前回対象日To = null;
        if (!前回対象日List.isEmpty() && 処理枝番_01.equals(前回対象日List.get(0).get処理枝番())) {
            if (前回対象日List.get(0).get対象開始年月日() != null) {
                前回対象日From = new RDate(前回対象日List.get(0).get対象開始年月日().toString());
            }
            if (前回対象日List.get(0).get対象終了年月日() != null) {
                前回対象日To = new RDate(前回対象日List.get(0).get対象終了年月日().toString());
                div.getChushutsuJoken().getTxtUketukebi().setFromValue(前回対象日To.plusDay(INT_1));
            }
        }
        if (前回対象日To != null) {
            RDate 前回対象日Toの次日 = 前回対象日To.plusDay(INT_1);
            div.getChushutsuJoken().getTxtUketukebi().setFromValue(前回対象日Toの次日);
            div.getChushutsuJoken().getTxtKetteibi().setFromValue(前回対象日Toの次日);
        }
        div.getChushutsuJoken().getTxtZenkaiTaishobi().setFromValue(前回対象日From);
        div.getChushutsuJoken().getTxtZenkaiTaishobi().setToValue(前回対象日To);
        RDate システム日付 = RDate.getNowDate();
        div.getChushutsuJoken().getTxtUketukebi().setToValue(システム日付);
        div.getChushutsuJoken().getTxtKetteibi().setToValue(システム日付);
        div.getChushutsuJoken().getTxtKetteishaUketukeNengetsu().setValue(システム日付);
        div.getShikyuKetteiTsuchisho().getＴｘｔHakkobi().setValue(システム日付);
        onClick_radKetteibiIkkatsuKoshinKubun();
        ChohyoBunruiKanri code = null;
        if (高額サービス費支給決定通知書作成メニューID.equals(ResponseHolder.getMenuID())) {
            code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                    new ReportId(高額サービス費支給決定通知書作成帳票ID));
            CommonButtonHolder.setVisibleByCommonButtonFieldName(実行するボタン2, false);
            div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().initialize(new ReportId(高額サービス費支給決定通知書作成帳票ID));
        } else if (高額総合事業サービス費支給決定通知書メニューID.equals(ResponseHolder.getMenuID())) {
            code = ChohyoBunruiKanriManager.createInstance().get帳票分類管理(SubGyomuCode.DBC介護給付,
                    new ReportId(高額総合事業サービス費支給決定通知書帳票ID));
            CommonButtonHolder.setVisibleByCommonButtonFieldName(実行するボタン1, false);
            div.getChushutsuJoken().getRadHizukeSentaku().getDataSource().remove(INT_2);
            div.getChushutsuJoken().getTxtKetteishaUketukeNengetsu().setVisible(false);
            div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().initialize(new ReportId(高額総合事業サービス費支給決定通知書帳票ID));
        }
        if (code != null) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, code.get帳票分類ID());
        }
        div.getCcdShiharaiHoho().initialize(ShiharaiHohoKinoKubun.高額介護.getコード());
    }

    /**
     * 「受付日」「決定日」「決定者受付年月」を選択のメソッドです。
     */
    public void onClick_radHizukeSentaku() {
        RString 選択Key = div.getChushutsuJoken().getRadHizukeSentaku().getSelectedKey();
        RDate 前回対象日From = null;
        RDate 前回対象日To = null;
        if (KEY0.equals(選択Key)) {
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setReadOnly(false);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setReadOnly(true);
            前回対象日From = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().getFromValue();
            前回対象日To = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().getToValue();
        } else if (KEY1.equals(選択Key)) {
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setReadOnly(false);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setReadOnly(true);
            前回対象日From = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().getFromValue();
            前回対象日To = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().getToValue();
        } else if (KEY2.equals(選択Key)) {
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteibi().setReadOnly(true);
            div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().setReadOnly(false);
            前回対象日From = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtKetteishaUketukeNengetsu().getValue();
            前回対象日To = 前回対象日From;
        }
        div.getChushutsuJoken().getTxtZenkaiTaishobi().setFromValue(前回対象日From);
        div.getChushutsuJoken().getTxtZenkaiTaishobi().setToValue(前回対象日To);
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
    public DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter creatBatchParameter2() {
        return KougakuSabisuhiShikyuuKetteiTsuchishoSakusei.createInstance().
                getDBC020060_KougakuSabisuhiShikyuuKetteiTsuchishoBatchParameter(creatCommonParameter());
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
            抽出条件日付From = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().getFromValue();
            抽出条件日付To = div.getChushutsuJoken().getChushutsubiNyuryokuEria().getTxtUketukebi().getToValue();
        } else if (KEY2.equals(div.getChushutsuJoken().getRadHizukeSentaku().getSelectedKey())) {
            抽出モード = STR_3;
        }
        parameter.set抽出モード(抽出モード);
        parameter.set抽出条件日付From(抽出条件日付From);
        parameter.set抽出条件日付To(抽出条件日付To);
        parameter.set決定者受付年月(div.getChushutsuJoken().getTxtKetteishaUketukeNengetsu().getValue());
        if (KEY0.equals(div.getChushutsuJoken().getRadInshoSentaku().getSelectedKey())) {
            parameter.set印書(STR_1);
        } else if (KEY1.equals(div.getChushutsuJoken().getRadInshoSentaku().getSelectedKey())) {
            parameter.set印書(STR_2);
        } else if (KEY2.equals(div.getChushutsuJoken().getRadInshoSentaku().getSelectedKey())) {
            parameter.set印書(STR_3);
        }
        if (KEY0.equals(div.getChushutsuJoken().getRadKogakuJidoShokanSentaku().getSelectedKey())) {
            parameter.set高額自動償還(STR_1);
        } else if (KEY1.equals(div.getChushutsuJoken().getRadKogakuJidoShokanSentaku().getSelectedKey())) {
            parameter.set高額自動償還(STR_2);
        } else if (KEY2.equals(div.getChushutsuJoken().getRadKogakuJidoShokanSentaku().getSelectedKey())) {
            parameter.set高額自動償還(STR_3);
        }
        parameter.set発行日(div.getShikyuKetteiTsuchisho().getＴｘｔHakkobi().getValue());
        parameter.set文書番号(div.getShikyuKetteiTsuchisho().getCcdBunshoBangoInput().get文書番号());
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
        if (div.getShikyuKetteiTsuchisho().getChkTesutoShuturyoku().getSelectedKeys().contains(利用者向け決定通知書)) {
            parameter.set利用者向け決定通知書フラグ(フラグ_FALSE);
        } else {
            parameter.set利用者向け決定通知書フラグ(フラグ_TRUE);
        }
        if (div.getShikyuKetteiTsuchisho().getChkTesutoShuturyoku().getSelectedKeys().contains(受領委任者向け決定通知書)) {
            parameter.set受領委任者向け決定通知書フラグ(フラグ_FALSE);
        } else {
            parameter.set受領委任者向け決定通知書フラグ(フラグ_TRUE);
        }
        parameter.set振込予定日(div.getCcdShiharaiHoho().get振込予定日());
        parameter.set支払場所(div.getCcdShiharaiHoho().get支払場所());
        parameter.set支払期間From(div.getCcdShiharaiHoho().get支払期間FROM());
        parameter.set支払期間To(div.getCcdShiharaiHoho().get支払期間TO());
        parameter.set開始時間(div.getCcdShiharaiHoho().get開始時間());
        parameter.set終了時間(div.getCcdShiharaiHoho().get終了時間());
        if (div.getCcdShutsuryokujun() != null && div.getCcdShutsuryokujun().get出力順ID() != null) {
            long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
            parameter.set出力順ID(出力順ID);
        }
        return parameter;
    }
}
