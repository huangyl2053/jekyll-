package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 差額令書発行指示区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SagakuReishoHakkoShijiKubun {

    /**
     * コード:0 名称:差額令書で発行する 略称:定義なし
     */
    差額令書で発行する("0", "差額令書で発行する"),
    /**
     * コード:1 名称:差額令書で発行しない 略称:定義なし
     */
    差額令書で発行しない("1", "差額令書で発行しない");

    private final RString code;
    private final RString fullName;

    private SagakuReishoHakkoShijiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 差額令書発行指示区分のコードを返します。
     *
     * @return 差額令書発行指示区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 差額令書発行指示区分の名称を返します。
     *
     * @return 差額令書発行指示区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 差額令書発行指示区分のコードと一致する内容を探します。
     *
     * @param code 差額令書発行指示区分のコード
     * @return {@code code} に対応する差額令書発行指示区分
     */
    public static SagakuReishoHakkoShijiKubun toValue(RString code) {
        for (SagakuReishoHakkoShijiKubun sagakuReishoHakkoShijiKubun : SagakuReishoHakkoShijiKubun.values()) {
            if (sagakuReishoHakkoShijiKubun.code.equals(code)) {
                return sagakuReishoHakkoShijiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("差額令書発行指示区分"));
    }
}
