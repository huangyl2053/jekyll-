/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.seikyushinsashuseitoroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)ことのパラメータクラスです
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SeikyuShinsaShuseiTorokuMapperParameter {

    private final boolean メニューID_1004;
    private final boolean メニューID_1005;
    private final boolean チェックオンフラグ;
    private final boolean チェックオフフラグ;
    private final boolean 事業者番号フラグ;
    private final boolean 理由書作成年月フラグ;
    private final RString 事業者番号;
    private final RString 請求情報作成年月;
    private static final RString DBCMNE_1004 = new RString("DBCMNE1004");
    private static final RString DBCMNE_1005 = new RString("DBCMNE1005");

    private SeikyuShinsaShuseiTorokuMapperParameter(
            boolean isチェックオンフラグ,
            boolean isチェックオフフラグ,
            boolean isメニューID_1004,
            boolean isメニューID_1005,
            boolean is事業者番号フラグ,
            boolean is理由書作成年月フラグ,
            RString 事業者番号,
            RString 請求情報作成年月) {
        this.チェックオンフラグ = isチェックオンフラグ;
        this.チェックオフフラグ = isチェックオフフラグ;
        this.メニューID_1004 = isメニューID_1004;
        this.メニューID_1005 = isメニューID_1005;
        this.事業者番号フラグ = is事業者番号フラグ;
        this.理由書作成年月フラグ = is理由書作成年月フラグ;
        this.事業者番号 = 事業者番号;
        this.請求情報作成年月 = 請求情報作成年月;
    }

    /**
     * キー検索用のパラメータを生成します
     *
     * @param 事業者番号 事業者番号
     * @param 請求情報作成年月 請求情報作成年月
     * @param checkFlag checkFlag
     * @return 広域内転居使用ことのパラメータ
     */
    public static SeikyuShinsaShuseiTorokuMapperParameter createSelectByKeyParam(
            RString 事業者番号,
            RString 請求情報作成年月,
            boolean checkFlag) {
        boolean チェックオンフラグ = false;
        boolean チェックオフフラグ = false;
        boolean メニューID_1004 = false;
        boolean メニューID_1005 = false;
        boolean 事業者番号フラグ = false;
        boolean 理由書作成年月フラグ = false;
        if (事業者番号 != null && !事業者番号.isEmpty()) {
            事業者番号フラグ = true;
        }
        if (!RString.isNullOrEmpty(請求情報作成年月)) {
            理由書作成年月フラグ = true;
        }
        if (checkFlag) {
            チェックオンフラグ = true;
        } else {
            チェックオフフラグ = false;
        }
        if (DBCMNE_1004.equals(ResponseHolder.getMenuID())) {
            メニューID_1004 = true;
        }
        if (DBCMNE_1005.equals(ResponseHolder.getMenuID()) && チェックオンフラグ) {
            メニューID_1005 = true;
        }
        return new SeikyuShinsaShuseiTorokuMapperParameter(
                メニューID_1004,
                メニューID_1005,
                チェックオンフラグ,
                チェックオフフラグ,
                事業者番号フラグ,
                理由書作成年月フラグ,
                事業者番号,
                請求情報作成年月
        );
    }
}
