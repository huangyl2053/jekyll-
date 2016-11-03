/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120050.KyufuJissekiInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekiin.IKyufuJissekiInMasterTorokuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 返却データ削除・給付実績H1の新規、修正データの場合。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class KyufuJissekiInHenkyakuH1DeleteProcess extends SimpleBatchProcessBase {

    private static final RString 給付実績明細TBL名 = new RString("DbT3018KyufujissekiMeisai");
    private static final RString 給付実績緊急時施設療養TBL名 = new RString("DbT3019KyufujissekiKinkyuShisetsuRyoyo");
    private static final RString 給付実績特定診療費TBL名 = new RString("DbT3020KyufujissekiTokuteiSinryohi");
    private static final RString 給付実績特定診療費特別療養費TBL名 = new RString("DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo");
    private static final RString 給付実績食事費用TBL名 = new RString("DbT3022KyufujissekiShokujiHiyo");
    private static final RString 給付実績居宅サービス計画費TBL名 = new RString("DbT3025KyufujissekiKyotakuService");
    private static final RString 給付実績福祉用具販売費TBL名 = new RString("DbT3026KyufujissekiFukushiYoguHanbaihi");
    private static final RString 給付実績住宅改修費TBL名 = new RString("DbT3027KyufujissekiJutakuKaishuhi");
    private static final RString 給付実績特定入所者介護サービス費用TBL名 = new RString("DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo");
    private static final RString 給付実績社会福祉法人軽減額TBL名 = new RString("DbT3030KyufuJissekiShakaiFukushiHojinKeigengaku");
    private static final RString 給付実績ケアマネジメント費TBL名 = new RString("DbT3031KyufuJissekiCareManagementHi");
    private static final RString 給付実績所定疾患施設療養費等TBL名 = new RString("DbT3032KyufujissekiShoteiShikkanShisetsuRyoyo");
    private static final RString 給付実績明細住所地特例TBL名 = new RString("DbT3106KyufujissekiMeisaiJushochiTokurei");
    private static final RString 給付実績集計TBL名 = new RString("DbT3033KyufujissekiShukei");
    private final KyufuJissekiInMybatisParameter parameter = new KyufuJissekiInMybatisParameter();
    private IKyufuJissekiInMasterTorokuMapper mapper;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IKyufuJissekiInMasterTorokuMapper.class);
    }

    @Override
    protected void process() {
        do関連データ削除(給付実績明細TBL名);
        do関連データ削除(給付実績緊急時施設療養TBL名);
        do関連データ削除(給付実績特定診療費TBL名);
        do関連データ削除(給付実績特定診療費特別療養費TBL名);
        do関連データ削除(給付実績食事費用TBL名);
        do関連データ削除(給付実績居宅サービス計画費TBL名);
        do関連データ削除(給付実績福祉用具販売費TBL名);
        do関連データ削除(給付実績住宅改修費TBL名);
        do関連データ削除(給付実績特定入所者介護サービス費用TBL名);
        do関連データ削除(給付実績社会福祉法人軽減額TBL名);
        do関連データ削除(給付実績ケアマネジメント費TBL名);
        do関連データ削除(給付実績所定疾患施設療養費等TBL名);
        do関連データ削除(給付実績明細住所地特例TBL名);
        do関連データ削除(給付実績集計TBL名);
    }

    private void do関連データ削除(RString 表名) {
        parameter.set表名(表名);
        mapper.delete給付実績H1の新規修正関連データ(parameter);
        mapper.delete給付実績H1の取消関連データ(parameter);
    }

}
