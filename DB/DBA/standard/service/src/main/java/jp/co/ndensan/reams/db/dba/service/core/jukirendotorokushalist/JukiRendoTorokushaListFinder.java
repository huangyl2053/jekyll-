/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jukirendotorokushalist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jukinentotoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA140010.DBA140010_JukiRendoTorokushaListParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住基連動登録者リスト作成クラスです。
 *
 * @reamsid_L DBA-0560-030 xuyannan
 */
public class JukiRendoTorokushaListFinder {

    private static final RString 処理名 = new RString("住基連動登録者リスト");
    private static final RString MIN_日時 = new RString(" 00:00:00.000");
    private static final RString MAX_日時 = new RString(" 23:59:59.999");
    private static final RString ライン = new RString("-");
    private static final RString CHECKBOX_KEY0 = new RString("key0");
    private static final RString CHECKBOX_KEY1 = new RString("key1");
    private static final RString CHECKBOX_KEY2 = new RString("key2");
    private static final int 年終了桁数 = 4;
    private static final int 月終了桁数 = 6;
    private static final int 日終了桁数 = 8;
    private final DbT7022ShoriDateKanriDac dac;

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
     * @param 対象台帳 対象台帳
     * @param 出力順ID 出力順ID
     * @return DBA140010_JukiRendoTorokushaListParameter 住基連動登録者リスト作成バッチパラメータクラス
     */
    public DBA140010_JukiRendoTorokushaListParameter getJukiRendoTorokushaListBatchParameter(
            FlexibleDate 前回開始日,
            FlexibleDate 前回終了日,
            FlexibleDate 今回開始日,
            FlexibleDate 今回終了日,
            List<RString> 対象台帳,
            Long 出力順ID) {
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
        DBA140010_JukiRendoTorokushaListParameter parameter = new DBA140010_JukiRendoTorokushaListParameter();
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
        parameter.setHihokenshadaichoFLG(被保険者台帳フラグ);
        parameter.setTajushochitokureishakanriFLG(他住所地特例者管理フラグ);
        parameter.setTekiyojogaishadaichoFLG(適用除外者台帳フラグ);
        parameter.setShuturyokujunID(出力順ID);
        return parameter;
    }
}
