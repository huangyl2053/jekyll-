/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyokihonchosascore;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 認定調査票（基本調査素点）を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosahyoKihonChosaScoreMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final int ninteichosaRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaRirekiNo int
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteichosahyoKihonChosaScoreMapperParameter(
            @lombok.NonNull ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo) {

        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaRirekiNo int
     * @return 認定調査票（基本調査素点）検索パラメータ
     */
    public static NinteichosahyoKihonChosaScoreMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo) {
        return new NinteichosahyoKihonChosaScoreMapperParameter(shinseishoKanriNo, ninteichosaRirekiNo);
    }
}
