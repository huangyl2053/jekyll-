/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710060;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710060.HanyoListKyodoJukyushaKogakuMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 共同処理用受給者情報（高額）ProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKyodoJukyushaKogakuProcessParameter implements IBatchProcessParameter {

    private RString 帳票ID;
    private Long 出力順ID;
    private RString 出力項目ID;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付編集;
    private RString 保険者コード;
    private RString 日付抽出区分;
    private RString 処理対象年月From;
    private RString 処理対象年月To;
    private RString 異動年月From;
    private RString 異動年月To;
    private boolean 各異動月の最新のみ;
    private List<RString> 異動区分s;
    private List<RString> 世帯所得区分s;
    private List<RString> 所得区分s;
    private List<Boolean> 老齢年金受給区分s;
    private List<Boolean> 利用者負担第２段階s;
    private boolean 削除含める;

    private IShikibetsuTaishoPSMSearchKey searchKey;

    private RDateTime システム日時;

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link HanyoListKyodoJukyushaKogakuMybatisParameter}
     */
    public HanyoListKyodoJukyushaKogakuMybatisParameter toMybatisParameter() {
        return new HanyoListKyodoJukyushaKogakuMybatisParameter(保険者コード, 日付抽出区分, 処理対象年月From, 処理対象年月To, 異動年月From, 異動年月To,
                各異動月の最新のみ, 異動区分s, 世帯所得区分s, 所得区分s, 老齢年金受給区分s, 利用者負担第２段階s, 削除含める, searchKey);
    }
}
