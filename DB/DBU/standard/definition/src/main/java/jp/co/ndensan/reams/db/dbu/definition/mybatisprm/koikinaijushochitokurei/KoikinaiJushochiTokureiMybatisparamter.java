/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 広域内住所地特例者一覧表のMyBatisパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KoikinaiJushochiTokureiMybatisparamter implements IMyBatisParameter{
    
    private static final RString 市町村DDL1件目コード = new RString("000000");
    private final RString shichosonCode;
    private final RString idoYMD;
    private final RString kaishibi;
    private final RString shuryobi;
    private final RString psmShikibetsuTaisho;
    private final boolean isEmptyShichosonCode;
    
    /**
     * コンストラクタ
     *
     * @param shichosonCode 市町村コード
     * @param idoYMD 基準日
     * @param kaishibi 今回開始日
     * @param shuryobi 今回終了日
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param isEmptyShichosonCode 市町村コードFlag
     */
    public KoikinaiJushochiTokureiMybatisparamter(RString shichosonCode,
            RString idoYMD,
            RString kaishibi,
            RString shuryobi,
            RString psmShikibetsuTaisho,
            boolean isEmptyShichosonCode) {
        this.shichosonCode = shichosonCode;
        this.idoYMD = idoYMD;
        this.kaishibi = kaishibi;
        this.shuryobi = shuryobi;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.isEmptyShichosonCode = isEmptyShichosonCode;
    }
    
    public static KoikinaiJushochiTokureiMybatisparamter createParamter(RString shichosonCode,
            RString idoYMD,
            RString kaishibi,
            RString shuryob,
            RString psmShikibetsuTaisho) {
        boolean isEmptyShichosonCodeFlag = false;
        if (!市町村DDL1件目コード.equals(shichosonCode)) {
            isEmptyShichosonCodeFlag = true;
        }
        return new KoikinaiJushochiTokureiMybatisparamter(shichosonCode, idoYMD, kaishibi, shuryob,
               psmShikibetsuTaisho, isEmptyShichosonCodeFlag);
        
    }
}
