/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.HihokenshaJyuhouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinnteiRiriBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.ShinseiIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoBatchMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeiParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.HihokenshaJyuhouRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinnteiRiriRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteichosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.ShinseiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定情報提供を管理するクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyoFinder {

    private final MapperProvider mapperProvider;
    private final RString 支所 = new RString("shishoKengen");

    /**
     * コンストラクタです。
     *
     */
    YokaigoNinteiJohoTeikyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    YokaigoNinteiJohoTeikyoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiJohoTeikyoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiJohoTeikyoFinder}のインスタンス
     */
    public static YokaigoNinteiJohoTeikyoFinder createInstance() {
        return InstanceProvider.create(YokaigoNinteiJohoTeikyoFinder.class);
    }

    /**
     * 被保険者情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 被保険者情報
     */
    @Transaction
    public HihokenshaJyuhouBusiness select被保険者情報(RString shinseishoKanriNo) {
        IYokaigoNinteiJohoTeikyoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoMapper.class);
        HihokenshaJyuhouRelateEntity entityList
                = mapper.get被保険者情報(YokaigoNinteiJohoTeiParameter.createParameter(shinseishoKanriNo, RString.EMPTY, RString.EMPTY, false));
        if (entityList == null) {
            return null;
        }
        return new HihokenshaJyuhouBusiness(entityList);
    }

    /**
     * 申請書管理番号を元に要介護認定情報提供を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定情報提供データ
     */
    @Transaction
    public YokaigoNinteiJohoTeikyoBusiness get要介護認定情報提供(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        IYokaigoNinteiJohoTeikyoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoMapper.class);
        List<YokaigoNinteiJohoTeikyoEntity> entityList = mapper.get要介護認定申請者(paramter);
        if (entityList.isEmpty()) {
            return null;
        }
        return new YokaigoNinteiJohoTeikyoBusiness(entityList.get(0));
    }

    @Transaction
    public YokaigoNinteiJohoTeikyoEntity get要介護認定申請者(YokaigoBatchMybitisParamter paramter) {
        IYokaigoNinteiJohoTeikyoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoMapper.class);
        List<YokaigoNinteiJohoTeikyoEntity> entityList = mapper.get要介護認定申請者(paramter);
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.get(0);
    }

    /**
     * 申請書管理番号を元に認定履歴情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 認定履歴データ
     */
    @Transaction
    public NinnteiRiriBusiness select認定履歴(ShinseishoKanriNo shinseishoKanriNo) {
        IYokaigoNinteiJohoTeikyoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoMapper.class);
        NinnteiRiriRelateEntity entity = mapper.get認定履歴(shinseishoKanriNo);
        if (entity == null) {
            return null;
        }
        return new NinnteiRiriBusiness(entity);
    }

    /**
     * 申請書管理番号を元に認定履歴情報を取得します。
     *
     * @param paramter YokaigoBatchMybitisParamter
     * @return 申請一覧
     */
    @Transaction
    public SearchResult<ShinseiIchiran> get申請一覧(YokaigoNinteiJohoTeikyoIkkatsuHakkoParameter paramter) {
        IYokaigoNinteiJohoTeikyoIkkatsuHakkoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoIkkatsuHakkoMapper.class);
        int 該当件数 = mapper.select申請一覧件数(paramter);
        List<ShinseiIchiran> 申請一覧 = new ArrayList<>();
        if (該当件数 == 0) {
            return SearchResult.of(申請一覧, 該当件数, false);
        }
        List<ShinseiIchiranEntity> entityList = mapper.select申請一覧(paramter);
        for (ShinseiIchiranEntity entity : entityList) {
            申請一覧.add(new ShinseiIchiran(entity));
        }
        return SearchResult.of(申請一覧, 該当件数, 該当件数 > 申請一覧.size());
    }

    /**
     * メージ共有ファイルIDを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return メージ共有ファイルID
     */
    @Transaction
    public RDateTime getイメージ共有ファイルID(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        return mapper.getイメージ(paramter);
    }

    /**
     * 特記事項のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 特記事項マスキング区分 特記事項マスキング区分
     * @return 特記事項のリスト
     */
    @Transaction
    public List<NinteichosaRelate> get特記事項List(ShinseishoKanriNo 申請書管理番号, RString 特記事項マスキング区分) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号.value(), 特記事項マスキング区分);
        List<NinteichosaRelateEntity> entityList = mapper.get特記事項リスト(paramter);
        List<NinteichosaRelate> 特記事項List = new ArrayList<>();
        for (NinteichosaRelateEntity entity : entityList) {
            特記事項List.add(new NinteichosaRelate(entity));
        }
        return 特記事項List;
    }

    /**
     * 認定調査特記事項番号のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 認定調査特記事項番号のリスト
     */
    @Transaction
    public List<RString> get認定調査特記事項番号(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        return mapper.get認定調査特記事項番号(paramter);
    }

    /**
     * 認定調査特記事項番号のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 認定調査特記事項番号のリスト
     */
    @Transaction
    public List<NinteichosahyoServiceJokyo> get認定調査票サービス状況(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5207NinteichosahyoServiceJokyoEntity> entityList = mapper.get認定調査票サービス状況(paramter);
        List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List = new ArrayList<>();
        for (DbT5207NinteichosahyoServiceJokyoEntity entity : entityList) {
            認定調査票サービス状況List.add(new NinteichosahyoServiceJokyo(entity));
        }
        return 認定調査票サービス状況List;
    }

    /**
     * 認定調査票サービス状況フラグのリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 認定調査票サービス状況フラグのリスト
     */
    @Transaction
    public List<NinteichosahyoServiceJokyoFlag> get認定調査票サービス状況フラグ(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5208NinteichosahyoServiceJokyoFlagEntity> entityList = mapper.get認定調査票フラグ(paramter);
        List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList = new ArrayList<>();
        for (DbT5208NinteichosahyoServiceJokyoFlagEntity entity : entityList) {
            認定調査票サービス状況フラグList.add(new NinteichosahyoServiceJokyoFlag(entity));
        }
        return 認定調査票サービス状況フラグList;
    }

    /**
     * 認定調査票調査項目のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 認定調査票調査項目のリスト
     */
    @Transaction
    public List<NinteichosahyoChosaItem> get認定調査票調査項目List(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5211NinteichosahyoChosaItemEntity> entityList = mapper.get認定調査票調査項目(paramter);
        List<NinteichosahyoChosaItem> 認定調査票調査項目List = new ArrayList<>();
        for (DbT5211NinteichosahyoChosaItemEntity entity : entityList) {
            認定調査票調査項目List.add(new NinteichosahyoChosaItem(entity));
        }
        return 認定調査票調査項目List;
    }

    /**
     * 前回認定調査票調査項目のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 前回認定調査票調査項目のリスト
     */
    @Transaction
    public List<NinteichosahyoChosaItem> get前回認定調査票調査項目List(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5211NinteichosahyoChosaItemEntity> entityList = mapper.get前回認定調査票調査項目(paramter);
        List<NinteichosahyoChosaItem> 前回認定調査票調査項目List = new ArrayList<>();
        for (DbT5211NinteichosahyoChosaItemEntity entity : entityList) {
            前回認定調査票調査項目List.add(new NinteichosahyoChosaItem(entity));
        }
        return 前回認定調査票調査項目List;
    }

    /**
     * 主治医意見書意見項目のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 主治医意見書意見項目のリスト
     */
    @Transaction
    public List<ShujiiIkenshoIkenItem> get主治医意見書意見項目List(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5304ShujiiIkenshoIkenItemEntity> entityList = mapper.get主治医意見書意見項目(paramter);
        List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List = new ArrayList<>();
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : entityList) {
            主治医意見書意見項目List.add(new ShujiiIkenshoIkenItem(entity));
        }
        return 主治医意見書意見項目List;
    }

    /**
     * 前回主治医意見書意見項目のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 前回主治医意見書意見項目のリスト
     */
    @Transaction
    public List<ShujiiIkenshoIkenItem> get前回主治医意見書意見項目List(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5304ShujiiIkenshoIkenItemEntity> entityList = mapper.get前回主治医意見書意見項目(paramter);
        List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List = new ArrayList<>();
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : entityList) {
            前回主治医意見書意見項目List.add(new ShujiiIkenshoIkenItem(entity));
        }
        return 前回主治医意見書意見項目List;
    }

    /**
     * 認定調査票記入項目のリストを取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 認定調査票記入項目のリスト
     */
    @Transaction
    public List<NinteichosahyoKinyuItem> get認定調査票記入項目List(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5209NinteichosahyoKinyuItemEntity> entityList = mapper.get認定調査票記入項目(paramter);
        List<NinteichosahyoKinyuItem> 認定調査票記入項目List = new ArrayList<>();
        for (DbT5209NinteichosahyoKinyuItemEntity entity : entityList) {
            認定調査票記入項目List.add(new NinteichosahyoKinyuItem(entity));
        }
        return 認定調査票記入項目List;
    }

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 要介護認定申請情報
     */
    @Transaction
    public NinteiShinseiJoho get要介護認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5101NinteiShinseiJohoEntity> entityList = mapper.get要介護認定申請情報(paramter);
        if (entityList.isEmpty()) {
            return null;
        }
        DbT5101NinteiShinseiJohoEntity entity = entityList.get(0);
        entity.initializeMd5();
        return new NinteiShinseiJoho(entity);
    }

    /**
     * 一次判定結果情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 一次判定結果情報
     */
    @Transaction
    public IchijiHanteiKekkaJoho get一次判定結果情報(ShinseishoKanriNo 申請書管理番号) {
        IYokaigoNinteiJohoTeikyoMapper mapper = InstanceProvider.create(MapperProvider.class).create(IYokaigoNinteiJohoTeikyoMapper.class);
        YokaigoBatchMybitisParamter paramter = YokaigoBatchMybitisParamter.createParam(申請書管理番号);
        List<DbT5116IchijiHanteiKekkaJohoEntity> entityList = mapper.select一次判定結果情報(paramter);
        if (entityList.isEmpty()) {
            return null;
        }
        DbT5116IchijiHanteiKekkaJohoEntity entity = entityList.get(0);
        entity.initializeMd5();
        return new IchijiHanteiKekkaJoho(entity);
    }
}
