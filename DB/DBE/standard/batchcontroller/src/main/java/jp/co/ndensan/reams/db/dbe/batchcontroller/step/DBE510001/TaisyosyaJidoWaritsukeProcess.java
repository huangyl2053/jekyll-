package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE510001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeKensakuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.taisyosyajidowaritsuke.TaisyosyaJidoWaritsukeEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.taisyosyajidowaritsuke.ITaisyosyaJidoWaritsukeRelateMapper;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.journal.JournalWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 対象者自動割付の取得バッチクラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
public class TaisyosyaJidoWaritsukeProcess extends SimpleBatchProcessBase {

    private static final RString オブザーバー_機関 = new RString("1");
    private static final RString 一次判定後 = new RString("1");
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
        shinsakaiWaritsukeNinsu = paramter.getShinsakaiWaritsukeNinsu();
        shinsakaiJidoWariateTeiin = paramter.getShinsakaiJidoWariateTeiin();
        shinsakaiKaisaiNo = paramter.getShinsakaiKaisaiNo();
        shinsakaiKaisaiYMD = paramter.getKaisaiYMD();
        mapper = getMapper(ITaisyosyaJidoWaritsukeRelateMapper.class);
        TaisyosyaJidoWaritsukeKensakuParameter parameter;
        final RString マスキングチェックタイミング = DbBusinessConfig.get(
                ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        parameter = new TaisyosyaJidoWaritsukeKensakuParameter(shinsakaiKaisaiNo, 一次判定後.equals(マスキングチェックタイミング));
        taisyosya = mapper.selectTaisyosya(parameter);
    }

    @Override
    protected void process() {
        if (taisyosya == null || taisyosya.isEmpty()) {
            final RString 対象者が存在しない = new RString("指定された条件に該当する対象者が存在しません。");
            JournalWriter journalWriter = new JournalWriter();
            journalWriter.writeErrorJournal(RDate.getNowDateTime(), 対象者が存在しない);
        } else {
            loop審査会割付();
        }
    }

