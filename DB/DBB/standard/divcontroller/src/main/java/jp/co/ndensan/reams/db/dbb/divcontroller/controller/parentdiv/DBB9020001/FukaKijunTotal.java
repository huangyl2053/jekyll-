/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9020001;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.DBB9020001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.DBB9020001TransitionEventName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.FukaKijunTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001.FukaKijunTotalHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001.FukaKijunTotalSaveHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001.FukaKijunTotalValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * システム管理（賦課基準）のクラスです。
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class FukaKijunTotal {

    private static final RString MESSAGE = new RString("システム管理登録_賦課基準保存処理は正常に行われました。");
    private static final RString MESSAGE_KEY = new RString("賦課年度：平XX年度");
    private static final RString 引数_XX = new RString("平XX");

    /**
     * 画面初期化です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onload(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        getHandler(div).賦課年度の設定(now);
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        getHandler(div).ランクの取得(賦課年度, now);
        return ResponseData.of(div).setState(getHandler(div).遷移先の設定(賦課年度));
    }

    /**
     * 賦課年度選択イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_DdlFukaNendo(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        getHandler(div).ランクの取得(賦課年度, now);
        return ResponseData.of(div).setState(getHandler(div).遷移先の設定(賦課年度));
    }

    /**
     * ランク選択イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_DdlRank(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        List<HokenryoDankai> 保険料段階List = getHandler(div).保険料率の取得と画面表示の設定(now);
        if (getHandler(div).check保険料段階マスタ(保険料段階List, 賦課年度)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div)
                    .保険料段階マスタが不正チェックValidate(賦課年度);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).画面項目の保険料率の値の設定(保険料段階List, now);
        ViewStateHolder.put(ViewStateKeys.保険料段階を全件, (Serializable) 保険料段階List);
        Map<RString, RString> dateSource = getHandler(div).本人保険料段階強制設定の設定段階の設定(now);
        ViewStateHolder.put(ViewStateKeys.保険料段階DATESOURCE, (Serializable) dateSource);
        getHandler(div).setランクの変更_項目表示を制御(dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 所得段階パネル（画面項目２～５を載せているパネル）イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onStateTransition(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        getHandler(div).保険料段階2015年以降の表示設定(now);
        List<HokenryoDankai> 保険料段階List = getHandler(div).保険料率の取得と画面表示の設定(now);
        if (getHandler(div).check保険料段階マスタ(保険料段階List, 賦課年度)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div)
                    .保険料段階マスタが不正チェックValidate(賦課年度);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        getHandler(div).画面項目の保険料率の値の設定(保険料段階List, now);
        ViewStateHolder.put(ViewStateKeys.保険料段階を全件, (Serializable) 保険料段階List);
        Map<RString, RString> dateSource = getHandler(div).本人保険料段階強制設定の設定段階の設定(now);
        ViewStateHolder.put(ViewStateKeys.保険料段階DATESOURCE, (Serializable) dateSource);
        getHandler(div).set項目表示を制御(now, dateSource);
        getHandler(div).set状態定義(賦課年度);
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯非課税段階（２段階以外）の軽減措置イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radKeigenSochiDankai2Gai(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        List<HokenryoDankai> 保険料段階一覧 = ViewStateHolder.get(ViewStateKeys.保険料段階を全件, List.class);
        getHandler(div).世帯非課税の軽減措置の変更(保険料段階一覧, now);
        Map<RString, RString> dateSource = getHandler(div).本人保険料段階強制設定の設定段階の設定(now);
        ViewStateHolder.put(ViewStateKeys.保険料段階DATESOURCE, (Serializable) dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 世帯非課税段階（２段階以外）の段階表記イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radDankaiHyokiDankai2Gai(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        List<HokenryoDankai> 保険料段階一覧 = ViewStateHolder.get(ViewStateKeys.保険料段階を全件, List.class);
        getHandler(div).世帯非課税の段階表記の変更(保険料段階一覧, now);
        Map<RString, RString> dateSource = getHandler(div).本人保険料段階強制設定の設定段階の設定(now);
        ViewStateHolder.put(ViewStateKeys.保険料段階DATESOURCE, (Serializable) dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 本人非課税・世帯課税段階の軽減措置イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radKeigenSochiDankai4(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        List<HokenryoDankai> 保険料段階一覧 = ViewStateHolder.get(ViewStateKeys.保険料段階を全件, List.class);
        getHandler(div).本人非課税の軽減措置の変更(保険料段階一覧, now);
        Map<RString, RString> dateSource = getHandler(div).本人保険料段階強制設定の設定段階の設定(now);
        ViewStateHolder.put(ViewStateKeys.保険料段階DATESOURCE, (Serializable) dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 本人非課税・世帯課税段階の段階表記イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radDankaiHyokiDankai4(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        List<HokenryoDankai> 保険料段階一覧 = ViewStateHolder.get(ViewStateKeys.保険料段階を全件, List.class);
        getHandler(div).本人非課税の段階表記の変更(保険料段階一覧, now);
        Map<RString, RString> dateSource = getHandler(div).本人保険料段階強制設定の設定段階の設定(now);
        ViewStateHolder.put(ViewStateKeys.保険料段階DATESOURCE, (Serializable) dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険料段階2015年以降の段階表記の任意設定イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radDankaihyokiNinisettei(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        List<HokenryoDankai> 保険料段階一覧 = ViewStateHolder.get(ViewStateKeys.保険料段階を全件, List.class);
        getHandler(div).段階表記の任意設定の変更(保険料段階一覧, now);
        return ResponseData.of(div).respond();
    }

    /**
     * 「未申告」の場合本人保険料段階の強制設定イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radMishinkokuKyoseiSettei(FukaKijunTotalDiv div) {
        Map<RString, RString> dateSource = ViewStateHolder.get(ViewStateKeys.保険料段階DATESOURCE, Map.class);
        getHandler(div).未申告設定段階の表示制御(dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 「所得調査中」の場合本人保険料段階の強制設定イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radShotokuChosaChuKyoseiSettei(FukaKijunTotalDiv div) {
        Map<RString, RString> dateSource = ViewStateHolder.get(ViewStateKeys.保険料段階DATESOURCE, Map.class);
        getHandler(div).所得調査中設定段階の表示制御(dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 課税取消の場合本人保険料段階の強制設定イベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_radKazeiTorikeshiKyoseiSettei(FukaKijunTotalDiv div) {
        Map<RString, RString> dateSource = ViewStateHolder.get(ViewStateKeys.保険料段階DATESOURCE, Map.class);
        getHandler(div).課税取消設定段階の表示制御(dateSource);
        return ResponseData.of(div).respond();
    }

    /**
     * 「完了する」ボタンのイベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onClick_btnKanryo(FukaKijunTotalDiv div) {
        getHandler(div).前排他を解除する();
        return ResponseData.of(div).forwardWithEventName(DBB9020001TransitionEventName.完了).respond();
    }

    /**
     * 「保存する」ボタンのイベント処理です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onClick_btnKoshin(FukaKijunTotalDiv div) {
        RDate now = RDate.getNowDate();
        List<HokenryoDankai> 保険料段階一覧 = ViewStateHolder.get(ViewStateKeys.保険料段階を全件, List.class);
        List<HokenryoDankai> 変更内容List = getSaveHandler(div).get変更内容(保険料段階一覧, now);
        if (getHandler(div).check保険料率(変更内容List)) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).保険料率が不正チェックValidate();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        ValidationMessageControlPairs validPairs = getValidationHandler(div).基準所得金額の必須チェックValidate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getSaveHandler(div).変更内容を保存(変更内容List, now);
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        div.getKanryoMessage().getCcdKaigoKanryoMessage().setMessage(MESSAGE,
                new RString(MESSAGE_KEY.toString().replace(引数_XX, 賦課年度.wareki().toDateString())),
                RString.EMPTY,
                true);
        return ResponseData.of(div).setState(DBB9020001StateName.完了);
    }

    private FukaKijunTotalHandler getHandler(FukaKijunTotalDiv div) {
        return new FukaKijunTotalHandler(div);
    }

    private FukaKijunTotalSaveHandler getSaveHandler(FukaKijunTotalDiv div) {
        return new FukaKijunTotalSaveHandler(div);
    }

    private FukaKijunTotalValidationHandler getValidationHandler(FukaKijunTotalDiv div) {
        return new FukaKijunTotalValidationHandler(div);
    }
}
