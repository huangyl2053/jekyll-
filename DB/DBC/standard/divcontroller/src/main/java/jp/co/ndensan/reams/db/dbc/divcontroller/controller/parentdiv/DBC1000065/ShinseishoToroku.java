/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1000065;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC190030.DBC190030_kijunsyunygetsujiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoTorokuChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065.DBC1000065TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065.ShinseishoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000065.ShinseishoTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000065.ShinseishoTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 基準収入額適用申請書_異動分作成のクラスです。
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class ShinseishoToroku {

    private static final int INDEX_4 = 4;

    /**
     * 画面初期化のハンドラクラスです。
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onLoad(ShinseishoTorokuDiv div) {
        getHandler(div).initialize(div);
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタンを切り替えた時に、画面項目の表示を制御するのクラスです。
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onChange_RadChushutsuJoken(ShinseishoTorokuDiv div) {
        getHandler(div).set抽出条件表示制御処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタン押下時のイベントメソッドです。
     *
     * @param div DBZ0200001
     * @return ResponseData<DBZ0200001Div>
     */
    public ResponseData<ShinseishoTorokuDiv> onClick_Search(ShinseishoTorokuDiv div) {
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getTxtHihokenshaNo().getValue());
        return ResponseData.of(div).forwardWithEventName(DBC1000065TransitionEventName.対象者検索).respond();
    }

    /**
     * 画面項目の被保険者番号に設定のクラスです。
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onActive(ShinseishoTorokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (資格対象者 == null) {
            div.getTxtHihokenshaNo().setValue(RString.EMPTY);
        } else {
            div.getTxtHihokenshaNo().setValue(isNullOrEmpty(資格対象者.get被保険者番号()));
        }
        return ResponseData.of(div).respond();
    }

    private RString isNullOrEmpty(HihokenshaNo date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.value();
    }

    /**
     * 文書番号ccdを初期化のクラスです。
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onChange_SakuseiYMD(ShinseishoTorokuDiv div) {
        getHandler(div).set文書番号();
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialog
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoTorokuDiv> onBeforeOpenDialog(ShinseishoTorokuDiv div) {
        FlexibleYear 処理年度 = new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4));
        getHandler(div).set出力順の入力チェック();
        if (ShinseishoTorokuChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey()) && getHandler(div).処理年度判定()) {
            ValidationMessageControlPairs valid = getValidationHandler(div).処理年度チェックValidate();
            if (valid.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        if (ShinseishoTorokuChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey()) && getHandler(div).世帯員把握基準日判定()) {
            ValidationMessageControlPairs valid1 = getValidationHandler(div).世帯員把握基準日チェックValidate(処理年度);
            if (valid1.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid1).respond();
            }
        }
        if ((div.getChkIchiranhyoCsv().isAllSelected() && !div.getChkTsuchisho().isAllSelected()
                && !div.getChkShinseisho().isAllSelected()) || (!div.getChkIchiranhyoCsv().isAllSelected()
                && !div.getChkTsuchisho().isAllSelected() && !div.getChkShinseisho().isAllSelected())) {
            ValidationMessageControlPairs valid2 = getValidationHandler(div).出力対象チェックValidate();
            if (valid2.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid2).respond();
            }
        }
        if (ShinseishoTorokuChushutsuJoken.異動分.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())
                || ShinseishoTorokuChushutsuJoken.被保険者番号.getコード().equals(div.getRadChushutsuJoken().getSelectedKey())) {
            getHandler(div).年次処理が実行済みか確認();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「實行」ボタン押下時の処理クラスです。
     *
     * @param div ShinseishoTorokuDiv
     * @return ResponseData
     */
    public ResponseData<DBC190030_kijunsyunygetsujiParameter> onClick_btnExcute(ShinseishoTorokuDiv div) {
        DBC190030_kijunsyunygetsujiParameter parameter = getHandler(div).setバッチ();
        return ResponseData.of(parameter).respond();
    }

    private ShinseishoTorokuHandler getHandler(ShinseishoTorokuDiv div) {
        return new ShinseishoTorokuHandler(div);
    }

    private ShinseishoTorokuValidationHandler getValidationHandler(ShinseishoTorokuDiv div) {
        return new ShinseishoTorokuValidationHandler(div);
    }
}
