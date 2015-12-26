package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付連携データ共有ファイル名称を表す列挙型です。
 *
 * @author LDNS
 */
public enum SofuRenkeiDataKyoyuFileName {

    /**
     * コード:B1 名称:介護個別事項異動情報（一定間隔） 略称:定義なし
     */
    介護個別事項異動情報_一定間隔("B1", "介護個別事項異動情報（一定間隔）"),
    /**
     * コード:F1 名称:特徴依頼情報（年次） 略称:定義なし
     */
    特徴依頼情報_年次("F1", "特徴依頼情報（年次）"),
    /**
     * コード:F2 名称:特徴各種異動情報（月次） 略称:定義なし
     */
    特徴各種異動情報_月次("F2", "特徴各種異動情報（月次）"),
    /**
     * コード:F3 名称:特徴依頼データ（550バイト） 略称:定義なし
     */
    特徴依頼データ_550バイト("F3", "特徴依頼データ（550バイト）"),
    /**
     * コード:I1 名称:介護資格情報（日次） 略称:定義なし
     */
    介護資格情報_日次("I1", "介護資格情報（日次）"),
    /**
     * コード:D1 名称:納付額情報（年次） 略称:定義なし
     */
    納付額情報_年次("D1", "納付額情報（年次）");

    private final RString code;
    private final RString fullName;

    private SofuRenkeiDataKyoyuFileName(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 送付連携データ共有ファイル名称のコードを返します。
     *
     * @return 送付連携データ共有ファイル名称のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 送付連携データ共有ファイル名称の名称を返します。
     *
     * @return 送付連携データ共有ファイル名称の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 送付連携データ共有ファイル名称のコードと一致する内容を探します。
     *
     * @param code 送付連携データ共有ファイル名称のコード
     * @return {@code code} に対応する送付連携データ共有ファイル名称
     */
    public static SofuRenkeiDataKyoyuFileName toValue(RString code) {

        for (SofuRenkeiDataKyoyuFileName sofuRenkeiDataKyoyuFileName : SofuRenkeiDataKyoyuFileName.values()) {
            if (sofuRenkeiDataKyoyuFileName.code.equals(code)) {
                return sofuRenkeiDataKyoyuFileName;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("送付連携データ共有ファイル名称"));
    }
}
