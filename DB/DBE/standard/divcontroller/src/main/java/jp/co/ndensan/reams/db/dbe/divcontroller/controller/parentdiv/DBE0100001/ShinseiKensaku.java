/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinseikensaku.ShinseiKensakuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinseikensaku.ShinseiKensakuInfoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001.DBE0100001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001.DBE0100001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001.ShinseiKensakuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0100001.dgShinseiJoho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0100001.ShinseiKensakuHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinseikensaku.ShinseiKensakuFinder;
import jp.co.ndensan.reams.db.dbe.service.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定申請検索のクラスです。
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
public class ShinseiKensaku {

    private static final RString MENUID_DBEMN11001 = new RString("DBEMN11001");
    private static final RString MENUID_DBEMN11003 = new RString("DBEMN11003");
    private static final RString MENUID_DBEMN14001 = new RString("DBEMN14001");
    private static final RString MENUID_DBEMN32002 = new RString("DBEMN32002");
    private static final RString MENUID_DBEMN31005 = new RString("DBEMN31005");
    private static final RString MENUID_DBEMN21001 = new RString("DBEMN21001");
    private static final RString MENUID_DBEMN33001 = new RString("DBEMN33001");
    private static final RString MENUID_DBEMN62001 = new RString("DBEMN72001");
    private static final RString BUTTON_BTNITIRANPRINT = new RString("btnitiranprint");

    /**
     * 画面初期化処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<ShinseiKensakuDiv> onLoad(ShinseiKensakuDiv div) {
        div.getCcdNinteishinseishaFinder().initialize();
        getHandler(div).load();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (MENUID_DBEMN11001.equals(menuID)) {
            return ResponseData.of(div).setState(DBE0100001StateName.申請検索);
        } else if (MENUID_DBEMN11003.equals(menuID)) {
            return ResponseData.of(div).setState(DBE0100001StateName.個人照会);
        } else if (MENUID_DBEMN14001.equals(menuID)
                || MENUID_DBEMN32002.equals(menuID)
                || MENUID_DBEMN31005.equals(menuID)) {
            return ResponseData.of(div).setState(DBE0100001StateName.情報提供);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件クリア処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<ShinseiKensakuDiv> onClick_btnClear(ShinseiKensakuDiv div) {
        div.getCcdNinteishinseishaFinder().initialize();
        getHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<ShinseiKensakuDiv> onClick_btnKensaku(ShinseiKensakuDiv div) {
        ValidationMessageControlPairs pairs = div.getCcdNinteishinseishaFinder().validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<ShinseiKensakuBusiness> list = ShinseiKensakuFinder.createInstance().getShinseiKensaku(getHandler(div).createParameter());
        ViewStateHolder.put(ViewStateKeys.認定申請情報, new ShinseiKensakuInfoBusiness(list));
        if (!list.isEmpty()) {
            getHandler(div).setShinseiJohoIchiran(list);
            div.getCcdNinteishinseishaFinder().getNinteiShinseishaFinderDiv().setIsOpen(false);
            div.getBtnClear().setDisabled(true);
            div.getTxtMaxDisp().setDisabled(true);
            div.getBtnKensaku().setDisabled(true);
            div.getBtnModoru().setDisabled(false);
            IUrControlData controlData = UrControlDataFactory.createInstance();
            RString menuID = controlData.getMenuID();
            if (MENUID_DBEMN11001.equals(menuID)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BUTTON_BTNITIRANPRINT, false);
            }
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 申請一覧の「選択」ボタン処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<ShinseiKensakuDiv> onSelect_dgShinseiJoho(ShinseiKensakuDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        dgShinseiJoho_Row row = div.getDgShinseiJoho().getActiveRow();
        RString 申請書管理番号 = row.getShinseishoKanriNo();
        RString 証記載保険者番号 = row.getShoKisaiHokenshaNo();
        RString 被保険者番号 = row.getHihokenshaNo();
        RString 主治医意見書作成依頼履歴番号 = row.getIkenshoIraiRirekiNo();
        div.getBtnClear().setDisabled(false);
        div.getTxtMaxDisp().setDisabled(false);
        div.getBtnKensaku().setDisabled(false);
        if (MENUID_DBEMN11001.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.要介護認定個人状況照会へ).respond();
        } else if (MENUID_DBEMN11003.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.要介護認定個人状況照会へ).respond();
        } else if (MENUID_DBEMN14001.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.証記載保険者番号, 証記載保険者番号);
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.要介護認定情報提供へ).respond();
        } else if (MENUID_DBEMN32002.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
            ViewStateHolder.put(ViewStateKeys.主治医意見書作成依頼履歴番号, 主治医意見書作成依頼履歴番号);
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.主治医意見書登録へ).respond();
        } else if (MENUID_DBEMN31005.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(申請書管理番号));
            ViewStateHolder.put(ViewStateKeys.認定調査履歴番号,
                    Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.認定調査結果登録1へ).respond();
        } else if (MENUID_DBEMN21001.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(申請書管理番号));
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.審査依頼受付へ).respond();
        } else if (MENUID_DBEMN33001.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(申請書管理番号));
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.個人依頼内容更新へ).respond();
        } else if (MENUID_DBEMN62001.equals(menuID)) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(申請書管理番号));
            return ResponseData.of(div).forwardWithEventName(DBE0100001TransitionEventName.要介護認定イメージ情報管理へ).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索条件に戻る」ボタン処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<ShinseiKensakuDiv> onClick_btnModoru(ShinseiKensakuDiv div) {
        List<dgShinseiJoho_Row> dataSource = new ArrayList<>();
        div.getDgShinseiJoho().setDataSource(dataSource);
        div.getBtnClear().setDisabled(false);
        div.getTxtMaxDisp().setDisabled(false);
        div.getBtnKensaku().setDisabled(false);
        div.getBtnModoru().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択した帳票を発行する」ボタンのclick後処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<ShinseiKensakuDiv>
     */
    public ResponseData<ShinseiKensakuDiv> onClick_printAfter(ShinseiKensakuDiv div) {
        return ResponseData.of(div).setState(DBE0100001StateName.完了);
    }

