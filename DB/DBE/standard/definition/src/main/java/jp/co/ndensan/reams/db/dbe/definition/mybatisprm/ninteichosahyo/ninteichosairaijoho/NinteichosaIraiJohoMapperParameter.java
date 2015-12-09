/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosairaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 認定調査依頼情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteichosaIraiJohoMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final int ninteichosaIraiRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaIraiRirekiNo int
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteichosaIraiJohoMapperParameter(
            @lombok.NonNull ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaIraiRirekiNo) {

        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaIraiRirekiNo int
     * @return 認定調査依頼情報検索パラメータ
     */
    public static NinteichosaIraiJohoMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaIraiRirekiNo) {
        return new NinteichosaIraiJohoMapperParameter(shinseishoKanriNo, ninteichosaIraiRirekiNo);
    }
}
