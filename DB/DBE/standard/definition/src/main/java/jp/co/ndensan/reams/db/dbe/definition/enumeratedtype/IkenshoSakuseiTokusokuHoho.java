/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成督促方法を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum IkenshoSakuseiTokusokuHoho {

    /**
     * 意見書作成督促方法が「督促状郵送」であることを表します。<br />
     * コード : 1
     */
    督促状郵送(new RString("1")),
    /**
     * 意見書作成督促方法が「督促状ＦＡＸ」であることを表します。<br />
     * コード : 2
     */
    督促状ＦＡＸ(new RString("2")),
    /**
     * 意見書作成督促方法が「電話」であることを表します。<br />
     * コード : 3
     */
    電話(new RString("3")),
    /**
     * 意見書作成督促方法が「その他」であることを表します。<br />
     * コード : 4
     */
    その他(new RString("4"));
    private RString code;

    private IkenshoSakuseiTokusokuHoho(RString code) {
        this.code = code;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 引数のコードに対応する意見書作成督促方法を返します。
     *
     * @param code コード
     * @return 意見書作成督促方法
     */
    public static IkenshoSakuseiTokusokuHoho toValue(RString code) {
        for (IkenshoSakuseiTokusokuHoho data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する意見書作成督促方法").getMessage());
    }
}
