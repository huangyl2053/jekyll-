/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 厚労省インターフェース識別コードの列挙型です。
 *
 * @author N8156 宮本 康
 * @jpName
 * @bizDomain
 * @category
 * @subCategory
 * @mainClass
 * @reference
 */
public enum KoroshoInterfaceShikibetsuCode {

    /**
     * 識別コードが「認定ソフト99」のコードであることを表します。<br />
     * コード：99A
     */
    V99A("99A", "20000401", "20020331"),
    /**
     * 識別コードが「認定ソフト2002」のコードであることを表します。<br />
     * コード：02A
     */
    V02A("02A", "20020401", "20060331"),
    /**
     * 識別コードが「認定ソフト2006」のコードであることを表します。<br />
     * コード：06A
     */
    V06A("06A", "20060401", "20090331"),
    /**
     * 識別コードが「認定ソフト2009」のコードであることを表します。<br />
     * コード：09A
     */
    V09A("09A", "20090401", "20120331"),
    /**
     * 識別コードが「認定ソフト2009（SP3）」のコードであることを表します。<br />
     * コード：09B
     */
    V09B("09B", "20120401", "");

    private final RString code;
    private final transient Range<FlexibleDate> 有効期間;

    private KoroshoInterfaceShikibetsuCode(String code, String 有効開始日, String 有効終了日) {
        this.code = new RString(code);
        this.有効期間 = new Range<>(
                !有効開始日.isEmpty() ? new FlexibleDate(有効開始日) : FlexibleDate.MIN,
                !有効終了日.isEmpty() ? new FlexibleDate(有効終了日) : FlexibleDate.MAX);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 基準日時点で有効かどうかを判定します。
     *
     * @param 基準日 基準日
     *
     * @return 有効な場合はtrue、無効の場合はfalseを返します。
     */
    public boolean isValidOn(FlexibleDate 基準日) {
        return 有効期間.between(基準日);
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static KoroshoInterfaceShikibetsuCode toValue(RString code) {
        KoroshoInterfaceShikibetsuCode value = toValueOrDefault(code, null);
        if (value == null) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("厚労省インターフェース識別コード"));
        }
        return value;
    }

    /**
     * コードに対応する要素を返します。存在しない場合は、{@code defaultValue}を返します。
     *
     * @param code コード
     * @return 指定のコードに対応する要素. 存在しない場合は、{@code defaultValue}を返します。
     */
    public static KoroshoInterfaceShikibetsuCode toValueOrDefault(RString code, KoroshoInterfaceShikibetsuCode defaultValue) {
        for (KoroshoInterfaceShikibetsuCode data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return defaultValue;
    }
}
