/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動賦課情報一時テーブルInsertパラメータ
 *
 * @reamsid_L DBB-0710-040 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchNokumiParameter extends KozaSearchParameter implements IMyBatisParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 調定前年度;
    private FlexibleYear 賦課年度;
    private RString 科目コード;
    private RString 処理日;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定前年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     */
    public FuchNokumiParameter(
            FlexibleYear 調定年度,
            FlexibleYear 調定前年度,
            FlexibleYear 賦課年度,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード) {
        super(searchkey, list);
        this.科目コード = 科目コード;
        this.調定年度 = 調定年度;
        this.調定前年度 = 調定前年度;
        this.賦課年度 = 賦課年度;
        this.処理日 = 処理日;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 調定前年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 処理日 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 科目コード RString
     * @return パラメータ
     */
    public static FuchNokumiParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 調定前年度,
            FlexibleYear 賦課年度,
            RString 処理日,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 科目コード) {
        return new FuchNokumiParameter(調定年度, 調定前年度, 賦課年度, 処理日, searchkey, list, 科目コード);
    }
}
