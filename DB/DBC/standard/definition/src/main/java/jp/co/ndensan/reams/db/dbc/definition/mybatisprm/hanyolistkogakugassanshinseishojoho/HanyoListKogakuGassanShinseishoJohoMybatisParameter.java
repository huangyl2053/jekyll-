/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanshinseishojoho;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)MybatisParameter
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanShinseishoJohoMybatisParameter extends KozaSearchParameter
        implements IMyBatisParameter {

    private RString 抽出区分;
    private RString 申請状況区分;
    private RString 対象年度;
    private FlexibleDate 申請年月日From;
    private FlexibleDate 申請年月日To;
    private RString 支給申請書整理番号From;
    private RString 支給申請書整理番号To;
    private FlexibleYearMonth 送付年月From;
    private FlexibleYearMonth 送付年月To;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private RString 保険者コード;
    private Long 出力順;
    private RString 出力項目;
    private boolean hasValidKamoku;

    /**
     * コンストラクタです
     *
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 抽出区分 RString
     * @param 申請状況区分 RString
     * @param 対象年度 RString
     * @param 申請年月日From FlexibleDate
     * @param 申請年月日To FlexibleDate
     * @param 支給申請書整理番号From RString
     * @param 支給申請書整理番号To RString
     * @param 送付年月From FlexibleYearMonth
     * @param 送付年月To FlexibleYearMonth
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付スラッシュ付加 boolean
     * @param 保険者コード RString
     * @param 出力順 RString
     * @param 出力項目 RString
     */
    public HanyoListKogakuGassanShinseishoJohoMybatisParameter(
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 抽出区分,
            RString 申請状況区分,
            RString 対象年度,
            FlexibleDate 申請年月日From,
            FlexibleDate 申請年月日To,
            RString 支給申請書整理番号From,
            RString 支給申請書整理番号To,
            FlexibleYearMonth 送付年月From,
            FlexibleYearMonth 送付年月To,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            RString 保険者コード,
            Long 出力順,
            RString 出力項目
    ) {
        super(searchkey, list);
        this.抽出区分 = 抽出区分;
        this.申請状況区分 = 申請状況区分;
        this.対象年度 = 対象年度;
        this.申請年月日From = 申請年月日From;
        this.申請年月日To = 申請年月日To;
        this.支給申請書整理番号From = 支給申請書整理番号From;
        this.支給申請書整理番号To = 支給申請書整理番号To;
        this.送付年月From = 送付年月From;
        this.送付年月To = 送付年月To;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.保険者コード = 保険者コード;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
        this.hasValidKamoku = super.has権限有科目();
    }
}
