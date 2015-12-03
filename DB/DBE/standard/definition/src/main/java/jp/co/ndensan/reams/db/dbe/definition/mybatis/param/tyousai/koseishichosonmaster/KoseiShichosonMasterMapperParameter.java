/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.koseishichosonmaster;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタを特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KoseiShichosonMasterMapperParameter {

    private final RString shichosonShokibetsuID;

    private final boolean usesShichosonShokibetsuID;

    /**
     * コンストラクタです。
     *
     * @param shichosonShokibetsuID shichosonShokibetsuID
     * @param usesShichosonShokibetsuID usesShichosonShokibetsuID
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KoseiShichosonMasterMapperParameter(RString shichosonShokibetsuID,
            boolean usesShichosonShokibetsuID) {
        requireNonNull(shichosonShokibetsuID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        this.shichosonShokibetsuID = shichosonShokibetsuID;

        this.usesShichosonShokibetsuID = usesShichosonShokibetsuID;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonShokibetsuID shichosonShokibetsuID
     * @return 構成市町村マスタパラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectByKeyParam(
            RString shichosonShokibetsuID) {
        return new KoseiShichosonMasterMapperParameter(shichosonShokibetsuID, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param shichosonShokibetsuID shichosonShokibetsuID
     * @return 構成市町村マスタパラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectListParam(
            RString shichosonShokibetsuID) {
        return new KoseiShichosonMasterMapperParameter(shichosonShokibetsuID, false);
    }
}
