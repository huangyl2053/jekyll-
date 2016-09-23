/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.convertparameter;

import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryToReamsUnicodeConverter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.RecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.externalcharacter.UnicodeCharacterConvertParameter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.UnicodeCharacterConvertParameterBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取込データ一時作成のファイル変換を管理するクラス
 *
 * @reamsid_L DBD-4910-030 x_youyj
 */
public class TorikomiDtaFileRecordConverter {

    private final UnicodeCharacterConvertParameter uccp;

    /**
     * コンストラクタです。
     *
     */
    public TorikomiDtaFileRecordConverter() {
        this.uccp = getConvertParameter();
    }

    /**
     * テスト用のコンストラクタです。
     *
     * @param uccp コード変換パラメータ
     */
    public TorikomiDtaFileRecordConverter(UnicodeCharacterConvertParameter uccp) {
        this.uccp = uccp;
    }

    //UNFINISHED CODE:SUPPRESS CHECKSTYLE START//
    /**
     * 引数の値を文字列に変換します。
     *
     * @param item Jisコード文字列をバイナリ変換した変換対象
     *
     * @return 変換された文字列
     */
    public RString getBinaryToConvertCharacter(byte[] item) {
        return getBinaryToConvertReamsUnicode(item, uccp);
    }
    //UNFINISHED CODE:SUPPRESS CHECKSTYLE END//

    /**
     * jisコード、文字属性混在の設定でRecordConvertMaterialを返します。
     */
    private RecordConvertMaterial createRecordConvertMaterial() {
        return new RecordConvertMaterial(CharacterConvertTable.Jis, CharacterAttribute.混在);
    }

    //UNFINISHED CODE:SUPPRESS CHECKSTYLE START//
    /**
     * 引数のitemを引数のconvertParameterを元に、ReamsUnicodeに変換した値を返します。
     *
     * @param item 変換対象
     * @param convertParameter 変換パラメータ
     * <p>
     * @return ReamsUnicodeに変換された文字列
     */
    private RString getBinaryToConvertReamsUnicode(byte[] item,
            UnicodeCharacterConvertParameter convertParameter) {
        return new BinaryToReamsUnicodeConverter(convertParameter).convert(item);
    }
    //UNFINISHED CODE:SUPPRESS CHECKSTYLE END//

    /**
     * 変換用のパラメータを返します。
     *
     * @return {@link UnicodeCharacterConvertParameter Unicode変換パラメータ}
     */
    private UnicodeCharacterConvertParameter getConvertParameter() {
        return new UnicodeCharacterConvertParameterBuilder(createRecordConvertMaterial())
                .enabledConvertError(true).build();
    }

}
