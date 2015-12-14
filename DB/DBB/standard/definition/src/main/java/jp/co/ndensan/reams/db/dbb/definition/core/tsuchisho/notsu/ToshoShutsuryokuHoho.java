package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 当初出力方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum ToshoShutsuryokuHoho {

    /**
     * コード:0 名称:別々出力 略称:前期・中期・後期を別々に出力
     */
    前期_中期_後期を別々に出力("0", "別々出力", "前期・中期・後期を別々に出力"),
    /**
     * コード:1 名称:全件出力 略称:前期・中期・後期を全件出力
     */
    前期_中期_後期を全件出力("1", "全件出力", "前期・中期・後期を全件出力");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ToshoShutsuryokuHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 当初出力方法のコードを返します。
     *
     * @return 当初出力方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 当初出力方法の名称を返します。
     *
     * @return 当初出力方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 当初出力方法の略称を返します。
     *
     * @return 当初出力方法の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 当初出力方法のコードと一致する内容を探します。
     *
     * @param code 当初出力方法のコード
     * @return {@code code} に対応する当初出力方法
     */
    public static ToshoShutsuryokuHoho toValue(RString code) {
        for (ToshoShutsuryokuHoho toshoShutsuryokuHoho : ToshoShutsuryokuHoho.values()) {
            if (toshoShutsuryokuHoho.code.equals(code)) {
                return toshoShutsuryokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("当初出力方法"));
    }
}
