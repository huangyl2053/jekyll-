package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文属性コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum TeikeibunZokuseiCode {

    /**
     * コード:101 名称:認定理由 略称:定義なし
     */
    認定理由("101", "認定理由"),
    /**
     * コード:102 名称:サ変理由 略称:定義なし
     */
    サ変理由("102", "サ変理由"),
    /**
     * コード:103 名称:取消理由 略称:定義なし
     */
    取消理由("103", "取消理由"),
    /**
     * コード:104 名称:却下理由 略称:定義なし
     */
    却下理由("104", "却下理由"),
    /**
     * コード:105 名称:延期理由 略称:定義なし
     */
    延期理由("105", "延期理由"),
    /**
     * コード:109 名称:サービス種類 略称:定義なし
     */
    サービス種類("109", "サービス種類"),
    /**
     * コード:201 名称:調査票住宅改修 略称:定義なし
     */
    調査票住宅改修("201", "調査票住宅改修"),
    /**
     * コード:202 名称:調査票主訴 略称:定義なし
     */
    調査票主訴("202", "調査票主訴"),
    /**
     * コード:203 名称:調査票家族状況 略称:定義なし
     */
    調査票家族状況("203", "調査票家族状況"),
    /**
     * コード:204 名称:調査票居住環境 略称:定義なし
     */
    調査票居住環境("204", "調査票居住環境"),
    /**
     * コード:205 名称:機器器械 略称:定義なし
     */
    機器器械("205", "機器器械"),
    /**
     * コード:210 名称:特記事項 略称:定義なし
     */
    特記事項("210", "特記事項"),
    /**
     * コード:501 名称:審査会意見 略称:定義なし
     */
    審査会意見("501", "審査会意見"),
    /**
     * コード:502 名称:審査会メモ 略称:定義なし
     */
    審査会メモ("502", "審査会メモ"),
    /**
     * コード:503 名称:審査会メモ情報 略称:定義なし
     */
    審査会メモ情報("503", "審査会メモ情報");

    private final RString code;
    private final RString fullName;

    private TeikeibunZokuseiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 定型文属性コードのコードを返します。
     *
     * @return 定型文属性コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 定型文属性コードの名称を返します。
     *
     * @return 定型文属性コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 定型文属性コードのコードと一致する内容を探します。
     *
     * @param code 定型文属性コードのコード
     * @return {@code code} に対応する定型文属性コード
     */
    public static TeikeibunZokuseiCode toValue(RString code) {

        for (TeikeibunZokuseiCode teikeibunZokuseiCode : TeikeibunZokuseiCode.values()) {
            if (teikeibunZokuseiCode.code.equals(code)) {
                return teikeibunZokuseiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("定型文属性コード"));
    }
}
