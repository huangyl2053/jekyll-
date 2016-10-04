/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hihokenshashikakuteisei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshashikakuteisei.SukejuruRirekiJohoListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.basic.IDbT3104KokuhorenInterfaceKanriMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * HihokenshaShikakuTeisei_国保連連携スケジュール設定のクラスです
 *
 * @reamsid_L DBC-2930-030 liuxiaoyu
 */
public class HihokenshaShikakuTeisei {

    private final DbT3104KokuhorenInterfaceKanriDac dbT3104Dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public HihokenshaShikakuTeisei() {
        this.dbT3104Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link  HihokenshaShikakuTeisei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link  HihokenshaShikakuTeisei}のインスタンス
     */
    public static HihokenshaShikakuTeisei createInstance() {
        return InstanceProvider.create(HihokenshaShikakuTeisei.class);
    }

    /**
     * 国保連連携スケジュール設定のスケジュール履歴情報初期取得ンメソッドです。
     *
     *
     * @return スケジュール履歴情報初期 SukejuruRirekiJohoListEntity
     */
    public SukejuruRirekiJohoListEntity getSukejuruRirekiShokiJoho() {
        IDbT3104KokuhorenInterfaceKanriMapper mapper = mapperProvider.create(IDbT3104KokuhorenInterfaceKanriMapper.class);
        SukejuruRirekiJohoListEntity entity = new SukejuruRirekiJohoListEntity();
        List<DbT3104KokuhorenInterfaceKanriEntity> 送付List = mapper.getスケジュール履歴情報初期_送付();
        List<DbT3104KokuhorenInterfaceKanriEntity> 取込List = mapper.getスケジュール履歴情報初期_取込();
        entity.setスケジュール履歴情報_送付List(changeList(送付List));
        entity.setスケジュール履歴情報_取込List(changeList(取込List));
        return entity;
    }

    /**
     * 国保連連携スケジュール設定のスケジュール履歴情報取得ンメソッドです。
     *
     * @param 処理年月 FlexibleYearMonth
     *
     * @return スケジュール履歴情報 SukejuruRirekiJohoListEntity
     */
    public SukejuruRirekiJohoListEntity getSukejuruRirekiJoho(FlexibleYearMonth 処理年月) {
        SukejuruRirekiJohoListEntity entity = new SukejuruRirekiJohoListEntity();
        List<DbT3104KokuhorenInterfaceKanriEntity> 送付List = dbT3104Dac.getスケジュール履歴情報_送付(処理年月);
        List<DbT3104KokuhorenInterfaceKanriEntity> 取込List = dbT3104Dac.getスケジュール履歴情報_取込(処理年月);
        entity.setスケジュール履歴情報_送付List(changeList(送付List));
        entity.setスケジュール履歴情報_取込List(changeList(取込List));
        return entity;
    }

    private List<KokuhorenInterfaceKanri> changeList(List<DbT3104KokuhorenInterfaceKanriEntity> inputList) {
        List<KokuhorenInterfaceKanri> outputList = new ArrayList<>();
        if (inputList == null) {
            return outputList;
        } else {
            KokuhorenInterfaceKanri kokuhorenInterfaceKanri;
            for (DbT3104KokuhorenInterfaceKanriEntity entity : inputList) {
                kokuhorenInterfaceKanri = new KokuhorenInterfaceKanri(entity);
                outputList.add(kokuhorenInterfaceKanri);
            }
            return outputList;
        }
    }
}
