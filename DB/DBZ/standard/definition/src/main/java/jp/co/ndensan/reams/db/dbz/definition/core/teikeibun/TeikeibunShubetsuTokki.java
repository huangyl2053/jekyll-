package jp.co.ndensan.reams.db.dbz.definition.core.teikeibun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項定型文種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum TeikeibunShubetsuTokki {

    /**
     * コード:001 名称:第１群_１_麻痺 略称:定義なし
     */
    第１群_１_麻痺("001", "第１群_１_麻痺"),
    /**
     * コード:002 名称:第１群_２_拘縮 略称:定義なし
     */
    第１群_２_拘縮("002", "第１群_２_拘縮"),
    /**
     * コード:003 名称:第１群_３_寝返り 略称:定義なし
     */
    第１群_３_寝返り("003", "第１群_３_寝返り"),
    /**
     * コード:004 名称:第１群_４_起き上がり 略称:定義なし
     */
    第１群_４_起き上がり("004", "第１群_４_起き上がり"),
    /**
     * コード:070 名称:その他特記 略称:定義なし
     */
    その他特記("070", "その他特記");

    private final RString code;
    private final RString fullName;

    private TeikeibunShubetsuTokki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特記事項定型文種別のコードを返します。
     *
     * @return 特記事項定型文種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特記事項定型文種別の名称を返します。
     *
     * @return 特記事項定型文種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特記事項定型文種別のコードと一致する内容を探します。
     *
     * @param code 特記事項定型文種別のコード
     * @return {@code code} に対応する特記事項定型文種別
     */
    public static TeikeibunShubetsuTokki toValue(RString code) {

        for (TeikeibunShubetsuTokki teikeibunShubetsuTokki : TeikeibunShubetsuTokki.values()) {
            if (teikeibunShubetsuTokki.code.equals(code)) {
                return teikeibunShubetsuTokki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特記事項定型文種別"));
    }
}
