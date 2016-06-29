/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplShisetsuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplZaitakuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Handler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoChosaItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査結果登録1のクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public class NinnteiChousaKekkaTouroku1 {

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString 登録グループコード = new RString("5001");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 施設 = new RString("施設");
    private static final RString カンマ = new RString(",");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;

    /**
     * 認定調査結果登録1の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onLoad(NinnteiChousaKekkaTouroku1Div div) {

        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            throw new ApplicationException(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage());
        }
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBE2210001StateName.調査結果登録);
    }

    /**
     * 認定調査結果登録1のオンアクティブ処理。<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onActive(NinnteiChousaKekkaTouroku1Div div) {

        getHandler(div).resetData();
        return ResponseData.of(div).respond();
    }

    /**
     * 現在のサービス区分radのonChange処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_radGenzaiService(NinnteiChousaKekkaTouroku1Div div) {

        boolean 変更あり;
        RString 変更前の設定値 = RString.EMPTY;
        RString 現在の設定値 = RString.EMPTY;
        RString 現在の選択 = div.getRadGenzaiservis().getSelectedKey();
        RString 元の選択 = ViewStateHolder.get(Dbe2210001Keys.現在のサービス区分, RString.class);

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getRadGenzaiservis().setSelectedKey(元の選択);
            return ResponseData.of(div).respond();
        } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).利用サービス前半or後半の切り替え(現在の選択);
            return ResponseData.of(div).respond();
        }

        boolean 入力あり = Boolean.FALSE;
        if (予防給付サービス_選択.equals(元の選択)) {
            List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                    入力あり = Boolean.TRUE;
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の予防給付サービス, RString.class);
        } else if (介護給付サービス_選択.equals(元の選択)) {
            List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
            for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                    入力あり = Boolean.TRUE;
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の介護給付サービス, RString.class);
        }
        if (変更前の設定値 == null && 入力あり == Boolean.FALSE) {
            変更あり = Boolean.FALSE;
        } else if (変更前の設定値 == null && 入力あり == Boolean.TRUE) {
            変更あり = Boolean.TRUE;
        } else {
            変更あり = !現在の設定値.equalsIgnoreCase(変更前の設定値);
        }

        if (変更あり && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (!変更あり) {
            getHandler(div).利用サービス前半or後半の切り替え(現在の選択);
        }

        ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 現在の選択);
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
            return 在宅クリック(div);
        } else if (施設.equals(title)) {
            return 施設クリック(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 在宅tplのクリック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    private ResponseData<NinnteiChousaKekkaTouroku1Div> 在宅クリック(NinnteiChousaKekkaTouroku1Div div) {

        RString 実施場所 = div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue();
        if (!ResponseHolder.isReRequest() && ChosaJisshiBashoCode.自宅外.get名称().equals(実施場所)) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.自宅外で在宅.getMessage().getCode(),
                    DbeWarningMessages.自宅外で在宅.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbeWarningMessages.自宅外で在宅.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getTabChosaBasho().setSelectedItem(new tplShisetsuDiv());
            return ResponseData.of(div).respond();
        }
        ViewStateHolder.put(Dbe2210001Keys.現在の概況調査場所, 在宅);
        getHandler(div).施設tplのクリア();
        div.getRadGenzaiservis().setDisabled(Boolean.FALSE);
        return ResponseData.of(div).respond();
    }

    /**
     * 施設tplのクリック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    private ResponseData<NinnteiChousaKekkaTouroku1Div> 施設クリック(NinnteiChousaKekkaTouroku1Div div) {

        RString 実施場所 = div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue();
        if (!ResponseHolder.isReRequest() && ChosaJisshiBashoCode.自宅内.get名称().equals(実施場所)) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.自宅内で施設.getMessage().getCode(),
                    DbeWarningMessages.自宅内で施設.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(DbeWarningMessages.自宅内で施設.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
            return ResponseData.of(div).respond();
        }
        ViewStateHolder.put(Dbe2210001Keys.現在の概況調査場所, 施設);
        div.getRadGenzaiservis().setSelectedKey(なし_選択);
        ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, なし_選択);
        getHandler(div).施設の表示();
        getHandler(div).利用サービス前半Gridのクリア();
        getHandler(div).利用サービス後半Gridのクリア();
        getHandler(div).利用サービス前半Grid非表示();
        getHandler(div).利用サービス後半Grid非表示();
        getHandler(div).住宅改修と記入項目のクリア();
        div.getRadGenzaiservis().setDisabled(Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 実施場所selectのonChange処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onChange_ddlChosaJisshiBasho(NinnteiChousaKekkaTouroku1Div div) {
        RString 現在の実施場所 = div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey();
        RString 元の実施場所 = ViewStateHolder.get(Dbe2210001Keys.実施場所, RString.class);
        RString 概況調査場所 = ViewStateHolder.get(Dbe2210001Keys.現在の概況調査場所, RString.class);

        if (!ResponseHolder.isReRequest() && ChosaJisshiBashoCode.自宅内.getコード().equals(現在の実施場所) && 施設.equals(概況調査場所)) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.施設で自宅内.getMessage().getCode(),
                    DbeWarningMessages.施設で自宅内.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (!ResponseHolder.isReRequest() && ChosaJisshiBashoCode.自宅外.getコード().equals(現在の実施場所) && 在宅.equals(概況調査場所)) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.在宅で自宅外.getMessage().getCode(),
                    DbeWarningMessages.在宅で自宅外.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(DbeWarningMessages.自宅内で施設.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                || new RString(DbeWarningMessages.施設で自宅内.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ViewStateHolder.put(Dbe2210001Keys.実施場所, 現在の実施場所);

        } else if (new RString(DbeWarningMessages.在宅で自宅外.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No
                || new RString(DbeWarningMessages.施設で自宅内.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().setSelectedValue(元の実施場所);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「一次判定を実施する」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onBeforeOpenDialog_btnIchiHanteiJisshi(NinnteiChousaKekkaTouroku1Div div) {
        // TODO 「DBZ.IchijiHanteiKekkaJoho」  #75188 この機能はTodoとしてください。また、テストも未実施で良いです。
        return ResponseData.of(div).respond();
    }

    /**
     * ダイアログで選択された情報を「一次判定結果」へセットします。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnIchiHanteiJisshi(NinnteiChousaKekkaTouroku1Div div) {
        // TODO #75188 この機能はTodoとしてください。また、テストも未実施で良いです。
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
        div.setHidden登録グループコード(登録グループコード);
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
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onOkClose_btnKihonChosa(NinnteiChousaKekkaTouroku1Div div) {
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「前回値をコピーする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnZenkaiCopy(NinnteiChousaKekkaTouroku1Div div) {

        boolean 前回基本調査項目値あり = ViewStateHolder.get(Dbe2210001Keys.前回基本調査項目値あり, Boolean.class);
        if (!前回基本調査項目値あり) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("前回値"));
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
            getHandler(div).前回値コピー処理();
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

        if (!第1群List.isEmpty() || 第2群List.isEmpty() || 第3群List.isEmpty() || 第4群List.isEmpty()
                || 第5群List.isEmpty() || 特別な医療List.isEmpty() || 自立度List.isEmpty()) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().getCode(),
                    DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).規定値設定処理();
        }
        return ResponseData.of(div).respond();
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
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        boolean 入力内容変更なし = Boolean.FALSE;
        if (!ResponseHolder.isReRequest()) {
            入力内容変更なし = getHandler(div).is入力内容変更なし();
        }
        if (!入力内容変更なし && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        } else if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes || 入力内容変更なし) {
            前排他キーの解除();
            set画面遷移パラメータ(div);
            return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.概況特記入力を表示).respond();
        }

        return ResponseData.of(div).respond();
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
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        boolean 入力内容変更なし = Boolean.FALSE;
        if (!ResponseHolder.isReRequest()) {
            入力内容変更なし = getHandler(div).is入力内容変更なし();
        }

        if (!入力内容変更なし && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes || 入力内容変更なし) {
            前排他キーの解除();
            set画面遷移パラメータ(div);
            return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.特記事項一覧を表示).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ボタン「入力内容をキャンセルする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnCancel(NinnteiChousaKekkaTouroku1Div div) {

        boolean 入力内容変更なし = Boolean.FALSE;
        if (!ResponseHolder.isReRequest()) {
            入力内容変更なし = getHandler(div).is入力内容変更なし();
        }

        if (!入力内容変更なし && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes || 入力内容変更なし) {
            getHandler(div).resetData();
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

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor調査実施日の必須入力(pairs, div);
        getValidationHandler().validateFor実施場所の必須入力(pairs, div);
        getValidationHandler().validateFor所属機関の必須入力(pairs, div);
        getValidationHandler().validateFor記入者の必須入力(pairs, div);
        getValidationHandler().validateFor第1群の必須入力(pairs, div);
        getValidationHandler().validateFor第2群の必須入力(pairs, div);
        getValidationHandler().validateFor第3群の必須入力(pairs, div);
        getValidationHandler().validateFor第4群の必須入力(pairs, div);
        getValidationHandler().validateFor第5群の必須入力(pairs, div);
        getValidationHandler().validateFor生活自立度の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        RString 実施場所 = div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue();
        RString 概況調査場所 = ViewStateHolder.get(Dbe2210001Keys.現在の概況調査場所, RString.class);

        if (ChosaJisshiBashoCode.自宅内.get名称().equals(実施場所) && 施設.equals(概況調査場所)) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("調査実施場所が自宅内ですが調査場所が施設"));
        } else if (ChosaJisshiBashoCode.自宅外.get名称().equals(実施場所) && 在宅.equals(概況調査場所)) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("調査実施場所が自宅外ですが調査場所が在宅"));
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            更新処理(div);
            前排他キーの解除();
            div.getKanryoMessage().getCcdKanryoMessage().setMessage(
                    new RString(UrInformationMessages.正常終了.getMessage().replace("処理").evaluate()), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2210001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象者一覧へ戻る」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onclick_btnBackToTaishoshaIchiran(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.検索結果一覧に戻る).respond();
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

    @Transaction
    private void 更新処理(NinnteiChousaKekkaTouroku1Div div) {

        RString 認定調査0回 = new RString("0");
        RString 認定調査1回 = new RString("1");
        RString 現在の概況調査場所 = ViewStateHolder.get(Dbe2210001Keys.現在の概況調査場所, RString.class);

        RString 現在のサービス区分 = div.getRadGenzaiservis().getSelectedKey();

        RString temp_認定調査回数 = ViewStateHolder.get(Dbe2210001Keys.認定調査回数, RString.class);
        if (ChosaKubun.新規調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())
                && 認定調査0回.equals(temp_認定調査回数)
                || ChosaKubun.新規調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())
                && 認定調査1回.equals(temp_認定調査回数)
                || ChosaKubun.再調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())) {

            現在の状況_在宅or施設の保存(div);
            認定調査依頼情報の更新();
            概況調査の更新(div);
            サービス状況フラグの更新(div);
            記入項目の更新(div);
            調査項目の更新();

            if (予防給付サービス_選択.toString().equalsIgnoreCase(現在のサービス区分.toString())) {
                介護給付サービス状況のクリア(div);
                予防給付サービス状況の更新(div);
            } else if (介護給付サービス_選択.toString().equalsIgnoreCase(現在のサービス区分.toString())) {
                予防給付サービス状況のクリア(div);
                介護給付サービス状況の更新(div);
            } else if (なし_選択.toString().equalsIgnoreCase(現在のサービス区分.toString())) {
                予防給付サービス状況のクリア(div);
                介護給付サービス状況のクリア(div);
            }

            if (施設.equals(現在の概況調査場所)) {
                施設利用の更新(div);
            } else if (!施設.equals(現在の概況調査場所)) {
                施設利用falseの設定(div);
            }
        }
    }

    private void 認定調査依頼情報の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosaIraiJohoManager dbt5201Manager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho dbt5201 = dbt5201Manager.get認定調査依頼情報(temp_申請書管理番号, temp_認定調査履歴番号);
        if (dbt5201 == null) {
            dbt5201 = new NinteichosaIraiJoho(temp_申請書管理番号, temp_認定調査履歴番号);
        }
        NinteichosaIraiJohoBuilder dbt5201Bulid = dbt5201.createBuilderForEdit();
        dbt5201Bulid.set認定調査回数(1);
        dbt5201Manager.save認定調査依頼情報(dbt5201Bulid.build());
    }

    private void 概況調査の更新(NinnteiChousaKekkaTouroku1Div div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);
        RString temp_認定調査依頼区分コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.認定調査依頼区分コード, RString.class);

        RString 概況調査テキストイメージ区分 = DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        NinteichosahyoGaikyoChosaManager dbt5202Manager = new NinteichosahyoGaikyoChosaManager();
        NinteichosahyoGaikyoChosa dbt5202 = dbt5202Manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        if (dbt5202 == null) {
            dbt5202 = new NinteichosahyoGaikyoChosa(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        }
        NinteichosahyoGaikyoChosaBuilder dbt5202builder = dbt5202.createBuilderForEdit();

        RString 認定調査区分コード = ChosaKubun.新規調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())
                ? ChosaKubun.新規調査.getコード() : ChosaKubun.再調査.getコード();
        RString サービス区分コード = div.getRadGenzaiservis().getSelectedKey();
        if (予防給付サービス_選択.equals(サービス区分コード)) {
            サービス区分コード = ServiceKubunCode.予防給付サービス.getコード();
        } else if (介護給付サービス_選択.equals(サービス区分コード)) {
            サービス区分コード = ServiceKubunCode.介護給付サービス.getコード();
        } else {
            サービス区分コード = ServiceKubunCode.なし.getコード();
        }

        dbt5202builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5202builder.set認定調査依頼区分コード(new Code(temp_認定調査依頼区分コード));
        dbt5202builder.set認定調査回数(1);
        dbt5202builder.set認定調査実施年月日(new FlexibleDate(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getValue().toDateString()));
        dbt5202builder.set認定調査受領年月日(FlexibleDate.getNowDate());
        dbt5202builder.set認定調査区分コード(new Code(認定調査区分コード));
        dbt5202builder.set認定調査委託先コード(new JigyoshaNo(div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedKey()));
        dbt5202builder.set認定調査員コード(div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedKey());
        dbt5202builder.set認定調査実施場所コード(new Code(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey()));
        dbt5202builder.set認定調査実施場所名称(div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getValue());
        dbt5202builder.set認定調査_サービス区分コード(new Code(サービス区分コード));
        dbt5202builder.set利用施設名(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().getValue());
        dbt5202builder.set利用施設住所(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().getDomain());
        dbt5202builder.set利用施設電話番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().getDomain());
        dbt5202builder.set利用施設郵便番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().getValue());
        dbt5202builder.set特記(div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
        dbt5202builder.set認定調査特記事項受付年月日(new FlexibleDate(RString.EMPTY));
        dbt5202builder.set認定調査特記事項受領年月日(new FlexibleDate(RString.EMPTY));

        dbt5202Manager.save認定調査票_概況調査_子(dbt5202builder.build());
    }

    private void サービス状況フラグの更新(NinnteiChousaKekkaTouroku1Div div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        NinteichosahyoServiceJokyoFlagManager dbt5208Manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag dbt5208 = dbt5208Manager.
                get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        if (dbt5208 == null) {
            dbt5208 = new NinteichosahyoServiceJokyoFlag(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        }
        NinteichosahyoServiceJokyoFlagBuilder dbt5208Builder = dbt5208.createBuilderForEdit();
        dbt5208Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        RString 住宅改修 = div.getRadJutakuKaishu().getSelectedKey();
        if (住宅改修_有.equals(住宅改修)) {
            dbt5208Builder.setサービスの状況フラグ(Boolean.TRUE);
        } else if (住宅改修_無.equals(住宅改修)) {
            dbt5208Builder.setサービスの状況フラグ(Boolean.FALSE);
        }
        dbt5208Manager.save認定調査票_概況調査_サービスの状況フラグ(dbt5208Builder.build());
    }

    private void 記入項目の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        NinteichosahyoKinyuItemManager dbt5209Manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem dbt5209 = dbt5209Manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        if (dbt5209 == null) {
            dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        }
        NinteichosahyoKinyuItemBuilder dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(div.getTxtShichosonTokubetsuKyufu().getValue());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());

        dbt5209 = dbt5209Manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        if (dbt5209 == null) {
            dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        }
        dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(div.getTxtKyufuIgaiJutakuService().getValue());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());
    }

    private void 施設利用の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = getHandler(div).get施設利用連番List(temp_厚労省IF識別コード);

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        int index = 0;
        int 連番;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            連番 = 連番List.get(index++);
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5210 == null) {
                dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(row.getShisetsuRiyoUmu());
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void 施設利用falseの設定(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = getHandler(div).get施設利用連番List(temp_厚労省IF識別コード);

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        for (Integer 連番 : 連番List) {
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5210 == null) {
                dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(Boolean.FALSE);
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void 現在の状況_在宅or施設の保存(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        int 居宅連番 = 1;
        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 居宅連番);
        if (dbt5210 == null) {
            dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 居宅連番);
        }
        NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
        dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));

        RString title = div.getTabChosaBasho().getSelectedItem().getTitle();
        if (在宅.equals(title)) {
            dbt5210Builder.set施設利用フラグ(Boolean.TRUE);
        } else if (施設.equals(title)) {
            dbt5210Builder.set施設利用フラグ(Boolean.FALSE);
        }
        dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
    }

    private void 調査項目の更新() {
        基本調査第1群更新();
        基本調査第2群更新();
        基本調査第3群更新();
        基本調査第4群更新();
        基本調査第5群更新();
        基本調査第6群更新();
        基本調査第7群更新();
    }

    private void 基本調査第1群更新() {

        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        if (第1群List == null || 第1群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第1群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
        }
    }

    private void 基本調査第2群更新() {
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        if (第2群List == null || 第2群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第2群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
        }
    }

    private void 基本調査第3群更新() {
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        if (第3群List == null || 第3群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第3群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
        }
    }

    private void 基本調査第4群更新() {
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        if (第4群List == null || 第4群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第4群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
        }
    }

    private void 基本調査第5群更新() {
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        if (第5群List == null || 第5群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第5群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
        }
    }

    private void 基本調査第6群更新() {
        ArrayList<KihonChosaInput> 第6群List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        if (第6群List == null || 第6群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 第6群List) {
            調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
        }
    }

    private void 基本調査第7群更新() {

        ArrayList<KihonChosaInput> 第7群List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        if (第7群List == null || 第7群List.isEmpty()) {
            return;
        }

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        NinteichosahyoKihonChosaManager manager = new NinteichosahyoKihonChosaManager();

        Code 障害高齢者の日常生活自立度コード = 第7群List.get(0).get障害高齢者自立度();
        Code 認知症高齢者の日常生活自立度コード = 第7群List.get(1).get認知症高齢者自立度();

        NinteichosahyoKihonChosa dbt5203 = manager.get認定調査票_基本調査(temp_申請書管理番号, temp_認定調査履歴番号);
        if (dbt5203 == null) {
            dbt5203 = new NinteichosahyoKihonChosa(temp_申請書管理番号, temp_認定調査履歴番号);
        }
        NinteichosahyoKihonChosaBuilder builder = dbt5203.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        builder.set認定調査_障害高齢者の日常生活自立度コード(障害高齢者の日常生活自立度コード);
        builder.set認定調査_認知症高齢者の日常生活自立度コード(認知症高齢者の日常生活自立度コード);
        manager.save認定調査票_基本調査(builder.build());
    }

    private void 調査項目の保存(int 連番, RString 調査項目) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoChosaItemManager manager = new NinteichosahyoChosaItemManager();
        NinteichosahyoChosaItem dbt5211 = manager.get認定調査票_基本調査_調査項目(temp_申請書管理番号, temp_認定調査履歴番号, 連番);

        if (dbt5211 == null) {
            dbt5211 = new NinteichosahyoChosaItem(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        }
        NinteichosahyoChosaItemBuilder builder = dbt5211.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(ViewStateHolder.get(Dbe2210001Keys.厚労省IF識別コード, RString.class)));
        builder.set調査項目(調査項目);
        manager.save認定調査票_基本調査_調査項目(builder.build());
    }

    private void 予防給付サービス状況の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = getHandler(div).get予防給付サービス連番List(temp_厚労省IF識別コード);

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        List<dgRiyoSerViceFirstHalf_Row> firstHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
        if (firstHalf == null) {
            return;
        }
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (dgRiyoSerViceFirstHalf_Row firstRow : firstHalf) {
            利用状況 = firstRow.getServiceJokyo().getValue();
            if (利用状況 == null || 利用状況.toString().isEmpty()) {
                利用状況 = new Decimal(0);
            }
            連番 = 連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 予防給付サービス状況のクリア(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = getHandler(div).get予防給付サービス連番List(temp_厚労省IF識別コード);

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        for (Integer 連番 : 連番List) {
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(0);
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 介護給付サービス状況の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = getHandler(div).get介護給付サービス連番List(temp_厚労省IF識別コード);

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        if (secondHalf == null) {
            return;
        }
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (dgRiyoSerViceSecondHalf_Row secondRow : secondHalf) {
            利用状況 = secondRow.getServiceJokyo().getValue();
            if (利用状況 == null || 利用状況.toString().isEmpty()) {
                利用状況 = new Decimal(0);
            }
            連番 = 連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 介護給付サービス状況のクリア(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = getHandler(div).get介護給付サービス連番List(temp_厚労省IF識別コード);

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        for (Integer 連番 : 連番List) {
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(0);
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void set画面遷移パラメータ(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        ViewStateHolder.put(ViewStateKeys.申請書管理番号, temp_申請書管理番号);
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, temp_認定調査履歴番号);
        ViewStateHolder.put(ViewStateKeys.調査実施日, div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText());
        ViewStateHolder.put(ViewStateKeys.調査実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.実施場所名称, div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getText());
        ViewStateHolder.put(ViewStateKeys.所属機関, div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.記入者, div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.調査区分, div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getText());
    }

    private NinnteiChousaKekkaTouroku1Handler getHandler(NinnteiChousaKekkaTouroku1Div div) {
        return new NinnteiChousaKekkaTouroku1Handler(div);
    }

    private NinnteiChousaKekkaTouroku1ValidationHandler getValidationHandler() {
        return new NinnteiChousaKekkaTouroku1ValidationHandler();
    }

}
