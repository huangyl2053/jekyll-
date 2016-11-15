/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kyokaisogaitosha.KyokaisoGaito;
import jp.co.ndensan.reams.db.dbu.business.core.kyokaisogaitosha.KyokaisoGaitoshaJoho;
import jp.co.ndensan.reams.db.dbu.business.core.kyokaisogaitosha.KyokaisoHokenryo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.DBU0510011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.DBU0510011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.KyokaisoGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dgKyokaisouGaitouItran_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dghokenryoNofu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011.KyokaisoGaitoshaPanelHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011.KyokaisoGaitoshaPanelValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.core.kyokaisogaitosha.KyokaisoGaitoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankaiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinseiIdentifier;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 境界層該当者台帳管理Divを制御します。
 *
 * @reamsid_L DBU-0430-010 linghuhang
 */
public class KyokaisoGaitoshaPanel {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 保存 = new RString("保存");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onLoad(KyokaisoGaitoshaPanelDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        ShikibetsuCode 識別コード = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        div.getCcdKaigoAtena().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        List<KyokaisoGaitoshaJoho> 境界層該当一覧情報
                = KyokaisoGaitoshaManager.createInstance().getKyokaisoGaitoshaJohoList(被保険者番号).records();
        if (境界層該当一覧情報 == null || 境界層該当一覧情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.境界層該当者情報, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.境界層措置申請情報, Models.create(new ArrayList()));
            境界層該当一覧情報 = new ArrayList<>();
        } else {
            KyokaisoGaito 境界層該当者情報 = KyokaisoGaitoshaManager.createInstance().get境界層該当者情報(被保険者番号);
            ViewStateHolder.put(ViewStateKeys.境界層該当者情報, Models.create(境界層該当者情報.get境界層該当者List()));
            ViewStateHolder.put(ViewStateKeys.境界層措置申請情報, Models.create(境界層該当者情報.get境界層措置申請Lsit()));
        }
        getHandler(div).onLoad(境界層該当一覧情報);
        return ResponseData.of(div).setState(DBU0510011StateName.Kousin);
    }

    /**
     * 追加ボタンが押下された場合、境界層該当一覧エリアを閉じて、明細エリアを空白で表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnTuika(KyokaisoGaitoshaPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.境界層保険料段階情報, Models.create(new ArrayList()));
        getHandler(div).onClick_btnTuika();
        return ResponseData.of(div).setState(DBU0510011StateName.Insert);
    }

    /**
     * 選択ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowSelectButton(KyokaisoGaitoshaPanelDiv div) {
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        List<KyokaisoHokenryo> 境界層保険料段階情報
                = get境界層保険料段階情報(被保険者番号, new Decimal(row.getLinkNo().toString()));
        getHandler(div).onClick_ShowSelectButton(row, 境界層保険料段階情報);
        return ResponseData.of(div).setState(DBU0510011StateName.Sentaku);
    }

    /**
     * 修正ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowModifyButton(KyokaisoGaitoshaPanelDiv div) {
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        List<KyokaisoHokenryo> 境界層保険料段階情報
                = get境界層保険料段階情報(被保険者番号, new Decimal(row.getLinkNo().toString()));
        getHandler(div).onClick_ShowModifyButton(row, 境界層保険料段階情報);
        return ResponseData.of(div).setState(DBU0510011StateName.Insert);
    }

    /**
     * 削除ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowDeleteButton(KyokaisoGaitoshaPanelDiv div) {
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        List<KyokaisoHokenryo> 境界層保険料段階情報
                = get境界層保険料段階情報(被保険者番号, new Decimal(row.getLinkNo().toString()));
        getHandler(div).onClick_ShowDeleteButton(row, 境界層保険料段階情報);
        return ResponseData.of(div).setState(DBU0510011StateName.Insert);
    }

    /**
     * 取消ボタンが押下された場合、明細エリアを閉じて、境界層該当一覧エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowCancel(KyokaisoGaitoshaPanelDiv div) {

        getHandler(div).onClick_ShowCancel();
        return ResponseData.of(div).setState(DBU0510011StateName.Yameru);
    }

    /**
     * 該当・非該当を押下された場合、標準負担額の項目が活性・不活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_radHyojunFutanGaku(KyokaisoGaitoshaPanelDiv div) {
        getHandler(div).onClick_radHyojunFutanGaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 該当・非該当を押下された場合、居住費等負担額減額の項目が活性・不活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_radkyojuhiFutanGakuGengaku(KyokaisoGaitoshaPanelDiv div) {
        getHandler(div).onClick_radkyojuhiFutanGakuGengaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 該当・非該当を押下された場合、食費負担額減額の項目が活性・不活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_radShokuhiFutangakuGengaku(KyokaisoGaitoshaPanelDiv div) {
        getHandler(div).onClick_radShokuhiFutangakuGengaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 該当・非該当を押下された場合、高額サービス費上限額減額の項目が活性・不活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_radGogakuServiceJoken(KyokaisoGaitoshaPanelDiv div) {
        getHandler(div).onClick_radGogakuServiceJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 適用する・適用しないを押下された場合、項目が活性・不活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_radHokenryoNofuGengaku(KyokaisoGaitoshaPanelDiv div) {
        getHandler(div).onClick_radHokenryoNofuGengaku();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険料納付を追加するボタンが押下された場合、保険料納付入力エリアの項目が活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnTuikaSuru(KyokaisoGaitoshaPanelDiv div) {
        div.getHokenryoNofuGengaku().setTekiyoState(状態_追加);
        getHandler(div).onClick_btnTuikaSuru();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険料納付を修正ボタンが押下された場合、保険料納付を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ModifyButton(KyokaisoGaitoshaPanelDiv div) {
        dghokenryoNofu_Row nofu_Row = div.getDghokenryoNofu().getActiveRow();
        div.getHokenryoNofuGengaku().setTekiyoState(状態_修正);
        getHandler(div).onClick_ModifyButton(nofu_Row);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険料納付を削除ボタンが押下された場合、保険料納付を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_DeleteButton(KyokaisoGaitoshaPanelDiv div) {
        dghokenryoNofu_Row nofu_Row = div.getDghokenryoNofu().getActiveRow();
        div.getHokenryoNofuGengaku().setTekiyoState(状態_削除);
        getHandler(div).onClick_DeleteButton(nofu_Row);
        return ResponseData.of(div).respond();
    }

    /**
     * 取消するボタンが押下された場合、保険料納付入力エリアの項目が活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnCancel(KyokaisoGaitoshaPanelDiv div) {
        getHandler(div).onClick_btnCancel();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタンが押下された場合、保存後最新のデータを一覧に表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowUpdate(KyokaisoGaitoshaPanelDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForUpdate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            HihokenshaNo 被保険者番号 = ViewStateHolder.get(
                    jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
            dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getSelectedItems().size() > 0 ? 
                    div.getDgKyokaisouGaitouItran().getSelectedItems().get(0) : null;
            KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
            int 最新履歴番号 = KyokaisoGaitoshaManager.createInstance().get最新履歴番号(parameter).intValue();
            int 最新リンク番号 = KyokaisoGaitoshaManager.createInstance().get最新リンク番号(parameter).intValue();
            Models<KyokaisoGaitoshaIdentifier, KyokaisoGaitosha> gaitoshaModels
                    = ViewStateHolder.get(ViewStateKeys.境界層該当者情報, Models.class);
            Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> sochiShinseiModels
                    = ViewStateHolder.get(ViewStateKeys.境界層措置申請情報, Models.class);
            Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> dankaiModels
                    = ViewStateHolder.get(ViewStateKeys.境界層保険料段階情報, Models.class);

            if (状態_追加.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                KyokaisoGaitosha kyokaisoGaitosha = new KyokaisoGaitosha(被保険者番号, 最新履歴番号, 最新リンク番号);
                KyokaisoSochiShinsei kyokaisoSochiShinsei = new KyokaisoSochiShinsei(被保険者番号, 最新履歴番号, 最新リンク番号);
                kyokaisoGaitosha = getHandler(div).editKyokaisoGaitosha(kyokaisoGaitosha);
                kyokaisoSochiShinsei = getHandler(div).editKyokaisoSochiShinsei(kyokaisoSochiShinsei);
                gaitoshaModels.add(kyokaisoGaitosha);
                sochiShinseiModels.add(kyokaisoSochiShinsei);
            } else if (状態_修正.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                KyokaisoGaitoshaIdentifier 元の境界層該当者 = new KyokaisoGaitoshaIdentifier(
                        被保険者番号,
                        Integer.parseInt(row.getRirekiNo().toString()),
                        Integer.parseInt(row.getLinkNo().toString()));
                KyokaisoSochiShinseiIdentifier 元の境界層措置申請 = new KyokaisoSochiShinseiIdentifier(
                        被保険者番号,
                        Integer.parseInt(row.getRirekiNo().toString()),
                        Integer.parseInt(row.getLinkNo().toString()));

                KyokaisoGaitosha key = new KyokaisoGaitosha(
                        被保険者番号,
                        最新履歴番号,
                        Integer.parseInt(row.getLinkNo().toString()));
                KyokaisoGaitosha kyokaisoGaitosha = getHandler(div).editKyokaisoGaitosha(key);

                KyokaisoSochiShinsei shinseiKey = new KyokaisoSochiShinsei(
                        被保険者番号,
                        最新履歴番号,
                        Integer.parseInt(row.getLinkNo().toString()));
                KyokaisoSochiShinsei kyokaisoSochiShinsei = getHandler(div).editKyokaisoSochiShinsei(shinseiKey);
                gaitoshaModels.add(gaitoshaModels.get(元の境界層該当者).createBuilderForEdit().is論理削除フラグ(true).build());
                gaitoshaModels.add(kyokaisoGaitosha);
                sochiShinseiModels.add(sochiShinseiModels.get(元の境界層措置申請).createBuilderForEdit().is論理削除フラグ(true).build());
                sochiShinseiModels.add(kyokaisoSochiShinsei);
            } else if (状態_削除.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                KyokaisoGaitoshaIdentifier key = new KyokaisoGaitoshaIdentifier(
                        被保険者番号,
                        Integer.parseInt(row.getRirekiNo().toString()),
                        Integer.parseInt(row.getLinkNo().toString()));
                KyokaisoSochiShinseiIdentifier shinseiKey = new KyokaisoSochiShinseiIdentifier(
                        被保険者番号,
                        Integer.parseInt(row.getRirekiNo().toString()),
                        Integer.parseInt(row.getLinkNo().toString()));
                gaitoshaModels.add(gaitoshaModels.get(key).createBuilderForEdit().is論理削除フラグ(true).build());
                sochiShinseiModels.add(sochiShinseiModels.get(shinseiKey).createBuilderForEdit().is論理削除フラグ(true).build());
                境界層保険料段階情報削除の処理(div, 被保険者番号, dankaiModels);
            }
            KyokaisoGaito kyokaisoGaito = new KyokaisoGaito();
            List<KyokaisoGaitosha> kyokaisoGaitoshaList = new ArrayList<>();
            List<KyokaisoSochiShinsei> kyokaisoSochiShinseiList = new ArrayList<>();
            List<KyokaisoHokenryoDankai> hokenryoDankaiList = new ArrayList<>();

            for (KyokaisoGaitosha gaitosha : gaitoshaModels) {
                kyokaisoGaitoshaList.add(gaitosha);
            }
            for (KyokaisoSochiShinsei shinsei : sochiShinseiModels) {
                kyokaisoSochiShinseiList.add(shinsei);
            }
            for (KyokaisoHokenryoDankai dankai : dankaiModels) {
                hokenryoDankaiList.add(dankai);
            }
            kyokaisoGaito.set境界層該当者List(kyokaisoGaitoshaList);
            kyokaisoGaito.set境界層措置申請Lsit(kyokaisoSochiShinseiList);
            kyokaisoGaito.set境界層保険料段階List(hokenryoDankaiList);
            KyokaisoGaitoshaManager manager = KyokaisoGaitoshaManager.createInstance();
            if (状態_追加.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                manager.regKyokaisoGaitoshaJoho(kyokaisoGaito, 被保険者番号);
            } else if (状態_修正.equals(div.getKyokaisouGaitouItiran().getIranState())) {
                manager.updKyokaisoGaitoshaJoho(kyokaisoGaito, 被保険者番号);
            } else {
                manager.delKyokaisoGaitoshaJoho(kyokaisoGaito, 被保険者番号, new Decimal(最新履歴番号), new Decimal(最新履歴番号));
            }
            div.getCcdKanryoMessage().setSuccessMessage(new RString(
                    UrInformationMessages.正常終了.getMessage().replace(保存.toString()).evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBU0510011StateName.AfterSave);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 確認ボタンが押下された場合、保険料納付減額Grid一覧を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnKakutei(KyokaisoGaitoshaPanelDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakuninn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(
                jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        RString イベント状態 = div.getKyokaisouGaitouItiran().getIranState();
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        dghokenryoNofu_Row nofu_Row = div.getDghokenryoNofu().getActiveRow();
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        int 最新リンク番号 = KyokaisoGaitoshaManager.createInstance().get最新リンク番号(parameter).intValue();
        int 最新履歴番号 = KyokaisoGaitoshaManager.createInstance().get最新履歴番号(parameter).intValue();
        Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> models
                = ViewStateHolder.get(ViewStateKeys.境界層保険料段階情報, Models.class);
        RString 状態 = div.getHokenryoNofuGengaku().getTekiyoState();
        if (状態.isEmpty() || 状態_追加.equals(状態)) {
            if (状態_修正.equals(イベント状態)) {
                最新リンク番号 = Integer.parseInt(row.getLinkNo().toString());
            }
            KyokaisoHokenryoDankai hokenryoDankai = new KyokaisoHokenryoDankai(
                    被保険者番号,
                    最新履歴番号,
                    最新リンク番号,
                    new FlexibleYearMonth(div.getTxtHohenryoNofuFromDate().getValue().seireki().getYearMonth().replace(new RString("."), RString.EMPTY)));
            hokenryoDankai = getHandler(div).editHokenryoDankai(hokenryoDankai);
            models.add(hokenryoDankai);
        } else if (状態_修正.equals(状態)) {
            if (状態_修正.equals(イベント状態)) {
                最新リンク番号 = Integer.parseInt(row.getLinkNo().toString());
                最新履歴番号 = Integer.parseInt(nofu_Row.getTekiyoRirekiNo().toString());
            }
            if (状態_削除.equals(nofu_Row.getState()) || !状態_追加.equals(nofu_Row.getState())) {
                最新リンク番号 = Integer.parseInt(nofu_Row.getTekiyoLinkNo().toString());
                最新履歴番号 = Integer.parseInt(nofu_Row.getTekiyoRirekiNo().toString());
            }
            int 修正前の履歴番号 = Integer.parseInt(nofu_Row.getTekiyoRirekiNo().toString());
            int 修正前のリンク番号 = Integer.parseInt(nofu_Row.getTekiyoLinkNo().toString());
            RDate 修正前の適用開始年月 = new RDate(nofu_Row.getHiddenTekiyoKaishiDate().toString());
            RDate 修正後の適用開始年月 = new RDate(div.getTxtHohenryoNofuFromDate().getValue().getYearMonth().toString());
            KyokaisoHokenryoDankaiIdentifier 修正前Key = new KyokaisoHokenryoDankaiIdentifier(
                    被保険者番号,
                    修正前の履歴番号,
                    修正前のリンク番号,
                    new FlexibleYearMonth(修正前の適用開始年月.getYearMonth().toDateString()));
            KyokaisoHokenryoDankai hokenryoDan = new KyokaisoHokenryoDankai(
                    被保険者番号,
                    (修正前の履歴番号 + 1),
                    修正前のリンク番号,
                    new FlexibleYearMonth(修正後の適用開始年月.getYearMonth().toDateString()));
            if (状態_追加.equals(nofu_Row.getState())) {
                hokenryoDan = getHandler(div).editHokenryoDankai(models.get(修正前Key));
            }
            if (状態_削除.equals(nofu_Row.getState()) || !状態_追加.equals(nofu_Row.getState())) {
                models.add(models.get(修正前Key).createBuilderForEdit().is論理削除フラグ(true).build());
                hokenryoDan = getHandler(div).editHokenryoDankai(hokenryoDan);
            }
            models.add(hokenryoDan);
        } else if (状態_削除.equals(状態)) {
            if (状態_修正.equals(イベント状態)) {
                最新リンク番号 = Integer.parseInt(row.getLinkNo().toString());
                最新履歴番号 = Integer.parseInt(nofu_Row.getTekiyoRirekiNo().toString());
            }
            if (nofu_Row.getState().isEmpty()) {
                最新リンク番号 = Integer.parseInt(nofu_Row.getTekiyoLinkNo().toString());
                最新履歴番号 = Integer.parseInt(nofu_Row.getTekiyoRirekiNo().toString());
            }
            RDate 修正前の適用開始年月 = new RDate(nofu_Row.getHiddenTekiyoKaishiDate().toString());
            KyokaisoHokenryoDankaiIdentifier key = new KyokaisoHokenryoDankaiIdentifier(
                    被保険者番号,
                    最新履歴番号,
                    最新リンク番号,
                    new FlexibleYearMonth(修正前の適用開始年月.getYearMonth().toDateString()));
            if (!状態_追加.equals(nofu_Row.getState())) {
                models.add(models.get(key).createBuilderForEdit().is論理削除フラグ(true).build());
            } else {
                models.deleteOrRemove(key);
            }
        }
        ViewStateHolder.put(ViewStateKeys.境界層保険料段階情報, Models.create(models));
        getHandler(div).onClick_btnKakutei(イベント状態, 最新リンク番号, 最新履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタン押下、検索画面へ遷移します。
     *
     * @param div SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnBack(KyokaisoGaitoshaPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0510011TransitionEventName.research).respond();
    }

    private List<KyokaisoHokenryo> get境界層保険料段階情報(
            HihokenshaNo 被保険者番号,
            Decimal リンク番号) {
        List<KyokaisoHokenryo> 境界層保険料段階情報
                = KyokaisoGaitoshaManager.createInstance().getKyokaisoHokenryoDakaiJohoList(被保険者番号, リンク番号).records();
        if (境界層保険料段階情報 == null || 境界層保険料段階情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.境界層保険料段階情報, Models.create(new ArrayList()));
        } else {
            KyokaisoGaito 境界層該当者情報 = KyokaisoGaitoshaManager.createInstance().get境界層保険料段階情報(被保険者番号, リンク番号);
            ViewStateHolder.put(ViewStateKeys.境界層保険料段階情報, Models.create(境界層該当者情報.get境界層保険料段階List()));
        }
        return 境界層保険料段階情報;
    }

    private KyokaisoGaitoshaPanelHandler getHandler(KyokaisoGaitoshaPanelDiv div) {
        return new KyokaisoGaitoshaPanelHandler(div);
    }

    private KyokaisoGaitoshaPanelValidationHandler getValidationHandler(KyokaisoGaitoshaPanelDiv div) {
        return new KyokaisoGaitoshaPanelValidationHandler(div);
    }

    private void 境界層保険料段階情報削除の処理(
            KyokaisoGaitoshaPanelDiv div,
            HihokenshaNo 被保険者番号,
            Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> dankaiModels) {
        if (div.getDghokenryoNofu().getDataSource() != null && !div.getDghokenryoNofu().getDataSource().isEmpty()) {
            for (dghokenryoNofu_Row noFu_row : div.getDghokenryoNofu().getDataSource()) {
                RDate 修正前の適用開始年月 = new RDate(noFu_row.getHiddenTekiyoKaishiDate().toString());
                KyokaisoHokenryoDankaiIdentifier dankaiKey = new KyokaisoHokenryoDankaiIdentifier(
                        被保険者番号,
                        Integer.parseInt(noFu_row.getTekiyoRirekiNo().toString()),
                        Integer.parseInt(noFu_row.getTekiyoLinkNo().toString()),
                        new FlexibleYearMonth(修正前の適用開始年月.getYearMonth().toDateString()));

                dankaiModels.add(dankaiModels.get(dankaiKey).createBuilderForEdit().is論理削除フラグ(true).build());
            }
        }
    }
}
