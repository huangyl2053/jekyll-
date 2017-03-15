/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0900001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinnteiRiriBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbe.service.report.ichijihanteikekkahyo.IchijihanteikekkahyoPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.ninteichosajohohyo.INinteiChosaJohohyoPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.ninteichosajohohyo.NinteiChosaJohohyoPrintServiceFactory;
import jp.co.ndensan.reams.db.dbe.service.report.shujiiikensho.ShujiiIkenshoPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.sonotashiryo.SonotashiryoPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.tokkijiko.ITokkiJikoPrintService;
import jp.co.ndensan.reams.db.dbe.service.report.tokkijiko.TokkiJikoPrintServiceFactory;
import jp.co.ndensan.reams.db.dbe.service.report.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定情報提供Divの制御クラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyo {

    private final RString なし = new RString("0");
    private final RString あり = new RString("1");
    private final RString 出力方法_一式 = new RString("0");

    /**
     * ページロードイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> onLoad(YokaigoNinteiJohoTeikyoDiv div) {
        RString 申請書管理番号Str = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ShinseishoKanriNo 申請書管理番号 = RString.isNullOrEmpty(申請書管理番号Str)
                ? ShinseishoKanriNo.EMPTY : new ShinseishoKanriNo(申請書管理番号Str);
        NinnteiRiriBusiness business = YokaigoNinteiJohoTeikyoFinder.createInstance().select認定履歴(申請書管理番号);
        //TODO n8178 本来なら受け取れなかった場合のチェック処理くらいは必要だけど、急ぎのため今は無視。
        getHandler(div).onLoad(申請書管理番号Str, business);
        ViewStateHolder.put(ViewStateKeys.認定申請情報, business);
        return ResponseData.of(div).respond();
    }

    /**
     * btn_ToSearchイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> btn_ToSearch(YokaigoNinteiJohoTeikyoDiv div) {
        ViewStateHolder.put(ViewStateKeys.機能詳細画面から再検索, Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 出力方法ラジオボタン変更イベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> onChange_radOutputHoho(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).set発行する帳票(ViewStateHolder.get(ViewStateKeys.認定申請情報, NinnteiRiriBusiness.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkNinteiChosahyo(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkNinteiChosahyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 特記事項チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkTokkiJiko(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkTokkiJiko();
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医意見書チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkShujiiIkensho(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkShujiiIkensho();
        return ResponseData.of(div).respond();
    }

    /**
     * その他資料チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkSonotaShiryo(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkSonotaShiryo();
        return ResponseData.of(div).respond();
    }

    /**
     * 一次判定結果チェックボックス変更します。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> chkIchijiHanteiKekka(YokaigoNinteiJohoTeikyoDiv div) {
        getHandler(div).chkIchijiHanteikekka();
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンクリック時のバリデーションです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<YokaigoNinteiJohoTeikyoDiv> validate_btnPrint(YokaigoNinteiJohoTeikyoDiv div) {
        NinnteiRiriBusiness 認定申請情報 = ViewStateHolder.get(ViewStateKeys.認定申請情報, NinnteiRiriBusiness.class);
        if (!ResponseHolder.isReRequest()) {
            if (認定申請情報.get要介護認定一次判定完了年月日() == null
                    || 認定申請情報.get要介護認定一次判定完了年月日().isEmpty()) {
                throw new ApplicationException(DbeErrorMessages.一次判定未実施のため発行不可.getMessage());
            }

            ValidationMessageControlPairs validationMessageControlPairs = getValidationHandler(div).validateCheck();
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
            }

            if (認定申請情報.get認定審査会完了年月日() == null || 認定申請情報.get認定審査会完了年月日().isEmpty()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().getCode(),
                        DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }

            if (認定申請情報.get出力年月日() != null && !認定申請情報.get出力年月日().isEmpty()) {
                WarningMessage message = new WarningMessage(DbeWarningMessages.既に印刷済.getMessage().getCode(),
                        DbeWarningMessages.既に印刷済.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }

        if (new RString(DbeQuestionMessages.二次判定結果が決定していませんが印刷.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (認定申請情報.get出力年月日() != null && !認定申請情報.get出力年月日().isEmpty()) {
                WarningMessage message = new WarningMessage(DbeWarningMessages.既に印刷済.getMessage().getCode(),
                        DbeWarningMessages.既に印刷済.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        ViewStateHolder.put(ViewStateKeys.状態, ResponseHolder.getButtonType() != null ? ResponseHolder.getButtonType().getKey() : null);
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンクリックイベントです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnPrint(YokaigoNinteiJohoTeikyoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        if (ViewStateHolder.get(ViewStateKeys.状態, RString.class) != null
                && MessageDialogSelectedResult.No.getKey().equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            return response;
        }

        ShinseishoKanriNo 申請書管理番号 = (!RString.isNullOrEmpty(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class)))
                ? new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class))
                : ShinseishoKanriNo.EMPTY;
        YokaigoNinteiJohoTeikyoFinder finder = YokaigoNinteiJohoTeikyoFinder.createInstance();
        YokaigoNinteiJohoTeikyoBusiness business = finder.get要介護認定情報提供(申請書管理番号);
        RDateTime イメージ共有ファイルID = finder.getイメージ共有ファイルID(申請書管理番号);
        List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List = finder.get認定調査票サービス状況(申請書管理番号);
        List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList = finder.get認定調査票サービス状況フラグ(申請書管理番号);
        List<NinteichosahyoChosaItem> 認定調査票調査項目List = finder.get認定調査票調査項目List(申請書管理番号);

        try (ReportManager reportManager = new ReportManager()) {
            if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                print一式(div, finder, business, 申請書管理番号, イメージ共有ファイルID, 認定調査票サービス状況List,
                        認定調査票サービス状況フラグList, 認定調査票調査項目List, reportManager);
            } else {
                print帳票ごと(div, finder, business, 申請書管理番号, イメージ共有ファイルID, 認定調査票サービス状況List,
                        認定調査票サービス状況フラグList, 認定調査票調査項目List, reportManager);
            }
            response.data = reportManager.publish();
            update要介護認定申請情報(finder.get要介護認定申請情報(申請書管理番号));
        }
        return response;
    }

    private void print一式(YokaigoNinteiJohoTeikyoDiv div,
            YokaigoNinteiJohoTeikyoFinder finder,
            YokaigoNinteiJohoTeikyoBusiness business,
            ShinseishoKanriNo 申請書管理番号,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            ReportManager reportManager) {

        List<NinteichosahyoKinyuItem> 認定調査票記入項目List = new ArrayList<>();
        RString 総合事業開始区分 = RString.EMPTY;
        List<NinteichosaRelate> 特記事項List = new ArrayList<>();
        List<RString> 特記事項区分List = new ArrayList<>();
        List<RString> 認定調査特記事項番号List = new ArrayList<>();
        List<NinteichosahyoChosaItem> 前回認定調査票調査項目List = new ArrayList<>();
        List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List = new ArrayList<>();
        List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List = new ArrayList<>();
        RString 特記事項符号印刷有無 = RString.EMPTY;
        RString 正常選択肢印刷有無 = RString.EMPTY;
        RString 前回との結果比較印刷有無 = RString.EMPTY;
        RString 前回正常選択肢印刷有無 = RString.EMPTY;
        if (div.getChkNinteiChosahyo().isAllSelected()) {
            認定調査票記入項目List = finder.get認定調査票記入項目List(申請書管理番号);
            総合事業開始区分 = DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        if (div.getChkTokkiJiko().isAllSelected()) {
            特記事項List = finder.get特記事項List(申請書管理番号, div.getRadTokkiJikoMasking().getSelectedKey());
            if (あり.equals(div.getRadTokkiJikoMasking().getSelectedKey()) && 特記事項List.isEmpty()) {
                特記事項List = finder.get特記事項List(申請書管理番号, なし);
            }
            for (NinteichosaRelate 特記事項 : 特記事項List) {
                特記事項区分List.add(特記事項.get特記事項区分());
            }
        }
        if (div.getChkIchijiHanteiKekka().isAllSelected()) {
            認定調査特記事項番号List = finder.get認定調査特記事項番号(申請書管理番号);
            前回認定調査票調査項目List = finder.get前回認定調査票調査項目List(申請書管理番号);
            主治医意見書意見項目List = finder.get主治医意見書意見項目List(申請書管理番号);
            前回主治医意見書意見項目List = finder.get前回主治医意見書意見項目List(申請書管理番号);
            特記事項符号印刷有無
                    = DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            正常選択肢印刷有無
                    = DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            前回との結果比較印刷有無
                    = DbBusinessConfig.get(ConfigNameDBE.前回との結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            前回正常選択肢印刷有無
                    = DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        new YokaigoNinteiJohoTeikyoPrintService(reportManager).print(
                div.getChkNinteiChosahyo().isAllSelected(),
                div.getChkTokkiJiko().isAllSelected(),
                div.getChkShujiiIkensho().isAllSelected(),
                div.getChkSonotaShiryo().isAllSelected(),
                div.getChkIchijiHanteiKekka().isAllSelected(),
                div.getRadNinteiChosaMasking().getSelectedKey(),
                div.getRadTokkiJikoMasking().getSelectedKey(),
                div.getRadShujii().getSelectedKey(),
                div.getRadSonotaShiryoMasking().getSelectedKey(),
                div.getRadIchijiHanteiMasking().getSelectedKey(),
                business,
                イメージ共有ファイルID,
                認定調査票サービス状況List,
                認定調査票サービス状況フラグList,
                認定調査票調査項目List,
                認定調査票記入項目List,
                総合事業開始区分,
                特記事項区分List,
                特記事項List,
                認定調査特記事項番号List,
                前回認定調査票調査項目List,
                主治医意見書意見項目List,
                前回主治医意見書意見項目List,
                特記事項符号印刷有無,
                正常選択肢印刷有無,
                前回との結果比較印刷有無,
                前回正常選択肢印刷有無);
    }

    private void print帳票ごと(YokaigoNinteiJohoTeikyoDiv div,
            YokaigoNinteiJohoTeikyoFinder finder,
            YokaigoNinteiJohoTeikyoBusiness business,
            ShinseishoKanriNo 申請書管理番号,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            ReportManager reportManager) {

        if (div.getChkNinteiChosahyo().isAllSelected()) {
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List = finder.get認定調査票記入項目List(申請書管理番号);
            print認定調査票(business, イメージ共有ファイルID, 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                    認定調査票調査項目List, 認定調査票記入項目List, div.getRadNinteiChosaMasking().getSelectedKey(), reportManager);
        }

        if (div.getChkTokkiJiko().isAllSelected()) {
            RString 特記事項マスキング区分 = div.getRadTokkiJikoMasking().getSelectedKey();
            List<NinteichosaRelate> 特記事項List = finder.get特記事項List(申請書管理番号, 特記事項マスキング区分);
            if (あり.equals(特記事項マスキング区分) && 特記事項List.isEmpty()) {
                特記事項List = finder.get特記事項List(申請書管理番号, なし);
            }
            List<RString> 特記事項区分List = new ArrayList<>();
            for (NinteichosaRelate 特記事項 : 特記事項List) {
                特記事項区分List.add(特記事項.get特記事項区分());
            }
            print特記事項(business, 特記事項区分List, 特記事項List, 特記事項マスキング区分, イメージ共有ファイルID, reportManager);
        }

        if (div.getChkShujiiIkensho().isAllSelected()) {
            print主治医意見書(business, イメージ共有ファイルID, div.getRadShujii().getSelectedKey(), reportManager);
        }

        if (div.getChkSonotaShiryo().isAllSelected()) {
            printその他資料(business, イメージ共有ファイルID, div.getRadSonotaShiryoMasking().getSelectedKey(), reportManager);
        }

        if (div.getChkIchijiHanteiKekka().isAllSelected()) {
            List<RString> 認定調査特記事項番号List = finder.get認定調査特記事項番号(申請書管理番号);
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List = finder.get前回認定調査票調査項目List(申請書管理番号);
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List = finder.get主治医意見書意見項目List(申請書管理番号);
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List = finder.get前回主治医意見書意見項目List(申請書管理番号);
            print一次判定結果(business, 認定調査特記事項番号List, 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                    認定調査票調査項目List, 前回認定調査票調査項目List, 主治医意見書意見項目List, 前回主治医意見書意見項目List,
                    div.getRadIchijiHanteiMasking().getSelectedKey(), reportManager);
        }
    }

    private void print認定調査票(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoKinyuItem> 認定調査票記入項目List,
            RString 認定調査票マスキング区分,
            ReportManager reportManager) {
        RString 総合事業開始区分 = DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        INinteiChosaJohohyoPrintService printService
                = NinteiChosaJohohyoPrintServiceFactory.create(business.get厚労省IF識別コード(), 総合事業開始区分, reportManager);
        if (printService != null) {
            printService.print(business, イメージ共有ファイルID, 認定調査票サービス状況List, 認定調査票サービス状況フラグList,
                    認定調査票調査項目List, 認定調査票記入項目List, 認定調査票マスキング区分);
        }
    }

    private void print特記事項(YokaigoNinteiJohoTeikyoBusiness business,
            List<RString> 特記事項区分List,
            List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分,
            RDateTime イメージ共有ファイルID,
            ReportManager reportManager) {
        ITokkiJikoPrintService printService = TokkiJikoPrintServiceFactory.create(business.toEntity(), 特記事項区分List, reportManager);
        if (printService != null) {
            printService.print(business, 特記事項List, 特記事項マスキング区分, イメージ共有ファイルID);
        }
    }

    private void print主治医意見書(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            RString 主治医意見書マスキング区分,
            ReportManager reportManager) {
        new ShujiiIkenshoPrintService(reportManager).print(business, イメージ共有ファイルID, 主治医意見書マスキング区分);
    }

    private void printその他資料(YokaigoNinteiJohoTeikyoBusiness business,
            RDateTime イメージ共有ファイルID,
            RString その他資料マスキング区分,
            ReportManager reportManager) {
        new SonotashiryoPrintService(reportManager).print(business, イメージ共有ファイルID, その他資料マスキング区分);
    }

    private void print一次判定結果(YokaigoNinteiJohoTeikyoBusiness business,
            List<RString> 認定調査特記事項番号List,
            List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList,
            List<NinteichosahyoChosaItem> 認定調査票調査項目List,
            List<NinteichosahyoChosaItem> 前回認定調査票調査項目List,
            List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List,
            List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List,
            RString 一次判定結果マスキング区分,
            ReportManager reportManager) {
        new IchijihanteikekkahyoPrintService(reportManager).print(business, 認定調査特記事項番号List, 認定調査票サービス状況List,
                認定調査票サービス状況フラグList, 認定調査票調査項目List, 前回認定調査票調査項目List, 主治医意見書意見項目List,
                前回主治医意見書意見項目List, 一次判定結果マスキング区分);
    }

    private void update要介護認定申請情報(NinteiShinseiJoho 要介護認定申請情報) {
        if (要介護認定申請情報 != null) {
            NinteiShinseiJohoBuilder builder = 要介護認定申請情報.createBuilderForEdit();
            builder.set情報提供資料出力年月日(FlexibleDate.getNowDate());
            NinteiShinseiJohoManager.createInstance().save要介護認定申請情報(builder.build().modifiedModel());
        }
    }

    private YokaigoNinteiJohoTeikyoHandler getHandler(YokaigoNinteiJohoTeikyoDiv div) {
        return new YokaigoNinteiJohoTeikyoHandler(div);
    }

    private YokaigoNinteiJohoTeikyoValidationHandler getValidationHandler(YokaigoNinteiJohoTeikyoDiv div) {
        return new YokaigoNinteiJohoTeikyoValidationHandler(div);
    }
}
