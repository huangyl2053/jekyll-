/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei.ShichosonJohoShutoku;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shutokujohochushutsurenkei.ShutokuJohoChushutsuRenkeiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得情報抽出・連携（バッチ）のProcessパラメータです。
 *
 * @reamsid_L DBB-1690-060 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutokuJohoShuchutsuRenkeiProcessParameter implements IBatchProcessParameter {

    private FlexibleYear shorinendo;
    private List<ShichosonJohoShutoku> shichosonJohoList;
    private long shutsuryokujunID;
    private ReportId chohyoID;
    private RString sharefilesname;
    private RString sharefilesID;
    private RString shorikubun;
    private YMDHMS shorinichiji;

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
    public ShutokuJohoShuchutsuRenkeiProcessParameter(FlexibleYear shorinendo,
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

    /**
     * 所得情報抽出・連携（バッチ）のMyBatisパラメータ作成です。
     *
     * @return 所得情報抽出・連携（バッチ）のMyBatisパラメータ
     */
    public ShutokuJohoChushutsuRenkeiMybatisParameter toMybatisParamter() {

        return new ShutokuJohoChushutsuRenkeiMybatisParameter(
                shorinendo,
                shichosonJohoList,
                shutsuryokujunID,
                chohyoID,
                sharefilesname,
                sharefilesID,
                shorikubun,
                shorinichiji
        );
    }
}
