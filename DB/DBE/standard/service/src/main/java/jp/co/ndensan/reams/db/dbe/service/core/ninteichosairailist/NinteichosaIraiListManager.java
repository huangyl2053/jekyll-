/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosairailist;

import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5203NinteichosahyoKihonChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5205NinteichosahyoTokkijikoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5206GaikyoTokkiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5208NinteichosahyoServiceJokyoFlagDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5209NinteichosahyoKinyuItemDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5210NinteichosahyoShisetsuRiyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5211NinteichosahyoChosaItemDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・認定調査結果入手のクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaIraiListManager {

    private final DbT5105NinteiKanryoJohoDac 要介護認定完了情報Dac;
    private final DbT5116IchijiHanteiKekkaJohoDac 要介護認定一次判定結果情報Dac;
    private final DbT5202NinteichosahyoGaikyoChosaDac 認定調査票概況調査Dac;
    private final DbT5206GaikyoTokkiDac 認定調査票概況特記Dac;
    private final DbT5205NinteichosahyoTokkijikoDac 認定調査票特記情報Dac;
    private final DbT5203NinteichosahyoKihonChosaDac 認定調査票基本調査Dac;
    private final DbT5211NinteichosahyoChosaItemDac 認定調査票基本調査調査項目Dac;
    private final DbT5207NinteichosahyoServiceJokyoDac 認定調査票概況調査サービスの状況Dac;
    private final DbT5208NinteichosahyoServiceJokyoFlagDac 認定調査票概況調査サービスの状況フラグDac;
    private final DbT5209NinteichosahyoKinyuItemDac 認定調査票概況調査記入項目Dac;
    private final DbT5210NinteichosahyoShisetsuRiyoDac 認定調査票概況調査施設利用Dac;

    /**
     * コンストラクタです。
     */
    NinteichosaIraiListManager() {
        this.要介護認定完了情報Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        this.要介護認定一次判定結果情報Dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
        this.認定調査票概況調査Dac = InstanceProvider.create(DbT5202NinteichosahyoGaikyoChosaDac.class);
        this.認定調査票概況特記Dac = InstanceProvider.create(DbT5206GaikyoTokkiDac.class);
        this.認定調査票特記情報Dac = InstanceProvider.create(DbT5205NinteichosahyoTokkijikoDac.class);
        this.認定調査票基本調査Dac = InstanceProvider.create(DbT5203NinteichosahyoKihonChosaDac.class);
        this.認定調査票基本調査調査項目Dac = InstanceProvider.create(DbT5211NinteichosahyoChosaItemDac.class);
        this.認定調査票概況調査サービスの状況Dac = InstanceProvider.create(DbT5207NinteichosahyoServiceJokyoDac.class);
        this.認定調査票概況調査サービスの状況フラグDac = InstanceProvider.create(DbT5208NinteichosahyoServiceJokyoFlagDac.class);
        this.認定調査票概況調査記入項目Dac = InstanceProvider.create(DbT5209NinteichosahyoKinyuItemDac.class);
        this.認定調査票概況調査施設利用Dac = InstanceProvider.create(DbT5210NinteichosahyoShisetsuRiyoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 要介護認定完了情報Dac 要介護認定完了情報Dac
     */
    NinteichosaIraiListManager(
            DbT5105NinteiKanryoJohoDac 要介護認定完了情報Dac,
            DbT5116IchijiHanteiKekkaJohoDac 要介護認定一次判定結果情報Dac,
            DbT5202NinteichosahyoGaikyoChosaDac 認定調査票概況調査Dac,
            DbT5206GaikyoTokkiDac 認定調査票概況特記Dac,
            DbT5205NinteichosahyoTokkijikoDac 認定調査票特記情報Dac,
            DbT5203NinteichosahyoKihonChosaDac 認定調査票基本調査Dac,
            DbT5211NinteichosahyoChosaItemDac 認定調査票基本調査調査項目Dac,
            DbT5207NinteichosahyoServiceJokyoDac 認定調査票概況調査サービスの状況Dac,
            DbT5208NinteichosahyoServiceJokyoFlagDac 認定調査票概況調査サービスの状況フラグDac,
            DbT5209NinteichosahyoKinyuItemDac 認定調査票概況調査記入項目Dac,
            DbT5210NinteichosahyoShisetsuRiyoDac 認定調査票概況調査施設利用Dac) {
        this.要介護認定完了情報Dac = 要介護認定完了情報Dac;
        this.要介護認定一次判定結果情報Dac = 要介護認定一次判定結果情報Dac;
        this.認定調査票概況調査Dac = 認定調査票概況調査Dac;
        this.認定調査票概況特記Dac = 認定調査票概況特記Dac;
        this.認定調査票特記情報Dac = 認定調査票特記情報Dac;
        this.認定調査票基本調査Dac = 認定調査票基本調査Dac;
        this.認定調査票基本調査調査項目Dac = 認定調査票基本調査調査項目Dac;
        this.認定調査票概況調査サービスの状況Dac = 認定調査票概況調査サービスの状況Dac;
        this.認定調査票概況調査サービスの状況フラグDac = 認定調査票概況調査サービスの状況フラグDac;
        this.認定調査票概況調査記入項目Dac = 認定調査票概況調査記入項目Dac;
        this.認定調査票概況調査施設利用Dac = 認定調査票概況調査施設利用Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiListManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiListManager}のインスタンス
     */
    public static NinteichosaIraiListManager createInstance() {
        return InstanceProvider.create(NinteichosaIraiListManager.class);
    }

    /**
     * 要介護認定調査情報を保存します。
     *
     * @param 認定調査票概況調査 認定調査票概況調査
     * @param 認定調査票概況特記 認定調査票概況特記
     * @param 認定調査票特記情報 認定調査票特記情報
     * @param 認定調査票基本調査 認定調査票基本調査
     * @param 認定調査票基本調査調査項目 認定調査票基本調査調査項目
     * @param 認定調査票概況調査サービスの状況 認定調査票概況調査サービスの状況
     * @param 認定調査票概況調査サービスの状況フラグ 認定調査票概況調査サービスの状況フラグ
     * @param 認定調査票概況調査記入項目 認定調査票概況調査記入項目
     * @param 認定調査票概況調査施設利用 認定調査票概況調査施設利用
     */
    @Transaction
    public void saveCsvDataInput(NinteichosahyoGaikyoChosa 認定調査票概況調査,
            GaikyoTokki 認定調査票概況特記,
            NinteichosahyoTokkijiko 認定調査票特記情報,
            NinteichosahyoKihonChosa 認定調査票基本調査,
            NinteichosahyoChosaItem 認定調査票基本調査調査項目,
            NinteichosahyoServiceJokyo 認定調査票概況調査サービスの状況,
            NinteichosahyoServiceJokyoFlag 認定調査票概況調査サービスの状況フラグ,
            NinteichosahyoKinyuItem 認定調査票概況調査記入項目,
            NinteichosahyoShisetsuRiyo 認定調査票概況調査施設利用) {
        save認定調査票概況調査(認定調査票概況調査);
        save認定調査票概況特記(認定調査票概況特記);
        save認定調査票特記情報(認定調査票特記情報);
        save認定調査票基本調査(認定調査票基本調査);
        save認定調査票基本調査調査項目(認定調査票基本調査調査項目);
        save認定調査票概況調査サービスの状況(認定調査票概況調査サービスの状況);
        save認定調査票概況調査サービスの状況フラグ(認定調査票概況調査サービスの状況フラグ);
        save認定調査票概況調査記入項目(認定調査票概況調査記入項目);
        save認定調査票概況調査施設利用(認定調査票概況調査施設利用);
        save要介護認定一次判定結果情報(認定調査票概況調査.get申請書管理番号());
    }

    /**
     * 要介護認定完了情報を保存します。
     *
     * @param 要介護認定完了情報 要介護認定完了情報
     * @return 更新件数
     */
    @Transaction
    public int save要介護認定完了情報(DbT5105NinteiKanryoJohoEntity 要介護認定完了情報) {
        return 要介護認定完了情報Dac.save(要介護認定完了情報);
    }

    @Transaction
    private void save認定調査票概況調査(NinteichosahyoGaikyoChosa 認定調査票概況調査) {
        DbT5202NinteichosahyoGaikyoChosaEntity entity = 認定調査票概況調査Dac.selectByKey(
                認定調査票概況調査.get申請書管理番号(),
                認定調査票概況調査.get認定調査依頼履歴番号(),
                認定調査票概況調査.get概況調査テキストイメージ区分());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票概況調査.get厚労省IF識別コード());
            entity.setNinteichousaIraiKubunCode(認定調査票概況調査.get認定調査依頼区分コード());
            entity.setNinteichosaIraiKaisu(認定調査票概況調査.get認定調査回数());
            entity.setNinteichosaJisshiYMD(認定調査票概況調査.get認定調査実施年月日());
            entity.setNinteichosaJuryoYMD(認定調査票概況調査.get認定調査受領年月日());
            entity.setNinteiChosaKubunCode(認定調査票概況調査.get認定調査区分コード());
            entity.setChosaItakusakiCode(認定調査票概況調査.get認定調査委託先コード());
            entity.setChosainCode(認定調査票概況調査.get認定調査員コード());
            entity.setChosaJisshiBashoCode(認定調査票概況調査.get認定調査実施場所コード());
            entity.setChosaJisshiBashoMeisho(認定調査票概況調査.get認定調査実施場所名称());
            entity.setServiceKubunCode(認定調査票概況調査.get認定調査_サービス区分コード());
            entity.setRiyoShisetsuShimei(認定調査票概況調査.get利用施設名());
            entity.setRiyoShisetsuJusho(認定調査票概況調査.get利用施設住所().getColumnValue());
            entity.setRiyoShisetsuTelNo(認定調査票概況調査.get利用施設電話番号().getColumnValue());
            entity.setRiyoShisetsuYubinNo(認定調査票概況調査.get利用施設郵便番号());
            entity.setTokki(認定調査票概況調査.get特記());
            entity.setTokkijikoUketsukeYMD(認定調査票概況調査.get認定調査特記事項受付年月日());
            entity.setTokkijikoJuryoYMD(認定調査票概況調査.get認定調査特記事項受領年月日());
            認定調査票概況調査Dac.save(entity);
        } else {
            認定調査票概況調査Dac.save(認定調査票概況調査.toEntity());
        }
    }

    @Transaction
    private void save認定調査票概況特記(GaikyoTokki 認定調査票概況特記) {
        DbT5206GaikyoTokkiEntity entity = 認定調査票概況特記Dac.selectByKey(
                認定調査票概況特記.get申請書管理番号(),
                認定調査票概況特記.get認定調査依頼履歴番号(),
                認定調査票概況特記.get概況特記テキストイメージ区分());
        if (entity != null) {
            entity.setJutakuKaishu(認定調査票概況特記.get住宅改修());
            entity.setTokubetsuKyufuService(認定調査票概況特記.get市町村特別給付サービス種類名());
            entity.setZaitakuService(認定調査票概況特記.get介護保険給付以外の在宅サービス種類名());
            entity.setShuso(認定調査票概況特記.get概況特記事項_主訴());
            entity.setKazokuJokyo(認定調査票概況特記.get概況特記事項_家族状況());
            entity.setKyojuKankyo(認定調査票概況特記.get概況特記事項_居住環境());
            entity.setKikaiKiki(認定調査票概況特記.get概況特記事項_機器_器械());
            認定調査票概況特記Dac.save(entity);
        } else {
            認定調査票概況特記Dac.save(認定調査票概況特記.toEntity());
        }
    }

    @Transaction
    private void save認定調査票特記情報(NinteichosahyoTokkijiko 認定調査票特記情報) {
        DbT5205NinteichosahyoTokkijikoEntity entity = 認定調査票特記情報Dac.selectByKey(
                認定調査票特記情報.get申請書管理番号(),
                認定調査票特記情報.get認定調査依頼履歴番号(),
                認定調査票特記情報.get認定調査特記事項番号(),
                認定調査票特記情報.get認定調査特記事項連番(),
                認定調査票特記情報.get特記事項テキスト_イメージ区分(),
                認定調査票特記情報.get原本マスク区分());
        if (entity != null) {
            entity.setTokkiJiko(認定調査票特記情報.get特記事項());
            認定調査票特記情報Dac.save(entity);
        } else {
            認定調査票特記情報Dac.save(認定調査票特記情報.toEntity());
        }
    }

    @Transaction
    private void save認定調査票基本調査(NinteichosahyoKihonChosa 認定調査票基本調査) {
        DbT5203NinteichosahyoKihonChosaEntity entity = 認定調査票基本調査Dac.selectByKey(
                認定調査票基本調査.get申請書管理番号(),
                認定調査票基本調査.get要介護認定調査履歴番号());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票基本調査.get厚労省IF識別コード());
            entity.setNinchishoNichijoSeikatsuJiritsudoCode(認定調査票基本調査.get認定調査_認知症高齢者の日常生活自立度コード());
            entity.setShogaiNichijoSeikatsuJiritsudoCode(認定調査票基本調査.get認定調査_障害高齢者の日常生活自立度コード());
            認定調査票基本調査Dac.save(entity);
        } else {
            認定調査票基本調査Dac.save(認定調査票基本調査.toEntity());
        }
    }

    @Transaction
    private void save認定調査票基本調査調査項目(NinteichosahyoChosaItem 認定調査票基本調査調査項目) {
        DbT5211NinteichosahyoChosaItemEntity entity = 認定調査票基本調査調査項目Dac.selectByKey(
                認定調査票基本調査調査項目.get申請書管理番号(),
                認定調査票基本調査調査項目.get要介護認定調査履歴番号(),
                認定調査票基本調査調査項目.get連番());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票基本調査調査項目.get厚労省IF識別コード());
            entity.setResearchItem(認定調査票基本調査調査項目.get調査項目());
            認定調査票基本調査調査項目Dac.save(entity);
        } else {
            認定調査票基本調査調査項目Dac.save(認定調査票基本調査調査項目.toEntity());
        }
    }

    @Transaction
    private void save認定調査票概況調査サービスの状況(NinteichosahyoServiceJokyo 認定調査票概況調査サービスの状況) {
        DbT5207NinteichosahyoServiceJokyoEntity entity = 認定調査票概況調査サービスの状況Dac.selectByKey(
                認定調査票概況調査サービスの状況.get申請書管理番号(),
                認定調査票概況調査サービスの状況.get認定調査依頼履歴番号(),
                認定調査票概況調査サービスの状況.get連番());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票概況調査サービスの状況.toEntity().getKoroshoIfShikibetsuCode());
            entity.setServiceJokyo(認定調査票概況調査サービスの状況.getサービスの状況());
            認定調査票概況調査サービスの状況Dac.save(entity);
        } else {
            認定調査票概況調査サービスの状況Dac.save(認定調査票概況調査サービスの状況.toEntity());
        }
    }

    @Transaction
    private void save認定調査票概況調査サービスの状況フラグ(NinteichosahyoServiceJokyoFlag 認定調査票概況調査サービスの状況フラグ) {
        DbT5208NinteichosahyoServiceJokyoFlagEntity entity = 認定調査票概況調査サービスの状況フラグDac.selectByKey(
                認定調査票概況調査サービスの状況フラグ.get申請書管理番号(),
                認定調査票概況調査サービスの状況フラグ.get認定調査依頼履歴番号(),
                認定調査票概況調査サービスの状況フラグ.get連番());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票概況調査サービスの状況フラグ.toEntity().getKoroshoIfShikibetsuCode());
            entity.setServiceJokyoFlag(認定調査票概況調査サービスの状況フラグ.toEntity().getServiceJokyoFlag());
            認定調査票概況調査サービスの状況フラグDac.save(entity);
        } else {
            認定調査票概況調査サービスの状況フラグDac.save(認定調査票概況調査サービスの状況フラグ.toEntity());
        }
    }

    @Transaction
    private void save認定調査票概況調査記入項目(NinteichosahyoKinyuItem 認定調査票概況調査記入項目) {
        DbT5209NinteichosahyoKinyuItemEntity entity = 認定調査票概況調査記入項目Dac.selectByKey(
                認定調査票概況調査記入項目.get申請書管理番号(),
                認定調査票概況調査記入項目.get認定調査依頼履歴番号(),
                認定調査票概況調査記入項目.get連番());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票概況調査記入項目.get厚労省IF識別コード());
            entity.setServiceJokyoKinyu(認定調査票概況調査記入項目.getサービスの状況記入());
            認定調査票概況調査記入項目Dac.save(entity);
        } else {
            認定調査票概況調査記入項目Dac.save(認定調査票概況調査記入項目.toEntity());
        }
    }

    @Transaction
    private void save認定調査票概況調査施設利用(NinteichosahyoShisetsuRiyo 認定調査票概況調査施設利用) {
        DbT5210NinteichosahyoShisetsuRiyoEntity entity = 認定調査票概況調査施設利用Dac.selectByKey(
                認定調査票概況調査施設利用.get申請書管理番号(),
                認定調査票概況調査施設利用.get認定調査依頼履歴番号(),
                認定調査票概況調査施設利用.get連番());
        if (entity != null) {
            entity.setKoroshoIfShikibetsuCode(認定調査票概況調査施設利用.get厚労省IF識別コード());
            entity.setShisetsuRiyoFlag(認定調査票概況調査施設利用.toEntity().getShisetsuRiyoFlag());
            認定調査票概況調査施設利用Dac.save(entity);
        } else {
            認定調査票概況調査施設利用Dac.save(認定調査票概況調査施設利用.toEntity());
        }
    }

    @Transaction
    private void save要介護認定一次判定結果情報(ShinseishoKanriNo 申請書管理番号) {
        DbT5116IchijiHanteiKekkaJohoEntity entity = 要介護認定一次判定結果情報Dac.selectByKey(申請書管理番号);
        if (entity != null) {
            IchijiHanteiKekkaJohoSearchBusiness 一次判定結果情報 = IchijiHanteiKekkaJohoSearchManager.createIntance().
                    getIchijiHanteiKekkaJoho(申請書管理番号);

            entity.setKariIchijiHanteiKubun(true);
            entity.setIchijiHanteiYMD(FlexibleDate.getNowDate());
            entity.setIchijiHanteiKekkaCode(new Code(一次判定結果情報.get一次判定結果()));
            entity.setIchijiHanteiKekkaNinchishoKasanCode(new Code(一次判定結果情報.get認知症加算後の一次判定結果()));
            entity.setKijunJikan(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（食事） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanShokuji(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（排泄） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanHaisetsu(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（移動） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanIdo(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（清潔保持） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanSeiketsuHoji(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（間接ケア） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanKansetsuCare(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（BPSD関連） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanBPSDKanren(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（機能訓練） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanKinoKunren(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（医療関連） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanIryoKanren(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 要介護認定等基準時間（認知症加算） ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setKijunJikanNinchishoKasan(Integer.parseInt(一次判定結果情報.get要介護認定等基準時間().toString()));
            // TODO 中間評価項目得点第1群 ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setChukanHyokaKomoku1gun(Integer.parseInt(一次判定結果情報.get中間評価項目得点().toString()));
            // TODO 中間評価項目得点第2群 ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setChukanHyokaKomoku2gun(Integer.parseInt(一次判定結果情報.get中間評価項目得点().toString()));
            // TODO 中間評価項目得点第3群 ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setChukanHyokaKomoku3gun(Integer.parseInt(一次判定結果情報.get中間評価項目得点().toString()));
            // TODO 中間評価項目得点第4群 ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setChukanHyokaKomoku4gun(Integer.parseInt(一次判定結果情報.get中間評価項目得点().toString()));
            // TODO 中間評価項目得点第5群 ビジネス設計_IchijiHanteiKekkaJoho_一次判定結果処理にて、 QA79385を参照する
            entity.setChukanHyokaKomoku5gun(Integer.parseInt(一次判定結果情報.get中間評価項目得点().toString()));
            entity.setIchijiHnateiKeikokuCode(一次判定結果情報.get一次判定警告コード());
            entity.setJotaiAnteiseiCode(new Code(一次判定結果情報.get状態の安定性()));
            entity.setNinchishoJiritsudoIIijoNoGaizensei(Decimal.valueOf(Integer.parseInt(一次判定結果情報.get認知症自立度Ⅱ以上の蓋然性_評価の１０倍().toString())));
            entity.setSuiteiKyufuKubunCode(new Code(一次判定結果情報.get認知機能及び状態安定性から推定される給付区分()));

            要介護認定一次判定結果情報Dac.save(entity);
        }
    }

}
