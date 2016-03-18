/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020010;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010.NinteiChosaScheduleInputDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 認定調査スケジュール登録10のHandlerクラスです。
 */
public class NinteiChosaScheduleInputHandler {

    private static final RString 予約可 = new RString("0");
    private static final RString 予約不可 = new RString("1");
    private static final RString 予約可_KEY = new RString("key0");
    private static final RString 予約不可_KEY = new RString("key1");
    private static final RString 予約状況_未定 = new RString("0");
    private static final RString 予約状況_仮予約 = new RString("1");
    private static final RString 予約状況_確定 = new RString("2");
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
        予約可否 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_予約可否, RString.class);
        予約状況 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_予約状況, RString.class);
        モード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class);
        認定調査員コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査員コード, RString.class);
        認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_認定調査委託先コード, RString.class);
        時間枠 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_時間枠, RString.class);
        設定日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
        if (モード_1.equals(モード)) {
            if (予約不可.equals(予約可否)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getTxtNinteiChosainCode().setDisabled(true);
                div.getTxtNinteiChosainName().setDisabled(true);
                div.getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getTxtNinteiChosaDate().setDisabled(true);
                div.getTxtNinteiChosaTime().setDisabled(true);
                div.getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getRadYoyakuKahi().setDisabled(false);
                div.getTxtNinteiChosaBiko().setDisabled(false);
                div.getRadYoyakuJokyo().setDisabled(true);
                div.getBtnSearchTaishosha().setDisabled(true);
                div.getBtnDisplayLatestInformation().setDisabled(true);
                div.getTaishoshaShosai().setDisabled(true);
                div.getBtnClear().setDisabled(true);
            }
            if (予約可.equals(予約可否) && 予約状況_未定.equals(予約状況)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getTxtNinteiChosainCode().setDisabled(true);
                div.getTxtNinteiChosainName().setDisabled(true);
                div.getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getTxtNinteiChosaDate().setDisabled(true);
                div.getTxtNinteiChosaTime().setDisabled(true);
                div.getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getRadYoyakuKahi().setDisabled(false);
                div.getTxtNinteiChosaBiko().setDisabled(false);
                div.getRadYoyakuJokyo().setDisabled(false);
                div.getBtnSearchTaishosha().setDisabled(false);
                div.getBtnDisplayLatestInformation().setDisabled(true);
                set対象者詳細Grid状態();
            }
            if (予約可.equals(予約可否) && (予約状況_仮予約.equals(予約状況) || 予約状況_確定.equals(予約状況))) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getTxtNinteiChosainCode().setDisabled(true);
                div.getTxtNinteiChosainName().setDisabled(true);
                div.getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getTxtNinteiChosaDate().setDisabled(true);
                div.getTxtNinteiChosaTime().setDisabled(true);
                div.getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getRadYoyakuKahi().setDisabled(false);
                div.getTxtNinteiChosaBiko().setDisabled(true);
                div.getRadYoyakuJokyo().setDisabled(false);
                div.getBtnSearchTaishosha().setDisabled(false);
                div.getBtnDisplayLatestInformation().setDisabled(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                set対象者詳細Grid状態();
            }
        }
        onLoad_モード_2_3(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況,
                temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名, temp_カナ氏名,
                temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
        if (div.getBtnSearchTaishosha().isVisible()) {
            if (!RString.isNullOrEmpty(temp_申請者管理番号3)) {
                div.getBtnDisplayLatestInformation().setDisabled(false);
            } else {
                div.getBtnDisplayLatestInformation().setDisabled(true);
            }
        }
    }

    private void onLoad_モード_2_3(RString temp_認定調査員名称, RString temp_認定調査委託先名称, RString temp_予約可否,
            RString temp_備考, RString temp_予約状況, RString temp_被保番号, RString temp_被保険者区分コード, RString temp_保険者,
            FlexibleDate temp_認定申請日, RString temp_申請区分_申請時, RString temp_氏名, RString temp_カナ氏名, RString temp_場所,
            RString temp_駐車場, RString temp_立会人1, RString temp_連絡先1, RString temp_立会人2, RString temp_連絡先2, RString temp_対象者メモ) {
        if (モード_2.equals(モード)) {
            set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
            div.getTxtNinteiChosainCode().setDisabled(true);
            div.getTxtNinteiChosainName().setDisabled(true);
            div.getTxtNinteiChosaItakusakiCode().setDisabled(true);
            div.getTxtNinteiChosaItakusakiName().setDisabled(true);
            div.getTxtNinteiChosaDate().setDisabled(true);
            div.getTxtNinteiChosaTime().setDisabled(true);
            div.getTxtNinteiChosaTimeFrame().setDisabled(true);
            div.getRadYoyakuKahi().setDisabled(false);
            div.getTxtNinteiChosaBiko().setDisabled(true);
            div.getRadYoyakuJokyo().setDisabled(false);
            div.getBtnSearchTaishosha().setVisible(false);
            div.getBtnDisplayLatestInformation().setVisible(false);
            set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                    temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
            div.getTxtHihoBangoNumber().setDisabled(true);
            div.getTxtHihoBangoGosu().setDisabled(true);
            div.getTxtHokenshaName().setDisabled(true);
            div.getTxtNinteiShinseiDate().setDisabled(true);
            div.getTxtNinteiShinseiKubun().setDisabled(true);
            div.getTxtTaishoshaName().setDisabled(true);
            div.getTxtTaishoshaNameKana().setDisabled(true);
            div.getTxtBasho().setDisabled(true);
            div.getTxtChushajo().setDisabled(true);
            div.getTxtTachiainin1().setDisabled(true);
            div.getTxtRenrakusaki1().setDisabled(true);
            div.getTxtTachiainin2().setDisabled(true);
            div.getTxtRenrakusaki2().setDisabled(true);
            div.getTxtTaishoshaShosaiMemo().setDisabled(true);
            div.getBtnClear().setVisible(false);
        }
        if (モード_3.equals(モード)) {
            if (予約可.equals(予約可否) && 予約状況_未定.equals(予約状況)) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getTxtNinteiChosainCode().setDisabled(true);
                div.getTxtNinteiChosainName().setDisabled(true);
                div.getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getTxtNinteiChosaDate().setDisabled(true);
                div.getTxtNinteiChosaTime().setDisabled(true);
                div.getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getRadYoyakuKahi().setDisabled(false);
                div.getTxtNinteiChosaBiko().setDisabled(false);
                div.getRadYoyakuJokyo().setDisabled(false);
                div.getBtnSearchTaishosha().setVisible(false);
                div.getBtnDisplayLatestInformation().setDisabled(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                set対象者詳細Grid状態();
                div.getBtnClear().setVisible(false);
            }
            if (予約不可.equals(予約可否) && (予約状況_仮予約.equals(予約状況) || 予約状況_確定.equals(予約状況))) {
                set割当状況Grid値(temp_認定調査員名称, temp_認定調査委託先名称, temp_予約可否, temp_備考, temp_予約状況);
                div.getTxtNinteiChosainCode().setDisabled(true);
                div.getTxtNinteiChosainName().setDisabled(true);
                div.getTxtNinteiChosaItakusakiCode().setDisabled(true);
                div.getTxtNinteiChosaItakusakiName().setDisabled(true);
                div.getTxtNinteiChosaDate().setDisabled(true);
                div.getTxtNinteiChosaTime().setDisabled(true);
                div.getTxtNinteiChosaTimeFrame().setDisabled(true);
                div.getRadYoyakuKahi().setDisabled(true);
                div.getTxtNinteiChosaBiko().setDisabled(true);
                div.getRadYoyakuJokyo().setDisabled(true);
                div.getBtnSearchTaishosha().setVisible(false);
                div.getBtnDisplayLatestInformation().setVisible(false);
                set対象者詳細Grid値(temp_被保番号, temp_被保険者区分コード, temp_保険者, temp_認定申請日, temp_申請区分_申請時, temp_氏名,
                        temp_カナ氏名, temp_場所, temp_駐車場, temp_立会人1, temp_連絡先1, temp_立会人2, temp_連絡先2, temp_対象者メモ);
                div.getTxtHihoBangoNumber().setDisabled(true);
                div.getTxtHihoBangoGosu().setDisabled(true);
                div.getTxtHokenshaName().setDisabled(true);
                div.getTxtNinteiShinseiDate().setDisabled(true);
                div.getTxtNinteiShinseiKubun().setDisabled(true);
                div.getTxtTaishoshaName().setDisabled(true);
                div.getTxtTaishoshaNameKana().setDisabled(true);
                div.getTxtBasho().setDisabled(true);
                div.getTxtChushajo().setDisabled(true);
                div.getTxtTachiainin1().setDisabled(true);
                div.getTxtRenrakusaki1().setDisabled(true);
                div.getTxtTachiainin2().setDisabled(true);
                div.getTxtRenrakusaki2().setDisabled(true);
                div.getTxtTaishoshaShosaiMemo().setDisabled(true);
                div.getBtnClear().setVisible(false);
            }
        }
    }

    private void set対象者詳細Grid状態() {
        div.getTxtHihoBangoNumber().setDisabled(true);
        div.getTxtHihoBangoGosu().setDisabled(true);
        div.getTxtHokenshaName().setDisabled(true);
        div.getTxtNinteiShinseiDate().setDisabled(true);
        div.getTxtNinteiShinseiKubun().setDisabled(true);
        div.getTxtTaishoshaName().setDisabled(true);
        div.getTxtTaishoshaNameKana().setDisabled(true);
        div.getTxtBasho().setDisabled(false);
        div.getTxtChushajo().setDisabled(false);
        div.getTxtTachiainin1().setDisabled(false);
        div.getTxtRenrakusaki1().setDisabled(false);
        div.getTxtTachiainin2().setDisabled(false);
        div.getTxtRenrakusaki2().setDisabled(false);
        div.getTxtTaishoshaShosaiMemo().setDisabled(false);
        div.getBtnClear().setDisabled(false);
    }

    private void set割当状況Grid値(RString temp_認定調査員名称, RString temp_認定調査委託先名称,
            RString temp_予約可否, RString temp_備考, RString temp_予約状況) {
        div.getTxtNinteiChosainCode().setValue(認定調査員コード == null ? RString.EMPTY : 認定調査員コード);
        div.getTxtNinteiChosainName().setValue(temp_認定調査員名称 == null ? RString.EMPTY : temp_認定調査員名称);
        div.getTxtNinteiChosaItakusakiCode().setValue(認定調査委託先コード == null ? RString.EMPTY : 認定調査委託先コード);
        div.getTxtNinteiChosaItakusakiName().setValue(temp_認定調査委託先名称 == null ? RString.EMPTY : temp_認定調査委託先名称);
        div.getTxtNinteiChosaDate().setValue(設定日 == null ? FlexibleDate.EMPTY : 設定日);
        div.getTxtNinteiChosaTime().setValue(get調査日時(時間枠));
        div.getTxtNinteiChosaTimeFrame().setValue(時間枠 == null ? RString.EMPTY : 時間枠);
        if (予約可.equals(temp_予約可否)) {
            div.getRadYoyakuKahi().setSelectedKey(予約可_KEY);
        } else {
            div.getRadYoyakuKahi().setSelectedKey(予約不可_KEY);
        }
        div.getTxtNinteiChosaBiko().setValue(temp_備考 == null ? RString.EMPTY : temp_備考);
        if (予約状況_未定.equals(temp_予約状況)) {
            div.getRadYoyakuJokyo().setSelectedKey(予約状況_未定_KEY);
        } else if (予約状況_仮予約.equals(temp_予約状況)) {
            div.getRadYoyakuJokyo().setSelectedKey(予約状況_仮予約_KEY);
        } else {
            div.getRadYoyakuJokyo().setSelectedKey(予約状況_確定_KEY);
        }
    }

    private void set対象者詳細Grid値(RString temp_被保番号, RString temp_被保険者区分コード, RString temp_保険者, FlexibleDate temp_認定申請日,
            RString temp_申請区分_申請時, RString temp_氏名, RString temp_カナ氏名, RString temp_場所, RString temp_駐車場, RString temp_立会人1,
            RString temp_連絡先1, RString temp_立会人2, RString temp_連絡先2, RString temp_対象者メモ) {
        div.getTxtHihoBangoNumber().setValue(temp_被保番号 == null ? RString.EMPTY : temp_被保番号);
        div.getTxtHihoBangoGosu().setValue(temp_被保険者区分コード == null ? RString.EMPTY : temp_被保険者区分コード);
        div.getTxtHokenshaName().setValue(temp_保険者 == null ? RString.EMPTY : temp_保険者);
        div.getTxtNinteiShinseiDate().setValue(temp_認定申請日 == null ? FlexibleDate.EMPTY : temp_認定申請日);
        div.getTxtNinteiShinseiKubun().setValue(temp_申請区分_申請時 == null ? RString.EMPTY : temp_申請区分_申請時);
        div.getTxtTaishoshaName().setValue(temp_氏名 == null ? RString.EMPTY : temp_氏名);
        div.getTxtTaishoshaNameKana().setValue(temp_カナ氏名 == null ? RString.EMPTY : temp_カナ氏名);
        div.getTxtBasho().setValue(temp_場所 == null ? RString.EMPTY : temp_場所);
        div.getTxtChushajo().setValue(temp_駐車場 == null ? RString.EMPTY : temp_駐車場);
        div.getTxtTachiainin1().setValue(temp_立会人1 == null ? RString.EMPTY : temp_立会人1);
        div.getTxtRenrakusaki1().setValue(temp_連絡先1 == null ? RString.EMPTY : temp_連絡先1);
        div.getTxtTachiainin2().setValue(temp_立会人2 == null ? RString.EMPTY : temp_立会人2);
        div.getTxtRenrakusaki2().setValue(temp_連絡先2 == null ? RString.EMPTY : temp_連絡先2);
        div.getTxtTaishoshaShosaiMemo().setValue(temp_対象者メモ == null ? RString.EMPTY : temp_対象者メモ);
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

        div.getTxtBasho().setValue(list.get(0).get場所());
        div.getTxtChushajo().setValue(list.get(0).get駐車場());
        div.getTxtTachiainin1().setValue(list.get(0).get立会人１());
        div.getTxtRenrakusaki1().setValue(list.get(0).get連絡先１().value());
        div.getTxtTachiainin2().setValue(list.get(0).get立会人２());
        div.getTxtRenrakusaki2().setValue(list.get(0).get連絡先２().value());
        div.getTxtTaishoshaShosaiMemo().setValue(list.get(0).get対象者メモ());
    }
}