    @Transaction
    private void loop審査会割付() {
        TaisyosyaJidoWaritsukeKensakuParameter kensakuparameter;
        ShinsakaiKaisaiYoteiJohoManager 審査会開催予定Manager = new ShinsakaiKaisaiYoteiJohoManager();
        final RString マスキングチェックタイミング = DbBusinessConfig.get(
                ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        for (int i = 0; i < shinsakaiKaisaiNo.size(); i++) {
            List<RString> kaisaiNo = new ArrayList<>();
            List<ShinseishoKanriNo> 申請書管理番号List = new ArrayList<>();;
            kaisaiNo.add(shinsakaiKaisaiNo.get(i));
            kensakuparameter = new TaisyosyaJidoWaritsukeKensakuParameter(kaisaiNo, 一次判定後.equals(マスキングチェックタイミング));
            taisyosya = mapper.selectTaisyosya(kensakuparameter);

            int 割付人数 = 0;
            boolean is介護認定審査会割付情報Insert = false;
            DbT5501ShinsakaiKaisaiYoteiJohoEntity 開催予定情報 = mapper.selectYoteiJohoForUpdate(shinsakaiKaisaiNo.get(i));
            if (開催予定情報 == null) {
                continue;
            }
            JournalWriter journalWriter = new JournalWriter();
            final RString 申請者オブザーバーチェック = new RString("申請者オブザーバーチェックエラー  開催番号： 第");
            final RString 審査会委員除外存在チェック = new RString("審査会委員除外存在チェックエラー  開催番号： 第");
            final RString 対象者 = new RString("回審査会 対象者： ");
            for (int j = 0; j < taisyosya.size(); j++) {
                if (!(shinsakaiWaritsukeNinsu.get(i) < shinsakaiJidoWariateTeiin.get(i))) {
                    break;
                }
                if (申請書管理番号List.isEmpty()) {
                    申請書管理番号List.add(taisyosya.get(j).getShinseishoKanriNo());
                } else {
                    if (申請書管理番号List.contains(taisyosya.get(j).getShinseishoKanriNo())) {
                        break;
                    }
                    申請書管理番号List.add(taisyosya.get(j).getShinseishoKanriNo());
                }
                TaisyosyaJidoWaritsukeMybatisParameter parameter = getParameter(shinsakaiKaisaiNo.get(i), taisyosya.get(j));
                if (0 < mapper.selectCountShinsakaiWariateIinJoho(parameter)) {
                    RStringBuilder errorMsg = new RStringBuilder();
                    errorMsg.append(申請者オブザーバーチェック);
                    errorMsg.append(shinsakaiKaisaiNo.get(i));
                    errorMsg.append(対象者);
                    errorMsg.append(taisyosya.get(j));
                    journalWriter.writeErrorJournal(RDate.getNowDateTime(), errorMsg.toRString());
                    continue;
                }
                if (0 < mapper.selectCountShinsakaiIinJogaiJoho(parameter)) {
                    RStringBuilder errorMsg = new RStringBuilder();
                    errorMsg.append(審査会委員除外存在チェック);
                    errorMsg.append(shinsakaiKaisaiNo.get(i));
                    errorMsg.append(対象者);
                    errorMsg.append(taisyosya.get(j));
                    journalWriter.writeErrorJournal(RDate.getNowDateTime(), errorMsg.toRString());
                    continue;
                }
                insert介護認定審査会割付情報(shinsakaiKaisaiNo.get(i), taisyosya.get(j), shinsakaiKaisaiYMD.get(i));
                is介護認定審査会割付情報Insert = true;
                AccessLogger.log(AccessLogType.更新,
                        toPersonalData(shinsakaiKaisaiNo.get(i), taisyosya.get(j).getShinseishoKanriNo().value()));
                割付人数++;
                if (!(shinsakaiWaritsukeNinsu.get(i) + 割付人数 < shinsakaiJidoWariateTeiin.get(i))) {
                    break;
                }
            }
            if (is介護認定審査会割付情報Insert) {
                ShinsakaiKaisaiYoteiJoho kaisaiYoteiJoho = 審査会開催予定Manager.get介護認定審査会開催予定情報(shinsakaiKaisaiNo.get(i));
                kaisaiYoteiJoho = kaisaiYoteiJoho.createBuilderForEdit()
                        .set介護認定審査会進捗状況(進捗状況_未開催)
                        .set介護認定審査会割当済み人数(kaisaiYoteiJoho.get介護認定審査会割当済み人数() + 割付人数).build();
                審査会開催予定Manager.save介護認定審査会開催予定情報(kaisaiYoteiJoho);
//以下の方法ではDB共通列の値が更新されない
//                開催予定情報.setShinsakaiShinchokuJokyo(進捗状況_未開催);
//                開催予定情報.setShinsakaiWariateZumiNinzu(開催予定情報.getShinsakaiWariateZumiNinzu() + 割付人数);
//                mapper.updateDbT5501ShinsakaiKaisaiYoteiJoho(開催予定情報);
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
                get主治医医療機関コード(要介護認定申請情報.getShujiiIryokikanCode()),
                get主治医コード(要介護認定申請情報.getShujiiCode()),
                要介護認定申請情報.getNyushoShisetsuCode(),
                オブザーバー_機関.equals(DbBusinessConfig.get(
                                ConfigNameDBE.オブザーバーチェック, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
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

    private PersonalData toPersonalData(RString 開催番号, RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), 開催番号, 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private RString get主治医医療機関コード(ShujiiIryokikanCode 主治医医療機関コード) {
        if (主治医医療機関コード == null) {
            return RString.EMPTY;
        }
        return 主治医医療機関コード.value();
    }

    private RString get主治医コード(ShujiiCode 主治医コード) {
        if (主治医コード == null) {
            return RString.EMPTY;
        }
        return 主治医コード.value();
    }
}
