package jp.co.ndensan.reams.db.dbz.definition.core.kogakujikofutan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付高額_自己負担上限月額を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum KogakuJikofutanJogen {

    /**
     * コード:1 名称:15,000
     */
    第1段階_高額介護サービス費支給_自己負担上限月額("1", "15,000"),
    /**
     * コード:2 名称:24,600
     */
    第2段階_高額介護サービス費支給_自己負担上限月額("2", "24,600"),
    /**
     * コード:3 名称:37,200
     */
    第3段階_高額介護サービス費支給_自己負担上限月額("3", "37,200");

    private final RString code;
    private final RString fullName;

    private KogakuJikofutanJogen(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付高額_自己負担上限月額のコードを返します。
     *
     * @return 給付高額_自己負担上限月額のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付高額_自己負担上限月額の名称を返します。
     *
     * @return 給付高額_自己負担上限月額の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付高額_自己負担上限月額のコードと一致する内容を探します。
     *
     * @param code 給付高額_自己負担上限月額のコード
     * @return {@code code} に対応する給付高額_自己負担上限月額
     */
    public static KogakuJikofutanJogen toValue(RString code) {
        for (KogakuJikofutanJogen kogakuJikofutanJogen : KogakuJikofutanJogen.values()) {
            if (kogakuJikofutanJogen.code.equals(code)) {
                return kogakuJikofutanJogen;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付高額_自己負担上限月額"));
    }
}
