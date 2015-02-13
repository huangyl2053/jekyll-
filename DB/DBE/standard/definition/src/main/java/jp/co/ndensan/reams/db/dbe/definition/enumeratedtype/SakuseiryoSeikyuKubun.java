/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 作成料請求区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum SakuseiryoSeikyuKubun {

    /**
     * 作成料請求区分が「在宅新規」であることを表します。<br />
     * コード : 11
     */
    在宅新規(new RString("11")),
    /**
     * 作成料請求区分が「在宅継続」であることを表します。<br />
     * コード : 12
     */
    在宅継続(new RString("12")),
    /**
     * 作成料請求区分が「施設新規」であることを表します。<br />
     * コード : 21
     */
    施設新規(new RString("21")),
    /**
     * 作成料請求区分が「施設継続」であることを表します。<br />
     * コード : 22
     */
    施設継続(new RString("22"));
    private RString code;

    private SakuseiryoSeikyuKubun(RString code) {
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
     * 引数のコードに対応する作成料請求区分を返します。
     *
     * @param code コード
     * @return 作成料請求区分
     */
    public static SakuseiryoSeikyuKubun toValue(RString code) {
        for (SakuseiryoSeikyuKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する作成料請求区分").evaluate());
    }
}
