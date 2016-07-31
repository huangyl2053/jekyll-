/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakainenkansukejuruhyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran.NiTeiCyoSaiChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran.NinteichosahyoGaikyoChosaRelateBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.niteicyosaichiran.NiTeiCyoSaiChiRanParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran.NiTeiCyoSaiChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran.NinteichosahyoGaikyoChosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.niteicyosaichiran.INiTeiCyoSaiChiRanMapper;
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
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 画面設計_DBE2250001_認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBZ-1870-010 houtianpeng
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
    private final RString 申請書管理番号_Message = new RString("申請書管理番号");
    private final RString 認定調査依頼履歴番号_Message = new RString("認定調査依頼履歴番号");
    private final RString 概況調査テキストイメージ区分_Message = new RString("概況調査テキストイメージ区分");

    /**
     * コンストラクタ。
     *
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
     * 認定調査一覧を取得します。
     *
     * @param parameter NiTeiCyoSaiChiRanParameter
     * @return 認定調査一覧リスト
     */
    @Transaction
    public SearchResult<NiTeiCyoSaiChiRanBusiness> get認定調査一覧(NiTeiCyoSaiChiRanParameter parameter) {
        List<NiTeiCyoSaiChiRanBusiness> 認定調査一覧List = new ArrayList<>();
        INiTeiCyoSaiChiRanMapper mapper = mapperProvider.create(INiTeiCyoSaiChiRanMapper.class);
        List<NiTeiCyoSaiChiRanRelateEntity> entityList = mapper.get認定調査一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NiTeiCyoSaiChiRanBusiness>emptyList(), 0, false);
        }
        for (NiTeiCyoSaiChiRanRelateEntity entity : entityList) {
            認定調査一覧List.add(new NiTeiCyoSaiChiRanBusiness(entity));
        }
        return SearchResult.of(認定調査一覧List, 0, false);
    }

    /**
     * 認定調査票（概況調査）を取得します。
     *
     * @param parameter NiTeiCyoSaiChiRanParameter
     * @return 認定調査票（概況調査）リスト
     */
    @Transaction
    public SearchResult<NinteichosahyoGaikyoChosaRelateBusiness> get認定調査(NiTeiCyoSaiChiRanParameter parameter) {
        INiTeiCyoSaiChiRanMapper mapper = mapperProvider.create(INiTeiCyoSaiChiRanMapper.class);
        List<NinteichosahyoGaikyoChosaRelateEntity> entityList = mapper.getNinteichosahyoGaikyoChosa(parameter);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosahyoGaikyoChosaRelateBusiness>emptyList(), 0, false);
        }
        List<NinteichosahyoGaikyoChosaRelateBusiness> businessList = new ArrayList<>();
        for (NinteichosahyoGaikyoChosaRelateEntity chosaRelateEntity : entityList) {
            businessList.add(new NinteichosahyoGaikyoChosaRelateBusiness(chosaRelateEntity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 認定調査票（概況調査）に登録する。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 概況調査テキストイメージ区分 RString
     * @param 認定調査特記事項番号 RString
     * @param 認定調査特記事項連番 int
     * @param 特記事項テキスト_イメージ区分 RString
     * @param 原本マスク区分 Code
     * @param 概況調査 NinteichosahyoGaikyoChosaBuilder
     * @param 特記情報 NinteichosahyoTokkijiko
     * @param 概況特記 NinteichosahyoGaikyoChosa
     * @param 基本調査 NinteichosahyoKihonChosa
     * @param 要介護認定調査履歴番号 int
     * @param 連番 int
     * @param 調査項目 NinteichosahyoChosaItem
     * @param サービスの状況 NinteichosahyoServiceJokyo
     * @param サービスの状況フラグ NinteichosahyoServiceJokyoFlag
     * @param 記入項目 NinteichosahyoKinyuItem
     * @param 施設利用 NinteichosahyoShisetsuRiyo
     */
    @Transaction
    public void 認定調査一覧更新処理(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分,
            RString 認定調査特記事項番号,
            int 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分,
            NinteichosahyoTokkijiko 特記情報,
            NinteichosahyoGaikyoChosa 概況調査,
            GaikyoTokki 概況特記,
            NinteichosahyoKihonChosa 基本調査,
            int 要介護認定調査履歴番号,
            int 連番,
            NinteichosahyoChosaItem 調査項目,
            NinteichosahyoServiceJokyo サービスの状況,
            NinteichosahyoServiceJokyoFlag サービスの状況フラグ,
            NinteichosahyoKinyuItem 記入項目,
            NinteichosahyoShisetsuRiyo 施設利用
    ) {
        認定調査票概況調査(
                申請書管理番号,
                認定調査依頼履歴番号,
                概況調査テキストイメージ区分,
                概況調査);
        認定調査票概況特記(
                申請書管理番号,
                認定調査依頼履歴番号,
                概況調査テキストイメージ区分,
                概況特記);
        認定調査票特記情報(
                申請書管理番号,
                認定調査依頼履歴番号,
                認定調査特記事項番号,
                認定調査特記事項連番,
                特記事項テキスト_イメージ区分,
                原本マスク区分,
                特記情報);
        認定調査票基本調査(
                申請書管理番号,
                要介護認定調査履歴番号,
                基本調査);
        基本調査調査項目(
                申請書管理番号,
                要介護認定調査履歴番号,
                連番,
                調査項目);
        認定調査票概況調査サービスの状況(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番,
                サービスの状況);
        認定調査票概況調査サービスの状況フラグ(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番,
                サービスの状況フラグ);
        認定調査票概況調査記入項目(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番,
                記入項目);
        認定調査票概況調査施設利用(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番,
                施設利用);

    }

    /**
     * 認定調査票（概況調査）に登録する。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 概況調査テキストイメージ区分 RString
     * @param 概況調査 NinteichosahyoGaikyoChosaBuilder
     * @return 認定調査票概況調査のCOUNT
     */
    private boolean 認定調査票概況調査(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分,
            NinteichosahyoGaikyoChosa 概況調査) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage(概況調査テキストイメージ区分_Message.toString()));
        DbT5202NinteichosahyoGaikyoChosaEntity entity = dbT5202Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキストイメージ区分);
        if (!概況調査.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5202Dac.save(概況調査.toEntity());

        }
        return 1 == dbT5202Dac.save(概況調査.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（概況特記）を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 概況調査テキストイメージ区分 RString
     * @param 概況特記 GaikyoTokki
     * @return 認定調査票（概況特記）のCOUNT
     */
    private boolean 認定調査票概況特記(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキストイメージ区分,
            GaikyoTokki 概況特記) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(概況調査テキストイメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage(概況調査テキストイメージ区分_Message.toString()));
        DbT5206GaikyoTokkiEntity entity = dbT5206Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキストイメージ区分);
        if (!概況特記.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5206Dac.save(概況特記.toEntity());
        }
        return 1 == dbT5206Dac.save(概況特記.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（特記情報）を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 認定調査特記事項番号 RString
     * @param 認定調査特記事項連番 int
     * @param 特記事項テキスト_イメージ区分 RString
     * @param 原本マスク区分 Code
     * @param 特記情報 NinteichosahyoTokkijiko
     * @return 認定調査票（概況特記）のCOUNT
     */
    private boolean 認定調査票特記情報(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 認定調査特記事項番号,
            int 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分,
            NinteichosahyoTokkijiko 特記情報) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(認定調査特記事項番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項番号"));
        requireNonNull(認定調査特記事項連番, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項連番"));
        requireNonNull(特記事項テキスト_イメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項テキスト_イメージ区分"));
        DbT5205NinteichosahyoTokkijikoEntity entity = dbT5205Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号,
                認定調査特記事項番号, 認定調査特記事項連番, 特記事項テキスト_イメージ区分, 原本マスク区分);
        if (!特記情報.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5205Dac.save(特記情報.toEntity());
        }
        return 1 == dbT5205Dac.save(特記情報.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（基本調査）を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 要介護認定調査履歴番号 int
     * @param 基本調査 NinteichosahyoKihonChosa
     * @return 認定調査票（基本調査）のCOUNT
     */
    private boolean 認定調査票基本調査(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            NinteichosahyoKihonChosa 基本調査) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));

        DbT5203NinteichosahyoKihonChosaEntity entity = dbT5203Dac.selectByKey(申請書管理番号, 要介護認定調査履歴番号);
        if (!基本調査.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5203Dac.save(基本調査.toEntity());
        }
        return 1 == dbT5203Dac.save(基本調査.modifiedModel().toEntity());
    }

    /**
     * （基本調査）調査項目を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 要介護認定調査履歴番号 int
     * @param 連番 int
     * @param 調査項目 NinteichosahyoChosaItem
     * @return （基本調査）調査項目のCOUNT
     */
    private boolean 基本調査調査項目(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番,
            NinteichosahyoChosaItem 調査項目) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5211NinteichosahyoChosaItemEntity entity = dbT5211Dac.selectByKey(申請書管理番号, 要介護認定調査履歴番号, 連番);
        if (!調査項目.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5211Dac.save(調査項目.toEntity());
        }
        return 1 == dbT5211Dac.save(調査項目.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（概況調査）サービスの状況を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 連番 int
     * @param サービスの状況 NinteichosahyoServiceJokyo
     * @return 認定調査票（概況調査）サービスの状況のCOUNT
     */
    private boolean 認定調査票概況調査サービスの状況(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番,
            NinteichosahyoServiceJokyo サービスの状況) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        DbT5207NinteichosahyoServiceJokyoEntity entity = dbT5207Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 連番);

        if (!サービスの状況.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5207Dac.save(サービスの状況.toEntity());
        }
        return 1 == dbT5207Dac.save(サービスの状況.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（概況調査）サービスの状況フラグを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 連番 int
     * @param サービスの状況フラグ NinteichosahyoServiceJokyoFlag
     * @return 認定調査票（概況調査）サービスの状況のCOUNT
     */
    private boolean 認定調査票概況調査サービスの状況フラグ(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番,
            NinteichosahyoServiceJokyoFlag サービスの状況フラグ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5208NinteichosahyoServiceJokyoFlagEntity entity = dbT5208Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 連番);

        if (!サービスの状況フラグ.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5208Dac.save(サービスの状況フラグ.toEntity());
        }
        return 1 == dbT5208Dac.save(サービスの状況フラグ.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（概況調査）記入項目を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 連番 int
     * @param 記入項目 NinteichosahyoKinyuItem
     * @return 認定調査票（概況調査）記入項目のCOUNT
     */
    private boolean 認定調査票概況調査記入項目(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番,
            NinteichosahyoKinyuItem 記入項目) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        DbT5209NinteichosahyoKinyuItemEntity entity = dbT5209Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 連番);

        if (!記入項目.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5209Dac.save(記入項目.toEntity());
        }
        return 1 == dbT5209Dac.save(記入項目.modifiedModel().toEntity());
    }

    /**
     * 認定調査票（概況調査）施設利用を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * @param 連番 int
     * @param 施設利用 NinteichosahyoShisetsuRiyo
     * @return 認定調査票（概況調査）記入項目のCOUNT
     */
    private boolean 認定調査票概況調査施設利用(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番,
            NinteichosahyoShisetsuRiyo 施設利用) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(申請書管理番号_Message.toString()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(認定調査依頼履歴番号_Message.toString()));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        DbT5210NinteichosahyoShisetsuRiyoEntity entity = dbT5210Dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 連番);

        if (!施設利用.hasChanged()) {
            return false;
        }
        if (entity == null) {

            return 1 == dbT5210Dac.save(施設利用.toEntity());
        }
        return 1 == dbT5210Dac.save(施設利用.modifiedModel().toEntity());
    }
}
