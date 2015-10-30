
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.code;

import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.IryoHokenShurui;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.ShutokuJiyuHihokensha;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.ShutokuJiyuJogaiTekiyo;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.ShutokuJiyuTatokuJogai;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.ShutokuJiyuTatokuTekiyo;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.SoshitsuJiyuHihokensha;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.SoshitsuJiyuJogaiTekiyo;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.SoshitsuJiyuTatokuJogai;
import jp.co.ndensan.reams.db.dba.business.core.codeassigneditem.SoshitsuJiyuTatokuTekiyo;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;

/**
 * コード種別を表す列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DBACodeShubetsu {

    /**
     * 取得事由_被保険者。
     */
    取得事由_被保険者("0001", ShutokuJiyuHihokensha.class),
    /**
     * 取得事由_他特適用。
     */
    取得事由_他特適用("0002", ShutokuJiyuTatokuTekiyo.class),
    /**
     * 取得事由_除外適用。
     */
    取得事由_除外適用("0003", ShutokuJiyuJogaiTekiyo.class),
    /**
     * 取得事由_他特除外。
     */
    取得事由_他特除外("0004", ShutokuJiyuTatokuJogai.class),
    /**
     * 喪失事由_被保険者。
     */
    喪失事由_被保険者("0005", SoshitsuJiyuHihokensha.class),
    /**
     * 喪失事由_他特適用。
     */
    喪失事由_他特適用("0006", SoshitsuJiyuTatokuTekiyo.class),
    /**
     * 喪失事由_除外適用。
     */
    喪失事由_除外適用("0007", SoshitsuJiyuJogaiTekiyo.class),
    /**
     * 喪失事由_他特除外。
     */
    喪失事由_他特除外("0008", SoshitsuJiyuTatokuJogai.class),
    /**
     * 医療保険種類。
     */
    医療保険種類("0009", IryoHokenShurui.class);

    private final CodeShubetsu codeShubetsu;
    private final Class returnType;

    private DBACodeShubetsu(String code, Class returnType) {
        this.codeShubetsu = new CodeShubetsu(code);
        this.returnType = returnType;
    }

    public CodeShubetsu getCodeShubetsu() {
        return codeShubetsu;
    }

    public Class getReturnType() {
        return returnType;
    }

}
