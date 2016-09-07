/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.chosaocrtorikomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.chosaocrtorikomi.ChosaOCRTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosaocrtorikomi.ChosaOCRTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosaocrtorikomi.ChosaOCRTorikomiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosaocrtorikomi.IChosaOCRTorikomiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会審査結果登録（OCR)クラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
public class ChosaOCRTorikomiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ChosaOCRTorikomiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ChosaOCRTorikomiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaOCRTorikomiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaOCRTorikomiFinder}のインスタンス
     */
    public static ChosaOCRTorikomiFinder createInstance() {
        return InstanceProvider.create(ChosaOCRTorikomiFinder.class);
    }

    /**
     * 検索条件に従い、審査結果登録情報を検索します。
     *
     * @param parameter 審査結果登録検索条件
     * @return ShujiiMaster 審査結果情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ChosaOCRTorikomiBusiness> getChosaOCRTorikomi(ChosaOCRTorikomiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        IChosaOCRTorikomiMapper mapper = mapperProvider.create(IChosaOCRTorikomiMapper.class);
        List<ChosaOCRTorikomiRelateEntity> relateEntityList = mapper.selectChosaOCRTorikomi(parameter);
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ChosaOCRTorikomiBusiness>emptyList(), 0, false);
        }
        List<ChosaOCRTorikomiBusiness> 審査結果情報List = new ArrayList<>();
        for (ChosaOCRTorikomiRelateEntity entity : relateEntityList) {
            審査結果情報List.add(new ChosaOCRTorikomiBusiness(entity));
        }
        return SearchResult.of(審査結果情報List, 0, false);
    }

    /**
     * 検索条件に従い、審査結果登録情報を検索します。
     *
     * @param parameter 審査結果登録検索条件
     * @return ShujiiMaster 審査結果情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ChosaOCRTorikomiBusiness> getChosahyoTorikomiKekka(ChosaOCRTorikomiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        IChosaOCRTorikomiMapper mapper = mapperProvider.create(IChosaOCRTorikomiMapper.class);
        List<ChosaOCRTorikomiRelateEntity> relateEntityList = mapper.selectChosahyoTorikomiKekka(parameter);
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ChosaOCRTorikomiBusiness>emptyList(), 0, false);
        }
        List<ChosaOCRTorikomiBusiness> 審査結果情報List = new ArrayList<>();
        for (ChosaOCRTorikomiRelateEntity entity : relateEntityList) {
            審査結果情報List.add(new ChosaOCRTorikomiBusiness(entity));
        }
        return SearchResult.of(審査結果情報List, 0, false);
    }

    /**
     * 検索条件に従い、申請書管理番号を検索します。
     *
     * @param parameter 審査結果登録検索条件
     * @return RString 申請書管理番号 nullが返る可能性があります。
     */
    @Transaction
    public List<RString> getShinseishoKanriNo(ChosaOCRTorikomiParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        IChosaOCRTorikomiMapper mapper = mapperProvider.create(IChosaOCRTorikomiMapper.class);
        return mapper.selectShinseishoKanriNo(parameter);
    }
}
