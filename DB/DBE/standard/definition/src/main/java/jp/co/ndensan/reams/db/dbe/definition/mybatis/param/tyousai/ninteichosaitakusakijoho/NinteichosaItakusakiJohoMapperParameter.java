/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.ninteichosaitakusakijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteichosaItakusakiJohoMapperParameter {

    private final LasdecCode shichosonCode;
    private final RString ninteichosaItakusakiCode;

    private final boolean usesShichosonCode;
    private final boolean usesNinteichosaItakusakiCode;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode shichosonCode
     * @param ninteichosaItakusakiCode ninteichosaItakusakiCode
     * @param usesShichosonCode usesShichosonCode
     * @param usesNinteichosaItakusakiCode usesNinteichosaItakusakiCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteichosaItakusakiJohoMapperParameter(LasdecCode shichosonCode,
            RString ninteichosaItakusakiCode,
            boolean usesShichosonCode,
            boolean usesNinteichosaItakusakiCode) {
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(ninteichosaItakusakiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        this.shichosonCode = shichosonCode;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.usesShichosonCode = usesShichosonCode;
        this.usesNinteichosaItakusakiCode = usesNinteichosaItakusakiCode;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonCode shichosonCode
     * @param ninteichosaItakusakiCode ninteichosaItakusakiCode
     * @return 認定調査委託先情報パラメータ
     */
    public static NinteichosaItakusakiJohoMapperParameter createSelectByKeyParam(
            LasdecCode shichosonCode,
            RString ninteichosaItakusakiCode) {
        return new NinteichosaItakusakiJohoMapperParameter(shichosonCode, ninteichosaItakusakiCode, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param shichosonCode shichosonCode
     * @param ninteichosaItakusakiCode ninteichosaItakusakiCode
     * @return 認定調査委託先情報パラメータ
     */
    public static NinteichosaItakusakiJohoMapperParameter createSelectListParam(
            LasdecCode shichosonCode,
            RString ninteichosaItakusakiCode) {
        return new NinteichosaItakusakiJohoMapperParameter(shichosonCode, ninteichosaItakusakiCode, true, false);
    }
}
