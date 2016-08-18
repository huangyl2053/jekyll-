/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.ninteishojoho;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4030011.ShogaishakojoTaishoshaListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4038ShogaishaKoujoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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

    /**
     * コンストラクタです。
     */
    NinteiShoJohoFinder() {
        障がい者控除dac = InstanceProvider.create(DbT4038ShogaishaKoujoDac.class);
        受給者台帳dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
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
     * 障がい者控除と認定年月日取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return NinteishoJohoEntity
     */
    @Transaction
    public NinteishoJohoEntity set障がい者控除と認定年月日(HihokenshaNo 被保険者番号) {
        DbT4001JukyushaDaichoEntity dbT4001entity = 受給者台帳dac.select認定年月日(被保険者番号);
        DbT4038ShogaishaKoujoEntity dbT4038entity = 障がい者控除dac.selectBy被保険者番号(被保険者番号);
        if (dbT4001entity == null) {
            return null;
        }
        dbT4001entity.initializeMd5();
        NinteishoJohoEntity ninteishoJohoentity = new NinteishoJohoEntity();
        ninteishoJohoentity.set要介護認定日(dbT4001entity.getNinteiYMD());
        if (dbT4038entity == null) {
            return null;
        }
        dbT4038entity.initializeMd5();
        ninteishoJohoentity.set障害理由区分(dbT4038entity.getNinteiKubun());
        ninteishoJohoentity.set障害理由内容(dbT4038entity.getNinteiNaiyo());
        FlexibleYear 年度 = dbT4038entity.getTaishoNendo();
        if (年度 != null) {
            ninteishoJohoentity.set対象年度(年度);
        }
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
    public NinteishoJohoEntity setTarget(NinteishoJohoEntity target, ShogaishakojoTaishoshaListProcessParameter parameter,
            ReportSourceWriter reportSourceWriter) {
        if (target.getPsmEntity() == null) {
            target.setPsmEntity(new UaFt200FindShikibetsuTaishoEntity());
        }

        target.set文書番号(文書番号取得());
        target.set発行日(parameter.get交付日());
        target.set申請者住所(target.get申請者住所());
        if (target.get申請者住所() == null || target.get申請者住所().isEmpty()) {
            AtenaJusho 住所 = target.getPsmEntity().getJusho();
            RString 住所Val = 住所 != null ? 住所.getColumnValue() : RString.EMPTY;
            AtenaBanchi 番地 = target.getPsmEntity().getBanchi();
            RString 番地Val = 番地 != null ? 番地.getColumnValue() : RString.EMPTY;
            Katagaki 方書 = target.getPsmEntity().getKatagaki();
            RString 方書Val = 方書 != null ? 方書.getColumnValue() : RString.EMPTY;
            target.set申請者住所(new RStringBuilder().append(住所Val).append(番地Val).append(方書Val).toRString());
        }

        target.set申請者(target.get申請者氏名());
        target.set申請者氏名(target.get申請者氏名());
        if (target.get申請者氏名() == null || target.get申請者氏名().isEmpty()) {
            AtenaMeisho 被保険者氏名 = target.getPsmEntity().getMeisho();
            RString 被保険者氏名Val = 被保険者氏名 != null ? 被保険者氏名.getColumnValue() : RString.EMPTY;
            target.set申請者(被保険者氏名Val);
            target.set申請者氏名(被保険者氏名Val);
        }

        AtenaJusho 住所 = target.getPsmEntity().getJusho();
        RString 住所Val = 住所 != null ? 住所.getColumnValue() : RString.EMPTY;
        target.set対象者住所(住所Val);
        AtenaMeisho 被保険者氏名 = target.getPsmEntity().getMeisho();
        RString 被保険者氏名Val = 被保険者氏名 != null ? 被保険者氏名.getColumnValue() : RString.EMPTY;
        target.set対象者氏名(被保険者氏名Val);

        IKojin ikojin = ShikibetsuTaishoFactory.createKojin(target.getPsmEntity());
        FlexibleDate 対象者生年月日 = target.getPsmEntity().getSeinengappiYMD();
        if (ikojin.is日本人() && 対象者生年月日 != null) {
            target.set対象者生年月日(対象者生年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        } else if (対象者生年月日 != null) {
            target.set対象者生年月日((new FlexibleDate(target.get対象者生年月日()).seireki()
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()));
        }

        RString 性別 = RString.EMPTY;
        if (new RString("1").equals(target.getPsmEntity().getSeibetsuCode())) {
            性別 = new RString("男");
        } else if (new RString("2").equals(target.getPsmEntity().getSeibetsuCode())) {
            性別 = new RString("女");
        }
        target.set対象者性別(性別);
        NinteishoJohoEntity ninteishoJohoentity = set障がい者控除と認定年月日(target.get被保険者番号());
        target.set障害理由区分(ninteishoJohoentity.get障害理由区分());
        target.set障害理由内容(ninteishoJohoentity.get障害理由内容());
        target.set要介護認定日(ninteishoJohoentity.get要介護認定日());
        target.set対象年度(ninteishoJohoentity.get対象年度());
        return target;
    }

}
