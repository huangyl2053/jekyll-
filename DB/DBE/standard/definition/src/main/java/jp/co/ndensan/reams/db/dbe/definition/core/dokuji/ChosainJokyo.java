package jp.co.ndensan.reams.db.dbe.definition.core.dokuji;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員状況を表す列挙型です。
 * RString型codeは連携データ取込のIF上のコード値
 * 
 * @author n3213
 */
public enum ChosainJokyo {
    
    /**
     * is有効:True code:1 名称:有効 略称:定義なし
     */
    有効(true, "1", "有効"),
    /**
     * is有効:False code:2 名称:無効 略称:定義なし
     */
    無効(false, "2", "無効");
    
    private final boolean is有効;
    private final RString code;
    private final RString fullName;
    
    private ChosainJokyo(boolean is有効, String code, String fullname) {
        this.is有効 = is有効;
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }
    
    /**
     * 調査員状況の真偽値を返します。
     *
     * @return 調査員状況の真偽値
     */
    public boolean is有効() {
        return is有効;
    }
    
    /**
     * 調査員状況のコードを返します。
     *
     * @return 調査員状況のコード
     */
    public RString getCode() {
        return code;
    }
    
    /**
     * 調査員状況の名称を返します。
     *
     * @return 調査員状況の名称
     */
    public RString get名称() {
        return fullName;
    }
    
    /**
     * 調査員状況の真偽値と一致する内容を探します。
     *
     * @param is有効 調査員状況の真偽値
     * @return {@code code} に対応する調査員状況
     */
    public static ChosainJokyo toValue(boolean is有効) {
        for (ChosainJokyo chosainJokyo : ChosainJokyo.values()) {
            if (chosainJokyo.is有効() == is有効) {
                return chosainJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
    
    /**
     * 調査員状況のコードと一致する内容を探します。
     *
     * @param code 調査員状況のコード
     * @return {@code code} に対応する調査員状況
     */
    public static ChosainJokyo toValue(RString code) {
        for (ChosainJokyo chosainJokyo : ChosainJokyo.values()) {
            if (chosainJokyo.getCode().equals(code)) {
                return chosainJokyo;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
    
}
