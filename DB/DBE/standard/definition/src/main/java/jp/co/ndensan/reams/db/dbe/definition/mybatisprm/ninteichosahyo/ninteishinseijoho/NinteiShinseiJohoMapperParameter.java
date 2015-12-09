/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteishinseijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 要介護認定申請情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteiShinseiJohoMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteiShinseiJohoMapperParameter(
            @lombok.NonNull ShinseishoKanriNo shinseishoKanriNo) {
        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.shinseishoKanriNo = shinseishoKanriNo;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @return 要介護認定申請情報検索パラメータ
     */
    public static NinteiShinseiJohoMapperParameter createSelectByKeyParam(
            ShinseishoKanriNo shinseishoKanriNo) {
        return new NinteiShinseiJohoMapperParameter(shinseishoKanriNo);
    }
}
