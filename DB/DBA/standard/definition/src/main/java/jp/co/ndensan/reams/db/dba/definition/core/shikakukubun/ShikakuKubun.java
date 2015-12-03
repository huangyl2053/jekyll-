package jp.co.ndensan.reams.db.dba.definition.core.shikakukubun;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格区分を表す列挙型です。
 *
 * @author LDNS 作成者漢字名
 */
public enum ShikakuKubun {

    /**
     * コード:1 名称:１号被保険者 略称:１号
     */
    _1号("1", "１号被保険者", "１号"),
    /**
     * コード:2 名称:２号被保険者 略称:２号
     */
    _2号("2", "２号被保険者", "２号");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShikakuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 資格区分のコードを返します。
     *
     * @return 資格区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格区分の名称を返します。
     *
     * @return 資格区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格区分の略称を返します。
     *
     * @return 資格区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 資格区分のコードと一致する内容を探します。
     *
     * @param code 資格区分のコード
     * @return {@code code} に対応する資格区分
     */
    public static ShikakuKubun toValue(RString code) {
        //requireNonNull(code, DcErrorMessages.E00001.getMessage().getMessage());
        for (ShikakuKubun shikakuKubun : ShikakuKubun.values()) {
            if (shikakuKubun.code.equals(code)) {
                return shikakuKubun;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        throw new IllegalArgumentException();
    }
}
