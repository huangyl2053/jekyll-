/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.kaigojuminhyo;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護住民票個別事項連携情報作成【他社住基】_バッチパラメータ作成するクラスです
 *
 */
public class KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7021JigyoHokokuTokeiDataDac}
     */
    KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 画面入力するデータより、バッチ用パラメータクラスを作成です。今回開始年月日　今回開始時分秒
     *
     * @param kaishiYMD 今回開始年月日
     * @param kaishiTimestamp 今回開始時分秒
     * @return KaigoJuminhyoBatchParameter 介護住民票個別事項連携情報作成【他社住基】のバッチのパラメータ
     */
    @Transaction
    public KaigoJuminhyoBatchParameter getKaigoJuminhyoKobetsuJikouBatchParameter(RString kaishiYMD, RString kaishiTimestamp) {

        if (kaishiYMD != null) {
            KaigoJuminhyoBatchParameter kaigoJuminhyoBatchParameter = new KaigoJuminhyoBatchParameter();
            StringBuilder taishoKaishiYMDHMS = new StringBuilder();
            taishoKaishiYMDHMS.append(kaishiYMD);
            taishoKaishiYMDHMS.append(kaishiTimestamp);

            RString ymd = RDate.getNowDate().toDateString();
            RString time = new RString(RDate.getNowTime().toString());
            StringBuilder taishoShuryoYMDHMS = new StringBuilder();
            taishoShuryoYMDHMS.append(ymd);
            taishoShuryoYMDHMS.append("000000");
            kaigoJuminhyoBatchParameter.setTaishoKaishiYMDHMS(new YMDHMS(taishoKaishiYMDHMS.toString()));
            kaigoJuminhyoBatchParameter.setTaishoShuryoYMDHMS(new YMDHMS(taishoShuryoYMDHMS.toString()));
            return kaigoJuminhyoBatchParameter;
        }
        return null;
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得です。
     *
     * @return ChushutsuKikanJohoEntity
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity getChushutsukikanJoho() {

        DbT7022ShoriDateKanriEntity dbT7022Entity = dac.selectTaishoYMD();

        return dbT7022Entity;
    }
}
