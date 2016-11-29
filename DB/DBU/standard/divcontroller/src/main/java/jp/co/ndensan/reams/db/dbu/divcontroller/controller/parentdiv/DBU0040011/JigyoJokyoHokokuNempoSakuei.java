/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0040011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030010.DBU030010_JigyoHokokuNenpo_MainParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0040011.JigyoJokyoHokokuNempoSakueiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.ILoginInfo;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 事業状況報告（年報）作成クラスです。
 *
 * @reamsid_L DBU-5600-010 linghuhang
 */
public class JigyoJokyoHokokuNempoSakuei {

    private static final int INT_ITTI = 1;
    private static final int INT_NI = 2;
    private static final int INT_YOU = 4;
    private static final int INT_JUNI = 12;
    private static final RString 審査年月 = new RString("shinsaYM4");
    private static final RString 処理枝番 = new RString("0099");
    private static final RString 年度内連番 = new RString("0001");
    private static final RString 実行単位選択集計のみ = new RString("ITI");
    private static final RString 実行単位選択集計後に印刷 = new RString("NI");
    private static final RString 実行単位選択過去の集計 = new RString("SAN");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onLoad(JigyoJokyoHokokuNempoSakueiDiv div) {
        RString 導入形態コード = RString.EMPTY;
        List<RString> 枝番 = new ArrayList<>();
        枝番.add(処理枝番);
        RString 合併情報区分 = GappeiCityJohoBFinder.createInstance().getGappeijohokubun();
        div.setHiddenGappeiKoseiKubun(合併情報区分);
        div.setKijun(new RString("nashi"));
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null
                && !市町村セキュリティ情報.get導入形態コード().isEmpty()) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        }
        div.setHiddenDonyuKeitaiCode(導入形態コード);
        List<ShoriDateKanri> 過去集計年度データ = ShoriDateKanriManager.createInstance().
                get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告, get処理名(), 枝番).records();
        getHandler(div).onLoad(合併情報区分, 導入形態コード, 過去集計年度データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeJikkoTaniIti(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeJikkoTani(実行単位選択集計のみ);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeJikkoTaniNi(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeJikkoTani(実行単位選択集計後に印刷);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行単位選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeJikkoTaniSan(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeJikkoTani(実行単位選択過去の集計);
        return ResponseData.of(div).respond();
    }

    /**
     * 報告年度を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeHokokuNendo(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeHokokuNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * 報告開始年月を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeShukeiFromYM(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiFromYM(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 報告終了年月を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeShukeiToYM(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiToYM(RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 過去集計年度を変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeKakoHokokuNendo(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShoriDateKanri 様式12処理日付管理情報 = null;
        ShoriDateKanri 一般状況111処理日付管理情報 = null;
        ShoriDateKanri 一般状況1214現物分処理日付管理情報 = null;
        ShoriDateKanri 給付決定現物分処理日付管理情報 = null;
        ShoriDateKanri 一般状況1214償還分審査処理日付管理情報 = null;
        ShoriDateKanri 一般状況1214償還分決定処理日付管理情報 = null;
        ShoriDateKanri 給付決定償還分審査処理日付管理情報 = null;
        ShoriDateKanri 給付決定償還分決定処理日付管理情報 = null;
        ShoriDateKanri 給付決定高額分処理日付管理情報 = null;
        ShoriDateKanri 給付決定高額合算分処理日付管理情報 = null;
        if (!RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedKey())) {
            様式12処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告様式１_２.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況111処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告一般状況１_１１.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況1214現物分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告一般状況１２_１４現物分.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定現物分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告保険給付決定現物分.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況1214償還分審査処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告一般状況1２_１４償還分審査.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            一般状況1214償還分決定処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告一般状況1２_１４償還分決定.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定償還分審査処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告保険給付決定償還分審査.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定償還分決定処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告保険給付決定償還分決定.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定高額分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告保険給付決定高額分.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
            給付決定高額合算分処理日付管理情報 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                    Syorimei.年報報告保険給付決定高額合算分.get名称(), 処理枝番,
                    new FlexibleYear(div.getDdlKakoHokokuNendo().getSelectedKey()), 年度内連番);
        }
        getHandler(div).onClick_onChangeKakoHokokuNendo(様式12処理日付管理情報,
                一般状況111処理日付管理情報,
                一般状況1214現物分処理日付管理情報,
                給付決定現物分処理日付管理情報,
                一般状況1214償還分審査処理日付管理情報,
                一般状況1214償還分決定処理日付管理情報,
                給付決定償還分審査処理日付管理情報,
                給付決定償還分決定処理日付管理情報,
                給付決定高額分処理日付管理情報,
                給付決定高額合算分処理日付管理情報, RDate.getNowDate());
        return ResponseData.of(div).respond();
    }

    /**
     * 合併市町村用保険者選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeGappeiShichoson(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeGappeiShichoson();
        return ResponseData.of(div).respond();
    }

    /**
     * 広域構成市町村用保険者選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeKoikiRengo(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeKoikiRengo();
        return ResponseData.of(div).respond();
    }

    /**
     * （すべて選択）チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeAll(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeAll();
        return ResponseData.of(div).respond();
    }

    /**
     * 様式12チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange1(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange1();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 一般状況1～11チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange2(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange2();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 一般状況12～14【現物分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange3(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange3();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 保険給付決定状況【現物分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange4(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange4();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 一般状況12～14【償還分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange5(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange5();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 保険給付決定状況【償還分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange6(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange6();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 保険給付決定状況【高額分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange7(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange7();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 保険給付決定状況【高額合算分】チェックボックスを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChange8(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChange8();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況１２～１４【償還分】集計年月選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeIppanShukeiType(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiType(RString.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】集計年月選択ラジオボタンを変更する場合、画面を表示する。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_onChangeHokenShokanShukeiType(JigyoJokyoHokokuNempoSakueiDiv div) {
        getHandler(div).onClick_onChangeShukeiType(new RString("償還分"));
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタンを押下する、市町村選択を設定します。
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> btnSearch(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShichosonSelectorModel model = new ShichosonSelectorModel();
        model.setShichosonModel(div.getShichosonKubun());
        div.setKyuShichoson(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタンのOKClose時の処理を行います。<br/>
     *
     * @param div 画面情報
     * @return ResponseData<JigyoJokyoHokokuNempoSakueiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onOkClose_btnSenTaKuSearch(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        ViewStateHolder.put(ViewStateKeys.市町村選択データ, model);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、入力チェックを実行します。
     *
     * @param div 画面情報
     * @return ResponseData<PublicationShiryoShinsakaiDiv>
     */
    public ResponseData<JigyoJokyoHokokuNempoSakueiDiv> onClick_btnCheck(JigyoJokyoHokokuNempoSakueiDiv div) {
        ValidationMessageControlPairs validateForUpdate = getValidationHandler(div).validateForUpdate(
                !RString.isNullOrEmpty(div.getHiddenGappei()), !RString.isNullOrEmpty(div.getHiddenKouiki()));
        respinseData(div, validateForUpdate);
        if (!RString.isNullOrEmpty(div.getRadJikkoTaniShukeiOnly().getSelectedKey())
                || !RString.isNullOrEmpty(div.getRadJikkoTani2().getSelectedKey())) {
            if (RString.isNullOrEmpty(div.getDdlHokokuNendo().getSelectedValue())
                    || RString.isNullOrEmpty(div.getDdlShukeiFromYM().getSelectedValue())
                    || RString.isNullOrEmpty(div.getDdlShukeiToYM().getSelectedValue())) {
                return ResponseData.of(div).addValidationMessages(
                        new JigyoJokyoHokokuNempoSakueiValidationHandler(div).check出力対象の指定を確認()).respond();
            }
        } else {
            if (RString.isNullOrEmpty(div.getDdlKakoHokokuNendo().getSelectedValue())) {
                return ResponseData.of(div).addValidationMessages(
                        new JigyoJokyoHokokuNempoSakueiValidationHandler(div).check出力対象の指定を確認()).respond();
            }
        }
        if (div.getCblShutsuryokuTaishoYoshiki1().isAllSelected()) {
            ValidationMessageControlPairs 年報報告様式１２ = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                    Syorimei.月報報告一般状況１_１１.get名称(),
                    div.getTxttxtShukeiNendo1().getValue().getYear(), div.getTxtShukeiFromYM1().getValue().getMonthValue(),
                    div.getTxtShukeiToYM1().getValue().getMonthValue()), Syorimei.月報報告一般状況１_１１.get名称(),
                    div.getTxtShukeiFromYM1().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM1().getValue().getYearMonth().toDateString());
            return respinseData(div, 年報報告様式１２);
        }
        if (div.getCblShutsuryokuTaishoIppan1to11().isAllSelected()) {
            ValidationMessageControlPairs 年報報告一般状況１１１ = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                    Syorimei.月報報告一般状況１_１１.get名称(),
                    div.getTxtShukeiNendo2().getValue().getYear(), div.getTxtShukeiFromYM2().getValue().getMonthValue(),
                    div.getTxtShukeiToYM2().getValue().getMonthValue()), Syorimei.月報報告一般状況１_１１.get名称(),
                    div.getTxtShukeiFromYM2().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM2().getValue().getYearMonth().toDateString());
            return respinseData(div, 年報報告一般状況１１１);
        }
        if (div.getCblShutsuryokuTaishoIppanGembutsu().isAllSelected()) {
            ValidationMessageControlPairs 年報報告一般状況１２１４現物分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                    Syorimei.月報報告一般状況１２_１４現物分.get名称(),
                    div.getTxtShukeiNendo3().getValue().getYear(), div.getTxtShukeiFromYM3().getValue().getMonthValue(),
                    div.getTxtShukeiToYM3().getValue().getMonthValue()), Syorimei.月報報告一般状況１２_１４現物分.get名称(),
                    div.getTxtShukeiFromYM3().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM3().getValue().getYearMonth().toDateString());
            return respinseData(div, 年報報告一般状況１２１４現物分);
        }
        if (div.getCblShutsuryokuTaishoHokenGembutsu().isAllSelected()) {
            ValidationMessageControlPairs 年報報告保険給付決定現物分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                    Syorimei.月報報告保険給付決定現物分.get名称(),
                    div.getTxtShukeiNendo4().getValue().getYear(), div.getTxtShukeiFromYM4().getValue().getMonthValue(),
                    div.getTxtShukeiToYM4().getValue().getMonthValue()), Syorimei.月報報告保険給付決定現物分.get名称(),
                    div.getTxtShukeiFromYM4().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM4().getValue().getYearMonth().toDateString());
            return respinseData(div, 年報報告保険給付決定現物分);
        }
        if (div.getCblShutsuryokuTaishoIppanShokan().isAllSelected()) {
            if (審査年月.equals(div.getRadlblShukeiType4().getSelectedKey())) {
                ValidationMessageControlPairs 一般状況1214償還分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                        Syorimei.月報報告一般状況１２_１４償還分審査.get名称(),
                        div.getTxtShukeiNendo5().getValue().getYear(), div.getTxtShukeiFromYM5().getValue().getMonthValue(),
                        div.getTxtShukeiToYM5().getValue().getMonthValue()), Syorimei.月報報告一般状況１２_１４償還分審査.get名称(),
                        div.getTxtShukeiFromYM5().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM5().getValue().getYearMonth().toDateString());
                return respinseData(div, 一般状況1214償還分);
            } else {
                ValidationMessageControlPairs 一般状況1214償還分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                        Syorimei.月報報告一般状況１２_１４償還分決定.get名称(),
                        div.getTxtShukeiNendo5().getValue().getYear(), div.getTxtShukeiFromYM5().getValue().getMonthValue(),
                        div.getTxtShukeiToYM5().getValue().getMonthValue()), Syorimei.月報報告一般状況１２_１４償還分決定.get名称(),
                        div.getTxtShukeiFromYM5().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM5().getValue().getYearMonth().toDateString());
                return respinseData(div, 一般状況1214償還分);
            }
        }
        return check月報未処理(div);
    }

    /**
     * 実行するボタンを押下する場合、バッチ起動する。
     *
     * @param div 画面情報
     * @return ResponseData<DBU030010_JigyoHokokuNenpo_MainParameter>
     */
    public ResponseData<DBU030010_JigyoHokokuNenpo_MainParameter> onClick_btnExecute(JigyoJokyoHokokuNempoSakueiDiv div) {
        ShichosonSelectorModel 引き継ぎデータ = ViewStateHolder.get(ViewStateKeys.市町村選択データ, ShichosonSelectorModel.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        ILoginInfo iLoginInfo = UrControlDataFactory.createInstance().getLoginInfo();
        RString userId = iLoginInfo.getUserId();
        List<AuthorityItem> 市町村識別 = ShichosonSecurityJoho.getShichosonShikibetsuId(userId);
        List<KoikiZenShichosonJoho> 現市町村情報 = KoikiShichosonJohoFinder.createInstance().
                getGenShichosonJoho().records();
        List<GappeiCityJyoho> 合併市町村情報 = GappeiCityJohoBFinder.createInstance().getSennyoukouikigappeijohokensaku(
                HyojiUmu.表示する.getコード(), div.getHiddenDonyuKeitaiCode()).records();
        return ResponseData.of(getHandler(div).onClick_btnBatchParamSave(市町村セキュリティ情報, 引き継ぎデータ,
                市町村識別, 現市町村情報, 合併市町村情報)).respond();
    }

    private List<RString> get処理名() {
        List<RString> 処理名リスト = new ArrayList<>();
        for (Syorimei 処理名 : Syorimei.values()) {
            処理名リスト.add(処理名.get名称());
        }
        return 処理名リスト;
    }

    private List<ShoriDateKanri> get処理日付管理情報(SubGyomuCode サブ業務コード, RString 処理名, FlexibleYear 年度, int 集計開始月, int 集計終了月) {
        List<ShoriDateKanri> 処理日付管理情報 = new ArrayList<>();
        for (int i = 集計開始月; i != 集計終了月;) {
            RStringBuilder builder = new RStringBuilder();
            builder.append(new RString("00"))
                    .append(new RString(i).padZeroToLeft(INT_NI));
            ShoriDateKanri 処理日付管理;
            if (i >= INT_YOU) {
                処理日付管理 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(サブ業務コード,
                        処理名, builder.toRString(), 年度, 年度内連番);
            } else {
                処理日付管理 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(サブ業務コード,
                        処理名, builder.toRString(), 年度.plusYear(INT_ITTI), 年度内連番);
            }
            if (処理日付管理 != null) {
                処理日付管理情報.add(処理日付管理);
            }
            i++;
            if (i > INT_JUNI) {
                i = i - INT_JUNI;
            }
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("00"))
                .append(new RString(集計終了月).padZeroToLeft(INT_NI));
        ShoriDateKanri 処理日付管理;
        if (集計終了月 >= INT_YOU) {
            処理日付管理 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(サブ業務コード,
                    処理名, builder.toRString(), 年度, 年度内連番);
        } else {
            処理日付管理 = ShoriDateKanriManager.createInstance().get処理日付管理マスタ(サブ業務コード,
                    処理名, builder.toRString(), 年度.plusYear(INT_ITTI), 年度内連番);
        }
        if (処理日付管理 != null) {
            処理日付管理情報.add(処理日付管理);
        }
        return 処理日付管理情報;
    }

    private ResponseData<JigyoJokyoHokokuNempoSakueiDiv> check月報未処理(JigyoJokyoHokokuNempoSakueiDiv div) {
        if (div.getCblShutsuryokuTaishoHokenShokan().isAllSelected()) {
            if (審査年月.equals(div.getRadlblShukeiType5().getSelectedKey())) {
                ValidationMessageControlPairs 給付決定償還分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                        Syorimei.月報報告保険給付決定償還分審査.get名称(),
                        div.getTxtShukeiNendo6().getValue().getYear(), div.getTxtShukeiFromYM6().getValue().getMonthValue(),
                        div.getTxtShukeiToYM6().getValue().getMonthValue()), Syorimei.月報報告保険給付決定償還分審査.get名称(),
                        div.getTxtShukeiFromYM6().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM6().getValue().getYearMonth().toDateString());
                return respinseData(div, 給付決定償還分);
            } else {
                ValidationMessageControlPairs 給付決定償還分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                        Syorimei.月報報告保険給付決定償還分決定.get名称(),
                        div.getTxtShukeiNendo6().getValue().getYear(), div.getTxtShukeiFromYM6().getValue().getMonthValue(),
                        div.getTxtShukeiToYM6().getValue().getMonthValue()), Syorimei.月報報告保険給付決定償還分決定.get名称(),
                        div.getTxtShukeiFromYM6().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM6().getValue().getYearMonth().toDateString());
                return respinseData(div, 給付決定償還分);
            }
        }
        if (div.getCblShutsuryokuTaishoHokenKogaku().isAllSelected()) {
            ValidationMessageControlPairs 給付決定高額分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                    Syorimei.月報報告保険給付決定高額分.get名称(),
                    div.getTxtShukeiNendo7().getValue().getYear(), div.getTxtShukeiFromYM7().getValue().getMonthValue(),
                    div.getTxtShukeiToYM7().getValue().getMonthValue()), Syorimei.月報報告保険給付決定高額分.get名称(),
                    div.getTxtShukeiFromYM7().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM7().getValue().getYearMonth().toDateString());
            return respinseData(div, 給付決定高額分);
        }
        if (div.getCblShutsuryokuTaishoHokenKogakuGassan().isAllSelected()) {
            ValidationMessageControlPairs 給付決定高額合算分 = getValidationHandler(div).check月報未処理(get処理日付管理情報(SubGyomuCode.DBU介護統計報告,
                    Syorimei.月報報告保険給付決定高額合算分.get名称(),
                    div.getTxtShukeiNendo8().getValue().getYear(), div.getTxtShukeiFromYM8().getValue().getMonthValue(),
                    div.getTxtShukeiToYM8().getValue().getMonthValue()), Syorimei.月報報告保険給付決定高額合算分.get名称(),
                    div.getTxtShukeiFromYM8().getValue().getYearMonth().toDateString(), div.getTxtShukeiToYM8().getValue().getYearMonth().toDateString());
            return respinseData(div, 給付決定高額合算分);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JigyoJokyoHokokuNempoSakueiDiv> respinseData(JigyoJokyoHokokuNempoSakueiDiv div, ValidationMessageControlPairs validateForUpdate) {
        if (validateForUpdate.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validateForUpdate).respond();
        }
        return ResponseData.of(div).respond();
    }

    private JigyoJokyoHokokuNempoSakueiHandler getHandler(JigyoJokyoHokokuNempoSakueiDiv div) {
        return new JigyoJokyoHokokuNempoSakueiHandler(div);
    }

    private JigyoJokyoHokokuNempoSakueiValidationHandler getValidationHandler(JigyoJokyoHokokuNempoSakueiDiv div) {
        return new JigyoJokyoHokokuNempoSakueiValidationHandler(div);
    }

}
