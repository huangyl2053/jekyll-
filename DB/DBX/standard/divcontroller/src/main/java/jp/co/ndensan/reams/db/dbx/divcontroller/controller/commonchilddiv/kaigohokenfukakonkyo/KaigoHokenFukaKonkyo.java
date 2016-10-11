/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.divcontroller.controller.commonchilddiv.kaigohokenfukakonkyo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.fukajoho.FukaJohoRelateSearchResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.KaigoHokenFukaKonkyo.KaigoHokenFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.KaigoHokenFukaKonkyo.KaigoHokenFukaKonkyoHandler;
import jp.co.ndensan.reams.db.dbx.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbx.service.core.fuka.FukaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 賦課根拠照会【共有子Div】のcontrollerクラスです。
 *
 * @reamsid_L DBB-5723-010 xuxin
 */
public class KaigoHokenFukaKonkyo {

    private static final Code 業務固有 = new Code("0003");
    private static final RString 業務固有の識別情報名称 = new RString("被保険者番号");

    private KaigoHokenFukaKonkyoHandler getHandler(KaigoHokenFukaKonkyoDiv div) {
        return new KaigoHokenFukaKonkyoHandler(div);
    }

    /**
     * 初期化のonLoadイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> initialize(KaigoHokenFukaKonkyoDiv div) {

        ShikibetsuCode 識別コード = DataPassingConverter.deserialize(div.get識別コード(), ShikibetsuCode.class);
        if (識別コード != null) {
            div.getTxtShikibetsuCode().setValue(識別コード.getColumnValue());
            List<FukaJohoRelateSearchResult> resultList = FukaJohoFinder.createInstance().
                    find全ての賦課の情報(識別コード).records();
            if (!resultList.isEmpty()) {
                List<FukaJohoRelateSearchResult> resultList合併後 = setList合併(resultList);
                ViewStateHolder.put(ViewStateKeys.賦課根拠情報, (Serializable) resultList合併後);
                FukaJohoRelateSearchResult resultMax = resultList合併後.get(resultList合併後.size() - 1);
                ShoriDateKanri 処理日付管理情報 = ShoriDateKanriManager.createInstance().
                        get最大基準日時(resultMax.get介護賦課Result().get賦課年度());
                getHandler(div).init(処理日付管理情報, resultMax, resultList合併後, 識別コード);
                setAccessLog出力(識別コード, resultMax.get介護賦課Result().get被保険者番号());
            } else {
                div.getBtnBefore().setDisabled(true);
                div.getBtnAfter().setDisabled(true);
            }
        }
        return ResponseData.of(div).respond();
    }

    private List<FukaJohoRelateSearchResult> setList合併(List<FukaJohoRelateSearchResult> resultList) {
        if (resultList.size() == 1) {
            return resultList;
        } else {
            List<FukaJohoRelateSearchResult> resultList合併後 = new ArrayList<>();
            for (int i = 0; i < resultList.size(); i++) {
                FukaJohoRelateSearchResult result1 = resultList.get(i);
                if (i == resultList.size() - 1) {
                    resultList合併後.add(result1);
                    break;
                }
                FukaJohoRelateSearchResult result2 = resultList.get(i + 1);
                if (result1.get介護賦課Result().get調定年度().equals(result2.get介護賦課Result().get調定年度())
                        && result1.get介護賦課Result().get賦課年度().equals(result2.get介護賦課Result().get賦課年度())
                        && result1.get介護賦課Result().get通知書番号().equals(result2.get介護賦課Result().get通知書番号())
                        && (result1.get介護賦課Result().get履歴番号() == result2.get介護賦課Result().get履歴番号())) {
                    Decimal 合計調定額 = result1.get調定額().add(result2.get調定額());
                    result2.set調定額(合計調定額);
                } else {
                    resultList合併後.add(result1);
                }
            }
            return resultList合併後;
        }
    }

    private void setAccessLog出力(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        if (被保険者番号 != null) {
            ExpandedInformation expandedInfo = new ExpandedInformation(業務固有, 業務固有の識別情報名称,
                    被保険者番号.getColumnValue());
            AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード, expandedInfo));
        }
    }

    /**
     * 調定年度DDLのonChangeイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onChange_ddlChoteiNendo(KaigoHokenFukaKonkyoDiv div) {

        List<FukaJohoRelateSearchResult> 賦課根拠情報List = ViewStateHolder.get(ViewStateKeys.賦課根拠情報, List.class);
        if (賦課根拠情報List != null && !賦課根拠情報List.isEmpty()) {
            getHandler(div).setDDL再表示(賦課根拠情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 賦課年度DDLのonChangeイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onChange_ddlFukaNendo(KaigoHokenFukaKonkyoDiv div) {

        List<FukaJohoRelateSearchResult> 賦課根拠情報List = ViewStateHolder.get(ViewStateKeys.賦課根拠情報, List.class);
        if (賦課根拠情報List != null && !賦課根拠情報List.isEmpty()) {
            getHandler(div).set通知書番号DDL再表示(賦課根拠情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「表示する」ボタンのonClickイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onClick_btnSearch(KaigoHokenFukaKonkyoDiv div) {

        List<FukaJohoRelateSearchResult> 賦課根拠情報List = ViewStateHolder.get(ViewStateKeys.賦課根拠情報, List.class);
        if (賦課根拠情報List != null && !賦課根拠情報List.isEmpty()) {
            FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
            ShoriDateKanri 処理日付管理情報 = ShoriDateKanriManager.createInstance().get最大基準日時(画面賦課年度);
            getHandler(div).btnSearch(処理日付管理情報, 賦課根拠情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「前へ」ボタンのonClickイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onClick_btnBefore(KaigoHokenFukaKonkyoDiv div) {

        List<FukaJohoRelateSearchResult> 賦課根拠情報List = ViewStateHolder.get(ViewStateKeys.賦課根拠情報, List.class);
        if (賦課根拠情報List != null && !賦課根拠情報List.isEmpty()) {
            FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
            ShoriDateKanri 処理日付管理情報 = ShoriDateKanriManager.createInstance().get最大基準日時(画面賦課年度);
            getHandler(div).btnBefore(処理日付管理情報, 賦課根拠情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「後へ」ボタンのonClickイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onClick_btnAfter(KaigoHokenFukaKonkyoDiv div) {

        List<FukaJohoRelateSearchResult> 賦課根拠情報List = ViewStateHolder.get(ViewStateKeys.賦課根拠情報, List.class);
        if (賦課根拠情報List != null && !賦課根拠情報List.isEmpty()) {
            FlexibleYear 画面賦課年度 = new FlexibleYear(div.getDdlFukaNendo().getSelectedKey());
            ShoriDateKanri 処理日付管理情報 = ShoriDateKanriManager.createInstance().get最大基準日時(画面賦課年度);
            getHandler(div).btnAfter(処理日付管理情報, 賦課根拠情報List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタンのonClickイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onClick_btnClose(KaigoHokenFukaKonkyoDiv div) {
        return ResponseData.of(div).respond();
    }

}
