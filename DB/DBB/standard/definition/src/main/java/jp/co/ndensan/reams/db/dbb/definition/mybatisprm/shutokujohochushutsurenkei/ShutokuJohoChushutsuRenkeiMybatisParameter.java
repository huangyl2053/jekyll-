/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shutokujohochushutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei.ShichosonJohoShutoku;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携（バッチ）のMybatisパラメータです。
 *
 * @reamsid_L DBB-1690-060 sunhui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutokuJohoChushutsuRenkeiMybatisParameter implements IMyBatisParameter {

    private final FlexibleYear shorinendo;
    private final List<ShichosonJohoShutoku> shichosonJohoList;
    private final long shutsuryokujunID;
    private final ReportId chohyoID;
    private final RString sharefilesname;
    private final RString sharefilesID;
    private final RString shorikubun;
    private final YMDHMS shorinichiji;

    /**
     * コンストラクタです。
     *
     * @param shorinendo FlexibleYear
     * @param shichosonJohoList List<ShichosonJohoEntity>
     * @param shutsuryokujunID long
     * @param chohyoID ReportId
     * @param sharefilesname RString
     * @param sharefilesID RDateTime
     * @param shorikubun RString
     * @param shorinichiji YMDHMS
     */
    public ShutokuJohoChushutsuRenkeiMybatisParameter(FlexibleYear shorinendo,
            List<ShichosonJohoShutoku> shichosonJohoList, long shutsuryokujunID, ReportId chohyoID,
            RString sharefilesname, RString sharefilesID, RString shorikubun, YMDHMS shorinichiji) {
        this.shorinendo = shorinendo;
        this.shichosonJohoList = shichosonJohoList;
        this.shutsuryokujunID = shutsuryokujunID;
        this.chohyoID = chohyoID;
        this.sharefilesname = sharefilesname;
        this.sharefilesID = sharefilesID;
        this.shorikubun = shorikubun;
        this.shorinichiji = shorinichiji;
    }

}
