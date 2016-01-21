/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金保険者判定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NenkinHokenshaHanteiParameter {

    private final RString choshuGimushaCode;

    /**
     * コンストラクタです。
     *
     * @param choshuGimushaCode 特別徴収義務者コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NenkinHokenshaHanteiParameter(
            RString choshuGimushaCode) {

        this.choshuGimushaCode = requireNonNull(choshuGimushaCode, UrSystemErrorMessages.値がnull.getReplacedMessage("特別徴収義務者コード"));
    }

    /**
     * 年金保険者判定するためのMyBatis用パラメータを生成します。
     *
     * @param choshuGimushaCode 特別徴収義務者コード
     * @return 年金保険者判定するためのMyBatis用パラメータ
     */
    public static NenkinHokenshaHanteiParameter createParam(
            RString choshuGimushaCode) {
        return new NenkinHokenshaHanteiParameter(choshuGimushaCode);
    }
}
