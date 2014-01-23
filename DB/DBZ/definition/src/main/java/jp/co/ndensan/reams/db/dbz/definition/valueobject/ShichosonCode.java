/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
//TODO n3327 三浦凌　ILocalGovernmentCodeがdefinitionに移動したら、アンコメントする。
//import jp.co.ndensan.reams.ur.urz.business.ILocalGovernmentCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護保険業務で利用する、5桁の市町村コードです。
 *
 * @author N3327 三浦 凌
 */
public class ShichosonCode {

    private final RString 市町村コード;

    /**
     * 指定した値から、市町村コードを生成します。
     *
     * @param コード 市町村コードの値
     */
    public ShichosonCode(RString コード) {
        this.市町村コード = Objects.requireNonNull(コード, Messages.E00003.replace("コード", "市町村コード").getMessage());
    }

//    /**
//     * 指定の地方公共団体コードから、市町村コードを生成します。
//     *
//     * @param 地方公共団体コード 地方公共団体コード
//     */
//    public ShichosonCode(ILocalGovernmentCode 地方公共団体コード) {
//        Objects.requireNonNull(地方公共団体コード, Messages.E00003.replace("地方公共団体コード", "市町村コード").getMessage());
//
//        //TODO N3327 三浦凌 以下の処理は、5桁のコードを取得するメソッドがILocalGovernmentCodeに作成されたら、そのメソッドに書き直す。
//        RString 都道府県コード = 地方公共団体コード.get都道府県コード();
//        RString 市区町村コード = 地方公共団体コード.get市区町村コード();
//        this.市町村コード = compose市町村コード(都道府県コード, 市区町村コード);
//    }
    /**
     * コードを取得します。
     *
     * @return 市町村コードの値
     */
    public RString getValue() {
        return 市町村コード;
    }

    @Override
    public String toString() {
        return 市町村コード.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ShichosonCode)) {
            return false;
        }
        ShichosonCode 比較対象 = (ShichosonCode) obj;
        return 比較対象.getValue().equals(市町村コード);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.getValue());
        return hash;
    }

    private RString compose市町村コード(final RString 都道府県コード, final RString 市区町村コード) {
        RStringBuilder code = new RStringBuilder();
        code.append(都道府県コード);
        code.append(市区町村コード);
        return code.toRString();
    }
}
