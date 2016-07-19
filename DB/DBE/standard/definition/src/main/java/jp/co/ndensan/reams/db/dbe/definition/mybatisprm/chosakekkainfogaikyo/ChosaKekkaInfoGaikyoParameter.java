/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_概況調査のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosaKekkaInfoGaikyoParameter {

    private final RString shinseishoKanriNo;
    private final int ninteichosaRirekiNo;
    private final RString gaikyoChosaTextImageKubun;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況調査テキスト_イメージ区分 概況調査テキスト_イメージ区分
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ChosaKekkaInfoGaikyoParameter(
            RString shinseishoKanriNo,
            int ninteichosaRirekiNo,
            RString gaikyoChosaTextImageKubun) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
        this.gaikyoChosaTextImageKubun = gaikyoChosaTextImageKubun;
    }

    /**
     * 画面で入力した設定のパラメータを生成します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param ninteichosaRirekiNo 認定調査依頼履歴番号
     * @param gaikyoChosaTextImageKubun 概況調査テキスト_イメージ区分
     * @return 画面で入力した設定パラメータ
     */
    public static ChosaKekkaInfoGaikyoParameter createGamenParam(
            RString shinseishoKanriNo,
            int ninteichosaRirekiNo,
            RString gaikyoChosaTextImageKubun) {
        return new ChosaKekkaInfoGaikyoParameter(shinseishoKanriNo, ninteichosaRirekiNo, gaikyoChosaTextImageKubun);
    }
}
