/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.code;

import jp.co.ndensan.reams.ur.urz.definition.code.ICodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * コード種別を表す列挙型です。
 *
 * @author n8187 久保田 英男
 */
public enum DBACodeShubetsu implements ICodeShubetsu {

    /**
     * 医療保険種類
     */
    医療保険種類("0001", IryoHokenShurui.class),
    /**
     * 被保険者証交付事由
     */
    被保険者証交付事由("0002", HihokenshashoKofuJiyu.class),
    /**
     * 被保険者証回収事由
     */
    被保険者証回収事由("0003", HihokenshashoKaishuJiyu.class),
    /**
     * 資格者証交付事由
     */
    資格者証交付事由("0004", ShikakushashoKofuJiyu.class),
    /**
     * 資格者証回収事由
     */
    資格者証回収事由("0005", ShikakushashoKaishuJiyu.class);

    private final SubGyomuCode subGyomuCode = SubGyomuCode.DBA介護資格;
    private final CodeShubetsu codeShubetsu;
    private final Class returnType;

    private DBACodeShubetsu(String codeShubetsu, Class returnType) {
        this.codeShubetsu = new CodeShubetsu(codeShubetsu);
        this.returnType = returnType;
    }

    @Override
    public CodeShubetsu getCodeShubetsu() {
        return codeShubetsu;
    }

    @Override
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    @Override
    public Class getReturnType() {
        return returnType;
    }
}
