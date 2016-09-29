/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710070.HanyoListKyodoJukyushaShokanMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_共同処理用受給者情報（償還）ProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3099-020 zhouchuanlin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyodoJukyushaShokanProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private RString 出力順ID;
    private RString 出力項目ID;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付編集;
    private RString 保険者コード;
    private RString 日付抽出区分;
    private FlexibleYearMonth 処理対象年月FROM;
    private FlexibleYearMonth 処理対象年月TO;
    private FlexibleYearMonth 異動年月FROM;
    private FlexibleYearMonth 異動年月TO;
    private boolean 各異動月の最新のみ;
    private List<RString> 異動区分S;
    private boolean 削除含める;

    private IShikibetsuTaishoPSMSearchKey searchKey;

    private RDateTime システム日時;
    private FlexibleDate システム日付;

    /**
     * ンストラクタです。
     *
     * @param 帳票ID RString
     * @param 出力順ID RString
     * @param 出力項目ID RString
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付編集 boolean
     * @param 保険者コード RString
     * @param 日付抽出区分 RString
     * @param 処理対象年月FROM FlexibleYearMonth
     * @param 処理対象年月TO FlexibleYearMonth
     * @param 異動年月FROM FlexibleYearMonth
     * @param 異動年月TO FlexibleYearMonth
     * @param 各異動月の最新のみ boolean
     * @param 異動区分S List<RString>
     * @param 削除含める boolean
     */
    public HanyoListKyodoJukyushaShokanProcessParameter(
            RString 帳票ID, RString 出力順ID, RString 出力項目ID, boolean 項目名付加, boolean 連番付加, boolean 日付編集,
            RString 保険者コード, RString 日付抽出区分, FlexibleYearMonth 処理対象年月FROM, FlexibleYearMonth 処理対象年月TO,
            FlexibleYearMonth 異動年月FROM, FlexibleYearMonth 異動年月TO, boolean 各異動月の最新のみ, List<RString> 異動区分S,
            boolean 削除含める) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.出力項目ID = 出力項目ID;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付編集 = 日付編集;
        this.保険者コード = 保険者コード;
        this.日付抽出区分 = 日付抽出区分;
        this.処理対象年月FROM = 処理対象年月FROM;
        this.処理対象年月TO = 処理対象年月TO;
        this.異動年月FROM = 異動年月FROM;
        this.異動年月TO = 異動年月TO;
        this.各異動月の最新のみ = 各異動月の最新のみ;
        this.異動区分S = 異動区分S;
        this.削除含める = 削除含める;
    }

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link HanyoListKyodoJukyushaShokanMybatisParameter}
     */
    public HanyoListKyodoJukyushaShokanMybatisParameter tomMybatisParameter() {
        return new HanyoListKyodoJukyushaShokanMybatisParameter(処理対象年月FROM, 処理対象年月TO, 保険者コード, 日付抽出区分,
                異動年月FROM, 異動年月TO, 削除含める, 各異動月の最新のみ, searchKey, 異動区分S);
    }
}
