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
public class INinteiKanryoJohoMybatisParameter {

    private final boolean 保険者フラグ;
    private final RString 保険者フ;
    private final RString 証記載保険者番号;
    private final RString 支所コード;
    private final boolean 被保険者番号フラグ;
    private final RString 被保険者番号;
    private final boolean 識別コードフラグ;
    private final RString 識別コード;
    private final boolean 入力氏名フラグ;
    private final RString 入力氏名;
    private final boolean カナ氏名フラグ;
    private final RString カナ氏名;
    private final boolean 生年月日フラグ;
    private final RString 生年月日;
    private final boolean 認定申請日Fromフラグ;
    private final RString 認定申請日From;
    private final boolean 認定申請日Toフラグ;
    private final RString 認定申請日To;
    private final boolean メモフラグ;
    private final RString メモ;
    private final boolean 対象地区フラグ;
    private final RString 対象地区;
    private final boolean usesSaidaiHyojiKensu;
    private final Decimal saidaiHyojiKensu;

    private INinteiKanryoJohoMybatisParameter(
            boolean 保険者フラグ,
            RString 保険者フ,
            RString 証記載保険者番号,
            RString 支所コード,
            boolean 被保険者番号フラグ,
            RString 被保険者番号,
            boolean 識別コードフラグ,
            RString 識別コード,
            boolean 入力氏名フラグ,
            RString 入力氏名,
            boolean カナ氏名フラグ,
            RString カナ氏名,
            boolean 生年月日フラグ,
            RString 生年月日,
            boolean 認定申請日Fromフラグ,
            RString 認定申請日From,
            boolean 認定申請日Toフラグ,
            RString 認定申請日To,
            boolean メモフラグ,
            RString メモ,
            boolean 対象地区フラグ,
            RString 対象地区,
            boolean usesSaidaiHyojiKensu,
            Decimal saidaiHyojiKensu) {
        this.保険者フラグ = 保険者フラグ;
        this.保険者フ = 保険者フ;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号フラグ = 被保険者番号フラグ;
        this.被保険者番号 = 被保険者番号;
        this.識別コードフラグ = 識別コードフラグ;
        this.識別コード = 識別コード;
        this.入力氏名フラグ = 入力氏名フラグ;
        this.入力氏名 = 入力氏名;
        this.カナ氏名フラグ = カナ氏名フラグ;
        this.カナ氏名 = カナ氏名;
        this.生年月日フラグ = 生年月日フラグ;
        this.生年月日 = 生年月日;
        this.認定申請日Fromフラグ = 認定申請日Fromフラグ;
        this.認定申請日From = 認定申請日From;
        this.認定申請日Toフラグ = 認定申請日Toフラグ;
        this.認定申請日To = 認定申請日To;
        this.メモフラグ = メモフラグ;
        this.メモ = メモ;
        this.対象地区フラグ = 対象地区フラグ;
        this.対象地区 = 対象地区;
        this.支所コード = 支所コード;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
    }

    /**
     * コンストラクタ作成
     *
     * @param 保険者フ RString
     * @param 証記載保険者番号 RString
     * @param 支所コード RString
     * @param 被保険者番号 RString
     * @param 識別コード RString
     * @param 入力氏名 RString
     * @param カナ氏名 RString
     * @param 生年月日 RString
     * @param 対象地区 RString
     * @param メモ RString
     * @param 認定申請日From RString
     * @param 認定申請日To RString
     * @param 最大表示件数 RString
     * @return INinteiKanryoJohoMybatisParameter INinteiKanryoJohoMybatisParameter
     */
    public static INinteiKanryoJohoMybatisParameter createParam(
            RString 保険者フ,
            RString 証記載保険者番号,
            RString 支所コード,
            RString 被保険者番号,
            RString 識別コード,
            RString 入力氏名,
            RString カナ氏名,
            RString 生年月日,
            RString 認定申請日From,
            RString 認定申請日To,
            RString メモ,
            RString 対象地区,
            Decimal 最大表示件数) {
        boolean 保険者フラグ = false;
        boolean 被保険者番号フラグ = false;
        boolean 識別コードフラグ = false;
        boolean 入力氏名フラグ = false;
        boolean カナ氏名フラグ = false;
        boolean 生年月日フラグ = false;
        boolean 認定申請日Fromフラグ = false;
        boolean 認定申請日Toフラグ = false;
        boolean メモフラグ = false;
        boolean 対象地区フラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        if (new RString("1").equals(保険者フ)) {
            保険者フラグ = true;
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            被保険者番号フラグ = true;
        }
        if (識別コード != null && !識別コード.isEmpty()) {
            識別コードフラグ = true;
        }
        if (入力氏名 != null && !入力氏名.isEmpty()) {
            入力氏名フラグ = true;
        }
        if (カナ氏名 != null && !カナ氏名.isEmpty()) {
            カナ氏名フラグ = true;
        }
        if (生年月日 != null && !生年月日.isEmpty()) {
            生年月日フラグ = true;
        }
        if (認定申請日From != null && !認定申請日From.isEmpty()) {
            認定申請日Fromフラグ = true;
        }
        if (認定申請日To != null && !認定申請日To.isEmpty()) {
            認定申請日Toフラグ = true;
        }
        if (メモ != null && !メモ.isEmpty()) {
            メモフラグ = true;
        }
        if (!対象地区.isEmpty()) {
            対象地区フラグ = true;
        }
        if (!最大表示件数.equals(new Decimal(-1))) {
            usesSaidaiHyojiKensu = true;
        }
        return new INinteiKanryoJohoMybatisParameter(保険者フラグ,
                保険者フ,
                証記載保険者番号,
                支所コード,
                被保険者番号フラグ,
                被保険者番号,
                識別コードフラグ,
                識別コード,
                入力氏名フラグ,
                入力氏名,
                カナ氏名フラグ,
                カナ氏名,
                生年月日フラグ,
                生年月日,
                認定申請日Fromフラグ,
                認定申請日From,
                認定申請日Toフラグ,
                認定申請日To,
                メモフラグ,
                メモ,
                対象地区フラグ,
                対象地区,
                usesSaidaiHyojiKensu,
                最大表示件数);
    }
}
