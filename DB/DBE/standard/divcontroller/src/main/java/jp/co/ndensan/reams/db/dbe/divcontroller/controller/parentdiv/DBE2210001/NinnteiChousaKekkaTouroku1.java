/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1RelateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1RowJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
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
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1ValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Manager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho.ChosaJisshishaJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }

        TempData 認定調査情報 = getHandler(div).認定調査情報を取得(temp_申請書管理番号, temp_認定調査履歴番号);
        TempData gaikyoChosa = getHandler(div).既存概況調査情報取得(temp_申請書管理番号, temp_認定調査履歴番号);
        boolean is再調査の場合 = gaikyoChosa != null;
        ViewStateHolder.put(ViewStateKeys.再調査の場合, is再調査の場合);
        ViewStateHolder.put(ViewStateKeys.厚労省IF識別コード, 認定調査情報.getTemp_厚労省IF識別コード());
        ViewStateHolder.put(ViewStateKeys.認定調査依頼区分コード, 認定調査情報.getTemp_認定調査依頼区分コード());
        ViewStateHolder.put(ViewStateKeys.認定調査回数, 認定調査情報.getTemp_認定調査回数());

        基本調査の初期化(div, is再調査の場合);

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        if (is再調査の場合) {
            getHandler(div).住宅改修_既存初期化(temp_申請書管理番号, temp_認定調査履歴番号);
            ViewStateHolder.put(ViewStateKeys.住宅改修rad, div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().getSelectedKey());
            ViewStateHolder.put(ViewStateKeys.市町村特別給付TXT, div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().getValue());
            ViewStateHolder.put(ViewStateKeys.介護保険給付以外の在宅サービスTXT, div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().getValue());

            ChosaJisshishaJohoFinder service = ChosaJisshishaJohoFinder.createInstance();
            List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = service.getSyozokuKikan(temp_申請書管理番号.getColumnValue()).records();
            for (NinteichosaItakusakiJoho joho : ninteichosaItakusakiJohoList) {
                if (joho.get認定調査委託先コード().equals(gaikyoChosa.getTemp_調査委託先コード())) {
                    model.set所属機関(joho.get事業者名称());
                }
            }
            List<ChosainJoho> chosainJohoList = service.getKinyusha(temp_申請書管理番号.getColumnValue()).records();
            for (ChosainJoho chosainJoho : chosainJohoList) {
                if (chosainJoho.get認定調査員コード().equals(gaikyoChosa.getTemp_調査員コード())) {
                    model.set記入者(chosainJoho.get調査員氏名());
                }
            }
            model.set調査実施日(gaikyoChosa.getTemp_調査実施年月日());
            model.set調査実施場所(ChosaJisshiBashoCode.toValue(gaikyoChosa.getTemp_調査実施場所コード()).get名称());
            model.set実施場所名称(gaikyoChosa.getTemp_調査実施場所名称());
            getHandler(div).共有子DIV初期化(temp_申請書管理番号, model);
            再調査場合の初期化(div, 認定調査情報, gaikyoChosa, temp_申請書管理番号, temp_認定調査履歴番号);
        } else {
            getHandler(div).共有子DIV初期化(temp_申請書管理番号, model);

            ViewStateHolder.put(ViewStateKeys.現在の概況調査場所, 在宅);
            ViewStateHolder.put(ViewStateKeys.初期の概況調査場所, 在宅);
            ViewStateHolder.put(ViewStateKeys.現在のサービス区分, 予防給付サービス_選択);
            ViewStateHolder.put(ViewStateKeys.初期のサービス区分, 予防給付サービス_選択);
            div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
            ViewStateHolder.put(ViewStateKeys.住宅改修rad, 住宅改修_無);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修_無);

            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
            RString 予防給付状況 = getHandler(div).予防給付サービス名称取得(認定調査情報.getTemp_厚労省IF識別コード());
            ViewStateHolder.put(ViewStateKeys.初期の予防給付サービス, 予防給付状況);

            getHandler(div).利用サービス前半Grid表示(is再調査の場合, 認定調査情報.getTemp_厚労省IF識別コード(), null);
            getHandler(div).利用サービス後半Grid非表示();
        }
        ViewStateHolder.put(ViewStateKeys.調査実施場所コード, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, temp_申請書管理番号);
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, temp_認定調査履歴番号);
        ViewStateHolder.put(ViewStateKeys.調査実施日, div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText());
        ViewStateHolder.put(ViewStateKeys.調査実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.実施場所名称, div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getText());
        ViewStateHolder.put(ViewStateKeys.所属機関, div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.記入者, div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.調査区分, div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getText());

        return ResponseData.of(div).setState(DBE2210001StateName.調査結果登録);
    }

    /**
     * 認定調査結果登録1のオンアクティブ処理。<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinnteiChousaKekkaTouroku1Div> onActive(NinnteiChousaKekkaTouroku1Div div) {
        resetData(div);
        return onLoad(div);
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
        RString 元の選択 = ViewStateHolder.get(ViewStateKeys.現在のサービス区分, RString.class);

        boolean is再調査の場合 = ViewStateHolder.get(ViewStateKeys.再調査の場合, Boolean.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);

        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getRadGenzaiservis().setSelectedKey(元の選択);
            ViewStateHolder.put(ViewStateKeys.現在のサービス区分, 元の選択);
            return ResponseData.of(div).respond();
        } else if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            変更前の設定値 = get変更前の現在のサービス区分(現在の選択);
            getHandler(div).利用サービス前半or後半の切り替え(現在の選択, is再調査の場合, temp_厚労省IF識別コード, 変更前の設定値);
            ViewStateHolder.put(ViewStateKeys.現在のサービス区分, 現在の選択);
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
            変更前の設定値 = ViewStateHolder.get(ViewStateKeys.初期の予防給付サービス, RString.class);
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
            変更前の設定値 = ViewStateHolder.get(ViewStateKeys.初期の介護給付サービス, RString.class);
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
            変更前の設定値 = get初期のサービス設定値(現在の選択);
            getHandler(div).利用サービス前半or後半の切り替え(現在の選択, is再調査の場合, temp_厚労省IF識別コード, 変更前の設定値);
        }

        ViewStateHolder.put(ViewStateKeys.現在のサービス区分, 現在の選択);
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
     * 再調査場合、画面初期化を行います。
     *
     * @param div コントロールdiv
     * @param tempData 認定調査情報
     * @param gaikyoChosa 既存概況調査情報取得（再調査の場合）
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     */
    public void 再調査場合の初期化(NinnteiChousaKekkaTouroku1Div div, TempData tempData, TempData gaikyoChosa,
            ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {

        div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(gaikyoChosa.getTemp_特記());
        ViewStateHolder.put(ViewStateKeys.特記, div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getText());

        RString 現在の状況コード = gaikyoChosa.getTemp_現在の状況コード();
        RString サービス区分コード = gaikyoChosa.getTemp_現在のサービス区分コード();
        if (施設.equals(現在の状況コード) && ServiceKubunCode.なし.getコード().equals(サービス区分コード)) {

            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().setValue(gaikyoChosa.getTemp_利用施設名());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo()
                    .setValue(new YubinNo(gaikyoChosa.getTemp_利用施設郵便番号()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho()
                    .setDomain(new AtenaJusho(gaikyoChosa.getTemp_利用施設住所()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().setDomain(new TelNo(gaikyoChosa.getTemp_利用施設電話番号()));

            RString 施設連絡先 = gaikyoChosa.getTemp_利用施設名().concat(カンマ).concat(gaikyoChosa.getTemp_利用施設郵便番号()).concat(カンマ)
                    .concat(gaikyoChosa.getTemp_利用施設住所()).concat(カンマ).concat(gaikyoChosa.getTemp_利用施設電話番号());
            ViewStateHolder.put(ViewStateKeys.初期の施設連絡先, 施設連絡先);

            div.getTabChosaBasho().setSelectedItem(new tplShisetsuDiv());
            div.getRadGenzaiservis().setDisabled(Boolean.TRUE);
            ViewStateHolder.put(ViewStateKeys.現在の概況調査場所, 施設);
            ViewStateHolder.put(ViewStateKeys.初期の概況調査場所, 施設);
            div.getRadGenzaiservis().setSelectedKey(なし_選択);
            ViewStateHolder.put(ViewStateKeys.初期のサービス区分, なし_選択);
            ViewStateHolder.put(ViewStateKeys.現在のサービス区分, なし_選択);
            RString 施設利用 = getHandler(div).施設_施設利用フラグ_初期設定(申請書管理番号, 認定調査履歴番号, tempData.getTemp_厚労省IF識別コード());
            getHandler(div).利用サービス前半Grid非表示();
            getHandler(div).利用サービス後半Grid非表示();

            ViewStateHolder.put(ViewStateKeys.初期の施設利用, 施設利用);

        } else if (在宅.equals(現在の状況コード)) {
            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
            ViewStateHolder.put(ViewStateKeys.現在の概況調査場所, 在宅);
            ViewStateHolder.put(ViewStateKeys.初期の概況調査場所, 在宅);

            if (ServiceKubunCode.予防給付サービス.getコード().equals(サービス区分コード)) {
                div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
                ViewStateHolder.put(ViewStateKeys.初期のサービス区分, 予防給付サービス_選択);
                ViewStateHolder.put(ViewStateKeys.現在のサービス区分, 予防給付サービス_選択);
                RString 予防給付状況 = getHandler(div).予防給付サービス_利用状況_初期設定(申請書管理番号, 認定調査履歴番号, tempData.getTemp_厚労省IF識別コード());
                ViewStateHolder.put(ViewStateKeys.初期の予防給付サービス, 予防給付状況);
                getHandler(div).利用サービス後半Grid非表示();
            } else if (ServiceKubunCode.介護給付サービス.getコード().equals(サービス区分コード)) {
                div.getRadGenzaiservis().setSelectedKey(介護給付サービス_選択);
                ViewStateHolder.put(ViewStateKeys.初期のサービス区分, 介護給付サービス_選択);
                ViewStateHolder.put(ViewStateKeys.現在のサービス区分, 介護給付サービス_選択);
                RString 介護給付状況 = getHandler(div).介護給付サービス_利用状況_初期設定(申請書管理番号, 認定調査履歴番号, tempData.getTemp_厚労省IF識別コード());
                getHandler(div).利用サービス前半Grid非表示();

                ViewStateHolder.put(ViewStateKeys.初期の介護給付サービス, 介護給付状況);
            } else {
                div.getRadGenzaiservis().setSelectedKey(なし_選択);
                ViewStateHolder.put(ViewStateKeys.初期のサービス区分, なし_選択);
                ViewStateHolder.put(ViewStateKeys.現在のサービス区分, なし_選択);
                getHandler(div).利用サービス前半Grid非表示();
                getHandler(div).利用サービス後半Grid非表示();
            }
        }
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
        ViewStateHolder.put(ViewStateKeys.現在の概況調査場所, 在宅);
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
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);
        ViewStateHolder.put(ViewStateKeys.現在の概況調査場所, 施設);
        div.getRadGenzaiservis().setSelectedKey(なし_選択);
        ViewStateHolder.put(ViewStateKeys.現在のサービス区分, なし_選択);
        getHandler(div).施設の表示(temp_厚労省IF識別コード);
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
        RString 元の実施場所 = ViewStateHolder.get(ViewStateKeys.調査実施場所コード, RString.class);
        RString 概況調査場所 = ViewStateHolder.get(ViewStateKeys.現在の概況調査場所, RString.class);

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
            ViewStateHolder.put(ViewStateKeys.調査実施場所コード, 現在の実施場所);

        } else if (new RString(DbeWarningMessages.在宅で自宅外.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No
                || new RString(DbeWarningMessages.施設で自宅内.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().setSelectedKey(元の実施場所);
            ViewStateHolder.put(ViewStateKeys.調査実施場所コード, 元の実施場所);
            return ResponseData.of(div).respond();
        }
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

        boolean 前回基本調査項目値あり = ViewStateHolder.get(ViewStateKeys.前回基本調査項目値あり, Boolean.class);
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
            getHandler(div).前回値コピー処理(第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
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

        if (!第1群List.isEmpty() || 第2群List.isEmpty() || 第3群List.isEmpty() || 第4群List.isEmpty()
                || 第5群List.isEmpty() || 特別な医療List.isEmpty() || 自立度List.isEmpty()) {
            WarningMessage message = new WarningMessage(DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().getCode(),
                    DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }

        if (new RString(DbeWarningMessages.既に基本調査値が存在します_上書き確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).規定値設定処理(第1群List, 第2群List, 第3群List, 第4群List, 第5群List);
            ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, 第1群List);
            ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, 第2群List);
            ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, 第3群List);
            ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, 第4群List);
            ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, 第5群List);
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
            入力内容変更なし = is入力内容変更なし(div);
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
            入力内容変更なし = is入力内容変更なし(div);
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
            入力内容変更なし = is入力内容変更なし(div);
        }

        if (!入力内容変更なし && !ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes || 入力内容変更なし) {
            resetData(div);
            onLoad(div);
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
        RString 概況調査場所 = ViewStateHolder.get(ViewStateKeys.現在の概況調査場所, RString.class);

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

    private RString get初期のサービス設定値(RString 現在の選択) {
        RString 変更前の設定値 = RString.EMPTY;
        if (予防給付サービス_選択.equals(現在の選択)) {
            変更前の設定値 = ViewStateHolder.get(ViewStateKeys.初期の予防給付サービス, RString.class);
        } else if (介護給付サービス_選択.equals(現在の選択)) {
            変更前の設定値 = ViewStateHolder.get(ViewStateKeys.初期の介護給付サービス, RString.class);
        }
        return 変更前の設定値;
    }

    private void 基本調査の初期化(NinnteiChousaKekkaTouroku1Div div, boolean is再調査の場合) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        ArrayList<KihonChosaInput> 第1群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第2群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第3群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第4群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第5群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 特別な医療List = new ArrayList<>();
        ArrayList<KihonChosaInput> 自立度List = new ArrayList<>();

        RString 初期の基本調査 = getHandler(div).基本調査の初期化(temp_申請書管理番号, is再調査の場合, 第1群List, 第2群List,
                第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
        boolean 前回基本調査項目値あり = new RString("T").equals(初期の基本調査.substring(初期の基本調査.length() - 1, 初期の基本調査.length()));
        ViewStateHolder.put(ViewStateKeys.前回基本調査項目値あり, 前回基本調査項目値あり);
        ViewStateHolder.put(ViewStateKeys.初期の基本調査, 初期の基本調査.substring(0, 初期の基本調査.length() - 1));

        getHandler(div).基本調査の必須入力チェック(第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 自立度List);

        ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, 第1群List);
        ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, 第2群List);
        ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, 第3群List);
        ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, 第4群List);
        ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, 第5群List);
        ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, 特別な医療List);
        ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, 自立度List);
    }

    private RString get変更前の現在のサービス区分(RString 現在の選択) {
        RString 変更前の設定値 = RString.EMPTY;
        if (予防給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            変更前の設定値 = ViewStateHolder.get(ViewStateKeys.初期の予防給付サービス, RString.class);
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            変更前の設定値 = ViewStateHolder.get(ViewStateKeys.初期の介護給付サービス, RString.class);
        }
        return 変更前の設定値;
    }

    private boolean is入力内容変更なし(NinnteiChousaKekkaTouroku1Div div) {

        boolean is調査実施者等しい = getHandler(div).is調査実施者等しい(
                ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class),
                ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class),
                ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class),
                ViewStateHolder.get(ViewStateKeys.所属機関, RString.class),
                ViewStateHolder.get(ViewStateKeys.記入者, RString.class));

        boolean is基本調査以外等しい = getHandler(div).is入力内容変更なし(
                ViewStateHolder.get(ViewStateKeys.市町村特別給付TXT, RString.class),
                ViewStateHolder.get(ViewStateKeys.介護保険給付以外の在宅サービスTXT, RString.class),
                ViewStateHolder.get(ViewStateKeys.特記, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期の概況調査場所, RString.class),
                ViewStateHolder.get(ViewStateKeys.現在の概況調査場所, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期のサービス区分, RString.class),
                ViewStateHolder.get(ViewStateKeys.現在のサービス区分, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期の予防給付サービス, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期の介護給付サービス, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期の施設利用, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期の施設連絡先, RString.class),
                ViewStateHolder.get(ViewStateKeys.初期の基本調査, RString.class));

        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);

        boolean is基本調査等しい = getHandler(div).is基本調査等しい(ViewStateHolder.get(ViewStateKeys.初期の基本調査, RString.class),
                第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
        return is調査実施者等しい && is基本調査以外等しい && is基本調査等しい;
    }

    private void 更新処理(NinnteiChousaKekkaTouroku1Div div) {

        RString 現在の概況調査場所 = ViewStateHolder.get(ViewStateKeys.現在の概況調査場所, RString.class);
        RString 現在のサービス区分 = div.getRadGenzaiservis().getSelectedKey();
        RString temp_認定調査回数 = ViewStateHolder.get(ViewStateKeys.認定調査回数, RString.class);
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);

        RString 調査場所 = div.getTabChosaBasho().getSelectedItem().getTitle();
        RString 住宅改修 = div.getRadJutakuKaishu().getSelectedKey();
        RString 市町村特別給付TXT = div.getTxtShichosonTokubetsuKyufu().getValue();
        RString 介護保険給付以外の在宅サービスTXT = div.getTxtKyufuIgaiJutakuService().getValue();
        List<dgRiyoSerViceFirstHalf_Row> firstHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();

        List<NinnteiChousaKekkaTouroku1RowJoho> firstHalfJohoList = new ArrayList<>();
        NinnteiChousaKekkaTouroku1RowJoho firstHalfRow;
        if (firstHalf != null) {
            for (dgRiyoSerViceFirstHalf_Row row : firstHalf) {
                firstHalfRow = new NinnteiChousaKekkaTouroku1RowJoho();
                firstHalfRow.set利用状況(row.getServiceJokyo().getValue());
                firstHalfJohoList.add(firstHalfRow);
            }
        }
        List<NinnteiChousaKekkaTouroku1RowJoho> secondHalfJohoList = new ArrayList<>();
        NinnteiChousaKekkaTouroku1RowJoho secondHalfRow;
        if (secondHalf != null) {
            for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
                secondHalfRow = new NinnteiChousaKekkaTouroku1RowJoho();
                secondHalfRow.set利用状況(row.getServiceJokyo().getValue());
                secondHalfJohoList.add(secondHalfRow);
            }
        }
        List<NinnteiChousaKekkaTouroku1RowJoho> shisetsuJohoListJohoList = new ArrayList<>();
        NinnteiChousaKekkaTouroku1RowJoho shisetsuHalfRow;
        if (shisetsuList != null) {
            for (dgRiyoShisetsu_Row row : shisetsuList) {
                shisetsuHalfRow = new NinnteiChousaKekkaTouroku1RowJoho();
                shisetsuHalfRow.set施設利用フラグ(row.getShisetsuRiyoUmu());
                shisetsuJohoListJohoList.add(shisetsuHalfRow);
            }
        }
        NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho = new NinnteiChousaKekkaTouroku1RelateJoho();
        pageRelateJoho.set調査区分(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue());
        pageRelateJoho.set現在の概況調査場所(現在の概況調査場所);
        pageRelateJoho.set現在のサービス区分(現在のサービス区分);
        pageRelateJoho.setTemp_認定調査回数(temp_認定調査回数);
        pageRelateJoho.setTemp_申請書管理番号(temp_申請書管理番号);
        pageRelateJoho.setTemp_認定調査履歴番号(temp_認定調査履歴番号);
        pageRelateJoho.setTemp_厚労省IF識別コード(temp_厚労省IF識別コード);
        pageRelateJoho.set調査場所(調査場所);
        pageRelateJoho.set住宅改修(住宅改修);
        pageRelateJoho.set市町村特別給付TXT(市町村特別給付TXT);
        pageRelateJoho.set介護保険給付以外の在宅サービスTXT(介護保険給付以外の在宅サービスTXT);
        pageRelateJoho.setFirstHalf(firstHalfJohoList);
        pageRelateJoho.setSecondHalf(secondHalfJohoList);
        pageRelateJoho.setShisetsuList(shisetsuJohoListJohoList);
        pageRelateJoho.set介護給付サービス連番List(getHandler(div).get介護給付サービス連番List(temp_厚労省IF識別コード));
        pageRelateJoho.set予防給付サービス連番List(getHandler(div).get予防給付サービス連番List(temp_厚労省IF識別コード));
        pageRelateJoho.set施設利用連番List(getHandler(div).get施設利用連番List(temp_厚労省IF識別コード));
        pageRelateJoho.set第1群List(ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class));
        pageRelateJoho.set第2群List(ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class));
        pageRelateJoho.set第3群List(ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class));
        pageRelateJoho.set第4群List(ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class));
        pageRelateJoho.set第5群List(ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class));
        pageRelateJoho.set第6群List(ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class));
        pageRelateJoho.set第7群List(ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class));
        概況調査のデータ編集(div, pageRelateJoho);

        NinnteiChousaKekkaTouroku1Manager.createInstance().更新処理(pageRelateJoho);
    }

    private void 概況調査のデータ編集(NinnteiChousaKekkaTouroku1Div div, NinnteiChousaKekkaTouroku1RelateJoho pageRelateJoho) {
        RString temp_認定調査依頼区分コード = ViewStateHolder.get(ViewStateKeys.認定調査依頼区分コード, RString.class);

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

        pageRelateJoho.set認定調査依頼区分コード(new Code(temp_認定調査依頼区分コード));
        pageRelateJoho.set認定調査回数(1);
        pageRelateJoho.set認定調査実施年月日(new FlexibleDate(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getValue().toDateString()));
        pageRelateJoho.set認定調査受領年月日(FlexibleDate.getNowDate());
        pageRelateJoho.set認定調査区分コード(new Code(認定調査区分コード));
        pageRelateJoho.set認定調査委託先コード(new JigyoshaNo(div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedKey()));
        pageRelateJoho.set認定調査員コード(div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedKey());
        pageRelateJoho.set認定調査実施場所コード(new Code(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey()));
        pageRelateJoho.set認定調査実施場所名称(div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getValue());
        pageRelateJoho.set認定調査_サービス区分コード(new Code(サービス区分コード));
        pageRelateJoho.set利用施設名(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().getValue());
        pageRelateJoho.set利用施設住所(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().getDomain());
        pageRelateJoho.set利用施設電話番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().getDomain());
        pageRelateJoho.set利用施設郵便番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().getValue());
        pageRelateJoho.set特記(div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
        pageRelateJoho.set認定調査特記事項受付年月日(new FlexibleDate(RString.EMPTY));
        pageRelateJoho.set認定調査特記事項受領年月日(new FlexibleDate(RString.EMPTY));
    }

    private void set画面遷移パラメータ(NinnteiChousaKekkaTouroku1Div div) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        ViewStateHolder.put(ViewStateKeys.申請書管理番号, temp_申請書管理番号);
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, temp_認定調査履歴番号);
        ViewStateHolder.put(ViewStateKeys.調査実施日, div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText());
        ViewStateHolder.put(ViewStateKeys.調査実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.実施場所名称, div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getText());
        ViewStateHolder.put(ViewStateKeys.所属機関, div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.記入者, div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedValue());
        ViewStateHolder.put(ViewStateKeys.調査区分, div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getText());
    }

    /**
     * 入力内容を取り消します。
     */
    private void resetData(NinnteiChousaKekkaTouroku1Div div) {
        前排他キーの解除();
        div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().clearValue();
        div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().setSelectedKey(new RString("1"));
        div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().clearValue();
        div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().setSelectedKey(RString.EMPTY);
        div.getCcdChosaJisshishaJoho().getDdlKinyusha().setSelectedKey(RString.EMPTY);
        div.getCcdChosaJisshishaJoho().getTxtChosaKubun().clearValue();

        ViewStateHolder.put(ViewStateKeys.再調査の場合, Boolean.FALSE);
        ViewStateHolder.put(ViewStateKeys.初期の予防給付サービス, null);
        ViewStateHolder.put(ViewStateKeys.初期の介護給付サービス, null);
        ViewStateHolder.put(ViewStateKeys.住宅改修rad, null);
        ViewStateHolder.put(ViewStateKeys.市町村特別給付TXT, null);
        ViewStateHolder.put(ViewStateKeys.介護保険給付以外の在宅サービスTXT, null);
        ViewStateHolder.put(ViewStateKeys.初期の施設利用, null);
        ViewStateHolder.put(ViewStateKeys.初期の施設連絡先, null);
        ViewStateHolder.put(ViewStateKeys.特記, null);
        ViewStateHolder.put(ViewStateKeys.初期の基本調査, null);
        ViewStateHolder.put(ViewStateKeys.厚労省IF識別コード, null);
        ViewStateHolder.put(ViewStateKeys.認定調査依頼区分コード, null);
        ViewStateHolder.put(ViewStateKeys.認定調査回数, null);
        ViewStateHolder.put(ViewStateKeys.初期のサービス区分, null);
        ViewStateHolder.put(ViewStateKeys.現在のサービス区分, null);
        ViewStateHolder.put(ViewStateKeys.現在の概況調査場所, null);
        ViewStateHolder.put(ViewStateKeys.初期の概況調査場所, null);
        ViewStateHolder.put(ViewStateKeys.調査実施場所コード, null);

        ArrayList<KihonChosaInput> list = new ArrayList<>();
        ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, list);

        getHandler(div).利用サービス前半Gridのクリア();
        getHandler(div).利用サービス後半Gridのクリア();
        getHandler(div).住宅改修と記入項目のクリア();
        div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().clearValue();
        getHandler(div).施設tplのクリア();
    }

    private NinnteiChousaKekkaTouroku1Handler getHandler(NinnteiChousaKekkaTouroku1Div div) {
        return new NinnteiChousaKekkaTouroku1Handler(div);
    }

    private NinnteiChousaKekkaTouroku1ValidationHandler getValidationHandler() {
        return new NinnteiChousaKekkaTouroku1ValidationHandler();
    }

}
