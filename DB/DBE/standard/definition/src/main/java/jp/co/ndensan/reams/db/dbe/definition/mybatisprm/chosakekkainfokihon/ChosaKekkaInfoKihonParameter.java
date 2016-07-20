/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfokihon;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_基本調査のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosaKekkaInfoKihonParameter {

    private final RString shinseishoKanriNo;
    private final int ninteichosaRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ChosaKekkaInfoKihonParameter(
            RString shinseishoKanriNo,
            int ninteichosaRirekiNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 画面で入力した設定のパラメータを生成します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param ninteichosaRirekiNo 認定調査依頼履歴番号
     * @return 画面で入力した設定パラメータ
     */
    public static ChosaKekkaInfoKihonParameter createGamenParam(
            RString shinseishoKanriNo,
            int ninteichosaRirekiNo) {
        return new ChosaKekkaInfoKihonParameter(shinseishoKanriNo, ninteichosaRirekiNo);
    }
}
