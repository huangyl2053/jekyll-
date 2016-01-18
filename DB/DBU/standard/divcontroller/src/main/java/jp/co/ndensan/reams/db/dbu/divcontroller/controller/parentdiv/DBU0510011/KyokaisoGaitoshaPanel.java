/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoGaito;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoGaitoshaJoho;
import jp.co.ndensan.reams.db.dbu.business.kyokaisogaitosha.KyokaisoHokenryo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha.KyokaisoGaitoshaParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.DBU0510011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.DBU0510011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.KyokaisoGaitoshaPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dgKyokaisouGaitouItran_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011.dghokenryoNofu_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011.KyokaisoGaitoshaPanelHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0510011.KyokaisoGaitoshaPanelValidationHandler;
import jp.co.ndensan.reams.db.dbu.service.kyokaisogaitosha.KyokaisoGaitoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitoshaIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoHokenryoDankaiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinseiIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
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
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 境界層該当者台帳管理Divを制御します。
 */
public class KyokaisoGaitoshaPanel {

    private static final RString 照会 = new RString("照会");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onLoad(KyokaisoGaitoshaPanelDiv div) {

        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("0000000003")));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(new RString("000008")));
        ViewStateHolder.put(ViewStateKeys.状態, new RString("更新"));
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        // TODO 凌護行 共通DIVが実装不正です。共通DIVを提供無し、2016/1/18
        // 宛名基本情報を取得
//        div.getCcdKaigoAtena().load(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
        // 資格系基本情報を取得
