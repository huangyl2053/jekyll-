package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 作成料請求区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SakuseiryoSeikyuKubun {

    /**
     * コード:11 名称:在宅新規 略称:定義なし
     */
    在宅新規("11", "在宅新規"),
    /**
     * コード:12 名称:在宅継続 略称:定義なし
     */
    在宅継続("12", "在宅継続"),
    /**
     * コード:21 名称:施設新規 略称:定義なし
     */
    施設新規("21", "施設新規"),
    /**
     * コード:22 名称:施設継続 略称:定義なし
     */
    施設継続("22", "施設継続");

    private final RString code;
    private final RString fullName;

    private SakuseiryoSeikyuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 作成料請求区分のコードを返します。
     *
     * @return 作成料請求区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 作成料請求区分の名称を返します。
     *
     * @return 作成料請求区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 作成料請求区分のコードと一致する内容を探します。
     *
     * @param code 作成料請求区分のコード
     * @return {@code code} に対応する作成料請求区分
     */
    public static SakuseiryoSeikyuKubun toValue(RString code) {

        for (SakuseiryoSeikyuKubun sakuseiryoSeikyuKubun : SakuseiryoSeikyuKubun.values()) {
            if (sakuseiryoSeikyuKubun.code.equals(code)) {
                return sakuseiryoSeikyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("作成料請求区分"));
    }
}
