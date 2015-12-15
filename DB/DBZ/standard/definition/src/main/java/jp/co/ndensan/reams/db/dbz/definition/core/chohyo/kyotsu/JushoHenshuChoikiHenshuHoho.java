package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所編集町域編集方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum JushoHenshuChoikiHenshuHoho {

    /**
     * コード:1 名称:住所_番地 略称:住所＋番地
     */
    住所足す番地("1", "住所_番地", "住所＋番地"),
    /**
     * コード:2 名称:行政区_番地 略称:行政区＋番地
     */
    行政区足す番地("2", "行政区_番地", "行政区＋番地"),
    /**
     * コード:3 名称:住所_番地_行政区 略称:住所＋番地、（行政区）
     */
    住所足す番地_行政区("3", "住所_番地_行政区", "住所＋番地、（行政区）"),
    /**
     * コード:4 名称:番地のみ 略称:番地のみ
     */
    番地のみ("4", "番地のみ", "番地のみ"),
    /**
     * コード:5 名称:表示なし 略称:表示なし(住所は印字しない)
     */
    表示なし_住所は印字しない("5", "表示なし", "表示なし(住所は印字しない)");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private JushoHenshuChoikiHenshuHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 住所編集町域編集方法のコードを返します。
     *
     * @return 住所編集町域編集方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 住所編集町域編集方法の名称を返します。
     *
     * @return 住所編集町域編集方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住所編集町域編集方法の略称を返します。
     *
     * @return 住所編集町域編集方法の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 住所編集町域編集方法のコードと一致する内容を探します。
     *
     * @param code 住所編集町域編集方法のコード
     * @return {@code code} に対応する住所編集町域編集方法
     */
    public static JushoHenshuChoikiHenshuHoho toValue(RString code) {

        for (JushoHenshuChoikiHenshuHoho jushoHenshuChoikiHenshuHoho : JushoHenshuChoikiHenshuHoho.values()) {
            if (jushoHenshuChoikiHenshuHoho.code.equals(code)) {
                return jushoHenshuChoikiHenshuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住所編集町域編集方法"));
    }
}
