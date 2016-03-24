/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteirirekiichiran.NinteiRirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbz.definition.param.ninteirirekiichiran.NinteiRirekiIchiranParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteirirekiichiran.INinteiRirekiIchiranMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 受給者台帳情報クラスです。
 */
public class NinteiRirekiIchiran {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiRirekiIchiran() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    NinteiRirekiIchiran(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiRirekiIchiran}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiRirekiIchiran}のインスタンス
     */
    public static NinteiRirekiIchiran createInstance() {
        return InstanceProvider.create(NinteiRirekiIchiran.class);
    }

    /**
     * 受給者台帳情報を検索します。
     *
     * @param parametere NinteiRirekiIchiranParameter
     * @return 受給者台帳情報リスト
     */
    @Transaction
    public SearchResult<NinteiRirekiIchiranBusiness> getJyukyuuSyaDaiTyouJyoho(NinteiRirekiIchiranParameter parametere) {
        List<NinteiRirekiIchiranBusiness> ninteiRirekiList = new ArrayList();
        INinteiRirekiIchiranMapper mapper = mapperProvider.create(INinteiRirekiIchiranMapper.class);
        if (parametere.getHihokenshaNo() != null && !parametere.getHihokenshaNo().isEmpty()) {
            List<DbT4001JukyushaDaichoEntity> 受給者台帳情報リスト = mapper.getJyukyuuSyaDaiTyouJyoho(parametere);
            if (受給者台帳情報リスト != null && !受給者台帳情報リスト.isEmpty()) {
                for (DbT4001JukyushaDaichoEntity entity : 受給者台帳情報リスト) {
                    ninteiRirekiList.add(new NinteiRirekiIchiranBusiness(entity));
                }
                return SearchResult.of(ninteiRirekiList, 0, false);
            }
        }
        return SearchResult.of(Collections.<NinteiRirekiIchiranBusiness>emptyList(), 0, false);
    }
}
