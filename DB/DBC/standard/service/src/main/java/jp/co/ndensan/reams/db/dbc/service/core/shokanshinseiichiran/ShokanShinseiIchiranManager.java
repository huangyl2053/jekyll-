/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanshinseiichiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshinseiichiran.ShokanShinseiIchiran;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshinseiichiran.ShokanShinseiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshinseiichiran.ShokanShinseiIchiranParameterCount;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran.ShokanShinseiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshinseiichiran.ShokanShinseiIchiranMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払支給申請リストを取得するクラスです。
 *
 */
public class ShokanShinseiIchiranManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShokanShinseiIchiranManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShokanShinseiIchiranManager}のインスタンスを返します。
     *
     * @return // * {@link InstanceProvider#create}にて生成した{@link ShokanShinseiIchiranManager}のインスタンス
     */
    public static ShokanShinseiIchiranManager createInstance() {
        return InstanceProvider.create(ShokanShinseiIchiranManager.class);
    }

    /**
     * 償還払支給申請リスト取得(照会)を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @return 償還払支給申請リスト
     */
    public SearchResult<ShokanShinseiIchiran> getShokanShinseiListSyokai(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月From,
            FlexibleYearMonth サービス提供年月To) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        if ((サービス提供年月From == null || サービス提供年月From.isEmpty()) && (サービス提供年月To == null || サービス提供年月To.isEmpty())) {
            return SearchResult.of(Collections.<ShokanShinseiIchiran>emptyList(), 0, false);
        }
        ShokanShinseiIchiranMapper mapper = mapperProvider.create(ShokanShinseiIchiranMapper.class);
        List<ShokanShinseiIchiranRelateEntity> relateEntity = mapper.select償還払支給申請リスト照会(
                ShokanShinseiIchiranParameter.createSelectByKeyParam(
                        被保険者番号,
                        サービス提供年月From,
                        サービス提供年月To));
        if (relateEntity == null || relateEntity.isEmpty()) {
            return SearchResult.of(Collections.<ShokanShinseiIchiran>emptyList(), 0, false);
        }
        List<ShokanShinseiIchiran> shinseiIchiranList = new ArrayList<>();
        for (ShokanShinseiIchiranRelateEntity entity : relateEntity) {
            shinseiIchiranList.add(new ShokanShinseiIchiran(entity));
        }
        return SearchResult.of(shinseiIchiranList, 0, false);
    }

    /**
     * 償還払支給申請リスト取得 (申請)を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @return 償還払支給申請リスト
     */
    public SearchResult<ShokanShinseiIchiran> getShokanShinseiListShinsei(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月From, FlexibleYearMonth サービス提供年月To) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        if ((サービス提供年月From == null || サービス提供年月From.isEmpty()) && (サービス提供年月To == null || サービス提供年月To.isEmpty())) {
            return SearchResult.of(Collections.<ShokanShinseiIchiran>emptyList(), 0, false);
        }
        ShokanShinseiIchiranMapper mapper = mapperProvider.create(ShokanShinseiIchiranMapper.class);
        List<ShokanShinseiIchiranRelateEntity> relateEntity = mapper.select償還払支給申請リスト申請(ShokanShinseiIchiranParameter.createSelectByKeyParam(
                被保険者番号,
                サービス提供年月From,
                サービス提供年月To));
        if (relateEntity == null || relateEntity.isEmpty()) {
            return SearchResult.of(Collections.<ShokanShinseiIchiran>emptyList(), 0, false);
        }
        List<ShokanShinseiIchiran> shinseiIchiranList = new ArrayList<>();
        for (ShokanShinseiIchiranRelateEntity entity : relateEntity) {
            shinseiIchiranList.add(new ShokanShinseiIchiran(entity));
        }
        return SearchResult.of(shinseiIchiranList, 0, false);
    }

    /**
     * 償還払支給申請情報件数取得を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @return 償還払支給申請情報件数
     */
    public int getShokanShinseiCount(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス年月"));
        ShokanShinseiIchiranMapper mapper = mapperProvider.create(ShokanShinseiIchiranMapper.class);
        return mapper.select償還払支給申請情報件数取得(ShokanShinseiIchiranParameterCount.createSelectByKeyParam(被保険者番号, サービス年月));
    }
}
