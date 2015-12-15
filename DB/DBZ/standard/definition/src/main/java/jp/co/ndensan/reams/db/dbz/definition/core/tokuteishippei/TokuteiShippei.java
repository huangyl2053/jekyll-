package jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定疾病コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuteiShippei {

    /**
     * コード:01 名称:筋萎縮性側索硬化症 略称:定義なし
     */
    筋萎縮性側索硬化症("01", "筋萎縮性側索硬化症"),
    /**
     * コード:02 名称:後縦靭帯骨化症 略称:定義なし
     */
    後縦靭帯骨化症("02", "後縦靭帯骨化症"),
    /**
     * コード:03 名称:骨折を伴う骨粗鬆症 略称:定義なし
     */
    骨折を伴う骨粗鬆症("03", "骨折を伴う骨粗鬆症"),
    /**
     * コード:04 名称:多系統萎縮症 略称:定義なし
     */
    多系統萎縮症("04", "多系統萎縮症"),
    /**
     * コード:05 名称:初老期における認知症 略称:定義なし
     */
    初老期における認知症("05", "初老期における認知症"),
    /**
     * コード:06 名称:脊髄小脳変性症 略称:定義なし
     */
    脊髄小脳変性症("06", "脊髄小脳変性症"),
    /**
     * コード:07 名称:脊柱管狭窄症 略称:定義なし
     */
    脊柱管狭窄症("07", "脊柱管狭窄症"),
    /**
     * コード:08 名称:早老症 略称:定義なし
     */
    早老症("08", "早老症"),
    /**
     * コード:09 名称:糖尿病性神経障害、糖尿病性腎症及び糖尿病性網膜症 略称:定義なし
     */
    糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症("09", "糖尿病性神経障害、糖尿病性腎症及び糖尿病性網膜症"),
    /**
     * コード:10 名称:脳血管疾患 略称:定義なし
     */
    脳血管疾患("10", "脳血管疾患"),
    /**
     * コード:11 名称:パーキンソン病関連疾患 略称:定義なし
     */
    パーキンソン病関連疾患("11", "パーキンソン病関連疾患"),
    /**
     * コード:12 名称:閉塞性動脈硬化症 略称:定義なし
     */
    閉塞性動脈硬化症("12", "閉塞性動脈硬化症"),
    /**
     * コード:13 名称:関節リウマチ 略称:定義なし
     */
    関節リウマチ("13", "関節リウマチ"),
    /**
     * コード:14 名称:慢性閉塞性肺疾患 略称:定義なし
     */
    慢性閉塞性肺疾患("14", "慢性閉塞性肺疾患"),
    /**
     * コード:15 名称:両側の膝関節又は股関節に著しい変形を伴う変形性関節症 略称:定義なし
     */
    両側の膝関節又は股関節に著しい変形を伴う変形性関節症("15", "両側の膝関節又は股関節に著しい変形を伴う変形性関節症"),
    /**
     * コード:16 名称:がん（末期） 略称:定義なし
     */
    がん_末期("16", "がん（末期）"),
    /**
     * コード:99 名称:特定疾病以外 略称:定義なし
     */
    特定疾病以外("99", "特定疾病以外");

    private final RString code;
    private final RString fullName;

    private TokuteiShippei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特定疾病コードのコードを返します。
     *
     * @return 特定疾病コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定疾病コードの名称を返します。
     *
     * @return 特定疾病コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定疾病コードのコードと一致する内容を探します。
     *
     * @param code 特定疾病コードのコード
     * @return {@code code} に対応する特定疾病コード
     */
    public static TokuteiShippei toValue(RString code) {

        for (TokuteiShippei tokuteiShippei : TokuteiShippei.values()) {
            if (tokuteiShippei.code.equals(code)) {
                return tokuteiShippei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定疾病コード"));
    }
}
