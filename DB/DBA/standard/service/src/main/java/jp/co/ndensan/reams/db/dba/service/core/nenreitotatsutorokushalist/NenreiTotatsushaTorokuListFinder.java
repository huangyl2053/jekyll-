/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.nenreitotatsutorokushalist;

import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA150010.DBA150010_NenreitotatsuTorokuListParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 年齢到達登録者リスト作成クラスです。
 *
 * @reamsid_L DBA-0570-030 xuyannan
 */
public class NenreiTotatsushaTorokuListFinder {

    private static final RString 処理名 = new RString("年齢到達登録者リスト");
    private static final RString MIN_日時 = new RString(" 00:00:00.000");
    private static final RString MAX_日時 = new RString(" 23:59:59.999");
    private static final RString ライン = new RString("-");
    private static final int 年終了桁数 = 4;
    private static final int 月終了桁数 = 6;
    private static final int 日終了桁数 = 8;
    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public NenreiTotatsushaTorokuListFinder() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7022ShoriDateKanriDac}
     */
    NenreiTotatsushaTorokuListFinder(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NenreiTotatsushaTorokuListFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NenreiTotatsushaTorokuListFinder}のインスタンス
     */
    public static NenreiTotatsushaTorokuListFinder createInstance() {
        return InstanceProvider.create(NenreiTotatsushaTorokuListFinder.class);
    }

    /**
     * 前回開始終了日を取得します。
     *
     * @return DbT7022ShoriDateKanriEntity 処理日付管理マスタEntiy(nullを返すことがある)
     */
    @Transaction
    public DbT7022ShoriDateKanriBusiness getKaishiShuryobi() {
        DbT7022ShoriDateKanriEntity entity = dac.select処理日付管理BYサブ業務コードAND処理名(SubGyomuCode.DBA介護資格, 処理名);
        if (entity == null) {
            return null;
        }
        return new DbT7022ShoriDateKanriBusiness(entity);
    }

    /**
     * バッチ用パラメータ作成。
     *
     * @param 前回開始日 前回開始日
     * @param 前回終了日 前回終了日
     * @param 今回開始日 今回開始日
     * @param 今回終了日 今回終了日
     * @param 出力順ID 出力順ID
     * @return DBA150010_NenreitotatsuTorokuListParameter 年齢到達登録者リスト作成バッチパラメータクラス
     */
    public DBA150010_NenreitotatsuTorokuListParameter getNenreiTotatsushaTorokuListBatchParameter(
            FlexibleDate 前回開始日,
            FlexibleDate 前回終了日,
            FlexibleDate 今回開始日,
            FlexibleDate 今回終了日,
            Long 出力順ID) {
        DBA150010_NenreitotatsuTorokuListParameter parameter = new DBA150010_NenreitotatsuTorokuListParameter();
        RStringBuilder 今回開始日Builder = new RStringBuilder();
        RStringBuilder 今回終了日Builder = new RStringBuilder();

        if (!前回開始日.isEmpty()) {
            RStringBuilder 前回開始日Builder = new RStringBuilder();
            前回開始日Builder.append(前回開始日.toString().substring(0, 年終了桁数));
            前回開始日Builder.append(ライン.toString());
            前回開始日Builder.append(前回開始日.toString().substring(年終了桁数, 月終了桁数));
            前回開始日Builder.append(ライン.toString());
            前回開始日Builder.append(前回開始日.toString().substring(月終了桁数, 日終了桁数));
            前回開始日Builder.append(MIN_日時.toString());
            parameter.setZenkaikaishiYMDHMS(前回開始日Builder.toRString());
        }
        if (!前回終了日.isEmpty()) {
            RStringBuilder 前回終了日Builder = new RStringBuilder();
            前回終了日Builder.append(前回終了日.toString().substring(0, 年終了桁数));
            前回終了日Builder.append(ライン.toString());
            前回終了日Builder.append(前回終了日.toString().substring(年終了桁数, 月終了桁数));
            前回終了日Builder.append(ライン.toString());
            前回終了日Builder.append(前回終了日.toString().substring(月終了桁数, 日終了桁数));
            前回終了日Builder.append(MAX_日時.toString());
            parameter.setZenkaishuryoYMDHMS(前回終了日Builder.toRString());
        }
        今回開始日Builder.append(今回開始日.toString().substring(0, 年終了桁数));
        今回開始日Builder.append(ライン.toString());
        今回開始日Builder.append(今回開始日.toString().substring(年終了桁数, 月終了桁数));
        今回開始日Builder.append(ライン.toString());
        今回開始日Builder.append(今回開始日.toString().substring(月終了桁数, 日終了桁数));
        今回開始日Builder.append(MIN_日時.toString());
        今回終了日Builder.append(今回終了日.toString().substring(0, 年終了桁数));
        今回終了日Builder.append(ライン.toString());
        今回終了日Builder.append(今回終了日.toString().substring(年終了桁数, 月終了桁数));
        今回終了日Builder.append(ライン.toString());
        今回終了日Builder.append(今回終了日.toString().substring(月終了桁数, 日終了桁数));
        今回終了日Builder.append(MAX_日時.toString());
        parameter.setKonkaikaishiYMDHMS(今回開始日Builder.toRString());
        parameter.setKonkaishuryoYMDHMS(今回終了日Builder.toRString());
        parameter.setShutsuryokujunID(出力順ID);
        return parameter;
    }
}
