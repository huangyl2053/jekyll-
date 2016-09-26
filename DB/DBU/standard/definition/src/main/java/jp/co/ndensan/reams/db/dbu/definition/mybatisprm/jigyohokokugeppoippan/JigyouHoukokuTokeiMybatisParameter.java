/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保台帳生年月日情報処理のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyouHoukokuTokeiMybatisParameter implements IMyBatisParameter {

    private static final int 処理枝番LENGTH = 4;
    private List<RString> shichosoncodeList;
    private FlexibleYearMonth syukeiYM;
    private List<RString> shukeinoList;
    private List<RString> hyonoList;

    private SubGyomuCode subGyomuCode;
    private RString syoriName;
    private RString shoriEdaban;
    private FlexibleYear nendo;
    private FlexibleDate kijunYMD;
    private YMDHMS kijunTimestamp;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 FlexibleYearMonth
     * @param 年度 FlexibleYear
     * @param 処理日時 YMDHMS
     */
    public JigyouHoukokuTokeiMybatisParameter(FlexibleYearMonth 集計年月,
            FlexibleYear 年度,
            YMDHMS 処理日時) {
        this.syukeiYM = 集計年月;
        this.nendo = 年度;
        this.kijunTimestamp = 処理日時;
        this.kijunYMD = new FlexibleDate(処理日時.getYearValue(), 処理日時.getMonthValue(), 処理日時.getDayValue());
        this.shoriEdaban = new RString(集計年月.getMonthValue()).padZeroToLeft(処理枝番LENGTH);
        this.subGyomuCode = SubGyomuCode.DBU介護統計報告;
        this.syoriName = Syorimei.月報報告一般状況１_１１.get名称();
    }
}
