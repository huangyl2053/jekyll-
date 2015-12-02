/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariatejoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ShinsakaiWariateJohoMapperParameter {

    private final RString shinsakaiKaisaiNo;
    private final ShinseishoKanriNo shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo RString
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShinsakaiWariateJohoMapperParameter(
            RString shinsakaiKaisaiNo,
            ShinseishoKanriNo shinseishoKanriNo) {

        this.shinsakaiKaisaiNo = requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        this.shinseishoKanriNo = requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinsakaiKaisaiNo RString
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @return 身体手帳検索パラメータ
     */
    public static ShinsakaiWariateJohoMapperParameter createSelectByKeyParam(
            RString shinsakaiKaisaiNo,
            ShinseishoKanriNo shinseishoKanriNo) {
        return new ShinsakaiWariateJohoMapperParameter(shinsakaiKaisaiNo, shinseishoKanriNo);
    }
}
