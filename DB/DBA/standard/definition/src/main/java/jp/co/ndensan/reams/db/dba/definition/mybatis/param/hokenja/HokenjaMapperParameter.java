/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hokenja;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 保険者情報のパラメータです。
 */
public final class HokenjaMapperParameter {

    private final HokenjaNo hokenjaNo;
    private final RString kenCode;

    /**
     * 非公開コンストラクタです。
     *
     * @param hokenjaNo 保険者番号
     * @param kenCode 県コード
     */
    private HokenjaMapperParameter(
            HokenjaNo hokenjaNo,
            RString kenCode) {
        this.hokenjaNo = requireNonNull(hokenjaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        this.kenCode = requireNonNull(kenCode, UrSystemErrorMessages.値がnull.getReplacedMessage("県コード"));
    }

    /**
     * 保険者情報特定用のパラメータを生成します。
     *
     * @param hokenjaNo 保険者番号
     * @return 保険者検索パラメータ
     */
    public static HokenjaMapperParameter createHokenjaNoParam(
            HokenjaNo hokenjaNo) {
        return new HokenjaMapperParameter(
                hokenjaNo,
                RString.EMPTY
        );
    }

    /**
     * 保険者情報特定用のパラメータを生成します。
     *
     * @param kenCode 県コード
     * @return 保険者検索パラメータ
     */
    public static HokenjaMapperParameter createKenCodeParam(
            RString kenCode) {
        return new HokenjaMapperParameter(
                new HokenjaNo(RString.EMPTY),
                kenCode
        );
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenjaNo getHokenjaNo() {
        return hokenjaNo;
    }

    /**
     * 県コードを返します。
     *
     * @return 県コード
     */
    public RString getKenCode() {
        return kenCode;
    }

}
