/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanshujii;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタを特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public final class ShujiiIryoKikanShujiiParameter {

    /**
     * コンストラクタです。
     *
     * @param RString shichosonShokibetsuID
     * @param LasdecCode shichosonCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShujiiIryoKikanShujiiParameter(
            RString shichosonShokibetsuID,
            LasdecCode shichosonCode
    ) {
        requireNonNull(shichosonShokibetsuID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonShokibetsuID RString
     * @param shichosonCode LasdecCode
     * @return 身体手帳検索パラメータ
     */
    public static ShujiiIryoKikanShujiiParameter createSelectByKeyParam(
            RString shichosonShokibetsuID,
            LasdecCode shichosonCode) {
        return new ShujiiIryoKikanShujiiParameter(shichosonShokibetsuID, shichosonCode);
    }

}
