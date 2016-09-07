/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kozafurikaeiraitsuchi;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBMN00020_口座振替依頼通知のビジネスクラスです。
 *
 * @reamsid_L DBB-5724-010 xuxin
 */
public class KozaFurikaeIraiTsuchi {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    /**
     * コンストラクタです。
     */
    public KozaFurikaeIraiTsuchi() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KozaFurikaeIraiTsuchi}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KozaFurikaeIraiTsuchi}のインスタンス
     */
    public static KozaFurikaeIraiTsuchi createInstance() {
        return InstanceProvider.create(KozaFurikaeIraiTsuchi.class);
    }

    /**
     * 当月の月次処理が確定処理まで完了している場合、Trueを返します。未完了の場合、Falseを返します。
     *
     * @param 口座振替年月 FlexibleYearMonth
     * @return Boolean
     */
    public Boolean getGetsujiShoriJokyo(FlexibleYearMonth 口座振替年月) {

        Boolean is確定処理完了;
        DbT7022ShoriDateKanriEntity entity = 処理日付管理Dac.get月次処理状況(口座振替年月);
        is確定処理完了 = entity != null;
        return is確定処理完了;
    }

}
