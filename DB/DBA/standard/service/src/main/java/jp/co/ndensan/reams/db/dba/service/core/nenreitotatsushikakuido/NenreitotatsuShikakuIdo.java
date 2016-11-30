/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA010010.DBA010010_NenreitotatsuShikakuIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushikakuido.NenreitotatsuJokenEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ６５歳年齢到達資格異動のビジネスクラスです。
 *
 * @reamsid_L DBA-0330-020 xuyue
 */
public class NenreitotatsuShikakuIdo {

    private final DbT7022ShoriDateKanriDac db7022Dac;
    private static final LasdecCode 市町村コード = new LasdecCode("000000");
    private static final RString 処理名 = new RString("年齢到達抽出処理");
    private static final RString 処理枝番 = new RString("00");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString 年度枝番 = new RString("00");

    /**
     * コンストラクタです。
     *
     */
    public NenreitotatsuShikakuIdo() {
        this.db7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * 年齢到達条件の取得を行います。
     *
     * @return 年齢到達条件Entity
     */
    public NenreitotatsuJokenEntity getNenreitotatsuJoken() {

        NenreitotatsuJokenEntity nenreitotatsuJokenEntity = new NenreitotatsuJokenEntity();

        DbT7022ShoriDateKanriEntity entity = db7022Dac.selectByKey(SubGyomuCode.DBA介護資格, 市町村コード,
                処理名, 処理枝番, 年度, 年度枝番);
        if (entity != null) {
            nenreitotatsuJokenEntity.set前回処理期間開始日(entity.getTaishoKaishiYMD());
            nenreitotatsuJokenEntity.set前回処理期間終了日(entity.getTaishoShuryoYMD());
            nenreitotatsuJokenEntity.set年齢到達期間開始日(new RString(entity.getKijunYMD().toString()));
            nenreitotatsuJokenEntity.set年齢到達期間終了日(RDate.getNowDate().toDateString());
        } else {
            nenreitotatsuJokenEntity.set前回処理期間開始日(null);
            nenreitotatsuJokenEntity.set前回処理期間終了日(null);
            nenreitotatsuJokenEntity.set年齢到達期間開始日(RDate.getNowDate().toDateString());
            nenreitotatsuJokenEntity.set年齢到達期間終了日(RDate.getNowDate().toDateString());
        }
        return nenreitotatsuJokenEntity;
    }

    /**
     * 開始日と終了日の順番の整合性チェックを行います。
     *
     * @param 年齢到達期間開始日 年齢到達期間開始日
     * @param 年齢到達期間終了日 年齢到達期間開始日
     * @return チェック結果
     */
    public boolean checkKaishibiShuryobiJunban(FlexibleDate 年齢到達期間開始日, FlexibleDate 年齢到達期間終了日) {

        if (年齢到達期間開始日.isBeforeOrEquals(年齢到達期間終了日)) {
            return true;
        }
        return false;
    }

    /**
     * 開始日と終了日の期間重複チェックを行います。
     *
     * @param 前回処理期間開始日 前回処理期間開始日
     * @param 前回処理期間終了日 前回処理期間終了日
     * @param 年齢到達期間開始日 年齢到達期間開始日
     * @param 年齢到達期間終了日 年齢到達期間終了日
     * @return チェック結果
     */
    public boolean checkKaishibiShuryobiKikanJufuku(FlexibleDate 前回処理期間開始日, FlexibleDate 前回処理期間終了日, FlexibleDate 年齢到達期間開始日, FlexibleDate 年齢到達期間終了日) {
        if (前回処理期間終了日 == null || 前回処理期間終了日.isEmpty()) {
            return true;
        }
        FlexibleDate 前回処理期間終了日の翌日 = 前回処理期間終了日.plusDay(1);
        return !前回処理期間終了日の翌日.isBefore(年齢到達期間開始日);
    }

    /**
     * バッチパラメータ作成を行います。
     *
     * @param 年齢到達期間開始日 年齢到達期間開始日
     * @param 年齢到達期間終了日 年齢到達期間開始日
     * @return 65歳年齢到達資格異動バッチパラメータクラス
     */
    public DBA010010_NenreitotatsuShikakuIdoParameter getNenreitotatsuJokenBatchParameter(FlexibleDate 年齢到達期間開始日, FlexibleDate 年齢到達期間終了日) {

        return new DBA010010_NenreitotatsuShikakuIdoParameter().createRoreiFukushiParam(年齢到達期間開始日, 年齢到達期間終了日);
    }

}
