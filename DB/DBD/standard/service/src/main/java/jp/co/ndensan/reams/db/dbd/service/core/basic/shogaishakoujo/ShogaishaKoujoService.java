/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic.shogaishakoujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4030011.ShogaishaKojoTaishoshaListMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4040011.ShogaishaKojoTaishoNinteishoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4038ShogaishaKoujoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakojotaishoninteisho.IShogaishaKojoTaishoNinteishoMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujotaishoninteisho.IShogaishaKoujoTaishoNinteiShoMapper;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100025.ShogaishaKojoNinteishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい者控除対象者認定画面
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShogaishaKoujoService {

    private final DbT4038ShogaishaKoujoDac dac;
    private final MapperProvider mapperProvider;
    private static final ReportId 帳票ID = new ReportId("DBD100025_ShogaishaKojoNinteisho");
    private static final ReportId 帳票分類ID = new ReportId("DBD100025_ShogaishaKojoNinteisho");
    private static final int ONE_1 = 1;
    private static final int TWO_2 = 2;
    private static final int THREE_3 = 3;
    private static final int FOUR_4 = 4;
    private static final RString GENERICKEY = new RString("障がい者控除対象者認定書");
    private static final int COUNT = 1;

    ShogaishaKoujoService() {
        this.dac = InstanceProvider.create(DbT4038ShogaishaKoujoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     *
     * @return ShoriDateKanriService
     */
    public static ShogaishaKoujoService createInstance() {
        return InstanceProvider.create(ShogaishaKoujoService.class);
    }

    /**
     * DbT4038ShogaishaKoujoEntityを取得します
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT4038ShogaishaKoujoEntity
     */
    @Transaction
    public ShogaishaKoujo getDbT4038ShogaishaKoujoEntity(HihokenshaNo 被保険者番号) {
        DbT4038ShogaishaKoujoEntity entity = dac.selectBy被保険者番号(被保険者番号);
        if (entity == null) {
            return null;
        } else {
            return new ShogaishaKoujo(entity);
        }
    }

    /**
     * 障がい者控除対象者認定書を取得します。
     *
     * @param 障がい者控除対象者認定書検索条件 障がい者控除対象者認定書検索条件
     * @return int 障がい者控除対象者認定書件数
     */
    @Transaction
    public int get障がい者控除対象者認定書(ShogaishaKojoTaishoshaListMyBatisParameter 障がい者控除対象者認定書検索条件) {
        IShogaishaKoujoTaishoNinteiShoMapper mapper
                = mapperProvider.create(IShogaishaKoujoTaishoNinteiShoMapper.class);
        List<NinteishoJohoEntity> result
                = mapper.控除対象者データの取得(障がい者控除対象者認定書検索条件);
        if (result == null || result.isEmpty()) {
            return 0;
        }
        return result.size();
    }

    /**
     * 帳票発行します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 識別コード
     * @param 発行日 発行日
     * @param 申請者住所 申請者住所
     * @param 申請者氏名 申請者氏名
     * @param 外国人 外国人
     * @param reportManager reportManager
     */
    public void edit帳票発行(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, RDate 発行日, RString 申請者住所,
            RString 申請者氏名, RString 外国人, ReportManager reportManager) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        ShogaishaKojoTaishoNinteishoParameter param = new ShogaishaKojoTaishoNinteishoParameter();
        param.set識別コード(識別コード);
        param.set被保険者番号(被保険者番号);
        IShogaishaKojoTaishoNinteishoMapper mapper = mapperProvider.create(IShogaishaKojoTaishoNinteishoMapper.class);
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = mapper.get宛名情報(param);
        UaFt250FindAtesakiEntity uaFt250Entity = mapper.get宛先情報(param);
        DbT4001JukyushaDaichoEntity dbT4001JukyushaDaichoEntity = mapper.get受給者台帳情報(param);
        NinteishoJohoEntity entity = new NinteishoJohoEntity();
        ShogaishaKoujo shogaishaKoujo = getDbT4038ShogaishaKoujoEntity(被保険者番号);
        entity.set被保険者番号(被保険者番号);
        entity.set障害理由区分(shogaishaKoujo.get認定区分());
        entity.set障害理由内容(shogaishaKoujo.get認定内容());
        entity.set要介護認定日(dbT4001JukyushaDaichoEntity.getNinteiYMD());
        entity.set対象年度(shogaishaKoujo.get対象年度());
        entity.set発行日(発行日);
        entity.set申請者住所(申請者住所);
        entity.set申請者氏名(申請者氏名);
        ChohyoSeigyoKyotsu 帳票共通情報
                = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBD介護受給, 帳票分類ID);
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        List<ChohyoSeigyoHanyo> 帳票制御汎用キー = manager.get帳票制御汎用一覧(SubGyomuCode.DBD介護受給, 帳票分類ID);
        int パターン番号 = 0;
        if (TeikeibunMojiSize.フォント小.getコード().equals(帳票共通情報.get定型文文字サイズ())) {
            パターン番号 = ONE_1;
        } else if (TeikeibunMojiSize.フォント大.getコード().equals(帳票共通情報.get定型文文字サイズ())) {
            パターン番号 = TWO_2;
        } else if (TeikeibunMojiSize.フォント上小下大.getコード().equals(帳票共通情報.get定型文文字サイズ())) {
            パターン番号 = THREE_3;
        } else if (TeikeibunMojiSize.フォント上大下小.getコード().equals(帳票共通情報.get定型文文字サイズ())) {
            パターン番号 = FOUR_4;
        }
        List<RString> 通知書定型文 = new ArrayList();
        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchishoTeikeibunManager.get通知書定型文項目(SubGyomuCode.DBD介護受給, 帳票ID,
                KamokuCode.EMPTY, パターン番号);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, 帳票ID);
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibunEntity : 通知書定型文List) {
            int 項目番号 = tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
        NinteishoJohoBusiness business = new NinteishoJohoBusiness();
        business.setNinteishoJohoEntity(entity);
        RString 文書番号 = set文書番号(発行日);
        ShogaishaKojoNinteishoPrintService service = new ShogaishaKojoNinteishoPrintService();
        service.print(business, ShikibetsuTaishoFactory.createKojin(uaFt200Entity), AtesakiFactory.createInstance(uaFt250Entity),
                帳票共通情報, 帳票制御汎用キー, 地方公共団体, 発行日, 文書番号, 通知書定型文, reportManager);
    }

    private RString set文書番号(RDate 発行日) {
        RString 文書番号 = RString.EMPTY;
        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = finder.get文書番号管理(帳票ID, new FlexibleDate(発行日.toDateString()));
        if (bushoNo != null) {
            RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
            if (BunshoNoHatsubanHoho.固定.getCode().equals(文書番号発番方法)) {
                文書番号 = bushoNo.edit文書番号();
            } else if (BunshoNoHatsubanHoho.手入力.getCode().equals(文書番号発番方法)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
            } else if (BunshoNoHatsubanHoho.自動採番.getCode().equals(文書番号発番方法)) {
                CountedItem 採番 = Saiban.get(SubGyomuCode.DBD介護受給, GENERICKEY, new FlexibleYear(RDate.getNowDate().getYear().toDateString()), COUNT);
                文書番号 = bushoNo.edit文書番号(採番.nextString());
                RString 文書番号記号 = bushoNo.get文書番号記号();
                文書番号 = 文書番号記号.concat(文書番号);
            }
        }
        return 文書番号;
    }
}
