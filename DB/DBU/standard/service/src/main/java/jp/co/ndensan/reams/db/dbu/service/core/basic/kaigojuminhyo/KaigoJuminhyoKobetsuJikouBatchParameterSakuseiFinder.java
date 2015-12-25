/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.kaigojuminhyo;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
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

    private final DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac;

    /**
     * コンストラクタです。
     */
    public KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder() {
        dbT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT7022ShoriDateKanriDac {@link dbT7022ShoriDateKanriDac}
     */
    KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder(DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac) {
        this.dbT7022ShoriDateKanriDac = dbT7022ShoriDateKanriDac;
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
        KaigoJuminhyoBatchParameter kaigoJuminhyoBatchParameter = new KaigoJuminhyoBatchParameter();
        if (kaishiYMD != null) {
            StringBuilder strTaishoKaishiYMDHMS = new StringBuilder();
            strTaishoKaishiYMDHMS.append(kaishiYMD);
            strTaishoKaishiYMDHMS.append(kaishiTimestamp);
            YMDHMS taishoKaishiYMDHMS = new YMDHMS(strTaishoKaishiYMDHMS.toString());

            kaigoJuminhyoBatchParameter.setTaishoKaishiYMDHMS(taishoKaishiYMDHMS.getRDateTime());
            kaigoJuminhyoBatchParameter.setTaishoShuryoYMDHMS(RDate.getNowDateTime());
        }
        return kaigoJuminhyoBatchParameter;
    }

    /**
     * 処理日付管理マスタテーブルから、抽出期間情報を取得です。
     *
     * @return ChushutsuKikanJohoEntity
     */
   // @Transaction
    // public ChushutsuKikanJohoData getChushutsukikanJoho() {
    //List<DbT7022ShoriDateKanriEntity> shoriDateKanriEntity = dbT7022ShoriDateKanriDac.selectTaishoYMD();
    //    ChushutsuKikanJohoData chushutsuKikanJohoData = new ChushutsuKikanJohoData();
//        YMDHMS TaishoShuryoTimestamp = new YMDHMS("19000101010101");
//        if (shoriDateKanriEntity != null) {
//            for (DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity : shoriDateKanriEntity) {
//                if (!dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp().isEmpty()) {
//                    if (TaishoShuryoTimestamp.isBefore(dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp())) {
//                        TaishoShuryoTimestamp = dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp();
//                        chushutsuKikanJohoData.setTaishoKaishiTimestamp(dbT7022ShoriDateKanriEntity.getTaishoKaishiTimestamp());
//                        chushutsuKikanJohoData.setTaishoKaishiYMD(dbT7022ShoriDateKanriEntity.getTaishoKaishiYMD());
//                        chushutsuKikanJohoData.setTaishoShuryoTimestamp(dbT7022ShoriDateKanriEntity.getTaishoShuryoTimestamp());
//                        chushutsuKikanJohoData.setTaishoShuryoYMD(dbT7022ShoriDateKanriEntity.getTaishoShuryoYMD());
//                    }
//                }
//            }
//        }
    //      return chushutsuKikanJohoData;
    //  }
}
