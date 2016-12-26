/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.hanteikekkajouhoushuturyoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajouhoushuturyoku.IHanteiKekkaJouhouShuturyokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 判定結果情報出力（保険者）クラスです。
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public class HanteiKekkaJouhouShuturyokuFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    HanteiKekkaJouhouShuturyokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    HanteiKekkaJouhouShuturyokuFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HanteiKekkaJouhouShuturyokuFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HanteiKekkaJouhouShuturyokuFinder}のインスタンス
     */
    public static HanteiKekkaJouhouShuturyokuFinder createInstance() {
        return InstanceProvider.create(HanteiKekkaJouhouShuturyokuFinder.class);
    }

    /**
     * パラメータ．モード：2(スケジュール照会)の場合、画面の検索条件より、判定結果情報出力（保険者）を検索する。
     *
     * @param parametere HanteiKekkaJouhouShuturyokuParameter
     * @return 判定結果情報出力リスト
     */
    @Transaction
    public SearchResult<HanteiKekkaJouhouShuturyokuBusiness> getHanteiKekka(HanteiKekkaJouhouShuturyokuParameter parametere) {
        List<HanteiKekkaJouhouShuturyokuBusiness> kojinJokyoShokaiList = new ArrayList();
        IHanteiKekkaJouhouShuturyokuMapper mapper = mapperProvider.create(IHanteiKekkaJouhouShuturyokuMapper.class);
        List<HanteiKekkaJouhouShuturyokuRelateEntity> 判定結果情報出力リスト = mapper.getNinteiChousaSukeList(parametere);
        if (判定結果情報出力リスト == null || 判定結果情報出力リスト.isEmpty()) {
            return SearchResult.of(Collections.<HanteiKekkaJouhouShuturyokuBusiness>emptyList(), 0, false);
        }
        int totalCount;
        if (判定結果情報出力リスト.size() < parametere.getLimitCount()) {
            totalCount = 判定結果情報出力リスト.size();
        } else {
            totalCount = mapper.countNinteiChousaSukeList(parametere);
        }
        for (HanteiKekkaJouhouShuturyokuRelateEntity entity : 判定結果情報出力リスト) {
            kojinJokyoShokaiList.add(new HanteiKekkaJouhouShuturyokuBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, totalCount, (parametere.getLimitCount() < totalCount));
    }

}
