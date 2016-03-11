/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 判定結果情報出力（保険者）クラスパラメータクラス。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class HanteiKekkaJouhouShuturyokuParameter {

    private final boolean 二次判定日Fromフラグ;
    private final RString 二次判定日From;
    private final boolean 二次判定日Toフラグ;
    private final RString 二次判定日To;
    private final boolean 未出力のみフラグ;
    private final RString 未出力のみ;
    private final boolean 出力済みフラグ;
    private final RString 出力済み;
    private final boolean 被保険者番号フラグ;
    private final RString 被保険者番号;
    private final boolean 保険者フラグ;
    private final RString 保険者;
    private final boolean 支所フラグ;
    private final RString 支所;
    private final boolean 被保険者氏名フラグ;
    private final RString 被保険者氏名;
    private final boolean 見做申請フラグ;
    private final boolean 認定申請日Fromフラグ;
    private final RString 認定申請日From;
    private final boolean 認定申請日Toフラグ;
    private final RString 認定申請日To;
    private final boolean 生年月日Fromフラグ;
    private final RString 生年月日From;
    private final boolean 生年月日Toフラグ;
    private final RString 生年月日To;
    private final boolean 申請区分_申請時フラグ;
    private final RString 申請区分_申請時;
    private final boolean 性別男フラグ;
    private final boolean 性別女フラグ;
    private final boolean usesSaidaiHyojiKensu;
    private final Decimal saidaiHyojiKensu;
    private final RString 一致;
    private final boolean 前方一致フラグ;
    private final boolean 完全一致フラグ;
    private final boolean 部分一致フラグ;
    private final boolean 後方一致フラグ;

    private HanteiKekkaJouhouShuturyokuParameter(boolean 二次判定日Fromフラグ,
            RString 二次判定日From,
            boolean 二次判定日Toフラグ,
            RString 二次判定日To,
            boolean 未出力のみフラグ,
            RString 未出力のみ,
            boolean 出力済みフラグ,
            RString 出力済み,
            boolean 被保険者番号フラグ,
            RString 被保険者番号,
            boolean 保険者フラグ,
            RString 保険者,
            boolean 支所フラグ,
            RString 支所,
            boolean 被保険者氏名フラグ,
            RString 被保険者氏名,
            boolean 見做申請フラグ,
            boolean 認定申請日Fromフラグ,
            RString 認定申請日From,
            boolean 認定申請日Toフラグ,
            RString 認定申請日To,
            boolean 生年月日Fromフラグ,
            RString 生年月日From,
            boolean 生年月日Toフラグ,
            RString 生年月日To,
            boolean 申請区分_申請時フラグ,
            RString 申請区分_申請時,
            boolean 性別男フラグ,
            boolean 性別女フラグ,
            boolean usesSaidaiHyojiKensu,
            Decimal saidaiHyojiKensu,
            RString 一致,
            boolean 前方一致フラグ,
            boolean 完全一致フラグ,
            boolean 部分一致フラグ,
            boolean 後方一致フラグ) {
        this.二次判定日Fromフラグ = 二次判定日Fromフラグ;
        this.二次判定日From = 二次判定日From;
        this.二次判定日Toフラグ = 二次判定日Toフラグ;
        this.二次判定日To = 二次判定日To;
        this.未出力のみフラグ = 未出力のみフラグ;
        this.未出力のみ = 未出力のみ;
        this.出力済みフラグ = 出力済みフラグ;
        this.出力済み = 出力済み;
        this.被保険者番号フラグ = 被保険者番号フラグ;
        this.被保険者番号 = 被保険者番号;
        this.保険者フラグ = 保険者フラグ;
        this.保険者 = 保険者;
        this.支所フラグ = 支所フラグ;
        this.支所 = 支所;
        this.被保険者氏名フラグ = 被保険者氏名フラグ;
        this.被保険者氏名 = 被保険者氏名;
        this.見做申請フラグ = 見做申請フラグ;
        this.認定申請日Fromフラグ = 認定申請日Fromフラグ;
        this.認定申請日From = 認定申請日From;
        this.認定申請日Toフラグ = 認定申請日Toフラグ;
        this.認定申請日To = 認定申請日To;
        this.生年月日Fromフラグ = 生年月日Fromフラグ;
        this.生年月日From = 生年月日From;
        this.生年月日Toフラグ = 生年月日Toフラグ;
        this.生年月日To = 生年月日To;
        this.申請区分_申請時フラグ = 申請区分_申請時フラグ;
        this.申請区分_申請時 = 申請区分_申請時;
        this.性別男フラグ = 性別男フラグ;
        this.性別女フラグ = 性別女フラグ;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.一致 = 一致;
        this.前方一致フラグ = 前方一致フラグ;
        this.完全一致フラグ = 完全一致フラグ;
        this.部分一致フラグ = 部分一致フラグ;
        this.後方一致フラグ = 後方一致フラグ;
    }

    /**
     * コンストラクタ作成
     *
     * @param 二次判定日From RString
     * @param 二次判定日To RString
     * @param 未出力のみ RString
     * @param 出力済み RString
     * @param 被保険者番号 RString
     * @param 保険者 RString
     * @param 支所 RString
     * @param 被保険者氏名 RString
     * @param 見做申請フラグ boolean
     * @param 認定申請日From RString
     * @param 認定申請日To RString
     * @param 生年月日From RString
     * @param 生年月日To RString
     * @param 申請区分_申請時 RString
     * @param 性別男フラグ boolean
     * @param 性別女フラグ boolean
     * @param 最大表示件数 Decimal
     * @param 一致 一致
     * @return HanteiKekkaJouhouShuturyokuParameter
     * HanteiKekkaJouhouShuturyokuParameter
     */
    public static HanteiKekkaJouhouShuturyokuParameter createParam(
            RString 二次判定日From,
            RString 二次判定日To,
            RString 未出力のみ,
            RString 出力済み,
            RString 被保険者番号,
            RString 保険者,
            RString 支所,
            RString 被保険者氏名,
            boolean 見做申請フラグ,
            RString 認定申請日From,
            RString 認定申請日To,
            RString 生年月日From,
            RString 生年月日To,
            RString 申請区分_申請時,
            boolean 性別男フラグ,
            boolean 性別女フラグ,
            Decimal 最大表示件数,
            RString 一致) {

        boolean 二次判定日Fromフラグ = false;
        boolean 二次判定日Toフラグ = false;
        boolean 未出力のみフラグ = false;
        boolean 出力済みフラグ = false;
        boolean 被保険者番号フラグ = false;
        boolean 保険者フラグ = false;
        boolean 支所フラグ = false;
        boolean 被保険者氏名フラグ = false;
        boolean 認定申請日Fromフラグ = false;
        boolean 認定申請日Toフラグ = false;
        boolean 生年月日Fromフラグ = false;
        boolean 生年月日Toフラグ = false;
        boolean 申請区分_申請時フラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        boolean 前方一致フラグ = false;
        boolean 完全一致フラグ = false;
        boolean 部分一致フラグ = false;
        boolean 後方一致フラグ = false;
        if (!RString.isNullOrEmpty(二次判定日From)) {
            二次判定日Fromフラグ = true;
        }
        if (!RString.isNullOrEmpty(二次判定日To)) {
            二次判定日Toフラグ = true;
        }

        if (new RString("1").equals(未出力のみ)) {
            未出力のみフラグ = true;
        }

        if (new RString("2").equals(出力済み)) {
            出力済みフラグ = true;
        }

        if (!RString.isNullOrEmpty(被保険者番号)) {
            被保険者番号フラグ = true;
        }
        if (!RString.isNullOrEmpty(保険者)) {
            保険者フラグ = true;
        }
        if (!RString.isNullOrEmpty(支所)) {
            支所フラグ = true;
        }
        if (!RString.isNullOrEmpty(認定申請日From)) {
            認定申請日Fromフラグ = true;
        }
        if (!RString.isNullOrEmpty(認定申請日To)) {
            認定申請日Toフラグ = true;
        }
        if (!RString.isNullOrEmpty(被保険者氏名)) {
            被保険者氏名フラグ = true;
        }
        if (!RString.isNullOrEmpty(認定申請日From)) {
            認定申請日Fromフラグ = true;
        }
        if (!RString.isNullOrEmpty(認定申請日To)) {
            認定申請日Toフラグ = true;
        }

        if (!RString.isNullOrEmpty(生年月日From)) {
            生年月日Fromフラグ = true;
        }
        if (!RString.isNullOrEmpty(生年月日To)) {
            生年月日Toフラグ = true;
        }

        if (!RString.isNullOrEmpty(申請区分_申請時)) {
            申請区分_申請時フラグ = true;
        }

        if (!最大表示件数.equals(new Decimal(0))) {
            usesSaidaiHyojiKensu = true;
        }
        if (一致.equals(new RString("key0"))) {
            前方一致フラグ = true;
        }
        if (一致.equals(new RString("key1"))) {
            完全一致フラグ = true;
        }
        if (一致.equals(new RString("key2"))) {
            部分一致フラグ = true;
        }
        if (一致.equals(new RString("key3"))) {
            後方一致フラグ = true;
        }

        return new HanteiKekkaJouhouShuturyokuParameter(二次判定日Fromフラグ,
                二次判定日From,
                二次判定日Toフラグ,
                二次判定日To,
                未出力のみフラグ,
                未出力のみ,
                出力済みフラグ,
                出力済み,
                被保険者番号フラグ,
                被保険者番号,
                保険者フラグ,
                保険者,
                支所フラグ,
                支所,
                被保険者氏名フラグ,
                被保険者氏名,
                見做申請フラグ,
                認定申請日Fromフラグ,
                認定申請日From,
                認定申請日Toフラグ,
                認定申請日To,
                生年月日Fromフラグ,
                生年月日From,
                生年月日Toフラグ,
                生年月日To,
                申請区分_申請時フラグ,
                申請区分_申請時,
                性別男フラグ,
                性別女フラグ,
                usesSaidaiHyojiKensu,
                最大表示件数,
                一致,
                前方一致フラグ,
                完全一致フラグ,
                部分一致フラグ,
                後方一致フラグ);
    }

}
