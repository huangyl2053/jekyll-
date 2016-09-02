/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hanyolistfukadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBBBT22001_汎用リスト 賦課台帳MybatisParameterのクラス
 *
 * @reamsid_L DBB-1900-030 zhaowei
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListDaichoMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final boolean 最新状態で抽出;
    private final RDate 基準日;
    private final RString 基準日区分;
    private final List<RString> 保険料段階s;
    private final RString 保険者コード;
    private final RString 資格区分;
    private final RString 受給者判定;
    private final RDate システム日付;
    private final RString 賦課基準日で抽出;
    private final RString 調定日で抽出;
    private final RString 資格取得者のみ;
    private final RString 資格喪失者のみ;
    private final RString 受給者のみ;
    private final RString 有効無効区分;
    private final AtenaSelectBatchParameter 宛名抽出条件;
    private final RString 出力順;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 最新状態で抽出 boolean
     * @param 基準日 RDate
     * @param 基準日区分 RString
     * @param 保険料段階s List<RString>
     * @param 保険者コード RString
     * @param 受給者判定 RString
     * @param システム日付 RDate
     * @param 賦課基準日で抽出 RString
     * @param 調定日で抽出 RString
     * @param 資格取得者のみ RString
     * @param 資格喪失者のみ RString
     * @param 受給者のみ RString
     * @param 資格区分 RString
     * @param 有効無効区分 RString
     * @param 宛名抽出条件 AtenaSelectBatchParameter
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 出力順 RString
     */
    public HanyoListDaichoMybatisParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            boolean 最新状態で抽出,
            RDate 基準日,
            RString 基準日区分,
            List<RString> 保険料段階s,
            RString 保険者コード,
            RString 資格区分,
            RString 受給者判定,
            RDate システム日付,
            RString 賦課基準日で抽出,
            RString 調定日で抽出,
            RString 資格取得者のみ,
            RString 資格喪失者のみ,
            RString 受給者のみ,
            RString 有効無効区分,
            AtenaSelectBatchParameter 宛名抽出条件,
            IShikibetsuTaishoPSMSearchKey searchKey,
            RString 出力順) {
        super(searchKey);
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.最新状態で抽出 = 最新状態で抽出;
        this.基準日 = 基準日;
        this.基準日区分 = 基準日区分;
        this.保険料段階s = 保険料段階s;
        this.保険者コード = 保険者コード;
        this.資格区分 = 資格区分;
        this.受給者判定 = 受給者判定;
        this.システム日付 = システム日付;
        this.賦課基準日で抽出 = 賦課基準日で抽出;
        this.調定日で抽出 = 調定日で抽出;
        this.資格取得者のみ = 資格取得者のみ;
        this.資格喪失者のみ = 資格喪失者のみ;
        this.受給者のみ = 受給者のみ;
        this.有効無効区分 = 有効無効区分;
        this.宛名抽出条件 = 宛名抽出条件;
        this.出力順 = 出力順;
    }
}
