package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 内部帳票文字切れ制御を表す列挙型です。
 *
 * @author LDNS
 */
public enum NaibuChohyoMojigireSeigyo {

    /**
     * コード:1 名称:印字可能範囲まで印字する 略称:印字可能範囲まで印字する
     */
    印字可能範囲まで印字する("1", "印字可能範囲まで印字する", "印字可能範囲まで印字する"),
    /**
     * コード:2 名称:オーバーフロー文字を印字する 略称:ｵｰﾊﾞｰﾌﾛｰ文字を印字する
     */
    ｵｰﾊﾞｰﾌﾛｰ文字を印字する("2", "オーバーフロー文字を印字する", "ｵｰﾊﾞｰﾌﾛｰ文字を印字する");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private NaibuChohyoMojigireSeigyo(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 内部帳票文字切れ制御のコードを返します。
     *
     * @return 内部帳票文字切れ制御のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 内部帳票文字切れ制御の名称を返します。
     *
     * @return 内部帳票文字切れ制御の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 内部帳票文字切れ制御の略称を返します。
     *
     * @return 内部帳票文字切れ制御の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 内部帳票文字切れ制御のコードと一致する内容を探します。
     *
     * @param code 内部帳票文字切れ制御のコード
     * @return {@code code} に対応する内部帳票文字切れ制御
     */
    public static NaibuChohyoMojigireSeigyo toValue(RString code) {

        for (NaibuChohyoMojigireSeigyo naibuChohyoMojigireSeigyo : NaibuChohyoMojigireSeigyo.values()) {
            if (naibuChohyoMojigireSeigyo.code.equals(code)) {
                return naibuChohyoMojigireSeigyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("内部帳票文字切れ制御"));
    }
}
