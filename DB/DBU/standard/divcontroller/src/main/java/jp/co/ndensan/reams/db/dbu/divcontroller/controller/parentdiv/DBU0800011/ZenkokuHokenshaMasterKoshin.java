/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0800011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.zenkokuhokenshamasterkoshin.HokenshaMasterKoshinBusiness;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.DBU0800011StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.DBU0800011TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.ZenkokuHokenshaMasterKoshinDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011.dgHokenshas_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0800011.ZenkokuHokenshaMasterKoshinHandler;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0800011.ZenkokuHokenshaMasterKoshinValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja.Builder;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsuType;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoDataKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaSearchItem;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.IHokenjaManager;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.IZenkokuJushoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.INewSearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory;
import static jp.co.ndensan.reams.uz.uza.util.db.searchcondition.SearchConditionFactory.where;
import jp.co.ndensan.reams.uz.uza.util.db.searchcondition.StringOperator;

/**
 * 全国保険者マスタ更新のDivControllerです。
 *
 * @reamsid_L DBU-4230-010 chenxiangyu
 */
public class ZenkokuHokenshaMasterKoshin {

    private static final RString 全国住所管理が取得できなかった = new RString("全国住所管理が取得できなかった");
    private static final RString 処理 = new RString("処理");
    private static final RString 修正状態 = new RString("修正");
    private static final RString 削除状態 = new RString("削除");
    private static final RString 追加状態 = new RString("追加");
    private static final RString DB = new RString("DB");
    private static final RString HOKENSJA = new RString("Hokensja");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onload(ZenkokuHokenshaMasterKoshinDiv div) {
        IZenkokuJushoFinder finder = ZenkokuJushoFinderFactory.createInstance();
        List<ZenkokuJushoItem> itemList = finder.get全国住所Byデータ区分(ZenkokuJushoDataKubunType.都道府県.getデータ区分());
        if (itemList.isEmpty()) {
            Message message = UrErrorMessages.実行不可.getMessage().replace(
                    全国住所管理が取得できなかった.toString(),
                    処理.toString());
            ErrorMessage errorMessages = new ErrorMessage(message.getCode(), message.evaluate());
            return ResponseData.of(div).addMessage(errorMessages).respond();
        }

        List<KeyValueDataSource> sourceList = new ArrayList<>();
        RString 都道府県コード = RString.EMPTY;
        for (ZenkokuJushoItem item : itemList) {
            if (!都道府県コード.equals(item.get都道府県コード())) {
                sourceList.add(new KeyValueDataSource(item.get都道府県コード(), item.get都道府県名()));
            }
            都道府県コード = item.get都道府県コード();
        }
        div.getDdlTodofuken().setDataSource(sourceList);
        div.getDdlTodofuken().setSelectedKey(DbBusinessConfig.
                get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, 2));
        getHander(div).set保険者一覧(search保険者一覧(div));
        return ResponseData.of(div).setState(DBU0800011StateName.更新);
    }

    /**
     * 「都道府県DDL」のフォーカスを失うします。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onBlur_ddlTodofuken(ZenkokuHokenshaMasterKoshinDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate変更内容();
        if (!validPairs.iterator().hasNext()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHander(div).set保険者一覧(search保険者一覧(div));
                return ResponseData.of(div).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        }
        getHander(div).set保険者一覧(search保険者一覧(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 「追加する」ボタンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_btnAddHokensha(ZenkokuHokenshaMasterKoshinDiv div) {
        div.getHokenshaJoho().setHdnJotai(追加状態);
        getHander(div).show保険者情報();
        return ResponseData.of(div).setState(DBU0800011StateName.保険者情報登録);
    }

    /**
     * 「確定する」ボタンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_btnKakutei(ZenkokuHokenshaMasterKoshinDiv div) {
        if (追加状態.equals(div.getHokenshaJoho().getHdnJotai())) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validate必須入力項();
            ValidationMessageControlPair 保険者番号pair = getValidationHandler(div).validate保険者番号();
            if (保険者番号pair != null) {
                validPairs.add(保険者番号pair);
            }
            ValidationMessageControlPair 重複pair = getValidationHandler(div).validate重複();
            if (重複pair != null) {
                validPairs.add(重複pair);
            }
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHander(div).update保険者一覧項目();
        div.getHokenshaJoho().setDisplayNone(true);
        return ResponseData.of(div).setState(DBU0800011StateName.更新);
    }

    /**
     * 「取消する」ボタンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_btnTorikeshi(ZenkokuHokenshaMasterKoshinDiv div) {
        if (getValidationHandler(div).check保険者情報の編集()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHander(div).clear保険者情報();
                div.getHokenshaJoho().setDisplayNone(true);
                return ResponseData.of(div).setState(DBU0800011StateName.更新);
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            getHander(div).clear保険者情報();
            div.getHokenshaJoho().setDisplayNone(true);
            return ResponseData.of(div).setState(DBU0800011StateName.更新);
        }
    }

    /**
     * 「保存する」ボタンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_btnUpdate(ZenkokuHokenshaMasterKoshinDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate変更内容();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            LockingKey 前排他ロックキー = new LockingKey(DB.concat(div.getDdlTodofuken().getSelectedKey()).concat(HOKENSJA));
            if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
                throw new PessimisticLockingException();
            }
            save(div);
            RealInitialLocker.release(前排他ロックキー);
            return ResponseData.of(div).setState(DBU0800011StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_btnComplete(ZenkokuHokenshaMasterKoshinDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBU0800011TransitionEventName.完了).respond();
    }

    /**
     * 「修正」アイコンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_iconModify(ZenkokuHokenshaMasterKoshinDiv div) {
        div.getHokenshaJoho().setHdnJotai(修正状態);
        getHander(div).set保険者情報(div.getDgHokenshas().getSelectedItems().get(0));
        getHander(div).show保険者情報();
        return ResponseData.of(div).setState(DBU0800011StateName.保険者情報登録);
    }

    /**
     * 「削除」アイコンを押します。
     *
     * @param div 画面の情報
     * @return ResponseData<ZenkokuHokenshaMasterKoshinDiv>
     */
    public ResponseData<ZenkokuHokenshaMasterKoshinDiv> onClick_iconDelete(ZenkokuHokenshaMasterKoshinDiv div) {
        div.getHokenshaJoho().setHdnJotai(削除状態);
        getHander(div).set保険者情報(div.getDgHokenshas().getSelectedItems().get(0));
        getHander(div).show保険者情報();
        return ResponseData.of(div).setState(DBU0800011StateName.保険者情報登録);
    }

    private List<Hokenja> search保険者一覧(ZenkokuHokenshaMasterKoshinDiv div) {
        IHokenjaManager manager = HokenjaManagerFactory.createInstance();
        INewSearchCondition 保険者番号 = SearchConditionFactory.
                condition(HokenjaSearchItem.保険者番号, StringOperator.前方一致, div.getDdlTodofuken().getSelectedKey());
        INewSearchCondition 保険者種別 = SearchConditionFactory.
                condition(HokenjaSearchItem.保険者種別, StringOperator.完全一致, HokenjaShubetsuType.介護保険.code());
        ISearchCondition result = where(保険者番号).and(保険者種別);
        return manager.get保険者一覧(result);
    }

    private ZenkokuHokenshaMasterKoshinHandler getHander(ZenkokuHokenshaMasterKoshinDiv div) {
        return new ZenkokuHokenshaMasterKoshinHandler(div);
    }

    private ZenkokuHokenshaMasterKoshinValidationHandler getValidationHandler(ZenkokuHokenshaMasterKoshinDiv div) {
        return new ZenkokuHokenshaMasterKoshinValidationHandler(div);
    }

    private boolean save(ZenkokuHokenshaMasterKoshinDiv div) {
        boolean flag = true;
        IHokenjaManager manager = HokenjaManagerFactory.createInstance();
        for (dgHokenshas_Row row : div.getDgHokenshas().getDataSource()) {
            if (!row.getJotai().isNullOrEmpty()) {
                Builder builder = Hokenja.newBuilder();
                builder.setHokenjaShubetsu(new HokenjaShubetsu(HokenjaShubetsuType.介護保険.code()));
                builder.setHokenjaNo(new HokenjaNo(row.getHokenshaNo()));
                builder.setHokenjaName(row.getHokenshaName());
                builder.setJusho(row.getJusho());
                builder.setTelNo(new TelNo(row.getTelNo()));
                builder.setYubinNo(new YubinNo(row.getYubinNo()));
                Hokenja hknj = builder.build();
                HokenshaMasterKoshinBusiness business = new HokenshaMasterKoshinBusiness(hknj.toEntity());
                if (追加状態.equals(row.getJotai())) {
                    business.setState(EntityDataState.Added);
                    flag = (1 == manager.save保険者(new Hokenja(business.getEntity())));
                } else if (修正状態.equals(row.getJotai())) {
                    business.setState(EntityDataState.Modified);
                    flag = (1 == manager.save保険者(new Hokenja(business.getEntity())));
                } else {
                    business.setState(EntityDataState.Deleted);
                    flag = (1 == manager.save保険者(new Hokenja(business.getEntity())));
                }
            }
        }
        return flag;
    }
}
