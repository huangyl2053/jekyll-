package jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域認定支援システム_調査実施日初期値を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum KoikiNinteiShienSystemChosaJisshibiDefault {

    /**
     * コード:1 名称:処理日 略称:定義なし
     */
    処理日("1", "処理日"),
    /**
     * コード:2 名称:調査予定日 略称:定義なし
     */
    調査予定日("2", "調査予定日"),
    /**
     * コード:3 名称:空白 略称:定義なし
     */
    空白("3", "空白");

    private final RString code;
    private final RString fullName;

    private KoikiNinteiShienSystemChosaJisshibiDefault(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域認定支援システム_調査実施日初期値のコードを返します。
     *
     * @return 広域認定支援システム_調査実施日初期値のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域認定支援システム_調査実施日初期値の名称を返します。
     *
     * @return 広域認定支援システム_調査実施日初期値の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域認定支援システム_調査実施日初期値のコードと一致する内容を探します。
     *
     * @param code 広域認定支援システム_調査実施日初期値のコード
     * @return {@code code} に対応する広域認定支援システム_調査実施日初期値
     */
    public static KoikiNinteiShienSystemChosaJisshibiDefault toValue(RString code) {
        for (KoikiNinteiShienSystemChosaJisshibiDefault value : KoikiNinteiShienSystemChosaJisshibiDefault.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("広域認定支援システム_調査実施日初期値"));
    }
}
