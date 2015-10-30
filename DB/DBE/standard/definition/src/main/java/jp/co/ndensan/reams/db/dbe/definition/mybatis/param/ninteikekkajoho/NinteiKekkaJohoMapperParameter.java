/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteiKekkaJohoMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteiKekkaJohoMapperParameter(
            ShinseishoKanriNo shinseishoKanriNo) {

        this.shinseishoKanriNo = requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
    }

    /**
     * 要介護認定結果情報を特定するためのMyBatis用パラメータを生成します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 要介護認定結果情報を特定するためのMyBatis用パラメータ
     */
    public static NinteiKekkaJohoMapperParameter createParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new NinteiKekkaJohoMapperParameter(shinseishoKanriNo);
    }

}
