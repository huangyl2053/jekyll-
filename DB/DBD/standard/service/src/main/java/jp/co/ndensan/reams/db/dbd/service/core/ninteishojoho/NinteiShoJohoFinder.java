/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.ninteishojoho;

import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4030011.ShogaishakojoTaishoshaListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinshoshaDenshiKoinDataEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4038ShogaishaKoujoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい者控除対象者認定証のFinderです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class NinteiShoJohoFinder {

    private static final ReportId 帳票分類ID = ReportIdDBD.DBD100025.getReportId();
    private final DbT4038ShogaishaKoujoDac 障がい者控除dac;
    private final DbT4001JukyushaDaichoDac 受給者台帳dac;
    private final NinteishoJohoEntity ninteishoJohoentity;

    /**
     * コンストラクタです。
     */
    public NinteiShoJohoFinder() {
        障がい者控除dac = InstanceProvider.create(DbT4038ShogaishaKoujoDac.class);
        受給者台帳dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        ninteishoJohoentity = new NinteishoJohoEntity();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 受給者台帳dac {@link DbT4001JukyushaDaichoDac}
     * @param ninteishoJohoentity {@link NinteishoJohoEntity}
     */
    NinteiShoJohoFinder(DbT4038ShogaishaKoujoDac 障がい者控除dac, DbT4001JukyushaDaichoDac 受給者台帳dac,
            NinteishoJohoEntity ninteishoJohoentity) {
        this.障がい者控除dac = 障がい者控除dac;
        this.受給者台帳dac = 受給者台帳dac;
        this.ninteishoJohoentity = ninteishoJohoentity;

    }

    /**
     * 障がい者控除対象者認定証FindのIntanceを作成します。
     *
     * @return NinteiShoJohoFinder
     */
    public static NinteiShoJohoFinder createInstance() {
        return InstanceProvider.create(NinteiShoJohoFinder.class);
    }

    /**
     * 文書番号取得。
     *
     * @return 文書番号
     */
    public RString 文書番号取得() {

        RString 文書番号 = RString.EMPTY;

        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(帳票分類ID, FlexibleDate.getNowDate());
        if (bushoNo != null) {
            RString 文書番号記号 = bushoNo.get文書番号記号();
            RString 文書番号固定文字 = bushoNo.get文書番号固定文字();
            文書番号 = new RStringBuilder().append(文書番号記号).
                    append(new RString("第")).
                    append(文書番号固定文字).
                    append(new RString("号")).toRString();
        }
        return 文書番号;
    }

    /**
     * 認証者氏名取得。
     *
     * @param reportSourceWriter ReportSourceWriter
     * @return NinshoshaDenshiKoinDataEntity
     */
    public NinshoshaDenshiKoinDataEntity set認証者氏名(ReportSourceWriter reportSourceWriter) {
        NinshoshaDenshiKoinDataEntity entity = new NinshoshaDenshiKoinDataEntity();
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.toValue(NinshoshaDenshikoinshubetsuCode.保険者印.getコード()), reportSourceWriter);
        entity.set認職者氏名(ninshoshaSource.ninshoshaShimeiKakeru);
        entity.set電子公印(ninshoshaSource.denshiKoin);
        return entity;

    }

    /**
     * 障がい者控除と認定年月日取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return NinteishoJohoEntity
     */
    @Transaction
    public NinteishoJohoEntity set障がい者控除と認定年月日(HihokenshaNo 被保険者番号) {
        DbT4001JukyushaDaichoEntity dbT4001entity = 受給者台帳dac.select認定年月日(被保険者番号);
        DbT4038ShogaishaKoujoEntity dbT4038entity = 障がい者控除dac.selectAll(被保険者番号);
        if (dbT4001entity == null) {
            return null;
        }
        dbT4001entity.initializeMd5();
        ninteishoJohoentity.set要介護認定日(dbT4001entity.getNinteiYMD());
        if (dbT4038entity == null) {
            return null;
        }
        dbT4038entity.initializeMd5();
        ninteishoJohoentity.set障害理由区分(dbT4038entity.getNinteiKubun());
        ninteishoJohoentity.set障害理由内容(dbT4038entity.getNinteiNaiyo());
        ninteishoJohoentity.set申告年(new RDate(dbT4038entity.getTaishoNendo().toString()));
        return ninteishoJohoentity;
    }

    /**
     * 認定書情報をsetする。
     *
     * @param target NinteishoJohoBusiness
     * @param parameter ShogaishakojoTaishoshaListProcessParameter
     * @param reportSourceWriter ReportSourceWriter
     * @return NinteishoJohoBusiness
     */
    public NinteishoJohoBusiness setTarget(NinteishoJohoBusiness target, ShogaishakojoTaishoshaListProcessParameter parameter,
            ReportSourceWriter reportSourceWriter) {
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票分類ID, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.toValue(NinshoshaDenshikoinshubetsuCode.保険者印.getコード()), reportSourceWriter);
        target.set文書番号(文書番号取得());
        target.set発行日(parameter.get交付日());
        target.set申請者(target.getNinteishoJohoEntity().get申請者氏名());
        target.set認職者氏名(ninshoshaSource.ninshoshaShimeiKakeru);
        target.set電子公印(ninshoshaSource.denshiKoin);
        target.set申請者住所(target.getNinteishoJohoEntity().get申請者住所());
        if (target.getNinteishoJohoEntity().get申請者住所() == null && target.getNinteishoJohoEntity().get申請者住所().isEmpty()) {
            target.set申請者住所(new RStringBuilder().append(target.getNinteishoJohoEntity().getPsmEntity().getJusho().getColumnValue()).
                    append(target.getNinteishoJohoEntity().getPsmEntity().getBanchi().getColumnValue()).
                    append(target.getNinteishoJohoEntity().getPsmEntity().getKatagaki().getColumnValue()).toRString());
        }
        target.set申請者氏名(target.getNinteishoJohoEntity().get申請者氏名());
        if (target.getNinteishoJohoEntity().get申請者氏名() == null && target.getNinteishoJohoEntity().get申請者氏名().isEmpty()) {
            target.set申請者(target.getNinteishoJohoEntity().getPsmEntity().getMeisho().getColumnValue());
            target.set申請者氏名(target.getNinteishoJohoEntity().getPsmEntity().getMeisho().getColumnValue());
        }
        target.set対象者住所(target.getNinteishoJohoEntity().getPsmEntity().getJusho().getColumnValue());
        target.set対象者氏名(target.getNinteishoJohoEntity().getPsmEntity().getMeisho().getColumnValue());
        target.set対象者生年月日(target.getNinteishoJohoEntity().getPsmEntity().getSeinengappiYMD());
        target.set対象者性別(target.getNinteishoJohoEntity().getPsmEntity().getSeibetsuCode());
        NinteishoJohoEntity ninteishoJohoentity = set障がい者控除と認定年月日(parameter.get被保険者番号());
        target.set障害理由区分(ninteishoJohoentity.get障害理由区分());
        target.set障害理由内容(ninteishoJohoentity.get障害理由内容());
        target.set要介護認定日(ninteishoJohoentity.get要介護認定日());
        target.set申告年(ninteishoJohoentity.get対象年度());
        return target;
    }

}
