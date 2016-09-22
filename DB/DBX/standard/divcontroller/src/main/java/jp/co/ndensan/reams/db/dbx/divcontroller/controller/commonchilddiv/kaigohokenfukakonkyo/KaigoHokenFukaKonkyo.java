/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.divcontroller.controller.commonchilddiv.kaigohokenfukakonkyo;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.fukajoho.FukaJohoRelateSearchResult;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.KaigoHokenFukaKonkyo.KaigoHokenFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbx.divcontroller.entity.commonchilddiv.KaigoHokenFukaKonkyo.KaigoHokenFukaKonkyoHandler;
import jp.co.ndensan.reams.db.dbx.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbx.service.core.fuka.FukaJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 賦課根拠照会【共有子Div】のcontrollerクラスです。
 *
 * @reamsid_L DBB-5723-010 xuxin
 */
public class KaigoHokenFukaKonkyo {

    private static final RString ログコード = new RString("0001");

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
            List<FukaJohoRelateSearchResult> resultList = FukaJohoFinder.createInstance().
                    find全ての賦課の情報(識別コード).records();     //1.1
            div.getTxtShikibetsuCode().setValue(識別コード.getColumnValue());
            if (!resultList.isEmpty()) {
                ViewStateHolder.put(ViewStateKeys.賦課根拠情報, (Serializable) resultList);
                int listSize = resultList.size();
                FukaJohoRelateSearchResult resultMax = resultList.get(listSize - 1);   //1.2
                ShoriDateKanri 処理日付管理情報 = ShoriDateKanriManager.createInstance().
                        get最大基準日時(resultMax.get介護賦課Result().get賦課年度());  //1.3
                getHandler(div).init(処理日付管理情報, resultMax, resultList);
            }
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(識別コード.getColumnValue()), ログコード,
                    識別コード.getColumnValue());
            AccessLogger.log(AccessLogType.照会, PersonalData.of(識別コード, expandedInfo));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調定年度DDLのonChangeイベントです。
     *
     * @param div KaigoHokenFukaKonkyoDiv
     * @return ResponseData<KaigoHokenFukaKonkyoDiv>
     */
    public ResponseData<KaigoHokenFukaKonkyoDiv> onChange_ddlChoteiNendo(KaigoHokenFukaKonkyoDiv div) {
        List<FukaJohoRelateSearchResult> 賦課根拠情報List = ViewStateHolder.get(ViewStateKeys.賦課根拠情報, List.class);
        getHandler(div).setDDL再表示(賦課根拠情報List);
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
        getHandler(div).set通知書番号DDL再表示(賦課根拠情報List);
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
        getHandler(div).get指定賦課情報(賦課根拠情報List);
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
        getHandler(div).get指定賦課情報前へ(賦課根拠情報List);
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
        getHandler(div).get指定賦課情報後へ(賦課根拠情報List);
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
