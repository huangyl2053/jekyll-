/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.hokenryodankaipatternhantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBHokenryoDankaiPatternHantei_保険料段階パターン判定
 *
 * @reamsid_L DBB-1770-030 yangchenbing
 */
public enum HokenryoDankaiPattern {

    /**
     * コード:1 名称:パターン無し 略称:定義パターン無し
     */
    パターン無し("1", "パターン無し"),
    /**
     * コード:2 名称:2009_パターン1 略称:定義2009_パターン1
     */
    _2009_パターン1("2", "2009_パターン1"),
    /**
     * コード:3 名称:2009_パターン2 略称:定義2009_パターン2
     */
    _2009_パターン2("3", "2009_パターン2"),
    /**
     * コード:4 名称:2009_パターン3 略称:定義2009_パターン3
     */
    _2009_パターン3("4", "2009_パターン3"),
    /**
     * コード:5 名称:2012_パターン1 略称:定義2012_パターン1
     */
    _2012_パターン1("5", "2012_パターン1"),
    /**
     * コード:6 名称:2012_パターン2 略称:定義2012_パターン2
     */
    _2012_パターン2("6", "2012_パターン2"),
    /**
     * コード:7 名称:2012_パターン3 略称:定義2012_パターン3
     */
    _2012_パターン3("7", "2012_パターン3"),
    /**
     * コード:8 名称:2012_パターン4 略称:定義2012_パターン4
     */
    _2012_パターン4("8", "2012_パターン4"),
    /**
     * コード:9 名称:2012_パターン5 略称:定義2012_パターン5
     */
    _2012_パターン5("9", "2012_パターン5"),
    /**
     * コード:10 名称:2012_パターン6 略称:定義2012_パターン6
     */
    _2012_パターン6("10", "2012_パターン6"),
    /**
     * コード:11 名称:2012_パターン7 略称:定義2012_パターン7
     */
    _2012_パターン7("11", "2012_パターン7"),
    /**
     * コード:12 名称:2012_パターン8 略称:定義2012_パターン8
     */
    _2012_パターン8("12", "2012_パターン8"),
    /**
     * コード:13 名称:2012_パターン9 略称:定義2012_パターン9
     */
    _2012_パターン9("13", "2012_パターン9");

    private final RString code;
    private final RString fullName;
    private static final RString 普徴処理対象 = new RString("普徴処理対象");

    private HokenryoDankaiPattern(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 普徴処理対象のコードを返します。
     *
     * @return 普徴処理対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 普徴処理対象の名称を返します。
     *
     * @return 普徴処理対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 普徴処理対象のコードと一致する内容を探します。
     *
     * @param code 普徴処理対象のコード
     * @return {@code code} に対応する普徴処理対象
     */
    public static HokenryoDankaiPattern toValue(RString code) {
        for (HokenryoDankaiPattern hokenryodankaipattern : HokenryoDankaiPattern.values()) {
            if (hokenryodankaipattern.code.equals(code)) {
                return hokenryodankaipattern;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(普徴処理対象.toString()));
    }
}
