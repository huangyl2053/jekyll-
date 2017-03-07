/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会共有一覧のパラメータクラス。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiKaisaiParameter {

    private static final RString 割付未完了のみ = new RString("割付未完了分のみ");
    private static final RString 未開催分のみ = new RString("未開催分のみ");
    private static final RString 審査会未完了のみ = new RString("審査会未完了分のみ");
    private static final RString 審査会完了のみ = new RString("審査会完了分のみ");
    private static final RString 審査会未開催分のみ = new RString("審査会未開催分のみ");
    public static final RString 全ての審査会 = new RString("全ての審査会");
    private static final RString 結果登録審査会未完了のみ = new RString("結果登録審査会未完了のみ");
    private static final RString 表示しない = new RString("表示しない");
    private static final RString 開催予定登録 = new RString("kaisaiYoteiToroku");
    private static final RString 対象者割付 = new RString("taishoshaWaritsuke");
    private static final RString モード_対象者割付_自動割付使用不可 = new RString("taishoshaWaritsuke_UnUseAutoWaritsuke");
    private final RString 表示期間From;
    private final RString 表示期間To;
    private final RString モード;
    private final RString 表示条件;
    private final RString ダミー審査会;
    private final Decimal saidaiHyojiKensu;
    private final boolean is割付未完了のみ;
    private final boolean is未開催分のみ;
    private final boolean is審査会未完了のみ;
    private final boolean is結果登録審査会未完了のみ;
    private final boolean is審査会完了のみ;
    private final boolean is開催予定登録OR対象者割付;
    private final boolean is表示しない;
    private final boolean is審査会未開催分のみ;
    private final RString 審査会開催番号;

    /**
     * コンストラクタです。
     *
     * @param 表示期間From 表示期間From
     * @param 表示期間To 表示期間To
     * @param モード モード
     * @param 表示条件 表示条件
     * @param ダミー審査会 ダミー審査会
     * @param saidaiHyojiKensu saidaiHyojiKensu
     * @param is割付未完了のみ is割付未完了のみ
     * @param is未開催分のみ is未開催分のみ
     * @param is審査会未完了のみ is審査会未完了のみ
     * @param is審査会完了のみ is審査会完了のみ
     * @param is開催予定登録OR対象者割付 is開催予定登録OR対象者割付
     * @param is表示しない is表示しない
     * @param is結果登録審査会未完了のみ is結果登録審査会未完了のみ
     */
    private ShinsakaiKaisaiParameter(
            RString 表示期間From,
            RString 表示期間To,
            RString モード,
            RString 表示条件,
            RString ダミー審査会,
            Decimal saidaiHyojiKensu,
            boolean is割付未完了のみ,
            boolean is未開催分のみ,
            boolean is審査会未完了のみ,
            boolean is審査会完了のみ,
            boolean is開催予定登録OR対象者割付,
            boolean is表示しない,
            RString 審査会開催番号,
            boolean is結果登録審査会未完了のみ,
            boolean is審査会未開催分のみ) {
        this.表示期間From = 表示期間From;
        this.表示期間To = 表示期間To;
        this.モード = モード;
        this.表示条件 = 表示条件;
        this.ダミー審査会 = ダミー審査会;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.is割付未完了のみ = is割付未完了のみ;
        this.is未開催分のみ = is未開催分のみ;
        this.is審査会未完了のみ = is審査会未完了のみ;
        this.is審査会完了のみ = is審査会完了のみ;
        this.is開催予定登録OR対象者割付 = is開催予定登録OR対象者割付;
        this.is表示しない = is表示しない;
        this.審査会開催番号 = 審査会開催番号;
        this.is結果登録審査会未完了のみ = is結果登録審査会未完了のみ;
        this.is審査会未開催分のみ = is審査会未開催分のみ;
    }

    /**
     * 審査会一覧情報検索用のパラメータを生成します。
     *
     * @param 表示期間From 表示期間From
     * @param 表示期間To 表示期間To
     * @param モード モード
     * @param 表示条件 表示条件
     * @param 最大表示件数 最大表示件数
     * @param ダミー審査会 ダミー審査会
     * @return 介護認定審査会共有一覧のパラメータ
     */
    public static ShinsakaiKaisaiParameter createParam(
            RString 表示期間From,
            RString 表示期間To,
            RString モード,
            RString 表示条件,
            Decimal 最大表示件数,
            RString ダミー審査会) {
        boolean is割付未完了のみ = false;
        boolean is未開催分のみ = false;
        boolean is審査会未完了のみ = false;
        boolean is審査会完了のみ = false;
        boolean is開催予定登録OR対象者割付 = false;
        boolean is表示しない = false;
        boolean is結果登録審査会未完了のみ = false;
        boolean is審査会未開催分のみ = false;

        if (!全ての審査会.equals(表示条件)) {
            if (割付未完了のみ.equals(表示条件)) {
                is割付未完了のみ = true;
            }
            if (未開催分のみ.equals(表示条件)) {
                is未開催分のみ = true;
            }
            if (審査会未完了のみ.equals(表示条件)) {
                is審査会未完了のみ = true;
            }
            if (審査会完了のみ.equals(表示条件)) {
                is審査会完了のみ = true;
            }
            if (結果登録審査会未完了のみ.equals(表示条件)) {
                is結果登録審査会未完了のみ = true;
            }
            if (審査会未開催分のみ.equals(表示条件)) {
                is審査会未開催分のみ = true;
            }
        }
        if ((開催予定登録.equals(モード) || 対象者割付.equals(モード) || モード_対象者割付_自動割付使用不可.equals(モード)) && 表示しない.equals(ダミー審査会)) {
            is開催予定登録OR対象者割付 = true;
            is表示しない = true;
        }
        return new ShinsakaiKaisaiParameter(
                表示期間From,
                表示期間To,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                最大表示件数,
                is割付未完了のみ,
                is未開催分のみ,
                is審査会未完了のみ,
                is審査会完了のみ,
                is開催予定登録OR対象者割付,
                is表示しない,
                RString.EMPTY,
                is結果登録審査会未完了のみ,
                is審査会未開催分のみ);
    }

    /**
     * 審査会情報検索用のパラメータを生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @return 介護認定審査会検索パラメータ
     */
    public static ShinsakaiKaisaiParameter create審査会検索Param(RString 審査会開催番号) {
        return new ShinsakaiKaisaiParameter(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                Decimal.ZERO,
                false,
                false,
                false,
                false,
                false,
                false,
                審査会開催番号,
                false,
                false);
    }

    /**
     * 審査結果登録用のパラメータを生成します。
     *
     * @param 表示期間From 表示期間From
     * @param 表示期間To 表示期間To
     * @param 表示条件 表示条件
     * @param 最大表示件数 最大表示件数
     * @return 介護認定審査会検索パラメータ
     */
    public static ShinsakaiKaisaiParameter create審査結果登録Param(
            RString 表示期間From,
            RString 表示期間To,
            RString 表示条件,
            Decimal 最大表示件数) {
        return new ShinsakaiKaisaiParameter(
                /* 表示期間From */表示期間From,
                /* 表示期間To */ 表示期間To,
                /* モード */ RString.EMPTY,
                /* 表示条件 */ RString.EMPTY,
                /* ダミー審査会 */ RString.EMPTY,
                /* saidaiHyojiKensu */ 最大表示件数,
                /* is割付未完了のみ */ false,
                /* is未開催分のみ */ false,
                /* is審査会未完了のみ */ false,
                /* is審査会完了のみ */ false,
                /* is開催予定登録OR対象者割付 */ true,
                /* is表示しない */ true,
                /* 審査会開催番号 */ RString.EMPTY,
                /* is結果登録審査会未完了のみ */ !全ての審査会.equals(表示条件),
                /* is審査会未開催分のみ*/ false
        );
    }
}
