/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chosaJisshishaJoho.ChosaJisshishaMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.chosajisshishajoho.IChosaJisshishaJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 調査実施者情報の検索処理クラスです。
 * @reamsid_L DBE-3000-100 dongyabin
 */
public class ChosaJisshishaJohoFinder {
    
    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ChosaJisshishaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }
    
    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     * @param dac {@link DbT5101NinteiShinseiJohoDac}
     */
    ChosaJisshishaJohoFinder(MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaJisshishaJohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChosaJisshishaJohoFinder}のインスタンス
     */
    public static ChosaJisshishaJohoFinder createInstance() {
        return InstanceProvider.create(ChosaJisshishaJohoFinder.class);
    }
    
    /**
     * 所属機関のデータソースを取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<NinteichosaItakusakiJoho> getSyozokuKikan(RString shinseishoKanriNo) {
        List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        List<DbT5910NinteichosaItakusakiJohoEntity> syozokuKikanList = mapper.getSyozokuKikan(shinseishoKanriNo);
        for (DbT5910NinteichosaItakusakiJohoEntity syozokuKikan : syozokuKikanList) {
            ninteichosaItakusakiJohoList.add(new NinteichosaItakusakiJoho(syozokuKikan));
        }
        return SearchResult.of(ninteichosaItakusakiJohoList, 0, false);
    }
    
    /**
     * 記入者の初期値を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @param ninteiChosaItakusakiCode 調査委託先コード
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<ChosainJoho> getKinyusha(RString shinseishoKanriNo, RString ninteiChosaItakusakiCode) {
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        ChosaJisshishaMapperParameter paramer = new ChosaJisshishaMapperParameter();
        paramer.setShinseishoKanriNo(shinseishoKanriNo);
        paramer.setNinteiChosaItakusakiCode(ninteiChosaItakusakiCode);
        List<DbT5913ChosainJohoEntity> kinyushaList = mapper.getKinyusha(paramer);
        for (DbT5913ChosainJohoEntity kinyusha : kinyushaList) {
            chosainJohoList.add(new ChosainJoho(kinyusha));
        }
        return SearchResult.of(chosainJohoList, 0, false);
    }
    
    /**
     * 所属機関のデータソースを取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<ChosainJoho> getKinyushaEmpty(RString shinseishoKanriNo) {
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        List<DbT5913ChosainJohoEntity> kinyushaEmptyList = mapper.getKinyushaEmpty(shinseishoKanriNo);
        for (DbT5913ChosainJohoEntity kinyushaEmpty : kinyushaEmptyList) {
            chosainJohoList.add(new ChosainJoho(kinyushaEmpty));
        }
        return SearchResult.of(chosainJohoList, 0, false);
    }
    
    /**
     * 調査区分を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteiShinseiJoho>
     */
    public SearchResult<NinteiShinseiJoho> get調査区分(RString shinseishoKanriNo) {
        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        List<NinteiShinseiJoho> ninteiShinseiJohoList = new ArrayList<>();
        DbT5101NinteiShinseiJohoEntity kinyushaEmpty = dac.selectByKey(new ShinseishoKanriNo(shinseishoKanriNo));
        if (kinyushaEmpty != null) {
            ninteiShinseiJohoList.add(new NinteiShinseiJoho(kinyushaEmpty));
        }
        return SearchResult.of(ninteiShinseiJohoList, 0, false);
    }
}
