package jp.co.ndensan.reams.db.dbx.definition.core.kensakuseigyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内住所地特例者検索制御を表す列挙型です。
 *
 */
public enum KoikinaiJushochitokureiKensakuSeigyo {

    /**
     * コード:CAA 名称:広域内住所地特例者検索制御_措置元_措置先区分_収納 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_収納("CAA", "広域内住所地特例者検索制御_措置元_措置先区分_収納"),
    /**
     * コード:CAB 名称:広域内住所地特例者検索制御_措置元_措置先区分_滞納 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_滞納("CAB", "広域内住所地特例者検索制御_措置元_措置先区分_滞納"),
    /**
     * コード:DBA 名称:広域内住所地特例者検索制御_措置元_措置先区分_介護資格 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_介護資格("DBA", "広域内住所地特例者検索制御_措置元_措置先区分_介護資格"),
    /**
     * コード:DBB 名称:広域内住所地特例者検索制御_措置元_措置先区分_介護賦課 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_介護賦課("DBB", "広域内住所地特例者検索制御_措置元_措置先区分_介護賦課"),
    /**
     * コード:DBC 名称:広域内住所地特例者検索制御_措置元_措置先区分_介護給付 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_介護給付("DBC", "広域内住所地特例者検索制御_措置元_措置先区分_介護給付"),
    /**
     * コード:DBD 名称:広域内住所地特例者検索制御_措置元_措置先区分_介護受給 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_介護受給("DBD", "広域内住所地特例者検索制御_措置元_措置先区分_介護受給"),
    /**
     * コード:DBE 名称:広域内住所地特例者検索制御_措置元_措置先区分_介護認定 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_介護認定("DBE", "広域内住所地特例者検索制御_措置元_措置先区分_介護認定"),
    /**
     * コード:DBU 名称:広域内住所地特例者検索制御_措置元_措置先区分_介護共通 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_介護共通("DBU", "広域内住所地特例者検索制御_措置元_措置先区分_介護共通"),
    /**
     * コード:UAA 名称:広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座 略称:定義なし
     */
    広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座("UAA", "広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座");

    private final RString code;
    private final RString fullName;

    private KoikinaiJushochitokureiKensakuSeigyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域内住所地特例者検索制御のコードを返します。
     *
     * @return 広域内住所地特例者検索制御のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域内住所地特例者検索制御の名称を返します。
     *
     * @return 広域内住所地特例者検索制御の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域内住所地特例者検索制御のコードと一致する内容を探します。
     *
     * @param code 広域内住所地特例者検索制御のコード
     * @return {@code code} に対応する広域内住所地特例者検索制御
     */
    public static KoikinaiJushochitokureiKensakuSeigyo toValue(RString code) {
        for (KoikinaiJushochitokureiKensakuSeigyo value : KoikinaiJushochitokureiKensakuSeigyo.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("広域内住所地特例者検索制御"));
    }
}
