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
    private static final RString 割付完了のみ = new RString("割付完了分のみ");
    private static final RString 審査会未完了のみ = new RString("審査会未完了分のみ");
    private static final RString 審査会完了のみ = new RString("審査会完了分のみ");
    private static final RString 全ての審査会 = new RString("全ての審査会");
    private static final RString 表示しない = new RString("表示しない");
    private static final RString 開催予定登録 = new RString("kaisaiYoteiToroku");
    private static final RString 対象者割付 = new RString("taishoshaWaritsuke");
    private final RString 表示期間From;
    private final RString 表示期間To;
    private final RString モード;
    private final RString 表示条件;
    private final RString ダミー審査会;
    private final Decimal saidaiHyojiKensu;
    private final boolean is割付未完了のみ;
    private final boolean is割付完了のみ;
    private final boolean is審査会未完了のみ;
    private final boolean is審査会完了のみ;
    private final boolean is開催予定登録OR対象者割付;
    private final boolean is表示しない;

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
     * @param is割付完了のみ is割付完了のみ
     * @param is審査会未完了のみ is審査会未完了のみ
     * @param is審査会完了のみ is審査会完了のみ
     * @param is開催予定登録OR対象者割付 is開催予定登録OR対象者割付
     * @param is表示しない is表示しない
     */
    private ShinsakaiKaisaiParameter(
            RString 表示期間From,
            RString 表示期間To,
            RString モード,
            RString 表示条件,
            RString ダミー審査会,
            Decimal saidaiHyojiKensu,
            boolean is割付未完了のみ,
            boolean is割付完了のみ,
            boolean is審査会未完了のみ,
            boolean is審査会完了のみ,
            boolean is開催予定登録OR対象者割付,
            boolean is表示しない) {
        this.表示期間From = 表示期間From;
        this.表示期間To = 表示期間To;
        this.モード = モード;
        this.表示条件 = 表示条件;
        this.ダミー審査会 = ダミー審査会;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.is割付未完了のみ = is割付未完了のみ;
        this.is割付完了のみ = is割付完了のみ;
        this.is審査会未完了のみ = is審査会未完了のみ;
        this.is審査会完了のみ = is審査会完了のみ;
        this.is開催予定登録OR対象者割付 = is開催予定登録OR対象者割付;
        this.is表示しない = is表示しない;
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
        boolean is割付完了のみ = false;
        boolean is審査会未完了のみ = false;
        boolean is審査会完了のみ = false;
        boolean is開催予定登録OR対象者割付 = false;
        boolean is表示しない = false;

        if (!全ての審査会.equals(表示条件)) {
            if (割付未完了のみ.equals(表示条件)) {
                is割付未完了のみ = true;
            }
            if (割付完了のみ.equals(表示条件)) {
                is割付完了のみ = true;
            }
            if (開催予定登録.equals(モード) || 審査会未完了のみ.equals(表示条件)) {
                is審査会未完了のみ = true;
            }
            if (審査会完了のみ.equals(表示条件)) {
                is審査会完了のみ = true;
            }
        }
        if ((開催予定登録.equals(モード) || 対象者割付.equals(モード)) && 表示しない.equals(ダミー審査会)) {
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
                is割付完了のみ,
                is審査会未完了のみ,
                is審査会完了のみ,
                is開催予定登録OR対象者割付,
                is表示しない);
    }

}