    /**
     * 「選択した帳票を発行する」ボタンのclick処理です。
     *
     * @param div ShinseiKensakuDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnitiranprint(ShinseiKensakuDiv div) {
        List<YokaigoYoshienShinseiIchiranItem> items = new ArrayList<>();
        ShinseiKensakuInfoBusiness infoBusiness = ViewStateHolder.get(ViewStateKeys.認定申請情報, ShinseiKensakuInfoBusiness.class);
        int renban = 1;
        for (ShinseiKensakuBusiness row : infoBusiness.getShinseiKensakuList()) {
            YokaigoYoshienShinseiIchiranItem item = new YokaigoYoshienShinseiIchiranItem();
            item.setRenban(new RString(String.valueOf(renban++)));
            item.setShoKisaiHokenshaNo(row.get証記載保険者番号());
            item.setShichosonName(row.get市町村名称());
            if (row.get被保険者氏名() != null) {
                item.setHihokenshaName(row.get被保険者氏名().value());
            }
            item.setHihokenshaNo(row.get被保険者番号());
            item.setSeinengappiYMD(row.get生年月日());
            item.setSeibetsu(row.get性別());
            item.setKoroshoIfShikibetsuCode(row.get厚労省IF識別コード());
            item.setNijiHanteiYokaigoJotaiKubun(row.get二次判定要介護状態区分コード());
            item.setNijiHanteiNinteiYukoKikan(row.get二次判定認定有効期間());
            item.setNijiHanteiNinteiYukoKaishiYMD(row.get前回認定有効期間_開始_());
            item.setNijiHanteiNinteiYukoShuryoYMD(row.get前回認定有効期間_終了_());
            item.setNinteiShinseiYMD(row.get認定申請年月日());
            item.setNinteiShinseiShinseijiKubun(row.get認定申請区分_申請時_コード());
            item.setJigyoshaMeisho(row.get事業者名称());
            item.setChosainShimei(row.get調査員氏名());
            item.setIryoKikanMeisho(row.get医療機関名称());
            item.setShujiiName(row.get主治医氏名());
            items.add(item);
        }
        return ResponseData.of(new YokaigoYoshienShinseiIchiranPrintService().print(items)).respond();
    }

    private ShinseiKensakuHandler getHandler(ShinseiKensakuDiv div) {
        return new ShinseiKensakuHandler(div);
    }
}
