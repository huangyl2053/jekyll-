/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.koikinaitenkyojoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkan;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koikinaitenkyojoho.IKoikinaiTenkyoRirekiHenkanMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBE1720001_広域内転居Finderクラスです
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
public class KoikinaiTenkyoRirekiHenkanFinder {

    private final DbT7051KoseiShichosonMasterDac dac;
    private final DbT5121ShinseiRirekiJohoDac dacDbT5121;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KoikinaiTenkyoRirekiHenkanFinder() {
        this.dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.dacDbT5121 = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    KoikinaiTenkyoRirekiHenkanFinder(DbT7051KoseiShichosonMasterDac dac, DbT5121ShinseiRirekiJohoDac dacDbT5121, MapperProvider mapperProvider) {
        this.dac = dac;
        this.dacDbT5121 = dacDbT5121;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoikinaiTenkyoRirekiHenkanFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoikinaiTenkyoRirekiHenkanFinder}のインスタンス
     */
    public static KoikinaiTenkyoRirekiHenkanFinder createInstance() {
        return InstanceProvider.create(KoikinaiTenkyoRirekiHenkanFinder.class);
    }

    /**
     * 検索条件より、適当な条件を連結して、申請者一覧情報を検索する
     *
     * @param 検索条件 KoikinaiTenkyoRirekiHenkanMapperParameter
     * @return ResponseData<KoikinaiTenkyoRirekiHenkanDiv>
     */
    public SearchResult<KoikinaiTenkyoRirekiHenkan> getKoikinaiTenkyoList(KoikinaiTenkyoRirekiHenkanMapperParameter 検索条件) {
        requireNonNull(検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("検索条件"));
        IKoikinaiTenkyoRirekiHenkanMapper mapper = mapperProvider.create(IKoikinaiTenkyoRirekiHenkanMapper.class);
        List<KoikinaiTenkyoRirekiHenkanRelateEntity> relateEntity = mapper.selectKoikinaiTenkyoList(検索条件);
        if (relateEntity.isEmpty()) {
            return SearchResult.of(Collections.<KoikinaiTenkyoRirekiHenkan>emptyList(), 0, false);
        }
        List<KoikinaiTenkyoRirekiHenkan> 申請者一覧情報List = new ArrayList<>();
        for (KoikinaiTenkyoRirekiHenkanRelateEntity entity : relateEntity) {
            AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
            申請者一覧情報List.add(new KoikinaiTenkyoRirekiHenkan(entity));
        }
        return SearchResult.of(申請者一覧情報List, 0, false);
    }

    /**
     * DbT5101NinteiShinseiJoho更新使用のデータを検索する
     *
     * @param 検索条件 KoikinaiTenkyoRirekiHenkanMapperParameter
     * @return ResponseData<KoikinaiTenkyoRirekiHenkanDiv>
     */
    public SearchResult<NinteiShinseiJoho> getUpdateDataList(KoikinaiTenkyoRirekiHenkanMapperParameter 検索条件) {
        requireNonNull(検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("検索条件"));
        IKoikinaiTenkyoRirekiHenkanMapper mapper = mapperProvider.create(IKoikinaiTenkyoRirekiHenkanMapper.class);
        List<DbT5101NinteiShinseiJohoEntity> relateEntity = mapper.selectKoikinaiTenkyoListUpdate(検索条件);
        if (relateEntity.isEmpty()) {
            return SearchResult.of(Collections.<KoikinaiTenkyoRirekiHenkan>emptyList(), 0, false);
        }
        List<NinteiShinseiJoho> updateDataList = new ArrayList<>();

        for (DbT5101NinteiShinseiJohoEntity entity : relateEntity) {
            entity.initializeMd5();
            updateDataList.add(new NinteiShinseiJoho(entity));
        }
        return SearchResult.of(updateDataList, 0, false);
    }

    private PersonalData toPersonalData(KoikinaiTenkyoRirekiHenkanRelateEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                entity.getShinseishoKanriNo().value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * 検索条件より、適当な条件を連結して、申請者一覧情報を検索する
     *
     * @return SearchResult<KeyValueDataSource>
     */
    public SearchResult<KeyValueDataSource> creatListFromDbT7051() {
        List<DbT7051KoseiShichosonMasterEntity> entitylist = dac.select市町村名称();
        List<KeyValueDataSource> list = new ArrayList<>();
        if (entitylist.isEmpty()) {
            return SearchResult.of(Collections.<KeyValueDataSource>emptyList(), 0, false);
        }
        for (int index = 0; index < entitylist.size(); index++) {
            if (!entitylist.get(index).getShoKisaiHokenshaNo().isEmpty()) {
                KeyValueDataSource keyvaule = new KeyValueDataSource();
                RString key = entitylist.get(index).getShoKisaiHokenshaNo().value();
                RString value = entitylist.get(index).getShichosonMeisho();
                keyvaule.setKey(key);
                RStringBuilder rstBuilder = new RStringBuilder();
                rstBuilder.append(key);
                rstBuilder.append(RString.HALF_SPACE);
                rstBuilder.append(value);
                keyvaule.setValue(rstBuilder.toRString());
                list.add(keyvaule);
            }
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 前回申請管理番号を取得する
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return ShinseishoKanriNo
     */
    public ShinseishoKanriNo getZenkaiShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        DbT5121ShinseiRirekiJohoEntity entity = dacDbT5121.selectByKey(shinseishoKanriNo);
        if (entity == null) {
            return null;
        }
        ShinseiRirekiJoho shinseirireki = new ShinseiRirekiJoho(entity);
        return shinseirireki.get前回申請管理番号();
    }
}
