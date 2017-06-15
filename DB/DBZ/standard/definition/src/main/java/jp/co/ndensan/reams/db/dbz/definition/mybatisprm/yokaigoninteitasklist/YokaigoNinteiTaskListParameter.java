/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * タスク一覧共有画面クラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YokaigoNinteiTaskListParameter {

    private final RString 通常;
    private final RString 延期;
    private final RString 状態区分;
    private final Decimal 件数;
    private final LasdecCode 市町村コード;
    private final RString 処理日;
    private final boolean isItijiHannteiAto;
    private final boolean is特記事項必須;
    private final boolean is概況特記必須;
    private final boolean usesIraisho;
    private final boolean usesIkensho;
    private final boolean usesIraisho_Ikensho;
    private static final RString 依頼書のみ = new RString("1");
    private static final RString 意見書のみ = new RString("2");
    private static final RString 依頼書_意見書 = new RString("3");

    private YokaigoNinteiTaskListParameter(RString 通常, RString 延期, RString 状態区分, Decimal 件数, LasdecCode 市町村コード, RString 処理日,
            boolean 一次判定後フラグ, boolean is特記事項必須, boolean is概況特記必須,
            boolean usesIraisho,
            boolean usesIkensho,
            boolean usesIraisho_Ikensho) {
        this.通常 = 通常;
        this.延期 = 延期;
        this.状態区分 = 状態区分;
        this.件数 = 件数;
        this.市町村コード = 市町村コード;
        this.処理日 = 処理日;
        this.isItijiHannteiAto = 一次判定後フラグ;
        this.is特記事項必須 = is特記事項必須;
        this.is概況特記必須 = is概況特記必須;
        this.usesIraisho = usesIraisho;
        this.usesIkensho = usesIkensho;
        this.usesIraisho_Ikensho = usesIraisho_Ikensho;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param 状態区分 RString
     * @param 件数 Decimal
     * @param 市町村コード LasdecCode
     * @param 一次判定後フラグ boolean
     * @param is特記事項必須 boolean
     * @param is概況特記必須 boolean
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期,
            RString 状態区分,
            Decimal 件数,
            LasdecCode 市町村コード,
            boolean 一次判定後フラグ,
            boolean is特記事項必須,
            boolean is概況特記必須) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                状態区分,
                件数,
                市町村コード,
                RDate.getNowDate().toDateString(),
                一次判定後フラグ,
                is特記事項必須,
                is概況特記必須,
                false,
                false,
                false);
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param 状態区分 RString
     * @param 件数 Decimal
     * @param 市町村コード LasdecCode
     * @param 一次判定後フラグ boolean
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期,
            RString 状態区分,
            Decimal 件数,
            LasdecCode 市町村コード,
            boolean 一次判定後フラグ) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                状態区分,
                件数,
                市町村コード,
                RDate.getNowDate().toDateString(),
                一次判定後フラグ,
                false,
                false,
                false,
                false,
                false);
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param 状態区分 RString
     * @param 件数 Decimal
     * @param 市町村コード LasdecCode
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期,
            RString 状態区分,
            Decimal 件数,
            LasdecCode 市町村コード) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                状態区分,
                件数,
                市町村コード,
                RDate.getNowDate().toDateString(),
                false,
                false,
                false,
                false,
                false,
                false);
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param 状態区分 RString
     * @param 件数 Decimal
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期,
            RString 状態区分,
            Decimal 件数) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                状態区分,
                件数,
                LasdecCode.EMPTY,
                RDate.getNowDate().toDateString(),
                false,
                false,
                false,
                false,
                false,
                false);
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param 状態区分 RString
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期,
            RString 状態区分) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                状態区分,
                Decimal.ZERO,
                LasdecCode.EMPTY,
                RDate.getNowDate().toDateString(),
                false,
                false,
                false,
                false,
                false,
                false);
    }

    /**
     * タスク一覧共有画面検索用パラメータを生成します。
     *
     * @param 通常 処理状態区分.通常
     * @param 延期 処理状態区分.延期
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                RString.EMPTY,
                Decimal.ZERO,
                LasdecCode.EMPTY,
                RDate.getNowDate().toDateString(),
                false,
                false,
                false,
                false,
                false,
                false);
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param 状態区分 RString
     * @param 件数 Decimal
     * @param 市町村コード LasdecCode
     * @param 追加完了条件 RString
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期,
            RString 状態区分,
            Decimal 件数,
            LasdecCode 市町村コード,
            RString 追加完了条件) {
        boolean Iraisho = false;
        boolean Ikensho = false;
        boolean Iraisho_Ikensho = false;
        if (追加完了条件.equals(依頼書のみ)) {
            Iraisho = true;
        }
        if (追加完了条件.equals(意見書のみ)) {
            Ikensho = true;
        }
        if (追加完了条件.equals(依頼書_意見書)) {
            Iraisho_Ikensho = true;
        }
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期,
                状態区分,
                件数,
                市町村コード,
                RDate.getNowDate().toDateString(),
                false,
                false,
                false,
                Iraisho,
                Ikensho,
                Iraisho_Ikensho);
    }
}
