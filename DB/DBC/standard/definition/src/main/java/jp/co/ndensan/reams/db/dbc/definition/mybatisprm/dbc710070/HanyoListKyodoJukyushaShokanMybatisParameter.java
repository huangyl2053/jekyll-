/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710070;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_共同処理用受給者情報（償還）MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3099-020 zhouchuanlin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyodoJukyushaShokanMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private FlexibleYearMonth 処理対象年月FROM;
    private FlexibleYearMonth 処理対象年月TO;
    private FlexibleYearMonth 異動年月From;
    private FlexibleYearMonth 異動年月To;
    private RString 保険者コード;
    private RString 日付抽出区分;
    private boolean 各異動月の最新のみ;
    private List<RString> 異動区分S;
    private boolean 削除含める;

    /**
     * ンストラクタです。
     *
     * @param 処理対象年月FROM FlexibleYearMonth
     * @param 処理対象年月TO FlexibleYearMonth
     * @param 保険者コード RString
     * @param 日付抽出区分 RString
     * @param 異動年月From FlexibleYearMonth
     * @param 異動年月To FlexibleYearMonth
     * @param 各異動月の最新のみ boolean
     * @param 削除含める boolean
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 異動区分S List<RString>
     */
    public HanyoListKyodoJukyushaShokanMybatisParameter(FlexibleYearMonth 処理対象年月FROM, FlexibleYearMonth 処理対象年月TO,
            RString 保険者コード, RString 日付抽出区分, FlexibleYearMonth 異動年月From, FlexibleYearMonth 異動年月To, boolean 削除含める,
            boolean 各異動月の最新のみ, IShikibetsuTaishoPSMSearchKey searchKey, List<RString> 異動区分S) {
        super(searchKey);
        this.処理対象年月FROM = 処理対象年月FROM;
        this.処理対象年月TO = 処理対象年月TO;
        this.日付抽出区分 = 日付抽出区分;
        this.保険者コード = 保険者コード;
        this.異動年月From = 異動年月From;
        this.異動年月To = 異動年月To;
        this.削除含める = 削除含める;
        this.各異動月の最新のみ = 各異動月の最新のみ;
        this.異動区分S = 異動区分S;
    }

}
