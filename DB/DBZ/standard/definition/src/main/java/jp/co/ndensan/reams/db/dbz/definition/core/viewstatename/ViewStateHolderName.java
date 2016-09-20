package jp.co.ndensan.reams.db.dbz.definition.core.viewstatename;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ViewStateHolder名称を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ViewStateHolderName {

    /**
     * コード:無し 名称:国保連送付情報 略称:定義なし
     */
    国保連送付情報("国保連送付情報"),
    /**
     * コード:無し 名称:国保連取込情報 略称:定義なし
     */
    国保連取込情報("国保連取込情報"),
    /**
     * コード:無し 名称:介護支援専門員登録情報 略称:定義なし
     */
    介護支援専門員登録情報("介護支援専門員登録情報"),
    /**
     * コード:無し 名称:二次予防情報対象情報 略称:定義なし
     */
    二次予防情報対象情報("二次予防情報対象情報"),
    /**
     * コード:無し 名称:高額受領委任契約事業者 略称:定義なし
     */
    高額受領委任契約事業者("高額受領委任契約事業者");

    private final RString fullName;

    private ViewStateHolderName(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * ViewStateHolder名称の名称を返します。
     *
     * @return ViewStateHolder名称の名称
     */
    public RString get名称() {
        return fullName;
    }
}
