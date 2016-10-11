/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd104010.DBD104010MybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者減免実施状況のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-3770-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD104010ProcessParameter implements IBatchProcessParameter {

    private IShikibetsuTaishoPSMSearchKey searchKey;
    private FlexibleDate 抽出期間開始日;
    private FlexibleDate 抽出期間終了日;
    private AtenaSelectBatchParameter 宛名抽出条件;
    private YMDHMS systemTime;

    private RString 出力帳票;
    private FlexibleYear 対象年度;
    private RString 基準日区分;
    private RString 基準日;
    private ReportId 帳票ID;

    /**
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 抽出期間開始日 FlexibleDate
     * @param 抽出期間終了日 FlexibleDate
     * @return DBD104010MybatisParameter
     */
    public DBD104010MybatisParameter toDBD104010MybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey, FlexibleDate 抽出期間開始日,
            FlexibleDate 抽出期間終了日) {
        this.searchKey = searchKey;
        this.抽出期間開始日 = 抽出期間開始日;
        this.抽出期間終了日 = 抽出期間終了日;
        return new DBD104010MybatisParameter(searchKey, 抽出期間開始日, 抽出期間終了日, 基準日区分, 基準日, 宛名抽出条件, 対象年度);
    }
}
