/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE514001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 介護認定審査会スケジュール表ですためのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBE-0130-090 yaodongsheng
 */
@Getter
@Setter
public class DBE514001_ShinsakaiScheduleParameter extends BatchParameterBase {

    private static final String SHINSAKAIKAISAIKIKANFROM = "shinsakaiKaisaiKikanFrom";
    private static final String SHINSAKAIKAISAIKIKANTO = "shinsakaiKaisaiKikanTo";
    private static final String NENDO = "shinsakaiKaisaiKikanTo";
    private static final String CHOHYOSHUTSURYOKUKUBUN = "chohyoShutsuryokuKubun";
    private static final String SHINSAKAIIINCODE = "shinsakaiIinCodeList";

    @BatchParameter(key = SHINSAKAIKAISAIKIKANFROM, name = "介護認定審査会開催予定期間From")
    private RString shinsakaiKaisaiKikanFrom;
    @BatchParameter(key = SHINSAKAIKAISAIKIKANTO, name = "介護認定審査会開催予定期間To")
    private RString shinsakaiKaisaiKikanTo;
    @BatchParameter(key = NENDO, name = "年度")
    private RString nendo;
    @BatchParameter(key = CHOHYOSHUTSURYOKUKUBUN, name = "帳票出力区分")
    private RString chohyoShutsuryokuKubun;
    @BatchParameter(key = SHINSAKAIIINCODE, name = "審査会委員コードリスト")
    private List<RString> shinsakaiIinCodeList;

    /**
     * コンストラクタです。
     */
    public DBE514001_ShinsakaiScheduleParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催予定期間From 介護認定審査会開催予定期間From
     * @param 介護認定審査会開催予定期間To 介護認定審査会開催予定期間To
     * @param 年度 年度
     * @param 帳票出力区分 帳票出力区分
     * @param 審査会委員コードリスト 審査会委員コードリスト
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DBE514001_ShinsakaiScheduleParameter(
            RString 介護認定審査会開催予定期間From,
            RString 介護認定審査会開催予定期間To,
            RString 年度,
            RString 帳票出力区分,
            List<RString> 審査会委員コードリスト) {
        this.shinsakaiKaisaiKikanFrom = 介護認定審査会開催予定期間From;
        this.shinsakaiKaisaiKikanTo = 介護認定審査会開催予定期間To;
        this.nendo = 年度;
        this.chohyoShutsuryokuKubun = 帳票出力区分;
        this.shinsakaiIinCodeList = 審査会委員コードリスト;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleProcessParamter
     */
    public KaigoNinteiShinsakaiScheduleProcessParamter toKaigoNinteiShinsakaiScheduleProcessParamter() {
        return new KaigoNinteiShinsakaiScheduleProcessParamter(shinsakaiKaisaiKikanFrom,
                shinsakaiKaisaiKikanTo,
                nendo,
                chohyoShutsuryokuKubun);
    }

    /**
     * processのパラメータを生成します。
     *
     * @return KaigoNinteiShinsakaiScheduleKagamiProcessParamter
     */
    public KaigoNinteiShinsakaiScheduleKagamiProcessParamter toKaigoNinteiShinsakaiScheduleKagamiProcessParamter() {
        return new KaigoNinteiShinsakaiScheduleKagamiProcessParamter(shinsakaiKaisaiKikanFrom,
                shinsakaiKaisaiKikanTo,
                shinsakaiIinCodeList);
    }
}
