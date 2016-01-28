/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikaisaiyoteijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ShinsakaiKaisaiYoteiJohoMapperParameter {

    private final RString shinsakaiKaisaiNo;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo shinsakaiKaisaiNo
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShinsakaiKaisaiYoteiJohoMapperParameter(RString shinsakaiKaisaiNo) {

        this.shinsakaiKaisaiNo
                = requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinsakaiKaisaiNo shinsakaiKaisaiNo
     * @return 身体手帳検索パラメータ
     */
    public static ShinsakaiKaisaiYoteiJohoMapperParameter createSelectByKeyParam(RString shinsakaiKaisaiNo) {
        return new ShinsakaiKaisaiYoteiJohoMapperParameter(shinsakaiKaisaiNo);
    }

}
