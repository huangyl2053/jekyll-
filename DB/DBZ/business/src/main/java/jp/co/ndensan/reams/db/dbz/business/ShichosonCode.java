/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.business.ILocalGovernmentCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護保険業務で利用する、5桁の市町村コードです。
 *
 * @author N3327 三浦 凌
 */
public class ShichosonCode {

    private final RString code;

    /**
     * 指定した値から、市町村コードを作成します。
     *
     * @param コード 市町村コードの値
     */
    public ShichosonCode(RString コード) {
        this.code = Objects.requireNonNull(コード, Messages.E00003.replace("コード", "市町村コード").getMessage());
    }

    /**
     * 指定の地方公共団体コードから、市町村コードを作成します。
     *
     * @param 地方公共団体コード
     */
    public ShichosonCode(ILocalGovernmentCode 地方公共団体コード) {
        Objects.requireNonNull(地方公共団体コード, Messages.E00003.replace("地方公共団体コード", "市町村コード").getMessage());

        //TODO N3327 三浦凌 以下の処理は、5桁のコードを取得するメソッドがILocalGovernmentCodeに作成されたら、そのメソッドに委譲する。
        RString 都道府県コード = 地方公共団体コード.get都道府県コード();
        RString 市区町村コード = 地方公共団体コード.get市区町村コード();

        this.code = make市町村コードFrom(都道府県コード, 市区町村コード);
    }

    /**
     * コードを取得します。
     *
     * @return 市町村コードの値
     */
    public RString getCode() {
        return code;
    }

    private RString make市町村コードFrom(final RString 都道府県コード, final RString 市区町村コード) {
        RStringBuilder 市町村コード = new RStringBuilder();
        市町村コード.append(都道府県コード);
        市町村コード.append(市区町村コード);
        return 市町村コード.toRString();
    }
}
