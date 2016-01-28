package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他納入通知書タイプを表す列挙型です。
 *
 * @author LDNS
 */
public enum SonotaTsuchishoType {

    /**
     * コード:001 名称:標準版ブックタイプ 略称:定義なし
     */
    標準版ブックタイプ("001", "標準版ブックタイプ"),
    /**
     * コード:101 名称:標準版コンビニタイプ 略称:定義なし
     */
    標準版コンビニタイプ("101", "標準版コンビニタイプ"),
    /**
     * コード:10E 名称:飯田市版コンビニタイプ 略称:定義なし
     */
    飯田市版コンビニタイプ("10E", "飯田市版コンビニタイプ"),
    /**
     * コード:10C 名称:上田市版コンビニタイプ 略称:定義なし
     */
    上田市版コンビニタイプ("10C", "上田市版コンビニタイプ");

    private final RString code;
    private final RString fullName;

    private SonotaTsuchishoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * その他納入通知書タイプのコードを返します。
     *
     * @return その他納入通知書タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * その他納入通知書タイプの名称を返します。
     *
     * @return その他納入通知書タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * その他納入通知書タイプのコードと一致する内容を探します。
     *
     * @param code その他納入通知書タイプのコード
     * @return {@code code} に対応するその他納入通知書タイプ
     */
    public static SonotaTsuchishoType toValue(RString code) {
        for (SonotaTsuchishoType sonotaTsuchishoType : SonotaTsuchishoType.values()) {
            if (sonotaTsuchishoType.code.equals(code)) {
                return sonotaTsuchishoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("その他納入通知書タイプ"));
    }
}
