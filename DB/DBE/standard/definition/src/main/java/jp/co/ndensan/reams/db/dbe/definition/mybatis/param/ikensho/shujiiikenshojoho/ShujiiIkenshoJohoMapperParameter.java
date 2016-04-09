/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.shujiiikenshojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 要介護認定主治医意見書情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIkenshoJohoMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final int ikenshoIraiRirekiNo;

    private final boolean usesShinseishoKanriNo;
    private final boolean usesIkenshoIraiRirekiNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     * @param usesShinseishoKanriNo usesShinseishoKanriNo
     * @param usesIkenshoIraiRirekiNo usesIkenshoIraiRirekiNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShujiiIkenshoJohoMapperParameter(
            ShinseishoKanriNo shinseishoKanriNo,
            int ikenshoIraiRirekiNo,
            boolean usesShinseishoKanriNo,
            boolean usesIkenshoIraiRirekiNo) {

        this.shinseishoKanriNo = requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;

        this.usesShinseishoKanriNo = usesShinseishoKanriNo;
        this.usesIkenshoIraiRirekiNo = usesIkenshoIraiRirekiNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     * @return 身体手帳検索パラメータ
     */
    public static ShujiiIkenshoJohoMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo,
            int ikenshoIraiRirekiNo) {
        return new ShujiiIkenshoJohoMapperParameter(shinseishoKanriNo, ikenshoIraiRirekiNo, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @return 身体手帳検索パラメータ
     */
    public static ShujiiIkenshoJohoMapperParameter createSelectListParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new ShujiiIkenshoJohoMapperParameter(shinseishoKanriNo, 0, true, false);
    }
}
