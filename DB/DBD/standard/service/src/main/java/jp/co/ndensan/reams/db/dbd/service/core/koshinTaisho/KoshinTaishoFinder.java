/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.koshinTaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.koshinTaisho.KoshinTaishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.koshinTaisho.SelectSyuuShadeTaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshintaisho.IKoshinTaishoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のビジネスを生成します。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KoshinTaishoFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 画面設計_DBD5010001_完了処理・更新管理のビジネスを生成します。
     *
     * @return 画面設計_DBD5010001_完了処理・更新管理のビジネス
     */
    public static KoshinTaishoFinder createInstance() {
        return InstanceProvider.create(KoshinTaishoFinder.class);
    }

    /**
     * 調査データ（モバイル用）の抽出します。
     *
     * @param 申請書管理番号 RString
     *
     * @return List<selectSyuuShadeTaEntity>
     */
    @Transaction
    public List<SelectSyuuShadeTaEntity> get調査データの取得(RString 申請書管理番号) {

        KoshinTaishoMybatisParameter parameter = new KoshinTaishoMybatisParameter(申請書管理番号);
        IKoshinTaishoMapper mapper = mapperProvider.create(IKoshinTaishoMapper.class);
        return mapper.get調査データの取得(parameter);
    }

    /**
     * 認定調査依頼情報の取得
     *
     * @param shinseishoKanriNo RString
     * @return DbT4201NinteichosaIraiJohoEntity
     */
    public DbT4201NinteichosaIraiJohoEntity get認定調査依頼情報の取得(RString shinseishoKanriNo) {
        IKoshinTaishoMapper mapper = mapperProvider.create(IKoshinTaishoMapper.class);
        return mapper.get認定調査依頼情報の取得(shinseishoKanriNo);
    }

    /**
     * 要介護認定申請情報の取得する
     *
     * @param shinseishoKanriNo RString
     * @return DbT4101NinteiShinseiJohoEntity
     */
    public List<DbT4101NinteiShinseiJohoEntity> get要介護認定申請情報の取得(RString shinseishoKanriNo) {
        IKoshinTaishoMapper mapper = mapperProvider.create(IKoshinTaishoMapper.class);
        return mapper.get要介護認定申請情報の取得(shinseishoKanriNo);
    }

}
