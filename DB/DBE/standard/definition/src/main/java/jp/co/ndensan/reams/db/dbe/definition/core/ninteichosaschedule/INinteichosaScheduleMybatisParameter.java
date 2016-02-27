/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 認定調査スケジュール登録3クラスパラメータクラス。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class INinteichosaScheduleMybatisParameter {

    private final boolean 仮予約分フラグ;
    private final RString 仮予約分;
    private final boolean 確定分フラグ;
    private final RString 確定分;
    private final boolean 保険者フラグ;
    private final RString 保険者フ;
    private final RString 証記載保険者番号;
    private final RString 支所コード;
    private final boolean 被保険者番号フラグ;
    private final RString 被保険者番号;
    private final boolean 入力氏名フラグ;
    private final RString 入力氏名;
    private final boolean 生年月日フラグ;
    private final RString 生年月日;
    private final boolean 認定申請日Fromフラグ;
    private final RString 認定申請日From;
    private final boolean 認定申請日Toフラグ;
    private final RString 認定申請日To;
    private final boolean メモフラグ;
    private final RString メモ;
    private final boolean 認定調査委託先フラグ;
    private final RString 認定調査委託先;
    private final boolean 認定調査員フラグ;
    private final RString 認定調査員;
    private final boolean 認定調査日Fromフラグ;
    private final RString 認定調査日From;
    private final boolean 認定調査日Toフラグ;
    private final RString 認定調査日To;
    private final boolean 対象地区フラグ;
    private final RString 対象地区;
    private final boolean 識別コードフラグ;
    private final RString 識別コード;
    private final boolean カナ氏名フラグ;
    private final RString カナ氏名;
    private final boolean usesSaidaiHyojiKensu;
    private final Decimal saidaiHyojiKensu;

    private INinteichosaScheduleMybatisParameter(boolean 仮予約分フラグ,
            RString 仮予約分,
            boolean 確定分フラグ,
            RString 確定分,
            boolean 保険者フラグ,
            RString 保険者フ,
            RString 証記載保険者番号,
            RString 支所コード,
            boolean 被保険者番号フラグ,
            RString 被保険者番号,
            boolean 入力氏名フラグ,
            RString 入力氏名,
            boolean 生年月日フラグ,
            RString 生年月日,
            boolean 認定申請日Fromフラグ,
            RString 認定申請日From,
            boolean 認定申請日Toフラグ,
            RString 認定申請日To,
            boolean メモフラグ,
            RString メモ,
            boolean 認定調査委託先フラグ,
            RString 認定調査委託先,
            boolean 認定調査員フラグ,
            RString 認定調査員,
            boolean 認定調査日Fromフラグ,
            RString 認定調査日From,
            boolean 認定調査日Toフラグ,
            RString 認定調査日To,
            boolean 対象地区フラグ,
            RString 対象地区,
            boolean 識別コードフラグ,
            RString 識別コード,
            boolean カナ氏名フラグ,
            RString カナ氏名,
            boolean usesSaidaiHyojiKensu,
            Decimal saidaiHyojiKensu) {
        this.仮予約分フラグ = 仮予約分フラグ;
        this.入力氏名フラグ = 入力氏名フラグ;
        this.メモ = メモ;
        this.対象地区 = 対象地区;
        this.支所コード = 支所コード;
        this.生年月日フラグ = 生年月日フラグ;
        this.確定分フラグ = 確定分フラグ;
        this.被保険者番号 = 被保険者番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.認定申請日From = 認定申請日From;
        this.認定申請日To = 認定申請日To;
        this.認定調査員 = 認定調査員;
        this.認定調査委託先 = 認定調査委託先;
        this.認定調査日From = 認定調査日From;
        this.認定調査日To = 認定調査日To;
        this.メモフラグ = メモフラグ;
        this.仮予約分 = 仮予約分;
        this.保険者フラグ = 保険者フラグ;
        this.入力氏名 = 入力氏名;
        this.生年月日 = 生年月日;
        this.被保険者番号フラグ = 被保険者番号フラグ;
        this.認定申請日Fromフラグ = 認定申請日Fromフラグ;
        this.認定調査員フラグ = 認定調査員フラグ;
        this.認定申請日Toフラグ = 認定申請日Toフラグ;
        this.認定調査委託先フラグ = 認定調査委託先フラグ;
        this.認定調査日Fromフラグ = 認定調査日Fromフラグ;
        this.認定調査日Toフラグ = 認定調査日Toフラグ;
        this.対象地区フラグ = 対象地区フラグ;
        this.確定分 = 確定分;
        this.保険者フ = 保険者フ;
        this.識別コードフラグ = 識別コードフラグ;
        this.識別コード = 識別コード;
        this.カナ氏名フラグ = カナ氏名フラグ;
        this.カナ氏名 = カナ氏名;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
    }

    /**
     * コンストラクタ作成
     *
     * @param 仮予約分 RString
     * @param 確定分 RString
     * @param 保険者フ RString
     * @param 保険者番号 RString
     * @param 支所コード RString
     * @param 被保険者番号 RString
     * @param 識別コード RString
     * @param 入力氏名 RString
     * @param カナ氏名 RString
     * @param 生年月日 RString
     * @param 対象地区 RString
     * @param 認定調査委託先 RString
     * @param 認定調査員 RString
     * @param 認定調査日From RString
     * @param 認定調査日To RString
     * @param メモ RString
     * @param 認定申請日From RString
     * @param 認定申請日To RString
     * @param 最大表示件数 RString
     * @return INinteichosaScheduleMybatisParameter INinteichosaScheduleMybatisParameter
     */
    public static INinteichosaScheduleMybatisParameter createParam(
            RString 仮予約分,
            RString 確定分,
            RString 保険者フ,
            RString 保険者番号,
            RString 支所コード,
            RString 被保険者番号,
            RString 入力氏名,
            RString 生年月日,
            RString 認定申請日From,
            RString 認定申請日To,
            RString メモ,
            RString 認定調査委託先,
            RString 認定調査員,
            RString 認定調査日From,
            RString 認定調査日To,
            RString 対象地区,
            RString 識別コード,
            RString カナ氏名,
            Decimal 最大表示件数) {

        boolean 仮予約分フラグ = false;
        boolean 確定分フラグ = false;
        boolean 保険者フラグ = false;
        boolean 被保険者番号フラグ = false;
        boolean 識別コードフラグ = false;
        boolean 入力氏名フラグ = false;
        boolean カナ氏名フラグ = false;
        boolean 生年月日フラグ = false;
        boolean 認定申請日Fromフラグ = false;
        boolean 認定申請日Toフラグ = false;
        boolean メモフラグ = false;
        boolean 認定調査委託先フラグ = false;
        boolean 認定調査員フラグ = false;
        boolean 認定調査日Fromフラグ = false;
        boolean 認定調査日Toフラグ = false;
        boolean 対象地区フラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        if (new RString("1").equals(仮予約分)) {
            仮予約分フラグ = true;
        }

        if (new RString("2").equals(確定分)) {
            確定分フラグ = true;
        }
        if (!保険者フ.isEmpty()) {
            保険者フラグ = true;
        }
        if (!RString.isNullOrEmpty(被保険者番号)) {
            被保険者番号フラグ = true;
        }
        if (!RString.isNullOrEmpty(識別コード)) {
            識別コードフラグ = true;
        }
        if (!RString.isNullOrEmpty(入力氏名)) {
            入力氏名フラグ = true;
        }
        if (!RString.isNullOrEmpty(カナ氏名)) {
            カナ氏名フラグ = true;
        }
        if (!RString.isNullOrEmpty(生年月日)) {
            生年月日フラグ = true;
        }
        if (!RString.isNullOrEmpty(認定申請日From)) {
            認定申請日Fromフラグ = true;
        }
        if (!RString.isNullOrEmpty(認定申請日To)) {
            認定申請日Toフラグ = true;
        }
        if (!RString.isNullOrEmpty(メモ)) {
            メモフラグ = true;
        }
        if (!認定調査委託先.isEmpty()) {
            認定調査委託先フラグ = true;
        }
        if (!認定調査員.isEmpty()) {
            認定調査員フラグ = true;
        }
        if (!RString.isNullOrEmpty(認定調査日From)) {
            認定調査日Fromフラグ = true;
        }
        if (!RString.isNullOrEmpty(認定調査日To)) {
            認定調査日Toフラグ = true;
        }
        if (!対象地区.isEmpty()) {
            対象地区フラグ = true;
        }
        if (!最大表示件数.equals(new Decimal(0))) {
            usesSaidaiHyojiKensu = true;
        }
        return new INinteichosaScheduleMybatisParameter(仮予約分フラグ,
                仮予約分,
                確定分フラグ,
                確定分,
                保険者フラグ,
                保険者フ,
                保険者番号,
                支所コード,
                被保険者番号フラグ,
                被保険者番号,
                入力氏名フラグ,
                入力氏名,
                生年月日フラグ,
                生年月日,
                認定申請日Fromフラグ,
                認定申請日From,
                認定申請日Toフラグ,
                認定申請日To,
                メモフラグ,
                メモ,
                認定調査委託先フラグ,
                認定調査委託先,
                認定調査員フラグ,
                認定調査員,
                認定調査日Fromフラグ,
                認定調査日From,
                認定調査日Toフラグ,
                認定調査日To,
                対象地区フラグ,
                対象地区,
                識別コードフラグ,
                識別コード,
                カナ氏名フラグ,
                カナ氏名,
                usesSaidaiHyojiKensu,
                最大表示件数);
    }
}
