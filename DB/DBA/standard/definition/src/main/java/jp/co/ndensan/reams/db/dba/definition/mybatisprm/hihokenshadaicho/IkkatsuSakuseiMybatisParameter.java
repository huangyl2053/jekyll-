/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 被保険者証一括発行のMyBatisパラメータです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IkkatsuSakuseiMybatisParameter implements IMyBatisParameter {

    private final RString chushutsuFlag;
    private final LasdecCode shichosonCode;
    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 識別対象PSM 識別対象PSM
     */
    private IkkatsuSakuseiMybatisParameter(RString 資格喪失者抽出フラグ,
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            RString 識別対象PSM) {
        this.chushutsuFlag = 資格喪失者抽出フラグ;
        this.shichosonCode = 市町村コード;
        this.shikibetsuCode = 識別コード;
        this.psmShikibetsuTaisho = 識別対象PSM;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 識別対象PSM 識別対象PSM
     *
     * @return mybatisパラメータ
     */
    public static IkkatsuSakuseiMybatisParameter createSelectByKeyParam(RString 資格喪失者抽出フラグ,
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            RString 識別対象PSM) {
        return new IkkatsuSakuseiMybatisParameter(資格喪失者抽出フラグ, 市町村コード, 識別コード, 識別対象PSM);
    }
}
