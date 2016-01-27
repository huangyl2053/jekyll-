/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.core.dbamn71001.DBAMN71001BatchFlowParameter;
import jp.co.ndensan.reams.db.dba.entity.nenreitotatsushikakuido.NenreitotatsuJokenEntity;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ６５歳年齢到達資格異動のビジネスクラスです。
 *
 */
public class NenreitotatsuShikakuIdo {

    private static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBA");
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理名 = new RString("年齢到達抽出処理");
    private static final RString 処理枝番 = new RString("00");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度枝番 = new RString("00");
    private static DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public NenreitotatsuShikakuIdo() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);

    }

    /**
     * 処理日付管理マスタから、年齢到達条件を取得する。
     *
     * @return 年齢到達条件Entity
     */
    public NenreitotatsuJokenEntity getNenreitotatsuJoken() {

        NenreitotatsuJokenEntity entity = new NenreitotatsuJokenEntity();
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        DbT7022ShoriDateKanriEntity 処理日付 = dac.selectByKey(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度枝番);

        if (処理日付 != null) {
            entity.set前回処理期間開始日(処理日付.getTaishoKaishiYMD());
            entity.set前回処理期間終了日(処理日付.getTaishoShuryoYMD());
            entity.set年齢到達期間開始日(処理日付.getKijunTimestamp().toDateString());
            entity.set年齢到達期間終了日(RDate.getNowDate().toDateString());
        } else {
            entity.set前回処理期間開始日(null);
            entity.set前回処理期間終了日(null);
            entity.set年齢到達期間開始日(RDate.getNowDate().toDateString());
            entity.set年齢到達期間終了日(RDate.getNowDate().toDateString());
        }
        return entity;
    }

    /**
     * 開始日、終了日によって、順番の整合性チェックを実施する。
     *
     * @param 年齢到達期間開始日 年齢到達期間開始日
     * @param 年齢到達期間終了日 年齢到達期間終了日
     *
     * @return チェックOK（ true; false)
     */
    public boolean checkKaishibiShuryobiJunban(FlexibleDate 年齢到達期間開始日, FlexibleDate 年齢到達期間終了日) {

        if (new FlexibleDate(年齢到達期間開始日.toString()).isBeforeOrEquals(年齢到達期間終了日)) {
            return true;
        } else {
            throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace(年齢到達期間開始日.toString(), 年齢到達期間終了日.toString()));
        }
    }

    /**
     * 開始日、終了日によって、期間重複チェックを実施する。
     *
     * @param 前回処理期間終了日 前回処理期間終了日
     * @param 年齢到達期間開始日 年齢到達期間開始日
     *
     * @return チェックOK（ true; false)
     */
    public boolean checkKaishibiShuryobiKikanJufuku(FlexibleDate 前回処理期間終了日, FlexibleDate 年齢到達期間開始日) {

        if (new FlexibleDate(前回処理期間終了日.toString()).isBefore(年齢到達期間開始日)) {
            return true;
        } else {
            throw new ApplicationException(DbzErrorMessages.期間が不正_過去日付不可.getMessage().replace(年齢到達期間開始日.toString(), 前回処理期間終了日.toString()));
        }
    }

    /**
     * 画面から入力するデータより、バッチ用パラメータクラスを作成する。
     *
     * @param 年齢到達期間開始日 年齢到達期間開始日
     * @param 年齢到達期間終了日 年齢到達期間終了日
     *
     * @return 65歳年齢到達資格異動バッチパラメータクラス
     */
    public DBAMN71001BatchFlowParameter getNenreitotatsuJokenBatchParameter(RString 年齢到達期間開始日, RString 年齢到達期間終了日) {

        return DBAMN71001BatchFlowParameter.createRoreiFukushiParam(new FlexibleDate(年齢到達期間開始日), new FlexibleDate(年齢到達期間終了日));
    }
}
