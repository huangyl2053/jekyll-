/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020010;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010.NinteiChosaScheduleInputDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査スケジュール登録10のHandlerクラスです。
 *
 * @reamsid_L DBE-0020-060 lishengli
 */
public class NinteiChosaScheduleInputHandler {

    private static final RString 予約可 = new RString("0");
    private static final RString 予約不可 = new RString("1");
    private static final RString 予約可名 = new RString("t");
    private static final RString 予約不可名 = new RString("f");
    private static final RString 予約可_KEY = new RString("key0");
    private static final RString 予約不可_KEY = new RString("key1");
    private static final RString 予約状況_未定 = new RString("0");
    private static final RString 予約状況_仮予約 = new RString("1");
    private static final RString 予約状況_確定 = new RString("2");
    private static final RString 予約状況_未定名 = new RString("未定");
    private static final RString 予約状況_仮予約名 = new RString("仮予約");
    private static final RString 予約状況_確定名 = new RString("確定");
    private static final RString 予約状況_仮予約_KEY = new RString("key0");
    private static final RString 予約状況_確定_KEY = new RString("key1");
    private static final RString 予約状況_未定_KEY = new RString("key2");
    private static final RString モード_1 = new RString("1");
    private static final RString モード_2 = new RString("2");
    private static final RString モード_3 = new RString("3");
    private static final RString 枠数_1 = new RString("1");
    private static final RString 枠数_2 = new RString("2");
    private static final RString 枠数_3 = new RString("3");
    private static final RString 枠数_4 = new RString("4");
    private static final RString 枠数_5 = new RString("5");
    private static final RString 枠数_6 = new RString("6");
    private static final RString 枠数_7 = new RString("7");
    private static final RString 枠数_8 = new RString("8");
    private static final RString 枠数_9 = new RString("9");
    private static final RString 枠数_10 = new RString("10");
    private final NinteiChosaScheduleInputDiv div;
    private RString 予約可否;
    private RString 予約状況;
    private RString モード;
    private RString 時間枠;
    private FlexibleDate 設定日;
    private RString 認定調査員コード;
    private RString 認定調査委託先コード;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public NinteiChosaScheduleInputHandler(NinteiChosaScheduleInputDiv div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     *
     * @param temp_申請者管理番号3 temp_申請者管理番号3
     * @param temp_認定調査員名称 temp_認定調査員名称
     * @param temp_認定調査委託先名称 temp_認定調査委託先名称
     * @param temp_予約可否 temp_予約可否
     * @param temp_備考 temp_備考
     * @param temp_予約状況 temp_予約状況
     * @param temp_被保番号 temp_被保番号
     * @param temp_被保険者区分コード temp_被保険者区分コード
     * @param temp_保険者 temp_保険者
     * @param temp_認定申請日 temp_認定申請日
     * @param temp_申請区分_申請時 temp_申請区分_申請時
     * @param temp_氏名 temp_氏名
     * @param temp_カナ氏名 temp_カナ氏名
     * @param temp_場所 temp_場所
     * @param temp_駐車場 temp_駐車場
     * @param temp_立会人1 temp_立会人1
     * @param temp_連絡先1 temp_連絡先1
     * @param temp_立会人2 temp_立会人2
     * @param temp_連絡先2 temp_連絡先2
     * @param temp_対象者メモ temp_対象者メモ
     */
    public void onLoad(RString temp_申請者管理番号3, RString temp_認定調査員名称, RString temp_認定調査委託先名称, RString temp_予約可否,
            RString temp_備考, RString temp_予約状況, RString temp_被保番号, RString temp_被保険者区分コード, RString temp_保険者,
            FlexibleDate temp_認定申請日, RString temp_申請区分_申請時, RString temp_氏名, RString temp_カナ氏名, RString temp_場所,
            RString temp_駐車場, RString temp_立会人1, RString temp_連絡先1, RString temp_立会人2, RString temp_連絡先2, RString temp_対象者メモ) {
        予約可否 = get予約可のKEY(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_予約可否, RString.class));
        予約状況 = get予約状況のKEY(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_予約状況, RString.class));
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        認定調査員コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査員コード, RString.class);
        認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, RString.class);
        時間枠 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_時間枠, RString.class);
        設定日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
        if (モード_1.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_対象者を検索するモード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録10_対象者を検索するモード, RString.EMPTY);
            boolean 状態 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_認定調査員コード状態, boolean.class);
            boolean 予約可否状態 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_予約可否状態, boolean.class);
            boolean 備考状態 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_備考状態, boolean.class);
            boolean 予約状況状態 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_予約状況状態, boolean.class);
            boolean 被保番号状態 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_被保番号状態, boolean.class);
            boolean 場所状態 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_場所状態, boolean.class);
            div.getWariateJokyo().getTxtNinteiChosainCode().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_認定調査員コード値, RString.class)));
            div.getWariateJokyo().getTxtNinteiChosainName().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_認定調査員氏名値, RString.class)));
            div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_認定調査委託先コード値, RString.class)));
            div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_認定調査委託先名称値, RString.class)));
            div.getWariateJokyo().getTxtNinteiChosaDate().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_調査日値, FlexibleDate.class)));
            div.getWariateJokyo().getTxtNinteiChosaTime().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_調査日時値, RString.class)));
            div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_時間枠値, RString.class)));
            div.getWariateJokyo().getRadYoyakuKahi().setSelectedKey(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_予約可否値, RString.class)));
            div.getWariateJokyo().getTxtNinteiChosaBiko().setValue(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_認定調査員コード値, RString.class)));
            div.getWariateJokyo().getRadYoyakuJokyo().setSelectedKey(
                    chickNull(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_予約状況値, RString.class)));
            div.getButtonArea().getBtnSearchTaishosha().setVisible(true);
            div.getButtonArea().getBtnDisplayLatestInformation().setVisible(true);
            div.getButtonArea().getBtnSearchTaishosha().setDisabled(false);
            div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(false);
            div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(状態);
            div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(状態);
            div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(状態);
            div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(状態);
            div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(状態);
            div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(状態);
            div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(状態);
            div.getWariateJokyo().getRadYoyakuKahi().setDisabled(予約可否状態);
            div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(備考状態);
            div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(予約状況状態);
            set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                    temp_カナ氏名, ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_場所値, RString.class),
                    ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_駐車場値, RString.class),
                    ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_立会人１値, RString.class),
                    ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_連絡先１値, RString.class),
                    ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_立会人２値, RString.class),
                    ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_連絡先２値, RString.class),
                    ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録10_対象者メモ値, RString.class));
            div.getTaishoshaShosai().getTxtHihoBangoNumber().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtHihoBangoGosu().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtHokenshaName().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtNinteiShinseiDate().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtNinteiShinseiKubun().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtTaishoshaName().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtTaishoshaNameKana().setDisabled(被保番号状態);
            div.getTaishoshaShosai().getTxtBasho().setDisabled(場所状態);
            div.getTaishoshaShosai().getTxtChushajo().setDisabled(場所状態);
            div.getTaishoshaShosai().getTxtTachiainin1().setDisabled(場所状態);
            div.getTaishoshaShosai().getTxtRenrakusaki1().setDisabled(場所状態);
            div.getTaishoshaShosai().getTxtTachiainin2().setDisabled(場所状態);
            div.getTaishoshaShosai().getTxtRenrakusaki2().setDisabled(場所状態);
            div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().setDisabled(場所状態);
            div.getTaishoshaShosai().getBtnClear().setVisible(true);
            div.getTaishoshaShosai().getBtnClear().setDisabled(false);
        } else {
            onLoad_モード1_2_3(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況,
                    temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名, temp_カナ氏名,
                    temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
            getボタン状態(temp_申請者管理番号3);
        }
    }

    private RString chickNull(RString temp) {
        return temp == null ? RString.EMPTY : temp;
    }

    private FlexibleDate chickNull(FlexibleDate temp) {
        return temp == null ? FlexibleDate.EMPTY : temp;
    }

    private void getボタン状態(RString temp_申請者管理番号3) {
        if (div.getButtonArea().getBtnDisplayLatestInformation().isVisible()) {
            if (!RString.isNullOrEmpty(temp_申請者管理番号3)) {
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(false);
            } else {
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(true);
            }
        }
        if (予約不可.equals(予約可否)) {
            if (div.getButtonArea().getBtnSearchTaishosha().isVisible()) {
                div.getButtonArea().getBtnSearchTaishosha().setDisabled(true);
            }
            if (div.getButtonArea().getBtnDisplayLatestInformation().isVisible()) {
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(true);
            }
        }
    }

    private void onLoad_モード1_2_3(RString temp_認定調査員名称, RString temp_認定調査委託先名称, RString temp_予約可否,
            RString temp_備考, RString temp_予約状況, RString temp_被保番号, RString temp_被保険者区分コード, RString temp_保険者,
            FlexibleDate temp_認定申請日, RString temp_申請区分_申請時, RString temp_氏名, RString temp_カナ氏名, RString temp_場所,
            RString temp_駐車場, RString temp_立会人1, RString temp_連絡先1, RString temp_立会人2, RString temp_連絡先2, RString temp_対象者メモ) {
        if (モード_1.equals(モード)) {
            if (予約不可.equals(予約可否)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuKahi().setDisabled(false);
                div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(false);
                div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(true);
                div.getButtonArea().getBtnSearchTaishosha().setDisabled(true);
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(true);
                div.getTaishoshaShosai().setDisabled(true);
                div.getTaishoshaShosai().getBtnClear().setDisabled(true);
            } else if (予約可.equals(予約可否) && 予約状況_未定.equals(予約状況)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuKahi().setDisabled(false);
                div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(false);
                div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(false);
                div.getButtonArea().getBtnSearchTaishosha().setDisabled(false);
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(true);
                set対象者詳細Grid状態();
            } else if (予約可.equals(予約可否) && (予約状況_仮予約.equals(予約状況) || 予約状況_確定.equals(予約状況))) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuKahi().setDisabled(false);
                div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(false);
                div.getButtonArea().getBtnSearchTaishosha().setDisabled(false);
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                set対象者詳細Grid状態();
            }
        } else if (モード_2.equals(モード)) {
            onLoad_モード2(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況,
                    temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名, temp_カナ氏名,
                    temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
        } else if (モード_3.equals(モード)) {
            if (予約可.equals(予約可否) && 予約状況_未定.equals(予約状況)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuKahi().setDisabled(false);
                div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(false);
                div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(false);
                div.getButtonArea().getBtnSearchTaishosha().setVisible(false);
                div.getButtonArea().getBtnDisplayLatestInformation().setDisabled(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                set対象者詳細Grid状態();
                div.getTaishoshaShosai().getBtnClear().setVisible(false);
            } else if (予約可.equals(予約可否) && (予約状況_仮予約.equals(予約状況) || 予約状況_確定.equals(予約状況))) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuKahi().setDisabled(false);
                div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(false);
                div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(false);
                div.getButtonArea().getBtnSearchTaishosha().setVisible(false);
                div.getButtonArea().getBtnDisplayLatestInformation().setVisible(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                set対象者詳細Grid状態();
                div.getTaishoshaShosai().getBtnClear().setVisible(false);
            } else if (予約不可.equals(予約可否)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuKahi().setDisabled(true);
                div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(true);
                div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(true);
                div.getButtonArea().getBtnSearchTaishosha().setVisible(false);
                div.getButtonArea().getBtnDisplayLatestInformation().setVisible(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                div.getTaishoshaShosai().getTxtHihoBangoNumber().setDisabled(true);
                div.getTaishoshaShosai().getTxtHihoBangoGosu().setDisabled(true);
                div.getTaishoshaShosai().getTxtHokenshaName().setDisabled(true);
                div.getTaishoshaShosai().getTxtNinteiShinseiDate().setDisabled(true);
                div.getTaishoshaShosai().getTxtNinteiShinseiKubun().setDisabled(true);
                div.getTaishoshaShosai().getTxtTaishoshaName().setDisabled(true);
                div.getTaishoshaShosai().getTxtTaishoshaNameKana().setDisabled(true);
                div.getTaishoshaShosai().getTxtBasho().setDisabled(true);
                div.getTaishoshaShosai().getTxtChushajo().setDisabled(true);
                div.getTaishoshaShosai().getTxtTachiainin1().setDisabled(true);
                div.getTaishoshaShosai().getTxtRenrakusaki1().setDisabled(true);
                div.getTaishoshaShosai().getTxtTachiainin2().setDisabled(true);
                div.getTaishoshaShosai().getTxtRenrakusaki2().setDisabled(true);
                div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().setDisabled(true);
                div.getTaishoshaShosai().getBtnClear().setVisible(false);
            }
        }
    }

    private void onLoad_モード2(RString temp_認定調査員名称, RString temp_認定調査委託先名称, RString temp_予約可否,
            RString temp_備考, RString temp_予約状況, RString temp_被保番号, RString temp_被保険者区分コード, RString temp_保険者,
            FlexibleDate temp_認定申請日, RString temp_申請区分_申請時, RString temp_氏名, RString temp_カナ氏名, RString temp_場所,
            RString temp_駐車場, RString temp_立会人1, RString temp_連絡先1, RString temp_立会人2, RString temp_連絡先2, RString temp_対象者メモ) {
        set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
        div.getWariateJokyo().getTxtNinteiChosainCode().setDisabled(true);
        div.getWariateJokyo().getTxtNinteiChosainName().setDisabled(true);
        div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setDisabled(true);
        div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setDisabled(true);
        div.getWariateJokyo().getTxtNinteiChosaDate().setDisabled(true);
        div.getWariateJokyo().getTxtNinteiChosaTime().setDisabled(true);
        div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setDisabled(true);
        div.getWariateJokyo().getRadYoyakuKahi().setDisabled(false);
        div.getWariateJokyo().getTxtNinteiChosaBiko().setDisabled(true);
        div.getWariateJokyo().getRadYoyakuJokyo().setDisabled(false);
        div.getButtonArea().getBtnSearchTaishosha().setVisible(false);
        div.getButtonArea().getBtnDisplayLatestInformation().setVisible(false);
        set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
        div.getTaishoshaShosai().getTxtHihoBangoNumber().setDisabled(true);
        div.getTaishoshaShosai().getTxtHihoBangoGosu().setDisabled(true);
        div.getTaishoshaShosai().getTxtHokenshaName().setDisabled(true);
        div.getTaishoshaShosai().getTxtNinteiShinseiDate().setDisabled(true);
        div.getTaishoshaShosai().getTxtNinteiShinseiKubun().setDisabled(true);
        div.getTaishoshaShosai().getTxtTaishoshaName().setDisabled(true);
        div.getTaishoshaShosai().getTxtTaishoshaNameKana().setDisabled(true);
        div.getTaishoshaShosai().getTxtBasho().setDisabled(true);
        div.getTaishoshaShosai().getTxtChushajo().setDisabled(true);
        div.getTaishoshaShosai().getTxtTachiainin1().setDisabled(true);
        div.getTaishoshaShosai().getTxtRenrakusaki1().setDisabled(true);
        div.getTaishoshaShosai().getTxtTachiainin2().setDisabled(true);
        div.getTaishoshaShosai().getTxtRenrakusaki2().setDisabled(true);
        div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().setDisabled(true);
        div.getTaishoshaShosai().getBtnClear().setVisible(false);
    }

    private void set対象者詳細Grid状態() {
        div.getTaishoshaShosai().getTxtHihoBangoNumber().setDisabled(true);
        div.getTaishoshaShosai().getTxtHihoBangoGosu().setDisabled(true);
        div.getTaishoshaShosai().getTxtHokenshaName().setDisabled(true);
        div.getTaishoshaShosai().getTxtNinteiShinseiDate().setDisabled(true);
        div.getTaishoshaShosai().getTxtNinteiShinseiKubun().setDisabled(true);
        div.getTaishoshaShosai().getTxtTaishoshaName().setDisabled(true);
        div.getTaishoshaShosai().getTxtTaishoshaNameKana().setDisabled(true);
        div.getTaishoshaShosai().getTxtBasho().setDisabled(false);
        div.getTaishoshaShosai().getTxtChushajo().setDisabled(false);
        div.getTaishoshaShosai().getTxtTachiainin1().setDisabled(false);
        div.getTaishoshaShosai().getTxtRenrakusaki1().setDisabled(false);
        div.getTaishoshaShosai().getTxtTachiainin2().setDisabled(false);
        div.getTaishoshaShosai().getTxtRenrakusaki2().setDisabled(false);
        div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().setDisabled(false);
        div.getTaishoshaShosai().getBtnClear().setDisabled(false);
    }

    private void set割当状況Grid値(RString temp_認定調査員名称, RString temp_認定調査委託先名称,
            RString temp_予約可否, RString temp_備考, RString temp_予約状況) {
        div.getWariateJokyo().getTxtNinteiChosainCode().setValue(認定調査員コード == null ? RString.EMPTY : 認定調査員コード);
        div.getWariateJokyo().getTxtNinteiChosainName().setValue(temp_認定調査員名称 == null ? RString.EMPTY : temp_認定調査員名称);
        div.getWariateJokyo().getTxtNinteiChosaItakusakiCode().setValue(認定調査委託先コード == null ? RString.EMPTY : 認定調査委託先コード);
        div.getWariateJokyo().getTxtNinteiChosaItakusakiName().setValue(temp_認定調査委託先名称 == null ? RString.EMPTY : temp_認定調査委託先名称);
        div.getWariateJokyo().getTxtNinteiChosaDate().setValue(設定日 == null ? FlexibleDate.EMPTY : 設定日);
        div.getWariateJokyo().getTxtNinteiChosaTime().setValue(get調査日時(時間枠));
        div.getWariateJokyo().getTxtNinteiChosaTimeFrame().setValue(時間枠 == null ? RString.EMPTY : 時間枠);
        if (予約可.equals(temp_予約可否)) {
            div.getWariateJokyo().getRadYoyakuKahi().setSelectedKey(予約可_KEY);
        } else {
            div.getWariateJokyo().getRadYoyakuKahi().setSelectedKey(予約不可_KEY);
        }
        div.getWariateJokyo().getTxtNinteiChosaBiko().setValue(temp_備考 == null ? RString.EMPTY : temp_備考);
        if (予約状況_未定.equals(temp_予約状況)) {
            div.getWariateJokyo().getRadYoyakuJokyo().setSelectedKey(予約状況_未定_KEY);
        } else if (予約状況_仮予約.equals(temp_予約状況)) {
            div.getWariateJokyo().getRadYoyakuJokyo().setSelectedKey(予約状況_仮予約_KEY);
        } else {
            div.getWariateJokyo().getRadYoyakuJokyo().setSelectedKey(予約状況_確定_KEY);
        }
    }

    private void set対象者詳細Grid値(RString temp_被保番号, RString temp_被保険者区分コード, RString temp_保険者, FlexibleDate temp_認定申請日,
            RString temp_申請区分_申請時, RString temp_氏名, RString temp_カナ氏名, RString temp_場所, RString temp_駐車場, RString temp_立会人1,
            RString temp_連絡先1, RString temp_立会人2, RString temp_連絡先2, RString temp_対象者メモ) {
        div.getTaishoshaShosai().getTxtHihoBangoNumber().setValue(temp_被保番号 == null ? RString.EMPTY : temp_被保番号);
        div.getTaishoshaShosai().getTxtHihoBangoGosu().setValue(temp_被保険者区分コード == null ? RString.EMPTY : temp_被保険者区分コード);
        div.getTaishoshaShosai().getTxtHokenshaName().setValue(temp_保険者 == null ? RString.EMPTY : temp_保険者);
        div.getTaishoshaShosai().getTxtNinteiShinseiDate().setValue(temp_認定申請日 == null ? FlexibleDate.EMPTY : temp_認定申請日);
        div.getTaishoshaShosai().getTxtNinteiShinseiKubun().setValue(get申請区分(temp_申請区分_申請時));
        div.getTaishoshaShosai().getTxtTaishoshaName().setValue(temp_氏名 == null ? RString.EMPTY : temp_氏名);
        div.getTaishoshaShosai().getTxtTaishoshaNameKana().setValue(temp_カナ氏名 == null ? RString.EMPTY : temp_カナ氏名);
        div.getTaishoshaShosai().getTxtBasho().setValue(temp_場所 == null ? RString.EMPTY : temp_場所);
        div.getTaishoshaShosai().getTxtChushajo().setValue(temp_駐車場 == null ? RString.EMPTY : temp_駐車場);
        div.getTaishoshaShosai().getTxtTachiainin1().setValue(temp_立会人1 == null ? RString.EMPTY : temp_立会人1);
        div.getTaishoshaShosai().getTxtRenrakusaki1().setValue(temp_連絡先1 == null ? RString.EMPTY : temp_連絡先1);
        div.getTaishoshaShosai().getTxtTachiainin2().setValue(temp_立会人2 == null ? RString.EMPTY : temp_立会人2);
        div.getTaishoshaShosai().getTxtRenrakusaki2().setValue(temp_連絡先2 == null ? RString.EMPTY : temp_連絡先2);
        div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().setValue(temp_対象者メモ == null ? RString.EMPTY : temp_対象者メモ);
    }

    private RString get申請区分(RString 申請区分) {
        if (!RString.isNullOrEmpty(申請区分)) {
            return NinteiShinseiShinseijiKubunCode.toValue(申請区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get調査日時(RString 時間枠) {
        RString 調査日時 = RString.EMPTY;
        if (枠数_1.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠1, SubGyomuCode.DBE認定支援);
        }
        if (枠数_2.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠2, SubGyomuCode.DBE認定支援);
        }
        if (枠数_3.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠3, SubGyomuCode.DBE認定支援);
        }
        if (枠数_4.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠4, SubGyomuCode.DBE認定支援);
        }
        if (枠数_5.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠5, SubGyomuCode.DBE認定支援);
        }
        if (枠数_6.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠6, SubGyomuCode.DBE認定支援);
        }
        if (枠数_7.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠7, SubGyomuCode.DBE認定支援);
        }
        if (枠数_8.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠8, SubGyomuCode.DBE認定支援);
        }
        if (枠数_9.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠9, SubGyomuCode.DBE認定支援);
        }
        if (枠数_10.equals(時間枠)) {
            調査日時 = BusinessConfig.get(ConfigNameDBE.調査スケジュール時間枠10, SubGyomuCode.DBE認定支援);
        }
        return 調査日時;
    }

    /**
     * 前回情報を表示するボタン処理です。
     *
     * @param list List<認定調査スケジュール情報>
     */
    public void btnZenkayiJyoho(List<NinteichosaSchedule> list) {
        if (list != null && !list.isEmpty()) {
            div.getTaishoshaShosai().getTxtBasho().setValue(list.get(0).get場所());
            div.getTaishoshaShosai().getTxtChushajo().setValue(list.get(0).get駐車場());
            div.getTaishoshaShosai().getTxtTachiainin1().setValue(list.get(0).get立会人１());
            div.getTaishoshaShosai().getTxtRenrakusaki1().setValue(get連絡先(list.get(0).get連絡先１()));
            div.getTaishoshaShosai().getTxtTachiainin2().setValue(list.get(0).get立会人２());
            div.getTaishoshaShosai().getTxtRenrakusaki2().setValue(get連絡先(list.get(0).get連絡先２()));
            div.getTaishoshaShosai().getTxtTaishoshaShosaiMemo().setValue(list.get(0).get対象者メモ());
        }
    }

    private RString get連絡先(TelNo 連絡先) {
        return 連絡先 == null ? RString.EMPTY : 連絡先.value();
    }

    private RString get予約状況のKEY(RString 予約状況) {
        if (予約状況_未定名.equals(予約状況)) {
            return 予約状況_未定;
        } else if (予約状況_仮予約名.equals(予約状況)) {
            return 予約状況_仮予約;
        } else if (予約状況_確定名.equals(予約状況)) {
            return 予約状況_確定;
        }
        return 予約状況;
    }

    private RString get予約可のKEY(RString 予約可否) {
        if (予約可名.equals(予約可否)) {
            return 予約可;
        } else if (予約不可名.equals(予約可否)) {
            return 予約不可;
        }
        return 予約可否;
    }
}
