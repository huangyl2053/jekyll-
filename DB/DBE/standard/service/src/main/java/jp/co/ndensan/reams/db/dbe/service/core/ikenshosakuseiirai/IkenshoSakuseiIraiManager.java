/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshosakuseiirai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudou;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.ShujiiIkenshoTeishutsuIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.ninteishinseijoho.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.IkenshoirairirekiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudouEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.ShujiiIkenshoTeishutsuIraishoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshosakuseiirai.IIkenshoSakuseiIraiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼(手動)を管理するクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIraiManager {

    private final MapperProvider mapperProvider;
    private final NinteiShinseiJohoManager 要介護認定申請情報Manager;
    private final DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private final DbT5301ShujiiIkenshoIraiJohoDac 主治医意見書作成依頼情報Dac;
    private static final int ZERO = 0;
    private static final RString 定数_申請書管理番号 = new RString("申請書管理番号");

    /**
     * コンストラクタです。
     */
    IkenshoSakuseiIraiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        要介護認定申請情報Manager = NinteiShinseiJohoManager.createInstance();
        要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        主治医意見書作成依頼情報Dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IkenshoSakuseiIraiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link IkenshoSakuseiIraiManager}のインスタンス
     */
    public static IkenshoSakuseiIraiManager createInstance() {
        return InstanceProvider.create(IkenshoSakuseiIraiManager.class);
    }

    /**
     * 主治医意見書作成依頼(手動)情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼(手動)情報
     */
    @Transaction
    public IkenshoirairirekiichiranShudou get主治医意見書作成依頼(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_申請書管理番号.toString()));
        IIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IIkenshoSakuseiIraiMapper.class);

        IkenshoirairirekiichiranShudouEntity entity = mapper.get主治医意見書作成依頼(申請書管理番号);
        if (entity == null) {
            return null;
        }
        return new IkenshoirairirekiichiranShudou(entity);
    }

    /**
     * 主治医意見書作成依頼発行一覧表情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 主治医意見書作成依頼発行一覧表情報
     */
    @Transaction
    public SearchResult<IkenshoirairirekiichiranShudou> get主治医意見書作成依頼発行一覧表(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_申請書管理番号.toString()));
        IIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IIkenshoSakuseiIraiMapper.class);

        List<IkenshoirairirekiichiranShudouEntity> entityList = mapper.get主治医意見書作成依頼発行一覧表(申請書管理番号);
        if (entityList == null) {
            return SearchResult.of(Collections.EMPTY_LIST, ZERO, false);
        }
        List<IkenshoirairirekiichiranShudou> businessList = new ArrayList<>();
        for (IkenshoirairirekiichiranShudouEntity entity : entityList) {
            businessList.add(new IkenshoirairirekiichiranShudou(entity));
        }
        return SearchResult.of(businessList, ZERO, false);
    }

    /**
     * 要介護認定申請情報{@link NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 要介護認定申請情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteiShinseiJoho 要介護認定申請情報) {
        DbT5301ShujiiIkenshoIraiJohoEntity 主治医意見書作成依頼情報
                = 要介護認定申請情報.getshujiiIkenshoIraiJohoList().get(ZERO).toEntity();
        if (主治医意見書作成依頼情報.getState() != EntityDataState.Modified) {
            主治医意見書作成依頼情報.setState(EntityDataState.Added);
            主治医意見書作成依頼情報Dac.save(主治医意見書作成依頼情報);
            要介護認定申請情報Dac.save(要介護認定申請情報.toEntity());
        }
        return 要介護認定申請情報Manager.save(要介護認定申請情報);
    }

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報
     */
    @Transaction
    public NinteiShinseiJoho get要介護認定申請情報(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_申請書管理番号.toString()));
        IIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IIkenshoSakuseiIraiMapper.class);

        NinteiShinseiJohoEntity entity = mapper.get要介護認定申請情報(申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5ToEntities();
        return new NinteiShinseiJoho(entity);
    }

    /**
     * 介護保険指定医依頼兼主治医意見書提出意見書情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 介護保険指定医依頼兼主治医意見書提出意見書情報
     */
    @Transaction
    public SearchResult<ShujiiIkenshoTeishutsuIraishoBusiness> get介護保険指定医依頼兼主治医意見書提出意見書(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_申請書管理番号.toString()));
        IIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IIkenshoSakuseiIraiMapper.class);

        List<ShujiiIkenshoTeishutsuIraishoEntity> entityList = mapper.get介護保険指定医依頼兼主治医意見書提出意見書(申請書管理番号);
        if (entityList == null) {
            return SearchResult.of(Collections.EMPTY_LIST, ZERO, false);
        }
        List<ShujiiIkenshoTeishutsuIraishoBusiness> businessList = new ArrayList<>();
        for (ShujiiIkenshoTeishutsuIraishoEntity entity : entityList) {
            businessList.add(new ShujiiIkenshoTeishutsuIraishoBusiness(entity));
        }
        return SearchResult.of(businessList, ZERO, false);
    }

    /**
     * 主治医意見書依頼該当者履歴一覧情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 主治医意見書依頼該当者履歴一覧情報
     */
    @Transaction
    public SearchResult<IkenshoirairirekiIchiran> get主治医意見書依頼該当者履歴一覧(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        IIkenshoSakuseiIraiMapper mapper = mapperProvider.create(IIkenshoSakuseiIraiMapper.class);

        List<IkenshoirairirekiIchiranEntity> entityList = mapper.get主治医意見書依頼該当者履歴一覧(被保険者番号);
        if (entityList == null) {
            return SearchResult.of(Collections.EMPTY_LIST, ZERO, false);
        }
        List<IkenshoirairirekiIchiran> businessList = new ArrayList<>();
        for (IkenshoirairirekiIchiranEntity entity : entityList) {
            businessList.add(new IkenshoirairirekiIchiran(entity));
        }
        return SearchResult.of(businessList, ZERO, false);
    }

    /**
     * 主治医意見書作成依頼情報を保存します。
     *
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save主治医意見書作成依頼情報(ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報) {
        requireNonNull(主治医意見書作成依頼情報, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼情報"));
        return 1 == 主治医意見書作成依頼情報Dac.save(主治医意見書作成依頼情報.toEntity());
    }
}
