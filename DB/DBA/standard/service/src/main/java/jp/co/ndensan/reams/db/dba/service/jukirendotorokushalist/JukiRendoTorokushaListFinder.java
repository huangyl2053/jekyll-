/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.jukirendotorokushalist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jukinentotoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.batchprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住基連動登録者リスト作成クラスです
 */
public class JukiRendoTorokushaListFinder {

    private final DbT7022ShoriDateKanriDac dac;
    private static final RString 処理名 = new RString("住基連動登録者リスト");
    private static final RString MIN_日時 = new RString(" 00:00:00.000");
    private static final RString MAX_日時 = new RString(" 23:59:59.999");
    private static final RString ライン = new RString("-");
    private static final RString CHECKBOX_KEY0 = new RString("key0");
    private static final RString CHECKBOX_KEY1 = new RString("key1");
    private static final RString CHECKBOX_KEY2 = new RString("key2");

    /**
     * コンストラクタです。
     */
    public JukiRendoTorokushaListFinder() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7022ShoriDateKanriDac}
     */
    JukiRendoTorokushaListFinder(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukiRendoTorokushaListFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukiRendoTorokushaListFinder}のインスタンス
     */
    public static JukiRendoTorokushaListFinder createInstance() {
        return InstanceProvider.create(JukiRendoTorokushaListFinder.class);
    }

    /**
     * 前回開始終了日を取得します。
     *
     * @return DbT7022ShoriDateKanriEntity 処理日付管理マスタEntiy(nullを返すことがある)
     */
    @Transaction
    public DbT7022ShoriDateKanriBusiness getKaishiShuryobi() {
        // TODO QA303を提出しました
        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(
                SubGyomuCode.DBA介護資格,
                LasdecCode.EMPTY,
                処理名,
                RString.EMPTY,
                FlexibleYear.MAX,
                RString.EMPTY);
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
     * @param 対象台帳 対象台帳
     * @param 出力順ID 出力順ID
     * @return JyukiRendoTorokushaListBatchParameter 住基連動登録者リスト作成バッチパラメータクラス
     */
    public JyukiRendoTorokushaListBatchParameter getJukiRendoJouhouParameter(
            FlexibleDate 前回開始日,
            FlexibleDate 前回終了日,
            FlexibleDate 今回開始日,
            FlexibleDate 今回終了日,
            List<RString> 対象台帳,
            RString 出力順ID) {
        boolean 被保険者台帳フラグ = false;
        boolean 他住所地特例者管理フラグ = false;
        boolean 適用除外者台帳フラグ = false;

        for (RString key : 対象台帳) {
            if (CHECKBOX_KEY0.equals(key)) {
                被保険者台帳フラグ = true;
            } else if (CHECKBOX_KEY1.equals(key)) {
                他住所地特例者管理フラグ = true;
            } else if (CHECKBOX_KEY2.equals(key)) {
                適用除外者台帳フラグ = true;
            }
        }
        // TODO QA332を提出しました
        JyukiRendoTorokushaListBatchParameter parameter = new JyukiRendoTorokushaListBatchParameter();

        if (!前回開始日.isEmpty()) {

            parameter.setZenkaikaishiYMDHMS(new RString(前回開始日.toString().substring(0, 4) + ライン.toString()
                    + 前回開始日.toString().substring(4, 6) + ライン.toString()
                    + 前回開始日.toString().substring(6, 8) + MIN_日時.toString()));
        }
        if (!前回終了日.isEmpty()) {
            parameter.setZenkaishuryoYMDHMS(new RString(前回終了日.toString().substring(0, 4) + ライン.toString()
                    + 前回終了日.toString().substring(4, 6) + ライン.toString()
                    + 前回終了日.toString().substring(6, 8) + MAX_日時.toString()));
        }
        parameter.setKonkaikaishiYMDHMS(new RString(今回開始日.toString().substring(0, 4) + ライン.toString()
                + 今回開始日.toString().substring(4, 6) + ライン.toString()
                + 今回開始日.toString().substring(6, 8) + MIN_日時.toString()));
        parameter.setKonkaishuryoYMDHMS(new RString(今回終了日.toString().substring(0, 4) + ライン.toString()
                + 今回終了日.toString().substring(4, 6) + ライン.toString()
                + 今回終了日.toString().substring(6, 8) + MAX_日時.toString()));
        parameter.setHihokenshadaichoFLG(被保険者台帳フラグ);
        parameter.setTajushochitokureishakanriFLG(他住所地特例者管理フラグ);
        parameter.setTekiyojogaishadaichoFLG(適用除外者台帳フラグ);
        parameter.setShuturyokujunID(RString.EMPTY);
        return parameter;
    }

    /**
     * 開始日、終了日によって、順番の整合性チェックを実施する。
     *
     * @param 今回開始日 今回開始日
     * @param 今回終了日 今回終了日
     *
     * @return チェックOK（ true; false)
     */
    public boolean checkKaishibiShuryobiJunban(FlexibleDate 今回開始日, FlexibleDate 今回終了日) {
        if (今回開始日.isBeforeOrEquals(今回終了日)) {
            return true;
        } else {
            throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("開始日", "終了日"));
        }
    }

    /**
     * 開始日、終了日によって、必須チェックを実施する。
     *
     * @param 今回開始日 今回開始日
     * @param 今回終了日 今回終了日
     *
     * @return チェックOK（ true; false)
     */
    public boolean checkKaishibiShuryobiHisu(FlexibleDate 今回開始日, FlexibleDate 今回終了日) {

        if (!今回開始日.isEmpty() && !今回終了日.isEmpty()) {
            if (今回開始日.isValid() && 今回終了日.isValid()) {
                return true;
            } else {
                // TODO QA415
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("今回開始日と終了日両方"));
            }
        } else {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("今回開始日と終了日両方"));
        }
    }
}
