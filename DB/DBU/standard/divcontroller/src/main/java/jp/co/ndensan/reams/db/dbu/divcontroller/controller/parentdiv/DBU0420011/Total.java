/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0420011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4Joho;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Item;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoJoho;
import jp.co.ndensan.reams.db.dba.service.report.hihokenshashoa4.HihokenshashoA4PrintService;
import jp.co.ndensan.reams.db.dba.service.report.hihokenshashob4.HihokenshashoB4PrintService;
import jp.co.ndensan.reams.db.dba.service.report.jukyushikakushomeisho.JukyuShikakuShomeishoPrintService;
import jp.co.ndensan.reams.db.dba.service.report.shikakushasho.ShikakushashoPrintService;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashikakushodata.HihokenshaShikakuShoDataParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011.DBU0420011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011.DBU0420011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011.TotalDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0420011.TotalHandler;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashikakusho.HihokenshaShikakuShoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 被保険者証・資格者証管理Divを制御します。
 *
 * @reamsid_L DBU-0490-010 zhangzhiming
 */
public class Total {

    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");
    private static final RString MENUID_DBUMN12003 = new RString("DBUMN12003");
    private static final RString 帳票制御汎用_証表示タイプ = new RString("証表示タイプ");
    private static final ReportId 帳票分類ID = new ReportId("DBA100001_Hihokenshasho");
    private static final RString テスト = new RString("テスト");
    private static final RString 証表示タイプ_01 = new RString("01");
    private static final RString 証表示タイプ_21 = new RString("21");
    private static final int 桁数_6 = 6;

    /**
     * 被保険者証・資格者証画面初期化を処理します。
     *
     * @param div 被保険者証・資格者証DIV
     * @return ResponseData<TotalDiv>
     */
    public ResponseData<TotalDiv> onLoad(TotalDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        createHandler(div).onLoad(識別コード, 被保険者番号);
        if (MENUID_DBUMN12001.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).setState(DBU0420011StateName.被保険者証);
        }
        if (MENUID_DBUMN12002.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).setState(DBU0420011StateName.資格者証);
        }
        if (MENUID_DBUMN12003.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).setState(DBU0420011StateName.受給資格証明書);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェック実行します。
     *
     * @param div 被保険者証・資格者証DIV
     * @return ResponseData<TotalDiv>
     */
    public ResponseData<TotalDiv> onClick_btnCheck(TotalDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = createHandler(div).detaCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタン実行します。
     *
     * @param div 被保険者証・資格者証DIV
     * @return ResponseData<TotalDiv>
     */
    public ResponseData<TotalDiv> btn_ReSearch(TotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0420011TransitionEventName.対象者検索に戻る).respond();
    }

    /**
     * 被保険者証・資格者証画面「発行する」ボタンを処理します。
     *
     * @param div 被保険者証・資格者証DIV
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnPublish(TotalDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        if (MENUID_DBUMN12001.equals(ResponseHolder.getMenuID())) {
            if (!テスト.equals(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getDdlKofuJiyu().getSelectedValue())) {
                insertShoKofuKaishu(div);
            }
            ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
            ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBA介護資格, 帳票分類ID,
                    FlexibleDate.getNowDate().getYear(), 帳票制御汎用_証表示タイプ);
            if (証表示タイプ_01.equals(chohyoSeigyoHanyo.get設定値())) {
                List<HihokenshashoA4BodyItem> bodyItemlist = createHandler(div).hihokenshashoA4(識別コード, 被保険者番号);
                HihokenshashoA4Joho hihokenshashoA4 = new HihokenshashoA4Joho(bodyItemlist);
                return ResponseData.of(new HihokenshashoA4PrintService().print(hihokenshashoA4)).respond();
            }
            if (証表示タイプ_21.equals(chohyoSeigyoHanyo.get設定値())) {
                List<HihokenshashoB4Item> items = createHandler(div).hihokenshashoB4(識別コード, 被保険者番号);
                return ResponseData.of(new HihokenshashoB4PrintService().print(items)).respond();
            }
        }
        if (MENUID_DBUMN12002.equals(ResponseHolder.getMenuID())) {
            if (!テスト.equals(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getDdlKofuJiyu().getSelectedValue())) {
                insertShoKofuKaishu(div);
            }
            List<ShikakushashoBodyItem> bodyItemList = createHandler(div).shikakushasho(識別コード, 被保険者番号);
            ShikakushashoJoho reportJoho = new ShikakushashoJoho(bodyItemList);
            return ResponseData.of(new ShikakushashoPrintService().print(reportJoho)).respond();
        }
        if (MENUID_DBUMN12003.equals(ResponseHolder.getMenuID())) {
            List<JukyuShikakuShomeishoBodyItem> bodyItemList = createHandler(div).jukyuShikakuShomeisho(識別コード, 被保険者番号);
            return ResponseData.of(new JukyuShikakuShomeishoPrintService().print(bodyItemList)).respond();
        }
        return null;
    }

    private void insertShoKofuKaishu(TotalDiv div) {
        HihokenshaShikakuShoDataParameter parameter = new HihokenshaShikakuShoDataParameter();
        parameter.setMenuId(ResponseHolder.getMenuID());
        parameter.setHihokenshaNo(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号());
        parameter.setShikibetsuCode(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード());
        parameter.setShoKisaiHokenshaNo(RString.isNullOrEmpty(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().
                getYukoKigenInfo().getTxtHokensha().getValue()) ? ShoKisaiHokenshaNo.EMPTY
                : new ShoKisaiHokenshaNo(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().
                        getYukoKigenInfo().getTxtHokensha().getValue().substring(0, 桁数_6)));
        parameter.setKofuYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtKofuDate().getValue());
        parameter.setKofuJiyu(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getDdlKofuJiyu().getSelectedKey());
        parameter.setKofuRiyu(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getDdlKofuJiyu().getSelectedValue());
        HihokenshaShikakuShoFinder.createInstance().insert(HihokenshaShikakuShoFinder.createInstance().insertShoKofuKaishu(parameter));
    }

    private TotalHandler createHandler(TotalDiv div) {
        return new TotalHandler(div);
    }
}
