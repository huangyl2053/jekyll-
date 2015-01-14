/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.code.ICodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * コード種別を表す列挙型です。
 *
 * @author n3327 三浦 凌
 */
public enum DBZCodeShubetsu implements ICodeShubetsu {

    /**
     * 調定事由
     */
    調定事由("0001", ChoteiJiyu.class),
    /**
     * 保険料減免種類
     */
    保険料減免種類("0002", HokenryoGemmenShurui.class),
    /**
     * 保険料徴収猶予種類
     */
    保険料徴収猶予種類("0003", HokenryoChoshuYuyoShurui.class),
    /**
     * 保険料減免取消種類
     */
    保険料減免取消種類("0004", HokenryoGemmenTorikeshiShurui.class),
    /**
     * 保険料徴収猶予取消種類
     */
    保険料徴収猶予取消種類("0005", HokenryoChoshuYuyoTorikeshiShurui.class),
    /**
     * 特別徴収停止事由
     */
    特別徴収停止事由("0006", TokubetsuChoshuTeishiJiyu.class);

    private final SubGyomuCode subGyomuCode = SubGyomuCode.DBZ介護共通;
    private final CodeShubetsu codeShubetsu;
    private final Class returnType;

    private DBZCodeShubetsu(String codeShubetsu, Class returnType) {
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
