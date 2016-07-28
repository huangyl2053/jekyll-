/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinJigyoHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TmpSetaiJigyoHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.ISetaiiShotokuKazeiHanteiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 世帯所得・課税判定です。
 *
 * @reamsid_L DBC-2010-090 jiangzongyue
 */
public class SetaiShotokuKazeiHantei {

    private final MapperProvider mapperProvider;
    private static final RString メニューID_高額介護サービス = new RString("DBCMN41002");
    private static final RString メニューID_事業高額介護サービス = new RString("DBCMN41004");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 管理区分 = new RString("管理識別区分");

    /**
     * コンストラクタです。
     */
    SetaiShotokuKazeiHantei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    SetaiShotokuKazeiHantei(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SetaiShotokuKazeiHantei}のインスタンス
     */
    public static SetaiShotokuKazeiHantei createInstance() {
        return InstanceProvider.create(SetaiShotokuKazeiHantei.class);
    }

    /**
     * 世帯員把握入力高額一時の中で「住所地特例該当」が「１」のデータを取得します。
     *
     * @param 管理識別区分 {@link SetaiShotokuKazeiHanteiMybatisParameter}
     * @param メニューID RString
     */
    @Transaction
    public void getSetaiinHaaku(RString 管理識別区分, RString メニューID) {
        requireNonNull(管理識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage(管理区分.toString()));
        ISetaiiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiiShotokuKazeiHanteiMapper.class);
        if (is高額介護サービス(メニューID)) {
            mapper.insert世帯員所得情報高額一時に一括住所地特例該当が1();
            mapper.insert世帯員所得情報高額一時に一括住所地特例該当が1以外(new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分));
            List<TempSetaiinHaakuNyuryokuEntity> tempSetaiList = mapper.select世帯員所得情報高額一時に一括();
            if (!tempSetaiList.isEmpty()) {
                for (TempSetaiinHaakuNyuryokuEntity tempEntity : tempSetaiList) {
                    List<TmpSetaiHaakuNyuryokuEntity> list = get世帯員所得情報高額一時のデータ(tempEntity);
                    mapper.insert世帯員所得情報高額一時に一括(list);
                }
            }

        }

        if (is事業高額介護サービス(メニューID)) {
            mapper.insert世帯員所得情報事業高額一時に一括住所地特例該当が1();
            mapper.insert世帯員所得情報事業高額一時に一括住所地特例該当が1以外(new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分));
            List<TempSetaiinJigyoHaakuNyuryokuEntity> tempSetaiList = mapper.select世帯員所得情報事業高額一時に一括();
            if (!tempSetaiList.isEmpty()) {
                for (TempSetaiinJigyoHaakuNyuryokuEntity tempEntity : tempSetaiList) {
                    List<TmpSetaiJigyoHaakuNyuryokuEntity> list = get世帯員所得情報事業高額一時のデータ(tempEntity);
                    mapper.insert世帯員所得情報事業高額一時に一括(list);
                }
            }
        }
    }

    private List<TmpSetaiHaakuNyuryokuEntity> get世帯員所得情報高額一時のデータ(TempSetaiinHaakuNyuryokuEntity tempSetaiEntity) {
        ISetaiFinder 世帯Finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai 世帯 = 世帯Finder.findBy識別コード(GyomuCode.DB介護保険, tempSetaiEntity.getShikibetsuCode(), tempSetaiEntity.getKijunYMD());
        List<TmpSetaiHaakuNyuryokuEntity> list = new ArrayList();
        TmpSetaiHaakuNyuryokuEntity entity = new TmpSetaiHaakuNyuryokuEntity();
        IKojins 世帯員リスト = 世帯.get世帯員リスト();
        for (IKojin 世帯員 : 世帯員リスト) {
            entity.setHihokenshaNo(tempSetaiEntity.getHihokenshaNo());
            entity.setShikibetsuCode(世帯員.get識別コード());
            if (tempSetaiEntity.getShikibetsuCode().equals(世帯員.get識別コード())) {
                entity.setHonninKubun(ONE);
                entity.setHonninKazeiKubun(ONE);
            } else {
                entity.setHonninKubun(TWO);
                entity.setSetaiKazeiKubun(ONE);
                entity.setSetaiinHihokenshaNo(tempSetaiEntity.getHihokenshaNo().value());
            }
            entity.setKijunYMD(tempSetaiEntity.getKijunYMD());
            entity.setShotokuNendo(tempSetaiEntity.getShotokuNendo());
            entity.setJushochiTokureiFlag(tempSetaiEntity.getJushochiTokureiFlag());
            entity.setSetaiCode(世帯.getSetaiCode().value());
            list.add(entity);
        }
        return list;
    }

    private List<TmpSetaiJigyoHaakuNyuryokuEntity> get世帯員所得情報事業高額一時のデータ(TempSetaiinJigyoHaakuNyuryokuEntity tempSetaiEntity) {
        ISetaiFinder 世帯Finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai 世帯 = 世帯Finder.findBy識別コード(GyomuCode.DB介護保険, tempSetaiEntity.getShikibetsuCode(), tempSetaiEntity.getKijunYMD());
        List<TmpSetaiJigyoHaakuNyuryokuEntity> list = new ArrayList();
        TmpSetaiJigyoHaakuNyuryokuEntity entity = new TmpSetaiJigyoHaakuNyuryokuEntity();
        IKojins 世帯員リスト = 世帯.get世帯員リスト();
        for (IKojin 世帯員 : 世帯員リスト) {
            entity.setHihokenshaNo(tempSetaiEntity.getHihokenshaNo());
            entity.setShikibetsuCode(世帯員.get識別コード());
            if (tempSetaiEntity.getShikibetsuCode().equals(世帯員.get識別コード())) {
                entity.setHonninKubun(ONE);
                entity.setHonninKazeiKubun(ONE);
            } else {
                entity.setHonninKubun(TWO);
                entity.setSetaiKazeiKubun(ONE);
                entity.setSetaiinHihokenshaNo(tempSetaiEntity.getHihokenshaNo().value());
            }
            entity.setKijunYMD(tempSetaiEntity.getKijunYMD());
            entity.setShotokuNendo(tempSetaiEntity.getShotokuNendo());
            entity.setJushochiTokureiFlag(tempSetaiEntity.getJushochiTokureiFlag());
            entity.setSetaiCode(世帯.getSetaiCode().value());
            list.add(entity);
        }
        return list;
    }

    /**
     * 合併内住特者番号変換処理取得します。
     *
     * @param メニューID RString
     */
    @Transaction
    public void convertGappeinaiJutokushaShinKyuNo(RString メニューID) {
        ISetaiiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiiShotokuKazeiHanteiMapper.class);
        if (is高額介護サービス(メニューID)) {
            mapper.update世帯員所得情報高額一時合併内住所地特例者番号変換処理();
        }
        if (is事業高額介護サービス(メニューID)) {
            mapper.update世帯員所得情報事業高額一時合併内住所地特例者番号変換処理();
        }
    }

    /**
     * 合併内住特者番号変換処理取得します。
     *
     * @param メニューID RString
     */
    @Transaction
    public void getJuminShotokuJoho(RString メニューID) {
        ISetaiiShotokuKazeiHanteiMapper mapper = mapperProvider.create(ISetaiiShotokuKazeiHanteiMapper.class);
        if (is高額介護サービス(メニューID)) {
            mapper.update高額介護サービス場合();
            int 生保区分count = mapper.select取得した内容で世帯員所得情報高額一時に生保区分を更新();
            if (生保区分count != 0) {
                mapper.update世帯員所得情報高額一時生保区分を付加する();
            }
            int 老齢福祉区分count = mapper.select取得した内容で世帯員所得情報高額一時に老齢福祉区分を更新();
            if (老齢福祉区分count != 0) {
                mapper.update世帯員所得情報高額一時老齢福祉区分を更新する();
            }
        }
        if (is事業高額介護サービス(メニューID)) {
            mapper.update事業高額介護サービス場合();
            int 事業生保区分count = mapper.select取得した内容で世帯員所得情報事業高額一時に生保区分を更新();
            if (事業生保区分count != 0) {
                mapper.update世帯員所得情報事業高額一時生保区分を付加する();
            }
            int 事業老齢福祉区分count = mapper.select取得した内容で世帯員所得情報事業高額一時に老齢福祉区分を更新();
            if (事業老齢福祉区分count != 0) {
                mapper.update世帯員所得情報事業高額一時老齢福祉区分を更新する();
            }
        }
    }

    private boolean is高額介護サービス(RString メニューID) {
        return メニューID_高額介護サービス.equals(メニューID);
    }

    private boolean is事業高額介護サービス(RString メニューID) {
        return メニューID_事業高額介護サービス.equals(メニューID);
    }
}
