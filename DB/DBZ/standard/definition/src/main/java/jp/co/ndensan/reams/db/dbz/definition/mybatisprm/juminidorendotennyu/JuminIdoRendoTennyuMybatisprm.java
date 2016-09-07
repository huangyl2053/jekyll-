/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.juminidorendotennyu;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録_転入のパラメータです。
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class JuminIdoRendoTennyuMybatisprm {

    private final RString psmShikibetsuTaisho;
    private final RString 性別コード;
    private final FlexibleDate 生年月日;
    private final AtenaKanaMeisho カナ名称;

    private JuminIdoRendoTennyuMybatisprm(RString psmShikibetsuTaisho,
            RString 性別コード,
            FlexibleDate 生年月日,
            AtenaKanaMeisho カナ名称) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.性別コード = 性別コード;
        this.生年月日 = 生年月日;
        this.カナ名称 = カナ名称;
    }

    /**
     * パラメータ設定です
     *
     * @param psmShikibetsuTaisho RString
     * @param 性別コード RString
     * @param 生年月日 FlexibleDate
     * @param カナ名称 RString
     * @return JuminIdoRendoTennyuMybatisprm
     */
    public static JuminIdoRendoTennyuMybatisprm createParam(RString psmShikibetsuTaisho,
            RString 性別コード,
            FlexibleDate 生年月日,
            AtenaKanaMeisho カナ名称) {
        return new JuminIdoRendoTennyuMybatisprm(psmShikibetsuTaisho, 性別コード, 生年月日, カナ名称);
    }
}
