package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取込連携データ共有ファイル名称を表す列挙型です。
 *
 * @author LDNS
 */
public enum TorikomiRenkeiDataKyoyuFileName {

    /**
     * コード:A1 名称:住民異動情報（一定間隔） 略称:定義なし
     */
    住民異動情報_一定間隔("A1", "住民異動情報（一定間隔）"),
    /**
     * コード:E1 名称:特徴対象者情報（年次） 略称:定義なし
     */
    特徴対象者情報_年次("E1", "特徴対象者情報（年次）"),
    /**
     * コード:E2 名称:特徴依頼処理結果情報（年次） 略称:定義なし
     */
    特徴依頼処理結果情報_年次("E2", "特徴依頼処理結果情報（年次）"),
    /**
     * コード:E3 名称:特別徴収結果情報（月次） 略称:定義なし
     */
    特別徴収結果情報_月次("E3", "特別徴収結果情報（月次）"),
    /**
     * コード:C1 名称:所得情報（年次） 略称:定義なし
     */
    所得情報_年次("C1", "所得情報（年次）"),
    /**
     * コード:C2 名称:所得情報（月次） 略称:定義なし
     */
    所得情報_月次("C2", "所得情報（月次）"),
    /**
     * コード:H1 名称:国保資格情報（月次） 略称:定義なし
     */
    国保資格情報_月次("H1", "国保資格情報（月次）"),
    /**
     * コード:G1 名称:後期高齢受給資格情報（月次） 略称:定義なし
     */
    後期高齢受給資格情報_月次("G1", "後期高齢受給資格情報（月次）");

    private final RString code;
    private final RString fullName;

    private TorikomiRenkeiDataKyoyuFileName(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 取込連携データ共有ファイル名称のコードを返します。
     *
     * @return 取込連携データ共有ファイル名称のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 取込連携データ共有ファイル名称の名称を返します。
     *
     * @return 取込連携データ共有ファイル名称の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 取込連携データ共有ファイル名称のコードと一致する内容を探します。
     *
     * @param code 取込連携データ共有ファイル名称のコード
     * @return {@code code} に対応する取込連携データ共有ファイル名称
     */
    public static TorikomiRenkeiDataKyoyuFileName toValue(RString code) {

        for (TorikomiRenkeiDataKyoyuFileName value : TorikomiRenkeiDataKyoyuFileName.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("取込連携データ共有ファイル名称"));
    }
}
