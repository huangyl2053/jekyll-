package jp.co.ndensan.reams.db.dbz.definition.core.kogakujikofutan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額給付_201504以降_自己負担上限月額を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum Kogaku201504JikofutanJogen {

    /**
     * コード:1 名称:15,000
     */
    第1段階_高額介護サービス費支給_201504以降_自己負担上限月額("1", "15,000"),
    /**
     * コード:2 名称:24,600
     */
    第2段階_高額介護サービス費支給_201504以降_自己負担上限月額("2", "24,600"),
    /**
     * コード:3 名称:37,200
     */
    第3段階_高額介護サービス費支給_201504以降_自己負担上限月額("3", "37,200"),
    /**
     * コード:4 名称:44,400
     */
    第4段階_高額介護サービス費支給_201504以降_自己負担上限月額("4", "44,400");

    private final RString code;
    private final RString fullName;

    private Kogaku201504JikofutanJogen(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額給付_201504以降_自己負担上限月額のコードを返します。
     *
     * @return 高額給付_201504以降_自己負担上限月額のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額給付_201504以降_自己負担上限月額の名称を返します。
     *
     * @return 高額給付_201504以降_自己負担上限月額の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額給付_201504以降_自己負担上限月額のコードと一致する内容を探します。
     *
     * @param code 高額給付_201504以降_自己負担上限月額のコード
     * @return {@code code} に対応する高額給付_201504以降_自己負担上限月額
     */
    public static Kogaku201504JikofutanJogen toValue(RString code) {
        for (Kogaku201504JikofutanJogen kogaku201504JikofutanJogen : Kogaku201504JikofutanJogen.values()) {
            if (kogaku201504JikofutanJogen.code.equals(code)) {
                return kogaku201504JikofutanJogen;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額給付_201504以降_自己負担上限月額"));
    }
}
