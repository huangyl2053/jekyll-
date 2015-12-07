/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.shujiiIkenshoIraiJoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 主治医意見書作成依頼情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ShujiiIkenshoIraiJohoMapperParameter {

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
    private ShujiiIkenshoIraiJohoMapperParameter(
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
    public static ShujiiIkenshoIraiJohoMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo,
            int ikenshoIraiRirekiNo) {
        return new ShujiiIkenshoIraiJohoMapperParameter(shinseishoKanriNo, ikenshoIraiRirekiNo, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @return 身体手帳検索パラメータ
     */
    public static ShujiiIkenshoIraiJohoMapperParameter createSelectListParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new ShujiiIkenshoIraiJohoMapperParameter(shinseishoKanriNo, 0, true, false);
    }
}
