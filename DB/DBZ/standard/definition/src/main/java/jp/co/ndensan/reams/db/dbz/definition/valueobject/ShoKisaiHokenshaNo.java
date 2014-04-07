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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
//import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護保険業務で利用する、6桁の証記載保険者番号です。
 *
 * @author N3327 三浦 凌
 */
public class ShoKisaiHokenshaNo implements IDbColumnMappable {

    private final RString 証記載保険者番号;

    /**
     * 指定した値から、証記載保険者番号を生成します。
     *
     * @param コード 証記載保険者番号の値
     */
    public ShoKisaiHokenshaNo(RString コード) {
        this.証記載保険者番号 = Objects.requireNonNull(コード, Messages.E00003.replace("コード", "証記載保険者番号").getMessage());
    }

//    /**
//     * 指定の地方公共団体コードから、証記載保険者番号を生成します。
//     *
//     * @param 地方公共団体コード 地方公共団体コード
//     */
//    public ShoKisaiHokenshaNo(ILocalGovernmentCode 地方公共団体コード) {
//        Objects.requireNonNull(地方公共団体コード, Messages.E00003.replace("地方公共団体コード", "証記載保険者番号").getMessage());
//
//        //TODO N3327 三浦凌 以下の処理は、5桁のコードを取得するメソッドがILocalGovernmentCodeに作成されたら、そのメソッドに書き直す。
//        RString 都道府県コード = 地方公共団体コード.get都道府県コード();
//        RString 市区町村コード = 地方公共団体コード.get市区町村コード();
//        this.証記載保険者番号 = compose証記載保険者番号(都道府県コード, 市区町村コード);
//    }
    /**
     * コードを取得します。
     *
     * @return 証記載保険者番号の値
     */
    public RString getValue() {
        return 証記載保険者番号;
    }

    @Override
    public String toString() {
        return 証記載保険者番号.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ShoKisaiHokenshaNo)) {
            return false;
        }
        ShoKisaiHokenshaNo 比較対象 = (ShoKisaiHokenshaNo) obj;
        return 比較対象.getValue().equals(証記載保険者番号);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.getValue());
        return hash;
    }
//    private RString compose証記載保険者番号(final RString 都道府県コード, final RString 市区町村コード) {
//        RStringBuilder code = new RStringBuilder();
//        code.append(都道府県コード);
//        code.append(市区町村コード);
//        return code.toRString();
//    }

    @Override
    public RString getColumnValue() {
        return 証記載保険者番号;
    }
}
