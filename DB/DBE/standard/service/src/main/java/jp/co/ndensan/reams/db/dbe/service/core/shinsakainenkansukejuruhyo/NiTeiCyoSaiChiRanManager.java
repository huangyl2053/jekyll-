/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakainenkansukejuruhyo;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadatatorikomi.NinteiChosaDataTorikomiRelate;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadatatorikomi.NinteiChosaDataTorikomiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadatatorikomi.NinteiChosaDataTorikomiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadatatorikomi.INinteiChosaDataTorikomiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5203NinteichosahyoKihonChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5205NinteichosahyoTokkijikoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5206GaikyoTokkiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5208NinteichosahyoServiceJokyoFlagDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5209NinteichosahyoKinyuItemDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5210NinteichosahyoShisetsuRiyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5211NinteichosahyoChosaItemDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBE2250001_認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class NiTeiCyoSaiChiRanManager {

    private final MapperProvider mapperProvider;
    private final DbT5202NinteichosahyoGaikyoChosaDac dbT5202Dac;
    private final DbT5206GaikyoTokkiDac dbT5206Dac;
    private final DbT5205NinteichosahyoTokkijikoDac dbT5205Dac;
    private final DbT5203NinteichosahyoKihonChosaDac dbT5203Dac;
    private final DbT5211NinteichosahyoChosaItemDac dbT5211Dac;
    private final DbT5207NinteichosahyoServiceJokyoDac dbT5207Dac;
    private final DbT5208NinteichosahyoServiceJokyoFlagDac dbT5208Dac;
    private final DbT5209NinteichosahyoKinyuItemDac dbT5209Dac;
    private final DbT5210NinteichosahyoShisetsuRiyoDac dbT5210Dac;

    /**
     * コンストラクタです。
     */
    public NiTeiCyoSaiChiRanManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dbT5202Dac = InstanceProvider.create(DbT5202NinteichosahyoGaikyoChosaDac.class);
        dbT5206Dac = InstanceProvider.create(DbT5206GaikyoTokkiDac.class);
        dbT5205Dac = InstanceProvider.create(DbT5205NinteichosahyoTokkijikoDac.class);
        dbT5203Dac = InstanceProvider.create(DbT5203NinteichosahyoKihonChosaDac.class);
        dbT5211Dac = InstanceProvider.create(DbT5211NinteichosahyoChosaItemDac.class);
        dbT5207Dac = InstanceProvider.create(DbT5207NinteichosahyoServiceJokyoDac.class);
        dbT5208Dac = InstanceProvider.create(DbT5208NinteichosahyoServiceJokyoFlagDac.class);
        dbT5209Dac = InstanceProvider.create(DbT5209NinteichosahyoKinyuItemDac.class);
        dbT5210Dac = InstanceProvider.create(DbT5210NinteichosahyoShisetsuRiyoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NiTeiCyoSaiChiRanManager}のインスタンスを返します。
     *
     * @return JigyoshaInputGuideFinder
     */
    public static NiTeiCyoSaiChiRanManager createInstance() {
        return InstanceProvider.create(NiTeiCyoSaiChiRanManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     */
    NiTeiCyoSaiChiRanManager(
            MapperProvider mapperProvider,
            DbT5202NinteichosahyoGaikyoChosaDac dbT5202Dac,
            DbT5206GaikyoTokkiDac dbT5206Dac,
            DbT5205NinteichosahyoTokkijikoDac dbT5205Dac,
            DbT5203NinteichosahyoKihonChosaDac dbT5203Dac,
            DbT5211NinteichosahyoChosaItemDac dbT5211Dac,
            DbT5207NinteichosahyoServiceJokyoDac dbT5207Dac,
            DbT5208NinteichosahyoServiceJokyoFlagDac dbT5208Dac,
            DbT5209NinteichosahyoKinyuItemDac dbT5209Dac,
            DbT5210NinteichosahyoShisetsuRiyoDac dbT5210Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5202Dac = dbT5202Dac;
        this.dbT5206Dac = dbT5206Dac;
        this.dbT5205Dac = dbT5205Dac;
        this.dbT5203Dac = dbT5203Dac;
        this.dbT5211Dac = dbT5211Dac;
        this.dbT5207Dac = dbT5207Dac;
        this.dbT5208Dac = dbT5208Dac;
        this.dbT5209Dac = dbT5209Dac;
        this.dbT5210Dac = dbT5210Dac;
    }

    /**
     * 引数で指定した条件に該当する認定調査情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     * @return 認定調査一覧リスト
     */
    @Transaction
    public NinteiChosaDataTorikomiRelate get認定調査情報(RString 証記載保険者番号, RString 被保険者番号, RString 認定申請日) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(認定申請日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請日"));

        INinteiChosaDataTorikomiMapper mapper = mapperProvider.create(INinteiChosaDataTorikomiMapper.class);
        NinteiChosaDataTorikomiMapperParameter parameter
                = new NinteiChosaDataTorikomiMapperParameter(証記載保険者番号, 被保険者番号, 認定申請日);
        NinteiChosaDataTorikomiRelateEntity entity = mapper.select認定調査情報(parameter);
        return (entity != null) ? new NinteiChosaDataTorikomiRelate(entity) : null;
    }

    /**
     * 認定調査データを更新します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param テキストイメージ区分 RString
     * @param 原本マスク区分 Code
     * @param 概況調査 NinteichosahyoGaikyoChosaBuilder
     * @param 特記情報 NinteichosahyoTokkijiko
     * @param 概況特記 NinteichosahyoGaikyoChosa
     * @param 基本調査 NinteichosahyoKihonChosa
     * @param 要介護認定調査履歴番号 int
     * @param 調査項目 NinteichosahyoChosaItem
     * @param サービスの状況 NinteichosahyoServiceJokyo
     * @param サービスの状況フラグ NinteichosahyoServiceJokyoFlag
     * @param 記入項目 NinteichosahyoKinyuItem
     * @param 施設利用 NinteichosahyoShisetsuRiyo
     */
    @Transaction
    public void save認定調査データ(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString テキストイメージ区分,
            Code 原本マスク区分,
            List<NinteichosahyoTokkijiko> 特記情報,
            NinteichosahyoGaikyoChosa 概況調査,
            GaikyoTokki 概況特記,
            NinteichosahyoKihonChosa 基本調査,
            List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoServiceJokyo> サービスの状況,
            List<NinteichosahyoServiceJokyoFlag> サービスの状況フラグ,
            List<NinteichosahyoKinyuItem> 記入項目,
            List<NinteichosahyoShisetsuRiyo> 施設利用) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査テキストイメージ区分"));
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));

        save認定調査票概況調査(申請書管理番号, 認定調査依頼履歴番号, テキストイメージ区分, 概況調査);
        save認定調査票概況特記(申請書管理番号, 認定調査依頼履歴番号, テキストイメージ区分, 原本マスク区分, 概況特記);
        save認定調査票特記情報(申請書管理番号, 認定調査依頼履歴番号, テキストイメージ区分, 原本マスク区分, 特記情報);
        save認定調査票基本調査(申請書管理番号, 認定調査依頼履歴番号, 基本調査);
        save基本調査調査項目(申請書管理番号, 認定調査依頼履歴番号, 調査項目);
        save認定調査票概況調査サービスの状況(申請書管理番号, 認定調査依頼履歴番号, サービスの状況);
        save認定調査票概況調査サービスの状況フラグ(申請書管理番号, 認定調査依頼履歴番号, サービスの状況フラグ);
        save認定調査票概況調査記入項目(申請書管理番号, 認定調査依頼履歴番号, 記入項目);
        save認定調査票概況調査施設利用(申請書管理番号, 認定調査依頼履歴番号, 施設利用);
    }

    private boolean save認定調査票概況調査(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分, NinteichosahyoGaikyoChosa 概況調査) {
        DbT5202NinteichosahyoGaikyoChosaEntity entity = dbT5202Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキストイメージ区分);
        if (!概況調査.hasChanged()) {
            return false;
        }
        if (entity == null) {
            return 1 == dbT5202Dac.save(概況調査.toEntity());
        }
        return 1 == dbT5202Dac.save(createModifyData(entity, 概況調査));
    }

    private DbT5202NinteichosahyoGaikyoChosaEntity createModifyData(DbT5202NinteichosahyoGaikyoChosaEntity entity,
            NinteichosahyoGaikyoChosa 概況調査) {
        entity.setShinseishoKanriNo(概況調査.get申請書管理番号());
        entity.setNinteichosaRirekiNo(概況調査.get認定調査依頼履歴番号());
        entity.setGaikyoChosaTextImageKubun(概況調査.get概況調査テキストイメージ区分());
        entity.setKoroshoIfShikibetsuCode(概況調査.get厚労省IF識別コード());
        entity.setNinteichousaIraiKubunCode(概況調査.get認定調査依頼区分コード());
        entity.setNinteichosaIraiKaisu(概況調査.get認定調査回数());
        entity.setNinteichosaJisshiYMD(概況調査.get認定調査実施年月日());
        entity.setNinteichosaJuryoYMD(概況調査.get認定調査受領年月日());
        entity.setNinteiChosaKubunCode(概況調査.get認定調査区分コード());
        entity.setChosaItakusakiCode(概況調査.get認定調査委託先コード());
        entity.setChosainCode(概況調査.get認定調査員コード());
        entity.setChosaJisshiBashoCode(概況調査.get認定調査実施場所コード());
        entity.setChosaJisshiBashoMeisho(概況調査.get認定調査実施場所名称());
        entity.setServiceKubunCode(概況調査.get認定調査_サービス区分コード());
        entity.setRiyoShisetsuShimei(概況調査.get利用施設名());
        entity.setRiyoShisetsuJusho(概況調査.get利用施設住所().getColumnValue());
        entity.setRiyoShisetsuTelNo(概況調査.get利用施設電話番号().getColumnValue());
        entity.setRiyoShisetsuYubinNo(概況調査.get利用施設郵便番号());
        entity.setTokki(概況調査.get特記());
        entity.setTokkijikoUketsukeYMD(概況調査.get認定調査特記事項受付年月日());
        entity.setTokkijikoJuryoYMD(概況調査.get認定調査特記事項受領年月日());
        return entity;
    }

    private boolean save認定調査票概況特記(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分, Code 原本マスク区分, GaikyoTokki 概況特記) {
        DbT5206GaikyoTokkiEntity entity = dbT5206Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキストイメージ区分, 原本マスク区分);
        if (!概況特記.hasChanged()) {
            return false;
        }
        if (entity == null) {
            return 1 == dbT5206Dac.save(概況特記.toEntity());
        }
        return 1 == dbT5206Dac.save(createModifyData(entity, 概況特記));
    }

    private DbT5206GaikyoTokkiEntity createModifyData(DbT5206GaikyoTokkiEntity entity, GaikyoTokki 概況特記) {
        entity.setShinseishoKanriNo(概況特記.get申請書管理番号());
        entity.setNinteichosaRirekiNo(概況特記.get認定調査依頼履歴番号());
        entity.setGaikyoTokkiTextImageKubun(概況特記.get概況特記テキストイメージ区分());
        entity.setJutakuKaishu(概況特記.get住宅改修());
        entity.setTokubetsuKyufuService(概況特記.get市町村特別給付サービス種類名());
        entity.setZaitakuService(概況特記.get介護保険給付以外の在宅サービス種類名());
        entity.setShuso(概況特記.get概況特記事項_主訴());
        entity.setKazokuJokyo(概況特記.get概況特記事項_家族状況());
        entity.setKyojuKankyo(概況特記.get概況特記事項_居住環境());
        entity.setKikaiKiki(概況特記.get概況特記事項_機器_器械());
        return entity;
    }

    private boolean save認定調査票特記情報(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号,
            RString 特記事項テキスト_イメージ区分, Code 原本マスク区分, List<NinteichosahyoTokkijiko> 特記情報List) {
        List<DbT5205NinteichosahyoTokkijikoEntity> entityList = dbT5205Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号,
                特記事項テキスト_イメージ区分, 原本マスク区分);
        int updateCount = 0;
        if (entityList == null || entityList.isEmpty()) {
            for (NinteichosahyoTokkijiko 特記事項 : 特記情報List) {
                updateCount = updateCount + dbT5205Dac.save(特記事項.toEntity());
            }
            return updateCount == 特記情報List.size();
        }

        for (NinteichosahyoTokkijiko 特記事項 : 特記情報List) {
            for (DbT5205NinteichosahyoTokkijikoEntity entity : entityList) {
                if (特記事項.get申請書管理番号().equals(entity.getShinseishoKanriNo())
                        && 特記事項.get認定調査依頼履歴番号() == entity.getNinteichosaRirekiNo()
                        && 特記事項.get認定調査特記事項番号().equals(entity.getNinteichosaTokkijikoNo())
                        && 特記事項.get認定調査特記事項連番() == entity.getNinteichosaTokkijikoRemban()
                        && 特記事項.get特記事項テキスト_イメージ区分().equals(entity.getTokkijikoTextImageKubun())
                        && 特記事項.get原本マスク区分().equals(entity.getGenponMaskKubun())) {
                    updateCount = updateCount + dbT5205Dac.save(createModifyData(entity, 特記事項));
                }
            }
        }
        return updateCount == 特記情報List.size();
    }

    private DbT5205NinteichosahyoTokkijikoEntity createModifyData(DbT5205NinteichosahyoTokkijikoEntity entity,
            NinteichosahyoTokkijiko 特記情報) {
        entity.setShinseishoKanriNo(特記情報.get申請書管理番号());
        entity.setNinteichosaRirekiNo(特記情報.get認定調査依頼履歴番号());
        entity.setNinteichosaTokkijikoNo(特記情報.get認定調査特記事項番号());
        entity.setNinteichosaTokkijikoRemban(特記情報.get認定調査特記事項連番());
        entity.setTokkijikoTextImageKubun(特記情報.get特記事項テキスト_イメージ区分());
        entity.setGenponMaskKubun(特記情報.get原本マスク区分());
        entity.setTokkiJiko(特記情報.get特記事項());
        return entity;
    }

    private boolean save認定調査票基本調査(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号, NinteichosahyoKihonChosa 基本調査) {
        DbT5203NinteichosahyoKihonChosaEntity entity = dbT5203Dac.selectByKey(申請書管理番号, 要介護認定調査履歴番号);
        if (!基本調査.hasChanged()) {
            return false;
        }
        if (entity == null) {
            return 1 == dbT5203Dac.save(基本調査.toEntity());
        }
        return 1 == dbT5203Dac.save(createModifyData(entity, 基本調査));
    }

    private DbT5203NinteichosahyoKihonChosaEntity createModifyData(DbT5203NinteichosahyoKihonChosaEntity entity,
            NinteichosahyoKihonChosa 基本調査) {
        entity.setShinseishoKanriNo(基本調査.get申請書管理番号());
        entity.setNinteichosaRirekiNo(基本調査.get要介護認定調査履歴番号());
        entity.setKoroshoIfShikibetsuCode(基本調査.get厚労省IF識別コード());
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(基本調査.get認定調査_認知症高齢者の日常生活自立度コード());
        entity.setShogaiNichijoSeikatsuJiritsudoCode(基本調査.get認定調査_障害高齢者の日常生活自立度コード());
        return entity;
    }

    private boolean save基本調査調査項目(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号, List<NinteichosahyoChosaItem> 調査項目List) {
        List<DbT5211NinteichosahyoChosaItemEntity> entityList = dbT5211Dac.select調査項目(申請書管理番号, 要介護認定調査履歴番号);
        int updateCount = 0;
        if (entityList == null || entityList.isEmpty()) {
            for (NinteichosahyoChosaItem 調査項目 : 調査項目List) {
                updateCount = updateCount + dbT5211Dac.save(調査項目.toEntity());
            }
            return updateCount == 調査項目List.size();
        }

        for (NinteichosahyoChosaItem 調査項目 : 調査項目List) {
            for (DbT5211NinteichosahyoChosaItemEntity entity : entityList) {
                if (調査項目.get申請書管理番号().equals(entity.getShinseishoKanriNo())
                        && 調査項目.get要介護認定調査履歴番号() == entity.getNinteichosaRirekiNo()
                        && 調査項目.get連番() == entity.getRemban()) {
                    updateCount = updateCount + dbT5211Dac.save(createModifyData(entity, 調査項目));
                }
            }
        }
        return updateCount == 調査項目List.size();
    }

    private DbT5211NinteichosahyoChosaItemEntity createModifyData(DbT5211NinteichosahyoChosaItemEntity entity,
            NinteichosahyoChosaItem 調査項目) {
        entity.setShinseishoKanriNo(調査項目.get申請書管理番号());
        entity.setNinteichosaRirekiNo(調査項目.get要介護認定調査履歴番号());
        entity.setRemban(調査項目.get連番());
        entity.setKoroshoIfShikibetsuCode(調査項目.get厚労省IF識別コード());
        entity.setResearchItem(調査項目.get調査項目());
        return entity;
    }

    private boolean save認定調査票概況調査サービスの状況(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号, List<NinteichosahyoServiceJokyo> サービスの状況List) {
        List<DbT5207NinteichosahyoServiceJokyoEntity> entityList = dbT5207Dac.selectサービスの状況(申請書管理番号, 認定調査依頼履歴番号);
        int updateCount = 0;
        if (entityList == null || entityList.isEmpty()) {
            for (NinteichosahyoServiceJokyo サービスの状況 : サービスの状況List) {
                updateCount = updateCount + dbT5207Dac.save(サービスの状況.toEntity());
            }
            return updateCount == サービスの状況List.size();
        }

        for (NinteichosahyoServiceJokyo サービスの状況 : サービスの状況List) {
            for (DbT5207NinteichosahyoServiceJokyoEntity entity : entityList) {
                if (サービスの状況.get申請書管理番号().equals(entity.getShinseishoKanriNo())
                        && サービスの状況.get認定調査依頼履歴番号() == entity.getNinteichosaRirekiNo()
                        && サービスの状況.get連番() == entity.getRemban()) {
                    updateCount = updateCount + dbT5207Dac.save(createModifyData(entity, サービスの状況));
                }
            }
        }
        return updateCount == サービスの状況List.size();
    }

    private DbT5207NinteichosahyoServiceJokyoEntity createModifyData(DbT5207NinteichosahyoServiceJokyoEntity entity,
            NinteichosahyoServiceJokyo サービスの状況) {
        entity.setShinseishoKanriNo(サービスの状況.get申請書管理番号());
        entity.setNinteichosaRirekiNo(サービスの状況.get認定調査依頼履歴番号());
        entity.setRemban(サービスの状況.get連番());
        entity.setKoroshoIfShikibetsuCode(サービスの状況.get厚労省IF識別コード());
        entity.setServiceJokyo(サービスの状況.getサービスの状況());
        return entity;
    }

    private boolean save認定調査票概況調査サービスの状況フラグ(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号, List<NinteichosahyoServiceJokyoFlag> サービスの状況フラグList) {
        List<DbT5208NinteichosahyoServiceJokyoFlagEntity> entityList = dbT5208Dac.selectサービスの状況フラグ(申請書管理番号, 認定調査依頼履歴番号);
        int updateCount = 0;
        if (entityList == null || entityList.isEmpty()) {
            for (NinteichosahyoServiceJokyoFlag サービスの状況フラグ : サービスの状況フラグList) {
                updateCount = updateCount + dbT5208Dac.save(サービスの状況フラグ.toEntity());
            }
            return updateCount == サービスの状況フラグList.size();
        }

        for (NinteichosahyoServiceJokyoFlag サービスの状況フラグ : サービスの状況フラグList) {
            for (DbT5208NinteichosahyoServiceJokyoFlagEntity entity : entityList) {
                if (サービスの状況フラグ.get申請書管理番号().equals(entity.getShinseishoKanriNo())
                        && サービスの状況フラグ.get認定調査依頼履歴番号() == entity.getNinteichosaRirekiNo()
                        && サービスの状況フラグ.get連番() == entity.getRemban()) {
                    updateCount = updateCount + dbT5208Dac.save(createModifyData(entity, サービスの状況フラグ));
                }
            }
        }
        return updateCount == サービスの状況フラグList.size();
    }

    private DbT5208NinteichosahyoServiceJokyoFlagEntity createModifyData(DbT5208NinteichosahyoServiceJokyoFlagEntity entity,
            NinteichosahyoServiceJokyoFlag サービスの状況フラグ) {
        entity.setShinseishoKanriNo(サービスの状況フラグ.get申請書管理番号());
        entity.setNinteichosaRirekiNo(サービスの状況フラグ.get認定調査依頼履歴番号());
        entity.setRemban(サービスの状況フラグ.get連番());
        entity.setKoroshoIfShikibetsuCode(サービスの状況フラグ.get厚労省IF識別コード());
        entity.setServiceJokyoFlag(サービスの状況フラグ.isサービスの状況フラグ());
        return entity;
    }

    private boolean save認定調査票概況調査記入項目(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号, List<NinteichosahyoKinyuItem> 記入項目List) {
        List<DbT5209NinteichosahyoKinyuItemEntity> entityList = dbT5209Dac.select記入項目(申請書管理番号, 認定調査依頼履歴番号);
        int updateCount = 0;
        if (entityList == null || entityList.isEmpty()) {
            for (NinteichosahyoKinyuItem 記入項目 : 記入項目List) {
                updateCount = updateCount + dbT5209Dac.save(記入項目.toEntity());
            }
            return updateCount == 記入項目List.size();
        }

        for (NinteichosahyoKinyuItem 記入項目 : 記入項目List) {
            for (DbT5209NinteichosahyoKinyuItemEntity entity : entityList) {
                if (記入項目.get申請書管理番号().equals(entity.getShinseishoKanriNo())
                        && 記入項目.get認定調査依頼履歴番号() == entity.getNinteichosaRirekiNo()
                        && 記入項目.get連番() == entity.getRemban()) {
                    updateCount = updateCount + dbT5209Dac.save(createModifyData(entity, 記入項目));
                }
            }
        }
        return updateCount == 記入項目List.size();
    }

    private DbT5209NinteichosahyoKinyuItemEntity createModifyData(DbT5209NinteichosahyoKinyuItemEntity entity,
            NinteichosahyoKinyuItem 記入項目) {
        entity.setShinseishoKanriNo(記入項目.get申請書管理番号());
        entity.setNinteichosaRirekiNo(記入項目.get認定調査依頼履歴番号());
        entity.setRemban(記入項目.get連番());
        entity.setKoroshoIfShikibetsuCode(記入項目.get厚労省IF識別コード());
        entity.setServiceJokyoKinyu(記入項目.getサービスの状況記入());
        return entity;
    }

    private boolean save認定調査票概況調査施設利用(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号, List<NinteichosahyoShisetsuRiyo> 施設利用List) {
        List<DbT5210NinteichosahyoShisetsuRiyoEntity> entityList = dbT5210Dac.selectBy連番除外(申請書管理番号, 認定調査依頼履歴番号);
        int updateCount = 0;
        if (entityList == null || entityList.isEmpty()) {
            for (NinteichosahyoShisetsuRiyo 施設利用 : 施設利用List) {
                updateCount = updateCount + dbT5210Dac.save(施設利用.toEntity());
            }
            return updateCount == 施設利用List.size();
        }

        for (NinteichosahyoShisetsuRiyo 施設利用 : 施設利用List) {
            for (DbT5210NinteichosahyoShisetsuRiyoEntity entity : entityList) {
                if (施設利用.get申請書管理番号().equals(entity.getShinseishoKanriNo())
                        && 施設利用.get認定調査依頼履歴番号() == entity.getNinteichosaRirekiNo()
                        && 施設利用.get連番() == entity.getRemban()) {
                    updateCount = updateCount + dbT5210Dac.save(createModifyData(entity, 施設利用));
                }
            }
        }
        return updateCount == 施設利用List.size();
    }

    private DbT5210NinteichosahyoShisetsuRiyoEntity createModifyData(DbT5210NinteichosahyoShisetsuRiyoEntity entity,
            NinteichosahyoShisetsuRiyo 施設利用) {
        entity.setShinseishoKanriNo(施設利用.get申請書管理番号());
        entity.setNinteichosaRirekiNo(施設利用.get認定調査依頼履歴番号());
        entity.setRemban(施設利用.get連番());
        entity.setKoroshoIfShikibetsuCode(施設利用.get厚労省IF識別コード());
        entity.setShisetsuRiyoFlag(施設利用.is施設利用フラグ());
        return entity;
    }
}
