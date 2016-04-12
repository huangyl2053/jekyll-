package jp.co.ndensan.reams.db.dbe.batchcontroller.step.taisyosyajidowaritsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.taisyosyajidowaritsuke.ITaisyosyaJidoWaritsukeRelateMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 対象者自動割付の取得バッチクラスです。TODO 2016/04/12 AccessLog出力を実装しない
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
public class TaisyosyaJidoWaritsukeProcess extends SimpleBatchProcessBase {

    private static final RString オブザーバー_機関 = new RString("1");
    private static final Code 進捗状況_未開催 = new Code("1");
    private TaisyosyaJidoWaritsukeProcessParameter paramter;
    private ITaisyosyaJidoWaritsukeRelateMapper mapper;
    private List<TaisyosyaJidoWaritsukeEntity> taisyosya;
    private List<RString> shinsakaiKaisaiNo;
    private List<FlexibleDate> shinsakaiKaisaiYMD;
    private List<Integer> shinsakaiWaritsukeNinsu;
    private List<Integer> shinsakaiJidoWariateTeiin;

    @Override
    protected void beforeExecute() {
        mapper = getMapper(ITaisyosyaJidoWaritsukeRelateMapper.class);
        taisyosya = mapper.selectTaisyosya();
        shinsakaiWaritsukeNinsu = paramter.getShinsakaiWaritsukeNinsu();
        shinsakaiJidoWariateTeiin = paramter.getShinsakaiJidoWariateTeiin();
        shinsakaiKaisaiNo = paramter.getShinsakaiKaisaiNo();
        shinsakaiKaisaiYMD = paramter.getKaisaiYMD();
    }

    @Override
    protected void process() {
        if (taisyosya == null || taisyosya.isEmpty()) {
            throw new BatchInterruptedException(UrErrorMessages.対象者が存在しない.getMessage().toString());
        }
        loop審査会割付();
    }

    @Transaction
    private void loop審査会割付() {
        for (int i = 0; i < shinsakaiKaisaiNo.size(); i++) {
            int 割付人数 = 0;
            boolean isExeNext = false;
            DbT5501ShinsakaiKaisaiYoteiJohoEntity 開催予定情報 = mapper.selectYoteiJohoForUpdate(shinsakaiKaisaiNo.get(i));
            for (int j = 0; j < taisyosya.size(); j++) {
                if (!(shinsakaiWaritsukeNinsu.get(i) < shinsakaiJidoWariateTeiin.get(i))) {
                    isExeNext = true;
                    break;
                }
                TaisyosyaJidoWaritsukeMybatisParameter parameter = getParameter(shinsakaiKaisaiNo.get(i), taisyosya.get(j));
                if (0 < mapper.selectCountShinsakaiWariateIinJoho(parameter)) {
                    continue;
                }
                if (0 < mapper.selectCountShinsakaiWariateIinJoho(parameter)) {
                    continue;
                }
                insert介護認定審査会割付情報(shinsakaiKaisaiNo.get(i), taisyosya.get(j), shinsakaiKaisaiYMD.get(i));
                割付人数++;
                taisyosya.remove(j);
                if (!(shinsakaiWaritsukeNinsu.get(i) + 割付人数 < shinsakaiJidoWariateTeiin.get(i))) {
                    break;
                }
            }
            if (!isExeNext) {
                開催予定情報.setShinsakaiShinchokuJokyo(進捗状況_未開催);
                開催予定情報.setShinsakaiWariateZumiNinzu(開催予定情報.getShinsakaiWariateZumiNinzu() + 割付人数);
                mapper.updateDbT5501ShinsakaiKaisaiYoteiJoho(開催予定情報);
            }
        }
    }

    private TaisyosyaJidoWaritsukeMybatisParameter getParameter(RString shinsakaiKaisaiNo, TaisyosyaJidoWaritsukeEntity 対象者) {
        DbT5101NinteiShinseiJohoEntity 要介護認定申請情報 = mapper.selectNinteiShinseiJohoByKey(対象者.getShinseishoKanriNo().value());
        return new TaisyosyaJidoWaritsukeMybatisParameter(
                shinsakaiKaisaiNo,
                対象者.getShinseishoKanriNo().value(),
                要介護認定申請情報.getNinteiChosaItakusakiCode(),
                要介護認定申請情報.getNinteiChosainCode(),
                要介護認定申請情報.getShujiiIryokikanCode(),
                要介護認定申請情報.getShujiiCode(),
                要介護認定申請情報.getNyushoShisetsuCode(),
                オブザーバー_機関.equals(BusinessConfig.get(ConfigNameDBE.オブザーバーチェック, SubGyomuCode.DBE認定支援)));
    }

    private void insert介護認定審査会割付情報(RString shinsakaiKaisaiNo, TaisyosyaJidoWaritsukeEntity 対象者, FlexibleDate kaisaiYMD) {
        DbT5502ShinsakaiWariateJohoEntity dbT5502Entity = new DbT5502ShinsakaiWariateJohoEntity();
        dbT5502Entity.setShinsakaiKaisaiNo(shinsakaiKaisaiNo);
        dbT5502Entity.setShinseishoKanriNo(対象者.getShinseishoKanriNo());
        dbT5502Entity.setShinsakaiKaisaiYMD(kaisaiYMD);
        dbT5502Entity.setShinsakaiWariateYMD(FlexibleDate.getNowDate());
        dbT5502Entity.setShinsakaiOrder(mapper.selectMaxShinsakaiOrder(shinsakaiKaisaiNo) + 1);
        dbT5502Entity.setShinsakaiOrderKakuteiFlag(true);
        dbT5502Entity.setShinsakaiJidoWaritsukeFlag(true);
        dbT5502Entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.EMPTY);
        dbT5502Entity.setShinsakaiShiryoSofuYMD(FlexibleDate.EMPTY);
        dbT5502Entity.setHanteiKekkaCode(Code.EMPTY);
        mapper.insertDbT5502ShinsakaiWariateJoho(dbT5502Entity);
    }
}
