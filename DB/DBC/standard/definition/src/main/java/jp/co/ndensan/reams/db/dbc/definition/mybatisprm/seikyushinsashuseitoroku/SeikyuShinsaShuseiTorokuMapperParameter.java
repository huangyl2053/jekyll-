/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.seikyushinsashuseitoroku;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)ことのパラメータクラスです
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SeikyuShinsaShuseiTorokuMapperParameter {

    private final boolean チェックオンフラグ;
    private final boolean チェックオフフラグ;
    private final boolean 事業者番号フラグ;
    private final boolean 理由書作成年月フラグ;
    private final RString 事業者番号;
    private final RDate 理由書作成年月;

    private SeikyuShinsaShuseiTorokuMapperParameter(
            boolean isチェックオンフラグ,
            boolean isチェックオフフラグ,
            boolean is事業者番号フラグ,
            boolean is理由書作成年月フラグ,
            RString 事業者番号,
            RDate 理由書作成年月) {
        this.チェックオンフラグ = isチェックオンフラグ;
        this.チェックオフフラグ = isチェックオフフラグ;
        this.事業者番号フラグ = is事業者番号フラグ;
        this.理由書作成年月フラグ = is理由書作成年月フラグ;
        this.事業者番号 = 事業者番号;
        this.理由書作成年月 = 理由書作成年月;
    }

    /**
     * キー検索用のパラメータを生成します
     *
     * @param 事業者番号 事業者番号
     * @param 理由書作成年月 理由書作成年月
     * @param checkFlag checkFlag
     * @return 広域内転居使用ことのパラメータ
     */
    public static SeikyuShinsaShuseiTorokuMapperParameter createSelectByKeyParam(
            RString 事業者番号,
            RDate 理由書作成年月,
            boolean checkFlag) {
        boolean isチェックオンフラグ = false;
        boolean isチェックオフフラグ = false;
        boolean is事業者番号フラグ = false;
        boolean is理由書作成年月フラグ = false;
        if (!事業者番号.isNullOrEmpty()) {
            is事業者番号フラグ = true;
        }
        if (理由書作成年月 != null && !理由書作成年月.toDateString().isEmpty()) {
            is理由書作成年月フラグ = true;
        }

        if (checkFlag) {
            isチェックオンフラグ = true;
        } else {
            isチェックオフフラグ = true;
        }
        return new SeikyuShinsaShuseiTorokuMapperParameter(
                isチェックオンフラグ,
                isチェックオフフラグ,
                is事業者番号フラグ,
                is理由書作成年月フラグ,
                事業者番号,
                理由書作成年月
        );

    }
}
