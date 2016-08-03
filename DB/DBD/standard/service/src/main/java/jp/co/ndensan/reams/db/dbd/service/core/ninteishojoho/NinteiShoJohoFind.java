/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.ninteishojoho;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinshoshaDenshiKoinDataEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 障がい者控除対象者認定証のFindです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public class NinteiShoJohoFind {

    private static final ReportId 帳票分類ID = ReportIdDBD.DBD100025.getReportId();
    private final DbT4001JukyushaDaichoDac 受給者台帳dac;
    private final NinteishoJohoEntity ninteishoJohoentity;

    /**
     * コンストラクタです。
     */
    public NinteiShoJohoFind() {
        受給者台帳dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        ninteishoJohoentity = new NinteishoJohoEntity();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 受給者台帳dac {@link DbT4001JukyushaDaichoDac}
     * @param ninteishoJohoentity {@link NinteishoJohoEntity}
     */
    NinteiShoJohoFind(DbT4001JukyushaDaichoDac 受給者台帳dac,
            NinteishoJohoEntity ninteishoJohoentity) {
        this.受給者台帳dac = 受給者台帳dac;
        this.ninteishoJohoentity = ninteishoJohoentity;

    }

    /**
     * 障がい者控除対象者認定証FindのIntanceを作成します。
     *
     * @return NinteiShoJohoFind
     */
    public static NinteiShoJohoFind createInstance() {
        return InstanceProvider.create(NinteiShoJohoFind.class);
    }

    /**
     * 文書番号取得。
     *
     * @param 帳票ID 帳票ID
     */
    public void get文書番号取得(ReportId 帳票ID) {

        RString 文書番号 = RString.EMPTY;

        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(帳票ID, FlexibleDate.getNowDate());
        if (bushoNo != null) {
            RString 文書番号記号 = bushoNo.get文書番号記号();
            RString 文書番号固定文字 = bushoNo.get文書番号固定文字();
            文書番号 = new RStringBuilder(文書番号記号).
                    append(new RString("第")).
                    append(文書番号固定文字).
                    append(new RString("号")).toRString();
        }
        ninteishoJohoentity.set文書番号(文書番号);
    }

    /**
     * 発行日を取得します。
     *
     * @return 申請者住所
     */
    public FlexibleDate get発行日() {
        return ninteishoJohoentity.get発行日();
    }

    /**
     * 申請者住所を取得します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return ninteishoJohoentity.get申請者住所();
    }

    /**
     * 申請者氏名を取得します。
     *
     * @return 申請者住所
     */
    public RString get申請者氏名() {
        return ninteishoJohoentity.get申請者氏名();
    }

    /**
     * 認証者氏名取得。
     *
     * @param reportSourceWriter ReportSourceWriter
     * @return NinshoshaDenshiKoinDataEntity
     */
    public NinshoshaDenshiKoinDataEntity get認証者氏名(ReportSourceWriter reportSourceWriter) {

        NinshoshaDenshiKoinDataEntity entity = new NinshoshaDenshiKoinDataEntity();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu 帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBD介護受給, 帳票分類ID);

        FlexibleDate 開始年月日 = FlexibleDate.getNowDate();
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha 帳票認証者情報 = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 開始年月日);

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (new RString("1").equals(帳票制御共通.get首長名印字位置())) {
            is公印に掛ける = true;
        }
        if (!帳票制御共通.is電子公印印字有無()) {
            is公印を省略 = true;
        }
        NinshoshaSource ninshoshaSource = NinshoshaSourceBuilderFactory.createInstance(帳票認証者情報,
                地方公共団体,
                reportSourceWriter.getImageFolderPath(),
                RDate.getNowDate(),
                is公印に掛ける,
                is公印を省略,
                KenmeiFuyoKubunType.付与なし).buildSource();
        entity.set認職者氏名(ninshoshaSource.ninshoshaShimeiKakeru);
        entity.set電子公印(ninshoshaSource.denshiKoin);
        return entity;

    }

    /**
     * 対象者住所を取得します。
     *
     * @return 対象者住所
     */
    public AtenaJusho get対象者住所() {
        return ninteishoJohoentity.getPsmEntity().getJusho();
    }

    /**
     * 対象者氏名を取得します。
     *
     * @return 対象者氏名
     */
    public AtenaMeisho get対象者氏名() {
        return ninteishoJohoentity.getPsmEntity().getMeisho();  //TODO get対象者氏名()
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return ninteishoJohoentity.getPsmEntity().getSeinengappiYMD();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return ninteishoJohoentity.getPsmEntity().getSeibetsuCode();
    }

    /**
     * 障がい者控除取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return NinteishoJohoEntity
     */
    @Transaction
    public NinteishoJohoEntity get障がい者控除(HihokenshaNo 被保険者番号) {
        //TODO 障がい者控除がありません。
        ninteishoJohoentity.set障害理由内容(RString.EMPTY);
        ninteishoJohoentity.set障害理由区分(RString.EMPTY);
        ninteishoJohoentity.set申告年(FlexibleDate.MAX);
        return ninteishoJohoentity;
    }

    /**
     * 認定年月日取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return NinteishoJohoEntity
     */
    @Transaction
    public NinteishoJohoEntity get要介護認定日(HihokenshaNo 被保険者番号) {
        DbT4001JukyushaDaichoEntity entity = 受給者台帳dac.select認定年月日(被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        ninteishoJohoentity.set要介護認定日(entity.getNinteiYMD());
        return ninteishoJohoentity;
    }

}
