/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 *
 * @author N3327 三浦 凌
 */
public enum T1001HihokenshaDaicho implements IColumnDefinition {

    ShichosonCd(5, 0),
    HihokenshaNo(10, 0),
    ShikibetsuCode(15, 0),
    ShikakuIdouKubunCode(5, 0),
    ShikakuShutokuTodokedeDate(8, 0),
    ShikakuShutokuJiyuCode(3, 0),
    ShikakuShutokuDate(8, 0),
    IchigoHihokenshaNenreiTotatsuDate(8, 0),
    HihokennshaKubunCode(1, 0),
    ShikakuSoshitsuJiyuCode(3, 0),
    ShikakuSoshitsuTodokedeDate(8, 0),
    ShikakuSoshitsuDate(8, 0),
    ShikakuHenkoJiyuCode(3, 0),
    ShikakuHenkoTodokedeDate(8, 0),
    ShikakuHenkoDate(8, 0),
    JushochiTokureiTekiyoJiyuCode(3, 0),
    TekiyoTodokedeDate(8, 0),
    TekiyoDate(8, 0),
    JushochiTokureiSochiShichosonCd(5, 0),
    JushochiTokureikaijoJiyuCode(3, 0),
    KaijoTodokedeDate(8, 0),
    KaijoDate(8, 0),
    JushochiTokureiFlag(1, 0),
    KoikinaiJushochiTokureiFlag(1, 0),
    KoikinaiTokureiSochimotoShichosonCd(5, 0),
    SaikofuKubun(1, 0),
    SaikofuJiyuCode(3, 0);
    private final int maxLength;
    private final int scale;

    private T1001HihokenshaDaicho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getScale() {
        return scale;
    }
}
