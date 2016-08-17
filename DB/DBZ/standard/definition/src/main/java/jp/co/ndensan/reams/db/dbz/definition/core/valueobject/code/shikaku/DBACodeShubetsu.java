/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku;

import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.code.ICodeShubetsu;

/**
 * コード種別を表す列挙型クラスです。
 *
 * @author n8187 久保田 英男
 */
public enum DBACodeShubetsu implements ICodeShubetsu {

    /**
     * 医療保険種類。
     */
    医療保険種類("0001", IryoHokenShurui.class),
    /**
     * 被保険者証交付事由。
     */
    被保険者証交付事由("0002", HihokenshashoKofuJiyu.class),
    /**
     * 被保険者証回収事由。
     */
    被保険者証回収事由("0003", HihokenshashoKaishuJiyu.class),
    /**
     * 資格者証交付事由。
     */
    資格者証交付事由("0004", ShikakushashoKofuJiyu.class),
    /**
     * 資格者証回収事由。
     */
    資格者証回収事由("0005", ShikakushashoKaishuJiyu.class),
    /**
     * 交付証種類。 クラスは未実装
     */
    交付証種類("0006", IryoHokenShurui.class),
    /**
     * 介護資格取得事由_被保険者。 クラスは未実装
     */
    介護資格取得事由_被保険者("0007", ShikakuShutokuJiyuHihokensha.class),
    /**
     * 介護資格適用事由_他特例者。 クラスは未実装
     */
    介護資格適用事由_他特例者("0008", IryoHokenShurui.class), /**
     * 介護資格適用事由_除外者。 クラスは未実装
     */
    介護資格適用事由_除外者("0009", IryoHokenShurui.class),
    /**
     * 介護資格喪失事由_被保険者。 クラスは未実装
     */
    介護資格喪失事由_被保険者("0010", ShikakuSositsuJiyuHihokensha.class),
    /**
     * 介護資格解除事由_他特例者。 クラスは未実装
     */
    介護資格解除事由_他特例者("0011", IryoHokenShurui.class),
    /**
     * 介護資格解除事由_除外者。 クラスは未実装
     */
    介護資格解除事由_除外者("0012", IryoHokenShurui.class),
    /**
     * 介護資格変更事由_被保険者。 クラスは未実装
     */
    介護資格変更事由_被保険者("0013", IryoHokenShurui.class),
    /**
     * 介護資格住特適用。 クラスは未実装
     */
    介護資格住特適用("0014", IryoHokenShurui.class),
    /**
     * 介護資格住特解除。 クラスは未実装
     */
    介護資格住特解除("0015", IryoHokenShurui.class),
    /**
     * 介護資格住特解除。 クラスは未実装
     */
    負担割合証交付事由("0016", IryoHokenShurui.class);

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
