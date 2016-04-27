/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkyotakuservicekeikaku;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 汎用リスト 居宅サービス計画のMybatisParameterクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyotakuServiceKeikakuMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final LasdecCode 構成市町村コード;
    private final RString 作成区分;
    private final RString 抽出区分;
    private final FlexibleDate 基準年月日;
    private final RString 支援事業者番号;
    private final RString 改頁出力順ID;
    private final RString 出力項目ID;
    private final boolean csv項目名付加;
    private final boolean csv連番付加;
    private final boolean csv日付スラッシュ編集;

    /**
     * コンストラクタ
     *
     * @param 構成市町村コード LasdecCode
     * @param 作成区分 RString
     * @param 抽出区分 RString
     * @param 基準年月日 FlexibleDate
     * @param 支援事業者番号 RString
     * @param 改頁出力順ID RString
     * @param 出力項目ID RString
     * @param csv項目名付加 boolean
     * @param csv連番付加 boolean
     * @param csv日付スラッシュ編集 boolean
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public HanyoListKyotakuServiceKeikakuMybatisParameter(LasdecCode 構成市町村コード,
            RString 作成区分, RString 抽出区分,
            FlexibleDate 基準年月日, RString 支援事業者番号,
            RString 改頁出力順ID, RString 出力項目ID,
            boolean csv項目名付加, boolean csv連番付加,
            boolean csv日付スラッシュ編集, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.構成市町村コード = 構成市町村コード;
        this.作成区分 = 作成区分;
        this.抽出区分 = 抽出区分;
        this.基準年月日 = 基準年月日;
        this.支援事業者番号 = 支援事業者番号;
        this.改頁出力順ID = 改頁出力順ID;
        this.出力項目ID = 出力項目ID;
        this.csv項目名付加 = csv項目名付加;
        this.csv連番付加 = csv連番付加;
        this.csv日付スラッシュ編集 = csv日付スラッシュ編集;

    }
}
