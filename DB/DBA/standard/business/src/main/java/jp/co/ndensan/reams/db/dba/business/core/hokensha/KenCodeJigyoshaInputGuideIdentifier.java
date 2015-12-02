/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokensha;

import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoDataKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 全国住所情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KenCodeJigyoshaInputGuideIdentifier {

    private final ZenkokuJushoDataKubun dataKubun;
    private final RString todofukenJushoCode;
    private final RString shichosonJushoCode;
    private final RString ooazaJushoCode;
    private final RString azaChoJushoCode;

    /**
     * コンストラクタです。
     *
     * @param dataKubun データ区分
     * @param todofukenJushoCode 都道府県住所コード
     * @param shichosonJushoCode 市町村住所コード
     * @param ooazaJushoCode 大字住所コード
     * @param azaChoJushoCode 字丁住所コード
     */
    public KenCodeJigyoshaInputGuideIdentifier(
            ZenkokuJushoDataKubun dataKubun,
            RString todofukenJushoCode,
            RString shichosonJushoCode,
            RString ooazaJushoCode,
            RString azaChoJushoCode) {
        this.dataKubun = dataKubun;
        this.todofukenJushoCode = todofukenJushoCode;
        this.shichosonJushoCode = shichosonJushoCode;
        this.ooazaJushoCode = ooazaJushoCode;
        this.azaChoJushoCode = azaChoJushoCode;
    }
}
