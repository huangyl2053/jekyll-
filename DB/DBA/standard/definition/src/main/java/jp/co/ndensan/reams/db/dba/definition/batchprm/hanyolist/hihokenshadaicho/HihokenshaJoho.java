package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum HihokenshaJoho {

    /**
     * コード:1 名称:１号 略称:１号
     */
    _１号("1", "１号", "１号"),
    /**
     * コード:2 名称:２号 略称:２号
     */
    _２号("2", "２号", "２号"),
    /**
     * コード:3 名称:日本人 略称:日本人
     */
    日本人("3", "日本人", "日本人"),
    /**
     * コード:4 名称:外国人 略称:外国人
     */
    外国人("4", "外国人", "外国人"),
    /**
     * コード:5 名称:自特例者 略称:自特例者
     */
    自住所特例("5", "自特例者", "自特例者"),
    /**
     * コード:6 名称:広域住特 略称:広域住特
     */
    広域住特者("6", "広域住特", "広域住特"),
    /**
     * コード:7 名称:継続考慮する 略称:継続考慮する
     */
    継続考慮する("7", "継続考慮する", "継続考慮する");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HihokenshaJoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 被保険者情報のコードを返します。
     *
     * @return 被保険者情報のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者情報の名称を返します。
     *
     * @return 被保険者情報の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者情報の略称を返します。
     *
     * @return 被保険者情報の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 被保険者情報のコードと一致する内容を探します。
     *
     * @param code 被保険者情報のコード
     * @return {@code code} に対応する被保険者情報
     */
    public static HihokenshaJoho toValue(RString code) {
        for (HihokenshaJoho hihokenshaJoho : HihokenshaJoho.values()) {
            if (hihokenshaJoho.code.equals(code)) {
                return hihokenshaJoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者情報"));
    }
}
