/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsei.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.DBE2210001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplShisetsuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplZaitakuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1Handler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001.NinnteiChousaKekkaTouroku1ValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1 {

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString 登録グループコード_1 = new RString("1");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 施設 = new RString("施設");
    private static final RString カンマ = new RString(",");
    private static final RString ない = new RString("0");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;
    private static final RString 厚労省IF識別コード_02A = new RString("02A");
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_99A = new RString("99A");
    private static final int データベース内連番_1 = 1;
    private static final int データベース内連番_2 = 2;
    private static final int データベース内連番_3 = 3;
    private static final int データベース内連番_4 = 4;
    private static final int データベース内連番_5 = 5;
    private static final int データベース内連番_6 = 6;
    private static final int データベース内連番_7 = 7;
    private static final int データベース内連番_8 = 8;
    private static final int データベース内連番_9 = 9;
    private static final int データベース内連番_10 = 10;
    private static final int データベース内連番_11 = 11;
    private static final int データベース内連番_12 = 12;
    private static final int データベース内連番_13 = 13;
    private static final int データベース内連番_14 = 14;
    private static final int データベース内連番_15 = 15;
    private static final int データベース内連番_16 = 16;
    private static final int データベース内連番_17 = 17;
    private static final int データベース内連番_18 = 18;
    private static final int データベース内連番_19 = 19;
    private static final int データベース内連番_20 = 20;
    private static final int データベース内連番_21 = 21;
    private static final int データベース内連番_22 = 22;
    private static final int データベース内連番_23 = 23;
    private static final int データベース内連番_24 = 24;
    private static final int データベース内連番_25 = 25;
    private static final int データベース内連番_26 = 26;
    private static final int データベース内連番_27 = 27;
    private static final int データベース内連番_28 = 28;
    private static final int データベース内連番_29 = 29;
    private static final int データベース内連番_30 = 30;
    private static final int データベース内連番_31 = 31;
    private static final int データベース内連番_32 = 32;
    private static final int データベース内連番_33 = 33;
    private static final int データベース内連番_34 = 34;
    private static final int データベース内連番_35 = 35;
    private static final int データベース内連番_36 = 36;
    private static final int データベース内連番_37 = 37;
    private static final int データベース内連番_38 = 38;
    private static final int データベース内連番_39 = 39;
    private static final int データベース内連番_40 = 40;
    private static final int データベース内連番_41 = 41;
    private static final int データベース内連番_42 = 42;
    private static final int データベース内連番_43 = 43;
    private static final int データベース内連番_44 = 44;
    private static final int データベース内連番_45 = 45;
    private static final int データベース内連番_46 = 46;
    private static final int データベース内連番_47 = 47;
    private static final int データベース内連番_48 = 48;
    private static final int データベース内連番_49 = 49;
    private static final int データベース内連番_50 = 50;
    private static final int データベース内連番_51 = 51;
    private static final int データベース内連番_52 = 52;
    private static final int データベース内連番_53 = 53;
    private static final int データベース内連番_54 = 54;
    private static final int データベース内連番_55 = 55;
    private static final int データベース内連番_56 = 56;
    private static final int データベース内連番_57 = 57;
    private static final int データベース内連番_58 = 58;
    private static final int データベース内連番_59 = 59;
    private static final int データベース内連番_60 = 60;
    private static final int データベース内連番_61 = 61;
    private static final int データベース内連番_62 = 62;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_63 = 63;
    private static final int INDEX_72 = 72;

    /**
     * 認定調査結果登録1の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onLoad(NinnteiChousaKekkaTouroku1Div div) {

        // テストデータ
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, 123);
        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, new RString("1"));
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(new RString("221001")));

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

        boolean 変更あり = false;
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
            getHandler(div).利用サービス前半or後半の切り替え(Boolean.TRUE, 現在の選択, 元の選択);
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
            getHandler(div).利用サービス前半or後半の切り替え(Boolean.FALSE, 現在の選択, 元の選択);
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
            div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().setSelectedKey(元の実施場所);
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
        div.setHidden登録グループコード(登録グループコード_1);
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
     * ボタン「前回値をコピーする」を押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onClick_btnZenkaiCopy(NinnteiChousaKekkaTouroku1Div div) {
//        ShinseishoKanriNo 前回申請書管理番号 = getHandler(div).get前回申請書管理番号();
//        int 前回最大認定調査依頼履歴番号 = getHandler(div).get前回最大認定調査依頼履歴番号(前回申請書管理番号);
//        RString 調査項目 = getHandler(div).get調査項目(前回申請書管理番号, 前回最大認定調査依頼履歴番号);
        // TODO # 75188 共有子DIVにて対応を行います。  基本調査の共有子DIVは四次設計対象になっています。
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

//            更新処理(div); // TODO #78160
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
        return ResponseData.of(div).forwardWithEventName(DBE2210001TransitionEventName.検索結果一覧に戻る).respond();
    }

    /**
     * 「完了」ボタンを押下する処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onclick_btnComplete(NinnteiChousaKekkaTouroku1Div div) {
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

    private void 更新処理(NinnteiChousaKekkaTouroku1Div div) {

        認定調査依頼情報の更新();
        概況調査の更新(div);
        RString 選択値 = div.getRadGenzaiservis().getSelectedKey();
        if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            予防給付サービス状況の更新(div);
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            介護給付サービス状況の更新(div);
        }
        サービス状況フラグの更新(div);
        記入項目の更新(div);
        施設利用の更新(div);
        調査項目の更新(div);
    }

    private void 認定調査依頼情報の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosaIraiJohoManager dbt5201Manager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho dbt5201 = dbt5201Manager.get認定調査依頼情報(temp_申請書管理番号, temp_認定調査履歴番号);
        NinteichosaIraiJohoBuilder dbt5201Bulid = dbt5201.createBuilderForEdit();
        dbt5201Bulid.set認定調査回数(1);
        dbt5201Manager.save認定調査依頼情報(dbt5201Bulid.build());
    }

    private void 概況調査の更新(NinnteiChousaKekkaTouroku1Div div) {
        // TODO 78160
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);
        RString temp_認定調査依頼区分コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.認定調査依頼区分コード, RString.class);

        RString 概況調査テキストイメージ区分 = BusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        NinteichosahyoGaikyoChosa dbt5202 = new NinteichosahyoGaikyoChosa(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        NinteichosahyoGaikyoChosaBuilder dbt5202builder = dbt5202.createBuilderForEdit();

        RString 認定調査区分コード = ChosaKubun.新規調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())
                ? ChosaKubun.新規調査.getコード() : ChosaKubun.再調査.getコード();
        dbt5202builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5202builder.set認定調査依頼区分コード(new Code(temp_認定調査依頼区分コード));
        dbt5202builder.set認定調査回数(1);
        dbt5202builder.set認定調査実施年月日(new FlexibleDate(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getValue().toDateString()));
//        dbt5202builder.set認定調査受領年月日(newFlexibleDate( ));  // TODO #78160
        dbt5202builder.set認定調査区分コード(new Code(認定調査区分コード));
        dbt5202builder.set認定調査委託先コード(new JigyoshaNo(div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedKey()));
        dbt5202builder.set認定調査員コード(div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedKey());
        dbt5202builder.set認定調査実施場所コード(new Code(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey())); //test key的值
//        dbt5202builder.set認定調査実施場所名称(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().get); #75188 TODO
        dbt5202builder.set認定調査_サービス区分コード(new Code(div.getRadGenzaiservis().getSelectedKey())); //test key的值
        dbt5202builder.set利用施設名(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().getValue());
        dbt5202builder.set利用施設住所(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().getDomain());
        dbt5202builder.set利用施設電話番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().getDomain());
        dbt5202builder.set利用施設郵便番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().getValue());
        dbt5202builder.set特記(div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
        dbt5202builder.set認定調査特記事項受付年月日(new FlexibleDate(RString.EMPTY));
        dbt5202builder.set認定調査特記事項受領年月日(new FlexibleDate(RString.EMPTY));

        NinteichosahyoGaikyoChosaManager dbt5202Manager = new NinteichosahyoGaikyoChosaManager();
        dbt5202Manager.save認定調査票_概況調査_子(dbt5202builder.build());
    }

    private void サービス状況フラグの更新(NinnteiChousaKekkaTouroku1Div div) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoServiceJokyoFlagManager dbt5208Manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag dbt5208 = new NinteichosahyoServiceJokyoFlag(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        NinteichosahyoServiceJokyoFlagBuilder dbt5202Builder = dbt5208.createBuilderForEdit();
        RString 住宅改修 = div.getRadJutakuKaishu().getSelectedKey();
        if (住宅改修_有.equals(住宅改修)) {
            dbt5202Builder.setサービスの状況フラグ(Boolean.TRUE);
        } else if (住宅改修_無.equals(住宅改修)) {
            dbt5202Builder.setサービスの状況フラグ(Boolean.FALSE);
        }
        dbt5208Manager.save認定調査票_概況調査_サービスの状況フラグ(dbt5202Builder.build());
    }

    private void 記入項目の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        NinteichosahyoKinyuItemManager dbt5209Manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        NinteichosahyoKinyuItemBuilder dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(div.getTxtShichosonTokubetsuKyufu().getValue());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());

        dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(div.getTxtKyufuIgaiJutakuService().getValue());
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());
    }

    private void 調査項目の更新(NinnteiChousaKekkaTouroku1Div div) {
        基本調査第1群更新(div);
        基本調査第2群更新(div);
        基本調査第3群更新(div);
        基本調査第4群更新(div);
        基本調査第5群更新(div);
        基本調査第6群更新(div);
        基本調査第7群更新(div);
    }

    private void 基本調査第1群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        List<RString> 麻痺List = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getChkMahi().getSelectedKeys();
        for (RString key : 麻痺List) {
            key = key.substring(INDEX_3);
            if (!ない.equals(key)) {
                調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, Integer.valueOf(key.toString()), RString.EMPTY);
            }
        }
        List<RString> 拘縮List = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getChkKoshuku().getSelectedKeys();
        for (RString key : 拘縮List) {
            key = key.substring(INDEX_3);
            if (!ない.equals(key)) {
                調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, Integer.valueOf(key.toString()) + INDEX_5, RString.EMPTY);
            }
        }

        RString 寝返り = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadNeKaeri().getSelectedKey();
        RString 起き上がり = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadOkiAgari().getSelectedKey();
        RString 座位保持 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadZai().getSelectedKey();
        RString 両足での立位保持 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadRyoAshi().getSelectedKey();
        RString 歩行 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadBuko().getSelectedKey();
        RString 立ち上がり = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadTachiAgari().getSelectedKey();
        RString 片足での立位 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadKataAshi().getSelectedKey();
        RString 洗身 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadSenshin().getSelectedKey();
        RString つめ切り = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadTumeKiri().getSelectedKey();
        RString 視力 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadShiryoku().getSelectedKey();
        RString 聴力 = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadChoryoku().getSelectedKey();

        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_10, 寝返り);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_11, 起き上がり);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_12, 座位保持);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_13, 両足での立位保持);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_14, 歩行);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_15, 立ち上がり);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_16, 片足での立位);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_17, 洗身);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_18, つめ切り);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_19, 視力);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_20, 聴力);
    }

    private void 基本調査第2群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        RString 移乗 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadIjyo().getSelectedKey();
        RString 移動 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadIdou().getSelectedKey();
        RString えん下 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadEnka().getSelectedKey();
        RString 食事摂取 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadShokuji().getSelectedKey();
        RString 排尿 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHainyo().getSelectedKey();
        RString 排便 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHaiben().getSelectedKey();
        RString 口腔清潔 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadKokou().getSelectedKey();
        RString 洗顔 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadSengan().getSelectedKey();
        RString 整髪 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadSeihatsu().getSelectedKey();
        RString 上衣の着脱 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadUwagi().getSelectedKey();
        RString ズボンの着脱 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadZubon().getSelectedKey();
        RString 外出頻度 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHindo().getSelectedKey();

        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_21, 移乗);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_22, 移動);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_23, えん下);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_24, 食事摂取);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_25, 排尿);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_26, 排便);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_27, 口腔清潔);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_28, 洗顔);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_29, 整髪);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_30, 上衣の着脱);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_31, ズボンの着脱);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_32, 外出頻度);
    }

    private void 基本調査第3群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        RString 意思の伝達 = div.getCcdSangunKihonChosa().getNinchiKinou().getRadIshiDentatsu().getSelectedKey();
        RString 毎日の日課を理解 = div.getCcdSangunKihonChosa().getNinchiKinou().getRadNikka().getSelectedKey();
        RString 生年月日や年齢を言う = div.getCcdSangunKihonChosa().getNinchiKinou().getRadInfo().getSelectedKey();
        RString 短期記憶 = div.getCcdSangunKihonChosa().getNinchiKinou().getRadDankiKioku().getSelectedKey();
        RString 自分の名前を言う = div.getCcdSangunKihonChosa().getNinchiKinou().getRadNameInfo().getSelectedKey();
        RString 今の季節を理解する = div.getCcdSangunKihonChosa().getNinchiKinou().getRadKisetsu().getSelectedKey();
        RString 場所の理解 = div.getCcdSangunKihonChosa().getNinchiKinou().getRadBasho().getSelectedKey();
        RString 徘徊 = div.getCcdSangunKihonChosa().getNinchiKinou().getRadHaikai().getSelectedKey();
        RString 外出すると戻れない = div.getCcdSangunKihonChosa().getNinchiKinou().getRadModoru().getSelectedKey();

        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_33, 意思の伝達);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_34, 毎日の日課を理解);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_35, 生年月日や年齢を言う);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_36, 短期記憶);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_37, 自分の名前を言う);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_38, 今の季節を理解する);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_39, 場所の理解);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_40, 徘徊);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_41, 外出すると戻れない);
    }

    private void 基本調査第4群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        RString 被虐的 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadbtnHiryaku().getSelectedKey();
        RString 作話 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadTukuriHanashi().getSelectedKey();
        RString 感情が不安定 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadKanjyo().getSelectedKey();
        RString 昼夜逆転 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadChuyaku().getSelectedKey();
        RString 同じ話をする = div.getCcdYongunKihonChosa().getKoudoShogai().getRadOnajiHanashi().getSelectedKey();
        RString 大声をだす = div.getCcdYongunKihonChosa().getKoudoShogai().getRadBigVoice().getSelectedKey();
        RString 介護に抵抗 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadTeikou().getSelectedKey();
        RString 落ち着きなし = div.getCcdYongunKihonChosa().getKoudoShogai().getRadOchituki().getSelectedKey();
        RString 一人で出たがる = div.getCcdYongunKihonChosa().getKoudoShogai().getRadOutLonly().getSelectedKey();
        RString 収集癖 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadShushu().getSelectedKey();
        RString 物や衣類を壊す = div.getCcdYongunKihonChosa().getKoudoShogai().getRadKowasu().getSelectedKey();
        RString ひどい物忘れ = div.getCcdYongunKihonChosa().getKoudoShogai().getRadMonoWasure().getSelectedKey();
        RString 独り言 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadHitoriWarai().getSelectedKey();
        RString 自分勝手に行動する = div.getCcdYongunKihonChosa().getKoudoShogai().getRadKateKodo().getSelectedKey();
        RString 話がまとまらない = div.getCcdYongunKihonChosa().getKoudoShogai().getRadMatomeNai().getSelectedKey();

        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_42, 被虐的);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_43, 作話);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_44, 感情が不安定);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_45, 昼夜逆転);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_46, 同じ話をする);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_47, 大声をだす);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_48, 介護に抵抗);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_49, 落ち着きなし);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_50, 一人で出たがる);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_51, 収集癖);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_52, 物や衣類を壊す);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_53, ひどい物忘れ);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_54, 独り言);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_55, 自分勝手に行動する);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_56, 話がまとまらない);
    }

    private void 基本調査第5群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        RString 薬の内服 = div.getCcdGogun().getShakaiSekatsu().getRadKusuri().getSelectedKey();
        RString 金銭の管理 = div.getCcdGogun().getShakaiSekatsu().getRadKingakuKanri().getSelectedKey();
        RString 日常の意思決定 = div.getCcdGogun().getShakaiSekatsu().getRadIshiKetei().getSelectedKey();
        RString 集団への不適用 = div.getCcdGogun().getShakaiSekatsu().getRadShudan().getSelectedKey();
        RString 買い物 = div.getCcdGogun().getShakaiSekatsu().getRadKaiMono().getSelectedKey();
        RString 簡単な調理 = div.getCcdGogun().getShakaiSekatsu().getRadKantanChori().getSelectedKey();

        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_57, 薬の内服);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_58, 金銭の管理);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_59, 日常の意思決定);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_60, 集団への不適用);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_61, 買い物);
        調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, データベース内連番_62, 簡単な調理);
    }

    private void 基本調査第6群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        List<RString> 処置内容List = div.getCcdTokubetsuIryoKihonChosa().getTokubetsuIryo().getChkShochiNaiyo().getSelectedKeys();
        for (RString key : 処置内容List) {
            key = key.substring(INDEX_3);
            if (ない.equals(key)) {
                調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, Integer.valueOf(key.toString()) + INDEX_63, RString.EMPTY);
            }
        }
        List<RString> 特別な対応List = div.getCcdTokubetsuIryoKihonChosa().getTokubetsuIryo().getChkTokiTaiou().getSelectedKeys();
        for (RString key : 特別な対応List) {
            key = key.substring(INDEX_3);
            if (ない.equals(key)) {
                調査項目の保存(temp_申請書管理番号, temp_認定調査履歴番号, Integer.valueOf(key.toString()) + INDEX_72, RString.EMPTY);
            }
        }
    }

    private void 基本調査第7群更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        NinteichosahyoKihonChosaManager manager = new NinteichosahyoKihonChosaManager();
        RString 認知症高齢者の日常生活自立度コード = div.getCcdSeikatsuJiritsudoKihonchosa().getJiritsudo().getRadShogaiKoreisha().getSelectedKey();
        NinteichosahyoKihonChosa dbt5203 = new NinteichosahyoKihonChosa(temp_申請書管理番号, temp_認定調査履歴番号);
        NinteichosahyoKihonChosaBuilder builder = dbt5203.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        builder.set認定調査_認知症高齢者の日常生活自立度コード(new Code(new RString(
                Integer.valueOf(Integer.valueOf(認知症高齢者の日常生活自立度コード.substring(INDEX_3).toString()) + 1).toString())));
        manager.save認定調査票_基本調査(builder.build());

        RString 障害高齢者の日常生活自立度コード = div.getCcdSeikatsuJiritsudoKihonchosa().getJiritsudo().getRadNinchishaJiritsudo().getSelectedKey();
        dbt5203 = new NinteichosahyoKihonChosa(temp_申請書管理番号, temp_認定調査履歴番号);
        builder = dbt5203.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        builder.set認定調査_障害高齢者の日常生活自立度コード(new Code(new RString(
                Integer.valueOf(Integer.valueOf(障害高齢者の日常生活自立度コード.substring(INDEX_3).toString()) + 1).toString())));
        manager.save認定調査票_基本調査(builder.build());
    }

    private void 調査項目の保存(ShinseishoKanriNo temp_申請書管理番号, int temp_認定調査履歴番号, int 連番, RString selectKey) {
        NinteichosahyoChosaItem dbt5211 = new NinteichosahyoChosaItem(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        NinteichosahyoChosaItemBuilder builder = dbt5211.createBuilderForEdit();
        if (!selectKey.isNullOrEmpty()) {
            builder.set調査項目(new RString(Integer.valueOf(Integer.valueOf(selectKey.substring(INDEX_3).toString()) + 1).toString()));
        }
        NinteichosahyoChosaItemManager manager = new NinteichosahyoChosaItemManager();
        manager.save認定調査票_基本調査_調査項目(builder.build());
    }

    private void 予防給付サービス状況の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
        }

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        List<dgRiyoSerViceFirstHalf_Row> firstHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (dgRiyoSerViceFirstHalf_Row firstRow : firstHalf) {
            利用状況 = firstRow.getServiceJokyo().getValue();
            連番 = 連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 介護給付サービス状況の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = new ArrayList<>();
        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_13);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
            連番List.add(データベース内連番_17);
            連番List.add(データベース内連番_18);
        }

        if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_19);
            連番List.add(データベース内連番_20);
        }

        NinteichosahyoServiceJokyoManager dbt5207Manager = new NinteichosahyoServiceJokyoManager();
        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        Decimal 利用状況;
        int index = 0;
        int 連番;
        for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
            利用状況 = row.getServiceJokyo().getValue();
            連番 = 連番List.get(index++);
            NinteichosahyoServiceJokyo dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    private void 施設利用の更新(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
        } else if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_9);
        }

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = new NinteichosahyoShisetsuRiyoManager();
        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        int index = 0;
        int 連番;
        RString 概況調査場所 = ViewStateHolder.get(Dbe2210001Keys.現在の概況調査場所, RString.class);
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            連番 = 連番List.get(index++);
            NinteichosahyoShisetsuRiyo dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            if (連番 == データベース内連番_1 && 施設.equals(概況調査場所)) {
                dbt5210Builder.set施設利用フラグ(Boolean.TRUE);
            } else {
                dbt5210Builder.set施設利用フラグ(Boolean.FALSE);
            }
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(row.getShisetsuRiyoUmu());
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
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
