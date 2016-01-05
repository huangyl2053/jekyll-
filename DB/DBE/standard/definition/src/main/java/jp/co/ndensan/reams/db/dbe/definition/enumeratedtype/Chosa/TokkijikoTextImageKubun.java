package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項テキスト・イメージ区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokkijikoTextImageKubun {

    /**
     * コード:1 名称:テキスト 略称:定義なし
     */
    テキスト("1", "テキスト"),
    /**
     * コード:2 名称:イメージ 略称:定義なし
     */
    イメージ("2", "イメージ");

    private final RString code;
    private final RString fullName;

    private TokkijikoTextImageKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特記事項テキスト・イメージ区分のコードを返します。
     *
     * @return 特記事項テキスト・イメージ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特記事項テキスト・イメージ区分の名称を返します。
     *
     * @return 特記事項テキスト・イメージ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特記事項テキスト・イメージ区分のコードと一致する内容を探します。
     *
     * @param code 特記事項テキスト・イメージ区分のコード
     * @return {@code code} に対応する特記事項テキスト・イメージ区分
     */
    public static TokkijikoTextImageKubun toValue(RString code) {

        for (TokkijikoTextImageKubun tokkijikoTextImageKubun : TokkijikoTextImageKubun.values()) {
            if (tokkijikoTextImageKubun.code.equals(code)) {
                return tokkijikoTextImageKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特記事項テキスト・イメージ区分"));
    }
}
