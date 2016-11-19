/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.ShinsakaiChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.chosajisshishajoho.IChosaJisshishaJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 調査実施者情報の検索処理クラスです。
 *
 * @reamsid_L DBE-3000-100 dongyabin
 */
public class ChosaJisshishaJohoFinder {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5910NinteichosaItakusakiJohoDac dbT5910Dac;
    private final DbT5913ChosainJohoDac dbT5913Dac;
    private final DbT7051KoseiShichosonMasterDac dbT7051Dac;

    /**
     * コンストラクタです。
     */
    public ChosaJisshishaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5910Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.dbT5913Dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
        this.dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     * @param dbT5101Dac {@link DbT5101NinteiShinseiJohoDac}
     * @param dbT5101Dac {@link DbT5101NinteiShinseiJohoDac}
     * @param dbT5101Dac {@link DbT5101NinteiShinseiJohoDac}
     */
    ChosaJisshishaJohoFinder(MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac dbT5101Dac,
            DbT5910NinteichosaItakusakiJohoDac dbT5910Dac,
            DbT5913ChosainJohoDac dbT5913Dac,
            DbT7051KoseiShichosonMasterDac dbT7051Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5101Dac = dbT5101Dac;
        this.dbT5910Dac = dbT5910Dac;
        this.dbT5913Dac = dbT5913Dac;
        this.dbT7051Dac = dbT7051Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChosaJisshishaJohoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ChosaJisshishaJohoFinder}のインスタンス
     */
    public static ChosaJisshishaJohoFinder createInstance() {
        return InstanceProvider.create(ChosaJisshishaJohoFinder.class);
    }

    /**
     * 所属機関のデータソースを取得します。
     *
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
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteichosaItakusakiJoho>
     */
    public SearchResult<ChosainJoho> getKinyusha(RString shinseishoKanriNo) {
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        IChosaJisshishaJohoMapper mapper = mapperProvider.create(IChosaJisshishaJohoMapper.class);
        List<DbT5913ChosainJohoEntity> kinyushaList = mapper.getKinyusha(shinseishoKanriNo);
        for (DbT5913ChosainJohoEntity kinyusha : kinyushaList) {
            chosainJohoList.add(new ChosainJoho(kinyusha));
        }
        return SearchResult.of(chosainJohoList, 0, false);
    }

    /**
     * 所属機関のデータソースを取得します。
     *
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
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteiShinseiJoho>
     */
    public SearchResult<NinteiShinseiJoho> get調査区分(RString shinseishoKanriNo) {
        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        List<NinteiShinseiJoho> ninteiShinseiJohoList = new ArrayList<>();
        DbT5101NinteiShinseiJohoEntity kinyushaEmpty = dbT5101Dac.selectByKey(new ShinseishoKanriNo(shinseishoKanriNo));
        if (kinyushaEmpty != null) {
            ninteiShinseiJohoList.add(new NinteiShinseiJoho(kinyushaEmpty));
        }
        return SearchResult.of(ninteiShinseiJohoList, 0, false);
    }

    /**
     * 市町村コードを取得します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @return SearchResult<NinteiShinseiJoho>
     */
    public SearchResult<KoseiShichosonMaster> get市町村コード(RString shoKisaiHokenshaNo) {
        requireNonNull(shoKisaiHokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        List<KoseiShichosonMaster> koseiShichosonMasterList = new ArrayList<>();
        DbT7051KoseiShichosonMasterEntity koseiShichosonEntity = dbT7051Dac.shichosonCode(new ShoKisaiHokenshaNo(shoKisaiHokenshaNo));
        if (koseiShichosonEntity != null) {
            koseiShichosonMasterList.add(new KoseiShichosonMaster(koseiShichosonEntity));
        }
        return SearchResult.of(koseiShichosonMasterList, 0, false);
    }

    /**
     * 認定申請日を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return SearchResult<NinteiShinseiJoho>
     */
    public SearchResult<NinteiShinseiJoho> get認定申請情報(RString shinseishoKanriNo) {
        requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        List<NinteiShinseiJoho> ninteiShinseiJohoList = new ArrayList<>();
        DbT5101NinteiShinseiJohoEntity ninteiShinseiJohoEntity = dbT5101Dac.selectByKey(new ShinseishoKanriNo(shinseishoKanriNo));
        if (ninteiShinseiJohoEntity != null) {
            ninteiShinseiJohoList.add(new NinteiShinseiJoho(ninteiShinseiJohoEntity));
        }
        return SearchResult.of(ninteiShinseiJohoList, 0, false);
    }

    /**
     * 所属機関コードtxtのロストフォーカス時の検索します。
     *
     * @param 市町村コード 市町村コード
     * @param 所属機関コード 所属機関コード
     * @return NinteichosaItakusakiJoho 認定調査委託先情報を管理するクラス
     */
    @Transaction
    public NinteichosaItakusakiJoho onBlurTxtShozokuKikanCode(LasdecCode 市町村コード, RString 所属機関コード) {
        DbT5910NinteichosaItakusakiJohoEntity dbT5910Entity = dbT5910Dac.selectByKey(市町村コード, 所属機関コード);
        if (dbT5910Entity != null && dbT5910Entity.getJokyoFlag()) {
            return new NinteichosaItakusakiJoho(dbT5910Entity);
        }
        return null;
    }

    /**
     * 記入者コードtxtのロストフォーカス時の検索します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return ShinsakaiChosainJoho 調査員情報のビジネスクラス
     */
    @Transaction
    public ShinsakaiChosainJoho onBlurTxtKinyushaCode(LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {
        DbT5913ChosainJohoEntity dbT5913Entity = dbT5913Dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード);
        if (dbT5913Entity != null && dbT5913Entity.getJokyoFlag()) {
            return new ShinsakaiChosainJoho(dbT5913Entity);
        }
        return null;
    }
}
