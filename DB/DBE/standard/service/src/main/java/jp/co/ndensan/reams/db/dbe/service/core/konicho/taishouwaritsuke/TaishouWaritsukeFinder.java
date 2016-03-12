/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.konicho.taishouwaritsuke;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.KohoshaIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.TaishouWaritsukeHead;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.Taishouichiran;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.CountShinsakaiIinJogaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.CountShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.KohoshaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.TaishouIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.KohoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.TaishouIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.TaishouWaritsukeHeadEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.taishouwaritsuke.ITaishouWaritsukeMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定審査会対象者割付検索用クラスです。
 */
public class TaishouWaritsukeFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TaishouWaritsukeFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです。
     *
     * @return TaishouWaritsukeFinder
     */
    public static TaishouWaritsukeFinder createInstance() {
        return InstanceProvider.create(TaishouWaritsukeFinder.class);

    }

    /**
     * 介護認定審査会対象者割付ヘッドエリア内容検索
     *
     * @param kaisaiNo 開催番号
     * @return ヘッドエリア
     */
    public TaishouWaritsukeHead getヘッドエリア(RString kaisaiNo) {
        ITaishouWaritsukeMapper mapper = mapperProvider.create(ITaishouWaritsukeMapper.class);
        List<TaishouWaritsukeHeadEntity> list = mapper.getTaishouWaritsukeHead(kaisaiNo);
        if (!list.isEmpty()) {
            return new TaishouWaritsukeHead(list.get(0));
        } else {
            return null;
        }
    }

    /**
     * 介護認定審査会対象者対象者一覧エリア内容検索
     *
     * @param param 検索パラメータ
     * @return 対象者一覧
     */
    public List<Taishouichiran> get対象者一覧(TaishouIchiranMapperParameter param) {
        ITaishouWaritsukeMapper mapper = mapperProvider.create(ITaishouWaritsukeMapper.class);
        List<TaishouIchiranEntity> list = mapper.getTaishouIchiran(param);
        List<Taishouichiran> results = new ArrayList<>();
        for (TaishouIchiranEntity taishouichiranEntity : list) {
            results.add(new Taishouichiran(taishouichiranEntity));
        }
        return results;
    }

    /**
     * 介護認定審査会対象者候補者一覧エリア内容検索
     *
     * @param param 検索パラメータ
     * @return 対象者一覧
     */
    public List<KohoshaIchiran> get候補者一覧(KohoshaIchiranMapperParameter param) {
        ITaishouWaritsukeMapper mapper = mapperProvider.create(ITaishouWaritsukeMapper.class);
        List<KohoshaIchiranEntity> list = mapper.getKohoshaIchiran(param);
        List<KohoshaIchiran> results = new ArrayList<>();
        for (KohoshaIchiranEntity entity : list) {
            results.add(new KohoshaIchiran(entity));
        }
        return results;
    }

    /**
     * get申請書情報by申請書管理番号
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報
     */
    public NinteiShinseiJoho get申請書情報by申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5101NinteiShinseiJohoDac dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        DbT5101NinteiShinseiJohoEntity entity = dac.get申請書情報by申請書管理番号(申請書管理番号);
        if (entity != null) {
            return new NinteiShinseiJoho(entity);
        } else {
            return new NinteiShinseiJoho(new DbT5101NinteiShinseiJohoEntity());
        }
    }

    /**
     * get二次判定年月日
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定申請情報
     */
    public FlexibleDate get二次判定年月日(ShinseishoKanriNo 申請書管理番号) {
        DbT5102NinteiKekkaJohoDac dbt5102Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        ShinseishoKanriNo zenkaiShinseishoKanriNo = get前回申請書管理番号(申請書管理番号);
        if (zenkaiShinseishoKanriNo != null) {
            DbT5102NinteiKekkaJohoEntity kekkaJohoEntity = dbt5102Dac.selectByKey(zenkaiShinseishoKanriNo);
            if (kekkaJohoEntity != null) {
                FlexibleDate 二次判定年月日 = kekkaJohoEntity.getNijiHanteiYMD();
                return 二次判定年月日 == null ? FlexibleDate.EMPTY : 二次判定年月日;
            }
        }
        return FlexibleDate.EMPTY;
    }

    /**
     * 介護認定審査会対象者申請者オブザーバーチェック
     *
     * @param parameter 検索パラメータ
     * @return is申請者オブザーバーチェックOK
     */
    public boolean is申請者オブザーバーチェックOK(CountShinsakaiWariateIinJohoMapperParameter parameter) {
        ITaishouWaritsukeMapper mapper = mapperProvider.create(ITaishouWaritsukeMapper.class);
        return mapper.countShinsakaiWariateIinJoho(parameter) <= 0;
    }

    /**
     * 介護認定審査会対象者審査会委員除外存在チェック
     *
     * @param param 検索パラメータ
     * @return is審査会委員除外存在チェックOK
     */
    public boolean is審査会委員除外存在チェックOK(CountShinsakaiIinJogaiJohoMapperParameter param) {
        ITaishouWaritsukeMapper mapper = mapperProvider.create(ITaishouWaritsukeMapper.class);
        return mapper.countShinsakaiIinJogaiJoho(param) <= 0;
    }

    private ShinseishoKanriNo get前回申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbT5121ShinseiRirekiJohoDac dbt5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        DbT5121ShinseiRirekiJohoEntity rirekiJohoEntity = dbt5121Dac.selectByKey(申請書管理番号);
        if (rirekiJohoEntity != null) {
            return rirekiJohoEntity.getZenkaiShinseishoKanriNo();
        }
        return null;
    }
}
