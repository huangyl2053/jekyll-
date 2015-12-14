package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納入通知書口座出力対象を表す列挙型です。
 *
 * @author LDNS
 */
public enum NotsuKozaShutsuryokuTaisho {

    /**
     * コード:0 名称:現金納付者 略称:定義なし
     */
    現金納付者("0", "現金納付者"),
    /**
     * コード:1 名称:口座振替者 略称:定義なし
     */
    口座振替者("1", "口座振替者"),
    /**
     * コード:2 名称:全て 略称:定義なし
     */
    全て("2", "全て");

    private final RString code;
    private final RString fullName;

    private NotsuKozaShutsuryokuTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 納入通知書口座出力対象のコードを返します。
     *
     * @return 納入通知書口座出力対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納入通知書口座出力対象の名称を返します。
     *
     * @return 納入通知書口座出力対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納入通知書口座出力対象のコードと一致する内容を探します。
     *
     * @param code 納入通知書口座出力対象のコード
     * @return {@code code} に対応する納入通知書口座出力対象
     */
    public static NotsuKozaShutsuryokuTaisho toValue(RString code) {
        for (NotsuKozaShutsuryokuTaisho notsuKozaShutsuryokuTaisho : NotsuKozaShutsuryokuTaisho.values()) {
            if (notsuKozaShutsuryokuTaisho.code.equals(code)) {
                return notsuKozaShutsuryokuTaisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納入通知書口座出力対象"));
    }
}
