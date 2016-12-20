/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.core.ocrfiledata;

import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.ICodeValueEnumeratedType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 行データタイプを表す列挙型です。
 *
 * @author n8429
 */
public enum OcrFileLineDataTypeModel implements ICodeValueEnumeratedType {
    
     /**
     * 行データタイプ：対象外を表す列挙体です。
     */
    行データタイプ_対象外("1", "対象外"),
    /**
     * 行データタイプ：ヘッダー行を表す列挙体です。
     */
    行データタイプ_ヘッダー行("2", "ヘッダー行"),
    /**
     * 行データタイプ：データ行を表す列挙体です。
     */
    行データタイプ_データ行("3", "データ行");

    private final RString code;
    private final RString name;

    private OcrFileLineDataTypeModel(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    @Override
    public RString code() {
        return code;
    }

    @Override
    public RString toRString() {
        return name;
    }

    /**
     * 引数のコードに対応する列挙型を返します。
     * <p/>
     * 該当する列挙型がない場合はnullを返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static OcrFileLineDataTypeModel toValue(RString code) {

        for (OcrFileLineDataTypeModel target : OcrFileLineDataTypeModel.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("ViewStateの保存に使用するキー(" + code.toString() + ")").evaluate());
    }
    
}
