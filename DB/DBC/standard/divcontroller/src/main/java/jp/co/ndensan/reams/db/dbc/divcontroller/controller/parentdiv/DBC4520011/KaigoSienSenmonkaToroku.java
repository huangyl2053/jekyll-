/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC4520011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.DBC4520011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4520011.KaigoSienSenmonkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouFinder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManeger;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManegerHolder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.CareManegerIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.basic.CareManegerManager;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護支援専門員登録画面 divcontrollerクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class KaigoSienSenmonkaToroku {

    private static final LockingKey 前排他ロックキー = new LockingKey("DbT7064CareManeger");
    private static final RString RADIOBUTTON_SELECTKEY = new RString("key0");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    private static final RString 事業者入力モード = new RString("事業者入力モード");

    private KaigoSienSenmonkaTorokuHandler getHandler(KaigoSienSenmonkaTorokuDiv div) {
        return new KaigoSienSenmonkaTorokuHandler(div);
    }

    private KaigoSienSenmonkaTorokuValidationHandler getValidationHandler(KaigoSienSenmonkaTorokuDiv div) {
        return new KaigoSienSenmonkaTorokuValidationHandler(div);
    }

    /**
     * 介護支援専門員登録画面 初期化を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onLoad(KaigoSienSenmonkaTorokuDiv div) {
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new PessimisticLockingException();
        }
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 事業者入力モード);
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 RAD選択を処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_radChange(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_radChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「条件をクリアする」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnClear(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「検索する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnSearch(KaigoSienSenmonkaTorokuDiv div) {
        KaigoShienSenmoninJouhouParameter param = getParameter(div);
        KaigoShienSenmoninJouhouFinder finder = KaigoShienSenmoninJouhouFinder.createInstance();
        List<KaigoShienSenmoninJouhouResult> resultList = finder.get介護支援専門員情報(param);
        List<CareManeger> careManagerList = new ArrayList<>();
        if (resultList != null && (!resultList.isEmpty())) {
            for (KaigoShienSenmoninJouhouResult result : resultList) {
                careManagerList.add(result.getCareManeger());
            }
            ViewStateHolder.put(ViewStateHolderName.介護支援専門員登録情報, new CareManegerHolder(careManagerList));
            getHandler(div).onClick_btnSearch(resultList);
        }
        return ResponseData.of(div).respond();
    }

    private KaigoShienSenmoninJouhouParameter getParameter(KaigoSienSenmonkaTorokuDiv div) {
        KaigoShienSenmoninJouhouParameter param = new KaigoShienSenmoninJouhouParameter();
        if (RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadKaigoSienSenmoninBangoKensaku().getSelectedKey())
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtKaigoShienSenmoninBango().getValue()))) {
            param.set介護支援専門員番号(div.getKensakuJoken().getTxtKaigoShienSenmoninBango().getValue());
        }

        if (RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadShozokuJigyoshaBangoKensaku().getSelectedKey())
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtShozokuJigyoshaBango().getValue()))) {
            param.set所属事業者番号(div.getKensakuJoken().getTxtShozokuJigyoshaBango().getValue());
        }

        boolean is介護支援専門員氏名検索_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadKaigoShienSenmoninShimeiKensaku().getSelectedKey());
        if (is介護支援専門員氏名検索_SELECT
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtKanjiShimei().getValue()))) {
            param.set漢字氏名(div.getKensakuJoken().getTxtKanjiShimei().getValue());
        }
        param.set漢字氏名の前方一致(is介護支援専門員氏名検索_SELECT
                && RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getChkKanjiShimeiZenpoItchi().getSelectedKeys().isEmpty()
                        ? RString.EMPTY : div.getKensakuJoken().getChkKanjiShimeiZenpoItchi().getSelectedKeys().get(0)));
        if (is介護支援専門員氏名検索_SELECT
                && (!RString.isNullOrEmpty(div.getKensakuJoken().getTxtkanaShimei().getValue()))) {
            param.setカナ氏名(div.getKensakuJoken().getTxtkanaShimei().getValue());
        }
        param.setカナ氏名の前方一致(is介護支援専門員氏名検索_SELECT
                && RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getChkKanaShimeiZenpoItchi().getSelectedKeys().isEmpty()
                        ? RString.EMPTY : div.getKensakuJoken().getChkKanaShimeiZenpoItchi().getSelectedKeys().get(0)));

        boolean is有効期間検索_SELECT
                = RADIOBUTTON_SELECTKEY.equals(div.getKensakuJoken().getRadYukoKikanKensaku().getSelectedKey());
        if (is有効期間検索_SELECT) {
            if (null != div.getKensakuJoken().getTxtYukoKikanKensaku().getFromValue()) {
                param.set有効開始年月日(div.getKensakuJoken().getTxtYukoKikanKensaku().getFromValue().toDateString());
            }
            if (null != div.getKensakuJoken().getTxtYukoKikanKensaku().getToValue()) {
                param.set有効終了年月日(div.getKensakuJoken().getTxtYukoKikanKensaku().getToValue().toDateString());
            }
        }

        param.set最大表示件数(RString.isNullOrEmpty(div.getKensakuJoken().getTxtSaidaiHyojiKensu().getText()) ? 0
                : Integer.parseInt(div.getKensakuJoken().getTxtSaidaiHyojiKensu().getValue().toString()));
        return param;
    }

    /**
     * 介護支援専門員登録画面 「追加する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnTsuika(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnTsuika();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 介護支援専門員一覧DataGrid、「修正」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnModify(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnModify();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 介護支援専門員一覧DataGrid、「削除」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnDelete(KaigoSienSenmonkaTorokuDiv div) {
        getHandler(div).onClick_btnDelete();
        return ResponseData.of(div).respond();
    }

    /**
     * 介護支援専門員登録画面 「保存する」ボタンを処理します。
     *
     * @param div KaigoSienSenmonkaTorokuDiv
     * @return 画面
     */
    public ResponseData<KaigoSienSenmonkaTorokuDiv> onClick_btnSave(KaigoSienSenmonkaTorokuDiv div) {
        if (状態_追加.equals(div.getOperateState())) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        RString 介護支援専門員番号 = div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninBango().getValue();
        RString 介護支援専門員氏名 = div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().getValue();
        boolean isSuccess = 介護支援専門員登録情報を保存する(div, 介護支援専門員番号);
        RString 完了メッセージ = isSuccess ? new RString(UrInformationMessages.保存終了.getMessage().evaluate())
                : new RString(UrErrorMessages.異常終了.getMessage().evaluate());
        getHandler(div).介護完了メッセージパネルを表示する(完了メッセージ, 介護支援専門員番号, 介護支援専門員氏名, true);
        return ResponseData.of(div).setState(DBC4520011StateName.完了状態);
    }

    private boolean 介護支援専門員登録情報を保存する(KaigoSienSenmonkaTorokuDiv div, RString 介護支援専門員番号) {
        AtenaMeisho 介護支援専門員名 = new AtenaMeisho(div.getKaigoSienSenmoninToroku().getTxtKaigoSienSenmoninShimei().getValue());
        AtenaKanaMeisho 介護支援専門員名カナ
                = RString.isNullOrEmpty(div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().getValue())
                ? AtenaKanaMeisho.EMPTY : new AtenaKanaMeisho(div.getKaigoSienSenmoninToroku().getTxtKaingoSienSenmoninShimeiKana().getValue());
        JigyoshaNo 所属事業者番号 = new JigyoshaNo(div.getKaigoSienSenmoninToroku().getCcdShozokuJigyosha().getNyuryokuShisetsuKodo());
        FlexibleDate 有効開始年月日 = null == div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getFromValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getFromValue().toString());
        FlexibleDate 有効終了年月日 = null == div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getToValue() ? FlexibleDate.EMPTY
                : new FlexibleDate(div.getKaigoSienSenmoninToroku().getTxtYukoKikan().getToValue().toString());
        CareManegerHolder holder = ViewStateHolder.get(ViewStateHolderName.介護支援専門員登録情報, CareManegerHolder.class);
        CareManeger careManeger;
        if (状態_削除.equals(div.getOperateState())) {
            careManeger = holder.getCareManeger(new CareManegerIdentifier(介護支援専門員番号)).deleted();
        } else if (状態_修正.equals(div.getOperateState())) {
            careManeger = holder.getCareManeger(new CareManegerIdentifier(介護支援専門員番号)).createBuilderForEdit()
                    .set介護支援専門員名(介護支援専門員名)
                    .set介護支援専門員名カナ(介護支援専門員名カナ)
                    .set所属事業者番号(所属事業者番号)
                    .set有効開始年月日(有効開始年月日)
                    .set有効終了年月日(有効終了年月日)
                    .build().modified();
        } else {
            careManeger = new CareManeger(介護支援専門員番号).createBuilderForEdit()
                    .set介護支援専門員名(介護支援専門員名)
                    .set介護支援専門員名カナ(介護支援専門員名カナ)
                    .set所属事業者番号(所属事業者番号)
                    .set有効開始年月日(有効開始年月日)
                    .set有効終了年月日(有効終了年月日)
                    .build();
        }
        CareManegerManager manager = new CareManegerManager();
        return manager.save介護支援専門員(careManeger);
    }
}
