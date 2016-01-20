/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.kaigojuminhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyo.ChushutsuKikanJohoData;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護住民票個別事項連携情報作成【他社住基】_バッチパラメータ作成するクラスです。
 *
 */
public class KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder {

    private final DbT7022ShoriDateKanriDac shoriDateKanriDac;
    private YMDHMS taishoShuryoTimestamp;

    /**
     * コンストラクタです。
     */
    public KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder() {
        shoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * 介護住民票個別事項連携情報作成【他社住基】_バッチパラメータ作成するクラスを返します。
     *
     * @return 介護住民票個別事項連携情報作成【他社住基】_バッチパラメータ作成するクラス
     */
    public static KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder createInstance() {
        return new KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder();
    }

    /**
     * 画面入力するデータより、バッチ用パラメータクラスを作成です。
     *
     * @param kaishiYMD 今回開始年月日
     * @param kaishiTimestamp 今回開始時分秒
     * @return KaigoJuminhyoBatchParameter 介護住民票個別事項連携情報作成【他社住基】のバッチのパラメータ
     */
    public KaigoJuminhyoBatchParameter getKaigoJuminhyoKobetsuJikouBatchParameter(RDate kaishiYMD, RTime kaishiTimestamp) {
        KaigoJuminhyoBatchParameter kaigoJuminhyoBatchParameter = new KaigoJuminhyoBatchParameter();
        if (kaishiYMD != null && kaishiTimestamp != null) {
            kaigoJuminhyoBatchParameter.setTaishoKaishiYMDHMS(
                    RDateTime.of(new RString(kaishiYMD.toString()), new RString(kaishiTimestamp.toString())));
            kaigoJuminhyoBatchParameter.setTaishoShuryoYMDHMS(RDate.getNowDateTime());
        }
        return kaigoJuminhyoBatchParameter;
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得です。
     *
     * @return ChushutsuKikanJohoEntity
     */
    @Transaction
    public ChushutsuKikanJohoData getChushutsukikanJoho() {
        List<DbT7022ShoriDateKanriEntity> shoriDateKanriEntity = shoriDateKanriDac.selectChushutsukikan();
        ChushutsuKikanJohoData chushutsuKikanJohoData = null;
        if (shoriDateKanriEntity != null) {
            for (DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity : shoriDateKanriEntity) {
                chushutsuKikanJohoData = new ChushutsuKikanJohoData(dbT7022ShoriDateKanriEntity);
                if (taishoShuryoTimestamp == null) {
                    taishoShuryoTimestamp = dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp();
                }
                if (taishoShuryoTimestamp.isBeforeOrEquals(dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp())) {
                    taishoShuryoTimestamp = dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp();
                    chushutsuKikanJohoData = new ChushutsuKikanJohoData(dbT7022ShoriDateKanriEntity);
                }
            }
        }
        return chushutsuKikanJohoData;
    }
}
