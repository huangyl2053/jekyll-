/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecoderiyojokyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.TempDbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * サービスコード別利用状況作成ReportEntityクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeRiyojokyoReportEntity extends DbTableEntityBase<TempDbWT0001HihokenshaEntity>
        implements IDbAccessable {

    private RString 種類コード;
    private RString 項目コード;
    private RString サービス略称_上;
    private Decimal 非該当日数_回数集計値;
    private Decimal 要支援１日数_回数集計値;
    private Decimal 要支援２日数_回数集計値;
    private Decimal 経過的要介護日数_回数集計値;
    private Decimal 要介護１日数_回数集計値;
    private Decimal 要介護２日数_回数集計値;
    private Decimal 要介護３日数_回数集計値;
    private Decimal 要介護４日数_回数集計値;
    private Decimal 要介護５日数_回数集計値;
    private Decimal 日数_回数合計値;
    private RString サービス略称_下;
    private Decimal 非該当単位数集計値;
    private Decimal 要支援１単位数集計値;
    private Decimal 要支援２単位数集計値;
    private Decimal 経過的要介護単位数集計値;
    private Decimal 要介護１単位数集計値;
    private Decimal 要介護２単位数集計値;
    private Decimal 要介護３単位数集計値;
    private Decimal 要介護４単位数集計値;
    private Decimal 要介護５単位数集計値;
    private Decimal 単位数合計値;

}
