/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710050;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710050.HanyoListKyodoJukyushaMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_共同処理用受給者情報（基本）ProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3097-020 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyodoJukyushaProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private RString 出力順ID;
    private RString 出力項目ID;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付編集;
    private LasdecCode 保険者コード;
    private RString 日付抽出区分;
    private RString 範囲指定;
    private RString 直近のみ;
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
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link HanyoListKagoKekkaMybatisParameter}
     */
    public HanyoListKyodoJukyushaMybatisParameter toMybatisParameter() {
        return new HanyoListKyodoJukyushaMybatisParameter(処理対象年月FROM, 処理対象年月TO, 日付抽出区分,
                異動年月FROM, 異動年月TO, 削除含める, 各異動月の最新のみ, searchKey, 異動区分S);
    }
}
