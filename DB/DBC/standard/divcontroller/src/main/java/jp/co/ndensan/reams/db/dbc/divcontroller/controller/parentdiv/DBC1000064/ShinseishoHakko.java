/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1000064;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC190020.DBC190020_kijunsyunyunenjiParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000064.DBC1000064TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000064.ShinseishoHakkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000064.ShinseishoHakkoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000064.ShinseishoHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 基準収入額適用申請書_年次分作成のクラスです。
 *
 * @reamsid_L DBC-4630-010 lihang
 */
public class ShinseishoHakko {

    private static final ReportId 帳票ID = new ReportId("DBC100064_KijunShunyugakuTekiyoShinseisho");
    private static final RString 十二月三十一 = new RString("1231");
    private static final RString 出力順を = new RString("出力順を");
    private static final RString 異動処理が実施済みの = new RString("異動処理が実施済みの");
    private static final RString 実行 = new RString("実行");
    private static final int INDEX_4 = 4;

    /**
     * onLoadです。
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoHakkoDiv> onLoad(ShinseishoHakkoDiv div) {

        getHandler(div).set初期化処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件ラジオボタンです。
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoHakkoDiv> onChange_RadChushutsuJoken(ShinseishoHakkoDiv div) {
        getHandler(div).set抽出条件表示制御処理();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタン押下時のイベントメソッドです。
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoHakkoDiv> onClick_Search(ShinseishoHakkoDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC1000064TransitionEventName.対象者検索).respond();
    }

    /**
     * 画面項目の被保険者番号に設定のクラスです。
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoHakkoDiv> onActive(ShinseishoHakkoDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        if (資格対象者 != null && 資格対象者.get被保険者番号() != null) {
            div.getTxtHihokenshaNo().setValue(資格対象者.get被保険者番号().getColumnValue());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 作成日 文書番号ccdを初期化です。
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoHakkoDiv> onChange_SakuseiYMD(ShinseishoHakkoDiv div) {
        FlexibleDate 作成日 = div.getTxtSakuseiYMD().getValue();
        div.getCcdBunshoBangoInput().initialize(帳票ID, 作成日);
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialog
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishoHakkoDiv> onBeforeOpenDialog(ShinseishoHakkoDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).get入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() == null) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace(出力順を.toString()));
        }
        if (getHandler(div).is異動処理が実施済みか判定()) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().
                    replace(異動処理が実施済みの.toString(), 実行.toString()));
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(
                    new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                            UrQuestionMessages.処理実行の確認.getMessage().evaluate())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnExcute
     *
     * @param div ShinseishoHakkoDiv
     * @return ResponseData
     */
    public ResponseData<DBC190020_kijunsyunyunenjiParameter> onClick_btnExcute(ShinseishoHakkoDiv div) {
        DBC190020_kijunsyunyunenjiParameter parameter = new DBC190020_kijunsyunyunenjiParameter();
        getHandler(div).set前排他();
        FlexibleDate 世帯員把握基準日2 = new FlexibleDate(div.getTxtSetaiinHaakuKijunYMD()
                .getValue().getYear().minusYear(1).toString().concat(十二月三十一.toString()));
        parameter.set抽出条件(div.getRadChushutsuJoken().getSelectedKey());
        parameter.set処理年度(new FlexibleYear(div.getTxtShoriNendo().getValue().toString().substring(0, INDEX_4)));
        if (div.getTxtHihokenshaNo().getValue() != null) {
            parameter.set被保険者番号(new RString(div.getTxtHihokenshaNo().getValue().toString()));
        }
        parameter.set世帯員把握基準日(div.getTxtSetaiinHaakuKijunYMD().getValue());
        parameter.set世帯員把握基準日2(世帯員把握基準日2);
        parameter.set提出期限(div.getTxtTeishutsuKigen().getValue());
        parameter.set作成日(div.getTxtSakuseiYMD().getValue());
        parameter.set申請書出力フラグ(!(div.getChkShinseisho().getSelectedKeys().isEmpty()));
        parameter.setお知らせ通知書出力フラグ(!(div.getChkShinseisho().getSelectedKeys().isEmpty()));
        parameter.set一覧表CSV出力フラグ(!(div.getChkShinseisho().getSelectedKeys().isEmpty()));
        parameter.set文書番号(div.getCcdBunshoBangoInput().get文書番号());
        parameter.set帳票出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());
        parameter.set市町村コード(AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード());
        parameter.set市町村名(AssociationFinderFactory.createInstance().getAssociation().get市町村名());
        getHandler(div).release前排他();
        return ResponseData.of(parameter).respond();
    }

    private ShinseishoHakkoHandler getHandler(ShinseishoHakkoDiv div) {
        return new ShinseishoHakkoHandler(div);
    }

    private ShinseishoHakkoValidationHandler getValidationHandler(ShinseishoHakkoDiv div) {
        return new ShinseishoHakkoValidationHandler(div);
    }
}
