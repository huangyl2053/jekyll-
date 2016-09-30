/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shikyugakujohomanager;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 振込明細一覧表作成_serviceクラスです．
 *
 * @reamsid_L DBC-2180-030 tianyh
 */
public class ShikyugakuJohoManager {

    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    /**
     * コンストラクタです
     */
    public ShikyugakuJohoManager() {
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 帳票制御汎用Dac DbT7067ChohyoSeigyoHanyoDac
     */
    ShikyugakuJohoManager(DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した
     *
     * @return ShikyugakuJohoManager
     */
    public static ShikyugakuJohoManager createInstance() {
        return InstanceProvider.create(ShikyugakuJohoManager.class);
    }

    /**
     * getfetch設定値のメソッドです。
     *
     * @param 帳票分類ID ReportId
     * @param 管理年度 FlexibleYear
     * @param 項目名 RString
     * @return RString
     */
    public RString fetch設定値(ReportId 帳票分類ID, FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity = 帳票制御汎用Dac.selectByKey(SubGyomuCode.DBC介護給付, 帳票分類ID, 管理年度, 項目名);
        if (entity != null) {
            return entity.getKomokuValue();
        } else {
            return RString.EMPTY;
        }
    }
}
