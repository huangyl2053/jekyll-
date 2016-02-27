/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 申請書_共通クラス部分パラメータクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuteifutanGendogakuShinseishoMybatisParameter {

    private final HihokenshaNo 被保険者番号;
    private final ShikibetsuCode 識別コード;
    private final boolean is被保険者番号_FLG;
    private final boolean is識別コード_FLG;

    private TokuteifutanGendogakuShinseishoMybatisParameter(
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            boolean is被保険者番号_FLG,
            boolean is識別コード_FLG) {
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
        this.is被保険者番号_FLG = is被保険者番号_FLG;
        this.is識別コード_FLG = is識別コード_FLG;
    }

    /**
     * 申請書_共通クラス部分のパラメータです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param is被保険者番号_FLG 被保険者番号_FLG
     * @param is識別コード_FLG 識別コード_FLG
     * @return TokuteifutanGendogakuShinseishoMapperParameter
     */
    public static TokuteifutanGendogakuShinseishoMybatisParameter createParam(
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            boolean is被保険者番号_FLG,
            boolean is識別コード_FLG) {
        return new TokuteifutanGendogakuShinseishoMybatisParameter(
                被保険者番号,
                識別コード,
                is被保険者番号_FLG,
                is識別コード_FLG);
    }
}
