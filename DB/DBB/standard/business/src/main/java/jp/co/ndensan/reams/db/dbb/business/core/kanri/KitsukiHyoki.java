/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import jp.co.ndensan.reams.db.dbb.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 期と月を使用して文字列を編集します。
 */
public class KitsukiHyoki {

    public static final KitsukiHyoki EMPTY = new KitsukiHyoki(Tsuki._1月, RString.EMPTY);
    private static final RString 文字列_期 = new RString("期");
    private static final RString 文字列_第 = new RString("第");
    private static final RString 括弧_左 = new RString("（");
    private static final RString 括弧_右 = new RString("）");

    private final Tsuki 月;
    private final RString 期;

    /**
     * コンストラクタです。
     *
     * @param 月 月
     * @param 期 期
     */
    public KitsukiHyoki(Tsuki 月, RString 期) {
        this.月 = 月;
        this.期 = 期;
    }

    /**
     * ”○期”という文字列に編集して返します。
     *
     * @return 編集した文字列
     */
    public RString asX期() {
        if (!RString.isNullOrEmpty(期)) {
            RStringBuilder sb = new RStringBuilder(期);
            sb.append(文字列_期);
            return sb.toRString();
        }
        return RString.EMPTY;
    }

    /**
     * ”第○期”という文字列に編集して返します。
     *
     * @return 編集した文字列
     */
    public RString as第X期() {
        if (!RString.isNullOrEmpty(期)) {
            RStringBuilder sb = new RStringBuilder(文字列_第);
            sb.append(期);
            sb.append(文字列_期);
            return sb.toRString();
        }
        return RString.EMPTY;
    }

    /**
     * ”第○○期”(2桁、0埋め)という文字列に編集して返します。
     *
     * @return 編集した文字列
     */
    public RString as第0X期() {
        if (!RString.isNullOrEmpty(期)) {
            RStringBuilder sb = new RStringBuilder(文字列_第);
            sb.append(期.padLeft(new RString("0"), 2));
            sb.append(文字列_期);
            return sb.toRString();
        }
        return RString.EMPTY;
    }

    /**
     * ”○期（○月）”という文字列に編集して返します。
     *
     * @return 編集した文字列
     */
    public RString asX期括弧X月() {
        if (!RString.isNullOrEmpty(期)) {
            RStringBuilder sb = new RStringBuilder(文字列_第);
            sb.append(期);
            sb.append(文字列_期);
            sb.append(括弧_左);
            sb.append(月.get名称());
            sb.append(括弧_右);
            return sb.toRString();
        }
        return RString.EMPTY;
    }
}
