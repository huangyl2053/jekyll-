/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2210001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.kanri.SampleBunshoGroupCodes;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeInformationMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Handler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1ValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査結果登録1のクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public class NinnteiChousaKekkaTouroku1 {

    private static final RString KEY_登録修正 = new RString("0");
    private static final RString 在宅 = new RString("在宅");
    private static final RString KEY1 = new RString("第1群");
    private static final RString KEY2 = new RString("第2群");
    private static final RString KEY3 = new RString("第3群");
    private static final RString KEY4 = new RString("第4群");
    private static final RString KEY5 = new RString("第5群");
    private static final RString KEY6 = new RString("特別な医療群");
    private static final RString KEY7 = new RString("自立度群");
    private static final RString UICONTAINERID_DBEUC20601 = new RString("DBEUC20601");
    private static final RString 概況特記出力しない = new RString("2");

    /**
     * 認定調査結果登録1の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onLoad(NinnteiChousaKekkaTouroku1Div div) {
        if (new RString(UrErrorMessages.不正.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.審査会割当済のため処理不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeErrorMessages.一次判定済のため処理不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setDisabledControl_Error(div);
            return ResponseData.of(div).respond();
        }
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer 認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        getHandler(div).onLoad(申請書管理番号, 認定調査履歴番号);
        if (概況特記出力しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnGaikyoTokkiInput"), true);
        }
        if (!KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class))) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.不正.getMessage().getCode(),
                    UrErrorMessages.不正.getMessage().replace("認定ソフトのバージョン").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        ShinsakaiWariateJohoManager shinsakaiWariateManager = InstanceProvider.create(ShinsakaiWariateJohoManager.class);
        boolean 審査会割当済 = shinsakaiWariateManager.get審査会割当データ(申請書管理番号);
        if (審査会割当済) {
            if (!ResponseHolder.isReRequest()) {
                ErrorMessage message = new ErrorMessage(DbeErrorMessages.審査会割当済のため処理不可.getMessage().getCode(),
                        DbeErrorMessages.審査会割当済のため処理不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        NinteiKanryoJohoManager ninteiKanryoJohoManager = InstanceProvider.create(NinteiKanryoJohoManager.class);
        NinteiKanryoJoho 認定完了情報 = ninteiKanryoJohoManager.get要介護認定完了情報(申請書管理番号);
        if (認定完了情報.get要介護認定一次判定完了年月日() != null) {
            if (!ResponseHolder.isReRequest()) {
                InformationMessage message = new InformationMessage(DbeErrorMessages.一次判定済のため処理不可.getMessage().getCode(),
                        DbeErrorMessages.一次判定済のため処理不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査結果登録1のオンアクティブ処理。<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onActive(NinnteiChousaKekkaTouroku1Div div) {
        if (概況特記出力しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(new RString("btnGaikyoTokkiInput"), true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 更新種類ラジオボタンの切り替え処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_radUpdateKind(NinnteiChousaKekkaTouroku1Div div) {
        if (KEY_登録修正.equals(div.getRadUpdateKind().getSelectedKey())) {
            setNinteiChosaNyuryokuPanelDisabled(div, false);
        } else {
            setNinteiChosaNyuryokuPanelDisabled(div, true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 現在のサービス区分radのonChange処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_radGenzaiService(NinnteiChousaKekkaTouroku1Div div) {
        getHandler(div).サービス区分の切り替え();
        return ResponseData.of(div).respond();
    }

    /**
     * 「在宅・施設」tplのクリック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_tabChosaBasho(NinnteiChousaKekkaTouroku1Div div) {
        RString title = div.getTabChosaBasho().getSelectedItem().getTitle();
        if (在宅.equals(title)) {
            div.getRadGenzaiservis().setDisabled(Boolean.FALSE);
        } else {
            div.getRadGenzaiservis().setDisabled(Boolean.TRUE);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 施設利用のチェックボックス切り替え処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_chkShisetsuRiyoUmu(NinnteiChousaKekkaTouroku1Div div) {
        for (dgRiyoShisetsu_Row row : div.getDgRiyoShisetsu().getDataSource()) {
            if (!row.equals(div.getDgRiyoShisetsu().getClickedItem())) {
                row.setShisetsuRiyoUmu(Boolean.FALSE);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実施場所selectのonChange処理です。<br />
     * 選択された値をViewStateへのputのみを実施しています。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_ddlChosaJisshiBasho(NinnteiChousaKekkaTouroku1Div div) {
        RString 現在の実施場所 = div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey();
        ViewStateHolder.put(ViewStateKeys.調査実施場所コード, 現在の実施場所);
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「一次判定を実施する」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onBeforeOpenDialog_btnIchiHanteiJisshi(NinnteiChousaKekkaTouroku1Div div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor第1群の必須入力(pairs, div);
        getValidationHandler().validateFor第2群の必須入力(pairs, div);
        getValidationHandler().validateFor第3群の必須入力(pairs, div);
        getValidationHandler().validateFor第4群の必須入力(pairs, div);
        getValidationHandler().validateFor第5群の必須入力(pairs, div);
        getValidationHandler().validateFor生活自立度の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        ViewStateHolder.put(ViewStateKeys.モード, ModeType.ADD_MODE);

        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();

        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        RString hanteiArgument = manager.get一次判定引数(申請書管理番号, 第1群List, 第2群List, 第3群List,
                第4群List, 第5群List, 特別な医療List, 自立度List);

        if (RString.isNullOrEmpty(hanteiArgument)) {
            throw new ApplicationException(DbeErrorMessages.一次判定実行不可.getMessage());
        }

        div.setHanteiArgument(hanteiArgument);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された情報を「一次判定結果」へセットします。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnIchiHanteiJisshi(NinnteiChousaKekkaTouroku1Div div) {
        if (RString.isNullOrEmpty(div.getIchijiHanteiKekkaJoho())) {
            return ResponseData.of(div).respond();
        }
        IchijiHanteiKekkaJoho result = DataPassingConverter.deserialize(div.getIchijiHanteiKekkaJoho(), IchijiHanteiKekkaJoho.class);

        RString 厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);
        RString meisho = result.get一次判定結果名称(new Code(厚労省IF識別コード));
        div.getTxtIchijiHanteiKekka().setValue(meisho);
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「定型文」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onBeforeOpenDialog_btnTeikeibun(NinnteiChousaKekkaTouroku1Div div) {
        div.setHidden登録業務コード(GyomuCode.DB介護保険.getColumnValue());
        div.setHidden登録グループコード(SampleBunshoGroupCodes.調査票概況調査特記事項.getコード());
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された情報を概況調査定型文へセットします。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnTeikeibun(NinnteiChousaKekkaTouroku1Div div) {
        div.getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(div.getHiddenサンプル文書());
        return ResponseData.of(div).respond();
    }

    /**
     * 「基本調査選択欄」の各ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onBeforeOpenDialog_btnKihonChosa(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        div.setShinseishoKanriNo(temp_申請書管理番号.getColumnValue());
        div.setRecordNumber(new RString(String.valueOf(temp_認定調査履歴番号)));
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa1(NinnteiChousaKekkaTouroku1Div div) {
        RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
        div.setHiddenKihonChosaInput1Flag(基本調査の入力状況);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa2(NinnteiChousaKekkaTouroku1Div div) {
        RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
        div.setHiddenKihonChosaInput2Flag(基本調査の入力状況);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa3(NinnteiChousaKekkaTouroku1Div div) {
        RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
        div.setHiddenKihonChosaInput3Flag(基本調査の入力状況);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa4(NinnteiChousaKekkaTouroku1Div div) {
        RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
        div.setHiddenKihonChosaInput4Flag(基本調査の入力状況);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa5(NinnteiChousaKekkaTouroku1Div div) {
        RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
        div.setHiddenKihonChosaInput5Flag(基本調査の入力状況);
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa6(NinnteiChousaKekkaTouroku1Div div) {
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された基本調査情報を本画面に保存します。
     *
     * @param div コントロールdiv
     * @return スポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa7(NinnteiChousaKekkaTouroku1Div div) {
        RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
        div.setHiddenKihonChosaInput7Flag(基本調査の入力状況);
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「前回値をコピーする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnZenkaiCopy(NinnteiChousaKekkaTouroku1Div div) {
        RString 認定調査依頼区分コード = ViewStateHolder.get(ViewStateKeys.認定調査依頼区分コード, RString.class);
        if (!NinteichosaIraiKubun.再調査.getCode().equals(認定調査依頼区分コード)) {
            boolean 前回基本調査項目値あり = ViewStateHolder.get(ViewStateKeys.前回基本調査項目値あり, Boolean.class);
            if (!前回基本調査項目値あり) {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("前回値"));
            }
        }
        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        if (!第1群List.isEmpty() || 第2群List.isEmpty() || 第3群List.isEmpty() || 第4群List.isEmpty()
                || 第5群List.isEmpty() || 特別な医療List.isEmpty() || 自立度List.isEmpty()) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().getCode(),
                    DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (NinteichosaIraiKubun.再調査.getCode().equals(認定調査依頼区分コード)) {
                getHandler(div).前回値コピー処理_前回履歴(第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
            } else {
                getHandler(div).前回値コピー処理_前回申請(第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
            }
            ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, 第1群List);
            ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, 第2群List);
            ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, 第3群List);
            ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, 第4群List);
            ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, 第5群List);
            ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, 特別な医療List);
            ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, 自立度List);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「規定値を設定する」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnKiteichiSettei(NinnteiChousaKekkaTouroku1Div div) {

        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("規定値を設定します。").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.確認_汎用.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            Map<RString, ArrayList<KihonChosaInput>> map = new HashMap<>();
            map.put(KEY1, 第1群List);
            map.put(KEY2, 第2群List);
            map.put(KEY3, 第3群List);
            map.put(KEY4, 第4群List);
            map.put(KEY5, 第5群List);
            map.put(KEY6, 特別な医療List);
            map.put(KEY7, 自立度List);
            map = getHandler(div).規定値設定の前処理(map);

            ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY1)));
            ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY2)));
            ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY3)));
            ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY4)));
            ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY5)));
            ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY6)));
            ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, getHandler(div).基本調査群規定値設定(map.get(KEY7)));
            ViewStateHolder.put(ViewStateKeys.基本調査の入力状況, new RString("1"));
            RString 基本調査の入力状況 = ViewStateHolder.get(ViewStateKeys.基本調査の入力状況, RString.class);
            div.setHiddenKihonChosaInput1Flag(基本調査の入力状況);
            div.setHiddenKihonChosaInput2Flag(基本調査の入力状況);
            div.setHiddenKihonChosaInput3Flag(基本調査の入力状況);
            div.setHiddenKihonChosaInput4Flag(基本調査の入力状況);
            div.setHiddenKihonChosaInput5Flag(基本調査の入力状況);
            div.setHiddenKihonChosaInput7Flag(基本調査の入力状況);
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * ボタン「概況特記を入力する」を押下する処理です。（DBE2210002　概況特記入力画面へ遷移する）
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnGaikyoTokkiInput(NinnteiChousaKekkaTouroku1Div div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
        getValidationHandler().validateFor調査実施日の妥当性入力(pairs, div);
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        前排他キーの解除();
        set画面遷移パラメータ(div);
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.概況特記入力を表示).respond();
    }

    /**
     * ボタン「特記事項一覧を表示する」を押下する処理です。（DBE2210003　特記事項一覧画面へ遷移する）
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnTokkiJikoIchiran(NinnteiChousaKekkaTouroku1Div div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
        getValidationHandler().validateFor調査実施日の妥当性入力(pairs, div);
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        前排他キーの解除();
        set画面遷移パラメータ(div);
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.特記事項一覧を表示).respond();
    }

    /**
     * ボタン「入力内容をクリアする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnClear(NinnteiChousaKekkaTouroku1Div div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            前排他キーの解除();
            ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
            Integer 認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
            getHandler(div).DataReset();
            getHandler(div).onLoadAfterClear(申請書管理番号, 認定調査履歴番号);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「調査結果を保存する」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onclick_btnChosaKekkaUpdate(NinnteiChousaKekkaTouroku1Div div) {
        if (new RString(DbeInformationMessages.一次判定再処理.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).setState(DBE2210001StateName.完了);
        }

        boolean isDelete = !KEY_登録修正.equals(div.getRadUpdateKind().getSelectedKey());
        if (isDelete) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                        UrQuestionMessages.削除の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        } else {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
            getValidationHandler().validateFor調査実施日の妥当性入力(pairs, div);
            getValidationHandler().validateFor実施場所の必須入力(pairs, div);
            getValidationHandler().validateFor所属機関の必須入力(pairs, div);
            getValidationHandler().validateFor記入者の必須入力(pairs, div);
            getValidationHandler().validateFor第1群の必須入力(pairs, div);
            getValidationHandler().validateFor第2群の必須入力(pairs, div);
            getValidationHandler().validateFor第3群の必須入力(pairs, div);
            getValidationHandler().validateFor第4群の必須入力(pairs, div);
            getValidationHandler().validateFor第5群の必須入力(pairs, div);
            getValidationHandler().validateFor生活自立度の必須入力(pairs, div);
            pairs.add(div.getCcdChosaJisshishaJoho().validate());
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(UrQuestionMessages.削除の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            if (isDelete) {
                getHandler(div).削除処理();
            } else {
                getHandler(div).更新処理();
            }
            前排他キーの解除();
            div.getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("完了処理・認定調査結果登録").evaluate()), RString.EMPTY, RString.EMPTY, true);
            if (UICONTAINERID_DBEUC20601.equals(ResponseHolder.getUIContainerId())) {
                return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            }
            if (!isDelete) {
                ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
                IchijiHanteiKekkaJohoManager ichijiHanteiKekkaJohoManager = InstanceProvider.create(IchijiHanteiKekkaJohoManager.class);
                IchijiHanteiKekkaJoho 一次判定結果情報 = ichijiHanteiKekkaJohoManager.get要介護認定一次判定結果情報(申請書管理番号);
                if (一次判定結果情報 != null) {
                    return ResponseData.of(div).addMessage(DbeInformationMessages.一次判定再処理.getMessage()).respond();
                }
            }
            return ResponseData.of(div).setState(DBE2210001StateName.完了);
        }
        if (new RString(UrInformationMessages.保存終了.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.検索結果一覧に戻る).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧画面に遷移する。
     *
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return ResponseData<NinnteiChousaKekkaTouroku1Div>
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnSearchResult(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.検索結果一覧に戻る).respond();
    }

    /**
     * 申請者検索画面に遷移する.
     *
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return ResponseData<NinnteiChousaKekkaTouroku1Div>
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnReSearch(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.検索に戻る).respond();
    }

    /**
     * 基本運用画面に遷移する.
     *
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return ResponseData<NinnteiChousaKekkaTouroku1Div>
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnBackKihonUnyo(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.基本運用に戻る).respond();
    }

    /**
     * 「完了」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onclick_btnComplete(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.処理終了).respond();
    }

    /**
     * 「完了」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnKihonUnyo(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.基本運用に進む).respond();
    }

    private boolean 前排他キーのセット() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue()
                .concat(new RString("ShinseishoKanriNo")).concat(temp_申請書管理番号.getColumnValue()));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        LockingKey 排他キー = new LockingKey(SubGyomuCode.DBE認定支援.getGyomuCode().getColumnValue().concat(new RString("ShinseishoKanriNo"))
                .concat(temp_申請書管理番号.getColumnValue()));
        RealInitialLocker.release(排他キー);
    }

    private void set画面遷移パラメータ(NinnteiChousaKekkaTouroku1Div div) {
        ViewStateHolder.put(ViewStateKeys.申請日, div.getCcdChosaJisshishaJoho().getTxtNinteiShinseiDate().getText());
        ViewStateHolder.put(ViewStateKeys.調査実施日, div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText());
        ViewStateHolder.put(ViewStateKeys.調査実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.実施場所名称, div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getText());
        ViewStateHolder.put(ViewStateKeys.所属機関コード, div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode().getText());
        ViewStateHolder.put(ViewStateKeys.所属機関名称, div.getCcdChosaJisshishaJoho().getTxtShozokuKikanName().getText());
        ViewStateHolder.put(ViewStateKeys.記入者コード, div.getCcdChosaJisshishaJoho().getTxtKinyushaCode().getText());
        ViewStateHolder.put(ViewStateKeys.記入者名称, div.getCcdChosaJisshishaJoho().getTxtKinyushaName().getText());
        ViewStateHolder.put(ViewStateKeys.調査区分, div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getText());
    }

    private void setNinteiChosaNyuryokuPanelDisabled(NinnteiChousaKekkaTouroku1Div div, boolean isDisabled) {
        div.getNinteiChosaNyuryoku().getChosaTaisho().setDisabled(isDisabled);
        div.getNinteiChosaNyuryoku().getChosaJisshisha().setDisabled(isDisabled);
        div.getNinteiChosaNyuryoku().getTabChosaShurui().setDisabled(isDisabled);
        div.getNinteiChosaNyuryoku().getBtnClear().setDisabled(isDisabled);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnTokkiJikoIchiran"), isDisabled);
        if (!概況特記出力しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnGaikyoTokkiInput"), isDisabled);
        }
    }

    private void setDisabledControl_Error(NinnteiChousaKekkaTouroku1Div div) {
        div.setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnChosaKekkaUpdate"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnTokkiJikoIchiran"), true);
        if (DBE2210001StateName.調査結果登録_基本運用.getName().equals(ResponseHolder.getState())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnBackKihonUnyo"), true);
        }
    }

    private NinnteiChousaKekkaTouroku1Handler getHandler(NinnteiChousaKekkaTouroku1Div div) {
        return new NinnteiChousaKekkaTouroku1Handler(div);
    }

    private NinnteiChousaKekkaTouroku1ValidationHandler getValidationHandler() {
        return new NinnteiChousaKekkaTouroku1ValidationHandler();
    }

}
