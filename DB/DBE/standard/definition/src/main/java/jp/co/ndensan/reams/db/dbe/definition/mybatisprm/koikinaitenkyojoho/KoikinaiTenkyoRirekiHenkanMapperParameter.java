/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.koikinaitenkyojoho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 広域内転居使用ことのパラメータクラスです
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KoikinaiTenkyoRirekiHenkanMapperParameter {

    private final boolean 被保険者番号フラグ;
    private final boolean 前方一致フラグ;
    private final boolean 完全一致フラグ;
    private final boolean 部分一致フラグ;
    private final boolean 後方一致フラグ;
    private final boolean みなしフラグ;
    private final boolean 認定申請日Fromフラグ;
    private final boolean 認定申請日Toフラグ;
    private final boolean 生年月日Fromフラグ;
    private final boolean 生年月日Toフラグ;
    private final boolean 申請区分フラグ;
    private final boolean 男フラグ;
    private final boolean 女フラグ;
    private final RString 被保険者番号;
    private final AtenaMeisho 被保険者氏名;
    private final RString 被保険者氏名キー;
    private final FlexibleDate 認定申請日From;
    private final FlexibleDate 認定申請日To;
    private final FlexibleDate 生年月日From;
    private final FlexibleDate 生年月日To;
    private final Code 申請区分;
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_2 = new RString("key2");
    private static final RString KEY_3 = new RString("key3");
    private static final RString SELECTKEY_空白 = RString.EMPTY;
    private final boolean みなしキー;
    private final RString 申請区分キー;
    private final List<RString> 性別キー;
    private final boolean 最大表示件数フラグ;
    private final RString 処理状態区分_通常;
    private final RString 処理状態区分_延期;
    private final boolean 性別フラグ;
    private final Decimal 最大表示件数;

    private KoikinaiTenkyoRirekiHenkanMapperParameter(
            RString 被保険者番号,
            AtenaMeisho 被保険者氏名,
            FlexibleDate 認定申請日From,
            FlexibleDate 認定申請日To,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            Code 申請区分,
            RString 被保険者氏名キー,
            boolean みなしキー,
            RString 申請区分キー,
            List<RString> 性別キー,
            Decimal 最大表示件数,
            boolean is被保険者番号,
            boolean is前方一致,
            boolean is完全一致,
            boolean is部分一致,
            boolean is後方一致,
            boolean is認定申請日From,
            boolean is認定申請日To,
            boolean is生年月日From,
            boolean is生年月日To,
            boolean is申請区分,
            boolean is男,
            boolean is女,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            boolean 性別フラグ,
            boolean is最大表示件数) {
        this.被保険者番号フラグ = is被保険者番号;
        this.前方一致フラグ = is前方一致;
        this.完全一致フラグ = is完全一致;
        this.部分一致フラグ = is部分一致;
        this.後方一致フラグ = is後方一致;
        this.みなしフラグ = みなしキー;
        this.認定申請日Fromフラグ = is認定申請日From;
        this.認定申請日Toフラグ = is認定申請日To;
        this.生年月日Fromフラグ = is生年月日From;
        this.生年月日Toフラグ = is生年月日To;
        this.申請区分フラグ = is申請区分;
        this.男フラグ = is男;
        this.女フラグ = is女;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 被保険者氏名;
        this.認定申請日From = 認定申請日From;
        this.認定申請日To = 認定申請日To;
        this.生年月日From = 生年月日From;
        this.生年月日To = 生年月日To;
        this.申請区分 = 申請区分;
        this.被保険者氏名キー = 被保険者氏名キー;
        this.みなしキー = みなしキー;
        this.申請区分キー = 申請区分キー;
        this.性別キー = 性別キー;
        this.最大表示件数 = 最大表示件数;
        this.処理状態区分_通常 = 処理状態区分_通常;
        this.処理状態区分_延期 = 処理状態区分_延期;
        this.性別フラグ = 性別フラグ;
        this.最大表示件数フラグ = is最大表示件数;
    }

    /**
     * キー検索用のパラメータを生成します
     *
     * @param 被保険者番号 被保険者番号
     * @param 被保険者氏名 被保険者氏名
     * @param 認定申請日From 認定申請日From
     * @param 認定申請日To 認定申請日To
     * @param 生年月日From 生年月日From
     * @param 生年月日To 生年月日To
     * @param 申請区分 申請区分
     * @param 被保険者氏名キー 被保険者氏名キー
     * @param みなしキー みなしキー
     * @param 申請区分キー 申請区分キー
     * @param 性別キー 性別キー
     * @param 処理状態区分_通常 処理状態区分_通常
     * @param 処理状態区分_延期 処理状態区分_通常
     * @param 最大表示件数 最大表示件数
     * @return 広域内転居使用ことのパラメータ
     */
    public static KoikinaiTenkyoRirekiHenkanMapperParameter createSelectByKeyParam(
            RString 被保険者番号,
            AtenaMeisho 被保険者氏名,
            FlexibleDate 認定申請日From,
            FlexibleDate 認定申請日To,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            Code 申請区分,
            RString 被保険者氏名キー,
            boolean みなしキー,
            RString 申請区分キー,
            List<RString> 性別キー,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            Decimal 最大表示件数) {
        boolean 男 = false;
        boolean 女 = false;
        boolean 性別 = false;
        if (性別キー.contains(KEY_0) && 性別キー.contains(KEY_1)) {
            性別 = true;
        } else {
            if (性別キー.contains(KEY_0)) {
                男 = true;
            }
            if (性別キー.contains(KEY_1)) {
                女 = true;
            }
        }
        return new KoikinaiTenkyoRirekiHenkanMapperParameter(
                被保険者番号,
                被保険者氏名,
                認定申請日From,
                認定申請日To,
                生年月日From,
                生年月日To,
                申請区分,
                被保険者氏名キー,
                みなしキー,
                申請区分キー,
                性別キー,
                最大表示件数,
                null != 被保険者番号 && !被保険者番号.isEmpty(),
                (null != 被保険者氏名 && !被保険者氏名.isEmpty()) && KEY_0.equals(被保険者氏名キー),
                (null != 被保険者氏名 && !被保険者氏名.isEmpty()) && KEY_1.equals(被保険者氏名キー),
                (null != 被保険者氏名 && !被保険者氏名.isEmpty()) && KEY_2.equals(被保険者氏名キー),
                (null != 被保険者氏名 && !被保険者氏名.isEmpty()) && KEY_3.equals(被保険者氏名キー),
                null != 認定申請日From && !認定申請日From.isEmpty(),
                null != 認定申請日To && !認定申請日To.isEmpty(),
                null != 生年月日From && !生年月日From.isEmpty(),
                null != 生年月日To && !生年月日To.isEmpty(),
                !SELECTKEY_空白.equals(申請区分キー),
                男,
                女,
                処理状態区分_通常,
                処理状態区分_延期,
                性別,
                最大表示件数 != null
        );
    }
}