//        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        SearchResult<KyokaisoGaitoshaJoho> 境界層該当一覧情報
                = KyokaisoGaitoshaManager.createInstance().getKyokaisoGaitoshaJohoList(被保険者番号);
        if (境界層該当一覧情報.records() == null || 境界層該当一覧情報.records().isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.境界層該当者情報, Models.create(new ArrayList()));
            ViewStateHolder.put(ViewStateKeys.境界層措置申請情報, Models.create(new ArrayList()));
        } else {
            KyokaisoGaito 境界層該当者情報 = KyokaisoGaitoshaManager.createInstance().get境界層該当者情報(被保険者番号);
            ViewStateHolder.put(ViewStateKeys.境界層該当者情報, Models.create(境界層該当者情報.get境界層該当者List()));
            ViewStateHolder.put(ViewStateKeys.境界層措置申請情報, Models.create(境界層該当者情報.get境界層措置申請Lsit()));
        }
        getHandler(div).onLoad(境界層該当一覧情報);
        if (照会.equals(状態)) {
            return ResponseData.of(div).setState(DBU0510011StateName.照会);
        } else {
            return ResponseData.of(div).setState(DBU0510011StateName.更新);
        }
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
        return ResponseData.of(div).setState(DBU0510011StateName.追加);
    }

    /**
     * 選択ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowSelectButton(KyokaisoGaitoshaPanelDiv div) {
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        // TODO 凌護行 DBに項目「リンク番号」が無し、現在「履歴番号」使用です、　QA328回答まち、 2016/1/18
        SearchResult<KyokaisoHokenryo> 境界層保険料段階情報
                = get境界層保険料段階情報(被保険者番号, new Decimal(row.getDefaultDataName27().toString()));
        getHandler(div).onClick_ShowSelectButton(row, 境界層保険料段階情報);
        return ResponseData.of(div).setState(DBU0510011StateName.選択);
    }

    /**
     * 修正ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowModifyButton(KyokaisoGaitoshaPanelDiv div) {
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        // TODO 凌護行 DBに項目「リンク番号」が無し、現在「履歴番号」使用です、　QA328回答まち、 2016/1/18
        SearchResult<KyokaisoHokenryo> 境界層保険料段階情報
                = get境界層保険料段階情報(被保険者番号, new Decimal(row.getDefaultDataName27().toString()));
        getHandler(div).onClick_ShowModifyButton(row, 境界層保険料段階情報);
        return ResponseData.of(div).setState(DBU0510011StateName.追加);
    }

    /**
     * 削除ボタンが押下された場合、境界層該当一覧エリアを閉じて、選択したデータを明細エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowDeleteButton(KyokaisoGaitoshaPanelDiv div) {
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        // TODO 凌護行 DBに項目「リンク番号」が無し、現在「履歴番号」使用です、　QA328回答まち、 2016/1/18
        SearchResult<KyokaisoHokenryo> 境界層保険料段階情報
                = get境界層保険料段階情報(被保険者番号, new Decimal(row.getDefaultDataName27().toString()));
        getHandler(div).onClick_ShowDeleteButton(row, 境界層保険料段階情報);
        return ResponseData.of(div).setState(DBU0510011StateName.追加);
    }

    /**
     * 取消ボタンが押下された場合、明細エリアを閉じて、境界層該当一覧エリアで表示します。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_ShowCancel(KyokaisoGaitoshaPanelDiv div) {

        if (状態_追加.equals(div.getKyokaisouGaitouItiran().getIranState())) {
            getHandler(div).onClick_ShowCancel();
            return ResponseData.of(div).setState(DBU0510011StateName.追加);
        } else {
            return ResponseData.of(div).setState(DBU0510011StateName.更新);
        }
    }

    /**
     * 保険料納付を追加するボタンが押下された場合、保険料納付入力エリアの項目が活性になる。
     *
     * @param div 画面情報
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnTuikaSuru(KyokaisoGaitoshaPanelDiv div) {
        div.getHokenryoNofuGengaku().setState(状態_追加);
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
        div.getHokenryoNofuGengaku().setState(状態_修正);
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
        div.getHokenryoNofuGengaku().setState(状態_削除);
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

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        Decimal 最新履歴番号 = KyokaisoGaitoshaManager.createInstance().get最新履歴番号(parameter);
        Models<KyokaisoGaitoshaIdentifier, KyokaisoGaitosha> gaitoshaModels
                = ViewStateHolder.get(ViewStateKeys.境界層該当者情報, Models.class);
        Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> sochiShinseiModels
                = ViewStateHolder.get(ViewStateKeys.境界層措置申請情報, Models.class);
        Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> dankaiModels
                = ViewStateHolder.get(ViewStateKeys.境界層保険料段階情報, Models.class);
        // TODO 凌護行 DBに項目「リンク番号」が無し、現在「履歴番号」使用です、　QA328回答まち、 2016/1/18
//        Decimal 最新リンク番号 = KyokaisoGaitoshaManager.createInstance().get最新リンク番号(parameter);
        if (状態_追加.equals(div.getKyokaisouGaitouItiran().getIranState())) {
            KyokaisoGaitosha kyokaisoGaitosha = new KyokaisoGaitosha(被保険者番号, 最新履歴番号);
            KyokaisoSochiShinsei kyokaisoSochiShinsei = new KyokaisoSochiShinsei(被保険者番号, 最新履歴番号);
            kyokaisoGaitosha = getHandler(div).editKyokaisoGaitosha(kyokaisoGaitosha);
            kyokaisoSochiShinsei = getHandler(div).editKyokaisoSochiShinsei(kyokaisoSochiShinsei);
            gaitoshaModels.add(kyokaisoGaitosha);
            sochiShinseiModels.add(kyokaisoSochiShinsei);
        } else if (状態_修正.equals(div.getKyokaisouGaitouItiran().getIranState())) {
            KyokaisoGaitoshaIdentifier key = new KyokaisoGaitoshaIdentifier(
                    被保険者番号,
                    new Decimal(row.getDefaultDataName27().toString()));
            KyokaisoGaitosha kyokaisoGaitosha = getHandler(div).editKyokaisoGaitosha(gaitoshaModels.get(key).modifiedModel());
            KyokaisoSochiShinseiIdentifier shinseiKey = new KyokaisoSochiShinseiIdentifier(
                    被保険者番号,
                    new Decimal(row.getDefaultDataName27().toString()));
            KyokaisoSochiShinsei kyokaisoSochiShinsei = getHandler(div).editKyokaisoSochiShinsei(sochiShinseiModels.get(shinseiKey).modifiedModel());
            gaitoshaModels.deleteOrRemove(key);
            gaitoshaModels.add(kyokaisoGaitosha);
            sochiShinseiModels.deleteOrRemove(shinseiKey);
            sochiShinseiModels.add(kyokaisoSochiShinsei);
        } else if (状態_削除.equals(div.getKyokaisouGaitouItiran().getIranState())) {
            List<KyokaisoGaitosha> 境界層該当者List = new ArrayList<>();
            List<KyokaisoSochiShinsei> 境界層措置申請Lsit = new ArrayList<>();
            KyokaisoGaitoshaIdentifier key = new KyokaisoGaitoshaIdentifier(
                    被保険者番号,
                    new Decimal(row.getDefaultDataName27().toString()));
            KyokaisoGaitosha kyokaisoGaitosha = getHandler(div).editKyokaisoGaitosha(gaitoshaModels.get(key).modifiedModel());
            KyokaisoSochiShinseiIdentifier shinseiKey = new KyokaisoSochiShinseiIdentifier(
                    被保険者番号,
                    new Decimal(row.getDefaultDataName27().toString()));
            KyokaisoSochiShinsei kyokaisoSochiShinsei = getHandler(div).editKyokaisoSochiShinsei(sochiShinseiModels.get(shinseiKey).modifiedModel());
            境界層該当者List.add(kyokaisoGaitosha.deleted());
            境界層措置申請Lsit.add(kyokaisoSochiShinsei.deleted());
            ViewStateHolder.put(ViewStateKeys.境界層該当者情報, Models.create(境界層該当者List));
            ViewStateHolder.put(ViewStateKeys.境界層措置申請情報, Models.create(境界層措置申請Lsit));

            if (div.getDghokenryoNofu().getDataSource() != null && !div.getDghokenryoNofu().getDataSource().isEmpty()) {
                List<KyokaisoHokenryoDankai> 境界層保険料段階List = new ArrayList<>();
                for (dghokenryoNofu_Row noFu_row : div.getDghokenryoNofu().getDataSource()) {
                    RDate 修正前の適用開始年月 = new RDate(noFu_row.getDefaultDataName1().toString());
                    KyokaisoHokenryoDankaiIdentifier dankaiKey = new KyokaisoHokenryoDankaiIdentifier(
                            被保険者番号,
                            new Decimal(noFu_row.getDefaultDataName4().toString()),
                            new FlexibleYearMonth(修正前の適用開始年月.getYearMonth().toDateString()));

                    KyokaisoHokenryoDankai hokenryoDan = getHandler(div).delHokenryoDankai(
                            dankaiModels.get(dankaiKey).modifiedModel());
                    dankaiModels.add(hokenryoDan.deleted());
                    境界層保険料段階List.add(hokenryoDan.deleted());
                    ViewStateHolder.put(ViewStateKeys.境界層保険料段階情報, Models.create(境界層保険料段階List));
                }
            }
        }

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
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            KyokaisoGaito kyokaisoGaito = new KyokaisoGaito();
            List<KyokaisoGaitosha> kyokaisoGaitoshaList = new ArrayList<>();
            List<KyokaisoSochiShinsei> kyokaisoSochiShinseiList = new ArrayList<>();
            List<KyokaisoHokenryoDankai> hokenryoDankaiList = new ArrayList<>();
            Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> 境界層保険料段階情報
                    = ViewStateHolder.get(ViewStateKeys.境界層保険料段階情報, Models.class);

            for (KyokaisoGaitosha gaitosha : gaitoshaModels) {
                kyokaisoGaitoshaList.add(gaitosha);
            }
            for (KyokaisoSochiShinsei shinsei : sochiShinseiModels) {
                kyokaisoSochiShinseiList.add(shinsei);
            }
            for (KyokaisoHokenryoDankai dankai : 境界層保険料段階情報) {
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
                manager.delKyokaisoGaitoshaJoho(kyokaisoGaito, 被保険者番号, 最新履歴番号, 最新履歴番号);
            }
            SearchResult<KyokaisoGaitoshaJoho> 境界層該当一覧情報
                    = KyokaisoGaitoshaManager.createInstance().getKyokaisoGaitoshaJohoList(被保険者番号);
            getHandler(div).onClick_ShowUpdate(境界層該当一覧情報);
            return ResponseData.of(div).setState(DBU0510011StateName.保存);
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

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString イベント状態 = div.getKyokaisouGaitouItiran().getIranState();
        dgKyokaisouGaitouItran_Row row = div.getDgKyokaisouGaitouItran().getActiveRow();
        dghokenryoNofu_Row nofu_Row = div.getDghokenryoNofu().getActiveRow();
        KyokaisoGaitoshaParameter parameter = KyokaisoGaitoshaParameter.createParamFor被保険者番号(被保険者番号);
        Decimal 最新リンク番号 = KyokaisoGaitoshaManager.createInstance().get最新リンク番号(parameter);
        Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> models
                = ViewStateHolder.get(ViewStateKeys.境界層保険料段階情報, Models.class);
        RString 状態 = div.getHokenryoNofuGengaku().getState();
        if (状態.isEmpty() || 状態_追加.equals(状態)) {
            if (状態_修正.equals(イベント状態)) {
                最新リンク番号 = new Decimal(row.getDefaultDataName27().toString());
            }
            KyokaisoHokenryoDankai hokenryoDankai = new KyokaisoHokenryoDankai(
                    被保険者番号,
                    最新リンク番号,
                    new FlexibleYearMonth(div.getTxtHohenryoNofuFromDate().getValue().seireki().getYearMonth().replace(new RString("."), RString.EMPTY)));
            hokenryoDankai = getHandler(div).editHokenryoDankai(hokenryoDankai, 最新リンク番号);
            models.add(hokenryoDankai);
        } else if (状態_修正.equals(状態)) {
            if (状態_修正.equals(イベント状態)) {
                最新リンク番号 = new Decimal(row.getDefaultDataName27().toString());
            }
            if (!状態_追加.equals(nofu_Row.getDefaultDataName0())) {
                最新リンク番号 = new Decimal(nofu_Row.getDefaultDataName4().toString());

            }
            RDate 修正前の適用開始年月 = new RDate(nofu_Row.getDefaultDataName1().toString());
            KyokaisoHokenryoDankaiIdentifier key = new KyokaisoHokenryoDankaiIdentifier(
                    被保険者番号,
                    最新リンク番号,
                    new FlexibleYearMonth(修正前の適用開始年月.getYearMonth().toDateString()));
            KyokaisoHokenryoDankai hokenryoDan = getHandler(div).editHokenryoDankai(
                    models.get(key).modifiedModel(),
                    new Decimal(row.getDefaultDataName27().toString()));
            models.deleteOrRemove(key);
            models.add(hokenryoDan);
        } else if (状態_削除.equals(状態)) {
            if (状態_修正.equals(イベント状態)) {
                最新リンク番号 = new Decimal(row.getDefaultDataName27().toString());
            }
            if (nofu_Row.getDefaultDataName0().isEmpty()) {
                最新リンク番号 = new Decimal(nofu_Row.getDefaultDataName4().toString());

            }
            RDate 修正前の適用開始年月 = new RDate(nofu_Row.getDefaultDataName1().toString());
            KyokaisoHokenryoDankaiIdentifier key = new KyokaisoHokenryoDankaiIdentifier(
                    被保険者番号,
                    最新リンク番号,
                    new FlexibleYearMonth(修正前の適用開始年月.getYearMonth().toDateString()));
            KyokaisoHokenryoDankai hokenryoDan = getHandler(div).editHokenryoDankai(
                    models.get(key).modifiedModel(),
                    new Decimal(row.getDefaultDataName27().toString()));
            models.deleteOrRemove(key);
            if (nofu_Row.getDefaultDataName0().isEmpty()) {
                models.add(hokenryoDan.deleted());
            }
        }
        ViewStateHolder.put(ViewStateKeys.境界層保険料段階情報, Models.create(models));
        getHandler(div).onClick_btnKakutei(イベント状態);
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタン押下、検索画面へ遷移します。
     *
     * @param div SinsaSeikyusyoMeisaiPanelDiv
     * @return ResponseData<KyokaisoGaitoshaPanelDiv>
     */
    public ResponseData<KyokaisoGaitoshaPanelDiv> onClick_btnBack(KyokaisoGaitoshaPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0510011TransitionEventName.対象者検索に戻る).respond();
    }

    private SearchResult<KyokaisoHokenryo> get境界層保険料段階情報(
            HihokenshaNo 被保険者番号,
            Decimal リンク番号) {
        SearchResult<KyokaisoHokenryo> 境界層保険料段階情報
                = KyokaisoGaitoshaManager.createInstance().getKyokaisoHokenryoDakaiJohoList(被保険者番号, リンク番号);
        if (境界層保険料段階情報.records() == null || 境界層保険料段階情報.records().isEmpty()) {
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
}
