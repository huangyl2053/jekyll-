/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.shikakutokuso;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.ShikakuTokuso;
import jp.co.ndensan.reams.db.dba.definition.shikakutokuso.ShikakuTokusoInputGuideParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.ServiceShikakuJohoRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.IDbT1001ShikakuTokusoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 資格一覧データ取得クラスです。
 */
public class ShikakuTokusoFinder {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;

    public ShikakuTokusoFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    public static ShikakuTokusoFinder createInstance() {
        return InstanceProvider.create(ShikakuTokusoFinder.class);
    }

    /**
     * 一覧データ取得リストを取得する
     *
     * @param params ShikakuTokusoInputGuideParameter
     * @return List<ServiceJigyoshaInputGuideRelateEntity> 一覧データ取得取得リスト
     */
    public List<ShikakuTokuso> getShikakuTokuso(ShikakuTokusoInputGuideParameter params) {
        IDbT1001ShikakuTokusoMapper ShikakuTokusoMapper = this.mapperProvider.create(IDbT1001ShikakuTokusoMapper.class);
        List<ServiceShikakuJohoRelateEntity> 一覧データ取得リスト = ShikakuTokusoMapper.getShikakuJoho(params);

        //get画面一覧データ取得リスト(一覧データ取得リスト);
        if (一覧データ取得リスト == null || 一覧データ取得リスト.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShikakuTokuso> hihokensyataichoList = new ArrayList<>();
        for (ServiceShikakuJohoRelateEntity entity : 一覧データ取得リスト) {

            hihokensyataichoList.add(new ShikakuTokuso(entity));
        }
        return hihokensyataichoList;
    }

    /**
     * コードマスタから取得事由ドロップダウンリストに表示する用のデータを取得する
     *
     * @param 住所地特例適用事由コード@return List<KaigoKanriCode>コード種別　=　'0117'取得取得リスト
     */
    public List<DbT1001HihokenshaDaichoEntity> getShutokuJiyuDDL(KaigoShikakuJutokuTekiyoJiyu 住所地特例適用事由コード) {
        List<DbT1001HihokenshaDaichoEntity> entity = dbT1001Dac.selectByShutokuJiyuDDL(住所地特例適用事由コード);
        if (entity.isEmpty()) {
            return new ArrayList<>();
        }
        return entity;
    }

    /**
     * コードマスタから喪失事由ドロップダウンリストに表示する用のデータを取得する
     *
     * @param 住所地特例解除事由コード
     * @return List<KaigoKanriCode>コード種別　=　'0121'取得取得リスト
     */
    public List<DbT1001HihokenshaDaichoEntity> getSoshitsuJiyuDDL(KaigoShikakuJutokuKaijoJiyu 住所地特例解除事由コード) {
        List<DbT1001HihokenshaDaichoEntity> entity = dbT1001Dac.selectBySoshitsuJiyuDDL(住所地特例解除事由コード);
        if (entity.isEmpty()) {
            return new ArrayList<>();
        }

        return entity;
    }

    private List<ServiceShikakuJohoRelateEntity> get画面一覧データ取得リスト(List<ServiceShikakuJohoRelateEntity> 一覧データ取得リスト) {

        List<ServiceShikakuJohoRelateEntity> 取得日リスト = new ArrayList();
        FlexibleDate shikakuShutokuYMDFlag = FlexibleDate.EMPTY;

        for (int i = 0; i <= 一覧データ取得リスト.size(); i++) {
            if (!shikakuShutokuYMDFlag.equals(一覧データ取得リスト.get(i).getShikakuShutokuYMD())) {

                取得日リスト.add(一覧データ取得リスト.get(i));
                shikakuShutokuYMDFlag = 一覧データ取得リスト.get(i).getShikakuShutokuYMD();
            }
        }
        return 取得日リスト;
    }
}
