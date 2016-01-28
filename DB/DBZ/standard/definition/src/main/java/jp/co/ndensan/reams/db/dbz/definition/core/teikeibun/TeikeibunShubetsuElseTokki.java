package jp.co.ndensan.reams.db.dbz.definition.core.teikeibun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項以外定型文種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum TeikeibunShubetsuElseTokki {

    /**
     * コード:001 名称:申請理由 略称:定義なし
     */
    申請理由("001", "申請理由"),
    /**
     * コード:002 名称:認定理由 略称:定義なし
     */
    認定理由("002", "認定理由"),
    /**
     * コード:003 名称:サービス変更理由 略称:定義なし
     */
    サービス変更理由("003", "サービス変更理由"),
    /**
     * コード:004 名称:取消理由 略称:定義なし
     */
    取消理由("004", "取消理由"),
    /**
     * コード:005 名称:却下理由 略称:定義なし
     */
    却下理由("005", "却下理由"),
    /**
     * コード:006 名称:延期理由 略称:定義なし
     */
    延期理由("006", "延期理由"),
    /**
     * コード:007 名称:サービス種類 略称:定義なし
     */
    サービス種類("007", "サービス種類"),
    /**
     * コード:008 名称:意見書意見 略称:定義なし
     */
    意見書意見("008", "意見書意見");

    private final RString code;
    private final RString fullName;

    private TeikeibunShubetsuElseTokki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特記事項以外定型文種別のコードを返します。
     *
     * @return 特記事項以外定型文種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特記事項以外定型文種別の名称を返します。
     *
     * @return 特記事項以外定型文種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特記事項以外定型文種別のコードと一致する内容を探します。
     *
     * @param code 特記事項以外定型文種別のコード
     * @return {@code code} に対応する特記事項以外定型文種別
     */
    public static TeikeibunShubetsuElseTokki toValue(RString code) {

        for (TeikeibunShubetsuElseTokki teikeibunShubetsuElseTokki : TeikeibunShubetsuElseTokki.values()) {
            if (teikeibunShubetsuElseTokki.code.equals(code)) {
                return teikeibunShubetsuElseTokki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特記事項以外定型文種別"));
    }
}
