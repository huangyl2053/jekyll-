/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code;

import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.code.ICodeShubetsu;

/**
 * コード種別を表す列挙型クラスです。
 *
 * @author N8156 宮本 康
 */
public enum DBZCodeShubetsu implements ICodeShubetsu {

    /**
     * 調定事由コード。
     */
    調定事由コード("0001", ChoteiJiyuCode.class);

    private final SubGyomuCode subGyomuCode = SubGyomuCode.DBZ介護共通;
    private final CodeShubetsu codeShubetsu;
    private final Class returnType;

    private DBZCodeShubetsu(String codeShubetsu, Class returnType) {
        this.codeShubetsu = new CodeShubetsu(codeShubetsu);
        this.returnType = returnType;
    }

    /**
     * getCodeShubetsuを取得します。
     *
     * @return codeShubetsu
     */
    @Override
    public CodeShubetsu getCodeShubetsu() {
        return codeShubetsu;
    }

    /**
     * getSubGyomuCodeを取得します。
     *
     * @return subGyomuCode
     */
    @Override
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * getReturnTypeを取得します。
     *
     * @return returnType
     */
    @Override
    public Class getReturnType() {
        return returnType;
    }
}
