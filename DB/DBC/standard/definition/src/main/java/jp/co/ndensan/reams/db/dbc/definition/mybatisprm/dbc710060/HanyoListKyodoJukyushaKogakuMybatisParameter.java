/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710060;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 共同処理用受給者情報（高額）MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoListKyodoJukyushaKogakuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

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
    private List<Boolean> 利用者負担第2段階s;
    private boolean 削除含める;

    /**
     * ンストラクタです。
     *
     * @param 保険者コード RString
     * @param 日付抽出区分 RString
     * @param 処理対象年月From RString
     * @param 処理対象年月To RString
     * @param 異動年月From RString
     * @param 異動年月To RString
     * @param 各異動月の最新のみ boolean
     * @param 異動区分s List<RString>
     * @param 世帯所得区分s List<RString>
     * @param 所得区分s List<RString>
     * @param 老齢年金受給区分s List<Boolean>
     * @param 利用者負担第2段階s List<Boolean>
     * @param 削除含める boolean
     * @param searchKey searchKey
     */
    public HanyoListKyodoJukyushaKogakuMybatisParameter(RString 保険者コード, RString 日付抽出区分, RString 処理対象年月From,
            RString 処理対象年月To, RString 異動年月From, RString 異動年月To, boolean 各異動月の最新のみ, List<RString> 異動区分s,
            List<RString> 世帯所得区分s, List<RString> 所得区分s, List<Boolean> 老齢年金受給区分s, List<Boolean> 利用者負担第2段階s,
            boolean 削除含める, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.保険者コード = 保険者コード;
        this.日付抽出区分 = 日付抽出区分;
        this.処理対象年月From = 処理対象年月From;
        this.処理対象年月To = 処理対象年月To;
        this.異動年月From = 異動年月From;
        this.異動年月To = 異動年月To;
        this.各異動月の最新のみ = 各異動月の最新のみ;
        this.異動区分s = 異動区分s;
        this.世帯所得区分s = 世帯所得区分s;
        this.所得区分s = 所得区分s;
        this.老齢年金受給区分s = 老齢年金受給区分s;
        this.利用者負担第2段階s = 利用者負担第2段階s;
        this.削除含める = 削除含める;
    }

}
