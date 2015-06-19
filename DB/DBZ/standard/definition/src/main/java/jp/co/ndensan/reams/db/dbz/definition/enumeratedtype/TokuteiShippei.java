/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定疾病の列挙型です。
 *
 * @author N8235 船山 洋介
 */
public enum TokuteiShippei {

    /**
     * 筋萎縮性側索硬化症 <br />
     * コード : 01
     */
    筋萎縮性側索硬化症("01"),
    /**
     * 後縦靭帯骨化症 <br />
     * コード : 02
     */
    後縦靭帯骨化症("02"),
    /**
     * 骨折を伴う骨粗鬆症 <br />
     * コード : 03
     */
    骨折を伴う骨粗鬆症("03"),
    /**
     * 多系統萎縮症 <br />
     * コード : 04
     */
    多系統萎縮症("04"),
    /**
     * 初老期における認知症 <br />
     * コード : 05
     */
    初老期における認知症("05"),
    /**
     * 脊髄小脳変性症 <br />
     * コード : 06
     */
    脊髄小脳変性症("06"),
    /**
     * 脊柱管狭窄症 <br />
     * コード : 07
     */
    脊柱管狭窄症("07"),
    /**
     * 早老症 <br />
     * コード : 08
     */
    早老症("08"),
    /**
     * 糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症 <br />
     * コード : 09
     */
    糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症("09"),
    /**
     * 脳血管疾患 <br />
     * コード : 10
     */
    脳血管疾患("10"),
    /**
     * パーキンソン病関連疾患 <br />
     * コード : 11
     */
    パーキンソン病関連疾患("11"),
    /**
     * 閉塞性動脈硬化症 <br />
     * コード : 12
     */
    閉塞性動脈硬化症("12"),
    /**
     * 関節リウマチ <br />
     * コード : 13
     */
    関節リウマチ("13"),
    /**
     * 第１号被保険者 <br />
     * コード : 14
     */
    慢性閉塞性肺疾患("14"),
    /**
     * 両側の膝関節又は股関節に著しい変形を伴う変形性関節症 <br />
     * コード : 15
     */
    両側の膝関節又は股関節に著しい変形を伴う変形性関節症("15"),
    /**
     * がん_末期 <br />
     * コード : 16
     */
    がん_末期("16"),
    /**
     * 特定疾病以外 <br />
     * コード : 99
     */
    特定疾病以外("99");

    private final RString theCode;

    private TokuteiShippei(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.theCode;
    }

    /**
     * {@link #name() name()}を{@link RString}へ変換して返します。
     *
     * @return {@link #name() name()}を{@link RString}へ変換した物
     */
    public RString toRString() {
        return new RString(name());
    }

    /**
     * 引数のコードに対応する{@link TokuteiShippei}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link TokuteiShippei}
     * @throws IllegalArgumentException コードに対応する{@link TokuteiShippei}が無い時
     */
    public static TokuteiShippei toValue(RString code) throws IllegalArgumentException {
        TokuteiShippei value = CodeToValue.get(code);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(TokuteiShippei.class.getSimpleName()));
    }

    //<editor-fold defaultstate="collapsed" desc="CodeToValue">
    private static final class CodeToValue {

        private static final Map<RString, TokuteiShippei> DICTHIONARY;

        static {
            Map<RString, TokuteiShippei> map = new HashMap<>();
            for (TokuteiShippei value : values()) {
                map.put(value.code(), value);
            }
            DICTHIONARY = Collections.unmodifiableMap(map);
        }

        static TokuteiShippei get(RString code) {
            return DICTHIONARY.get(code);
        }
    }
    //</editor-fold>
}
