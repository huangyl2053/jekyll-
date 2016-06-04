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
 * 被保険者台帳一括作成のMyBatisパラメータです。
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IkkatsuSakuseiMybatisParameter implements IMyBatisParameter {

    private final boolean chushutsuFlag;
    private final LasdecCode shichosonCode;
    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;
    private final RString orderby;
    private final boolean orderbyFlag;

    /**
     * コンストラクタです。
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 識別対象PSM 識別対象PSM
     * @param orderby orderby
     * @param orderbyFlag orderbyFlag
     */
    private IkkatsuSakuseiMybatisParameter(boolean 資格喪失者抽出フラグ,
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            RString 識別対象PSM,
            RString orderby,
            boolean orderbyFlag) {
        this.chushutsuFlag = 資格喪失者抽出フラグ;
        this.shichosonCode = 市町村コード;
        this.shikibetsuCode = 識別コード;
        this.psmShikibetsuTaisho = 識別対象PSM;
        this.orderby = orderby;
        this.orderbyFlag = orderbyFlag;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param 資格喪失者抽出フラグ 資格喪失者抽出フラグ
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 識別対象PSM 識別対象PSM
     * @param orderby orderby
     *
     * @return mybatisパラメータ
     */
    public static IkkatsuSakuseiMybatisParameter createSelectByKeyParam(boolean 資格喪失者抽出フラグ,
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            RString 識別対象PSM,
            RString orderby) {
        boolean flag = false;
        if (!RString.isNullOrEmpty(orderby)) {
            flag = true;
        }
        return new IkkatsuSakuseiMybatisParameter(資格喪失者抽出フラグ,
                市町村コード,
                識別コード,
                識別対象PSM,
                orderby,
                flag);
    }
}
