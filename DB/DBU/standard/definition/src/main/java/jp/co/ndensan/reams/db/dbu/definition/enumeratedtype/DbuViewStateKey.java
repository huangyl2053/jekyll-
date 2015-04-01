package jp.co.ndensan.reams.db.dbu.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告年報補正表示をViewStateす列挙型です。
 *
 */
public enum DbuViewStateKey {

    /**
     * 名称:補正検索画面情報
     */
    補正検索画面情報("補正検索画面情報"),
    /**
     * 未定義：（△）を表す列挙体です。
     * <p/>
     * コードには空白（nullでない）が定義されます。
     */
    未定義("");
    private final RString code;

    private DbuViewStateKey(String code) {
        this.code = new RString(code);
    }

    public RString code() {
        return code;
    }

    public RString toRString() {
        return new RString(this.toString());
    }

    /**
     * 引数のコードに対応する列挙型を返します。
     * <p/>
     * 該当する列挙型がない場合はnullを返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static DbuViewStateKey toValue(RString code) {
        if (code == null) {
            return 未定義;
        }
        for (DbuViewStateKey target : DbuViewStateKey.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("ViewStateKeyに値(" + code.toString() + ")").toString());
    }

}
