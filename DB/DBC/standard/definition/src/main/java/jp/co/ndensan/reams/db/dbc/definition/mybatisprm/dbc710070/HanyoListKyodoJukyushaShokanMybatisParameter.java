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
    private RString 日付抽出区分;
    private boolean 各異動月の最新のみ;
    private List<RString> 異動区分S;
    private boolean 削除含める;

    /**
     * ンストラクタです。
     *
     * @param 処理対象年月FROM 処理対象年月FROM
     * @param 処理対象年月TO 処理対象年月TO
     * @param 日付抽出区分 日付抽出区分 // * @param 範囲指定 範囲指定 // * @param 直近のみ 直近のみ
     * @param 異動年月From 異動年月From
     * @param 異動年月To 異動年月To
     * @param 各異動月の最新のみ 各異動月の最新のみ
     * @param 削除含める 削除含める
     * @param searchKey searchKey
     * @param 異動区分S List<RString>
     */
    public HanyoListKyodoJukyushaShokanMybatisParameter(FlexibleYearMonth 処理対象年月FROM, FlexibleYearMonth 処理対象年月TO,
            RString 日付抽出区分, FlexibleYearMonth 異動年月From, FlexibleYearMonth 異動年月To, boolean 削除含める, boolean 各異動月の最新のみ,
            IShikibetsuTaishoPSMSearchKey searchKey, List<RString> 異動区分S) {
        super(searchKey);
        this.処理対象年月FROM = 処理対象年月FROM;
        this.処理対象年月TO = 処理対象年月TO;
        this.日付抽出区分 = 日付抽出区分;
        this.異動年月From = 異動年月From;
        this.異動年月To = 異動年月To;
        this.削除含める = 削除含める;
        this.各異動月の最新のみ = 各異動月の最新のみ;
        this.異動区分S = 異動区分S;
    }

}
