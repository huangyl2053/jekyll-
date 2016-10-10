/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD9010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.IryoHiKojoNaiyo;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001.DBD9010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001.IryohiKojyoItiranDataGrid_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010001.IryouhiKoujyoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010001.IryouhiKoujyoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010001.IryouhiKoujyoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 医療費控除登録画面のDivControllerです。
 *
 * @reamsid_L DBD-5770-010 tz_chengpeng
 */
public class IryouhiKoujyo {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 医療費控除登録 = new RString("IryohiKojyoToroku");
    private static final RString DB = new RString("DB");
    private static final RString 完了メッセージメイン = new RString("医療費控除の登録を完了しました。");

    /**
     * 画面初期化
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onLoad(IryouhiKoujyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            if (引き継ぎEntity.get被保険者番号() == null || 引き継ぎEntity.get被保険者番号().isEmpty()) {
                return ResponseData.of(div).addMessage(DbdInformationMessages.被保険者でないデータ.getMessage()).respond();
            }
            List<IryohiKojoEntityResult> 医療費控除リスト = getHandler(div).onLoad(引き継ぎEntity);
            ViewStateHolder.put(ViewStateKeys.医療費控除情報, new ArrayList(医療費控除リスト));
            return ResponseData.of(div).setState(DBD9010001StateName.初期表示);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 区分onChangeイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onChange_KubunRadioButton(IryouhiKoujyoDiv div) {
        RString 区分 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey();
        if (IryoHiKojoNaiyo.おむつ使用証明書.getコード().equals(区分)) {
            div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setValue(RDate.getNowDate());
            return ResponseData.of(div).setState(DBD9010001StateName.おむつ使用証明書);
        } else if (IryoHiKojoNaiyo.主治医意見書確認書.getコード().equals(区分)) {
            div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setValue(RDate.getNowDate());
            return ResponseData.of(div).setState(DBD9010001StateName.主治医意見書確認書);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」ボタンクリックイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_ModifyButton(IryouhiKoujyoDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 修正);
        RString 区分 = div.getIryohiKojyoItiranDataGrid().getActiveRow().getHiddenCodeKubun();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().setReadOnly(true);
        if (IryoHiKojoNaiyo.おむつ使用証明書.getコード().equals(区分)) {
            getHandler(div).set詳細データパネル1();
            return ResponseData.of(div).setState(DBD9010001StateName.おむつ使用証明書);
        } else if (IryoHiKojoNaiyo.主治医意見書確認書.getコード().equals(区分)) {
            getHandler(div).set詳細データ();
            return ResponseData.of(div).setState(DBD9010001StateName.主治医意見書確認書);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタンクリックイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_DeleteButton(IryouhiKoujyoDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 削除);
        RString 区分 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey();
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getSinseYYMMDD().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNitijyoSekatuJiritudo().setReadOnly(true);
        div.getIryohiKojyoSyosai().getSyosaiPanel2().getNyosikin().setReadOnly(true);
        if (IryoHiKojoNaiyo.おむつ使用証明書.getコード().equals(区分)) {
            getHandler(div).set詳細データパネル1();
            return ResponseData.of(div).setState(DBD9010001StateName.おむつ使用証明書);
        } else if (IryoHiKojoNaiyo.主治医意見書確認書.getコード().equals(区分)) {
            getHandler(div).set詳細データ();
            return ResponseData.of(div).setState(DBD9010001StateName.主治医意見書確認書);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加する」ボタンクリックイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_AddButton(IryouhiKoujyoDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 追加);
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().setSelectedKey(IryoHiKojoNaiyo.主治医意見書確認書.getコード());
        div.getIryohiKojyoSyosai().getSyosaiPanel1().getTorokuYYMMDD().setValue(RDate.getNowDate());
        return ResponseData.of(div).setState(DBD9010001StateName.主治医意見書確認書);
    }

    /**
     * 対象年フォーカスアウトイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onBlur_TaisyoYY(IryouhiKoujyoDiv div) {
        if (div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().getValue() == null) {
            return ResponseData.of(div).respond();
        }
        TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        RString 被保険者番号 = 引き継ぎEntity.get被保険者番号().value();
        RString 対象年 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().getValue().toDateString();
        IryoHiKojoKakuninSinsei iryoHiKojoKakuninSinsei = IryoHiKojoKakuninSinsei.createIntance();
        FlexibleDate 治医意見書受領年月日 = iryoHiKojoKakuninSinsei.getJukyusha(被保険者番号, 対象年).get主治医意見書受領年月日();
        FlexibleDate 認定有効期間終了年月日 = iryoHiKojoKakuninSinsei.getJukyusha(被保険者番号, 対象年).get認定有効期間終了年月日();
        FlexibleDate 認定有効期間開始年月日 = iryoHiKojoKakuninSinsei.getJukyusha(被保険者番号, 対象年).get認定有効期間開始年月日();
        if (!ResponseHolder.isReRequest() && 治医意見書受領年月日 == null && 認定有効期間終了年月日 == null && 認定有効期間開始年月日 == null) {
            return ResponseData.of(div).addMessage(DbdWarningMessages.受給者なし確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            getHandler(div).init詳細データ();
            div.getIryohiKojyoSyosai().setIsOpen(false);
            return ResponseData.of(div).respond();
        }
        RString データ区分 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey();
        if (IryoHiKojoNaiyo.主治医意見書確認書.getコード().equals(データ区分)) {
            if (div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD().getValue() == null) {
                div.getIryohiKojyoSyosai().getSyosaiPanel2().getSakuseYYMMDD()
                        .setValue(治医意見書受領年月日 != null && !治医意見書受領年月日.isEmpty() ? new RDate(治医意見書受領年月日.toString()) : null);
            }
            if (div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD().getValue() == null) {
                div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteEndYYMMDD()
                        .setValue(認定有効期間終了年月日 != null && !認定有効期間終了年月日.isEmpty() ? new RDate(認定有効期間終了年月日.toString()) : null);
            }
            if (div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD().getValue() == null) {
                div.getIryohiKojyoSyosai().getSyosaiPanel2().getNinteFromYYMMDD()
                        .setValue(認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty() ? new RDate(認定有効期間開始年月日.toString()) : null);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消する」ボタンクリックイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_CancleButton(IryouhiKoujyoDiv div) {
        getHandler(div).init詳細エリア();
        div.getIryohiKojyoSyosai().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「クリアする」ボタンクリックイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_ClearButton(IryouhiKoujyoDiv div) {
        List<IryohiKojoEntityResult> 医療費控除リスト = ViewStateHolder.get(ViewStateKeys.医療費控除情報, ArrayList.class);
        getHandler(div).onClick_ClearButton(医療費控除リスト);
        return ResponseData.of(div).setState(DBD9010001StateName.初期表示);
    }

    /**
     * 「確定する」ボタンクリックイベント。
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_KakuteButton(IryouhiKoujyoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor申請年月日と対象年の未入力チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (!div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getReadOnly()) {
            List<IryohiKojyoItiranDataGrid_Row> dataSource = div.getIryohiKojyoItiran().getIryohiKojyoItiranDataGrid().getDataSource();
            RDate 対象年 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getTaisyoYY().getValue();
            RString データ区分 = div.getIryohiKojyoSyosai().getSyosaiPanel1().getKubunRadioButton().getSelectedKey();
            for (IryohiKojyoItiranDataGrid_Row row : dataSource) {
                if (row.getHiddenCodeKubun().equals(データ区分) && row.getHiddentaisyouYY().getValue().equals(対象年)) {
                    throw new ApplicationException(DbdErrorMessages.被保_受給者登録なし.getMessage()
                            .replace(IryoHiKojoNaiyo.toValue(データ区分).get名称().toString()));
                }
            }
        }
        if (!ResponseHolder.isReRequest() && getHandler(div).確定確認チェック()) {
            return ResponseData.of(div).addMessage(DbdWarningMessages.発行対象外登録.getMessage()).respond();
        }
        if (!ResponseHolder.isReRequest()
                || (ResponseHolder.getMessageCode().equals(new RString(DbdWarningMessages.発行対象外登録.getMessage().getCode()))
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.確定の確認.getMessage().getCode()))
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onClick_KakuteButton(ViewStateHolder.get(ViewStateKeys.状態, RString.class));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンonClick
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onClick_btnReSearch(IryouhiKoujyoDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        RealInitialLocker.release(new LockingKey(DB.concat(被保険者番号.value()).concat(医療費控除登録)));
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンonClick
     *
     * @param div IryouhiKoujyoDiv
     * @return ResponseData<IryouhiKoujyoDiv>
     */
    public ResponseData<IryouhiKoujyoDiv> onSave(IryouhiKoujyoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            TaishoshaKey 引き継ぎEntity = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            getHandler(div).save(引き継ぎEntity);
            div.getKaigoKanryoMessageChildDiv().setMessage(完了メッセージメイン,
                    ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号().value(),
                    div.getKaigoAtenaInfoChildDiv().get氏名漢字(), true);
            return ResponseData.of(div).setState(DBD9010001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private IryouhiKoujyoHandler getHandler(IryouhiKoujyoDiv div) {
        return new IryouhiKoujyoHandler(div);
    }

    private IryouhiKoujyoValidationHandler getValidationHandler() {
        return new IryouhiKoujyoValidationHandler();
    }
}
