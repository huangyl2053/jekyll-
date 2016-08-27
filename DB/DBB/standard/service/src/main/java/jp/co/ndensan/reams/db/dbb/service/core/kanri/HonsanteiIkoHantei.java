/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 本算定以降判定のクラスです。
 *
 * @reamsid_L DBB-9020-040 sunhaidi
 */
public class HonsanteiIkoHantei {

    private static final RString 処理名 = new RString("本算定賦課");
    private static final RString 処理枝番 = new RString("0001");
    private static final RString 年度内連番 = new RString("0001");
    private final DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac;

    /**
     * コンストラクタです。
     */
    HonsanteiIkoHantei() {
        this.dbT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT7022ShoriDateKanriDac {@link DbT7022ShoriDateKanriDac}
     */
    HonsanteiIkoHantei(DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac) {
        this.dbT7022ShoriDateKanriDac = dbT7022ShoriDateKanriDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HonsanteiIkoHantei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HonsanteiIkoHantei}のインスタンス
     */
    public static HonsanteiIkoHantei createInstance() {
        return InstanceProvider.create(HonsanteiIkoHantei.class);
    }

    /**
     * パラメータに渡された賦課の情報が本算定後のものかどうかを判定します。<br>
     * 処理日付管理マスタから本算定の終了日時を取得し、パラメータの賦課の調定日時と比較します。<br>
     * 「本算定の終了日時≦賦課の調定日時」の場合、trueを返します。
     *
     * @param 賦課 賦課の情報
     * @return 判定結果(TRUE:本算定以降、FALSE:仮算定)
     */
    public boolean is本算定後(FukaJoho 賦課) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        DbT7022ShoriDateKanriEntity shoriDateKanriEntity
                = dbT7022ShoriDateKanriDac.selectByKey(SubGyomuCode.DBB介護賦課,
                        association.get地方公共団体コード(),
                        処理名,
                        処理枝番,
                        賦課.get賦課年度(),
                        年度内連番);

        if (shoriDateKanriEntity == null || shoriDateKanriEntity.getKijunTimestamp() == null
                || shoriDateKanriEntity.getKijunTimestamp().isEmpty()) {
            return false;
        }
        YMDHMS 本算定の終了日時 = shoriDateKanriEntity.getKijunTimestamp();
        return !賦課.get調定日時().isBefore(本算定の終了日時);
    }
}
