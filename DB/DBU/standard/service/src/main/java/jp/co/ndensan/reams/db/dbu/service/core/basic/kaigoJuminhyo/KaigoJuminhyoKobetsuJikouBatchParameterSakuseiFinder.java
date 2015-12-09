/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.kaigoJuminhyo;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.db.dbu.entity.kaigojuminhyo.ChushutsuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
     * 画面入力するデータより、バッチ用パラメータクラスを作成です。
     *
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public KaigoJuminhyoBatchParameter getKaigoJuminhyoKobetsuJikouBatchParameter(ChushutsuKikanJohoEntity chushutsuKikanEntity) {

        if (chushutsuKikanEntity == null) {
            return null;
        }

        KaigoJuminhyoBatchParameter KaigoJuminhyoBatchParameter = new KaigoJuminhyoBatchParameter();
        StringBuffer taishoKaishiYMDHMS = new StringBuffer();
        taishoKaishiYMDHMS.append(chushutsuKikanEntity.getTaishoKaishiYMD());
        taishoKaishiYMDHMS.append(chushutsuKikanEntity.getTaishoKaishiTimestamp());

        StringBuffer taishoShuryoYMDHMS = new StringBuffer();
        taishoShuryoYMDHMS.append(chushutsuKikanEntity.getTaishoShuryoYMD());
        taishoShuryoYMDHMS.append(chushutsuKikanEntity.getTaishoShuryoTimestamp());

        KaigoJuminhyoBatchParameter.setTaishoKaishiYMDHMS(new YMDHMS(taishoKaishiYMDHMS.toString()));
        KaigoJuminhyoBatchParameter.setTaishoShuryoYMDHMS(new YMDHMS(taishoShuryoYMDHMS.toString()));
        return KaigoJuminhyoBatchParameter;
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得です。
     *
     * @return ChushutsuKikanJohoEntity
     */
    @Transaction
    public ChushutsuKikanJohoEntity getChushutsukikanJoho() {

        DbT7022ShoriDateKanriEntity dbT7022Entity = dac.selectTaishoYMD();

        if (dbT7022Entity == null) {
            return null;
        }
        dbT7022Entity.initializeMd5();

        ChushutsuKikanJohoEntity chushutsuKikanEntity = new ChushutsuKikanJohoEntity();
        chushutsuKikanEntity.setTaishoKaishiTimestamp(dbT7022Entity.getTaishoKaishiTimestamp().toDateString());
        chushutsuKikanEntity.setTaishoKaishiYMD(new RString(dbT7022Entity.getTaishoKaishiYMD().toString()));
        chushutsuKikanEntity.setTaishoShuryoTimestamp(dbT7022Entity.getTaishoShuryoTimestamp().toDateString());
        chushutsuKikanEntity.setTaishoShuryoYMD(new RString(dbT7022Entity.getTaishoShuryoYMD().toString()));
        return chushutsuKikanEntity;
    }
}
